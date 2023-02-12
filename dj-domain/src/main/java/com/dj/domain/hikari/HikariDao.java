package com.dj.domain.hikari;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.dj.domain.hikari.core.EntityMapping;
import com.dj.domain.hikari.core.accessor.AccessorEntityMapping;
import com.dj.domain.hikari.core.accessor.AnnotationEntityMaker;
import com.dj.domain.hikari.core.accessor.mysql.MysqlSqlExpert;
import com.dj.domain.hikari.core.accessor.mysql.SqlGener;
import com.dj.domain.util.Utility;
import com.dj.domain.util.cache.CacheUtil;
import com.google.common.cache.Cache;
import com.zaxxer.hikari.HikariDataSource;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class HikariDao {
	/**
	 * @Field expert : sql导出器
	 */
	public final static MysqlSqlExpert expert = new MysqlSqlExpert();

	/**
	 * @Field maker : 实体对象解析生成器
	 */
	private final static AnnotationEntityMaker maker = new AnnotationEntityMaker();

	/**
	 * @Field jdbcTemplate : JDBC操作模版
	 */
	protected HikariTemplate jdbcTemplate;

	/**
	 * @Field entityMappings : 实体类映射缓存
	 */
	private Cache<String, EntityMapping<?>> entityMappings = CacheUtil.createCache();

	public HikariDao(HikariConfig config) {
		com.zaxxer.hikari.HikariConfig hkconfig = new com.zaxxer.hikari.HikariConfig();
		hkconfig.setJdbcUrl(config.getUrl());
		hkconfig.setUsername(config.getUser());
		hkconfig.setPassword(config.getPassword());
		hkconfig.setDriverClassName(config.getDriverClass());
		if (config.getMinPoolSize() != 0) {
			hkconfig.setMinimumIdle(config.getMinPoolSize());
		}
		if (config.getMaxPoolSize() != 0) {
			hkconfig.setMaximumPoolSize(config.getMaxPoolSize());
		}
		HikariTemplate template = new HikariTemplate();
		template.setConfig(config);
		template.setDataSource(new HikariDataSource(hkconfig));
		this.jdbcTemplate = template;
	}

	public void shutdown() {
		HikariDataSource dataSource = (HikariDataSource) jdbcTemplate.getDataSource();
		dataSource.close();
		log.info("close dataSource successfully");
	}

	@SuppressWarnings("unchecked")
	public <T> EntityMapping<T> getEntityMapping(Class<T> clazz) {
		try {
			return (EntityMapping<T>) entityMappings.get(clazz.getName(), new Callable<EntityMapping<T>>() {
				@Override
				public EntityMapping<T> call() throws Exception {
					return maker.make(clazz);
				}
			});
		} catch (ExecutionException e) {
			log.error(Utility.getTraceString(e));
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public <T> Object insert(final T entity) {
		try {
			EntityMapping<T> em = (EntityMapping<T>) getEntityMapping(entity.getClass());
			return jdbcTemplate.insert(expert.genInsertSql(em, entity), new ScalarHandler<T>(1));
		} catch (Exception e) {
			log.error("insert error={}", e.getMessage());
		}
		return null;
	}

	public <T> void delete(final T entity) {
		try {
			delete(getEntityMapping(entity.getClass()), getEntityMapping(entity.getClass()).getPrimaryIdValue(entity));
		} catch (Exception e) {
			log.error("delete error={}", e.getMessage());
		}
	}

	private <T, K extends Serializable> void delete(final EntityMapping<T> em, final K id) {
		try {
			jdbcTemplate.update(((SqlGener) em).getDeleteSql(expert), id);
		} catch (Exception e) {
			log.error("delete error={}", e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	public <T> void update(final T entity) {
		try {
			EntityMapping<T> em = (EntityMapping<T>) getEntityMapping(entity.getClass());
			jdbcTemplate.update(expert.genUpdateSql(em, entity));
		} catch (Exception e) {
			log.error("update error={}", e.getMessage());
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public <T> List<T> queryAllByWhere(Class<T> clazz, String sql) {
		try {
			AccessorEntityMapping<T> em = (AccessorEntityMapping<T>) getEntityMapping(clazz);
			StringBuilder sb = new StringBuilder();
			sb.append(em.getSelectAllSql(expert)).append(" where ").append(sql);
			return (List<T>) jdbcTemplate.query(sb.toString(), new BeanListHandler(clazz));
		} catch (Exception e) {
			log.error("queryAllByWhere error={}", e.getMessage());
		}
		return null;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public <T> List<T> queryAllByOrder(Class<T> clazz, String sql) {
		try {
			AccessorEntityMapping<T> em = (AccessorEntityMapping<T>) getEntityMapping(clazz);
			StringBuilder sb = new StringBuilder();
			sb.append(em.getSelectAllSql(expert)).append(" order by ").append(sql);
			return (List<T>) jdbcTemplate.query(sb.toString(), new BeanListHandler(clazz));
		} catch (Exception e) {
			log.error("queryAllByOrder error={}", e.getMessage());
		}
		return null;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public <T, K extends Serializable> List<T> queryAllByOrderAndRoleId(Class<T> clazz, String sql, final K id) {
		try {
			AccessorEntityMapping<T> em = (AccessorEntityMapping<T>) getEntityMapping(clazz);
			StringBuilder sb = new StringBuilder();
			sb.append(em.getSelectByRoleId(expert)).append(" order by ").append(sql);
			return (List<T>) jdbcTemplate.query(sb.toString(), new BeanListHandler(clazz), id);
		} catch (Exception e) {
			log.error("queryAllByOrderAndRoleId error={}", e.getMessage());
		}
		return null;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public <T> List<T> queryAll(Class<T> clazz, String sql, Object... param) {
		try {
			return (List<T>) jdbcTemplate.query(sql, new BeanListHandler(clazz), param);
		} catch (Exception e) {
			log.error("queryAll error={}", e.getMessage());
		}
		return null;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public <T> List<T> queryAll(Class<T> clazz) {
		try {
			AccessorEntityMapping<T> em = (AccessorEntityMapping<T>) getEntityMapping(clazz);
			return (List<T>) jdbcTemplate.query(expert.genSelectAllSql(em), new BeanListHandler(clazz));
		} catch (Exception e) {
			log.error("queryAll error={}", e.getMessage());
		}
		return null;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public <T, K extends Serializable> List<T> queryAllByRoleId(Class<T> clazz, final K id) {
		try {
			EntityMapping<T> em = getEntityMapping(clazz);
			return (List<T>) jdbcTemplate.query(expert.genSelectByRoleId(em), new BeanListHandler(clazz), id);
		} catch (Exception e) {
			log.error("queryAllByRoleId error={}", e.getMessage());
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public <T> void insertBatch(final List<T> entityList) {
		Connection connection = null;
		Statement psts = null;
		try {
			connection = jdbcTemplate.getConnection();
			psts = connection.createStatement();
			for (T entity : entityList) {
				if (entity != null) {
					EntityMapping<T> em = (EntityMapping<T>) getEntityMapping(entity.getClass());
					psts.addBatch(expert.genReplaceInsertSql(em, entity));
				}
			}
			psts.executeBatch();
		} catch (Exception e) {
			log.error("insertBatch error={}", e.getMessage());
		} finally {
			jdbcTemplate.close(connection, psts, null);
		}
	}

	public void insertBatchSql(List<String> sqlList) {
		Connection connection = null;
		Statement psts = null;
		try {
			connection = getJdbcTemplate().getConnection();
			psts = connection.createStatement();
			for (String sql : sqlList) {
				psts.addBatch(sql);
			}
			psts.executeBatch();
		} catch (Exception e) {
			log.error("insertBatchSql error={}", e.getMessage());
		} finally {
			getJdbcTemplate().close(connection, psts, null);
		}
	}

	public boolean createTable(String sql) {
		Connection connection = null;
		Statement psts = null;
		boolean ret = false;
		try {
			connection = getJdbcTemplate().getConnection();
			psts = connection.createStatement();
			ret = psts.execute(sql);
		} catch (Exception e) {
			log.error("createTable error={}", e.getMessage());
		} finally {
			getJdbcTemplate().close(connection, psts, null);
		}
		return ret;
	}

	public boolean checkExistTable(String tableName) {
		Connection connection = null;
		ResultSet rs = null;
		try {
			connection = getJdbcTemplate().getConnection();
			rs = connection.getMetaData().getTables(null, null, tableName, null);
            return rs.next();
		} catch (Exception e) {
			log.error("checkExistTable error={}", e.getMessage());
		} finally {
			getJdbcTemplate().close(connection, null, rs);
		}
		return false;
	}
}
