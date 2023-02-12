package com.dj.domain.entity.player;

import com.dj.domain.base.BaseEntity;
import com.dj.domain.base.IEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class PlayerBook extends BaseEntity {
	private static final long serialVersionUID = 2732478746566245923L;

	public PlayerBook(long roleID) {
		super(roleID);
	}

	private int type;

	private int bookID;

	private int itemID;

	private int state;
	
	private int reward;

//	@Override
//	public String getPrimaryKeyName() {
//		return "bookID";
//	}
//
//	@Override
//	public Object getPrimaryKeyValue() {
//		return bookID;
//	}

	@Override
	public IEntity copy() {
		PlayerBook item = new PlayerBook();
		copySuper(item);
		item.setType(type);
		item.setBookID(bookID);
		item.setItemID(itemID);
		item.setState(state);
		item.setReward(reward);
		return item;
	}
}