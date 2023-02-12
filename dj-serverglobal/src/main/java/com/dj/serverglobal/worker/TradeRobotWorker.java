//package com.dj.serverglobal.worker;
//
//import java.util.List;
//import java.util.concurrent.BlockingQueue;
//import java.util.concurrent.LinkedBlockingQueue;
//
//import com.dj.domain.GlobalRoleID;
//import com.dj.domain.entity.global.GlobalTrade;
//import com.dj.domain.entity.global.GlobalTradeOrder;
//import com.dj.domain.topic.TradeUseEvent;
//import com.dj.protobuf.trade.TradeType;
//import com.dj.servercore.spring.SpringContext;
//import com.dj.serverglobal.handler.GlobalTradeHandler;
//import com.dj.serverglobal.manager.DataManager;
//import com.dj.domain.util.Utility;
//
//import lombok.extern.slf4j.Slf4j;
//
///**
//* @ClassName: TradeRobotWorker
//* @Description: 交易机器人
//* @author zcq
//* @date 2021年3月6日
// */
//@Slf4j
//public class TradeRobotWorker extends Thread {
//
//	private BlockingQueue<Integer> orderQueue = new LinkedBlockingQueue<Integer>();
//
//	private GlobalTradeHandler tradeHandler = SpringContext.getBean(GlobalTradeHandler.class);
//
//	private static TradeRobotWorker worker = new TradeRobotWorker();
//
//	public static TradeRobotWorker getWorker() {
//		return worker;
//	}
//
//	public TradeRobotWorker() {
//		super(TradeRobotWorker.class.getSimpleName());
//	}
//
//	public void addOrder(int orderID) {
//		orderQueue.add(orderID);
//	}
//
//	@Override
//	public void run() {
//		while(true) {
//			try {
//				sleep(2000);
//				int orderID = orderQueue.take();
//				TradeUseEvent event = new TradeUseEvent();
//				event.setRoleID(GlobalRoleID.getXiaoXun());
//				List<GlobalTradeOrder> tradeList = tradeHandler.getTradeTopN(event.getRoleID(), orderID, TradeType.Sell, 1);
//				if(tradeList.size() > 0) {
//					event.setType(TradeType.Buy_VALUE);
//					event.setOrderID(orderID);
//					event.setId(tradeList.get(0).getId());
//					event.setNum(1);
//					tradeHandler.tradeUse(event);
//				}else {
//					tradeList = tradeHandler.getTradeTopN(event.getRoleID(), orderID, TradeType.Buy, 1);
//					if(tradeList.size() > 0) {
//						event.setType(TradeType.Sell_VALUE);
//						event.setOrderID(orderID);
//						event.setId(tradeList.get(0).getId());
//						event.setNum(1);
//						tradeHandler.tradeUse(event);
//					}
//				}
//			} catch (Exception e) {
//				log.error(Utility.getTraceString(e));
//			}
//		}
//	}
//}
