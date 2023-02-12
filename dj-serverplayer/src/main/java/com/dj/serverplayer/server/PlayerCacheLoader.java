package com.dj.serverplayer.server;

import com.dj.domain.entity.player.*;
import com.dj.domain.entity.player.item.*;
import com.dj.domain.entity.player.task.PlayerTask1;
import com.dj.domain.entity.player.task.PlayerTask2;
import com.dj.domain.entity.player.task.PlayerTask3;
import com.dj.domain.entity.player.task.PlayerTask4;
import com.dj.domain.util.StringUtil;
import com.dj.domain.util.Utility;
import com.dj.domain.util.lib.QueryParamMap;
import com.dj.protobuf.CommonException;
import com.dj.protobuf.ErrorIDOuterClass.ErrorID;
import com.dj.serverapi.ServiceProvider;
import com.dj.serverapi.dao.*;
import com.dj.serverapi.dao.item.*;
import com.dj.serverapi.dao.task.PlayerTask1Dao;
import com.dj.serverapi.dao.task.PlayerTask2Dao;
import com.dj.serverapi.dao.task.PlayerTask3Dao;
import com.dj.serverapi.dao.task.PlayerTask4Dao;
import com.dj.servercore.db.cache.IEntityCache;
import com.dj.servercore.db.cache.IEntityCacheLoader;
import com.dj.servercore.spring.SpringContext;
import com.dj.serverplayer.handler.FriendHandler;
import com.dj.serverplayer.manager.DataManager;
import com.dj.serverplayer.manager.ServiceManager;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author zcq
 * @ClassName: PlayerCacheLoader
 * @Description: 玩家缓存加载器
 * @date 2019年6月25日
 */
@Slf4j
@Component("playerCacheLoader")
public class PlayerCacheLoader implements IEntityCacheLoader {

    @Autowired
    public PlayerRoleDao playerRoleDao;
    @Autowired
    public PlayerFactoryDao playerFactoryDao;
    @Autowired
    public PlayerItem1Dao playerItem1Dao;
    @Autowired
    public PlayerItem2Dao playerItem2Dao;
    @Autowired
    public PlayerItem3Dao playerItem3Dao;
    @Autowired
    public PlayerItem4Dao playerItem4Dao;
    @Autowired
    public PlayerItem5Dao playerItem5Dao;
    @Autowired
    public PlayerItem6Dao playerItem6Dao;
    @Autowired
    public PlayerItem7Dao playerItem7Dao;
    @Autowired
    public PlayerItem100Dao playerItem100Dao;
    @Autowired
    public PlayerFriendDao playerFriendDao;
    @Autowired
    public PlayerVerifyDao playerVerifyDao;
    @Autowired
    public PlayerVerifyHistoryDao playerVerifyHistoryDao;
    @Autowired
    public PlayerGuideDao playerGuideDao;
    @Autowired
    public PlayerObstacleDao playerObstacleDao;
    @Autowired
    public PlayerShowTableDao playerShowTableDao;
    @Autowired
    public PlayerShowTableMoneyDao playerShowTableMoneyDao;
    @Autowired
    public PlayerManufactureDao playerManufactureDao;
    @Autowired
    public PlayerCollectionDao playerCollectionDao;
    @Autowired
    public PlayerFarmDao playerFarmDao;
    @Autowired
    public PlayerTask1Dao playerTask1Dao;
	@Autowired
	public PlayerTask2Dao playerTask2Dao;
	@Autowired
	public PlayerTask3Dao playerTask3Dao;
	@Autowired
	public PlayerTask4Dao playerTask4Dao;
	@Autowired
	public PlayerBookDao  playerBookDao;
	@Autowired
	public PlayerNpcDao playerNpcDao;
	@Autowired
	public PlayerItemInteractHistoryDao playerItemInteractHistoryDao;
	@Autowired
	public PlayerLeaveHistoryDao playerLeaveHistoryDao;
    @Autowired
    public PlayerGameScoreRankDao playerGameScoreRankDao;

    @Override
    public void loadEntityCache(long identity, IEntityCache entityCache) {
        log.info("identity {}", identity);
        // 角色
        PlayerRole playerRole = ServiceProvider.getPlayerService().getPlayer(identity);
        if(playerRole == null) {
            QueryParamMap queryParams = new QueryParamMap();
            queryParams.put("roleID",identity);
            playerRole = playerRoleDao.cacheSelect(queryParams, identity);
            if (playerRole == null) {
                throw new CommonException(ErrorID.COMMON_DATA_ERROR);
            }
        }
        if (StringUtil.isEmpty(playerRole.getSignature())) {
            playerRole.setSignature("一起来寻宝吧");
        }
        playerRole.setOnline(true);
        ServiceManager.getPlayerService().setPlayer(identity, playerRole);
        entityCache.addModelData(playerRole, PlayerRole.class);
        // 建筑
        List<PlayerFactory> factorys = playerFactoryDao.readDbData(identity);
        if(factorys == null) {
            factorys = new ArrayList<>();
        }
        entityCache.addModelData(factorys, PlayerFactory.class);
        ServiceManager.getGameService().setFactory(identity, factorys);
        // 地图碎片临时处理
        // 植物
        List<PlayerItem1> items1 = playerItem1Dao.readDbData(identity);
        if(items1 == null) {
            items1 = new ArrayList<>();
        }
        entityCache.addModelData(items1, PlayerItem1.class);
        setItemCount(identity, items1);
        // 动物
        List<PlayerItem2> items2 = playerItem2Dao.readDbData(identity);
        if(items2 == null) {
            items2 = new ArrayList<>();
        }
        entityCache.addModelData(items2, PlayerItem2.class);
        setItemCount(identity, items2);
        // 食品
        List<PlayerItem3> items3 = playerItem3Dao.readDbData(identity);
        if(items3 == null) {
            items3 = new ArrayList<>();
        }
        entityCache.addModelData(items3, PlayerItem3.class);
        setItemCount(identity, items3);
        // 工业
        List<PlayerItem4> items4 = playerItem4Dao.readDbData(identity);
        if(items4 == null) {
            items4 = new ArrayList<>();
        }
        entityCache.addModelData(items4, PlayerItem4.class);
        setItemCount(identity, items4);
        // 收集品
        List<PlayerItem5> items5 = playerItem5Dao.readDbData(identity);
        if(items5 == null) {
            items5 = new ArrayList<>();
        }
        entityCache.addModelData(items5, PlayerItem5.class);
        setItemCount(identity, items5);
        // 道具
        List<PlayerItem6> items6 = playerItem6Dao.readDbData(identity);
        if(items6 == null) {
            items6 = new ArrayList<>();
        }
        entityCache.addModelData(items6, PlayerItem6.class);
        setItemCount(identity, items6);
        // 宝贝
        List<PlayerItem7> items7 = playerItem7Dao.readDbData(identity);
        if(items7 == null) {
            items7 = new ArrayList<>();
        }
        entityCache.addModelData(items7, PlayerItem7.class);
        setItemCount(identity, items7);
        // 特殊物品
        List<PlayerItem100> items100 = playerItem100Dao.readDbData(identity);
        if(items100 == null) {
            items100 = new ArrayList<>();
        }
        entityCache.addModelData(items100, PlayerItem100.class);
        setItemCount(identity, items100);

        // 更新缓存道具
        try {
            DataManager.INSTANCE.syncItem(identity);
        } catch (CommonException e) {
            String error = Utility.getTraceString(e);
            log.error("msg {}, error {}", e.getMessage(), error);
            //WechatUtil.writeActionException(AbsServer.getServerConfig().getTag(), AbsServer.getServerConfig().getName(), AbsServer.getServerConfig().getId(), e.getMessage(), error);
        }
        // 鉴定
        List<PlayerVerify> verifys = playerVerifyDao.readDbData(identity);
        if(verifys == null) {
            verifys = new ArrayList<>();
        }
        entityCache.addModelData(verifys, PlayerVerify.class);
        ServiceManager.getVerifyService().setVerifyQueue(identity, verifys);
        // 鉴定
        List<PlayerVerifyHistory> verifyHistories = playerVerifyHistoryDao.readDbData(identity);
        if(verifyHistories == null) {
            verifyHistories = new ArrayList<>();
        }
        entityCache.addModelData(verifyHistories, PlayerVerifyHistory.class);
        // 更新待揭晓
        ServiceManager.getVerifyService().updateVerify(identity, value -> {
            playerVerifyDao.cacheUpdate(value, identity);
            // 添加历史记录
            List<PlayerVerifyHistory> historyList = value.getHistoryList();
        	if(historyList != null) {
        		for (PlayerVerifyHistory playerVerifyHistory : historyList) {
        			playerVerifyHistoryDao.cacheInsert(playerVerifyHistory, playerVerifyHistory.getRoleID());
        		}
        	}
        });
        // 好友
        List<PlayerFriend> friends = playerFriendDao.readDbData(identity);
        if(friends == null) {
            friends = new ArrayList<>();
        }
        entityCache.addModelData(friends, PlayerFriend.class);

        // 同步好友行为
        ServiceProvider.getFriendService().doAction(identity, value -> {
            if (value.getAction() == 1) {
                SpringContext.getBean(FriendHandler.class).friendApproveSync(identity, value.getRoleID(), value.getApplyType(), value.getApplyTime());
                SpringContext.getBean(FriendHandler.class).friendApproveSync(value.getRoleID(), identity, value.getApplyType(), value.getApplyTime());
            } else {
                if(value.getId() > 0) {
                    playerFriendDao.cacheDelete(value.getId(), identity);
                }
            }
        });
        // 新手引导
        List<PlayerGuide> guides = playerGuideDao.readDbData(identity);
        if(guides == null) {
            guides = new ArrayList<>();
        }
        entityCache.addModelData(guides, PlayerGuide.class);
        // 沙漠
        List<PlayerObstacle> obstacles = playerObstacleDao.readDbData(identity);
        if(obstacles == null) {
            obstacles = new ArrayList<>();
        }
        entityCache.addModelData(obstacles, PlayerObstacle.class);
        ServiceManager.getGameService().setObstacle(identity, obstacles);
        // 展厅
        List<PlayerShowTable> showTables = playerShowTableDao.readDbData(identity);
        if(showTables == null) {
            showTables = new ArrayList<>();
        }
        entityCache.addModelData(showTables, PlayerShowTable.class);
        ServiceManager.getShowTableService().setShowTables(identity, showTables);
        // 馆藏
        List<PlayerShowTableMoney> showTableMoneys = playerShowTableMoneyDao.readDbData(identity);
        if(showTableMoneys == null) {
            showTableMoneys = new ArrayList<>();
        }
        entityCache.addModelData(showTableMoneys, PlayerShowTableMoney.class);
        // 制作
        List<PlayerManufacture> manufactures = playerManufactureDao.readDbData(identity);
        if(manufactures == null) {
            manufactures = new ArrayList<>();
        }
        entityCache.addModelData(manufactures, PlayerManufacture.class);
        // 图鉴
        List<PlayerCollection> collections = playerCollectionDao.readDbData(identity);
        if(collections == null) {
            collections = new ArrayList<>();
        }
        entityCache.addModelData(collections, PlayerCollection.class);
        // 农场
        List<PlayerFarm> farms = playerFarmDao.readDbData(identity);
        if(farms == null) {
            farms = new ArrayList<>();
        }
        entityCache.addModelData(farms, PlayerFarm.class);
        //ServiceManager.getParkService().setFarm(identity, farms);
        // 成长任务
        List<PlayerTask1> tasks1 = playerTask1Dao.readDbData(identity);
        if(tasks1 == null) {
            tasks1 = new ArrayList<>();
        }
        entityCache.addModelData(tasks1, PlayerTask1.class);
        // 每日任务
        List<PlayerTask2> tasks2 = playerTask2Dao.readDbData(identity);
        if(tasks2 == null) {
            tasks2 = new ArrayList<>();
        }
        entityCache.addModelData(tasks2, PlayerTask2.class);
        // 月度任务
        List<PlayerTask3> tasks3 = playerTask3Dao.readDbData(identity);
        if(tasks3 == null) {
            tasks3 = new ArrayList<>();
        }
        entityCache.addModelData(tasks3, PlayerTask3.class);
        // 商会任务
        List<PlayerTask4> tasks4 = playerTask4Dao.readDbData(identity);
        if(tasks4 == null) {
            tasks4 = new ArrayList<>();
        }
        entityCache.addModelData(tasks4, PlayerTask4.class);
        // 图鉴
        List<PlayerBook> books = playerBookDao.readDbData(identity);
        if(books == null) {
            books = new ArrayList<>();
        }
        entityCache.addModelData(books, PlayerBook.class);
        // npc
        List<PlayerNpc> npcs = playerNpcDao.readDbData(identity);
        if(npcs == null) {
            npcs = new ArrayList<>();
        }
        entityCache.addModelData(npcs, PlayerNpc.class);
        // 好友互动物品历史记录
        List<PlayerItemInteractHistory> itemInteractHistories = playerItemInteractHistoryDao.readDbData(identity);
        if(itemInteractHistories == null) {
            itemInteractHistories = new ArrayList<>();
        }
        entityCache.addModelData(itemInteractHistories, PlayerItemInteractHistory.class);
        // 更新好友互动物品
        DataManager.INSTANCE.syncItemInteract(identity);
        // 离开历史记录
        List<PlayerLeaveHistory> leaveHistories = playerLeaveHistoryDao.readDbData(identity);
        if(leaveHistories == null) {
            leaveHistories = new ArrayList<>();
        }
        entityCache.addModelData(leaveHistories, PlayerLeaveHistory.class);
        // 玩家游戏积分排行
        List<PlayerGameScoreRank>  playerGameScoreRanks = playerGameScoreRankDao.readDbData(identity);
        if(playerGameScoreRanks == null) {
            playerGameScoreRanks = new ArrayList<>();
        }
        entityCache.addModelData(playerGameScoreRanks, PlayerGameScoreRank.class);
    }

    /**
     * 加载物品和数量到内存
     * @param roleID
     * @param items
     */
	private void setItemCount(long roleID, List<? extends IPlayerItem> items) {
        Map<Integer, Long> pieceMap = Maps.newHashMap();
		//ConfigRobCfgConf conf = ConfManager.getInstance().getConfigRobCfgConf();
        //if(conf == null){
        //    throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
        //}
		//Set<Integer> mapPieceSet = conf.getMapPieceSet();
		for (IPlayerItem item : items) {
			//if(mapPieceSet.contains(item.getItemID())) {
				pieceMap.put(item.getItemID(), item.getItemCount());
			//}
		}
		if(pieceMap.size() > 0) {
			ServiceManager.getItemService().setItemCount(roleID, pieceMap);
		}
	}
}
