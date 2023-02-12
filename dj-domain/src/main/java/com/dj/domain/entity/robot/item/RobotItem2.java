package com.dj.domain.entity.robot.item;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 *	动物
 */
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class RobotItem2 extends RobotItem  {

	private static final long serialVersionUID = -138721412527726478L;

	public RobotItem2(long roleID) {
		super(roleID);
	}
}