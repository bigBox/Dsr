package com.dj.domain.topic;

import com.dj.domain.constant.ConstantTopic;
import com.dj.domain.base.BaseEvent;
import com.dj.domain.base.IAsyncEvent;
import com.dj.domain.base.ITopicEvent;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
* @ClassName: TradeEnqueueEvent  
* @Description: 交易挂单
* @author zcq 
* @date 2019年7月5日
 */
@IAsyncEvent
@Data
@EqualsAndHashCode(callSuper = false)
public class TradeEnqueueEvent extends BaseEvent implements ITopicEvent {

	private int type;
	private int orderID;
	private int price;
	private int orderNum;

	@Override
	protected void resetProperties() {
		type = 0;
		orderID = 0;
		price = 0;
		orderNum = 0;
	}

	@Override
	public String getTopic() {
		return ConstantTopic.TOPIC_TRADE_ENQUEUE;
	}
}
