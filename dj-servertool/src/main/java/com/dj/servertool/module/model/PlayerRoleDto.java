package com.dj.servertool.module.model;

import com.dj.protobuf.common.RoleInfo;
import lombok.Data;


@Data
public class PlayerRoleDto {

	private Long roleID;
	private String roleName;
	private Integer level;
	private Integer gold;
	private Integer diamond;
	private Integer ecology;
	private Integer guildId;
	private String signature;


	public RoleInfo toRoleInfo() {
		RoleInfo.Builder builder = RoleInfo.newBuilder();
		builder.setRoleId(roleID);
		builder.setRoleName(roleName);
		builder.setLevel(level);
		builder.setGold(gold);
		builder.setDiamond(diamond);
		builder.setEcology(ecology);
		builder.setGuildId(guildId);
		builder.setSignature(signature);
		return builder.build();
	}
}
