package com.dj.serverplayer.action;

import java.util.List;

import com.dj.protobuf.Module;
import com.dj.protobuf.ProtobufCmd;
import com.dj.protobuf.ErrorIDOuterClass.ErrorID;
import com.dj.protobuf.book.*;
import com.dj.protobuf.buffer.MonthCardDrawReq;
import com.dj.protobuf.buffer.MonthCardDrawRsp;
import com.dj.protobuf.buffer.MonthCardNtf;
import com.dj.protobuf.buffer.MonthCardReq;
import com.dj.protobuf.character.ChangeClientDataReq;
import com.dj.protobuf.character.ChangeClientDataRsp;
import com.dj.protobuf.character.ChangeNameReq;
import com.dj.protobuf.character.ChangeNameRsp;
import com.dj.protobuf.character.ChangeSignatureReq;
import com.dj.protobuf.character.ChangeSignatureRsp;
import com.dj.protobuf.character.CheckWordReq;
import com.dj.protobuf.character.CheckWordRsp;
import com.dj.protobuf.character.LeaveHistoryReq;
import com.dj.protobuf.character.LeaveHistoryRsp;
import com.dj.protobuf.character.UsePowerBarAddStaminaReq;
import com.dj.protobuf.character.UsePowerBarAddStaminaRsp;
import com.dj.protobuf.forward.ForwardPlayerBasicReq;
import com.dj.protobuf.forward.ForwardPlayerBasicRsp;
import com.dj.protobuf.gm.GmCommandReq;
import com.dj.protobuf.gm.GmCommandRsp;
import com.dj.protobuf.gm.GmShutdownCmdReq;
import com.dj.protobuf.gm.GmShutdownCmdRsp;
import com.dj.protobuf.guide.GetGuideRewardReq;
import com.dj.protobuf.guide.GetGuideRewardRsp;
import com.dj.protobuf.guide.GuideInfoReq;
import com.dj.protobuf.guide.GuideInfoRsp;
import com.dj.protobuf.guide.UpdateGuideProcessReq;
import com.dj.protobuf.guide.UpdateGuideProcessRsp;
import com.dj.protobuf.item.GridItem;
import com.dj.protobuf.item.ItemInteractHistoryReq;
import com.dj.protobuf.item.ItemInteractHistoryRsp;
import com.dj.protobuf.item.ItemListReq;
import com.dj.protobuf.item.ItemListRsp;
import com.dj.protobuf.item.ItemRemoveReq;
import com.dj.protobuf.item.ItemRemoveRsp;
import com.dj.protobuf.login.HeartbeatInfo;
import com.dj.protobuf.login.HeartbeatInfoRsp;
import com.dj.protobuf.task.*;
import com.dj.servercore.action.base.BaseAction;
import com.dj.servercore.action.base.IActionCmd;
import com.dj.servercore.action.base.IActionModule;
import com.dj.servercore.action.base.IFieldHandler;
import com.dj.servercore.task.msg.MyMsg;
import com.dj.serverplayer.handler.*;
import com.dj.domain.util.StringUtil;
import com.dj.domain.util.Utility;
import com.google.protobuf.GeneratedMessageV3;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;

/**
 * @author zcq
 * @ClassName: PlayerBasicAction
 * @Description: ????????????
 * @date 2019???6???25???
 */
@Data
@Slf4j
@EqualsAndHashCode(callSuper = false)
@IActionModule(module = Module.PLAYER_BASIC)
public class PlayerBasicAction extends BaseAction {

    @IFieldHandler
    private InitHandler initHandler;
    @IFieldHandler
    private ItemHandler itemHandler;
    @IFieldHandler
    private GuideHandler guideHandler;
    @IFieldHandler
    private TaskHandler taskHandler;
    @IFieldHandler
    private BookHandler bookHandler;

    @IActionCmd(cmd = ProtobufCmd.SERVER_FORWARD_PLAYER_BASIC_REQ)
    public Long forwardPlayerBasicReq(MyMsg msg) {
        ForwardPlayerBasicReq forward = msg.getContent(ForwardPlayerBasicReq.class);
        long roleID = forward.getRoleID();
        try {
            GeneratedMessageV3 rspContent = doReqHandler(forward.getRoleID(), forward.getReqClz(), forward.getReq());
            if (rspContent != null) {
                ForwardPlayerBasicRsp.Builder builder = msg.getResultBuilder(ForwardPlayerBasicRsp.class);
                builder.setRoleID(forward.getRoleID());
                builder.setRsp(rspContent.toByteString());
                builder.setRspClz(rspContent.getClass().getName());
                log.debug("roleID ???{}???, rsp:{}, content:{}", forward.getRoleID(), rspContent.getClass().getSimpleName(), StringUtil.msg2Json(rspContent));
            }
        } catch (Exception e) {
            log.error(Utility.getTraceString(e));
        }
        return roleID;
    }

    // ??????
    public GeneratedMessageV3 heartbeatInfo(long roleID, HeartbeatInfo req) {
    	HeartbeatInfoRsp.Builder builder = HeartbeatInfoRsp.newBuilder();
    	return builder.build();
    }
    
    // ??????
    public GeneratedMessageV3 changeNameReq(long roleID, ChangeNameReq req) {
        ChangeNameRsp.Builder builder = ChangeNameRsp.newBuilder();
        builder.setReq(req);
        ErrorID result = handleService(() -> {
            initHandler.changeName(roleID, req.getName());
        });
        builder.setErrorID(result);
        return builder.build();
    }

    // ??????????????????
    public GeneratedMessageV3 changeSignatureReq(long roleID, ChangeSignatureReq req) {
        ChangeSignatureRsp.Builder builder = ChangeSignatureRsp.newBuilder();
        builder.setReq(req);
        ErrorID result = handleService(() -> {
            initHandler.changeSignature(roleID, req.getSignature());
        });
        builder.setErrorID(result);
        return builder.build();
    }

    // ???????????????
    public GeneratedMessageV3 checkWordReq(long roleID, CheckWordReq req) {
    	CheckWordRsp.Builder builder = CheckWordRsp.newBuilder();
    	ErrorID result = handleService(() -> {
    		initHandler.checkWord(req.getWord(), builder);
    	});
    	builder.setErrorID(result);
    	return builder.build();
    }
    
    // ????????????????????????
    public GeneratedMessageV3 leaveHistoryReq(long roleID, LeaveHistoryReq req) {
    	LeaveHistoryRsp.Builder builder = LeaveHistoryRsp.newBuilder();
    	builder.setReq(req);
    	ErrorID result = handleService(() -> {
    		initHandler.leaveHistory(roleID, req.getType(), builder);
    	});
    	builder.setErrorID(result);
    	return builder.build();
    }

    // ?????????????????????
    public GeneratedMessageV3 changeClientDataReq(long roleID, ChangeClientDataReq req) {
        ChangeClientDataRsp.Builder builder = ChangeClientDataRsp.newBuilder();
        builder.setReq(req);
        ErrorID result = handleService(() -> {
            initHandler.changeClientData(roleID, req);
        });
        builder.setErrorID(result);
        return builder.build();
    }
    
    // ????????????????????????
    public GeneratedMessageV3 usePowerBarAddStaminaReq(long roleID, UsePowerBarAddStaminaReq req) {
    	UsePowerBarAddStaminaRsp.Builder builder = UsePowerBarAddStaminaRsp.newBuilder();
        ErrorID result = handleService(() -> {
            initHandler.usePowerBarAddStamina(roleID, req);
        });
        builder.setErrorID(result);
        return builder.build();
    }

    // ??????
    public GeneratedMessageV3 monthCardReq(long roleID, MonthCardReq req) {
        MonthCardNtf.Builder builder = MonthCardNtf.newBuilder();
        handleService(() -> {
            initHandler.monthCard(roleID, builder);
        });
        return builder.build();
    }

    // ??????????????????
    public GeneratedMessageV3 monthCardDrawReq(long roleID, MonthCardDrawReq req) {
        MonthCardDrawRsp.Builder builder = MonthCardDrawRsp.newBuilder();
        ErrorID result = handleService(() -> {
        	builder.setReq(req);
            initHandler.monthCardDraw(roleID, req);
        });
        builder.setErrorID(result);
        return builder.build();
    }

    // ????????????
    public GeneratedMessageV3 itemListReq(long roleID, ItemListReq req) {
        ItemListRsp.Builder builder = ItemListRsp.newBuilder();
        builder.setReq(req);
        ErrorID result = handleService(() -> {
            List<GridItem> updateData = itemHandler.getItemList(roleID, req.getCol());
            builder.addAllUpdateData(updateData);
        });
        builder.setErrorID(result);
        return builder.build();
    }

    // ????????????
    public GeneratedMessageV3 itemRemoveReq(long roleID, ItemRemoveReq req) {
        ItemRemoveRsp.Builder builder = ItemRemoveRsp.newBuilder();
        builder.setReq(req);
        ErrorID result = handleService(() -> {
            itemHandler.itemRemove(roleID, req);
        });
        builder.setErrorID(result);
        return builder.build();
    }
    
    // ????????????????????????
    public GeneratedMessageV3 guideInfoReq(long roleID, GuideInfoReq req) {
        GuideInfoRsp.Builder builder = GuideInfoRsp.newBuilder();
        ErrorID result = handleService(() -> {
            guideHandler.guideInfo(roleID, builder);
        });
        builder.setErrorID(result);
        return builder.build();
    }

    // ????????????????????????
    public GeneratedMessageV3 updateGuideProcessReq(long roleID, UpdateGuideProcessReq req) {
        UpdateGuideProcessRsp.Builder builder = UpdateGuideProcessRsp.newBuilder();
        builder.setReq(req);
        ErrorID result = handleService(() -> {
            guideHandler.updateGuideProcess(roleID, req);
        });
        builder.setErrorID(result);
        return builder.build();
    }

    // ????????????????????????
    public GeneratedMessageV3 getGuideRewardReq(long roleID, GetGuideRewardReq req) {
        GetGuideRewardRsp.Builder builder = GetGuideRewardRsp.newBuilder();
        builder.setReq(req);
        ErrorID result = handleService(() -> {
            guideHandler.getGuideReward(roleID, req.getGroupId());
        });
        builder.setErrorID(result);
        return builder.build();
    }

    // ????????????
    public GeneratedMessageV3 taskListReq(long roleID, TaskListReq req) {
        TaskListRsp.Builder builder = TaskListRsp.newBuilder();
        ErrorID result = handleService(() -> {
        	builder.addAllTasks(taskHandler.taskList(roleID, 0));
        });
        builder.setErrorID(result);
        return builder.build();
    }

    // ??????????????????
    public GeneratedMessageV3 taskStateListReq(long roleID, TaskStateListReq req) {
        TaskStateListRsp.Builder builder = TaskStateListRsp.newBuilder();
        ErrorID result = handleService(() -> {
            builder.addAllTaskState(taskHandler.taskStateList(roleID, ETaskType.GrowUp_VALUE));
        });
        builder.setErrorID(result);
        return builder.build();
    }
    // ????????????
    public GeneratedMessageV3 taskAcceptReq(long roleID, TaskAcceptReq req) {
        TaskAcceptRsp.Builder builder = TaskAcceptRsp.newBuilder();
        builder.setReq(req);
        ErrorID result = handleService(() -> {
           taskHandler.taskAccept(roleID, req, builder);
        });
        builder.setErrorID(result);
        return builder.build();
    }

    // ??????????????????
    public GeneratedMessageV3 taskRewardReq(long roleID, TaskRewardReq req) {
        TaskRewardRsp.Builder builder = TaskRewardRsp.newBuilder();
        builder.setReq(req);
        ErrorID result = handleService(() -> {
            taskHandler.taskReward(roleID, req, builder);
        });
        builder.setErrorID(result);
        return builder.build();
    }

    // ????????????
    public GeneratedMessageV3 taskRemoveReq(long roleID, TaskRemoveReq req) {
        TaskRemoveRsp.Builder builder = TaskRemoveRsp.newBuilder();
        builder.setReq(req);
        ErrorID result = handleService(() -> {
            taskHandler.taskRemove(roleID, req, builder);
        });
        builder.setErrorID(result);
        return builder.build();
    }
    
    // ??????????????????
    public GeneratedMessageV3 taskFirstReq(long roleID, TaskFirstReq req) {
        TaskFirstRsp.Builder builder = TaskFirstRsp.newBuilder();
        builder.setReq(req);
        ErrorID result = handleService(() -> {
            taskHandler.taskFirst(roleID, req);
        });
        builder.setErrorID(result);
        return builder.build();
    }

    // ????????????
    public GeneratedMessageV3 taskRefreshReq(long roleID, TaskRefreshReq req) {
        TaskRefreshRsp.Builder builder = TaskRefreshRsp.newBuilder();
        builder.setReq(req);
        ErrorID result = handleService(() -> {
            taskHandler.taskRefresh(roleID, req, builder);
        });
        builder.setErrorID(result);
        return builder.build();
    }
    
    // ????????????
    public GeneratedMessageV3 taskPointReq(long roleID, TaskPointReq req) {
    	TaskPointRsp.Builder builder = TaskPointRsp.newBuilder();
    	builder.setReq(req);
    	ErrorID result = handleService(() -> {
    		taskHandler.taskPoint(roleID, req);
    	});
    	builder.setErrorID(result);
    	return builder.build();
    }

    // ????????????????????????
    public GeneratedMessageV3 bookAllTypeReq(long roleID, BookAllTypeReq req) {
    	BookAllTypeRsp.Builder builder = BookAllTypeRsp.newBuilder();
    	ErrorID result = handleService(() -> {
    		bookHandler.bookAllType(roleID, builder);
    	});
    	builder.setErrorID(result);
    	return builder.build();
    }
    
    // ?????????????????????????????????
    public GeneratedMessageV3 bookInfoReq(long roleID, BookInfoReq req) {
    	BookInfoRsp.Builder builder = BookInfoRsp.newBuilder();
    	builder.setReq(req);
    	ErrorID result = handleService(() -> {
    		bookHandler.bookInfo(roleID, req, builder);
    	});
    	builder.setErrorID(result);
    	return builder.build();
    }
    
    // ??????????????????????????????
    public GeneratedMessageV3 bookRewardReq(long roleID, BookRewardReq req) {
    	BookRewardRsp.Builder builder = BookRewardRsp.newBuilder();
    	builder.setReq(req);
    	ErrorID result = handleService(() -> {
    		bookHandler.bookReward(roleID, req, builder);
    	});
    	builder.setErrorID(result);
    	return builder.build();
    }

    // ????????????
    public GeneratedMessageV3 bookTurnPagesReq(long roleID, BookTurnPagesReq req) {
        BookTurnPagesRsp.Builder builder = BookTurnPagesRsp.newBuilder();
        builder.setReq(req);
        ErrorID result = handleService(() -> {
            bookHandler.bookTurnPages(roleID);
        });
        builder.setErrorID(result);
        return builder.build();
    }

    // gm??????
    public GeneratedMessageV3 gmCommandReq(long roleID, GmCommandReq req) {
        GmCommandRsp.Builder builder = GmCommandRsp.newBuilder();
        builder.setReq(req);
        ErrorID result = handleService(() -> {
            initHandler.gmCommandHandler(roleID, req.getCmd());
        });
        builder.setErrorID(result);
        return builder.build();
    }

    // ????????????
    public GeneratedMessageV3 gmShutdownCmdReq(long roleID, GmShutdownCmdReq req) {
        GmShutdownCmdRsp.Builder builder = GmShutdownCmdRsp.newBuilder();
        builder.setReq(req);
        ErrorID result = handleService(() -> {
            initHandler.gmShutdownCmdReq();
        });
        builder.setErrorID(result);
        return builder.build();
    }

    // ?????????????????????????????????
    public GeneratedMessageV3 itemInteractHistoryReq(long roleID, ItemInteractHistoryReq req) {
    	ItemInteractHistoryRsp.Builder builder = ItemInteractHistoryRsp.newBuilder();
    	builder.setReq(req);
    	ErrorID result = handleService(() -> {
    		initHandler.itemInteractHistory(roleID, builder);
    	});
    	builder.setErrorID(result);
    	return builder.build();
    }
}
