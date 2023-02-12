package com.dj.serverglobal.action;

import java.util.List;

import com.dj.protobuf.Module;
import com.dj.protobuf.CommonException;
import com.dj.protobuf.ErrorIDOuterClass.ErrorID;
import com.dj.protobuf.ProtobufCmd;
import com.dj.protobuf.forward.ForwardGlobalGuildReq;
import com.dj.protobuf.forward.ForwardGlobalGuildRsp;
import com.dj.protobuf.guild.EGuildQuitReson;
import com.dj.protobuf.guild.GuildAdjustPostReq;
import com.dj.protobuf.guild.GuildAdjustPostRsp;
import com.dj.protobuf.guild.GuildApplyInfo;
import com.dj.protobuf.guild.GuildApplyListReq;
import com.dj.protobuf.guild.GuildApplyListRsp;
import com.dj.protobuf.guild.GuildApplyReq;
import com.dj.protobuf.guild.GuildApplyRsp;
import com.dj.protobuf.guild.GuildApproveReq;
import com.dj.protobuf.guild.GuildApproveRsp;
import com.dj.protobuf.guild.GuildBaseInfo;
import com.dj.protobuf.guild.GuildKickReq;
import com.dj.protobuf.guild.GuildKickRsp;
import com.dj.protobuf.guild.GuildListReq;
import com.dj.protobuf.guild.GuildListRsp;
import com.dj.protobuf.guild.GuildMemberInfo;
import com.dj.protobuf.guild.GuildMemberListReq;
import com.dj.protobuf.guild.GuildMemberListRsp;
import com.dj.protobuf.guild.GuildModifySummaryReq;
import com.dj.protobuf.guild.GuildModifySummaryRsp;
import com.dj.protobuf.guild.GuildSearchReq;
import com.dj.protobuf.guild.GuildSearchRsp;
import com.dj.protobuf.guild.QuitGuildReq;
import com.dj.protobuf.guild.QuitGuildRsp;
import com.dj.protobuf.guildTask.*;
import com.dj.protobuf.task.TaskInfo;
import com.dj.servercore.action.base.BaseAction;
import com.dj.servercore.action.base.IActionCmd;
import com.dj.servercore.action.base.IActionModule;
import com.dj.servercore.action.base.IFieldHandler;
import com.dj.servercore.task.msg.MyMsg;
import com.dj.serverglobal.handler.GlobalGuildHandler;
import com.dj.domain.util.StringUtil;
import com.dj.domain.util.Utility;
import com.google.protobuf.GeneratedMessageV3;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;

/**
 * @author zcq
 * @ClassName: GlobalGuildAction
 * @Description: 商会
 * @date 2019年6月25日
 */
@Slf4j
@Data
@EqualsAndHashCode(callSuper = false)
@IActionModule(module = Module.GLOBAL_GUILD)
public class GlobalGuildAction extends BaseAction {

    @IFieldHandler
    private GlobalGuildHandler globalGuildHandler;

    @IActionCmd(cmd = ProtobufCmd.SERVER_FORWARD_GLOBALGUILD_REQ)
    public Long forwardGlobalGuildReq(MyMsg msg) {
        ForwardGlobalGuildReq forward = msg.getContent(ForwardGlobalGuildReq.class);
        try {
            GeneratedMessageV3 rspContent = doReqHandler(forward.getRoleID(), forward.getReqClz(), forward.getReq(), forward.getPs());
            if (rspContent != null) {
                ForwardGlobalGuildRsp.Builder builder = msg.getResultBuilder(ForwardGlobalGuildRsp.class);
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

    // 查询公会信息
    public GeneratedMessageV3 guildListReq(long roleID, GuildListReq req, String ps) {
        GuildListRsp.Builder builder = GuildListRsp.newBuilder();
        ErrorID result = handleService(() -> {
        	globalGuildHandler.guildList(roleID, req, builder);
        });
        builder.setErrorID(result);
        return builder.build();
    }

    // 修改公告
    public GeneratedMessageV3 guildModifySummaryReq(long roleID, GuildModifySummaryReq req, String ps) {
        GuildModifySummaryRsp.Builder builder = GuildModifySummaryRsp.newBuilder();
        ErrorID result = handleService(() -> {
            globalGuildHandler.guildModifySummary(roleID, req, builder);
        });
        builder.setErrorID(result);
        return builder.build();
    }

    // 申请加入
    public GeneratedMessageV3 guildApplyReq(long roleID, GuildApplyReq req, String ps) {
        GuildApplyRsp.Builder builder = GuildApplyRsp.newBuilder();
        ErrorID result = handleService(() -> {
        	int tokenCount = Integer.parseInt(ps);
        	if(tokenCount < req.getTokenCount()) {
        		throw new CommonException(ErrorID.COMMON_PLAYER_ITEM_LESS);
        	}
            GuildApplyInfo applyInfo = globalGuildHandler.guildApply(roleID, req);
            builder.setApplyInfo(applyInfo);
        });
        builder.setErrorID(result);
        return builder.build();
    }

    // 批准加入
    public GeneratedMessageV3 guildApproveReq(long roleID, GuildApproveReq req, String ps) {
        GuildApproveRsp.Builder builder = GuildApproveRsp.newBuilder();
        builder.setReq(req);
        ErrorID result = handleService(() -> {
        	globalGuildHandler.guildApprove(roleID, req, builder);
        });
        builder.setErrorID(result);
        return builder.build();
    }

    // 申请列表
    public GeneratedMessageV3 guildApplyListReq(long roleID, GuildApplyListReq req, String ps) {
        GuildApplyListRsp.Builder builder = GuildApplyListRsp.newBuilder();
        ErrorID result = handleService(() -> {
            List<GuildApplyInfo> applies = globalGuildHandler.guildApplyList(roleID);
            if (applies != null) {
                builder.addAllApplies(applies);
            }
        });
        builder.setErrorID(result);
        return builder.build();
    }

    // 成员列表
    public GeneratedMessageV3 guildMemberListReq(long roleID, GuildMemberListReq req, String ps) {
        GuildMemberListRsp.Builder builder = GuildMemberListRsp.newBuilder();
        ErrorID result = handleService(() -> {
            List<GuildMemberInfo> members = globalGuildHandler.guildMemberList(roleID);
            builder.addAllMembers(members);
        });
        builder.setErrorID(result);
        return builder.build();
    }

    // 退出公会
    public GeneratedMessageV3 quitGuildReq(long roleID, QuitGuildReq req, String ps) {
        QuitGuildRsp.Builder builder = QuitGuildRsp.newBuilder();
        ErrorID result = handleService(() -> {
            GuildBaseInfo guildBaseInfo = globalGuildHandler.quitGuild(roleID, EGuildQuitReson.GuildQuitActive);
            builder.setGuildBaseInfo(guildBaseInfo);
        });
        builder.setErrorID(result);
        return builder.build();
    }

    // 踢出公会
    public GeneratedMessageV3 guildKickReq(long roleID, GuildKickReq req, String ps) {
        GuildKickRsp.Builder builder = GuildKickRsp.newBuilder();
        ErrorID result = handleService(() -> {
            builder.setReq(req);
            GuildBaseInfo guildBaseInfo = globalGuildHandler.guildKick(roleID, req.getRoleId());
            builder.setGuildBaseInfo(guildBaseInfo);
        });
        builder.setErrorID(result);
        return builder.build();
    }

    // 调整职务
    public GeneratedMessageV3 guildAdjustPostReq(long roleID, GuildAdjustPostReq req, String ps) {
        GuildAdjustPostRsp.Builder builder = GuildAdjustPostRsp.newBuilder();
        ErrorID result = handleService(() -> {
            GuildMemberInfo memberInfo = globalGuildHandler.guildAdjustPost(roleID, req.getRoleId(), req.getPost());
            builder.setMemberInfo(memberInfo);
        });
        builder.setErrorID(result);
        return builder.build();
    }

    // 公会搜索
    public GeneratedMessageV3 guildSearchReq(long roleID, GuildSearchReq req, String ps) {
        GuildSearchRsp.Builder builder = GuildSearchRsp.newBuilder();
        ErrorID result = handleService(() -> {
            globalGuildHandler.guildSearch(roleID, req, builder);
        });
        builder.setErrorID(result);
        return builder.build();
    }
    
    // 请求商会任务列表
    public GeneratedMessageV3 guildTaskListReq(long roleID, GuildTaskListReq req, String ps) {
    	GuildTaskListRsp.Builder builder = GuildTaskListRsp.newBuilder();
    	ErrorID result = handleService(() -> {
    		List<TaskInfo> tasks= globalGuildHandler.guildTaskList(roleID);
    		builder.addAllTasks(tasks);
    	});
    	builder.setErrorID(result);
    	return builder.build();
    }

    // 接受商会任务
    public GeneratedMessageV3 guildTaskAcceptReq(long roleID, GuildTaskAcceptReq req, String ps) {
    	GuildTaskAcceptRsp.Builder builder = GuildTaskAcceptRsp.newBuilder();
    	ErrorID result = handleService(() -> {
    		builder.setReq(req);
    		globalGuildHandler.guildTaskAccept(roleID, req.getTaskId(), req.getIndex(), builder);
    	});
    	builder.setErrorID(result);
    	return builder.build();
    }
    
    // 商会任务删除（撕单）
    public GeneratedMessageV3 guildTaskRemoveReq(long roleID, GuildTaskRemoveReq req, String ps) {
    	GuildTaskRemoveRsp.Builder builder = GuildTaskRemoveRsp.newBuilder();
    	ErrorID result = handleService(() -> {
    		builder.setReq(req);
    		globalGuildHandler.guildTaskRemove(roleID, req.getTaskId(),  req.getIndex(), builder);
    	});
    	builder.setErrorID(result);
    	return builder.build();
    }
    
    // 商会任务加速
    public GeneratedMessageV3 guildTaskSpeedUpReq(long roleID, GuildTaskSpeedUpReq req, String ps) {
    	GuildTaskSpeedUpRsp.Builder builder = GuildTaskSpeedUpRsp.newBuilder();
    	ErrorID result = handleService(() -> {
    		builder.setReq(req);
    		globalGuildHandler.guildTaskSpeedUp(roleID, req.getTaskId(),  req.getIndex(), builder);
    	});
    	builder.setErrorID(result);
    	return builder.build();
    }

    // 商会任务奖励
    public GeneratedMessageV3 guildTaskRewardReq(long roleID, GuildTaskRewardReq req, String ps) {
        GuildTaskRewardRsp.Builder builder = GuildTaskRewardRsp.newBuilder();
        ErrorID result = handleService(() -> {
            builder.setReq(req);
            globalGuildHandler.guildTaskReward(roleID, req.getTaskId(),  req.getIndex(), builder);
        });
        builder.setErrorID(result);
        return builder.build();
    }
}
