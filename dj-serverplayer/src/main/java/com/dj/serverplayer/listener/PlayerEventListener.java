package com.dj.serverplayer.listener;

import com.dj.domain.config.ConfigBook;
import com.dj.domain.config.ConfigCollectionItems;
import com.dj.domain.config.ConfigItems;
import com.dj.domain.config.ConfigTasks;
import com.dj.domain.entity.player.PlayerBook;
import com.dj.domain.entity.player.task.ITask;
import com.dj.domain.enums.ItemColor;
import com.dj.domain.enums.PlayerAttrEnum;
import com.dj.domain.event.*;
import com.dj.domain.util.GsonUtil;
import com.dj.domain.util.ThreadUtil;
import com.dj.domain.util.Utility;
import com.dj.domain.util.lib.QueryParamMap;
import com.dj.protobuf.CommonException;
import com.dj.protobuf.ErrorIDOuterClass;
import com.dj.protobuf.ErrorIDOuterClass.ErrorID;
import com.dj.protobuf.book.BookInfo;
import com.dj.protobuf.book.BookState;
import com.dj.protobuf.book.BookType;
import com.dj.protobuf.book.BookUpdateNtf;
import com.dj.protobuf.collection.CollectionInfo;
import com.dj.protobuf.collection.CollectionItem;
import com.dj.protobuf.collection.CollectionState;
import com.dj.protobuf.collection.CollectionUpdateNtf;
import com.dj.protobuf.item.GridItem;
import com.dj.protobuf.item.ItemUpdateNtf;
import com.dj.protobuf.login.HeartbeatCfgNtf;
import com.dj.protobuf.login.PlayerAttrClientNtf;
import com.dj.protobuf.login.PlayerLoginInfo;
import com.dj.protobuf.login.RoleLoginNtf;
import com.dj.protobuf.task.ETaskType;
import com.dj.protobuf.task.TaskFinishNtf;
import com.dj.protobuf.task.TaskUpdateNtf;
import com.dj.serverapi.dao.task.PlayerTask1Dao;
import com.dj.serverapi.helper.OnlineHelper;
import com.dj.servercore.conf.ConfigBookConf;
import com.dj.servercore.conf.ConfigCollectionItemsConf;
import com.dj.servercore.conf.ConfigItemsConf;
import com.dj.servercore.conf.ConfigTasksConf;
import com.dj.servercore.event.BasePlayerEventListener;
import com.dj.servercore.spring.SpringContext;
import com.dj.serverplayer.handler.BookHandler;
import com.dj.serverplayer.handler.HomeHandler;
import com.dj.serverplayer.handler.TaskHandler;
import com.dj.serverplayer.helper.QueueHelper;
import com.dj.serverplayer.manager.ChannelManager;
import com.dj.serverplayer.manager.ConfManager;
import com.dj.serverplayer.manager.EventManager;
import com.dj.serverplayer.manager.ServiceManager;
import com.google.common.collect.Maps;
import com.google.common.eventbus.AllowConcurrentEvents;
import com.google.common.eventbus.Subscribe;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;

@Slf4j
public class PlayerEventListener extends BasePlayerEventListener {

	private static String BBS_REGISTER_URL = "%sapi/game/register?account=%s&password=%s&roleID=%s";
	private static String BBS_LOGIN_URL = "%sapi/game/login?account=%s&password=%s&roleID=%s";
	/**
     *	????????????????????????
     *
     * @param event
     */
    @Subscribe
    @AllowConcurrentEvents
    public void listenRegisterEvent(RegisterEvent event) {
        //try {
        	//OkHttpUtil.get(String.format(BBS_REGISTER_URL, SocketServer.getServerConfig().getBbsUrl(), event.getAccount(), event.getPassword(), event.getRoleID()));
			//String url = String.format(BBS_REGISTER_URL, SocketServer.getServerConfig().getBbsUrl(), event.getAccount(), event.getPassword(), event.getRoleID());
			//HttpClient httpClient = HttpClientBuilder.create().build();
			//HttpGet request = new HttpGet(url);
			//HttpResponse response = httpClient.execute(request);
			//if (response.getStatusLine().getStatusCode() == 200) {
			//	String result = EntityUtils.toString(response.getEntity());
			//	log.info(result);
			//}
        //} catch (Exception e) {
        //    log.error(Utility.getTraceString(e));
        //} finally {
        //    returnEvent(event);
        //}
    }
	
    /**
     *	????????????????????????
     *
     * @param event
     */
    @Subscribe
    @AllowConcurrentEvents
    public void listenLoginEvent(LoginEvent event) {
        try {
            ThreadUtil.sleep(500);
            if(event.isLogin()) {
            	// ????????????????????????
            	PlayerAttrClientNtf.Builder playerAttrClientNtf = PlayerAttrClientNtf.newBuilder();
            	Map<String, Long> intDic = Maps.newHashMapWithExpectedSize(5);
            	intDic.put(PlayerAttrEnum.LEVEL.getKey(), (long)event.getPlayerRole().getLevel());
            	intDic.put(PlayerAttrEnum.EXP.getKey(), event.getPlayerRole().getExperience());
            	intDic.put(PlayerAttrEnum.GOLD.getKey(), event.getPlayerRole().getGold());
            	intDic.put(PlayerAttrEnum.STAMINA.getKey(), event.getPlayerRole().getStamina());
            	intDic.put(PlayerAttrEnum.DIAMOND.getKey(), event.getPlayerRole().getDiamond());
            	intDic.put(PlayerAttrEnum.RENOWN.getKey(), event.getPlayerRole().getRenown());
            	intDic.put(PlayerAttrEnum.RENOWN_LEVEL.getKey(), (long)event.getPlayerRole().getRenownLevel());
            	intDic.put(PlayerAttrEnum.ECOLOGY.getKey(), event.getPlayerRole().getEcology());
            	intDic.put(PlayerAttrEnum.BOOM.getKey(), event.getPlayerRole().getBoom());
            	intDic.put(PlayerAttrEnum.SHOWTABLE.getKey(), event.getPlayerRole().getShowTable());
            	intDic.put(PlayerAttrEnum.SHOWTABLE_LEVEL.getKey(), (long)event.getPlayerRole().getShowTableLevel());
            	intDic.put(PlayerAttrEnum.GUILDSCORE.getKey(), event.getPlayerRole().getGuildScore());
            	intDic.put(PlayerAttrEnum.ACHIEVEMENT.getKey(), event.getPlayerRole().getAchievement());
            	intDic.put(PlayerAttrEnum.ACHIEVEMENT_LEVEL.getKey(), (long)event.getPlayerRole().getAchievementLevel());
            	playerAttrClientNtf.putAllIntDic(intDic);
            	PlayerLoginInfo.Builder playerLoginInfo = PlayerLoginInfo.newBuilder();
            	playerLoginInfo.setNtf(playerAttrClientNtf);
            	RoleLoginNtf.Builder roleLoginNtf = RoleLoginNtf.newBuilder();
            	roleLoginNtf.setErrorID(ErrorID.OK);
            	Map<Integer, PlayerLoginInfo> infosMap = Maps.newHashMapWithExpectedSize(5);
            	infosMap.put(1, playerLoginInfo.build());
            	roleLoginNtf.putAllInfos(infosMap);
            	// ???????????????
            	Map<String, Integer> clientData = ServiceManager.getCommonService().getClientData(event.getRoleID());
            	roleLoginNtf.putAllClientData(clientData);
            	ChannelManager.getInstance().sendPlayerInitToGate(event.getPlayerRole().getGateServerID(), event.getRoleID(), roleLoginNtf.build(), event.getChannelID());
            }
            // ????????????
            OnlineHelper.getInstance().addOnline(event.getPlayerRole().getGateServerID(), event.getAccount(), event.getPassword(), event.getIp(), event.getRoleID(), 
            		event.getPlayerRole().getTodayOnline());
            // ????????????
            QueueHelper.getInstance().addGrazeQueue(event.getRoleID());
			//QueueHelper.getInstance().addTravelQueue(event.getRoleID());
            // ?????????????????????????????????????????????
            HeartbeatCfgNtf.Builder heartNtf = HeartbeatCfgNtf.newBuilder();
            heartNtf.setInterval(60);
            ChannelManager.getInstance().sendPlayerBasicToGate(event.getPlayerRole().getGateServerID(), event.getRoleID(), heartNtf.build());
            // ????????????
            //OkHttpUtil.get(String.format(BBS_REGISTER_URL, SocketServer.getServerConfig().getBbsUrl(), event.getAccount(), event.getPassword(), event.getRoleID()));
			//String url = String.format(BBS_LOGIN_URL, SocketServer.getServerConfig().getBbsUrl(), event.getAccount(), event.getPassword(), event.getRoleID());
			//HttpClient httpClient = HttpClientBuilder.create().build();
			//HttpGet request = new HttpGet(url);
			//HttpResponse response = httpClient.execute(request);
			//if (response.getStatusLine().getStatusCode() == 200) {
			//	String result = EntityUtils.toString(response.getEntity());
			//	log.info(result);
			//}
        } catch (Exception e) {
            log.error(Utility.getTraceString(e));
			returnEvent(event);
        }
    }

    /**
     *	??????????????????
     *
     * @param event
     */
    @Override
    public void listenerPlayerLevelUpEvent(PlayerLevelUpEvent event) {
        try {
        	List<? extends ITask> list = SpringContext.getBean(PlayerTask1Dao.class).flushLevelTask(event.getRoleID(), event.getNowLevel());
        	if(list != null && list.size() > 0) {
        		TaskUpdateNtf.Builder taskUpdateNtf = TaskUpdateNtf.newBuilder();
        		taskUpdateNtf.setType(ETaskType.GrowUp);
        		list.forEach(value -> {
        			taskUpdateNtf.addTasks(value.toTaskInfo());
        		});
                int gateID = OnlineHelper.getInstance().getOnlineGateID(event.getRoleID());
                ChannelManager.getInstance().sendPlayerBasicToGate(gateID, event.getRoleID(), taskUpdateNtf.build());
        	}
        	log.info(GsonUtil.toJson(event));
        } catch (Exception e) {
            log.error(Utility.getTraceString(e));
			returnEvent(event);
        }
    }

    /**
     *	????????????????????????
     *
     * @param event
     */
    @Subscribe
    @AllowConcurrentEvents
    public void listenPlayerItemEvent(PlayerItemEvent event) {
        try {
        	int gateID = OnlineHelper.getInstance().getOnlineGateID(event.getRoleID());
        	// ???????????????
        	if(event.isPost2Client()) {
        		ItemUpdateNtf.Builder builder = ItemUpdateNtf.newBuilder();
        		builder.setVersion("");
        		builder.setCol(event.getCol());
        		GridItem.Builder itemBuilder = GridItem.newBuilder();
        		builder.addUpdateData(event.getItem().toGridItem(itemBuilder));
        		builder.setVisible(event.isVisible());
        		ChannelManager.getInstance().sendPlayerBasicToGate(gateID, event.getRoleID(), builder.build());
        	}
            // ????????????
            ConfigCollectionItemsConf collectionItemsConf = ConfManager.getInstance().getConfigCollectionItemsConf();
			if(collectionItemsConf == null){
				throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
			}
			ConfigCollectionItems collectionItem = collectionItemsConf.getCollectionItems(event.getItem().getItemID());
            if(collectionItem != null) {
            	CollectionInfo.Builder infoBuilder = CollectionInfo.newBuilder();
            	CollectionItem.Builder collectionItemBuilder = CollectionItem.newBuilder();
            	infoBuilder.setState(CollectionState.Gather_All);
            	infoBuilder.setId(collectionItem.getAntiqueId());
            	HomeHandler homeHandler = SpringContext.getBean(HomeHandler.class);
            	Map<Integer, ConfigCollectionItems> antique = collectionItemsConf.getAntique(collectionItem.getAntiqueId());
            	for(Map.Entry<Integer, ConfigCollectionItems> itemEntry : antique.entrySet()) {
            		homeHandler.setCollectionItem(event.getRoleID(), itemEntry.getValue().getID(), infoBuilder, collectionItemBuilder);
            	}
        		CollectionUpdateNtf.Builder collectionUpdateNtf = CollectionUpdateNtf.newBuilder();
        		collectionUpdateNtf.putInfos(collectionItem.getAntiqueId(), infoBuilder.build());
        		ChannelManager.getInstance().sendPlayerBasicToGate(gateID, event.getRoleID(), collectionUpdateNtf.build());
            }
            ConfigItemsConf itemsConf = ConfManager.getInstance().getConfigItemsConf();
			if(itemsConf == null){
				throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
			}
            // ????????????
            ConfigBookConf bookConf = ConfManager.getInstance().getConfigBookConf();
			if(bookConf == null){
				throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
			}
			ConfigItems items = itemsConf.getItem(event.getItem().getItemID());
			if(items == null){
				throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
			}
            int itemBookId = bookConf.getItemBook(items.getVerify());
        	if(itemBookId > 0) {
        		ConfigBook bookConfig = bookConf.getBook(itemBookId);
                if(bookConfig != null) {
                	BookHandler bookHandler = SpringContext.getBean(BookHandler.class);
                	if(event.isItemAdd()) {
                		// ????????????
						QueryParamMap queryParams = new QueryParamMap();
						queryParams.put("roleID",event.getRoleID());
						queryParams.put("bookID", itemBookId);
                		PlayerBook book = bookHandler.playerBookDao.cacheSelect(queryParams, event.getRoleID());
                		if(book == null) {
                    		book = new PlayerBook(event.getRoleID());
                    		//book.setId(BookHandler.readModuleID(TableID.TABLE_BOOK));
                    		book.setType(bookConfig.getType());
                    		book.setBookID(itemBookId);
                    		book.setItemID(event.getItem().getItemID());
                    		book.setState(BookState.Grey_VALUE);
                    		bookHandler.playerBookDao.cacheInsert(book, event.getRoleID());
                		}
                		int color = items.getColor();
        				if(color == ItemColor.color2.getColor()) {
        					book.setItemID(event.getItem().getItemID());
        					book.setState(BookState.Color_VALUE);
        				}
        				//else if(book.getState() != BookState.Color_VALUE){
        				//	book.setItemID(event.getItem().getItemID());
        				//	book.setState(BookState.Grey_VALUE);
        				//}
                		book.setReward(1);
                		bookHandler.playerBookDao.cacheUpdate(book, event.getRoleID());
                		// ??????????????????
						BookType type = BookType.forNumber(bookConfig.getType());
						if(type != null) {
							BookUpdateNtf.Builder ntfBuilder = BookUpdateNtf.newBuilder();
							BookInfo.Builder      info       = BookInfo.newBuilder();
							info.setType(type);
							info.setBookId(itemBookId);
							info.setItemId(event.getItem().getItemID());
							info.setState(BookState.forNumber(book.getState()));
							info.setReward(book.getReward());
							ntfBuilder.setBook(info.build());
							ChannelManager.getInstance().sendPlayerBasicToGate(gateID, event.getRoleID(), ntfBuilder.build());
						}
                	}
                }
        	}
        	
            // ??????????????????
            if(ConfManager.getInstance().getConfigRobCfgConf().getMapPieceSet().contains(event.getItem().getItemID())) {
            	ServiceManager.getItemService().setItemCount(event.getRoleID(), event.getItem().getItemID(), event.getItem().getItemCount());
            }
        } catch (Exception e) {
            log.error(Utility.getTraceString(e));
			returnEvent(event);
        }
    }

    /**
     *	????????????????????????
     *
     * @param event
     */
    @Subscribe
    @AllowConcurrentEvents
    public void listenerPlayerAttrEvent(PlayerAttrEvent event) {
        try {
            EventManager.postPlayerAttr(event.getRoleID());
        } catch (Exception e) {
            log.error(Utility.getTraceString(e));
			returnEvent(event);
        }
    }

    /**
     *	????????????????????????
     *
     * @param event
     */
    @Subscribe
    @AllowConcurrentEvents
    public void listenerTaskUpdateEvent(TaskUpdateEvent event) {
        try {
			log.info("listenerTaskUpdateEvent roleID={}, topic={}", event.getRoleID(), event.getTopic());
        	TaskHandler taskHandler = SpringContext.getBean(TaskHandler.class);
        	int gateID = OnlineHelper.getInstance().getOnlineGateID(event.getRoleID());
            TaskUpdateNtf.Builder taskUpdateNtf = TaskUpdateNtf.newBuilder();
            taskUpdateNtf.setType(ETaskType.forNumber(event.getTaskType()));
            taskUpdateNtf.addAllTasks(taskHandler.taskList(event.getRoleID(), event.getTaskType()));
            ChannelManager.getInstance().sendPlayerBasicToGate(gateID, event.getRoleID(), taskUpdateNtf.build());
        } catch (Exception e) {
            log.error(Utility.getTraceString(e));
			returnEvent(event);
        }
    }
    
    /**
     *	??????????????????????????????
     *
     * @param event
     */
    @Subscribe
    @AllowConcurrentEvents
    public void listenerTaskFinishEvent(TaskFinishEvent event) {
        try {
        	ConfigTasksConf conf = ConfManager.getInstance().getConfigTasksConf();
			if(conf == null){
				throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
			}
			log.info("listenerTaskFinishEvent roleID={}, topic={}", event.getRoleID(), event.getTopic());
        	ConfigTasks config = conf.getTask(event.getTask().getTaskID());
			OnlineHelper.getInstance().checkTaskFinishNtf(event.getRoleID(), config, ()->{
				TaskFinishNtf.Builder taskFinishNtf = TaskFinishNtf.newBuilder();
				taskFinishNtf.setTask(event.getTask().toTaskInfo());
				int gateID = OnlineHelper.getInstance().getOnlineGateID(event.getRoleID());
				ChannelManager.getInstance().sendPlayerBasicToGate(gateID, event.getRoleID(), taskFinishNtf.build());
			});
        } catch (Exception e) {
            log.error(Utility.getTraceString(e));
			returnEvent(event);
        }
    }

    /**
     *	??????????????????????????????
     *
     * @param event
     */
    @Subscribe
    @AllowConcurrentEvents
    public void listenerTaskActionEvent(TaskActionEvent event) {
        try {
			log.info("listenerTaskActionEvent roleID={}, topic={}", event.getRoleID(), event.getTopic());
        	SpringContext.getBean(TaskHandler.class).doTaskAction(event.getRoleID(), event.getActionEnum(), event.getActionTime());
        } catch (Exception e) {
            log.error(Utility.getTraceString(e));
			returnEvent(event);
        }
    }
    
    /**
     *	??????npc??????
     *
     * @param event
     */
    @Subscribe
    @AllowConcurrentEvents
    public void listenNpcSkillEvent(NpcSkillEvent event) {
        try {
        	if(event.getSkillID() == 7) {
        		//?????????????????????????????????????????????????????????5???---???????????????????????????
        		ServiceManager.getGameMineService().triggerNpcSkill(event.getRoleID());
        	}
        	else {
        		ServiceManager.getBuffService().setNpcSkill(event.getRoleID(), event.getNpcID(), event.getSkillID());
        	}
        	
        } catch (Exception e) {
            log.error(Utility.getTraceString(e));
			returnEvent(event);
        }
    }
}
