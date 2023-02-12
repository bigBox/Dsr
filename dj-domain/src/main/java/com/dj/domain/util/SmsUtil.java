//package com.dj.util;
//
//import com.github.qcloudsms.SmsSingleSender;
//import com.github.qcloudsms.SmsSingleSenderResult;
//
//public class SmsUtil {
//	@SuppressWarnings("unused")
//	public static void main(String[] args) {
//		// 短信应用 SDK AppID
//		int appid = 1400243541; // SDK AppID 以1400开头
//		// 短信应用 SDK AppKey
//		String appkey = "72e5d38f1c4795d2bff3519bfc71b88f";
//		// 需要发送短信的手机号码
//		String phoneNumber = "13524123919";
//		// 短信模板 ID，需要在短信应用中申请
//		int templateId = 7839; // NOTE: 这里的模板 ID`7839`只是示例，真实的模板 ID 需要在短信控制台中申请
//		// 签名
//		String smsSign = "腾讯云"; // NOTE: 签名参数使用的是`签名内容`，而不是`签名ID`。这里的签名"腾讯云"只是示例，真实的签名需要在短信控制台申请
//		try {
//			SmsSingleSender ssender = new SmsSingleSender(appid, appkey);
//			SmsSingleSenderResult result = ssender.send(0, "86", phoneNumber, "【腾讯云】您的验证码是: 5678", "", "");
//			System.out.println(result);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//}
