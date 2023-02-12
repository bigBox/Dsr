package com.dj.domain.topic;

import com.dj.domain.constant.ConstantTopic;
import com.dj.domain.base.BaseEvent;
import com.dj.domain.base.IAsyncEvent;
import com.dj.domain.base.ITopicEvent;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
* @ClassName: TradeUseEvent  
* @Description: 交易买卖
* @author zcq
* @date 2019年7月5日
 */
@IAsyncEvent
@Data
@EqualsAndHashCode(callSuper = false)
public class TradeUseEvent extends BaseEvent implements ITopicEvent {

	private int type;
	private int orderID;
	private long id;
	private int num;

	@Override
	protected void resetProperties() {
		type = 0;
		orderID = 0;
		id = 0;
		num = 0;
	}

	@Override
	public String getTopic() {
		return ConstantTopic.TOPIC_TRADE_USE;
	}
}
