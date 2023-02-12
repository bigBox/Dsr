package com.dj.domain.entity.player;

import com.dj.domain.base.BaseEntity;
import com.dj.domain.base.IEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class PlayerNpc extends BaseEntity {

	private static final long serialVersionUID = 6166199058278270170L;

	public PlayerNpc(long roleID) {
		super(roleID);
	}

	private int npcID;

	private int visitValue;
	
//	@Override
//	public String getPrimaryKeyName() {
//		return "npcID";
//	}
//
//	@Override
//	public Object getPrimaryKeyValue() {
//		return npcID;
//	}
	
	@Override
	public IEntity copy() {
		PlayerNpc item = new PlayerNpc();
		copySuper(item);
		item.setNpcID(npcID);
		item.setVisitValue(visitValue);
		return item;
	}
}