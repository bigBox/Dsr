package com.dj.serverapi.security;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.*;

/**
 * @author zcq
 * @date 2021-03-11 16:57
 */
public class HMAC {

    public static String sign(String appId, String bizId, String timestamps, String secretKey, Map<String, String> dataMap, String encryptData) {
        Map<String, String> params = new HashMap<>();
        params.put("appId", appId);
        params.put("bizId", bizId);
        params.put("timestamps", timestamps);
        if(dataMap.containsKey("ai")){
            params.put("ai",dataMap.get("ai"));
        }
        if(dataMap.containsKey("idNum")){
            params.put("idNum",dataMap.get("idNum"));
        }
        if(dataMap.containsKey("name")){
            params.put("name",dataMap.get("name"));
        }
        String signStr = createLinkString(params);
        signStr = secretKey + signStr + encryptData;
        return SHA256(signStr);
    }

    /**
     * 系统参数及URL参数拼接
     */
    private static String createLinkString(Map<String, String> params) {
        List<String> keys = new ArrayList<String>(params.keySet());
        Collections.sort(keys);
        StringBuilder sb = new StringBuilder();
        for (String key : keys) {
            String value = params.get(key);
            sb.append(key).append(value);
        }
        return sb.toString();
    }

    private static String SHA256(String str){
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(str.getBytes(StandardCharsets.UTF_8));
            return byte2Hex(messageDigest.digest());
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    private static String byte2Hex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        String temp = null;
        for (byte aByte : bytes) {
            temp = Integer.toHexString(aByte & 0xFF);
            if (temp.length() == 1) {
                sb.append("0");
            }
            sb.append(temp);
        }
        return sb.toString();
    }
}
