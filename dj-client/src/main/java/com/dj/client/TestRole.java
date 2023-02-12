package com.dj.client;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class TestRole {

	private String account;
	private String password;
	private int level;
	private int age;
	private String idCard;
	
	
	public TestRole(String account, String password, int level, int age) {
		this.setAccount(account);
		this.setPassword(password);
		this.setLevel(level);
		this.setAge(age);
		int year = 2020-age;
		this.setIdCard("346688"+year+"06061100");
	}
}
