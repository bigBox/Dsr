package com.dj.domain.data.meetEgg;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author zcq
 * @ClassName: MeetEggBuild
 * @Description: 单人接鸡蛋建筑数据
 * @date 2019年7月22日
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class MeetEggBuild {

    /**
     *	建筑id
     */
    private int buildID;
    /**
     *	接鸡蛋时间
     */
    private long meetEggTime;
    /**
     *	积分
     */
    private int score;
    /**
     *	上次发放奖励时间
     */
    private long lastRewardTime;
}
