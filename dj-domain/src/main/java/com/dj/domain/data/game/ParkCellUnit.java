package com.dj.domain.data.game;

import java.util.Date;

import com.dj.protobuf.datetime.DateTime;
import com.dj.protobuf.park.ParkCell;
import com.dj.protobuf.park.ParkStatus;
import com.dj.domain.util.DateUtil;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ParkCellUnit {

    private int x;

    private int y;

    /**
     *	植物id
     */
    private int plantID;

    /**
     *	放置时间
     */
    private long placeTime;

    /**
     *	出生时间
     */
    private long birthTime;

    /**
     *	绿化值
     */
    private int green;

    /**
     *	收获次数
     */
    private int harvestNum;

    /**
     * 0正常，1枯萎
     */
    private int status;

    /**
     *	产出（饲养）-物品id
     */
    private int feedID;

    /**
     *	（饲养）数量
     */
    private int feedNum;

    /**
     *	成熟时间（ms）
     */
    private long cookingTime;

    public ParkCell toParkCell() {
        ParkCell.Builder builder = ParkCell.newBuilder();
        builder.setX(x);
        builder.setY(y);
        builder.setPlantID(plantID);
        builder.setPlaceTime(DateTime.newBuilder().setValue(placeTime));
        int leftSeconds = 0;
        if(plantID > 0) {
            Date nowTime = DateUtil.getCurrentDate();
            Date cookingTimeDate = new Date(birthTime + cookingTime);
            if (nowTime.getTime() < cookingTimeDate.getTime()) {
                leftSeconds = DateUtil.secondsBetween(nowTime, cookingTimeDate);
            }
        }
        builder.setLeftSeconds(leftSeconds);
        builder.setGreen(green);
        builder.setHarvestNum(harvestNum);
        builder.setStatus(ParkStatus.forNumber(status));
        return builder.build();
    }

//    public ParkCell toParkPlantCell() {
//        ParkCell.Builder builder = ParkCell.newBuilder();
//        builder.setX(x);
//        builder.setY(y);
//        builder.setPlantID(plantID);
//        builder.setPlaceTime(DateTime.newBuilder().setValue(placeTime));
//        int leftSeconds = 0;
//        if(plantID > 0) {
//            Date nowTime = DateUtil.getCurrentDate();
//            Date cookingTimeDate = new Date(birthTime + cookingTime);
//            if (nowTime.getTime() < cookingTimeDate.getTime()) {
//                leftSeconds = DateUtil.secondsBetween(nowTime, cookingTimeDate);
//            }
//        }
//        builder.setLeftSeconds(leftSeconds);
//        builder.setGreen(green);
//        builder.setHarvestNum(harvestNum);
//        builder.setStatus(ParkStatus.forNumber(status));
//        return builder.build();
//    }

//    public ParkCell toParkTreeCell() {
//        ParkCell.Builder builder = ParkCell.newBuilder();
//        builder.setX(x);
//        builder.setY(y);
//        builder.setPlantID(plantID);
//        builder.setPlaceTime(DateTime.newBuilder().setValue(placeTime));
//        int leftSeconds = 0;
//        if(plantID > 0) {
//            Date nowTime = DateUtil.getCurrentDate();
//            Date cookingTimeDate = new Date(birthTime + cookingTime);
//            if (nowTime.getTime() < cookingTimeDate.getTime()) {
//                leftSeconds = DateUtil.secondsBetween(nowTime, cookingTimeDate);
//            }
//        }
//        builder.setLeftSeconds(leftSeconds);
//        builder.setGreen(green);
//        builder.setHarvestNum(harvestNum);
//        builder.setStatus(ParkStatus.forNumber(status));
//        return builder.build();
//    }
}
