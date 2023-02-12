package com.dj.domain.hikari.core.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Json {
	/**
	 *	是否写入类名.
	 * <p>
	 *	默认不写入 <br>
	 * <b>如果需要写入类名，注意重构时包目录和类名</b>
	 * 
	 * @return 如果需要写入类名返回true,否则返回false.
	 */
	JsonStyle style() default JsonStyle.DefaultStyle;

	enum JsonStyle {
		/**
		 *	这个没有任何意义，只是个默认值.
		 */
		DefaultStyle,
		/**
		 *	写入Class类名
		 */
		WriteClassName
    }
}