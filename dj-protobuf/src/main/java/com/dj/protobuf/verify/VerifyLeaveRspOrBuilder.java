// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Verify.proto

package com.dj.protobuf.verify;

public interface VerifyLeaveRspOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Protocols.VerifyLeaveRsp)
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
   * <code>optional uint64 roleId = 2;</code>
   */
  boolean hasRoleId();
  /**
   * <code>optional uint64 roleId = 2;</code>
   */
  long getRoleId();
}