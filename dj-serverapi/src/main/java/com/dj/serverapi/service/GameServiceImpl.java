package com.dj.serverapi.service;

import com.dj.domain.entity.player.PlayerFactory;
import com.dj.domain.entity.player.PlayerObstacle;
import com.dj.domain.entity.robot.RobotFactory;
import com.dj.domain.entity.robot.RobotObstacle;
import com.dj.serverapi.redis.model.GameModel;
import com.dj.serverapi.service.inf.IGameService;
import com.dj.servercore.redis.base.BaseService;

import java.util.List;

public class GameServiceImpl extends BaseService implements IGameService {

    @Override
    public void setFactory(long roleID, List<PlayerFactory> factorys) {
        if(factorys != null) {
            getWriteModel(roleID, GameModel.class).setFactory(factorys);
        }
    }

    @Override
    public List<PlayerFactory> getFactory(long roleID) {
        return getReadModel(roleID, GameModel.class).getFactory();
    }

    @Override
    public void setRobotFactory(long roleID, List<RobotFactory> factorys) {
        if(factorys != null) {
            getWriteModel(roleID, GameModel.class).setRobotFactory(factorys);
        }
    }
    @Override
    public List<RobotFactory> getRobotFactory(long roleID) {
        return getReadModel(roleID, GameModel.class).getRobotFactory();
    }

    @Override
    public void setObstacle(long roleID, List<PlayerObstacle> obstacle) {
        if(obstacle != null) {
            getModel(roleID, GameModel.class, true).setObstacle(obstacle);
        }
    }

    @Override
    public List<PlayerObstacle> getObstacle(long roleID) {
        return getReadModel(roleID, GameModel.class).getObstacle();
    }

    @Override
    public void setRobotObstacle(long roleID, List<RobotObstacle> obstacle) {
        if(obstacle != null) {
            getModel(roleID, GameModel.class, true).setRobotObstacle(obstacle);
        }
    }

    @Override
    public List<RobotObstacle> getRobotObstacle(long roleID) {
        return getReadModel(roleID, GameModel.class).getRobotObstacle();
    }
}
