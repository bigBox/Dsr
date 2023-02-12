package com.dj.domain.entity.robot.item;

import com.dj.domain.base.IEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 *	收集品
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class RobotItem5 extends RobotItem{

	private static final long serialVersionUID = -1386284123927726478L;

	public RobotItem5(long roleID) {
		super(roleID);
	}

	private int inVerifyCount;

	@Override
	public IEntity copy() {
		RobotItem5 playerItem = new RobotItem5(roleID);
		copySuper(playerItem);
		playerItem.setItemID(getItemID());
		playerItem.setItemCount(getItemCount());
		playerItem.setInVerifyCount(inVerifyCount);
		return playerItem;
	}
}