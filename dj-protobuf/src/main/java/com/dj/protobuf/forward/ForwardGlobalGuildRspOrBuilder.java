// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Forward.proto

package com.dj.protobuf.forward;

public interface ForwardGlobalGuildRspOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Protocols.ForwardGlobalGuildRsp)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>optional uint64 roleID = 1;</code>
   */
  boolean hasRoleID();
  /**
   * <code>optional uint64 roleID = 1;</code>
   */
  long getRoleID();

  /**
   * <code>optional string rspClz = 2;</code>
   */
  boolean hasRspClz();
  /**
   * <code>optional string rspClz = 2;</code>
   */
  java.lang.String getRspClz();
  /**
   * <code>optional string rspClz = 2;</code>
   */
  com.google.protobuf.ByteString
      getRspClzBytes();

  /**
   * <code>optional bytes rsp = 3;</code>
   */
  boolean hasRsp();
  /**
   * <code>optional bytes rsp = 3;</code>
   */
  com.google.protobuf.ByteString getRsp();
}
