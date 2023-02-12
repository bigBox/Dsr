package com.dj.bms.modules.visit.service.impl;

import java.util.Date;
import java.util.List;

import com.dj.bms.common.beans.Page;
import com.dj.bms.common.dto.DMLExecution;
import com.dj.bms.common.enums.InsertEnum;
import com.dj.bms.common.enums.UpdateEnum;
import com.dj.bms.common.exception.OperationFailedException;
import com.dj.bms.common.exception.OperationRepeaException;
import com.dj.bms.common.exception.OperationSystemException;
import com.dj.bms.modules.user.model.User;
import com.dj.bms.modules.visit.dao.VisitDao;
import com.dj.bms.modules.visit.model.Visit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.dj.bms.modules.visit.service.VisitService;

/**
 * 
 * @author zcq 2018年8月4日 下午3:34:37 TODO
 */
@Service
public class VisitServiceImpl implements VisitService {

	@Autowired
	private VisitDao visitDao;

	/**
	 * 分页查询访问记录
	 */
	@Override
	public Page<User> page(Integer vid, Integer pageNumber, Integer pageSize) {
		int totalRow = visitDao.count(vid);
		List<User> list = visitDao.select(vid, (pageNumber - 1) * pageSize, pageSize);
		return new Page<>(list, pageNumber, pageSize, totalRow);
	}

	/**
	 * 添加访问记录
	 */
	@Override
	@Transactional
	public DMLExecution save(Visit visit) {
		try {
			if (visit.getSourceId() == visit.getTargetId()) {
				throw new OperationRepeaException("访问者与被访问者为同一用户！");
			}
			int isVisit = visitDao.isVisit(visit.getSourceId(), visit.getTargetId());
			if (isVisit == 0) {
				int insert = visitDao.insert(visit);
				if (insert <= 0) {
					throw new OperationFailedException("添加失败!");
				} else {
					return new DMLExecution("添加访问记录", InsertEnum.SUCCESS, visit);
				}
			} else {
				visit.setUpdateDate(new Date());
				int update = visitDao.update(visit);
				if (update <= 0) {
					throw new OperationFailedException("更新失败!");
				} else {
					return new DMLExecution("更新访问记录", UpdateEnum.SUCCESS, visit);
				}
			}
		} catch (OperationRepeaException e2) {
			throw e2;
		} catch (OperationFailedException e1) {
			throw e1;
		} catch (Exception e) {
			throw new OperationSystemException("insert into or update visit error " + e.getMessage());
		}
	}

	@Override
	public int count(Integer vid) {
		return visitDao.count(vid);
	}

}
