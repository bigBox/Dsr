package com.dj.domain.entity.robot.item;

import com.dj.protobuf.item.GridItem;

public interface IRobotItem {

	GridItem toGridItem(GridItem.Builder builder);
	
	int getItemID();
	long getItemCount();
	
	void setItemID(int value);
	
	void setItemCount(long value);
}