package com.dj.servercore.redis.base;

import java.util.List;
import java.util.Map;

import com.dj.servercore.redis.RedisTemplate;
import com.dj.servercore.redis.container.RankContainer;
import com.dj.servercore.redis.container.ServiceContainer;
import com.dj.domain.util.lib.DataPair;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter(AccessLevel.PROTECTED)
@Setter(AccessLevel.PUBLIC)
public abstract class AbsService {
	/**
	 * @Field serviceContainer : Service容器
	 */
	private ServiceContainer serviceContainer;

	/**
	 * @Title clear
	 * @Description 清空属性
	 * @return void
	 */
	public void dispose() {
		getServiceContainer().dispose();
		setServiceContainer(null);
	}

	/**
	 * @Title saveModel
	 * @Description 手动调用保存model数据
	 * @return void
	 */
	public void saveModel() {
		getServiceContainer().save();
	}

	/**
	 * @Title getRedisTemplate
	 * @Description 获取RedisTemplate
	 * @return RedisTemplate
	 */
	protected final RedisTemplate getRedisTemplate() {
		return getServiceContainer().getRedisTemplate();
	}

	/**
	 * @Title getRankContainer
	 * @Description 获取RankContainer
	 * @return RankContainer
	 */
	protected final RankContainer getRankContainer() {
		return getServiceContainer().getRankContainer();
	}

	/**
	 * @Title getService
	 * @Description 获取一个service服务,该service与调用它的service共享ServiceContainer
	 * @param clz
	 * @return AbstractService
	 */
	protected final <T extends AbsService> T getService(Class<T> clz) {
		return getServiceContainer().getService(clz);
	}

	/**
	 * @Title getModel
	 * @Description 获取Model
	 * @param roleID
	 * @param clz model class
	 * @param lock 持久化锁-加锁取model后对model内数据的修改会持久化到Redis 未加锁不则不会持久化
	 * @return T
	 */
	public final <T extends AbsModel> T getModel(long roleID, Class<T> clz, boolean lock) {
		return getServiceContainer().getModelContainer().getModel(roleID, clz, lock);
	}

	public final <T extends AbsModel> T getReadModel(long roleID, Class<T> clz) {
		return getServiceContainer().getModelContainer().getModel(roleID, clz, false);
	}

	public final <T extends AbsModel> T getWriteModel(long roleID, Class<T> clz) {
		return getServiceContainer().getModelContainer().getModel(roleID, clz, true);
	}

	public final List<AbsModel>  getAllModels(Class<?> clz) {
		return getServiceContainer().getModelContainer().getAllModels(clz);
	}
	/**
	 *	获取公共model
	 * 
	 * @param clz
	 * @param lock
	 * @param <T>
	 * @return
	 */
	public final <T extends AbsModel> T getGlobalModel(Class<T> clz, boolean lock) {
		return getServiceContainer().getModelContainer().getGlobalModel(clz, lock);
	}

	/**
	 * @Title rankSet
	 * @Description 设置玩家排行榜数据
	 * @param rankName  排行榜名称
	 * @param uid  唯一id
	 * @param score  分数
	 * @return void
	 */
	public final void rankSet(String rankName, long uid, long score) {
		getServiceContainer().getRankContainer().set(rankName, uid, score);
	}

//	protected final void rankSet(String rankName, long uid, long score) {
//		getServiceContainer().getRankContainer().set(rankName, uid, score);
//	}

	/**
	 * @Title rankRemove
	 * @Description 删除玩家排行榜数据
	 * @param rankName  排行榜名称
	 * @param uid   唯一id
	 * @return void
	 */
	protected final void rankRemove(String rankName, long uid) {
		getServiceContainer().getRankContainer().remove(rankName, uid);
	}

	/**
	 * @Title rankIncrease
	 * @Description 增加玩家排行榜分数
	 * @param rankName  排行榜名称
	 * @param uid   唯一id
	 * @param increaseScore  增加的分数
	 * @return void
	 */
	protected final void rankIncrease(String rankName, long uid, int increaseScore) {
		getServiceContainer().getRankContainer().increase(rankName, uid, increaseScore);
	}

	protected final void rankIncrease(String rankName, long uid, long increaseScore) {
		getServiceContainer().getRankContainer().increase(rankName, uid, increaseScore);
	}

	/**
	 * @Title rankGetScore
	 * @Description 获取指定排行榜指定id的分数
	 * @param rankName
	 * @param uid
	 * @return 实际分数， 如果没有值，会返回0
	 */
	protected final long rankGetScore(String rankName, long uid) {
		Long long1 = getServiceContainer().getRankContainer().getScore(rankName, uid);
		return long1 == null ? 0 : long1;
	}

	/**
	 * @Title rankGetRankDesc
	 * @Description 获取指定排行榜指定id的降序排名
	 * @param rankName
	 * @param uid
	 * @return 实际的排名， 如果没有值， 则会返回 -1
	 */
	protected final int rankGetRankDesc(String rankName, long uid) {
		Integer integer = getServiceContainer().getRankContainer().getRankDesc(rankName, uid);
		return integer == null ? -1 : integer;
	}

	/**
	 * @Title rankGetRankDesc
	 * @Description 获取指定排行榜指定id的升序排名
	 * @param rankName
	 * @param uid
	 * @return 实际的排名， 如果没有值， 则会返回 -1
	 */
	protected final int rankGetRankAsc(String rankName, long uid) {
		Integer integer = getServiceContainer().getRankContainer().getRankAsc(rankName, uid);
		return integer == null ? -1 : integer;
	}

	/**
	 * @Title: rankGetRankAndScoreDesc
	 * @Description: 获取指定排行榜指定id的降序排名以及对应分值
	 * @param rankName
	 * @param uid
	 * @return DataPair T1-rank T2-score
	 */
	protected final DataPair<Long, Long> rankGetRankAndScoreDesc(String rankName, long uid) {
		return getServiceContainer().getRankContainer().getRankAndScoreByUserIdDesc(rankName, uid);
	}

	/**
	 * @Title: rankGetRankAndScoreDesc
	 * @Description: 获取指定排行榜指定id的升序排名以及对应分值
	 * @param rankName
	 * @param uid
	 * @return DataPair T1-rank T2-score
	 */
	protected final DataPair<Long, Long> rankGetRankAndScoreAsc(String rankName, long uid) {
		return getServiceContainer().getRankContainer().getRankAndScoreByUserIdAsc(rankName, uid);
	}

	/**
	 * @Title rankGetTop 获取指定降序排行榜前N的数据
	 * @param rankName
	 * @param num
	 * @return Map roleID-score
	 */
	protected final Map<Long, Long> rankGetTopDesc(String rankName, int num) {
		return getServiceContainer().getRankContainer().getTopDesc(rankName, num);
	}

	/**
	 * @Title rankGetTop 获取指定升序排行榜前N的数据
	 * @param rankName
	 * @param num
	 * @return Map roleID-score
	 */
	protected final Map<Long, Long> rankGetTopAsc(String rankName, int num) {
		return getServiceContainer().getRankContainer().getTopAsc(rankName, num);
	}

}
