package com.dj.serverplayer.quartz;

import com.dj.domain.config.ConfigStaminaCfg;
import com.dj.domain.data.MonthCard;
import com.dj.domain.entity.player.PlayerRole;
import com.dj.domain.enums.PlayerAttrEnum;
import com.dj.domain.enums.ResourceBillEnum;
import com.dj.serverapi.helper.OnlineHelper;
import com.dj.serverapi.helper.OnlineRole;
import com.dj.servercore.conf.ConfigStaminaCfgConf;
import com.dj.servercore.quartz.AbstractQuartzJob;
import com.dj.servercore.spring.SpringContext;
import com.dj.serverplayer.handler.InitHandler;
import com.dj.serverplayer.manager.ConfManager;
import com.dj.serverplayer.manager.EventManager;
import com.dj.serverplayer.manager.QuartzManager;
import com.dj.serverplayer.manager.ServiceManager;
import com.google.common.cache.Cache;
import org.quartz.JobExecutionContext;

import java.util.Set;

public class StaminaRecoverJob extends AbstractQuartzJob {

	private ConfigStaminaCfgConf staminaCfgConf = ConfManager.getInstance().getConfigStaminaCfgConf();
	
	public StaminaRecoverJob() {
		setName(StaminaRecoverJob.class.getSimpleName());
		setDescription("体力恢复");
		setNeedCancelAfterWork(false);
		setRetryAfter3MinOnError(false);
	}

	@Override
	protected void run(JobExecutionContext jobContext) {
		// 对在线玩家每分钟进行体力恢复
		Cache<Long, OnlineRole> onlineMap = OnlineHelper.getInstance().getOnlineMap();
		if(onlineMap.size() <= 0){
			return;
		}
		InitHandler initHandler = SpringContext.getBean(InitHandler.class);
		Set<Long> roleSet = onlineMap.asMap().keySet();
		for (long roleID : roleSet){
			PlayerRole playerRole =ServiceManager.getPlayerService().getPlayer(roleID);
			int recoverMax = PlayerAttrEnum.STAMINA.getDefaultValue();
			ConfigStaminaCfg staminaCfg = staminaCfgConf.getStaminaCfg(playerRole.getLevel());
			if(staminaCfg != null) {
				recoverMax = staminaCfg.getRecoverMax();
			}
			long stamina = 10;
			MonthCard monthCard = ServiceManager.getBuffService().getMonthCard(roleID);
			if (monthCard != null && monthCard.getEndTime() >= System.currentTimeMillis()) {
				// 月卡用户体力加倍
				stamina = (int) (stamina*1.5);
				recoverMax = (int) (recoverMax*1.5);
			}
			// 没超过体力上限
			if(playerRole != null && playerRole.getStamina() < recoverMax){
				if(playerRole.getStamina() + stamina > recoverMax){
					stamina = recoverMax - playerRole.getStamina();
				}
				initHandler.addStamina(roleID, stamina, ResourceBillEnum.staminaRecover);
				EventManager.commitRoleEvent(roleID);
			}
		}
	}

	public static void init() {
		QuartzManager.getInstance().addJob("maintain_staminarecover", "group_job_maintain", StaminaRecoverJob.class, 60 * 1000L);
	}
}
