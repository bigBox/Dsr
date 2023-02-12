package com.dj.bms.modules.follow.service.impl;

import java.util.List;
import java.util.function.Function;

import com.dj.bms.common.beans.Page;
import com.dj.bms.common.dao.BaseDao;
import com.dj.bms.common.service.impl.AbstractBaseServiceImpl;
import com.dj.bms.modules.collect.model.Collect;
import com.dj.bms.modules.follow.dao.FollowDao;
import com.dj.bms.modules.follow.dto.FollowDTO;
import com.dj.bms.modules.follow.model.Follow;
import com.dj.bms.modules.follow.service.FollowService;
import com.dj.bms.modules.post.model.Post;
import com.dj.bms.modules.topic.model.Topic;
import com.dj.bms.modules.user.model.User;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FollowServiceImpl extends AbstractBaseServiceImpl<Follow, FollowDTO> implements FollowService {

	@Autowired
	private FollowDao followDao;
	
	/**
	 * 我关注的人
	 */
	@Override
	public Page<User> page(Integer pageNumber, Integer pageSize, Integer uid) {
		int total = followDao.countByUid(uid);
		List<User> list = followDao.select((pageNumber - 1) * pageSize, pageSize, uid);
		return new Page<>(list, pageNumber, pageSize, total);
	}

	/**
	 * 关注
	 */
	@Override
	public int insert(Follow follow) {
		return followDao.insert(follow);
	}

	/**
	 * 取消关注
	 */
	@Override
	public int delete(Integer uid, Integer fid) {
		return followDao.delete(uid, fid);
	}

	/**
	 * 我关注的数量
	 */
	@Override
	public int countBySourceId(Integer uid) {
		return followDao.countByUid(uid);
	}

	/**
	 * 我被关注的数量
	 */
	@Override
	public int countByTargetId(Integer fid) {
		return followDao.countByFid(fid);
	}

	/**
	 * 我是否已关注了
	 */
	@Override
	public int isFollow(Integer uid, Integer fid) {
		return followDao.isFollow(uid, fid);
	}

	/**
	 * 关注我的人
	 */
	@Override
	public Page<User> followMe(Integer pageNumber, Integer pageSize, Integer fid) {
		int total = followDao.countByFid(fid);
		List<User> list = followDao.selectByFid((pageNumber - 1) * pageSize, pageSize, fid);
		return new Page<>(list, pageNumber, pageSize, total);
	}

	/**
	 * 关注的人的主题
	 */
	@Override
	public Page<Topic> pageTopic(Integer pageNumber, Integer pageSize, Integer sourceId) {
		int total = followDao.countTopic(sourceId);
		List<Topic> list = followDao.selectTopic((pageNumber - 1) * pageSize, pageSize, sourceId);
		return new Page<>(list, pageNumber, pageSize, total);
	}

	@Override
	public Function<? super FollowDTO, ? extends Follow> getDTO2DOMapper() {
		return followDTO -> {
			Follow follow = new Follow();
			if (followDTO != null) {
				BeanUtils.copyProperties(followDTO, follow);
			}
			return follow;
		};
	}

	@Override
	public Function<? super Follow, ? extends FollowDTO> getDO2DTOMapper() {
		return follow -> {
			FollowDTO followDTO = new FollowDTO();
			if (follow != null) {
				BeanUtils.copyProperties(follow, followDTO);
			}
			return followDTO;
		};
	}

	@Override
	public BaseDao<Follow> getDao() {
		return followDao;
	}

}
