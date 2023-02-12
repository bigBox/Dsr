package com.dj.bms.common.enums;

/**
 * 转换的策略
 * 
 * @author zcq
 * @date 2020-02-09
 * @since 3.0
 */
public enum ConverPolicy {

	/**
	 * ID 转 DTO
	 */
	ID_CONVER_DTO,

	/**
	 * 编码转枚举
	 */
	CODE_CONVER_ENUM,
	
	/**
	 * 枚举转编码
	 */
	ENUM_CONVER_CODE,

	/**
	 * 枚举转说明
	 */
	ENUM_CONVER_DESC,
	
	/**
	 * 说明转枚举
	 */
	DESC_CONVER_ENUM,

	/**
	 * 时间转字符串
	 */
	DATE_CONVER_STRING,
	
	/**
	 * 字符串转时间
	 */
	STRING_CONVER_DATE,
	
	/**
	 * 属性复制
	 */
	COPY_PROPERTIES,
	
	DTO_CONVER_VO,
	
	VO_CONVER_DTO;

}
