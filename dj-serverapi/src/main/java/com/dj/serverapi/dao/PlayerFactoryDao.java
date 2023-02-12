package com.dj.serverapi.dao;

import com.dj.domain.type.AccessType;
import com.dj.domain.config.ConfigFactory;
import com.dj.domain.entity.player.PlayerFactory;
import com.dj.protobuf.CommonException;
import com.dj.protobuf.ErrorIDOuterClass;
import com.dj.serverapi.ServiceProvider;
import com.dj.serverapi.dao.base.BaseCacheDao;
import com.dj.serverapi.dao.inf.IPlayerFactoryDao;
import com.dj.servercore.conf.ConfigFactoryConf;
import com.dj.servercore.conf.base.ConfProvider;
import com.dj.servercore.conf.base.IConfProvider;
import com.dj.domain.util.lib.QueryParamMap;
import com.google.common.collect.ImmutableMap;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PlayerFactoryDao extends BaseCacheDao<PlayerFactory> implements IPlayerFactoryDao {

	@Override
	public void initFactory(long roleID) {
		ConfigFactoryConf conf = ConfProvider.getConfigConfProvider().getConfigConf(IConfProvider.CONFIG_FACTORY);
		if(conf == null){
			throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
		}
		ImmutableMap<Integer, ConfigFactory> factoryMap = conf.getFactoryMap();
		for (ConfigFactory factory : factoryMap.values()) {
			// -1 不会自动显示,要用户根据levelRequire在栅栏里面拖,大于0表示到了多少等级会自动显示在对应的场景里面
			if (factory.getShowLevel() >= 0) {
				PlayerFactory playerFactory = new PlayerFactory(roleID);
				playerFactory.setFactoryID(factory.getID());
				playerFactory.setShowLevel(factory.getShowLevel());
				playerFactory.setPointX(factory.getX());
				playerFactory.setPointY(factory.getY());
				cacheInsert(playerFactory, roleID);
			}
		}
		List<PlayerFactory> factories = cacheLoadAll(roleID);
		if(factories != null && factories.size() > 0) {
			ServiceProvider.getGameService().setFactory(roleID, factories);
		}
	}

	@Override
	public List<PlayerFactory> readDbData(long roleID) {
		QueryParamMap<String, Object> queryParams = new QueryParamMap<>(1);
		queryParams.put("roleID", roleID);
		return selectList(queryParams, roleID, AccessType.DIRECT_DB);
	}
}
