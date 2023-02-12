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
public class PlayerManufacture extends BaseEntity implements Comparable<PlayerManufacture> {
	private static final long serialVersionUID = -250224415765163118L;

	public PlayerManufacture(long roleID) {
		super(roleID);
	}

	private int factoryID;

	private int recipeID;

	private int makingTime;

	private Date startTime;

	private int state;

//	@Override
//	public String getPrimaryKeyName() {
//		return "factoryID";
//	}
//
//	@Override
//	public Object getPrimaryKeyValue() {
//		return factoryID;
//	}

	@Override
	public IEntity copy() {
		PlayerManufacture item = new PlayerManufacture();
		copySuper(item);
		item.setFactoryID(factoryID);
		item.setRecipeID(recipeID);
		item.setMakingTime(makingTime);
		item.setStartTime(startTime);
		item.setState(state);
		return item;
	}

	@Override
	public int compareTo(PlayerManufacture o) {
		return Long.valueOf(this.id - o.getId()).intValue();
	}
}