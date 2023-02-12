package com.dj.serverapi.redis.model;

import com.dj.domain.RedisKeys;
import com.dj.domain.entity.player.PlayerRole;
import com.dj.serverapi.redis.base.InitModel;
import com.dj.servercore.redis.RedisTemplate;

/**
 * @author zcq
 * @ClassName: PlayerModel
 * @Description: 玩家
 * @date 2019年8月7日
 */
public class PlayerModel extends InitModel {

    public PlayerModel(Long roleID, RedisTemplate lockTemplate, RedisTemplate redisTemplate, Boolean lock) {
        super(RedisKeys.KEY_PLAYER, roleID, lockTemplate, redisTemplate, lock);
    }

    @Override
    protected void init() {
        initTime();
    }

    @Override
    protected void onLoadOver() {
        // 如果初始化时间不是今天就重置
    }

    public PlayerRole getPlayer() {
        return this.data.get(RedisKeys.KEY_PLAYER_ROLE);
    }

    public void setPlayer(PlayerRole player) {
        this.data.set(RedisKeys.KEY_PLAYER_ROLE, player);
    }
}
