// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Login.proto

package com.dj.protobuf.login;

public interface CreateSmsCodeRspOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Protocols.CreateSmsCodeRsp)
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
   * <code>optional .Protocols.CreateSmsCodeReq req = 2;</code>
   */
  boolean hasReq();
  /**
   * <code>optional .Protocols.CreateSmsCodeReq req = 2;</code>
   */
  com.dj.protobuf.login.CreateSmsCodeReq getReq();
  /**
   * <code>optional .Protocols.CreateSmsCodeReq req = 2;</code>
   */
  com.dj.protobuf.login.CreateSmsCodeReqOrBuilder getReqOrBuilder();
}
