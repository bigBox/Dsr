package com.dj.serverapi.dao.inf;

import com.dj.domain.entity.global.GlobalTradeHistoryImport;
import com.dj.servercore.db.inf.dao.IDaoOperation;

import java.util.List;

public interface IGlobalTradeHistoryImportDao extends IDaoOperation<GlobalTradeHistoryImport> {

    List<GlobalTradeHistoryImport> readDbData(String itemID);
}
