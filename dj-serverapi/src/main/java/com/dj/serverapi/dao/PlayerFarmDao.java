package com.dj.serverapi.dao;

import com.dj.domain.config.ConfigFarmCulture;
import com.dj.domain.config.ConfigFarmParkAnimal;
import com.dj.domain.config.ConfigNewRoleFarm;
import com.dj.domain.entity.player.PlayerFarm;
import com.dj.domain.type.AccessType;
import com.dj.domain.util.DateUtil;
import com.dj.domain.util.lib.QueryParamMap;
import com.dj.protobuf.CommonException;
import com.dj.protobuf.ErrorIDOuterClass;
import com.dj.serverapi.ServiceProvider;
import com.dj.serverapi.dao.base.BaseCacheDao;
import com.dj.serverapi.dao.inf.IPlayerFarmDao;
import com.dj.servercore.conf.ConfigFarmCultureConf;
import com.dj.servercore.conf.ConfigFarmParkAnimalConf;
import com.dj.servercore.conf.ConfigNewRoleFarmConf;
import com.dj.servercore.conf.base.ConfProvider;
import com.dj.servercore.conf.base.IConfProvider;
import com.google.common.collect.ImmutableMap;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Slf4j
@Component
public class PlayerFarmDao extends BaseCacheDao<PlayerFarm> implements IPlayerFarmDao {

	@Override
	public List<PlayerFarm> readDbData(long roleID) {
		QueryParamMap<String, Object> queryParams = new QueryParamMap<>(1);
		queryParams.put("roleID", roleID);
		return selectList(queryParams, roleID, AccessType.DIRECT_DB);
	}

	public void initNewRoleFarm(long roleID) {
		ConfigFarmCultureConf farmCultureConf = ConfProvider.getConfigConfProvider().getConfigConf(IConfProvider.CONFIG_FARMCULTURE);
		if(farmCultureConf == null){
			throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
		}
		ConfigFarmParkAnimalConf farmParkAnimalConf = ConfProvider.getConfigConfProvider().getConfigConf(IConfProvider.CONFIG_FARMPARKANIMAL);
		if(farmParkAnimalConf == null){
			throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
		}
		ConfigNewRoleFarmConf conf = ConfProvider.getConfigConfProvider().getConfigConf(IConfProvider.CONFIG_NEWROLEFARM);
		if(conf == null){
			throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
		}
		try {
			ImmutableMap<Integer, ConfigNewRoleFarm> farmMap  = conf.getNewRoleFarmMap();
			for(ConfigNewRoleFarm config : farmMap.values()) {
				PlayerFarm playerFarm = new PlayerFarm(roleID);
				playerFarm.setX(config.getX());
				playerFarm.setY(config.getY());
				playerFarm.setSeed(config.getSeedId());
				if(config.getType()==1) {
					ConfigFarmCulture farmCultureConfig = farmCultureConf.getPlant(config.getSeedId());
					if(config.getInitState() == 3) {
						playerFarm.setPlaintTime(DateUtil.plusNow(TimeUnit.SECONDS, -farmCultureConfig.getCookingTime() * DateUtil.ONEMINUTE_2_SECOND));
					}else{
						playerFarm.setPlaintTime(DateUtil.getCurrentDate());
					}
					cacheInsert(playerFarm, roleID);
					ServiceProvider.getParkService().parkPlaceCrops(roleID, config.getX(), config.getY(), config.getSeedId(), farmCultureConfig);
				}else if(config.getType() == 2){
					ConfigFarmParkAnimal farmParkAnimalConfig = farmParkAnimalConf.getAnimal(config.getSeedId());
					ServiceProvider.getParkService().parkPlaceAnimal(roleID, farmParkAnimalConfig.getID(), farmParkAnimalConfig,0);
				}
			}
		}catch (Exception e){
			log.error(e.getMessage());
		}
	}
}
