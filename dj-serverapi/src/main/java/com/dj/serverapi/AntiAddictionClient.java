package com.dj.serverapi;

import com.dj.serverapi.constant.RequestEndpoint;
import com.dj.serverapi.kernel.ClientContext;
import com.dj.serverapi.kernel.DefaultClient;
import com.dj.serverapi.kernel.IClientConfig;
import com.dj.serverapi.model.AuthenticationCheckRequest;
import com.dj.serverapi.model.AuthenticationQueryRequest;
import com.dj.serverapi.model.BehaviorLoginOutListRequest;
import com.dj.serverapi.model.Response;
import lombok.extern.slf4j.Slf4j;

/**
 * @author zcq
 */
@Slf4j
public class AntiAddictionClient extends DefaultClient implements IClient{

    public AntiAddictionClient(ClientContext clientContext, IClientConfig clientConfig) {
        super(clientContext, clientConfig);
    }

    @Override
    public Response authenticationCheck(AuthenticationCheckRequest request) {
        try {
            return post(RequestEndpoint.AUTHENTICATION_CHECK, request);
        } catch (Exception e) {
            log.error("error invoke authenticationCheck, exception: {}",e.getMessage());
            return null;
        }
    }

    @Override
    public Response authenticationQuery(AuthenticationQueryRequest request) {
        try {
            return get(RequestEndpoint.AUTHENTICATION_QUERY, request);
        } catch (Exception e) {
            log.error("error invoke authenticationQuery, exception: {}",e.getMessage());
            return null;
        }
    }

    @Override
    public Response behaviorLoginOut(BehaviorLoginOutListRequest request) {
        try {
            return post(RequestEndpoint.BEHAVIOR_LOGIN_OUT, request);
        } catch (Exception e) {
            log.error("error invoke behaviorLoginOut, exception: {}",e.getMessage());
            return null;
        }
    }

}
