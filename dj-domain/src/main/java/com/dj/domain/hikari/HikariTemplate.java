package com.dj.domain.hikari;

import com.dj.domain.util.Utility;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

@Data
@Slf4j
@NoArgsConstructor
public class HikariTemplate {
	/**
	 * @Field config : 数据库配置
	 */
	private HikariConfig config;

	/**
	 * @Field dataSource : 数据源
	 */
	private DataSource dataSource;

	/**
	 * @Title getConnection
	 * @Description 获取数据库连接
	 * @return Connection
	 */
	public Connection getConnection() {
		try {
			return dataSource.getConnection();
		} catch (Exception e) {
			log.error("error in get connection", e);
			throw new RuntimeException(e);
		}
	}

	/**
	 * @Title close
	 * @Description 关闭连接等
	 * @param conn
	 * @param stmt
	 * @param rs
	 * @return void
	 */
	public void close(Connection conn, Statement stmt, ResultSet rs) {
		DbUtils.closeQuietly(conn, stmt, rs);
	}

	/**
	 * @Title query
	 * @Description 无参查询
	 * @param sql
	 * @return Object
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Object query(String sql, ResultSetHandler rsh) {
		Connection conn = null;
		try {
			conn = getConnection();
			QueryRunner qRunner = new QueryRunner();
			return qRunner.query(conn, sql, rsh);
		} catch (Exception e) {
			log.error(Utility.getTraceString(e));
			throw new RuntimeException(e);
		} finally {
			DbUtils.closeQuietly(conn);
		}
	}

	/**
	 * @Title query
	 * @Description 有参查询
	 * @param sql
	 * @return Object
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Object query(String sql, ResultSetHandler rsh, Object... param) {
		Connection conn = null;
		try {
			conn = getConnection();
			QueryRunner qRunner = new QueryRunner();
			return qRunner.query(conn, sql, rsh, param);
		} catch (Exception e) {
			log.error(Utility.getTraceString(e));
			throw new RuntimeException(e);
		} finally {
			DbUtils.closeQuietly(conn);
		}
	}

	/**
	 * @Title update
	 * @Description 更新
	 * @param sql
	 * @return void
	 */
	public int update(String sql) {
		Connection conn = null;
		try {
			conn = getConnection();
			QueryRunner qRunner = new QueryRunner();
			return qRunner.update(conn, sql);
		} catch (Exception e) {
			log.error(Utility.getTraceString(e));
			throw new RuntimeException(e);
		} finally {
			DbUtils.closeQuietly(conn);
		}
	}

	/**
	 * @Title update
	 * @Description 有参更新
	 * @param sql
	 * @param param
	 * @return void
	 */
	public int update(String sql, Object... param) {
		Connection conn = null;
		try {
			conn = getConnection();
			QueryRunner qRunner = new QueryRunner();
			return qRunner.update(conn, sql, param);
		} catch (Exception e) {
			log.error(Utility.getTraceString(e));
			throw new RuntimeException(e);
		} finally {
			DbUtils.closeQuietly(conn);
		}
	}

	/**
	 * @Title insert
	 * @Description 插入
	 * @param sql
	 * @param rsh
	 * @return void
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object insert(String sql, ResultSetHandler rsh) {
		Connection conn = null;
		try {
			conn = getConnection();
			QueryRunner qRunner = new QueryRunner();
			return qRunner.insert(conn, sql, rsh);
		} catch (Exception e) {
			log.error(Utility.getTraceString(e));
			throw new RuntimeException(e);
		} finally {
			DbUtils.closeQuietly(conn);
		}
	}

	/**
	 * @Title insert
	 * @Description 有参插入
	 * @param sql
	 * @param rsh
	 * @param param
	 * @return void
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void insert(String sql, ResultSetHandler rsh, Object... param) {
		Connection conn = null;
		try {
			conn = getConnection();
			QueryRunner qRunner = new QueryRunner();
			qRunner.insert(conn, sql, rsh, param);
		} catch (Exception e) {
			log.error(Utility.getTraceString(e));
			throw new RuntimeException(e);
		} finally {
			DbUtils.closeQuietly(conn);
		}
	}

	/**
	 * @Title insertBatch
	 * @Description 批量插入
	 * @param sql
	 * @param rsh
	 * @return void
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void insertBatch(String sql, ResultSetHandler rsh, Object[][] params) {
		Connection conn = null;
		try {
			conn = getConnection();
			QueryRunner qRunner = new QueryRunner(true);
			qRunner.insertBatch(conn, sql, rsh, params);
		} catch (Exception e) {
			log.error(Utility.getTraceString(e));
			throw new RuntimeException(e);
		} finally {
			DbUtils.closeQuietly(conn);
		}
	}
}
