package com.dj.bms.modules.topic.controller;

import com.dj.bms.common.beans.Result;
import com.dj.bms.common.controller.AbstractBaseApiController;
import com.dj.bms.common.dao.mapper.wrapper.query.QueryWrapper;
import com.dj.bms.common.service.BaseService;
import com.dj.bms.common.util.BeanUtils;
import com.dj.bms.modules.post.enums.PostErrorCodeEnum;
import com.dj.bms.modules.post.exception.PostException;
import com.dj.bms.modules.topic.dto.TopicDTO;
import com.dj.bms.modules.topic.model.Topic;
import com.dj.bms.modules.topic.service.TopicService;
import com.dj.bms.modules.topic.vo.TopicVO;
import com.dj.bms.modules.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.function.Function;

/**
 * @author zcq
 * @date 2020-01-20
 */
@RestController
@RequestMapping(value = "api/v3")
public class TopicApiController extends AbstractBaseApiController<Topic, TopicDTO, TopicVO> {

	@Autowired
	private TopicService topicService;
	
	@Override
	@RequestMapping(value = "/topic", method = RequestMethod.POST)
	public ResponseEntity<Result<TopicVO>> save(@RequestBody TopicVO topicVO, HttpServletRequest request, HttpServletResponse response) {
		User user = getUser(request);
		if (user == null) {
			throw new PostException(PostErrorCodeEnum.INVALIDATE_USER);
		}
		topicVO.setUserId(user.getUserId());
		topicVO.setUserName(user.getUserName());
		return super.save(topicVO, request, response);
	}

	@Override
	protected Function<? super TopicDTO, ? extends TopicVO> getDTO2VO() {
		return postDTO -> (TopicVO) BeanUtils.DTO2VO(postDTO, TopicVO.class);

	}

	@Override
	protected Function<? super TopicVO, ? extends TopicDTO> getVO2DTO() {
		return topicVO -> (TopicDTO) BeanUtils.VO2DTO(topicVO, TopicDTO.class);
	}

	@Override
	protected BaseService<Topic, TopicDTO> getService() {
		return topicService;
	}

	@Override
	protected QueryWrapper<Topic> getQueryWrapper() {
		return null;
	}

}
