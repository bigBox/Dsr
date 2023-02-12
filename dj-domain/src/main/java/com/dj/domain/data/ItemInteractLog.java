package com.dj.domain.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ItemInteractLog implements Comparable<ItemInteractLog> {

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
	
	private long time;
	
	@Override
	public int compareTo(ItemInteractLog o) {
		long t = this.getTime() - o.getTime();
		if(t > 0) {
			return 1;
		}
		return -1;
	}
}
