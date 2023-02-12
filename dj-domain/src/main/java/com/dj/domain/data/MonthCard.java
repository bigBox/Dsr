package com.dj.domain.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class MonthCard {

	/**
	 *	月卡结束时间
	 */
	private long endTime;
	
	/**
	 *	登陆奖励当天领取状态
	 */
	private boolean isDrawedToday;
	/**
	 *	月卡额外奖励当天领取状态
	 */
	private boolean isMonthCardDrawedToday;
	
	/**
	 * 月卡数量
	 */
	private long count;
}
