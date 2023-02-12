package com.dj.domain.enums;

import com.dj.domain.util.StringUtil;

public enum NpcDefineEnum {
	NPC_1 (1,"秋香","scene_1"),
	NPC_2 (2,"唐百虎","scene_2"),
	NPC_3 (3,"石榴姐","scene_3"),
	NPC_4 (4,"胡蝶","scene_4"),
	NPC_5 (5,"杜月笙","scene_5"),
	NPC_6 (6,"李叔同","scene_6"),
	NPC_7 (7,"小混混","scene_7"),
	NPC_8 (8,"沈万山","scene_8"),
	NPC_9 (9,"西施","scene_9"),
	NPC_10 (10,"建文帝","scene_10");

	public int getNpcId() {
		return npcId;
	}

	public void setNpcId(int npcId) {
		this.npcId = npcId;
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

	private int    npcId;
    private String desc;
	private String method;

    NpcDefineEnum(int npcId, String desc, String method) {
        this.npcId = npcId;
        this.desc = desc;
        this.method = method;
    }

    public static int getNpcIdByMethodName(String method){
		if(StringUtil.isNotEmpty(method)) {
			for (NpcDefineEnum enumItem : NpcDefineEnum.values()) {
				if (enumItem.getMethod().equals(method)) {
					return enumItem.npcId;
				}
			}
		}
		return 0;
	}
}
