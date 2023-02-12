package com.dj.serverplayer.quartz;

import com.dj.domain.constant.ConstantGame;
import com.dj.domain.data.summon.SummonData;
import com.dj.domain.data.summon.SummonPackage;
import com.dj.domain.util.GsonUtil;
import com.dj.protobuf.summon.SummonMailInfo;
import com.dj.protobuf.summon.SummonMailNtf;
import com.dj.serverapi.helper.MessageHelper;
import com.dj.serverapi.helper.OnlineHelper;
import com.dj.servercore.quartz.AbstractQuartzJob;
import com.dj.serverplayer.helper.QueueHelper;
import com.dj.serverplayer.manager.ChannelManager;
import com.dj.serverplayer.manager.QuartzManager;
import com.dj.serverplayer.manager.ServiceManager;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Slf4j
public class SummonTravelJob extends AbstractQuartzJob {

	public SummonTravelJob() {
		setName(SummonTravelJob.class.getSimpleName());
		setDescription("精灵旅行");
		setNeedCancelAfterWork(false);
		setRetryAfter3MinOnError(false);
	}

	@Override
	protected void run(JobExecutionContext jobContext) {
		List<Long> queue = QueueHelper.getInstance().getTravelQueue();
		Iterator<Long> it = queue.iterator();
		while (it.hasNext()) {
			long roleID     = it.next();

			Map<Integer, SummonData> summonMap = ServiceManager.getSummonService().getSummonMap(roleID);
			if(summonMap != null) {
				for (Integer summonId : summonMap.keySet()) {
					SummonData summonData = summonMap.get(summonId);
					if(summonData.isTourEnd()){
						continue;
					}
					// 精灵旅行途中获得邮件
					SummonMailInfo.Builder mailBuilder = SummonMailInfo.newBuilder();
					for (SummonPackage mail : summonData.getPackages()) {
						if (mail.isNtfFlag()) {
							continue;
						}
						long mailTime = mail.getTime();
						if ((mailTime >= summonData.getLastMailTime()) && (mailTime - 1000 <= System.currentTimeMillis())) {
							summonData.setLastMailTime(mailTime);
							mail.setNtfFlag(true);
							if(mail.getRewardType() == ConstantGame.SUMMON_INVEST_EVENT) { // 可以投资了
								summonData.setCanInvest(true);
							}
							summonData.setRevPackageCount(summonData.getRevPackageCount()+1);
							// 推送邮件给前端
							SummonMailNtf.Builder builder = SummonMailNtf.newBuilder();
							builder.setMail(MessageHelper.toSummonMailInfo(mailBuilder, mail));
							int gateID = OnlineHelper.getInstance().getOnlineGateID(roleID);
							ChannelManager.getInstance().sendPlayerBasicToGate(gateID, roleID, builder.build());
							log.info("roleID {} 获得邮件 mail {}", roleID, GsonUtil.toJson(mail));
							ServiceManager.getSummonService().setSummon(roleID, summonData);
						}
					}
					boolean mailsAllProcessed = true;
					for (SummonPackage mail : summonData.getPackages()) {
						if (!mail.isProcessed()) {
							mailsAllProcessed = false;
							break;
						}
					}
					// 旅行结束
					if((mailsAllProcessed) && (summonData.getSendTime() > 0) && (summonData.getRevPackageCount() >= summonData.getAllPackageCount())) {
						ServiceManager.getSummonService().tourEnd(roleID, summonId);
						it.remove();
					}
				}
			}
		}
	}

	public static void init() {
		QuartzManager.getInstance().addJob("maintain_summon_travel", "group_job_maintain", SummonTravelJob.class,1000L);
	}
}
