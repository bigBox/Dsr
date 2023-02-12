package com.dj.serverglobal.action;

import com.dj.protobuf.Module;
import com.dj.protobuf.ErrorIDOuterClass.ErrorID;
import com.dj.protobuf.ProtobufCmd;
import com.dj.protobuf.forward.ForwardGlobalGuildBattleReq;
import com.dj.protobuf.forward.ForwardGlobalGuildBattleRsp;
import com.dj.protobuf.guildBattle.BattleBuildListReq;
import com.dj.protobuf.guildBattle.BattleBuildListRsp;
import com.dj.protobuf.guildBattle.BattleChangeMeetXReq;
import com.dj.protobuf.guildBattle.BattleChangeMeetXRsp;
import com.dj.protobuf.guildBattle.BattleMeetDropReq;
import com.dj.protobuf.guildBattle.BattleMeetDropRsp;
import com.dj.protobuf.guildBattle.CaptureBattleBuildReq;
import com.dj.protobuf.guildBattle.CaptureBattleBuildRsp;
import com.dj.protobuf.guildBattle.ExitBattleBuildListReq;
import com.dj.protobuf.guildBattle.ExitBattleBuildListRsp;
import com.dj.protobuf.guildBattle.ExitBattleMeetEggReq;
import com.dj.protobuf.guildBattle.ExitBattleMeetEggRsp;
import com.dj.protobuf.guildBattle.HoldBattleBuildReq;
import com.dj.protobuf.guildBattle.HoldBattleBuildRsp;
import com.dj.protobuf.guildBattle.StartBattleMeetEggNtf;
import com.dj.protobuf.guildBattle.StartBattleMeetEggReq;
import com.dj.servercore.action.base.BaseAction;
import com.dj.servercore.action.base.IActionCmd;
import com.dj.servercore.action.base.IActionModule;
import com.dj.servercore.action.base.IFieldHandler;
import com.dj.servercore.task.msg.MyMsg;
import com.dj.serverglobal.handler.GlobalGuildBattleHandler;
import com.dj.serverglobal.worker.GuildBattleGameWorker;
import com.dj.domain.util.StringUtil;
import com.dj.domain.util.Utility;
import com.google.protobuf.GeneratedMessageV3;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;

/**
 * @author zcq
 * @ClassName: GlobalGuildBattleAction
 * @Description: 商会战斗
 * @date 2020年7月31日
 */
@Slf4j
@Data
@EqualsAndHashCode(callSuper = false)
@IActionModule(module = Module.GLOBAL_GUILD_BATTLE)
public class GlobalGuildBattleAction extends BaseAction {

    @IFieldHandler
    private GlobalGuildBattleHandler globalGuildBattleHandler;

    @IActionCmd(cmd = ProtobufCmd.SERVER_FORWARD_GLOBALGUILDBATTLE_REQ)
    public Long forwardGlobalGuildBattleReq(MyMsg msg) {
        ForwardGlobalGuildBattleReq forward = msg.getContent(ForwardGlobalGuildBattleReq.class);
        try {
            GeneratedMessageV3 rspContent = doReqHandler(forward.getRoleID(), forward.getReqClz(), forward.getReq());
            if (rspContent != null) {
                ForwardGlobalGuildBattleRsp.Builder builder = msg.getResultBuilder(ForwardGlobalGuildBattleRsp.class);
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
    
    // 商会战斗建筑列表
    public GeneratedMessageV3 battleBuildListReq(long roleID, BattleBuildListReq req) {
    	BattleBuildListRsp.Builder builder = BattleBuildListRsp.newBuilder();
        ErrorID result = handleService(() -> {
        	globalGuildBattleHandler.battleBuildList(roleID, req, builder);
        });
        builder.setErrorID(result);
        return builder.build();
    }
    
    // 占领战斗建筑
    public GeneratedMessageV3 holdBattleBuildReq(long roleID, HoldBattleBuildReq req) {
    	HoldBattleBuildRsp.Builder builder = HoldBattleBuildRsp.newBuilder();
    	ErrorID result = handleService(() -> {
    		globalGuildBattleHandler.holdBattleBuild(roleID, req);
    	});
    	builder.setErrorID(result);
    	return builder.build();
    }

    // 攻占战斗建筑
    public GeneratedMessageV3 captureBattleBuildReq(long roleID, CaptureBattleBuildReq req) {
    	CaptureBattleBuildRsp.Builder builder = CaptureBattleBuildRsp.newBuilder();
    	ErrorID result = handleService(() -> {
    		globalGuildBattleHandler.captureBattleBuild(roleID, req);
    	});
    	builder.setErrorID(result);
    	return builder.build();
    }
    
    // 玩家开始接鸡蛋
    public GeneratedMessageV3 startBattleMeetEggReq(long roleID, StartBattleMeetEggReq req) {
    	StartBattleMeetEggNtf.Builder builder = StartBattleMeetEggNtf.newBuilder();
    	ErrorID result = handleService(() -> {
    		globalGuildBattleHandler.startBattleMeetEgg(roleID, req, builder);
    	});
    	builder.setErrorID(result);
    	return builder.build();
    }

    // 变化平底锅的位置
    public GeneratedMessageV3 battleChangeMeetXReq(long roleID, BattleChangeMeetXReq req) {
    	BattleChangeMeetXRsp.Builder builder = BattleChangeMeetXRsp.newBuilder();
    	ErrorID result = handleService(() -> {
    		globalGuildBattleHandler.battleChangeMeetX(roleID, req);
    	});
    	builder.setErrorID(result);
    	return builder.build();
    }

    // 接到了掉落物
    public GeneratedMessageV3 battleMeetDropReq(long roleID, BattleMeetDropReq req) {
    	BattleMeetDropRsp.Builder builder = BattleMeetDropRsp.newBuilder();
    	ErrorID result = handleService(() -> {
    		globalGuildBattleHandler.battleMeetDrop(roleID, req, builder);
    	});
    	builder.setErrorID(result);
    	return builder.build();
    }
    
    // 退出接鸡蛋
    public GeneratedMessageV3 exitBattleMeetEggReq(long roleID, ExitBattleMeetEggReq req) {
    	ExitBattleMeetEggRsp.Builder builder = ExitBattleMeetEggRsp.newBuilder();
    	ErrorID result = handleService(() -> {
    		GuildBattleGameWorker.getWorker().exitBattleMeetEgg(roleID, builder);
    	});
    	builder.setErrorID(result);
    	return builder.build();
    }

    // 退出商会战斗建筑列表
    public GeneratedMessageV3 exitBattleBuildListReq(long roleID, ExitBattleBuildListReq req) {
    	ExitBattleBuildListRsp.Builder builder = ExitBattleBuildListRsp.newBuilder();
    	ErrorID result = handleService(() -> {
    		GuildBattleGameWorker.getWorker().exitBattleBuildList(roleID);
    	});
    	builder.setErrorID(result);
    	return builder.build();
    }
}
