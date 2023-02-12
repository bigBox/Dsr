package com.dj.serverapi.service;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.dj.domain.enums.PlayerAttrEnum;
import com.dj.domain.enums.ResourceBillEnum;
import com.dj.domain.config.ConfigDigGold;
import com.dj.domain.data.AttrBill;
import com.dj.serverapi.redis.model.CommonModel;
import com.dj.serverapi.service.inf.ICommonService;
import com.dj.servercore.redis.base.BaseService;
import com.dj.domain.util.inf.IArgumentRunnable;
import com.dj.domain.util.math.RandomUtil;

public class CommonServiceImpl extends BaseService implements ICommonService {

    @Override
    public void addAttrBill(long roleID, String key, long value, ResourceBillEnum bill) {
        CommonModel model = getWriteModel(roleID, CommonModel.class);
        AttrBill attrBill = new AttrBill(key, value, bill, System.currentTimeMillis());
        model.getAttrBillList().add(attrBill);
    }

    @Override
    public void doAttrBill(long roleID, IArgumentRunnable<AttrBill> run) {
        CommonModel model = getWriteModel(roleID, CommonModel.class);
        List<AttrBill> list = model.getAttrBillList();
        Collections.sort(list);
        list.forEach((attrBill) -> run.run(attrBill));
        list.clear();
    }

    @Override
    public void changeAttrDigGold(long roleID, ConfigDigGold digGold) {
        CommonModel model = getWriteModel(roleID, CommonModel.class);
        // 扣除体力
        AttrBill attrBill1 = new AttrBill(PlayerAttrEnum.STAMINA.getKey(), -digGold.getCost(), ResourceBillEnum.mineCost, System.currentTimeMillis());
        model.getAttrBillList().add(attrBill1);
        // 获得经验
        if(RandomUtil.nextInt(10) < 1) {
        	AttrBill attrBill2 = new AttrBill(PlayerAttrEnum.EXP.getKey(), (int) digGold.getExp(), ResourceBillEnum.mineReward, System.currentTimeMillis());
        	model.getAttrBillList().add(attrBill2);
        }
    }

    @Override
    public Map<String, Integer> getClientData(long roleID) {
        return getReadModel(roleID, CommonModel.class).getClientData();
    }

    @Override
    public void changeClientData(long roleID, String key, int value) {
        CommonModel model = getWriteModel(roleID, CommonModel.class);
        model.getClientData().put(key, value);
    }

	@Override
	public int getAcceptTypeTask(long roleID, int taskType) {
		int value = getReadModel(roleID, CommonModel.class).getAcceptTypeTask(taskType);
		return value; 
	}

	@Override
	public void setAcceptTypeTask(long roleID, int taskType, int taskID) {
		CommonModel model = getWriteModel(roleID, CommonModel.class);
		model.setAcceptTypeTask(taskType, taskID);
	}

	@Override
	public boolean getParkDrawPrize(long roleID) {
		return getReadModel(roleID, CommonModel.class).getParkDrawPrize();
	}
}
