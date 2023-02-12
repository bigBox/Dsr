package com.dj.domain.base;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Column {
	/**
	 *	属性对应数据库中列的名称.
	 */
	String name() default "";

	/**
	 *	属性表示该字段是否为唯一标识，默认为false。
	 */
	boolean unique() default false;

	/**
	 * nullable属性表示该字段是否可以为null值，默认为true。
	 */
	boolean nullable() default true;

	/**
	 * insertable属性表示在使用“INSERT”脚本插入数据时，是否需要插入该字段的值。
	 * <p>
	 * 这是原来JPA的规范，我们需要吗？
	 */
	boolean insertable() default true;

	/**
	 * updatable属性表示在使用“UPDATE”脚本插入数据时，是否需要更新该字段的值。
	 * <p>
	 * insertable和updatable属性一般多用于只读的属性，例如主键和外键等。这些字段的值通常是自动生成的。
	 */
	boolean updatable() default true;

	/**
	 * columnDefinition属性表示创建表时，该字段创建的SQL语句，一般用于通过Entity生成表定义时使用。
	 */
	String columnDefinition() default "";

	/**
	 * length属性表示字段的长度，当字段的类型为varchar时，该属性才有效，默认为255个字符。
	 */
	int length() default 255;

	/**
	 * precision属性和scale属性表示精度，当字段类型为double时，precision表示数值的总长度，scale表示小数点所占的位数。
	 */
	int precision() default 15;

	/**
	 * @see Column#precision
	 */
	int scale() default 5;

	/**
	 * comment表示注释，仅在创建表时起作用.
	 */
	String comment() default "";

	/**
	 *	建表时的默认值。
	 * 
	 * @return 如果有此属性，则在生成建表语句时添加此默认值
	 */
	String defaultValue() default "";
}
