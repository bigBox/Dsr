// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Login.proto

package com.dj.protobuf.login;

public interface HeartbeatCfgNtfOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Protocols.HeartbeatCfgNtf)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   *&#47; &lt;/summary&gt;
   * 单位 秒 为0时候则是防沉迷提示，不做心跳处理，只需显示tip
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional int32 interval = 1;</code>
   */
  boolean hasInterval();
  /**
   * <pre>
   *&#47; &lt;/summary&gt;
   * 单位 秒 为0时候则是防沉迷提示，不做心跳处理，只需显示tip
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional int32 interval = 1;</code>
   */
  int getInterval();

  /**
   * <code>optional string tip = 2;</code>
   */
  boolean hasTip();
  /**
   * <code>optional string tip = 2;</code>
   */
  java.lang.String getTip();
  /**
   * <code>optional string tip = 2;</code>
   */
  com.google.protobuf.ByteString
      getTipBytes();
}
