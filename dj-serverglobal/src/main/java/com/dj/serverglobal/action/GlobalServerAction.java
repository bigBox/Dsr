package com.dj.serverglobal.action;

import com.dj.protobuf.Module;
import com.dj.protobuf.ProtobufCmd;
import com.dj.protobuf.server.KeepAlive4GlobalRsp;
import com.dj.protobuf.server.RegisterGate2GlobalReq;
import com.dj.protobuf.server.RegisterGate2GlobalRsp;
import com.dj.protobuf.server.UpdateConfig4GlobalReq;
import com.dj.servercore.action.base.BaseAction;
import com.dj.servercore.action.base.IActionCmd;
import com.dj.servercore.action.base.IActionModule;
import com.dj.servercore.conf.base.BaseConfManager;
import com.dj.servercore.task.msg.MyMsg;
import com.dj.serverglobal.manager.ChannelManager;
import com.dj.serverglobal.server.GlobalServer;
import com.dj.domain.util.GsonUtil;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zcq
 * @description 全局服务器
 * @date 2019年4月18日
 */
@Slf4j
@IActionModule(module = Module.GLOBAL_SERVER)
public class GlobalServerAction extends BaseAction {

    @IActionCmd(cmd = ProtobufCmd.SERVER_REGISTER_GATE2GLOBAL_REQ)
    public void registerGate2GlobalReq(MyMsg msg) {
        RegisterGate2GlobalReq content = msg.getContent(RegisterGate2GlobalReq.class);
        log.info("GlobalServer and GateServer channel:{}",GsonUtil.toJson(content));
        ChannelManager.getInstance().addChannel(content.getServerId(), msg.getChannel());

        RegisterGate2GlobalRsp.Builder builder = msg.getResultBuilder(RegisterGate2GlobalRsp.class);
        builder.setServerId(GlobalServer.getServerConfig().getId());
        builder.setServerName(GlobalServer.getServerConfig().getName());
    }

    @IActionCmd(cmd = ProtobufCmd.SERVER_KEEPALIVE4GLOBAL_REQ)
    public void keepAlive4Global(MyMsg msg) {
        msg.getResultBuilder(KeepAlive4GlobalRsp.class);
    } 

    @IActionCmd(cmd = ProtobufCmd.SERVER_UPDATE_CONFIG_4GLOBAL_REQ)
    public void updateConfig4GlobalReq(MyMsg msg) {
        UpdateConfig4GlobalReq content = msg.getContent(UpdateConfig4GlobalReq.class);
        BaseConfManager.getInstance().updateConfig(content.getJsonConfigName());
    }
}
