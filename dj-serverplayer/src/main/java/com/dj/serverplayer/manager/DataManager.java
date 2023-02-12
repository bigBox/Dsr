package com.dj.serverplayer.manager;

import com.dj.domain.entity.player.task.GuildTask;
import com.dj.domain.enums.PlayerAttrEnum;
import com.dj.domain.enums.SyncCommonEnum;
import com.dj.domain.enums.TaskActionEnum;
import com.dj.domain.enums.TaskState;
import com.dj.domain.config.ConfigTasks;
import com.dj.domain.data.GuildApply;
import com.dj.domain.entity.global.GlobalGuild;
import com.dj.domain.entity.player.PlayerItemInteractHistory;
import com.dj.domain.entity.player.PlayerRole;
import com.dj.domain.entity.player.PlayerVerifyHistory;
import com.dj.domain.event.TaskActionEvent;
import com.dj.domain.topic.*;
import com.dj.protobuf.CommonException;
import com.dj.protobuf.ErrorIDOuterClass;
import com.dj.protobuf.datetime.DateTime;
import com.dj.protobuf.guild.GuildApplyInfo;
import com.dj.protobuf.guild.GuildApplyNtf;
import com.dj.protobuf.guild.GuildApproveNtf;
import com.dj.protobuf.guild.GuildBaseInfo;
import com.dj.protobuf.task.ETaskType;
import com.dj.serverapi.ServiceProvider;
import com.dj.serverapi.dao.*;
import com.dj.serverapi.dao.task.GuildTaskDao;
import com.dj.serverapi.helper.MessageHelper;
import com.dj.servercore.conf.ConfigTasksConf;
import com.dj.servercore.spring.SpringContext;
import com.dj.serverplayer.handler.FriendHandler;
import com.dj.serverplayer.handler.InitHandler;
import com.dj.serverplayer.handler.ItemHandler;
import com.dj.serverplayer.handler.TaskHandler;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.List;

/**
 * @author zcq
 * @ClassName: DataManager
 * @Description: 跨项目处理事件，作为redis的topic主题鉴定后续业务逻辑
 * @date 2019年6月25日
 */
@Slf4j
public enum DataManager {
    INSTANCE;

	/**
	 * 通用变更
	 * @param event
	 */
    public void syncCommon(SyncCommonEvent event) {
        log.info("syncCommon event=",event.getTopic());
        if (event.getType() == SyncCommonEnum.VERIFY) {
            // 更新待揭晓
            ServiceManager.getVerifyService().updateVerify(event.getRoleID(), value -> {
            	SpringContext.getBean(PlayerVerifyDao.class).cacheUpdate(value, event.getRoleID());
            	// 添加历史记录
                List<PlayerVerifyHistory> historyList = value.getHistoryList();
            	if(historyList != null) {
            		for (PlayerVerifyHistory playerVerifyHistory : historyList) {
            			SpringContext.getBean(PlayerVerifyHistoryDao.class).cacheInsert(playerVerifyHistory, playerVerifyHistory.getRoleID());
            		}
            	}
                EventManager.postSyncAttrEvent(event.getRoleID());
                EventManager.commitRoleEvent(event.getRoleID());

            });
        } else if (event.getType() == SyncCommonEnum.FRIEND_ACTION) {
            // 好友行为
            long targetRoleID = (long) event.getArgs()[0];
            ServiceProvider.getFriendService().doAction(targetRoleID, value -> {
                if (value.getAction() == 1) {
                    SpringContext.getBean(FriendHandler.class).friendApproveSync(targetRoleID, value.getRoleID(), value.getApplyType(), value.getApplyTime());
                    SpringContext.getBean(FriendHandler.class).friendApproveSync(value.getRoleID(), targetRoleID, value.getApplyType(), value.getApplyTime());
                } else {
                    if(value.getId() > 0) {
                        SpringContext.getBean(PlayerFriendDao.class).cacheDelete(value.getId(), targetRoleID);
                    }
                }
            });
        }
    }

    /**
     * 同步道具
     *
     * @param roleID
     */
    public void syncItem(long roleID) {
        log.info("syncItem roleID {}", roleID);
        ServiceManager.getItemService().doItemBill(roleID, itemBill -> {
            if (itemBill.getItemCount() > 0) {
                SpringContext.getBean(ItemHandler.class).addItem(roleID, itemBill.getItemID(), itemBill.getItemCount(), itemBill.getBill(), itemBill.isPost2Client(), itemBill.isVisible());
            } else if (itemBill.getItemCount() < 0) {
                SpringContext.getBean(ItemHandler.class).costItem(roleID, itemBill.getItemID(), -itemBill.getItemCount(), itemBill.getBill(), itemBill.isPost2Client(), itemBill.isVisible());
            }
        });
        EventManager.commitRoleEvent(roleID);
    }

    /**
     * 同步属性
     *
     * @param roleID
     */
    public void syncAttr(long roleID) {
        log.info("syncAttr roleID {}", roleID);
        ServiceManager.getCommonService().doAttrBill(roleID, attrBill -> {
        	if (attrBill.getKey().equals(PlayerAttrEnum.DIAMOND.getKey())) {
                if (attrBill.getValue() > 0) {
                    SpringContext.getBean(InitHandler.class).addDiamond(roleID, attrBill.getValue(), attrBill.getBill());
                } else if (attrBill.getValue() < 0) {
                    SpringContext.getBean(InitHandler.class).costDiamond(roleID, -attrBill.getValue(), attrBill.getBill());
                }
            } else if (attrBill.getKey().equals(PlayerAttrEnum.GOLD.getKey())) {
                if (attrBill.getValue() > 0) {
                    SpringContext.getBean(InitHandler.class).addGold(roleID, attrBill.getValue(), attrBill.getBill());
                } else if (attrBill.getValue() < 0) {
                    SpringContext.getBean(InitHandler.class).costGold(roleID, -attrBill.getValue(), attrBill.getBill());
                }
            } else if (attrBill.getKey().equals(PlayerAttrEnum.EXP.getKey())) {
                if (attrBill.getValue() > 0) {
                    SpringContext.getBean(InitHandler.class).addExp(roleID, attrBill.getValue(), attrBill.getBill());
                }
            } else if (attrBill.getKey().equals(PlayerAttrEnum.STAMINA.getKey())) {
                if (attrBill.getValue() > 0) {
                    SpringContext.getBean(InitHandler.class).addStamina(roleID, attrBill.getValue(), attrBill.getBill());
                } else if (attrBill.getValue() < 0) {
                    SpringContext.getBean(InitHandler.class).costStamina(roleID, -attrBill.getValue(), attrBill.getBill());
                }
            }
            EventManager.commitRoleEvent(roleID);
        });
    }

    /**
     * 商会申请
     * @param event
     */
    public void guildApply(GuildApplyEvent event) {
        log.info("guildApply event=",event.getTopic());
        // 公会基本信息
        GlobalGuild guild = ServiceManager.getGuildService().getGuild(event.getGuildId());
        GuildBaseInfo guildInfo = MessageHelper.toGuildBaseInfo(guild);
        GuildApplyInfo.Builder applyInfo = GuildApplyInfo.newBuilder();
        applyInfo.setGuildInfo(guildInfo);
        PlayerRole playerRole = ServiceManager.getPlayerService().getPlayer(event.getRoleID());
        applyInfo.setBaseInfo(playerRole.toBaseRoleInfo());
        GuildApply guildApply = ServiceManager.getGuildService().getGuildApply(event.getRoleID(), event.getGuildId());
        applyInfo.setApplyTime(DateTime.newBuilder().setValue(guildApply.getApplyTime()));
        // 通知会长有新申请
        GuildApplyNtf.Builder ntf = GuildApplyNtf.newBuilder();
        ntf.setApplyInfo(applyInfo);
        playerRole = ServiceManager.getPlayerService().getPlayer(event.getChairman());
        ChannelManager.getInstance().sendPlayerSingleToGate(playerRole.getGateServerID(), event.getChairman(), ntf.build());
        EventManager.commitRoleEvent(event.getRoleID());
    }

    /**
     * 商会批准
     * @param event
     */
    public void guildApprove(GuildApproveEvent event) {
        log.info("guildApprove event=",event.getTopic());
        // 公会基本信息
        GlobalGuild guild = ServiceManager.getGuildService().getGuild(event.getGuildId());
        if(guild.getChairman() != event.getRoleID()){
            PlayerRole playerRole = ServiceManager.getPlayerService().setRoleGuild(event.getRoleID(), event.getGuildId());
            playerRole.setPost(event.getPost());
            SpringContext.getBean(PlayerRoleDao.class).cacheUpdate(playerRole, event.getRoleID());
            EventManager.commitRoleEvent(event.getRoleID());

            GuildBaseInfo guildInfo = MessageHelper.toGuildBaseInfo(guild);
            GuildApproveNtf.Builder ntf = GuildApproveNtf.newBuilder();
            ntf.setGuild(guildInfo);
            ChannelManager.getInstance().sendPlayerSingleToGate(playerRole.getGateServerID(), event.getRoleID(), ntf.build());

            EventManager.postTaskActionEvent(event.getRoleID(), TaskActionEnum.HAS_GUILD, 1);
            EventManager.commitRoleEvent(event.getRoleID());
        }
    }

    /**
     * 退出商会
     * @param event
     */
    public void guildQuit(GuildQuitEvent event) {
        log.info("guildQuit event=",event.getTopic());
        PlayerRole playerRole = ServiceManager.getPlayerService().setRoleGuild(event.getRoleID(), 0);
        playerRole.setGuildScore(0);
        playerRole.setPost(0);
        SpringContext.getBean(PlayerRoleDao.class).cacheUpdate(playerRole, event.getRoleID());
    }

    /**
     * 商会接受任务
     * @param event
     */
    public void guildAcceptTask(GuildAcceptTaskEvent event) {
        log.info("guildAcceptTask event=",event.getTopic());
        PlayerRoleDao playerRoleDao = SpringContext.getBean(PlayerRoleDao.class);
        PlayerRole playerRole = ServiceManager.getPlayerService().getPlayer(event.getRoleID());
        if((playerRole == null)||(playerRole.getGuildId() != event.getGuildID()))return;
        ConfigTasksConf conf = ConfManager.getInstance().getConfigTasksConf();
        if(conf == null){
            throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
        }
    	ConfigTasks configTasks = conf.getTask(event.getTaskID());
        GuildTask guildTask = new GuildTask(event.getRoleID());
        guildTask.setGuildID(event.getGuildID());
        guildTask.setTaskID(event.getTaskID());
        guildTask.setIndex(event.getIndex());
        guildTask.setActionType(configTasks.getActionType());
        guildTask.setActionTime(0);
        guildTask.setActionType1(configTasks.getActionType1());
        guildTask.setActionTime1(0);
        guildTask.setFirst(0);
        guildTask.setState(TaskState.accept.getState());
        guildTask.setNeedItem(configTasks.getNeedItem());
        guildTask.setCurItem("");
        guildTask.setLastLoginTime(0L);
        GuildTaskDao guildTaskDao = SpringContext.getBean(GuildTaskDao.class);
        guildTaskDao.cacheInsert(guildTask, event.getRoleID());

    	ServiceManager.getCommonService().setAcceptTypeTask(event.getRoleID(), ETaskType.Guild_VALUE, event.getTaskID());
        EventManager.postTaskUpdateEvent(event.getRoleID(), ETaskType.Guild_VALUE);
        EventManager.commitRoleEvent(event.getRoleID());
    }
    
    /**
     * 做任务行为
     * @param event
     */
    public void taskAction(TaskActionEvent event) {
        log.info("taskAction event=",event.getTopic());
        SpringContext.getBean(TaskHandler.class).doTaskAction(event.getRoleID(), event.getActionEnum(), event.getActionTime());
    }

    /**
     * 好友互动物品
     * @param roleID
     */
	public void syncItemInteract(long roleID) {
        log.info("syncItemInteract roleID=",roleID);
		PlayerItemInteractHistoryDao playerItemInteractHistoryDao = SpringContext.getBean(PlayerItemInteractHistoryDao.class);
		ServiceManager.getItemService().doItemInteractLog(roleID, itemInteractLog -> {
			PlayerItemInteractHistory playerItemInteractHistory = new PlayerItemInteractHistory(roleID);
			playerItemInteractHistory.setItemID(itemInteractLog.getItemID());
			playerItemInteractHistory.setItemCount(itemInteractLog.getItemCount());
			playerItemInteractHistory.setInteractRoleID(itemInteractLog.getInteractRoleID());
			playerItemInteractHistory.setPs(itemInteractLog.getPs());
			playerItemInteractHistory.setCreateTime(new Date(itemInteractLog.getTime()));
			playerItemInteractHistoryDao.cacheInsert(playerItemInteractHistory, roleID);
        });
	}

}
