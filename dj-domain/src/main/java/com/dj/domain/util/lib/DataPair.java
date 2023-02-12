package com.dj.domain.util.lib;

public class DataPair<T1,T2>{
	
	private T1 obj1 ;
	private T2 obj2 ;
	
	public DataPair(T1 obj1, T2 obj2) {
		this.obj1 = obj1;
		this.obj2 = obj2;
	}

	public T1 getObj1() {
		return obj1;
	}
	
	public T2 getObj2() {
		return obj2;
	}
	
	public void setObj1(T1 obj1) {
		this.obj1 = obj1;
	}
	
	public void setObj2(T2 obj2) {
		this.obj2 = obj2;
	}

	@Override
	public String toString() {
		return "DataPair [obj1=" + obj1 + ", obj2=" + obj2 + "]";
	}
	
	/**
	 * 利用一个元素生成这个对象
	 * @param t1
	 * @return
	 */
	public static final<T1,T2> DataPair<T1, T2> fromOne(T1 t1){
		return new DataPair<T1, T2>(t1, null);
	}

	/**
	 * 利用两个元素生成这个对象
	 * @param t1
	 * @param t2
	 * @return
	 */
	public static final <T1,T2> DataPair<T1, T2> fromTwo(T1 t1, T2 t2){
		return new DataPair<T1, T2>(t1, t2);
	}
}
