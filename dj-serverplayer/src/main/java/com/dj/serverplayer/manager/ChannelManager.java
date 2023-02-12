package com.dj.serverplayer.manager;

import com.dj.servercore.server.netty.channel.BaseLogicChannelManager;

public final class ChannelManager extends BaseLogicChannelManager {

    private static final ChannelManager INSTANCE = new ChannelManager();

    public ChannelManager() {
        setInstance(this);
    }

    public static final ChannelManager getInstance() {
        return INSTANCE;
    }
}
