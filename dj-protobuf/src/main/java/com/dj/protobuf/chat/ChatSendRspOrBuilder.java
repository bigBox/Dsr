// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Chat.proto

package com.dj.protobuf.chat;

public interface ChatSendRspOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Protocols.ChatSendRsp)
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
   * <code>optional .Protocols.ChatSendReq req = 2;</code>
   */
  boolean hasReq();
  /**
   * <code>optional .Protocols.ChatSendReq req = 2;</code>
   */
  com.dj.protobuf.chat.ChatSendReq getReq();
  /**
   * <code>optional .Protocols.ChatSendReq req = 2;</code>
   */
  com.dj.protobuf.chat.ChatSendReqOrBuilder getReqOrBuilder();
}
