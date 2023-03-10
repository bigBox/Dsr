//package com.github.wxpay.sdk;
//
//import java.text.SimpleDateFormat;
//import java.util.Calendar;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//
//public class TestWXPay {
//
//    private WXPay wxpay;
//    private WXPayConfigImpl config;
//    private String out_trade_no;
//    private String total_fee;
//
//    public TestWXPay() throws Exception {
//        config = WXPayConfigImpl.getInstance();
//        wxpay = new WXPay(config);
//        total_fee = "201";
//        out_trade_no = "201701017496748980290321";
//        //out_trade_no = "201613091059590000003433-asd002";
//    }
//
//    /**
//     * 扫码支付  下单
//     */
//    public void doUnifiedOrder() {
//        HashMap<String, String> data = new HashMap<String, String>();
//        data.put("body", "寻宝吧-钻石");
//        data.put("out_trade_no", out_trade_no);
//        data.put("device_info", "");
//        data.put("fee_type", "CNY");
//        data.put("total_fee", total_fee);
//        data.put("spbill_create_ip", "112.23.119.49");
//        data.put("notify_url", "http://test.letiantian.me/wxpay/notify");
//        data.put("trade_type", "APP");
//        data.put("product_id", "1001");
//        String time_start = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
//        data.put("time_start", time_start);
//        Calendar ca = Calendar.getInstance();
//        ca.setTime(new Date());
//        ca.add(Calendar.DATE, 1);
//        String time_expire = new SimpleDateFormat("yyyyMMddHHmmss").format(ca.getTime());
//        data.put("time_expire", time_expire);
//        //data.put("goods_tag","MEETING");
//        //data.put("version","1.0");
//        //data.put("detail","[{\"cost_price\":1,\"receipt_id\":\"wx123\",\"goods_detail\":[{\"goods_id\":\"商品编码\",\"wxpay_goods_id\":\"1001\",\"goods_name\":\"iPhone6s 16G\",\"quantity\":1,\"price\":1},{\"goods_id\":\"商品编码\",\"wxpay_goods_id\":\"1002\",\"goods_name\":\"iPhone6s 32G\",\"quantity\":1,\"price\":1}]}]");
//        try {
//            Map<String, String> r = wxpay.unifiedOrder(data);
//            System.out.println(r);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * 订单关闭
//     */
//    public void doOrderClose() {
//        System.out.println("关闭订单");
//        HashMap<String, String> data = new HashMap<String, String>();
//        data.put("out_trade_no", out_trade_no);
//        try {
//            Map<String, String> r = wxpay.closeOrder(data);
//            System.out.println(r);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//    /**
//     * 查询订单
//     */
//    public void doOrderQuery() {
//        System.out.println("查询订单");
//        HashMap<String, String> data = new HashMap<String, String>();
//        data.put("out_trade_no", out_trade_no);
////        data.put("transaction_id", "4008852001201608221962061594");
//        try {
//            Map<String, String> r = wxpay.orderQuery(data);
//            System.out.println(r);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//    /**
//     * 订单撤销
//     */
//    public void doOrderReverse() {
//        System.out.println("撤销");
//        HashMap<String, String> data = new HashMap<String, String>();
//        data.put("out_trade_no", out_trade_no);
////        data.put("transaction_id", "4008852001201608221962061594");
//        try {
//            Map<String, String> r = wxpay.reverse(data);
//            System.out.println(r);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//
//
//    /**
//     * 长链接转短链接
//     * 测试成功
//     */
//    public void doShortUrl() {
//        String long_url = "weixin://wxpay/bizpayurl?pr=etxB4DY";
//        HashMap<String, String> data = new HashMap<String, String>();
//        data.put("long_url", long_url);
//        try {
//            Map<String, String> r = wxpay.shortUrl(data);
//            System.out.println(r);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * 退款
//     * 已测试
//     */
//    public void doRefund() {
//        HashMap<String, String> data = new HashMap<String, String>();
//        data.put("out_trade_no", out_trade_no);
//        data.put("out_refund_no", out_trade_no);
//        data.put("total_fee", total_fee);
//        data.put("refund_fee", total_fee);
//        data.put("refund_fee_type", "CNY");
//        data.put("op_user_id", config.getMchID());
//
//        try {
//            Map<String, String> r = wxpay.refund(data);
//            System.out.println(r);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
//
//    /**
//     * 查询退款
//     * 已经测试
//     */
//    public void doRefundQuery() {
//        HashMap<String, String> data = new HashMap<String, String>();
//        data.put("out_refund_no", out_trade_no);
//        try {
//            Map<String, String> r = wxpay.refundQuery(data);
//            System.out.println(r);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * 对账单下载
//     * 已测试
//     */
//    public void doDownloadBill() {
//        HashMap<String, String> data = new HashMap<String, String>();
//        data.put("bill_date", "20161102");
//        data.put("bill_type", "ALL");
//        try {
//            Map<String, String> r = wxpay.downloadBill(data);
//            System.out.println(r);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//    /**
//     * 沙箱环境获取验签秘钥
//     */
//    public void doGetSandboxSignKey() throws Exception {
//        WXPayConfigImpl config = WXPayConfigImpl.getInstance();
//        HashMap<String, String> data = new HashMap<String, String>();
//        data.put("mch_id", config.getMchID());
//        data.put("nonce_str", WXPayUtil.generateNonceStr());
//        String sign = WXPayUtil.generateSignature(data, config.getKey());
//        data.put("sign", sign);
//        WXPay wxPay = new WXPay(config);
//        String result = wxPay.requestWithoutCert(WXPayConstants.SANDBOX_GETSIGNKEY_URL_SUFFIX, data, 10000, 10000);
//        HashMap<String, String> map = (HashMap<String, String>) WXPayUtil.xmlToMap(result);
//        System.out.println(map.get("sandbox_signkey"));
//    }
//    /**
//     * 交易保障
//     */
//
////    public void doReport() {
////        HashMap<String, String> data = new HashMap<String, String>();
////        data.put("interface_url", "20160822");
////        data.put("bill_type", "ALL");
////    }
//
//    /**
//     * 小测试
//     */
//    public void test001() {
//        String xmlStr="<xml><return_code><![CDATA[SUCCESS]]></return_code>\n" +
//                "<return_msg><![CDATA[OK]]></return_msg>\n" +
//                "<appid><![CDATA[wx273fe72f2db863ed]]></appid>\n" +
//                "<mch_id><![CDATA[1228845802]]></mch_id>\n" +
//                "<nonce_str><![CDATA[lCXjx3wNx45HfTV2]]></nonce_str>\n" +
//                "<sign><![CDATA[68D7573E006F0661FD2A77BA59124E87]]></sign>\n" +
//                "<result_code><![CDATA[SUCCESS]]></result_code>\n" +
//                "<openid><![CDATA[oZyc_uPx_oed7b4q1yKmj_3M2fTU]]></openid>\n" +
//                "<is_subscribe><![CDATA[N]]></is_subscribe>\n" +
//                "<trade_type><![CDATA[NATIVE]]></trade_type>\n" +
//                "<bank_type><![CDATA[CFT]]></bank_type>\n" +
//                "<total_fee>1</total_fee>\n" +
//                "<fee_type><![CDATA[CNY]]></fee_type>\n" +
//                "<transaction_id><![CDATA[4008852001201608221983528929]]></transaction_id>\n" +
//                "<out_trade_no><![CDATA[20160822162018]]></out_trade_no>\n" +
//                "<attach><![CDATA[]]></attach>\n" +
//                "<time_end><![CDATA[20160822202556]]></time_end>\n" +
//                "<trade_state><![CDATA[SUCCESS]]></trade_state>\n" +
//                "<cash_fee>1</cash_fee>\n" +
//                "</xml>";
//        try {
//            System.out.println(xmlStr);
//            System.out.println("+++++++++++++++++");
//            System.out.println(WXPayUtil.isSignatureValid(xmlStr, config.getKey()));
//            Map<String, String> hm = WXPayUtil.xmlToMap(xmlStr);
//            System.out.println("+++++++++++++++++");
//            System.out.println(hm);
//            System.out.println(hm.get("attach").length());
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
//
//    public void testUnifiedOrderSpeed() throws Exception {
////        TestWXPay dodo = new TestWXPay();
////
////        for (int i=0; i<100; ++i) {
////            long startTs = System.currentTimeMillis();
////            out_trade_no = out_trade_no+i;
////            dodo.doUnifiedOrder();
////            long endTs = System.currentTimeMillis();
////            System.out.println(endTs-startTs);
////            Thread.sleep(1000);
////        }
//
//    }
//
//    public static void main(String[] args) throws Exception {
//        //System.out.println("--------------->");
//        //TestWXPay dodo = new TestWXPay();
//        //dodo.doGetSandboxSignKey();
//        //dodo.testUnifiedOrderSpeed();
//        //dodo.doUnifiedOrder();
//        //dodo.doOrderQuery();
//        // dodo.doDownloadBill();
//        // dodo.doShortUrl();
//        // dodo.test001();
//        // dodo.doOrderQuery();
//        // dodo.doOrderClose();
//        // dodo.doRefund();
//        // dodo.doRefundQuery();
//        // dodo.doOrderReverse();
//        //System.out.println("<---------------"); // wx2016112510573077
//    }
//}
