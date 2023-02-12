package com.dj.serverplayer.quartz;

import com.dj.servercore.quartz.AbstractQuartzJob;
import com.dj.serverplayer.helper.QueueHelper;
import com.dj.serverplayer.manager.QuartzManager;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;

import java.util.Iterator;
import java.util.List;

@Slf4j
public class ParkGrazeJob extends AbstractQuartzJob {

	public ParkGrazeJob() {
		setName(ParkGrazeJob.class.getSimpleName());
		setDescription("生态园动物吃草");
		setNeedCancelAfterWork(false);
		setRetryAfter3MinOnError(false);
	}

	@Override
	protected void run(JobExecutionContext jobContext) {
		List<Long> queue = QueueHelper.getInstance().getGrazeQueue();
		Iterator<Long> it = queue.iterator();
		while (it.hasNext()) {
			long roleID = it.next();
			//zcq 注释掉是担心影响服务器运行效率
			//Map<String, ParkAnimalUnit> animalMap = ServiceManager.getParkService().getAnimalMap(roleID);
			//log.info("roleID {}, animal count {} ", roleID, animalMap.size());
			boolean graze = QueueHelper.getInstance().animalEatPlant(roleID);
			//if (!graze) {
			//	it.remove();
			//	continue;
			//}
		}
	}

	public static void init() {
		QuartzManager.getInstance().addJob("maintain_park_graze", "group_job_maintain", ParkGrazeJob.class, 1 * 1000L);
	}
}
