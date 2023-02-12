package com.dj.domain.log;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import com.dj.domain.base.Column;
import com.dj.domain.base.Entity;
import com.dj.domain.base.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity(fetch = Entity.FeatchType.START)
@Table(name = "log_login")
@TableName("log_login")
public class LogLogin extends AbsLog {

	/**
	 * @Field roleID
	 */
	@Column(name = "roleID")
	@TableField("roleID")
	private int roleID;
	/**
	 * @Field account
	 */
	@Column(name = "account")
	@TableField("account")
	private String account;
	/**
	 * @Field password
	 */
	@Column(name = "password")
	@TableField("password")
	private String password;
	/**
	 * @Field ip
	 */
	@Column(name = "ip")
	@TableField("ip")
	private String ip;
	/**
	 * @Field type
	 */
	@Column(name = "type")
	@TableField("type")
	private String type;
}