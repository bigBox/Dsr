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
public class AliPay extends BaseEntity implements Comparable<AliPay> {
	private static final long serialVersionUID = -138621416927726478L;

	public AliPay(long roleID) {
		super(roleID);
	}
	//用户的支付宝账号
	private String alipayId;
	//商户订单号
	private String outTradeNo;
	//支付宝交易号
	private String tradeNo;
	//交易状态
	private String tradeStatus;
	//物品id
	private Integer itemId;
	//物品数量
	private Integer count;
	//物品单价
	private BigDecimal price;
	//交易金额
	private BigDecimal amount;
	// 是否成功
	private Boolean success;
	// 是否已经交付物品
	private Boolean deliver;
	// 时间戳
	private Long timeStamp;

	@Override
	public IEntity copy() {
		AliPay item = new AliPay();
		copySuper(item);
		item.setAlipayId(alipayId);
		item.setOutTradeNo(outTradeNo);
		item.setTradeNo(tradeNo);
		item.setItemId(itemId);
		item.setCount(count);
		item.setPrice(price);
		item.setAmount(amount);
		item.setSuccess(success);
		item.setDeliver(deliver);
		item.setTimeStamp(timeStamp);
		return item;
	}
	
	@Override
	public int compareTo(AliPay verify) {
		return Long.valueOf(this.id - verify.getId()).intValue();
	}

}