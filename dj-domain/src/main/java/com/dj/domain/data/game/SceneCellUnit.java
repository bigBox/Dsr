package com.dj.domain.data.game;

import com.dj.protobuf.rob.ERobCellType;
import com.dj.protobuf.rob.RobCell;
import com.dj.protobuf.scene.ESceneCellType;
import com.dj.protobuf.scene.SceneCell;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class SceneCellUnit {

    private int x;

    private int y;
    //地图格子类型 100钻石；101、矿；102五行石矿；103化石；104地图孙碎片；109-功能
    private int type;
    //有没有被挖过的标记 已挖掘数量
    private int stage;
    //
    private boolean isShow;
    //
    //private String cellTypeLandforms;
    //
    private int robId;
    
    public SceneCell toSceneCell(SceneCell.Builder builder) {
        builder.setX(x);
        builder.setY(y);
        builder.setType(ESceneCellType.forNumber(type));
        builder.setStage(stage);
        builder.setIsShow(isShow);
        builder.setRobId(robId);
        return builder.build();
    }

    public RobCell toRobCell(RobCell.Builder builder) {
        builder.setX(x);
        builder.setY(y);
        builder.setType(ERobCellType.forNumber(type));
        builder.setStage(stage);
        builder.setIsShow(isShow);
        builder.setCellTypeLandforms("");
        return builder.build();
    }
}
