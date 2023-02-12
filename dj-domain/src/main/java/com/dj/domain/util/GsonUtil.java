package com.dj.domain.util;

import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;

@Data
@Getter(AccessLevel.PROTECTED)
@SuppressWarnings("deprecation")
public class GsonUtil {

	protected static final GsonBuilder builder = new GsonBuilder();

	protected static final Gson gson = builder.create();

	/**
	 *	将字符型转化为JSON对象
	 * 
	 * @param json
	 * @return
	 */
	public static JsonObject toJsonObject(String json) {
		JsonParser parser = new JsonParser();
		JsonObject jsonObject = parser.parse(json).getAsJsonObject();
		return jsonObject;
	}

	/**
	 *	将对象转化为JSON字符串
	 * 
	 * @param obj
	 * @return
	 */
	public static String toJson(Object obj) {
		return gson.toJson(obj);
	}

	/**
	 *	将JSON字符串转化为对象
	 * 
	 * @param json
	 * @return
	 */
	public static <T> T fromJson(String json, Class<T> clazz) {
		return gson.fromJson(json, clazz);
	}

	/**
	 *	将JSON字符串转化为对象
	 * 
	 * @param json
	 * @return
	 */
	public static <T> T fromJson(String json, Type type) {
		if (json == null || json.isEmpty()) {
			json = "{}";
		}
		return gson.fromJson(json, type);
	}

	/**
	 *	将Json对象中指定字段转化为对象
	 * 
	 * @param json
	 * @return
	 */
	public static <T> Object fromJson(JsonObject json, String key, Class<T> clazz) {
		JsonElement el_ec = json.get(key);
		Object value = gson.fromJson(el_ec, clazz);
		return value;
	}
}
