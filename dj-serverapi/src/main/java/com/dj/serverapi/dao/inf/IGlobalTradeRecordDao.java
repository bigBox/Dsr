package com.dj.serverapi.dao.inf;

import com.dj.domain.entity.global.GlobalTradeRecord;
import com.dj.protobuf.trade.TradeType;
import com.dj.servercore.db.inf.dao.IDaoOperation;

import java.util.List;

public interface IGlobalTradeRecordDao extends IDaoOperation<GlobalTradeRecord> {

	List<GlobalTradeRecord> readDbData(int itemID);

	List<GlobalTradeRecord> getRoleTradeRecord(long roleID, TradeType tradeType);
}
