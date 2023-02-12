package com.dj.protobuf;

public final class ProtobufCmd {

	// 通知客户端需要多久发一次心跳吧
	public static final int SERVER_HEARTBEATCFG_NTF = 0x4109;
	// 客户端发送心跳包
	public static final int SERVER_HEARTBEAT_INFO = 0x410a;
	// 心跳包返回
	public static final int SERVER_HEARTBEAT_INFO_RSP = 0x410c;
	// 玩家登出
	public static final int SERVER_PLAYER_LOGOUT_REQ = -0x90;
	// 游戏登出
	public static final int SERVER_GAME_LOGOUT_REQ = -0x91;
	// 聊天响应
	public static final int SERVER_FORWARD_CHAT_SEND_NTF = -0x95;
	// 注冊玩家服
	public static final int SERVER_REGISTER_GATE2PLAYER_REQ = -0x101;
	public static final int SERVER_REGISTER_GATE2PLAYER_RSP = -0x102;
	// 玩家服心跳
	public static final int SERVER_KEEPALIVE4PLAYER_REQ = -0x103;
	public static final int SERVER_KEEPALIVE4PLAYER_RSP = -0x104;

	// 玩家初始化内网转发
	public static final int SERVER_FORWARD_PLAYER_INIT_REQ = -0x105;
	public static final int SERVER_FORWARD_PLAYER_INIT_RSP = -0x106;
	// 玩家基本内网转发
	public static final int SERVER_FORWARD_PLAYER_BASIC_REQ = -0x107;
	public static final int SERVER_FORWARD_PLAYER_BASIC_RSP = -0x108;

	// 玩家好友内网转发
	public static final int SERVER_FORWARD_PLAYER_FRIEND_REQ = -0x109;
	public static final int SERVER_FORWARD_PLAYER_FRIEND_RSP = -0x110;

	// 玩家主页内网转发
	public static final int SERVER_FORWARD_PLAYER_HOME_REQ = -0x111;
	public static final int SERVER_FORWARD_PLAYER_HOME_RSP = -0x112;

	// 单人游戏内网转发
	public static final int SERVER_FORWARD_PLAYER_SINGLE_REQ = -0x113;
	public static final int SERVER_FORWARD_PLAYER_SINGLE_RSP = -0x114;

	// 玩家GM内网转发
	public static final int SERVER_FORWARD_PLAYER_GM_REQ = -0x117;
	public static final int SERVER_FORWARD_PLAYER_GM_RSP = -0x118;

	// 玩家微信支付内网转发
	public static final int SERVER_FORWARD_PLAYER_WECHATPAY_REQ = -0x119;
	public static final int SERVER_FORWARD_PLAYER_WECHATPAY_RSP = -0x120;

	// 注冊游戏服
	public static final int SERVER_REGISTER_GATE2GAME_REQ = -0x151;
	public static final int SERVER_REGISTER_GATE2GAME_RSP = -0x152;
	// 游戏服心跳
	public static final int SERVER_KEEPALIVE4GAME_REQ = -0x153;
	public static final int SERVER_KEEPALIVE4GAME_RSP = -0x154;

	// 游戏主页内网转发
	public static final int SERVER_FORWARD_GAMEHOME_REQ = -0x155;
	public static final int SERVER_FORWARD_GAMEHOME_RSP = -0x156;
	// 多人游戏内网转发
	public static final int SERVER_FORWARD_GAMEMULTI_REQ = -0x157;
	public static final int SERVER_FORWARD_GAMEMULTI_RSP = -0x158;
	// 生态园内网转发
	public static final int SERVER_FORWARD_GAMEPARK_REQ = -0x159;
	public static final int SERVER_FORWARD_GAMEPARK_RSP = -0x160;
	// 小游戏内网转发
	public static final int SERVER_FORWARD_GAMEMINI_REQ = -0x161;
	public static final int SERVER_FORWARD_GAMEMINI_RSP = -0x162;
	// 注冊全局服
	public static final int SERVER_REGISTER_GATE2GLOBAL_REQ = -0x201;
	public static final int SERVER_REGISTER_GATE2GLOBAL_RSP = -0x202;
	// 全局服心跳
	public static final int SERVER_KEEPALIVE4GLOBAL_REQ = -0x203;
	public static final int SERVER_KEEPALIVE4GLOBAL_RSP = -0x204;

	// 全局排行内网转发
	public static final int SERVER_FORWARD_GLOBALRANK_REQ = -0x205;
	public static final int SERVER_FORWARD_GLOBALRANK_RSP = -0x206;
	// 全局商会内网转发
	public static final int SERVER_FORWARD_GLOBALGUILD_REQ = -0x207;
	public static final int SERVER_FORWARD_GLOBALGUILD_RSP = -0x208;
	// 全局商会战斗内网转发
	public static final int SERVER_FORWARD_GLOBALGUILDBATTLE_REQ = -0x209;
	public static final int SERVER_FORWARD_GLOBALGUILDBATTLE_RSP = -0x210;

	// 更新配置
	public static final int SERVER_UPDATE_CONFIG_REQ = 0x100;
	public static final int SERVER_UPDATE_CONFIG_RSP = 0x101;
	// 更新玩家服配置
	public static final int SERVER_UPDATE_CONFIG_4PLAYER_REQ = -0x253;
	public static final int SERVER_UPDATE_CONFIG_4PLAYER_RSP = -0x254;
	// 更新游戏服配置
	public static final int SERVER_UPDATE_CONFIG_4GAME_REQ = -0x255;
	public static final int SERVER_UPDATE_CONFIG_4GAME_RSP = -0x256;
	// 更新全局服配置
	public static final int SERVER_UPDATE_CONFIG_4GLOBAL_REQ = -0x257;
	public static final int SERVER_UPDATE_CONFIG_4GLOBAL_RSP = -0x258;
	// 更新逻辑服配置
	public static final int SERVER_UPDATE_CONNECT_LOGIC_REQ = 0x102;
	public static final int SERVER_UPDATE_CONNECT_LOGIC_RSP = 0x103;

	// 获取玩家道具
	public static final int SERVER_READ_PLAYER_ITEM_REQ = 0x104;
	public static final int SERVER_READ_PLAYER_ITEM_RSP = 0x105;

	// ===============================client====================================
	// 获取手机号登陆的短信验证码
	public static final int CLIENT_CREATE_SMS_CODE_REQ = 0x4303;
	public static final int CLIENT_CREATE_SMS_CODE_RSP = 0x4304;
	// 忘记密码时手机号验证短信验证码
	public static final int CLIENT_VERIFY_SMS_CODE_REQ = 0x4305;
	public static final int CLIENT_VERIFY_SMS_CODE_RSP = 0x4306;
	// 忘记密码后重设密码
	public static final int CLIENT_RESET_PASSWORD_REQ = 0x4307;
	public static final int CLIENT_RESET_PASSWORD_RSP = 0x4308;

	// 创建账号
	public static final int CLIENT_CREATE_ACCOUNT_REQ = 0x430a;
	public static final int CLIENT_CREATE_ACCOUNT_RSP = 0x430b;
	// 登录
	public static final int CLIENT_LOGIN_USERLOGIN_REQ = 0x4301;
	public static final int CLIENT_LOGIN_USERLOGIN_RSP = 0x4302;
	// 重新登录
	public static final int CLIENT_LOGIN_RELOGIN_REQ = 0x430e;
	public static final int CLIENT_LOGIN_RELOGIN_RSP = 0x430f;
	// 推送登陆角色属性
	public static final int CLIENT_LOGIN_ROLE_LOGIN_NTF = 0x430c;
	// 服务器停服维护
	public static final int CLIENT_SERVER_STOP_NTF = 0x430d;
	// 通知关闭论坛
	public static final int CLIENT_CLOSE_BBS_NTF = 0x4310;
	// 通知被踢出游戏
	public static final int CLIENT_KICK_OUT_GAME_NTF = 0x4311;
	// 实名认证
	public static final int REAL_NAME_AUTH_REQ = 0x4312;
	public static final int REAL_NAME_AUTH_RSP = 0x4313;
	// 改名请求
	public static final int CLIENT_CHANGE_NAME_REQ = 0x5201;
	public static final int CLIENT_CHANGE_NAME_RSP = 0x5202;
	// 修改个人签名
	public static final int CLIENT_CHANGE_SIGNATURE_REQ = 0x5203;
	public static final int CLIENT_CHANGE_SIGNATURE_RSP = 0x5204;
	// 修改客戶端数据
	public static final int CLIENT_CHANGE_CLIENT_DATA_REQ = 0x5205;
	public static final int CLIENT_CHANGE_CLIENT_DATA_RSP = 0x5206;
	// 使用能量棒加体力
	public static final int CLIENT_USE_POWER_BAR_ADD_STAMINA_REQ = 0x520e;
	public static final int CLIENT_USE_POWER_BAR_ADD_STAMINA_RSP = 0x520f;
	// 校验敏感词
	public static final int CLIENT_CHECK_WORD_REQ = 0x5210;
	public static final int CLIENT_CHECK_WORD_RSP = 0x5211;
	// 获取离开记录
	public static final int CLIENT_LEAVE_HISTORY_REQ = 0x5212;
	public static final int CLIENT_LEAVE_HISTORY_RSP = 0x5213;
	// 月卡
	public static final int CLIENT_MONTH_CARD_REQ = 0x7201;
	public static final int CLIENT_MONTH_CARD_NTF = 0x7202;
	// 领取月卡奖励
	public static final int CLIENT_MONTH_CARD_DRAW_REQ = 0x7203;
	public static final int CLIENT_MONTH_CARD_DRAW_RSP = 0x7204;

	// 属性值同步客户端完成
	public static final int CLIENT_PLAYER_ATTR_CLIENT_NTF_FINISH = 0x0907;
	// 属性值同步客户端
	public static final int CLIENT_PLAYER_ATTR_CLIENT_NTF = 0x903;

	// 物品列表
	public static final int CLIENT_ITEM_LIST_REQ = 0x4701;
	public static final int CLIENT_ITEM_LIST_RSP = 0x4702;
	// 删除物品
	public static final int CLIENT_ITEM_REMOVE_REQ = 0x4705;
	public static final int CLIENT_ITEM_REMOVE_RSP = 0x4706;
	// 和好友互动物品
	public static final int CLIENT_ITEM_INTERACT_REQ = 0x4707;
	public static final int CLIENT_ITEM_INTERACT_RSP = 0x4708;
	// 道具变更推送
	public static final int CLIENT_ITEM_UPDATE_NTF = 0x4709;
	// 获取好友家道具数量
	public static final int CLIENT_ITEM_FRIEND_REQ = 0x4710;
	public static final int CLIENT_ITEM_FRIEND_RSP = 0x4711;
	// 和好友互动物品历史记录
	public static final int CLIENT_ITEM_INTERACT_HISTORY_REQ = 0x4712;
	public static final int CLIENT_ITEM_INTERACT_HISTORY_RSP = 0x4713;
	// 获取玩家宝藏地图数量
	public static final int CLIENT_PLAYER_MAP_ITEM_REQ = 0x4714;
	public static final int CLIENT_PLAYER_MAP_ITEM_RSP = 0x4715;

	// 建筑位置
	public static final int CLIENT_SCENE_POS_REQ = 0x4292;
	public static final int CLIENT_SCENE_POS_RSP = 0x4293;
	// 建筑位置更新
	public static final int CLIENT_SCENE_POS_UPDATE_REQ = 0x4294;
	public static final int CLIENT_SCENE_POS_UPDATE_RSP = 0x4295;

	// 好友列表
	public static final int CLIENT_FRIEND_LIST_REQ = 0x6801;
	public static final int CLIENT_FRIEND_LIST_RSP = 0x6802;
	// 好友申请
	public static final int CLIENT_FRIEND_APPLY_REQ = 0x680b;
	public static final int CLIENT_FRIEND_APPLY_RSP = 0x680c;
	// 好友申请通知
	public static final int CLIENT_FRIEND_APPLY_NTF = 0x6815;
	// 好友批准
	public static final int CLIENT_FRIEND_APPROVE_REQ = 0x680d;
	public static final int CLIENT_FRIEND_APPROVE_RSP = 0x680e;
	// 好友批准通知
	public static final int CLIENT_FRIEND_APPROVE_NTF = 0x6827;
	// 好友移除
	public static final int CLIENT_FRIEND_REMOVE_REQ = 0x6809;
	public static final int CLIENT_FRIEND_REMOVE_RSP = 0x680a;
	// 好友查找
	public static final int CLIENT_FRIEND_SEARCH_REQ = 0x6810;
	public static final int CLIENT_FRIEND_SEARCH_RSP = 0x6811;
	// 好友推荐
	public static final int CLIENT_FRIEND_RECOMMEND_REQ = 0x6812;
	public static final int CLIENT_FRIEND_RECOMMEND_RSP = 0x6813;
	// gm命令
	public static final int CLIENT_GM_COMMAND_REQ = 0x4603;
	public static final int CLIENT_GM_COMMAND_RSP = 0x4604;
	// 停服维护
	public static final int CLIENT_GM_SHUTDOWN_CMD_REQ = 0x4610;
	public static final int CLIENT_GM_SHUTDOWN_CMD_RSP = 0x4611;

	// 读取角色信息
	public static final int CLIENT_READ_ROLE_REQ = 0x4601;
	public static final int CLIENT_READ_ROLE_RSP = 0x4602;
	// 写入角色信息
	public static final int CLIENT_WRITE_ROLE_REQ = 0x4605;
	public static final int CLIENT_WRITE_ROLE_RSP = 0x4606;
	// 读取仓库信息
	public static final int CLIENT_READ_ITEM_REQ = 0x4607;
	public static final int CLIENT_READ_ITEM_RSP = 0x4608;

	// 本人-获取待揭晓队列
	public static final int CLIENT_VERIFIED_QUEUE_REQ = 0x4296;
	public static final int CLIENT_VERIFIED_QUEUE_RSP = 0x4297;

	// 好友-获取待鉴定队列
	public static final int CLIENT_VERIFYING_QUEUE_REQ = 0x4298;
	public static final int CLIENT_VERIFYING_QUEUE_RSP = 0x4299;

	// 把鉴定好的物品放回背包
	public static final int CLIENT_VERIFY_DEQUEUE_REQ = 0x429a;
	public static final int CLIENT_VERIFY_DEQUEUE_RSP = 0x429b;

	// 把背包物品放入鉴定队列
	public static final int CLIENT_VERIFY_ENQUEUE_REQ = 0x8116;
	public static final int CLIENT_VERIFY_ENQUEUE_RSP = 0x8117;

	// 使用鉴定卡鉴定
	public static final int CLIENT_VERIFY_USECARD_REQ = 0x8120;
	public static final int CLIENT_VERIFY_USECARD_RSP = 0x8121;
	
	// 鉴定加速
	public static final int CLIENT_VERIFY_SPEEDUP_REQ = 0x8122;
	public static final int CLIENT_VERIFY_SPEEDUP_RSP = 0x8123;

	// 帮朋友鉴定物品
	public static final int CLIENT_VERIFY_ITEM_REQ = 0x429c;
	public static final int CLIENT_VERIFY_ITEM_RSP = 0x429e;

	// 离开好友鉴定室
	public static final int CLIENT_VERIFY_LEAVE_REQ = 0x8112;
	public static final int CLIENT_VERIFY_LEAVE_RSP = 0x8113;

	// 制作系统信息
	public static final int CLIENT_MANUFACTURE_INFO_REQ = 0x5d01;
	public static final int CLIENT_MANUFACTURE_INFO_RSP = 0x5d02;
	// 制作操作
	public static final int CLIENT_MANUFACTURE_ACTION_REQ = 0x5d20;
	public static final int CLIENT_MANUFACTURE_ACTION_RSP = 0x5d21;
	// 制作加速
	public static final int CLIENT_MANUFACTURE_SPEEDUP_REQ = 0x5d26;
	public static final int CLIENT_MANUFACTURE_SPEEDUP_RSP = 0x5d27;
	// 批量拾取制作物品
	public static final int CLIENT_MANUFACTURE_BATCH_PICKUP_REQ = 0x5d28;
	public static final int CLIENT_MANUFACTURE_BATCH_PICKUP_RSP = 0x5d29;

	// 获取展厅
	public static final int CLIENT_SHOW_TABLE_REQ = 0x8201;
	public static final int CLIENT_SHOW_TABLE_RSP = 0x8202;
	// 放入展厅
	public static final int CLIENT_SHOW_TABLE_PUTON_REQ = 0x8203;
	public static final int CLIENT_SHOW_TABLE_PUTON_RSP = 0x8204;
	// 从展厅拿下来
	public static final int CLIENT_SHOW_TABLE_PUTDOWN_REQ = 0x8205;
	public static final int CLIENT_SHOW_TABLE_PUTDOWN_RSP = 0x8206;

	public static final int CLIENT_SHOW_TABLE_ALL_PUTDOWN_REQ = 0x812a;
	public static final int CLIENT_SHOW_TABLE_ALL_PUTDOWN_RSP = 0x812b;
	// 物品移动位置
	public static final int CLIENT_SHOW_TABLE_MOVE_REQ = 0x8207;
	public static final int CLIENT_SHOW_TABLE_MOVE_RSP = 0x8208;
	// 展厅领奖
	public static final int CLIENT_SHOW_TABLE_DRAWPRIZE_REQ = 0x8209;
	public static final int CLIENT_SHOW_TABLE_DRAWPRIZE_RSP = 0x820a;
	// 展厅领奖状态查询
	public static final int CLIENT_SHOW_TABLE_DRAWINFO_REQ = 0x820b;
	public static final int CLIENT_SHOW_TABLE_DRAWINFO_RSP = 0x820c;
	// 展厅合成
	public static final int CLIENT_ANTIQUE_COMPOSE_REQ = 0x820d;
	public static final int CLIENT_ANTIQUE_COMPOSE_RSP = 0x820e;
	// 展厅财富值变动通知
	public static final int CLIENT_SHOW_TABLE_MONEY_NTF = 0x8210;
	// 获取展厅财富值
	public static final int CLIENT_SHOW_TABLE_MONEY_REQ = 0x8211;
	// 获取展厅信息
	public static final int CLIENT_GET_SHOW_TABLE_INFO_REQ = 0x8212;
	public static final int CLIENT_GET_SHOW_TABLE_INFO_RSP = 0x8213;
	// 保存展厅信息
	public static final int CLIENT_SAVE_SHOW_TABLE_INFO_REQ = 0x8214;
	public static final int CLIENT_SAVE_SHOW_TABLE_INFO_RSP = 0x8215;
	// 物品交换位置
	public static final int CLIENT_SHOW_TABLE_CHANGE_POSITION_REQ = 0x8110;
	public static final int CLIENT_SHOW_TABLE_CHANGE_POSITION_RSP = 0x8111;
	// 展厅套装
	public static final int CLIENT_ANTIQUE_SUIT_REQ = 0x8114;
	public static final int CLIENT_ANTIQUE_SUIT_RSP = 0x8115;
	// 展厅点赞
	public static final int CLIENT_SHOW_TABLE_SUPPORT_REQ = 0x8124;
	public static final int CLIENT_SHOW_TABLE_SUPPORT_RSP = 0x8125;
	// 展厅自动下架
	public static final int CLIENT_SHOW_TABLE_AUTO_PUTDOWN_NTF = 0x8126;

	// 新手引导
	public static final int CLIENT_GUIDE_INFO_REQ = 0x5209;
	public static final int CLIENT_GUIDE_INFO_RSP = 0x520a;
	public static final int CLIENT_GUIDE_PROCUPDATE_REQ = 0x5207;
	public static final int CLIENT_GUIDE_PROCUPDATE_RSP = 0x5208;
	public static final int CLIENT_GUIDE_GETREWARD_REQ = 0x520c;
	public static final int CLIENT_GUIDE_GETREWARD_RSP = 0x520d;

	// 加入场景
	public static final int CLIENT_JOINSCENE_REQ = 0x4207;
	public static final int CLIENT_JOINSCENE_RSP = 0x4208;
	// 加入场景通知
	public static final int CLIENT_JOINSCENE_NTF = 0x4209;

	// 发送地图信息
	public static final int CLIENT_SCENE_MAP_NTF = 0x4267;

	// 离开场景
	public static final int CLIENT_LEAVESCENE_REQ = 0x420a;
	public static final int CLIENT_LEAVESCENE_RSP = 0x420b;
	// 离开场景通知
	public static final int CLIENT_LEAVE_SCENE_NTF = 0x420c;

	// 场景移动
	public static final int CLIENT_SCENE_MOVEMENT_REQ = 0x4223;
	public static final int CLIENT_SCENE_MOVEMENT_RSP = 0x4224;
	// 场景移动通知
	public static final int CLIENT_SCENE_MOVEMENT_NTF = 0x4225;

	// 场景使用技能
	public static final int CLIENT_SCENE_USESKILL_REQ = 0x4220;
	public static final int CLIENT_SCENE_USESKILL_RSP = 0x4221;
	// 场景使用技能通知
	public static final int CLIENT_SCENE_USESKILL_NTF = 0x4222;

	// 检查当前是否在某个场景
	public static final int CLIENT_CHECKSCENE_REQ = 0x4232;
	public static final int CLIENT_CHECKSCENE_RSP = 0x4233;

	// 排行榜请求
	public static final int CLIENT_RANK_TOPN_REQ = 0x7c01;
	// 通用角色排行榜通知
	public static final int CLIENT_RANK_ROLE_COMMON_NTF = 0x7c05;
	// 涨跌幅
	public static final int CLIENT_RANK_STOCK_INFO_NTF = 0x7c0c;
	// 公会排行榜通知
	public static final int CLIENT_RANK_GUILD_NTF = 0x7c08;

	// 获取自己排名附近前后的排行
	public static final int CLIENT_RANK_SELF_NEARBY_REQ = 0x7c02;
	public static final int CLIENT_RANK_SELF_NEARBY_RSP = 0x7c03;

	// 盗墓地图-寻宝
	public static final int CLIENT_ROB_MAP_REQ = 0x8101;
	public static final int CLIENT_ROB_MAP_RSP = 0x8102;
	// 地图变化
	public static final int CLIENT_ROB_MAP_NTF = 0x8103;
	// 盗墓使用技能
	public static final int CLIENT_ROB_USE_SKILL_REQ = 0x8104;
	public static final int CLIENT_ROB_USE_SKILL_RSP = 0x8105;
	// 距离大宝远近通知
	public static final int CLIENT_ROB_DISTANCE_NTF = 0x8106;
	// 盗墓怪物碰撞
	public static final int CLIENT_ROB_MONSTER_ONCOLLISION_REQ = 0x8107;
	public static final int CLIENT_ROB_MONSTER_ONCOLLISION_RSP = 0x8108;
	// 新大宝点推送
	public static final int CLIENT_ROB_NEW_TREASURE_NTF = 0x8109;
	// 消灭毒虫
	public static final int CLIENT_ROB_BOMB_MONSTER_REQ = 0x8118;
	public static final int CLIENT_ROB_BOMB_MONSTER_RSP = 0x8119;
	// 完成宝藏说明引导任务
	public static final int CLIENT_ROB_COMPLETE_GUIDE_REQ = 0x8129;
	public static final int CLIENT_ROB_COMPLETE_GUIDE_RSP = 0x8130;
	// 挖去地貌表皮，漏出宝物， 开门也用这个协议
	public static final int CLIENT_ROB_LOOK_ITEM_REQ = 0x8127;
	public static final int CLIENT_ROB_LOOK_ITEM_RSP = 0x8128;
	// 野外
	public static final int CLIENT_OUTSIDE_REQ = 0x5e0d;
	public static final int CLIENT_OUTSIDE_RSP = 0x5e0f;
	public static final int CLIENT_OUTSIDE_GUIDE_REQ = 0x5e10;
	public static final int CLIENT_OUTSIDE_GUIDE_RSP = 0x5e11;
	// 批量采集
	public static final int CLIENT_OUTSIDE_BATCH_REQ = 0x5e12;
	public static final int CLIENT_OUTSIDE_BATCH_RSP = 0x5e13;

	// 收集模块
	public static final int CLIENT_COLLECTION_LIST_REQ = 0x8501;
	public static final int CLIENT_COLLECTION_LIST_RSP = 0x8502;
	public static final int CLIENT_COLLECTION_UPDATE_NTF = 0x8503;
	// 兑换收集奖励
	public static final int CLIENT_COLLECTION_EXCHANGE_REWARD_REQ = 0x8504;
	public static final int CLIENT_COLLECTION_EXCHANGE_REWARD_RSP = 0x8505;
	// 荒地信息查询
	public static final int CLIENT_OBSTACLES_LIST_REQ = 0x42a3;
	public static final int CLIENT_OBSTACLES_LIST_RSP = 0x42a4;
	// 开垦荒地
	public static final int CLIENT_OBSTACLES_OPENUP_REQ = 0x42a5;
	public static final int CLIENT_OBSTACLES_OPENUP_RSP = 0x42a6;
	// 商城查询
	public static final int CLIENT_MALL_LIST_REQ = 0x4a30;
	public static final int CLIENT_MALL_LIST_RSP = 0x4a31;
	// 商城购买
	public static final int CLIENT_MALL_BUY_REQ = 0x4a32;
	public static final int CLIENT_MALL_BUY_RSP = 0x4a33;

	// -------------------公会模块------------------------------------------------------------------
	// 创建公会
	public static final int CLIENT_GUILD_CREATE_REQ = 0x6B01;
	public static final int CLIENT_GUILD_CREATE_RSP = 0x6B02;
	// 查询公会信息
	public static final int CLIENT_GUILD_LIST_REQ = 0x6B1c;
	public static final int CLIENT_GUILD_LIST_RSP = 0x6B1d;
	// 修改公告
	public static final int CLIENT_GUILD_MODIFYSUMMARY_REQ = 0x6B0f;
	public static final int CLIENT_GUILD_MODIFYSUMMARY_RSP = 0x6B10;
	// 申请加入
	public static final int CLIENT_GUILD_APPLY_REQ = 0x6B07;
	public static final int CLIENT_GUILD_APPLY_RSP = 0x6B08;
	// 申请加入通知
	public static final int CLIENT_GUILD_APPLY_NTF = 0x6B09;
	// 批准加入
	public static final int CLIENT_GUILD_APPROVE_REQ = 0x6B0a;
	public static final int CLIENT_GUILD_APPROVE_RSP = 0x6B0b;
	// 公会批准通知
	public static final int CLIENT_GUILD_APPROVE_NTF = 0x6B0c;
	// 申请列表
	public static final int CLIENT_GUILD_APPLYLIST_REQ = 0x6B1a;
	public static final int CLIENT_GUILD_APPLYLIST_RSP = 0x6B1b;
	// 成员列表
	public static final int CLIENT_GUILD_MEMBERLIST_REQ = 0x6B13;
	public static final int CLIENT_GUILD_MEMBERLIST_RSP = 0x6B14;
	// 退出公会
	public static final int CLIENT_GUILD_QUIT_REQ = 0x6B15;
	public static final int CLIENT_GUILD_QUIT_RSP = 0x6B16;
	// 退出公会通知
	public static final int CLIENT_GUILD_QUIT_NTF = 0x6B17;
	// 踢出公会
	public static final int CLIENT_GUILD_KICK_REQ = 0x6B18;
	public static final int CLIENT_GUILD_KICK_RSP = 0x6B19;
	// 调整职务
	public static final int CLIENT_GUILD_ADJUSTPOST_REQ = 0x6B0d;
	public static final int CLIENT_GUILD_ADJUSTPOST_RSP = 0x6B0e;
	// 公会搜索
	public static final int CLIENT_GUILD_SEARCH_REQ = 0x6B05;
	public static final int CLIENT_GUILD_SEARCH_RSP = 0x6B06;
	// 商会属性推送
	public static final int CLIENT_GUILD_ATTR_CLIENT_NTF = 0x6B20;
	// 改商会名
	public static final int CLIENT_CHANGE_GUILD_NAME_REQ = 0x6B21;
	public static final int CLIENT_CHANGE_GUILD_NAME_NTF = 0x6B22;
	// 商会战斗报名
	public static final int CLIENT_SIGNUP_GUILD_BATTLE_REQ = 0x6B23;
	public static final int CLIENT_SIGNUP_GUILD_BATTLE_RSP = 0x6B24;
	
	// -------------------------------------------------------------------------------------------
	// 可交易的前几名
	public static final int CLIENT_TRADE_TOPN_REQ = 0x8301;
	public static final int CLIENT_TRADE_TOPN_RSP = 0x8302;
	// 放入队列
	public static final int CLIENT_TRADE_ENQUEUE_REQ = 0x8303;
	public static final int CLIENT_TRADE_ENQUEUE_RSP = 0x8304;
	// 拿出队列
	public static final int CLIENT_TRADE_DEQUEUE_REQ = 0x8305;
	public static final int CLIENT_TRADE_DEQUEUE_RSP = 0x8306;
	// 交易买卖
	public static final int CLIENT_TRADE_USE_REQ = 0x8307;
	public static final int CLIENT_TRADE_USE_RSP = 0x8308;
	// 玩家发布的东西
	public static final int CLIENT_TRADE_ROLE_REQ = 0x8309;
	public static final int CLIENT_TRADE_ROLE_RSP = 0x830a;
	// 交易信息
	public static final int CLIENT_STOCK_LIST_REQ = 0x830b;
	public static final int CLIENT_STOCK_LIST_RSP = 0x830c;
	// 获取订单的交易历史记录
	public static final int CLIENT_TRADE_HISTORY_REQ = 0x830d;
	public static final int CLIENT_TRADE_HISTORY_RSP = 0x830e;
	// 交易推送
	public static final int CLIENT_TRADE_USE_NTF = 0x8310;
	// 交易页面关闭
	public static final int CLIENT_TRADE_CLOSE_REQ = 0x8311;
	public static final int CLIENT_TRADE_CLOSE_RSP = 0x8312;

	// 农场信息查询
	public static final int CLIENT_FARM_LIST_REQ = 0x429f;
	public static final int CLIENT_FARM_LIST_RSP = 0x42a0;
	// 农场种植
	public static final int CLIENT_FARM_ACTION_PLAINT_REQ = 0x42a1;
	public static final int CLIENT_FARM_ACTION_PLAINT_RSP = 0x42a2;
	// 农场收获
	public static final int CLIENT_FARM_ACTION_HARVEST_REQ = 0x42a7;
	public static final int CLIENT_FARM_ACTION_HARVEST_RSP = 0x42a8;

	// -------------------------------------------------------------------------------------------
	// 任务列表
	public static final int CLIENT_TASK_LIST_REQ = 0x1001;
	public static final int CLIENT_TASK_LIST_RSP = 0x1002;
	// 推送任务刷新
	public static final int CLIENT_TASK_UPDATE_NTF = 0x1003;
	// 领取任务奖励
	public static final int CLIENT_TASK_REWARD_REQ = 0x1004;
	public static final int CLIENT_TASK_REWARD_RSP = 0x1005;
	// 接受任务
	public static final int CLIENT_TASK_ACCEPT_REQ = 0x1006;
	public static final int CLIENT_TASK_ACCEPT_RSP = 0x1007;
	// 删除任务
	public static final int CLIENT_TASK_REMOVE_REQ = 0x1008;
	public static final int CLIENT_TASK_REMOVE_RSP = 0x1009;
	// 首次打开任务
	public static final int CLIENT_TASK_FIRST_REQ = 0x1010;
	public static final int CLIENT_TASK_FIRST_RSP = 0x1011;
	// 刷新任务
	public static final int CLIENT_TASK_REFRESH_REQ = 0x1012;
	public static final int CLIENT_TASK_REFRESH_RSP = 0x1013;
	// 任务埋点
	public static final int CLIENT_TASK_POINT_REQ = 0x1014;
	public static final int CLIENT_TASK_POINT_RSP = 0x1015;
	// 推送成长任务完成
	public static final int CLIENT_TASK_FINISH_NTF = 0x1016;
	// 请求成长任务状态列表
	public static final int CLIENT_TASK_STATE_LIST_REQ = 0x1017;
	public static final int CLIENT_TASK_STATE_LIST_RSP = 0x1018;

	// 请求召唤精灵信息
	public static final int CLIENT_SUMMON_INFO_REQ = 0x1101;
	public static final int CLIENT_SUMMON_INFO_RSP = 0x1102;
	// 召唤精灵
	public static final int CLIENT_SUMMON_REQ = 0x1103;
	public static final int CLIENT_SUMMON_RSP = 0x1104;
	// 保留精灵
	public static final int CLIENT_SUMMON_RETAIN_REQ = 0x1110;
	public static final int CLIENT_SUMMON_RETAIN_RSP = 0x1111;
	// 派出精灵
	public static final int CLIENT_SUMMON_SEND_REQ = 0x1105;
	public static final int CLIENT_SUMMON_SEND_RSP = 0x1106;
	// 推送精灵邮件奖励
	public static final int CLIENT_SUMMON_MAIL_NTF = 0x1107;
	// 领取精灵邮件奖励
	public static final int CLIENT_SUMMON_MAIL_REWARD_REQ = 0x1108;
	public static final int CLIENT_SUMMON_MAIL_REWARD_RSP = 0x1109;
	// 领取所有精灵邮件奖励
	public static final int CLIENT_SUMMON_ALL_MAIL_REWARD_REQ = 0x1124;
	public static final int CLIENT_SUMMON_ALL_MAIL_REWARD_RSP = 0x1125;
	// 刷新精灵邮件
	public static final int CLIENT_SUMMON_MAIL_REFRESH_REQ = 0x1116;
	public static final int CLIENT_SUMMON_MAIL_REFRESH_RSP = 0x1117;
	// 重启召唤
	//public static final int CLIENT_SUMMON_RESET_REQ = 0x1110;
	//public static final int CLIENT_SUMMON_RESET_RSP = 0x1111;
	// 首次打开精灵邮件
	public static final int CLIENT_SUMMON_MAIL_FIRST_REQ = 0x1112;
	public static final int CLIENT_SUMMON_MAIL_FIRST_RSP = 0x1113;
	// 投资精灵
	public static final int CLIENT_SUMMON_INVEST_REQ = 0x1114;
	public static final int CLIENT_SUMMON_INVEST_RSP = 0x1115;
	// 请求精灵新邮件
	public static final int CLIENT_SUMMON_NEW_MAIL_REQ = 0x1118;
	public static final int CLIENT_SUMMON_NEW_MAIL_RSP = 0x1119;
	// 精灵投资奖励捡漏
	public static final int CLIENT_SUMMON_PICKUP_INVEST_REWARD_REQ = 0x1120;
	public static final int CLIENT_SUMMON_PICKUP_INVEST_REWARD_RSP = 0x1121;
	// 精灵快速回家
	public static final int CLIENT_SUMMON_FAST_MAIL_REQ = 0x1122;
	public static final int CLIENT_SUMMON_FAST_MAIL_RSP = 0x1123;
	// 获取生态园信息
	public static final int CLIENT_PARK_INFO_REQ = 0x2000;
	public static final int CLIENT_PARK_INFO_RSP = 0x2001;
	// 放置植物
	public static final int CLIENT_PARK_PLACE_PLANT_REQ = 0x2002;
	public static final int CLIENT_PARK_PLACE_PLANT_RSP = 0x2003;
	// 放置动物
	public static final int CLIENT_PARK_PLACE_ANIMAL_REQ = 0x2004;
	public static final int CLIENT_PARK_PLACE_ANIMAL_RSP = 0x2005;
	// 收获植物
	public static final int CLIENT_PARK_HARVEST_PLANT_REQ = 0x2006;
	public static final int CLIENT_PARK_HARVEST_PLANT_RSP = 0x2007;
	// 收获动物
	public static final int CLIENT_PARK_HARVEST_ANIMAL_REQ = 0x2008;
	public static final int CLIENT_PARK_HARVEST_ANIMAL_RSP = 0x2009;
	// 生态园地图变化推送
	public static final int CLIENT_PARK_CELL_NTF = 0x2010;
	// 生态园动物变化推送
	public static final int CLIENT_PARK_ANIMAL_NTF = 0x2011;
	// 生态园动物成熟变化推送
	public static final int CLIENT_PARK_ANIMAL_MATURE_NTF = 0x2012;
	// 动物园放置动物
	public static final int CLIENT_ZOO_PLACE_ANIMAL_REQ = 0x2014;
	public static final int CLIENT_ZOO_PLACE_ANIMAL_RSP = 0x2015;
	// 鱼塘放置鱼
	public static final int CLIENT_PARK_PLACE_FISH_REQ = 0x2020;
	public static final int CLIENT_PARK_PLACE_FISH_RSP = 0x2021;
	// 鱼塘收获鱼
	public static final int CLIENT_PARK_HARVEST_FISH_REQ = 0x2022;
	public static final int CLIENT_PARK_HARVEST_FISH_RSP = 0x2023;
	// 生态园鱼塘的鱼变化推送
	public static final int CLIENT_PARK_FISH_NTF = 0x2024;
	// 清除枯萎植物
	public static final int CLIENT_PARK_CLEAR_WITHER_PLANT_REQ = 0x2025;
	public static final int CLIENT_PARK_CLEAR_WITHER_PLANT_RSP = 0x2026;
	// 清除枯萎动物
	public static final int CLIENT_PARK_CLEAR_WITHER_ANIMAL_REQ = 0x2027;
	public static final int CLIENT_PARK_CLEAR_WITHER_ANIMAL_RSP = 0x2028;
	// 领取蜂蜜
	public static final int CLIENT_PARK_DRAW_HONEY_REQ = 0x2029;
	public static final int CLIENT_PARK_DRAW_HONEY_RSP = 0x2030;
	// 生态园动物喂食
	public static final int CLIENT_PARK_ANIMAL_FEED_REQ = 0x2031;
	public static final int CLIENT_PARK_ANIMAL_FEED_RSP = 0x2032;
	// 结算
	public static final int CLIENT_PARK_DRAW_PRIZE_REQ = 0x2033;
	public static final int CLIENT_PARK_DRAW_PRIZE_RSP = 0x2034;
	// 生态园动物自动离开
	public static final int CLIENT_PARK_ANIMAL_AUTO_LEAVE_NTF = 0x2035;
	// 放置树木
	public static final int CLIENT_PARK_PLACE_TREE_REQ = 0x2042;
	public static final int CLIENT_PARK_PLACE_TREE_RSP = 0x2043;
	// 收获树木
	public static final int CLIENT_PARK_HARVEST_TREE_REQ = 0x2044;
	public static final int CLIENT_PARK_HARVEST_TREE_RSP = 0x2045;
	// 放置庄稼
	public static final int CLIENT_PARK_PLACE_CROPS_REQ = 0x2046;
	public static final int CLIENT_PARK_PLACE_CROPS_RSP = 0x2047;
	// 收获庄稼
	public static final int CLIENT_PARK_HARVEST_CROPS_REQ = 0x2048;
	public static final int CLIENT_PARK_HARVEST_CROPS_RSP = 0x2049;
	// 加速收获生态园动物
	public static final int CLIENT_PARK_ANIMAL_SPEEDUP_REQ = 0x2050;
	public static final int CLIENT_PARK_ANIMAL_SPEEDUP_RSP = 0x2051;
	// 加速收获生态园鱼
	public static final int CLIENT_PARK_FISH_SPEEDUP_REQ = 0x2052;
	public static final int CLIENT_PARK_FISH_SPEEDUP_RSP = 0x2053;
	// 加速收获庄家/植物/树木
	public static final int CLIENT_PARK_PLANT_SPEEDUP_REQ = 0x2054;
	public static final int CLIENT_PARK_PLANT_SPEEDUP_RSP = 0x2055;
	// -------------------------------------------------------------------------------------------
	// 开始接鸡蛋
	public static final int CLIENT_START_MEET_EGG_REQ = 0x2201;
	public static final int CLIENT_START_MEET_EGG_RSP = 0x2202;
	// 接鸡蛋的顶部掉落推送
	public static final int CLIENT_MEET_EGG_DROP_NTF = 0x2203;
	// 变化平底锅的位置
	public static final int CLIENT_CHANGE_MEET_X_REQ = 0x2204;
	public static final int CLIENT_CHANGE_MEET_X_RSP = 0x2205;
	// 接到了掉落物
	public static final int CLIENT_MEET_DROP_REQ = 0x2206;
	public static final int CLIENT_MEET_DROP_RSP = 0x2207;
	// 退出接鸡蛋
	public static final int CLIENT_EXIT_MEET_EGG_REQ = 0x2208;
	public static final int CLIENT_EXIT_MEET_EGG_RSP = 0x2209;
	// 接鸡蛋结束
	public static final int CLIENT_MEET_EGG_STOP_NTF = 0x2210;
	// 暂停开始
	public static final int CLIENT_MEET_EGG_PAUSE_START_REQ = 0x2211;
	public static final int CLIENT_MEET_EGG_PAUSE_START_RSP = 0x2212;

	// 聊天
	public static final int CLIENT_CHAT_SEND_REQ = 0x2301;
	public static final int CLIENT_CHAT_SEND_RSP = 0x2302;
	// 聊天推送
	public static final int CLIENT_CHAT_SEND_NTF = 0x2303;
	
	//--------------------------------------------------------------------------------------------------------
	// 商会战斗建筑列表
	public static final int CLIENT_BATTLE_BUILD_LIST_REQ = 0x2401;
	public static final int CLIENT_BATTLE_BUILD_LIST_RSP = 0x2402;
	// 占领战斗建筑
	public static final int CLIENT_HOLD_BATTLE_BUILD_REQ = 0x2403;
	public static final int CLIENT_HOLD_BATTLE_BUILD_RSP = 0x2404;
	// 攻占战斗建筑
	public static final int CLIENT_CAPTURE_BATTLE_BUILD_REQ = 0x2405;
	public static final int CLIENT_CAPTURE_BATTLE_BUILD_RSP = 0x2406;
	// 有人攻占战斗建筑推送
	public static final int CLIENT_CAPTURE_BATTLE_BUILD_NTF = 0x2407;
	// 商会战斗匹配成功推送
	public static final int CLIENT_GUILD_BATTLE_MATCH_SUCESS_NTF = 0x2408;
	// 退出商会战斗建筑列表
	public static final int CLIENT_EXIT_BATTLE_BUILD_LIST_REQ = 0x2409;
	public static final int CLIENT_EXIT_BATTLE_BUILD_LIST_RSP = 0x2410;
	// 占据产出分数推送
	public static final int CLIENT_BATTLE_HOLD_SCORE_NTF = 0x2411;
	// 游戏结束推送
	public static final int CLIENT_BATTLE_OVER_NTF = 0x2412;
	// 玩家开始接鸡蛋
	public static final int CLIENT_START_BATTLE_MEET_EGG_REQ = 0x2421;
	public static final int CLIENT_START_BATTLE_MEET_EGG_NTF = 0x2422;
	// 接鸡蛋的顶部掉落推送
	public static final int CLIENT_BATTLE_MEET_EGG_DROP_NTF = 0x2423;
	// 变化平底锅的位置
	public static final int CLIENT_BATTLE_CHANGE_MEET_X_REQ = 0x2424;
	public static final int CLIENT_BATTLE_CHANGE_MEET_X_RSP = 0x2425;
	// 接到了掉落物
	public static final int CLIENT_BATTLE_MEET_DROP_REQ = 0x2426;
	public static final int CLIENT_BATTLE_MEET_DROP_RSP = 0x2427;
	// 积分变化推送
	public static final int CLIENT_BATTLE_MEET_SCORE_NTF = 0x2428;
	// 退出接鸡蛋
	public static final int CLIENT_EXIT_BATTLE_MEET_EGG_REQ = 0x2429;
	public static final int CLIENT_EXIT_BATTLE_MEET_EGG_RSP = 0x2430;
	// 接鸡蛋结束
	public static final int CLIENT_BATTLE_MEET_EGG_STOP_NTF = 0x2431;
	// 战斗后建筑占领信息更新
	public static final int CLIENT_BATTLE_BUILD_UPDATE_NTF = 0x2432;
	
	//--------------------------------------------------------------------------------------------------------
	// 商会任务
	// 请求商会任务列表
	public static final int CLIENT_GUILD_TASK_LIST_REQ = 0x2501;
	public static final int CLIENT_GUILD_TASK_LIST_RSP = 0x2502;
	// 接受商会任务
	public static final int CLIENT_GUILD_TASK_ACCEPT_REQ = 0x2503;
	public static final int CLIENT_GUILD_TASK_ACCEPT_RSP = 0x2504;
	// 商会任务更新推送
	public static final int CLIENT_GUILD_TASK_UPDATE_NTF = 0x2505;
	// 商会任务删除（撕单）
	public static final int CLIENT_GUILD_TASK_REMOVE_REQ = 0x2506;
	public static final int CLIENT_GUILD_TASK_REMOVE_RSP = 0x2507;
	// 商会任务加速
	public static final int CLIENT_GUILD_TASK_SPEEDUP_REQ = 0x2508;
	public static final int CLIENT_GUILD_TASK_SPEEDUP_RSP = 0x2509;
	// 商会任务奖励
	public static final int CLIENT_GUILD_TASK_REWARD_REQ = 0x2510;
	public static final int CLIENT_GUILD_TASK_REWARD_RSP = 0x2511;
	//--------------------------------------------------------------------------------------------------------
	// 图鉴
	// 请求图鉴所有类型
	public static final int CLIENT_BOOK_ALL_TYPE_REQ = 0x2601;
	public static final int CLIENT_BOOK_ALL_TYPE_RSP = 0x2602;
	// 请求指定类型的图鉴信息
	public static final int CLIENT_BOOK_INFO_REQ = 0x2603;
	public static final int CLIENT_BOOK_INFO_RSP = 0x2604;
	// 图鉴更新通知
	public static final int CLIENT_BOOK_UPDATE_NTF = 0x2605;
	// 领取图鉴标志新的奖励
	public static final int CLIENT_BOOK_REWARD_REQ = 0x2606;
	public static final int CLIENT_BOOK_REWARD_RSP = 0x2607;
	// 图鉴翻页
	public static final int CLIENT_BOOK_TURN_PAGES_REQ = 0x2608;
	public static final int CLIENT_BOOK_TURN_PAGES_RSP = 0x2609;
	//--------------------------------------------------------------------------------------------------------
	// 城市
	// 请求npc列表
	public static final int CLIENT_NPC_LIST_REQ = 0x2701;
	public static final int CLIENT_NPC_LIST_RSP = 0x2702;
	// 拜访npc
	public static final int CLIENT_NPC_VISIT_REQ = 0x2703;
	public static final int CLIENT_NPC_VISIT_RSP = 0x2704;
	// npc触发事件
	public static final int CLIENT_NPC_TRIGGER_EVENT_REQ = 0x2705;
	public static final int CLIENT_NPC_TRIGGER_EVENT_RSP = 0x2706;
	// 请求对诗信息，获取第一道题
	public static final int CLIENT_NPC_ON_POETRY_INFO_REQ = 0x2707;
	public static final int CLIENT_NPC_ON_POETRY_INFO_RSP = 0x2708;
	// 对诗，并获取后续题目
	public static final int CLIENT_NPC_ON_POETRY_REQ = 0x2709;
	public static final int CLIENT_NPC_ON_POETRY_RSP = 0x2710;
	// 要东西
	public static final int CLIENT_NPC_WANT_THING_REQ = 0x2711;
	public static final int CLIENT_NPC_WANT_THING_RSP = 0x2712;
	// 赌马下注
	public static final int CLIENT_NPC_RACE_HORSES_REQ = 0x2713;
	public static final int CLIENT_NPC_RACE_HORSES_RSP = 0x2714;

	// 小混混抢劫
	public static final int CLIENT_NPC_ROBBERY_REQ = 0x2715;
	public static final int CLIENT_NPC_ROBBERY_RSP = 0x2716;

	// 赞美NPC
	public static final int CLIENT_NPC_PRAISE_REQ = 0x2717;
	public static final int CLIENT_NPC_PRAISE_RSP = 0x2718;
	// 客户端发起支付
	public static final int WX_PRE_PAY_REQ = 0x2801;
	public static final int WX_PRE_PAY_RSP = 0x2802;

	// 支付状态查询
	public static final int WX_PAY_QUERY_REQ = 0x2803;
	public static final int WX_PAY_QUERY_RSP = 0x2804;

	// 客户端发起支付
	public static final int ALI_PAY_PRE_REQ = 0x2805;
	public static final int ALI_PAY_PRE_RSP = 0x2806;

	// 支付状态查询
	public static final int ALI_PAY_QUERY_REQ = 0x2807;
	public static final int ALI_PAY_QUERY_RSP = 0x2808;

	public static void main(String[] args) {
		System.out.println(CLIENT_CHAT_SEND_NTF);
	}
}
