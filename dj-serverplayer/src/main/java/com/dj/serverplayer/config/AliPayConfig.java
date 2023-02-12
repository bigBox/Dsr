package com.dj.serverplayer.config;

import lombok.Data;

@Data
public class AliPayConfig {
    //AP_APP_ID 应用id
    public static String appId = "2021002183643183";
    //APP_PRIVATE_KEY #应用支付宝私钥
    public static String appPrivateKey = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCIp0MCrtXZuzmyfW9FC9mIcOA13Cv/HUmt26M9NUcO0rfY2fcP05R/+fru+vXh2aLjoFYTVX6KqUSsVy7x3JDtidci7pmeN1e8XRQ1bwf8v/DgDOJLyNIOlvuVMb+5X35/EsUhbGIQYMxHzL1BvEwCCjGNp1xJ/BN6fbwIzlOfK2OgOR0gr3Z5He29KoRtz5ZjyM0bgrZdmzwrYlrxnEsVVrEpr26A2iUou96tDh1FcImtWXmJmp4IYEubGAdAyz+NwS2fDJZLg8DZl4ckgz6WM3UsM1xGdTFDzo7GC9FfjNYNIi5wLnAfl4Q84snvhrQswRWCEcsHjxkojdpbNRLpAgMBAAECggEAMs71xFabHnRVVH780xA/1lIZmwz8ssMB9Ql33Tck72b7gj4wdQr26MpaOWbH6yxPOxEPT+r2vLmI1gcoZjbbD+azPcK3DTOIhHmbHO7malw3RCamMQU+zLvoWKWBonvV/YtODkpM/8ftzDhcmcdX/14o5IE4eC2oVF/RfPix8LjXER9YdfiGI5nJgji3Jg4svgRM53lOSrDCPC/ljYq4S28u0yBNZJ1QDZxzB6/rQmAei4sLLwtsXiwCillmsFQHixYvCcTKU+B7iPhFCtxaR37VYOLW6nsL7Tqe/3s7p9W0pJzzs/v/Gf50hKDtJgIwowmbIW2T1FD3vprWKWfBbQKBgQDAtIuY3X2lnLnn24U6/zNP/DV6vqiVqWk+cLFq1hyQ2lCrenmH3MSCB/oICCji73CtNLc2VY/0QGXRmct0bkn6KS3q4I4gu1UrCp/wN3tDi2OmGo5iYXGIwYEhKnoK/8CW1sba1HHbCovnqEPTgwFEGBBtw1nm6UL3tQ5QAq8hLwKBgQC1iaRRWNZOrfnWakjUffeC6B2338lKAMiYeQ8IUbUEAz35eSKAWvSL+TfATpFsBrpFLX0YWSyNIAEb4MCJ2l3N2q/LMlsoc9wZIP1Ywq1ixQpGsX26Tw/3jadYwz+K+6aWnncPJC5vYwEvLjmE1WYyWFiiVYOhqI8C5MdHJZSXZwKBgQCgkpCzyvPUmPirw1aL53SJVJ33boEpXCXPGrYrUMgyx0dq673ywLmZpC3qnWn8VworuX5krv0pyLNO6PkIRpIr+j5BteWYTqDUIaFN191FVhOtp/k27v1ct+jyiuNw4NVImyTN2TIaE/qqCKKjz0ixxd+CpsH10C62G08WynXFjwKBgAFaDQcuCip70ShvkitC5NzsrYv49p6+cr/v5tTBBwAIpiV9aWxbQQbpzCh6bUrIogpx1ESiJVrHqjpy6fwczCYEQtrYfSVH95OYU0qd6Hybyv/Lwovoms3VGDHpAkgep5bnhyttsYrSyed4CKWckS4+yiorSNejUa1L1tAIz5pxAoGAetf0BMu53Kd8M9DGDNkDL6SnnOpTsOtJt0mUKEe5fZmySqX5aEHtKI30YCJlHNS/y1EJrGvc03jFXREdaLvZ9EbPQtRI2U2LNDo0BBsCNXAYc4q3UU/Xq4tJop4CbILpXFKzEScaONCGR1n5aA6ExraBECXg57b4taExAFE+oA8=";
    //AP_ALIPAY_PUBLIC_KEY #支付宝公钥
    public static String appPublicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAiKdDAq7V2bs5sn1vRQvZiHDgNdwr/x1JrdujPTVHDtK32Nn3D9OUf/n67vr14dmi46BWE1V+iqlErFcu8dyQ7YnXIu6ZnjdXvF0UNW8H/L/w4AziS8jSDpb7lTG/uV9+fxLFIWxiEGDMR8y9QbxMAgoxjadcSfwTen28CM5TnytjoDkdIK92eR3tvSqEbc+WY8jNG4K2XZs8K2Ja8ZxLFVaxKa9ugNolKLverQ4dRXCJrVl5iZqeCGBLmxgHQMs/jcEtnwyWS4PA2ZeHJIM+ljN1LDNcRnUxQ86OxgvRX4zWDSIucC5wH5eEPOLJ74a0LMEVghHLB48ZKI3aWzUS6QIDAQAB";

    public static String batchAppId = "2088241683627856";//AP_BATCH_APP_ID 商户APP_ID

    //public static String batchPid;//AP_BATCH_PID 合作身份者id

    //public static String privateKey;//AP_PRIVATE_KEY #应用私钥

    //public static String publicKey;//AP_PUBLIC_KEY #支付宝公钥

    public static String notifyUrl = "http://pay.xbao8.com/ali/callback";//异步回调地址

    public static String signType = "RSA2";//签名方式

    public static String charset = "utf-8";

    public static String format = "json";

}
