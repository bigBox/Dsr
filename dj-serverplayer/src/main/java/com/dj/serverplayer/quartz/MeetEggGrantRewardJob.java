package com.dj.serverplayer.quartz;

import com.dj.servercore.quartz.AbstractQuartzJob;
import com.dj.serverplayer.helper.QueueHelper;
import com.dj.serverplayer.manager.QuartzManager;
import com.dj.serverplayer.manager.ServiceManager;
import org.quartz.JobExecutionContext;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class MeetEggGrantRewardJob extends AbstractQuartzJob {

	public MeetEggGrantRewardJob() {
		setName(MeetEggGrantRewardJob.class.getSimpleName());
		setDescription("接鸡蛋发放奖励");
		setNeedCancelAfterWork(false);
		setRetryAfter3MinOnError(false);
	}

	@Override
	protected void run(JobExecutionContext jobContext) {
		Date nowDate = new Date();
		List<Long> queue = QueueHelper.getInstance().getTravelQueue();
		Iterator<Long> it = queue.iterator();
		while (it.hasNext()) {
			long roleID = it.next();
			boolean reward = ServiceManager.getMeetEggSingleService().hasMeetEggReward(roleID, nowDate);
			if (!reward) {
				it.remove();
				continue;
			}
			QueueHelper.getInstance().meetEggGrantReward(roleID, nowDate);
		}
	}

	public static void init() {
		QuartzManager.getInstance().addJob("maintain_meetegg_grantreward", "group_job_maintain", MeetEggGrantRewardJob.class, 5 * 60 * 1000L);
	}
}
