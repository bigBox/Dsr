package com.dj.serverapi.dao;

import com.dj.domain.config.ConfigNewRoleShowTableInfo;
import com.dj.domain.entity.player.PlayerShowTableInfo;
import com.dj.domain.type.AccessType;
import com.dj.domain.util.lib.QueryParamMap;
import com.dj.protobuf.CommonException;
import com.dj.protobuf.ErrorIDOuterClass;
import com.dj.serverapi.ServiceProvider;
import com.dj.serverapi.dao.base.BaseCacheDao;
import com.dj.serverapi.dao.inf.IPlayerShowTableInfoDao;
import com.dj.servercore.conf.ConfigNewRoleShowTableInfoConf;
import com.dj.servercore.conf.base.ConfProvider;
import com.dj.servercore.conf.base.IConfProvider;
import com.google.common.collect.ImmutableMap;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class PlayerShowTableInfoDao extends BaseCacheDao<PlayerShowTableInfo> implements IPlayerShowTableInfoDao {

	@Override
	public List<PlayerShowTableInfo> initNewRoleShowTableInfo(long roleID) {
		List<PlayerShowTableInfo> newRoleShowTableInfoList = new ArrayList<>();
		ConfigNewRoleShowTableInfoConf conf = ConfProvider.getConfigConfProvider().getConfigConf(IConfProvider.CONFIG_NEWROLESHOWTABLEINFO);
		if(conf == null){
			throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
		}
		try {
			ImmutableMap<Integer, ConfigNewRoleShowTableInfo> showTableInfoList = conf.getNewRoleShowTableInfoMap();
			for (ConfigNewRoleShowTableInfo showTableInfo : showTableInfoList.values()) {
				PlayerShowTableInfo playerShowTableInfo = new PlayerShowTableInfo(roleID);
				playerShowTableInfo.setRoleID(roleID);
				playerShowTableInfo.setPage(showTableInfo.getPage());
				playerShowTableInfo.setType(0);
				playerShowTableInfo.setInfo(showTableInfo.getInfo());
				cacheInsert(playerShowTableInfo, roleID);
				ServiceProvider.getShowTableService().setShowTableInfo(roleID, playerShowTableInfo);
				newRoleShowTableInfoList.add(playerShowTableInfo);
			}
		}catch (Exception e){
			log.error(e.getMessage());
		}
		return newRoleShowTableInfoList;
	}

	@Override
	public List<PlayerShowTableInfo> readDbData(long roleID) {
		QueryParamMap<String, Object> queryParams = new QueryParamMap<>(1);
		queryParams.put("roleID", roleID);
		return selectList(queryParams, roleID, AccessType.DIRECT_DB);
	}
}
