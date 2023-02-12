package com.dj.domain.data.guildBattle;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import com.dj.domain.GlobalRoleID;
import com.dj.domain.util.DateUtil;
import com.google.common.collect.Maps;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class GuildBattleRoom {

	private long roleID;
	private int rewardScore;
	
	private long matchRoleID;
	private int matchRewardScore;
	
	private Date roomEndDate;
	
	private Map<Long, GuildBattleRole> battleRoleMap = Maps.newHashMapWithExpectedSize(2);
	private Map<Integer, GuildBattleBuildGame> buildGameMap = Maps.newHashMapWithExpectedSize(5);
	
	public GuildBattleRoom(long roleID, long matchRoleID) {
		this.roleID = roleID;
		this.rewardScore = 0;
		this.matchRoleID = matchRoleID;
	}
	
	public GuildBattleBuildGame getBuildGame(int buildID) {
    	return buildGameMap.get(buildID);
    }
    
    public GuildBattleBuildGame getRoleBuildGame(long roleID) {
    	if(battleRoleMap.containsKey(roleID)) {
    		GuildBattleRole battleRole = battleRoleMap.get(roleID);
    		return buildGameMap.get(battleRole.getBuildID());
    	}
    	return null;
    }
    
    public GuildBattleRole putBattleRole(long roleID, int buildID) {
    	GuildBattleRole battleRole = battleRoleMap.get(roleID);
    	if(battleRole == null) {
    		battleRole = new GuildBattleRole(roleID, null, buildID);
    		battleRoleMap.put(roleID, battleRole);
    	}
    	battleRole.setBuildID(buildID);
    	battleRole.setBattleCDEnd(null);
    	return battleRole;
    }
    
    public GuildBattleRole getBattleRole(long roleID) {
    	if(battleRoleMap.containsKey(roleID)) {
    		return battleRoleMap.get(roleID);
    	}
    	return putBattleRole(roleID, 0);
    }
    
    public void setBattleRoleBuild(long roleID, int buildID) {
    	GuildBattleRole battleRole = getBattleRole(roleID);
    	battleRole.setBuildID(buildID);
    }
	
	public void addBattleCD(int battleCD) {
		GuildBattleRole battleRole = getBattleRole(roleID);
		Date battleCDEnd = DateUtil.plusNow(TimeUnit.SECONDS, battleCD);
		battleRole.setBattleCDEnd(battleCDEnd);
	}

	/**
	 * 初始化战斗房间
	 */
	public void initBattleRoom() {
		// 房间建筑
		buildGameMap.clear();
		// 房间角色
		battleRoleMap.clear();
		putBattleRole(roleID, 0);
		for (int i = 1; i <= 5; i++) {
        	GuildBattleBuildGame buildGame = new GuildBattleBuildGame(i, 0);
        	buildGame.setHoldRoleID(GlobalRoleID.getXiaoXun());
    		buildGameMap.put(i, buildGame);
    		if (buildGame.getHoldRoleID() > 0) {
    			buildGame.setRewardDate(DateUtil.getCurrentDate());
    			putBattleRole(buildGame.getHoldRoleID(), i);
			}
		}
	}
}
