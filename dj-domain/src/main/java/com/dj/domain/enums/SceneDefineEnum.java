package com.dj.domain.enums;

import com.dj.domain.util.StringUtil;

public enum SceneDefineEnum {
	scene_1	(1,"塞外江南","scene_1"),
	scene_2	(2,"茶马古道","scene_2"),
	scene_3	(3,"西夏风光","scene_3"),
	scene_4	(4,"楼兰古图","scene_4"),
	scene_101 (101,"秋香","scene_101"),
	scene_102 (102,"唐百虎","scene_102"),
	scene_103 (103,"石榴姐","scene_103"),
	scene_104 (104,"胡蝶","scene_104"),
	scene_105 (105,"杜月笙","scene_105"),
	scene_106 (106,"李叔同","scene_106"),
	scene_107 (107,"小混混","scene_107"),
	scene_108 (108,"沈万山","scene_108"),
	scene_109 (109,"西施","scene_109"),
	scene_110 (110,"建文帝","scene_110"),
	scene_211 (211,"低金精灵","scene_211"),
	scene_212 (212,"低木精灵","scene_212"),
	scene_213 (213,"低水精灵","scene_213"),
	scene_214 (214,"低火精灵","scene_214"),
	scene_215 (215,"低土精灵","scene_215"),
	scene_221 (221,"初金精灵","scene_221"),
	scene_222 (222,"初木精灵","scene_222"),
	scene_223 (223,"初水精灵","scene_223"),
	scene_224 (224,"初火精灵","scene_224"),
	scene_225 (225,"初土精灵","scene_225"),
	scene_231 (231,"中金精灵","scene_231"),
	scene_232 (232,"中木精灵","scene_232"),
	scene_233 (233,"中水精灵","scene_233"),
	scene_234 (234,"中火精灵","scene_234"),
	scene_235 (235,"中土精灵","scene_235"),
	scene_241 (241,"高金精灵","scene_241"),
	scene_242 (242,"高木精灵","scene_242"),
	scene_243 (243,"高水精灵","scene_243"),
	scene_244 (244,"高火精灵","scene_244"),
	scene_245 (245,"高土精灵","scene_245");

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

    SceneDefineEnum(int sceneId, String desc, String method) {
        this.sceneId = sceneId;
        this.desc = desc;
        this.method = method;
    }

    public static int getSceneIdByMethodName(String method){
		if(StringUtil.isNotEmpty(method)) {
			for (SceneDefineEnum enumItem : SceneDefineEnum.values()) {
				if (enumItem.getMethod().equals(method)) {
					return enumItem.sceneId;
				}
			}
		}
		return 0;
	}
}
