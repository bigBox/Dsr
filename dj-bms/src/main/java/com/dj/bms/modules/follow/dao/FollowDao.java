package com.dj.bms.modules.follow.dao;

import java.util.List;

import com.dj.bms.modules.topic.model.Topic;
import org.apache.ibatis.annotations.Param;

import com.dj.bms.common.dao.BaseDao;
import com.dj.bms.modules.follow.model.Follow;
import com.dj.bms.modules.post.model.Post;
import com.dj.bms.modules.user.model.User;

public interface FollowDao extends BaseDao<Follow> {

	/**
	 * 我关注的人
	 * @param start
	 * @param limit
	 * @param sourceId
	 * @return
	 */
	List<User> select(@Param("start") Integer start, @Param("limit") Integer limit, @Param("sourceId") Integer sourceId);

	/**
	 * 关注人的主题
	 * @param start
	 * @param limit
	 * @param sourceId
	 * @return
	 */
	List<Topic> selectTopic(@Param("start") Integer start, @Param("limit") Integer limit, @Param("sourceId") Integer sourceId);

	/**
	 * 关注我的人
	 * @param start
	 * @param limit
	 * @param targetId
	 * @return
	 */
	List<User> selectByFid(@Param("start") Integer start, @Param("limit") Integer limit, @Param("targetId") Integer targetId);

	/**
	 * 添加关注
	 * @param follow
	 * @return
	 */
	int insert(Follow follow);

	/**
	 * 取消关注
	 * @param sourceId
	 * @param targetId
	 * @return
	 */
	int delete(@Param("sourceId") Integer sourceId, @Param("targetId") Integer targetId);

	/**
	 * 统计用户关注的数量
	 * @param sourceId
	 * @return
	 */
	int countByUid(@Param("sourceId") Integer sourceId);

	/**
	 * 统计用户被关注的数量
	 * @param targetId
	 * @return
	 */
	int countByFid(@Param("targetId") Integer targetId);

	/**
	 * 判断是否已关注 0：否 1：是
	 * @param sourceId
	 * @param targetId
	 * @return
	 */
	int isFollow(@Param("sourceId") Integer sourceId, @Param("targetId") Integer targetId);

	/**
	 * 关注的人的主题的数量
	 * @param sourceId
	 * @return
	 */
	int countTopic(@Param("sourceId") Integer sourceId);
}
