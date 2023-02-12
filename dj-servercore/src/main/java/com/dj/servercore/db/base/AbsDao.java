package com.dj.servercore.db.base;

import com.dj.domain.type.AccessType;
import com.dj.domain.base.IEntity;
import com.dj.servercore.db.accessor.AccessorManager;
import com.dj.servercore.db.inf.dao.ICacheDaoOperation;
import com.dj.servercore.db.inf.dao.IDaoContext;
import com.dj.servercore.db.inf.dao.IDaoOperation;
import com.dj.domain.util.lib.QueryParamMap;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.ParameterizedType;
import java.util.List;

@SuppressWarnings({ "rawtypes", "unchecked" })
public abstract class AbsDao<P extends IEntity> implements IDaoContext, IDaoOperation<P>, ICacheDaoOperation<P> {

	private Class<P> poClass = (Class<P>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	
	@Autowired
	protected AccessorManager accessorManager;

	@Override
	public String getAccessType() {
		return accessorManager.getDefaultAccessType();
	}

	/**
	 *	实体，角色id索引变量名
	 */
	protected static final String ENTITY_INDEX_ROLE_ID = "roleID";
	/**
	 *	实体，角色id索引变量名
	 */
	protected static final String ENTITY_INDEX_GUILD_ID = "guildID";
	/**
	 *	获取实体类型
	 * 
	 * @param
	 */
	public Class<P> getEntityClass() {
		return poClass;
	}

	@Override
	public int insert(P pojo, long identity, String accessType) {
		return accessorManager.getAccessor(accessType).insert(pojo, identity, poClass);
	}

	@Override
	public int update(P pojo, long identity, String accessType) {
		return accessorManager.getAccessor(accessType).update(pojo, identity);
	}

	@Override
	public int delete(Object primaryKey, long identity, String accessType) {
		return accessorManager.getAccessor(accessType).delete(primaryKey, getEntityClass(), identity);
	}

	@Override
	public P query(Object primaryKey, long identity, String accessType) {
		return (P) accessorManager.getAccessor(accessType).query(primaryKey, getEntityClass(), identity);
	}

	@Override
	public P select(QueryParamMap queryParams, long identity, String accessType) {
		return (P) accessorManager.getAccessor(accessType).select(queryParams, getEntityClass(), identity);
	}

	@Override
	public List<P> selectList(QueryParamMap queryParams, long identity, String accessType) {
		return (List<P>) accessorManager.getAccessor(accessType).selectList(queryParams, getEntityClass(), identity);
	}

	@Override
	public List<P> queryList(String indexName, Object indexValue, long identity, String accessType) {
		return (List<P>) accessorManager.getAccessor(accessType).queryList(indexName, indexValue, getEntityClass(), identity);
	}

	@Override
	public List<P> getAll(long identity, String accessType) {
		return (List<P>) accessorManager.getAccessor(accessType).queryAll(getEntityClass(), identity);
	}

	@Override
	public P cacheQuery(Object primaryKey, long identity) {
		return (P) query(primaryKey, identity, AccessType.DIRECT_DB);
	}

	@Override
	public P cacheLoad(String key, Object value, long identity){
		QueryParamMap queryParams = new QueryParamMap();
		queryParams.put(key, value);
		return (P) select(queryParams, identity, AccessType.DIRECT_DB);
	}

	@Override
	public P cacheSelect(QueryParamMap queryParams, long identity) {
		return select(queryParams, identity, AccessType.DIRECT_DB);
	}

	@Override
	public int cacheInsert(P pojo, long identity) {
		int ret = insert(pojo, identity, AccessType.DIRECT_DB);
		return ret;
	}

	@Override
	public int cacheUpdate(P pojo, long identity) {
		return update(pojo, identity, AccessType.DIRECT_DB);
	}

	@Override
	public int cacheDelete(Object primaryKey, long identity) {
		return delete(primaryKey, identity, AccessType.DIRECT_DB);
	}

	@Override
	public List<P> cacheLoadAll(long identity) {
		if(identity == 0){
			return null;
		}
		return queryList(ENTITY_INDEX_ROLE_ID, identity, identity, AccessType.DIRECT_DB);
	}

	@Override
	public List<P> cacheLoadAll(String key, Object value, long identity){
		QueryParamMap queryParams = new QueryParamMap();
		queryParams.put(key, value);
		return selectList(queryParams, identity, AccessType.DIRECT_DB);
	}

	@Override
	public List<P> cacheLoadAll(QueryParamMap queryParams, long identity){
		return selectList(queryParams, identity, AccessType.DIRECT_DB);
	}
}
