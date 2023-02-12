package com.dj.servergame.handler;

import com.dj.domain.config.*;
import com.dj.domain.data.game.ParkAnimalUnit;
import com.dj.domain.data.game.ParkCellUnit;
import com.dj.domain.data.game.ParkFishUnit;
import com.dj.domain.data.game.ZooAnimalUnit;
import com.dj.domain.util.DateUtil;
import com.dj.domain.util.collection.MapSubMap;
import com.dj.protobuf.CommonException;
import com.dj.protobuf.ErrorIDOuterClass;
import com.dj.protobuf.park.*;
import com.dj.serverapi.ServiceProvider;
import com.dj.servercore.conf.*;
import com.dj.servergame.manager.ConfManager;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *	生态园
 */
@Component
@Slf4j
public class GameParkHandler extends ServiceProvider {

	/**
	 *	农场信息查询
	 * 
	 * @param roleID
	 * @param builder
	 */
//	public void farmList(long roleID, FarmListRsp.Builder builder) {
//		ConfigFarmCultureConf conf = ConfManager.getInstance().getConfigFarmCultureConf();
//		if(conf == null){
//			throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
//		}
//		Date nowDate = DateUtil.getCurrentDate();
//		Map<Integer, PlayerFarm> farmMap = gameService.getFarmMap(roleID);
//		Map<Integer, FarmCellInfo> cells = Maps.newHashMapWithExpectedSize(15);
//		FarmCellInfo.Builder farmCellInfo = FarmCellInfo.newBuilder();
//		for (int i = 0; i < 15; i++) {// 农场规格默认 3*5
//			PlayerFarm playerFarm = farmMap.get(i);
//			farmCellInfo.clear();
//			farmCellInfo.setIndex(playerFarm.getIndex());
//			farmCellInfo.setSeed(playerFarm.getSeed());
//			if (playerFarm.getSeed() > 0) {// 有植物
//				ConfigFarmCulture config = conf.getPlant(playerFarm.getSeed());
//				Date endDate = DateUtil.plusTime(playerFarm.getPlaintTime(), TimeUnit.SECONDS, config.getCookingTime());
//				if (endDate.getTime() > nowDate.getTime()) {// 生长中
//					farmCellInfo.setState(EFarmCellState.Growning);
//					farmCellInfo.setLeftSeconds(DateUtil.secondsBetween(nowDate, endDate));
//					farmCellInfo.setPlaintTime(DateTime.newBuilder().setValue(playerFarm.getPlaintTime().getTime()));
//				} else {
//					farmCellInfo.setState(EFarmCellState.Ripe);// 成熟了
//					farmCellInfo.setLeftSeconds(0);
//					farmCellInfo.setPlaintTime(DateTime.newBuilder().setValue(0));
//				}
//			} else {// 无植物
//				farmCellInfo.setState(EFarmCellState.Clearing);
//				farmCellInfo.setLeftSeconds(0);
//				farmCellInfo.setPlaintTime(DateTime.newBuilder().setValue(0));
//			}
//			cells.put(i, farmCellInfo.build());
//		}
//		builder.putAllCells(cells);
//	}

	/**
	 *	获取生态园信息
	 * 
	 * @param roleID
	 * @param builder
	 */
	public void parkInfo(long roleID, ParkInfoRsp.Builder builder) {
		Date nowTime = DateUtil.getCurrentDate();
		// 地图格子 植物
		ConfigFarmCultureConf cropsConf = ConfManager.getInstance().getConfigFarmCultureConf();
		if (cropsConf == null) {
			log.error("parkInfo cropsConf == null roleID:{} ",roleID);
			throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
		}
		ConfigFarmParkPlantConf plantConf = ConfManager.getInstance().getConfigFarmParkPlantConf();
		if (plantConf == null) {
			log.error("parkInfo plantConf == null roleID:{} ",roleID);
			throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
		}
		ConfigFarmParkTreeConf treeConf = ConfManager.getInstance().getConfigFarmParkTreeConf();
		if (treeConf == null) {
			log.error("parkInfo treeConf == null roleID:{} ",roleID);
			throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
		}
		MapSubMap<Integer, Integer, ParkCellUnit> cellMap = parkService.getCellMap(roleID);
		if (cellMap != null) {
			List<ParkCellUnit> list = cellMap.allValues();
			if((list != null)&&(list.size() > 0)) {
				List<ParkCell> cells = Lists.newArrayListWithExpectedSize(list.size());
				list.forEach(item -> {
					if (item.getPlantID() > 0) {
						ConfigFarmCulture cropsConfig = cropsConf.getPlant(item.getPlantID());
						if (ObjectUtils.isNotEmpty(cropsConfig)) {
							cells.add(item.toParkCell());
						}
						ConfigFarmParkPlant plantConfig = plantConf.getPlant(item.getPlantID());
						if (ObjectUtils.isNotEmpty(plantConfig)) {
							cells.add(item.toParkCell());
						}
						ConfigFarmParkTree treeConfig = treeConf.getPlant(item.getPlantID());
						if (ObjectUtils.isNotEmpty(treeConfig)) {
							cells.add(item.toParkCell());
						}
					} else {
						cells.add(item.toParkCell());
					}
				});
				builder.addAllCells(cells);
			}
		}
		// 生态园动物
		Map<String, ParkAnimalUnit> parkAnimalMap = parkService.getParkAnimalMap(roleID);
		if((parkAnimalMap != null) && (parkAnimalMap.size() > 0)) {
			ConfigFarmParkAnimalConf parkAnimalConf = ConfManager.getInstance().getConfigFarmParkAnimalConf();
			List<ParkAnimal> parkAnimals = Lists.newArrayListWithExpectedSize(parkAnimalMap.size());
			parkAnimalMap.forEach((key, value) -> {
				ConfigFarmParkAnimal config = parkAnimalConf.getAnimal(value.getAnimalID());
				if (config != null) {
					parkAnimals.add(value.toParkAnimal(config));
				}
			});
			builder.addAllParkAnimals(parkAnimals);
		}
		Map<String, ZooAnimalUnit> zooAnimalMap = parkService.getZooAnimalMap(roleID);
		if((zooAnimalMap != null) && (zooAnimalMap.size() > 0)) {
			List<ZooAnimal> zooAnimals = Lists.newArrayListWithExpectedSize(zooAnimalMap.size());
			ConfigFarmZooAnimalConf zooAnimalConf = ConfManager.getInstance().getConfigFarmZooAnimalConf();
			ZooAnimal.Builder zooAnimalBuilder = ZooAnimal.newBuilder();
			zooAnimalMap.forEach((key, value) -> {
				ConfigFarmZooAnimal config = zooAnimalConf.getAnimalByProId(value.getAnimalID());
				if (config != null) {
					zooAnimals.add(value.toZooAnimal(zooAnimalBuilder, nowTime, config));
				}
			});
			builder.addAllZooAnimals(zooAnimals);
		}
		// 鱼塘的鱼
		Map<Integer, ParkFishUnit> fishMap = parkService.getFishMap(roleID);
		if(fishMap != null && fishMap.size() > 0) {
			List<ParkFish> parkFish = Lists.newArrayListWithExpectedSize(fishMap.size());
			fishMap.forEach((key, value) -> {
				parkFish.add(value.toParkFish());
			});
			builder.addAllFishs(parkFish);
		}
		// 已经占用的生态值
		builder.setUseEcology(parkService.getUseEcology(roleID));
		// 蜂巢奖励cd
		builder.setHoneyCD(parkService.getHoneyCD(roleID));
		// 结算状态
		builder.setParkDrawPrize(commonService.getParkDrawPrize(roleID));
	}
}
