package com.dj.domain.hikari.core.accessor;

import com.dj.domain.hikari.core.EntityMapping;
import com.dj.domain.hikari.core.accessor.mysql.SqlExpert;
import com.dj.domain.hikari.core.accessor.mysql.SqlGener;

public class AccessorEntityMapping<T> extends EntityMapping<T> implements SqlGener {
	private String insertSql = null;
	private String updateSql = null;
	private String deleteSql = null;
	private String seleteSql = null;
	private String seleteAllSql = null;
	private String seleteByRoleIdSql = null;
	private String seleteByGroupSql = null;

	public AccessorEntityMapping(Class<T> klass) {
		super(klass);
	}

	@Override
	public String getInsertSql(SqlExpert expert) {
		if (insertSql == null) {
			insertSql = expert.genInsertSql(this);
		}
		return insertSql;
	}

	@Override
	public String getUpdateSql(SqlExpert expert) {
		if (updateSql == null) {
			updateSql = expert.genUpdateSql(this);
		}
		return updateSql;
	}

	@Override
	public String getDeleteSql(SqlExpert expert) {
		if (deleteSql == null) {
			deleteSql = expert.genDeleteSql(this);
		}
		return deleteSql;
	}

	@Override
	public String getSelectSql(SqlExpert expert) {
		if (seleteSql == null) {
			seleteSql = expert.genSelectSql(this);
		}
		return seleteSql;
	}

	@Override
	public String getSelectAllSql(SqlExpert expert) {
		if (seleteAllSql == null) {
			seleteAllSql = expert.genSelectAllSql(this);
		}
		return seleteAllSql;
	}

	@Override
	public String getSelectByRoleId(SqlExpert expert) {
		if (seleteByRoleIdSql == null) {
			seleteByRoleIdSql = expert.genSelectByRoleId(this);
		}
		return seleteByRoleIdSql;
	}

	@Override
	public String getSelectByGroupBy(SqlExpert expert) {
		if (seleteByGroupSql == null) {
			seleteByGroupSql = expert.genSelectByGroup(this);
		}
		return seleteByGroupSql;
	}
}
