package com.dj.servercore.redis.base;

import java.util.Map;

import com.dj.domain.constant.ConstantServer;
import com.dj.protobuf.CommonException;
import com.dj.servercore.Checker;
import com.dj.domain.util.DateUtil;
import com.dj.domain.util.Utility;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class BaseService extends AbsService {

	private BaseService service;

	public BaseService() {
		service = this;
		log.info(DateUtil.getNowTime2() + " " + service.getClass().getSimpleName());
	}

	/**
	 * @Title: checkNumRange
	 * @Description: 检测数值范围
	 * @param para
	 */
	protected final void checkNumRange(int para) {
		try {
			Checker.checkNumRange(para, ConstantServer.SUBMIT_NUM_LOWER_LIMIT, ConstantServer.SUBMIT_NUM_UPPER_LIMIT);
		} catch (CommonException e) {
			log.error(Utility.getTraceString(e));
			throw e;
		}
	}

	public void hashSet(String key, Object field, Object value) {
		getRedisTemplate().hashSet(key, field, value);
	}

	public void hashDelete(String key, Object field) {
		getRedisTemplate().hashDelete(key, field);
	}

	public Object hashGet(String key, Object field) {
		return getRedisTemplate().hashGet(key, field);
	}

	public Map<Object, Object> hashGetAll(String key) {
		return getRedisTemplate().hashGetAll(key);
	}

	public void listAdd(String key, Object value) {
		getRedisTemplate().listAdd(key, value);
	}

	public Object listGet(String key, int index) {
		return getRedisTemplate().listGet(key, index);
	}

	public int listSize(String key) {
		return getRedisTemplate().listSize(key);
	}
}
