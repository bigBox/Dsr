package com.dj.serverapi.service;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import com.dj.domain.data.MonthCard;
import com.dj.domain.data.NpcSkill;
import com.dj.protobuf.buffer.EDrawTodayType;
import com.dj.serverapi.redis.model.BuffModel;
import com.dj.serverapi.service.inf.IBuffService;
import com.dj.servercore.redis.base.BaseService;
import com.dj.domain.util.DateUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BuffServiceImpl extends BaseService implements IBuffService {

    @Override
    public MonthCard getMonthCard(long roleID) {
        return getReadModel(roleID, BuffModel.class).getMonthCard();
    }

    @Override
    public MonthCard updateMonthCardTime(long roleID, long count) {
        BuffModel model = getWriteModel(roleID, BuffModel.class);
        MonthCard monthCard = model.getMonthCard();
        if (monthCard == null) {
            monthCard = new MonthCard();
            model.setMonthCard(monthCard);
        }
        Date endTime;
        if (monthCard.getEndTime() < System.currentTimeMillis()) {
            endTime = DateUtil.plusNow(TimeUnit.DAYS, (int)(30 * count));
        } else {
            endTime = DateUtil.plusTime(new Date(monthCard.getEndTime()), TimeUnit.DAYS, (int)(30 * count));
        }
        monthCard.setEndTime(endTime.getTime());
        monthCard.setCount(monthCard.getCount()+count);
        log.info("roleID {}, monthCard  count {}, endTime {}", roleID, count, DateUtil.formatDate(endTime, DateUtil.STYLE4));
        return monthCard;
    }

    @Override
    public MonthCard updateMonthCardDraw(long roleID, EDrawTodayType type, boolean draw) {
        BuffModel model = getWriteModel(roleID, BuffModel.class);
        MonthCard monthCard = model.getMonthCard();
        if(type == EDrawTodayType.Login) {
        	monthCard.setDrawedToday(draw);
        }else if(type == EDrawTodayType.MonthCard) {
        	monthCard.setMonthCardDrawedToday(draw);
        }
        return monthCard;
    }

	@Override
	public void repairMonthCard(long roleID) {
		BuffModel model = getWriteModel(roleID, BuffModel.class);
        MonthCard monthCard = model.getMonthCard();
        if (monthCard == null) {
            monthCard = new MonthCard();
            model.setMonthCard(monthCard);
        }
        monthCard.setCount(1);
        monthCard.setEndTime(DateUtil.plusNow(TimeUnit.DAYS, 31).getTime());
	}

	@Override
	public NpcSkill getNpcSkill(long roleID) {
		return getReadModel(roleID, BuffModel.class).getNpcSkill();
	}
	
	@Override
	public void setNpcSkill(long roleID, int npcID, int skillID) {
		BuffModel model = getWriteModel(roleID, BuffModel.class);
		model.setNpcSkill(npcID, skillID);
	}
}
