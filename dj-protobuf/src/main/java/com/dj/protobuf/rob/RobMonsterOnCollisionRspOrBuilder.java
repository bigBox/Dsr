// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Rob.proto

package com.dj.protobuf.rob;

public interface RobMonsterOnCollisionRspOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Protocols.RobMonsterOnCollisionRsp)
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
   * <code>optional int32 actionValue = 2;</code>
   */
  boolean hasActionValue();
  /**
   * <code>optional int32 actionValue = 2;</code>
   */
  int getActionValue();

  /**
   * <code>optional int32 actionChange = 3;</code>
   */
  boolean hasActionChange();
  /**
   * <code>optional int32 actionChange = 3;</code>
   */
  int getActionChange();
}
