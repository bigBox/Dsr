package com.dj.servercore.db.accessor;

import java.util.List;

import com.dj.domain.base.IEntity;
import com.dj.servercore.db.cache.CacheManager;
import com.dj.servercore.db.cache.IEntityCache;
import com.dj.servercore.db.cache.IEntityCacheReader;
import com.dj.servercore.db.cache.model.EntityCacheModel;
import com.dj.servercore.db.cache.write.AsyncWriteManager;
import com.dj.servercore.db.inf.IDbAccessor;
import com.dj.domain.util.lib.QueryParamMap;

/**
 * @description 实体缓存访问器
 * @author zcq
 * @date 2019年3月29日
 */
public class EntityCacheAccessor implements IDbAccessor {

	private CacheManager cacheManager;

	private AsyncWriteManager asyncWriteManager;

	public void setCacheManager(CacheManager cacheManager) {
		this.cacheManager = cacheManager;
	}

	public void setAsyncWriteManager(AsyncWriteManager asyncWriteManager) {
		this.asyncWriteManager = asyncWriteManager;
	}

	@Override
	public int insert(IEntity entity, long identity, Class<? extends IEntity> clazz) {
		if(identity == 0){
			return 0;
		}
		IEntityCache cache = cacheManager.getIdentityCache(identity);
		IEntityCacheReader reader = (IEntityCacheReader) cache;
		EntityCacheModel dataModel = reader.getModel(entity.getClass());
		if (null == dataModel) {
			// 初始化模块和数据
			cache.addModelData(entity, clazz);
		} else {
			dataModel.insert(entity);
		}
		asyncWriteManager.getDataContainer(identity).insert(entity);
		return 1;
	}

	@Override
	public int delete(Object primaryKey, Class<? extends IEntity> class1, long identity) {
		boolean result = false;
		if(identity == 0){
			return 0;
		}
		IEntityCache cache = cacheManager.getIdentityCache(identity);
		IEntityCacheReader reader = (IEntityCacheReader) cache;
		EntityCacheModel dataModel = reader.getModel(class1);
		IEntity entity = null;
		if (null != dataModel) {
			entity = dataModel.delete(primaryKey);
			result = (null != entity);
		}
		if (entity != null) {
			asyncWriteManager.getDataContainer(identity).delete(entity);
		}
		return result ? 1 : 0;
	}

	@Override
	public int update(IEntity entity, long identity) {
		boolean result = false;
		if(identity == 0){
			return 0;
		}
		IEntityCache cache = cacheManager.getIdentityCache(identity);
		IEntityCacheReader reader = (IEntityCacheReader) cache;
		EntityCacheModel dataModel = reader.getModel(entity.getClass());
		if (null != dataModel) {
			result = dataModel.update(entity);
		}
		asyncWriteManager.getDataContainer(identity).update(entity);
		return result ? 1 : 0;
	}

	@Override
	public IEntity query(Object primaryKey, Class<? extends IEntity> clazz, long identity) {
		if(identity == 0){
			return null;
		}
		IEntityCache cache = cacheManager.getIdentityCache(identity);
		IEntityCacheReader reader = (IEntityCacheReader) cache;
		EntityCacheModel dataModel = reader.getModel(clazz);
		if (null != dataModel) {
			return dataModel.load(primaryKey);
		}
		return null;
	}

	@Override
	public IEntity select(QueryParamMap<String, Object> map, Class<? extends IEntity> clazz, long identity) {
		if(identity == 0){
			return null;
		}
		IEntityCache cache = cacheManager.getIdentityCache(identity);
		IEntityCacheReader reader = (IEntityCacheReader) cache;
		EntityCacheModel dataModel = reader.getModel(clazz);
		if (null != dataModel) {
			return dataModel.load(map);
		}
		return null;
	}

	@Override
	public List<IEntity> queryList(String indexName, Object indexValue, Class<? extends IEntity> clazz, long identity) {
		if(identity == 0){
			return null;
		}
		QueryParamMap<String, Object> map = new QueryParamMap<>();
		map.put(indexName, indexValue);
		IEntityCache cache = cacheManager.getIdentityCache(identity);
		IEntityCacheReader reader = (IEntityCacheReader) cache;
		EntityCacheModel dataModel = reader.getModel(clazz);
		if (null != dataModel) {
			return dataModel.loadAll(map);
		}
		return null;
	}

	@Override
	public List<IEntity> selectList(QueryParamMap<String, Object> map, Class<? extends IEntity> clazz, long identity) {
		if(identity == 0){
			return null;
		}
		IEntityCache cache = cacheManager.getIdentityCache(identity);
		IEntityCacheReader reader = (IEntityCacheReader) cache;
		EntityCacheModel dataModel = reader.getModel(clazz);
		if (null != dataModel) {
			return dataModel.loadAll(map);
		}
		return null;
	}

	@Override
	public List<IEntity> queryAll(Class<? extends IEntity> clazz, long identity) {
		if(identity == 0){
			return null;
		}
		IEntityCache cache = cacheManager.getIdentityCache(identity);
		IEntityCacheReader reader = (IEntityCacheReader) cache;
		EntityCacheModel dataModel = reader.getModel(clazz);
		if (null != dataModel) {
			return dataModel.loadAll();
		}
		return null;
	}

//	@SuppressWarnings("rawtypes")
//	@Override
//	public List<IEntity> query(String indexName, Object indexValue, IQueryFilter filter, Class<? extends IEntity> clazz, long identity) {
//		IEntityCache cache = cacheManager.getIdentityCache(identity);
//		IEntityCacheReader reader = (IEntityCacheReader) cache;
//		EntityCacheModel dataModel = reader.getModel(clazz);
//		if (null != dataModel) {
//			return dataModel.loadAll(filter);
//		}
//		return null;
//	}
}
