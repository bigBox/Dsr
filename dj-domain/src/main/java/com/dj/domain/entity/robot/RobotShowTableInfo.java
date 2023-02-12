package com.dj.domain.entity.robot;

import com.dj.domain.base.BaseEntity;
import com.dj.domain.base.IEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class RobotShowTableInfo extends BaseEntity {

	private static final long serialVersionUID = -8725006742311360484L;

	public RobotShowTableInfo(long roleID) {
		super(roleID);
	}

	private int type;

	private int page;

	/**
	 *	套装id
	 */
	private String info;

	@Override
	public IEntity copy() {
		RobotShowTableInfo item = new RobotShowTableInfo();
		copySuper(item);
		item.setType(type);
		item.setPage(page);
		item.setInfo(info);
		return item;
	}
}