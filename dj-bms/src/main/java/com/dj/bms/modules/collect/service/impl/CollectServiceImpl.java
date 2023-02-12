package com.dj.bms.modules.collect.service.impl;

import java.util.List;
import java.util.function.Function;

import com.dj.bms.common.beans.Page;
import com.dj.bms.common.dao.BaseDao;
import com.dj.bms.common.service.impl.AbstractBaseServiceImpl;
import com.dj.bms.modules.collect.dao.CollectDao;
import com.dj.bms.modules.collect.dto.CollectDTO;
import com.dj.bms.modules.collect.model.Collect;
import com.dj.bms.modules.collect.service.CollectService;
import com.dj.bms.modules.post.model.Post;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CollectServiceImpl extends AbstractBaseServiceImpl<Collect, CollectDTO> implements CollectService {

	@Autowired
	private CollectDao collectDao;

	/**
	 * 分页查询收藏的话题
	 */
	@Override
	public Page<Post> page(Integer pageNumber, Integer pageSize, Integer uid) {
		int total = collectDao.count(uid);
		List<Post> list = collectDao.selectAllByCollect((pageNumber - 1) * pageSize, pageSize, uid);
		return new Page<>(list, pageNumber, pageSize, total);
	}

	/**
	 * 收藏话题
	 */
	@Override
	public int insert(Collect collect) {
		return collectDao.insert(collect);
	}

	/**
	 * 取消收藏
	 */
	@Override
	public int delete(Integer uid, Integer tid) {
		return collectDao.delete(uid, tid);
	}

	/**
	 * 根据用户 ID 删除收藏
	 */
	@Override
	public void deleteByUid(Integer uid) {
		collectDao.deleteByUid(uid);
	}

	/**
	 * 统计收藏话题的数量
	 */
	@Override
	public int count(Integer uid) {
		return collectDao.count(uid);
	}

	/**
	* 判断用户是否已收藏此话题 0:否 1:是
	*/
	@Override
	public int isCollect(Integer uid, Integer tid) {
		return collectDao.isCollect(uid, tid);
	}

	/**
	 * 统计话题被收藏的数量
	 * @param tid
	 * @return
	 */
	@Override
	public int countByTid(Integer tid) {
		return collectDao.countByTid(tid);
	}

	@Override
	public Function<? super CollectDTO, ? extends Collect> getDTO2DOMapper() {
		return collectDTO -> {
			Collect collect = new Collect();
			if (collectDTO != null) {
				BeanUtils.copyProperties(collectDTO, collect);
			}
			return collect;
		};
	}

	@Override
	public Function<? super Collect, ? extends CollectDTO> getDO2DTOMapper() {
		return collect -> {
			CollectDTO collectDTO = new CollectDTO();
			if (collect != null) {
				BeanUtils.copyProperties(collect, collectDTO);
			}
			return collectDTO;
		};
	}

	@Override
	public BaseDao<Collect> getDao() {
		return collectDao;
	}

}
