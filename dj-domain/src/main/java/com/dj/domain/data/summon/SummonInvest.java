package com.dj.domain.data.summon;

import java.util.Date;
import java.util.List;

import com.dj.protobuf.summon.SummonInvestReward;
import com.dj.domain.util.DateUtil;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class SummonInvest{
	
	private int mailIndex;
	
	// 地形id
    private int terrainId;

    private Date rewardTime;

    private int positionX;
    
    private int positionY;
    
    private List<Long> friendRoleIDList;
    
    public SummonInvestReward toSummonInvestReward(long roleID) {
    	SummonInvestReward.Builder builder = SummonInvestReward.newBuilder();
    	int second = DateUtil.secondsBetween(DateUtil.getCurrentDate(), rewardTime);
    	if(second < 0) {
    		second = 0;
    	}
    	builder.setMailIndex(mailIndex);
    	builder.setRewardTime(second);
    	builder.setPositionX(positionX);
    	builder.setPositionY(positionY);
    	if(friendRoleIDList != null && friendRoleIDList.contains(roleID)) {
    		builder.setRewadFlag(true);
    	}else {
    		builder.setRewadFlag(false);
    	}
    	return builder.build();
    }
}
