package com.dj.domain.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class BaseEvent implements IEvent{

	/**
	 * @Field roleID : 角色Id
	 */
	private long roleID;

	/**
	 * @Title reset
	 * @Description 重置事件对象属性 首先重置事件基类属性而后调用resetProperties方法重置子类属性
	 * @return void
	 */
	public void reset() {
		setRoleID(0L);
		resetProperties();
	}

	/**
	 * @Title resetProperties
	 * @Description 事件子类根据实际需求重置事件属性(一般设置为0、null等等)
	 * @return void
	 */
	protected abstract void resetProperties();
}
