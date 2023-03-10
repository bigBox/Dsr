// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Trade.proto

package com.dj.protobuf.trade;

public interface TradeOrderInfoOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Protocols.TradeOrderInfo)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * 交易类型
   * </pre>
   *
   * <code>optional .Protocols.TradeType type = 1;</code>
   */
  boolean hasType();
  /**
   * <pre>
   * 交易类型
   * </pre>
   *
   * <code>optional .Protocols.TradeType type = 1;</code>
   */
  com.dj.protobuf.trade.TradeType getType();

  /**
   * <pre>
   * 挂单ID
   * </pre>
   *
   * <code>optional uint64 orderID = 2;</code>
   */
  boolean hasOrderID();
  /**
   * <pre>
   * 挂单ID
   * </pre>
   *
   * <code>optional uint64 orderID = 2;</code>
   */
  long getOrderID();

  /**
   * <pre>
   * 挂单数量
   * </pre>
   *
   * <code>optional uint64 orderNum = 3;</code>
   */
  boolean hasOrderNum();
  /**
   * <pre>
   * 挂单数量
   * </pre>
   *
   * <code>optional uint64 orderNum = 3;</code>
   */
  long getOrderNum();

  /**
   * <pre>
   * 已经完成的交易物品数量
   * </pre>
   *
   * <code>optional uint64 tradeNum = 4;</code>
   */
  boolean hasTradeNum();
  /**
   * <pre>
   * 已经完成的交易物品数量
   * </pre>
   *
   * <code>optional uint64 tradeNum = 4;</code>
   */
  long getTradeNum();

  /**
   * <pre>
   * 物品ID
   * </pre>
   *
   * <code>optional uint32 itemID = 5;</code>
   */
  boolean hasItemID();
  /**
   * <pre>
   * 物品ID
   * </pre>
   *
   * <code>optional uint32 itemID = 5;</code>
   */
  int getItemID();

  /**
   * <pre>
   * 物品数量
   * </pre>
   *
   * <code>optional uint64 itemNum = 6;</code>
   */
  boolean hasItemNum();
  /**
   * <pre>
   * 物品数量
   * </pre>
   *
   * <code>optional uint64 itemNum = 6;</code>
   */
  long getItemNum();

  /**
   * <pre>
   * 单品价格
   * </pre>
   *
   * <code>optional uint64 price = 7;</code>
   */
  boolean hasPrice();
  /**
   * <pre>
   * 单品价格
   * </pre>
   *
   * <code>optional uint64 price = 7;</code>
   */
  long getPrice();

  /**
   * <pre>
   * 挂单总价格
   * </pre>
   *
   * <code>optional uint64 amount = 8;</code>
   */
  boolean hasAmount();
  /**
   * <pre>
   * 挂单总价格
   * </pre>
   *
   * <code>optional uint64 amount = 8;</code>
   */
  long getAmount();

  /**
   * <pre>
   * 挂单发起者
   * </pre>
   *
   * <code>optional uint64 roleID = 9;</code>
   */
  boolean hasRoleID();
  /**
   * <pre>
   * 挂单发起者
   * </pre>
   *
   * <code>optional uint64 roleID = 9;</code>
   */
  long getRoleID();
}
