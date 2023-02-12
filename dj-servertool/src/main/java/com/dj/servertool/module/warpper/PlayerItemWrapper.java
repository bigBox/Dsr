package com.dj.servertool.module.warpper;

import java.util.List;
import java.util.Map;

//import org.apache.commons.collections.MapUtils;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dj.servertool.core.manager.ConfManager;
import com.google.common.collect.Maps;

import cn.stylefeng.roses.core.base.warpper.BaseControllerWrapper;
import cn.stylefeng.roses.kernel.model.page.PageResult;
import org.apache.commons.collections4.MapUtils;

public class PlayerItemWrapper extends BaseControllerWrapper {

	private static Map<String, String> typeDesc = Maps.newHashMapWithExpectedSize(10);
	static {
		typeDesc.put("1", "植物");
		typeDesc.put("2", "动物");
		typeDesc.put("3", "食品");
		typeDesc.put("4", "工业");
		typeDesc.put("5", "收集品");
		typeDesc.put("6", "道具");
		typeDesc.put("100", "进仓库的物品");
	}

	public PlayerItemWrapper(Map<String, Object> single) {
		super(single);
	}

	public PlayerItemWrapper(List<Map<String, Object>> multi) {
		super(multi);
	}

	public PlayerItemWrapper(Page<Map<String, Object>> page) {
		super(page);
	}

	public PlayerItemWrapper(PageResult<Map<String, Object>> pageResult) {
		super(pageResult);
	}

	@Override
	protected void wrapTheMap(Map<String, Object> map) {
		String ItemId = MapUtils.getString(map, "ItemId");
		map.put("ItemName", ConfManager.getInstance().getConfigItemsConf().getItemName(ItemId));
	}
}
