package com.dj.serverplayer.manager;

import com.dj.serverapi.ServiceProvider;
import com.dj.serverapi.service.RedDotServiceImpl;
import com.dj.serverapi.service.TaskServiceImpl;
import com.dj.serverapi.service.inf.IRedDotService;
import com.dj.serverapi.service.inf.ITaskService;

import lombok.Getter;

public class ServiceManager extends ServiceProvider {
    /**
     * 任务
     */
    @Getter
    protected static ITaskService taskService = (ITaskService) getProxyService(TaskServiceImpl.class);
    /**
     * 红点
     */
    @Getter
    protected static IRedDotService redDotService = (IRedDotService) getProxyService(RedDotServiceImpl.class);
}
