//package com.github.wxpay.sdk;
//
//import com.google.zxing.BarcodeFormat;
//import com.google.zxing.EncodeHintType;
//import com.google.zxing.MultiFormatWriter;
//import com.google.zxing.WriterException;
//import com.google.zxing.common.BitMatrix;
//
//import java.util.HashMap;
//import java.util.Hashtable;
//import java.util.Map;
//
//public class TestWXPayPerformance {
//
//
//    private WXPay wxpay;
//    private WXPayConfigImpl config;
//    private String out_trade_no;
//    private String total_fee;
//
//    public TestWXPayPerformance() throws Exception {
//        config = WXPayConfigImpl.getInstance();
//        wxpay = new WXPay(config);
//        total_fee = "1";//正式环境(分)
//        out_trade_no = "201701017496748980290393";
//    }
//
//    /**
//     * 统一下单
//     */
//    public void doUnifiedOrder() {
//        HashMap<String, String> data = new HashMap<String, String>();
//        data.put("body", "腾讯充值中心-QQ会员充值");
//        data.put("out_trade_no", out_trade_no);
//        data.put("device_info", "");
//        data.put("fee_type", "CNY");
//        data.put("total_fee", total_fee);
//        data.put("spbill_create_ip", "123.12.12.123");
//        data.put("notify_url", "http://www.aifengx.club/provider03/pay/notify_url");
//        data.put("trade_type", "NATIVE");
//        data.put("product_id", "12");
//        // data.put("time_expire", "20170112104120");
//        int width = 300; // 二维码图片宽度
//        int height = 300; // 二维码图片高度
//        String format = "png";// 二维码的图片格式
//
//        Hashtable<EncodeHintType, String> hints = new Hashtable<EncodeHintType, String>();
//        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");   // 内容所使用字符集编码
//        BitMatrix bitMatrix;
//        try {
//            Map<String, String> r = wxpay.unifiedOrder(data);
//            System.out.println("下单结果"+r);
//            try {
//				bitMatrix = new MultiFormatWriter().encode(r.get("code_url"), BarcodeFormat.QR_CODE, width, height, hints);
//				// 生成二维码
//                //File outputFile = new File("d:" + File.separator + "weixinpay.png");
//                //try {
//				//	MatrixToImageWriterUtils.writeToFile(bitMatrix, format, outputFile);
//				//} catch (IOException e) {
//				//	e.printStackTrace();
//				//}
//			} catch (WriterException e) {
//				e.printStackTrace();
//			}
//            System.out.println("下单结果"+r);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * 关闭订单
//     */
//    public void doOrderClose() {
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
//     * 付款码支付
//     */
//    public void doMicropayWithPos(String auth_code) {
//        HashMap<String, String> data = new HashMap<String, String>();
//        data.put("out_trade_no", out_trade_no);
//        data.put("body", "测试");
//        data.put("total_fee", "1");
//        data.put("auth_code", auth_code);
//        try {
//            Map<String, String> r = wxpay.microPayWithPos(data);
//            System.out.println(r);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//    /**
//     * 订单撤销
//     */
//    public void doOrderReverse() {
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
//    public String doShortUrl(String long_url) {
//        //String long_url = "weixin://wxpay/bizpayurl?pr=ZpEo615";
//        HashMap<String, String> data = new HashMap<String, String>();
//        data.put("long_url", long_url);
//        Map<String, String> r = null;
//        try {
//            r = wxpay.shortUrl(data);
//            System.out.println(r);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return r.get("short_url");
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
//        data.put("bill_date", "20180530");
//        data.put("bill_type", "ALL");
//        try {
//            Map<String, String> r = wxpay.downloadBill(data);
//            System.out.println(r);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
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
////        String xmlStr="<xml><return_code><![CDATA[SUCCESS]]></return_code>\n" +
////                "<return_msg><![CDATA[OK]]></return_msg>\n" +
////                "<appid><![CDATA[wx273fe72f2db863ed]]></appid>\n" +
////                "<mch_id><![CDATA[1228845802]]></mch_id>\n" +
////                "<nonce_str><![CDATA[lCXjx3wNx45HfTV2]]></nonce_str>\n" +
////                "<sign><![CDATA[68D7573E006F0661FD2A77BA59124E87]]></sign>\n" +
////                "<result_code><![CDATA[SUCCESS]]></result_code>\n" +
////                "<openid><![CDATA[oZyc_uPx_oed7b4q1yKmj_3M2fTU]]></openid>\n" +
////                "<is_subscribe><![CDATA[N]]></is_subscribe>\n" +
////                "<trade_type><![CDATA[NATIVE]]></trade_type>\n" +
////                "<bank_type><![CDATA[CFT]]></bank_type>\n" +
////                "<total_fee>1</total_fee>\n" +
////                "<fee_type><![CDATA[CNY]]></fee_type>\n" +
////                "<transaction_id><![CDATA[4008852001201608221983528929]]></transaction_id>\n" +
////                "<out_trade_no><![CDATA[20160822162018]]></out_trade_no>\n" +
////                "<attach><![CDATA[]]></attach>\n" +
////                "<time_end><![CDATA[20160822202556]]></time_end>\n" +
////                "<trade_state><![CDATA[SUCCESS]]></trade_state>\n" +
////                "<cash_fee>1</cash_fee>\n" +
////                "</xml>";
////        try {
////            System.out.println(xmlStr);
////            System.out.println("+++++++++++++++++");
////            System.out.println(WXPayUtil.isSignatureValid(xmlStr, config.getKey()));
////            Map<String, String> hm = WXPayUtil.xmlToMap(xmlStr);
////            System.out.println("+++++++++++++++++");
////            System.out.println(hm);
////            System.out.println(hm.get("attach").length());
////
////        } catch (Exception e) {
////            e.printStackTrace();
////        }
//
//    }
//
//    public void testUnifiedOrderSpeed() throws Exception {
////        TestWXPayPerformance dodo = new TestWXPayPerformance();
////
////        for (int i=0; i<100; ++i) {
////            long startTs = System.currentTimeMillis();
////            out_trade_no = out_trade_no+i;
////            dodo.doUnifiedOrder();
////            long endTs = System.currentTimeMillis();
////            System.out.println(String.format("time used to unified order: %ld", endTs-startTs));
////            Thread.sleep(2000);
////        }
//
//    }
//
//    public void testRefundSpeed() throws Exception {
////        TestWXPayPerformance dodo = new TestWXPayPerformance();
////
////        for (int i=0; i<1000; ++i) {
////            long startTs = System.currentTimeMillis();
////            out_trade_no = out_trade_no+i;
////            dodo.doRefund();
////            long endTs = System.currentTimeMillis();
////            System.out.println(String.format("time used to refund: %ld", endTs-startTs));
////            Thread.sleep(2*1000);
////        }
//
//    }
//
//    public void testUnifiedOrderSpeedWithMultiThread() throws Exception {
////        Runnable task = new Runnable() {
////            public void run() {
////                try {
////                    testUnifiedOrderSpeed();
////                }
////                catch (Exception ex) {
////
////                }
////            }
////        };
////        int threadNum = 8;
////        ArrayList<Thread> threads = new ArrayList<Thread>();
////        for (int i=0; i<threadNum; ++i) {
////            threads.add(new Thread(task));
////        }
////        for (int i=0; i<threadNum; ++i) {
////            threads.get(i).start();
////        }
////        for (int i=0; i<threadNum; ++i) {
////            threads.get(i).join();
////        }
//
//    }
//
//    public void testRefundSpeedWithMultiThread() throws Exception {
////        Runnable task = new Runnable() {
////            public void run() {
////                try {
////                    testRefundSpeed();
////                }
////                catch (Exception ex) {
////
////                }
////            }
////        };
////        int threadNum = 8;
////        ArrayList<Thread> threads = new ArrayList<Thread>();
////        for (int i=0; i<threadNum; ++i) {
////            threads.add(new Thread(task));
////        }
////        for (int i=0; i<threadNum; ++i) {
////            threads.get(i).start();
////        }
////        for (int i=0; i<threadNum; ++i) {
////            threads.get(i).join();
////        }
//
//    }
//
//    public void testHelloWorld() throws Exception {
////        for (int i=0; i<1000; ++i) {
////            System.out.println("hi");
////            Thread.sleep(1000);
////        }
//    }
//
//
//
//    public static void main(String[] args) throws Exception {
//        //System.out.println("--------------->");
//        //TestWXPayPerformance dodo = new TestWXPayPerformance();
//
//        //dodo.doUnifiedOrder();//统一下单(可进行二维码支付)
//        //dodo.doOrderQuery();//查询订单
//        //dodo.doOrderClose();//关闭订单
//        //dodo.doDownloadBill();//对账单下载
//        //dodo.doRefund();//申请退款
//        //dodo.doRefundQuery();//退款情况查询
//        //dodo.doShortUrl();
//        //dodo.doOrderReverse();//订单撤销
//        //dodo.doMicropayWithPos("281920324935854674");//付款码扫码支付
//        //dodo.testUnifiedOrderSpeed();
//        //dodo.testUnifiedOrderSpeedWithMultiThread();
//        //dodo.testRefundSpeedWithMultiThread();
//        //dodo.testRefundSpeed();
//        //dodo.testHelloWorld();
//        //dodo.test001();
//        //System.out.println("<---------------"); // wx2016112510573077
//        //Thread.sleep(5000);
//    }
//}
//
