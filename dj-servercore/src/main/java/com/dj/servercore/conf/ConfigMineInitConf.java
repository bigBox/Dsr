package com.dj.servercore.conf;

import com.dj.domain.config.ConfigMineInit;
import com.dj.domain.constant.ConstantGame;
import com.dj.domain.util.collection.MapUtil;
import com.dj.servercore.conf.base.BaseConfigConf;
import com.dj.servercore.conf.base.IConfProvider;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;

import java.util.Map;

public class ConfigMineInitConf extends BaseConfigConf<ConfigMineInit> {

    public ConfigMineInitConf() {
        super(IConfProvider.CONFIG_MINEINIT);
    }

    private ImmutableMap<Integer, ConfigMineInit> cellMap;

    //我的出生点
    private ConfigMineInit myPosition;
    //去好友家的出生点
    private Map<Integer, ConfigMineInit> friendPosition = Maps.newHashMapWithExpectedSize(6);

    @Override
    public void onLoadOver() {
        cellMap = MapUtil.listToImmMap(dataList, obj -> obj.getID());

        friendPosition.clear();
        for (ConfigMineInit item : dataList) {
            if (item.getType() == ConstantGame.Unknown) {// 0-未知
                myPosition = item;
            } else if (String.valueOf(item.getType()).startsWith("109")) { // 109-功能
                friendPosition.put(item.getType(), item);
            }
        }
    }

    public ImmutableMap<Integer, ConfigMineInit> getCellMap() {
        return getConfig(cellMap);
    }

    public ConfigMineInit getMyPosition() {
        return getConfig(myPosition);
    }

    public ConfigMineInit getFriendPosition(int pos) {
        if(friendPosition.containsKey(pos)) {
            return getConfig(pos, friendPosition);
        }else{
            return null;
        }
    }

    public boolean isFriendPosition(int type) {
        return friendPosition.containsKey(type);
    }
}
