package com.dj.domain.entity.player.task;

import com.dj.domain.util.StringUtil;
import com.dj.domain.util.collection.MapUtil;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@NoArgsConstructor
public class TasksItem {

    private Map<Integer, Integer> needItem;

    private Map<Integer, Integer> curItem;

    public TasksItem(String need) {
        if (StringUtil.isNotEmpty0Null(need)) {
            this.needItem = MapUtil.mapStringToMap1(need);
        }
        this.curItem = new HashMap<>();
    }

    public Map<Integer, Integer> getNeedItem() {
        return needItem;
    }

    public void setNeedItem(Map<Integer, Integer> needItem) {
        this.needItem = needItem;
    }

    public Map<Integer, Integer> getCurItem() {
        return curItem;
    }

    public void setCurItem(Map<Integer, Integer> curItem) {
        this.curItem = curItem;
    }
}
