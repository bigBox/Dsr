package com.dj.servercore.db.accessor;

import com.dj.domain.base.IEntity;
import com.dj.domain.util.lib.QueryParamMap;
import com.dj.servercore.db.DbTemplate;
import com.dj.servercore.db.base.EntityMetaData;
import com.dj.servercore.db.inf.IDbAccessor;
import lombok.extern.slf4j.Slf4j;

import java.sql.SQLException;
import java.util.List;

import static com.dj.servercore.db.base.IbatisStatementMapper.*;

/**
 * @description 直接数据库访问器
 * @author zcq
 * @date 2019年3月26日
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
@Slf4j
public class DatabaseAccessor implements IDbAccessor {

	@Override
	public int insert(IEntity entity, long identity, Class<? extends IEntity> clazz) {
		String cls = EntityMetaData.getEntityName(clazz);
		try {
			DbTemplate.getSqlmapClient(cls).insert(createStatement(INSERT_OP, cls), entity);
		} catch (SQLException e) {
			log.error(e.getMessage());
			return 0;
//			if (null != entity) {
//				throw new ServiceException("insert error ! entity:" + cls + ",primaryKey :" + entity.getPrimaryKeyValue() + ", sql:" + Utility.getTraceString(e), e);
//			} else {
//				throw new ServiceException("null point entity:" + clazz.getSimpleName() + ",primaryKey :" + identity + ", sql:" + Utility.getTraceString(e), e);
//			}
		}
		return 1;
	}

	@Override
	public int delete(Object primaryKey, Class<? extends IEntity> clazz, long identity) {
		String cls = EntityMetaData.getEntityName(clazz);
		int result = 0;
		try {
			result = DbTemplate.getSqlmapClient(cls).delete(createStatement(DELETE_OP, cls), primaryKey);
		} catch (SQLException e) {
			log.error(e.getMessage());
			//throw new ServiceException("delete error ! entity:" + cls + ",identity :" + identity + ",primaryKey :" + primaryKey + ", sql:" + Utility.getTraceString(e), e);
		}
		return result;
	}

	@Override
	public int update(IEntity entity, long identity) {
		String cls = EntityMetaData.getEntityName(entity);
		int result = 0;
		try {
			result = DbTemplate.getSqlmapClient(cls).update(createStatement(UPDATE_OP, EntityMetaData.getEntityName(entity)), entity);
		} catch (SQLException e) {
			log.error(e.getMessage());
			//throw new ServiceException("update error ! entity:" + cls + ",identity :" + identity + ",primaryKey :" + entity.getPrimaryKeyValue() + ", sql:" + Utility.getTraceString(e), e);
		}
		return result;
	}

	@Override
	public IEntity query(Object primaryKey, Class<? extends IEntity> clazz, long identity) {
		String cls = EntityMetaData.getEntityName(clazz);
		IEntity entity = null;
		try {
			entity = (IEntity) DbTemplate.getSqlmapClient(cls).queryForObject(createStatement(SELECT_SINGLE_OP, cls), primaryKey);
		} catch (SQLException e) {
			log.error(e.getMessage());
			//throw new ServiceException("query single error ! entity:" + cls + ",primaryKey :" + primaryKey + ",identity :" + identity + ", sql:" + Utility.getTraceString(e), e);
		}
		return entity;
	}

	@Override
	public IEntity select(QueryParamMap<String, Object> map, Class<? extends IEntity> clazz, long identity) {
		String cls = EntityMetaData.getEntityName(clazz);
		IEntity result = null;
		try {
			result = (IEntity) DbTemplate.getSqlmapClient(cls).queryForObject(createStatement(SELECT_SINGLE_PARAMS_OP, cls), map);
		} catch (SQLException e) {
			log.error(e.getMessage());
			//throw new ServiceException("query multi error ! entity:" + cls + ",identity :" + identity + ", sql:" + Utility.getTraceString(e), e);
		}
		return result;
	}

	@Override
	public List<IEntity> queryList(String indexName, Object indexValue, Class<? extends IEntity> clazz, long identity) {
		QueryParamMap<String, Object> map = new QueryParamMap<String, Object>();
		map.put(indexName, indexValue);
		return selectList(map, clazz, identity);
	}

	@Override
	public List<IEntity> selectList(QueryParamMap<String, Object> map, Class<? extends IEntity> clazz, long identity) {
		String cls = EntityMetaData.getEntityName(clazz);
		List<IEntity> result = null;
		try {
			result = DbTemplate.getSqlmapClient(cls).queryForList(createStatement(SELECT_MULTI_OP, cls), map);
		} catch (SQLException e) {
			log.error(e.getMessage());
			//throw new ServiceException("query multi error ! entity:" + cls + ",identity :" + identity + ", sql:" + Utility.getTraceString(e), e);
		}
		return result;
	}

	@Override
	public List<IEntity> queryAll(Class<? extends IEntity> clazz, long identity) {
		String cls = EntityMetaData.getEntityName(clazz);
		List<IEntity> result = null;
		try {
			result = DbTemplate.getSqlmapClient(cls).queryForList(createStatement(SELECT_ALL_OP, cls));
		} catch (SQLException e) {
			log.error(e.getMessage());
			//throw new ServiceException("query all error ! entity:" + cls + ",identity :" + identity + ", sql:" + Utility.getTraceString(e), e);
		}
		return result;
	}

//	@Override
//	public List<IEntity> query(String indexName, Object indexValue, IQueryFilter filter, Class<? extends IEntity> clazz, long identity) {
//		QueryParamMap<String, Object> map = new QueryParamMap<String, Object>();
//		map.put(indexName, indexValue);
//		List<IEntity> entitys = queryList(map, clazz, identity);
//		if (null != entitys && entitys.size() > 0) {
//			List<IEntity> result = null;
//			for (IEntity tmp : entitys) {
//				if (!filter.stopped() && filter.check(tmp)) {
//					if (null == result) {
//						result = new ArrayList<>();
//					}
//					result.add(tmp);
//				}
//			}
//			return result;
//		}
//		return null;
//	}

//	@Override
//	public List customQuery(String statement, QueryParamMap parameters, Class<? extends IEntity> clazz, long identity) {
//		String cls = EntityMetaData.getEntityName(clazz);
//		List result;
//		try {
//			result = DbTemplate.getSqlmapClient(cls).queryForList(statement, parameters);
//		} catch (SQLException e) {
//			throw new ServiceException("query  error ! statement:" + statement + ",identity :" + identity +  ", sql:" + Utility.getTraceString(e), e);
//		}
//		return result;
//	}

//	@Override
//	public void customUpdate(String statement, QueryParamMap parameters, Class<? extends IEntity> clazz, long identity) {
//		String cls = EntityMetaData.getEntityName(clazz);
//		try {
//			DbTemplate.getSqlmapClient(cls).update(statement, parameters);
//		} catch (SQLException e) {
//			throw new ServiceException("customUpdate error !" + statement + ",identity :" + identity +  ", sql:" + Utility.getTraceString(e), e);
//		}
//	}

//	@Override
//	public Object customQueryOne(String statement, QueryParamMap<String, Object> parameters, Class<? extends IEntity> clazz, long identity) {
//		String cls = EntityMetaData.getEntityName(clazz);
//		try {
//			return DbTemplate.getSqlmapClient(cls).queryForObject(statement, parameters);
//		} catch (SQLException e) {
//			throw new ServiceException("query error! statement:" + statement + ",identity :" + identity +  ", sql:" + Utility.getTraceString(e), e);
//		}
//	}
}
