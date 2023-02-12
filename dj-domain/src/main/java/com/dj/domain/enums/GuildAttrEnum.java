package com.dj.domain.enums;

public enum GuildAttrEnum {

    // 等级
    LEVEL("Level", 1),

    // 经验
    Experience("Experience", 0);

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

    private String key;
    private int defaultValue;

    GuildAttrEnum(String key, int defaultValue) {
        this.key = key;
        this.defaultValue = defaultValue;
    }
}
