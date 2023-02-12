package com.dj.domain.constant;

public final class ConstantGame {

	// 挖矿地图大小
	public static final int MINE_X = 28;
	public static final int MINE_Y = 28;
	// 古迹地图大小                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 
	public static final int ROB_X = 10;
	public static final int ROB_Y = 10;

	public static final int CELL_SIZE = 120;

	public static final int MINE_CELL_INIT_X_DIS = 60;
	public static final int MINE_CELL_INIT_Y_DIS = 60;

	public static final int DigUp = -1; // 挖完
	public static final int Unknown = 0; // 未知

	public static final int Land = 100; // 陆地
	public static final int Water = 200; // 水域
	public static final int Invalid = 99; //不可探险
	/**
	 *	古跡随机道具类型个数
	 */
	public static final int ROB_TYPE_COUNT = 5;

	/**
	 *	接鸡蛋游戏id
	 */
	public static final int MINI_GAME_EGG = 1;

	/**
	 *	生态园无效区xy坐标
	 */
	public static final int PARK_INVALID_XY = 2;
	public static final int PARK_INVALID_YX = 7;

	/**
	 *	生态园检查在无效区内
	 * 
	 * @return
	 */
	public static boolean checkInvalid(int x, int y) {
		// 在无效区
		//return (x <= ConstantGame.PARK_INVALID_YX && y <= ConstantGame.PARK_INVALID_XY) || (y <= ConstantGame.PARK_INVALID_YX && x <= ConstantGame.PARK_INVALID_XY);
		return false;
	}
	
	/**
	 *	鸡蛋
	 */
	public static final int EGG = 240060001;
	/**
	 *	金蛋
	 */
	public static final int GOLD_EGG = 249970001;
	/**
	 * 能量棒
	 */
	public static final int POWER_BAR = 609990003;
	/**
	 * 令牌
	 */
	public static final int TOKEN = 609990004;
	/**
	 * 铲子
	 */
	public static final int SHOVEL = 410250001;
	/**
	 * 改名卡
	 */
	public static final int CHANGE_NAME_CARD = 609990006;
	/**
	 * 金币id
	 */
	public static final int GOLD = 1;
	/**
	 * 钻石id
	 */
	public static final int DIAMOND = 2;
	
	// 未成年人每日累计游戏时间不得超过1.5小时，法定节假日每日累计游戏时间不得超过3小时。
	// 1.5小时对应的秒数
	public static int ADDICTION_90 = 90*60-3*60;
	// 3小时对应的秒数
	public static int ADDICTION_180 = 180*60-3*60;

	/**
	 * 挖矿塞外江南地图子碎片
	 */
	public static final int DIGGOLD_MAPPIECE = 104001;

	/**
	 * 户外地图宽度
	 */
	public static final int WORLD_MAP_WEIGHT = 1101;
	/**
	 * 户外地图高度
	 */
	public static final int WORLD_MAP_HEIGHT = 557;
	
	/**
	 * 投资事件
	 */
	public static final int SUMMON_INVEST_EVENT = 11;
}
