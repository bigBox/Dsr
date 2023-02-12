package com.dj.serverplayer.handler;

import com.dj.domain.GlobalRoleID;
import com.dj.domain.TableID;
import com.dj.domain.data.FriendAction;
import com.dj.domain.data.FriendApply;
import com.dj.domain.entity.player.PlayerFriend;
import com.dj.domain.entity.player.PlayerRole;
import com.dj.domain.entity.robot.RobotRole;
import com.dj.domain.enums.SyncCommonEnum;
import com.dj.domain.enums.TaskActionEnum;
import com.dj.domain.type.AccessType;
import com.dj.domain.util.StringUtil;
import com.dj.domain.util.lib.QueryParamMap;
import com.dj.protobuf.CommonException;
import com.dj.protobuf.ErrorIDOuterClass.ErrorID;
import com.dj.protobuf.common.BaseRoleInfo;
import com.dj.protobuf.datetime.DateTime;
import com.dj.protobuf.friend.*;
import com.dj.serverplayer.handler.base.BaseHandler;
import com.dj.serverplayer.manager.ChannelManager;
import com.dj.serverplayer.manager.EventManager;
import com.dj.serverplayer.manager.ServiceManager;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @author zcq
 * @description 好友业务处理
 * @date 2019年4月2日
 */
@Component
public class FriendHandler extends BaseHandler {
    /**
     *	初始化好友
     *
     * @param roleID
     */
    public void initFriend(long roleID) {
        // 本人
        PlayerFriend friend = new PlayerFriend(roleID);
        friend.setId(readModuleID(TableID.TABLE_FRIEND));
        friend.setFriendID(roleID);
        friend.setFriendType(FriendType.FT_Normal_VALUE);
        playerFriendDao.cacheInsert(friend, roleID);
        // 小寻
        PlayerFriend xxfriend = new PlayerFriend(roleID);
        xxfriend.setId(readModuleID(TableID.TABLE_FRIEND));
        xxfriend.setFriendID(GlobalRoleID.getXiaoXun());
        xxfriend.setFriendType(FriendType.FT_Normal_VALUE);
        playerFriendDao.cacheInsert(xxfriend, roleID);
    }

    /**
     *	获取好友列表
     *
     * @param roleID
     * @return
     */
    public void getFriends(long roleID, FriendListRsp.Builder builder) {
        List<PlayerFriend> lists = playerFriendDao.cacheLoadAll(roleID);
        if (lists!= null && lists.size() > 0) {
            FriendInfo.Builder friendInfo = FriendInfo.newBuilder();
            BaseRoleInfo.Builder roleInfo = BaseRoleInfo.newBuilder();
            // 好友红点数据
            FriendRedDot.Builder redDot = FriendRedDot.newBuilder();
            lists.forEach(value->{
                if(value.getFriendID() != GlobalRoleID.getXiaoXun()) {
                    // 好友基础数据
                    PlayerRole playerRole = playerService.getPlayer(value.getFriendID());
                    if (playerRole == null) {
                        QueryParamMap queryParams = new QueryParamMap();
                        queryParams.put("roleID", value.getFriendID());
                        playerRole = playerRoleDao.cacheSelect(queryParams, value.getFriendID());
                    }
                    if (playerRole != null) {
                        builder.addFriends(value.toFriendInfo(friendInfo, playerRole.toBaseRoleInfo(roleInfo), redDot.build()));
                        // 待鉴定数量
                        redDot.setVerifyingCount(ServiceManager.getRedDotService().getVerifyingCount(value.getFriendID()));
                        // 生态园待喂动物数量
                        redDot.setFeedCount(ServiceManager.getRedDotService().getFeedCount(value.getFriendID()));
                    }
                }else{
                    QueryParamMap queryParams = new QueryParamMap();
                    queryParams.put("roleID", roleID);
                    RobotRole robotRole = robotRoleDao.cacheSelect(queryParams, roleID);
                    if (robotRole != null) {
                        robotRole.setRoleID(GlobalRoleID.getXiaoXun());
                        builder.addFriends(value.toFriendInfo(friendInfo, robotRole.toBaseRoleInfo(roleInfo), redDot.build()));
                        // 待鉴定数量
                        redDot.setVerifyingCount(ServiceManager.getRedDotService().getRobotVerifyingCount(roleID));
                        // 生态园待喂动物数量
                        redDot.setFeedCount(ServiceManager.getRedDotService().getRobotFeedCount(roleID));
                    }
                }
            });
        }
    }

    /**
     *	好友申请
     *
     * @param targetRoleIDs
     * @param srcRoleID
     * @param applyType
     */
    public void friendApply(List<Long> targetRoleIDs, long srcRoleID, EFriendApplyType applyType) {
        // 先判定对方是否申请添加本人好友
        if(targetRoleIDs != null && targetRoleIDs.size() > 0) {
            for(Long targetRoleID : targetRoleIDs) {
                Map<Long, FriendApply> applyMap = friendService.getApply(srcRoleID);
                if (applyMap.containsKey(targetRoleID)) {
                    friendApprove(targetRoleID, srcRoleID, true);
                }
                if(targetRoleID != GlobalRoleID.getXiaoXun()){
                    FriendApply apply = friendService.friendApply(targetRoleID, srcRoleID, applyType);
                    friendApplySync(targetRoleID, srcRoleID, apply.getApplyTime(), applyType.getNumber());
                    //EventManager.postTaskActionEvent(srcRoleID, TaskActionEnum.ADD_FRIEND, 1);
                }
                else {
                    initFriend(srcRoleID);
                    FriendApproveNtf.Builder builder = FriendApproveNtf.newBuilder();
                    FriendInfo.Builder friendInfo = FriendInfo.newBuilder();
                    PlayerRole srcRole = playerService.getPlayer(srcRoleID);
                    friendInfo.setRoleInfo(srcRole.toBaseRoleInfo());
                    friendInfo.setSendGiftTime(DateTime.newBuilder().setValue(0));
                    friendInfo.setReceiveGift(0);
                    friendInfo.setFriendType(FriendType.FT_Normal);
                    friendInfo.setApplyDate(DateTime.newBuilder().setValue(System.currentTimeMillis()));
                    friendInfo.setApplyType(applyType);
                    builder.setRoleInfo(friendInfo.build());
                    ChannelManager.getInstance().sendPlayerFriendToGate(srcRole.getGateServerID(), targetRoleID, builder.build());
                    EventManager.postTaskActionEvent(srcRoleID, TaskActionEnum.ADD_FRIEND, 1);
                    EventManager.commitRoleEvent(srcRoleID);
                }
            }
        }
    }

    /**
     *	好友申请同步
     *
     * @param targetRoleID
     * @param srcRoleID
     * @param applyTime
     * @param applyType
     */
    private void friendApplySync(long targetRoleID, long srcRoleID, long applyTime, int applyType) {
        FriendApplyNtf.Builder builder = FriendApplyNtf.newBuilder();
        FriendInfo.Builder friendInfo = FriendInfo.newBuilder();
        PlayerRole role = playerService.getPlayer(srcRoleID);
        friendInfo.setRoleInfo(role.toBaseRoleInfo());
        friendInfo.setSendGiftTime(DateTime.newBuilder().setValue(0));
        friendInfo.setReceiveGift(0);
        friendInfo.setFriendType(FriendType.FT_Normal);
        friendInfo.setApplyDate(DateTime.newBuilder().setValue(applyTime));
        friendInfo.setApplyType(EFriendApplyType.forNumber(applyType));
        builder.addApplies(friendInfo.build());
        role = playerService.getPlayer(targetRoleID);
        ChannelManager.getInstance().sendPlayerFriendToGate(role.getGateServerID(), targetRoleID, builder.build());
    }

    /**
     *	获取好友申请列表
     *
     * @param roleID
     * @return
     */
    public void getApplies(long roleID, FriendListRsp.Builder builder) {
        Map<Long, FriendApply> applyMap = friendService.getApply(roleID);
        if (applyMap != null && applyMap.size() > 0) {
            for (Map.Entry<Long, FriendApply> entry : applyMap.entrySet()) {
                FriendInfo.Builder friendInfo = FriendInfo.newBuilder();
                PlayerRole friendRole = playerService.getPlayer(entry.getKey());
                friendInfo.setRoleInfo(friendRole.toBaseRoleInfo());
                friendInfo.setSendGiftTime(DateTime.newBuilder().setValue(0));
                friendInfo.setReceiveGift(0);
                friendInfo.setFriendType(FriendType.FT_Normal);
                friendInfo.setApplyDate(DateTime.newBuilder().setValue(entry.getValue().getApplyTime()));
                friendInfo.setApplyType(EFriendApplyType.forNumber(entry.getValue().getApplyType()));
                builder.addApplies(friendInfo.build());
            }
        }
    }

    /**
     *	好友批准
     *
     * @param targetRoleIDs
     * @param srcRoleID
     * @param agree
     */
    public void friendApproveList(List<Long> targetRoleIDs, long srcRoleID, boolean agree) {
        if(targetRoleIDs != null && targetRoleIDs.size() > 0) {
            for(Long targetRoleID : targetRoleIDs) {
                friendApprove(targetRoleID, srcRoleID, agree);
            }
        }
    }

    public void friendApprove(Long targetRoleID, long srcRoleID, boolean agree) {
        friendService.friendApprove(targetRoleID, srcRoleID, apply -> {
            if (agree) {
                QueryParamMap queryParams = new QueryParamMap();
                queryParams.put("roleID", srcRoleID);
                queryParams.put("friendID", targetRoleID);
                PlayerFriend friend = playerFriendDao.cacheSelect(queryParams, srcRoleID);
                if (friend == null) {
                    friend = new PlayerFriend(srcRoleID);
                    friend.setFriendID(targetRoleID);
                    friend.setFriendType(apply.getApplyType());
                    playerFriendDao.cacheInsert(friend, srcRoleID);
                    EventManager.postTaskActionEvent(srcRoleID, TaskActionEnum.ADD_FRIEND, 1);
                    EventManager.commitRoleEvent(srcRoleID);
                    friend = playerFriendDao.cacheSelect(queryParams, srcRoleID);
                }
                // 同步好友行为
                FriendAction action = new FriendAction();
                action.setId(friend.getId());
                action.setRoleID(srcRoleID);
                action.setApplyType(apply.getApplyType());
                action.setApplyTime(apply.getApplyTime());
                action.setAction(1);//添加
                friendService.addAction(targetRoleID, action);
                EventManager.postSyncCommonEvent(srcRoleID, SyncCommonEnum.FRIEND_ACTION, targetRoleID);
            }
        });
    }
    /**
     *	好友批准同步
     *
     * @param targetRoleID
     * @param srcRoleID
     * @param applyType
     * @param applyTime
     */
    public void friendApproveSync(long targetRoleID, long srcRoleID, int applyType, long applyTime) {
        QueryParamMap queryParams = new QueryParamMap();
        queryParams.put("roleID",targetRoleID);
        queryParams.put("friendID", srcRoleID);
        PlayerFriend friend = playerFriendDao.cacheSelect(queryParams, targetRoleID);
        if (friend == null) {
            friend = new PlayerFriend(targetRoleID);
            friend.setFriendID(srcRoleID);
            friend.setFriendType(applyType);
            playerFriendDao.cacheInsert(friend, targetRoleID);
            EventManager.postTaskActionEvent(targetRoleID, TaskActionEnum.ADD_FRIEND, 1);
            EventManager.commitRoleEvent(targetRoleID);
        }
        FriendApproveNtf.Builder builder = FriendApproveNtf.newBuilder();
        FriendInfo.Builder friendInfo = FriendInfo.newBuilder();
        PlayerRole role = playerService.getPlayer(srcRoleID);
        friendInfo.setRoleInfo(role.toBaseRoleInfo());
        friendInfo.setSendGiftTime(DateTime.newBuilder().setValue(0));
        friendInfo.setReceiveGift(0);
        friendInfo.setFriendType(FriendType.FT_Normal);
        friendInfo.setApplyDate(DateTime.newBuilder().setValue(applyTime));
        friendInfo.setApplyType(EFriendApplyType.forNumber(applyType));
        builder.setRoleInfo(friendInfo.build());
        role = playerService.getPlayer(targetRoleID);
        ChannelManager.getInstance().sendPlayerFriendToGate(role.getGateServerID(), targetRoleID, builder.build());
    }

    /**
     *	好友移除
     *
     * @param targetRoleID
     * @param srcRoleID
     */
    public void removeFriend(long targetRoleID, long srcRoleID) {
    	if(targetRoleID == GlobalRoleID.getXiaoXun()) {
    		throw new CommonException(ErrorID.COMMON_PARAM_ERROR);
    	}
        QueryParamMap queryParams = new QueryParamMap();
        queryParams.put("roleID", srcRoleID);
        queryParams.put("friendID", targetRoleID);
        PlayerFriend playerFriend = playerFriendDao.cacheSelect(queryParams, srcRoleID);
        if(playerFriend != null) {
            playerFriendDao.cacheDelete(playerFriend.getId(), srcRoleID);
            // 同步好友行为
            FriendAction action = new FriendAction();
            action.setId(playerFriend.getId());
            action.setRoleID(srcRoleID);
            action.setAction(0);//删除
            friendService.addAction(targetRoleID, action);
        }
        EventManager.postSyncCommonEvent(srcRoleID, SyncCommonEnum.FRIEND_ACTION, targetRoleID);
    }

    /**
     * 好友查找
     * @param req
     * @param builder
     */
	public void friendSearch(long roleID, FriendSearchReq req, FriendSearchRsp.Builder builder) {
		QueryParamMap<String, Object> queryParams = new QueryParamMap<>(1);
		List<PlayerRole> lists = null;
        if(StringUtil.isNotEmpty(req.getName())) {
            if(StringUtil.isNumberStr(req.getName())){
                queryParams.put("roleID", req.getName());
                lists = playerRoleDao.selectList(queryParams, roleID, AccessType.DIRECT_DB);
                if(CollectionUtils.isEmpty(lists)){
                    queryParams.put("roleName", req.getName());
                    lists = playerRoleDao.selectList(queryParams, roleID, AccessType.DIRECT_DB);
                }
            }else {
                queryParams.put("roleName", req.getName());
                lists = playerRoleDao.selectList(queryParams, roleID, AccessType.DIRECT_DB);
            }
        }
        else if (req.getId() > 0) {
            queryParams.put("roleID", req.getId());
            lists = playerRoleDao.selectList(queryParams, roleID, AccessType.DIRECT_DB);
        }
        if(lists != null && lists.size() > 0) {
            lists.removeIf(role -> role.getId() == roleID);
        	BaseRoleInfo.Builder baseRoleInfo = BaseRoleInfo.newBuilder();
        	lists.forEach(value -> {
        		builder.addRoleInfos(value.toBaseRoleInfo(baseRoleInfo));
        	});
        }
	}

    /**
     * 好友推荐
     * @param req
     * @param builder
     */
    public void friendRecommend(long roleID, FriendRecommendReq req, FriendRecommendRsp.Builder builder) {
        PlayerRole playerRole = playerService.getPlayer(roleID);
        List<Long> firendIdList = new ArrayList<>();
        List<PlayerFriend> firendLists = playerFriendDao.cacheLoadAll(roleID);
        if (firendLists!= null && firendLists.size() > 0) {
            firendLists.forEach(value -> {
                firendIdList.add(value.getFriendID());
            });
        }
        else {
            QueryParamMap queryParams = new QueryParamMap();
            queryParams.put("roleID", roleID);
            RobotRole robotRole = robotRoleDao.cacheSelect(queryParams, roleID);
            if (robotRole != null) {
                BaseRoleInfo.Builder baseRoleInfo = BaseRoleInfo.newBuilder();
                robotRole.setRoleID(GlobalRoleID.getXiaoXun());
                builder.addRoleInfos(robotRole.toBaseRoleInfo(baseRoleInfo));
            }
        }
        List<PlayerRole> lists = playerRoleDao.getAll(roleID, AccessType.DIRECT_DB);
        if(lists != null && lists.size() > 0) {
            lists.removeIf(role -> role.getId() == roleID);
            lists.forEach(value -> {
                value.setDiffLevel(Math.abs(playerRole.getLevel()-value.getLevel()));
            });
            Collections.sort(lists);
        }
        if(lists != null && lists.size() > 0) {
            int count = 0;
            for(PlayerRole playerRole1 : lists){
                if(count < 10){
                    if(!firendIdList.contains(playerRole1.getRoleID())) {
                        BaseRoleInfo.Builder baseRoleInfo = BaseRoleInfo.newBuilder();
                        builder.addRoleInfos(playerRole1.toBaseRoleInfo(baseRoleInfo));
                        count++;
                    }
                }else {
                    break;
                }
            }
        }
    }
}
