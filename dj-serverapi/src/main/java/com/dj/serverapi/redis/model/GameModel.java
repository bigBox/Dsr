package com.dj.serverapi.redis.model;

import com.dj.domain.RedisKeys;
import com.dj.domain.entity.player.PlayerFactory;
import com.dj.domain.entity.player.PlayerObstacle;
import com.dj.domain.entity.robot.RobotFactory;
import com.dj.domain.entity.robot.RobotObstacle;
import com.dj.servercore.redis.RedisTemplate;
import com.dj.servercore.redis.base.BaseModel;

import java.util.List;

/**
 * @author zcq
 * @ClassName: GameModel
 * @Description: 游戏-提供多人访问，建筑，荒地，农田
 * @date 2019年8月7日
 */
public class GameModel extends BaseModel {

    public GameModel(Long roleID, RedisTemplate lockTemplate, RedisTemplate redisTemplate, Boolean lock) {
        super(RedisKeys.KEY_GAME, roleID, lockTemplate, redisTemplate, lock);
    }

    @Override
    protected void init() {

    }

    public List<PlayerFactory> getFactory() {
        return this.data.get(RedisKeys.KEY_GAME_FACTORY);
    }

    public void setFactory(List<PlayerFactory> factorys) {
        if(factorys != null) {
            this.data.set(RedisKeys.KEY_GAME_FACTORY, factorys);
        }
    }

    public List<RobotFactory> getRobotFactory() {
        return this.data.get(RedisKeys.KEY_ROBOT_GAME_FACTORY);
    }

    public void setRobotFactory(List<RobotFactory> factorys) {
        if(factorys != null) {
            this.data.set(RedisKeys.KEY_ROBOT_GAME_FACTORY, factorys);
        }
    }

    public List<PlayerObstacle> getObstacle() {
        return this.data.get(RedisKeys.KEY_GAME_OBSTACLE);
    }

    public void setObstacle(List<PlayerObstacle> obstacle) {
        this.data.set(RedisKeys.KEY_GAME_OBSTACLE, obstacle);
    }


    public List<RobotObstacle> getRobotObstacle() {
        return this.data.get(RedisKeys.KEY_ROBOT_GAME_OBSTACLE);
    }

    public void setRobotObstacle(List<RobotObstacle> obstacle) {
        this.data.set(RedisKeys.KEY_ROBOT_GAME_OBSTACLE, obstacle);
    }

}
