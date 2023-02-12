package com.dj.domain.hikari.core.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Enumerated {

	/**
	 *	入库时有两种模式，一是以下标，二是以字符串，默认为下标
	 */
	EnumType value() default EnumType.ORDINAL;

	enum EnumType {
		/**
		 *	下标形式
		 */
		ORDINAL,
		/**
		 *	字符串形式
		 */
		STRING
	}
}
