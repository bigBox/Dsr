package com.dj.domain.data.game;

import java.util.Date;

import com.dj.domain.config.ConfigPoolFishs;
import com.dj.protobuf.datetime.DateTime;
import com.dj.protobuf.park.ParkFish;
import com.dj.domain.util.DateUtil;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ParkFishUnit {
    /**
     *	鱼塘索引
     */
    private int index;
    /**
     *	鱼id
     */
    private int fishID;

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
     *	成熟时间（ms）
     */
    private long cookingTime;

    public ParkFish toParkFish() {
        ParkFish.Builder builder = ParkFish.newBuilder();
        builder.setIndex(index);
        builder.setFishID(fishID);
        builder.setPlaceTime(DateTime.newBuilder().setValue(placeTime));
        Date nowTime = DateUtil.getCurrentDate();
        Date cookingTimeDate = new Date(birthTime + cookingTime);
        int leftSeconds = 0;
        if (nowTime.getTime() < cookingTimeDate.getTime()) {
            leftSeconds = DateUtil.secondsBetween(nowTime, cookingTimeDate);
        }
        builder.setLeftSeconds(leftSeconds);
        return builder.build();
    }
}
