package com.dj.servertool.module.model;

import java.io.Serializable;

import lombok.Data;

/**
 * 字典信息
 */
@Data
public class DeptDto implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 主键id
	 */
	private Long deptId;
	/**
	 * 父部门id
	 */
	private Long pid;
	/**
	 * 父部门名称
	 */
	private String pName;
	/**
	 * 简称
	 */
	private String simpleName;
	/**
	 * 全称
	 */
	private String fullName;
	/**
	 * 描述
	 */
	private String description;
	/**
	 * 排序
	 */
	private Integer sort;
}
