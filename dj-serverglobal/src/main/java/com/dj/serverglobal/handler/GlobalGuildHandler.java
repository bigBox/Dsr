package com.dj.serverglobal.handler;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import com.dj.domain.entity.player.task.GuildTask;
import com.dj.domain.enums.TaskActionEnum;
import com.dj.domain.enums.TaskState;
import com.dj.domain.config.ConfigTasks;
import com.dj.domain.topic.*;
import com.dj.protobuf.ErrorIDOuterClass;
import com.dj.protobuf.ErrorIDOuterClass.ErrorID;
import com.dj.protobuf.guild.*;
import com.dj.protobuf.guildTask.GuildTaskRewardRsp;
import com.dj.serverapi.dao.task.GuildTaskDao;
import com.dj.servercore.conf.ConfigSundryConf;
import com.dj.servercore.conf.ConfigTasksConf;
import com.dj.servercore.conf.base.ConfProvider;
import com.dj.servercore.conf.base.IConfProvider;
import com.dj.serverglobal.manager.ServiceManager;
import com.dj.domain.util.StringUtil;
import com.dj.domain.util.collection.MapUtil;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dj.serverapi.sensitiveword.SensitivewordFilter;
import com.dj.domain.enums.PlayerAttrEnum;
import com.dj.domain.enums.ResourceBillEnum;
import com.dj.domain.type.AccessType;
import com.dj.domain.data.GuildApply;
import com.dj.domain.entity.global.GlobalGuild;
import com.dj.domain.entity.global.GlobalGuildMember;
import com.dj.domain.entity.player.PlayerRole;
import com.dj.protobuf.CommonException;
import com.dj.protobuf.datetime.DateTime;
import com.dj.protobuf.guildTask.GuildTaskAcceptRsp;
import com.dj.protobuf.guildTask.GuildTaskRemoveRsp;
import com.dj.protobuf.guildTask.GuildTaskSpeedUpRsp;
import com.dj.protobuf.task.ETaskType;
import com.dj.protobuf.task.TaskInfo;
import com.dj.serverapi.ServiceProvider;
import com.dj.serverapi.dao.GlobalGuildDao;
import com.dj.serverapi.dao.GlobalGuildMemberDao;
import com.dj.serverapi.helper.MessageHelper;
import com.dj.serverapi.topic.TopicManager;
import com.dj.servercore.event.AbsEventManager;
import com.dj.serverglobal.manager.ChannelManager;
import com.dj.serverglobal.manager.EventManager;
import com.dj.domain.util.DateUtil;
import com.dj.domain.util.lib.QueryParamMap;
import com.google.common.collect.Lists;

/**
 * @author zcq
 * @description 商会业务
 * @date 2019年4月26日
 */
@Slf4j
@Component
public class GlobalGuildHandler extends ServiceProvider {

    @Autowired
    public GlobalGuildDao globalGuildDao;
    @Autowired
    public GlobalGuildMemberDao globalGuildMemberDao;
    @Autowired
    public GuildTaskDao guildTaskDao;

    /**
     *	查询商会及成员信息
     *
     * @param roleID
     * @param builder
     */
    public void guildList(long roleID, GuildListReq req, GuildListRsp.Builder builder) {
        long guildId;
        if(req.getGuildId() > 0){
            guildId = req.getGuildId();
        }else {
            PlayerRole playerRole = ServiceProvider.getPlayerService().getPlayer(roleID);
            if (playerRole.getGuildId() == 0) {
                log.error("guildList playerRole.getGuildId() == 0 roleID:{}", roleID);
                throw new CommonException(ErrorID.GUILD_NO_JOIN);
            }
            guildId = playerRole.getGuildId();
        }
        GlobalGuild guild = globalGuildDao.cacheQuery(guildId, roleID);
        if (guild == null) {
            log.error("guildList guild == null roleID:{} guildId:{}", roleID, guildId);
            throw new CommonException(ErrorID.GUILD_NOT_EXIT);
        }
        // 商会基本信息
        GuildBaseInfo guildInfo = MessageHelper.toGuildBaseInfo(guild);
        builder.setGuilBaseInfo(guildInfo);
        // 商会成员信息
        List<GuildMemberInfo> members = Lists.newArrayList();
        QueryParamMap queryParams = new QueryParamMap();
        queryParams.put("guildID", guild.getId());
        List<GlobalGuildMember> lists = globalGuildMemberDao.selectList(queryParams, roleID, AccessType.DIRECT_DB);
        if((lists != null)&&(lists.size() > 0)) {
            GuildMemberInfo.Builder guildMemberInfo = GuildMemberInfo.newBuilder();
            lists.forEach(value -> {
                guildMemberInfo.setBaseInfo(ServiceProvider.getPlayerService().getPlayer(value.getRoleID()).toBaseRoleInfo());
                guildMemberInfo.setGuildPost(EGuildPost.forNumber(value.getPost()));
                members.add(guildMemberInfo.build());
            });
        }
        builder.addAllMembers(members);
    }

    /**
     *	修改公告
     *
     * @param roleID
     * @param req
     * @return
     */
    public void guildModifySummary(long roleID, GuildModifySummaryReq req, GuildModifySummaryRsp.Builder builder) {
    	builder.setType(req.getType());
        PlayerRole playerRole = ServiceProvider.getPlayerService().getPlayer(roleID);
        if (playerRole.getGuildId() == 0) {
            log.error("guildModifySummary playerRole.getGuildId() == 0 roleID:{} ", roleID);
            throw new CommonException(ErrorID.GUILD_NO_JOIN);
        }
        GlobalGuild guild = globalGuildDao.cacheQuery(playerRole.getGuildId(), playerRole.getRoleID());
        if (guild == null) {
            log.error("guildModifySummary guild == null roleID:{} ", roleID);
            throw new CommonException(ErrorID.GUILD_NOT_EXIT);
        }
        if(SensitivewordFilter.isContainSensitiveWord(req.getSummary())) {
        	if (req.getType() == SummaryType.External) {
        		builder.setSummary(guild.getSummary());
            } else {
            	builder.setSummary(guild.getInnerSummary());
            }
            log.error("guildModifySummary guild == null roleID:{}", roleID);
        	throw new CommonException(ErrorID.INPUT_WORD_IS_ILLEGAL);
        }
        if (req.getType() == SummaryType.External) {
            guild.setSummary(req.getSummary());
        } else {
            guild.setInnerSummary(req.getSummary());
        }
        globalGuildDao.cacheUpdate(guild, playerRole.getGuildId());
        ServiceProvider.getGuildService().setGuild(guild);
        builder.setSummary(req.getSummary());
    }

    /**
     *	申请加入
     *
     * @param roleID
     * @param req
     */
    public GuildApplyInfo guildApply(long roleID, GuildApplyReq req) {
        PlayerRole playerRole = ServiceProvider.getPlayerService().getPlayer(roleID);
        if ((ObjectUtils.isNotEmpty(playerRole.getGuildId()))&&(playerRole.getGuildId() > 0)) {
            QueryParamMap queryParams = new QueryParamMap();
            queryParams.put("roleID",roleID);
            queryParams.put("guildID", playerRole.getGuildId());
            GlobalGuildMember member = globalGuildMemberDao.cacheSelect(queryParams, playerRole.getGuildId());
            if (member != null) {
                log.error("guildApply member == null roleID:{}", roleID);
                throw new CommonException(ErrorID.GUILD_HAS_JOIN);
            }
        }
        GlobalGuild guild = globalGuildDao.cacheQuery(req.getGuildId(), roleID);
        if (guild == null) {
            log.error("guildApply guild == null roleID:{}", roleID);
            throw new CommonException(ErrorID.GUILD_NOT_EXIT);
        }
        GuildApply guildApply = ServiceProvider.getGuildService().guildApply(roleID, req.getGuildId());
        // 商会基本信息
        GuildBaseInfo guildInfo = MessageHelper.toGuildBaseInfo(guild);
        GuildApplyInfo.Builder applyInfo = GuildApplyInfo.newBuilder();
        applyInfo.setGuildInfo(guildInfo);
        applyInfo.setBaseInfo(playerRole.toBaseRoleInfo());
        applyInfo.setApplyTime(DateTime.newBuilder().setValue(guildApply.getApplyTime()));
        if(guild.getAutoApproval() > 0){
            // 自动通过
            // 添加成员
            GlobalGuildMember member = globalGuildMemberDao.cacheQuery(playerRole.getGuildId(), roleID);
            if (member == null) {
                member = new GlobalGuildMember(roleID);
                member.setGuildID(req.getGuildId());
                member.setPost(EGuildPost.GuildPostMember_VALUE);
                globalGuildMemberDao.cacheInsert(member, req.getGuildId());
            }else {
                member.setGuildID(req.getGuildId());
                globalGuildMemberDao.cacheUpdate(member, req.getGuildId());
            }
            // 更新商会人数
            List<GlobalGuildMember> members = globalGuildMemberDao.cacheLoadAll(req.getGuildId());
            guild.setCurMemberNums(members.size());
            globalGuildDao.cacheUpdate(guild, req.getGuildId());
            // 更新排行榜
            ServiceProvider.getRankService().updateGuildMemberRank(guild.getId(), guild.getCurMemberNums());
        }else {
            // 发送申请加入商会事件
            GuildApplyEvent event = EventManager.borrowEvent(GuildApplyEvent.class);
            event.setRoleID(roleID);
            event.setGuildId(req.getGuildId());
            event.setChairman(guild.getChairman());
            TopicManager.getInstance().publishTopic(event);
        }
        // 消耗令牌
        ServiceProvider.getItemService().addItemBill(roleID, req.getTokenID(), -req.getTokenCount(), ResourceBillEnum.guildApply, true, false);
        EventManager.postSyncItemEvent(roleID);
        return applyInfo.build();
    }

    /**
     *	商会批准
     *
     * @param roleID
     * @param req
     */
    public void guildApprove(long roleID, GuildApproveReq req, GuildApproveRsp.Builder builder) {
        // 会长判断
        PlayerRole playerRole = ServiceProvider.getPlayerService().getPlayer(roleID);
        if ((ObjectUtils.isEmpty(playerRole.getGuildId()))||(playerRole.getGuildId() == 0)) {
            log.error("guildApprove (ObjectUtils.isEmpty(playerRole.getGuildId()))||(playerRole.getGuildId() == 0) roleID:{}", roleID);
            throw new CommonException(ErrorID.GUILD_NO_JOIN);
        }
        ServiceProvider.getGuildService().guildApprove(req.getRoleId(), playerRole.getGuildId(), apply -> {
            if (req.getAgree()) {
                // 被批准人判断
                PlayerRole memberRole = ServiceProvider.getPlayerService().getPlayer(req.getRoleId());
                if ((ObjectUtils.isNotEmpty(playerRole.getGuildId()))&&(memberRole.getGuildId() > 0)) {
                    QueryParamMap queryParams = new QueryParamMap();
                    queryParams.put("roleID",memberRole.getRoleID());
                    queryParams.put("guildID", memberRole.getGuildId());
                    GlobalGuildMember member = globalGuildMemberDao.cacheSelect(queryParams, memberRole.getRoleID());
                    if (member != null) {
                        throw new CommonException(ErrorID.GUILD_HAS_JOIN);
                    }
                }
                // 添加成员
                QueryParamMap queryParams = new QueryParamMap();
                queryParams.put("roleID",memberRole.getRoleID());
                GlobalGuildMember member = globalGuildMemberDao.cacheSelect(queryParams, memberRole.getRoleID());
                if (member == null) {
                    member = new GlobalGuildMember(memberRole.getRoleID());
                   // member.setId(readModuleID(TableID.TABLE_GUILD_MEMBER));
                    member.setGuildID(playerRole.getGuildId());
                    member.setPost(EGuildPost.GuildPostMember_VALUE);
                    globalGuildMemberDao.cacheInsert(member, memberRole.getRoleID());
                }else {
                	member.setGuildID(playerRole.getGuildId());
                	globalGuildMemberDao.cacheUpdate(member, memberRole.getRoleID());
                }
                // 刷新后的普通成员列表
                GuildMemberInfo.Builder memberInfo = GuildMemberInfo.newBuilder();
                memberInfo.setBaseInfo(memberRole.toBaseRoleInfo());
                memberInfo.setGuildPost(EGuildPost.GuildPostMember);
                builder.setMemberInfo(memberInfo);
                builder.setOnline(memberRole.isOnline());
                // 更新商会人数
                GlobalGuild guild = globalGuildDao.cacheQuery(playerRole.getGuildId(), playerRole.getRoleID());
                QueryParamMap queryParams1 = new QueryParamMap();
                queryParams1.put("guildID",playerRole.getGuildId());
                List<GlobalGuildMember> lists = globalGuildMemberDao.selectList(queryParams1, playerRole.getRoleID(), AccessType.DIRECT_DB);
                if((lists != null)&&(lists.size() > 0)) {
                    guild.setCurMemberNums(lists.size());
                }else{
                    guild.setCurMemberNums(0);
                }
                globalGuildDao.cacheUpdate(guild, playerRole.getRoleID());
                // 更新排行榜
                ServiceProvider.getRankService().updateGuildMemberRank(guild.getId(), guild.getCurMemberNums());
                // 通知加入商会成功
                ServiceProvider.getPlayerService().setRoleGuild(req.getRoleId(), guild.getId());
                GuildApproveEvent event = AbsEventManager.borrowEvent(GuildApproveEvent.class);
                event.setRoleID(req.getRoleId());
                event.setGuildId(playerRole.getGuildId());
                event.setPost(playerRole.getPost());
                TopicManager.getInstance().publishTopic(event);
            }
        });
        GlobalGuild guild = globalGuildDao.cacheQuery(playerRole.getGuildId(), playerRole.getRoleID());
        ServiceProvider.getGuildService().setGuild(guild);
    }

    /**
     *	申请列表
     *
     * @param roleID
     * @return
     */
    public List<GuildApplyInfo> guildApplyList(long roleID) {
        PlayerRole playerRole = ServiceProvider.getPlayerService().getPlayer(roleID);
        if (playerRole.getGuildId() == 0) {
            log.error("guildApplyList playerRole.getGuildId() == null roleID:{}", roleID);
            throw new CommonException(ErrorID.GUILD_NO_JOIN);
        }
        Map<Long, GuildApply> applyMap = ServiceProvider.getGuildService().getGuildApplyMap(playerRole.getGuildId());
        if (applyMap != null && applyMap.size() > 0) {
            GlobalGuild guild = ServiceProvider.getGuildService().getGuild(playerRole.getGuildId());
            GuildBaseInfo guildInfo = MessageHelper.toGuildBaseInfo(guild);
            List<GuildApplyInfo> applies = Lists.newArrayListWithExpectedSize(applyMap.size());
            GuildApplyInfo.Builder info = GuildApplyInfo.newBuilder();
            for (Map.Entry<Long, GuildApply> entry : applyMap.entrySet()) {
                info.setGuildInfo(guildInfo);
                PlayerRole guildRole = ServiceProvider.getPlayerService().getPlayer(entry.getKey());
                info.setBaseInfo(guildRole.toBaseRoleInfo());
                info.setApplyTime(DateTime.newBuilder().setValue(entry.getValue().getApplyTime()));
                applies.add(info.build());
            }
            return applies;
        }
        return null;
    }

    /**
     *	商会成员列表
     *
     * @param roleID
     * @return
     */
    public List<GuildMemberInfo> guildMemberList(long roleID) {
        PlayerRole playerRole = ServiceProvider.getPlayerService().getPlayer(roleID);
        if (playerRole.getGuildId() == 0) {
            log.error("guildMemberList playerRole.getGuildId() == 0 roleID:{}", roleID);
            throw new CommonException(ErrorID.GUILD_NO_JOIN);
        }
        List<GuildMemberInfo> members = Lists.newArrayList();
        QueryParamMap queryParams1 = new QueryParamMap();
        queryParams1.put("guildID",playerRole.getGuildId());
        List<GlobalGuildMember> lists = globalGuildMemberDao.selectList(queryParams1, playerRole.getRoleID(), AccessType.DIRECT_DB);
        if((lists != null)&&(lists.size() > 0)) {
            GuildMemberInfo.Builder guildMemberInfo = GuildMemberInfo.newBuilder();
            lists.forEach(value -> {
                guildMemberInfo.setBaseInfo(ServiceProvider.getPlayerService().getPlayer(value.getRoleID()).toBaseRoleInfo());
                guildMemberInfo.setGuildPost(EGuildPost.forNumber(value.getPost()));
                members.add(guildMemberInfo.build());
            });
        }
        return members;
    }

    /**
     * 退出商会
     * @param roleID
     * @param reason
     * @return
     */
    public GuildBaseInfo quitGuild(long roleID, EGuildQuitReson reason) {
    	PlayerRole playerRole = ServiceProvider.getPlayerService().getPlayer(roleID);
    	if (playerRole.getGuildId() == 0) {
            log.error("quitGuild playerRole.getGuildId() == 0 roleID:{}", roleID);
            throw new CommonException(ErrorID.GUILD_NO_JOIN);
        }
		return quitGuild(roleID, playerRole.getGuildId(), reason);
	}
    
    /**
     *	退出商会
     *
     * @param roleID
     * @return
     */
    public GuildBaseInfo quitGuild(long roleID, long guildID, EGuildQuitReson reason) {
        GlobalGuild guild = globalGuildDao.cacheQuery(guildID, roleID);
        if (guild.getChairman() == roleID) {
            // 社长不能退，请先转让探险社
            log.error("quitGuild guild.getChairman() == roleID roleID:{}", roleID);
            throw new CommonException(ErrorID.GUILD_CANNT_EXIT);
        }
        globalGuildMemberDao.cacheDelete(roleID, roleID);
        // 更新商会人数
        QueryParamMap queryParams = new QueryParamMap();
        queryParams.put("guildID",guildID);
        List<GlobalGuildMember> lists = globalGuildMemberDao.selectList(queryParams, roleID, AccessType.DIRECT_DB);
        if((lists != null)&&(lists.size() > 0)) {
            guild.setCurMemberNums(lists.size());
        }
        globalGuildDao.cacheUpdate(guild, guildID);
        ServiceProvider.getGuildService().setGuild(guild);
        // 更新排行榜
        ServiceProvider.getRankService().updateGuildMemberRank(guild.getId(), guild.getCurMemberNums());
        GuildBaseInfo guildBaseInfo = MessageHelper.toGuildBaseInfo(guild);
        // 被踢出 ,通知被踢的玩家
        if (reason == EGuildQuitReson.GuildQuitKicked) {
            GuildQuitNtf.Builder ntf = GuildQuitNtf.newBuilder();
            ntf.setReason(reason);
            ntf.setGuildBaseInfo(guildBaseInfo);
	        PlayerRole playerRole = ServiceProvider.getPlayerService().getPlayer(roleID);
            ChannelManager.getInstance().sendGlobalGuildToGate(playerRole.getGateServerID(), roleID, ntf.build());
        }
        ServiceProvider.getPlayerService().setRoleGuild(roleID, 0);
        // 通知退出商会
        GuildQuitEvent event = AbsEventManager.borrowEvent(GuildQuitEvent.class);
        event.setRoleID(roleID);
        TopicManager.getInstance().publishTopic(event);
        return guildBaseInfo;
    }

    /**
     *	踢出商会
     *
     * @param chairman
     * @param roleID
     * @return
     */
    public GuildBaseInfo guildKick(long chairman, long roleID) {
        PlayerRole playerRole = ServiceProvider.getPlayerService().getPlayer(chairman);
        if (playerRole.getGuildId() == 0) {
            log.error("quitGuild playerRole.getGuildId() == 0 roleID:{}", roleID);
            throw new CommonException(ErrorID.GUILD_NO_JOIN);
        }
        GlobalGuild guild = globalGuildDao.cacheQuery(playerRole.getGuildId(), playerRole.getRoleID());
        if (guild.getChairman() != chairman) {
            throw new CommonException(ErrorID.GUILD_POST_NOT_ENOUGH);
        }
        return quitGuild(roleID, playerRole.getGuildId(), EGuildQuitReson.GuildQuitKicked);
    }

    /**
     *	调整商会职位
     *
     * @param chairman
     * @param roleID
     * @param post
     * @return
     */
    public GuildMemberInfo guildAdjustPost(long chairman, long roleID, EGuildPost post) {
        PlayerRole playerRole = ServiceProvider.getPlayerService().getPlayer(roleID);
        if (playerRole.getGuildId() == 0) {
            log.error("guildAdjustPost playerRole.getGuildId() == 0 roleID:{}", roleID);
            throw new CommonException(ErrorID.GUILD_NO_JOIN);
        }
        GlobalGuild guild = globalGuildDao.cacheQuery(playerRole.getGuildId(), roleID);
        if (guild.getChairman() != chairman) {
            log.error("guildAdjustPost guild.getChairman() != chairman roleID:{}", roleID);
            throw new CommonException(ErrorID.GUILD_POST_NOT_ENOUGH);
        }
        QueryParamMap queryParams = new QueryParamMap();
        queryParams.put("roleID",roleID);
        queryParams.put("guildID", playerRole.getGuildId());
        GlobalGuildMember member = globalGuildMemberDao.cacheSelect(queryParams, roleID);
        member.setPost(post.getNumber());
        playerRole = ServiceProvider.getPlayerService().changeGuildPost(roleID, post.getNumber());
        globalGuildMemberDao.cacheUpdate(member, playerRole.getRoleID());
        GuildApproveEvent event = AbsEventManager.borrowEvent(GuildApproveEvent.class);
        event.setRoleID(roleID);
        event.setGuildId(playerRole.getGuildId());
        event.setPost(post.getNumber());
        TopicManager.getInstance().publishTopic(event);
        if (post == EGuildPost.GuildPostChairMan) {
            // 任命会长
            // 老会长变普通会员
            QueryParamMap queryParams1 = new QueryParamMap();
            queryParams1.put("roleID",chairman);
            queryParams1.put("guildID", playerRole.getGuildId());
            GlobalGuildMember chairman_member = globalGuildMemberDao.cacheSelect(queryParams1, playerRole.getRoleID());
            PlayerRole chairmanRole = ServiceProvider.getPlayerService().changeGuildPost(chairman, EGuildPost.GuildPostMember_VALUE);
            globalGuildMemberDao.cacheUpdate(chairman_member, chairmanRole.getRoleID());
            guild.setChairman(roleID);
            globalGuildDao.cacheUpdate(guild, chairmanRole.getRoleID());
            ServiceProvider.getGuildService().setGuild(guild);
            GuildApproveEvent event1 = AbsEventManager.borrowEvent(GuildApproveEvent.class);
            event1.setRoleID(chairman);
            event1.setGuildId(chairmanRole.getGuildId());
            event1.setPost( EGuildPost.GuildPostMember_VALUE);
            TopicManager.getInstance().publishTopic(event1);
        }
        GuildMemberInfo.Builder memberInfo = GuildMemberInfo.newBuilder();
        memberInfo.setBaseInfo(playerRole.toBaseRoleInfo());
        memberInfo.setGuildPost(post);
        return memberInfo.build();
    }

    /**
     *	商会搜索
     *
     * @param req
     * @return
     */
    public void guildSearch(long roleID, GuildSearchReq req, GuildSearchRsp.Builder builder) {
        QueryParamMap<String, Object> queryParams = new QueryParamMap<>(1);
        if (req.getType() == EGuildSearchType.GuildSearchById) {
            queryParams.put("likeId", "%" + req.getId() + "%");
        } else {
            queryParams.put("likeName", "%" + req.getName() + "%");
        }
        List<GlobalGuild> list = globalGuildDao.selectList(queryParams, roleID, AccessType.DIRECT_DB);
        if (list == null || list.size() == 0) {
            return;
        }
        list.forEach(value -> {
        	builder.addGuilds(MessageHelper.toGuildBaseInfo(value));
        });
    }

    /**
     * 请求商会任务列表
     * @param roleID
     * @return
     */
	public List<TaskInfo> guildTaskList(long roleID) {
		PlayerRole playerRole = ServiceProvider.getPlayerService().getPlayer(roleID);
        if (playerRole.getGuildId() == 0) {
            log.error("guildTaskList playerRole.getGuildId() == 0 roleID:{}", roleID);
            throw new CommonException(ErrorID.GUILD_NO_JOIN);
        }
        return guildTaskDao.toTaskInfos(roleID, playerRole.getGuildId());
	}

	/**
	 * 接受商会任务
	 * @param roleID
	 * @param taskID
	 */
	public void guildTaskAccept(long roleID, int taskID, int index, GuildTaskAcceptRsp.Builder builder) {
		PlayerRole playerRole = ServiceProvider.getPlayerService().getPlayer(roleID);
        if (playerRole.getGuildId() == 0) {
            log.error("guildTaskAccept playerRole.getGuildId() == 0 roleID:{}", roleID);
            throw new CommonException(ErrorID.GUILD_NO_JOIN);
        }
        if(ServiceProvider.getCommonService().getAcceptTypeTask(roleID, ETaskType.Guild_VALUE) > 0) {
            log.error("guildTaskAccept TASK_GUILD_CANNT_TWO_ACCEPT roleID:{}", roleID);
        	throw new CommonException(ErrorID.TASK_GUILD_CANNT_TWO_ACCEPT);
        }
        QueryParamMap queryParams = new QueryParamMap();
        queryParams.put("taskID",taskID);
        queryParams.put("guildID",playerRole.getGuildId());
        GuildTask guildTask = guildTaskDao.cacheSelect(queryParams, playerRole.getGuildId());
        if(guildTask == null){
            throw new CommonException(ErrorID.COMMON_PARAM_ERROR);
        }
        if(guildTask.getState()!=TaskState.noAccept.getState())return;
        if (StringUtil.isNotEmpty0Null(guildTask.getNeedItem())) {
            guildTask.setNeedItemMap(MapUtil.stringToMap(guildTask.getNeedItem(),";","-"));
        }else {
            guildTask.setNeedItemMap(Maps.newHashMapWithExpectedSize(0));
        }
        if (StringUtil.isNotEmpty0Null(guildTask.getCurItem())) {
            guildTask.setCurItemMap(MapUtil.stringToMap(guildTask.getCurItem(),";","-"));
        }else {
            guildTask.setCurItemMap(Maps.newHashMapWithExpectedSize(0));
        }
        Date nowDate = DateUtil.getCurrentDate();
        if(guildTask.getCdEndTime() != null && guildTask.getCdEndTime().getTime() > nowDate.getTime()) {
        	throw new CommonException(ErrorID.COMMON_PARAM_ERROR);
        }
        guildTask.setState(TaskState.accept.getState());
        guildTaskDao.cacheUpdate(guildTask, roleID);
        builder.setTask(guildTask.toTaskInfo());
        //玩家接受任务
        GuildAcceptTaskEvent event = AbsEventManager.borrowEvent(GuildAcceptTaskEvent.class);
        event.setGuildID(playerRole.getGuildId());
        event.setRoleID(roleID);
        event.setTaskID(taskID);
        event.setIndex(index);
        TopicManager.getInstance().publishTopic(event);

        //更新任务
        //GuildTask newGuildTask = (GuildTask)guildTaskDao.flushTask(guildTask);
        ServiceProvider.getCommonService().setAcceptTypeTask(roleID, ETaskType.Guild_VALUE, guildTask.getTaskID());

        //通知商会成员有任务更新
        GuildTaskUpdateEvent updateEvent = AbsEventManager.borrowEvent(GuildTaskUpdateEvent.class);
        updateEvent.setGuildID(guildTask.getGuildID());
        updateEvent.setTaskInfo(guildTask.toTaskInfo());
        EventManager.postAsyncEvent(updateEvent);
	}

	/**
	 * 商会任务删除（撕单）
	 * @param roleID
	 * @param taskID
	 * @param builder
	 */
	public void guildTaskRemove(long roleID, int taskID, int index, GuildTaskRemoveRsp.Builder builder) {
		PlayerRole playerRole = ServiceProvider.getPlayerService().getPlayer(roleID);
        if (playerRole.getGuildId() == 0) {
            log.error("guildTaskRemove playerRole.getGuildId() == 0 roleID:{}", roleID);
            throw new CommonException(ErrorID.GUILD_NO_JOIN);
        }
        QueryParamMap queryParams = new QueryParamMap();
        queryParams.put("taskID",taskID);
        queryParams.put("guildID",playerRole.getGuildId());
        GuildTask guildTask = guildTaskDao.cacheSelect(queryParams, playerRole.getGuildId());
        if(guildTask == null){
            log.error("guildTaskRemove guildTask == null roleID:{}", roleID);
            throw new CommonException(ErrorID.COMMON_PARAM_ERROR);
        }
        if (StringUtil.isNotEmpty0Null(guildTask.getNeedItem())) {
            guildTask.setNeedItemMap(MapUtil.stringToMap(guildTask.getNeedItem(),";","-"));
        }else {
            guildTask.setNeedItemMap(Maps.newHashMapWithExpectedSize(0));
        }
        if (StringUtil.isNotEmpty0Null(guildTask.getCurItem())) {
            guildTask.setCurItemMap(MapUtil.stringToMap(guildTask.getCurItem(),";","-"));
        }else {
            guildTask.setCurItemMap(Maps.newHashMapWithExpectedSize(0));
        }
        if(guildTask.getState() == TaskState.accept.getState()){
            return;
        }
        guildTask.setState(TaskState.teared.getState());
        guildTask.setCdEndTime(DateUtil.plusNow(TimeUnit.SECONDS, ConfigSundryConf.guildTaskTearSheet));
        builder.setTask(guildTask.toTaskInfo());
        guildTaskDao.cacheUpdate(guildTask, roleID);

        //guildTaskDao.deleteTask(playerRole.getRoleID(), guildTask);
        //guildTaskDao.removeTask(guildTask, DateUtil.plusNow(TimeUnit.MINUTES, 30));
        //更新任务
        //GuildTask newGuildTask = (GuildTask)guildTaskDao.flushTask(guildTask);
        ////ServiceProvider.getCommonService().setAcceptTypeTask(roleID, ETaskType.Guild_VALUE, newGuildTask.getTaskID());
        //if(newGuildTask != null) {
        //    TaskInfo newTaskInfo = newGuildTask.toTaskInfo();
        //    builder.setTask(newTaskInfo);
        //    //通知商会成员有任务更新
        //    GuildTaskUpdateEvent updateEvent = AbsEventManager.borrowEvent(GuildTaskUpdateEvent.class);
        //    updateEvent.setGuildID(newGuildTask.getGuildID());
        //    updateEvent.setTaskInfo(newTaskInfo);
        //    EventManager.postAsyncEvent(updateEvent);
        //}
	}

	/**
	 * 商会任务加速
	 * @param roleID
	 * @param taskID
	 * @param builder
	 */
	public void guildTaskSpeedUp(long roleID, int taskID, int index, GuildTaskSpeedUpRsp.Builder builder) {
		PlayerRole playerRole = ServiceProvider.getPlayerService().getPlayer(roleID);
        if (playerRole.getGuildId() == 0) {
            log.error("guildTaskSpeedUp playerRole.getGuildId() == 0 roleID:{}", roleID);
            throw new CommonException(ErrorID.GUILD_NO_JOIN);
        }
        QueryParamMap queryParams = new QueryParamMap();
        queryParams.put("taskID",taskID);
        queryParams.put("guildID",playerRole.getGuildId());
        GuildTask guildTask = guildTaskDao.cacheSelect(queryParams, playerRole.getGuildId());
        if(guildTask == null){
            log.error("guildTaskSpeedUp guildTask == null roleID:{}", roleID);
            throw new CommonException(ErrorID.COMMON_PARAM_ERROR);
        }
        if(guildTask.getCdEndTime() == null) {
            log.error("guildTaskSpeedUp guildTask.getCdEndTime() == null roleID:{}", roleID);
        	throw new CommonException(ErrorID.COMMON_PARAM_ERROR);
        }
        Date nowDate = DateUtil.getCurrentDate();
        if(guildTask.getCdEndTime().getTime() <= nowDate.getTime()) {
            log.error("guildTaskSpeedUp guildTask.getCdEndTime().getTime() <= nowDate.getTime() roleID:{}", roleID);
        	throw new CommonException(ErrorID.COMMON_PARAM_ERROR);
        }
        int minute = DateUtil.minutesBetween(nowDate, guildTask.getCdEndTime());
        if(playerRole.getDiamond() < minute) {
            log.error("guildTaskSpeedUp playerRole.getDiamond() < minute roleID:{}", roleID);
        	throw new CommonException(ErrorID.COMMON_PLAYER_DIAMOND_LESS);
        }
        if(guildTask.getState() == TaskState.accept.getState()){
            if (StringUtil.isNotEmpty0Null(guildTask.getNeedItem())) {
                guildTask.setNeedItemMap(MapUtil.stringToMap(guildTask.getNeedItem(),";","-"));
            }else {
                guildTask.setNeedItemMap(Maps.newHashMapWithExpectedSize(0));
            }
            if (StringUtil.isNotEmpty0Null(guildTask.getCurItem())) {
                guildTask.setCurItemMap(MapUtil.stringToMap(guildTask.getCurItem(),";","-"));
            }else {
                guildTask.setCurItemMap(Maps.newHashMapWithExpectedSize(0));
            }
            guildTask.setState(TaskState.complete.getState());
            guildTask.setCdEndTime(null);
            guildTaskDao.cacheUpdate(guildTask, roleID);
            EventManager.postSyncAttrEvent(roleID);
            EventManager.commitRoleEvent(roleID);
            builder.setTask(guildTask.toTaskInfo());
        }else if(guildTask.getState() == TaskState.teared.getState()){
            guildTask.setState(TaskState.noAccept.getState());
            guildTask.setCdEndTime(null);
            guildTaskDao.deleteTask(playerRole.getRoleID(), guildTask);
            //更新任务
            GuildTask newGuildTask = (GuildTask)guildTaskDao.flushTask(guildTask);
            if(newGuildTask != null) {
                TaskInfo newTaskInfo = newGuildTask.toTaskInfo();
                builder.setTask(newTaskInfo);
                //通知商会成员有任务更新
                GuildTaskUpdateEvent updateEvent = AbsEventManager.borrowEvent(GuildTaskUpdateEvent.class);
                updateEvent.setGuildID(newGuildTask.getGuildID());
                updateEvent.setTaskInfo(newTaskInfo);
                EventManager.postAsyncEvent(updateEvent);
            }
        }else{
            throw new CommonException(ErrorID.COMMON_PARAM_ERROR);
        }
        ServiceProvider.getCommonService().addAttrBill(roleID, PlayerAttrEnum.DIAMOND.getKey(), -minute, ResourceBillEnum.guildTaskSpeedUp);
	}

    /**
     * 商会任务奖励
     * @param roleID
     * @param taskID
     * @param builder
     */
    public void guildTaskReward(long roleID, int taskID, int index, GuildTaskRewardRsp.Builder builder) {
        PlayerRole playerRole = ServiceProvider.getPlayerService().getPlayer(roleID);
        if (playerRole.getGuildId() == 0) {
            log.error("guildTaskReward playerRole.getGuildId() == 0 roleID:{}", roleID);
            throw new CommonException(ErrorID.GUILD_NO_JOIN);
        }
        QueryParamMap queryParams = new QueryParamMap();
        queryParams.put("taskID",taskID);
        queryParams.put("guildID",playerRole.getGuildId());
        GuildTask guildTask = guildTaskDao.cacheSelect(queryParams, playerRole.getGuildId());
        if(guildTask == null){
            log.error("guildTaskReward guildTask == null roleID:{}", roleID);
            throw new CommonException(ErrorID.COMMON_PARAM_ERROR);
        }
        if (StringUtil.isNotEmpty0Null(guildTask.getNeedItem())) {
            guildTask.setNeedItemMap(MapUtil.stringToMap(guildTask.getNeedItem(),";","-"));
        }else {
            guildTask.setNeedItemMap(Maps.newHashMapWithExpectedSize(0));
        }
        if (StringUtil.isNotEmpty0Null(guildTask.getCurItem())) {
            guildTask.setCurItemMap(MapUtil.stringToMap(guildTask.getCurItem(),";","-"));
        }else {
            guildTask.setCurItemMap(Maps.newHashMapWithExpectedSize(0));
        }
        if (guildTask.getState() != TaskState.complete.getState()) {
            log.error("guildTaskReward guildTask.getState() != TaskState.complete.getState() roleID:{}", roleID);
            throw new CommonException(ErrorID.TASK_NOT_FINISH, roleID + ":" +roleID + "- taskID" + taskID);
        }
        guildTask.setState(TaskState.award.getState());
        guildTaskDao.cacheUpdate(guildTask, roleID);

        ConfigTasksConf conf = ConfProvider.getConfigConfProvider().getConfigConf(IConfProvider.CONFIG_TASKS);
        if(conf == null){
            log.error("guildTaskReward conf == null roleID:{}", roleID);
            throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
        }
        ConfigTasks config = conf.getTask(guildTask.getTaskID());
        // 添加个人商会积分
        playerRole = ServiceProvider.getPlayerService().changeGuildScore(roleID, config.getGuildScore());
        EventManager.postSyncAttrEvent(roleID);
        log.info("roleID:{}, type:{}, resourceID:{}, resourceName:{}, count:{}, change:{}, bill:{}, desc:{}",
                roleID, PlayerAttrEnum.GUILDSCORE.getKey(), PlayerAttrEnum.GUILDSCORE.getKey(), "商会积分",
                playerRole.getGuildScore(), config.getGuildScore(), ResourceBillEnum.taskReward, ResourceBillEnum.taskReward.getDesc());
        // 为商会添加经验
        GuildLevelEvent guildLevelEvent = EventManager.borrowEvent(GuildLevelEvent.class);
        guildLevelEvent.setRoleID(roleID);
        guildLevelEvent.setGuildID(playerRole.getGuildId());
        guildLevelEvent.setGuildScore(config.getGuildScore());
        TopicManager.getInstance().publishTopic(guildLevelEvent);

        // 更新接受任务类型标记
        ServiceManager.getCommonService().setAcceptTypeTask(roleID, ETaskType.Guild_VALUE, -1);
        GuildTask newGuildTask = (GuildTask)guildTaskDao.flushTask(guildTask);
        builder.setTask(newGuildTask.toTaskInfo());
        EventManager.postTaskActionEvent(roleID, TaskActionEnum.FINISH_GUILD_TASK, 1);
        EventManager.commitRoleEvent(roleID);
    }
}
