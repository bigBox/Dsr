package com.dj.domain.enums;

public enum AchievementActionEnum {

	
	ROB(1, "宝藏探险");

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

    private int type;
    private String desc;

    AchievementActionEnum(int type, String desc) {
        this.type = type;
        this.desc = desc;
    }
}
