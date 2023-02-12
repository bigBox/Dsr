package com.dj.bms.common.controller;

import com.dj.bms.common.util.CookieAndSessionUtil;
import com.dj.bms.modules.user.model.User;

import javax.servlet.http.HttpServletRequest;

/**
 * @author zcq
 * @date 2020-01-15 9:48
 */
public class SessionController {

    /**
     * 获取当前登录用户的信息
     *
     * @param request
     * @return
     */
    public User getUser(HttpServletRequest request) {
        return CookieAndSessionUtil.getSession(request, "user");
    }
}
