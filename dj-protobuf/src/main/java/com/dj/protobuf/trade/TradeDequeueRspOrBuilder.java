// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Trade.proto

package com.dj.protobuf.trade;

public interface TradeDequeueRspOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Protocols.TradeDequeueRsp)
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
   * <code>optional .Protocols.TradeDequeueReq req = 2;</code>
   */
  boolean hasReq();
  /**
   * <code>optional .Protocols.TradeDequeueReq req = 2;</code>
   */
  com.dj.protobuf.trade.TradeDequeueReq getReq();
  /**
   * <code>optional .Protocols.TradeDequeueReq req = 2;</code>
   */
  com.dj.protobuf.trade.TradeDequeueReqOrBuilder getReqOrBuilder();
}
