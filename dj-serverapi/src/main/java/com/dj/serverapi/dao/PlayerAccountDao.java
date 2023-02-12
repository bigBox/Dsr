package com.dj.serverapi.dao;

import com.dj.domain.GlobalRoleID;
import com.dj.domain.enums.TaskActionEnum;
import com.dj.domain.type.AccessType;
import com.dj.domain.entity.player.PlayerAccount;
import com.dj.protobuf.CommonException;
import com.dj.protobuf.ErrorIDOuterClass.ErrorID;
import com.dj.protobuf.login.CreateAccountReq;
import com.dj.serverapi.EventProvider;
import com.dj.serverapi.dao.base.BaseCacheDao;
import com.dj.serverapi.dao.inf.IPlayerAccountDao;
import com.dj.serverapi.redis.CommonRedis;
import com.dj.domain.util.DateUtil;
import com.dj.domain.util.StringUtil;
import com.dj.domain.util.codec.Sha;
import com.dj.domain.util.lib.QueryParamMap;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class PlayerAccountDao extends BaseCacheDao<PlayerAccount> implements IPlayerAccountDao {
	// 创建账号
	@Override
	public PlayerAccount createAccount(CreateAccountReq req, String ip, String channel) {
		String account = req.getAccount().toLowerCase();
		if (account.equals(GlobalRoleID.getXiaoXunRoleName())) {
			log.error("createAccount error! account == 小寻");
			throw new CommonException(ErrorID.ACCOUNT_IS_EXITS);
		}
		// 检测账号是否存在
		List<PlayerAccount>list = this.getAccountFromDB(account, null);
		if (list != null && list.size() > 0) {
			log.error("createAccount list != null error! 账户已经存在!  account == {}", account);
			throw new CommonException(ErrorID.ACCOUNT_IS_EXITS);
		}
		// 是不是机器人大寻
		long roleID = GlobalRoleID.getRobot();
		if(!req.getAccount().equals("robot")) {
			roleID = CommonRedis.getInstance().getAtomicRoleId();
		}
		PlayerAccount playerAccount = new PlayerAccount(roleID, req.getAccount(), req.getPassword(), req.getNickname(), ip, channel);
		cacheInsert(playerAccount, roleID);
		return playerAccount;
	}

	@Override
	public PlayerAccount loginAccount(String account, String password, String ip) {
		PlayerAccount playerAccount = null;
		List<PlayerAccount> list = this.getAccountFromDB(account, null);
		if (list == null || list.size() == 0) {
			log.error("loginAccount list == null error! 账户不存在!  account == {}", account);
			throw new CommonException(ErrorID.ACCOUNT_PASS_ERROR, "account:"+account);
		}
		String shaPassword = Sha.getPassword(password);
		for (PlayerAccount tmp : list) {
			if (tmp.getPassword().equals(shaPassword)) {
				playerAccount = tmp;
				break;
			}
		}
		if (playerAccount == null) {
			log.error("loginAccount playerAccount == null error! 账户密码错误!  account == {}", account);
			throw new CommonException(ErrorID.ACCOUNT_PASS_ERROR, "account:"+account+", password:"+password);
		}
		// 设置首次登录
		playerAccount.setFirstLoginFlag(playerAccount.getLastLoginTime() == null);
		// 当天第一次登陆
		if (playerAccount.getLastLoginTime() == null || !DateUtil.isToday(playerAccount.getLastLoginTime().getTime())) {
			EventProvider.postTaskActionEvent(playerAccount.getId(), TaskActionEnum.ACTIVE_DAY, 1);
		}
		playerAccount.setLastLoginIp(ip);
		playerAccount.setLastLoginTime(DateUtil.getCurrentDate());
		this.cacheUpdate(playerAccount, playerAccount.getId());
		return playerAccount;
	}

	@Override
	public List<PlayerAccount> getAccountFromDB(String account, String idCard) {
		QueryParamMap<String, Object> queryParams = new QueryParamMap<>(1);
		if(StringUtil.isNotEmpty(account)) {
			queryParams.put("account", account);
		}else {
			queryParams.put("idCard", idCard);
		}
		return selectList(queryParams, GlobalRoleID.getRobot(), AccessType.DIRECT_DB);
	}
}
