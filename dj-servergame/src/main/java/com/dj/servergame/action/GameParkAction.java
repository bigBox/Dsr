package com.dj.servergame.action;

import com.dj.domain.util.StringUtil;
import com.dj.domain.util.Utility;
import com.dj.protobuf.ErrorIDOuterClass.ErrorID;
import com.dj.protobuf.Module;
import com.dj.protobuf.ProtobufCmd;
import com.dj.protobuf.forward.ForwardGameParkReq;
import com.dj.protobuf.forward.ForwardGameParkRsp;
import com.dj.protobuf.park.ParkInfoReq;
import com.dj.protobuf.park.ParkInfoRsp;
import com.dj.servercore.action.base.BaseAction;
import com.dj.servercore.action.base.IActionCmd;
import com.dj.servercore.action.base.IActionModule;
import com.dj.servercore.action.base.IFieldHandler;
import com.dj.servercore.task.msg.MyMsg;
import com.dj.servergame.handler.GameParkHandler;
import com.google.protobuf.GeneratedMessageV3;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;

/**
 * @author zcq
 * @ClassName: GameParkAction
 * @Description: 生态园
 * @date 2019年6月25日
 */
@Slf4j
@Data
@EqualsAndHashCode(callSuper = false)
@IActionModule(module = Module.GAME_PARK)
public class GameParkAction extends BaseAction {

    @IFieldHandler
    private GameParkHandler gameParkHandler;

    @IActionCmd(cmd = ProtobufCmd.SERVER_FORWARD_GAMEPARK_REQ)
    public Long forwardGameParkReq(MyMsg msg) {
        ForwardGameParkReq forward = msg.getContent(ForwardGameParkReq.class);
        try {
            GeneratedMessageV3 rspContent = doReqHandler(forward.getRoleID(), forward.getReqClz(), forward.getReq());
            if (rspContent != null) {
                ForwardGameParkRsp.Builder builder = msg.getResultBuilder(ForwardGameParkRsp.class);
                builder.setRoleID(forward.getRoleID());
                builder.setRsp(rspContent.toByteString());
                builder.setRspClz(rspContent.getClass().getName());
                log.debug("roleID 【{}】, roleID 【{}】, rsp:{}, content:{}", forward.getRoleID(), forward.getRoleID(), rspContent.getClass().getSimpleName(), StringUtil.msg2Json(rspContent));
            }
        } catch (Exception e) {
            log.error(Utility.getTraceString(e));
        }
        return forward.getRoleID();
    }

    // 获取生态园信息
    public GeneratedMessageV3 parkInfoReq(long roleID, ParkInfoReq req) {
        ParkInfoRsp.Builder builder = ParkInfoRsp.newBuilder();
        ErrorID result = handleService(() -> {
            gameParkHandler.parkInfo(req.getRoleId(), builder);
        });
        builder.setErrorID(result);
        return builder.build();
    }
}
