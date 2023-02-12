package com.dj.serverapi.dao;

import com.dj.domain.entity.robot.RobotRole;
import com.dj.domain.enums.PlayerAttrEnum;
import com.dj.protobuf.CommonException;
import com.dj.protobuf.ErrorIDOuterClass;
import com.dj.serverapi.dao.base.BaseCacheDao;
import com.dj.serverapi.dao.inf.IRobotRoleDao;
import com.dj.servercore.conf.ConfigNewRoleParkConf;
import com.dj.servercore.conf.base.ConfProvider;
import com.dj.servercore.conf.base.IConfProvider;
import com.dj.servercore.server.SocketServer;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class RobotRoleDao extends BaseCacheDao<RobotRole> implements IRobotRoleDao {

	@Override
	public RobotRole createRole(long roleID, int level, String nickName, String channel, int gateServerID, int fiveEle) {
		RobotRole robotRole = new RobotRole(roleID);
		robotRole.setLevel(level);
		robotRole.setRoleName(nickName);
		robotRole.setExperience(PlayerAttrEnum.EXP.getDefaultValue());
		robotRole.setGold(PlayerAttrEnum.GOLD.getDefaultValue());
		robotRole.setStamina(PlayerAttrEnum.STAMINA.getDefaultValue());
		robotRole.setDiamond(PlayerAttrEnum.DIAMOND.getDefaultValue());
		robotRole.setShowTableLevel(PlayerAttrEnum.SHOWTABLE_LEVEL.getDefaultValue());
		robotRole.setRenownLevel(PlayerAttrEnum.RENOWN_LEVEL.getDefaultValue());
		robotRole.setAchievementLevel(PlayerAttrEnum.ACHIEVEMENT_LEVEL.getDefaultValue());
		ConfigNewRoleParkConf conf = ConfProvider.getConfigConfProvider().getConfigConf(IConfProvider.CONFIG_NEWROLEPARK);
		if(conf == null){
			throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
		}
		robotRole.setEcology(conf.getNewRoleGreen());
		robotRole.setChannel(channel);
		robotRole.setSignature("一起来寻宝吧");
		robotRole.setPlayerServerID(SocketServer.getServerConfig().getId());
		robotRole.setGateServerID(gateServerID);
		robotRole.setFiveEle(fiveEle);
		robotRole.setGuideId(8001);
		robotRole.setGuideState(0);
		robotRole.setGuideTaskId(10000);
		robotRole.setGuideTaskState(0);
		cacheInsert(robotRole, robotRole.getRoleID());
		return robotRole;
	}

	@Override
	public int cacheUpdate(RobotRole robotRole) {
		robotRole.setUpdateTime(new Date());
		return cacheUpdate(robotRole, robotRole.getRoleID());
	}

}
