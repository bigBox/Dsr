package com.dj.domain.util.math;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WeightRet<K> {
	// 键
	private K key;
	// 值
	private int value;
}
