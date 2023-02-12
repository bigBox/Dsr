package com.dj.serverapi.dao;

import com.dj.domain.config.ConfigItems;
import com.dj.domain.config.ConfigNewRoleShowTableItem;
import com.dj.domain.entity.robot.RobotShowTable;
import com.dj.domain.type.AccessType;
import com.dj.domain.util.collection.MapUtil;
import com.dj.domain.util.lib.QueryParamMap;
import com.dj.protobuf.CommonException;
import com.dj.protobuf.ErrorIDOuterClass;
import com.dj.serverapi.ServiceProvider;
import com.dj.serverapi.dao.base.BaseCacheDao;
import com.dj.serverapi.dao.inf.IRobotShowTableDao;
import com.dj.servercore.conf.ConfigItemsConf;
import com.dj.servercore.conf.ConfigNewRoleShowTableItemConf;
import com.dj.servercore.conf.base.ConfProvider;
import com.dj.servercore.conf.base.IConfProvider;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class RobotShowTableDao extends BaseCacheDao<RobotShowTable> implements IRobotShowTableDao {

	@Override
	public Map<Integer, Integer> initNewRoleShowTableItem(long roleID) {
		Map<Integer, Integer> moneyMap = Maps.newHashMapWithExpectedSize(4);
		ConfigNewRoleShowTableItemConf conf = ConfProvider.getConfigConfProvider().getConfigConf(IConfProvider.CONFIG_NEWROLESHOWTABLEITEM);
		if(conf == null){
			throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
		}
		ConfigItemsConf itemsConf = ConfProvider.getConfigConfProvider().getConfigConf(IConfProvider.CONFIG_ITEMS);
		if(itemsConf == null){
			throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
		}
		ImmutableMap<Integer, ConfigNewRoleShowTableItem> showTables = conf.getNewRoleShowTableItemMap();
		List<RobotShowTable> list = Lists.newArrayListWithExpectedSize(showTables.size());
		for (ConfigNewRoleShowTableItem showTable : showTables.values()) {
			ConfigItems item = itemsConf.getItem(showTable.getItemId(), false);
			if(ObjectUtils.isNotEmpty(item)) {
				RobotShowTable playerShowTable = new RobotShowTable(roleID);
				playerShowTable.setType(showTable.getType());
				playerShowTable.setIndex(showTable.getIndex());
				playerShowTable.setItemID(showTable.getItemId());
				playerShowTable.setPage(showTable.getPage());
				playerShowTable.setX(showTable.getX());
				playerShowTable.setY(showTable.getY());
				playerShowTable.setSuitID(0);
				cacheInsert(playerShowTable, roleID);
				list.add(playerShowTable);
				MapUtil.fundInt(moneyMap, showTable.getType(), item.getGold());
			}
		}
		ServiceProvider.getShowTableService().setRobotShowTables(roleID, list);
		return moneyMap;
	}

	@Override
	public List<RobotShowTable> readDbData(long roleID) {
		QueryParamMap<String, Object> queryParams = new QueryParamMap<>(1);
		queryParams.put("roleID", roleID);
		return selectList(queryParams, roleID, AccessType.DIRECT_DB);
	}
}
