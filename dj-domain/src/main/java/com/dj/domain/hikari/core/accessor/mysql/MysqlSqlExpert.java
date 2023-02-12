package com.dj.domain.hikari.core.accessor.mysql;

import com.dj.domain.hikari.core.EntityMapping;
import com.dj.domain.hikari.core.FieldMapping;
import com.dj.domain.hikari.core.accessor.AccessorEntityMapping;
import com.dj.domain.hikari.core.accessor.ValueAdaptor;
import com.dj.domain.util.StringUtil;

public class MysqlSqlExpert extends AbstractSqlExpert {
	@Override
	public <T> String genCreateTableSql(EntityMapping<T> em) {
		StringBuilder sb = new StringBuilder(512);
		sb.append("CREATE TABLE `" + em.getTableName() + "` (");
		// 创建字段
		for (FieldMapping fm : em.getFieldMapping()) {
			sb.append('\n').append('`').append(fm.getColumnName()).append('`');
			sb.append(' ').append(evalFieldType(fm));
			// 主键的 @Id，应该加入唯一性约束
			if (fm.isPrimaryId()) {
				sb.append(" NOT NULL");
			}
			// 普通字段
			else {
				// 下面的关于Timestamp处理，是因为MySql中第一出现Timestamp的话，如果没有设定default，数据库默认会设置为CURRENT_TIMESTAMP
				if (fm.isUnsigned())
					sb.append(" UNSIGNED");
				if (fm.isNotNull()) {
					sb.append(" NOT NULL");
				} else if (fm.getAdaptor() == ValueAdaptor.AsDate) {
					sb.append(" NULL");
				}
				if (fm.hasDefaultValue()) {
					switch (fm.getAdaptor()) {
					case AsBoolean:
					case AsInteger:
					case AsLong:
					case AsDouble:
					case AsFloat:
						sb.append(" DEFAULT ").append(fm.getDefaultValue());
						break;
					default:
						sb.append(" DEFAULT '").append(fm.getDefaultValue()).append("'");
						break;
					}
				}
			}
			if (fm.hasColumnComment()) {
				sb.append(" COMMENT '").append(fm.getColumnComment()).append("'");
			}
			sb.append(',');
		}
		// 创建主键
		FieldMapping pk = em.getPrimaryId();
		if (pk != null) {
			sb.append('\n');
			sb.append("PRIMARY KEY (");
			sb.append('`').append(pk.getColumnName()).append('`').append(',');
			sb.setCharAt(sb.length() - 1, ')');
		}
		FieldMapping roleId = em.getRoleId();
		if ((roleId != null && pk != null && !pk.getColumnName().equals(roleId.getColumnName()))) {
			sb.append(",\n");
			sb.append("KEY `");
			sb.append(em.getTableName() + "_" + roleId.getColumnName());
			sb.append("` (`");
			sb.append(roleId.getColumnName());
			sb.append("`)");
		}
		if ((em.getTableName().equals("role"))) {
			sb.append(",\n");
			sb.append("KEY `");
			sb.append(em.getTableName() + "_user_id");
			sb.append("` (`");
			sb.append("user_id");
			sb.append("`)");
		}
		sb.append("\n");
		// 结束表字段设置
		sb.setCharAt(sb.length() - 1, ')');
		sb.append("\n");
		// 设置特殊引擎
		sb.append(" ENGINE=").append(em.getTableEngine().name());
		sb.append(" DEFAULT CHARSET=utf8");
		// 表名注释
		if (!StringUtil.isEmpty(em.getTableComment())) {
			sb.append(" COMMENT='").append(em.getTableComment()).append("'");
		}
		return sb.append(";").toString();
	}

	@Override
	protected String evalFieldType(FieldMapping fm) {
		switch (fm.getAdaptor()) {
		case AsInteger:
			return "INT(11)";
		case AsLong://
			return "BIGINT(20)";
		case AsDouble:// 有小数的就直接写上他写的参数
			return "DOUBLE(" + fm.getPrecision() + "," + fm.getScale() + ")";
		case AsFloat:
			return "FLOAT(" + fm.getPrecision() + "," + fm.getScale() + ")";
		default:// 其它的参照默认字段规则 ...
			return super.evalFieldType(fm);
		}
	}

	@Override
	public <T> String genInsertSql(EntityMapping<T> em) {
		StringBuilder sb = new StringBuilder(128);
		sb.append("INSERT INTO ").append(em.getTableName()).append(" (");
		int count = 0;
		for (FieldMapping fm : em.getFieldMapping()) {
			sb.append(fm.getColumnName()).append(',');
			count++;
		}
		sb.setCharAt(sb.length() - 1, ')');
		sb.append(" VALUES (");
		for (int i = 0; i < count; i++) {
			sb.append("?,");
		}
		sb.setCharAt(sb.length() - 1, ')');
		return sb.toString();
	}

	@Override
	public <T> String genDeleteSql(AccessorEntityMapping<T> sem) {
		StringBuilder sb = new StringBuilder(128);
		sb.append("DELETE FROM `").append(sem.getTableName());
		sb.append("` WHERE ").append(sem.getPrimaryId().getColumnName()).append("=?");
		return sb.toString();
	}

	@Override
	public <T> String genUpdateSql(EntityMapping<T> em) {
		StringBuilder sb = new StringBuilder(128);
		sb.append("UPDATE `").append(em.getTableName()).append("` SET ");
		for (FieldMapping fm : em.getFieldMapping()) {
			if (!fm.isPrimaryId()) {
				sb.append(fm.getColumnName()).append("=?,");
			}
		}
		sb.setCharAt(sb.length() - 1, ' ');
		sb.append("WHERE ").append(em.getPrimaryId().getColumnName()).append("=?");
		return sb.toString();
	}

	@Override
	public <T> String genSelectByRoleId(EntityMapping<T> em) {
		StringBuilder sb = new StringBuilder(128);
		sb.append("SELECT ");
		for (FieldMapping fm : em.getFieldMapping()) {
			sb.append(fm.getColumnName()).append(',');
		}
		sb.setCharAt(sb.length() - 1, ' ');
		sb.append("FROM `").append(em.getTableName());
		if (em.getRoleId() != null) {
			sb.append("` WHERE ").append(em.getRoleId().getColumnName()).append("=?");
		}
		return sb.toString();
	}

	@Override
	public <T> String genSelectSql(AccessorEntityMapping<T> sem) {
		StringBuilder sb = new StringBuilder(128);
		sb.append("SELECT ");
		for (FieldMapping fm : sem.getFieldMapping()) {
			sb.append(fm.getColumnName()).append(',');
		}
		sb.setCharAt(sb.length() - 1, ' ');
		sb.append("FROM `").append(sem.getTableName());
		sb.append("` WHERE ").append(sem.getPrimaryId().getColumnName()).append("=?");
		return sb.toString();
	}

	@Override
	public <T> String genSelectAllSql(AccessorEntityMapping<T> sem) {
		StringBuilder sb = new StringBuilder(128);
		sb.append("SELECT ");
		for (FieldMapping fm : sem.getFieldMapping()) {
			sb.append(fm.getColumnName()).append(',');
		}
		sb.setCharAt(sb.length() - 1, ' ');
		sb.append("FROM `").append(sem.getTableName()).append("`");
		return sb.toString();
	}

	@Override
	public <T> String genSelectByGroup(AccessorEntityMapping<T> em) {
		StringBuilder sb = new StringBuilder(128);
		sb.append("SELECT ");
		for (FieldMapping fm : em.getFieldMapping()) {
			sb.append(fm.getColumnName()).append(',');
		}
		sb.setCharAt(sb.length() - 1, ' ');
		sb.append("FROM `").append(em.getTableName());
		if (em.getGroupBy() != null) {
			sb.append("` WHERE ").append(em.getGroupBy().getColumnName()).append("=?");
		}
		return sb.toString();
	}

	@Override
	public <T> String genInsertSql(EntityMapping<T> em, T entity) {
		StringBuilder sb = new StringBuilder(256);
		sb.append("INSERT INTO `").append(em.getTableName()).append("` (");
		for (FieldMapping fm : em.getFieldMapping()) {
			sb.append(fm.getColumnName()).append(',');
		}
		sb.setCharAt(sb.length() - 1, ')');
		sb.append(" VALUES (");
		for (FieldMapping fm : em.getFieldMapping()) {
			try {
				sb.append(fm.getAdaptor().getString(fm, entity)).append(',');
			} catch (IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		sb.setCharAt(sb.length() - 1, ')');
		return sb.toString();
	}

	@Override
	public <T> String genUpdateSql(EntityMapping<T> em, T entity) {
		StringBuilder sb = new StringBuilder(256);
		sb.append("UPDATE `").append(em.getTableName()).append("` SET ");
		for (FieldMapping fm : em.getFieldMapping()) {
			if (!fm.isPrimaryId()) {
				try {
					sb.append(fm.getColumnName()).append("=").append(fm.getAdaptor().getString(fm, entity)).append(",");
				} catch (IllegalArgumentException | IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		}
		sb.setCharAt(sb.length() - 1, ' ');
		try {
			sb.append("WHERE ").append(em.getPrimaryId().getColumnName()).append("=").append(em.getPrimaryId().getAdaptor().getString(em.getPrimaryId(), entity));
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}

	@Override
	public <T> String genDeleteSql(EntityMapping<T> em, T entity) {
		StringBuilder sb = new StringBuilder(128);
		sb.append("DELETE FROM `").append(em.getTableName());
		try {
			sb.append("` WHERE ").append(em.getPrimaryId().getColumnName()).append("=").append(em.getPrimaryId().getAdaptor().getString(em.getPrimaryId(), entity));
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}

	@Override
	public <T> String genAddTableColumnSql(EntityMapping<T> em, FieldMapping fm) {
		StringBuilder sb = new StringBuilder(128);
		sb.append("ALTER TABLE `").append(em.getTableName()).append("` ADD COLUMN `").append(fm.getColumnName());
		sb.append("` ").append(evalFieldType(fm));
		if (fm.isNotNull()) {
			sb.append(" NOT NULL");
		} else if (fm.getAdaptor() == ValueAdaptor.AsDate) {
			sb.append(" NULL");
		}

		if (fm.hasDefaultValue()) {
			switch (fm.getAdaptor()) {
			case AsBoolean:
			case AsInteger:
			case AsLong:
			case AsDouble:
			case AsFloat:
				sb.append(" DEFAULT ").append(fm.getDefaultValue());
				break;
			default:
				sb.append(" DEFAULT '").append(fm.getDefaultValue()).append("'");
				break;
			}
		}
		if (fm.hasColumnComment()) {
			sb.append(" COMMENT '").append(fm.getColumnComment()).append("'");
		}
		return sb.toString();
	}

	@Override
	public <T> String genModifyTableColumnSql(EntityMapping<T> em, FieldMapping fm) {
		StringBuilder sb = new StringBuilder(128);
		sb.append("ALTER TABLE `").append(em.getTableName()).append("` MODIFY COLUMN `").append(fm.getColumnName());
		sb.append("` ").append(evalFieldType(fm));
		return sb.toString();
	}

	@Override
	public <T> String genReplaceInsertSql(EntityMapping<T> em, T entity) {
		StringBuilder sb = new StringBuilder(256);
		sb.append("REPLACE INTO `").append(em.getTableName()).append("` (");
		for (FieldMapping fm : em.getFieldMapping()) {
			sb.append(fm.getColumnName()).append(',');
		}
		sb.setCharAt(sb.length() - 1, ')');
		sb.append(" VALUES (");
		for (FieldMapping fm : em.getFieldMapping()) {
			try {
				sb.append(fm.getAdaptor().getString(fm, entity)).append(',');
			} catch (IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		sb.setCharAt(sb.length() - 1, ')');
		return sb.toString();
	}

	@Override
	public <T> String genSelectCount(EntityMapping<T> sem, String sql) {
		StringBuilder sb = new StringBuilder(128);
		sb.append("SELECT COUNT(`id`) FROM ");
		sb.append("`");
		sb.append(sem.getTableName());
		sb.append("`");
		if (sql != null) {
			sb.append(" where ").append(sql);
		}
		return sb.toString();
	}
}