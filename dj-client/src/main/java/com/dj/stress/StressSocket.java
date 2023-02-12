package com.dj.stress;

import java.lang.reflect.Method;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.ByteBuffer;
import java.util.concurrent.CountDownLatch;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import com.dj.protobuf.ProtobufCmdPool;
import com.dj.protobuf.login.UserLoginRsp;
import com.dj.domain.util.StringUtil;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.Message;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

public class StressSocket extends WebSocketClient {
	
	public String key;
	public long roleID;
	private CountDownLatch cdl;
	
	public StressSocket(String url, CountDownLatch cdl) throws URISyntaxException {
		super(new URI(url));
		this.cdl = cdl;
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
		int length = byteBuf.readIntLE();
		byte[] data = new byte[length];
		byteBuf.readBytes(data);
		Class cls = ProtobufCmdPool.INSTANCE.getCls(cmd);
		try {
			Method method = cls.getMethod("getDefaultInstance");
			GeneratedMessageV3 generatedMessageV3 = (GeneratedMessageV3) method.invoke(cls);
			Message rsp = generatedMessageV3.getParserForType().parseFrom(data, 0, length);
			System.out.println(key+"接收消息["+rsp.getClass().getSimpleName()+"],"+StringUtil.msg2Json(rsp));
			if (rsp instanceof UserLoginRsp) {
				this.roleID = ((UserLoginRsp)rsp).getRoleID();
				cdl.countDown();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
