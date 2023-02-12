package com.dj.serverapi.service;

import com.dj.domain.GlobalRoleID;
import com.dj.domain.RedisKeys;
import com.dj.domain.constant.ConstantRank;
import com.dj.domain.enums.PlayerAttrEnum;
import com.dj.domain.enums.ResourceBillEnum;
import com.dj.domain.config.ConfigAchievement;
import com.dj.domain.config.ConfigExpLevelCfg;
import com.dj.domain.config.ConfigReputationLevel;
import com.dj.domain.config.ConfigShowTableLevel;
import com.dj.domain.entity.player.PlayerRole;
import com.dj.protobuf.CommonException;
import com.dj.protobuf.ErrorIDOuterClass;
import com.dj.protobuf.ErrorIDOuterClass.ErrorID;
import com.dj.serverapi.EventProvider;
import com.dj.serverapi.redis.model.PlayerModel;
import com.dj.serverapi.service.inf.IPlayerService;
import com.dj.servercore.conf.ConfigExpLevelCfgConf;
import com.dj.servercore.conf.ConfigReputationLevelConf;
import com.dj.servercore.conf.ConfigShowTableLevelConf;
import com.dj.servercore.conf.base.ConfProvider;
import com.dj.servercore.conf.base.IConfProvider;
import com.dj.servercore.redis.base.AbsModel;
import com.dj.servercore.redis.base.BaseService;
import com.dj.domain.util.DateUtil;
import com.dj.domain.util.GsonUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
public class PlayerServiceImpl extends BaseService implements IPlayerService {

    @Override
    public void createPlayer(PlayerRole role) {
        getWriteModel(role.getRoleID(), PlayerModel.class).setPlayer(role);
        // 添加默认排名
        if(GlobalRoleID.isGlobalRoleID(role.getRoleID()) == false) {
        	rankSet(ConstantRank.LEVEL, role.getRoleID(), role.getLevel());
        	rankSet(ConstantRank.RENOWN_LEVEL, role.getRoleID(), role.getRenownLevel());
        }
        updatePlayerName(role.getRoleID(), "", role.getRoleName());
    }

    @Override
    public void logPlayerName() {
        Map<Object, Object> map = hashGetAll(RedisKeys.KEY_PLAYER_NAME);
        log.info(GsonUtil.toJson(map.keySet()));
        // 删除全局角色的排行数据
        rankRemove(ConstantRank.LEVEL, GlobalRoleID.getXiaoXun());
        rankRemove(ConstantRank.RENOWN_LEVEL, GlobalRoleID.getXiaoXun());
        rankRemove(ConstantRank.SHOWTABLE, GlobalRoleID.getXiaoXun());
        rankRemove(ConstantRank.LEVEL, GlobalRoleID.getRobot());
        rankRemove(ConstantRank.RENOWN_LEVEL, GlobalRoleID.getRobot());
        rankRemove(ConstantRank.SHOWTABLE, GlobalRoleID.getRobot());
    }

    @Override
    public void updatePlayerName(long roleID, String oldName, String name) {
        hashDelete(RedisKeys.KEY_PLAYER_NAME, oldName);
        hashSet(RedisKeys.KEY_PLAYER_NAME, name, 1);
    }

    @Override
    public boolean checkExitName(String name) {
        return hashGet(RedisKeys.KEY_PLAYER_NAME, name) != null;
    }

    @Override
    public PlayerRole getPlayer(long roleID) {
        return getReadModel(roleID, PlayerModel.class).getPlayer();
    }

    @Override
    public void setPlayer(long roleID, PlayerRole playerRole) {
    	PlayerModel playerModel = getWriteModel(roleID, PlayerModel.class);
    	if(playerModel.getPlayer() != null) {
    		long guildID = playerModel.getPlayer().getGuildId();
    		playerRole.setGuildId(guildID);
    	}
        getWriteModel(roleID, PlayerModel.class).setPlayer(playerRole);
        // 更新排行榜
        rankSet(ConstantRank.LEVEL, roleID, playerRole.getLevel());
        rankSet(ConstantRank.RENOWN_LEVEL, roleID, playerRole.getRenownLevel());
        rankSet(ConstantRank.SHOWTABLE, roleID, playerRole.getShowTable());
    }

    @Override
    public PlayerRole costGold(long roleID, long gold) {
        PlayerRole playerRole = getWriteModel(roleID, PlayerModel.class).getPlayer();
        if (playerRole.getGold() < gold) {
            throw new CommonException(ErrorID.COMMON_PLAYER_GOLD_LESS);
        }
        playerRole.setGold(playerRole.getGold() - gold);
        return playerRole;
    }

    @Override
    public PlayerRole costStamina(long roleID, long stamina) {
        PlayerRole playerRole = getWriteModel(roleID, PlayerModel.class).getPlayer();
        if (playerRole.getStamina() < stamina) {
            throw new CommonException(ErrorID.COMMON_PLAYER_STAMINA_LESS);
        }
        playerRole.setStamina(playerRole.getStamina() - stamina);
        return playerRole;
    }

    @Override
    public PlayerRole costDiamond(long roleID, long diamond) {
        PlayerRole playerRole = getWriteModel(roleID, PlayerModel.class).getPlayer();
        if (playerRole.getDiamond() < diamond) {
            throw new CommonException(ErrorID.COMMON_PLAYER_DIAMOND_LESS);
        }
        playerRole.setDiamond(playerRole.getDiamond() - diamond);
        return playerRole;
    }

    @Override
    public PlayerRole addGold(long roleID, long gold) {
        PlayerRole playerRole = getWriteModel(roleID, PlayerModel.class).getPlayer();
        playerRole.setGold(playerRole.getGold() + gold);
        return playerRole;
    }

    @Override
    public PlayerRole addStamina(long roleID, long stamina) {
        PlayerRole playerRole = getWriteModel(roleID, PlayerModel.class).getPlayer();
        playerRole.setStamina(playerRole.getStamina() + stamina);
        return playerRole;
    }

    @Override
    public PlayerRole addDiamond(long roleID, long diamond) {
        PlayerRole playerRole = getWriteModel(roleID, PlayerModel.class).getPlayer();
        playerRole.setDiamond(playerRole.getDiamond() + diamond);
        return playerRole;
    }

    @Override
    public PlayerRole addExp(long roleID, long exp) {
        PlayerRole playerRole = getWriteModel(roleID, PlayerModel.class).getPlayer();
        playerRole.setExperience(playerRole.getExperience() + exp);
        ConfigExpLevelCfgConf conf = ConfProvider.getConfigConfProvider().getConfigConf(IConfProvider.CONFIG_EXPLEVELCFG);
        if(conf == null){
            throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
        }
        int level = playerRole.getLevel();
        while (true) {
            ConfigExpLevelCfg cfg = conf.getExpLevelCfg(level);
            ConfigExpLevelCfg preCfg = conf.getExpLevelCfg(level-1);
            if (cfg == null || preCfg == null) {
                break;
            }
            if (playerRole.getExperience() < cfg.getUpLevelExp() + preCfg.getUpLevelTotalExp()) {
                break;
            }
            level++;
        }
        if (level > playerRole.getLevel()) {
        	addLevel(roleID, level - playerRole.getLevel());
        }
        return playerRole;
    }

    @Override
    public void addLevel(long roleID, int level) {
        PlayerRole playerRole = getWriteModel(roleID, PlayerModel.class).getPlayer();
        int previousLevel = playerRole.getLevel();
        playerRole.setLevel(previousLevel + level);
        playerRole.setLevelTime(System.currentTimeMillis());
        if(!GlobalRoleID.isGlobalRoleID(roleID)) {
        	rankSet(ConstantRank.LEVEL, roleID, playerRole.getLevel());
        	EventProvider.postPlayerLevelUpEvent(roleID, playerRole.getLevel(), previousLevel);
        	EventProvider.postPlayerAttrEvent(roleID, PlayerAttrEnum.LEVEL, playerRole.getLevel());
        }
        log.info("roleID:{}, level:{}", roleID, level);
    }

    @Override
    public PlayerRole addRenown(long roleID, long renown) {
        PlayerRole playerRole = getWriteModel(roleID, PlayerModel.class).getPlayer();
        playerRole.setRenown(playerRole.getRenown() + renown);
        ConfigReputationLevelConf conf = ConfProvider.getConfigConfProvider().getConfigConf(IConfProvider.CONFIG_REPUTATIONLEVEL);
        if(conf == null){
            throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
        }
        int level = playerRole.getRenownLevel();
        while (true) {
            ConfigReputationLevel config = conf.getReputationLevel(level);
            if (config == null) {
                break;
            }
            if (playerRole.getRenown() < config.getUpLevelExp() + config.getUpLevelTotalExp()) {
                break;
            }
            level++;
        }
        if (level > playerRole.getRenownLevel()) {
            setRenownLevel(roleID, level);
        }
        return playerRole;
    }

    @Override
    public void setRenownLevel(long roleID, int level) {
        PlayerRole playerRole = getWriteModel(roleID, PlayerModel.class).getPlayer();
        playerRole.setRenownLevel(level);
        if(GlobalRoleID.isGlobalRoleID(roleID) == false) {
        	rankSet(ConstantRank.RENOWN_LEVEL, roleID, playerRole.getRenownLevel());
        	EventProvider.postPlayerAttrEvent(roleID, PlayerAttrEnum.RENOWN_LEVEL, playerRole.getRenownLevel());
        }
        log.info("roleID:{}, renownLevel:{}", roleID, level);
    }

    @Override
	public PlayerRole addAchievement(long roleID, long actionCount, ConfigAchievement configAchievement, ResourceBillEnum bill) {
    	PlayerRole playerRole = getWriteModel(roleID, PlayerModel.class).getPlayer();
    	playerRole.setAchievement(playerRole.getAchievement()+actionCount);
    	if(playerRole.getAchievement() >= configAchievement.getCount()) {
    		playerRole.setAchievementLevel(playerRole.getAchievementLevel()+1);
    		playerRole.setAchievement(0);
    		EventProvider.postPlayerAttrEvent(roleID, PlayerAttrEnum.ACHIEVEMENT_LEVEL, playerRole.getAchievementLevel());
    		log.info("roleID:{}, type:{}, resourceID:{}, resourceName:{}, count:{}, change:{}, bill:{}, desc:{}", roleID, PlayerAttrEnum.ACHIEVEMENT_LEVEL.getKey(), PlayerAttrEnum.ACHIEVEMENT_LEVEL.getKey(), "成就", playerRole.getAchievementLevel(), 1, bill, bill.getDesc());
    	}
    	EventProvider.postPlayerAttrEvent(roleID, PlayerAttrEnum.ACHIEVEMENT, playerRole.getAchievement());
    	log.info("roleID:{}, type:{}, resourceID:{}, resourceName:{}, count:{}, change:{}, bill:{}, desc:{}", roleID, PlayerAttrEnum.ACHIEVEMENT.getKey(), PlayerAttrEnum.ACHIEVEMENT.getKey(), "成就", playerRole.getAchievement(), actionCount, bill, bill.getDesc());
		return playerRole;
	}

	@Override
    public PlayerRole addShowTable(long roleID, long showTable) {
        PlayerRole playerRole = getWriteModel(roleID, PlayerModel.class).getPlayer();
        playerRole.setShowTable(playerRole.getShowTable() + showTable);
        rankSet(ConstantRank.SHOWTABLE, roleID, playerRole.getShowTable());
        ConfigShowTableLevelConf conf = ConfProvider.getConfigConfProvider().getConfigConf(IConfProvider.CONFIG_SHOWTABLELEVEL);
        if(conf == null){
            throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
        }
        int level = playerRole.getShowTableLevel();
        while (true) {
            ConfigShowTableLevel config = conf.getShowTableLevel(level);
            if (config == null) {
                break;
            }
            if (playerRole.getShowTable() < config.getUpLevelTotalExp()) {
                break;
            }
            level++;
        }
        level--;
        if (level > playerRole.getShowTableLevel()) {
            setShowTableLevel(roleID, level);
        }
        return playerRole;
    }

    @Override
    public PlayerRole costShowTable(long roleID, long showTable) {
        PlayerRole playerRole = getWriteModel(roleID, PlayerModel.class).getPlayer();
        if(playerRole.getShowTable() < showTable) {
        	showTable = playerRole.getShowTable();
        }
        playerRole.setShowTable(playerRole.getShowTable() - showTable);
        if(GlobalRoleID.isGlobalRoleID(roleID) == false) {
        	rankSet(ConstantRank.SHOWTABLE, roleID, playerRole.getShowTable());
        }
        ConfigShowTableLevelConf conf = ConfProvider.getConfigConfProvider().getConfigConf(IConfProvider.CONFIG_SHOWTABLELEVEL);
        if(conf == null){
            throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
        }
        int level = playerRole.getShowTableLevel();
        while (true) {
            ConfigShowTableLevel config = conf.getShowTableLevel(level);
            if (config == null) {
                break;
            }
            if (playerRole.getShowTable() > config.getUpLevelTotalExp()) {
                break;
            }
            level--;
        }
        if (level < playerRole.getShowTableLevel()) {
            setShowTableLevel(roleID, level);
        }
        return playerRole;
    }

    @Override
    public void setShowTableLevel(long roleID, int level) {
        PlayerRole playerRole = getWriteModel(roleID, PlayerModel.class).getPlayer();
        playerRole.setShowTableLevel(level);
        EventProvider.postPlayerAttrEvent(roleID, PlayerAttrEnum.SHOWTABLE_LEVEL, playerRole.getShowTableLevel());
        log.info("roleID:{}, showTableLevel:{}", roleID, level);
    }

    @Override
    public PlayerRole setRoleGuild(long roleID, long guildId) {
        PlayerRole playerRole = getWriteModel(roleID, PlayerModel.class).getPlayer();
        playerRole.setGuildId(guildId);
        return playerRole;
    }

    @Override
    public PlayerRole setLoginServerID(long roleID, int gateServerID, int playerServerID) {
        PlayerRole playerRole = getWriteModel(roleID, PlayerModel.class).getPlayer();
        playerRole.setGateServerID(gateServerID);
        playerRole.setPlayerServerID(playerServerID);
        playerRole.setCrossLogin(false);
        playerRole.setLastLoginTime(DateUtil.getCurrentDate());
        return playerRole;
    }

    // 改名字实现
    @Override
    public PlayerRole changeName(long roleID, String name) {
        PlayerRole playerRole = getWriteModel(roleID, PlayerModel.class).getPlayer();
        updatePlayerName(roleID, playerRole.getRoleName(), name);  // 更新palyerrole的名字字段  redis 里面
        playerRole.setRoleName(name);
        return playerRole;
    }

    @Override
    public PlayerRole changeSignature(long roleID, String signature) {
        PlayerRole playerRole = getWriteModel(roleID, PlayerModel.class).getPlayer();
        playerRole.setSignature(signature);
        return playerRole;
    }

    @Override
    public PlayerRole changeEcology(long roleID, long change) {
        PlayerRole playerRole = getWriteModel(roleID, PlayerModel.class).getPlayer();
        long ecology = playerRole.getEcology() + change;
        if (ecology < 0) {
            ecology = 0;
        }
        playerRole.setEcology(ecology);
        return playerRole;
    }

    @Override
    public PlayerRole changeBoom(long roleID, long change) {
        PlayerRole playerRole = getWriteModel(roleID, PlayerModel.class).getPlayer();
        long boom = playerRole.getBoom() + change;
        if (boom < 0) {
            boom = 0;
        }
        playerRole.setBoom(boom);
        return playerRole;
    }

    @Override
    public PlayerRole changeGuildPost(long roleID, int post) {
        PlayerRole playerRole = getWriteModel(roleID, PlayerModel.class).getPlayer();
        playerRole.setPost(post);
        return playerRole;
    }

	@Override
	public PlayerRole changeGuildScore(long roleID, long change) {
		PlayerRole playerRole = getWriteModel(roleID, PlayerModel.class).getPlayer();
        long guildScore = playerRole.getGuildScore() + change;
        if (guildScore < 0) {
        	guildScore = 0;
        }
        playerRole.setGuildScore(guildScore);
        return playerRole;
	}
    @Override
    public PlayerRole updateGuideId(long roleID, int guideId){
        PlayerRole playerRole = getWriteModel(roleID, PlayerModel.class).getPlayer();
        playerRole.setGuideId(guideId);
        return playerRole;
    }

    @Override
    public PlayerRole updateGuideState(long roleID, int guideState){
        PlayerRole playerRole = getWriteModel(roleID, PlayerModel.class).getPlayer();
        playerRole.setGuideState(guideState);
        return playerRole;
    }

    @Override
    public PlayerRole updateGuideTaskId(long roleID, int guideTaskId){
        PlayerRole playerRole = getWriteModel(roleID, PlayerModel.class).getPlayer();
        playerRole.setGuideTaskId(guideTaskId);
        return playerRole;
    }

    @Override
    public PlayerRole updateGuideTaskState(long roleID, int guideTaskId, int guideTaskState) {
        PlayerRole playerRole = getWriteModel(roleID, PlayerModel.class).getPlayer();
        playerRole.setGuideTaskId(guideTaskId);
        playerRole.setGuideTaskState(guideTaskState);
        return playerRole;
    }


    @Override
    public final List<Long> getAllPlayerRoleIds(){
        List<AbsModel> allModels = getAllModels(PlayerModel.class);
        List<Long> allRoles = new ArrayList<>();
        for(AbsModel mode : allModels){
            PlayerRole role = mode.getData().get(RedisKeys.KEY_PLAYER_ROLE);
            allRoles.add(role.getRoleID());
        }
        return allRoles;
    }

    @Override
    public void disposeCache(){
        super.saveModel();
        super.dispose();
    }
}
