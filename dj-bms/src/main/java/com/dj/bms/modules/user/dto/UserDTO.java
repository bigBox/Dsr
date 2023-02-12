package com.dj.bms.modules.user.dto;

import java.util.Date;
import java.util.List;

import com.dj.bms.common.annotation.DTO2VO;
import com.dj.bms.common.dto.BaseDTO;
import com.dj.bms.common.enums.ConverPolicy;
import com.dj.bms.modules.role.dto.RoleDTO;

/**
 * @author zcq
 * 2018年5月5日
 * 下午8:46:50
 * 用户实体
 * Table: root_user
 */
public class UserDTO implements BaseDTO {

	private static final long serialVersionUID = 8303601775999413679L;

	/**
	 * 用户标识
	 */
	private Integer userId;
	/**
	 * 用户UID
	 */
	private String userUid;
	/**
	 * 用户昵称
	 */
	private String userName;
	
	/**
	 * 用户密码
	 */
	private String password;
	
	/**
	 * 用户性别
	 */
	private String userSex;
	
	/**
	 * 用户地址
	 */
	private String userAddr;
	
	/**
	 * 积分
	 */
	private Integer score;
	
	/**
	 * 头像
	 */
	private String avatar;
	
	/**
	 * 邮箱
	 */
	private String email;
	
	/**
	 * 个人主页
	 */
	private String url;
	
	/**
	 * 个性签名
	 */
	private String signature;
	
	/**
	 * 第三方账户ID
	 */
	private String thirdId;
	
	/**
	 * 邮箱是否接收社区消息
	 */
	private Boolean receiveMsg;
	
	/**
	 * 创建时间
	 */
	@DTO2VO(targets = {"createDate"}, policy = ConverPolicy.DATE_CONVER_STRING)
	private Date createDate;
	
	/**
	 * 修改时间
	 */
	@DTO2VO(targets = {"updateDate"}, policy = ConverPolicy.DATE_CONVER_STRING)
	private Date updateDate;
	
	/**
	 * 禁用 0：默认 1：禁用
	 */
	private Boolean isLocked;
	
	/**
	 * 第三方登录获取的access_token
	 */
	private String thirdAccessToken;
	
	/**
	 * 用户状态 1000:有效 1100:无效 1200:未生效
	 */
	private String statusCd;
	
	/**
	 * 用户登入ip
	 */
	private String loginIp;
	
	/**
	 * 用户最后登入ip
	 */
	private String lastLoginIp;
	
	/**
	 * 用户类型 0:超级管理员 1:版主 2:普通用户
	 */
	private String userType;
	
	/**
	 * 备注
	 */
	private String remark;
	
	/**
	 * 角色
	 */
	private List<RoleDTO> roleDTOs;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserUid() {
		return userUid;
	}

	public void setUserUid(String userUid) {
		this.userUid = userUid;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserSex() {
		return userSex;
	}

	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}

	public String getUserAddr() {
		return userAddr;
	}

	public void setUserAddr(String userAddr) {
		this.userAddr = userAddr;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public String getThirdId() {
		return thirdId;
	}

	public void setThirdId(String thirdId) {
		this.thirdId = thirdId;
	}

	public Boolean getReceiveMsg() {
		return receiveMsg;
	}

	public void setReceiveMsg(Boolean receiveMsg) {
		this.receiveMsg = receiveMsg;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Boolean getIsLocked() {
		return isLocked;
	}

	public void setIsLocked(Boolean isLocked) {
		this.isLocked = isLocked;
	}

	public String getThirdAccessToken() {
		return thirdAccessToken;
	}

	public void setThirdAccessToken(String thirdAccessToken) {
		this.thirdAccessToken = thirdAccessToken;
	}

	public String getStatusCd() {
		return statusCd;
	}

	public void setStatusCd(String statusCd) {
		this.statusCd = statusCd;
	}

	public String getLoginIp() {
		return loginIp;
	}

	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}

	public String getLastLoginIp() {
		return lastLoginIp;
	}

	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public List<RoleDTO> getRoleDTOs() {
		return roleDTOs;
	}

	public void setRoleDTOs(List<RoleDTO> roleDTOs) {
		this.roleDTOs = roleDTOs;
	}

	@Override
	public String toString() {
		return "UserDTO [userId=" + userId + ", userName=" + userName + ", password=" + password + ", userSex="
				+ userSex + ", userAddr=" + userAddr + ", score=" + score + ", avatar=" + avatar + ", email=" + email
				+ ", url=" + url + ", signature=" + signature + ", thirdId=" + thirdId + ", receiveMsg=" + receiveMsg
				+ ", createDate=" + createDate + ", updateDate=" + updateDate + ", isLocked=" + isLocked
				+ ", thirdAccessToken=" + thirdAccessToken + ", statusCd=" + statusCd + ", loginIp=" + loginIp
				+ ", lastLoginIp=" + lastLoginIp + ", userType=" + userType + ", remark=" + remark + ", roleDTOs="
				+ roleDTOs + "]";
	}
	
}
