package com.dj.bms.modules.post.controller;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dj.bms.modules.tab.service.TabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dj.bms.common.beans.BaseEntity;
import com.dj.bms.common.beans.Page;
import com.dj.bms.common.controller.AbstractBaseController;
import com.dj.bms.common.dao.mapper.wrapper.query.QueryWrapper;
import com.dj.bms.common.service.BaseService;
import com.dj.bms.common.util.BeanUtils;
import com.dj.bms.common.util.StringUtils;
import com.dj.bms.modules.node.dto.NodeDTO;
import com.dj.bms.modules.collect.service.CollectService;
import com.dj.bms.modules.comment.dto.CommentDTO;
import com.dj.bms.modules.comment.model.Comment;
import com.dj.bms.modules.comment.service.CommentService;
import com.dj.bms.modules.comment.vo.CommentVO;
import com.dj.bms.modules.node.service.NodeService;
import com.dj.bms.modules.node.vo.NodeVO;
import com.dj.bms.modules.notice.service.NoticeService;
import com.dj.bms.modules.post.dto.PostDTO;
import com.dj.bms.modules.post.enums.PostErrorCodeEnum;
import com.dj.bms.modules.post.exception.PostException;
import com.dj.bms.modules.post.model.Post;
import com.dj.bms.modules.post.service.PostService;
import com.dj.bms.modules.post.vo.PostVO;

@Controller
public class PostController extends AbstractBaseController<Post, PostDTO, PostVO> {

	@Autowired
	private PostService postService;

	@Autowired
	private CommentService commentService;

	@Autowired
	private CollectService collectService;
	@Autowired
	private NoticeService noticeService;
	@Autowired
	private TabService    tabService;
	@Autowired
	private NodeService   nodeService;
	@Autowired
	private BaseEntity baseEntity;

	/**
	 * 帖子详情
	 */
	@RequestMapping(value = "/posts/{postId}", method = RequestMethod.GET)
	public ModelAndView detail(@PathVariable String postId, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		PostDTO postDTO = postService.getById(postId);
		if (postDTO == null) {
			throw new PostException(PostErrorCodeEnum.NOT_FOUND);
		}
		// 浏览量+1
		postDTO.setViewCount(postDTO.getViewCount() + 1);
		postService.updateById(postDTO);
		PostVO postVO = getDTO2VO().apply(postDTO);
		Integer pageNumber = 1;
		String page = request.getParameter("page");
		if (StringUtils.notEmpty(page)) {
			try {
				pageNumber = Integer.valueOf(page);
			} catch (NumberFormatException e) {
				pageNumber = 1;
			}
		}
		// 评论
		QueryWrapper<Comment> queryWrapper = new QueryWrapper<>();
		queryWrapper.eq("post_id", postDTO.getPostId());
		queryWrapper.orderByDesc("create_date");
		Page<CommentVO> commentVOPage = commentDTOPage2CommentVOPage(commentService.page(pageNumber, 25, queryWrapper));
		// 帖子被收藏的数量
		int countByTid = 0;
		mv.addObject("postVO", postVO);
		mv.addObject("commentVOPage", commentVOPage);
		mv.addObject("countByTid", countByTid);
		mv.setViewName(this.getJspPrefix() + "/detail");
		return mv;
	}
	
	/**
	 * 发布帖子页面
	 */
	@RequestMapping(value = "/post/add", method = RequestMethod.GET)
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
	/*
	 * @RequestMapping(value = "/topic/save", method = RequestMethod.POST)
	 * 
	 * @ResponseBody private Result<TopicExecution> save(String title, String content, String nodeTitle, String tag,
	 * String type, HttpServletRequest request) { User user = getUser(request); ApiAssert.notNull(user, "请先登录");
	 * ApiAssert.notNull(title, "标题不能为空"); if (StringUtils.isEmpty(tag)) tag = null;
	 * 
	 * // 如果是 Markdown 格式的正文，则先渲染再保存进数据库 if ("1".equals(type)) { content = baseEntity.formatContent(content); }
	 * TopicExecution saveTopic = topicService.createTopic(title, content, null, null, nodeTitle, tag, user); return new
	 * Result<TopicExecution>(true, saveTopic); }
	 */

	/**
	 * 根据标签分页查找话题
	 *
	 * @param name
	 * @param model
	 * @param p
	 * @return
	 */
	@RequestMapping(value = "/tag/{name}", method = RequestMethod.GET)
	private String tag(@PathVariable String name, Model model,
			@RequestParam(value = "p", defaultValue = "1") Integer p) {
		Page<Post> pageByTag = postService.pageByTag(name, p, 20);
		model.addAttribute("tagName", name);
		model.addAttribute("pageByTag", pageByTag);
		return "/default/front/tag/view";
	}

	@Override
	protected Function<? super PostDTO, ? extends PostVO> getDTO2VO() {
		return postDTO -> {
			if (postDTO != null) {
				PostVO postVO = new PostVO();
				BeanUtils.DTO2VO(postDTO, postVO);
				return postVO;
			}
			return null;
		};
	}

	@Override
	protected Function<? super PostVO, ? extends PostDTO> getVO2DTO() {
		return postVO -> {
			if (postVO != null) {
				PostDTO postDTO = new PostDTO();
				BeanUtils.VO2DTO(postVO, postDTO);
				return postDTO;
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
	protected BaseService<Post, PostDTO> getService() {
		return postService;
	}

	@Override
	protected String getModuleName() {
		return "post";
	}

	@Override
	protected QueryWrapper<Post> getQueryWrapper() {
		return null;
	}

}
