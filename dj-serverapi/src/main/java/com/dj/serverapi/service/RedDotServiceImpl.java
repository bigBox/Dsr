package com.dj.serverapi.service;

import com.dj.domain.config.ConfigFarmParkAnimal;
import com.dj.domain.data.game.ParkAnimalUnit;
import com.dj.domain.entity.player.PlayerVerify;
import com.dj.domain.entity.robot.RobotVerify;
import com.dj.protobuf.CommonException;
import com.dj.protobuf.ErrorIDOuterClass;
import com.dj.serverapi.redis.model.ParkModel;
import com.dj.serverapi.redis.model.RobotVerifyModel;
import com.dj.serverapi.redis.model.VerifyModel;
import com.dj.serverapi.service.inf.IRedDotService;
import com.dj.servercore.conf.ConfigFarmParkAnimalConf;
import com.dj.servercore.conf.base.ConfProvider;
import com.dj.servercore.conf.base.IConfProvider;
import com.dj.servercore.redis.base.BaseService;

import java.util.List;
import java.util.Map;

public class RedDotServiceImpl extends BaseService implements IRedDotService {

    @Override
    public int getVerifyingCount(long roleID) {
        VerifyModel model = getReadModel(roleID, VerifyModel.class);
        List<PlayerVerify> queues = model.getVerifyQueue();
        int count = 0;
        if (queues != null) {
            for (PlayerVerify playerVerify : queues) {
                //待鉴定
                if (playerVerify.getVerifyID() > 0 && playerVerify.getResultItem() == 0) {
                    count++;
                }
            }
        }
        return count;
    }

    @Override
    public int getRobotVerifyingCount(long roleID) {
        RobotVerifyModel  model  = getReadModel(roleID, RobotVerifyModel.class);
        List<RobotVerify> queues = model.getVerifyQueue();
        int count  = 0;
        if (queues != null) {
            for (RobotVerify robotVerify : queues) {
                //待鉴定
                if (robotVerify.getVerifyID() > 0 && robotVerify.getResultItem() == 0) {
                    count++;
                }
            }
        }
        return count;
    }

    @Override
    public int getFeedCount(long roleID) {
        ParkModel model = getReadModel(roleID, ParkModel.class);
        Map<String, ParkAnimalUnit> animalMap = model.getParkAnimalMap();
        int count = 0;
        if (animalMap.size() > 0) {
            ConfigFarmParkAnimalConf animalConf = ConfProvider.getConfigConfProvider().getConfigConf(IConfProvider.CONFIG_FARMPARKANIMAL);
            if(animalConf == null){
                throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
            }
            for (ParkAnimalUnit animal : animalMap.values()) {
                ConfigFarmParkAnimal configAnimal = animalConf.getAnimal(animal.getAnimalID());
                // 饥饿的稀有动物
                if (configAnimal.getUncommon() == 1 && animal.getEatNum() < configAnimal.getEatNum()) {
                    count++;
                }
            }
        }
        return count;
    }

    @Override
    public int getRobotFeedCount(long roleID) {
        int count = 0;

        return count;
    }
}
