package com.dj.domain.entity.robot.item;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 *	食品
 */
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class RobotItem3 extends RobotItem  {

	private static final long serialVersionUID = -134321416927726478L;

	public RobotItem3(long roleID) {
		super(roleID);
	}
}