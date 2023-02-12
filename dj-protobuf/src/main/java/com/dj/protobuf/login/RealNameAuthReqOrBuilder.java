// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Login.proto

package com.dj.protobuf.login;

public interface RealNameAuthReqOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Protocols.RealNameAuthReq)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 登录类型 0自有平台账号/手机号登录 1-QQ登录 2-微信登录
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional uint32 platformType = 1;</code>
   */
  boolean hasPlatformType();
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 登录类型 0自有平台账号/手机号登录 1-QQ登录 2-微信登录
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional uint32 platformType = 1;</code>
   */
  int getPlatformType();

  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 自有平台账号(微信登录时为OpenId)
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional string account = 2;</code>
   */
  boolean hasAccount();
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 自有平台账号(微信登录时为OpenId)
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional string account = 2;</code>
   */
  java.lang.String getAccount();
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 自有平台账号(微信登录时为OpenId)
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional string account = 2;</code>
   */
  com.google.protobuf.ByteString
      getAccountBytes();

  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 自有平台密码(微信、QQ登陆时为Openkey access_token)
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional string password = 3;</code>
   */
  boolean hasPassword();
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 自有平台密码(微信、QQ登陆时为Openkey access_token)
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional string password = 3;</code>
   */
  java.lang.String getPassword();
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 自有平台密码(微信、QQ登陆时为Openkey access_token)
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional string password = 3;</code>
   */
  com.google.protobuf.ByteString
      getPasswordBytes();

  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 姓名
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional string name = 4;</code>
   */
  boolean hasName();
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 姓名
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional string name = 4;</code>
   */
  java.lang.String getName();
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 姓名
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional string name = 4;</code>
   */
  com.google.protobuf.ByteString
      getNameBytes();

  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 身份证
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional string idCard = 5;</code>
   */
  boolean hasIdCard();
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 身份证
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional string idCard = 5;</code>
   */
  java.lang.String getIdCard();
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 身份证
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional string idCard = 5;</code>
   */
  com.google.protobuf.ByteString
      getIdCardBytes();
}
