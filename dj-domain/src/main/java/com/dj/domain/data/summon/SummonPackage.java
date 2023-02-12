package com.dj.domain.data.summon;

import java.util.Date;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class SummonPackage implements Comparable<SummonPackage>{
    /**
     *	邮件索引
     */
    private int index;
    /**
     *	邮件时间
     */
    private long time;
    /**
     *	精灵id
     */
    private int summonID;
    /**
     *	归期时间
     */
    private long returnTime;
    /**
     *	奖励金币
     */
    private int rewardGold;
    /**
     *	奖励物品
     */
    private Map<Integer, Integer> rewardItem;
    /**
     * 获得的类型
     */
    private int rewardType;
    /**
     * 邮件未发放
     */
    private boolean ntfFlag = false;
    /**
     * 邮件已经被处理
     */
    private boolean processed = false;
    /**
     *	首次状态 0首次，1首次用完
     */
    private int first;
    /**
     * 邮件id
     */
    private int configMailID;
    /**
     * 领取奖励标记
     */
    private boolean reward = false;
    /**
     * 投资结束时间
     */
    private Date investDate;
    
    private int positionX;
    
    private int positionY;
    /**
     * 地形id
     */
    private int terrainId;
    
    @Override
	public int compareTo(SummonPackage o) {
		long t = this.getTime() - o.getTime();
		if(t > 0) {
			return 1;
		}
		return -1;
	}
}
