package com.dj.bms.modules.post.controller;

import java.util.function.Function;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dj.bms.common.beans.Result;
import com.dj.bms.common.controller.AbstractBaseApiController;
import com.dj.bms.common.dao.mapper.wrapper.query.QueryWrapper;
import com.dj.bms.common.service.BaseService;
import com.dj.bms.common.util.BeanUtils;
import com.dj.bms.common.util.IDGenerator;
import com.dj.bms.modules.node.service.NodeService;
import com.dj.bms.modules.post.dto.PostDTO;
import com.dj.bms.modules.post.enums.PostErrorCodeEnum;
import com.dj.bms.modules.post.exception.PostException;
import com.dj.bms.modules.post.model.Post;
import com.dj.bms.modules.post.service.PostService;
import com.dj.bms.modules.post.vo.PostVO;
import com.dj.bms.modules.user.model.User;
import com.dj.bms.modules.user.service.UserService;

/**
 * @author zcq
 * @date 2020-01-20
 */
@RestController
@RequestMapping(value = "api/v3")
public class PostApiController extends AbstractBaseApiController<Post, PostDTO, PostVO> {

	@Autowired
	private PostService postService;
	
	@Autowired 
	private NodeService nodeService;
	
	@Autowired
	private UserService userService;
	
	@Override
	@RequestMapping(value = "/post", method = RequestMethod.POST)
	public ResponseEntity<Result<PostVO>> save(@RequestBody PostVO postVO, HttpServletRequest request, HttpServletResponse response) {
		User user = getUser(request);
		if (user == null) {
			throw new PostException(PostErrorCodeEnum.INVALIDATE_USER);
		}
		postVO.setUserId(user.getUserId());
		postVO.setUserName(user.getUserName());
		return super.save(postVO, request, response);
	}

	@Override
	protected Function<? super PostDTO, ? extends PostVO> getDTO2VO() {
		return postDTO -> (PostVO) BeanUtils.DTO2VO(postDTO, PostVO.class);		

	}

	@Override
	protected Function<? super PostVO, ? extends PostDTO> getVO2DTO() {
		return postVO -> (PostDTO) BeanUtils.VO2DTO(postVO, PostDTO.class);
	}

	@Override
	protected BaseService<Post, PostDTO> getService() {
		return postService;
	}

	@Override
	protected QueryWrapper<Post> getQueryWrapper() {
		return null;
	}

}
