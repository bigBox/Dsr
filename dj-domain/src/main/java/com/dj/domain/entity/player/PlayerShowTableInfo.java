package com.dj.domain.entity.player;

import com.dj.domain.base.BaseEntity;
import com.dj.domain.base.IEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class PlayerShowTableInfo extends BaseEntity {

	private static final long serialVersionUID = -8725006742311360484L;

	public PlayerShowTableInfo(long roleID) {
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
		PlayerShowTableInfo item = new PlayerShowTableInfo();
		copySuper(item);
		item.setType(type);
		item.setPage(page);
		item.setInfo(info);
		return item;
	}
}