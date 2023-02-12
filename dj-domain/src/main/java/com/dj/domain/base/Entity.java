package com.dj.domain.base;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface Entity {

	/**
	 *	返回当前实体类的抓取策略.
	 * 
	 * @return 返回配置的抓取策略，默认值为什么用，什么时候初始化.
	 */
	FeatchType fetch() default FeatchType.USE;

	/**
	 *	抓取策略.
	 * <p>
	 * 1.启动服务器的时候，初始化当前实体数据.<br>
	 * 2.登录游戏的时候，初始化当前实体数据.<br>
	 * 3.什么时候用，什么时候初始化当前实体数据.<br>
	 */
    enum FeatchType {
		/**
		 *	启动服务器的时候，初始化当前实体数据.
		 */
		START,
		/**
		 *	登录游戏的时候，初始化当前实体数据.
		 */
		LOGIN,
		/**
		 *	什么时候用，什么时候初始化当前实体数据.
		 */
		USE
    }
}
