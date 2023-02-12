package com.dj.domain.entity.player.item;


import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 *	植物
 */
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class PlayerItem1 extends PlayerItem {

	private static final long serialVersionUID = -1386215546927726478L;

	public PlayerItem1(long roleID) {
		super(roleID);
	}
}