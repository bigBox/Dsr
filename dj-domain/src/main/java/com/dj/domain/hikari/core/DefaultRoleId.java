package com.dj.domain.hikari.core;

import java.io.Serializable;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DefaultRoleId implements Serializable {
	private static final long serialVersionUID = 4886721295480965055L;

	@Getter
	private final static DefaultRoleId instance = new DefaultRoleId();
}
