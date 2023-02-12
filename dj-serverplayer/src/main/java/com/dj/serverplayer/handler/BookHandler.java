package com.dj.serverplayer.handler;

import com.dj.domain.config.ConfigBook;
import com.dj.domain.config.ConfigCollectionItems;
import com.dj.domain.config.ConfigItems;
import com.dj.domain.config.ConfigTasks;
import com.dj.domain.entity.player.PlayerBook;
import com.dj.domain.entity.player.task.PlayerTask1;
import com.dj.domain.enums.ItemColor;
import com.dj.domain.enums.ResourceBillEnum;
import com.dj.domain.enums.TaskActionEnum;
import com.dj.domain.enums.TaskState;
import com.dj.domain.util.collection.MapUtil;
import com.dj.domain.util.lib.QueryParamMap;
import com.dj.protobuf.CommonException;
import com.dj.protobuf.ErrorIDOuterClass;
import com.dj.protobuf.ErrorIDOuterClass.ErrorID;
import com.dj.protobuf.book.*;
import com.dj.protobuf.task.ETaskType;
import com.dj.servercore.conf.ConfigBookConf;
import com.dj.servercore.conf.ConfigCollectionItemsConf;
import com.dj.servercore.conf.ConfigItemsConf;
import com.dj.serverplayer.handler.base.BaseHandler;
import com.dj.serverplayer.manager.ConfManager;
import com.dj.serverplayer.manager.EventManager;
import com.dj.serverplayer.manager.ServiceManager;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.MapUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: BookHandler  
 * @Description: 图鉴业务处理
 * @author zcq
 * @date 2020年9月17日
 */
@Component
@Slf4j
public class BookHandler extends BaseHandler {

	/**
	 * 请求图鉴所有类型
	 * @param roleID
	 * @param builder
	 */
	public void bookAllType(long roleID, BookAllTypeRsp.Builder builder) {
		ConfigBookConf conf = ConfManager.getInstance().getConfigBookConf();
		if(conf == null){
			log.error("bookAllType ConfigBookConf conf == null");
			throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
		}
		// 总百分比
		Map<Integer, ConfigBook> bookMap = conf.getBookMap();
		List<PlayerBook> bookList = playerBookDao.cacheLoadAll(roleID);
		if(bookList != null && bookList.size() > 0) {
			int totalRatio = (int) Math.round((double) bookList.size() / bookMap.size() * 100);
			builder.setTotalRatio(totalRatio);
			// 每种类型图鉴拥有百分比
			Map<Integer, Integer> typeMap = Maps.newHashMapWithExpectedSize(3);
			for (PlayerBook playerBook : bookList) {
				MapUtil.fundInt(typeMap, playerBook.getType(), 1);
			}
			for (BookType type : BookType.values()) {
				builder.putTypeMap(type.getNumber(), (int) Math.round((double) MapUtils.getIntValue(typeMap, type.getNumber()) / conf.getBookType(type.getNumber()).size() * 100));
			}
		}
	}

	/**
	 * 请求指定类型的图鉴信息
	 * @param roleID
	 * @param req
	 * @param builder
	 */
	public void bookInfo(long roleID, BookInfoReq req, BookInfoRsp.Builder builder) {
		ConfigBookConf conf = ConfManager.getInstance().getConfigBookConf();
		if(conf == null){
			log.error("bookInfo ConfigBookConf conf == null");
			throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
		}
		ConfigCollectionItemsConf itemsConf = ConfManager.getInstance().getConfigCollectionItemsConf();
		if(itemsConf == null){
			log.error("bookInfo ConfigCollectionItemsConf itemsConf == null");
			throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
		}
		List<BookType> types = Lists.newArrayListWithCapacity(BookType.values().length);
		if(req.getTypeCount() == 0) {
			for(BookType type : BookType.values()) {
				types.add(type);
			}
		}else {
			for(BookType type : req.getTypeList()) {
				types.add(type);
			}
		}
		for(BookType type : types) {
			List<ConfigBook> bookList = conf.getBookType(type.getNumber());
			BookInfo.Builder info = BookInfo.newBuilder();
			int haveCount = 0;
			for(ConfigBook config : bookList) {
				info.setType(type);
				info.setBookId(config.getBookID());
				QueryParamMap queryParams = new QueryParamMap();
				queryParams.put("roleID",roleID);
				queryParams.put("bookID", config.getBookID());
				PlayerBook book = playerBookDao.cacheSelect(queryParams, roleID);
				if(book != null) {
					info.setItemId(book.getItemID());
					info.setState(BookState.forNumber(book.getState()));
					info.setReward(book.getReward());
					haveCount++;
				}else {
					info.setItemId(config.getBookID());
					info.setState(BookState.No_Have);
					info.setReward(0);
				}
				ConfigCollectionItems collectionItems = itemsConf.getCollectionItems(config.getBookID());
				if(collectionItems != null) {
					info.setAntiqueId(collectionItems.getAntiqueId());
				}
				builder.addInfos(info.build());
			}
			int ratio = (int)Math.round((double)haveCount/bookList.size()*100);
			builder.putTypeMap(type.getNumber(), ratio);
		}
	}

	/**
	 * 领取图鉴标志新的奖励
	 * @param roleID
	 * @param req
	 * @param builder
	 */
	public void bookReward(long roleID, BookRewardReq req, BookRewardRsp.Builder builder) {
		QueryParamMap queryParams = new QueryParamMap();
		queryParams.put("roleID",roleID);
		queryParams.put("itemID", req.getItemId());
		PlayerBook book = playerBookDao.cacheSelect(queryParams, roleID);
		if(book == null) {
			throw new CommonException(ErrorID.BOOK_NO_HAVE);
		}
		if(book.getReward() == 0) {
			throw new CommonException(ErrorID.REWARD_RECEIVED);
		}
		book.setReward(book.getReward()-1);
		playerBookDao.cacheUpdate(book, roleID);
		addGold(roleID, 100, ResourceBillEnum.bookReward);
	}
	
	/**
	 * 修复图鉴数据
	 * @param roleID
	 */
	public void repairBook(long roleID) {
        ConfigBookConf bookConf = ConfManager.getInstance().getConfigBookConf();
		if(bookConf == null){
			log.error("repairBook ConfigBookConf bookConf == null");
			throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
		}
        ConfigItemsConf itemsConf = ConfManager.getInstance().getConfigItemsConf();
		if(itemsConf == null){
			log.error("repairBook ConfigItemsConf itemsConf == null");
			throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
		}
        Map<Integer, ConfigItems> itemMap = itemsConf.getItemMap();
        for(Map.Entry<Integer, ConfigItems> entry : itemMap.entrySet()) {
        	if(entry.getKey() == 2) {
        		continue;
        	}
        	int itemBookId = bookConf.getItemBook(entry.getKey());
        	if(itemBookId == 0) {
        		continue;
        	}
        	long itemCount = ServiceManager.getItemService().getItemCount(roleID, entry.getKey());
        	if(itemCount > 0) {
        		ConfigBook bookConfig = bookConf.getBook(itemBookId);
        		if(bookConfig == null) {
        			continue;
        		}
        		// 添加图鉴
				QueryParamMap queryParams = new QueryParamMap();
				queryParams.put("roleID",roleID);
				queryParams.put("bookID", itemBookId);
        		PlayerBook book = playerBookDao.cacheSelect(queryParams, roleID);
        		if(book == null) {
            		book = new PlayerBook(roleID);
            		//book.setId(BookHandler.readModuleID(TableID.TABLE_BOOK));
            		book.setType(bookConfig.getType());
            		book.setBookID(itemBookId);
            		book.setItemID(entry.getKey());
					book.setState(BookState.Grey_VALUE);
            		playerBookDao.cacheInsert(book, roleID);
        		}
        		int color = itemsConf.getItem(entry.getKey()).getColor();
				if(color == ItemColor.color2.getColor()) {
					book.setItemID(entry.getKey());
					book.setState(BookState.Color_VALUE);
				}
        		book.setReward(1);
        		playerBookDao.cacheUpdate(book, roleID);
        	}
        }
	}

	public void bookTurnPages(long roleID) {
		ConfigTasks configTasks = taskHandler.checkTaskAction(roleID, TaskActionEnum.BOOK_LIGHT_TREASURE1);
		if(configTasks != null) {
			QueryParamMap queryParams = new QueryParamMap();
			queryParams.put("roleID",roleID);
			queryParams.put("taskID", configTasks.getID());
			PlayerTask1 task = playerTask1Dao.cacheSelect(queryParams, roleID);
			if(configTasks.getType() == ETaskType.GrowUp_VALUE){
				// 任务完成状态
				task.setState(TaskState.complete.getState());
				taskHandler.updateTask(roleID, configTasks.getType(), task);
				playerService.updateGuideTaskState(roleID, task.getTaskID(), TaskState.complete.getState());
				EventManager.postTaskFinishEvent(roleID, task);
				EventManager.commitRoleEvent(roleID);
			}
			else if(configTasks.getType() == ETaskType.Guild_VALUE){
				// 任务完成状态
				task.setState(TaskState.complete.getState());
				taskHandler.updateTask(roleID, configTasks.getType(), task);
				taskHandler.guildTaskReward(roleID, task, configTasks);
				EventManager.postTaskFinishEvent(roleID, task);
				EventManager.commitRoleEvent(roleID);
			}
		}

	}
}
