package com.dj.serverapi.dao.inf;

import com.dj.domain.entity.player.PlayerAccount;
import com.dj.protobuf.login.CreateAccountReq;
import com.dj.servercore.db.inf.dao.IDaoOperation;

import java.util.List;

public interface IPlayerAccountDao extends IDaoOperation<PlayerAccount> {

	PlayerAccount createAccount(CreateAccountReq req, String ip, String channel);

	PlayerAccount loginAccount(String reqAccount, String password, String ip);
	
	List<PlayerAccount> getAccountFromDB(String reqAccount, String idCard);
}
