package com.dj.serverapi.service.inf;

import com.dj.protobuf.leaderboard.RankSelfNearbyRsp;
import com.dj.protobuf.leaderboard.RankType;
import com.google.protobuf.GeneratedMessageV3;

public interface IRankService {

	/**
	 *	读取指定类型排行榜
	 * 
	 * @param roleID
	 * @param type
	 * @return
	 */
	GeneratedMessageV3 readRankTypeNtf(long roleID, RankType type);

	/**
	 *	更新商会总排行榜
	 *
	 * @param id
	 * @param score
	 */
	void updateGuildRank(long id, int score);

	/**
	 *	更新商会等级排行榜
	 * 
	 * @param id
	 * @param level
	 */
	void updateGuildLevelRank(long id, int level);

	/**
	 *	更新商会成员数量排行榜
	 * 
	 * @param id
	 * @param member
	 */
	void updateGuildMemberRank(long id, int member);

	/**
	 *	读取指定类型自己排名附近前后排行榜
	 * 
	 * @param roleID
	 * @param type
	 * @return
	 */
	void rankSelfNearbyReq(long roleID, RankType type, RankSelfNearbyRsp.Builder builder);

    void rankContainerClear();

	void setRankInfo(String rankName, long uid, int score);
}
