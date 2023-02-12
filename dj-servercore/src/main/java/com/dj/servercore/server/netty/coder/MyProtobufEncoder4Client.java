package com.dj.servercore.server.netty.coder;

import java.util.List;

import com.dj.protobuf.ProtobufCmdPool;
import com.dj.servercore.server.base.ServerAttribute;
import com.dj.domain.util.StringUtil;
import com.google.protobuf.GeneratedMessageV3;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;
import io.netty.handler.codec.http.websocketx.BinaryWebSocketFrame;
import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "message")
public class MyProtobufEncoder4Client extends MessageToMessageEncoder<GeneratedMessageV3> {

    @SuppressWarnings("deprecation")
    @Override
    protected void encode(ChannelHandlerContext ctx, GeneratedMessageV3 msg, List<Object> out) {
        ByteBuf byteBuf = ByteBufAllocator.DEFAULT.buffer();
        int cmd = ProtobufCmdPool.INSTANCE.getCmd(msg.getClass());
        byteBuf.writeShortLE(cmd);
        byte[] data = msg.toByteArray();
        byteBuf.writeIntLE(data.length);
        byteBuf.writeBytes(data);
        out.add(new BinaryWebSocketFrame(byteBuf));
        if (log.isDebugEnabled()) {
            long roleID = 0;
            if (ctx.hasAttr(ServerAttribute.roleID)) {
                roleID = ctx.attr(ServerAttribute.roleID).get();
            }
            log.debug("roleID 【{}】, cmd {}, rsp {}, content {}", roleID, cmd, msg.getClass().getSimpleName(), StringUtil.msg2Json(msg));
        }
    }
}