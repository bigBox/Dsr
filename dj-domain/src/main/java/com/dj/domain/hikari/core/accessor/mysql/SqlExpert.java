package com.dj.domain.hikari.core.accessor.mysql;

import com.dj.domain.hikari.core.EntityMapping;
import com.dj.domain.hikari.core.FieldMapping;
import com.dj.domain.hikari.core.accessor.AccessorEntityMapping;

public interface SqlExpert {

	/**
	 *	获取创建表的SQL语句.
	 */
	<T> String genCreateTableSql(EntityMapping<T> em);

	<T> String genInsertSql(EntityMapping<T> em);

	<T> String genUpdateSql(EntityMapping<T> em);

	<T> String genSelectByRoleId(EntityMapping<T> sem);

	<T> String genDeleteSql(AccessorEntityMapping<T> sem);

	<T> String genSelectSql(AccessorEntityMapping<T> sem);

	<T> String genSelectAllSql(AccessorEntityMapping<T> sem);

	<T> String genSelectByGroup(AccessorEntityMapping<T> sem);

	// 生成带值的一条语句
	<T> String genInsertSql(EntityMapping<T> em, T entity);

	<T> String genUpdateSql(EntityMapping<T> em, T entity);

	<T> String genDeleteSql(EntityMapping<T> em, T entity);

	/**
	 *	生成添加表字段的SQL
	 */
	<T> String genAddTableColumnSql(EntityMapping<T> em, FieldMapping fm);

	/**
	 *	生成修改表字段的SQL(仅限于varchar转TEXT)
	 */
	<T> String genModifyTableColumnSql(EntityMapping<T> em, FieldMapping fm);

	// 替换插入数据语句
	<T> String genReplaceInsertSql(EntityMapping<T> em, T entity);
	
	/**
	 *	生成查询数量的SQL
	 * @param sem
	 * @return
	 */
    <T> String genSelectCount(EntityMapping<T> sem, String sql);
}