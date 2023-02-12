package com.dj.domain.entity.player;

import java.util.Date;

import com.dj.domain.base.BaseEntity;
import com.dj.domain.base.IEntity;
import com.dj.protobuf.common.BaseRoleInfo;
import com.dj.protobuf.common.ERoleFiveEle;
import com.dj.protobuf.common.RoleInfo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class PlayerRole extends BaseEntity implements Comparable<PlayerRole>{
	private static final long serialVersionUID = 8686074554446411483L;
	/**
	 * @Field nick : 昵称
	 */
	private String roleName;

	private int level;

	private int diffLevel;

	private long levelTime;

	private long experience;

	private long gold;

	private long stamina;

	private long diamond;

	/**
	 *	馆藏
	 */
	private long showTable;
	private int showTableLevel;
	/**
	 *	声望
	 */
	private long renown;
	private int renownLevel;
	/**
	 *	成就
	 */
	private long achievement;
	private int achievementLevel;
	/**
	 *	生态值
	 */
	private long ecology;
	/**
	 *	繁荣度
	 */
	private long boom;

	/**
	 * 商会id
	 */
	private long guildId;
	/**
	 * 商会积分
	 */
	private long guildScore;
	/**
	 * 商会位置
	 */
	private int post;
	/**
	 * @Field channel : 渠道
	 */
	private String channel;

	/**
	 *	个人签名
	 */
	private String signature;

	private int playerServerID;

	/**
	 *	网关id
	 */
	private int gateServerID;

	/**
	 *	最近登录时间
	 */
	private Date lastLoginTime;

	/**
	 *	总在线
	 */
	private int totalOnline;

	/**
	 *	今天在线
	 */
	private int todayOnline;
	/**
	 * 是否是跨天登陆
	 */
	private boolean crossLogin;
	
	/**
	 *	是否在线
	 */
	private boolean isOnline;
	/**
	 * 五行属性 ERoleFiveEle
	 */
	private int fiveEle;
	
	/**
	 * 修复次数
	 */
	private int repairCount;

	/**
	 * 新手引导ID
	 */
	private int guideId;

	/**
	 * 新手引导状态
	 */
	private int guideState;

	/**
	 * 玩家当前成长任务ID
	 */
	private int guideTaskId;
	/**
	 * 玩家当前成长任务状态
	 */
	private int guideTaskState;
	/**
	 * 精灵当前的召唤等级
	 */
	private int summonLevel;

	public PlayerRole(long roleID) {
		super(roleID);
		crossLogin=false;
		repairCount = 1;
	}

	@Override
	public IEntity copy() {
		PlayerRole playerRole = new PlayerRole();
		copySuper(playerRole);
		playerRole.setRoleName(roleName);
		playerRole.setLevel(level);
		playerRole.setLevelTime(levelTime);
		playerRole.setExperience(experience);
		playerRole.setGold(gold);
		playerRole.setStamina(stamina);
		playerRole.setDiamond(diamond);
		playerRole.setShowTable(showTable);
		playerRole.setShowTableLevel(showTableLevel);
		playerRole.setRenown(renown);
		playerRole.setRenownLevel(renownLevel);
		playerRole.setAchievement(achievement);
		playerRole.setAchievementLevel(achievementLevel);
		playerRole.setEcology(ecology);
		playerRole.setBoom(boom);
		playerRole.setGuildId(guildId);
		playerRole.setGuildScore(guildScore);
		playerRole.setPost(post);
		playerRole.setChannel(channel);
		playerRole.setSignature(signature);
		playerRole.setPlayerServerID(playerServerID);
		playerRole.setGateServerID(gateServerID);
		playerRole.setLastLoginTime(lastLoginTime);
		playerRole.setTotalOnline(totalOnline);
		playerRole.setTodayOnline(todayOnline);
		playerRole.setFiveEle(fiveEle);
		playerRole.setRepairCount(repairCount);
		playerRole.setGuideId(guideId);
		playerRole.setGuideState(guideState);
		playerRole.setGuideTaskId(guideTaskId);
		playerRole.setGuideTaskState(guideTaskState);
		playerRole.setSummonLevel(summonLevel);
		return playerRole;
	}

	public BaseRoleInfo toBaseRoleInfo() {
		BaseRoleInfo.Builder baseRoleInfo = BaseRoleInfo.newBuilder();
		baseRoleInfo.setRoleId(roleID);
		baseRoleInfo.setRoleName(roleName);
		baseRoleInfo.setLevel(level);
		baseRoleInfo.setExperience((int)experience);
		baseRoleInfo.setGuildId(guildId);
		baseRoleInfo.setSignature(signature);
		baseRoleInfo.setReputationLevel(renownLevel);
		baseRoleInfo.setShowTable((int)showTable);
		baseRoleInfo.setShowTableLevel(showTableLevel);
		baseRoleInfo.setFiveEle(ERoleFiveEle.forNumber(fiveEle));
		return baseRoleInfo.build();
	}
	
	public BaseRoleInfo toBaseRoleInfo(BaseRoleInfo.Builder baseRoleInfo) {
		baseRoleInfo.setRoleId(roleID);
		baseRoleInfo.setRoleName(roleName);
		baseRoleInfo.setLevel(level);
		baseRoleInfo.setExperience((int)experience);
		baseRoleInfo.setGuildId(guildId);
		baseRoleInfo.setSignature(signature);
		baseRoleInfo.setReputationLevel(renownLevel);
		baseRoleInfo.setShowTable((int)showTable);
		baseRoleInfo.setShowTableLevel(showTableLevel);
		baseRoleInfo.setFiveEle(ERoleFiveEle.forNumber(fiveEle));
		return baseRoleInfo.build();
	}

	public RoleInfo toRoleInfo() {
		RoleInfo.Builder roleInfo = RoleInfo.newBuilder();
		roleInfo.setRoleId(roleID);
		roleInfo.setRoleName(roleName);
		roleInfo.setLevel(level);
		roleInfo.setExperience((int)experience);
		roleInfo.setGold((int)gold);
		roleInfo.setDiamond((int)diamond);
		roleInfo.setEcology((int)ecology);
		roleInfo.setGuildId(guildId);
		roleInfo.setSignature(signature);
		return roleInfo.build();
	}

	@Override
	public int compareTo(@NotNull PlayerRole o) {
		if(this.isOnline()&&(!o.isOnline)){
			return -1;
		}
		return this.getDiffLevel() - o.getDiffLevel();
	}

}