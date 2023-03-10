package com.dj.domain.hikari.core;

import java.lang.reflect.Field;
import java.lang.reflect.Type;

import com.dj.domain.base.Column;
import com.dj.domain.base.Id;
import com.dj.domain.hikari.core.accessor.ValueAdaptor;
import com.dj.domain.hikari.core.annotations.Blob;
import com.dj.domain.hikari.core.annotations.Enumerated;
import com.dj.domain.hikari.core.annotations.Group;
import com.dj.domain.hikari.core.annotations.IsRoleId;
import com.dj.domain.hikari.core.annotations.Join;
import com.dj.domain.hikari.core.annotations.Json;
import com.dj.domain.hikari.core.annotations.Temporal;
import com.dj.domain.util.StringUtil;
import com.esotericsoftware.reflectasm.MethodAccess;

public class FieldMapping {

	private final Field field;
	private final Type klass;
	private ValueAdaptor adaptor;

	private final Column column;
	private final Id id;
	private final IsRoleId isRoleId;
	private final Enumerated enumerated;
	private final Temporal temporal;
	private final Json json;
	private final Blob blob;
	private final Group groupBy;
	private final Join join;

	private String columnName;
	private int width;
	private final int getMethodIndex;
	private final int setMethodIndex;

	public FieldMapping(Field field, MethodAccess methodAccess) {
		this.field = field;
		this.field.setAccessible(true);
		this.klass = field.getGenericType();

		// 所有注解
		this.id = field.getAnnotation(Id.class);
		this.column = field.getAnnotation(Column.class);
		this.temporal = field.getAnnotation(Temporal.class);
		this.isRoleId = field.getAnnotation(IsRoleId.class);
		this.enumerated = field.getAnnotation(Enumerated.class);
		this.json = field.getAnnotation(Json.class);
		this.blob = field.getAnnotation(Blob.class);
		this.groupBy = field.getAnnotation(Group.class);
		this.join = field.getAnnotation(Join.class);

		this.getMethodIndex = methodAccess.getIndex(StringUtil.genGetMethodName(field));
		this.setMethodIndex = methodAccess.getIndex(StringUtil.genSetMethodName(field));
	}

	public Field getField() {
		return field;
	}

	public Type getFieldClass() {
		return klass;
	}

	public Column getColumn() {
		return column;
	}

	public Id getId() {
		return id;
	}

	public IsRoleId getIsRoleId() {
		return isRoleId;
	}

	public Enumerated getEnumerated() {
		return enumerated;
	}

	public Temporal getTemporal() {
		return temporal;
	}

	public Json getJson() {
		return json;
	}

	public Blob getBlob() {
		return blob;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public String getColumnName() {
		return columnName;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getWidth() {
		return width;
	}

	public ValueAdaptor getAdaptor() {
		return adaptor;
	}

	public void setAdaptor(ValueAdaptor adaptor) {
		this.adaptor = adaptor;
	}

	// ---------------------

	public boolean isPrimaryId() {
		return id != null;
	}

	public boolean isRoleId() {
		return isRoleId != null;
	}

	public boolean hasGroupBy() {
		return groupBy != null;
	}

	public boolean isString() {
		return CharSequence.class.isAssignableFrom(field.getClass());
	}

	public boolean isInt() {
		return klass == int.class || klass == Integer.class;
	}

	public boolean isBoolean() {
		return klass == boolean.class || klass == Boolean.class;
	}

	/**
	 * @return 当前对象是否为浮点
	 */
	public boolean isFloat() {
		return klass == float.class || klass == Float.class;
	}

	/**
	 * @return 当前对象是否为双精度浮点
	 */
	public boolean isDouble() {
		return klass == double.class || klass == Double.class;
	}

	public int getPrecision() {
		return column == null ? 15 : column.precision();
	}

	public int getScale() {
		return column == null ? 5 : column.scale();
	}

	public boolean isUnsigned() {
		return column != null && column.unique();
	}

	public boolean isNotNull() {
		return column != null && !column.nullable();
	}

	public boolean hasDefaultValue() {
		return column != null && !"".equals(column.defaultValue());
	}

	public String getDefaultValue() {
		return column.defaultValue();
	}

	public boolean hasColumnComment() {
		return !StringUtil.isEmpty(this.getColumnComment());
	}

	public String getColumnComment() {
		return column == null ? "" : column.comment();
	}

	public int getGetMethodIndex() {
		return getMethodIndex;
	}

	public int getSetMethodIndex() {
		return setMethodIndex;
	}

	public Group getGroupBy() {
		return groupBy;
	}

	public Join getJoin() {
		return join;
	}
}
