package com.dj.bms.modules.notice.controller.front;

import java.util.function.Function;

import javax.servlet.http.HttpServletRequest;

import com.dj.bms.common.beans.Page;
import com.dj.bms.common.controller.AbstractBaseController;
import com.dj.bms.common.controller.SessionController;
import com.dj.bms.common.dao.mapper.wrapper.query.QueryWrapper;
import com.dj.bms.common.service.BaseService;
import com.dj.bms.modules.collect.service.CollectService;
import com.dj.bms.modules.notice.service.NoticeService;
import com.dj.bms.modules.post.service.PostService;
import com.dj.bms.modules.user.model.User;
import com.dj.bms.modules.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dj.bms.modules.notice.model.Notice;

@Controller
public class NoticeController extends SessionController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private NoticeService rootNoticeService;
	@Autowired
	private UserService rootUserService;
	@Autowired
	private PostService rootTopicService;
	@Autowired
	private CollectService collectDaoService;
	
	/**
	 * ้็ฅๅ่กจ
	 * @param request
	 * @param p
	 * @return
	 */
	@RequestMapping(value = "/notification/list", method = RequestMethod.GET)
	private String noticeList(HttpServletRequest request,@RequestParam(value = "p", defaultValue = "1") Integer p) {
		/*RootUser user = null;
		RootUser session = CookieAndSessionUtil.getSession(request, "user");
		if(session != null) {
			user = session;
		}
		if(user == null) {
			String cookie = CookieAndSessionUtil.getCookie(request, "user");
			if(cookie != null) {
	    		user = rootUserService.findByName(Base64Util.decode(cookie));
	    	}
		}
		if(user == null) {
			return "error-page/500";
		}*/
		User user = getUser(request);
		if(user == null) {
			return "error-page/500";
		}
		int countByAuthor = rootNoticeService.countByAuthor(user.getUserName());//็ป่ฎกๆๆ้็ฅ็ๆฐ้
		int notReadNotice = rootNoticeService.countNotReadNotice(user.getUserName());//็ป่ฎกๆช่ฏป้็ฅ็ๆฐ้
		int countTopicByUserName = rootTopicService.countByUserName(user.getUserName());//็จๆทๅๅธ็ไธป้ข็ๆฐ้
		int countCollect = collectDaoService.count(user.getUserId());//็จๆทๆถ่่ฏ้ข็ๆฐ้
		Page<Notice> page = rootNoticeService.pageByAuthor(p, 20, user.getUserName());//ๆฅ่ฏขๆๆ้็ฅ
		rootNoticeService.updateIsRead(user.getUserName());//ๅฐ้็ฅ้ฝ็ฝฎไธบๅทฒ่ฏป
		request.setAttribute("countByAuthor", countByAuthor);
		request.setAttribute("notReadNotice", notReadNotice);
		request.setAttribute("page", page);
		request.setAttribute("user", user);
		request.setAttribute("countTopicByUserName", countTopicByUserName);
		request.setAttribute("countCollect", countCollect);
		return "/default/front/notice/list";
	}


}
