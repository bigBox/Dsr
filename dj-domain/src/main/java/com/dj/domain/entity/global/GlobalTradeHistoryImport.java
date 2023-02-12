package com.dj.domain.entity.global;

import com.dj.domain.base.IEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
public class GlobalTradeHistoryImport implements Comparable<GlobalTradeHistoryImport> , IEntity{
	private static final long serialVersionUID = 7421733184508788578L;

	private long id;
	//物品ID
	private int itemID;
	//交易日期
	private Date date;
	//当日开盘价
	private long startPrice;
	//当日收盘价
	private long endPrice;
	//当日最高价
	private long highestPrice;
	//当日最低价
	private long lowestPrice;
	//成交量
	private long turnover;
	//记录创建时间

	public GlobalTradeHistoryImport() {
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
		GlobalTradeHistoryImport item = new GlobalTradeHistoryImport();
		item.setId(id);
		item.setItemID(itemID);
		item.setDate(date);
		item.setStartPrice(startPrice);
		item.setEndPrice(endPrice);
		item.setHighestPrice(highestPrice);
		item.setLowestPrice(lowestPrice);
		item.setTurnover(turnover);
		return item;
	}

	@Override
	public int compareTo(GlobalTradeHistoryImport oDate) {
		if(this.getDate().getTime() > oDate.getDate().getTime()) {
			return 1;
		}
		else if(this.getDate().getTime() < oDate.getDate().getTime()) {
			return -1;
		}
		return 0;
	}
}