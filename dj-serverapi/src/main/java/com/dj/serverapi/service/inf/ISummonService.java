package com.dj.serverapi.service.inf;

import com.dj.domain.config.ConfigSummonExplore;
import com.dj.domain.config.ConfigSummons;
import com.dj.domain.data.summon.SummonData;
import com.dj.domain.data.summon.SummonPackage;
import com.dj.domain.util.inf.IArgumentRunnable;
import com.dj.protobuf.summon.*;

import java.util.Map;

public interface ISummonService {

	//Integer getMaxLevel();

	Integer getCurSummonId(long roleID);
	/**
	 *	获取精灵信息并且重置邮件
	 */
	SummonData getSummonResetMail(long roleID);

	/**
	 *	获取精灵信息
	 */
	Map<Integer, SummonData> getSummonMap(long roleID);

	void setSummonMap(long roleID, Map<Integer, SummonData> summonDataMap);

	SummonData getSummon(long roleID);

	void setSummon(long roleID, SummonData summonData);

	void removeSummon(long roleID, Integer summonId);
	/**
	 *	召唤精灵
	 */
	SummonData callSummon(long roleID, ConfigSummons configSummon);

	/**
	 *	将精灵派出去
	 */
	void summonSend(long roleID, int summonID, SummonSendRsp.Builder builder, int mailID, int mailCount);

	/**
	 *	领取精灵派出的邮件奖励
	 */
	void summonMailReward(long roleID, int index, SummonMailRewardRsp.Builder builder, IArgumentRunnable<SummonPackage> mailRun);

	/**
	 *	刷新精灵邮件
	 */
	SummonPackage summonMailRefresh(long roleID, int index);

	/**
	 *	旅行结束
	 */
	SummonData tourEnd(long roleID, int element);

	/**
	 *	首次打开精灵邮件
	 */
	void summonMailFirst(long roleID, int index);

	/**
	 *	投资精灵
	 * 邮件索引
	 */
	void summonInvest(long roleID, SummonInvestReq req, SummonInvestRsp.Builder builder, IArgumentRunnable<ConfigSummonExplore> costGoldRun);
	
	/**
	 * 精灵投资奖励捡漏
	 */
	void summonPickupInvestReward(long roleID, SummonPickupInvestRewardReq req, SummonPickupInvestRewardRsp.Builder builder);

    void summonFastMail(long roleID, SummonFastMailReq req, SummonFastMailRsp.Builder builder);

    void summonAllMailReward(long roleID, SummonAllMailRewardReq req, SummonAllMailRewardRsp.Builder builder, IArgumentRunnable<SummonPackage> mailRun);
}
