package com.dj.domain.util;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

import org.apache.http.Consts;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;

import com.google.common.collect.Lists;

import lombok.extern.slf4j.Slf4j;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.RequestBody;
import okhttp3.Response;

@Slf4j
@SuppressWarnings("deprecation")
public class OkHttpUtil {
	private static final OkHttpClient client = new OkHttpClient.Builder().connectTimeout(30000, TimeUnit.MILLISECONDS).build();

	public static final MediaType MEDIATYPE_FORM = MediaType.parse("application/x-www-form-urlencoded; charset=UTF-8");
	public static final MediaType MEDIATYPE_JSON = MediaType.parse("application/json; charset=utf-8");
	public static final MediaType MEDIATYPE_TEXT = MediaType.parse("text/plain; charset=utf-8");

	/**
	 * @Title: formatParams
	 * @Description: 封装键值对为一个字符串
	 * @param paras 键值对参数
	 * @return String 字符串
	 */
	private static String formatParams(Map<String, String> paras) {
		List<NameValuePair> nvps = Lists.newArrayListWithExpectedSize(paras.size());
		for (Map.Entry<String, String> entry : paras.entrySet()) {
			String key = entry.getKey();
			String value = entry.getValue();
			nvps.add(new BasicNameValuePair(key, value));
		}
		return URLEncodedUtils.format(nvps, Consts.UTF_8);
	}

	/**
	 * @Title: get
	 * @Description: HTTP GET 同步请求
	 * @param url
	 * @return String
	 */
	public static String get(String url) {
		Request request = new Request.Builder().url(url).build();
		try {
			Response response = client.newCall(request).execute();
			if (response.isSuccessful()) {
				return response.body().string();
			} else {
				log.error("Unexpected code " + response);
			}
		} catch (IOException e) {
			log.error(Utility.getTraceString(e));
		}
		return null;
	}

	/**
	 * @Title: get
	 * @Description: HTTP GET 带参同步请求
	 * @param url
	 * @param paras 参数键值对
	 * @return String
	 */
	public static String get(String url, Map<String, String> paras) {
		String formParas = formatParams(paras);
		StringBuilder sb = new StringBuilder(url.length() + formParas.length());
		sb.append(url).append(formParas);
		Request request = new Request.Builder().url(sb.toString()).build();
		try {
			Response response = client.newCall(request).execute();
			if (response.isSuccessful()) {
				return response.body().string();
			} else {
				log.error("Unexpected code " + response);
			}
		} catch (IOException e) {
			log.error(Utility.getTraceString(e));
		}
		return null;
	}

	/**
	 * @Title: post
	 * @Description: HTTP POST 提交Json 同步请求
	 * @param url
	 * @param json json参数
	 * @return
	 */
	public static String post(String url, String json) {
		RequestBody body = RequestBody.create(MEDIATYPE_JSON, json);
		Request request = new Request.Builder().url(url).post(body).build();
		try {
			Response response = client.newCall(request).execute();
			if (response.isSuccessful()) {
				return response.body().string();
			} else {
				log.error("Unexpected code " + response);
			}
		} catch (IOException e) {
			log.error(Utility.getTraceString(e));
		}
		return null;
	}

	/**
	 * @Title: post
	 * @Description: HTTP POST 提交键值对参数 同步请求
	 * @param url
	 * @param paras 参数键值对
	 * @return String
	 */
	public static String post(String url, Map<String, String> paras) {
		return post(url, paras, MEDIATYPE_TEXT);
	}

	public static String post(String url, Map<String, String> paras, MediaType mediaType) {
		RequestBody formBody = RequestBody.create(mediaType, formatParams(paras));
		Request request = new Request.Builder().url(url).post(formBody).build();
		try {
			Response response = client.newCall(request).execute();
			if (response.isSuccessful()) {
				return response.body().string();
			} else {
				log.error("Unexpected code " + response);
			}
		} catch (IOException e) {
			log.error(Utility.getTraceString(e));
		}
		return null;
	}

	public static String post(String url, Map<String, String> paras, Map<String, String> headerMap) {
		return post(url, paras, headerMap, MEDIATYPE_TEXT);
	}

	public static String post(String url, Map<String, String> paras, Map<String, String> headerMap, MediaType mediaType) {
		RequestBody formBody = RequestBody.create(mediaType, formatParams(paras));
		Builder builder = new Request.Builder().url(url).post(formBody);
		if (headerMap != null) {
			for (Entry<String, String> entry : headerMap.entrySet()) {
				builder.addHeader(entry.getKey(), entry.getValue());
			}
		}
		Request request = builder.build();
		try {
			Response response = client.newCall(request).execute();
			if (response.isSuccessful()) {
				return response.body().string();
			} else {
				log.error("Unexpected code " + response);
			}
		} catch (IOException e) {
			log.error(Utility.getTraceString(e));
		}
		return null;
	}
}
