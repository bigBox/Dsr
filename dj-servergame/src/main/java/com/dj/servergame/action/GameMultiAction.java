package com.dj.servergame.action;

import com.dj.protobuf.Module;
import com.dj.protobuf.ErrorIDOuterClass.ErrorID;
import com.dj.protobuf.ProtobufCmd;
import com.dj.protobuf.forward.ForwardGameMultiReq;
import com.dj.protobuf.forward.ForwardGameMultiRsp;
import com.dj.protobuf.scene.CheckSceneReq;
import com.dj.protobuf.scene.CheckSceneRsp;
import com.dj.protobuf.scene.JoinSceneReq;
import com.dj.protobuf.scene.JoinSceneRsp;
import com.dj.protobuf.scene.LeaveSceneReq;
import com.dj.protobuf.scene.LeaveSceneRsp;
import com.dj.protobuf.scene.SceneMovementReq;
import com.dj.protobuf.scene.SceneMovementRsp;
import com.dj.protobuf.scene.SceneUseSkillReq;
import com.dj.protobuf.scene.SceneUseSkillRsp;
import com.dj.servercore.action.base.BaseAction;
import com.dj.servercore.action.base.IActionCmd;
import com.dj.servercore.action.base.IActionModule;
import com.dj.servercore.action.base.IFieldHandler;
import com.dj.servercore.task.msg.MyMsg;
import com.dj.servergame.handler.GameMineHandler;
import com.dj.domain.util.StringUtil;
import com.dj.domain.util.Utility;
import com.google.protobuf.GeneratedMessageV3;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;

/**
 * @author zcq
 * @ClassName: GameMultiAction
 * @Description: 多人游戏
 * @date 2019年6月25日
 */
@Slf4j
@Data
@EqualsAndHashCode(callSuper = false)
@IActionModule(module = Module.GAME_MULTI)
public class GameMultiAction extends BaseAction {

    @IFieldHandler
    private GameMineHandler gameMineHandler;

    @IActionCmd(cmd = ProtobufCmd.SERVER_FORWARD_GAMEMULTI_REQ)
    public Long forwardGameMultiReq(MyMsg msg) {
        ForwardGameMultiReq forward = msg.getContent(ForwardGameMultiReq.class);
        try {
            GeneratedMessageV3 rspContent = doReqHandler(forward.getRoleID(), forward.getReqClz(), forward.getReq(), forward.getPs());
            if (rspContent != null) {
                ForwardGameMultiRsp.Builder builder = msg.getResultBuilder(ForwardGameMultiRsp.class);
                builder.setRoleID(forward.getRoleID());
                builder.setRsp(rspContent.toByteString());
                builder.setRspClz(rspContent.getClass().getName());
                log.debug("roleID 【{}】, rsp:{}, content:{}", forward.getRoleID(), rspContent.getClass().getSimpleName(), StringUtil.msg2Json(rspContent));
            }
        } catch (Exception e) {
            log.error(Utility.getTraceString(e));
        }
        return forward.getRoleID();
    }

    // 加入场景
    public GeneratedMessageV3 joinSceneReq(long roleID, JoinSceneReq req, String ps) {
        JoinSceneRsp.Builder builder = JoinSceneRsp.newBuilder();
        builder.setReq(req);
        ErrorID result = handleService(() -> {
            gameMineHandler.joinScene(roleID, req, builder, Integer.parseInt(ps));
        });
        builder.setErrorID(result);
        return builder.build();
    }

    // 离开场景
    public GeneratedMessageV3 leaveSceneReq(long roleID, LeaveSceneReq req, String ps) {
        LeaveSceneRsp.Builder builder = LeaveSceneRsp.newBuilder();
        ErrorID result = handleService(() -> {
            gameMineHandler.leaveScene(roleID);
        });
        builder.setErrorID(result);
        return builder.build();
    }

    // 场景移动
    public GeneratedMessageV3 sceneMovementReq(long roleID, SceneMovementReq req, String ps) {
        SceneMovementRsp.Builder builder = SceneMovementRsp.newBuilder();
        ErrorID result = handleService(() -> {
            gameMineHandler.sceneMovement(roleID, req);
        });
        builder.setErrorID(result);
        return builder.build();
    }

    // 场景使用技能-挖矿
    public GeneratedMessageV3 sceneUseSkillReq(long roleID, SceneUseSkillReq req, String ps) {
        SceneUseSkillRsp.Builder builder = SceneUseSkillRsp.newBuilder();
        builder.setReq(req);
        handleService(() -> {
            gameMineHandler.sceneUseSkill(roleID, req, builder);
        });
        return builder.build();
    }

    // 检查当前是否在某个场景
    public GeneratedMessageV3 checkSceneReq(long roleID, CheckSceneReq req, String ps) {
        CheckSceneRsp.Builder builder = CheckSceneRsp.newBuilder();
        ErrorID result = handleService(() -> {
            gameMineHandler.checkScene(roleID, req, builder);
        });
        builder.setErrorID(result);
        return builder.build();
    }
}
