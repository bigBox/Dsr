package com.dj.domain.entity.player.item;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 *	食品
 */
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class PlayerItem3 extends PlayerItem  {

	private static final long serialVersionUID = -134321416927726478L;

	public PlayerItem3(long roleID) {
		super(roleID);
	}
}