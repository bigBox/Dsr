package com.dj.servercore.conf;

import com.dj.domain.config.ConfigCitySceneEvent;
import com.dj.domain.enums.CitySceneDefineEnum;
import com.dj.domain.util.collection.MapUtil;
import com.dj.servercore.conf.base.BaseConfigConf;
import com.dj.servercore.conf.base.IConfProvider;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class ConfigCitySceneEventConf extends BaseConfigConf<ConfigCitySceneEvent> {

	public ConfigCitySceneEventConf() {
		super(IConfProvider.CONFIG_CITY_SCENE_EVENT);
	}

	private ImmutableMap<Integer, ConfigCitySceneEvent> citySceneEventMap;

	//Map<场景ID, Map<事件ID, 权重>>
	private Map<Integer, Map<Integer, Integer>> allWeightedMap = Maps.newHashMap();

	@Override
	public void onLoadOver() {
		citySceneEventMap = MapUtil.listToImmMap(dataList, obj -> obj.getID());
		allWeightedMap.clear();
		for (ConfigCitySceneEvent item : dataList) {
			Field[] fields = item.getClass().getDeclaredFields();
			for (Field field : fields) {
				field.setAccessible(true);
			}
			for (Field field : fields) {
				String fieldName = getFiled(field).toLowerCase();
				int sceneId = CitySceneDefineEnum.getSceneIdByMethodName(fieldName);
				if(sceneId > 0) {
					Integer weight =  getFieldValue(item, fieldName);
					if(weight != null && weight > 0) {
						Map<Integer, Integer> sceneMap = allWeightedMap.get(sceneId);
						if (sceneMap == null) {
							sceneMap = Maps.newHashMap();
							allWeightedMap.put(sceneId, sceneMap);
						}
						sceneMap.put(item.getID(), weight);
					}
				}
			}
		}
	}

	public ImmutableMap<Integer, ConfigCitySceneEvent> getCitySceneEventMap() {
		return getConfig(citySceneEventMap);
	}

	public ConfigCitySceneEvent getCitySceneEvent(int id) {
		if(citySceneEventMap.containsKey(id)) {
			return getConfig(id, citySceneEventMap);
		}else {
			return null;
		}
	}
	public Map<Integer, Integer> getCitySceneEventWeightedMap(int id){
		if(allWeightedMap.containsKey(id)) {
			return getConfig(id, allWeightedMap);
		}else {
			return new HashMap<>();
		}
	}

	public static String getFiled(Field f) {
		String str = f.toString().substring(f.toString().lastIndexOf('.') + 1);
		return str.substring(0, 1).toUpperCase() + str.replaceFirst("\\w", "");
	}

	/**
	 * 获取对象的属性和属性值
	 *
	 * @author ghj
	 * @param owner
	 * @param fieldName
	 * @return
	 * @throws Throwable
	 */
	public static int getFieldValue(Object owner, String fieldName) {
		if(invokeMethod(owner, fieldName, null)!=null){
			return (Integer) invokeMethod(owner, fieldName, null);
		}else{
			return 0;
		}
	}

	/**
	 *
	 * 执行某个Field的getField方法
	 *
	 * @param owner
	 * 类
	 * @param fieldName
	 * 类的属性名称
	 * @param args
	 * 参数，默认为null
	 * @return
	 */

	private static Object invokeMethod(Object owner, String fieldName, Object[] args) {
		Class ownerClass = owner.getClass();
		// fieldName -> FieldName
		String methodName = fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
		Method method     = null;
		try {
			method = ownerClass.getMethod("get" + methodName);
		} catch (SecurityException e) {
			// e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// e.printStackTrace();
			return "";
		}
		// invoke getMethod
		try {
			return method.invoke(owner);
		} catch (Exception e) {
			return "";
		}
	}

}
