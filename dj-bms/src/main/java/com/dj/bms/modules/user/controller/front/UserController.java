package com.dj.bms.modules.user.controller.front;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import com.dj.bms.common.beans.BaseEntity;
import com.dj.bms.common.beans.Page;
import com.dj.bms.common.beans.Result;
import com.dj.bms.common.controller.AbstractBaseController;
import com.dj.bms.common.dao.mapper.wrapper.query.QueryWrapper;
import com.dj.bms.common.dto.UserExecution;
import com.dj.bms.common.service.BaseService;
import com.dj.bms.common.util.*;
import com.dj.bms.common.util.bcrypt.BCryptPasswordEncoder;
import com.dj.bms.modules.collect.service.CollectService;
import com.dj.bms.modules.comment.model.ReplyAndTopicByName;
import com.dj.bms.modules.comment.service.CommentService;
import com.dj.bms.modules.notice.service.NoticeService;
import com.dj.bms.modules.post.dto.PostDTO;
import com.dj.bms.modules.post.model.Post;
import com.dj.bms.modules.post.service.PostService;
import com.dj.bms.modules.post.vo.PostVO;
import com.dj.bms.modules.security.model.AuthenticationUser;
import com.dj.bms.modules.user.dto.UserDTO;
import com.dj.bms.modules.user.enums.UserErrorCodeEnum;
import com.dj.bms.modules.user.exception.UserException;
import com.dj.bms.modules.user.model.User;
import com.dj.bms.modules.user.service.UserService;
import com.dj.bms.modules.user.vo.UserVO;
import com.dj.bms.modules.visit.model.Visit;
import com.dj.bms.modules.visit.service.VisitService;
import com.dj.bms.store.StorageService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Controller
public class UserController extends AbstractBaseController<User, UserDTO, UserVO> {

	@Autowired
	private CommentService rootReplyService;
	@Autowired
	private UserService userService;
	@Autowired
	private PostService postService;
	@Autowired
	private CollectService collectDaoService;
	@Autowired
	private NoticeService rootNoticeService;
	@Autowired
	private VisitService visitService;
	@Autowired
	private StorageService storageService;

	/**
	 * ????????????
	 * @return
	 */
	@RequestMapping(value = "/user/{name}", method = RequestMethod.GET)
	private String detail(@PathVariable String name, Model model,
			@RequestParam(value = "tp", defaultValue = "1") Integer tp,
			@RequestParam(value = "rp", defaultValue = "1") Integer rp, HttpServletRequest request) {
		if (name == null) {
			return "error-page/404";
		}
		User user;
		String cookie = CookieAndSessionUtil.getCookie(request, "user");
		if(cookie != null) {
			user = userService.findByName(Base64Util.decode(cookie));
		}else {
			AuthenticationUser curUser = getUser();
			user = userService.findByName(curUser.getUsername());
		}
		ApiAssert.notNull(user, "????????????");
		UserDTO user2 = null;// ????????????
		Page<Post> topicPage = postService.pageByAuthor(tp, 20, name);
		Page<ReplyAndTopicByName> replyPage = null;//rootReplyService.findAllByNameAndTopic(name, rp, 20);
		int countTopic = postService.countByUserName(user.getUserName());// ????????????
		int countCollect = collectDaoService.count(user.getUserId());// ???????????????????????????
		int countReply = 0;//rootReplyService.countByName(name);// ???????????????
		int countScore = 0;//userService.countScore(user.getUserId());// ??????
		int countVisit = 0;//visitService.count(user.getUserId());// ??????????????????
		// ????????????????????????????????????????????????????????????????????????????????????????????????
		if (user2 != null && user.getUserId() != user2.getUserId()) {
			Visit visit = new Visit();
			visit.setSourceId(user2.getUserId());
			visit.setTargetId(user.getUserId());
			visit.setCreateDate(new Date());
			visit.setUpdateDate(new Date());
			//visit.setDelete(false);
			visitService.save(visit);
		}
		model.addAttribute("user", user);
		model.addAttribute("user2", user2);
		model.addAttribute("replyPage", replyPage);
		model.addAttribute("topicPage", topicPage);
		model.addAttribute("countTopic", countTopic);
		model.addAttribute("countCollect", countCollect);
		model.addAttribute("countReply", countReply);
		model.addAttribute("countScore", countScore);
		model.addAttribute("countVisit", countVisit);
		return "/default/front/user/view";
	}

	@RequestMapping(value = "/users/{userName}", method = RequestMethod.GET)
	@Override
	public ModelAndView detail(@PathVariable String userName, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
		userQueryWrapper.eq("user_name", userName);
		UserDTO userDTO = userService.getOne(userQueryWrapper);
		if (userDTO == null) {
			throw new UserException(UserErrorCodeEnum.INVALIDATE_USER);
		}
		Integer pageNumber = 1;
		try {
			pageNumber = Integer.valueOf(request.getParameter("pageNumber"));
		} catch (NumberFormatException e) {
			pageNumber = 1;
		}
		QueryWrapper<Post> postQueryWrapper = new QueryWrapper<>();
		postQueryWrapper.eq("user_id", userDTO.getUserId());
		postQueryWrapper.orderByDesc("create_date");
		Page<PostDTO> postDTOPage = postService.page(Integer.valueOf(pageNumber), 25, postQueryWrapper);
		Page<PostVO> postVOPage = postDTOPage2PostVOPage(postDTOPage);
		mv.setViewName(this.getJspPrefix() + "/detail");
		mv.addObject("userVO", getDTO2VO().apply(userDTO));
		mv.addObject("postVOPage", postVOPage);
		return mv;
	}



	/**
	 * ?????????????????????????????????
	 * @param model
	 * @param p
	 * @return
	 */
	@RequestMapping(value = "/user/topics", method = RequestMethod.GET)
	private String topics(Model model, @RequestParam(value = "p", defaultValue = "1") Integer p,
			HttpServletRequest request) {
		User user;
		String cookie = CookieAndSessionUtil.getCookie(request, "user");
		if(cookie != null) {
			user = userService.findByName(Base64Util.decode(cookie));
		}else {
			AuthenticationUser curUser = getUser();
			user = userService.findByName(curUser.getUsername());
		}
		ApiAssert.notNull(user, "????????????");
		Page<Post> topicPage = postService.pageByAuthor(p, 50, user.getUserName());
		int countCollect = collectDaoService.count(user.getUserId());// ???????????????????????????
		int countTopicByUserName = postService.countByUserName(user.getUserName());// ??????????????????????????????
		int notReadNotice = rootNoticeService.countNotReadNotice(user.getUserName());// ?????????????????????
		BaseEntity baseEntity = new BaseEntity();
		model.addAttribute("baseEntity", baseEntity);
		model.addAttribute("user", user);
		model.addAttribute("topicPage", topicPage);
		request.setAttribute("countCollect", countCollect);
		request.setAttribute("countTopicByUserName", countTopicByUserName);
		request.setAttribute("notReadNotice", notReadNotice);
		return "/default/front/user/topics";
	}

	/**
	 * ?????????????????????????????????
	 * @param name
	 * @param model
	 * @param p
	 * @return
	 */
	@RequestMapping(value = "/user/{name}/replys", method = RequestMethod.GET)
	private String replys(@PathVariable String name, Model model,
			@RequestParam(value = "p", defaultValue = "1") Integer p, HttpServletRequest request) {
		if (name == null) {
			return "error-page/404.jsp";
		}
		User user;
		String cookie = CookieAndSessionUtil.getCookie(request, "user");
		if(cookie != null) {
			user = userService.findByName(Base64Util.decode(cookie));
		}else {
			AuthenticationUser curUser = getUser();
			user = userService.findByName(curUser.getUsername());
		}
		ApiAssert.notNull(user, "????????????");
		UserDTO user2 = null;// ????????????
		Page<ReplyAndTopicByName> replyPage = null;// rootReplyService.findAllByNameAndTopic(name, p, 20);
		int countTopic = postService.countByUserName(user.getUserName());// ????????????
		int countCollect = collectDaoService.count(user.getUserId());// ???????????????????????????
		int countReply = 0;//rootReplyService.countByName(user.getUserName());// ???????????????
		model.addAttribute("user", user);
		model.addAttribute("user2", user2);
		model.addAttribute("replyPage", replyPage);
		model.addAttribute("countTopic", countTopic);
		model.addAttribute("countCollect", countCollect);
		model.addAttribute("countReply", countReply);
		// model.addAttribute("countCollect", getCountCollect(request));
		// model.addAttribute("countTopicByUserName", getCountTopicByUserName(request));
		// model.addAttribute("notReadNotice", getNotReadNotice(request));
		// model.addAttribute("myUser", getUser(request));
		return "/default/front/user/replys";
	}

	/**
	 * ????????????????????????
	 * @return
	 */
	@RequestMapping(value = "/user/settings/profile", method = RequestMethod.GET)
	private String setting(HttpServletRequest request) {
		User user;
		String cookie = CookieAndSessionUtil.getCookie(request, "user");
		if(cookie != null) {
			user = userService.findByName(Base64Util.decode(cookie));
		}else {
			AuthenticationUser curUser = getUser();
			user = userService.findByName(curUser.getUsername());
		}
		ApiAssert.notNull(user, "????????????");
		request.setAttribute("user", user);
		return "/default/front/user/profile";

	}

	/**
	 * ??????????????????
	 * @param email
	 * @param url
	 * @param thirdId
	 * @param userAddr
	 * @param signature
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/user/setting/profile", method = RequestMethod.POST)
	private String updateUserInfo(String email, String url, String thirdId, String userAddr, String signature,
			HttpServletRequest request, HttpServletResponse response) {
		User user;
		String cookie = CookieAndSessionUtil.getCookie(request, "user");
		if(cookie != null) {
			user = userService.findByName(Base64Util.decode(cookie));
		}else {
			AuthenticationUser curUser = getUser();
			user = userService.findByName(curUser.getUsername());
		}
		ApiAssert.notNull(user, "????????????");
		user.setEmail(email);
		user.setUrl(url);
		user.setThirdId(thirdId);
		user.setUserAddr(userAddr);
		user.setSignature(signature);
		userService.updateUser(user);
		try {
			response.sendRedirect("/user/settings/profile");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "error-page/500";
	}

	/**
	 * ????????????????????????
	 * @return
	 */
	@RequestMapping(value = "/user/settings/changeAvatar", method = RequestMethod.GET)
	private String changeAvatar(HttpServletRequest request) {
		User user;
		String cookie = CookieAndSessionUtil.getCookie(request, "user");
		if(cookie != null) {
			user = userService.findByName(Base64Util.decode(cookie));
		}else {
			AuthenticationUser curUser = getUser();
			user = userService.findByName(curUser.getUsername());
		}
		ApiAssert.notNull(user, "????????????");
		return "/default/front/user/changeAvatar";
	}

	/**
	 * ????????????
	 * @param avatarBase64:base64???????????????
	 * @param path:?????????????????????
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/user/setting/changeAvatar", method = RequestMethod.POST)
	@ResponseBody
	private Result<String> changeAvatar(String avatarBase64, String path, HttpServletRequest request) {
		ApiAssert.notEmpty(avatarBase64, "??????????????????");
		User user;
		String cookie = CookieAndSessionUtil.getCookie(request, "user");
		if(cookie != null) {
			user = userService.findByName(Base64Util.decode(cookie));
		}else {
			AuthenticationUser curUser = getUser();
			user = userService.findByName(curUser.getUsername());
		}
		ApiAssert.notNull(user, "????????????");
		if (user != null) {
			userService.updateAvatar(avatarBase64, path, user, request);
		}
		return new Result<>(200, true, "????????????");
	}

	/**
	 * ????????????????????????
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/user/settings/changePassword", method = RequestMethod.GET)
	private String changePassword(HttpServletRequest request) {
		return "/default/front/user/changePassword";
	}

	@RequestMapping(value = "/user/setting/changePassword", method = RequestMethod.POST)
	@ResponseBody
	private Result<UserExecution> changePassword(HttpServletRequest request, String oldPassword, String newPassword) {
		if (newPassword == null) {
			return new Result<>(201, false, "??????????????????");
		}
		User user;
		String cookie = CookieAndSessionUtil.getCookie(request, "user");
		if(cookie != null) {
			user = userService.findByName(Base64Util.decode(cookie));
		}else {
			AuthenticationUser curUser = getUser();
			user = userService.findByName(curUser.getUsername());
		}
		ApiAssert.notNull(user, "????????????");
		if (!user.getPassword().equals(oldPassword)) {
			return new Result<>(201, false, "??????????????????");
		}
		// ????????????
		user.setPassword(new BCryptPasswordEncoder().encode(newPassword));
		UserExecution updateUser = userService.updateUser(user);
		return new Result<UserExecution>(200, true, updateUser);
	}



	/**
	 * ????????????
	 * @return
	 */
	@RequestMapping(value = "/user/settings/returnGame", method = RequestMethod.GET)
	private String returnGame(HttpServletRequest request) {
		try {
			User user;
			String cookie = CookieAndSessionUtil.getCookie(request, "user");
			if(cookie != null) {
				user = userService.findByName(Base64Util.decode(cookie));
			}else {
				AuthenticationUser curUser = getUser();
				user = userService.findByName(curUser.getUsername());
			}
			ApiAssert.notNull(user, "????????????");
			System.out.println("returnGame:"+user.getUserId()+"???"+user.getThirdId()+"???return game");
			HttpUtil.get("http://127.0.0.1:8383/api/closebbs?"+user.getThirdId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "ok";
	}


	@Override
	protected Function<? super UserDTO, ? extends UserVO> getDTO2VO() {
		return userDTO -> {
			if (userDTO != null) {
				UserVO userVO = new UserVO();
				BeanUtils.DTO2VO(userDTO, userVO);
				return userVO;
			}
			return null;
		};
	}

	@Override
	protected Function<? super UserVO, ? extends UserDTO> getVO2DTO() {
		return userVO -> {
			if (userVO != null) {
				UserDTO userDTO = new UserDTO();
				BeanUtils.VO2DTO(userVO, userDTO);
				return userDTO;
			}
			return null;
		};
	}

	@Override
	protected BaseService<User, UserDTO> getService() {
		return userService;
	}

	@Override
	protected String getModuleName() {
		return "user";
	}

	@Override
	protected QueryWrapper<User> getQueryWrapper() {
		return null;
	}
	
	private Page<PostVO> postDTOPage2PostVOPage(Page<PostDTO> postDTOPage) {
		List<PostDTO> postDTOList = postDTOPage.getList();
		List<PostVO> postVOList = postDTOList.stream().map(postDTO2PostVO())
				.collect(Collectors.toList());
		return new Page<PostVO>(postVOList, postDTOPage.getPageNumber(), postDTOPage.getPageSize(),
				postDTOPage.getTotalRow());
	}
	
	private Function<? super PostDTO, ? extends PostVO> postDTO2PostVO() {
		return postDTO -> {
			if (postDTO != null) {
				PostVO postVO = new PostVO();
				BeanUtils.DTO2VO(postDTO, postVO);
				return postVO;
			}
			return null;
		};
	}

}