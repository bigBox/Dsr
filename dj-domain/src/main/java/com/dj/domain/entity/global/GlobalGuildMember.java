package com.dj.domain.entity.global;

import com.dj.domain.base.BaseEntity;
import com.dj.domain.base.IEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class GlobalGuildMember extends BaseEntity {
	private static final long serialVersionUID = -6468302116923354851L;

	public GlobalGuildMember(long roleID) {
		super(roleID);
	}

	private long guildID;

	private int post;

	@Override
	public String getPrimaryKeyName() {
		return "roleID";
	}

	@Override
	public Object getPrimaryKeyValue() {
		return roleID;
	}

	@Override
	public IEntity copy() {
		GlobalGuildMember member = new GlobalGuildMember();
		copySuper(member);
		member.setGuildID(guildID);
		member.setPost(post);
		return member;
	}
}