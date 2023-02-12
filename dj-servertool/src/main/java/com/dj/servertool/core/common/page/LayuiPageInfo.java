package com.dj.servertool.core.common.page;

import java.util.List;

import lombok.Data;

/**
 * 分页结果的封装(for Layui Table)
 */
@Data
public class LayuiPageInfo {

	private Integer code = 0;

	private String msg = "请求成功";

	@SuppressWarnings("rawtypes")
	private List data;

	private long count;

}
