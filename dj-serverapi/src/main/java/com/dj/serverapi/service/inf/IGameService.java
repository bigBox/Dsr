package com.dj.serverapi.service.inf;

import java.util.List;
import java.util.Map;

import com.dj.domain.entity.player.PlayerFactory;
import com.dj.domain.entity.player.PlayerFarm;
import com.dj.domain.entity.player.PlayerObstacle;
import com.dj.domain.entity.robot.RobotFactory;
import com.dj.domain.entity.robot.RobotObstacle;

public interface IGameService {

	/**
	 *	设置主页建筑
	 * 
	 * @param roleID
	 * @param factorys
	 */
	void setFactory(long roleID, List<PlayerFactory> factorys);

	/**
	 *	获取主页建筑
	 * 
	 * @param roleID
	 * @return
	 */
	List<PlayerFactory> getFactory(long roleID);

	/**
	 *	设置主页建筑
	 *
	 * @param roleID
	 * @param factorys
	 */
	void setRobotFactory(long roleID, List<RobotFactory> factorys);

	/**
	 *	获取主页建筑
	 *
	 * @param roleID
	 * @return
	 */
	List<RobotFactory> getRobotFactory(long roleID);

	/**
	 *	获取荒地
	 *
	 * @param roleID
	 * @return
	 */
	List<PlayerObstacle> getObstacle(long roleID);

	/**
	 *	设置荒地
	 *
	 * @param roleID
	 * @param obstacle
	 */
	void setObstacle(long roleID, List<PlayerObstacle> obstacle);

	/**
	 *	获取荒地
	 *
	 * @param roleID
	 * @return
	 */
	List<RobotObstacle> getRobotObstacle(long roleID);

	/**
	 *	设置荒地
	 *
	 * @param roleID
	 * @param obstacle
	 */
	void setRobotObstacle(long roleID, List<RobotObstacle> obstacle);
}
