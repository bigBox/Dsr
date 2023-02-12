package com.dj.domain.enums;

public enum TaskState {
	/**
	 *	已撕毁
	 */
	teared(-1),
	/**
	 *	未接受
	 */
	noAccept(0),
	/**
	 *	已接受
	 */
	accept(1),
	/**
	 *	已完成
	 */
	complete(2),
	/**
	 *	已领取
	 */
	award(3);

	private int state;

	TaskState(int state) {
		this.state = state;
	}

	public int getState() {
		return this.state;
	}
}
