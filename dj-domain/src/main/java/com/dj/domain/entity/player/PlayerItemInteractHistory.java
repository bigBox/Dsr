package com.dj.domain.entity.player;

import com.dj.domain.base.BaseEntity;
import com.dj.domain.base.IEntity;
import com.dj.protobuf.common.BaseRoleInfo;
import com.dj.protobuf.datetime.DateTime;
import com.dj.protobuf.item.ItemInteractHistory;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class PlayerItemInteractHistory extends BaseEntity implements Comparable<PlayerItemInteractHistory> {

	private static final long serialVersionUID = 1972260047008307528L;

	public PlayerItemInteractHistory(long roleID) {
		super(roleID);
	}

	private int itemID;
	private long itemCount;

	/**
	 * 鉴定人
	 */
	private long interactRoleID;

	/**
	 * 备注
	 */
	private String ps;

//	@Override
//	public String getPrimaryKeyName() {
//		return "itemID";
//	}
//
//	@Override
//	public Object getPrimaryKeyValue() {
//		return itemID;
//	}


	@Override
	public IEntity copy() {
		PlayerItemInteractHistory item = new PlayerItemInteractHistory();
		copySuper(item);
		item.setItemID(itemID);
		item.setItemCount(itemCount);
		item.setInteractRoleID(interactRoleID);
		item.setPs(ps);
		return item;
	}
	
	@Override
	public int compareTo(PlayerItemInteractHistory history) {
		return Long.valueOf(this.id - history.getId()).intValue();
	}

	public ItemInteractHistory toItemInteractHistory(ItemInteractHistory.Builder history, BaseRoleInfo roleInfo) {
		history.setInteractRoleInfo(roleInfo);
		history.setItemID(itemID);
		history.setItemCount((int)itemCount);
		history.setPs(ps);
		history.setInteractTime(DateTime.newBuilder().setValue(createTime.getTime()).build());
		return history.build();
	}
}