// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Wxpay.proto

package com.dj.protobuf.wxpay;

public interface WxPayQueryReqOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Protocols.WxPayQueryReq)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * 自有平台账号(微信登录时为OpenId)
   * </pre>
   *
   * <code>optional string account = 1;</code>
   */
  boolean hasAccount();
  /**
   * <pre>
   * 自有平台账号(微信登录时为OpenId)
   * </pre>
   *
   * <code>optional string account = 1;</code>
   */
  java.lang.String getAccount();
  /**
   * <pre>
   * 自有平台账号(微信登录时为OpenId)
   * </pre>
   *
   * <code>optional string account = 1;</code>
   */
  com.google.protobuf.ByteString
      getAccountBytes();

  /**
   * <code>optional uint64 roleID = 2;</code>
   */
  boolean hasRoleID();
  /**
   * <code>optional uint64 roleID = 2;</code>
   */
  long getRoleID();

  /**
   * <pre>
   * 交易流水号
   * </pre>
   *
   * <code>optional string tradeNo = 3;</code>
   */
  boolean hasTradeNo();
  /**
   * <pre>
   * 交易流水号
   * </pre>
   *
   * <code>optional string tradeNo = 3;</code>
   */
  java.lang.String getTradeNo();
  /**
   * <pre>
   * 交易流水号
   * </pre>
   *
   * <code>optional string tradeNo = 3;</code>
   */
  com.google.protobuf.ByteString
      getTradeNoBytes();
}
