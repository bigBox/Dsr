package com.dj.serverapi.service.inf;

import com.dj.domain.enums.ResourceBillEnum;
import com.dj.domain.config.ConfigAchievement;
import com.dj.domain.entity.player.PlayerRole;

import java.util.List;

public interface IPlayerService {

	/**
	 *	创建玩家
	 * 
	 * @param player
	 */
	void createPlayer(PlayerRole player);

	void logPlayerName();

	/**
	 *	更新玩家名称
	 * 
	 * @param oldName
	 * @param name
	 */
	void updatePlayerName(long roleID, String oldName, String name);

	/**
	 *	检查名称是否存在
	 * 
	 * @param name
	 * @return
	 */
	boolean checkExitName(String name);

	/**
	 *	获取玩家
	 * 
	 * @param roleID
	 * @return
	 */
	PlayerRole getPlayer(long roleID);

	/**
	 *	设置玩家
	 * @param roleID
	 * @param playerRole
	 */
	void setPlayer(long roleID, PlayerRole playerRole);

	/**
	 *	扣除玩家金币
	 * 
	 * @param roleID
	 * @param gold
	 * @return
	 */
	PlayerRole costGold(long roleID, long gold);

	/**
	 *	增加玩家金币
	 * 
	 * @param roleID
	 * @param gold
	 * @return
	 */
	PlayerRole addGold(long roleID, long gold);

	/**
	 *	扣除玩家体力
	 * 
	 * @param roleID
	 * @param stamina
	 * @return
	 */
	PlayerRole costStamina(long roleID, long stamina);

	/**
	 *	增加玩家体力
	 * 
	 * @param roleID
	 * @param stamina
	 * @return
	 */
	PlayerRole addStamina(long roleID, long stamina);

	/**
	 *	扣除玩家钻石
	 * 
	 * @param roleID
	 * @param diamond
	 * @return
	 */
	PlayerRole costDiamond(long roleID, long diamond);

	/**
	 *	增加玩家钻石
	 * 
	 * @param roleID
	 * @param diamond
	 * @return
	 */
	PlayerRole addDiamond(long roleID, long diamond);

	/**
	 *	增加玩家经验
	 * 
	 * @param roleID
	 * @param exp
	 * @return
	 */
	PlayerRole addExp(long roleID, long exp);

	/**
	 *	设置玩家等级
	 * 
	 * @param roleID
	 * @param level
	 */
	void addLevel(long roleID, int level);

	/**
	 *	增加玩家声望
	 * 
	 * @param roleID
	 * @param renown
	 * @return
	 */
	PlayerRole addRenown(long roleID, long renown);

	/**
	 *	设置玩家声望等级
	 * 
	 * @param roleID
	 * @param level
	 */
	void setRenownLevel(long roleID, int level);
	
	/**
	 * 增加成就
	 * @param roleID
	 * @param actionCount
	 * @return
	 */
	PlayerRole addAchievement(long roleID, long actionCount, ConfigAchievement configAchievement, ResourceBillEnum bill);

	/**
	 *	增加玩家馆藏
	 * 
	 * @param roleID
	 * @param showTable
	 * @return
	 */
	PlayerRole addShowTable(long roleID, long showTable);

	/**
	 *	扣除玩家馆藏
	 * 
	 * @param roleID
	 * @param showTable
	 * @return
	 */
	PlayerRole costShowTable(long roleID, long showTable);

	/**
	 *	设置玩家馆藏等级
	 * 
	 * @param roleID
	 * @param level
	 */
	void setShowTableLevel(long roleID, int level);

	/**
	 *	设置玩家商会
	 * 
	 * @param roleID
	 * @param guildId
	 */
	PlayerRole setRoleGuild(long roleID, long guildId);

	/**
	 *	设置玩家当前服务器id
	 * 
	 * @param roleID
	 * @param gateServerID
	 * @param playerServerID
	 * @return
	 */
	PlayerRole setLoginServerID(long roleID, int gateServerID, int playerServerID);

	/**
	 *	改名
	 * 
	 * @param roleID
	 * @param name
	 */
	PlayerRole changeName(long roleID, String name);

	/**
	 *	个人签名
	 * 
	 * @param roleID
	 * @param signature
	 */
	PlayerRole changeSignature(long roleID, String signature);

	/**
	 *	修改玩家生态值
	 * 
	 * @param roleID
	 * @param change
	 * @return
	 */
	PlayerRole changeEcology(long roleID, long change);

	/**
	 *	修改玩家繁荣度
	 * 
	 * @param roleID
	 * @param change
	 * @return
	 */
	PlayerRole changeBoom(long roleID, long change);

	PlayerRole changeGuildPost(long roleID, int post);
	/**
	 *	修改玩家商会积分
	 * 
	 * @param roleID
	 * @param change
	 * @return
	 */
	PlayerRole changeGuildScore(long roleID, long change);

	PlayerRole updateGuideId(long roleID, int guideId);

	PlayerRole updateGuideState(long roleID, int guideState);

	PlayerRole updateGuideTaskId(long roleID, int guideTaskId);

	PlayerRole updateGuideTaskState(long roleID, int guideTaskId, int guideTaskState);

	List<Long> getAllPlayerRoleIds();

	void disposeCache();
}
