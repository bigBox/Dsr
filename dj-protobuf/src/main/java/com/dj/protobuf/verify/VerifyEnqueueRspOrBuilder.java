// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Verify.proto

package com.dj.protobuf.verify;

public interface VerifyEnqueueRspOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Protocols.VerifyEnqueueRsp)
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
   * <code>optional .Protocols.VerifyEnqueueReq req = 2;</code>
   */
  boolean hasReq();
  /**
   * <code>optional .Protocols.VerifyEnqueueReq req = 2;</code>
   */
  com.dj.protobuf.verify.VerifyEnqueueReq getReq();
  /**
   * <code>optional .Protocols.VerifyEnqueueReq req = 2;</code>
   */
  com.dj.protobuf.verify.VerifyEnqueueReqOrBuilder getReqOrBuilder();

  /**
   * <pre>
   * 鉴定道具(选择用)
   * </pre>
   *
   * <code>repeated .Protocols.VerifyItem items = 3;</code>
   */
  java.util.List<com.dj.protobuf.verify.VerifyItem> 
      getItemsList();
  /**
   * <pre>
   * 鉴定道具(选择用)
   * </pre>
   *
   * <code>repeated .Protocols.VerifyItem items = 3;</code>
   */
  com.dj.protobuf.verify.VerifyItem getItems(int index);
  /**
   * <pre>
   * 鉴定道具(选择用)
   * </pre>
   *
   * <code>repeated .Protocols.VerifyItem items = 3;</code>
   */
  int getItemsCount();
  /**
   * <pre>
   * 鉴定道具(选择用)
   * </pre>
   *
   * <code>repeated .Protocols.VerifyItem items = 3;</code>
   */
  java.util.List<? extends com.dj.protobuf.verify.VerifyItemOrBuilder> 
      getItemsOrBuilderList();
  /**
   * <pre>
   * 鉴定道具(选择用)
   * </pre>
   *
   * <code>repeated .Protocols.VerifyItem items = 3;</code>
   */
  com.dj.protobuf.verify.VerifyItemOrBuilder getItemsOrBuilder(
      int index);

  /**
   * <pre>
   * 鉴定剩余时间(秒数)
   * </pre>
   *
   * <code>optional int32 verifyCD = 4;</code>
   */
  boolean hasVerifyCD();
  /**
   * <pre>
   * 鉴定剩余时间(秒数)
   * </pre>
   *
   * <code>optional int32 verifyCD = 4;</code>
   */
  int getVerifyCD();
}
