package com.dj.domain.entity.player.item;

import com.dj.protobuf.item.GridItem;

public interface IPlayerItem{

	GridItem toGridItem(GridItem.Builder builder);

	//void setId(long id);
	
	int getItemID();

	long getItemCount();
	
	void setItemID(int value);
	
	void setItemCount(long value);
}