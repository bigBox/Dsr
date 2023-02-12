package com.dj.serverplayer.handler;

import com.dj.domain.config.ConfigExpLevelCfg;
import com.dj.domain.entity.player.PlayerRole;
import com.dj.protobuf.CommonException;
import com.dj.protobuf.ErrorIDOuterClass;
import com.dj.protobuf.ErrorIDOuterClass.ErrorID;
import com.dj.protobuf.gm.*;
import com.dj.serverapi.helper.OnlineHelper;
import com.dj.serverapi.sensitiveword.SensitivewordFilter;
import com.dj.servercore.Checker;
import com.dj.servercore.conf.ConfigExpLevelCfgConf;
import com.dj.servercore.conf.base.ConfProvider;
import com.dj.servercore.conf.base.IConfProvider;
import com.dj.serverplayer.handler.base.BaseHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author zcq
 * @description GM业务处理
 * @date 2020年5月22日
 */
@Component
@Slf4j
public class GmHandler extends BaseHandler {

	public void readRole(ReadRoleReq req, ReadRoleRsp.Builder builder) {
		PlayerRole role = playerService.getPlayer(req.getRoleID());
		builder.setRoleInfo(role.toRoleInfo());
	}

	@SuppressWarnings("deprecation")
	public void writeRole(WriteRoleReq req, WriteRoleRsp.Builder builder) {
		PlayerRole role = playerService.getPlayer(req.getRoleID());
		// 角色名
		if (!role.getRoleName().equals(req.getRoleInfo().getRoleName())) {
			if (!Checker.isValidNickName(req.getRoleInfo().getRoleName())) {
				throw new CommonException(ErrorID.INPUT_WORD_IS_NOT_RIGHT);
			}
			if (SensitivewordFilter.isContainSensitiveWord(req.getRoleInfo().getRoleName())) {
				throw new CommonException(ErrorID.INPUT_WORD_IS_ILLEGAL);
			}
			if (playerService.checkExitName(req.getRoleInfo().getRoleName())) {
				throw new CommonException(ErrorID.PLAYER_NAME_IS_EXITS);
			}
			role.setRoleName(req.getRoleInfo().getRoleName());
		}
		// 等级
		if (role.getLevel() != req.getRoleInfo().getLevel()) {
			role.setLevel(req.getRoleInfo().getLevel());
			ConfigExpLevelCfgConf conf = ConfProvider.getConfigConfProvider().getConfigConf(IConfProvider.CONFIG_EXPLEVELCFG);
			if(conf == null){
				log.error("writeRole ConfigExpLevelCfgConf conf == null");
				throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
			}
			ConfigExpLevelCfg cfg = conf.getExpLevelCfg(role.getLevel());
			if (cfg != null) {
				role.setExperience((new Double(cfg.getUpLevelTotalExp())).intValue());
			}
		}
		// 金币
		if (role.getGold() != req.getRoleInfo().getGold()) {
			role.setGold(req.getRoleInfo().getGold());
		}
		// 钻石
		if (role.getDiamond() != req.getRoleInfo().getDiamond()) {
			role.setDiamond(req.getRoleInfo().getDiamond());
		}
		// 生态值
		if (role.getEcology() != req.getRoleInfo().getEcology()) {
			role.setEcology(req.getRoleInfo().getEcology());
		}
		// 个人签名
		if (!role.getSignature().equals(req.getRoleInfo().getSignature())) {
			role.setSignature(req.getRoleInfo().getSignature());
		}
		// 更新
		playerService.setPlayer(req.getRoleID(), role);
		if (OnlineHelper.getInstance().checkOnline(req.getRoleID())) {
			playerRoleDao.cacheUpdate(role);
		} else {
			playerRoleDao.cacheUpdate(role, req.getRoleID());
		}
		// 返回最新数据
		builder.setRoleInfo(role.toRoleInfo());
	}

	public void readItem(ReadItemReq req, ReadItemRsp.Builder builder) {
		builder.addAllItems(getItemList(req.getRoleID(), req.getCol()));
	}

}
