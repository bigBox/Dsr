package com.dj.bms.modules.user.controller.api;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dj.bms.modules.topic.model.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dj.bms.common.controller.SessionController;
import com.dj.bms.common.util.CookieAndSessionUtil;
import com.dj.bms.common.util.bcrypt.BCryptPasswordEncoder;
import com.dj.bms.config.ApplicationConfig;
import com.dj.bms.modules.user.model.User;
import com.dj.bms.modules.integral.model.Top100;
import com.dj.bms.modules.collect.service.CollectService;
import com.dj.bms.modules.comment.model.ReplyAndTopicByName;
import com.dj.bms.modules.comment.service.CommentService;
import com.dj.bms.modules.follow.service.FollowService;
import com.dj.bms.modules.notice.service.NoticeService;
import com.dj.bms.modules.post.model.Post;
import com.dj.bms.modules.post.service.PostService;
import com.dj.bms.modules.user.service.UserService;
import com.dj.bms.modules.visit.service.VisitService;
import com.dj.bms.common.beans.Page;
import com.dj.bms.common.beans.Result;
import com.dj.bms.common.controller.AbstractBaseController;
import com.dj.bms.common.dao.mapper.wrapper.query.QueryWrapper;
import com.dj.bms.common.service.BaseService;
import com.dj.bms.common.util.ApiAssert;

/**
 * 
 * @author zcq
 * 2018年7月21日
 * 下午10:58:12
 * TODO
 */
@RestController
public class UserApiController extends SessionController{

	@Autowired
	private CollectService collectDaoService;
	@Autowired
	private PostService topicService;
	@Autowired
	private NoticeService noticeService;
	@Autowired
	private UserService userService;
	@Autowired
	private CommentService replyService;
	@Autowired
	private FollowService followService;
	@Autowired
	private VisitService visitService;
	@Autowired
	private ApplicationConfig citeConfig;


	@RequestMapping(value = "/api/game/register", method = RequestMethod.GET)
	private void register(@RequestParam(value = "account") String account,
						  @RequestParam(value = "password") String password, @RequestParam(value = "roleID") String roleID) {
		userService.createUser(account, password, "game@qq.com", "2", roleID);
	}

	@RequestMapping(value = "/api/game/login", method = RequestMethod.GET)
	private void login(@RequestParam(value = "account") String account,
					   @RequestParam(value = "password") String password,
					   HttpServletRequest request, HttpServletResponse response) throws IOException {
		User user = userService.findByName(account);
		ApiAssert.notNull(user, "用户不存在");
		ApiAssert.isTrue(new BCryptPasswordEncoder().matches(password, user.getPassword()), "密码不正确");
		// 设置session
		CookieAndSessionUtil.setSession(request, "user", user);
		response.sendRedirect("/");
	}
	/**
	 * 用户的收藏
	 * @param name
	 * @param p
	 * @return
	 */
	@RequestMapping(value = "/api/user/collect",method = RequestMethod.GET)
	private Result<Page> collectList(@RequestParam(value = "name",defaultValue = "1") String name,@RequestParam(value = "p",defaultValue = "1") Integer p){
		User user = userService.findByName(name);
		/*if(user == null) {
			return new Result<PageDataBody>(true, "用户不存在");
		}*/
		ApiAssert.notNull(user, "用户不存在");
		Page<Post> page = collectDaoService.page(p, 20, user.getUserId());
		return new Result<Page>(200, true, page);
	}
	
	/**
	 * 用户的主题
	 * @param name
	 * @param p
	 * @return
	 */
	@RequestMapping(value = "/api/user/topic",method = RequestMethod.GET)
	private Result<Page> topicList(@RequestParam(value = "name",defaultValue = "1") String name,@RequestParam(value = "p",defaultValue = "1") Integer p){
		Page<Post> page = topicService.pageByAuthor(p, 20, name);
		return new Result<Page>(200, true, page);
	}
	
	/**
	 * 用户的评论
	 * @param name
	 * @param p
	 * @return
	 */
	@RequestMapping(value = "/api/user/reply",method = RequestMethod.GET)
	private Result<Page> replyList(@RequestParam(value = "name",defaultValue = "1") String name,@RequestParam(value = "p",defaultValue = "1") Integer p){
		Page<ReplyAndTopicByName> page = null;//replyService.findAllByNameAndTopic(name, p, 20);
		return new Result<Page>(200, true, page);
	}
	
	/**
	 * 用户的关注
	 * @param sourceId
	 * @param p
	 * @return
	 */
	@RequestMapping(value = "/api/user/follow/topic",method = RequestMethod.GET)
	private Result<Page> followList(@RequestParam(value = "uid",defaultValue = "-1") Integer sourceId,@RequestParam(value = "p",defaultValue = "1") Integer p){
		Page<Topic> page = followService.pageTopic(p, 20, sourceId);
		return new Result<Page>(200, true, page);
	}
	
	/**
	 * 用户的粉丝
	 * @param fid
	 * @param p
	 * @return
	 */
	@RequestMapping(value = "/api/user/fans",method = RequestMethod.GET)
	private Result<Page> fansList(@RequestParam(value = "fid",defaultValue = "-1") Integer fid,@RequestParam(value = "p",defaultValue = "1") Integer p){
		Page<User> page = followService.followMe(p, 20, fid);
		return new Result<Page>(200, true, page);
	}
	
	/**
	 * 用户的提问
	 * @param name
	 * @param p
	 * @return
	 */
	@RequestMapping(value = "/api/user/topic/qna",method = RequestMethod.GET)
	private  Result<Page> qnaTopicList(@RequestParam(value = "name",defaultValue = "-1") String name,@RequestParam(value = "p",defaultValue = "1") Integer p){
		Page<Post> page = topicService.pageAllByPtabAndAuthor(p, 20, "qna", name);
		return new Result<Page>(200, true, page);
	}
	
	/**
	 * 用户的访客
	 * @param vid
	 * @param p
	 * @return
	 */
	@RequestMapping(value = "/api/user/visit",method = RequestMethod.GET)
	private Result<Page> visitList(@RequestParam(value = "vid",defaultValue = "-1") Integer vid,
										   @RequestParam(value = "p",defaultValue = "1") Integer p){
		Page<User> page = visitService.page(vid, p, 10);
		return new Result<Page>(200, true, page);
	}
	
	@RequestMapping(value = "/api/test",method = RequestMethod.GET)
	private Result<Integer> test(Integer p){
		return new Result<Integer>(200, true, p);
	}
	
	/**
	 * 用户发表话题或者回复的数量
	 * @param type
	 * @param userName
	 * @return
	 */
	@RequestMapping(value = "/api/numberOfCountTopicsOrReply",method = RequestMethod.GET)
	private Map<String,Object> numberOfCountTopicsOrReply(String type,String userName){
		Map<String, Object> map = new HashMap<String, Object>();
		if(userName == null) {
			map.put("success", false);
			map.put("msg", "用户名不能为空");
			return map;
		}else if(type.equals("reply")){
			int countByName = 0;//replyService.countByName(userName);
			map.put("success", true);
			map.put("msg", countByName);
			return map;
		}else {
			int countByUserName = topicService.countByUserName(userName);
			map.put("success", true);
			map.put("msg", countByUserName);
			return map;
		}
	}
	
	/**
	 * Top100积分榜
	 * @return
	 */
	@RequestMapping(value = "/api/user/top100",method = RequestMethod.GET)
	private Result<List> top100(@RequestParam(value = "limit",defaultValue = "100")Integer limit){
		List<Top100> scores = userService.scores(limit);
		return new Result<List>(200, true, scores);
	}
	
	/**
	 * 用户的登录信息
	 * @return
	 */
	@RequestMapping(value = "/api/user/logininfo",method = RequestMethod.GET)
	private Result<Map> LoginInfo(HttpServletRequest request){
		User user = getUser(request);
		HashMap<String,Object> map = new HashMap<>();
		if(user == null) {
			map.put("intro", citeConfig.getIntro());
			return new Result<>(201, false, map);
		}else {
			map.put("userName", user.getUserName());
			map.put("avatar", user.getAvatar());
			map.put("signature", user.getSignature());
			int countTopic = topicService.countByUserName(user.getUserName());
			int countCollect = collectDaoService.count(user.getUserId());
			int countFollow = followService.countBySourceId(user.getUserId());
			int countNotReadNotice = noticeService.countNotReadNotice(user.getUserName());
			int countScore = userService.countScore(user.getUserId());
			map.put("countTopic", countTopic);
			map.put("countCollect", countCollect);
			map.put("countFollow", countFollow);
			map.put("countNotReadNotice", countNotReadNotice);
			map.put("countScore", countScore);
			return new Result<Map>(200, true, map);
		}
	}
	
	/**
	 * 作者的其他话题
	 * @param userName
	 * @param topicId
	 * @return
	 */
	@RequestMapping(value = "/api/user/other/topic",method = RequestMethod.GET)
	private Result<List> otherTopic(String userName,Integer topicId){
		List<Post> list = topicService.findOther(userName, topicId);
		return new Result<List>(200, true, list);
	}

}
