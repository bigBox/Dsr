package com.dj.domain.entity.player;

import com.dj.domain.base.BaseEntity;
import com.dj.domain.base.IEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class PlayerCollection extends BaseEntity {
	private static final long serialVersionUID = 4011003393485889407L;

	public PlayerCollection(long roleID) {
		super(roleID);
	}

	private int collectionID;

	private int reward;

//	@Override
//	public String getPrimaryKeyName() {
//		return "collectionID";
//	}
//
//	@Override
//	public Object getPrimaryKeyValue() {
//		return collectionID;
//	}

	@Override
	public IEntity copy() {
		PlayerCollection item = new PlayerCollection();
		copySuper(item);
		item.setCollectionID(collectionID);
		item.setReward(reward);
		return item;
	}
}