package com.dj.domain.entity.player;

import com.dj.domain.base.IEntity;
import com.dj.domain.util.codec.Sha;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class PlayerAccount implements Serializable, IEntity {
	private static final long serialVersionUID = -132321416927726478L;
	/**
	 * @Field id : 自增id-主键
	 */
	protected long id;
	/**
	 * @Field account : 账户
	 */
	private String account;

	/**
	 * @Field password : 账户密码
	 */
	private String password;
	/**
	 * @Field nickname : 昵称
	 */
	private String nickname;
	/**
	 * @Field channel : 渠道
	 */
	private String channel;

	/**
	 * @Field lastLoginIp : 最后登录ip
	 */
	private String lastLoginIp;

	/**
	 * @Field registerTime : 注册时间
	 */
	private Date registerTime;
	/**
	 * @Field lastLoginTime : 最后登录时间
	 */
	private Date lastLoginTime;
	/**
	 * @Field registerIp : 注册ip
	 */
	private String registerIp;
	/**
	 * name
	 */
	private String name;
	/**
	 * 身份证
	 */
	private String idCard;
	/**
	 * 年龄
	 */
	private int age;
	/**
	 * 实名认证账号MD5值
	 */
	private String ai;
	/**
	 * 实名认证平台返回用户唯一ID
	 */
	private String pi;
	/**
	 * 实名验证会话ID
	 */
	private String si;
	/**
	* 是否第一次登陆
	*/
	private boolean firstLoginFlag;

	@Override
	public String getPrimaryKeyName() {
		return "id";
	}

	@Override
	public Object getPrimaryKeyValue() {
		return getId();
	}


	public PlayerAccount(long roleID, String account, String password, String nickname, String ip, String channel) {
		setId(roleID);
		setAccount(account);
		setPassword(Sha.getPassword(password));
		setRegisterIp(ip);
		setChannel(channel);
		setRegisterTime(new Date());
		setNickname(nickname);
		setName("");
		setIdCard("");
		setAge(0);
		setAi("");
		setPi("");
		setSi("");
	}

	@Override
	public IEntity copy() {
		PlayerAccount acc = new PlayerAccount();
		acc.setId(id);
		acc.setAccount(account);
		acc.setPassword(password);
		acc.setNickname(nickname);
		acc.setChannel(channel);
		acc.setLastLoginIp(lastLoginIp);
		acc.setLastLoginTime(lastLoginTime);
		acc.setRegisterIp(registerIp);
		acc.setRegisterTime(registerTime);
		acc.setName(name);
		acc.setIdCard(idCard);
		acc.setAge(age);
		acc.setAi(ai);
		acc.setPi(pi);
		acc.setSi(si);
		acc.setFirstLoginFlag(firstLoginFlag);
		return acc;
	}
}