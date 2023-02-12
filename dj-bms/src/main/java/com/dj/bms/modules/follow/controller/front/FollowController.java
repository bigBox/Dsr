package com.dj.bms.modules.follow.controller.front;

import java.util.Date;
import java.util.function.Function;

import javax.servlet.http.HttpServletRequest;

import com.dj.bms.common.beans.BaseEntity;
import com.dj.bms.common.beans.Page;
import com.dj.bms.common.beans.Result;
import com.dj.bms.common.controller.AbstractBaseController;
import com.dj.bms.common.controller.SessionController;
import com.dj.bms.common.dao.mapper.wrapper.query.QueryWrapper;
import com.dj.bms.common.service.BaseService;
import com.dj.bms.common.util.DateUtils;
import com.dj.bms.modules.follow.service.FollowService;
import com.dj.bms.modules.follow.vo.FollowVO;
import com.dj.bms.modules.topic.model.Topic;
import com.dj.bms.modules.user.dto.UserDTO;
import com.dj.bms.modules.user.model.User;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dj.bms.modules.follow.dto.FollowDTO;
import com.dj.bms.modules.follow.model.Follow;
import com.dj.bms.modules.collect.dto.CollectDTO;
import com.dj.bms.modules.collect.service.CollectService;
import com.dj.bms.modules.collect.vo.CollectVO;
import com.dj.bms.modules.notice.service.NoticeService;
import com.dj.bms.modules.post.model.Post;
import com.dj.bms.modules.post.service.PostService;

/**
 * 
 * @author zcq
 * 2018年7月3日
 * 上午10:15:55
 * TODO
 */
@Controller
public class FollowController extends AbstractBaseController<Follow, FollowDTO, FollowVO> {

	@Autowired
	private FollowService followService;
	@Autowired
	private CollectService collectDaoService;
	@Autowired
	private PostService rootTopicService;
	@Autowired
	private NoticeService rootNoticeService;

	/**
	 * 是否已关注
	 * @param targetId
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/follow/isFollow", method = RequestMethod.GET)
	@ResponseBody
	private Result<Integer> isFollow(Integer targetId, HttpServletRequest request) {
		UserDTO user = null;
		if (user == null) return new Result<>(201, false, "未关注");
		if (user.getUserId() == targetId) {
			return new Result<>(201, false, "同一用户");
		}
		int follow = followService.isFollow(user.getUserId(), targetId);
		if (follow == 0) {
			return new Result<>(201, false, "未关注");
		}
		return new Result<>(true, follow);
	}

	/**
	 * 关注
	 * @param targetId
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/follow/save", method = RequestMethod.POST)
	@ResponseBody
	private Result<Integer> save(Integer targetId, HttpServletRequest request) {
		Follow follow = new Follow();
		follow.setSourceId(getUser().getUserId());
		follow.setTargetId(targetId);
		follow.setCreateDate(new Date());
		int insert = followService.insert(follow);
		if (insert == 1) {
			String info = "关注成功";
			return new Result<Integer>(200, true, info);
		}
		return new Result<>(201, false, "关注失败");
	};

	/**
	 * 取消关注
	 * @param targetId
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/follow/delete", method = RequestMethod.POST)
	@ResponseBody
	private Result<Integer> delete(Integer targetId, HttpServletRequest request) {
		int delete = followService.delete(getUser().getUserId(), targetId);
		if (delete == 1) {
			String info = "取消关注成功";
			return new Result<Integer>(200, true, info);
		}
		return new Result<>(201, false, "取消关注失败");
	}

	/**
	 * 我关注的数量
	 * @param sourceId
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/follow/count/for", method = RequestMethod.GET)
	@ResponseBody
	private Result<Integer> countByUid(Integer sourceId, HttpServletRequest request) {
		int countByUid = followService.countBySourceId(sourceId);
		return new Result<Integer>(true, countByUid);
	}

	/**
	 * 关注我的数量
	 * @param targetId
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/follow/count/to", method = RequestMethod.GET)
	@ResponseBody
	private Result<Integer> countByFid(Integer targetId, HttpServletRequest request) {
		int countByFid = followService.countByTargetId(targetId);
		return new Result<Integer>(true, countByFid);
	}

	/**
	 * 特别关注
	 * @param request
	 * @param p
	 * @return
	 */
	@RequestMapping(value = "/follow/topics", method = RequestMethod.GET)
	private String followTopics(HttpServletRequest request, @RequestParam(value = "p", defaultValue = "1") Integer p) {
		UserDTO user = null;
		if (user == null) return "error-page/404.jsp";
		int         countCollect         = collectDaoService.count(user.getUserId());// 用户收藏话题的数量
		int         countTopicByUserName = rootTopicService.countByUserName(user.getUserName());// 用户发布的主题的数量
		int         notReadNotice        = rootNoticeService.countNotReadNotice(user.getUserName());// 未读通知的数量
		Page<Topic> pageTopic            = followService.pageTopic(p, 20, user.getUserId());
		BaseEntity  baseEntity           = new BaseEntity();
		request.setAttribute("baseEntity", baseEntity);
		request.setAttribute("countCollect", countCollect);
		request.setAttribute("countTopicByUserName", countTopicByUserName);
		request.setAttribute("notReadNotice", notReadNotice);
		request.setAttribute("user", user);
		request.setAttribute("page", pageTopic);
		return "/default/front/follow/list";
	}

	@Override
	protected Function<? super FollowDTO, ? extends FollowVO> getDTO2VO() {
		return followDTO -> {
			FollowVO followVO = new FollowVO();
			if (followDTO != null) {
				BeanUtils.copyProperties(followDTO, followVO);
			}
			followVO.setCreateDate(DateUtils.formatDateTime(followDTO.getCreateDate()));
			followVO.setUpdateDate(DateUtils.formatDateTime(followDTO.getUpdateDate()));
			return followVO;
		};
	}

	@Override
	protected Function<? super FollowVO, ? extends FollowDTO> getVO2DTO() {
		return followVO -> {
			FollowDTO followDTO = new FollowDTO();
			if (followVO != null) {
				BeanUtils.copyProperties(followVO, followDTO);
			}
			followDTO.setCreateDate(DateUtils.string2Date(followVO.getCreateDate(), DateUtils.FORMAT_DATETIME));
			followDTO.setUpdateDate(DateUtils.string2Date(followVO.getUpdateDate(), DateUtils.FORMAT_DATETIME));
			return followDTO;
		};
	}

	@Override
	protected BaseService<Follow, FollowDTO> getService() {
		return followService;
	}

	@Override
	protected String getModuleName() {
		return "follow";
	}

	@Override
	protected QueryWrapper<Follow> getQueryWrapper() {
		return null;
	}
}