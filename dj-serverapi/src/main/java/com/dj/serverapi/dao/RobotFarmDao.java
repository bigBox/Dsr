package com.dj.serverapi.dao;

import com.dj.domain.config.ConfigFarmCulture;
import com.dj.domain.config.ConfigNewRoleFarm;
import com.dj.domain.entity.robot.RobotFarm;
import com.dj.domain.type.AccessType;
import com.dj.domain.util.DateUtil;
import com.dj.domain.util.lib.QueryParamMap;
import com.dj.protobuf.CommonException;
import com.dj.protobuf.ErrorIDOuterClass;
import com.dj.serverapi.dao.base.BaseCacheDao;
import com.dj.serverapi.dao.inf.IRobotFarmDao;
import com.dj.servercore.conf.ConfigFarmCultureConf;
import com.dj.servercore.conf.ConfigFarmParkAnimalConf;
import com.dj.servercore.conf.ConfigNewRoleFarmConf;
import com.dj.servercore.conf.base.ConfProvider;
import com.dj.servercore.conf.base.IConfProvider;
import com.google.common.collect.ImmutableMap;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Component
public class RobotFarmDao extends BaseCacheDao<RobotFarm> implements IRobotFarmDao {

	@Override
	public List<RobotFarm> readDbData(long roleID) {
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
		ImmutableMap<Integer, ConfigNewRoleFarm> farmMap  = conf.getNewRoleFarmMap();
		for(ConfigNewRoleFarm config : farmMap.values()) {
			RobotFarm robotFarm = new RobotFarm(roleID);
			robotFarm.setX(config.getX());
			robotFarm.setY(config.getY());
			robotFarm.setSeed(config.getSeedId());
			if(config.getType()==1) {
				ConfigFarmCulture farmCultureConfig = farmCultureConf.getPlant(config.getSeedId());
				if(config.getInitState() == 3) {
					robotFarm.setPlaintTime(DateUtil.plusNow(TimeUnit.SECONDS, -farmCultureConfig.getCookingTime() * DateUtil.ONEMINUTE_2_SECOND));
				}else{
					robotFarm.setPlaintTime(DateUtil.getCurrentDate());
				}
				cacheInsert(robotFarm, roleID);
				//机器人不需要再种植
				//ServiceProvider.getParkService().parkPlaceCrops(roleID, config.getX(), config.getY(), config.getSeedId(), farmCultureConfig);
			}
			//else if(config.getType() == 2){
			//	ConfigFarmParkAnimal farmParkAnimalConfig = farmParkAnimalConf.getAnimal(config.getSeedId());
			//	ServiceProvider.getParkService().parkPlaceAnimal(roleID, farmParkAnimalConfig.getID(), farmParkAnimalConfig,0);
			//}
		}
	}
}
