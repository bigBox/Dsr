package com.dj.servergame.handler;

import com.dj.domain.GlobalRoleID;
import com.dj.domain.config.ConfigMineInit;
import com.dj.domain.config.ConfigTasks;
import com.dj.domain.constant.ConstantGame;
import com.dj.domain.data.game.MineRole;
import com.dj.domain.data.game.MineRoom;
import com.dj.domain.data.game.SceneCellUnit;
import com.dj.domain.entity.player.PlayerRole;
import com.dj.domain.entity.player.task.ITask;
import com.dj.domain.entity.player.task.PlayerTask1;
import com.dj.domain.enums.ResourceBillEnum;
import com.dj.domain.enums.TaskActionEnum;
import com.dj.domain.enums.TaskState;
import com.dj.domain.util.DateUtil;
import com.dj.domain.util.StringUtil;
import com.dj.protobuf.CommonException;
import com.dj.protobuf.ErrorIDOuterClass;
import com.dj.protobuf.ErrorIDOuterClass.ErrorID;
import com.dj.protobuf.chat.ChatSendNtf;
import com.dj.protobuf.chat.ChatSendReq;
import com.dj.protobuf.chat.EChatChannel;
import com.dj.protobuf.common.SceneUpdateType;
import com.dj.protobuf.datetime.DateTime;
import com.dj.protobuf.scene.*;
import com.dj.serverapi.ServiceProvider;
import com.dj.serverapi.dao.PlayerFarmDao;
import com.dj.serverapi.dao.task.PlayerTask1Dao;
import com.dj.serverapi.sensitiveword.SensitivewordFilter;
import com.dj.servercore.conf.ConfigMineInitConf;
import com.dj.servercore.conf.ConfigTasksConf;
import com.dj.servercore.conf.base.ConfProvider;
import com.dj.servercore.conf.base.IConfProvider;
import com.dj.servergame.manager.ChannelManager;
import com.dj.servergame.manager.ConfManager;
import com.dj.servergame.manager.EventManager;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *	多人挖矿
 */
@Component
@Slf4j
public class GameMineHandler extends ServiceProvider {

    /**
     *	房主-房间
     */
    @Getter
    private Map<String, MineRoom> mineRoomMap = Maps.newHashMap();

    /**
     *	角色ID-房主
     */
    @Getter
    private Map<Long, String> mineRoomRole = Maps.newHashMap();

    /**
     *	加入场景
     *
     * @param roleID
     * @param shovelCount 铲子数量
     * @return
     */
    public void joinScene(long roleID, JoinSceneReq req, JoinSceneRsp.Builder builder, int shovelCount) {
        // 房主ID
        String mapOwner = req.getId() + "-";
        if (req.getId() == GlobalRoleID.getXiaoXun()) {
            mapOwner = mapOwner + roleID;
        }
        // 挖矿角色ID-房主ID 映射关系
        mineRoomRole.put(roleID, mapOwner);
        // 地图房间
        MineRoom mineRoom = mineRoomMap.get(mapOwner);
        if (mineRoom == null) {
            mineRoom = new MineRoom(mapOwner);
            mineRoomMap.put(mapOwner, mineRoom);
            //地图上没有人就重置矿区
            long resetTime = gameMineService.resetMine(req.getId());
            mineRoom.setResetTime(resetTime);
        }
        // 矿区刷新倒计时
        Date resetDate = new Date(mineRoom.getResetTime());
        int resetCountDown = DateUtil.secondsBetween(new Date(), resetDate);
        builder.setResetCountDown(resetCountDown);
        // 进入挖矿的出生位置
        ConfigMineInitConf conf = ConfProvider.getConfigConfProvider().getConfigConf(IConfProvider.CONFIG_MINEINIT);
        if(conf == null){
            throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
        }
        ConfigMineInit config;
        if (req.getPos() == ESceneRebornPos.RebornPos) {
            config = conf.getMyPosition();
        } else {
            config = conf.getFriendPosition(req.getPos().getNumber());
        }
        // 设置挖矿角色
        MineRole mineRole = mineRoom.getMineRoleMap().get(roleID);
        if (mineRole == null) {
            mineRole = new MineRole(roleID);
            mineRoom.getMineRoleMap().put(roleID, mineRole);
        }
        // 挖矿角色职位
        if (req.getId() == roleID) {
            // 房主
            mineRole.setPost(ESceneRolePost.Owner);
            // 是否当天第一次进入自家的矿
            int mineCount = otherService.getAddMineCount(roleID);
            builder.setFirstFlag(mineCount == 1);
        } else {
        	itemService.addItemBill(roleID, ConstantGame.SHOVEL, -1, ResourceBillEnum.joinSceneFriend, true, true);
            EventManager.postSyncItemEvent(roleID);
            mineRole.setPost(ESceneRolePost.Guest);
        }
        // 挖矿角色位置
        mineRole.setPositionX(config.getRow() * ConstantGame.CELL_SIZE + ConstantGame.MINE_CELL_INIT_X_DIS);
        mineRole.setPositionY(config.getCol() * ConstantGame.CELL_SIZE + ConstantGame.MINE_CELL_INIT_Y_DIS);
        mineRole.setPositionZ(0);
        // 挖矿角色方向
        mineRole.setDirectionX(-1);
        mineRole.setDirectionY(0);
        mineRole.setDirectionZ(0);
        // 返回数据
        List<SceneRoleInfo> attenders = Lists.newArrayListWithExpectedSize(mineRoom.getMineRoleMap().size());
        mineRoom.getMineRoleMap().forEach((key, value)->{
            PlayerRole valueRole = playerService.getPlayer(value.getRoleID());
            attenders.add(getSceneRoleInfo(valueRole, value));
        });
        SceneDetailInfo.Builder detailInfo = SceneDetailInfo.newBuilder();
        SceneBriefInfo.Builder briefInfo = SceneBriefInfo.newBuilder();
        briefInfo.setId(req.getId());
        briefInfo.setName("mine");
        briefInfo.setLevel(1);
        briefInfo.setThemeId(1);
        briefInfo.setCurPlayerNum(1);
        briefInfo.setMaxPlayerNum(10);
        briefInfo.setIsNeedPassword(false);
        detailInfo.setBriefInfo(briefInfo);
        detailInfo.addAllAttenders(attenders);
        builder.setDetailInfo(detailInfo);
        EventManager.postJoinSceneNtf(roleID, mapOwner, mineRole);
        EventManager.postSceneMapNtf(roleID, mapOwner, SceneUpdateType.Total, null);
    }

    public SceneRoleInfo getSceneRoleInfo(PlayerRole role, MineRole mineRole) {
        SceneRoleInfo.Builder joinRoleInfo = SceneRoleInfo.newBuilder();
        joinRoleInfo.setRoleBaseInfo(role.toBaseRoleInfo());
        // 场景内打扮
        joinRoleInfo.addAllSceneClothes(Lists.newArrayListWithExpectedSize(0));
        // 场景内职位
        joinRoleInfo.setPost(mineRole.getPost());
        // 进入场景的时间
        joinRoleInfo.setAttendTime(DateTime.newBuilder().setValue(mineRole.getEnterTime()));
        // 所在场景坐标
        OtomeVector3D.Builder position = OtomeVector3D.newBuilder();
        position.setX(mineRole.getPositionX());
        position.setY(mineRole.getPositionY());
        position.setZ(mineRole.getPositionZ());
        joinRoleInfo.setPosition(position);
        // 方向
        OtomeVector3D.Builder direction = OtomeVector3D.newBuilder();
        direction.setX(mineRole.getDirectionX());
        direction.setY(mineRole.getDirectionY());
        direction.setZ(mineRole.getDirectionZ());
        joinRoleInfo.setDirection(direction);
        // 当前所处技能状态
        SceneRoleSkillStatus.Builder skillStatus = SceneRoleSkillStatus.newBuilder();
        if (mineRole.getSkillId() > 0) {
            skillStatus.setSkillId(mineRole.getSkillId());
            skillStatus.setSrcRoleId(mineRole.getRoleID());
            skillStatus.setTargetRoleId(mineRole.getTargetRoleId());
            skillStatus.setType(mineRole.getType());
            skillStatus.setSrcRoleDirection(mineRole.getSrcRoleDirection());
            skillStatus.setTargetRoleDirection(mineRole.getTargetRoleDirection());
        }
        joinRoleInfo.setSkillStatus(skillStatus);
        // 双倍奖励到期时间
        joinRoleInfo.setDoubleExpire(DateTime.newBuilder());
        return joinRoleInfo.build();
    }

    /**
     *	挖矿使用技能
     *
     * @param roleID
     * @param req
     * @return
     */
    public void sceneUseSkill(long roleID, SceneUseSkillReq req, SceneUseSkillRsp.Builder builder) {
        ErrorID errorID = ErrorID.OK;
        if (!mineRoomRole.containsKey(roleID)) {
            log.error("sceneUseSkill mineRoomRole not containsKey roleID:{} ",roleID);
            throw new CommonException(ErrorID.NOT_IN_MINE_ROOM);
        }
        String mapOwner = mineRoomRole.get(roleID);
        if(StringUtil.isEmpty(mapOwner)){
            log.error("sceneUseSkill mapOwner isEmpty! roleID:{} ",roleID);
            throw new CommonException(ErrorID.NOT_IN_MINE_ROOM);
        }
        MineRoom mineRoom = mineRoomMap.get(mapOwner);
        if(mineRoom == null){
            log.error("sceneUseSkill mineRoom == null roleID:{} mapOwner:{}",roleID, mapOwner);
            throw new CommonException(ErrorID.NOT_IN_MINE_ROOM);
        }
        MineRole mineRole = mineRoom.getMineRoleMap().get(roleID);
        if (mineRole == null) {
            log.error("sceneUseSkill mineRole == null roleID:{} mapOwner:{}",roleID, mapOwner);
            throw new CommonException(ErrorID.NOT_IN_MINE_ROOM);
        }
        mineRole.setSkillId(req.getSkillId());
        mineRole.setTargetRoleId(req.getTargetRoleId());
        mineRole.setType(req.getType());
        mineRole.setSrcRoleDirection(req.getSrcRoleDirection());
        mineRole.setTargetRoleDirection(req.getTargetRoleDirection());
        long mapOwnerRoleID = getMapOwnerRoleID(mapOwner);
        boolean isXX = checkIsXXMine(mapOwner);
        if (req.getType() == ESceneUseSkillType.Skill_Start) {
        	// 检查挖矿消耗的体力是否足够
            PlayerRole playerRole = playerService.getPlayer(roleID);
            if (playerRole.getStamina() > 0) {
	            // 开始挖矿
	            gameMineService.userSkillStart(roleID, mapOwnerRoleID, isXX, req.getTargetPos().getX(), req.getTargetPos().getY());
            } else {
                errorID = ErrorID.COMMON_PLAYER_STAMINA_LESS;
            }
        } else {
            // 挖了一个矿
            List<SceneCellUnit> list = gameMineService.userSkillCancel(roleID, mapOwnerRoleID, isXX, req.getTargetPos().getX(), req.getTargetPos().getY());
            if (list != null) {
                EventManager.postSceneMapNtf(roleID, mapOwner, SceneUpdateType.Update, list);
            } else {
                errorID = ErrorID.MINE_QUICK;
            }
        }
    	// 使用技能同步
    	EventManager.postSceneUseSkillNtfEvent(roleID, mapOwner, req, mineRole);
        EventManager.commitRoleEvent(roleID);
        builder.setErrorID(errorID);
    }

    /**
     *	挖矿场景中玩家移动
     *
     * @param roleID
     * @param req
     */
    public void sceneMovement(long roleID, SceneMovementReq req) {
        if (!mineRoomRole.containsKey(roleID)) {
            log.error("sceneMovement mineRoomRole not containsKey roleID:{} ",roleID);
            return;
        }
        String mapOwner = mineRoomRole.get(roleID);
        if(StringUtil.isEmpty(mapOwner)){
            log.error("sceneMovement mapOwner isEmpty! roleID:{} ",roleID);
            return;
        }
        MineRoom mineRoom = mineRoomMap.get(mapOwner);
        if (mineRoom == null) {
            log.error("sceneMovement mineRoom == null roleID:{} mapOwner:{}",roleID, mapOwner);
            return;
        }
        MineRole mineRole = mineRoom.getMineRoleMap().get(roleID);
        if (mineRole == null) {
            log.error("sceneMovement mineRole == null roleID:{} mapOwner:{}",roleID, mapOwner);
            throw new CommonException(ErrorID.NOT_IN_MINE_ROOM);
        }
        mineRole.setPositionX(req.getPos().getX());
        mineRole.setPositionY(req.getPos().getY());
        mineRole.setPositionZ(req.getPos().getZ());
        mineRole.setSpeed(req.getSpeed());
        mineRole.setDirectionX(req.getDirection().getX());
        mineRole.setDirectionY(req.getDirection().getY());
        mineRole.setDirectionZ(req.getDirection().getZ());
        EventManager.postSceneMovementNtfEvent(roleID, mapOwner, req);
    }

    /**
     *	离开挖矿场景
     *
     * @param roleID
     */
    public void leaveScene(long roleID) {
        if (!mineRoomRole.containsKey(roleID)) {
            log.error("leaveScene mineRoomRole not containsKey roleID:{} ",roleID);
            return;
        }
        String mapOwner = mineRoomRole.get(roleID);
        if(StringUtil.isEmpty(mapOwner)){
            log.error("leaveScene mapOwner isEmpty! roleID:{} ",roleID);
            return;
        }
        if (!mineRoomMap.containsKey(mapOwner)) {
            log.error("leaveScene mineRoomMap not containsKey mapOwner! roleID:{} mapOwner:{}",roleID, mapOwner);
            return;
        }
        mineRoomRole.remove(roleID);
        MineRoom mineRoom = mineRoomMap.get(mapOwner);
        if (mineRoom == null) {
            log.error("leaveScene mineRoom == null roleID:{} mapOwner:{}",roleID, mapOwner);
            return;
        }
        mineRoom.getMineRoleMap().remove(roleID);
        if(mineRoom.getMineRoleMap().size() == 0){
            mineRoomMap.remove(mapOwner);
        }
        // 离开场景通知
        LeaveSceneNtf.Builder builder = LeaveSceneNtf.newBuilder();
        builder.setRoleId(roleID);
        long mapOwnerRoleID = getMapOwnerRoleID(mapOwner);
        builder.setSceneId(mapOwnerRoleID);
        LeaveSceneNtf ntf = builder.build();
        for (MineRole mineRole : mineRoom.getMineRoleMap().values()) {
            PlayerRole playerRole = playerService.getPlayer(mineRole.getRoleID());
            ChannelManager.getInstance().sendGameMultiToGate(playerRole.getGateServerID(), playerRole.getRoleID(), ntf);
        }
    }

    /**
     *	检查场景
     *
     * @param roleID
     * @param req
     * @param builder
     */
    public void checkScene(long roleID, CheckSceneReq req, CheckSceneRsp.Builder builder) {
        if (!mineRoomRole.containsKey(roleID)) {
            log.error("checkScene mineRoomRole not containsKey roleID:{} ",roleID);
            throw new CommonException(ErrorID.NOT_IN_MINE_ROOM);
        }
        String mapOwner = mineRoomRole.get(roleID);
        if(StringUtil.isEmpty(mapOwner)){
            log.error("checkScene mapOwner isEmpty! roleID:{} ",roleID);
            throw new CommonException(ErrorID.NOT_IN_MINE_ROOM);
        }
        MineRoom mineRoom = mineRoomMap.get(mapOwner);
        if (mineRoom == null) {
            log.error("checkScene mineRoom == null roleID:{} mapOwner:{}",roleID, mapOwner);
            throw new CommonException(ErrorID.NOT_IN_MINE_ROOM);
        }
        // 房间详情
        SceneDetailInfo.Builder detailInfo = SceneDetailInfo.newBuilder();
        SceneBriefInfo.Builder briefInfo = SceneBriefInfo.newBuilder();
        long mapOwnerRoleID = getMapOwnerRoleID(mapOwner);
        briefInfo.setId(mapOwnerRoleID);
        briefInfo.setName("test");
        briefInfo.setLevel(1);
        briefInfo.setThemeId(1);
        briefInfo.setCurPlayerNum(1);
        briefInfo.setMaxPlayerNum(10);
        briefInfo.setIsNeedPassword(false);
        detailInfo.setBriefInfo(briefInfo);
        List<SceneRoleInfo> attenders = Lists.newArrayListWithExpectedSize(mineRoom.getMineRoleMap().size());
        for (MineRole tmpMineRole : mineRoom.getMineRoleMap().values()) {
            PlayerRole playerRole = playerService.getPlayer(tmpMineRole.getRoleID());
            attenders.add(getSceneRoleInfo(playerRole, tmpMineRole));
        }
        detailInfo.addAllAttenders(attenders);
        builder.setSceneDetailInfo(detailInfo);
        // 地图格子
        List<SceneCellUnit> list;
        if (checkIsXXMine(mapOwner)) {
            list = gameMineService.getMineCellXXList(mapOwnerRoleID);
        } else {
            list = gameMineService.getMineCellList(mapOwnerRoleID);
        }
        List<SceneCell> cells = Lists.newArrayListWithExpectedSize(list.size());
        SceneCell.Builder cellBuilder = SceneCell.newBuilder();
        for (SceneCellUnit gameMineCell : list) {
            cells.add(gameMineCell.toSceneCell(cellBuilder));
        }
        builder.addAllCells(cells);
    }

    /**
     *	获取矿地图的主人
     *
     * @param mapOwner
     * @return
     */
    public static long getMapOwnerRoleID(String mapOwner) {
        String[] arr = mapOwner.split("-");
        long roleID = Long.parseLong(arr[0]);
        if (roleID == GlobalRoleID.getXiaoXun()) {
            return Long.parseLong(arr[1]);
        }
        return roleID;
    }

    /**
     *	检查是否是小寻的矿
     *
     * @param mapOwner
     * @return
     */
    public static boolean checkIsXXMine(String mapOwner) {
        String[] arr = mapOwner.split("-");
        long roleID = Long.parseLong(arr[0]);
        return roleID == GlobalRoleID.getXiaoXun();
    }

    /**
     *	挖矿聊天推送
     *
     * @param req
     */
    public void chatSendNtf(ChatSendReq req) {
        long roleID = req.getRoleID();
        if (!mineRoomRole.containsKey(roleID)) {
            log.error("chatSendNtf mineRoomRole not containsKey roleID:{} ",roleID);
            return;
        }
        String mapOwner = mineRoomRole.get(roleID);
        if(StringUtil.isEmpty(mapOwner)){
            log.error("chatSendNtf mapOwner isEmpty! roleID:{} ",roleID);
            return;
        }
        MineRoom mineRoom = mineRoomMap.get(mapOwner);
        if (mineRoom == null) {
            log.error("chatSendNtf mineRoom == null roleID:{} mapOwner:{}",roleID, mapOwner);
            return;
        }
        // 消息发送者
        PlayerRole roleInfo = playerService.getPlayer(req.getRoleID());
        // 消息推送
        ChatSendNtf.Builder builder = ChatSendNtf.newBuilder();
        builder.setRoleInfo(roleInfo.toBaseRoleInfo());
        builder.setSendTime(DateTime.newBuilder().setValue(System.currentTimeMillis()));
        builder.setChannel(EChatChannel.Mine);
        builder.setContent(SensitivewordFilter.replaceSensitiveWord(req.getContent()));
        ChatSendNtf ntf = builder.build();
        if(checkIsXXMine(mapOwner)) {
            ChannelManager.getInstance().sendChatSendNtfToGate(roleInfo.getGateServerID(), roleInfo.getRoleID(), ntf);
            // 小寻统一回复
            mineRoom.setXxChatCount(mineRoom.getXxChatCount()+1);
            if(mineRoom.getXxChatCount() >= 2) {
                PlayerRole playerRole = playerService.getPlayer(GlobalRoleID.getXiaoXun());
                builder.setRoleInfo(playerRole.toBaseRoleInfo());
                builder.setContent("我是机器人老友，更多聊天您需要与在线好友交流。");
                ChannelManager.getInstance().sendChatSendNtfToGate(roleInfo.getGateServerID(), roleInfo.getRoleID(), builder.build());
            }
        }else {
            // 遍历房间内玩家
            mineRoom.getMineRoleMap().forEach((key, value)->{
                PlayerRole playerRole = playerService.getPlayer(value.getRoleID());
                ChannelManager.getInstance().sendChatSendNtfToGate(playerRole.getGateServerID(), playerRole.getRoleID(), ntf);
            });
        }
    }

}
