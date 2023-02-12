package com.dj.serverplayer.server;

import com.dj.domain.GlobalRoleID;
import com.dj.domain.config.ConfigItems;
import com.dj.domain.config.ConfigVerifyFunc;
import com.dj.domain.entity.robot.RobotRole;
import com.dj.domain.entity.robot.RobotVerify;
import com.dj.domain.entity.robot.item.RobotItem5;
import com.dj.domain.enums.ItemColor;
import com.dj.domain.util.DateUtil;
import com.dj.domain.util.lib.QueryParamMap;
import com.dj.protobuf.CommonException;
import com.dj.protobuf.ErrorIDOuterClass;
import com.dj.protobuf.common.ERoleFiveEle;
import com.dj.serverapi.dao.*;
import com.dj.serverapi.dao.item.RobotItem5Dao;
import com.dj.servercore.conf.ConfigItemsConf;
import com.dj.servercore.conf.ConfigVerifyFuncConf;
import com.dj.servercore.conf.base.ConfProvider;
import com.dj.servercore.conf.base.IConfProvider;
import com.dj.servercore.db.cache.CacheManager;
import com.dj.serverplayer.handler.ItemHandler;
import com.dj.serverplayer.manager.ServiceManager;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author zcq
 * @ClassName: PlayerServerInit
 * @Description: 玩家服初始化
 * @date 2019年7月2日
 */
@Component
public class PlayerRobotInit {
    @Autowired
    @Qualifier("robotCacheManager")
    public CacheManager     robotCacheManager;
    @Autowired
    public RobotRoleDao     robotRoleDao;
    @Autowired
    public RobotFactoryDao robotFactoryDao;
    @Autowired
    public RobotShowTableDao robotShowTableDao;
    @Autowired
    public RobotShowTableMoneyDao robotShowTableMoneyDao;
    @Autowired
    public ItemHandler itemHandler;
    @Autowired
    public RobotFarmDao   robotFarmDao;
    @Autowired
    public RobotItem5Dao  robotItem5Dao;
    @Autowired
    public RobotVerifyDao robotVerifyDao;

    public void init(long roleId) {
        // 初始化角色小寻
        QueryParamMap queryParams = new QueryParamMap();
        queryParams.put("roleID",roleId);
        RobotRole xxRole = robotRoleDao.cacheSelect(queryParams, roleId);
        if (xxRole == null) {
            xxRole = robotRoleDao.createRole(roleId, 100, GlobalRoleID.getXiaoXunRoleName(), "serverInit", 1, ERoleFiveEle.Gold_VALUE);
            // 初始化建筑
            robotFactoryDao.initFactory(roleId);
            // 小寻出生的物品
            itemHandler.initXiaoXunItem(roleId);
            // 玩家出生时农场植物
            robotFarmDao.initNewRoleFarm(roleId);
            // 玩家出生时展架上就有的物品
            Map<Integer, Integer> moneyMap = robotShowTableDao.initNewRoleShowTableItem(roleId);
            // 馆藏值初始化
            robotShowTableMoneyDao.createPlayerShowTableMoney(roleId, moneyMap);
            // 鉴定队列初始化
            robotVerifyDao.initNewRoleGuideVerify(roleId);
            // 同步小寻缓存
            //robotCacheManager.flushSyncAllData(roleId, false);
            // 激活小寻缓存
            robotCacheManager.activateCache(roleId);
        }
        List<RobotVerify> queues = robotVerifyDao.cacheLoadAll(roleId);
        if (queues == null || queues.size() == 0) {
            ConfigItemsConf itemsConf = ConfProvider.getConfigConfProvider().getConfigConf(IConfProvider.CONFIG_ITEMS);
            if(itemsConf == null){
                throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
            }
            ConfigVerifyFuncConf verifyFuncConf = ConfProvider.getConfigConfProvider().getConfigConf(IConfProvider.CONFIG_VERIFYFUNC);
            if(verifyFuncConf == null){
                throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
            }
            // 补充鉴定队列
            List<RobotItem5> items5 = robotItem5Dao.cacheLoadAll(roleId);
            if(items5 != null && items5.size() > 0) {
                for (RobotItem5 robotItem5 : items5) {
                    ConfigItems item = itemsConf.getItem(robotItem5.getItemID(), false);
                    // 未鉴定
                    if (ObjectUtils.isNotEmpty(item) && item.getColor() == ItemColor.color1.getColor()) {
                        ConfigVerifyFunc verifyFunc = verifyFuncConf.getConfigVerifyFunc(robotItem5.getItemID());
                        if(verifyFunc == null){
                            throw new CommonException(ErrorIDOuterClass.ErrorID.COMMON_CONFIG_ERROR);
                        }
                        RobotVerify robotVerify = new RobotVerify(roleId);
                        robotVerify.setVerifyID(robotItem5.getItemID());
                        robotVerify.setVerifyRoleID("");
                        robotVerify.setVerifyFinishTime(DateUtil.plusNow(TimeUnit.MINUTES, verifyFunc.getVerifyTime()));
                        // 先出鉴定结果，后续再用
                        Integer color = verifyFuncConf.getProResult(robotVerify.getVerifyID());
                        Integer exp = verifyFuncConf.getProExp(robotVerify.getVerifyID());
                        int newItemId = itemsConf.getItemIdByType(robotVerify.getVerifyID(), color);
                        robotVerify.setResultItem(newItemId);
                        robotVerify.setResultRep(exp);
                        robotVerifyDao.cacheInsert(robotVerify, roleId);
                    }
                }
            }
            queues = robotVerifyDao.cacheLoadAll(roleId);
            if(queues != null && queues.size() > 0) {
                ServiceManager.getVerifyService().setRobotVerifyQueue(roleId, queues);
            }
        }
    }
}
