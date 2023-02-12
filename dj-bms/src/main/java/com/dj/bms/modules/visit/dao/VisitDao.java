package com.dj.bms.modules.visit.dao;

import java.util.List;

import com.dj.bms.modules.user.model.User;
import com.dj.bms.modules.visit.model.Visit;
import org.apache.ibatis.annotations.Param;

/**
 * 
 * @author zcq
 * 2018年8月4日
 * 上午11:33:04
 * TODO
 */
public interface VisitDao {

	/**
	 * 分页查询
	 * @param targetId 被访问者ID
	 * @param start
	 * @param limit
	 * @return
	 */
	List<User> select(@Param("target_id") Integer targetId, @Param("start") Integer start, @Param("limit") Integer limit);
	
	/**
	 * 统计被访问的数量
	 * @param targetId 被访问者ID
	 * @return
	 */
	int count(@Param("target_id") Integer targetId);
	
	/**
	 * 是否已存在访问记录
	 * @param sourceId
	 * @param targetId
	 * @return
	 */
	int isVisit(@Param("source_id") Integer sourceId,@Param("target_id") Integer targetId);
	
	/**
	 * 添加访问记录
	 * @param visit
	 * @return
	 */
	int insert(Visit visit);
	
	/**
	 * 删除访问记录
	 * @param sourceId 访问者ID
	 * @param targetId 被访问者ID
	 * @return
	 */
	int delete(@Param("source_id") Integer sourceId,@Param("target_id") Integer targetId);
	
	/**
	 * 更新访问记录
	 * @param visit
	 * @return
	 */
	int update(Visit visit);
}
