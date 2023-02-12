package com.dj.serverapi.service.inf;

import java.util.List;
import java.util.Map;

import com.dj.domain.config.*;
import com.dj.domain.data.game.ParkAnimalUnit;
import com.dj.domain.data.game.ParkCellUnit;
import com.dj.domain.data.game.ParkFishUnit;
import com.dj.domain.data.game.ZooAnimalUnit;
import com.dj.protobuf.park.AnimalPoint;
import com.dj.protobuf.park.CellPoint;
import com.dj.protobuf.park.ParkAnimal;
import com.dj.protobuf.park.ParkAnimalFeedReq;
import com.dj.protobuf.park.ParkCell;
import com.dj.domain.util.collection.MapSubMap;
import com.dj.domain.util.inf.IArgumentKeyValueRunnable;
import com.dj.domain.util.inf.IArgumentRunnable;

public interface IParkService {
	/**
	 *	获取生态园地图格子
	 * 
	 * @param roleID
	 * @return
	 */
	MapSubMap<Integer, Integer, ParkCellUnit> getCellMap(long roleID);

	/**
	 *	获取生态园动物
	 * 
	 * @param roleID
	 * @return
	 */
	Map<String, ParkAnimalUnit> getParkAnimalMap(long roleID);
	/**
	 *	获取动物园动物
	 *
	 * @param roleID
	 * @return
	 */
	Map<String, ZooAnimalUnit> getZooAnimalMap(long roleID);
	/**
	 *	获取生态园鱼塘的鱼
	 * 
	 * @param roleID
	 * @return
	 */
	Map<Integer, ParkFishUnit> getFishMap(long roleID);
	/**
	 *	放置植物
	 *
	 * @param roleID
	 * @param x
	 * @param y
	 * @param plantID
	 */
	ParkCellUnit parkPlaceCrops(long roleID, int x, int y, int plantID, ConfigFarmCulture config);

	/**
	 *	放置植物
	 * 
	 * @param roleID
	 * @param x
	 * @param y
	 * @param plantID
	 */
	ParkCellUnit parkPlacePlant(long roleID, int x, int y, int plantID, ConfigFarmParkPlant config);
	/**
	 *	放置树木
	 *
	 * @param roleID
	 * @param x
	 * @param y
	 * @param plantID
	 */
	ParkCellUnit parkPlaceTree(long roleID, int x, int y, int plantID, ConfigFarmParkTree config);
	/**
	 *	生态园放置动物
	 * 
	 * @param roleID
	 * @param animalID
	 * @param source   动物来源
	 */
	ParkAnimalUnit parkPlaceAnimal(long roleID, int animalID, ConfigFarmParkAnimal config, int source);
	/**
	 *	动物园放置动物
	 *
	 * @param roleID
	 * @param animalID
	 * @param source   动物来源
	 */
	ZooAnimalUnit zooPlaceAnimal(long roleID, int animalID, ConfigFarmZooAnimal config, int source);
	/**
	 *	收获植物
	 *
	 * @param roleID
	 * @return
	 */
	List<CellPoint> parkHarvestCorps(long roleID, List<CellPoint> points, IArgumentRunnable<ConfigFarmCulture> configRun, IArgumentRunnable<Integer> ecologyRun);
	/**
	 *	收获植物
	 * 
	 * @param roleID
	 * @return
	 */
	List<CellPoint> parkHarvestPlant(long roleID, List<CellPoint> points, IArgumentRunnable<ConfigFarmParkPlant> configRun, IArgumentRunnable<Integer> ecologyRun);
	/**
	 *	收获树木
	 *
	 * @param roleID
	 * @return
	 */
	List<CellPoint> parkHarvestTree(long roleID, List<CellPoint> points, IArgumentRunnable<ConfigFarmParkTree> configRun, IArgumentRunnable<Integer> ecologyRun);
	/**
	 *	清除枯萎的植物
	 * 
	 * @param roleID
	 * @return
	 */
	//List<CellPoint> parkClearWitherPlant(long roleID, List<CellPoint> points, IReturnRunnable<Boolean> costItemRun);

	/**
	 *	收获动物
	 * 
	 * @param roleID
	 */
	List<AnimalPoint> parkHarvestAnimal(long roleID, List<AnimalPoint> points, IArgumentKeyValueRunnable<ConfigFarmParkAnimal, Boolean> configRun);

	/**
	 *	清除枯萎的动物
	 * 
	 * @param roleID
	 * @return
	 */
	//List<String> parkClearWitherAnimal(long roleID, List<String> animalTimeIDs);

	/**
	 *	鱼塘放置鱼
	 * 
	 * @param roleID
	 * @param fishID
	 * @return
	 */
	ParkFishUnit parkPlaceFish(long roleID, int fishID, int  index, ConfigPoolFishs config);

	/**
	 *	鱼塘收获鱼
	 * 
	 * @param roleID
	 */
	List<Integer> parkHarvestFish(long roleID, List<Integer> indexList, IArgumentRunnable<ConfigPoolFishs> configRun);

	/**
	 *	动物吃草
	 * 
	 * @param roleID
	 */
	boolean animalEatPlant(long roleID, IArgumentRunnable<List<ParkCell>> cellRun, IArgumentRunnable<ParkAnimalUnit> animalRun, IArgumentRunnable<Integer> ecologyRun, IArgumentRunnable<ParkAnimal> animalLeave);

	/**
	 *	获取已经占用的生态值
	 * 
	 * @param roleID
	 * @return
	 */
	int getUseEcology(long roleID);

	/**
	 *	修改生态园 已经占用的生态值
	 * 
	 * @param change
	 * @return
	 */
	int changeUseEcology(long roleID, int change);

	/**
	 *	获取蜂蜜领取CD
	 * 
	 * @param roleID
	 * @return
	 */
	int getHoneyCD(long roleID);

	/**
	 *	领取蜂蜜
	 * 
	 * @param roleID
	 * @return
	 */
	int parkDrawHoney(long roleID);

	/**
	 *	生态园动物喂食
	 * 
	 * @param req
	 * @return
	 */
	ParkAnimalUnit parkAnimalFeed(ParkAnimalFeedReq req);
	
	/**
	 * 结算
	 * @param roleID
	 * @return
	 */
	int parkDrawPrize(long roleID);

	/**
	 *	设置农场
	 *
	 * @param roleID
	 * @param farms
	 */
	//void setFarm(long roleID, List<PlayerFarm> farms);

	/**
	 *	获取农场
	 *
	 * @param roleID
	 * @return
	 */
	//Map<Integer, PlayerFarm> getFarmMap(long roleID);

	/**
	 *	加速收获动物
	 *
	 * @param roleID
	 */
	//AnimalPoint parkHarvestAnimalSpeedup(long roleID, AnimalPoint point, IArgumentKeyValueRunnable<ConfigFarmParkAnimal, Boolean> configRun);
	AnimalPoint parkHarvestAnimalSpeedup(long roleID, AnimalPoint point);

	/**
	 *	加速收获植物
	 *
	 * @param roleID
	 * @return
	 */
	//CellPoint parkHarvestPlantSpeedup(long roleID, CellPoint point, IArgumentRunnable<Integer> ecologyRun);
	CellPoint parkHarvestPlantSpeedup(long roleID, CellPoint point);

	/**
	 *	加速鱼塘收获鱼
	 *
	 * @param roleID
	 */
	//Integer parkHarvestFishSpeedup(long roleID, Integer index, IArgumentRunnable<ConfigPoolFishs> configRun);
	Integer parkHarvestFishSpeedup(long roleID, Integer index);

}
