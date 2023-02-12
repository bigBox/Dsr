package com.dj.domain.entity.robot.item;

import com.dj.domain.base.BaseEntity;
import com.dj.domain.base.IEntity;
import com.dj.protobuf.datetime.DateTime;
import com.dj.protobuf.item.GridItem;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


/**
 *	植物
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class RobotItem extends BaseEntity implements IRobotItem, Comparable<RobotItem>{

	private static final long serialVersionUID = -237621416927726478L;

	public RobotItem(long roleID) {
		super(roleID);
	}

	private int itemID;

	private long itemCount;

	@Override
	public IEntity copy() {
		RobotItem playerItem = new RobotItem();
		copySuper(playerItem);
		playerItem.setItemID(getItemID());
		playerItem.setItemCount(getItemCount());
		return playerItem;
	}

	@Override
	public GridItem toGridItem(GridItem.Builder builder) {
		builder.setItemId(itemID);
		builder.setCount((int)itemCount);
		builder.setEffectsId(0);
		builder.setEffectsLevel(0);
		builder.setEffectsPosition(0);
		builder.setUpdateTime(DateTime.newBuilder().setValue(updateTime.getTime()));
		return builder.build();
	}

	@Override
	public int compareTo(RobotItem o) {
		return Long.valueOf(this.id - o.getId()).intValue();
	}
}