// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Summon.proto

package com.dj.protobuf.summon;

public interface SummonRetainRspOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Protocols.SummonRetainRsp)
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
   * <code>optional .Protocols.SummonRetainReq req = 2;</code>
   */
  boolean hasReq();
  /**
   * <code>optional .Protocols.SummonRetainReq req = 2;</code>
   */
  com.dj.protobuf.summon.SummonRetainReq getReq();
  /**
   * <code>optional .Protocols.SummonRetainReq req = 2;</code>
   */
  com.dj.protobuf.summon.SummonRetainReqOrBuilder getReqOrBuilder();
}
