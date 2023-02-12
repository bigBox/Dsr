package com.dj.domain.entity.player.item;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class PlayerItem4 extends PlayerItem  {

	private static final long serialVersionUID = -1386214169277252578L;

	public PlayerItem4(long roleID) {
		super(roleID);
	}
}