package com.dj.domain.data.meetEgg;

import java.util.Date;
import java.util.Map;

import com.dj.domain.util.DateUtil;
import com.google.common.collect.Maps;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author zcq
 * @description 接鸡蛋房间
 * @date 2019年5月24日
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class MeetEggRoom {

    /**
     *	房间主人
     */
    private long roleID;

    private int gateServerID;

    private Date startDate;

    private int buildID;

    private int positionX;

    // 方向， 2向右，1向左, 0原地不动
    private int directionX;

    /**
     *	配方id
     */
    private int makeID;
    /**
     *	下一个配方id1
     */
    private int nextMakeID1;
    /**
     *	下一个配方id2
     */
    private int nextMakeID2;

    /**
     *	接到的物品数量
     */
    private Map<Integer, Integer> meetItemMap = Maps.newHashMapWithExpectedSize(3);
    /**
     *	积分翻倍到期时间
     */
    private long doubleEndTime;

    /**
     *	总积分
     */
    private int totalScore;

    /**
     *	上次飞行物出现事件
     */
    private long lastFlyTime;

    /**
     * 2结束 1暂停， 0开始
     */
    private int state;

    private Date pauseDate;
    /**
     *	暂停的秒数
     */
    private int pauseSecond;
    
    /**
     * 作弊
     */
    private boolean zero = false;

    public MeetEggRoom(long roleID) {
        this.roleID = roleID;
        startDate = DateUtil.getCurrentDate();
        zero = false;
    }
}
