package com.dj.domain.hikari.core.accessor.mysql;

public interface SqlGener {

	String getInsertSql(SqlExpert expert);

	String getDeleteSql(SqlExpert expert);

	String getUpdateSql(SqlExpert expert);

	String getSelectSql(SqlExpert expert);

	String getSelectAllSql(SqlExpert expert);

	String getSelectByRoleId(SqlExpert expert);

	String getSelectByGroupBy(SqlExpert expert);
}
