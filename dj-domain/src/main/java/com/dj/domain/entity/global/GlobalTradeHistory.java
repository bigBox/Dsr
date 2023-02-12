package com.dj.domain.entity.global;

import com.dj.domain.base.IEntity;
import com.dj.domain.util.DateUtil;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
public class GlobalTradeHistory implements Comparable<GlobalTradeHistory> , IEntity{
	private static final long serialVersionUID = 7421733184508788578L;

	private long id;
	//物品ID
	private int itemID;
	//交易日期
	private String date;
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
	private Date createTime;
	//记录更新时间
	private Date updateTime;

	public GlobalTradeHistory() {
		setCreateTime(DateUtil.getCurrentDate());
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
		GlobalTradeHistory item = new GlobalTradeHistory();
		item.setId(id);
		item.setItemID(itemID);
		item.setDate(date);
		item.setStartPrice(startPrice);
		item.setEndPrice(endPrice);
		item.setHighestPrice(highestPrice);
		item.setLowestPrice(lowestPrice);
		item.setTurnover(turnover);
		item.setCreateTime(createTime);
		item.setUpdateTime(DateUtil.getCurrentDate());
		return item;
	}

	@Override
	public int compareTo(GlobalTradeHistory o) {
		Date sDate = DateUtil.parseDate(date, DateUtil.DATEPATTERN); 
		Date oDate = DateUtil.parseDate(o.getDate(), DateUtil.DATEPATTERN); 
		if(sDate.getTime() > oDate.getTime()) {
			return 1;
		}
		else if(sDate.getTime() < oDate.getTime()) {
			return -1;
		}
		return 0;
	}
}