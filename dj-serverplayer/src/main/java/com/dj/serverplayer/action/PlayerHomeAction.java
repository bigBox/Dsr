package com.dj.serverplayer.action;

import java.util.List;
import java.util.Map;

import com.dj.protobuf.Module;
import com.dj.protobuf.ProtobufCmd;
import com.dj.protobuf.ErrorIDOuterClass.ErrorID;
import com.dj.protobuf.collection.CollectionExchangeRewardReq;
import com.dj.protobuf.collection.CollectionExchangeRewardRsp;
import com.dj.protobuf.collection.CollectionInfo;
import com.dj.protobuf.collection.CollectionListReq;
import com.dj.protobuf.collection.CollectionListRsp;
import com.dj.protobuf.forward.ForwardPlayerHomeReq;
import com.dj.protobuf.forward.ForwardPlayerHomeRsp;
import com.dj.protobuf.guild.ChangeGuildNameReq;
import com.dj.protobuf.guild.CreateGuildReq;
import com.dj.protobuf.guild.CreateGuildRsp;
import com.dj.protobuf.guildBattle.SignUpGuildBattleReq;
import com.dj.protobuf.guildBattle.SignUpGuildBattleRsp;
import com.dj.protobuf.mall.GoodDescription;
import com.dj.protobuf.mall.MallBuyReq;
import com.dj.protobuf.mall.MallBuyRsp;
import com.dj.protobuf.mall.MallListReq;
import com.dj.protobuf.mall.MallListRsp;
import com.dj.protobuf.manufacture.ManufactureActionReq;
import com.dj.protobuf.manufacture.ManufactureActionRsp;
import com.dj.protobuf.manufacture.ManufactureBatchPickupReq;
import com.dj.protobuf.manufacture.ManufactureBatchPickupRsp;
import com.dj.protobuf.manufacture.ManufactureInfoReq;
import com.dj.protobuf.manufacture.ManufactureInfoRsp;
import com.dj.protobuf.manufacture.ManufactureSpeedupReq;
import com.dj.protobuf.manufacture.ManufactureSpeedupRsp;
import com.dj.protobuf.obstacle.ObstaclesOpenupReq;
import com.dj.protobuf.obstacle.ObstaclesOpenupRsp;
import com.dj.protobuf.scene.ScenePosUpdateReq;
import com.dj.protobuf.scene.ScenePosUpdateRsp;
import com.dj.protobuf.showtable.*;
import com.dj.protobuf.summon.*;
import com.dj.protobuf.verify.VerifiedQueueReq;
import com.dj.protobuf.verify.VerifiedQueueRsp;
import com.dj.protobuf.verify.VerifyDequeueReq;
import com.dj.protobuf.verify.VerifyDequeueRsp;
import com.dj.protobuf.verify.VerifyEnqueueReq;
import com.dj.protobuf.verify.VerifyEnqueueRsp;
import com.dj.protobuf.verify.VerifySpeedupReq;
import com.dj.protobuf.verify.VerifySpeedupRsp;
import com.dj.protobuf.verify.VerifyUseCardReq;
import com.dj.protobuf.verify.VerifyUseCardRsp;
import com.dj.servercore.action.base.BaseAction;
import com.dj.servercore.action.base.IActionCmd;
import com.dj.servercore.action.base.IActionModule;
import com.dj.servercore.action.base.IFieldHandler;
import com.dj.servercore.task.msg.MyMsg;
import com.dj.serverplayer.handler.HomeHandler;
import com.dj.serverplayer.handler.ManufactureHandler;
import com.dj.serverplayer.handler.SummonHandler;
import com.dj.serverplayer.handler.TableHandler;
import com.dj.serverplayer.handler.TopicHandler;
import com.dj.serverplayer.handler.VerifyHandler;
import com.dj.serverplayer.manager.ServiceManager;
import com.dj.domain.util.StringUtil;
import com.dj.domain.util.Utility;
import com.google.protobuf.GeneratedMessageV3;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;

/**
 * @author zcq
 * @ClassName: PlayerHomeAction
 * @Description: 玩家主页
 * @date 2019年6月25日
 */
@Data
@Slf4j
@EqualsAndHashCode(callSuper = false)
@IActionModule(module = Module.PLAYER_HOME)
public class PlayerHomeAction extends BaseAction {

    @IFieldHandler
    private VerifyHandler verifyHandler;
    @IFieldHandler
    private HomeHandler homeHandler;
    @IFieldHandler
    private TableHandler tableHandler;
    @IFieldHandler
    private SummonHandler summonHandler;
    @IFieldHandler
    private ManufactureHandler manufactureHandler;
    @IFieldHandler
	private TopicHandler topicHandler;

    @IActionCmd(cmd = ProtobufCmd.SERVER_FORWARD_PLAYER_HOME_REQ)
    public Long forwardPlayerHomeReq(MyMsg msg) {
        ForwardPlayerHomeReq forward = msg.getContent(ForwardPlayerHomeReq.class);
        try {
            GeneratedMessageV3 rspContent = doReqHandler(forward.getRoleID(), forward.getReqClz(), forward.getReq());
            if (rspContent != null) {
                ForwardPlayerHomeRsp.Builder builder = msg.getResultBuilder(ForwardPlayerHomeRsp.class);
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

    // 建筑位置更新
    public GeneratedMessageV3 scenePosUpdateReq(long roleID, ScenePosUpdateReq req) {
        ScenePosUpdateRsp.Builder builder = ScenePosUpdateRsp.newBuilder();
        ErrorID result = handleService(() -> {
            homeHandler.scenePosUpdate(roleID, req);
        });
        builder.setErrorID(result);
        return builder.build();
    }

    // 本人-获取待揭晓队列
    public GeneratedMessageV3 verifiedQueueReq(long roleID, VerifiedQueueReq req) {
        VerifiedQueueRsp.Builder builder = VerifiedQueueRsp.newBuilder();
        ErrorID result = handleService(() -> {
            verifyHandler.verifiedQueue(roleID, builder);
        });
        builder.setErrorID(result);
        return builder.build();
    }

    // 放入鉴定队列
    public GeneratedMessageV3 verifyEnqueueReq(long roleID, VerifyEnqueueReq req) {
        VerifyEnqueueRsp.Builder builder = VerifyEnqueueRsp.newBuilder();
        builder.setReq(req);
        ErrorID result = handleService(() -> {
            verifyHandler.verifyEnqueue(roleID, req, builder);
        });
        builder.setErrorID(result);
        return builder.build();
    }

    // 把鉴定好的物品放回背包
    public GeneratedMessageV3 verifyDequeueReq(long roleID, VerifyDequeueReq req) {
        VerifyDequeueRsp.Builder builder = VerifyDequeueRsp.newBuilder();
        builder.setReq(req);
        ErrorID result = handleService(() -> {
            verifyHandler.verifyDequeue(roleID, req.getIndex(), builder);
        });
        builder.setErrorID(result);
        return builder.build();
    }
    
    // 使用鉴定卡鉴定
    public GeneratedMessageV3 verifyUseCardReq(long roleID, VerifyUseCardReq req) {
    	VerifyUseCardRsp.Builder builder = VerifyUseCardRsp.newBuilder();
    	builder.setReq(req);
    	ErrorID result = handleService(() -> {
    		verifyHandler.verifyUseCard(roleID, req, builder);
    	});
    	builder.setErrorID(result);
    	return builder.build();
    }

    // 鉴定加速
    public GeneratedMessageV3 verifySpeedupReq(long roleID, VerifySpeedupReq req) {
    	VerifySpeedupRsp.Builder builder = VerifySpeedupRsp.newBuilder();
    	builder.setReq(req);
    	ErrorID result = handleService(() -> {
    		verifyHandler.verifySpeedup(roleID, req, builder);
    	});
    	builder.setErrorID(result);
    	return builder.build();
    }

    // 制作系统信息
    public GeneratedMessageV3 manufactureInfoReq(long roleID, ManufactureInfoReq reqContent) {
        ManufactureInfoRsp.Builder builder = ManufactureInfoRsp.newBuilder();
        ErrorID result = handleService(() -> {
            manufactureHandler.manufactureInfo(roleID, builder);
        });
        builder.setErrorID(result);
        return builder.build();
    }

    // 制作操作
    public GeneratedMessageV3 manufactureActionReq(long roleID, ManufactureActionReq req) {
        ManufactureActionRsp.Builder builder = ManufactureActionRsp.newBuilder();
		builder.setReq(req);
		ErrorID result = handleService(() -> {
            manufactureHandler.manufactureAction(roleID, req, builder);
        });
        builder.setErrorID(result);
        return builder.build();
    }

    // 制作加速
    public GeneratedMessageV3 manufactureSpeedupReq(long roleID, ManufactureSpeedupReq req) {
        ManufactureSpeedupRsp.Builder builder = ManufactureSpeedupRsp.newBuilder();
		builder.setReq(req);
		ErrorID result = handleService(() -> {
            manufactureHandler.manufactureSpeedup(roleID, req, builder);
        });
        builder.setErrorID(result);
        return builder.build();
    }

    // 批量拾取制作物品
    public GeneratedMessageV3 manufactureBatchPickupReq(long roleID, ManufactureBatchPickupReq req) {
        ManufactureBatchPickupRsp.Builder builder = ManufactureBatchPickupRsp.newBuilder();
        ErrorID result = handleService(() -> {
            List<Integer> successIndex = manufactureHandler.manufactureBatchPickup(roleID, req);
            builder.addAllSuccessIndex(successIndex);
        });
        builder.setErrorID(result);
        return builder.build();
    }

    // 收集模块
    public GeneratedMessageV3 collectionListReq(long roleID, CollectionListReq req) {
        CollectionListRsp.Builder builder = CollectionListRsp.newBuilder();
        ErrorID result = handleService(() -> {
            Map<Integer, CollectionInfo> infos = homeHandler.collectionList(roleID, req);
            builder.putAllInfos(infos);
        });
        builder.setErrorID(result);
        return builder.build();
    }

    // 兑换收集奖励
    public GeneratedMessageV3 collectionExchangeRewardReq(long roleID, CollectionExchangeRewardReq req) {
    	CollectionExchangeRewardRsp.Builder builder = CollectionExchangeRewardRsp.newBuilder();
    	builder.setReq(req);
    	ErrorID result = handleService(() -> {
    		homeHandler.collectionExchangeReward(roleID, req.getId());
    	});
    	builder.setErrorID(result);
    	return builder.build();
    }

    // 开垦荒地
    public GeneratedMessageV3 obstaclesOpenupReq(long roleID, ObstaclesOpenupReq req) {
        ObstaclesOpenupRsp.Builder builder = ObstaclesOpenupRsp.newBuilder();
		builder.setReq(req);
		ErrorID result = handleService(() -> {
            homeHandler.obstaclesOpenup(roleID, req.getIndex());
        });
        builder.setErrorID(result);
        return builder.build();
    }

    // 商城查询
    public GeneratedMessageV3 mallListReq(long roleID, MallListReq req) {
        MallListRsp.Builder builder = MallListRsp.newBuilder();
		builder.setReq(req);
		ErrorID result = handleService(() -> {
            Map<Integer, GoodDescription> goodInfos = homeHandler.mallList(roleID, req);
            builder.putAllGoodInfos(goodInfos);
        });
        builder.setErrorID(result);
        return builder.build();
    }

    // 商城购买
    public GeneratedMessageV3 mallBuyReq(long roleID, MallBuyReq req) {
        MallBuyRsp.Builder builder = MallBuyRsp.newBuilder();
		builder.setReq(req);
		ErrorID result = handleService(() -> {
            homeHandler.mallBuy(roleID, req);
        });
        builder.setErrorID(result);
        return builder.build();
    }

    // 放入展厅
    public GeneratedMessageV3 showTablePutOnReq(long roleID, ShowTablePutOnReq req) {
        ShowTablePutOnRsp.Builder builder = ShowTablePutOnRsp.newBuilder();
		builder.setReq(req);
		ErrorID result = handleService(() -> {
            tableHandler.showTablePutOn(roleID, req, builder);
        });
        builder.setErrorID(result);
        return builder.build();
    }

    // 从展厅拿下来
    public GeneratedMessageV3 showTablePutDownReq(long roleID, ShowTablePutDownReq req) {
        ShowTablePutDownRsp.Builder builder = ShowTablePutDownRsp.newBuilder();
		builder.setReq(req);
		ErrorID result = handleService(() -> {
			int money = tableHandler.showTablePutDown(roleID, req);
			builder.setMoney(money);
        });
        builder.setErrorID(result);
        return builder.build();
    }

    // 从展厅全部下架
    public GeneratedMessageV3 showTableAllPutDownReq(long roleID, ShowTableAllPutDownReq req) {
        ShowTableAllPutDownRsp.Builder builder = ShowTableAllPutDownRsp.newBuilder();
        builder.setReq(req);
        ErrorID result = handleService(() -> {
            int money = tableHandler.showTableAllPutDown(roleID, req);
            builder.setMoney(money);
        });
        builder.setErrorID(result);
        return builder.build();
    }
    // 展厅领奖状态查询
    public GeneratedMessageV3 showTableDrawInfoReq(long roleID, ShowTableDrawInfoReq req) {
        ShowTableDrawInfoRsp.Builder builder = ShowTableDrawInfoRsp.newBuilder();
        ErrorID result = handleService(() -> {
            int state = ServiceManager.getShowTableService().moneyDrawInfo(roleID, req.getType());
            builder.setState(state);
        });
        builder.setErrorID(result);
        return builder.build();
    }

    // 展厅领奖
    public GeneratedMessageV3 showTableDrawPrizeReq(long roleID, ShowTableDrawPrizeReq req) {
        ShowTableDrawPrizeRsp.Builder builder = ShowTableDrawPrizeRsp.newBuilder();
        ErrorID result = handleService(() -> {
            int goldNum = tableHandler.showTableDrawPrize(roleID, req.getType());
            builder.setGoldNum(goldNum);
        });
        builder.setErrorID(result);
        return builder.build();
    }

    // 物品移动位置
    public GeneratedMessageV3 showTableMoveReq(long roleID, ShowTableMoveReq req) {
        ShowTableMoveRsp.Builder builder = ShowTableMoveRsp.newBuilder();
		builder.setReq(req);
		ErrorID result = handleService(() -> {
            tableHandler.showTableMove(roleID, req);
        });
        builder.setErrorID(result);
        return builder.build();
    }

    // 获取展厅财富值
    public GeneratedMessageV3 showTableMoneyReq(long roleID, ShowTableMoneyReq req) {
        ShowTableMoneyNtf.Builder builder = ShowTableMoneyNtf.newBuilder();
        handleService(() -> {
            tableHandler.showTableMoney(roleID, builder);
        });
        return builder.build();
    }

    // 展厅合成
    public GeneratedMessageV3 antiqueComposeReq(long roleID, AntiqueComposeReq req) {
        AntiqueComposeRsp.Builder builder = AntiqueComposeRsp.newBuilder();
		builder.setReq(req);
		ErrorID result = handleService(() -> {
            tableHandler.antiqueCompose(roleID, req);
        });
        builder.setErrorID(result);
        return builder.build();
    }

    // 物品交换位置
    public GeneratedMessageV3 showTableChangePositionReq(long roleID, ShowTableChangePositionReq req) {
        ShowTableChangePositionRsp.Builder builder = ShowTableChangePositionRsp.newBuilder();
		builder.setReq(req);
		ErrorID result = handleService(() -> {
            tableHandler.showTableChangePosition(roleID, req);
        });
        builder.setErrorID(result);
        return builder.build();
    }

    // 展厅套装
    public GeneratedMessageV3 antiqueSuitReq(long roleID, AntiqueSuitReq req) {
        AntiqueSuitRsp.Builder builder = AntiqueSuitRsp.newBuilder();
		builder.setReq(req);
		ErrorID result = handleService(() -> {
            tableHandler.antiqueSuit(roleID, req);
        });
        builder.setErrorID(result);
        return builder.build();
    }

    // 召唤精灵
    public GeneratedMessageV3 summonReq(long roleID, SummonReq req) {
        SummonRsp.Builder builder = SummonRsp.newBuilder();
        ErrorID result = handleService(() -> {
            summonHandler.summonReq(roleID, req, builder);
        });
        builder.setErrorID(result);
        return builder.build();
    }

    // 召唤精灵
    public GeneratedMessageV3 summonRetainReq(long roleID, SummonRetainReq req) {
        SummonRetainRsp.Builder builder = SummonRetainRsp.newBuilder();
        ErrorID result = handleService(() -> {
            summonHandler.summonRetainReq(roleID, req, builder);
        });
        builder.setErrorID(result);
        builder.setReq(req);
        return builder.build();
    }

    // 派出精灵
    public GeneratedMessageV3 summonSendReq(long roleID, SummonSendReq req) {
        SummonSendRsp.Builder builder = SummonSendRsp.newBuilder();
        ErrorID result = handleService(() -> {
            summonHandler.summonSend(roleID, req.getSummonID(), builder);
        });
        builder.setErrorID(result);
        return builder.build();
    }

    // 领取精灵邮件奖励
    public GeneratedMessageV3 summonMailRewardReq(long roleID, SummonMailRewardReq req) {
        SummonMailRewardRsp.Builder builder = SummonMailRewardRsp.newBuilder();
        builder.setReq(req);
        ErrorID result = handleService(() -> {
            summonHandler.summonMailReward(roleID, req, builder);
        });
        builder.setErrorID(result);
        return builder.build();
    }

    // 领取精灵邮件奖励
    public GeneratedMessageV3 summonAllMailRewardReq(long roleID, SummonAllMailRewardReq req) {
        SummonAllMailRewardRsp.Builder builder = SummonAllMailRewardRsp.newBuilder();
        builder.setReq(req);
        ErrorID result = handleService(() -> {
            summonHandler.summonAllMailReward(roleID, req, builder);
        });
        builder.setErrorID(result);
        return builder.build();
    }

    // 刷新精灵邮件
    public GeneratedMessageV3 summonMailRefreshReq(long roleID, SummonMailRefreshReq req) {
        SummonMailRefreshRsp.Builder builder = SummonMailRefreshRsp.newBuilder();
        builder.setReq(req);
        ErrorID result = handleService(() -> {
            summonHandler.summonMailRefresh(roleID, req, builder);
        });
        builder.setErrorID(result);
        return builder.build();
    }

    // 首次打开精灵邮件
    public GeneratedMessageV3 summonMailFirstReq(long roleID, SummonMailFirstReq req) {
        SummonMailFirstRsp.Builder builder = SummonMailFirstRsp.newBuilder();
        ErrorID result = handleService(() -> {
            builder.setIndex(req.getIndex());
            summonHandler.summonMailFirst(roleID, req);
        });
        builder.setErrorID(result);
        return builder.build();
    }

    // 投资精灵
    public GeneratedMessageV3 summonInvestReq(long roleID, SummonInvestReq req) {
        SummonInvestRsp.Builder builder = SummonInvestRsp.newBuilder();
        ErrorID result = handleService(() -> {
        	builder.setReq(req);
            summonHandler.summonInvest(roleID, req, builder);
        });
        builder.setErrorID(result);
        return builder.build();
    }

    // 请求精灵新邮件
    public GeneratedMessageV3 summonNewMailReq(long roleID, SummonNewMailReq req) {
    	SummonNewMailRsp.Builder builder = SummonNewMailRsp.newBuilder();
    	ErrorID result = handleService(() -> {
    		summonHandler.summonNewMail(roleID, builder);
    	});
    	builder.setErrorID(result);
    	return builder.build();
    }

    // 请求召唤精灵信息
    public GeneratedMessageV3 summonInfoReq(long roleID, SummonInfoReq req) {
        SummonInfoRsp.Builder builder = SummonInfoRsp.newBuilder();
        ErrorID result = handleService(() -> {
            summonHandler.summonInfoReq(roleID, req.getRoleId(), builder);
        });
        builder.setErrorID(result);
        return builder.build();
    }

    // 精灵投资奖励
    public GeneratedMessageV3 summonPickupInvestRewardReq(long roleID, SummonPickupInvestRewardReq req) {
        SummonPickupInvestRewardRsp.Builder builder = SummonPickupInvestRewardRsp.newBuilder();
        builder.setReq(req);
        ErrorID result = handleService(() -> {
            summonHandler.summonPickupInvestReward(roleID, req, builder);
        });
        builder.setErrorID(result);
        return builder.build();
    }

    // 请求精灵新邮件
    public GeneratedMessageV3 summonFastMailReq(long roleID, SummonFastMailReq req) {
        SummonFastMailRsp.Builder builder = SummonFastMailRsp.newBuilder();
        ErrorID result = handleService(() -> {
            summonHandler.summonFastMail(roleID, req, builder);
        });
        builder.setErrorID(result);
        return builder.build();
    }

    // 创建公会
 	public GeneratedMessageV3 createGuildReq(long roleID, CreateGuildReq req) {
 		ErrorID result = handleService(() -> {
 			topicHandler.createGuild(roleID, req);
 		});
 		if (result != ErrorID.OK) {
 			CreateGuildRsp.Builder builder = CreateGuildRsp.newBuilder();
 			builder.setErrorID(result);
 			return builder.build();
 		}
 		return null;
 	}
 	
 	// 改商会名
 	public GeneratedMessageV3 changeGuildNameReq(long roleID, ChangeGuildNameReq req) {
 		handleService(() -> {
 			topicHandler.changeGuildName(roleID, req.getName());
 		});
 		return null;
 	}

 	// 商会战斗报名
 	public GeneratedMessageV3 signUpGuildBattleReq(long roleID, SignUpGuildBattleReq req) {
 		SignUpGuildBattleRsp.Builder builder = SignUpGuildBattleRsp.newBuilder();
    	ErrorID result = handleService(() -> {
    		topicHandler.signUpGuildBattle(roleID);
    	});
    	builder.setErrorID(result);
    	return builder.build();
 	}
}
