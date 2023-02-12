package com.dj.serverplayer.quartz;

import com.dj.domain.enums.ResourceBillEnum;
import com.dj.protobuf.CommonException;
import com.dj.protobuf.ErrorIDOuterClass;
import com.dj.protobuf.ServerType;
import com.dj.domain.config.ConfigItems;
import com.dj.domain.entity.player.PlayerAccount;
import com.dj.domain.entity.player.PlayerLeaveHistory;
import com.dj.domain.entity.player.PlayerShowTable;
import com.dj.domain.entity.player.PlayerShowTableMoney;
import com.dj.protobuf.login.HeartbeatCfgNtf;
import com.dj.protobuf.showtable.ShowTableAutoPutDownNtf;
import com.dj.serverapi.ServiceProvider;
import com.dj.serverapi.dao.PlayerAccountDao;
import com.dj.serverapi.helper.OnlineHelper;
import com.dj.serverapi.helper.OnlineRole;
import com.dj.servercore.conf.ConfigItemsConf;
import com.dj.servercore.quartz.AbstractQuartzJob;
import com.dj.servercore.server.SocketServer;
import com.dj.servercore.spring.SpringContext;
import com.dj.serverplayer.handler.InitHandler;
import com.dj.serverplayer.manager.ChannelManager;
import com.dj.serverplayer.manager.ConfManager;
import com.dj.serverplayer.manager.QuartzManager;
import com.dj.serverplayer.manager.ServiceManager;
import com.dj.domain.util.DateUtil;
import com.google.common.cache.Cache;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.quartz.JobExecutionContext;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Slf4j
public class OnlineJob extends AbstractQuartzJob {

    public OnlineJob() {
        setName(OnlineJob.class.getSimpleName());
        setDescription("在线人数");
        setNeedCancelAfterWork(false);
        setRetryAfter3MinOnError(false);
    }

    @Override
    protected void run(JobExecutionContext jobContext) {
    	Date nowDate = DateUtil.getCurrentDate();
    	// 在线列表
        Cache<Long, OnlineRole> onlineMap = OnlineHelper.getInstance().getOnlineMap();
        onlineMap.cleanUp();
        if(onlineMap.size() <= 0){
			return;
		}
        log.info("serverType:{}, serverID:{}, onlineCount:{}", ServerType.PLAYER, SocketServer.getServerConfig().getId(), onlineMap.size());
        InitHandler initHandler = SpringContext.getBean(InitHandler.class);
        // 检查防沉迷
        Set<Long> roleSet = onlineMap.asMap().keySet();
        HeartbeatCfgNtf.Builder heartNtf = HeartbeatCfgNtf.newBuilder();
        heartNtf.setInterval(0);

        ShowTableAutoPutDownNtf.Builder putDownNtf = ShowTableAutoPutDownNtf.newBuilder();
        ConfigItemsConf conf = ConfManager.getInstance().getConfigItemsConf();
		if(conf == null){
			throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
		}
		for (long roleID : roleSet){
			OnlineRole onlineRole = onlineMap.getIfPresent(roleID);
			// 标本馆和水族馆动物自动离开
			List<PlayerShowTable> showTables = initHandler.playerShowTableDao.cacheLoadAll(roleID);
			if(showTables != null && showTables.size() > 0) {
				for (int i = showTables.size() - 1; i >= 0; i--) {
					PlayerShowTable showTable = showTables.get(i);
					if(showTable.getType() != 0 && showTable.getCreateTime() != null) {
						Date leaveTime = DateUtil.plusTime(showTable.getCreateTime(), TimeUnit.DAYS, 1);
						if(nowDate.getTime() >= leaveTime.getTime()) {
							// 将物品从展架上拿下来
							initHandler.playerShowTableDao.cacheDelete(showTable.getId(), roleID);
							ServiceManager.getShowTableService().showTablePutDown(roleID, showTable);
							ConfigItems item = conf.getItem(showTable.getItemID());
							if(ObjectUtils.isNotEmpty(item)){
								PlayerShowTableMoney showTableMoney = ServiceManager.getShowTableService().decreaseShowTableMoney(roleID, showTable.getType(), item.getGold());
								initHandler.playerShowTableMoneyDao.cacheUpdate(showTableMoney, roleID);
								initHandler.costShowTable(roleID, item.getGold(), ResourceBillEnum.showTableAutoPutDown);
							}
					        // 添加离开历史记录
					        PlayerLeaveHistory leaveHistory = new PlayerLeaveHistory(roleID);
					        leaveHistory.setType(showTable.getType());
					        leaveHistory.setLeaveID(showTable.getItemID());
					        leaveHistory.setPlaceTime(showTable.getCreateTime());
					        initHandler.playerLeaveHistoryDao.cacheInsert(leaveHistory, roleID);
							// 推送给前端
							putDownNtf.setType(showTable.getType());
							putDownNtf.setPage(showTable.getPage());
							putDownNtf.setIndex(showTable.getIndex());
							ChannelManager.getInstance().sendPlayerSingleToGate(onlineRole.getGateServerID(), roleID, putDownNtf.build());
						}
					}
				}
			}
			List<PlayerAccount> playerAccounts = SpringContext.getBean(PlayerAccountDao.class).cacheLoadAll(roleID);
			if(playerAccounts == null || playerAccounts.size() == 0){
				return;
			}
			PlayerAccount   playerAccount = playerAccounts.get(0);
			if((playerAccount != null) && (playerAccount.getAge() < 18)) {
				log.info("roleID {}, age {}", onlineRole.getRoleID(), playerAccount.getAge());
				onlineRole.setTodayOnline(onlineRole.getTodayOnline()+onlineRole.getOnline());
				onlineRole.setOnline(60);
				boolean isGameDay = ServiceProvider.getHolidayService().isPlayGameDayTime(System.currentTimeMillis());
				if(!isGameDay){
					//throw new CommonException(ErrorIDOuterClass.ErrorID.ADDICTION_LIMIT_TIME);
					heartNtf.setTip("每日21时至次日20时，未成年人无法登陆游戏。请下线休息。");
					ChannelManager.getInstance().sendPlayerBasicToGate(onlineRole.getGateServerID(), onlineRole.getRoleID(), heartNtf.build());
					initHandler.logout(onlineRole.getRoleID());
				}
				// 每日22时至次日8时，未成年人用户无法登陆游戏。
//				String dateStr = DateUtil.formatDate(nowDate);
//				Date date22 = DateUtil.parseDate(dateStr + " 21:59", DateUtil.VIEW_STYLE_NORMAL);
//				if(nowDate.getTime() >= date22.getTime()) {
//					heartNtf.setTip("每日22时至次日8时，未成年人无法登陆游戏。请下线休息。");
//					ChannelManager.getInstance().sendPlayerBasicToGate(onlineRole.getGateServerID(), onlineRole.getRoleID(), heartNtf.build());
//					continue;
//				}
//				// 未成年人每日累计游戏时间不得超过1.5小时，法定节假日每日累计游戏时间不得超过3小时。
//				if (PlayerServer.getInstance().todayIsHoliday()) {
//					// 节假日
//					if(onlineRole.getTodayOnline() >= ConstantGame.ADDICTION_180) {
//						heartNtf.setTip("未成年人节假日累计游戏时间不得超过3小时，您已超时，请下线休息。");
//						ChannelManager.getInstance().sendPlayerBasicToGate(onlineRole.getGateServerID(), onlineRole.getRoleID(), heartNtf.build());
//
//						initHandler.logout(onlineRole.getRoleID());
//						continue;
//					}
//				}else {
//					// 非节假日
//					if(onlineRole.getTodayOnline() >= ConstantGame.ADDICTION_90) {
//						heartNtf.setTip("未成年人每日累计游戏时间不得超过1.5小时，您已超时，请下线休息。");
//						ChannelManager.getInstance().sendPlayerBasicToGate(onlineRole.getGateServerID(), onlineRole.getRoleID(), heartNtf.build());
//						initHandler.logout(onlineRole.getRoleID());
//						continue;
//					}
//				}
			}
		}
    }

    public static void init() {
        QuartzManager.getInstance().addJob("maintain_online", "group_job_maintain", OnlineJob.class, 60 * 1000L);
    }
}
