package com.dj.domain.hikari.core.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Group {
	/**
	 *	目标实体类.
	 * 
	 * @return 返回目标实体类的Class
	 */
	// Class<?> value() default null;
}
