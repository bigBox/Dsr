package com.dj.servercore.quartz;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;

import com.dj.domain.util.DateUtil;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public abstract class AbstractQuartzJob implements Job {
	// 工作结束之后需要取消当前定时器
	// 出现异常也会取消当前定时器的任务
	private boolean needCancelAfterWork = false;
	// 这个定时任务的名字-英文
	private String name;
	// 这个定时任务的描述-最好全中文
	private String description;
	// 在出现异常之后 3分钟后重试
	private boolean retryAfter3MinOnError = false;
	// 在 finally 部分执行的代码块。 一般情况下会确保这个部分的代码一定执行(就算出现了异常也会执行)
	// 此部分会在 needCancelAfterWork 后面执行
	private Runnable finallyBlock = null;

	/**
	 *	子类执行逻辑
	 * 
	 * @param jobContext
	 */
	protected abstract void run(JobExecutionContext jobContext);

	@Override
	public final void execute(JobExecutionContext arg0) {
		JobDataMap jobDataMap = arg0.getJobDetail().getJobDataMap();
		if (jobDataMap.containsKey("AbstractQuartzJob.ErrorRetry")) {
			if (jobDataMap.getBooleanValue("AbstractQuartzJob.ErrorRetry")) {
				needCancelAfterWork = true;
			}
		}
		try {
			run(arg0);
		} catch (Exception e) {
			log.error(String.format("AbstractQuartzJob Exception catch. name=%s,description=%s", name, description), e);
			if (retryAfter3MinOnError) {
				Map<String, Object> map = new HashMap<>();
				map.put("AbstractQuartzJob.ErrorRetry", true);
				AbstractQuartzManager.getInstance().addJob(arg0.getJobDetail().getKey().getName() + "ErrorRetry", arg0.getJobDetail().getKey().getGroup(), this.getClass(), DateUtil.plusNow(TimeUnit.MINUTES, 3), map);
			}
		} finally {
			if (needCancelAfterWork) {
				AbstractQuartzManager.getInstance().removeJob(arg0.getJobDetail().getKey());
			}
			// finallyBlock 会在 needCancelAfterWork 后面执行
			if (finallyBlock != null) {
				finallyBlock.run();
			}
		}
	}
}
