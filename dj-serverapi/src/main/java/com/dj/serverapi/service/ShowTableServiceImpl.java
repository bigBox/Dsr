package com.dj.serverapi.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.dj.domain.entity.player.PlayerShowTable;
import com.dj.domain.entity.player.PlayerShowTableInfo;
import com.dj.domain.entity.player.PlayerShowTableMoney;
import com.dj.domain.entity.robot.RobotShowTable;
import com.dj.domain.entity.robot.RobotShowTableMoney;
import com.dj.protobuf.CommonException;
import com.dj.protobuf.ErrorIDOuterClass.ErrorID;
import com.dj.serverapi.redis.model.RobotShowTableModel;
import com.dj.serverapi.redis.model.ShowTableInfoModel;
import com.dj.serverapi.redis.model.ShowTableModel;
import com.dj.serverapi.service.inf.IShowTableService;
import com.dj.servercore.redis.base.BaseService;
import com.dj.domain.util.DateUtil;
import com.dj.domain.util.inf.IArgumentRunnable;
import com.google.common.collect.Lists;

public class ShowTableServiceImpl extends BaseService implements IShowTableService {

    @Override
    public void setShowTables(long roleID, List<PlayerShowTable> showTables) {
        if(showTables != null) {
            ShowTableModel model = getWriteModel(roleID, ShowTableModel.class);
            model.setShowTables(showTables);
        }
    }

    @Override
    public Map<Integer, PlayerShowTable> getShowTable(long roleID, int type, int page) {
        ShowTableModel model = getReadModel(roleID, ShowTableModel.class);
        return model.getShowTable(type, page);
    }

    @Override
    public void showTablePutOn(long roleID, PlayerShowTable showTable) {
        ShowTableModel model = getWriteModel(roleID, ShowTableModel.class);
        model.showTablePutOn(showTable);
    }

    @Override
    public void showTablePutDown(long roleID, PlayerShowTable showTable) {
        ShowTableModel model = getWriteModel(roleID, ShowTableModel.class);
        model.showTablePutDown(showTable);
    }

    @Override
    public PlayerShowTableMoney getShowTableMoney(long roleID) {
        ShowTableModel model = getReadModel(roleID, ShowTableModel.class);
        return model.getShowTableMoney();
    }

    @Override
    public void setShowTableMoney(long roleID, PlayerShowTableMoney showTableMoney) {
        ShowTableModel model = getWriteModel(roleID, ShowTableModel.class);
        model.setShowTableMoney(showTableMoney);
    }

    @Override
    public PlayerShowTableMoney increaseShowTableMoney(long roleID, int type, int money) {
        ShowTableModel model = getWriteModel(roleID, ShowTableModel.class);
        PlayerShowTableMoney showTableMoney = model.getShowTableMoney();
        switch (type) {
            case 0:// 宝物，字画
                showTableMoney.setCol0Money(showTableMoney.getCol0Money() + money);
                break;
            case 1:// 水族馆
                showTableMoney.setCol1Money(showTableMoney.getCol1Money() + money);
                break;
            case 2:// 标本
                showTableMoney.setCol2Money(showTableMoney.getCol2Money() + money);
                break;
            case 3:// 字画（废弃）                                    
                showTableMoney.setCol3Money(showTableMoney.getCol3Money() + money);
                break;
        }
        return showTableMoney;
    }

    @Override
    public PlayerShowTableMoney decreaseShowTableMoney(long roleID, int type, int money) {
        ShowTableModel model = getWriteModel(roleID, ShowTableModel.class);
        PlayerShowTableMoney showTableMoney = model.getShowTableMoney();
        switch (type) {
            case 0:// 宝物，字画
            	if(showTableMoney.getCol0Money() < money) {
            		money = showTableMoney.getCol0Money();
            	}
                showTableMoney.setCol0Money(showTableMoney.getCol0Money() - money);
                break;
            case 1:// 水族馆
            	if(showTableMoney.getCol1Money() < money) {
            		money = showTableMoney.getCol1Money();
            	}
                showTableMoney.setCol1Money(showTableMoney.getCol1Money() - money);
                break;
            case 2:// 标本
            	if(showTableMoney.getCol2Money() < money) {
            		money = showTableMoney.getCol2Money();
            	}
                showTableMoney.setCol2Money(showTableMoney.getCol2Money() - money);
                break;
            case 3:// 字画（废弃）
            	if(showTableMoney.getCol3Money() < money) {
            		money = showTableMoney.getCol3Money();
            	}
                showTableMoney.setCol3Money(showTableMoney.getCol3Money() - money);
                break;
        }
        return showTableMoney;
    }

    @Override
    public int moneyDrawInfo(long roleID, int type) {
        ShowTableModel model = getReadModel(roleID, ShowTableModel.class);
        PlayerShowTableMoney showTableMoney = model.getShowTableMoney();
        Date colTime = null;
        switch (type) {
            case 0:// 宝物，字画
                colTime = showTableMoney.getCol0Time();
                break;
            case 1:// 水族馆
                colTime = showTableMoney.getCol1Time();
                break;
            case 2:// 标本
                colTime = showTableMoney.getCol2Time();
                break;
            case 3:// 字画（废弃）
                colTime = showTableMoney.getCol3Time();
                break;
        }
        if (colTime != null && DateUtil.isSameDay(colTime, DateUtil.getCurrentDate())) {
            return 1;
        }
        return 0;
    }

    @Override
    public int moneyDrawPrize(long roleID, int type, IArgumentRunnable<PlayerShowTableMoney> run) {
        int state = moneyDrawInfo(roleID, type);
        if (state == 1) {
            // 奖励已领取
            throw new CommonException(ErrorID.REWARD_RECEIVED);
        }
        ShowTableModel model = getWriteModel(roleID, ShowTableModel.class);
        PlayerShowTableMoney showTableMoney = model.getShowTableMoney();
        int money = 0;
        switch (type) {
            case 0:// 宝物，字画
                showTableMoney.setCol0Time(DateUtil.getCurrentDate());
                money = showTableMoney.getCol0Money();
                break;
            case 1:// 水族馆
                showTableMoney.setCol1Time(DateUtil.getCurrentDate());
                money = showTableMoney.getCol1Money();
                break;
            case 2:// 标本
                showTableMoney.setCol2Time(DateUtil.getCurrentDate());
                money = showTableMoney.getCol2Money();
                break;
            case 3:// 字画（废弃）
                showTableMoney.setCol3Time(DateUtil.getCurrentDate());
                money = showTableMoney.getCol3Money();
                break;
        }
        run.run(showTableMoney);
        return money;
    }

	@Override
	public void showTableSupport(long roleID, long friendID, Integer type) {
		ShowTableModel model = getWriteModel(roleID, ShowTableModel.class);
		Map<Long, List<Integer>> supportMap = model.getShowTableSupport();
		List<Integer> supportList = supportMap.get(friendID);
		if(supportList != null) {
			// 今天已经给好友点赞两次了，明天再来吧
			if(supportList.size() >= 2) {
				throw new CommonException(ErrorID.SUPPORT_TODAY_TWICE_LIMIT);
			}
			// 今天已点赞，明天再来吧
			if(supportList.contains(type)) {
				throw new CommonException(ErrorID.SUPPORT_LIMIT);
			}
		}else {
			supportList = Lists.newArrayListWithCapacity(3);
			supportMap.put(friendID, supportList);
		}
		supportList.add(type);
	}

    @Override
    public void setShowTableInfo(long roleID, PlayerShowTableInfo showTableInfo) {
        if(showTableInfo != null) {
            ShowTableInfoModel model = getWriteModel(roleID, ShowTableInfoModel.class);
            model.setShowTableInfo(showTableInfo);
        }
    }

    @Override
    public PlayerShowTableInfo getShowTableInfo(long roleID, int type, int page) {
        ShowTableInfoModel model = getReadModel(roleID, ShowTableInfoModel.class);
        return model.getShowTableInfo(page);
    }

    @Override
    public void setRobotShowTables(long roleID, List<RobotShowTable> showTables) {
        if(showTables != null) {
            RobotShowTableModel model = getWriteModel(roleID, RobotShowTableModel.class);
            model.setShowTables(showTables);
        }
    }

    @Override
    public Map<Integer, RobotShowTable> getRobotShowTable(long roleID, int type, int page) {
        RobotShowTableModel model = getReadModel(roleID, RobotShowTableModel.class);
        return model.getShowTable(type, page);
    }

    @Override
    public RobotShowTableMoney getRobotShowTableMoney(long roleID) {
        RobotShowTableModel model = getReadModel(roleID, RobotShowTableModel.class);
        return model.getShowTableMoney();
    }

    @Override
    public void setRobotShowTableMoney(long roleID, RobotShowTableMoney showTableMoney) {
        RobotShowTableModel model = getWriteModel(roleID, RobotShowTableModel.class);
        model.setShowTableMoney(showTableMoney);
    }
}
