package com.dj.servergame.listener;

/**
 * @author zcq
 * @ClassName: TopicListener
 * @Description: 跨进程topic主题监听器，多项目通过redis的topic主题作为中介传输数据
 * @date 2019年6月25日
 */
public class TopicListener {
    private static final TopicListener INSTANCE = new TopicListener();

    public static final TopicListener getInstance() {
        return INSTANCE;
    }

    public void initListener() {
    }
}
