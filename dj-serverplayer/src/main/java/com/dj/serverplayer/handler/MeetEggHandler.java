package com.dj.serverplayer.handler;

import com.dj.domain.config.ConfigMeetEggDropItems;
import com.dj.domain.config.ConfigMeetEggGhostData;
import com.dj.domain.config.ConfigMiniGame;
import com.dj.domain.constant.ConstantGame;
import com.dj.domain.data.meetEgg.MeetEggBuild;
import com.dj.domain.data.meetEgg.MeetEggRoom;
import com.dj.domain.entity.player.PlayerRole;
import com.dj.domain.enums.ResourceBillEnum;
import com.dj.domain.util.DateUtil;
import com.dj.domain.util.math.RandomUtil;
import com.dj.protobuf.CommonException;
import com.dj.protobuf.ErrorIDOuterClass;
import com.dj.protobuf.ErrorIDOuterClass.ErrorID;
import com.dj.protobuf.meetEgg.*;
import com.dj.servercore.conf.ConfigMeetEggDropItemsConf;
import com.dj.servercore.conf.ConfigMeetEggGhostDataConf;
import com.dj.servercore.conf.ConfigMiniGameConf;
import com.dj.servercore.conf.ConfigSundryConf;
import com.dj.serverplayer.handler.base.BaseHandler;
import com.dj.serverplayer.manager.ConfManager;
import com.dj.serverplayer.worker.MeetEggWorker;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 接鸡蛋处理
 */
@Slf4j
@Component
public class MeetEggHandler extends BaseHandler {

    private static String DROP_TIMEID = "%s_%d_%d";
    /**
     *	开始接鸡蛋
     *
     * @param roleID
     * @param req
     * @return 配方id
     */
    public void startMeetEgg(long roleID, StartMeetEggReq req, StartMeetEggRsp.Builder builder) {
        ConfigMiniGameConf conf = ConfManager.getInstance().getConfigMiniGameConf();
        if(conf == null){
            log.error("startMeetEgg ConfigMiniGameConf conf == null roleID:{}", roleID);
            throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
        }
        ConfigMiniGame config = conf.getMiniGame(ConstantGame.MINI_GAME_EGG);
        checkLevelEnough(roleID, config.getNeedLevel());
        // 接鸡蛋建筑cd判断
        MeetEggBuild build = meetEggSingleService.getMeetEggBuild(roleID, req.getBuildID());
        if (build != null && build.getMeetEggTime() > 0) {
            Date date = DateUtil.plusTime(new Date(build.getMeetEggTime()), TimeUnit.SECONDS, ConfigSundryConf.meetEggBuildCD);
            if (System.currentTimeMillis() < date.getTime()) {
                throw new CommonException(ErrorID.MEET_EGG_IN_CD);
            }
        }
        // 生成房间
        MeetEggRoom room = MeetEggWorker.getWorker().getRoomMap().get(roleID);
        if (room == null) {
            log.error("startMeetEgg MeetEggRoom room == null roleID:{}", roleID);
            PlayerRole playerRole = playerService.getPlayer(roleID);
            room = new MeetEggRoom(roleID);
            room.setBuildID(req.getBuildID());
            room.setGateServerID(playerRole.getGateServerID());
            MeetEggWorker.getWorker().addRoom(roleID, room);
        }
        room.setZero(false);
        room.setTotalScore(0);
        room.setPositionX(req.getPositionX());
        // 生成掉落物
        ConfigMeetEggGhostDataConf ghostDataConf = ConfManager.getInstance().getConfigMeetEggGhostDataConf();
        if(ghostDataConf == null){
            throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
        }
        MeetEggDropItem.Builder dropItemBuilder = MeetEggDropItem.newBuilder();
        List<MeetEggDropItem> dropItems = Lists.newArrayListWithExpectedSize(3);
        for(int i=1; i<=3; i++ ) {
            int ghostId = RandomUtil.weightedRandom(ghostDataConf.getWeightedMap());
            ConfigMeetEggGhostData ghostData = ghostDataConf.getMeetEggGhostData(ghostId);
            ConfigMeetEggDropItemsConf dropItemsConf = ConfManager.getInstance().getConfigMeetEggDropItemsConf();
            ConfigMeetEggDropItems dropItem = dropItemsConf.getMeetEggRandomDropItems(ghostData.getSubType());
            Date nowDate = DateUtil.getCurrentDate();
            String nowStr = DateUtil.formatDate(nowDate, DateUtil.STYLE20);
            String dropTimeID = String.format(DROP_TIMEID, nowStr, dropItem.getID(), i);
            dropItemBuilder.setTimeID(dropTimeID);
            dropItemBuilder.setDropID(dropItem.getID());
            dropItemBuilder.setLeftSeconds(i);
            dropItems.add(dropItemBuilder.build());
        }
        builder.addAllDropItems(dropItems);
        // 随机配方
//        ConfigMeetEggMakeDataConf makeConf = ConfManager.getInstance().getConfigMeetEggMakeDataConf();
//        if(makeConf == null){
//            throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
//        }
//        room.setMakeID(RandomUtil.weightedRandom(makeConf.getWeightedMap()));
//        room.setNextMakeID1(RandomUtil.weightedRandom(makeConf.getWeightedMap()));
//        room.setNextMakeID2(RandomUtil.weightedRandom(makeConf.getWeightedMap()));
        // 返回配方给前端
//        builder.setMakeID(room.getMakeID());
//        builder.setNextMakeID1(room.getNextMakeID1());
//        builder.setNextMakeID2(room.getNextMakeID2());
    }

    /**
     *	变化平底锅的位置
     *
     * @param roleID
     * @param req
     * @param builder
     */
    public void changeMeetX(long roleID, ChangeMeetXReq req, ChangeMeetXRsp.Builder builder) {
        MeetEggRoom room = MeetEggWorker.getWorker().getRoomMap().get(roleID);
        if (room == null) {
            log.error("changeMeetX MeetEggRoom room == null roleID:{}", roleID);
            return;
        }
        room.setPositionX(req.getPositionX());
        room.setDirectionX(req.getDirectionX());
    }

    /**
     *	接到了掉落物
     *
     * @param roleID
     * @param req
     * @param builder
     */
    public void meetDrop(long roleID, MeetDropReq req, MeetDropRsp.Builder builder) {
        MeetEggRoom room = MeetEggWorker.getWorker().getRoomMap().get(roleID);
        if (room == null) {
            log.error("meetDrop MeetEggRoom room == null roleID:{}", roleID);
            return;
        }
        long nowTime = System.currentTimeMillis();
        String[] arr = req.getTimeID().split("_");
        // 防作弊
        Date date = DateUtil.parseDate(arr[0], DateUtil.STYLE20);
        date = DateUtil.plusTime(date, TimeUnit.MILLISECONDS, MeetEggWorker.dropMilliSecond+Integer.parseInt(arr[1])*1000);
        if(date.getTime() < nowTime) {
        	room.setZero(true);
        }
        int dropID = Integer.parseInt(arr[1]);
        ConfigMeetEggDropItemsConf conf = ConfManager.getInstance().getConfigMeetEggDropItemsConf();
        if(conf == null){
            throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
        }
        ConfigMeetEggDropItems meetEggDropItems = conf.getMeetEggDropItems(dropID);
        if(meetEggDropItems.getSubType() > 0){
            addItem(roleID, meetEggDropItems.getID(), 1, ResourceBillEnum.meetDrop, false);
            // 结算积分
            int score = meetEggDropItems.getScore();
            room.setTotalScore(room.getTotalScore() + score);
            builder.setMeetScore(score);
            builder.setTotalScore(room.getTotalScore());
        }else {
            room.setState(2);
            builder.setMeetScore(0);
            builder.setTotalScore(room.getTotalScore());
            builder.putAllMeetItemMap(room.getMeetItemMap());
        }
//        // 是否需要鸡蛋
//        boolean needEgg = checkNeedEgg(config);
//        if (needEgg && dropID == ConstantGame.GOLD_EGG) {
//            // 接到了金蛋
//            room.setDoubleEndTime(nowTime + ConfigSundryConf.meetEggGoldEggDoubleTime * 1000);
//            log.info("doubleEndTime {}", room.getDoubleEndTime());
//            // 积分翻倍剩余时间：秒
//            builder.setDoubleLeftSeconds(ConfigSundryConf.meetEggGoldEggDoubleTime);
//        }
//        // 累加材料
//        int num = 0;
//        if (dropID == config.getMatrial1()) {
//            num = config.getNum1();
//        } else if (dropID == config.getMatrial2()) {
//            num = config.getNum2();
//        } else if (dropID == config.getMatrial3()) {
//            num = config.getNum3();
//        }
//        if (num > MapUtils.getIntValue(room.getMeetItemMap(), dropID)) {
//            MapUtil.fundInt(room.getMeetItemMap(), dropID, 1);
//        }
//        // 是否将当前配方材料接完整
//        boolean makeFinish = true;
//        if (config.getNum1() > 0 && config.getNum1() > MapUtils.getIntValue(room.getMeetItemMap(), config.getMatrial1())) {
//            makeFinish = false;
//        }
//        if (config.getNum2() > 0 && config.getNum2() > MapUtils.getIntValue(room.getMeetItemMap(), config.getMatrial2())) {
//            makeFinish = false;
//        }
//        if (config.getNum3() > 0 && config.getNum3() > MapUtils.getIntValue(room.getMeetItemMap(), config.getMatrial3())) {
//            makeFinish = false;
//        }
//        if (makeFinish) {
//            addItem(roleID, room.getMakeID(), 1, ResourceBillEnum.meetDrop, false);
//            // 当前配方材料接完整，则生成新的配方
//            room.setMakeID(room.getNextMakeID1());
//            room.setNextMakeID1(room.getNextMakeID2());
//            room.setNextMakeID2(RandomUtil.weightedRandom(conf.getWeightedMap()));
//            room.getMeetItemMap().clear();
//            // 结算积分
//            int score = config.getScore();
//            if (room.getDoubleEndTime() > nowTime) {
//                // 积分翻倍
//                score = config.getScore() * 2;
//            }
//            builder.setMeetScore(score);
//            room.setTotalScore(room.getTotalScore() + score);
//            builder.setTotalScore(room.getTotalScore());
//            // 返回配方给前端
//            builder.setMakeID(room.getMakeID());
//            builder.setNextMakeID1(room.getNextMakeID1());
//            builder.setNextMakeID2(room.getNextMakeID2());
//        } else {
//            builder.setMeetScore(0);
//            builder.setTotalScore(room.getTotalScore());
//            builder.putAllMeetItemMap(room.getMeetItemMap());
//            builder.setMakeID(0);
//            builder.setNextMakeID1(0);
//            builder.setNextMakeID2(0);
//        }
    }

    /**
     *	暂停开始
     *
     * @param roleID
     * @param req
     * @param builder
     */
    public void meetEggPauseStart(long roleID, MeetEggPauseStartReq req, MeetEggPauseStartRsp.Builder builder) {
        MeetEggRoom room = MeetEggWorker.getWorker().getRoomMap().get(roleID);
        room.setState(req.getState());
        Date nowDate = DateUtil.getCurrentDate();
        // 1暂停， 0开始
        if (req.getState() == 1) {
            room.setPauseDate(nowDate);
        } else {
            int second = DateUtil.secondsBetween(room.getPauseDate(), nowDate);
            room.setPauseSecond(room.getPauseSecond() + second);
        }
        Date endDate = DateUtil.plusTime(room.getStartDate(), TimeUnit.SECONDS, ConfigSundryConf.meetEggGameTime + room.getPauseSecond());
        int leftSeconds = DateUtil.secondsBetween(nowDate, endDate);
        builder.setLeftSeconds(leftSeconds);
    }
    /**
     *	退出接鸡蛋
     *
     * @param roleID
     * @param req
     * @param builder
     */
    public void exitMeetEgg(long roleID, ExitMeetEggReq req, ExitMeetEggRsp.Builder builder) {
        MeetEggRoom room = MeetEggWorker.getWorker().getRoomMap().get(roleID);
        if (room == null) {
            log.error("exitMeetEgg MeetEggRoom room == null roleID:{}", roleID);
            return;
        }
        room.setState(2);
    }

    /**
     *	判断配方是否需要鸡蛋
     *
     * @param config
     * @return
     */
//    private boolean checkNeedEgg(ConfigMeetEggMakeData config) {
//        if (ConstantGame.EGG == config.getMatrial1()) {
//            return true;
//        } else if (ConstantGame.EGG == config.getMatrial2()) {
//            return true;
//        } else {
//            return ConstantGame.EGG == config.getMatrial3();
//        }
//    }
}
