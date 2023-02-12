package com.dj.domain.entity.global;

import java.io.Serializable;
import java.util.Date;

import com.dj.domain.base.IEntity;
import com.dj.domain.util.DateUtil;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class GlobalTradeStock implements Serializable, IEntity {
	private static final long serialVersionUID = -6796912366010738221L;
	// ID号
	private long id;
	//物品ID
	private int itemID;
	//今日开盘价
	private long startPrice;
	//昨日收盘价
	private long endPrice;
	//最新价格
	private long lastPrice;
	//最低价格
	private long lowestPrice;
	//最高价格
	private long highestPrice;
	// 涨跌
	private long score;
	//成交量
	private long turnover;
	//记录创建时间
	private Date createTime;
	//记录更新时间
	private Date updateTime;
	//对应导入股票历史交易的ID
	private String importID;

	public GlobalTradeStock() {
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
		GlobalTradeStock item = new GlobalTradeStock();
		item.setId(id);
		item.setItemID(itemID);
		item.setStartPrice(startPrice);
		item.setEndPrice(endPrice);
		item.setLastPrice(lastPrice);
		item.setLowestPrice(lowestPrice);
		item.setHighestPrice(highestPrice);
		item.setScore(score);
		item.setTurnover(turnover);
		item.setCreateTime(createTime);
		item.setUpdateTime(DateUtil.getCurrentDate());
		return item;
	}

}