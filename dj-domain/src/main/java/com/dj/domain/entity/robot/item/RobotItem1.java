package com.dj.domain.entity.robot.item;


import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 *	植物
 */
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class RobotItem1 extends RobotItem {

	private static final long serialVersionUID = -1387215546927726478L;

	public RobotItem1(long roleID) {
		super(roleID);
	}
}