package com.dj.domain.data.game;

import java.util.Map;

import com.google.common.collect.Maps;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author zcq
 * @description 挖矿房间
 * @date 2019年4月12日
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class MineRoom {

    /**
     *	房主
     */
    private String mapOwner;

    private Map<Long, MineRole> mineRoleMap = Maps.newHashMapWithExpectedSize(3);

    private long resetTime;
    
    private int xxChatCount;

    public MineRoom(String mapOwner) {
        this.mapOwner = mapOwner;
        this.xxChatCount = 0;
    }
}
