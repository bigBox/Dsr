package com.dj.serverapi.service.inf;

import java.util.List;
import java.util.Map;

import com.dj.domain.data.game.VerifyRoom;
import com.dj.domain.entity.robot.RobotVerify;
import com.dj.domain.entity.robot.item.RobotItem5;
import com.dj.domain.enums.ResourceBillEnum;
import com.dj.domain.data.Verify;
import com.dj.domain.entity.player.PlayerVerify;
import com.dj.domain.entity.player.item.PlayerItem5;
import com.dj.protobuf.verify.VerifyItemReq;
import com.dj.protobuf.verify.VerifyItemRsp;
import com.dj.domain.util.inf.IArgumentRunnable;

public interface IVerifyService {

    /**
     *	初始化新玩家的鉴定道具
     *
     * @param roleID
     * @param items5
     */
    void initNewRoleVerify(long roleID, List<PlayerItem5> items5);
    /**
     *	添加鉴定道具
     *
     * @param roleID
     * @param item5
     * @param changeCount
     * @param bill
     */
    void addVerify(long roleID, PlayerItem5 item5, long changeCount, ResourceBillEnum bill);
    /**
     *	删除鉴定道具
     *
     * @param roleID
     * @param item5
     * @param changeCount
     */
    void delVerify(long roleID, PlayerItem5 item5, long changeCount);
    /**
     *	获取鉴定列表
     *
     * @param roleID
     * @return
     */
    List<Verify> getVerifyList(long roleID);
    /**
	 *	设置鉴定队列
     * @param roleID
     * @param list
     */
    void setVerifyQueue(long roleID, List<PlayerVerify> list);
	/**
	 *	获取鉴定队列
	 * @param roleID
	 * @return
	 */
	List<PlayerVerify> getVerifyQueue(long roleID);
    /**
     *	帮好友鉴定
     */
    void verifyItem(long roleID, VerifyItemReq req, VerifyItemRsp.Builder builder, IArgumentRunnable<Integer> renownRun);

    /**
     *	更新待揭晓
     */
    void updateVerify(long roleID, IArgumentRunnable<PlayerVerify> run);

    /**
     *	小寻
     */
    void addRobotVerify(long roleID, RobotItem5 robotItem, long count, ResourceBillEnum bill);

    void delRobotVerify(long roleID, RobotItem5 robotItem, long changeCount);

    List<Verify> getRobotVerifyList(long roleID);

    void setRobotVerifyQueue(long roleId, List<RobotVerify> queues);

    List<RobotVerify> getRobotVerifyQueue(long verifyRoleID);

    void verifyRobotItem(long roleID, VerifyItemReq req, VerifyItemRsp.Builder builder, IArgumentRunnable<Integer> renownRun);

    Map<Long, VerifyRoom> getPlayerVerifyRoomMap();

    void setPlayerVerifyRoomMap(Map<Long, VerifyRoom> playerVerifyRoomMap);

    Map<Long, Long> getPlayerVerifyRoomRole();

    void setPlayerVerifyRoomRole(Map<Long, Long> playerVerifyRoomRole);

    Map<Long, VerifyRoom> getRobotVerifyRoomMap();

    void setRobotVerifyRoomMap(Map<Long, VerifyRoom> robotVerifyRoomMap);

    Map<Long, Long> getRobotVerifyRoomRole();

    void setRobotVerifyRoomRole(Map<Long, Long> robotVerifyRoomRole);

    void addPlayerVerifyRoomRole(long roleID, long verifyRoleID);

    void addRobotVerifyRoomRole(long roleID, long verifyRoleID);

    VerifyRoom getPlayerVerifyRoom(long verifyRoleID);

    VerifyRoom getRobotVerifyRoom(long verifyRoleID);

    void addPlayerVerifyRoom(long verifyRoleID, VerifyRoom verifyRoom);

    void addRobotVerifyRoom(long verifyRoleID, VerifyRoom verifyRoom);

    void removePlayerVerifyRoomRole(long roleID);

    void removeRobotVerifyRoomRole(long roleID);
}

