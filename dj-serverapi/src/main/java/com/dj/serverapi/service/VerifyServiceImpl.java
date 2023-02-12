package com.dj.serverapi.service;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import com.dj.domain.data.game.VerifyRoom;
import com.dj.domain.entity.robot.RobotVerify;
import com.dj.domain.entity.robot.item.RobotItem5;
import com.dj.domain.enums.ItemColor;
import com.dj.domain.enums.ResourceBillEnum;
import com.dj.domain.enums.TaskActionEnum;
import com.dj.domain.config.ConfigVerifyFunc;
import com.dj.domain.config.ConfigItems;
import com.dj.domain.data.Verify;
import com.dj.domain.entity.player.PlayerVerify;
import com.dj.domain.entity.player.PlayerVerifyHistory;
import com.dj.domain.entity.player.item.PlayerItem5;
import com.dj.protobuf.CommonException;
import com.dj.protobuf.ErrorIDOuterClass;
import com.dj.protobuf.ErrorIDOuterClass.ErrorID;
import com.dj.protobuf.verify.VerifyItemReq;
import com.dj.protobuf.verify.VerifyItemRsp;
import com.dj.serverapi.EventProvider;
import com.dj.serverapi.redis.model.CommonModel;
import com.dj.serverapi.redis.model.RobotVerifyModel;
import com.dj.serverapi.redis.model.VerifyModel;
import com.dj.serverapi.service.inf.IVerifyService;
import com.dj.servercore.conf.ConfigItemsConf;
import com.dj.servercore.conf.ConfigVerifyFuncConf;
import com.dj.servercore.conf.base.ConfProvider;
import com.dj.servercore.conf.base.IConfProvider;
import com.dj.servercore.redis.base.BaseService;
import com.dj.domain.util.DateUtil;
import com.dj.domain.util.inf.IArgumentRunnable;
import com.google.common.collect.Lists;

import com.google.common.collect.Maps;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;

@Slf4j
public class VerifyServiceImpl extends BaseService implements IVerifyService {

    @Getter
    private Map<Long, VerifyRoom> playerVerifyRoomMap  = Maps.newHashMap();
    @Getter
    private Map<Long, Long>  playerVerifyRoomRole = Maps.newHashMap();

    @Getter
    private Map<Long, VerifyRoom> robotVerifyRoomMap = Maps.newHashMap();
    @Getter
    private Map<Long, Long> robotVerifyRoomRole = Maps.newHashMap();

    @Override
    public void initNewRoleVerify(long roleID, List<PlayerItem5> items5) {
        List<PlayerItem5> itemList = Lists.newArrayList();
        ConfigItemsConf conf = ConfProvider.getConfigConfProvider().getConfigConf(IConfProvider.CONFIG_ITEMS);
        if(conf == null){
            throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
        }
        for (PlayerItem5 playerItem5 : items5) {
            ConfigItems config = conf.getItem(playerItem5.getItemID(), false);
            if(ObjectUtils.isNotEmpty(config)){
                //未鉴定
                if (config.getColor() == ItemColor.color1.getColor()) {
                    playerItem5.setInVerifyCount(0);
                    itemList.add(playerItem5);
                }
            }
        }
        Collections.sort(itemList);
        VerifyModel model = getWriteModel(roleID, VerifyModel.class);
        List<Verify> verifyList = model.getVerifyList();
        long time = System.currentTimeMillis();
        while (true) {
            boolean finish = true;
            for (PlayerItem5 playerItem5 : itemList) {
                if (playerItem5.getInVerifyCount() < playerItem5.getItemCount()) {
                    Verify verify = new Verify(playerItem5.getItemID(), ResourceBillEnum.initNewRoleItem.getSource(), time);
                    verifyList.add(verify);
                    playerItem5.setInVerifyCount(playerItem5.getInVerifyCount() + 1);
                    finish = false;
                }
            }
            if (finish) {
                break;
            }
        }
    }

    @Override
    public void addVerify(long roleID, PlayerItem5 item5, long changeCount, ResourceBillEnum bill) {
        log.info("roleID {}, itemID {}, itemCount {}, changeCount {}, bill", roleID, item5.getItemID(), item5.getItemCount(), changeCount, bill);
        VerifyModel model = getWriteModel(roleID, VerifyModel.class);
        List<Verify> verifyList = model.getVerifyList();
        long time = System.currentTimeMillis();
        for (int i = 0; i < changeCount; i++) {
            Verify verify = new Verify(item5.getItemID(), bill.getSource(), time);
            verifyList.add(verify);
        }
    }

    @Override
    public void delVerify(long roleID, PlayerItem5 item5, long changeCount) {
        log.info("roleID {}, itemID {}, itemCount {}, changeCount {}", roleID, item5.getItemID(), item5.getItemCount(), changeCount);
        VerifyModel model = getWriteModel(roleID, VerifyModel.class);
        List<Verify> verifyList = model.getVerifyList();
        if (verifyList.size() > 0) {
            for (int i = 0; i < changeCount; i++) {
                for (int j = verifyList.size() - 1; j >= 0; j--) {
                    Verify verify = verifyList.get(j);
                    if (verify.getItemID() == item5.getItemID()) {
                        verifyList.remove(j);
                        break;
                    }
                }
            }
        }
    }

    @Override
    public List<Verify> getVerifyList(long roleID) {
        VerifyModel model = getReadModel(roleID, VerifyModel.class);
        return model.getVerifyList();
    }

    @Override
    public void setVerifyQueue(long roleID, List<PlayerVerify> list) {
        VerifyModel model = getWriteModel(roleID, VerifyModel.class);
        model.setVerifyQueue(list);
    }

    @Override
    public List<PlayerVerify> getVerifyQueue(long roleID) {
    		VerifyModel model = getReadModel(roleID, VerifyModel.class);
    		return model.getVerifyQueue();
    }

    @Override
    public void verifyItem(long roleID, VerifyItemReq req, VerifyItemRsp.Builder builder, IArgumentRunnable<Integer> renownRun) {
        VerifyModel model = getWriteModel(req.getRoleId(), VerifyModel.class);
        List<PlayerVerify> verifyQueue = model.getVerifyQueue();
        Collections.sort(verifyQueue);
        if (req.getIndex() >= verifyQueue.size()) {
            throw new CommonException(ErrorID.COMMON_PARAM_ERROR);
        }
        PlayerVerify playerVerify = verifyQueue.get(req.getIndex());
        if (playerVerify.getVerifyID() == 0 || playerVerify.getVerifyID() != req.getItemId()) {
            throw new CommonException(ErrorID.COMMON_PARAM_ERROR);
        }
        // 每个人只能鉴定一次
        List<Long> verifyRoleIDList = playerVerify.getVerifyRoleIDList();
        if(verifyRoleIDList == null) {
        	verifyRoleIDList = Lists.newArrayListWithCapacity(3);
        	playerVerify.setVerifyRoleIDList(verifyRoleIDList);
        }else if(verifyRoleIDList.contains(roleID)){
        	throw new CommonException(ErrorID.VERIFIY_ONCE_LIMIT);
        }
        // 添加到鉴定人
        verifyRoleIDList.add(roleID);
        // 鉴定时间
        ConfigVerifyFuncConf verifyFuncConf = ConfProvider.getConfigConfProvider().getConfigConf(IConfProvider.CONFIG_VERIFYFUNC);
        if(verifyFuncConf == null){
            throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
        }
        ConfigVerifyFunc verifyFunc = verifyFuncConf.getConfigVerifyFunc(playerVerify.getVerifyID());
        if(verifyFunc == null){
            throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
        }
        int verifyTime = 0; //鉴定了60分钟
        Date verifyFinishTime = playerVerify.getVerifyFinishTime();
        if((verifyFinishTime == null)||(verifyFinishTime.getTime() <= System.currentTimeMillis())) {
            playerVerify.setVerifyFinishTime(DateUtil.plusNow(TimeUnit.MINUTES, verifyFunc.getVerifyTime()));
            verifyTime = verifyFunc.getVerifyTime();
            // 鉴定中
            int verifyCD = DateUtil.secondsBetween(DateUtil.getCurrentDate(), verifyFinishTime);
            builder.setVerifyCD(verifyCD);
        }else{
            // 扣除鉴定剩余时间
            verifyFinishTime = DateUtil.plusTime(verifyFinishTime, TimeUnit.MINUTES, -verifyFunc.getVerifyTime());
            if(verifyFinishTime.getTime() <= System.currentTimeMillis()) {
                // 鉴定结束
                verifyFinishTime = DateUtil.getCurrentDate();
                builder.setVerifyCD(0);
            }else {
                // 鉴定中
                int verifyCD = DateUtil.secondsBetween(DateUtil.getCurrentDate(), verifyFinishTime);
                builder.setVerifyCD(verifyCD);
            }
            playerVerify.setVerifyFinishTime(verifyFinishTime);
        }
        // 添加历史记录
    	PlayerVerifyHistory history = new PlayerVerifyHistory(playerVerify.getRoleID());
    	history.setVerifyID(playerVerify.getVerifyID());
    	history.setVerifyRoleID(roleID);
    	history.setVerifyTime(DateUtil.getCurrentDate());
    	history.setVerifyCD(verifyTime);
    	List<PlayerVerifyHistory> historyList = playerVerify.getHistoryList();
    	if(historyList == null) {
    		historyList = Lists.newArrayListWithCapacity(3);
    	}
    	historyList.add(history);
        playerVerify.setHistoryList(historyList);
        // 同步更新鉴定数据
        List<PlayerVerify> verifyUpdate = model.getVerifyUpdate();
        verifyUpdate.add(playerVerify);
        // 返回声望
        if(renownRun != null) {
        	renownRun.run(playerVerify.getResultRep());
        }
        EventProvider.postTaskActionEvent(roleID, TaskActionEnum.VERIFY_FRIEND, 1);
        EventProvider.commitRoleEvent(roleID);
    }

    @Override
    public void verifyRobotItem(long roleID, VerifyItemReq req, VerifyItemRsp.Builder builder, IArgumentRunnable<Integer> renownRun) {
        CommonModel common = getWriteModel(roleID, CommonModel.class);
        RobotVerifyModel model = getWriteModel(roleID, RobotVerifyModel.class);
        List<RobotVerify> verifyQueue = model.getVerifyQueue();
        Collections.sort(verifyQueue);
        if (req.getIndex() >= verifyQueue.size()) {
            throw new CommonException(ErrorID.COMMON_PARAM_ERROR);
        }
        RobotVerify robotVerify = verifyQueue.get(req.getIndex());
        if (robotVerify.getVerifyID() != req.getItemId()) {
            throw new CommonException(ErrorID.COMMON_PARAM_ERROR);
        }
        // 小寻家鉴定时间已到，则重置
        Date verifyFinishTime = robotVerify.getVerifyFinishTime();
        if((verifyFinishTime == null)||(verifyFinishTime.getTime() <= System.currentTimeMillis())) {
        	robotVerify.setVerifyRoleID("");
        	robotVerify.setVerifyRoleIDList(null);
        	ConfigVerifyFuncConf verifyFuncConf = ConfProvider.getConfigConfProvider().getConfigConf(IConfProvider.CONFIG_VERIFYFUNC);
            if(verifyFuncConf == null){
                throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
            }
            ConfigVerifyFunc verifyFunc = verifyFuncConf.getConfigVerifyFunc(robotVerify.getVerifyID());
            if(verifyFunc != null){
                robotVerify.setVerifyFinishTime(DateUtil.plusNow(TimeUnit.MINUTES, verifyFunc.getVerifyTime()));
            }
        }
        // 只能帮小寻每个宝物鉴定一次
        String verifyRoleID = roleID + "";
        //if(robotVerify.getVerifyRoleID().contains(verifyRoleID)){
        //	throw new CommonException(ErrorID.VERIFIY_ONCE_LIMIT);
        //}
        robotVerify.setVerifyRoleID(verifyRoleID);
        // 扣除鉴定剩余时间
        verifyFinishTime = DateUtil.plusTime(verifyFinishTime, TimeUnit.HOURS, -1);
        if(verifyFinishTime.getTime() <= System.currentTimeMillis()) {
        	// 鉴定时间结束了，返回鉴定结果，主人可以拿宝物了
        	verifyFinishTime = DateUtil.getCurrentDate();
        	builder.setVerifyCD(0);
        }else {
        	// 鉴定结束时间未到
        	int verifyCD = DateUtil.secondsBetween(DateUtil.getCurrentDate(), verifyFinishTime);
        	builder.setVerifyCD(verifyCD);
        }
        robotVerify.setVerifyFinishTime(verifyFinishTime);
        // 返回声望
        renownRun.run(robotVerify.getResultRep());
        // 帮小寻鉴定标记
        common.setVerifyXiaoXun(true);
        EventProvider.postTaskActionEvent(roleID, TaskActionEnum.VERIFY_FRIEND, 1);
        EventProvider.commitRoleEvent(roleID);
    }

    @Override
    public void updateVerify(long roleID, IArgumentRunnable<PlayerVerify> run) {
        VerifyModel model = getWriteModel(roleID, VerifyModel.class);
        List<PlayerVerify> verifyUpdate = model.getVerifyUpdate();
        verifyUpdate.forEach(value -> run.run(value));
        verifyUpdate.clear();
    }

    @Override
    public void addRobotVerify(long roleID, RobotItem5 robotItem, long changeCount, ResourceBillEnum bill) {
        log.info("roleID {}, itemID {}, itemCount {}, changeCount {}, bill", roleID, robotItem.getItemID(), robotItem.getItemCount(), changeCount, bill);
        RobotVerifyModel model = getWriteModel(roleID, RobotVerifyModel.class);
        List<Verify> verifyList = model.getVerifyList();
        long time = System.currentTimeMillis();
        for (int i = 0; i < changeCount; i++) {
            Verify verify = new Verify(robotItem.getItemID(), bill.getSource(), time);
            verifyList.add(verify);
        }
    }

    @Override
    public void delRobotVerify(long roleID, RobotItem5 robotItem, long changeCount) {
        log.info("roleID {}, itemID {}, itemCount {}, changeCount {}", roleID, robotItem.getItemID(), robotItem.getItemCount(), changeCount);
        RobotVerifyModel model = getWriteModel(roleID, RobotVerifyModel.class);
        List<Verify> verifyList = model.getVerifyList();
        if (verifyList.size() > 0) {
            for (int i = 0; i < changeCount; i++) {
                for (int j = verifyList.size() - 1; j >= 0; j--) {
                    Verify verify = verifyList.get(j);
                    if (verify.getItemID() == robotItem.getItemID()) {
                        verifyList.remove(j);
                        break;
                    }
                }
            }
        }
    }

    @Override
    public List<Verify> getRobotVerifyList(long roleID) {
        RobotVerifyModel model = getReadModel(roleID, RobotVerifyModel.class);
        return model.getVerifyList();
    }

    @Override
    public void setRobotVerifyQueue(long roleID, List<RobotVerify> list) {
        RobotVerifyModel model = getWriteModel(roleID, RobotVerifyModel.class);
        model.setVerifyQueue(list);
    }

    @Override
    public List<RobotVerify> getRobotVerifyQueue(long verifyRoleID) {
        ConfigVerifyFuncConf verifyFuncConf = ConfProvider.getConfigConfProvider().getConfigConf(IConfProvider.CONFIG_VERIFYFUNC);
        if(verifyFuncConf == null){
            throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
        }
        RobotVerifyModel model = getWriteModel(verifyRoleID, RobotVerifyModel.class);
        List<RobotVerify> list = model.getVerifyQueue();
        for (RobotVerify robotVerify : list) {
            if((robotVerify.getVerifyID() > 0)
                    &&(robotVerify.getVerifyRoleID().equals(verifyRoleID+""))
                    &&(robotVerify.getVerifyFinishTime().getTime() <= System.currentTimeMillis())) {
                ConfigVerifyFunc verifyFunc = verifyFuncConf.getConfigVerifyFunc(robotVerify.getVerifyID());
                if(verifyFunc != null){
                    robotVerify.setVerifyFinishTime(DateUtil.plusNow(TimeUnit.MINUTES, verifyFunc.getVerifyTime()));
                }
            }
        }
        return list;
    }

    @Override
    public Map<Long, VerifyRoom> getPlayerVerifyRoomMap() {
        return playerVerifyRoomMap;
    }
    @Override
    public void setPlayerVerifyRoomMap(Map<Long, VerifyRoom> playerVerifyRoomMap) {
        this.playerVerifyRoomMap = playerVerifyRoomMap;
    }
    @Override
    public Map<Long, Long> getPlayerVerifyRoomRole() {
        return playerVerifyRoomRole;
    }
    @Override
    public void setPlayerVerifyRoomRole(Map<Long, Long> playerVerifyRoomRole) {
        this.playerVerifyRoomRole = playerVerifyRoomRole;
    }
    @Override
    public Map<Long, VerifyRoom> getRobotVerifyRoomMap() {
        return robotVerifyRoomMap;
    }
    @Override
    public void setRobotVerifyRoomMap(Map<Long, VerifyRoom> robotVerifyRoomMap) {
        this.robotVerifyRoomMap = robotVerifyRoomMap;
    }
    @Override
    public Map<Long, Long> getRobotVerifyRoomRole() {
        return robotVerifyRoomRole;
    }
    @Override
    public void setRobotVerifyRoomRole(Map<Long, Long> robotVerifyRoomRole) {
        this.robotVerifyRoomRole = robotVerifyRoomRole;
    }

    @Override
    public void addPlayerVerifyRoomRole(long roleID, long verifyRoleID) {
        this.playerVerifyRoomRole.put(roleID,verifyRoleID);
    }

    @Override
    public void addRobotVerifyRoomRole(long roleID, long verifyRoleID) {
        this.robotVerifyRoomRole.put(roleID,verifyRoleID);
    }

    @Override
    public VerifyRoom getPlayerVerifyRoom(long verifyRoleID) {
        return playerVerifyRoomMap.get(verifyRoleID);
    }

    @Override
    public VerifyRoom getRobotVerifyRoom(long verifyRoleID) {
        return robotVerifyRoomMap.get(verifyRoleID);
    }

    @Override
    public void addPlayerVerifyRoom(long verifyRoleID, VerifyRoom verifyRoom) {
        playerVerifyRoomMap.put(verifyRoleID, verifyRoom);
    }

    @Override
    public void addRobotVerifyRoom(long verifyRoleID, VerifyRoom verifyRoom) {
        robotVerifyRoomMap.put(verifyRoleID, verifyRoom);
    }

    @Override
    public void removePlayerVerifyRoomRole(long roleID) {
        this.playerVerifyRoomRole.remove(roleID);
    }

    @Override
    public void removeRobotVerifyRoomRole(long roleID) {
        this.robotVerifyRoomRole.remove(roleID);
    }
}
