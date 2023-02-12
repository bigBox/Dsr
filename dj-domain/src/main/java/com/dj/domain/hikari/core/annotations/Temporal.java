package com.dj.domain.hikari.core.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Temporal {

	/**
	 *	对应数据库中存储格式.
	 * <p>
	 *	有三种模式，DATE、TIME或TIMESTAMP，默认为TIMESTAMP
	 */
	TemporalType value() default TemporalType.TIMESTAMP;

	enum TemporalType {
		/**
		 *	日期 格式：yyyy-MM-dd
		 */
		DATE,
		/**
		 *	时间 格式：HH:mm:ss
		 */
		TIME,
		/**
		 *	日期和时间 格式：yyyy-MM-dd HH:mm:ss
		 */
		TIMESTAMP
	}
}