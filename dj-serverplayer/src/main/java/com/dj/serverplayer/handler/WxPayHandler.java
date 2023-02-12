package com.dj.serverplayer.handler;

import com.dj.domain.entity.player.AliPay;
import com.dj.domain.entity.player.PlayerAccount;
import com.dj.domain.entity.player.WxPay;
import com.dj.domain.util.codec.Md5Utils;
import com.dj.domain.util.lib.QueryParamMap;
import com.dj.domain.util.math.RandomUtil;
import com.dj.protobuf.CommonException;
import com.dj.protobuf.ErrorIDOuterClass;
import com.dj.protobuf.ErrorIDOuterClass.ErrorID;
import com.dj.protobuf.wxpay.WxPayQueryReq;
import com.dj.protobuf.wxpay.WxPayQueryRsp;
import com.dj.protobuf.wxpay.WxPrePayReq;
import com.dj.protobuf.wxpay.WxPrePayRsp;
import com.dj.servercore.conf.ConfigVirtualItemsConf;
import com.dj.servercore.conf.base.ConfProvider;
import com.dj.servercore.conf.base.IConfProvider;
import com.dj.serverplayer.handler.base.BaseHandler;
import com.github.wxpay.sdk.WXPay;
import com.github.wxpay.sdk.WXPayConfigImpl;
import com.github.wxpay.sdk.WXPayConstants;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author 仲崇全
 * @description 微信支付
 * @date 2019年4月3日
 */
@Slf4j
@Component
public class WxPayHandler extends BaseHandler {

    public void wxPrePay(long roleID, WxPrePayReq req, WxPrePayRsp.Builder builder) {
        double     originalAmount = req.getAmount() / 100.0;
        BigDecimal amount         = new BigDecimal(originalAmount);
        amount = amount.setScale(2, BigDecimal.ROUND_HALF_UP);

        BigDecimal totalAmount = new BigDecimal(0);
        totalAmount = totalAmount.add(amount);
        PlayerAccount playerAccount = playerAccountDao.cacheLoad("account", req.getAccount(), roleID);
        if(playerAccount == null){
            throw new CommonException(ErrorID.SYSTEM_REQUEST_ERROR);
        }
        if(playerAccount.getAge() < 8){
            throw new CommonException(ErrorID.PAY_AMOUNT_OUT_AGE);
        }
        if(playerAccount.getAge() < 16){
            if(req.getAmount() > 5000){
                throw new CommonException(ErrorID.PAY_AMOUNT_OUT_AGE);
            }
            List<WxPay> wxPayList = wxPayDao.readDbData(roleID);
            for(WxPay pay : wxPayList){
                totalAmount = totalAmount.add(pay.getAmount());
            }
            List<AliPay> aliPayList = aliPayDao.readDbData(roleID);
            for(AliPay pay : aliPayList){
                totalAmount = totalAmount.add(pay.getAmount());
            }
            if(req.getAmount() > 20000){
                throw new CommonException(ErrorID.PAY_AMOUNT_OUT_AGE);
            }
        }
        if(playerAccount.getAge() < 18){
            if(req.getAmount() > 10000){
                throw new CommonException(ErrorID.PAY_AMOUNT_OUT_AGE);
            }
            List<WxPay> wxPayList = wxPayDao.readDbData(roleID);
            for(WxPay pay : wxPayList){
                totalAmount = totalAmount.add(pay.getAmount());
            }
            List<AliPay> aliPayList = aliPayDao.readDbData(roleID);
            for(AliPay pay : aliPayList){
                totalAmount = totalAmount.add(pay.getAmount());
            }
            if(req.getAmount() > 40000){
                throw new CommonException(ErrorID.PAY_AMOUNT_OUT_AGE);
            }
        }
        long timeStamp = System.currentTimeMillis();
        String out_trade_no = timeStamp +""+ RandomUtil.nextInt(1000,9999);
        // 随机字符串
        String nonce_str = Md5Utils.md5To32(System.currentTimeMillis() + RandomUtil.nextInt(4)+"");
        Map<String, String>    retMap        = weixin_pay(out_trade_no,req.getItemID(), req.getAmount(), nonce_str);

        String return_code = retMap.get("return_code");
        if("SUCCESS".equalsIgnoreCase(return_code)){
            String prepay_id = retMap.get("prepay_id");
            String partner_id = "1609793554";
            try {
                WXPayConfigImpl config = WXPayConfigImpl.getInstance();
                partner_id = config.getMchID();
            } catch (Exception e) {
                //e.printStackTrace();
                log.error(e.toString());
            }
            ConfigVirtualItemsConf conf = ConfProvider.getConfigConfProvider().getConfigConf(IConfProvider.CONFIG_VIRTUAL_ITEMS);
            if(conf == null){
                throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
            }
            //ConfigVirtualItems     virtualItems  = conf.getVirtualItem(req.getItemID());
            //double                 originalPrice = new Double(virtualItems.getPrice()/100.00);
            //BigDecimal price = new BigDecimal(originalPrice);
            //price = price.setScale(2, BigDecimal.ROUND_HALF_UP);

            String sign = retMap.get("sign");
            WxPay wxPay = new WxPay();
            wxPay.setRoleID(roleID);
            wxPay.setPrepayId(prepay_id);
            wxPay.setPartnerId(partner_id);
            wxPay.setOutTradeNo(out_trade_no);
            wxPay.setItemId(req.getItemID());
            wxPay.setCount(req.getCount());
            wxPay.setPrice(amount);
            wxPay.setAmount(amount);
            wxPay.setPackageValue("Sign=WXPay");
            wxPay.setNonceStr(nonce_str);
            wxPay.setSign(sign);
            wxPay.setSuccess(false);
            wxPay.setDeliver(false);
            wxPay.setTradeNo("");
            wxPay.setTimeStamp(timeStamp);
            wxPayDao.cacheInsert(wxPay,roleID);

            builder.setPrepayId(wxPay.getPrepayId());
            builder.setNonceStr(wxPay.getNonceStr());
            builder.setPartnerId(wxPay.getPartnerId());
            builder.setPackageValue(wxPay.getPackageValue());
            builder.setTimeStamp(wxPay.getTimeStamp()+"");
            builder.setSign(sign);
        }
    }

    public void wxPayQuery(long roleID, WxPayQueryReq req, WxPayQueryRsp.Builder builder) {
        QueryParamMap queryParams = new QueryParamMap();
        queryParams.put("roleID",roleID);
        queryParams.put("prepayId",req.getTradeNo());
        WxPay wxPay = wxPayDao.cacheSelect(queryParams, roleID);
        if(ObjectUtils.isNotEmpty(wxPay)){
            if((wxPay.getSuccess())&&(wxPay.getDeliver())){
                builder.setItemID(wxPay.getItemId());
                builder.setCount(wxPay.getCount());
            }
        }
    }

    /**
     *
     *
     * @param out_trade_no 预交易号
     */
    public static Map<String, String> weixin_pay(String out_trade_no,int itemId,int total_fee,String nonce_str)  {
        try {
            // 价格 注意：价格的单位是分
            //String total_fee = "201";
            // 商品名称
            String body = "寻宝吧-钻石";

            // 获取发起电脑 ip
            String spbill_create_ip = "39.107.96.120";
            // 回调接口
            String notify_url = WXPayConstants.notify_url;
            String product_id = itemId + "";
            String trade_type = "APP";//JSAPI--公众号支付、NATIVE--原生扫码支付、APP--app支付
            String time_start = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
            Calendar ca = Calendar.getInstance();
            ca.setTime(new Date());
            ca.add(Calendar.DATE, 1);
            String time_expire = new SimpleDateFormat("yyyyMMddHHmmss").format(ca.getTime());
            HashMap<String, String> data = new HashMap<>();
            data.put("body", body);
            data.put("out_trade_no", out_trade_no);
            data.put("device_info", "");
            data.put("fee_type", "CNY");
            data.put("total_fee", total_fee+"");
            data.put("spbill_create_ip", spbill_create_ip);
            data.put("notify_url", notify_url);
            data.put("trade_type", trade_type);
            data.put("product_id", product_id);
            data.put("time_start", time_start);
            data.put("time_expire", time_expire);
            data.put("nonce_str",nonce_str);
            try {
                WXPayConfigImpl config = WXPayConfigImpl.getInstance();
                WXPay wxpay = new WXPay(config);
                Map<String, String> retMap = wxpay.unifiedOrder(data);
                System.out.println(retMap);
                return retMap;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
