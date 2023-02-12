package com.dj.domain.enums;

public enum TaskActionEnum {
    ROB_GUIDE				(1, 	"宝藏任务"),
	VERIFY_ME				(2, 	"鉴定宝物"),
	VERIFY_FRIEND			(3, 	"帮助（好友）鉴定宝物"),
	SHOW_TREASURE			(4, 	"展示宝物"),
	SUMMON_TREASURE			(5, 	"精灵寻宝"),
	PARK_PLANT_GREEN		(6, 	"沙漠绿化"),
	SUMMON_INVEST			(7, 	"精灵投资"),
	ROB_TREASURE			(8, 	"宝藏寻宝"),
	COLLECTION_REWARD		(9, 	"套装兑奖"),
	BOOK_LIGHT_TREASURE1	(10, 	"点亮宝物"),
	COLLECT_MAP_FRAGMENT	(11, 	"收集地图碎片"),
	EXPAND_CAMP				(12, 	"扩充营地"),
	ADD_FRIEND				(13, 	"添加好友"),
	TRADE					(14, 	"完成交易"),
	CREATE_GUILD			(15, 	"建立商会"),
	HAS_GUILD				(16, 	"加入商会"),
	FINISH_GUILD_TASK		(17, 	"完成商会任务"),
	JOIN_GUILD_BATTLE		(18, 	"参加商会比赛"),
	TRIGGER_NPC_SKILL		(19, 	"结交NPC"),
	BUY_MONTH_CARD			(20, 	"购买月卡"),
	PARK_FISH_TASK			(21, 	"养鱼任务"),
	CONJURE_ANIMALS			(22, 	"召唤动物"),
	PARK_ANIMALS			(23, 	"饲养动物"),
	PRODUCE_GOODS			(24, 	"生产物品"),
	MINI_GAME_SCORE			(25, 	"玩小游戏超过多少分"),
	//MINI_GAME_SCORE1		(26, 	"玩某款小游戏超过多少分"),
	//MINI_GAME_TIME			(27, 	"玩小游戏多少次"),
	//MINI_GAME_TIME1			(28, 	"玩某款小游戏多少次"),
	ROB_TREASURE_HELP		(29, 	"看两个探险玩法帮助"),

	ACTIVE_DAY				(900, 	"活跃天数", "doActionActiveDay"),
	NEED_ITEM				(910, 	"接任务之后，找到物品，进背包", null),
	USE_ITEM				(920, 	"接任务之后，使用物品", null);

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	private int type;
    private String desc;
    private String method;

    TaskActionEnum(int type, String desc, String method) {
        this.type = type;
        this.desc = desc;
        this.method = method;
    }
    
    TaskActionEnum(int type, String desc) {
    	this.type = type;
    	this.desc = desc;
    	this.method = "doActionCommonTime";
    }
    
//    public static void main(String[] args) {
//		for(TaskActionEnum enum1 : TaskActionEnum.values()) {
//			System.out.print(enum1.getType()+":"+enum1.getDesc()+",	");
//		}
//	}
}
