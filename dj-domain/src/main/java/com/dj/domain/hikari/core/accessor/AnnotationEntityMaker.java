package com.dj.domain.hikari.core.accessor;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import com.dj.domain.base.Column;
import com.dj.domain.base.Entity;
import com.dj.domain.base.Id;
import com.dj.domain.base.Table;
import com.dj.domain.hikari.core.EntityMapping;
import com.dj.domain.hikari.core.FieldMapping;
import com.dj.domain.hikari.core.accessor.mysql.Jdbcs;
import com.dj.domain.hikari.core.annotations.Blob;
import com.dj.domain.hikari.core.annotations.Enumerated;
import com.dj.domain.hikari.core.annotations.Group;
import com.dj.domain.hikari.core.annotations.IsRoleId;
import com.dj.domain.hikari.core.annotations.Join;
import com.dj.domain.hikari.core.annotations.Temporal;
import com.dj.domain.util.ClassUtil;
import com.dj.domain.util.StringUtil;
import com.esotericsoftware.reflectasm.MethodAccess;

public class AnnotationEntityMaker {

	private static final List<Class<?>> annotations = new ArrayList<>();
	static {
		annotations.add(Column.class);
		annotations.add(Id.class);
		annotations.add(IsRoleId.class);
		annotations.add(Enumerated.class);
		annotations.add(Temporal.class);
		annotations.add(Blob.class);
		annotations.add(Group.class);
		annotations.add(Join.class);
	}

	public <T> EntityMapping<T> make(Class<T> klass) {
		// 没有Entity注解，就认为他不是一个实体对象.
		if (!klass.isAnnotationPresent(Entity.class)) {
			throw new RuntimeException(klass.getName() + "没有@Entity注解标识 ≡ (^(OO)^) ≡");
		}
		return _makeEntity(klass);
	}

	private <T> EntityMapping<T> _makeEntity(Class<T> klass) {
		AccessorEntityMapping<T> em = new AccessorEntityMapping<>(klass);
		// 如果没有写TableName 默认为类的简单名称由驼峰式命名变成分割符分隔单词
		Table table = klass.getAnnotation(Table.class);
		String tableName = (table == null || StringUtil.isEmpty(table.name())) ? StringUtil.lowerWord(klass.getSimpleName(), '_') : table.name();
		em.setTableName(tableName);
		if (table != null) {
			em.setTableComment(table.comment());
		}
		// 解析属性
		Field[] fields = ClassUtil.scanAllField(klass, annotations);
		if (fields.length <= 0) {
			// 一个表没有属性，还ORM个蛋蛋~~
			throw new RuntimeException(klass.getName() + "没有可映射的属性 ≡ (^(OO)^) ≡");
		}
		ArrayList<FieldMapping> fieldInfo = new ArrayList<>(fields.length);
		for (Field field : fields) {
			FieldMapping fm = _makeFieldMapping(field, em.getMethodAccess());
			if (fm.isPrimaryId()) {
				em.setPrimaryId(fm);
			}
			if (fm.isRoleId()) {
				em.setRoleId(fm);
			}
			if (fm.hasGroupBy()) {
				em.setGroupBy(fm);
			}
			fieldInfo.add(fm);
		}
		em.setFieldInfo(fieldInfo);
		return em;
	}

	private FieldMapping _makeFieldMapping(Field field, MethodAccess methodAccess) {
		FieldMapping fm = new FieldMapping(field, methodAccess);
		// 需要解析的解析，有些不要用动的还放注解里面
		if (fm.getColumn() == null || StringUtil.isEmpty(fm.getColumn().name())) {
			fm.setColumnName(StringUtil.lowerWord(field.getName(), '_'));
		} else {
			fm.setColumnName(fm.getColumn().name());
		}
		Jdbcs.guessEntityFieldColumnType(fm);
		return fm;
	}
}
