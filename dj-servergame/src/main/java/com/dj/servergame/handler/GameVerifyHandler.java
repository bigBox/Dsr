package com.dj.servergame.handler;

import com.dj.domain.GlobalRoleID;
import com.dj.domain.data.game.VerifyRoom;
import com.dj.domain.entity.player.PlayerRole;
import com.dj.domain.entity.player.PlayerVerify;
import com.dj.domain.entity.robot.RobotVerify;
import com.dj.domain.enums.PlayerAttrEnum;
import com.dj.domain.enums.ResourceBillEnum;
import com.dj.domain.enums.SyncCommonEnum;
import com.dj.protobuf.CommonException;
import com.dj.protobuf.ErrorIDOuterClass.ErrorID;
import com.dj.protobuf.chat.ChatSendNtf;
import com.dj.protobuf.chat.ChatSendReq;
import com.dj.protobuf.chat.EChatChannel;
import com.dj.protobuf.datetime.DateTime;
import com.dj.protobuf.verify.VerifyItemReq;
import com.dj.protobuf.verify.VerifyItemRsp;
import com.dj.protobuf.verify.VerifyingQueueReq;
import com.dj.protobuf.verify.VerifyingQueueRsp;
import com.dj.serverapi.ServiceProvider;
import com.dj.serverapi.helper.MessageHelper;
import com.dj.servergame.manager.ChannelManager;
import com.dj.servergame.manager.EventManager;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 *	多人鉴定
 */
@Component
public class GameVerifyHandler extends ServiceProvider {

    /**
     *	进入好友鉴定室， 获取待鉴定列表
     *
     * @param roleID
     * @param req
     * @param builder
     */
    public void verifyingQueue(long roleID, VerifyingQueueReq req, VerifyingQueueRsp.Builder builder) {
        long verifyRoleID = req.getRoleId();
        if(verifyRoleID != GlobalRoleID.getXiaoXun()){
            List<PlayerVerify> queues = verifyService.getVerifyQueue(verifyRoleID);
            MessageHelper.toVerifyQueues(queues, queue -> builder.addQueues(queue));
            VerifyRoom verifyRoom = verifyService.getPlayerVerifyRoom(verifyRoleID);
            if (verifyRoom == null) {
                verifyRoom = new VerifyRoom(verifyRoleID);
                verifyService.addPlayerVerifyRoom(verifyRoleID, verifyRoom);
            }
            verifyRoom.getVisitorList().add(roleID);
            // 鉴定室列表
            verifyService.addPlayerVerifyRoomRole(roleID, verifyRoleID);
        }else {
            List<RobotVerify> queues = verifyService.getRobotVerifyQueue(roleID);
            MessageHelper.toRobotVerifyQueues(queues, queue -> builder.addQueues(queue));
            VerifyRoom verifyRoom = verifyService.getRobotVerifyRoom(roleID);
            if (verifyRoom == null) {
                verifyRoom = new VerifyRoom(roleID);
                verifyService.addRobotVerifyRoom(roleID, verifyRoom);
            }
            verifyRoom.getVisitorList().add(roleID);
            // 鉴定室列表
            verifyService.addRobotVerifyRoomRole(roleID, verifyRoleID);
        }

    }

    /**
     *	帮朋友鉴定
     *
     * @param roleID
     * @return
     */
    public void verifyItem(long roleID, VerifyItemReq req, VerifyItemRsp.Builder builder) {
        long verifyRoleID = req.getRoleId();
        if (verifyRoleID != GlobalRoleID.getXiaoXun()) {
            if (roleID == verifyRoleID) {
                PlayerRole playerRole = playerService.getPlayer(roleID);
                if(playerRole.getLevel() > 10) {
                    throw new CommonException(ErrorID.VERIFIY_AUTO_LEVEL_LIMIT);
                }
            	// 10 级以下，小寻每天可以帮自己鉴定3个
                if(otherService.getVerifyCount(roleID) >= 3) {
                    throw new CommonException(ErrorID.VERIFIY_AUTO_TODAY_LIMIT);
                }
                verifyService.verifyItem(roleID, req, builder, renown -> {
                    commonService.addAttrBill(roleID, PlayerAttrEnum.RENOWN.getKey(), renown, ResourceBillEnum.verifyItem);
                });
                otherService.addVerifyCount(roleID);
            }else {
                // 给好友鉴定
                verifyService.verifyItem(roleID, req, builder, renown -> {
                    commonService.addAttrBill(roleID, PlayerAttrEnum.RENOWN.getKey(), renown, ResourceBillEnum.verifyItem);
                });
            }
            EventManager.postSyncCommonEvent(req.getRoleId(), SyncCommonEnum.VERIFY);
            EventManager.commitRoleEvent(req.getRoleId());
        } else {// 帮小寻鉴定
            verifyService.verifyRobotItem(roleID, req, builder, renown -> {
                commonService.addAttrBill(roleID, PlayerAttrEnum.RENOWN.getKey(), renown, ResourceBillEnum.verifyItem);
            });
        }
        EventManager.postSyncAttrEvent(roleID);
    }

    /**
     *	离开好友鉴定室
     *
     * @param roleID
     * @param verifyRoleID
     */
    public void leaveVerify(long roleID, long verifyRoleID) {
        if (verifyRoleID != GlobalRoleID.getXiaoXun()) {
            VerifyRoom verifyRoom = verifyService.getPlayerVerifyRoom(verifyRoleID);
            if (verifyRoom != null) {
                verifyRoom.getVisitorList().remove(roleID);
            }
            verifyService.removePlayerVerifyRoomRole(roleID);
        }else {
            VerifyRoom verifyRoom = verifyService.getRobotVerifyRoom(roleID);
            if (verifyRoom != null) {
                verifyRoom.getVisitorList().remove(roleID);
            }
            verifyService.removeRobotVerifyRoomRole(roleID);
        }
    }

    /**
     *	鉴定聊天推送
     *
     * @param req
     */
    public void chatSendNtf(ChatSendReq req) {
        if (verifyService.getPlayerVerifyRoomRole().containsKey(req.getRoleID())) {
            long verifyRoleID = verifyService.getPlayerVerifyRoomRole().get(req.getRoleID());
            VerifyRoom verifyRoom = verifyService.getPlayerVerifyRoom(verifyRoleID);
            if (verifyRoom != null) {
                // 消息发送者
                PlayerRole roleInfo = playerService.getPlayer(req.getRoleID());
                // 消息推送
                ChatSendNtf.Builder builder = ChatSendNtf.newBuilder();
                builder.setRoleInfo(roleInfo.toBaseRoleInfo());
                builder.setSendTime(DateTime.newBuilder().setValue(System.currentTimeMillis()));
                builder.setChannel(EChatChannel.Verify);
                builder.setContent(req.getContent());
                ChatSendNtf ntf = builder.build();
                // 鉴定室主人
                PlayerRole playerRole = playerService.getPlayer(verifyRoom.getRoomRoleID());
                ChannelManager.getInstance().sendChatSendNtfToGate(playerRole.getGateServerID(), playerRole.getRoleID(), ntf);
                // 遍历房间内玩家
                verifyRoom.getVisitorList().forEach(roleID->{
                    PlayerRole visitorRole = playerService.getPlayer(roleID);
                    ChannelManager.getInstance().sendChatSendNtfToGate(visitorRole.getGateServerID(), visitorRole.getRoleID(), ntf);
                });
            }
        }
    }
}
