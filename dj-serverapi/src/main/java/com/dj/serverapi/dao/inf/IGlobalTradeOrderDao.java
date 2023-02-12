package com.dj.serverapi.dao.inf;

import java.util.List;

import com.dj.domain.entity.global.GlobalTradeOrder;
import com.dj.protobuf.trade.TradeType;
import com.dj.servercore.db.inf.dao.IDaoOperation;

public interface IGlobalTradeOrderDao extends IDaoOperation<GlobalTradeOrder> {

	List<GlobalTradeOrder> readDbData(int itemID, TradeType tradeType);

	List<GlobalTradeOrder> getRoleTradeOrder(long roleID, TradeType tradeType);
}
