package com.dj.serverapi.helper;

import com.dj.domain.config.ConfigSummonExplore;
import com.dj.domain.data.Verify;
import com.dj.domain.data.guildBattle.GuildBattleBuildGame;
import com.dj.domain.data.summon.SummonPackage;
import com.dj.domain.entity.global.GlobalGuild;
import com.dj.domain.entity.player.PlayerRole;
import com.dj.domain.entity.player.PlayerVerify;
import com.dj.domain.entity.player.PlayerVerifyHistory;
import com.dj.domain.entity.robot.RobotVerify;
import com.dj.domain.util.DateUtil;
import com.dj.domain.util.inf.IArgumentRunnable;
import com.dj.protobuf.CommonException;
import com.dj.protobuf.ErrorIDOuterClass;
import com.dj.protobuf.common.BaseRoleInfo;
import com.dj.protobuf.guild.EGuildPost;
import com.dj.protobuf.guild.GuildBaseInfo;
import com.dj.protobuf.guild.GuildMemberInfo;
import com.dj.protobuf.guildBattle.BattleBuildListRsp;
import com.dj.protobuf.guildBattle.GuildBattleBuildInfo;
import com.dj.protobuf.summon.SummonMailInfo;
import com.dj.protobuf.verify.*;
import com.dj.serverapi.ServiceProvider;
import com.dj.servercore.conf.ConfigSummonsExploreConf;
import com.dj.servercore.conf.ConfigSundryConf;
import com.dj.servercore.conf.base.ConfProvider;
import com.dj.servercore.conf.base.IConfProvider;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author zcq
 * @ClassName: MessageHelper
 * @Description: 消息助手
 * @date 2019年7月31日
 */
public class MessageHelper {

    public static GuildBaseInfo toGuildBaseInfo(GlobalGuild guild) {
        GuildBaseInfo.Builder guildBaseInfo = GuildBaseInfo.newBuilder();
        guildBaseInfo.setId(guild.getId());
        guildBaseInfo.setName(guild.getName());
        guildBaseInfo.setLevel(guild.getLevel());
        guildBaseInfo.setExperience(guild.getExperience());
        guildBaseInfo.setSummary(guild.getSummary());
        // 会长信息
        PlayerRole chairmanRole = ServiceProvider.getPlayerService().getPlayer(guild.getChairman());
        GuildMemberInfo.Builder chairman = GuildMemberInfo.newBuilder();
        chairman.setBaseInfo(chairmanRole.toBaseRoleInfo());
        chairman.setGuildPost(EGuildPost.GuildPostChairMan);
        guildBaseInfo.setChairman(chairman);
        guildBaseInfo.setCurMemberNums(guild.getCurMemberNums());
        guildBaseInfo.setInnerSummary(guild.getInnerSummary());
        return guildBaseInfo.build();
    }

    public static void toVerifyQueues(List<PlayerVerify> verifyList, IArgumentRunnable<VerifyQueue> addQueueRun) {
    	if (verifyList == null || verifyList.size() == 0) {
            return;
        }
        Collections.sort(verifyList);
        VerifyQueue.Builder queue = VerifyQueue.newBuilder();
        int index = 0;
        for (PlayerVerify playerVerify : verifyList) {
        	addQueueRun.run(toVerifyQueue(queue, playerVerify, index));
            index++;
        }
    }

    public static void toRobotVerifyQueues(List<RobotVerify> verifyList, IArgumentRunnable<VerifyQueue> addQueueRun) {
        if (verifyList == null || verifyList.size() == 0) {
            return;
        }
        Collections.sort(verifyList);
        VerifyQueue.Builder queue = VerifyQueue.newBuilder();
        int index = 0;
        for (RobotVerify robotVerify : verifyList) {
            addQueueRun.run(toRobotVerifyQueue(queue, robotVerify, index));
            index++;
        }
    }

    private static VerifyQueue toRobotVerifyQueue(VerifyQueue.Builder builder, RobotVerify robotVerify, int index) {
        builder.setIndex(index);
        builder.clearVerifyRoleInfo();
        if (robotVerify.getVerifyID() == 0) {
            builder.setItemId(0);
            builder.setVerifyCD(0);
            builder.setState(EVerifyState.NoSelect);
        } else {
            // 参加鉴定的玩家
            List<Long> verifyRoleIDList = robotVerify.getVerifyRoleIDList();
            if(verifyRoleIDList != null) {
                BaseRoleInfo.Builder baseRoleInfo = BaseRoleInfo.newBuilder();
                for (Long verifyRoleID : verifyRoleIDList) {
                    PlayerRole verifyRole = ServiceProvider.getPlayerService().getPlayer(verifyRoleID);
                    if (verifyRole != null) {
                        builder.addVerifyRoleInfo(verifyRole.toBaseRoleInfo(baseRoleInfo));
                    }
                }
            }
            // 鉴定时间
            Date verifyFinishTime = robotVerify.getVerifyFinishTime();
            if((verifyFinishTime == null)||(verifyFinishTime.getTime() <= System.currentTimeMillis())) {
                // 鉴定结束
                builder.setItemId(robotVerify.getVerifyID());
                builder.setVerifyCD(0);
                builder.setState(EVerifyState.Verified);
            }else {
                // 鉴定中
                builder.setItemId(robotVerify.getVerifyID());
                int verifyCD = DateUtil.secondsBetween(DateUtil.getCurrentDate(), verifyFinishTime);
                builder.setVerifyCD(verifyCD);
                builder.setState(EVerifyState.Verifying);
            }
        }
        return builder.build();
    }

    private static VerifyQueue toVerifyQueue(VerifyQueue.Builder builder, PlayerVerify playerVerify, int index) {
        builder.setIndex(index);
        builder.clearVerifyRoleInfo();
        if (playerVerify.getVerifyID() == 0) {
            builder.setItemId(0);
            builder.setVerifyCD(0);
            builder.setState(EVerifyState.NoSelect);
        } else {
        	// 参加鉴定的玩家
        	List<Long> verifyRoleIDList = playerVerify.getVerifyRoleIDList();
            if(verifyRoleIDList != null) {
            	BaseRoleInfo.Builder baseRoleInfo = BaseRoleInfo.newBuilder();
            	for (Long verifyRoleID : verifyRoleIDList) {
            		PlayerRole verifyRole = ServiceProvider.getPlayerService().getPlayer(verifyRoleID);
                    if (verifyRole != null) {
                        builder.addVerifyRoleInfo(verifyRole.toBaseRoleInfo(baseRoleInfo));
                    }
				}
            }
        	// 鉴定时间
            Date verifyFinishTime = playerVerify.getVerifyFinishTime();
            if((verifyFinishTime == null)||(verifyFinishTime.getTime() <= System.currentTimeMillis())) {
            	// 鉴定结束
            	builder.setItemId(playerVerify.getVerifyID());
            	builder.setVerifyCD(0);
                builder.setState(EVerifyState.Verified);
            }else {
            	// 鉴定中
            	builder.setItemId(playerVerify.getVerifyID());
            	int verifyCD = DateUtil.secondsBetween(DateUtil.getCurrentDate(), verifyFinishTime);
            	builder.setVerifyCD(verifyCD);
                builder.setState(EVerifyState.Verifying);
            }
        }
        return builder.build();
    }

    public static void toVerifyItem(List<Verify> verifyList, IArgumentRunnable<VerifyItem> addItemRun, List<Integer> queuesList) {
        if (verifyList == null || verifyList.size() == 0) {
            return;
        }
        int verifyItemCount = ConfigSundryConf.verifyItemCount;
        VerifyItem.Builder item = VerifyItem.newBuilder();
        int count = 0;
        for (int i = verifyList.size() - 1; i >= 0; i--) {
            Verify verify = verifyList.get(i);
            if(!queuesList.contains(verify.getItemID())) {
                addItemRun.run(verify.toVerifyItem(item));
                count++;
                if (count >= verifyItemCount) {
                    break;
                }
            }
        }
    }
    
    public static void toVerifyHistories(List<PlayerVerifyHistory> list, VerifiedQueueRsp.Builder builder) {
    	if (list == null || list.size() == 0) {
            return;
        }
        int countLimit = 20;
        VerifyHistory.Builder history = VerifyHistory.newBuilder();
        BaseRoleInfo.Builder baseRoleInfo = BaseRoleInfo.newBuilder();
        for (int i = list.size() - 1; i >= 0; i--) {
            PlayerVerifyHistory playerVerifyHistory = list.get(i);
            PlayerRole role = ServiceProvider.getPlayerService().getPlayer(playerVerifyHistory.getVerifyRoleID());
            builder.addHistories(playerVerifyHistory.toVerifyHistory(history, role.toBaseRoleInfo(baseRoleInfo)));
            if (builder.getHistoriesCount() >= countLimit) {
                break;
            }
        }
	}

    public static SummonMailInfo toSummonMailInfo(SummonMailInfo.Builder builder, SummonPackage mail) {
        builder.setIndex(mail.getIndex());
        builder.setRewardGold(mail.getRewardGold());
        builder.clearRewardItem();
        builder.putAllRewardItem(mail.getRewardItem());
        ConfigSummonsExploreConf exploreConf = ConfProvider.getConfigConfProvider().getConfigConf(IConfProvider.CONFIG_SUMMONSEXPLORE);
        if(exploreConf == null){
            throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
        }
        ConfigSummonExplore exploreConfig = exploreConf.getSummonExplore(mail.getTerrainId());
        // 标题
        builder.setTitle(exploreConfig.getFuncName());
        // 归期时间
        String returnTime = DateUtil.formatDate(new Date(mail.getReturnTime()), DateUtil.STYLE4);
        builder.setReturnTime(returnTime);
        builder.setFirst(mail.getFirst());
        builder.setConfigMailID(mail.getConfigMailID());
        if(mail.getInvestDate() == null) {
        	builder.setInvestCountDown(-1);
        }else {
        	if(mail.getInvestDate().getTime() > System.currentTimeMillis()) {
            	builder.setInvestCountDown(DateUtil.secondsBetween(DateUtil.getCurrentDate(), mail.getInvestDate()));
            }else {
            	builder.setInvestCountDown(0);
            }
        }
        builder.setPositionX(mail.getPositionX());
        builder.setPositionY(mail.getPositionY());
        builder.setRewardType(mail.getRewardType());
        builder.setTerrainId(mail.getTerrainId());
        builder.setProcessed(mail.isProcessed()?1:0);
        return builder.build();
    }

    public static void toBattleBuildList(Map<Integer, GuildBattleBuildGame> buildMap, BattleBuildListRsp.Builder builder) {
        GuildBattleBuildInfo.Builder guildBattleBuilder = GuildBattleBuildInfo.newBuilder();
        BaseRoleInfo.Builder baseRoleInfoBuilder = BaseRoleInfo.newBuilder();
        for (Entry<Integer, GuildBattleBuildGame> entry : buildMap.entrySet()) {
        	BaseRoleInfo baseRoleInfo = null;
            if(entry.getValue().getHoldRoleID() > 0) {
            	PlayerRole role = ServiceProvider.getPlayerService().getPlayer(entry.getValue().getHoldRoleID());
            	baseRoleInfo = role.toBaseRoleInfo(baseRoleInfoBuilder);
            }
            guildBattleBuilder.clear();
            builder.addBuilds(entry.getValue().toGuildBattleBuildInfo(guildBattleBuilder, baseRoleInfo));
        }
	}
}
