package com.dj.serverplayer;

import com.dj.serverapi.AntiAddictionClient;
import com.dj.serverapi.kernel.ClientContext;
import com.dj.serverapi.kernel.IClientConfig;
import com.dj.serverapi.model.AuthenticationCheckRequest;
import com.dj.serverapi.model.AuthenticationQueryRequest;
import com.dj.serverapi.model.BehaviorLoginOutListRequest;
import com.dj.serverapi.model.Response;
import lombok.extern.slf4j.Slf4j;

/**
 * 联调环境client
 * @author zcq
 */
@Slf4j
public class AntiAddictionTestClient extends AntiAddictionClient {

    public AntiAddictionTestClient(ClientContext clientContext, IClientConfig clientConfig) {
        super(clientContext, clientConfig);
    }

    public Response authenticationCheck(AuthenticationCheckRequest request, String testCode) {
        try {
            return post(RequestTestEndpoint.AUTHENTICATION_CHECK + testCode, request);
        } catch (Exception e) {
            log.error("error invoke authenticationCheck, exception: {}",e.getMessage());
            return null;
        }
    }

    public Response authenticationQuery(AuthenticationQueryRequest request, String testCode) {
        try {
            return get(RequestTestEndpoint.AUTHENTICATION_QUERY + testCode, request);
        } catch (Exception e) {
            log.error("error invoke authenticationQuery, exception: {}",e.getMessage());
            return null;
        }
    }

    public Response behaviorLoginOut(BehaviorLoginOutListRequest request, String testCode) {
        try {
            return post(RequestTestEndpoint.BEHAVIOR_LOGIN_OUT + testCode, request);
        } catch (Exception e) {
            log.error("error invoke behaviorLoginOut, exception: {}",e.getMessage());
            return null;
        }
    }
}
