package com.dj.serverapi.service;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.dj.domain.constant.ConstantRank;
import com.dj.domain.entity.global.GlobalGuild;
import com.dj.domain.entity.player.PlayerRole;
import com.dj.protobuf.CommonException;
import com.dj.protobuf.ErrorIDOuterClass.ErrorID;
import com.dj.protobuf.datetime.DateTime;
import com.dj.protobuf.leaderboard.GuildRankInfo;
import com.dj.protobuf.leaderboard.RankBaseInfo;
import com.dj.protobuf.leaderboard.RankGuildInfoNtf;
import com.dj.protobuf.leaderboard.RankSelfNearbyRsp;
import com.dj.protobuf.leaderboard.RankType;
import com.dj.protobuf.leaderboard.RoleRankCommonInfo;
import com.dj.protobuf.leaderboard.RoleRankCommonInfoNtf;
import com.dj.serverapi.ServiceProvider;
import com.dj.serverapi.redis.model.GuildModel;
import com.dj.serverapi.service.inf.IRankService;
import com.dj.servercore.conf.ConfigSundryConf;
import com.dj.servercore.redis.base.BaseService;
import com.dj.domain.util.StringUtil;
import com.google.common.collect.Lists;
import com.google.protobuf.GeneratedMessageV3;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;

@Slf4j
public class RankServiceImpl extends BaseService implements IRankService {

    @Override
    public GeneratedMessageV3 readRankTypeNtf(long roleID, RankType type) {
        log.info("roleID {}, type {}", roleID, type);
        GeneratedMessageV3 ntf = null;
        switch (type) {
            case ShowTable:
                ntf = readRoleRankCommonInfoNtf(roleID, type, ConstantRank.SHOWTABLE);
                break;
            case Renown:
                ntf = readRoleRankCommonInfoNtf(roleID, type, ConstantRank.RENOWN_LEVEL);
                break;
            case Level:
                ntf = readRoleRankCommonInfoNtf(roleID, type, ConstantRank.LEVEL);
                break;
            case Guilds:
                ntf = readRankGuildInfoNtf(roleID, ConstantRank.GUILDS);
                break;
            case GuildsLevel:
                ntf = readRankGuildInfoNtf(roleID, ConstantRank.GUILDS_LEVEL);
                break;
            case GuildsMember:
                ntf = readRankGuildInfoNtf(roleID, ConstantRank.GUILDS_MEMBER);
                break;
            default:
                break;
        }
        return ntf;
    }

    /**
     *	公会排行榜
     *
     * @param roleID
     * @param rankKey
     * @return
     */
    private GeneratedMessageV3 readRankGuildInfoNtf(long roleID, String rankKey) {
        RankGuildInfoNtf.Builder builder = RankGuildInfoNtf.newBuilder();
        Map<Long, Long> rankMap = getRankContainer().getRanksDesc(rankKey, 1, 50);
        if (rankMap.size() == 0) {
            // 排行榜为空，前端不显示，这里做补充数据用
            rankMap.put(0l, 0l);
        }
        int index = 1;
        List<GuildRankInfo> topN = Lists.newArrayList();
        for (Entry<Long, Long> entry : rankMap.entrySet()) {
            GlobalGuild guild = getReadModel(entry.getKey(), GuildModel.class).getGuild();
            if (guild != null) {
                RankBaseInfo.Builder rankBase = RankBaseInfo.newBuilder();
                rankBase.setId(entry.getKey());
                rankBase.setScore(entry.getValue().intValue());
                rankBase.setUpdateTime(DateTime.newBuilder());
                rankBase.setSeasonId(index);
                GuildRankInfo.Builder guildRankInfo = GuildRankInfo.newBuilder();
                guildRankInfo.setRankBase(rankBase.build());
                guildRankInfo.setName(guild.getName());
                guildRankInfo.setLevel(guild.getLevel());
                guildRankInfo.setHonor(guild.getExperience());
                guildRankInfo.setMembers(guild.getCurMemberNums());
                topN.add(guildRankInfo.build());
            }
        }
        builder.addAllTopN(topN);
        // 本商会排行
        PlayerRole playerRole = ServiceProvider.getPlayerService().getPlayer(roleID);
        if(ObjectUtils.isNotEmpty(playerRole.getGuildId())&&playerRole.getGuildId() > 0) {
            GlobalGuild guild = getReadModel(playerRole.getGuildId(), GuildModel.class).getGuild();
            if (guild != null) {
                RankBaseInfo.Builder rankBase = RankBaseInfo.newBuilder();
                rankBase.setId(playerRole.getGuildId());
                rankBase.setScore((int) rankGetScore(rankKey, playerRole.getGuildId()));
                rankBase.setUpdateTime(DateTime.newBuilder());
                int selfRank = rankGetRankDesc(rankKey, playerRole.getGuildId());
                selfRank--;
                rankBase.setSeasonId(selfRank);
                GuildRankInfo.Builder guildRankInfo = GuildRankInfo.newBuilder();
                guildRankInfo.setRankBase(rankBase.build());
                guildRankInfo.setName(guild.getName());
                guildRankInfo.setLevel(guild.getLevel());
                guildRankInfo.setHonor(guild.getExperience());
                guildRankInfo.setMembers(guild.getCurMemberNums());
                builder.setSelfInfo(guildRankInfo.build());
                builder.setSelfRank(selfRank);
            }
        }
        return builder.build();
    }

    /**
     *	通用角色排行榜通知
     *
     * @param roleID
     * @param type
     * @param rankKey
     * @return
     */
    private GeneratedMessageV3 readRoleRankCommonInfoNtf(long roleID, RankType type, String rankKey) {
        RoleRankCommonInfoNtf.Builder builder = RoleRankCommonInfoNtf.newBuilder();
        builder.setType(type);
        List<RoleRankCommonInfo> topN = Lists.newArrayListWithExpectedSize(50);
        Map<Long, Long> rankMap = getRankContainer().getRanksDesc(rankKey, 1, 50);
        int index = 1;
        RoleRankCommonInfo.Builder rankInfo = RoleRankCommonInfo.newBuilder();
        RankBaseInfo.Builder rankBase = RankBaseInfo.newBuilder();
        for (Entry<Long, Long> entry : rankMap.entrySet()) {
            PlayerRole playerRole = ServiceProvider.getPlayerService().getPlayer(entry.getKey());
            if(playerRole != null) {
                rankBase.setId(entry.getKey());
                rankBase.setScore(entry.getValue().intValue());
                rankBase.setSeasonId(index++);
                rankBase.setUpdateTime(DateTime.newBuilder().setValue(playerRole.getLevelTime()));
                rankInfo.setRankBase(rankBase.build());
                rankInfo.setRoleInfo(playerRole.toBaseRoleInfo());
                topN.add(rankInfo.build());
            }
        }
        builder.addAllTopN(topN);
        // 自己排行
        rankBase.setId(roleID);
        rankBase.setScore((int) rankGetScore(rankKey, roleID));
        int selfRank = rankGetRankDesc(rankKey, roleID);
        rankBase.setSeasonId(selfRank);
        rankInfo.setRankBase(rankBase.build());
        PlayerRole playerRole = ServiceProvider.getPlayerService().getPlayer(roleID);
        if(playerRole != null) {
            rankInfo.setRoleInfo(playerRole.toBaseRoleInfo());
        }
        builder.setSelfInfo(rankInfo.build());
        builder.setSelfRank(selfRank);
        return builder.build();
    }

    @Override
    public void updateGuildRank(long id, int score) {
        rankSet(ConstantRank.GUILDS, id, score);
    }

    @Override
    public void updateGuildLevelRank(long id, int level) {
        rankSet(ConstantRank.GUILDS_LEVEL, id, level);
    }

    @Override
    public void updateGuildMemberRank(long id, int member) {
        rankSet(ConstantRank.GUILDS_MEMBER, id, member);
    }

    @Override
    public void rankSelfNearbyReq(long roleID, RankType type, RankSelfNearbyRsp.Builder builder) {
        String rankKey = null;
        switch (type) {
            case ShowTable:
                rankKey = ConstantRank.SHOWTABLE;
                break;
            case Renown:
                rankKey = ConstantRank.RENOWN_LEVEL;
                break;
            case Level:
                rankKey = ConstantRank.LEVEL;
                break;
            default:
                break;
        }
        if (StringUtil.isEmpty(rankKey)) {
            throw new CommonException(ErrorID.COMMON_PARAM_ERROR, rankKey);
        }
        // 自己排名上下浮动排行榜
        int rankSelfNearby = ConfigSundryConf.rankSelfNearby;
        int selfRank = rankGetRankDesc(rankKey, roleID);
        int start = selfRank > rankSelfNearby ? selfRank - rankSelfNearby : 1;
        int end = selfRank + rankSelfNearby;
        List<RoleRankCommonInfo> ranks = Lists.newArrayListWithExpectedSize(50);
        Map<Long, Long> rankMap = getRankContainer().getRanksDesc(rankKey, start, end);
        RoleRankCommonInfo.Builder rankInfo = RoleRankCommonInfo.newBuilder();
        RankBaseInfo.Builder rankBase = RankBaseInfo.newBuilder();
        for (Entry<Long, Long> entry : rankMap.entrySet()) {
            rankBase.setId(entry.getKey());
            rankBase.setScore(entry.getValue().intValue());
            rankBase.setSeasonId(start++);
            PlayerRole playerRole = ServiceProvider.getPlayerService().getPlayer(entry.getKey());
            rankBase.setUpdateTime(DateTime.newBuilder().setValue(playerRole.getLevelTime()));
            rankInfo.setRankBase(rankBase.build());
            rankInfo.setRoleInfo(playerRole.toBaseRoleInfo());
            ranks.add(rankInfo.build());
        }
        builder.addAllRanks(ranks);
    }


    public void rankContainerClear() {
        getServiceContainer().getRankContainer().clear();
    }

    public void setRankInfo(String rankName, long uid, int score) {
        getServiceContainer().getRankContainer().set(rankName, uid, score);
    }
}
