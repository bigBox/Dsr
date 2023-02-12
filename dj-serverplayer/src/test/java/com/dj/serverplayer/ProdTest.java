//package com.dj.serverplayer;
//
//import com.dj.serverapi.AntiAddictionClient;
//import com.dj.serverapi.constant.ResponseCode;
//import com.dj.serverapi.kernel.ClientConfig;
//import com.dj.serverapi.kernel.ClientContext;
//import com.dj.serverapi.model.*;
//import com.dj.domain.util.codec.Md5Utils;
//import lombok.extern.slf4j.Slf4j;
//
//import java.util.ArrayList;
//
///**
// * 正式环境测试用例
// */
//@Slf4j
//public class ProdTest {
//
//    private AntiAddictionClient antiAddictionClient;
//
//    public void setUp() throws Exception {
//
//        ClientContext clientContext = ClientContext.builder
//                .aClientContext()
//                .appId("3b461800c9614109a9bbda662365a1c6")
//                .bizId("1108009471")
//                .secretKey("ba99bbccd9ffc945cde2feff5e5a6691")
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
//        antiAddictionClient = new AntiAddictionClient(clientContext,clientConfig);
//    }
//
//    public void authenticationCheck() {
//        AuthenticationCheckRequest request = new AuthenticationCheckRequest();
//        request.setAi(Md5Utils.md5To32("100000000000000001"));
//        request.setIdNum("210222198011264410");
//        request.setName("仲崇全");
//        Response response = antiAddictionClient.authenticationCheck(request);
//        if(response != null){
//            if(ResponseCode.OK.getCode() != response.getErrcode()){
//                System.out.println(response.getErrmsg());
//            }else {
//                System.out.println(response.getData().getResult());
//            }
//        }
//    }
//
//    public void authenticationQuery() {
//        AuthenticationQueryRequest request = new AuthenticationQueryRequest();
//        request.setAi(Md5Utils.md5To32("100000000000000001"));
//        Response response = antiAddictionClient.authenticationQuery(request);
//        if(response != null){
//            if(ResponseCode.OK.getCode() != response.getErrcode()){
//                System.out.println(response.getErrmsg());
//            }else {
//                System.out.println(response.getData().getResult());
//            }
//        }
//    }
//
//    public void behaviorLoginOut() {
//        BehaviorLoginOutItem item = new BehaviorLoginOutItem();
//        item.setNo(1);
//        item.setSi(Md5Utils.md5To32("100000000000000001"));
//        item.setBt(1);
//        item.setOt(System.currentTimeMillis()/1000);
//        item.setCt(0);
//        item.setDi("");
//        item.setPi("1h8ffk6ozqztueylyk3o30xco1iiomx8rb0o8g");
//        BehaviorLoginOutListRequest request = new BehaviorLoginOutListRequest();
//        ArrayList<BehaviorLoginOutItem> collections = new ArrayList<>();
//        collections.add(item);
//        request.setCollections(collections);
//
//        Response response = antiAddictionClient.behaviorLoginOut(request);
//        if(response != null){
//            if(ResponseCode.OK.getCode() != response.getErrcode()){
//                System.out.println(response.getErrmsg());
//            }else {
//                System.out.println(response.getData());
//            }
//        }
//    }
//}