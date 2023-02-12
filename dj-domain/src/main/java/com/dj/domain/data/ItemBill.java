package com.dj.domain.data;

import com.dj.domain.enums.ResourceBillEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ItemBill implements Comparable<ItemBill>{

	private int itemID;

	private long itemCount;
	
	private ResourceBillEnum bill;
	
	private boolean post2Client;
	private boolean visible;

	private long time;
	
	@Override
	public int compareTo(ItemBill o) {
		long t = this.getTime() - o.getTime();
		if(t > 0) {
			return 1;
		}
		return -1;
	}
}
