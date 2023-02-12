package com.dj.tool.error;

public class ErrorCode {
	public static final int XDQ_BASE_CODE = 10000;

	@ErrorDesc(text = "成功")
	public static final int OK = 0;
	@ErrorDesc(text = "未知错误")
	public static final int SYSTEM_ERROR = -1;
	@ErrorDesc(text = "系统错误 参数不存在")
	public static final int SYSTEM_PARAM_ERROR = -2;
	@ErrorDesc(text = "系统错误 未知错误 库错误 JAVA错误")
	public static final int SYSTEM_INTERNAL_ERROR = -3;
	@ErrorDesc(text = "系统错误 Redis错误")
	public static final int SYSTEM_REDIS_ERROR = -4;
	@ErrorDesc(text = "系统错误 Mysql错误")
	public static final int SYSTEM_MYSQL_ERROR = -5;
	@ErrorDesc(text = "系统错误 config配置不存在")
	public static final int SYSTEM_CONFIG_NOT_EXISTS = -6;
	@ErrorDesc(text = "系统错误 save时出错")
	public static final int SYSTEM_SAVE_ERROR = -7;
	@ErrorDesc(text = "系统错误 服务器未开启")
	public static final int SYSTEM_AREA_SERVER_NOT_START = -8;
	@ErrorDesc(text = "系统错误 请求错误")
	public static final int SYSTEM_REQUEST_ERROR = -9;
	@ErrorDesc(text = "系统错误 加锁失败")
	public static final int SYSTEM_LOCK_FAILED = -10;
	@ErrorDesc(text = "系统错误 获取model实例错误")
	public static final int SYSTEM_GET_MODEL_ERROR = -11;
	@ErrorDesc(text = "系统错误 系统服务不可用")
	public static final int SYSTEM_SERVICE_DOWN = -12;

	@ErrorDesc(text = "数据错误")
	public static final int COMMON_DATA_ERROR = 1;
	@ErrorDesc(text = "配置数据错误")
	public static final int COMMON_CONFIG_ERROR = 2;
	@ErrorDesc(text = "未能处理的错误，错误提示%s")
	public static final int COMMON_OTHER_ERROR = 3;
	@ErrorDesc(text = "参数有误，请重试")
	public static final int COMMON_PARAM_ERROR = 4;
	@ErrorDesc(text = "请稍候重试！")
	public static final int COMMON_COOLING_DOWN = 5;

	@ErrorDesc(text = "未能识别您的信息")
	public static final int COMMON_PLAYER_NOT_FOUND = 100;
	@ErrorDesc(text = "金币不足 ")
	public static final int COMMON_PLAYER_GOLD_LESS = 101;
	@ErrorDesc(text = "钻石不足")
	public static final int COMMON_PLAYER_DIAMOND_LESS = 102;
	@ErrorDesc(text = "物品不足")
	public static final int COMMON_PLAYER_ITEM_LESS = 103;
	@ErrorDesc(text = "等级不足")
	public static final int COMMON_PLAYER_LEVEL_LESS = 104;
	@ErrorDesc(text = "体力不足")
	public static final int COMMON_PLAYER_STAMINA_LESS = 105;
	@ErrorDesc(text = "气力不足")
	public static final int COMMON_PLAYER_ACTION_LESS = 106;
	@ErrorDesc(text = "绿化值不足")
	public static final int COMMON_PLAYER_ECOLOGY_LESS = 107;
	@ErrorDesc(text = "商会贡献度不足")
	public static final int COMMON_PLAYER_GUILD_SCORE_LESS = 108;

	@ErrorDesc(text = "渠道编号不存在")
	public static final int CHANNEL_NOT_EXITS = XDQ_BASE_CODE + 1;
	@ErrorDesc(text = "账户已经存在")
	public static final int ACCOUNT_IS_EXITS = XDQ_BASE_CODE + 2;
	@ErrorDesc(text = "账户密码错误")
	public static final int ACCOUNT_PASS_ERROR = XDQ_BASE_CODE + 3;
	@ErrorDesc(text = "账户格式不合法")
	public static final int ACCOUNT_NAME_ILLEGAL = XDQ_BASE_CODE + 4;
	@ErrorDesc(text = "账户已被冻结")
	public static final int ACCOUNT_BLOCKED = XDQ_BASE_CODE + 5;
	@ErrorDesc(text = "请重新登陆")
	public static final int PLEASE_RELOGIN = XDQ_BASE_CODE + 6;
	@ErrorDesc(text = "身份证错误")
	public static final int IDCARD_ERROR = XDQ_BASE_CODE + 7;
	@ErrorDesc(text = "每日22时至次日8时，未成年人用户无法登陆游戏。", isShow = 0)
	public static final int ADDICTION_LIMIT_TIME = XDQ_BASE_CODE + 8;
	@ErrorDesc(text = "未成年人每日累计游戏时间不得超过1.5小时，法定节假日每日累计游戏时间不得超过3小时。", isShow = 0)
	public static final int ADDICTION_LIMIT_WEEK = XDQ_BASE_CODE + 9;
	@ErrorDesc(text = "姓名错误")
	public static final int ACCOUNT_NAME_ERROR = XDQ_BASE_CODE + 10;
	@ErrorDesc(text = "身份证已注册")
	public static final int IDCARD_IS_EXITS= XDQ_BASE_CODE + 11;

	@ErrorDesc(text = "不在矿区")
	public static final int NOT_IN_MINE_ROOM = XDQ_BASE_CODE + 20;

	@ErrorDesc(text = "账号长度不够")
	public static final int PLAYER_NAME_LENGTH_SHORT = XDQ_BASE_CODE + 54;
	@ErrorDesc(text = "账号已经存在")
	public static final int PLAYER_NAME_IS_EXITS = XDQ_BASE_CODE + 55;
	@ErrorDesc(text = "账号包含敏感词")
	public static final int PLAYER_NAME_IS_ILLEGAL = XDQ_BASE_CODE + 56;
	@ErrorDesc(text = "账号过长")
	public static final int PLAYER_NAME_IS_TOO_LONG = XDQ_BASE_CODE + 57;
	@ErrorDesc(text = "签名包含敏感词")
	public static final int PLAYER_SIGNATURE_IS_ILLEGAL = XDQ_BASE_CODE + 60;
	@ErrorDesc(text = "签名过长")
	public static final int PLAYER_SIGNATURE_IS_TOO_LONG = XDQ_BASE_CODE + 61;
	@ErrorDesc(text = "没有月卡，不能领取")
	public static final int REWARD_DRAW_NEED_MONTH_CARD = XDQ_BASE_CODE + 70;
	@ErrorDesc(text = "你搜索的不是同一个玩家，请重新输入")
	public static final int SEARCH_NOT_SAME_PLAYER = XDQ_BASE_CODE + 71;
	@ErrorDesc(text = "包含敏感字符，请重新输入")
	public static final int INPUT_WORD_IS_ILLEGAL = XDQ_BASE_CODE + 72;

	@ErrorDesc(text = "奖励已领取")
	public static final int REWARD_RECEIVED = XDQ_BASE_CODE + 100;
	@ErrorDesc(text = "任务未完成")
	public static final int TASK_NOT_FINISH = XDQ_BASE_CODE + 101;
	@ErrorDesc(text = "任务未接受")
	public static final int TASK_NOT_ACCEPT = XDQ_BASE_CODE + 102;
	@ErrorDesc(text = "成长任务一次只能接受一个")
	public static final int TASK_GROWUP_CANNT_TWO_ACCEPT = XDQ_BASE_CODE + 103;
	@ErrorDesc(text = "商会任务一次只能接受一个")
	public static final int TASK_GUILD_CANNT_TWO_ACCEPT = XDQ_BASE_CODE + 104;
	@ErrorDesc(text = "精灵不存在")
	public static final int SUMMON_NOT_EXIT = XDQ_BASE_CODE + 110;
	@ErrorDesc(text = "精灵正在旅行")
	public static final int SUMMON_SENDING = XDQ_BASE_CODE + 111;
	@ErrorDesc(text = "不能召唤精灵，请稍后重试")
	public static final int SUMMON_NOT = XDQ_BASE_CODE + 112;
	@ErrorDesc(text = "今天已点赞，明天再来吧")
	public static final int SUPPORT_LIMIT = XDQ_BASE_CODE + 113;
	@ErrorDesc(text = "没有奖励可领取")
	public static final int NO_REWARD_CAN_DRAW = XDQ_BASE_CODE + 114;
	@ErrorDesc(text = "今天已经给好友点赞两次了，明天再来吧")
	public static final int SUPPORT_TODAY_TWICE_LIMIT = XDQ_BASE_CODE + 115;
	@ErrorDesc(text = "不能投资，邮件个数已达上限")
	public static final int SUMMON_MAIL_LIMIT = XDQ_BASE_CODE + 116;
	@ErrorDesc(text = "自己捡漏时间未到")
	public static final int SUMMON_PICKUP_INVEST_REWARD_TIME_LIMIT = XDQ_BASE_CODE + 117;
	@ErrorDesc(text = "已捡漏")
	public static final int SUMMON_PICKUP_ED_INVEST_REWARD = XDQ_BASE_CODE + 118;
	@ErrorDesc(text = "精灵事件未处理完")
	public static final int SUMMON_EVENT_NOT_HANDLER = XDQ_BASE_CODE + 119;

	@ErrorDesc(text = "未加入探险社")
	public static final int GUILD_NO_JOIN = XDQ_BASE_CODE + 200;
	@ErrorDesc(text = "探险社名字存在")
	public static final int GUILD_NAME_HAS_EXIT = XDQ_BASE_CODE + 201;
	@ErrorDesc(text = "已加入探险社，不能再加入其它探险社")
	public static final int GUILD_HAS_JOIN = XDQ_BASE_CODE + 202;
	@ErrorDesc(text = "探险社不存在")
	public static final int GUILD_NOT_EXIT = XDQ_BASE_CODE + 203;
	@ErrorDesc(text = "探险社职位权限不够")
	public static final int GUILD_POST_NOT_ENOUGH = XDQ_BASE_CODE + 204;
	@ErrorDesc(text = "社长不能退，请先转让探险社")
	public static final int GUILD_CANNT_EXIT = XDQ_BASE_CODE + 205;

	@ErrorDesc(text = "不是空地")
	public static final int FARM_NOT_CLEARING = XDQ_BASE_CODE + 300;
	@ErrorDesc(text = "未成熟")
	public static final int FARM_NOT_RIPE = XDQ_BASE_CODE + 301;
	@ErrorDesc(text = "已经有植物了")
	public static final int PARK_CELL_HAS_PLANT = XDQ_BASE_CODE + 302;
	@ErrorDesc(text = "没有植物")
	public static final int PARK_CELL_NO_PLANT = XDQ_BASE_CODE + 303;
	@ErrorDesc(text = "绿化值不够")
	public static final int PARK_GREEN_NOT_ENOUGH = XDQ_BASE_CODE + 304;
	@ErrorDesc(text = "该物种数量已达上限")
	public static final int PARK_PLACE_LIMIT = XDQ_BASE_CODE + 305;
	@ErrorDesc(text = "领取蜂蜜CD中")
	public static final int PARK_HONEY_DRAW_CD = XDQ_BASE_CODE + 306;
	@ErrorDesc(text = "不能放置在无效区")
	public static final int PARK_CANT_PLACE_INVALID = XDQ_BASE_CODE + 307;

	@ErrorDesc(text = "该建筑接鸡蛋游戏CD中，请稍后再试")
	public static final int MEET_EGG_IN_CD = XDQ_BASE_CODE + 350;
	@ErrorDesc(text = "碰撞无效")
	public static final int MEET_ERROR = XDQ_BASE_CODE + 351;
	@ErrorDesc(text = "比赛时间结束")
	public static final int BATTLE_ROOM_TIME_STOP = XDQ_BASE_CODE + 352;
	@ErrorDesc(text = "该建筑已经是你本人占领了")
	public static final int BATTLE_BUILD_ME_HOLD = XDQ_BASE_CODE + 353;
	@ErrorDesc(text = "该建筑正在被攻占中")
	public static final int BATTLE_BUILD_IN_GAME = XDQ_BASE_CODE + 354;
	@ErrorDesc(text = "战斗CD中")
	public static final int BATTLE_ROLE_IN_CD = XDQ_BASE_CODE + 355;
	@ErrorDesc(text = "该建筑已经被占领了")
	public static final int BATTLE_BUILD_HAS_HOLD = XDQ_BASE_CODE + 356;
	@ErrorDesc(text = "该建筑无人占领")
	public static final int BATTLE_BUILD_NO_HOLD = XDQ_BASE_CODE + 357;
	@ErrorDesc(text = "未匹配")
	public static final int BATTLE_NO_MATCH = XDQ_BASE_CODE + 358;

	@ErrorDesc(text = "已被好友鉴定，请左右滑动与好友错开鉴定")
	public static final int TREASURE_IS_VERIFIED = XDQ_BASE_CODE + 370;
	@ErrorDesc(text = "你今天已帮小寻鉴定，明天再来")
	public static final int VERIFIY_XIAOXUN_TODAY = XDQ_BASE_CODE + 371;
	@ErrorDesc(text = "小寻今日已鉴定3次，累了，剩下宝贝请你的好友来看看吧")
	public static final int VERIFIY_AUTO_TODAY_LIMIT = XDQ_BASE_CODE + 372;
	@ErrorDesc(text = "你的等级已超过10级")
	public static final int VERIFIY_AUTO_LEVEL_LIMIT = XDQ_BASE_CODE + 373;
	@ErrorDesc(text = "你已经鉴定过此宝物")
	public static final int VERIFIY_ONCE_LIMIT = XDQ_BASE_CODE + 374;
	@ErrorDesc(text = "")//挖矿请求过快
	public static final int MINE_QUICK = XDQ_BASE_CODE + 380;
	@ErrorDesc(text = "未收集齐")
	public static final int COLLECTION_NOT_GATHER_ALL = XDQ_BASE_CODE + 390;
	@ErrorDesc(text = "没有此图鉴")
	public static final int BOOK_NO_HAVE = XDQ_BASE_CODE + 400;
	@ErrorDesc(text = "给好友留一点吧")
	public static final int FRIEND_LEAVE_LITTLE = XDQ_BASE_CODE + 410;
}
