// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: ShowTable.proto

package com.dj.protobuf.showtable;

public interface AntiqueComposeRspOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Protocols.AntiqueComposeRsp)
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
   * <code>optional .Protocols.AntiqueComposeReq req = 2;</code>
   */
  boolean hasReq();
  /**
   * <code>optional .Protocols.AntiqueComposeReq req = 2;</code>
   */
  com.dj.protobuf.showtable.AntiqueComposeReq getReq();
  /**
   * <code>optional .Protocols.AntiqueComposeReq req = 2;</code>
   */
  com.dj.protobuf.showtable.AntiqueComposeReqOrBuilder getReqOrBuilder();
}
