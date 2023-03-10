// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Trade.proto

package com.dj.protobuf.trade;

public interface StockInfoOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Protocols.StockInfo)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * 物品ID
   * </pre>
   *
   * <code>optional uint32 itemID = 1;</code>
   */
  boolean hasItemID();
  /**
   * <pre>
   * 物品ID
   * </pre>
   *
   * <code>optional uint32 itemID = 1;</code>
   */
  int getItemID();

  /**
   * <pre>
   * 最新价格
   * </pre>
   *
   * <code>optional uint64 lastPrice = 2;</code>
   */
  boolean hasLastPrice();
  /**
   * <pre>
   * 最新价格
   * </pre>
   *
   * <code>optional uint64 lastPrice = 2;</code>
   */
  long getLastPrice();

  /**
   * <pre>
   * 最高价
   * </pre>
   *
   * <code>optional uint64 highestPrice = 3;</code>
   */
  boolean hasHighestPrice();
  /**
   * <pre>
   * 最高价
   * </pre>
   *
   * <code>optional uint64 highestPrice = 3;</code>
   */
  long getHighestPrice();

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
   * 成交量
   * </pre>
   *
   * <code>optional uint64 turnover = 5;</code>
   */
  boolean hasTurnover();
  /**
   * <pre>
   * 成交量
   * </pre>
   *
   * <code>optional uint64 turnover = 5;</code>
   */
  long getTurnover();

  /**
   * <pre>
   * 涨跌百分比*100
   * </pre>
   *
   * <code>optional int64 score = 6;</code>
   */
  boolean hasScore();
  /**
   * <pre>
   * 涨跌百分比*100
   * </pre>
   *
   * <code>optional int64 score = 6;</code>
   */
  long getScore();
}
