package com.dj.servercore.quartz;

import com.dj.domain.util.DateUtil;
import com.dj.domain.util.Utility;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.matchers.GroupMatcher;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Slf4j
public abstract class AbstractQuartzManager {

	private static AbstractQuartzManager instance;

	protected static void setInstance(AbstractQuartzManager instance) {
		AbstractQuartzManager.instance = instance;
	}

	/**
	 * @Title getInstance
	 * @Description 获得定时器管理 的实例
	 * @return AbstractQuartzManager
	 */
	public static AbstractQuartzManager getInstance() {
		return instance;
	}

	/**
	 * @Title initJob
	 * @Description 初始化管理器下所有的要执行的Job
	 * @return void
	 */
	public abstract void initJob();

	private Scheduler scheduler = null;

	public AbstractQuartzManager() {
		try {
			scheduler = new StdSchedulerFactory().getScheduler();
			log.info("Initialize the scheduler ");
		} catch (SchedulerException ex) {
			log.error("Initialize the scheduler fail cause={}", Utility.getTraceString(ex));
		}
	}

	public void addJob(String name, String group, Class<? extends Job> clazz, String cronExpression) {
		addJob(name, group, clazz, cronExpression, null);
	}

	public void addJob(String name, String group, Class<? extends Job> clazz, String cronExpression, Map<? extends String, ? extends Object> map) {
		try {
			// 构造任务
			JobDetail jobDetail = JobBuilder.newJob(clazz).withIdentity(name, group).build();
			if (map != null) {
				jobDetail.getJobDataMap().putAll(map);
			}
			// 构造任务触发器
			// Trigger trg = newTrigger().withIdentity(name,
			// group).withSchedule(cronSchedule(cronExpression)).build();
			CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity(name, group)// 触发器名,触发器组
					.withSchedule(CronScheduleBuilder.cronSchedule(cronExpression)).build();
			// 将作业添加到调度器
			scheduler.scheduleJob(jobDetail, trigger);
			log.info("Create Job,Job name：{} Job group：{} Job cron：{}", name, group, cronExpression);
		} catch (SchedulerException e) {
			log.error("Create Job,Job name：{} Job group：{} Job cron：{} fail cause={}", name, group, cronExpression, Utility.getTraceString(e));
		}
	}

	public void addJob(String name, String group, Class<? extends Job> clazz, long intervalInMillis) {
		addJob(name, group, clazz, intervalInMillis, null);
	}

	public void addJob(String name, String group, Class<? extends Job> clazz, long intervalInMillis, Map<? extends String, ? extends Object> map) {
		try {
			// 构造任务
			JobDetail jobDetail = JobBuilder.newJob(clazz).withIdentity(name, group).build();
			if (map != null) {
				jobDetail.getJobDataMap().putAll(map);
			}
			// 构造任务触发器
			SimpleTrigger trigger = TriggerBuilder.newTrigger().withIdentity(name, group)// 触发器名,触发器组
					.withSchedule(SimpleScheduleBuilder.simpleSchedule().repeatForever().withIntervalInMilliseconds(intervalInMillis)).build();
			// 将作业添加到调度器
			scheduler.scheduleJob(jobDetail, trigger);
			log.info("Create Job,Job name：{} Job group：{} Job intervalInMillis：{}", name, group, intervalInMillis);
		} catch (SchedulerException e) {
			log.error("Create Job,Job name：{} Job group：{} Job intervalInMillis：{} fail cause={}", name, group, intervalInMillis, Utility.getTraceString(e));
		}
	}

	/**
	 * @Title addJob
	 * @Description 新增一个以日期为参数的定时任务，设定触发时间为日期指定小时、分钟以及日期所在西式周数(周日为一周开始-1,周六为一周结束-7)
	 * @param name
	 * @param group
	 * @param clazz
	 * @param date
	 * @return void
	 */
	@SuppressWarnings("deprecation")
	public void addJob(String name, String group, Class<? extends Job> clazz, Date date) {
		try {
			// 构造任务
			JobDetail jobDetail = JobBuilder.newJob(clazz).withIdentity(name, group).build();
			// 构造任务触发器
			CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity(name, group).withSchedule(CronScheduleBuilder.atHourAndMinuteOnGivenDaysOfWeek(date.getHours(),
					date.getMinutes(), DateUtil.getDayOfWeekWestern(date.getTime()))).build();
			scheduler.scheduleJob(jobDetail, trigger);
			log.info("Create Job,Job name：{} Job group：{} Job date：{} ", name, group, date);
		} catch (SchedulerException e) {
			log.error("Create Job,Job name：{} Job group：{} Job date：{} fail cause={}", name, group, date, Utility.getTraceString(e));
		}
	}

	public void addJob(String name, String group, Class<? extends Job> clazz, Date date, Map<? extends String, ? extends Object> map){
		addJob(name, group, clazz, date, map, false);
	}

	/**
	 *
	 * @param name
	 * @param group
	 * @param clazz
	 * @param date
	 * @param map
	 * @param fixTimeError    是否自动修复时间上的错误，经测试，如果你添加了一个过去的任务 是不会被执行的
	 */
	@SuppressWarnings("deprecation")
	public void addJob(String name, String group, Class<? extends Job> clazz, Date date, Map<? extends String, ? extends Object> map,boolean fixTimeError) {
		try {
			// 构造任务
			JobDetail jobDetail = JobBuilder.newJob(clazz).withIdentity(name, group).build();
			if (map != null && !map.isEmpty()) {
				jobDetail.getJobDataMap().putAll(map);
			}
			if (fixTimeError) {
				boolean flag = false ;
				DateTime nowDateTime = DateTime.now();
				if (date.getTime() - nowDateTime.getMillis() < 60 * 1000) {
					flag = true;     // 如果给定的参数时间和当前时间的间隔小于1分钟， 则修改时间
				}
				if (flag) {
					// 只有增加1分钟必定会执行。。
					date = nowDateTime.plusMinutes(1).toDate();
				}
			}
			// 构造任务触发器
			CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity(name, group).withSchedule(CronScheduleBuilder.atHourAndMinuteOnGivenDaysOfWeek(date.getHours(),
							date.getMinutes(), DateUtil.getDayOfWeekWestern(date.getTime()))).build();
			scheduler.scheduleJob(jobDetail, trigger);
			log.info("Create Job,Job name：{} Job group：{} Job date：{}", name, group, date);
		} catch (SchedulerException e) {
			log.error("Create Job,Job name：{} Job group：{} Job date：{} fail cause={}", name, group, date, Utility.getTraceString(e));
		}
	}

	public void removeJob(String name, String group) {
		try {
			TriggerKey tk = TriggerKey.triggerKey(name, group);
			scheduler.pauseTrigger(tk);// 停止触发器
			scheduler.unscheduleJob(tk);// 移除触发器
			JobKey jobKey = JobKey.jobKey(name, group);
			scheduler.deleteJob(jobKey);// 删除作业
			log.info("Delete Job,Job name：{} Job group：{}", name, group);
		} catch (SchedulerException e) {
			log.error("Delete Job,Job name：{} Job group：{} fail cause={}", name, group, Utility.getTraceString(e));
		}
	}

	public void removeJob(JobKey jobKey) {
		if (jobKey == null) {
			return;
		}
		removeJob(jobKey.getName(), jobKey.getGroup());
	}

	public void pauseJob(String name, String group) {
		try {
			JobKey jobKey = JobKey.jobKey(name, group);
			scheduler.pauseJob(jobKey);
			log.info("Pause Job,Job name：{} Job group：{}", name, group);
		} catch (SchedulerException e) {
			log.error("Pause Job,Job name：{} Job group：{} fail cause={}", name, group, Utility.getTraceString(e));
		}
	}

	public void resumeJob(String name, String group) {
		try {
			JobKey jobKey = JobKey.jobKey(name, group);
			scheduler.resumeJob(jobKey);
			log.info("Resume Job,Job name：{} Job group：{}", name, group);
		} catch (SchedulerException e) {
			log.error("Resume Job,Job name：{} Job group：{} fail cause={}", name, group, Utility.getTraceString(e));
		}
	}

	public void modifyTime(String name, String group, String cronExpression) {
		try {
			TriggerKey tk = TriggerKey.triggerKey(name, group);
			// 构造任务触发器
			// Trigger trg = newTrigger().withIdentity(name,
			// group).withSchedule(cronSchedule(cronExpression)).build();
			CronTrigger trg = TriggerBuilder.newTrigger().withIdentity(name, group)// 触发器名,触发器组
					.withSchedule(CronScheduleBuilder.cronSchedule(cronExpression)).build();
			scheduler.rescheduleJob(tk, trg);
			log.info("Reschedule Job,Job name：{} Job group：{}", name, group);
		} catch (SchedulerException e) {
			log.error("Reschedule Job,Job name：{} Job group：{} fail cause={}", name, group, Utility.getTraceString(e));
		}
	}

	public List<JobKey> getJobs() {
		List<JobKey> ret = Lists.newArrayList();
		try {
			for (String groupName : scheduler.getJobGroupNames()) {
				ret.addAll(scheduler.getJobKeys(GroupMatcher.jobGroupEquals(groupName)));
			}
		} catch (SchedulerException e) {
			log.error("getJobs fail cause={}", Utility.getTraceString(e));
		}
		return ret;
	}

	public List<JobKey> getJobs(String group) {
		List<JobKey> ret = Lists.newArrayList();
		try {
			ret.addAll(scheduler.getJobKeys(GroupMatcher.jobGroupEquals(group)));
		} catch (SchedulerException e) {
			log.error("getJobs fail cause={}", Utility.getTraceString(e));
		}
		return ret;
	}

	public void start() {
		try {
			scheduler.start();
			log.info("Start the scheduler");
		} catch (SchedulerException e) {
			e.printStackTrace();
			log.error("Start the scheduler fail cause={}", Utility.getTraceString(e));
		}
	}

	public void shutdown() {
		if (scheduler == null) {
			return;
		}
		try {
			scheduler.shutdown();
			log.info("Shutdown the scheduler");
		} catch (SchedulerException e) {
			e.printStackTrace();
			log.error("Shutdown the scheduler fail cause={}", Utility.getTraceString(e));
		}
	}
}
