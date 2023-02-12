package com.dj.serverapi.redis.model;

import com.dj.domain.RedisKeys;
import com.dj.domain.constant.ConstantGame;
import com.dj.domain.data.summon.SummonData;
import com.dj.domain.data.summon.SummonPackage;
import com.dj.domain.util.inf.IArgumentRunnable;
import com.dj.servercore.redis.RedisTemplate;
import com.dj.servercore.redis.base.BaseModel;

import java.util.Map;

/**
 * @author zcq
 * @ClassName: SummonModel
 * @Description: 精灵
 * @date 2019年8月7日
 */
public class SummonModel extends BaseModel {

    public SummonModel(Long roleID, RedisTemplate lockTemplate, RedisTemplate redisTemplate, Boolean lock) {
        super(RedisKeys.KEY_SUMMON, roleID, lockTemplate, redisTemplate, lock);
    }

    @Override
    protected void init() {
        this.data.initNewSubMap(RedisKeys.KEY_SUMMON_INFO);
    }

    @Override
    protected void onLoadOver() {
    }

    public void clearSummonMap() {
        this.data.clearSubMap(RedisKeys.KEY_SUMMON_INFO);
    }

    public Map<Integer, SummonData> getSummonMap() {
        return this.data.getSubMap(RedisKeys.KEY_SUMMON_INFO);
    }

    public SummonData getSummon(Integer summonId) {
        return this.data.getSubMapItem(RedisKeys.KEY_SUMMON_INFO,summonId);
    }

    public void setSummon(SummonData summonData) {
        this.data.addSubMapItem(RedisKeys.KEY_SUMMON_INFO, summonData.getSummonID(), summonData);
    }

    public void removeSummon(Integer summonId) {
        this.data.getSubMap(RedisKeys.KEY_SUMMON_INFO).remove(summonId);
    }

    public boolean mailReward(int index, Integer summonId, IArgumentRunnable<SummonPackage> mailRun) {
        boolean hasNewMail = false;
        SummonData summonData = getSummon(summonId);
        if ((summonData != null)&&(summonData.getPackages().size() > 0)) {
        	for(int i = summonData.getPackages().size() - 1; i >= 0; i--) {
                SummonPackage mail = summonData.getPackages().get(i);
                if (mail.isNtfFlag() && mail.getIndex() == index) {
                	if(mail.getRewardType() != ConstantGame.SUMMON_INVEST_EVENT) {
                        mailRun.run(mail);
                        mail.setReward(true);
                        mail.setProcessed(true);
            		}
                } else if (!mail.isNtfFlag()) {
                    hasNewMail = true;
                }
            }
            setSummon(summonData);
        }
        return hasNewMail;
    }
}
