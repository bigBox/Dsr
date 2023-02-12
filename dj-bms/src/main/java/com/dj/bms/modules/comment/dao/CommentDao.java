package com.dj.bms.modules.comment.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.dj.bms.common.dao.BaseDao;
import com.dj.bms.modules.comment.model.Comment;

/**
 * 评论 Dao
 * 
 * @author zcq
 * @date 2018-05-05
 * @since 1.0
 * @version 3.0
 */
public interface CommentDao extends BaseDao<Comment> {

	// 统计当天评论数
	int countToday();

	// 后台评论列表
	List<Map<String, Object>> selectAllForAdmin(@Param("author") String author, @Param("topic") String topic,
			@Param("startDate") String startDate, @Param("endDate") String endDate, @Param("start") Integer start,
			@Param("limit") Integer limit);

	// 后台评论统计
	int countAllForAdmin(@Param("author") String author, @Param("topic") String topic,
			@Param("startDate") String startDate, @Param("endDate") String endDate);
}