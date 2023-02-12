package com.dj.serverapi.dao.inf;

import com.dj.domain.entity.global.GlobalTradeHistory;
import com.dj.servercore.db.inf.dao.IDaoOperation;

import java.util.List;

public interface IGlobalTradeHistoryDao extends IDaoOperation<GlobalTradeHistory> {

    List<GlobalTradeHistory> readDbData(int itemID);
}
