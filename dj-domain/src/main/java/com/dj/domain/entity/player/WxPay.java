package com.dj.domain.entity.player;

import com.dj.domain.base.BaseEntity;
import com.dj.domain.base.IEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class WxPay extends BaseEntity implements Comparable<WxPay> {
    private static final long serialVersionUID = -138621416927726478L;

    public WxPay(long roleID) {
        super(roleID);
    }

    //预付单号
    private String     prepayId;
    // 商户号
    private String     partnerId;
    //商户订单号
    private String     outTradeNo;
    //微信订单号
    private String     tradeNo;
    //物品id
    private Integer    itemId;
    //物品数量
    private Integer    count;
    //单价
    private BigDecimal price;
    //交易金额
    private BigDecimal amount;
    // 扩展字段
    private String     packageValue;
    // 随机字符串
    private String     nonceStr;
    // 签名
    private String     sign;
    // 是否支付成功
    private Boolean    success;
    // 是否已经交付物品
    private Boolean    deliver;
    // 时间戳
    private Long timeStamp;

    @Override
    public IEntity copy() {
        WxPay item = new WxPay();
        copySuper(item);
        item.setPrepayId(prepayId);
        item.setPartnerId(partnerId);
        item.setOutTradeNo(outTradeNo);
        item.setTradeNo(tradeNo);
        item.setItemId(itemId);
        item.setCount(count);
        item.setAmount(amount);
        item.setPackageValue(packageValue);
        item.setNonceStr(nonceStr);
        item.setSign(sign);
        item.setSuccess(success);
        item.setDeliver(deliver);
        item.setTimeStamp(timeStamp);
        return item;
    }

    @Override
    public int compareTo(WxPay verify) {
        return Long.valueOf(this.id - verify.getId()).intValue();
    }

}