package com.dj.bms.modules.sys.controller.front;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dj.bms.common.beans.BaseEntity;
import com.dj.bms.common.beans.Page;
import com.dj.bms.common.controller.SessionController;
import com.dj.bms.common.dao.mapper.wrapper.query.QueryWrapper;
import com.dj.bms.common.util.StringUtils;
import com.dj.bms.modules.node.model.Node;
import com.dj.bms.modules.node.model.NodeTab;
import com.dj.bms.modules.node.service.NodeService;
import com.dj.bms.modules.node.service.NodeTabService;
import com.dj.bms.modules.tab.service.TabService;
import com.dj.bms.modules.tag.model.Tag;
import com.dj.bms.modules.user.dto.UserDTO;
import com.dj.bms.modules.user.model.User;
import com.dj.bms.modules.user.service.UserService;
import org.apache.commons.collections.map.HashedMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.dj.bms.common.dto.UserExecution;
import com.dj.bms.modules.tab.model.Tab;
import com.dj.bms.modules.collect.service.CollectService;
import com.dj.bms.modules.comment.service.CommentService;
import com.dj.bms.modules.notice.service.NoticeService;
import com.dj.bms.modules.post.model.Post;
import com.dj.bms.modules.post.service.PostService;
import com.dj.bms.common.util.CookieAndSessionUtil;

@Controller
public class IndexController extends SessionController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UserService userService;
	@Autowired
	private PostService topicService;
	@Autowired
	private NodeTabService nodeTabService;
	@Autowired
	private NoticeService noticeService;
	@Autowired
	private CommentService replyService;
	@Autowired
	private CollectService collectDaoService;
	
	@Autowired
	private TabService tabService;

	//@Autowired
	//private ApplicationConfig siteConfig;

	@Autowired
	private BaseEntity baseEntity;

	@Autowired
	private NodeService nodeService;

	/**
	 * ??????
	 * 
	 * @param p
	 * @param tab
	 * @return
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	private String index(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value = "p", defaultValue = "1") Integer p,
			@RequestParam(value = "tab", defaultValue = "all") String tab) {
		Page<Post> page = topicService.pageAllByTab(p, 25, tab);
		List<Tab> tabList = tabService.selectAll();
		List<Node> nodeList = nodeService.findAllByTab(tab, 0, 5);
		// ???????????????
		List<Post> findHot = topicService.findHot(0, 10);
		// ???????????????????????????
		List<Post> findTodayNoReply = topicService.findTodayNoReply(0, 10);
		// ????????????
		Page<Tag> tag = topicService.findByTag(1, 10);
		List<Node> nodeList2 = nodeService.findAll(0, 10);
		// ?????????????????????
		int countUserAll = userService.countUserAll();
		// ?????????????????????
		int countAllTopic = topicService.countAllTopic(null);
		// ?????????????????????
		int countAllReply = replyService.count();
		request.setAttribute("page", page);
		request.setAttribute("findHot", findHot);
		request.setAttribute("findTodayNoReply", findTodayNoReply);
		request.setAttribute("tabList", tabList);
		request.setAttribute("nodeList", nodeList);
		request.setAttribute("nodeList2", nodeList2);
		request.setAttribute("tab", tab);
		request.setAttribute("tag", tag);
		request.setAttribute("countUserAll", countUserAll);
		request.setAttribute("countAllTopic", countAllTopic);
		request.setAttribute("countAllReply", countAllReply);
		return "/default/front/index";
	}

	/**
	 * ????????????
	 */
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	private String register(HttpServletRequest request) {
		return "/default/front/register";
	}

	/**
	 * ????????????
	 * @param userName
	 * @param password
	 * @param email
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	private String register(@RequestParam(value = "userName", required = true) String userName,
			@RequestParam(value = "password", required = true) String password,
			@RequestParam(value = "email", required = true) String email, HttpServletRequest request,
			HttpServletResponse response) {
		QueryWrapper<User> queryWrapper = new QueryWrapper<>();
		queryWrapper.eq("user_name", userName);
		UserDTO userDTO = this.userService.getOne(queryWrapper);
		if (userDTO != null) {
			request.setAttribute("error", "??????????????????");
			return "/default/front/register";
		}
		queryWrapper = new QueryWrapper<>();
		queryWrapper.eq("email", email);
		userDTO = this.userService.getOne(queryWrapper);
		if (userDTO != null) {
			request.setAttribute("error", "???????????????");
			return "/default/front/register";
		}
		UserExecution save = userService.createUser(userName, password, email,"1", "");
		CookieAndSessionUtil.setSession(request, "user", save.getUser());
		return "redirect:/";
	}

	/**
	 * ????????????
	 */
	/*@RequestMapping(value = "/login", method = RequestMethod.GET)
	private String login(HttpServletRequest request) {
		return "/default/front/login";
	}*/

	/**
	 * ????????????
	 * 
	 * @param username
	 * @param password
	 * @param request
	 * @param response
	 * @return
	 */
	/*@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	private Result<User> login(@RequestParam("username") String username, @RequestParam("password") String password,
			HttpServletRequest request, HttpServletResponse response) {
		User user = userService.findByName(username);
		ApiAssert.notNull(user, "???????????????");
		// ApiAssert.isTrue(new BCryptPasswordEncoder().matches(password, user.getPassword()), "???????????????");
		// ??????cookie
		CookieAndSessionUtil.setCookie(siteConfig.getCookieConfig().getName(),
				Base64Util.encode(user.getThirdAccessToken()), siteConfig.getCookieConfig().getMaxAge(),
				siteConfig.getCookieConfig().getPath(), siteConfig.getCookieConfig().isHttpOnly(), response);
		// ??????session
		CookieAndSessionUtil.setSession(request, "user", user);
		Subject subject = SecurityUtils.getSubject();
		if(!subject.isAuthenticated()) {
			UsernamePasswordToken token = new UsernamePasswordToken(username, password, false);
			//??????????????????????????????????????????????????????????????????
			subject.login(token);
		}
		return new Result<User>(true, user);
	}*/

	/**
	 * ??????
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	private String logout(HttpServletRequest request, HttpServletResponse response) {
		// stringRedisTemplate.delete("user");
		CookieAndSessionUtil.removeSession(request, "user");
		/*CookieAndSessionUtil.removeCookie(response, siteConfig.getCookieConfig().getName(),
				siteConfig.getCookieConfig().getPath(), siteConfig.getCookieConfig().isHttpOnly());*/
		return "redirect:/";
	}

	/**
	 * ?????????
	 * 
	 * @param request
	 * @param p
	 * @return
	 */
	@RequestMapping(value = "/tags", method = RequestMethod.GET)
	private String tag(HttpServletRequest request, @RequestParam(value = "p", defaultValue = "1") Integer p) {
		Page<Tag> tag = topicService.findByTag(p, 50);
		request.setAttribute("tag", tag);
		return "/default/front/tag/list";
	}

	@RequestMapping(value = "/session", method = RequestMethod.GET)
	@ResponseBody
	private Map<String, String> session(HttpServletRequest request) {
		User user = getUser(request);
		HashedMap map = new HashedMap();
		if (user != null) {
			map.put("success", true);
			map.put("user", user.getUserName());
			return map;
		} else {
			map.put("success", false);
			map.put("user", "");
			return map;
		}
	}

	/**
	 * ??????
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	private String search(HttpServletRequest request, @RequestParam("s") String search,
			@RequestParam(value = "p", defaultValue = "1") Integer p) {
		if (search == null || search.equals("")) {
			return "search";
		}
		Page<Post> pageLike = topicService.pageLike(p, 50, search);
		// BaseEntity baseEntity = new BaseEntity();
		// request.setAttribute("baseEntity", baseEntity);
		request.setAttribute("pageLike", pageLike);
		request.setAttribute("search", search);
		return "/default/front/search/view";
	}

	/**
	 * Top100?????????
	 * 
	 * @return
	 */
	@RequestMapping(value = "/top100")
	private String top100() {
		return "/default/front/integral/list";
	}

	/**
	 * ??????
	 * 
	 * @return
	 */
	@RequestMapping(value = "/about")
	private String about() {
		return "/default/front/common/about";
	}

	/**
	 * faq
	 * 
	 * @return
	 */
	@RequestMapping(value = "/faq")
	private String faq() {
		return "/default/front/common/faq";
	}

	/**
	 * api
	 * 
	 * @return
	 */
	@RequestMapping(value = "/api")
	private String api() {
		return "/default/front/common/api";
	}

	/**
	 * mission
	 * 
	 * @return
	 */
	@RequestMapping(value = "/mission")
	private String mission() {
		return "/default/front/common/mission";
	}

	/**
	 * advertise
	 * 
	 * @return
	 */
	@RequestMapping(value = "/advertise")
	private String advertise() {
		return "/default/front/common/advertise";
	}

	/**
	 * ????????????
	 * 
	 * @return
	 */
	@RequestMapping(value = "/feedback")
	private String feedback() {
		return "/default/front/common/feedback";
	}

	@RequestMapping(value = "/feedback/add", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	@ResponseBody
	private Map<String,Object> feedbackAdd(String info) {
		Map<String, Object> redisMap = new HashedMap();
		Map<String, Object> returnMap = new HashedMap();
		List<String> list = new ArrayList<>();
		if (info == null) {
			returnMap.put("success", false);
			returnMap.put("msg", "??????????????????");
			return returnMap;
		} else {
			list.add("????????????????????????!");
			redisMap.put(StringUtils.getUUID(), info);
			returnMap.put("success", true);
			returnMap.put("msg", list);
			return returnMap;
		}
	}

	/**
	 * ????????????????????????????????????
	 * excel
	 * 
	 * @return
	 */
	@RequestMapping(value = "/excel")
	private String excel(HttpServletRequest request) {
		List<Post> row1 = topicService.findAll();// ????????????
		List<Tab> row2 = tabService.selectAll();// ?????????
		List<NodeTab> row3 = nodeTabService.findAll();// ?????????
		request.setAttribute("row1", row1);
		request.setAttribute("row2", row2);
		request.setAttribute("row3", row3);
		return "/default/front/common/excel";
	}
	
	/*@RequestMapping("/**")
	public String noHandleMethod(HttpServletRequest request, HttpServletResponse response) {
		response.setStatus(HttpStatus.SC_NOT_FOUND);
		return "/default/front/error/404";
	}*/

}
