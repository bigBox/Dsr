package com.dj.servercore.wechat;

import java.util.Date;

import com.dj.protobuf.ErrorIDOuterClass.ErrorID;
import com.dj.domain.util.DateUtil;
import com.dj.domain.util.GsonUtil;
import com.dj.domain.util.OkHttpUtil;
import com.dj.domain.util.Utility;
import com.dj.domain.util.collection.MapUtil;
import com.dj.domain.util.inf.IArgumentRunnable;
import com.google.gson.JsonObject;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class WechatUtil {
    public static class WechatRequest {
        private StringBuilder sb = new StringBuilder();

        public WechatRequest text(String string) {
            text(string, true);
            return this;
        }

        public WechatRequest text(String string, boolean flag) {
            sb.append(string);
            if (flag) {
                sb.append(": ");
            }
            return this;
        }

        public WechatRequest value() {
            sb.append("\n");
            return this;
        }

        public WechatRequest value(int x) {
            sb.append(x).append("\n");
            return this;
        }

        public WechatRequest value(float x) {
            sb.append(x).append("\n");
            return this;
        }

        public WechatRequest value(long x) {
            sb.append(x).append("\n");
            return this;
        }

        public WechatRequest value(String x) {
            sb.append(x).append("\n");
            return this;
        }

        public WechatRequest useBuffer(IArgumentRunnable<String> runner) {
            if (runner != null) {
                runner.run(sb.toString());
            }
            return this;
        }

        public void send1() {
            sendContent1(sb.toString());
        }

        public void send2() {
            sendContent2(sb.toString());
        }
    }

    private static final String CORPID = "wwb49dbfede18b0698";
    private static final int PARTYID1 = 1;
    private static final int AGENTID1 = 1000002;
    private static final String SECRET1 = "vlwEFaxuy2oC-F7-GMvVUBSNGhq1APcJf6h9xcF7_h0";
    private static final int PARTYID2 = 2;
    private static final int AGENTID2 = 1000003;
    private static final String SECRET2 = "4vthRgKDGT8ahFhWU7xQ-hOE-pt1gBSvU9SHXnkJA14";

    private static final String URL_GET_TOKEN = "https://qyapi.weixin.qq.com/cgi-bin/gettoken?";
    private static final String URL_SEND = "https://qyapi.weixin.qq.com/cgi-bin/message/send?access_token=";

    /**
     * @param corpid 企业id
     * @param secret 应用secret
     * @return String
     * @Description: 获取企业微信AccessToken
     */
    private static String getAccessToken(String corpid, String secret) {
        String response = OkHttpUtil.get(URL_GET_TOKEN, MapUtil.asMap("corpid", corpid, "corpsecret", secret));
        JsonObject resObj = GsonUtil.toJsonObject(response);
        return (String) GsonUtil.fromJson(resObj, "access_token", String.class);
    }

    /**
     * @param corpid  企业id
     * @param partyId 部门id
     * @param secret  应用secret
     * @param agentId 应用id
     * @param content 文本
     * @Description: 发送文本
     */
    private static void sendContent(String corpid, int partyId, String secret, int agentId, String content) {
        try {
            String token = getAccessToken(corpid, secret);
            WechatSendContent sendContent = new WechatSendContent("@all", partyId, "", "text", agentId);
            sendContent.setText(sendContent.new Content(content));
            String reqData = GsonUtil.toJson(sendContent);
            String resData = OkHttpUtil.post(URL_SEND + token, reqData);
            log.debug("WechatUtil sendContent token={},reqData={},resData={}", token, reqData, resData);
        } catch (Exception e) {
            log.error(Utility.getTraceString(e));
        }
    }

    public static void sendContent1(String content) {
        sendContent(CORPID, PARTYID1, SECRET1, AGENTID1, content);
    }

    public static void sendContent2(String content) {
        sendContent(CORPID, PARTYID2, SECRET2, AGENTID2, content);
    }

    public static WechatRequest insRequest() {
        return new WechatRequest();
    }

    public static void writeLoginMsg(String serverTag, String account, String password, String ip, long roleID) {
//    	if(!serverTag.equals("版号")) {
//    		return;
//    	}
        insRequest().text("服务器标识").value(serverTag).value("账号登录").text("账号").value(account).text("密码").value(password).text("ip").value(ip)
                .text("roleID").value(roleID).text("登录时间").value(DateUtil.formatDate(new Date(), DateUtil.STYLE4)).send1();
    }

    public static void writeLogoutMsg(String serverTag, String roleName, long roleID, int onlineMinute) {
//    	if(!serverTag.equals("版号")) {
//    		return;
//    	}
    	insRequest().text("服务器标识").value(serverTag).value("角色登出").text("角色名").value(roleName).text("roleID").value(roleID)
    	.text("登出时间").value(DateUtil.formatDate(new Date(), DateUtil.STYLE4)).text("在线时间").value(onlineMinute+"分钟").send1();
    }

    public static void writeActionException(String serverTag, String server, int serverID, String clz, String content, String error) {
    	if(!serverTag.equals("版号")) {
    		return;
    	}
        insRequest().text("服务器标识").value(serverTag).value(server + serverID).value(DateUtil.formatDate(new Date(), DateUtil.STYLE4)).text("clz")
                .value(clz).text("content").value(content).text("error").value(error).send2();
    }

    public static void writeActionException(String serverTag, String server, int serverID, ErrorID errorID, String message, String error) {
    	if(!serverTag.equals("版号")) {
    		return;
    	}
        insRequest().text("服务器标识").value(serverTag).value(server + serverID).value(DateUtil.formatDate(new Date(), DateUtil.STYLE4)).text("errorID")
                .value(errorID.toString()).text("message").value(message).text("error").value(error).send2();
    }

    public static void writeActionException(String serverTag, String server, int serverID, String message, String error) {
    	if(!serverTag.equals("版号")) {
    		return;
    	}
        insRequest().text("服务器标识").value(serverTag).value(server + serverID).value(DateUtil.formatDate(new Date(), DateUtil.STYLE4)).text("message")
                .value(message).text("error").value(error).send2();
    }

    public static void writeActionException(String serverTag, String server, int serverID, ErrorID errorID, String clz, String content, String error) {
    	if(!serverTag.equals("版号")) {
    		return;
    	}
        insRequest().text("服务器标识").value(serverTag).value(server + serverID).value(DateUtil.formatDate(new Date(), DateUtil.STYLE4)).text("errorID")
                .value(errorID.toString()).text("clz").value(clz).text("content").value(content).text("error").value(error).send2();
    }
}
