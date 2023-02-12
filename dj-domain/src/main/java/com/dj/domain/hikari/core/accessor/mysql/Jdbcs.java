package com.dj.domain.hikari.core.accessor.mysql;

import java.lang.reflect.Type;
import java.util.Date;

import com.dj.domain.hikari.core.FieldMapping;
import com.dj.domain.hikari.core.accessor.ValueAdaptor;
import com.dj.domain.util.Utility;

public class Jdbcs {

	/**
	 *	根据字段现有的信息，尽可能猜测一下字段的数据库类型
	 * 
	 * @param fm   映射字段
	 */
	public static void guessEntityFieldColumnType(FieldMapping fm) {
		Type type = fm.getField().getGenericType();
		// 明确标识为时间类型的属性
		if (fm.getTemporal() != null) {
			if (type == Date.class || type == Long.class || type == long.class) {
				fm.setAdaptor(ValueAdaptor.AsDate);
			} else {
				throw new RuntimeException("Temporal 注解只能标识在Date或Long类型的属性.");
			}
		}
		// 明确标识为JSON类型的属性
		else if (fm.getJson() != null) {
			fm.setAdaptor(ValueAdaptor.AsJson);
			fm.setWidth(fm.getColumn() == null ? 1024 : fm.getColumn().length());
			return;
		}
		// 明确标识为Blob类型属性
		else if (fm.getBlob() != null) {
			fm.setAdaptor(ValueAdaptor.AsBlob);
			return;
		}
		// 整型
		else if (Utility.isInt(type)) {
			fm.setWidth(8);
			fm.setAdaptor(ValueAdaptor.AsInteger);
		}
		// 字符串
		else if (Utility.isString(type)) {
			fm.setAdaptor(ValueAdaptor.AsString);
			fm.setWidth(fm.getColumn() == null ? 255 : fm.getColumn().length());
		}
		// 长整型
		else if (Utility.isLong(type)) {
			fm.setWidth(16);
			fm.setAdaptor(ValueAdaptor.AsLong);
		}
		// 时间
		else if (Date.class == type) {
			fm.setAdaptor(ValueAdaptor.AsDate);
		}
		// 布尔
		else if (boolean.class == type || Boolean.class == type) {
			fm.setAdaptor(ValueAdaptor.AsBoolean);
		}
		// Float
		else if (float.class == type || Float.class == type) {
			fm.setAdaptor(ValueAdaptor.AsFloat);
		}
		// Double
		else if (double.class == type || Double.class == type) {
			fm.setAdaptor(ValueAdaptor.AsDouble);
		} else {
			fm.setAdaptor(ValueAdaptor.AsJson);
			fm.setWidth(fm.getColumn() == null ? 1024 : fm.getColumn().length());
		}
	}
}
