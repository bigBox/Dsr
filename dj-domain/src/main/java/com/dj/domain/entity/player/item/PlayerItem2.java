package com.dj.domain.entity.player.item;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 *	动物
 */
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class PlayerItem2 extends PlayerItem  {

	private static final long serialVersionUID = -138621412527726478L;

	public PlayerItem2(long roleID) {
		super(roleID);
	}
}