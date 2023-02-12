package com.dj.servercore.server.netty.coder;

import java.lang.reflect.Method;
import java.util.List;

import com.dj.protobuf.ProtobufCmdPool;
import com.dj.servercore.pool.ProtobufFactory;
import com.dj.servercore.task.msg.MyMsg;
import com.dj.domain.util.Utility;
import com.google.protobuf.GeneratedMessageV3;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MyProtobufDecoder extends MessageToMessageDecoder<ByteBuf> {

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf byteBuf, List<Object> out) throws Exception {
        int cmd = byteBuf.readShortLE();
        try {
            int length = byteBuf.readIntLE();
            byte[] data = new byte[length];
            byteBuf.readBytes(data);
            // 反序列化
            MyMsg result = decodeBody(cmd, data, 0, length);
            if (null == result) {
                return;
            }
            out.add(result);
        } catch (Exception e) {
            log.error("error cmd {} decode", cmd);
            log.error(Utility.getTraceString(e));
        }
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    public MyMsg decodeBody(int cmd, byte[] array, int offset, int length) throws Exception {
        GeneratedMessageV3 content;
        Class cls = ProtobufCmdPool.INSTANCE.getCls(cmd);
        if (cls == null) {
            return null;
        }
        Method method = cls.getMethod("getDefaultInstance");
        GeneratedMessageV3 generatedMessageV3 = (GeneratedMessageV3) method.invoke(cls);
        content = generatedMessageV3.getParserForType().parseFrom(array, offset, length);
        if (content == null) {
            return null;
        }
        long roleID = 0;
        try {
            if (cls.getMethod("getRoleID") != null) {
                roleID = (long) cls.getMethod("getRoleID").invoke(content);
            }
        } catch (Exception e) {
//        	log.error(Utility.getTraceString(e));
        }
        MyMsg myMsg = ProtobufFactory.borrowMyMsg(MyMsg.class, cmd, content, roleID);
        return myMsg;
    }
}