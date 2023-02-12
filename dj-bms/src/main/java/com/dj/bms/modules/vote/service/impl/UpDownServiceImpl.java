package com.dj.bms.modules.vote.service.impl;

import com.dj.bms.common.dto.DMLExecution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.dj.bms.modules.vote.dao.UpDownDao;
import com.dj.bms.modules.vote.model.UpDown;
import com.dj.bms.common.enums.InsertEnum;
import com.dj.bms.common.enums.UpdateEnum;
import com.dj.bms.common.exception.OperationFailedException;
import com.dj.bms.common.exception.OperationSystemException;
import com.dj.bms.modules.vote.service.UpDownService;

/**
 * 
 * @author zcq 2018年8月11日 上午11:45:07 TODO
 */
@Service
public class UpDownServiceImpl implements UpDownService {

	@Autowired
	private UpDownDao upDownDao;

	/**
	 * 添加赞同或者反对的记录
	 */
	@Override
	@Transactional
	public DMLExecution save(UpDown upDown) {
		try {
			int upOrDown = upDownDao.isUpOrDown(upDown.getUserId(), upDown.getTopicId());
			if (upOrDown == 0) {
				int insert = upDownDao.insert(upDown);
				if (insert <= 0) {
					throw new OperationFailedException("添加失败!");
				} else {
					return new DMLExecution(upDown.isUpDown() ? "添加赞同记录" : "添加反对记录", InsertEnum.SUCCESS, upDown);
				}
			} else {
				update(upDown);
				return new DMLExecution(upDown.isUpDown() ? "更新赞同记录" : "更新反对记录", UpdateEnum.SUCCESS, upDown);
			}
		} catch (OperationFailedException e1) {
			throw e1;
		} catch (Exception e) {
			throw new OperationSystemException("insert into up_down error " + e.getMessage());
		}
	}

	/**
	 * 更新状态
	 */
	@Override
	@Transactional
	public DMLExecution update(UpDown upDown) {
		try {
			int update = upDownDao.update(upDown);
			if (update <= 0) {
				throw new OperationFailedException("更新失败!");
			} else {
				return new DMLExecution(upDown.isUpDown() ? "更新赞同记录" : "更新反对记录", UpdateEnum.SUCCESS, upDown);
			}
		} catch (OperationFailedException e1) {
			throw e1;
		} catch (Exception e) {
			throw new OperationSystemException("update up_down error " + e.getMessage());
		}
	}

	/**
	 * 统计赞同或者反对的数量
	 */
	@Override
	public int countUpOrDown(Integer tid, Integer upDown) {
		return upDownDao.countUpOrDown(tid, upDown);
	}

}
