package com.dj.domain.entity.player;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import com.dj.domain.base.BaseEntity;
import com.dj.domain.base.IEntity;
import com.dj.protobuf.showtable.ShowTableItem;
import com.dj.domain.util.DateUtil;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class PlayerShowTable extends BaseEntity {

	private static final long serialVersionUID = -8725006719511360484L;

	public PlayerShowTable(long roleID) {
		super(roleID);
	}

	private int itemID;

	private int type;

	private int page;

	private int index;

	private int x;

	private int y;


	/**
	 *	套装id
	 */
	private long suitID;

//	@Override
//	public String getPrimaryKeyName() {
//		return "roleID";
//	}
//
//	@Override
//	public Object getPrimaryKeyValue() {
//		return getRoleID();
//	}

	@Override
	public IEntity copy() {
		PlayerShowTable item = new PlayerShowTable();
		copySuper(item);
		item.setItemID(itemID);
		item.setType(type);
		item.setPage(page);
		item.setIndex(index);
		item.setX(x);
		item.setY(y);
		item.setSuitID(suitID);
		return item;
	}

	public ShowTableItem toShowTableItem(ShowTableItem.Builder builder, Date nowDate) {
		builder.setItemId(itemID);
		builder.setType(type);
		builder.setPage(page);
		builder.setIndex(index);
		builder.setX(x);
		builder.setY(y);
		if(type != 0) {
			int leaveSeconds = 0;
			Date leaveTime = DateUtil.plusTime(createTime, TimeUnit.DAYS, 1);
			if (nowDate.getTime() < leaveTime.getTime()) {
				leaveSeconds = DateUtil.secondsBetween(nowDate, leaveTime);
            }
			builder.setLeaveSeconds(leaveSeconds);
		}
		return builder.build();
	}
}