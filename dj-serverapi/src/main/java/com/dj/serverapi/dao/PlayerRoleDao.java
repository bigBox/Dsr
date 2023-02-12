package com.dj.serverapi.dao;

import com.dj.domain.entity.player.PlayerRole;
import com.dj.domain.enums.PlayerAttrEnum;
import com.dj.protobuf.CommonException;
import com.dj.protobuf.ErrorIDOuterClass;
import com.dj.serverapi.dao.base.BaseCacheDao;
import com.dj.serverapi.dao.inf.IPlayerRoleDao;
import com.dj.servercore.conf.ConfigNewRoleParkConf;
import com.dj.servercore.conf.base.ConfProvider;
import com.dj.servercore.conf.base.IConfProvider;
import com.dj.servercore.server.SocketServer;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class PlayerRoleDao extends BaseCacheDao<PlayerRole> implements IPlayerRoleDao {

	@Override
	public PlayerRole createRole(long roleID, int level, String nickName, String channel, int gateServerID,int fiveEle) {
		PlayerRole playerRole = new PlayerRole(roleID);
		playerRole.setLevel(level);
		playerRole.setRoleName(nickName);
		playerRole.setExperience(PlayerAttrEnum.EXP.getDefaultValue());
		playerRole.setGold(PlayerAttrEnum.GOLD.getDefaultValue());
		playerRole.setStamina(PlayerAttrEnum.STAMINA.getDefaultValue());
		playerRole.setDiamond(PlayerAttrEnum.DIAMOND.getDefaultValue());
		playerRole.setShowTableLevel(PlayerAttrEnum.SHOWTABLE_LEVEL.getDefaultValue());
		playerRole.setRenownLevel(PlayerAttrEnum.RENOWN_LEVEL.getDefaultValue());
		playerRole.setAchievementLevel(PlayerAttrEnum.ACHIEVEMENT_LEVEL.getDefaultValue());
		ConfigNewRoleParkConf conf = ConfProvider.getConfigConfProvider().getConfigConf(IConfProvider.CONFIG_NEWROLEPARK);
		if(conf == null){
			throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
		}
		playerRole.setEcology(conf.getNewRoleGreen());
		playerRole.setChannel(channel);
		playerRole.setSignature("一起来寻宝吧");
		playerRole.setPlayerServerID(SocketServer.getServerConfig().getId());
		playerRole.setGateServerID(gateServerID);
		playerRole.setFiveEle(fiveEle);
		playerRole.setGuideId(8001);
		playerRole.setGuideState(0);
		playerRole.setGuideTaskId(10000);
		playerRole.setGuideTaskState(0);
		playerRole.setSummonLevel(0);
		cacheInsert(playerRole, playerRole.getRoleID());
		return playerRole;
	}

	@Override
	public int cacheUpdate(PlayerRole role) {
		role.setUpdateTime(new Date());
		return cacheUpdate(role, role.getRoleID());
	}

}
