// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Login.proto

package com.dj.protobuf.login;

public interface ResetPasswordReqOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Protocols.ResetPasswordReq)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 账号
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional string account = 1;</code>
   */
  boolean hasAccount();
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 账号
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional string account = 1;</code>
   */
  java.lang.String getAccount();
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 账号
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional string account = 1;</code>
   */
  com.google.protobuf.ByteString
      getAccountBytes();

  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 重设的密码
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional string password = 2;</code>
   */
  boolean hasPassword();
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 重设的密码
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional string password = 2;</code>
   */
  java.lang.String getPassword();
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 重设的密码
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional string password = 2;</code>
   */
  com.google.protobuf.ByteString
      getPasswordBytes();
}
