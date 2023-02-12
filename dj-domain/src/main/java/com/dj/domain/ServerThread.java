package com.dj.domain;

public final class ServerThread {

    public static final int PROCESSORS_THREAD_NUM = 2;

    public static final int SERVER_THREAD_NUM = Runtime.getRuntime().availableProcessors();
    /**
     * @Fields SERVER_PLAYER_THREAD_NUM: 玩家服线程数
     */
    public static final int SERVER_PLAYER_THREAD_NUM = PROCESSORS_THREAD_NUM * 2;
    /**
     * @Fields SERVER_GAME_THREAD_NUM: 游戏服线程数
     */
    public static final int SERVER_GAME_THREAD_NUM = PROCESSORS_THREAD_NUM * 2;
    /**
     * @Fields SERVER_GLOBAL_THREAD_NUM: 全局服线程数
     */
    public static final int SERVER_GLOBAL_THREAD_NUM = PROCESSORS_THREAD_NUM * 2;
}
