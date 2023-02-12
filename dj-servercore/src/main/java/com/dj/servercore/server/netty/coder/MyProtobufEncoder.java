package com.dj.servercore.server.netty.coder;

import java.util.List;

import com.dj.protobuf.ProtobufCmdPool;
import com.google.protobuf.MessageLite;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;


public class MyProtobufEncoder extends MessageToMessageEncoder<MessageLite> {

    private static byte[] SEPARATOR = new byte[]{'.', '_', '-', '_', '.'};

    @Override
    protected void encode(ChannelHandlerContext ctx, MessageLite msg, List<Object> out) {
        ByteBuf byteBuf = ByteBufAllocator.DEFAULT.buffer();
        int cmd = ProtobufCmdPool.INSTANCE.getCmd(msg.getClass());
        byteBuf.writeShortLE(cmd);
        byte[] data = msg.toByteArray();
        byteBuf.writeIntLE(data.length);
        byteBuf.writeBytes(data);
        byteBuf.writeBytes(SEPARATOR);
        out.add(byteBuf);
    }
}