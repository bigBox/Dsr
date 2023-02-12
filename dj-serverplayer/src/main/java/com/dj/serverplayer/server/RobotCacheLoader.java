package com.dj.serverplayer.server;

import com.dj.domain.entity.player.PlayerShowTableMoney;
import com.dj.domain.entity.player.item.*;
import com.dj.domain.entity.robot.RobotFarm;
import com.dj.domain.entity.robot.RobotRole;
import com.dj.domain.entity.robot.RobotShowTableMoney;
import com.dj.domain.entity.robot.RobotVerify;
import com.dj.domain.entity.robot.item.*;
import com.dj.domain.util.Utility;
import com.dj.protobuf.CommonException;
import com.dj.serverapi.dao.RobotFarmDao;
import com.dj.serverapi.dao.RobotRoleDao;
import com.dj.serverapi.dao.RobotShowTableMoneyDao;
import com.dj.serverapi.dao.RobotVerifyDao;
import com.dj.serverapi.dao.item.*;
import com.dj.servercore.db.cache.IEntityCache;
import com.dj.servercore.db.cache.IEntityCacheLoader;
import com.dj.serverplayer.manager.DataManager;
import com.dj.serverplayer.manager.ServiceManager;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author zcq
 * @ClassName: PlayerCacheLoader
 * @Description: 玩家缓存加载器
 * @date 2019年6月25日
 */
@Slf4j
@Component("robotCacheLoader")
public class RobotCacheLoader implements IEntityCacheLoader {

    @Autowired
    public RobotRoleDao robotRoleDao;
    @Autowired
    public RobotItem1Dao robotItem1Dao;
    @Autowired
    public RobotItem2Dao robotItem2Dao;
    @Autowired
    public RobotItem3Dao robotItem3Dao;
    @Autowired
    public RobotItem4Dao robotItem4Dao;
    @Autowired
    public RobotItem5Dao robotItem5Dao;
    @Autowired
    public RobotItem6Dao robotItem6Dao;
    @Autowired
    public RobotItem7Dao robotItem7Dao;
    @Autowired
    public RobotItem100Dao robotItem100Dao;
    @Autowired
    public RobotVerifyDao robotVerifyDao;
    @Autowired
    public RobotShowTableMoneyDao robotShowTableMoneyDao;
    @Autowired
    public RobotFarmDao robotFarmDao;

    @Override
    public void loadEntityCache(long identity, IEntityCache entityCache) {
        log.info("identity {}", identity);
        // 角色
        List<RobotRole> robotRoles = robotRoleDao.readDbData(identity);
        if(robotRoles == null) {
            robotRoles = new ArrayList<>();
        }
        entityCache.addModelData(robotRoles, RobotRole.class);
        // 地图碎片临时处理
        // 植物
        List<RobotItem1> items1 = robotItem1Dao.readDbData(identity);
        if(items1 == null) {
            items1 = new ArrayList<>();
        }
        entityCache.addModelData(items1, PlayerItem1.class);
        setItemCount(identity, items1);
        // 动物
        List<RobotItem2> items2 = robotItem2Dao.readDbData(identity);
        if(items2 == null) {
            items2 = new ArrayList<>();
        }
        entityCache.addModelData(items2, PlayerItem2.class);
        setItemCount(identity, items2);
        // 食品
        List<RobotItem3> items3 = robotItem3Dao.readDbData(identity);
        if(items3 == null) {
            items3 = new ArrayList<>();
        }
        entityCache.addModelData(items3, PlayerItem3.class);
        setItemCount(identity, items3);
        // 工业
        List<RobotItem4> items4 = robotItem4Dao.readDbData(identity);
        if(items4 == null) {
            items4 = new ArrayList<>();
        }
        entityCache.addModelData(items4, PlayerItem4.class);
        setItemCount(identity, items4);
        // 收集品
        List<RobotItem5> items5 = robotItem5Dao.readDbData(identity);
        if(items5 == null) {
            items5 = new ArrayList<>();
        }
        entityCache.addModelData(items5, PlayerItem5.class);
        setItemCount(identity, items5);
        // 道具
        List<RobotItem6> items6 = robotItem6Dao.readDbData(identity);
        if(items6 == null) {
            items6 = new ArrayList<>();
        }
        entityCache.addModelData(items6, PlayerItem6.class);
        setItemCount(identity, items6);
        // 宝贝
        List<RobotItem7> items7 = robotItem7Dao.readDbData(identity);
        if(items7 == null) {
            items7 = new ArrayList<>();
        }
        entityCache.addModelData(items7, PlayerItem7.class);
        setItemCount(identity, items7);
        // 特殊物品
        List<RobotItem100> items100 = robotItem100Dao.readDbData(identity);
        if(items100 == null) {
            items100 = new ArrayList<>();
        }
        entityCache.addModelData(items100, PlayerItem100.class);
        setItemCount(identity, items100);

        // 更新缓存道具
        try {
            DataManager.INSTANCE.syncItem(identity);
        } catch (CommonException e) {
            String error = Utility.getTraceString(e);
            log.error("msg {}, error {}", e.getMessage(), error);
        }
        // 鉴定
        List<RobotVerify> verifys = robotVerifyDao.readDbData(identity);
        if(verifys == null) {
            verifys = new ArrayList<>();
        }
        entityCache.addModelData(verifys, RobotVerify.class);
        ServiceManager.getVerifyService().setRobotVerifyQueue(identity, verifys);
        // 馆藏
        List<RobotShowTableMoney> showTableMoneys = robotShowTableMoneyDao.readDbData(identity);
        if(showTableMoneys == null) {
            showTableMoneys = new ArrayList<>();
        }
        entityCache.addModelData(showTableMoneys, PlayerShowTableMoney.class);
        // 农场
        List<RobotFarm> farms = robotFarmDao.readDbData(identity);
        if(farms == null) {
            farms = new ArrayList<>();
        }
        entityCache.addModelData(farms, RobotFarm.class);

    }

    /**
     * 加载物品和数量到内存
     * @param roleID
     * @param items
     */
	private void setItemCount(long roleID, List<? extends IRobotItem> items) {
        Map<Integer, Long> pieceMap = Maps.newHashMap();
		for (IRobotItem item : items) {
		    pieceMap.put(item.getItemID(), item.getItemCount());
		}
		if(pieceMap.size() > 0) {
			ServiceManager.getItemService().setItemCount(roleID, pieceMap);
		}
	}
}
