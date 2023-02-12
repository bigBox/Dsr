package com.dj.servergame.action;

import com.dj.protobuf.Module;
import com.dj.protobuf.ProtobufCmd;
import com.dj.protobuf.server.KeepAlive4GameRsp;
import com.dj.protobuf.server.RegisterGate2GameReq;
import com.dj.protobuf.server.RegisterGate2GameRsp;
import com.dj.protobuf.server.UpdateConfig4GameReq;
import com.dj.servercore.action.base.BaseAction;
import com.dj.servercore.action.base.IActionCmd;
import com.dj.servercore.action.base.IActionModule;
import com.dj.servercore.conf.base.BaseConfManager;
import com.dj.servercore.task.msg.MyMsg;
import com.dj.servergame.manager.ChannelManager;
import com.dj.servergame.server.GameServer;
import com.dj.domain.util.GsonUtil;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zcq
 * @description 游戏服务器
 * @date 2019年4月18日
 */
@Slf4j
@IActionModule(module = Module.GAME_SERVER)
public class GameServerAction extends BaseAction {

    @IActionCmd(cmd = ProtobufCmd.SERVER_REGISTER_GATE2GAME_REQ)
    public void registerGate2GameReq(MyMsg msg) {
        RegisterGate2GameReq content = msg.getContent(RegisterGate2GameReq.class);
        log.info("GameServer and GateServer channel:" + GsonUtil.toJson(content));
        ChannelManager.getInstance().addChannel(content.getServerId(), msg.getChannel());

        RegisterGate2GameRsp.Builder builder = msg.getResultBuilder(RegisterGate2GameRsp.class);
        builder.setServerId(GameServer.getServerConfig().getId());
        builder.setServerName(GameServer.getServerConfig().getName());
    }

    @IActionCmd(cmd = ProtobufCmd.SERVER_KEEPALIVE4GAME_REQ)
    public void keepAlive4Game(MyMsg msg) {
        msg.getResultBuilder(KeepAlive4GameRsp.class);
    }

    @IActionCmd(cmd = ProtobufCmd.SERVER_UPDATE_CONFIG_4GAME_REQ)
    public void updateConfig4GameReq(MyMsg msg) {
        UpdateConfig4GameReq content = msg.getContent(UpdateConfig4GameReq.class);
        BaseConfManager.getInstance().updateConfig(content.getJsonConfigName());
    }
}
