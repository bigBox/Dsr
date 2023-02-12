package com.dj.bms.modules.vote.dao;

import org.apache.ibatis.annotations.Param;
import com.dj.bms.modules.vote.model.UpDown;

/**
 * 
 * @author zcq
 * 2018年8月11日
 * 上午10:34:54
 * TODO
 */
public interface UpDownDao {

	/**
	 * 统计赞同或者反对的数量
	 * @param topicId:主题ID
	 * @param upDown:0 反对 1 赞同
	 * @return
	 */
	int countUpOrDown(@Param("topic_id") Integer topicId,@Param("upDown") Integer upDown);
	
	/**
	 * 是否已点赞或者点踩
	 * @param userId:用户ID
	 * @param topicId:主题ID
	 * @return
	 */
	int isUpOrDown(@Param("user_id") Integer userId,@Param("topic_id") Integer topicId);
	
	/**
	 * 添加赞同或者反对的记录
	 * @param upDown
	 * @return
	 */
	int insert(UpDown upDown);
	
	/**
	 * 更新状态
	 * @param upDown
	 * @return
	 */
	int update(UpDown upDown);
}
