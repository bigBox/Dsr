package com.dj.domain.data.guildBattle;

import java.util.Date;
import java.util.Map;

import com.dj.protobuf.common.BaseRoleInfo;
import com.dj.protobuf.guildBattle.GuildBattleBuildInfo;
import com.google.common.collect.Maps;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author zcq
 * @description 商会战斗接鸡蛋游戏
 * @date 2020年7月31日
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class GuildBattleBuildGame {

	private int buildID;
    /**
     *	占领方id
     */
    private long holdRoleID;
    private int holdScore;
    /**
     * 攻占方id
     */
    private long captureRoleID;
    private int captureScore;
    
    /**
     * 玩家id
     */
    private long gameRoleID;
    private Date rewardDate;
    /**
     * 机器人分数
     */
    private int robotScore;

    private Date gameStartDate;
    private Date gameEndDate;
    
    private int positionX;

    // 方向， 2向右，1向左, 0原地不动
    private int directionX;

    /**
     *	配方id
     */
    private int makeID;
    /**
     *	下一个配方id1
     */
    private int nextMakeID1;
    /**
     *	下一个配方id2
     */
    private int nextMakeID2;

    /**
     *	接到的物品数量
     */
    private Map<Integer, Integer> meetItemMap = Maps.newHashMapWithExpectedSize(3);
    /**
     *	积分翻倍到期时间
     */
    private long doubleEndTime;

    /**
     *	上次飞行物出现事件
     */
    private long lastFlyTime;

    /**
     * 游戏中
     */
    private boolean inGame = false;
    /**
     * 小寻攻占中
     */
    private boolean inXxCapture=false;
    
    
    public GuildBattleBuildGame(int buildID, long holdRoleID) {
        this.buildID = buildID;
        this.holdRoleID = holdRoleID;
        
        this.rewardDate = null;
    }
    
    public int getGameScore() {
    	if(gameRoleID == holdRoleID) {
    		return holdScore;
    	}
    	return captureScore;
    }
    
    public void setGameScore(int score) {
    	if(gameRoleID == holdRoleID) {
    		holdScore = score;
    	}else {
    		captureScore = score;
    	}
    }
    
    public long getRobotRoleID() {
    	if(gameRoleID == holdRoleID) {
    		return captureRoleID;
    	}
    	return holdRoleID;
    }
    
    public GuildBattleBuildInfo toGuildBattleBuildInfo(GuildBattleBuildInfo.Builder builder, BaseRoleInfo baseRoleInfo) {
    	builder.setBuildID(buildID);
    	if(baseRoleInfo != null) {
    		builder.setHoldRoleInfo(baseRoleInfo);
    	}
    	return builder.build();
    }
}
