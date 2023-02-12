package com.dj.domain.entity.player.item;

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
public class PlayerItem5 extends PlayerItem{

	private static final long serialVersionUID = -1386214123927726478L;

	public PlayerItem5(long roleID) {
		super(roleID);
	}

	private int inVerifyCount;

	@Override
	public IEntity copy() {
		PlayerItem5 playerItem = new PlayerItem5(roleID);
		copySuper(playerItem);
		playerItem.setItemID(getItemID());
		playerItem.setItemCount(getItemCount());
		playerItem.setInVerifyCount(inVerifyCount);
		return playerItem;
	}
}