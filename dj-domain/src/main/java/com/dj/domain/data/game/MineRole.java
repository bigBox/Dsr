package com.dj.domain.data.game;

import com.dj.protobuf.scene.ESceneRolePost;
import com.dj.protobuf.scene.ESceneUseSkillType;
import com.dj.protobuf.scene.OtomeVector3D;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author zcq
 * @description 挖矿角色
 * @date 2019年4月12日
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class MineRole {

    private long roleID;

    /**
     *	职位
     */
    private ESceneRolePost post;

    private long enterTime;

    private int positionX;

    private int positionY;

    private int positionZ;

    private float speed;

    private int directionX;

    private int directionY;

    private int directionZ;

    private int skillId;

    private long targetRoleId;

    /// <summary>
    /// 技能状态， start为使用技能状态，cancel为空闲状态
    /// </summary>
    private ESceneUseSkillType type;

    /// <summary>
    /// 技能发起方方向信息
    /// </summary>
    private OtomeVector3D srcRoleDirection;

    /// <summary>
    /// 技能目标方方向信息
    /// </summary>
    private OtomeVector3D targetRoleDirection;
    
    public MineRole(long roleID) {
        this.roleID = roleID;
        enterTime = System.currentTimeMillis();
    }

    public OtomeVector3D getPosition() {
        OtomeVector3D.Builder position = OtomeVector3D.newBuilder();
        position.setX(positionX);
        position.setY(positionY);
        position.setZ(positionZ);
        return position.build();
    }
}
