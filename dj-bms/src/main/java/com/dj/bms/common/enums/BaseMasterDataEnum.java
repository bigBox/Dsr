package com.dj.bms.common.enums;

/**
 * @author zcq
 * @date 2020-02-10
 */
public interface BaseMasterDataEnum {

	Integer getCode();
	
	String getDesc();
	
	BaseMasterDataEnum codeOf(Integer code);
}
