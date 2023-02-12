package com.dj.domain;

/**
 * 全局角色身份
 */
public class GlobalRoleID {

	public static long get() {
		return 1;
	}

	/**
	 * 小寻
	 * @return
	 */
	public static long getXiaoXun() {
		return 10;
	}
	
	/**
	 * 机器人-大寻
	 * @return
	 */
	public static long getRobot() {
		return 100;
	}

	public static String getXiaoXunRoleName() {
		return "小寻";
	}

	public static String getAdmin() {
		return "admin";
	}
	
	public static boolean isGlobalRoleID(long roleID) {
		if(roleID == getXiaoXun()) {
			return true;
		}
		if(roleID == getRobot()) {
			return true;
		}
		return false;
	}
}
