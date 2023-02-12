package com.dj.domain.base;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface Table {
	/**
	 * name属性表示实体所对应表的名称，默认表名为实体的名称。
	 */
	String name() default "";

	/**
	 * comment表示注释，仅在创建表时起作用.
	 */
	String comment() default "";

	/**
	 * engine表示表结构的默认存储引擎，仅在创建表时起作用.
	 */
	TableEngine engine() default TableEngine.InnoDB;

	/**
	 * catalog和schema属性表示实体指定的目录名或是数据库名，这根据不同的数据库类型有所不同。
	 */
	String catalog() default "";

	String schema() default "";

	enum TableEngine {
		InnoDB, MyISAM
	}
}