package com.dj.serverapi.service;

import com.dj.serverapi.redis.model.OtherModel;
import com.dj.serverapi.service.inf.IOtherService;
import com.dj.servercore.redis.base.BaseService;

public class OtherServiceImpl extends BaseService implements IOtherService {

	@Override
	public int getAddMineCount(long roleID) {
		OtherModel model = getWriteModel(roleID, OtherModel.class);
		return model.getAddMineCount();
	}

	@Override
	public int getVerifyCount(long roleID) {
		OtherModel model = getReadModel(roleID, OtherModel.class);
		return model.getVerifyCount();
	}

	@Override
	public void addVerifyCount(long roleID) {
		OtherModel model = getWriteModel(roleID, OtherModel.class);
		model.addVerifyCount();
	}
}
