package com.dj.serverapi;

import com.dj.serverapi.model.AuthenticationCheckRequest;
import com.dj.serverapi.model.AuthenticationQueryRequest;
import com.dj.serverapi.model.BehaviorLoginOutListRequest;
import com.dj.serverapi.model.Response;

public interface IClient {

    /**
     * 实名认证
     */
    Response authenticationCheck(AuthenticationCheckRequest request);

    /**
     * 实名认证
     */
    Response authenticationQuery(AuthenticationQueryRequest request);

    /**
     * 用户登录登出行为上报
     */
    Response behaviorLoginOut(BehaviorLoginOutListRequest request);
}
