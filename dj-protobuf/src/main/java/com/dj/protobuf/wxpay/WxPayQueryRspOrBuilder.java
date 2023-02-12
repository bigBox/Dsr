// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Wxpay.proto

package com.dj.protobuf.wxpay;

public interface WxPayQueryRspOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Protocols.WxPayQueryRsp)
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
   * <code>optional .Protocols.WxPayQueryReq req = 2;</code>
   */
  boolean hasReq();
  /**
   * <code>optional .Protocols.WxPayQueryReq req = 2;</code>
   */
  com.dj.protobuf.wxpay.WxPayQueryReq getReq();
  /**
   * <code>optional .Protocols.WxPayQueryReq req = 2;</code>
   */
  com.dj.protobuf.wxpay.WxPayQueryReqOrBuilder getReqOrBuilder();

  /**
   * <pre>
   * 自有平台账号(微信登录时为OpenId)
   * </pre>
   *
   * <code>optional string account = 3;</code>
   */
  boolean hasAccount();
  /**
   * <pre>
   * 自有平台账号(微信登录时为OpenId)
   * </pre>
   *
   * <code>optional string account = 3;</code>
   */
  java.lang.String getAccount();
  /**
   * <pre>
   * 自有平台账号(微信登录时为OpenId)
   * </pre>
   *
   * <code>optional string account = 3;</code>
   */
  com.google.protobuf.ByteString
      getAccountBytes();

  /**
   * <code>optional uint64 roleID = 4;</code>
   */
  boolean hasRoleID();
  /**
   * <code>optional uint64 roleID = 4;</code>
   */
  long getRoleID();

  /**
   * <pre>
   * 商品id
   * </pre>
   *
   * <code>optional uint32 itemID = 5;</code>
   */
  boolean hasItemID();
  /**
   * <pre>
   * 商品id
   * </pre>
   *
   * <code>optional uint32 itemID = 5;</code>
   */
  int getItemID();

  /**
   * <pre>
   * 商品数量
   * </pre>
   *
   * <code>optional uint32 count = 6;</code>
   */
  boolean hasCount();
  /**
   * <pre>
   * 商品数量
   * </pre>
   *
   * <code>optional uint32 count = 6;</code>
   */
  int getCount();
}
