package com.dj.domain.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 *	好友相关行为
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class FriendAction {

	private long id;

	private long roleID;
	
	private long applyTime;
	
	private int applyType;

	/**
	 * 1添加，0删除
	 */
	private int action;
}
