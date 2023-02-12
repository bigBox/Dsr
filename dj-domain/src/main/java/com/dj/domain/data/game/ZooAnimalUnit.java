package com.dj.domain.data.game;

import com.dj.domain.config.ConfigFarmZooAnimal;
import com.dj.domain.util.DateUtil;
import com.dj.protobuf.datetime.DateTime;
import com.dj.protobuf.park.ParkStatus;
import com.dj.protobuf.park.ZooAnimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.concurrent.TimeUnit;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ZooAnimalUnit {

    private String animalTimeID;
    /**
     *	动物id
     */
    private int animalID;

    /**
     *	放置时间
     */
    private long placeTime;

    /**
     *	出生时间
     */
    private long birthTime;

    /**
     *	收获次数
     */
    private int harvestNum;

    /**
     *	上次食草时间
     */
    private long eatTime;

    /**
     *	食草量
     */
    private int eatNum;

    /**
     * 0正常，1枯萎
     */
    private int status;

    /**
     *	稀有动物来源
     */
    private int source;

    // 便便位置
    private int x;
    private int y;
    // 推送标记
    private boolean ntfFlag = false;

    /**
     *	成熟时间（ms）
     */
    private long cookingTime;

    public ZooAnimal toZooAnimal(ZooAnimal.Builder builder, Date nowTime, ConfigFarmZooAnimal config) {
        builder.setAnimalTimeID(animalTimeID);
        builder.setAnimalID(animalID);
        builder.setPlaceTime(DateTime.newBuilder().setValue(placeTime));
        int  leftSeconds = 0;
        if(config.getCookingTime() > 0) {
            Date cookingTimeDate = new Date(birthTime + cookingTime);
            if (nowTime.getTime() < cookingTimeDate.getTime()) {
                leftSeconds = DateUtil.secondsBetween(nowTime, cookingTimeDate);
            }
        }
        builder.setLeftSeconds(leftSeconds);
        builder.setHarvestNum(harvestNum);
        // 收获状态 0：不可收获，1：可收获
        if(config.getEatNum() > 0) {
            if (leftSeconds == 0 && eatNum >= config.getEatNum()) {
                builder.setHarvestState(1);
            } else {
                builder.setHarvestState(0);
            }
        }
        // 放置时间
        Date placeDate = new Date(placeTime);
        // 生存的秒数
        int liveSeconds = 0;
        if (config.getLifeTime() > 0) {
            Date liveTime = DateUtil.plusTime(placeDate, TimeUnit.MINUTES, config.getLifeTime());
            if (nowTime.getTime() < liveTime.getTime()) {
                liveSeconds = DateUtil.secondsBetween(nowTime, liveTime);
            }
        }
        builder.setLiveSeconds(liveSeconds);
        builder.setStatus(ParkStatus.forNumber(status));
        // 稀有动物来源
        builder.setSource(source);
        // 便便位置
        builder.setX(x);
        builder.setY(y);
        // 稀有动物自动离开时间
        int leaveSeconds = 0;
        Date leaveTime = DateUtil.plusTime(placeDate, TimeUnit.DAYS, 1);
        if (nowTime.getTime() < leaveTime.getTime()) {
            leaveSeconds = DateUtil.secondsBetween(nowTime, leaveTime);
        }
        builder.setLeaveSeconds(leaveSeconds);
        return builder.build();
    }
}
