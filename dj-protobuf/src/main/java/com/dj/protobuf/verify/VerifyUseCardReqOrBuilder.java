// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Verify.proto

package com.dj.protobuf.verify;

public interface VerifyUseCardReqOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Protocols.VerifyUseCardReq)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>optional uint32 index = 1;</code>
   */
  boolean hasIndex();
  /**
   * <code>optional uint32 index = 1;</code>
   */
  int getIndex();

  /**
   * <pre>
   * 鉴定卡id
   * </pre>
   *
   * <code>optional uint32 cardID = 2;</code>
   */
  boolean hasCardID();
  /**
   * <pre>
   * 鉴定卡id
   * </pre>
   *
   * <code>optional uint32 cardID = 2;</code>
   */
  int getCardID();

  /**
   * <pre>
   * 鉴定卡数量
   * </pre>
   *
   * <code>optional uint32 cardCount = 3;</code>
   */
  boolean hasCardCount();
  /**
   * <pre>
   * 鉴定卡数量
   * </pre>
   *
   * <code>optional uint32 cardCount = 3;</code>
   */
  int getCardCount();
}
