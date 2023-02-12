package com.dj.domain.enums;

public enum PlayerAttrEnum {

    // 等级
    LEVEL("Level", 1),

    // 金币
    GOLD("Gold", 30000, 1),

    // 钻石
    DIAMOND("Diamond", 1000, 2),

    // 体力
    STAMINA("Stamina", 1000, 3),

    // 经验
    EXP("Experience", 0, 4),

    // 声望
    RENOWN("Reputation", 0, 39),

    // 声望等级
    RENOWN_LEVEL("ReputationLevel", 1),
    
    // 成就
    ACHIEVEMENT("Achievement", 0, 0),
    
    // 成就等级
    ACHIEVEMENT_LEVEL("AchievementLevel", 1),

    // 馆藏
    SHOWTABLE("ShowTable", 0),

    // 馆藏等级
    SHOWTABLE_LEVEL("ShowTableLevel", 1),

    // 生态值
    ECOLOGY("Ecology", 0),

    // 繁荣度
    BOOM("Boom", 0),
    
	// 商会积分
    GUILDSCORE("GuildScore", 0);

    private String key;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public int getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(int defaultValue) {
        this.defaultValue = defaultValue;
    }

    public int getVirtualItemID() {
        return virtualItemID;
    }

    public void setVirtualItemID(int virtualItemID) {
        this.virtualItemID = virtualItemID;
    }

    private int defaultValue;
    /**
     * 虚拟物品id
     */
    private int virtualItemID;

    PlayerAttrEnum(String key, int defaultValue) {
        this.key = key;
        this.defaultValue = defaultValue;
        this.virtualItemID = 0;
    }
    
    PlayerAttrEnum(String key, int defaultValue, int virtualItemID) {
    	this.key = key;
    	this.defaultValue = defaultValue;
    	this.virtualItemID = virtualItemID;
    }
}
