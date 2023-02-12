package com.dj.servercore.event;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import com.dj.domain.base.BaseEvent;
import com.dj.domain.base.IAsyncEvent;
import com.dj.domain.base.IEvent;
import com.dj.servercore.pool.MyThreadFactory;
import com.dj.servercore.pool.PooledObjectFactory;
import com.dj.servercore.server.SocketServer;
import com.dj.domain.util.Utility;
import com.dj.domain.util.cache.CacheUtil;
import com.google.common.cache.Cache;
import com.google.common.collect.Lists;
import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class AbsEventManager {

    /**
     * @Fields syncEventBus : 通用同步事件总线
     */
    protected static EventBus syncEventBus = new EventBus(new EventBusExceptionHandler());

    /**
     * @Fields asyncEventBus : 通用异步事件总线
     */
    protected static AsyncEventBus asyncEventBus = new AsyncEventBus(Executors.newFixedThreadPool(SocketServer.getThreadNum(),
            new MyThreadFactory(SocketServer.getServerConfig().getName() + "-Event-Async")), new EventBusExceptionHandler());

    protected static Cache<Long, List<IEvent>> eventCache = CacheUtil.createCacheWithExpire(30, TimeUnit.MINUTES);

    public AbsEventManager() {
        super();
        init();
    }

    private void init() {
        try {
            registerListener();
            log.info("init EventManager success");
        } catch (Exception e) {
            log.error("init EventManager error,cause={}", Utility.getTraceString(e));
        }
    }

    /**
     * @return void
     * @Title registerListener
     * @Description 注册监听器
     */
    protected abstract void registerListener();

    /**
     * @param event
     * @return void
     * @Title postSyncEvent
     * @Description 提交同步事件
     */
    protected static void postSyncEvent(Object event) {
        syncEventBus.post(event);
        //log.info("postSyncEvent end event=%",event.toString());
    }

    /**
     * @param event
     * @return void
     * @Title postAsyncEvent
     * @Description 提交异步事件
     */
    public static void postAsyncEvent(Object event) {
        asyncEventBus.post(event);
        //log.info("postAsyncEvent end event=%",event.toString());
    }

    @SuppressWarnings("unchecked")
    public static <T extends BaseEvent> T borrowEvent(Class<? extends BaseEvent> clz) {
        return (T) PooledObjectFactory.getInstance().borrowObject(clz);
    }

    protected static void putEventCache(IEvent event) {
        try {
            List<IEvent> list = eventCache.get(event.getRoleID(), () -> Lists.newLinkedList());
            synchronized (list) {
                list.add(event);
            }
        } catch (ExecutionException e) {
            log.error(Utility.getTraceString(e));
        }
    }

    /**
     *	提交角色事件
     *
     * @param roleID
     */
    public static void commitRoleEvent(long roleID) {
        List<IEvent> list = eventCache.getIfPresent(roleID);
        if (list != null && list.size() > 0) {
            synchronized (list) {
                Iterator<IEvent> iterator = list.iterator();
                while (iterator.hasNext()) {
                    IEvent event = iterator.next();
                    IAsyncEvent async = event.getClass().getAnnotation(IAsyncEvent.class);
                    if (async != null && async.async()) {
                        postAsyncEvent(event);
                    } else {
                        postSyncEvent(event);
                    }
                    iterator.remove();
                }
            }
        }
    }
}
