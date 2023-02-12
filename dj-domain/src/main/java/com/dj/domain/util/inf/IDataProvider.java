package com.dj.domain.util.inf;

public interface IDataProvider <R,P> {

	/**
	 * 根据param 返回一个 结果
	 * @param param     参数
	 * @return
	 */
	R getData( P param ) ;

	/**
	 * 2参数获得一个R 
	 * @param param
	 * @param object
	 * @return
	 */
	default R getData(P param , Object object) { return null ; }
}
