package com.dj.bms.common.vo;

import java.io.Serializable;

/**
 * VO 标记接口
 * 
 * @author zcq
 * @date 2020-01-14 
 * @since 3.0
 */
public interface BaseVO extends Serializable {

	/**
	 * 获取主键
	 * @return
	 */
	Integer getPrimaryKey();
	
	/**
	 * 设置主键
	 */
	void setPrimaryKey(Integer primaryKey);
	
}
