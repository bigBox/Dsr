//package com.dj.serverplayer;
//
//import com.dj.serverapi.constant.ResponseCode;
//import com.dj.serverapi.kernel.ClientConfig;
//import com.dj.serverapi.kernel.ClientContext;
//import com.dj.serverapi.model.*;
//
//import java.util.ArrayList;
//import java.util.UUID;
//
///**
// * 联调接口测试用例
// */
//public class UatTest {
//
//    private AntiAddictionTestClient antiAddictionClient;
//
//    public void setUp() throws Exception {
//
//        ClientContext clientContext = ClientContext.builder
//                .aClientContext()
//                .appId("32c7aee48e164168ba674fda4f789eb5")
//                .bizId("1101999999")
//                .secretKey("74d11f31c1b0e1bf04e285f7226a7830")
//                .build();
//
//        ClientConfig clientConfig = ClientConfig.builder
//                .aClientConfig()
//                .ignoreSSL(true)
//                .connectTimeout(4000)
//                .readTimeout(4000)
//                .maxRetry(1)
//                .build();
//
//        antiAddictionClient = new AntiAddictionTestClient(clientContext,clientConfig);
//    }
//
//    public void authenticationCheck() {
//        AuthenticationCheckRequest request = new AuthenticationCheckRequest();
//        request.setAi("100000000000000001");
//        request.setIdNum("110000190101010001");
//        request.setName("某一一");
//        Response response = antiAddictionClient.authenticationCheck(request,"测试码");
//        if(response != null){
//            if(ResponseCode.OK.getCode() != response.getErrcode()){
//                System.out.println(response.getErrmsg());
//            }
//        }
//    }
//
//    public void authenticationQuery() {
//        AuthenticationQueryRequest request = new AuthenticationQueryRequest();
//        request.setAi("100000000000000001");
//        Response response = antiAddictionClient.authenticationQuery(request,"测试码");
//        if(response != null){
//            if(ResponseCode.OK.getCode() != response.getErrcode()){
//                System.out.println(response.getErrmsg());
//            }
//        }
//    }
//
//    public void behaviorLoginOut() {
//        BehaviorLoginOutItem item = new BehaviorLoginOutItem();
//        item.setNo(1);
//        item.setSi(UUID.randomUUID().toString().replace("-","").substring(0,32));
//        item.setBt(1);
//        item.setOt(System.currentTimeMillis()/1000);
//        item.setCt(2);
//        item.setDi(UUID.randomUUID().toString().replace("-","").substring(0,32));
//        item.setPi("");
//        BehaviorLoginOutListRequest request = new BehaviorLoginOutListRequest();
//        ArrayList<BehaviorLoginOutItem> collections = new ArrayList<>();
//        collections.add(item);
//        request.setCollections(collections);
//
//        Response response = antiAddictionClient.behaviorLoginOut(request,"PEPvFq");
//        if(response != null){
//            if(ResponseCode.OK.getCode() != response.getErrcode()){
//                System.out.println(response.getErrmsg());
//            }
//        }
//    }
//
//    public void behaviorLoginOut1() {
//        BehaviorLoginOutItem item = new BehaviorLoginOutItem();
//        item.setNo(1);
//        item.setSi("100000000000000001");
//        item.setBt(1);
//        item.setOt(System.currentTimeMillis()/1000);
//        item.setCt(0);
//        item.setDi("");
//        item.setPi("1fffbjzos82bs9cnyj1dna7d6d29zg4esnh99u");
//        BehaviorLoginOutListRequest request = new BehaviorLoginOutListRequest();
//        ArrayList<BehaviorLoginOutItem> collections = new ArrayList<>();
//        collections.add(item);
//        request.setCollections(collections);
//
//        Response response = antiAddictionClient.behaviorLoginOut(request,"EM75rT");
//        if(response != null){
//            if(ResponseCode.OK.getCode() != response.getErrcode()){
//                System.out.println(response.getErrmsg());
//            }
//        }
//    }
//}