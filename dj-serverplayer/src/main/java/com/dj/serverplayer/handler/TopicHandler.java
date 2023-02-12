package com.dj.serverplayer.handler;

import com.dj.domain.entity.global.GlobalGuild;
import com.dj.domain.entity.player.PlayerRole;
import com.dj.domain.enums.ResourceBillEnum;
import com.dj.domain.topic.GuildBattleSingUpEvent;
import com.dj.domain.topic.GuildChangeNameEvent;
import com.dj.domain.topic.GuildCreateEvent;
import com.dj.domain.type.AccessType;
import com.dj.domain.util.lib.QueryParamMap;
import com.dj.protobuf.CommonException;
import com.dj.protobuf.ErrorIDOuterClass.ErrorID;
import com.dj.protobuf.guild.CreateGuildReq;
import com.dj.serverapi.sensitiveword.SensitivewordFilter;
import com.dj.serverapi.topic.TopicManager;
import com.dj.servercore.Checker;
import com.dj.servercore.conf.ConfigSundryConf;
import com.dj.serverplayer.handler.base.BaseHandler;
import com.dj.serverplayer.manager.EventManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author zcq
 * @ClassName: TopicHandler
 * @Description: 跨服通讯业务处理，通过redis的topic异步处理消息
 * @date 2019年7月5日
 */
@Component
@Slf4j
public class TopicHandler extends BaseHandler {

    /**
     *	创建商会
     *
     * @param roleID
     * @param req
     */
    public void createGuild(long roleID, CreateGuildReq req) {
        // 检查商会名称是否合法
        if (!Checker.isValidGuildName(req.getName()) || SensitivewordFilter.isContainSensitiveWord(req.getName())) {
            log.error("createGuild 检查商会名称是否合法 roleID:{}", roleID);
            throw new CommonException(ErrorID.PLAYER_NAME_IS_ILLEGAL);
        }
        // 检查当前玩家是否已在商会里
        PlayerRole playerRole = playerService.getPlayer(roleID);
        if (playerRole.getGuildId() != 0) {
            GlobalGuild guild = guildService.getGuild(playerRole.getGuildId());
            if (guild != null) {
                log.error("createGuildguild != null roleID:{}", roleID);
                throw new CommonException(ErrorID.GUILD_HAS_JOIN);
            }
        }
        // 检测商会名称是否已存在
        QueryParamMap<String, Object> queryParams = new QueryParamMap<String, Object>(1);
        queryParams.put("name", req.getName());
        List<GlobalGuild> guilds = globalGuildDao.cacheLoadAll("name", req.getName(), roleID);
        if (guilds.size() > 0) {
            throw new CommonException(ErrorID.GUILD_NAME_HAS_EXIT);
        }else {
            guilds = globalGuildDao.selectList(queryParams, roleID, AccessType.DIRECT_DB);
            if (guilds.size() > 0) {
                throw new CommonException(ErrorID.GUILD_NAME_HAS_EXIT);
            }
        }
        // 检测令牌是否够
        checkItemEnough(roleID, req.getTokenID(), req.getTokenCount());
        // 发布创建商会主题
        GuildCreateEvent event = EventManager.borrowEvent(GuildCreateEvent.class);
        event.setRoleID(roleID);
        event.setTokenId(req.getTokenID());
        event.setTokenCount(req.getTokenCount());
        event.setAutoApproval(req.getAutoApproval());
        event.setName(req.getName());
        TopicManager.getInstance().publishTopic(event);
    }
    
    /**
     * 修改商会名称
     * @param roleID
     * @param name
     */
    public void changeGuildName(long roleID, String name) {
    	 // 检查商会名称是否合法
        if (!Checker.isValidGuildName(name) || SensitivewordFilter.isContainSensitiveWord(name)) {
            log.error("changeGuildName != null roleID:{} name:{}", roleID, name);
            throw new CommonException(ErrorID.PLAYER_NAME_IS_ILLEGAL);
        }
        PlayerRole playerRole = playerService.getPlayer(roleID);
        if (playerRole.getGuildId() == 0) {
            log.error("changeGuildName playerRole.getGuildId() == 0 roleID:{} name:{}", roleID, name);
        	throw new CommonException(ErrorID.GUILD_NO_JOIN);
        }
    	// 消耗改名卡
        //costItem(roleID, ConstantGame.CHANGE_NAME_CARD, 1, ResourceBillEnum.changeGuildName, false);
        // 发布修改商会名称主题
        GuildChangeNameEvent event = EventManager.borrowEvent(GuildChangeNameEvent.class);
        event.setRoleID(roleID);
        event.setGuildID(playerRole.getGuildId());
        event.setName(name);
        TopicManager.getInstance().publishTopic(event);
	}
    
    /**
     * 商会战斗报名
     * @param roleID
     */
	public void signUpGuildBattle(long roleID) {
		 // 消耗钻石
        costDiamond(roleID, ConfigSundryConf.signUpGuildBattleCostDiamod, ResourceBillEnum.signUpGuildBattle);
        // 通知全局服进行匹配
        GuildBattleSingUpEvent event = EventManager.borrowEvent(GuildBattleSingUpEvent.class);
        event.setRoleID(roleID);
        TopicManager.getInstance().publishTopic(event);
	}

}
