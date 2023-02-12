package com.dj.serverapi.service;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.dj.domain.enums.ResourceBillEnum;
import com.dj.domain.data.ItemBill;
import com.dj.domain.data.ItemInteractLog;
import com.dj.serverapi.redis.model.ItemModel;
import com.dj.serverapi.service.inf.IItemService;
import com.dj.servercore.redis.base.BaseService;
import com.dj.domain.util.collection.MapUtil;
import com.dj.domain.util.inf.IArgumentRunnable;

public class ItemServiceImpl extends BaseService implements IItemService {

    @Override
    public void addItemBill(long roleID, int itemID, long itemCount, ResourceBillEnum bill, boolean post2Client, boolean visible) {
        ItemModel model = getWriteModel(roleID, ItemModel.class);
        ItemBill itemBill = new ItemBill(itemID, itemCount, bill, post2Client, visible, System.currentTimeMillis());
        model.getItemBillList().add(itemBill);
    }

    @Override
    public void doItemBill(long roleID, IArgumentRunnable<ItemBill> run) {
        ItemModel model = getWriteModel(roleID, ItemModel.class);
        List<ItemBill> list = model.getItemBillList();
        if(list.size() > 0) {
        	Collections.sort(list);
        	list.forEach((itemBill) -> {
        		run.run(itemBill);
        	});
        	list.clear();
        }
    }

    @Override
    public void recordItemSource(long roleID, int itemID, long count, int source) {
        ItemModel model = getWriteModel(roleID, ItemModel.class);
        List<Integer> sourceList = model.getItemRecordSource(itemID);
        for (int i = 0; i < count; i++) {
            sourceList.add(source);
        }
    }

    @Override
    public int getItemSource(long roleID, int itemID) {
        ItemModel model = getWriteModel(roleID, ItemModel.class);
        List<Integer> sourceList = model.getItemRecordSource(itemID);
        if (sourceList.size() > 0) {
            return sourceList.remove(0);
        }
        return 0;
    }

	@Override
	public void setItemCount(long roleID, Map<Integer, Long> pieceMap) {
		ItemModel model = getWriteModel(roleID, ItemModel.class);
		Map<Integer, Long> mapPieceMap = model.getItemMapPiece();
		mapPieceMap.putAll(pieceMap);
	}

	@Override
	public void setItemCount(long roleID, int itemID, long count) {
		ItemModel model = getWriteModel(roleID, ItemModel.class);
		Map<Integer, Long> mapPieceMap = model.getItemMapPiece();
		mapPieceMap.put(itemID, count);
	}

	@Override
	public Map<Integer, Long> getItemCount(long roleID) {
		ItemModel model = getReadModel(roleID, ItemModel.class);
		return model.getItemMapPiece();
	}

	@Override
	public long getItemCount(long roleID, int itemID) {
		ItemModel model = getReadModel(roleID, ItemModel.class);
		Map<Integer, Long> mapPieceMap = model.getItemMapPiece();
		return MapUtil.getLongValue(mapPieceMap, itemID);
	}

	@Override
	public void addItemInteractLog(long roleID, int itemID, long itemCount, long interactRoleID, String ps) {
		ItemModel model = getWriteModel(roleID, ItemModel.class);
		ItemInteractLog log = new ItemInteractLog();
		log.setItemID(itemID);
		log.setItemCount(itemCount);
		log.setInteractRoleID(interactRoleID);
		log.setPs(ps);
		log.setTime(System.currentTimeMillis());
		model.getItemInteractLog().add(log);
		if(model.getItemMapPiece().containsKey(itemID)) {
			MapUtil.fundInt(model.getItemMapPiece(), itemID, itemCount);
		}
	}

	@Override
	public void doItemInteractLog(long roleID, IArgumentRunnable<ItemInteractLog> run) {
		ItemModel model = getWriteModel(roleID, ItemModel.class);
        List<ItemInteractLog> list = model.getItemInteractLog();
        if(list.size() > 0) {
        	Collections.sort(list);
        	list.forEach((itemInteractLog) -> run.run(itemInteractLog));
        	list.clear();
        }
	}
}
