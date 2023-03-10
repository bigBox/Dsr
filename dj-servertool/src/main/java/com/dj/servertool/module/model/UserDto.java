package com.dj.servertool.module.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

/**
 * 用户传输bean
 */
@Data
public class UserDto {

	private Long userId;
	private String account;
	private String password;
	private String name;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birthday;
	private String sex;
	private String email;
	private String phone;
	private String roleId;
	private Long deptId;
	private String status;
	private String avatar;

}
