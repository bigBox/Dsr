package com.dj.serverglobal.action;

import com.dj.protobuf.Module;
import com.dj.protobuf.ProtobufCmd;
import com.dj.protobuf.chat.ChatSendReq;
import com.dj.servercore.action.base.BaseAction;
import com.dj.servercore.action.base.IActionCmd;
import com.dj.servercore.action.base.IActionModule;
import com.dj.servercore.action.base.IFieldHandler;
import com.dj.servercore.task.msg.MyMsg;
import com.dj.serverglobal.handler.GlobalChatHandler;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@EqualsAndHashCode(callSuper = false)
@IActionModule(module = Module.CHAT)
public class GlobalChatAction extends BaseAction {

    @IFieldHandler
    private GlobalChatHandler globalChatHandler;

    @IActionCmd(cmd = ProtobufCmd.CLIENT_CHAT_SEND_REQ)
    public void chatSendReq(MyMsg msg) {
        ChatSendReq content = msg.getContent(ChatSendReq.class);
        log.info("roleID {}, channel {}, content {}", content.getRoleID(), content.getChannel(), content.getContent());
        globalChatHandler.chatSendNtf(content);
    }
}
