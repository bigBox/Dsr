package com.dj.domain.entity.global;

import com.dj.domain.base.IEntity;
import com.dj.domain.util.DateUtil;
import com.dj.protobuf.trade.TradeRecordInfo;
import com.dj.protobuf.trade.TradeType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.jetbrains.annotations.NotNull;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
public class GlobalTradeRecord implements Comparable<GlobalTradeRecord> , IEntity {
	private static final long serialVersionUID = 5894798526686585815L;
	// 交易流水号
	private long id;
	// 买方ID
	private long buyRoleID;
	// 卖方ID
	private long sellRoleID;
	// 交易订单ID
	private long orderID;
	// 交易订单的数量
	private long orderNum;
	// 交易类型
	private int  type;
	//物品ID
	private int itemID;
	//物品数量
	private long itemNum;
	// 单品价格
	private long price;
	// 成交总价格
	private long amount;
	//记录创建时间
	private   Date createTime;
	//记录更新时间
	private   Date updateTime;

	public GlobalTradeRecord() {
		setCreateTime(DateUtil.getCurrentDate());
		setUpdateTime(DateUtil.getCurrentDate());
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
		GlobalTradeRecord item = new GlobalTradeRecord();
		item.setId(id);
		item.setBuyRoleID(buyRoleID);
		item.setSellRoleID(sellRoleID);
		item.setType(type);
		item.setOrderID(orderID);
		item.setOrderNum(orderNum);
		item.setItemID(itemID);
		item.setItemNum(itemNum);
		item.setPrice(price);
		item.setAmount(amount);
		item.setCreateTime(createTime);
		item.setUpdateTime(DateUtil.getCurrentDate());
		return item;
	}

	public TradeRecordInfo toTradeRecordInfo(TradeRecordInfo.Builder builder, int lastPrice) {
		builder.setId(id);
		builder.setBuyRoleID(buyRoleID);
		builder.setSellRoleID(sellRoleID);
		builder.setType(TradeType.forNumber(type));
		builder.setOrderID(orderID);
		builder.setOrderNum(orderNum);
		builder.setItemID(itemID);
		builder.setItemNum(itemNum);
		builder.setPrice(price);
		builder.setAmount(amount);
		return builder.build();
	}

	@Override
	public int compareTo(@NotNull GlobalTradeRecord o) {
		if(this.getCreateTime().getTime() > o.getCreateTime().getTime()) {
			return 1;
		}
		else if(this.getCreateTime().getTime() < o.getCreateTime().getTime()) {
			return -1;
		}
		return 0;
	}
}