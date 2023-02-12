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
public class AttrBill implements Comparable<AttrBill> {

	private String key;

	private long value;

	private ResourceBillEnum bill;

	private long time;

	@Override
	public int compareTo(AttrBill o) {
		long t = this.getTime() - o.getTime();
		if (t > 0) {
			return 1;
		}
		return -1;
	}
}
