package com.dj.domain.enums;

import com.dj.domain.util.StringUtil;

public enum NpcActionDefineEnum {
	ACTION_100 (100,"没有人","action_100"),
	ACTION_101 (101,"对诗","action_101"),
	ACTION_102 (102,"赛马","action_102"),
	ACTION_103 (103,"要金币","action_103"),
	ACTION_104 (104,"要东西","action_104"),
	ACTION_105 (105,"打劫","action_105"),
	ACTION_106 (106,"赞美NPC","action_106");

	public int getActionId() {
		return actionId;
	}

	public void setActionId(int actionId) {
		this.actionId = actionId;
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

	private int    actionId;
    private String desc;
	private String method;

    NpcActionDefineEnum(int actionId, String desc, String method) {
        this.actionId = actionId;
        this.desc = desc;
        this.method = method;
    }

    public static int getActionIdByMethodName(String method){
		if(StringUtil.isNotEmpty(method)) {
			for (NpcActionDefineEnum enumItem : NpcActionDefineEnum.values()) {
				if (enumItem.getMethod().equals(method)) {
					return enumItem.actionId;
				}
			}
		}
		return 0;
	}
}
