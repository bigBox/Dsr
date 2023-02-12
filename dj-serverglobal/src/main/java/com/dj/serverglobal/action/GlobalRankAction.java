package com.dj.serverglobal.action;

import java.util.List;
import java.util.Map;

import com.dj.protobuf.Module;
import com.dj.protobuf.ErrorIDOuterClass.ErrorID;
import com.dj.protobuf.ProtobufCmd;
import com.dj.protobuf.forward.ForwardGlobalRankReq;
import com.dj.protobuf.forward.ForwardGlobalRankRsp;
import com.dj.protobuf.leaderboard.RankSelfNearbyReq;
import com.dj.protobuf.leaderboard.RankSelfNearbyRsp;
import com.dj.protobuf.leaderboard.RankTopNReq;
import com.dj.protobuf.trade.*;
import com.dj.serverapi.ServiceProvider;
import com.dj.servercore.action.base.BaseAction;
import com.dj.servercore.action.base.IActionCmd;
import com.dj.servercore.action.base.IActionModule;
import com.dj.servercore.action.base.IFieldHandler;
import com.dj.servercore.task.msg.MyMsg;
import com.dj.serverglobal.handler.GlobalTradeHandler;
import com.dj.domain.util.StringUtil;
import com.dj.domain.util.Utility;
import com.google.protobuf.GeneratedMessageV3;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;

/**
 * @author zcq
 * @ClassName: GlobalRankAction
 * @Description: 排行榜，交易
 * @date 2019年6月25日
 */
@Slf4j
@Data
@EqualsAndHashCode(callSuper = false)
@IActionModule(module = Module.GLOBAL_RANK)
public class GlobalRankAction extends BaseAction {

    @IFieldHandler
    private GlobalTradeHandler globalTradeHandler;

    @IActionCmd(cmd = ProtobufCmd.SERVER_FORWARD_GLOBALRANK_REQ)
    public Long forwardGlobalRankReq(MyMsg msg) {
        ForwardGlobalRankReq forward = msg.getContent(ForwardGlobalRankReq.class);
        try {
            GeneratedMessageV3 rspContent = doReqHandler(forward.getRoleID(), forward.getReqClz(), forward.getReq());
            if (rspContent != null) {
                ForwardGlobalRankRsp.Builder builder = msg.getResultBuilder(ForwardGlobalRankRsp.class);
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

    // 排行榜请求
    public GeneratedMessageV3 rankTopNReq(long roleID, RankTopNReq req) {
        GeneratedMessageV3 rspContent = ServiceProvider.getRankService().readRankTypeNtf(roleID, req.getType());
        return rspContent;
    }

    // 获取自己排名附近前后的排行
    public GeneratedMessageV3 rankSelfNearbyReq(long roleID, RankSelfNearbyReq req) {
        RankSelfNearbyRsp.Builder builder = RankSelfNearbyRsp.newBuilder();
        ErrorID result = handleService(() -> {
            builder.setType(req.getType());
            ServiceProvider.getRankService().rankSelfNearbyReq(roleID, req.getType(), builder);
        });
        builder.setErrorID(result);
        return builder.build();
    }

    // 可交易的前几名
    public GeneratedMessageV3 tradeTopNReq(long roleID, TradeTopNReq req) {
        TradeTopNRsp.Builder builder = TradeTopNRsp.newBuilder();
        ErrorID result = handleService(() -> {
            builder.setReq(req);
            List<TradeOrderInfo> info = globalTradeHandler.tradeTopN(roleID, req.getItemID(), req.getType());
            if (info != null) {
                builder.addAllInfo(info);
            }
        });
        builder.setErrorID(result);
        return builder.build();
    }

    // 交易放入队列
    public GeneratedMessageV3 tradeEnqueueReq(long roleID, TradeEnqueueReq req) {
        TradeEnqueueRsp.Builder builder = TradeEnqueueRsp.newBuilder();
        builder.setReq(req);
        ErrorID result = handleService(() -> {
            globalTradeHandler.tradeEnqueue(roleID, req);
        });
        builder.setErrorID(result);
        return builder.build();
    }

    // 交易买卖
    //public GeneratedMessageV3 tradeUseReq(long roleID, TradeUseReq req) {
    //    TradeUseRsp.Builder builder = TradeUseRsp.newBuilder();
    //    builder.setReq(req);
    //    ErrorID result = handleService(() -> {
    //        globalTradeHandler.tradeUse(roleID, req);
    //    });
    //    builder.setErrorID(result);
    //    return builder.build();
    //}

    // 拿出队列
    public GeneratedMessageV3 tradeDequeueReq(long roleID, TradeDequeueReq req) {
        TradeDequeueRsp.Builder builder = TradeDequeueRsp.newBuilder();
        ErrorID result = handleService(() -> {
            builder.setReq(req);
            globalTradeHandler.tradeDequeue(roleID, req);
        });
        builder.setErrorID(result);
        return builder.build();
    }

    // 玩家发布的东西
    public GeneratedMessageV3 tradeRoleReq(long roleID, TradeRoleReq req) {
        TradeRoleRsp.Builder builder = TradeRoleRsp.newBuilder();
        ErrorID result = handleService(() -> {
            builder.setReq(req);
            List<TradeOrderInfo> info = globalTradeHandler.tradeRole(roleID, req);
            if (info != null) {
                builder.addAllInfo(info);
            }
        });
        builder.setErrorID(result);
        return builder.build();
    }

    // 交易信息
    public GeneratedMessageV3 stockListReq(long roleID, StockListReq req) {
        StockListRsp.Builder builder = StockListRsp.newBuilder();
        builder.setReq(req);
        ErrorID result = handleService(() -> {
            Map<Integer, StockInfo> stocks = globalTradeHandler.stockList(roleID, req.getItemIDsList());
            builder.putAllStocks(stocks);
        });
        builder.setErrorID(result);
        return builder.build();
    }

    // 获取订单的交易历史记录
    public GeneratedMessageV3 tradeHistoryReq(long roleID, TradeHistoryReq req) {
        TradeHistoryRsp.Builder builder = TradeHistoryRsp.newBuilder();
        builder.setReq(req);
        ErrorID result = handleService(() -> {
        	globalTradeHandler.tradeHistory(roleID, req.getItemID(), builder);
        });
        builder.setErrorID(result);
        return builder.build();
    }
    
    // 交易页面关闭
    public GeneratedMessageV3 tradeCloseReq(long roleID, TradeCloseReq req) {
        TradeCloseRsp.Builder builder = TradeCloseRsp.newBuilder();
    	ErrorID result = handleService(() -> {
    		globalTradeHandler.tradeClose(roleID);
    	});
    	builder.setErrorID(result);
    	return builder.build();
    }
}
