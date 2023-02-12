package com.dj.serverapi.kernel;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.dj.serverapi.model.IClientRequest;
import com.dj.serverapi.model.Response;
import com.dj.serverapi.request.ClientHelper;
import com.dj.serverapi.security.AES;
import com.dj.serverapi.security.HMAC;
import lombok.extern.slf4j.Slf4j;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

import java.net.URL;
import java.util.Collections;
import java.util.Map;

/**
 * @author zcq
 */
@Slf4j
@SuppressWarnings("deprecation")
public class DefaultClient {

    private ClientContext clientContext;

    private Map<String,Object> clientConfigMap;

    public DefaultClient(ClientContext clientContext) {
        this.clientContext = clientContext;
    }

    public DefaultClient(ClientContext clientContext, IClientConfig clientConfig) {
        this.clientContext = clientContext;
        this.clientConfigMap = clientConfig.toConfigMap();
    }

    protected String encryptBody(IClientRequest clientRequest){
        String encrypt = "{\"data\":\""+ AES.gcmEncrypt(new Gson().toJson(clientRequest), clientContext.getSecretKey())+"\"}";
        return encrypt;
    }

    protected Response get(String uri, IClientRequest request) throws Exception {

        URL url = new URL(uri);
        OkHttpClient client = ClientHelper.getOkHttpClient(url.getHost(), url.getPort(), clientConfigMap);

        Request.Builder requestBuilder = generateRequestWithHeader("GET", request, "");

        okhttp3.Response response = client.newCall(requestBuilder.url(url+"?"+request.toParamString())
                .get()
                .build()).execute();

        if(response.isSuccessful()){
            assert response.body() != null;
            JsonElement jsonElement = JsonParser.parseString(response.body().string());
            Response resp = new Gson().fromJson(jsonElement, Response.class);
            return resp;
        }else{
            log.error("error request to {} , response code: {}, message: {}",uri,response.code(),response.message());
            return null;
        }
    }

    protected Response post(String uri, IClientRequest request) throws Exception {

        URL url = new URL(uri);
        OkHttpClient client = ClientHelper.getOkHttpClient(url.getHost(), url.getPort(), clientConfigMap);

        String encryptBody = encryptBody(request);

        Request.Builder requestBuilder = generateRequestWithHeader("POST", request, encryptBody);

        okhttp3.Response response = client.newCall(requestBuilder.url(url)
                .post(RequestBody.create(MediaType.parse("application/json;charset=utf-8"),encryptBody))
                .build()).execute();

        if(response.isSuccessful()){
            assert response.body() != null;
            JsonElement jsonElement = JsonParser.parseString(response.body().string());
            Response resp = new Gson().fromJson(jsonElement, Response.class);
            return resp;
        }else{
            log.error("error request to {} , response code: {}, message: {}",uri,response.code(),response.message());
            return null;
        }
    }

    protected Request.Builder generateRequestWithHeader(String httpMethod, IClientRequest request, String encryptBody){

        Request.Builder requestBuilder = new Request.Builder();
        requestBuilder.addHeader("Content-Type","application/json;charset=utf-8");
        requestBuilder.addHeader("appId",clientContext.getAppId());
        requestBuilder.addHeader("bizId",clientContext.getBizId());
        String timestamps = String.valueOf(System.currentTimeMillis());
        requestBuilder.addHeader("timestamps",timestamps);

        if("POST".equals(httpMethod)){
            requestBuilder.addHeader("sign",
                    HMAC.sign(clientContext.getAppId(),clientContext.getBizId(),
                            timestamps,clientContext.getSecretKey(),
                            Collections.emptyMap(),encryptBody));
        }
        if("GET".equals(httpMethod)){
            requestBuilder.addHeader("sign",
                    HMAC.sign(clientContext.getAppId(),clientContext.getBizId(),
                            timestamps,clientContext.getSecretKey(),
                            request.toParamMap(),""));
        }
        return requestBuilder;
    }
}
