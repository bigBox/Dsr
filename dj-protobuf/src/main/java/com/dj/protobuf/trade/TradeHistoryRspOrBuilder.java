// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Trade.proto

package com.dj.protobuf.trade;

public interface TradeHistoryRspOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Protocols.TradeHistoryRsp)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>optional .ErrorID errorID = 1;</code>
   */
  boolean hasErrorID();
  /**
   * <code>optional .ErrorID errorID = 1;</code>
   */
  com.dj.protobuf.ErrorIDOuterClass.ErrorID getErrorID();

  /**
   * <code>optional .Protocols.TradeHistoryReq req = 2;</code>
   */
  boolean hasReq();
  /**
   * <code>optional .Protocols.TradeHistoryReq req = 2;</code>
   */
  com.dj.protobuf.trade.TradeHistoryReq getReq();
  /**
   * <code>optional .Protocols.TradeHistoryReq req = 2;</code>
   */
  com.dj.protobuf.trade.TradeHistoryReqOrBuilder getReqOrBuilder();

  /**
   * <pre>
   * 最新价格
   * </pre>
   *
   * <code>optional uint64 lastPrice = 3;</code>
   */
  boolean hasLastPrice();
  /**
   * <pre>
   * 最新价格
   * </pre>
   *
   * <code>optional uint64 lastPrice = 3;</code>
   */
  long getLastPrice();

  /**
   * <pre>
   * 最低价
   * </pre>
   *
   * <code>optional uint64 lowestPrice = 4;</code>
   */
  boolean hasLowestPrice();
  /**
   * <pre>
   * 最低价
   * </pre>
   *
   * <code>optional uint64 lowestPrice = 4;</code>
   */
  long getLowestPrice();

  /**
   * <pre>
   * 最低价
   * </pre>
   *
   * <code>optional uint64 highestPrice = 5;</code>
   */
  boolean hasHighestPrice();
  /**
   * <pre>
   * 最低价
   * </pre>
   *
   * <code>optional uint64 highestPrice = 5;</code>
   */
  long getHighestPrice();

  /**
   * <pre>
   * 历史价格
   * </pre>
   *
   * <code>repeated .Protocols.HistoryInfo historyPrices = 6;</code>
   */
  java.util.List<com.dj.protobuf.trade.HistoryInfo> 
      getHistoryPricesList();
  /**
   * <pre>
   * 历史价格
   * </pre>
   *
   * <code>repeated .Protocols.HistoryInfo historyPrices = 6;</code>
   */
  com.dj.protobuf.trade.HistoryInfo getHistoryPrices(int index);
  /**
   * <pre>
   * 历史价格
   * </pre>
   *
   * <code>repeated .Protocols.HistoryInfo historyPrices = 6;</code>
   */
  int getHistoryPricesCount();
  /**
   * <pre>
   * 历史价格
   * </pre>
   *
   * <code>repeated .Protocols.HistoryInfo historyPrices = 6;</code>
   */
  java.util.List<? extends com.dj.protobuf.trade.HistoryInfoOrBuilder> 
      getHistoryPricesOrBuilderList();
  /**
   * <pre>
   * 历史价格
   * </pre>
   *
   * <code>repeated .Protocols.HistoryInfo historyPrices = 6;</code>
   */
  com.dj.protobuf.trade.HistoryInfoOrBuilder getHistoryPricesOrBuilder(
      int index);
}
