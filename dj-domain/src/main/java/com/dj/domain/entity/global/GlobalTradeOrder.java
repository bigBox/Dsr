package com.dj.domain.entity.global;

import com.dj.domain.base.IEntity;
import com.dj.domain.util.DateUtil;
import com.dj.protobuf.trade.TradeOrderInfo;
import com.dj.protobuf.trade.TradeType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
public class GlobalTradeOrder implements Comparable<GlobalTradeOrder> , IEntity {
	private static final long serialVersionUID = 5371734526686585814L;
	// ID
	private long id;
	// 订单发起者
	private long roleID;
	// 交易流水号
	private long orderID;
	// 挂单数量
	private long orderNum;
	// 交易类型
	private int  type;
	// 物品ID
	private int itemID;
	// 物品数量
	private long itemNum;
	// 单品价格
	private long price;
	// 挂单总价格
	private long amount;
	// 已经完成的交易物品数量
	private long tradeNum;
	//记录创建时间
	private Date createTime;
	//记录更新时间
	private Date updateTime;
	// 交易挂单是否结束
	private int isDelete;

	public GlobalTradeOrder() {
		setTradeNum(0);
		setCreateTime(DateUtil.getCurrentDate());
		setUpdateTime(DateUtil.getCurrentDate());
		setIsDelete(0);
	}

	@Override
	public String getPrimaryKeyName() {
		return "id";
	}

	@Override
	public Object getPrimaryKeyValue() {
		return id;
	}

	@Override
	public IEntity copy() {
		GlobalTradeOrder item = new GlobalTradeOrder();
		item.setId(id);
		item.setRoleID(roleID);
		item.setType(type);
		item.setOrderID(orderID);
		item.setOrderNum(orderNum);
		item.setTradeNum(tradeNum);
		item.setItemID(itemID);
		item.setItemNum(itemNum);
		item.setPrice(price);
		item.setAmount(amount);
		item.setCreateTime(createTime);
		item.setUpdateTime(DateUtil.getCurrentDate());
		item.setIsDelete(isDelete);
		return item;
	}

	public TradeOrderInfo toTradeOrderInfo(TradeOrderInfo.Builder builder) {
		builder.setRoleID(roleID);
		builder.setType(TradeType.forNumber(type));
		builder.setOrderID(orderID);
		builder.setOrderNum(orderNum);
		builder.setTradeNum(tradeNum);
		builder.setItemNum(itemNum);
		builder.setItemID(itemID);
		builder.setItemNum(itemNum);
		builder.setPrice(price);
		builder.setAmount(amount);
		return builder.build();
	}

	@Override
	public int compareTo(@NotNull GlobalTradeOrder o) {
		if (this.getType() == TradeType.Sell.getNumber()) {//卖，价格正序，取价格小的
			if(o.getPrice() > this.getPrice()) {
				return -1;
			}
			else if(o.getPrice() < this.getPrice()) {
				return 1;
			}
		} else if(this.getType() == TradeType.Buy.getNumber()) {//买，价格倒序，取价格大的
			if(o.getPrice() > this.getPrice()) {
				return 1;
			}
			else if(o.getPrice() < this.getPrice()) {
				return -1;
			}
		}
		if(o.getCreateTime().getTime() < this.getCreateTime().getTime()) {
			return 1;
		}
		else if(o.getCreateTime().getTime() > this.getCreateTime().getTime()) {
			return -1;
		}
		return 0;
	}
}