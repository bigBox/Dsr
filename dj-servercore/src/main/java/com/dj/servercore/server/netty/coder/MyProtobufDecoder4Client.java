package com.dj.servercore.server.netty.coder;

import com.dj.protobuf.CmdUnit;
import com.dj.protobuf.ProtobufCmdPool;
import com.dj.servercore.pool.ProtobufFactory;
import com.dj.servercore.server.base.ServerAttribute;
import com.dj.servercore.task.msg.MyMsg;
import com.dj.domain.util.StringUtil;
import com.dj.domain.util.Utility;
import com.google.protobuf.GeneratedMessageV3;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Method;
import java.util.List;

@Slf4j(topic = "message")
@SuppressWarnings("deprecation")
public class MyProtobufDecoder4Client extends MessageToMessageDecoder<ByteBuf> {

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf byteBuf, List<Object> out) throws Exception {
        try {
            int cmd = byteBuf.readUnsignedShortLE();
            int length = byteBuf.readIntLE();
            byte[] data = new byte[length];
            byteBuf.readBytes(data);
            long roleID = 0;
            if (ctx.hasAttr(ServerAttribute.roleID)) {
                roleID = ctx.attr(ServerAttribute.roleID).get();
            }
            // 反序列化
            MyMsg result = decode(roleID, cmd, data, 0, length);
            if (null == result) {
                return;
            }
            out.add(result);
        } catch (Exception e) {
            log.error(Utility.getTraceString(e));
        }
    }

    public MyMsg decode(long roleID, int cmd, byte[] array, int offset, int length) throws Exception {
        CmdUnit unit = ProtobufCmdPool.INSTANCE.getUnit(cmd);
        if (unit == null || unit.getCls() == null) {
            log.error("null cmd {}", cmd);
            return null;
        }
        Method method = unit.getCls().getMethod("getDefaultInstance");
        GeneratedMessageV3 generatedMessageV3 = (GeneratedMessageV3) method.invoke(unit.getCls());
        GeneratedMessageV3 req = generatedMessageV3.getParserForType().parseFrom(array, offset, length);
        if (log.isDebugEnabled()) {
            log.debug("roleID 【{}】, cmd {}, req {}, content {}", roleID, cmd, req.getClass().getSimpleName(), StringUtil.msg2Json(req));
        }
        if (unit.isRecord()) {
            log.info("roleID:{}, cmd:{}, req:{}", roleID, cmd, req.getClass().getSimpleName());
        }
        MyMsg myMsg = ProtobufFactory.borrowMyMsg(MyMsg.class, cmd, req, roleID);
        return myMsg;
    }
}