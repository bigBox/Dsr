package com.dj.domain;

public final class RedisKeys {
    /**
     *	数据库Lock Key的redis key前缀
     */
    public static final String LOCK_KEY_PREFIX = "LOCK_{0}";

    /**
     *	数据库Lock Key的最大加锁时间
     */
    public static final int REDIS_KEY_LOCK_TIME = 500;

    /**
     *	角色唯一id自增基数
     */
    public final static int ROLEID_BASE_NUM = 10000;
    /**
     *	角色id
     */
    public static final String ROLE_ID = "ROLE_ID";

    /**
     *	玩家名字 key
     */
    public static final String KEY_PLAYER_NAME = "Player_Name";

    /**
     *	玩家key
     */
    public static final String KEY_PLAYER = "Player_{0}";
    /**
     *	玩家角色 key
     */
    public static final String KEY_PLAYER_ROLE = "Player";

    /**
     *	游戏key
     */
    public static final String KEY_GAME = "Game_{0}";
    /**
     *	游戏主页建筑 key
     */
    public static final String KEY_GAME_FACTORY = "Factory";
    /**
     *	游戏主页建筑 key
     */
    public static final String KEY_ROBOT_GAME_FACTORY = "Robot_Factory";
    /**
     *	游戏主页荒地 key
     */
    public static final String KEY_GAME_OBSTACLE = "Obstacle";
    /**
     *	游戏主页荒地 key
     */
    public static final String KEY_ROBOT_GAME_OBSTACLE = "Robot_Obstacle";
    /**
     *	农场key
     */
    public static final String KEY_GAME_FARM = "Farm";

    /**
     *	初始化时间
     */
    public static final String KEY_INIT_TIME = "Init_Time";

    /**
     *	挖矿key
     */
    public static final String KEY_GAME_MINE = "Game_Mine_{0}";
    // 本人矿区重置时间
    public static final String KEY_GAME_MINE_RESET = "Mine_Reset";
    // 本人矿区
    public static final String KEY_GAME_MINE_CELL = "Cell";
    // 小寻矿区
    public static final String KEY_GAME_MINE_CELL_XX = "Cell_XX";
    //npc触发技能地图碎片概率翻倍
    public static final String KEY_NPCSKILLMAPPIECEMULTIPLE = "npcSkillMapPieceMultiple";
    public static final String KEY_NPCSKILL_IN = "npcSkill_In";

    /**
     *	物品key
     */
    public static final String KEY_ITEM = "Item_{0}";
    /**
     *	物品流通
     */
    public static final String KEY_ITEM_BILL = "Item_Bill";
    /**
     *	记录物品来源
     */
    public static final String KEY_ITEM_RECORD_SOURCE = "Item_Record_Source";
    /**
     *	地图碎片
     */
    public static final String KEY_ITEM_MAP_PIECE = "Item_Map_Piece";
    /**
     *	好友互动物品日志
     */
    public static final String KEY_ITEM_INTERACT_LOG = "Item_Interact_Log";

    /**
     *	好友key
     */
    public static final String KEY_FRIEND = "Friend_{0}";
    /**
     *	好友申请 key
     */
    public static final String KEY_FRIEND_APPLY = "Friend_Apply";
    /**
     *	好友行为 key
     */
    public static final String KEY_FRIEND_ACTION = "Friend_Action";

    /**
     *	玩家通用key
     */
    public static final String KEY_COMMON = "Common_{0}";
    /**
     *	通用属性变更 key
     */
    public static final String KEY_COMMON_ATTR_BILL = "Attr_Bill";
    /**
     *	帮小寻鉴定标记
     */
    public static final String KEY_COMMON_VERIFY_XIAOXUN = "Verify_XiaoXun";
    /**
     *	接受任务类型标记
     */
    public static final String KEY_COMMON_ACCEPT_TYPE_TASK = "Accept_Type_Task";
    /**
     *	客户端自定义数据
     */
    public static final String KEY_COMMON_CLIENT_DATA = "Client_Data";
    /**
     *	生态园结算
     */
    public static final String KEY_COMMON_PARK_DRAW_PRIZE = "Park_Draw_Prize";

    /**
     *	展厅key
     */
    public static final String KEY_SHOW_TABLE = "Show_Table_{0}";
    /**
     *	展厅key
     */
    public static final String KEY_SHOW_TABLE_INFO = "Show_Table_Info_{0}";
    /**
     *	宝物，字画展厅
     */
    public static final String KEY_SHOW_TABLE_COL_0 = "Col_0";
    /**
     *	水族馆展厅
     */
    public static final String KEY_SHOW_TABLE_COL_1 = "Col_1";
    /**
     *	标本展厅
     */
    public static final String KEY_SHOW_TABLE_COL_2 = "Col_2";
    /**
     *	字画展厅（废弃）
     */
    public static final String KEY_SHOW_TABLE_COL_3 = "Col_3";
    /**
     *	馆藏值
     */
    public static final String KEY_SHOW_TABLE_MONEY = "Money";
    /**
     *	展厅点赞
     */
    public static final String KEY_SHOW_TABLE_SUPPORT = "Support";
    /**
     *	套装id
     */
    public static final String KEY_SUIT_ID = "SUIT_ID";

    /**
     *	商会key
     */
    public static final String KEY_GUILD = "Guild_{0}";
    /**
     *	商会信息key
     */
    public static final String KEY_GUILD_INFO = "Guild";
    /**
     *	商会申请 key
     */
    public static final String KEY_GUILD_APPLY = "Apply";

    /**
     *	交易key
     */
    public static final String KEY_TRADE = "Trade_{0}";
    /**
     *	交易挂单买 key
     */
    public static final String KEY_TRADE_ORDER_BUY = "TradeOrderBuy";
    /**
     *	交易挂单卖 key
     */
    public static final String KEY_TRADE_ORDER_SELL = "TradeOrderSell";
    /**
     *	交易记录 key
     */
    public static final String KEY_TRADE_RECORD = "TradeRecord";
    /**
     *	任务key
     */
    public static final String KEY_TASK = "Task_{0}";
    /**
     *	新手引导任务奖励 key
     */
    public static final String KEY_TASK_GUIDE_REWARD = "Task_Guide_Reward";
    /**
     *	新手引导任务完成标记 key
     */
    public static final String KEY_TASK_GUIDE_FINISH = "Task_Guide_Finish";
    /**
     *	日常任务个数
     */
    public static final String KEY_TASK_DAY_COUNT = "Task_Day_Count";

    /**
     *	精灵key
     */
    public static final String KEY_SUMMON = "Summon_{0}";
    public static final String KEY_SUMMON_INFO = "Summon";

    public static final String KEY_SUMMON_LEVEL = "Summon_Level";
    /**
     *	单人接鸡蛋key
     */
    public static final String KEY_MEET_EGG_SINGLE = "Meet_Egg_Single_{0}";
    public static final String KEY_MEET_EGG_BUILD = "Meet_Egg_Build";

    /**
     * 商会战斗建筑
     */
    public static final String KEY_GUILD_BATTLE= "Guild_Battle";
    public static final String KEY_GUILD_BATTLE_BUILD= "Guild_Battle_Build";

    /**
     *	生态园key
     */
    public static final String KEY_PARK = "Park_{0}";
    /**
     *	生态园 已经占用的生态值
     */
    public static final String KEY_PARK_USE_ECOLOGY = "Use_Ecology";
    /**
     *	生态园物种对应的数量
     */
    public static final String KEY_PARK_COUNT = "Park_Count";
    /**
     *	生态园格子key
     */
    public static final String KEY_PARK_CELL = "Park_Cell";
    /**
     *	生态园动物key
     */
    public static final String KEY_PARK_ANIMAL = "Park_Animal";
    /**
     *	动物园动物key
     */
    public static final String KEY_ZOO_ANIMAL = "Zoo_Animal";
    /**
     *	生态园鱼塘的鱼key
     */
    public static final String KEY_PARK_POOL_FISH = "Pool_Fish";
    /**
     *	蜂巢奖励下次可领取时间
     */
    public static final String KEY_PARK_HONEY_DRAW_TIME = "HoneyDrawTime";

    /**
     *	玩家buff key
     */
    public static final String KEY_BUFF = "Buff_{0}";
    /**
     *	月卡
     */
    public static final String KEY_BUFF_MONTH_CARD = "Month_Card";
    /**
     *	npc技能
     */
    public static final String KEY_BUFF_NPC_SKILL = "Npc_Skill";

    /**
     *	其他数据 key
     */
    public static final String KEY_OTHER = "Other_{0}";
    /**
     *	每天进入挖矿次数
     */
    public static final String KEY_OTHER_MINE_COUNT = "Mine_Count";
    /**
     *	每天自动鉴定次数
     */
    public static final String KEY_OTHER_VERIFY_COUNT = "Verify_Count";
    /**
     *	鉴定 key
     */
    public static final String KEY_VERIFY = "Verify_{0}";
    /**
     *	鉴定列表（选择用）
     */
    public static final String KEY_VERIFY_LIST = "Verify_List";
    /**
     *	鉴定队列
     */
    public static final String KEY_VERIFY_QUEUE = "Verify_Queue";
    /**
     *	鉴定更新
     */
    public static final String KEY_VERIFY_UPDATE = "Verify_Update";
    /**
     *	小寻鉴定 key
     */
    public static final String KEY_ROBOT_VERIFY = "Robot_Verify_{0}";
    /**
     *	小寻鉴定列表（选择用）
     */
    public static final String KEY_ROBOT_VERIFY_LIST = "Robot_Verify_List";
    /**
     *	小寻鉴定队列
     */
    public static final String KEY_ROBOT_VERIFY_QUEUE = "Robot_Verify_Queue";
    /**
     *	小寻鉴定更新
     */
    public static final String KEY_ROBOT_VERIFY_UPDATE = "Robot_Verify_Update";

    /**
     *	展厅key
     */
    public static final String KEY_ROBOT_SHOW_TABLE = "Robot_Show_Table_{0}";
    /**
     *	展厅key
     */
    public static final String KEY_ROBOT_SHOW_TABLE_INFO = "Robot_Show_Table_Info_{0}";
    /**
     *	宝物，字画展厅
     */
    public static final String KEY_ROBOT_SHOW_TABLE_COL_0 = "Robot_Col_0";
    /**
     *	水族馆展厅
     */
    public static final String KEY_ROBOT_SHOW_TABLE_COL_1 = "Robot_Col_1";
    /**
     *	标本展厅
     */
    public static final String KEY_ROBOT_SHOW_TABLE_COL_2 = "Robot_Col_2";
    /**
     *	字画展厅（废弃）
     */
    public static final String KEY_ROBOT_SHOW_TABLE_COL_3 = "Robot_Col_3";
    /**
     *	馆藏值
     */
    public static final String KEY_ROBOT_SHOW_TABLE_MONEY = "Robot_Money";
    /**
     *	展厅点赞
     */
    public static final String KEY_ROBOT_SHOW_TABLE_SUPPORT = "Robot_Support";
}
