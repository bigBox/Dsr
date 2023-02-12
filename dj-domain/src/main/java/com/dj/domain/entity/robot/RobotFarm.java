package com.dj.domain.entity.robot;

import com.dj.domain.base.BaseEntity;
import com.dj.domain.base.IEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class RobotFarm extends BaseEntity {
	private static final long serialVersionUID = 6476001748195643970L;

	public RobotFarm(long roleID) {
		super(roleID);
	}

	private int x;

	private int y;

	private int seed;

	private Date plaintTime;

	@Override
	public IEntity copy() {
		RobotFarm item = new RobotFarm();
		copySuper(item);
		item.setX(x);
		item.setY(y);
		item.setSeed(seed);
		item.setPlaintTime(plaintTime);
		return item;
	}
}