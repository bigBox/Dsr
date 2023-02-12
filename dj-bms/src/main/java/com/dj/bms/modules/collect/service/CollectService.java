package com.dj.bms.modules.collect.service;

import com.dj.bms.common.beans.Page;
import com.dj.bms.common.service.BaseService;
import com.dj.bms.modules.collect.dto.CollectDTO;
import com.dj.bms.modules.collect.model.Collect;
import com.dj.bms.modules.post.model.Post;

/**
 * @author zcq
 * 2018年7月3日
 * 上午10:14:57
 * TODO
 */
public interface CollectService extends BaseService<Collect, CollectDTO> {

	/**
	 * 分页查询收藏话题
	 * @param pageNumber
	 * @param pageSize
	 * @param uid
	 * @return
	 */
	Page<Post> page(Integer pageNumber, Integer pageSize, Integer uid);

	/**
	 * 添加收藏
	 * @param collect
	 * @return
	 */
	int insert(Collect collect);

	/**
	 * 取消收藏
	 * @param uid
	 * @param tid
	 * @return
	 */
	int delete(Integer uid, Integer tid);

	/**
	 * 根据用户 ID 删除收藏
	 * @param uid
	 * @return
	 */
	void deleteByUid(Integer uid);

	/**
	 * 统计用户收藏话题的数量
	 * @param uid
	 * @return
	 */
	int count(Integer uid);

	/**
	 * 判断用户是否已收藏此话题 0:否 1:是
	 */
	int isCollect(Integer uid, Integer tid);

	/**
	 * 统计话题被收藏的数量
	 * @param tid
	 * @return
	 */
	int countByTid(Integer tid);
}
