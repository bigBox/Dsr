// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Login.proto

package com.dj.protobuf.login;

public interface CreateSmsCodeReqOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Protocols.CreateSmsCodeReq)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 手机号
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional string phoneNum = 1;</code>
   */
  boolean hasPhoneNum();
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 手机号
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional string phoneNum = 1;</code>
   */
  java.lang.String getPhoneNum();
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 手机号
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional string phoneNum = 1;</code>
   */
  com.google.protobuf.ByteString
      getPhoneNumBytes();

  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 发送类型 0 手机号注册 1 重置密码
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional uint32 type = 2;</code>
   */
  boolean hasType();
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 发送类型 0 手机号注册 1 重置密码
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional uint32 type = 2;</code>
   */
  int getType();
}
