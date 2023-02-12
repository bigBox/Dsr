package com.dj.domain.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BasePlayer {

	// 角色id
	private long roleID;

	// 网关id
	private String gate;
}
