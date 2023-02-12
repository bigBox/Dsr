package com.dj.bms.modules.follow.service;

import com.dj.bms.common.beans.Page;
import com.dj.bms.common.service.BaseService;
import com.dj.bms.modules.follow.dto.FollowDTO;
import com.dj.bms.modules.follow.model.Follow;
import com.dj.bms.modules.post.model.Post;
import com.dj.bms.modules.topic.model.Topic;
import com.dj.bms.modules.user.model.User;

public interface FollowService extends BaseService<Follow, FollowDTO> {

	/**
	 * 我关注的人
	 * @param pageNumber
	 * @param pageSize
	 * @param sourceId
	 * @return
	 */
	Page<User> page(Integer pageNumber, Integer pageSize, Integer sourceId);

	/**
	 * 关注人的主题
	 * @param pageNumber
	 * @param pageSize
	 * @param sourceId
	 * @return
	 */
	Page<Topic> pageTopic(Integer pageNumber, Integer pageSize, Integer sourceId);

	/**
	 * 关注我的人
	 * @param pageNumber
	 * @param pageSize
	 * @param targetId
	 * @return
	 */
	Page<User> followMe(Integer pageNumber, Integer pageSize, Integer targetId);

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
	int delete(Integer sourceId, Integer targetId);

	/**
	 * 统计用户关注的数量
	 * @param sourceId
	 * @return
	 */
	int countBySourceId(Integer sourceId);

	/**
	 * 统计用户被关注的数量
	 * @param targetId
	 * @return
	 */
	int countByTargetId(Integer targetId);

	/**
	 * 判断是否已关注 0：否 1：是
	 * @param sourceId
	 * @param targetId
	 * @return
	 */
	int isFollow(Integer sourceId, Integer targetId);
}
