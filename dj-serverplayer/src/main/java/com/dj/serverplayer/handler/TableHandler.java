package com.dj.serverplayer.handler;

import com.dj.domain.RedisKeys;
import com.dj.domain.config.ConfigItems;
import com.dj.domain.config.ConfigTasks;
import com.dj.domain.entity.player.PlayerShowTable;
import com.dj.domain.entity.player.PlayerShowTableMoney;
import com.dj.domain.enums.ItemColor;
import com.dj.domain.enums.ResourceBillEnum;
import com.dj.domain.enums.TaskActionEnum;
import com.dj.domain.util.DateUtil;
import com.dj.protobuf.CommonException;
import com.dj.protobuf.ErrorIDOuterClass;
import com.dj.protobuf.ErrorIDOuterClass.ErrorID;
import com.dj.protobuf.showtable.*;
import com.dj.serverapi.redis.CommonRedis;
import com.dj.servercore.conf.ConfigAntiqueConf;
import com.dj.servercore.conf.ConfigItemsConf;
import com.dj.servercore.conf.ConfigSundryConf;
import com.dj.serverplayer.handler.base.BaseHandler;
import com.dj.serverplayer.manager.ConfManager;
import com.dj.serverplayer.manager.EventManager;
import com.google.common.collect.Sets;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author zcq
 * @description 展厅业务处理
 * @date 2019年4月23日
 */
@Component
@Slf4j
public class TableHandler extends BaseHandler {
    /**
     *	将物品放在展架上
     *
     * @param roleID
     * @param req
     */
    public void showTablePutOn(long roleID, ShowTablePutOnReq req, ShowTablePutOnRsp.Builder builder) {
        Map<Integer, PlayerShowTable> showtables = showTableService.getShowTable(roleID, req.getType(), req.getPage());
        if(showtables == null){
            throw new CommonException(ErrorID.COMMON_PARAM_ERROR, roleID+":"+req.getType()+":"+req.getPage()+":"+req.getIndex());
        }
        if (showtables.containsKey(req.getIndex())) {
            log.error("showTablePutOn showtablescontainsKey req.getIndex() roleID:{}", roleID);
            throw new CommonException(ErrorID.COMMON_PARAM_ERROR, roleID+":"+req.getType()+":"+req.getPage()+":"+req.getIndex());
        }
        ConfigItemsConf conf = ConfManager.getInstance().getConfigItemsConf();
        if(conf == null){
            log.error("showTablePutOn ConfigItemsConf conf == null roleID:{}", roleID);
            throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
        }
        ConfigItems item = conf.getItem(req.getItemId());
        if(ObjectUtils.isEmpty(item)){
            log.error("showTablePutOn ConfigItems item == null roleID:{}", roleID);
            throw new CommonException(ErrorID.COMMON_CONFIG_ERROR);
        }
        // 未鉴定的不能放入展架
        if(item.getColor() == ItemColor.color1.getColor()){
            throw new CommonException(ErrorID.COMMON_PARAM_ERROR, roleID+":"+req.getItemId());
        }
        // 扣除仓库物品
        costItem(roleID, req.getItemId(), 1, ResourceBillEnum.showTablePutOn);
        // 放在展架上
        PlayerShowTable showTable = new PlayerShowTable(roleID);
        showTable.setItemID(req.getItemId());
        showTable.setType(req.getType());
        showTable.setPage(req.getPage());
        showTable.setIndex(req.getIndex());
        showTable.setX(req.getX());
        showTable.setY(req.getY());
        playerShowTableDao.cacheInsert(showTable, roleID);
        showTableService.showTablePutOn(roleID, showTable);
        // 添加馆藏值
        PlayerShowTableMoney showTableMoney = showTableService.increaseShowTableMoney(roleID, req.getType(), item.getGold());
        playerShowTableMoneyDao.cacheUpdate(showTableMoney, roleID);
        addShowTable(roleID, item.getGold(), ResourceBillEnum.showTablePutOn);
        builder.setMoney(showTableMoney.getMoney(req.getType()));
        Date leaveTime = DateUtil.plusTime(showTable.getCreateTime(), TimeUnit.DAYS, 1);
		builder.setLeaveSeconds(DateUtil.secondsBetween(DateUtil.getCurrentDate(), leaveTime));
		if(req.getType() == 0) {//展示宝物
            ConfigTasks configTasks = taskHandler.checkTaskAction(roleID, TaskActionEnum.SHOW_TREASURE);
            if ((configTasks != null) && (configTasks.getExtraParam() > 0)) {
                if(req.getItemId() == configTasks.getExtraParam()) {
                    //taskHandler.doTaskNeedItem(roleID, req.getItemId(), 1);
                    EventManager.postTaskActionEvent(roleID, TaskActionEnum.SHOW_TREASURE, 1);
                    EventManager.commitRoleEvent(roleID);
                }
            }
            //if ((configTasks != null) && (StringUtil.isNotEmpty(configTasks.getExtraParam()))) {
            //    Map<Integer, Integer> itemMap = MapUtil.mapStringToMap1(configTasks.getExtraParam());
            //    if((itemMap.size() > 0)&&(itemMap.containsKey(req.getItemId()))) {
            //        //taskHandler.doTaskNeedItem(roleID, req.getItemId(), 1);
            //        EventManager.postTaskActionEvent(roleID, TaskActionEnum.SHOW_TREASURE, 1);
            //        EventManager.commitRoleEvent(roleID);
            //    }
            //}
        }
        ConfigTasks configTasks = taskHandler.checkTaskAction(roleID, TaskActionEnum.CONJURE_ANIMALS);
        if(configTasks != null) {
            taskHandler.doTaskNeedItem(roleID, req.getItemId(), 1);
            EventManager.postTaskActionEvent(roleID, TaskActionEnum.CONJURE_ANIMALS, 1);
            EventManager.commitRoleEvent(roleID);
        }
    }

    /**
     *	将物品从展架上拿下来，放回仓库
     *
     * @param roleID
     * @param req
     */
    public int showTablePutDown(long roleID, ShowTablePutDownReq req) {
        Map<Integer, PlayerShowTable> showtables = showTableService.getShowTable(roleID, req.getType(), req.getPage());
        if (showtables == null) {
            throw new CommonException(ErrorID.COMMON_PARAM_ERROR, roleID+":"+req.getType()+":"+req.getPage());
        }
        int money = 0;
        for(int index : req.getIndexList()) {
            if (showtables.containsKey(index)) {
                // 将物品从展架上拿下来
                PlayerShowTable showTable = showtables.get(index);
                if (showTable != null) {
                    // 将物品从展架上拿下来
                    playerShowTableDao.cacheDelete(showTable.getId(), roleID);
                    showTableService.showTablePutDown(roleID, showTable);
                    // 放回仓库
                    addItem(roleID, showTable.getItemID(), 1, ResourceBillEnum.showTablePutDown, false);
                    // 扣除馆藏值
                    ConfigItemsConf conf = ConfManager.getInstance().getConfigItemsConf();
                    if (conf != null) {
                        ConfigItems item = conf.getItem(showTable.getItemID());
                        if (ObjectUtils.isNotEmpty(item)) {
                            PlayerShowTableMoney showTableMoney = showTableService.decreaseShowTableMoney(roleID, req.getType(), item.getGold());
                            playerShowTableMoneyDao.cacheUpdate(showTableMoney, roleID);
                            costShowTable(roleID, item.getGold(), ResourceBillEnum.showTablePutDown);
                            money = money + showTableMoney.getMoney(req.getType());
                        }
                    }
                }
            }
        }
        return money;
    }

    /**
     *	领取展厅的奖励
     *
     * @param roleID
     * @param type
     * @return
     */
    public int showTableDrawPrize(long roleID, int type) {
        int money = showTableService.moneyDrawPrize(roleID, type, showTableMoney -> playerShowTableMoneyDao.cacheUpdate(showTableMoney, roleID));
        if (money > 0) {
        	int rate = ConfigSundryConf.showTableRewardRate;
            addGold(roleID, money / rate, ResourceBillEnum.showTableDrawPrize);
        	return money / rate;
        }
        return 0;
    }

    /**
     *	移动展架上的物品位置
     *
     * @param roleID
     * @param req
     */
    public void showTableMove(long roleID, ShowTableMoveReq req) {
        Map<Integer, PlayerShowTable> showtables = showTableService.getShowTable(roleID, req.getType(), req.getPage());
        if (!showtables.containsKey(req.getIndex())) {
            throw new CommonException(ErrorID.COMMON_PARAM_ERROR, "roleID:" + roleID + ", type:" + req.getType()
                    + ", page:" + req.getPage() + ", index:" + req.getIndex());
        }
        PlayerShowTable showTable = showtables.get(req.getIndex());
        showTable.setX(req.getX());
        showTable.setY(req.getY());
        playerShowTableDao.cacheUpdate(showTable, roleID);
        showTableService.showTablePutOn(roleID, showTable);
    }

    /**
     *	获取馆藏值
     *
     * @param roleID
     * @param builder
     */
    public void showTableMoney(long roleID, ShowTableMoneyNtf.Builder builder) {
        PlayerShowTableMoney showTableMoney = showTableService.getShowTableMoney(roleID);
        builder.setTotalMoney(showTableMoney.getTotalMoney());
        builder.setTitle(showTableMoney.getTitle());
    }

    /**
     *	展厅合成
     *
     * @param roleID
     * @param req
     */
    public void antiqueCompose(long roleID, AntiqueComposeReq req) {
        // 获取合成组成物品
        ConfigAntiqueConf conf = ConfManager.getInstance().getConfigAntiqueConf();
        if(conf == null){
            log.error("antiqueCompose ConfigAntiqueConf conf == null roleID:{}", roleID);
            throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
        }
        Set<Integer> suitSet = conf.getComposeSub(req.getTargetId().getItemId());
        // 合成子图数量
        int suitCount = conf.getComposeCount(req.getTargetId().getItemId());
        // 带消耗的组成物品
        Set<Integer> subSet = Sets.newHashSetWithExpectedSize(suitCount);
        Map<Integer, PlayerShowTable> showtables = showTableService.getShowTable(roleID, req.getType(), req.getPage());
        for (Antique antique : req.getMaterialsList()) {
            if (!showtables.containsKey(antique.getIndex()) || showtables.get(antique.getIndex()).getItemID() != antique.getItemId()) {
                throw new CommonException(ErrorID.COMMON_PARAM_ERROR);
            }
            // 检查合成，添加到子物品
            if (suitSet.contains(antique.getItemId())) {
                subSet.add(antique.getItemId());
            }
        }
        // 判断合成子图数量是否相等
        if (subSet.size() != suitCount) {
            throw new CommonException(ErrorID.COMMON_PARAM_ERROR, subSet.size());
        }
        // 删除合成材料
        for (Antique antique : req.getMaterialsList()) {
            PlayerShowTable showTable = showtables.get(antique.getIndex());
            playerShowTableDao.cacheDelete(showTable.getId(), roleID);
            showTableService.showTablePutDown(roleID, showTable);
        }
        // 添加合成后物品
        addItem(roleID, req.getTargetId().getItemId(), 1, ResourceBillEnum.antiqueCompose,false);
//        PlayerShowTable showTable = new PlayerShowTable(roleID);
//        showTable.setId(readModuleID(TableID.TABLE_SHOWTABLE));
//        showTable.setCol(req.getCol());
//        showTable.setIndex(req.getTargetId().getIndex());
//        showTable.setItemID(req.getTargetId().getItemId());
//        showTable.setX(req.getTargetId().getX());
//        showTable.setY(req.getTargetId().getY());
//        showTable.setPage(req.getPage());
//        playerShowTableDao.cacheInsert(showTable, roleID);
//        showTableService.showTablePutOn(roleID, showTable);
    }

    /**
     *	物品交换位置
     *
     * @param roleID
     * @param req
     */
    public void showTableChangePosition(long roleID, ShowTableChangePositionReq req) {
        Map<Integer, PlayerShowTable> showtables = showTableService.getShowTable(roleID, req.getType(), req.getPage());
        if (!showtables.containsKey(req.getIndex1())) {
            throw new CommonException(ErrorID.COMMON_PARAM_ERROR, "roleID:" + roleID + ", type:" + req.getType()
                    + ", page:" + req.getPage() + ", index:" + req.getIndex1());
        }
        PlayerShowTable showTable1 = showtables.get(req.getIndex1());
        if (showtables.containsKey(req.getIndex2())) {
            // 互调位置
            int index = showTable1.getIndex();
            int x1 = showTable1.getX();
            int y1 = showTable1.getY();
            PlayerShowTable showTable2 = showtables.get(req.getIndex2());
            showTable1.setIndex(showTable2.getIndex());
            showTable1.setX(showTable2.getX());
            showTable1.setY(showTable2.getY());
            showTable2.setIndex(index);
            showTable2.setX(x1);
            showTable2.setY(y1);
            playerShowTableDao.cacheUpdate(showTable2, roleID);
            showTableService.showTablePutOn(roleID, showTable2);
        } else {
            // 下架
            showTableService.showTablePutDown(roleID, showTable1);
            // 移动位置
            showTable1.setIndex(req.getIndex2());
        }
        // 上架
        playerShowTableDao.cacheUpdate(showTable1, roleID);
        showTableService.showTablePutOn(roleID, showTable1);
    }

    /**
     *	展厅套装
     *
     * @param roleID
     * @param req
     */
    public void antiqueSuit(long roleID, AntiqueSuitReq req) {
        ConfigAntiqueConf conf = ConfManager.getInstance().getConfigAntiqueConf();
        if(conf == null){
            log.error("antiqueSuit ConfigAntiqueConf conf == null roleID:{}", roleID);
            throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
        }
        // 检查套装需要的材料
        List<Set<Integer>> suitList = conf.getSuitList();
        Set<Integer> suit = null;
        for (Set<Integer> suits : suitList) {
            int suitCount = 0;
            for (Antique antique : req.getMaterialsList()) {
                if (suits.contains(antique.getItemId())) {
                    suitCount++;
                }
            }
            if (suitCount == suits.size()) {
                suit = suits;
                break;
            }
        }
        if (suit == null) {
            log.error("antiqueSuit suit == null roleID:{}", roleID);
            throw new CommonException(ErrorID.COMMON_PARAM_ERROR);
        }
        long suitID = 0;
        if (req.getCombine()) {
            //显示套装
            suitID = CommonRedis.getInstance().readModuleID(RedisKeys.KEY_SUIT_ID);
        }
        // 修改展厅里的套装id
        Map<Integer, PlayerShowTable> showtableMap = showTableService.getShowTable(roleID, req.getType(), req.getPage());
        for (Antique antique : req.getMaterialsList()) {
            PlayerShowTable showTable = showtableMap.get(antique.getIndex());
            if (showTable == null) {
                continue;
            }
            if (req.getCombine()) {
                showTable.setSuitID(suitID);
            } else {
                showTable.setSuitID(0);
            }
            playerShowTableDao.cacheUpdate(showTable, roleID);
            showTableService.showTablePutOn(roleID, showTable);
        }
    }

    public int showTableAllPutDown(long roleID, ShowTableAllPutDownReq req) {
        Map<Integer, PlayerShowTable> showtables = showTableService.getShowTable(roleID, req.getType(), req.getPage());
        if (showtables == null) {
            throw new CommonException(ErrorID.COMMON_PARAM_ERROR, roleID+":"+req.getType()+":"+req.getPage());
        }
        int money = 0;
        for(PlayerShowTable showTable : showtables.values()) {
            // 将物品从展架上拿下来
            playerShowTableDao.cacheDelete(showTable.getId(), roleID);
            showTableService.showTablePutDown(roleID, showTable);
            // 放回仓库
            addItem(roleID, showTable.getItemID(), 1, ResourceBillEnum.showTablePutDown, false);
            // 扣除馆藏值
            ConfigItemsConf conf = ConfManager.getInstance().getConfigItemsConf();
            if (conf != null) {
                ConfigItems item = conf.getItem(showTable.getItemID());
                if (ObjectUtils.isNotEmpty(item)) {
                    PlayerShowTableMoney showTableMoney = showTableService.decreaseShowTableMoney(roleID, req.getType(), item.getGold());
                    playerShowTableMoneyDao.cacheUpdate(showTableMoney, roleID);
                    costShowTable(roleID, item.getGold(), ResourceBillEnum.showTablePutDown);
                    money = money + showTableMoney.getMoney(req.getType());
                }
            }
        }
        return money;
    }
}
