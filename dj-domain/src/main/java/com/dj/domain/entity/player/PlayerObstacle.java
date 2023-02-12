package com.dj.domain.entity.player;

import com.dj.domain.base.BaseEntity;
import com.dj.domain.base.IEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class PlayerObstacle extends BaseEntity {

	private static final long serialVersionUID = -4995852194154161976L;

	public PlayerObstacle(long roleID) {
		super(roleID);
	}

	private int obstacleID;

	private int isOpen;
	
	@Override
	public IEntity copy() {
		PlayerObstacle item = new PlayerObstacle();
		copySuper(item);
		item.setObstacleID(obstacleID);
		item.setIsOpen(isOpen);
		return item;
	}
}