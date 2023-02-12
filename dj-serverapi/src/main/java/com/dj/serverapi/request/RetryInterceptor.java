package com.dj.serverapi.request;

import lombok.extern.slf4j.Slf4j;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import java.io.IOException;
import java.io.InterruptedIOException;

/**
 * @author zcq
 */
@Slf4j
public class RetryInterceptor implements Interceptor {

    private int maxRetry; //最大重试次数
    //private int retryNum = 0; //假如设置为3次重试的话，则最大可能请求4次（默认1次+3次重试）
    private long interval;

    public RetryInterceptor(int maxRetry, long interval) {
        this.maxRetry = maxRetry;
        this.interval = interval;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Response response = doRequest(chain, request);
        int retryNum = 0;
        while ((response == null || !response.isSuccessful()) && retryNum <= maxRetry) {
            log.info("intercept Request is not successful - {}",retryNum);
            try {
                Thread.sleep(interval);
            } catch (final InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new InterruptedIOException();
            }
            retryNum++;
            response = doRequest(chain, request);
        }
        return response;
    }


    private Response doRequest(Chain chain, Request request) {
        Response response = null;
        try {
            response = chain.proceed(request);
        } catch (Exception ignored) {
        }
        return response;
    }
}
