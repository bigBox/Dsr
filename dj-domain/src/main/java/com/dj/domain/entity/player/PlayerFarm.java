package com.dj.domain.entity.player;

import java.util.Date;

import com.dj.domain.base.BaseEntity;
import com.dj.domain.base.IEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class PlayerFarm extends BaseEntity {
	private static final long serialVersionUID = 6476001748195643970L;

	public PlayerFarm(long roleID) {
		super(roleID);
	}

	private int x;

	private int y;

	private int seed;

	private Date plaintTime;

	@Override
	public IEntity copy() {
		PlayerFarm item = new PlayerFarm();
		copySuper(item);
		item.setX(x);
		item.setY(y);
		item.setSeed(seed);
		item.setPlaintTime(plaintTime);
		return item;
	}
}