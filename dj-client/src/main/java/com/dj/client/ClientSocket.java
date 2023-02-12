package com.dj.client;

import java.lang.reflect.Method;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.ByteBuffer;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import com.dj.protobuf.ProtobufCmdPool;
import com.dj.domain.util.StringUtil;
import com.google.protobuf.GeneratedMessageV3;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ClientSocket extends WebSocketClient {
	public ClientSocket(String url) throws URISyntaxException {
		super(new URI(url));
	}

	@Override
	public void onOpen(ServerHandshake shake) {
		log.info("已连接 " + this.uri.getHost() + ":" + this.uri.getPort());
	}

	@Override
	public void onClose(int paramInt, String paramString, boolean paramBoolean) {
		log.info("关闭...");
	}

	@Override
	public void onError(Exception e) {
		log.info("异常:" + e);
	}

	@Override
	public void onMessage(String message) {
		log.info("接收到消息message：" + message);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void onMessage(ByteBuffer bytes) {
		ByteBuf byteBuf = Unpooled.copiedBuffer(bytes);
		int cmd = byteBuf.readUnsignedShortLE();
		log.info("接收消息：");
		log.info("cmd " + cmd);
		int length = byteBuf.readIntLE();
		byte[] data = new byte[length];
		byteBuf.readBytes(data);
		Class cls = ProtobufCmdPool.INSTANCE.getCls(cmd);
		if (cls == null) {
			log.info("null cls cmd " + cmd);
			return;
		}
		try {
			Method method = cls.getMethod("getDefaultInstance");
			GeneratedMessageV3 generatedMessageV3 = (GeneratedMessageV3) method.invoke(cls);
			GeneratedMessageV3 rsp = generatedMessageV3.getParserForType().parseFrom(data, 0, length);
			log.info(rsp.getClass().getSimpleName());
			log.info(StringUtil.msg2Json(rsp));
		} catch (Exception e) {
			e.printStackTrace();
		}
		log.info("================");
	}

}
