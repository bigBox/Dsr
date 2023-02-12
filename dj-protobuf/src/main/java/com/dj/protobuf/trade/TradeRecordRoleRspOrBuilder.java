// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Trade.proto

package com.dj.protobuf.trade;

public interface TradeRecordRoleRspOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Protocols.TradeRecordRoleRsp)
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
   * <code>optional .Protocols.TradeRecordRoleReq req = 2;</code>
   */
  boolean hasReq();
  /**
   * <code>optional .Protocols.TradeRecordRoleReq req = 2;</code>
   */
  com.dj.protobuf.trade.TradeRecordRoleReq getReq();
  /**
   * <code>optional .Protocols.TradeRecordRoleReq req = 2;</code>
   */
  com.dj.protobuf.trade.TradeRecordRoleReqOrBuilder getReqOrBuilder();

  /**
   * <pre>
   * 交易记录列表
   * </pre>
   *
   * <code>repeated .Protocols.TradeRecordInfo info = 3;</code>
   */
  java.util.List<com.dj.protobuf.trade.TradeRecordInfo> 
      getInfoList();
  /**
   * <pre>
   * 交易记录列表
   * </pre>
   *
   * <code>repeated .Protocols.TradeRecordInfo info = 3;</code>
   */
  com.dj.protobuf.trade.TradeRecordInfo getInfo(int index);
  /**
   * <pre>
   * 交易记录列表
   * </pre>
   *
   * <code>repeated .Protocols.TradeRecordInfo info = 3;</code>
   */
  int getInfoCount();
  /**
   * <pre>
   * 交易记录列表
   * </pre>
   *
   * <code>repeated .Protocols.TradeRecordInfo info = 3;</code>
   */
  java.util.List<? extends com.dj.protobuf.trade.TradeRecordInfoOrBuilder> 
      getInfoOrBuilderList();
  /**
   * <pre>
   * 交易记录列表
   * </pre>
   *
   * <code>repeated .Protocols.TradeRecordInfo info = 3;</code>
   */
  com.dj.protobuf.trade.TradeRecordInfoOrBuilder getInfoOrBuilder(
      int index);
}
