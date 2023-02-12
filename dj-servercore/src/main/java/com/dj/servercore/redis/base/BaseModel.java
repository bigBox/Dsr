package com.dj.servercore.redis.base;

import com.dj.protobuf.CommonException;
import com.dj.protobuf.ErrorIDOuterClass;
import com.dj.servercore.redis.RedisTemplate;
import com.dj.domain.util.Utility;
import com.google.common.hash.Hashing;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.redisson.client.codec.ByteArrayCodec;

import java.text.MessageFormat;

@Data
@Slf4j
@Getter(AccessLevel.PROTECTED)
@Setter(AccessLevel.PROTECTED)
@EqualsAndHashCode(callSuper = false)
public abstract class BaseModel extends AbsModel {

	/**
	 * Model构造函数
	 * 
	 * @param key
	 * @param roleID
	 * @param lockTemplate
	 * @param redisTemplate
	 * @param lock
	 */
	public BaseModel(String key, Long roleID, RedisTemplate lockTemplate, RedisTemplate redisTemplate, Boolean lock) {
		if (roleID < 0) {
			throw new CommonException(ErrorIDOuterClass.ErrorID.COMMON_PLAYER_NOT_FOUND, "roleID error id=" + roleID);
		}
		setUniqueId(roleID);
		setLockTemplate(lockTemplate);
		setRedisTemplate(redisTemplate);
		setKey(MessageFormat.format(key, String.valueOf(roleID)));
		setLockKey(getKey());
		try {
			// 加锁
			if (lock) {
				lock();
			}
			byte[] retBytes = null;
			// 毋须检查，直接获取数据
			Object obj = redisTemplate.getRedisson().getBucket(redisTemplate.buildKey(getKey()), ByteArrayCodec.INSTANCE).get();
			if (obj != null) {
				retBytes = (byte[]) obj;
			}
			// 序列化数据
			if (retBytes != null) {
				if (retBytes.length > 0) {
					ModelData data = RedisTemplate.unserialize(retBytes, ModelData.class);
					// 初始化数据
					setData(data);
					setDataDigest(Hashing.md5().newHasher(retBytes.length).putBytes(retBytes).hash().toString());
				}
			}
			if (getData() == null) {
				// 初始化时必须加锁 否则数据不保存
				if (!lock) {
					lock();
				}
				// 调用子类初始化函数
				setData(new ModelData());
				this.init();
			}
			onLoadOver();
		} catch (Exception e) {
			log.error(Utility.getTraceString(e));
			throw e;
		} finally {
		}
	}
}
