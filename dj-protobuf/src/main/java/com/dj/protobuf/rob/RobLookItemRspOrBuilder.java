// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Rob.proto

package com.dj.protobuf.rob;

public interface RobLookItemRspOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Protocols.RobLookItemRsp)
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
   * <code>optional .Protocols.RobLookItemReq req = 2;</code>
   */
  boolean hasReq();
  /**
   * <code>optional .Protocols.RobLookItemReq req = 2;</code>
   */
  com.dj.protobuf.rob.RobLookItemReq getReq();
  /**
   * <code>optional .Protocols.RobLookItemReq req = 2;</code>
   */
  com.dj.protobuf.rob.RobLookItemReqOrBuilder getReqOrBuilder();

  /**
   * <code>optional int32 type = 3;</code>
   */
  boolean hasType();
  /**
   * <code>optional int32 type = 3;</code>
   */
  int getType();
}
