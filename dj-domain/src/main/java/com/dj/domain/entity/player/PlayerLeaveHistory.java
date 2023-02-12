package com.dj.domain.entity.player;

import java.util.Date;

import com.dj.domain.base.BaseEntity;
import com.dj.domain.base.IEntity;
import com.dj.protobuf.character.LeaveHistory;
import com.dj.protobuf.datetime.DateTime;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class PlayerLeaveHistory extends BaseEntity implements Comparable<PlayerLeaveHistory> {

	private static final long serialVersionUID = 5439242001717248014L;

	public PlayerLeaveHistory(long roleID) {
		super(roleID);
	}

	private int type;
	private int leaveID;
	private Date placeTime;

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
		PlayerLeaveHistory item = new PlayerLeaveHistory();
		copySuper(item);
		item.setType(type);
		item.setLeaveID(leaveID);
		item.setPlaceTime(placeTime);
		return item;
	}
	
	@Override
	public int compareTo(PlayerLeaveHistory history) {
		return Long.valueOf(this.id - history.getId()).intValue();
	}
	
	public LeaveHistory toLeaveHistory(LeaveHistory.Builder history) {
		history.setLeaveID(leaveID);
		history.setLeaveTime(DateTime.newBuilder().setValue(createTime.getTime()).build());
		return history.build();
	}
}