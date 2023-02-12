// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Trade.proto

package com.dj.protobuf.trade;

public interface StockListRspOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Protocols.StockListRsp)
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
   * <code>optional .Protocols.StockListReq req = 2;</code>
   */
  boolean hasReq();
  /**
   * <code>optional .Protocols.StockListReq req = 2;</code>
   */
  com.dj.protobuf.trade.StockListReq getReq();
  /**
   * <code>optional .Protocols.StockListReq req = 2;</code>
   */
  com.dj.protobuf.trade.StockListReqOrBuilder getReqOrBuilder();

  /**
   * <code>map&lt;uint32, .Protocols.StockInfo&gt; stocks = 3;</code>
   */
  int getStocksCount();
  /**
   * <code>map&lt;uint32, .Protocols.StockInfo&gt; stocks = 3;</code>
   */
  boolean containsStocks(
      int key);
  /**
   * Use {@link #getStocksMap()} instead.
   */
  @java.lang.Deprecated
  java.util.Map<java.lang.Integer, com.dj.protobuf.trade.StockInfo>
  getStocks();
  /**
   * <code>map&lt;uint32, .Protocols.StockInfo&gt; stocks = 3;</code>
   */
  java.util.Map<java.lang.Integer, com.dj.protobuf.trade.StockInfo>
  getStocksMap();
  /**
   * <code>map&lt;uint32, .Protocols.StockInfo&gt; stocks = 3;</code>
   */

  com.dj.protobuf.trade.StockInfo getStocksOrDefault(
      int key,
      com.dj.protobuf.trade.StockInfo defaultValue);
  /**
   * <code>map&lt;uint32, .Protocols.StockInfo&gt; stocks = 3;</code>
   */

  com.dj.protobuf.trade.StockInfo getStocksOrThrow(
      int key);
}
