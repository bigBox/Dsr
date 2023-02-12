package com.dj.serverplayer.handler;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeAppPayModel;
import com.alipay.api.domain.GoodsDetail;
import com.alipay.api.request.AlipayTradeAppPayRequest;
import com.alipay.api.response.AlipayTradeAppPayResponse;
import com.dj.domain.config.ConfigVirtualItems;
import com.dj.domain.entity.player.AliPay;
import com.dj.domain.entity.player.PlayerAccount;
import com.dj.domain.entity.player.WxPay;
import com.dj.domain.util.lib.QueryParamMap;
import com.dj.domain.util.math.RandomUtil;
import com.dj.protobuf.CommonException;
import com.dj.protobuf.ErrorIDOuterClass;
import com.dj.protobuf.ErrorIDOuterClass.ErrorID;
import com.dj.protobuf.alipay.AliPayPreReq;
import com.dj.protobuf.alipay.AliPayPreRsp;
import com.dj.protobuf.alipay.AliPayQueryReq;
import com.dj.protobuf.alipay.AliPayQueryRsp;
import com.dj.servercore.conf.ConfigVirtualItemsConf;
import com.dj.servercore.conf.base.ConfProvider;
import com.dj.servercore.conf.base.IConfProvider;
import com.dj.serverplayer.config.AliPayConfig;
import com.dj.serverplayer.handler.base.BaseHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 仲崇全
 * @description 微信支付
 * @date 2019年4月3日
 */
@Slf4j
@Component
public class AliPayHandler extends BaseHandler {

    public void aliPayPre(long roleID, AliPayPreReq req, AliPayPreRsp.Builder builder) {
        double originalAmount = req.getAmount() / 100.0;
        BigDecimal amount = new BigDecimal(originalAmount);
        amount = amount.setScale(2, BigDecimal.ROUND_HALF_UP);

        PlayerAccount playerAccount = playerAccountDao.cacheLoad("account", req.getAccount(), roleID);
        if(playerAccount == null){
            log.error("aliPayPre playerAccount == null");
            throw new CommonException(ErrorID.SYSTEM_REQUEST_ERROR);
        }
        if(playerAccount.getAge() < 8){
            throw new CommonException(ErrorID.PAY_AMOUNT_OUT_AGE);
        }
        BigDecimal totalAmount = new BigDecimal(0);
        totalAmount = totalAmount.add(amount);
        if(playerAccount.getAge() < 16){
            if(req.getAmount() > 5000){
                throw new CommonException(ErrorID.PAY_AMOUNT_OUT_AGE);
            }
            List<AliPay> aliPayList = aliPayDao.readDbData(roleID);
            for(AliPay pay : aliPayList){
                totalAmount = totalAmount.add(pay.getAmount());
            }
            List<WxPay> wxPayList = wxPayDao.readDbData(roleID);
            for(WxPay pay : wxPayList){
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

        //app_id 	String 	是 	32 	支付宝分配给开发者的应用ID 	2014072300007148
        //method 	String 	是 	128 	接口名称 	alipay.trade.app.pay
        //format 	String 	否 	40 	仅支持JSON 	JSON
        //charset 	String 	是 	10 	请求使用的编码格式，如utf-8,gbk,gb2312等 	utf-8
        //sign_type 	String 	是 	10 	商户生成签名字符串所使用的签名算法类型，目前支持RSA2和RSA，推荐使用RSA2 	RSA2
        //sign 	String 	是 	256 	商户请求参数的签名串，详见签名 	详见示例
        //timestamp 	String 	是 	19 	发送请求的时间，格式"yyyy-MM-dd HH:mm:ss" 	2014-07-24 03:07:50
        //version 	String 	是 	3 	调用的接口版本，固定为：1.0 	1.0
        //notify_url 	String 	是 	256 	支付宝服务器主动通知商户服务器里指定的页面http/https路径。建议商户使用https 	https://api.xx.com/receive_notify.htm
        //biz_content 	String 	是 	- 	业务请求参数的集合，最大长度不限，除公共参数外所有请求参数都必须放在这个参数中传递，具体参照各产品快速接入文档
        long timeStamp = System.currentTimeMillis();
        String outTradeNo = timeStamp +""+ RandomUtil.nextInt(1000,9999);

        //实例化客户端
        AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipay.com/gateway.do", AliPayConfig.appId,
                AliPayConfig.appPrivateKey, AliPayConfig.format, AliPayConfig.charset, AliPayConfig.appPublicKey, AliPayConfig.signType);
        //实例化具体API对应的request类,类名称和接口名称对应,当前调用接口名称：alipay.trade.app.pay
        AlipayTradeAppPayRequest request = new AlipayTradeAppPayRequest();
        //SDK已经封装掉了公共参数，这里只需要传入业务参数。以下方法为sdk的model入参方式(model和biz_content同时存在的情况下取biz_content)。
        //body 	String 	否 	128 	对一笔交易的具体描述信息。如果是多种商品，请将商品描述字符串累加传给body。 	Iphone6 16G
        //subject 	String 	是 	256 	商品的标题/交易标题/订单标题/订单关键字等。 	大乐透
        //out_trade_no 	String 	是 	64 	商户网站唯一订单号 	70501111111S001111119
        //timeout_express 	String 	否 	6 	该笔订单允许的最晚付款时间，逾期将关闭交易。取值范围：1m～15d。m-分钟，h-小时，d-天，1c-当天（1c-当天的情况下，无论交易何时创建，都在0点关闭）。 该参数数值不接受小数点， 如 1.5h，可转换为 90m。注：若为空，则默认为15d。 	90m
        //total_amount 	String 	是 	9 	订单总金额，单位为元，精确到小数点后两位，取值范围[0.01,100000000] 	9.00
        //product_code 	String 	是 	64 	销售产品码，商家和支付宝签约的产品码，为固定值QUICK_MSECURITY_PAY 	QUICK_MSECURITY_PAY
        //goods_type 	String 	否 	2 	商品主类型：0—虚拟类商品，1—实物类商品注：虚拟类商品不支持使用花呗渠道 	0
        //passback_params 	String 	否 	512 	公用回传参数，如果请求时传递了该参数，则返回给商户时会回传该参数。支付宝会在异步通知时将该参数原样返回。本参数必须进行UrlEncode之后才可以发送给支付宝 	merchantBizType%3d3C%26merchantBizNo%3d2016010101111
        //promo_params 	String 	否 	512 	优惠参数注：仅与支付宝协商后可用 	{"storeIdType":"1"}
        //extend_params 	String 	否 	- 	业务扩展参数，详见下面的“业务扩展参数说明” 	{"sys_service_provider_id":"2088511833207846"}
        //enable_pay_channels 	String 	否 	128 	可用渠道，用户只能在指定渠道范围内支付当有多个渠道时用“,”分隔注：与disable_pay_channels互斥 	pcredit,moneyFund,debitCardExpress
        //disable_pay_channels 	String 	否 	128 	禁用渠道，用户不可用指定渠道支付当有多个渠道时用“,”分隔注：与enable_pay_channels互斥 	pcredit,moneyFund,debitCardExpress
        //store_id 	String 	否 	32 	商户门店编号。该参数用于请求参数中以区分各门店，非必传项。 	NJ_001
        //ext_user_info 	ExtUserInfo 	否 	- 	外部指定买家，详见外部用户ExtUserInfo参数说明
        ConfigVirtualItemsConf conf = ConfProvider.getConfigConfProvider().getConfigConf(IConfProvider.CONFIG_VIRTUAL_ITEMS);
        if(conf == null){
            throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
        }
        ConfigVirtualItems virtualItems = conf.getVirtualItem(req.getItemID());
        //double originalPrice = virtualItems.getPrice() / 100.00;
        //BigDecimal price = new BigDecimal(originalPrice);
        //price = price.setScale(2, BigDecimal.ROUND_HALF_UP);
        AlipayTradeAppPayModel model      = new AlipayTradeAppPayModel();
        model.setBody("寻宝吧-购买 "+virtualItems.getName());
        model.setSubject("寻宝吧");//商品名称    不可空
        model.setOutTradeNo(outTradeNo);
        model.setTimeoutExpress("30m");
        model.setProductCode("QUICK_MSECURITY_PAY");
        model.setTotalAmount(amount.toString());
        model.setGoodsType("0");
        model.setPassbackParams(req.getRoleID()+"");
        List<GoodsDetail> goodsDetails = new ArrayList<>();
        GoodsDetail goodsDetail = new GoodsDetail();
        goodsDetail.setGoodsId(virtualItems.getID()+"");
        goodsDetail.setGoodsName(virtualItems.getName());
        goodsDetail.setPrice(amount.toString());
        goodsDetail.setBody("");
        goodsDetail.setGoodsCategory("");
        goodsDetails.add(goodsDetail);
        model.setGoodsDetail(goodsDetails);
        model.setStoreId("1");//服务器id

        request.setBizModel(model);
        request.setNotifyUrl(AliPayConfig.notifyUrl);
        try {
            //这里和普通的接口调用不同，使用的是sdkExecute
            AlipayTradeAppPayResponse response = alipayClient.sdkExecute(request);
            System.out.println(response.getBody());//就是orderString 可以直接给客户端请求，无需再做处理。
            builder.setOrderString(response.getBody());
            builder.setOutTradeNo(outTradeNo);
            builder.setTimeStamp(timeStamp+"");
            AliPay aliPay = new AliPay();
            aliPay.setRoleID(roleID);
            aliPay.setItemId(req.getItemID());
            aliPay.setCount(req.getCount());
            aliPay.setPrice(amount);
            aliPay.setAmount(amount);
            aliPay.setOutTradeNo(outTradeNo);
            aliPay.setSuccess(false);
            aliPay.setDeliver(false);
            aliPay.setTimeStamp(System.currentTimeMillis());
            aliPayDao.cacheInsert(aliPay, roleID);
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
    }

    public void aliPayQuery(long roleID, AliPayQueryReq req, AliPayQueryRsp.Builder builder) {
        QueryParamMap queryParams = new QueryParamMap();
        queryParams.put("roleID",roleID);
        queryParams.put("tradeNo",req.getTradeNo());
        AliPay aliPay = aliPayDao.cacheSelect(queryParams, roleID);
        if(ObjectUtils.isNotEmpty(aliPay)){
            if((aliPay.getSuccess())&&(aliPay.getDeliver())){
                builder.setItemID(aliPay.getItemId());
                builder.setCount(aliPay.getCount());
            }
        }
    }
}
