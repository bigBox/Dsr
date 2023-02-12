package com.dj.servergame.action;

import com.dj.protobuf.Module;
import com.dj.protobuf.ProtobufCmd;
import com.dj.protobuf.chat.ChatSendReq;
import com.dj.protobuf.chat.EChatChannel;
import com.dj.servercore.action.base.BaseAction;
import com.dj.servercore.action.base.IActionCmd;
import com.dj.servercore.action.base.IActionModule;
import com.dj.servercore.action.base.IFieldHandler;
import com.dj.servercore.task.msg.MyMsg;
import com.dj.servergame.handler.GameMineHandler;
import com.dj.servergame.handler.GameVerifyHandler;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@EqualsAndHashCode(callSuper = false)
@IActionModule(module = Module.CHAT)
public class GameChatAction extends BaseAction {

    @IFieldHandler
    private GameMineHandler gameMineHandler;
    @IFieldHandler
    private GameVerifyHandler gameVerifyHandler;

    @IActionCmd(cmd = ProtobufCmd.CLIENT_CHAT_SEND_REQ)
    public void chatSendReq(MyMsg msg) {
        ChatSendReq req = msg.getContent(ChatSendReq.class);
        log.info("roleID {}, channel {}, content {}", req.getRoleID(), req.getChannel(), req.getContent());
        if (req.getChannel() == EChatChannel.Mine) {
            gameMineHandler.chatSendNtf(req);
        } else if (req.getChannel() == EChatChannel.Verify) {
            gameVerifyHandler.chatSendNtf(req);
        }
    }
}
