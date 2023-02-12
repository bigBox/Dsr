package com.dj.bms.modules.topic.controller;

import com.dj.bms.common.beans.Page;
import com.dj.bms.common.beans.Result;
import com.dj.bms.common.controller.AbstractBaseController;
import com.dj.bms.common.dao.mapper.wrapper.query.QueryWrapper;
import com.dj.bms.common.dto.TopicExecution;
import com.dj.bms.common.service.BaseService;
import com.dj.bms.common.util.ApiAssert;
import com.dj.bms.common.util.BeanUtils;
import com.dj.bms.common.util.StringUtils;
import com.dj.bms.modules.comment.dto.CommentDTO;
import com.dj.bms.modules.comment.model.Comment;
import com.dj.bms.modules.comment.service.CommentService;
import com.dj.bms.modules.comment.vo.CommentVO;
import com.dj.bms.modules.node.dto.NodeDTO;
import com.dj.bms.modules.node.service.NodeService;
import com.dj.bms.modules.node.vo.NodeVO;
import com.dj.bms.modules.security.model.AuthenticationUser;
import com.dj.bms.modules.topic.dto.TopicDTO;
import com.dj.bms.modules.topic.enums.TopicErrorCodeEnum;
import com.dj.bms.modules.topic.exception.TopicException;
import com.dj.bms.modules.topic.model.Topic;
import com.dj.bms.modules.topic.service.TopicService;
import com.dj.bms.modules.topic.vo.TopicVO;
import com.dj.bms.modules.user.dto.UserDTO;
import com.dj.bms.modules.user.model.User;
import com.dj.bms.modules.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Controller
public class TopicController extends AbstractBaseController<Topic, TopicDTO, TopicVO> {

	@Autowired
	private TopicService topicService;

	@Autowired
	private CommentService commentService;

	@Autowired
	private NodeService   nodeService;


	@Autowired
	private UserService   userService;
	/**
	 * 帖子详情
	 */
	@RequestMapping(value = "/topics/{topicId}", method = RequestMethod.GET)
	public ModelAndView detail(@PathVariable String topicId, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv      = new ModelAndView();
		TopicDTO     topicDTO = topicService.getById(topicId);
		if (topicDTO == null) {
			throw new TopicException(TopicErrorCodeEnum.NOT_FOUND);
		}
		// 浏览量+1
		topicDTO.setViewCount(topicDTO.getViewCount() + 1);
		topicService.updateById(topicDTO);
		TopicVO topicVO    = getDTO2VO().apply(topicDTO);
		Integer pageNumber = 1;
		String  page       = request.getParameter("page");
		if (StringUtils.notEmpty(page)) {
			try {
				pageNumber = Integer.valueOf(page);
			} catch (NumberFormatException e) {
				pageNumber = 1;
			}
		}
		// 评论
		QueryWrapper<Comment> queryWrapper = new QueryWrapper<>();
		queryWrapper.eq("topic_id", topicDTO.getPostId());
		queryWrapper.orderByDesc("create_date");
		Page<CommentVO> commentVOPage = commentDTOPage2CommentVOPage(commentService.page(pageNumber, 25, queryWrapper));
		// 帖子被收藏的数量
		int countByTid = 0;
		mv.addObject("topicVO", topicVO);
		mv.addObject("commentVOPage", commentVOPage);
		mv.addObject("countByTid", countByTid);
		mv.setViewName(this.getJspPrefix() + "/detail");
		return mv;
	}
	
	/**
	 * 发布帖子页面
	 */
	@RequestMapping(value = "/topic/add", method = RequestMethod.GET)
	@Override
	public ModelAndView add(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		Page<NodeVO> nodeVOPage = nodeDTOPage2NodeVOPage(nodeService.page(1, 25));
		mv.addObject("nodeVOPage", nodeVOPage);
		mv.setViewName(this.getJspPrefix() + "/add");
		return mv;
	}
	
	/**
	 * 发布话题接口
	 *
	 * @param title：标题
	 * @param content：正文
	 * @param nodeTitle：节点
	 * @param tag：标签，暂时只能输入一个
	 * @param type：类型         0：富文本 1：Markdown
	 * @param request
	 * @return
	 */

	 @RequestMapping(value = "/topic/save", method = RequestMethod.POST)
	 @ResponseBody
	 private Result<TopicExecution> save(String title, String content, String nodeTitle, String tag,
										 String type, HttpServletRequest request) {
		 AuthenticationUser authenticationUser = getUser();
		 ApiAssert.notNull(authenticationUser, "请先登录");
	     ApiAssert.notNull(title, "标题不能为空"); if (StringUtils.isEmpty(tag)) tag = null;
		 UserDTO userDTO = userService.getById(authenticationUser.getUserId());
		 User user = new User();
	  // 如果是 Markdown 格式的正文，则先渲染再保存进数据库 if ("1".equals(type)) { content = baseEntity.formatContent(content); }
	  TopicExecution saveTopic = topicService.createTopic(title, content, null, null, nodeTitle, tag, user); return new
	  Result<TopicExecution>(true, saveTopic);
	 }


	/**
	 * 根据标签分页查找话题
	 *
	 * @param name
	 * @param model
	 * @param p
	 * @return
	 */
	@RequestMapping(value = "/topic/{name}", method = RequestMethod.GET)
	private String tag(@PathVariable String name, Model model,
			@RequestParam(value = "p", defaultValue = "1") Integer p) {
		Page<Topic> pageByTag = topicService.pageByTag(name, p, 20);
		model.addAttribute("tagName", name);
		model.addAttribute("pageByTag", pageByTag);
		return "/default/front/tag/view";
	}

	@Override
	protected Function<? super TopicDTO, ? extends TopicVO> getDTO2VO() {
		return topicDTO -> {
			if (topicDTO != null) {
				TopicVO topicVO = new TopicVO();
				BeanUtils.DTO2VO(topicDTO, topicVO);
				return topicVO;
			}
			return null;
		};
	}

	@Override
	protected Function<? super TopicVO, ? extends TopicDTO> getVO2DTO() {
		return topicVO -> {
			if (topicVO != null) {
				TopicDTO topicDTO = new TopicDTO();
				BeanUtils.VO2DTO(topicVO, topicDTO);
				return topicDTO;
			}
			return null;
		};
	}

	private Page<CommentVO> commentDTOPage2CommentVOPage(Page<CommentDTO> commentDTOPage) {
		List<CommentDTO> commentDTOList = commentDTOPage.getList();
		List<CommentVO> commentVOList = commentDTOList.stream().map(commentDTO2CommentVO())
				.collect(Collectors.toList());
		return new Page<CommentVO>(commentVOList, commentDTOPage.getPageNumber(), commentDTOPage.getPageSize(),
				commentDTOPage.getTotalRow());
	}
	
	private Function<? super CommentDTO, ? extends CommentVO> commentDTO2CommentVO() {
		return commentDTO -> {
			if (commentDTO != null) {
				CommentVO commentVO = new CommentVO();
				BeanUtils.DTO2VO(commentDTO, commentVO);
				return commentVO;
			}
			return null;
		};
	}
	
	private Page<NodeVO> nodeDTOPage2NodeVOPage(Page<NodeDTO> nodeDTOPage) {
		List<NodeDTO> nodeDTOList = nodeDTOPage.getList();
		List<NodeVO> nodeVOList = nodeDTOList.stream().map(nodeDTO2NodeVO())
				.collect(Collectors.toList());
		return new Page<NodeVO>(nodeVOList, nodeDTOPage.getPageNumber(), nodeDTOPage.getPageSize(),
				nodeDTOPage.getTotalRow());
	}
	
	private Function<? super NodeDTO, ? extends NodeVO> nodeDTO2NodeVO() {
		return nodeDTO -> {
			if (nodeDTO != null) {
				NodeVO nodeVO = new NodeVO();
				BeanUtils.DTO2VO(nodeDTO, nodeVO);
				return nodeVO;
			}
			return null;
		};
	}

	@Override
	protected BaseService<Topic, TopicDTO> getService() {
		return topicService;
	}

	@Override
	protected String getModuleName() {
		return "post";
	}

	@Override
	protected QueryWrapper<Topic> getQueryWrapper() {
		return null;
	}

}
