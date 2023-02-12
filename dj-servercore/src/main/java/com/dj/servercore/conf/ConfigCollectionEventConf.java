package com.dj.servercore.conf;

import com.dj.domain.config.ConfigCollectionEvent;
import com.dj.domain.enums.SceneDefineEnum;
import com.dj.domain.util.collection.MapUtil;
import com.dj.servercore.conf.base.BaseConfigConf;
import com.dj.servercore.conf.base.IConfProvider;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class ConfigCollectionEventConf extends BaseConfigConf<ConfigCollectionEvent> {

	public ConfigCollectionEventConf() {
		super(IConfProvider.CONFIG_COLLECTION_EVENT);
	}

	private ImmutableMap<Integer, ConfigCollectionEvent> collectionMap;

	//Map<场景ID, Map<类型ID, Map<物品ID, 权重>>>
	private Map<Integer, Map<Integer, Map<Integer, Integer>>> allWeightedMap = Maps.newHashMap();

	@Override
	public void onLoadOver() {
		collectionMap = MapUtil.listToImmMap(dataList, obj -> obj.getID());
		allWeightedMap.clear();
		for (ConfigCollectionEvent item : dataList) {
			Field[] fields = item.getClass().getDeclaredFields();
			for (Field field : fields) {
				field.setAccessible(true);
			}
			for (Field field : fields) {
				String fieldName = getFiled(field).toLowerCase();
				int sceneId = SceneDefineEnum.getSceneIdByMethodName(fieldName);
				if(sceneId > 0) {
					Integer weight =  getFieldValue(item, fieldName);
					if(weight != null && weight > 0) {
						Map<Integer, Map<Integer, Integer>> sceneMap = allWeightedMap.get(sceneId);
						if (sceneMap == null) {
							sceneMap = Maps.newHashMap();
							allWeightedMap.put(sceneId, sceneMap);
						}
						Map<Integer, Integer> typeMap = sceneMap.get(item.getType());
						if (typeMap == null) {
							typeMap = new HashMap<>();
							sceneMap.put(item.getType(), typeMap);
						}
						typeMap.put(item.getID(), weight);
					}
				}
			}
		}
	}

	public ConfigCollectionEvent getCollection(int id) {
		if(collectionMap.containsKey(id)) {
			return getConfig(id, collectionMap);
		}else{
			return null;
		}
	}

	public Map<Integer, Integer> getWeighted(int sceneId) {
		Map<Integer, Integer> retWeightMap = new HashMap<>();
		if(allWeightedMap.containsKey(sceneId)) {
			Map<Integer, Map<Integer, Integer>> sceneMap = allWeightedMap.get(sceneId);
			if(ObjectUtils.isNotEmpty(sceneMap)){
				for(Map<Integer, Integer> values : sceneMap.values()){
					retWeightMap.putAll(values);
				}
			}
		}
		return retWeightMap;
	}

	public Map<Integer, Integer> getWeighted(int sceneId, int type) {
		if(allWeightedMap.containsKey(sceneId)) {
			Map<Integer, Map<Integer, Integer>> sceneMap = allWeightedMap.get(sceneId);
			if(ObjectUtils.isNotEmpty(sceneMap)&&(sceneMap.containsKey(type))){
				Map<Integer, Integer> weightMap = sceneMap.get(type);
				return weightMap;
			}
		}
		return null;
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
		Method method = null;
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
