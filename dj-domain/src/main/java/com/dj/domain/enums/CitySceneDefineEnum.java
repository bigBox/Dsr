package com.dj.domain.enums;

import com.dj.domain.util.StringUtil;

public enum CitySceneDefineEnum {
	scene_1 (1,"赛马场","scene_1"),
	scene_2 (2,"百乐门","scene_2"),
	scene_3 (3,"豫园","scene_3"),
	scene_4 (4,"十六铺","scene_4"),
	scene_5 (5,"华府","scene_5"),
	scene_6 (6,"寒山寺","scene_6"),
	scene_7 (7,"拙政园","scene_7");

	public int getSceneId() {
		return sceneId;
	}

	public void setSceneId(int sceneId) {
		this.sceneId = sceneId;
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

	private int    sceneId;
    private String desc;
	private String method;

    CitySceneDefineEnum(int sceneId, String desc, String method) {
        this.sceneId = sceneId;
        this.desc = desc;
        this.method = method;
    }

    public static int getSceneIdByMethodName(String method){
		if(StringUtil.isNotEmpty(method)) {
			for (CitySceneDefineEnum enumItem : CitySceneDefineEnum.values()) {
				if (enumItem.getMethod().equals(method)) {
					return enumItem.sceneId;
				}
			}
		}
		return 0;
	}
}
