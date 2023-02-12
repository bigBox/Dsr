package com.dj.serverapi.dao;

import com.dj.domain.config.ConfigItems;
import com.dj.domain.entity.robot.RobotVerify;
import com.dj.domain.type.AccessType;
import com.dj.domain.util.DateUtil;
import com.dj.domain.util.lib.QueryParamMap;
import com.dj.protobuf.CommonException;
import com.dj.protobuf.ErrorIDOuterClass;
import com.dj.serverapi.dao.base.BaseCacheDao;
import com.dj.serverapi.dao.inf.IRobotVerifyDao;
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
public class RobotVerifyDao extends BaseCacheDao<RobotVerify> implements IRobotVerifyDao {

	@Override
	public List<RobotVerify> readDbData(long roleID) {
		QueryParamMap<String, Object> queryParams = new QueryParamMap<>(1);
		queryParams.put("roleID", roleID);
		List<RobotVerify> list = selectList(queryParams, roleID, AccessType.DIRECT_DB);
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
		int verifyQueueCount = ConfigSundryConf.verifyQueueCount;
		// 补充鉴定队列
		for (int i = 0; i <= verifyQueueCount - guideVerified.size(); i++) {
			if(i == 3){
				for (Integer itemID : guideVerified) {
					ConfigItems item = itemsConf.getItem(itemID, false);
					if (ObjectUtils.isNotEmpty(item)) {
						RobotVerify robotVerify = new RobotVerify(roleID);
						robotVerify.setVerifyID(itemID);
						robotVerify.setVerifyRoleID(roleID+"");
						robotVerify.setVerifyFinishTime(DateUtil.getCurrentDate());
						Integer color = verifyFuncConf.getProResult(robotVerify.getVerifyID());
						Integer exp = verifyFuncConf.getProExp(robotVerify.getVerifyID());
						int newItemId = itemsConf.getItemIdByType(itemID, color);
						robotVerify.setResultItem(newItemId);
						robotVerify.setResultRep(exp);
						cacheInsert(robotVerify, roleID);
					}
				}
			}else{
				RobotVerify robotVerify = new RobotVerify(roleID);
				robotVerify.setVerifyID(0);
				robotVerify.setVerifyRoleID("");
				robotVerify.setVerifyFinishTime(null);
				robotVerify.setResultItem(0);
				robotVerify.setResultRep(0);
				cacheInsert(robotVerify, roleID);
			}
		}
	}
}
