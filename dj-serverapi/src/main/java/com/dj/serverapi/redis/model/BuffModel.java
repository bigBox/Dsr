package com.dj.serverapi.redis.model;

import com.dj.domain.RedisKeys;
import com.dj.domain.data.MonthCard;
import com.dj.domain.data.NpcSkill;
import com.dj.serverapi.redis.base.InitModel;
import com.dj.servercore.redis.RedisTemplate;
import com.dj.domain.util.DateUtil;

/**
 * @author zcq
 * @ClassName: BuffModel
 * @Description: buff 月卡
 * @date 2019年8月7日
 */
public class BuffModel extends InitModel {

    public BuffModel(Long roleID, RedisTemplate lockTemplate, RedisTemplate redisTemplate, Boolean lock) {
        super(RedisKeys.KEY_BUFF, roleID, lockTemplate, redisTemplate, lock);
    }

    @Override
    protected void init() {
    	MonthCard monthCard = new MonthCard(0, false, false, 0);
    	this.data.set(RedisKeys.KEY_BUFF_MONTH_CARD, monthCard);
        initTime();
        this.data.set(RedisKeys.KEY_BUFF_NPC_SKILL, new NpcSkill());
    }

    @Override
    protected void onLoadOver() {
        Long initTime = getInitTime();
        if (initTime == null) {
            initTime();
        }
        if (!DateUtil.isToday(getInitTime())) {
            resetInitTime();
            MonthCard monthCard = this.data.get(RedisKeys.KEY_BUFF_MONTH_CARD);
            if (monthCard != null) {
                monthCard.setDrawedToday(false);
                monthCard.setMonthCardDrawedToday(false);
            }
        }
        if(!this.data.isExists(RedisKeys.KEY_BUFF_NPC_SKILL)) {
        	this.data.set(RedisKeys.KEY_BUFF_NPC_SKILL, new NpcSkill());
        }
    }

    public MonthCard getMonthCard() {
        return this.data.get(RedisKeys.KEY_BUFF_MONTH_CARD);
    }

    public void setMonthCard(MonthCard monthCard) {
        this.data.set(RedisKeys.KEY_BUFF_MONTH_CARD, monthCard);
    }
    
    public NpcSkill getNpcSkill() {
    	return this.data.get(RedisKeys.KEY_BUFF_NPC_SKILL);
    }
    
    public void setNpcSkill(int npcID, int skillID) {
    	NpcSkill npcSkill = this.data.get(RedisKeys.KEY_BUFF_NPC_SKILL);
    	npcSkill.setNpcID(npcID);
    	npcSkill.setSkillID(skillID);
    }
}
