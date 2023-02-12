package com.dj.servertool.core.server;

import java.lang.reflect.Method;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import com.alibaba.fastjson.JSONObject;
import com.dj.protobuf.ProtobufCmdPool;
import com.dj.domain.util.StringUtil;
import com.google.common.collect.Lists;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.MessageLite;
import com.googlecode.protobuf.format.JsonFormat;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.Unpooled;

public class NettySocket extends WebSocketClient {

	private static NettySocket instance;

	private Object lock = new Object();
	private MessageLite result = null;
	private CountDownLatch downLatch = null;

	public NettySocket(String wsUrl) throws URISyntaxException {
		super(new URI(wsUrl));
		instance = this;
	}

	@Override
	public void onOpen(ServerHandshake shake) {
		// TODO Auto-generated method stub
		System.out.println("已连接 " + this.uri.getHost() + ":" + this.uri.getPort());
	}

	@Override
	public void onClose(int paramInt, String paramString, boolean paramBoolean) {
		// TODO Auto-generated method stub
		System.out.println("关闭...");
	}

	@Override
	public void onError(Exception e) {
		// TODO Auto-generated method stub
		System.out.println("异常" + e);

	}

	@Override
	public void onMessage(String message) {
		System.out.println("接收到消息message：" + message);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void onMessage(ByteBuffer bytes) {
		ByteBuf byteBuf = Unpooled.copiedBuffer(bytes);
		int cmd = byteBuf.readUnsignedShortLE();
		System.out.println("接收消息：");
		System.out.println("cmd " + cmd);
		int length = byteBuf.readIntLE();
		byte[] data = new byte[length];
		byteBuf.readBytes(data);
		Class cls = ProtobufCmdPool.INSTANCE.getCls(cmd);
		if (cls == null) {
			System.out.println("null cls cmd " + cmd);
		}
		try {
			Method method = cls.getMethod("getDefaultInstance");
			GeneratedMessageV3 generatedMessageV3 = (GeneratedMessageV3) method.invoke(cls);
			GeneratedMessageV3 rsp = generatedMessageV3.getParserForType().parseFrom(data, 0, length);
			System.out.println(rsp.getClass().getSimpleName());
			System.out.println(StringUtil.msg2Json(rsp));
			result = rsp;
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("================");

		if (downLatch != null) {
			downLatch.countDown();
		}
	}

	@SuppressWarnings("finally")
	public static MessageLite sendMsg(GeneratedMessageV3 msg) {
		synchronized (instance.lock) {
			instance.downLatch = new CountDownLatch(1);

			System.out.println("发送消息");
			System.out.println(msg.getClass().getSimpleName());
			System.out.println(StringUtil.msg2Json(msg));
			System.out.println("-----------");
			ByteBuf byteBuf = ByteBufAllocator.DEFAULT.buffer();
			int cmd = ProtobufCmdPool.INSTANCE.getCmd(msg.getClass());
			byteBuf.writeShortLE(cmd);
			byte[] data = msg.toByteArray();
			byteBuf.writeIntLE(data.length);
			byteBuf.writeBytes(data);

			byte[] sendData = new byte[byteBuf.readableBytes()];
			byteBuf.readBytes(sendData);

			instance.send(sendData);

			try {
				instance.downLatch.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				return instance.result;
			}
		}
	}

	public static Object parseMsg(GeneratedMessageV3 msg) {
		JsonFormat jsonFormat = new JsonFormat();
		String str = jsonFormat.printToString(msg);
		return JSONObject.parse(str);
	}

	@SuppressWarnings("unchecked")
	public static List<Map<String, Object>> parseMsgs(List<? extends GeneratedMessageV3> msgs) {
		if (msgs == null) {
			return Lists.newArrayListWithExpectedSize(0);
		}
		JsonFormat jsonFormat = new JsonFormat();
		List<Map<String, Object>> list = Lists.newArrayListWithExpectedSize(msgs.size());
		for (GeneratedMessageV3 msg : msgs) {
			String str = jsonFormat.printToString(msg);
			list.add(JSONObject.parseObject(str, Map.class));
		}
		return list;
	}

}
