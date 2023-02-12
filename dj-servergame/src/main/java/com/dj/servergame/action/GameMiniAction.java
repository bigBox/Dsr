package com.dj.servergame.action;

import com.dj.protobuf.Module;
import com.dj.protobuf.ProtobufCmd;
import com.dj.protobuf.forward.ForwardGameMiniReq;
import com.dj.protobuf.forward.ForwardGameMiniRsp;
import com.dj.servercore.action.base.BaseAction;
import com.dj.servercore.action.base.IActionCmd;
import com.dj.servercore.action.base.IActionModule;
import com.dj.servercore.action.base.IFieldHandler;
import com.dj.servercore.task.msg.MyMsg;
import com.dj.servergame.handler.GameMiniHandler;
import com.dj.domain.util.StringUtil;
import com.dj.domain.util.Utility;
import com.google.protobuf.GeneratedMessageV3;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;

/**
 * @author zcq
 * @description 小游戏
 * @date 2019年5月15日
 */
@Slf4j
@Data
@EqualsAndHashCode(callSuper = false)
@IActionModule(module = Module.GAME_MINI)
public class GameMiniAction extends BaseAction {

    @IFieldHandler
    private GameMiniHandler gameMiniHandler;

    @IActionCmd(cmd = ProtobufCmd.SERVER_FORWARD_GAMEMINI_REQ)
    public Long forwardGameMiniReq(MyMsg msg) {
        ForwardGameMiniReq forward = msg.getContent(ForwardGameMiniReq.class);
        try {
            GeneratedMessageV3 rspContent = doReqHandler(forward.getRoleID(), forward.getReqClz(), forward.getReq());
            if (rspContent != null) {
                ForwardGameMiniRsp.Builder builder = msg.getResultBuilder(ForwardGameMiniRsp.class);
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
    
    
}
