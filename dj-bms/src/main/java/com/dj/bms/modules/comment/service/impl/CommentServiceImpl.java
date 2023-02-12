package com.dj.bms.modules.comment.service.impl;

import java.util.List;
import java.util.Map;
import java.util.function.Function;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dj.bms.common.beans.Page;
import com.dj.bms.common.dao.BaseDao;
import com.dj.bms.modules.comment.dao.CommentDao;
import com.dj.bms.modules.comment.dto.CommentDTO;
import com.dj.bms.modules.comment.model.Comment;
import com.dj.bms.modules.comment.service.CommentService;
import com.dj.bms.modules.post.dto.PostDTO;
import com.dj.bms.modules.post.service.PostService;
import com.dj.bms.modules.user.dto.UserDTO;
import com.dj.bms.modules.user.service.UserService;
import com.dj.bms.common.service.impl.AbstractBaseServiceImpl;
import com.dj.bms.common.util.ApplicationContextUtils;

/**
 * 评论 Service Impl
 * @author zcq
 * @date 2018-05-25 20:54:27
 * @since 1.0
 * @version 3.0
 */
@Service
public class CommentServiceImpl extends AbstractBaseServiceImpl<Comment, CommentDTO> implements CommentService {

	@Autowired
	private CommentDao commentDao;

	@Override
	public int countToday() {
		return commentDao.countToday();
	}

	/**
	 * 后台评论分页列表
	 */
	@Override
	public Page<Map<String, Object>> pageForAdmin(String author, String topic, String startDate, String endDate,
			Integer pageNumber, Integer pageSize) {
		List<Map<String,Object>> list = commentDao.selectAllForAdmin(author, topic, startDate, endDate, (pageNumber - 1) * pageSize, pageSize);
		int totalRow = countAllForAdmin(author, topic, startDate, endDate);
		return new Page<Map<String, Object>>(list, pageNumber, pageSize, totalRow);
	}

	/**
	 * 统计后台评论
	 */
	@Override
	public int countAllForAdmin(String author, String topic, String startDate, String endDate) {
		return commentDao.countAllForAdmin(author, topic, startDate, endDate);
	}
	
	@Override
	public Function<? super CommentDTO, ? extends Comment> getDTO2DOMapper() {
		return commentDTO -> {
			if (commentDTO != null) {
				Comment comment = new Comment();
				BeanUtils.copyProperties(commentDTO, comment);
				comment.setPostId(commentDTO.getPostDTO().getPostId());
				comment.setUserId(commentDTO.getUserDTO().getUserId());
				return comment;
			}
			return null;
		};
	}

	@Override
	public Function<? super Comment, ? extends CommentDTO> getDO2DTOMapper() {
		return comment -> {
			if (comment != null) {
				CommentDTO commentDTO = new CommentDTO();
				BeanUtils.copyProperties(comment, commentDTO);
				PostService postService = ApplicationContextUtils.getBean(PostService.class);
				UserService userService = ApplicationContextUtils.getBean(UserService.class);
				PostDTO topicDTO = postService.getById(comment.getPostId());
				UserDTO userDTO = userService.getById(comment.getUserId());
				commentDTO.setPostDTO(topicDTO);
				commentDTO.setUserDTO(userDTO);
				return commentDTO;
			}
			return null;
		};
	}

	@Override
	public BaseDao<Comment> getDao() {
		return commentDao;
	}
}