package com.github.wxpay.sdk;

//import org.apache.http.HttpEntity;
//import org.apache.http.HttpResponse;
//import org.apache.http.client.HttpClient;
//import org.apache.http.client.methods.HttpGet;
//import org.apache.http.config.RegistryBuilder;
//import org.apache.http.conn.DnsResolver;
//import org.apache.http.conn.socket.ConnectionSocketFactory;
//import org.apache.http.conn.socket.PlainConnectionSocketFactory;
//import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
//import org.apache.http.impl.client.DefaultHttpClient;
//import org.apache.http.impl.client.HttpClientBuilder;
//import org.apache.http.impl.conn.BasicHttpClientConnectionManager;
//import org.apache.http.impl.conn.SystemDefaultDnsResolver;
//import org.apache.http.util.EntityUtils;
//
//import java.net.InetAddress;
//import java.net.UnknownHostException;

//public class TestApacheHttpClient {
//    public static void main(String[] args) {
//        /* Custom DNS resolver */
//        DnsResolver dnsResolver = new SystemDefaultDnsResolver() {
//            @Override
//            public InetAddress[] resolve(final String host) throws UnknownHostException {
//                if (host.equalsIgnoreCase("github.comm")) {
//                    return new InetAddress[] { InetAddress.getByName("127.0.0.1") };
//                } else {
//                    return super.resolve(host);
//                }
//            }
//        };
//
//        BasicHttpClientConnectionManager connManager = new BasicHttpClientConnectionManager(
//                RegistryBuilder.<ConnectionSocketFactory>create()
//                        .register("http", PlainConnectionSocketFactory.getSocketFactory())
//                        .register("https", SSLConnectionSocketFactory.getSocketFactory())
//                        .build(),
//                null, /* Default ConnectionFactory */
//                null, /* Default SchemePortResolver */
//                dnsResolver  /* Our DnsResolver */
//        );
//
//        HttpClient httpClient = HttpClientBuilder.create()
//                .setConnectionManager(connManager)
//                .build();
//
//        /* Should hit 127.0.0.1, regardless of DNS */
//        HttpGet httpRequest = new HttpGet("https://127.0.0.1");
//
//        try {
//            //??????DefaultHttpClient??????execute????????????HTTP GET??????????????????HttpResponse?????????
//            HttpResponse httpResponse = httpClient.execute(httpRequest);//??????HttpGet???HttpUriRequst?????????
//            HttpEntity httpEntity = httpResponse.getEntity();
//            String result = EntityUtils.toString(httpEntity);//?????????????????????
//            System.out.println(result);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}
