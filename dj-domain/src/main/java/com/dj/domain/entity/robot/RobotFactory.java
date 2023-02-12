package com.dj.domain.entity.robot;

import com.dj.domain.base.BaseEntity;
import com.dj.domain.base.IEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class RobotFactory extends BaseEntity {
	private static final long serialVersionUID = -13862141692887478L;
	private int factoryID;

	private int showLevel;

	private int pointX;

	private int pointY;

	public RobotFactory(long roleID) {
		super(roleID);
	}


	@Override
	public IEntity copy() {
		RobotFactory item = new RobotFactory(roleID);
		copySuper(item);
		item.setFactoryID(factoryID);
		item.setShowLevel(showLevel);
		item.setPointX(pointX);
		item.setPointY(pointY);
		return item;
	}
}