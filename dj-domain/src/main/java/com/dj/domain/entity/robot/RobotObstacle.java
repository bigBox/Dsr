package com.dj.domain.entity.robot;

import com.dj.domain.base.BaseEntity;
import com.dj.domain.base.IEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class RobotObstacle extends BaseEntity {

	private static final long serialVersionUID = -4985852194154161976L;

	public RobotObstacle(long roleID) {
		super(roleID);
	}

	private int obstacleID;

	private int isOpen;
	
	@Override
	public IEntity copy() {
		RobotObstacle item = new RobotObstacle();
		copySuper(item);
		item.setObstacleID(obstacleID);
		item.setIsOpen(isOpen);
		return item;
	}
}