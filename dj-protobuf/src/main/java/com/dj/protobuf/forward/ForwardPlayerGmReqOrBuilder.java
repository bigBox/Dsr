// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Forward.proto

package com.dj.protobuf.forward;

public interface ForwardPlayerGmReqOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Protocols.ForwardPlayerGmReq)
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
   * <code>optional string reqClz = 2;</code>
   */
  boolean hasReqClz();
  /**
   * <code>optional string reqClz = 2;</code>
   */
  java.lang.String getReqClz();
  /**
   * <code>optional string reqClz = 2;</code>
   */
  com.google.protobuf.ByteString
      getReqClzBytes();

  /**
   * <code>optional bytes req = 3;</code>
   */
  boolean hasReq();
  /**
   * <code>optional bytes req = 3;</code>
   */
  com.google.protobuf.ByteString getReq();

  /**
   * <code>optional string ps = 4;</code>
   */
  boolean hasPs();
  /**
   * <code>optional string ps = 4;</code>
   */
  java.lang.String getPs();
  /**
   * <code>optional string ps = 4;</code>
   */
  com.google.protobuf.ByteString
      getPsBytes();
}
