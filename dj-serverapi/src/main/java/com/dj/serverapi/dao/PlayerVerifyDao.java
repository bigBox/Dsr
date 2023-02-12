package com.dj.serverapi.dao;

import com.dj.domain.config.ConfigItems;
import com.dj.domain.entity.player.PlayerVerify;
import com.dj.domain.type.AccessType;
import com.dj.domain.util.DateUtil;
import com.dj.domain.util.lib.QueryParamMap;
import com.dj.protobuf.CommonException;
import com.dj.protobuf.ErrorIDOuterClass;
import com.dj.serverapi.dao.base.BaseCacheDao;
import com.dj.serverapi.dao.inf.IPlayerVerifyDao;
import com.dj.servercore.conf.ConfigItemsConf;
import com.dj.servercore.conf.ConfigSundryConf;
import com.dj.servercore.conf.ConfigVerifyFuncConf;
import com.dj.servercore.conf.base.ConfProvider;
import com.dj.servercore.conf.base.IConfProvider;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class PlayerVerifyDao extends BaseCacheDao<PlayerVerify> implements IPlayerVerifyDao {

	@Override
	public List<PlayerVerify> readDbData(long roleID) {
		QueryParamMap<String, Object> queryParams = new QueryParamMap<>(1);
		queryParams.put("roleID", roleID);
		List<PlayerVerify> list = selectList(queryParams, roleID, AccessType.DIRECT_DB);
		return list;
	}

	@Override
	public void initNewRoleGuideVerify(long roleID) {
		ConfigItemsConf itemsConf = ConfProvider.getConfigConfProvider().getConfigConf(IConfProvider.CONFIG_ITEMS);
		if(itemsConf == null){
			throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
		}
		ConfigVerifyFuncConf verifyFuncConf = ConfProvider.getConfigConfProvider()
				.getConfigConf(IConfProvider.CONFIG_VERIFYFUNC);
		if(verifyFuncConf == null){
			throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
		}
		// 新手引导要用
		List<Integer> guideVerified = ConfigSundryConf.guideVerified;
		Date verifyFinishTime = DateUtil.getCurrentDate();
		for (Integer itemID : guideVerified) {
			ConfigItems item = itemsConf.getItem(itemID, false);
			if (ObjectUtils.isNotEmpty(item)) {
				PlayerVerify playerVerify = new PlayerVerify(roleID);
				playerVerify.setVerifyID(itemID);
				playerVerify.setVerifyRoleID(roleID+"");
				playerVerify.setVerifyFinishTime(verifyFinishTime);
				Integer color = verifyFuncConf.getProResult(playerVerify.getVerifyID());
				Integer exp = verifyFuncConf.getProExp(playerVerify.getVerifyID());
				int newItemId = itemsConf.getItemIdByType(itemID, color);
				playerVerify.setResultItem(newItemId);
				playerVerify.setResultRep(exp);
				cacheInsert(playerVerify, roleID);
			}
		}

		int verifyQueueCount = ConfigSundryConf.verifyQueueCount;
		// 补充鉴定队列
		for (int i = guideVerified.size(); i < verifyQueueCount; i++) {
			PlayerVerify playerVerify = new PlayerVerify(roleID);
			playerVerify.setVerifyID(0);
			playerVerify.setVerifyRoleID("");
			playerVerify.setVerifyFinishTime(null);
			playerVerify.setResultItem(0);
			playerVerify.setResultRep(0);
			cacheInsert(playerVerify, roleID);
		}
	}
}
