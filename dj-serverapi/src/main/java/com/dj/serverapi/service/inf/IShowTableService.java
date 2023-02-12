package com.dj.serverapi.service.inf;

import java.util.List;
import java.util.Map;

import com.dj.domain.entity.player.PlayerShowTable;
import com.dj.domain.entity.player.PlayerShowTableInfo;
import com.dj.domain.entity.player.PlayerShowTableMoney;
import com.dj.domain.entity.robot.RobotShowTable;
import com.dj.domain.entity.robot.RobotShowTableMoney;
import com.dj.domain.util.inf.IArgumentRunnable;

public interface IShowTableService {

	/**
	 *	设置玩家展厅信息
	 *
	 * @param roleID
	 * @param showTables
	 */
	void setShowTables(long roleID, List<PlayerShowTable> showTables);

	/**
	 *	获取玩家展厅信息
	 * 
	 * @param roleID
	 * @param type
	 * @param page
	 * @return
	 */
	Map<Integer, PlayerShowTable> getShowTable(long roleID, int type, int page);
	/**
	 *	获取玩家展厅信息
	 *
	 * @param roleID
	 * @param page
	 * @return
	 */
	PlayerShowTableInfo getShowTableInfo(long roleID, int type, int page);
	/**
	 *	设置玩家展厅信息
	 *
	 * @param roleID
	 * @param showTableInfo
	 */
	void setShowTableInfo(long roleID, PlayerShowTableInfo showTableInfo);
	/**
	 *	把物品放入展厅
	 * 
	 * @param roleID
	 * @param showTable
	 */
	void showTablePutOn(long roleID, PlayerShowTable showTable);

	/**
	 *	把物品从展厅卸下来
	 * 
	 * @param roleID
	 * @param showTable
	 */
	void showTablePutDown(long roleID, PlayerShowTable showTable);

	/**
	 *	获取展厅的馆藏值
	 * 
	 * @param roleID
	 * @return
	 */
	PlayerShowTableMoney getShowTableMoney(long roleID);

	/**
	 *	设置展厅的馆藏值
	 * 
	 * @param roleID
	 * @param showTableMoney
	 */
	void setShowTableMoney(long roleID, PlayerShowTableMoney showTableMoney);

	/**
	 *	增加馆藏值
	 * 
	 * @param roleID
	 * @param type
	 * @param money
	 * @return
	 */
	PlayerShowTableMoney increaseShowTableMoney(long roleID, int type, int money);

	/**
	 *	扣除馆藏值
	 * 
	 * @param roleID
	 * @param type
	 * @param money
	 * @return
	 */
	PlayerShowTableMoney decreaseShowTableMoney(long roleID, int type, int money);

	/**
	 *	获取展厅的奖励状态，每个展厅每天只能领取1次
	 * 
	 * @param roleID
	 * @param type
	 */
	int moneyDrawInfo(long roleID, int type);

	/**
	 *	领取展厅奖励
	 * 
	 * @param roleID
	 * @param type
	 * @param run
	 * @return
	 */
	int moneyDrawPrize(long roleID, int type, IArgumentRunnable<PlayerShowTableMoney> run);
	
	/**
	 *	去好友家展厅
	 * 
	 * @param roleID
	 * @param friendID
	 * @param type
	 */
	void showTableSupport(long roleID, long friendID, Integer type);

	/**
	 *	设置玩家展厅信息
	 *
	 * @param roleID
	 * @param showTables
	 */
	void setRobotShowTables(long roleID, List<RobotShowTable> showTables);
	/**
	 *	获取玩家展厅信息
	 *
	 * @param roleID
	 * @param type
	 * @param page
	 * @return
	 */
	Map<Integer, RobotShowTable> getRobotShowTable(long roleID, int type, int page);

    void setRobotShowTableMoney(long roleID, RobotShowTableMoney showTableMoneyRobot);

	/**
	 *	获取展厅的馆藏值
	 *
	 * @param roleID
	 * @return
	 */
	RobotShowTableMoney getRobotShowTableMoney(long roleID);
}
