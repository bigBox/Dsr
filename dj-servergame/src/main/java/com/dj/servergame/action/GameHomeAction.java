package com.dj.servergame.action;

import com.dj.protobuf.Module;
import com.dj.protobuf.ErrorIDOuterClass.ErrorID;
import com.dj.protobuf.ProtobufCmd;
import com.dj.protobuf.forward.ForwardGameHomeReq;
import com.dj.protobuf.forward.ForwardGameHomeRsp;
import com.dj.protobuf.forward.GameLogoutReq;
import com.dj.protobuf.item.*;
import com.dj.protobuf.obstacle.ObstaclesListReq;
import com.dj.protobuf.obstacle.ObstaclesListRsp;
import com.dj.protobuf.scene.ScenePosReq;
import com.dj.protobuf.scene.ScenePosRsp;
import com.dj.protobuf.showtable.*;
import com.dj.protobuf.verify.VerifyItemReq;
import com.dj.protobuf.verify.VerifyItemRsp;
import com.dj.protobuf.verify.VerifyLeaveReq;
import com.dj.protobuf.verify.VerifyLeaveRsp;
import com.dj.protobuf.verify.VerifyingQueueReq;
import com.dj.protobuf.verify.VerifyingQueueRsp;
import com.dj.servercore.action.base.BaseAction;
import com.dj.servercore.action.base.IActionCmd;
import com.dj.servercore.action.base.IActionModule;
import com.dj.servercore.action.base.IFieldHandler;
import com.dj.servercore.task.msg.MyMsg;
import com.dj.servergame.handler.GameHomeHandler;
import com.dj.servergame.handler.GameMineHandler;
import com.dj.servergame.handler.GameVerifyHandler;
import com.dj.domain.util.StringUtil;
import com.dj.domain.util.Utility;
import com.google.protobuf.GeneratedMessageV3;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;

/**
 * @author zcq
 * @ClassName: GameHomeAction
 * @Description: 可以互访的玩家主页玩法
 * @date 2019年6月25日
 */
@Data
@Slf4j
@EqualsAndHashCode(callSuper = false)
@IActionModule(module = Module.GAME_HOME)
public class GameHomeAction extends BaseAction {

    @IFieldHandler
    private GameHomeHandler gameHomeHandler;
    @IFieldHandler
    private GameVerifyHandler gameVerifyHandler;
    @IFieldHandler
    private GameMineHandler gameMineHandler;

    @IActionCmd(cmd = ProtobufCmd.SERVER_FORWARD_GAMEHOME_REQ)
    public Long forwardGameHomeReq(MyMsg msg) {
        ForwardGameHomeReq forward = msg.getContent(ForwardGameHomeReq.class);
        try {
            GeneratedMessageV3 rspContent = doReqHandler(forward.getRoleID(), forward.getReqClz(), forward.getReq(), forward.getPs());
            if (rspContent != null) {
                ForwardGameHomeRsp.Builder builder = msg.getResultBuilder(ForwardGameHomeRsp.class);
                builder.setRoleID(forward.getRoleID());
                builder.setRsp(rspContent.toByteString());
                builder.setRspClz(rspContent.getClass().getName());
                log.debug("roleID 【{}】, rsp:{}, content:{}", forward.getRoleID(), rspContent.getClass().getSimpleName(), StringUtil.msg2Json(rspContent));
            }
        } catch (Exception e) {
            log.error(Utility.getTraceString(e));
        }
        return forward.getRoleID();
    }

    // 建筑位置
    public GeneratedMessageV3 scenePosReq(long roleID, ScenePosReq req, String ps) {
        ScenePosRsp.Builder builder = ScenePosRsp.newBuilder();
        builder.setReq(req);
        ErrorID result = handleService(() -> {
            gameHomeHandler.getScenePos(roleID, req, builder);
            gameMineHandler.leaveScene(roleID);
        });
        builder.setErrorID(result);
        return builder.build();
    }

    // 好友-获取待鉴定队列
    public GeneratedMessageV3 verifyingQueueReq(long roleID, VerifyingQueueReq req, String ps) {
        VerifyingQueueRsp.Builder builder = VerifyingQueueRsp.newBuilder();
        builder.setRoleId(req.getRoleId());
        ErrorID result = handleService(() -> {
            gameVerifyHandler.verifyingQueue(roleID, req, builder);
        });
        builder.setErrorID(result);
        return builder.build();
    }

    // 帮朋友鉴定物品
    public GeneratedMessageV3 verifyItemReq(long roleID, VerifyItemReq req, String ps) {
        VerifyItemRsp.Builder builder = VerifyItemRsp.newBuilder();
        builder.setReq(req);
        ErrorID result = handleService(() -> {
            gameVerifyHandler.verifyItem(roleID, req, builder);
        });
        builder.setErrorID(result);
        return builder.build();
    }

    // 离开好友鉴定室
    public GeneratedMessageV3 verifyLeaveReq(long roleID, VerifyLeaveReq req, String ps) {
        VerifyLeaveRsp.Builder builder = VerifyLeaveRsp.newBuilder();
        builder.setRoleId(req.getRoleId());
        ErrorID result = handleService(() -> {
            gameVerifyHandler.leaveVerify(roleID, req.getRoleId());
        });
        builder.setErrorID(result);
        return builder.build();
    }

    // 荒地信息查询
    public GeneratedMessageV3 obstaclesListReq(long roleID, ObstaclesListReq req, String ps) {
        ObstaclesListRsp.Builder builder = ObstaclesListRsp.newBuilder();
        builder.setReq(req);
        ErrorID result = handleService(() -> {
            gameHomeHandler.getObstaclesList(roleID, req, builder);
        });
        builder.setErrorID(result);
        return builder.build();
    }

    // 获取展厅
    public GeneratedMessageV3 showTableReq(long roleID, ShowTableReq req, String ps) {
        ShowTableRsp.Builder builder = ShowTableRsp.newBuilder();
        builder.setReq(req);
        ErrorID result = handleService(() -> {
            gameHomeHandler.getShowTable(req.getRoleId(), req.getType(), req.getPage(), builder);
        });
        builder.setErrorID(result);
        return builder.build();
    }

    // 获取展厅
    public GeneratedMessageV3 getShowTableInfoReq(long roleID, GetShowTableInfoReq req, String ps) {
        GetShowTableInfoRsp.Builder builder = GetShowTableInfoRsp.newBuilder();
        ErrorID result = handleService(() -> {
            gameHomeHandler.getShowTableInfo(req.getRoleId(), req.getType(), req.getPage(), builder);
        });
        builder.setErrorID(ErrorID.OK);
        return builder.build();
    }

    public GeneratedMessageV3 saveShowTableInfoReq(long roleID, SaveShowTableInfoReq req, String ps) {
        SaveShowTableInfoRsp.Builder builder = SaveShowTableInfoRsp.newBuilder();
        builder.setRoleId(roleID);
        builder.setPage(req.getPage());
        ErrorID result = handleService(() -> {
            gameHomeHandler.saveShowTableInfo(req.getRoleId(), req.getType(), req.getPage(), req.getInfo());
        });
        builder.setErrorID(result);
        return builder.build();
    }
    // 展厅点赞
    public GeneratedMessageV3 showTableSupportReq(long roleID, ShowTableSupportReq req, String ps) {
    	ShowTableSupportRsp.Builder builder = ShowTableSupportRsp.newBuilder();
    	ErrorID result = handleService(() -> {
    		gameHomeHandler.showTableSupport(roleID, req);
    	});
    	builder.setErrorID(result);
    	return builder.build();
    }

    // 获取好友家道具数量
    public GeneratedMessageV3 itemFriendReq(long roleID, ItemFriendReq req, String ps) {
    	ItemFriendRsp.Builder builder = ItemFriendRsp.newBuilder();
    	builder.setReq(req);
    	ErrorID result = handleService(() -> {
    		gameHomeHandler.itemFriend(roleID, req, builder);
    	});
    	builder.setErrorID(result);
    	return builder.build();
    }

    // 获取玩家宝藏地图数量
    public GeneratedMessageV3 playerMapItemReq(long roleID, PlayerMapItemReq req, String ps) {
        PlayerMapItemRsp.Builder builder = PlayerMapItemRsp.newBuilder();
        builder.setReq(req);
        ErrorID result = handleService(() -> {
            gameHomeHandler.playerMapItem(roleID, req, builder);
        });
        builder.setErrorID(result);
        return builder.build();
    }

    // 和好友互动物品
    public GeneratedMessageV3 itemInteractReq(long roleID, ItemInteractReq req, String ps) {
    	ItemInteractRsp.Builder builder = ItemInteractRsp.newBuilder();
    	builder.setReq(req);
    	ErrorID result = handleService(() -> {
    		gameHomeHandler.itemInteract(roleID, req);
    	});
    	builder.setErrorID(result);
    	return builder.build();
    }
    
    // 游戏退出
    public GeneratedMessageV3 gameLogoutReq(long roleID, GameLogoutReq req, String ps) {
        log.info("roleID {} ", req.getRoleID());
        // 离开挖矿
        gameMineHandler.leaveScene(req.getRoleID());
        // 离开鉴定
        gameVerifyHandler.leaveVerify(roleID, req.getRoleID());
        return null;
    }
}
