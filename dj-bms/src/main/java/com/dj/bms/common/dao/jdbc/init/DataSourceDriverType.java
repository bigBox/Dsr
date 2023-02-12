package com.dj.bms.common.dao.jdbc.init;

/**
 * 数据库驱动类型
 * @author: zcq
 * @date: 2019-12-14
 */
public enum DataSourceDriverType {

	MySQL("com.mysql.cj.jdbc.Driver"),
	
	H2("org.h2.Driver");
	
	private String driverClassName;

	private DataSourceDriverType(String driverClassName) {
		this.driverClassName = driverClassName;
	}

	public String getDriverClassName() {
		return driverClassName;
	}

}
