// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Login.proto

package com.dj.protobuf.login;

public interface UserLoginRspOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Protocols.UserLoginRsp)
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
   * <pre>
   *&#47; &lt;summary&gt;
   * / 登录类型 0自有平台账号/手机号登录 1-QQ登录 2-微信登录
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional uint32 platformType = 2;</code>
   */
  boolean hasPlatformType();
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 登录类型 0自有平台账号/手机号登录 1-QQ登录 2-微信登录
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional uint32 platformType = 2;</code>
   */
  int getPlatformType();

  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 自有平台账号/手机号(微信、QQ登录时为OpenId)
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional string account = 3;</code>
   */
  boolean hasAccount();
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 自有平台账号/手机号(微信、QQ登录时为OpenId)
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional string account = 3;</code>
   */
  java.lang.String getAccount();
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 自有平台账号/手机号(微信、QQ登录时为OpenId)
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional string account = 3;</code>
   */
  com.google.protobuf.ByteString
      getAccountBytes();

  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 第一个角色id，0表示无角色
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional uint64 roleID = 4;</code>
   */
  boolean hasRoleID();
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 第一个角色id，0表示无角色
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional uint64 roleID = 4;</code>
   */
  long getRoleID();

  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 角色名称
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional string roleName = 5;</code>
   */
  boolean hasRoleName();
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 角色名称
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional string roleName = 5;</code>
   */
  java.lang.String getRoleName();
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 角色名称
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional string roleName = 5;</code>
   */
  com.google.protobuf.ByteString
      getRoleNameBytes();

  /**
   * <code>map&lt;string, bytes&gt; actorData = 6;</code>
   */
  int getActorDataCount();
  /**
   * <code>map&lt;string, bytes&gt; actorData = 6;</code>
   */
  boolean containsActorData(
      java.lang.String key);
  /**
   * Use {@link #getActorDataMap()} instead.
   */
  @java.lang.Deprecated
  java.util.Map<java.lang.String, com.google.protobuf.ByteString>
  getActorData();
  /**
   * <code>map&lt;string, bytes&gt; actorData = 6;</code>
   */
  java.util.Map<java.lang.String, com.google.protobuf.ByteString>
  getActorDataMap();
  /**
   * <code>map&lt;string, bytes&gt; actorData = 6;</code>
   */

  com.google.protobuf.ByteString getActorDataOrDefault(
      java.lang.String key,
      com.google.protobuf.ByteString defaultValue);
  /**
   * <code>map&lt;string, bytes&gt; actorData = 6;</code>
   */

  com.google.protobuf.ByteString getActorDataOrThrow(
      java.lang.String key);

  /**
   * <code>optional int32 gmlevel = 7;</code>
   */
  boolean hasGmlevel();
  /**
   * <code>optional int32 gmlevel = 7;</code>
   */
  int getGmlevel();

  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 账号创建时间
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional .Protocols.DateTime CreateRoleTime = 8;</code>
   */
  boolean hasCreateRoleTime();
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 账号创建时间
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional .Protocols.DateTime CreateRoleTime = 8;</code>
   */
  com.dj.protobuf.datetime.DateTime getCreateRoleTime();
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 账号创建时间
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional .Protocols.DateTime CreateRoleTime = 8;</code>
   */
  com.dj.protobuf.datetime.DateTimeOrBuilder getCreateRoleTimeOrBuilder();

  /**
   * <code>optional int32 zoneId = 9;</code>
   */
  boolean hasZoneId();
  /**
   * <code>optional int32 zoneId = 9;</code>
   */
  int getZoneId();

  /**
   * <code>optional .Protocols.UserLoginReq req = 10;</code>
   */
  boolean hasReq();
  /**
   * <code>optional .Protocols.UserLoginReq req = 10;</code>
   */
  com.dj.protobuf.login.UserLoginReq getReq();
  /**
   * <code>optional .Protocols.UserLoginReq req = 10;</code>
   */
  com.dj.protobuf.login.UserLoginReqOrBuilder getReqOrBuilder();

  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 个人签名
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional string signature = 11;</code>
   */
  boolean hasSignature();
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 个人签名
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional string signature = 11;</code>
   */
  java.lang.String getSignature();
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 个人签名
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional string signature = 11;</code>
   */
  com.google.protobuf.ByteString
      getSignatureBytes();

  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 是否第一次登陆
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional bool firstLogin = 12;</code>
   */
  boolean hasFirstLogin();
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 是否第一次登陆
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional bool firstLogin = 12;</code>
   */
  boolean getFirstLogin();

  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 成长任务ID
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional int32 growUpTaskID = 13;</code>
   */
  boolean hasGrowUpTaskID();
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 成长任务ID
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional int32 growUpTaskID = 13;</code>
   */
  int getGrowUpTaskID();

  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 年龄
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional int32 age = 14;</code>
   */
  boolean hasAge();
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 年龄
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional int32 age = 14;</code>
   */
  int getAge();

  /**
   * <pre>
   *&#47; &lt;/summary&gt;
   * / 金木水火土其中一种五行属性
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional .Protocols.ERoleFiveEle fiveEle = 15;</code>
   */
  boolean hasFiveEle();
  /**
   * <pre>
   *&#47; &lt;/summary&gt;
   * / 金木水火土其中一种五行属性
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional .Protocols.ERoleFiveEle fiveEle = 15;</code>
   */
  com.dj.protobuf.common.ERoleFiveEle getFiveEle();

  /**
   * <pre>
   *&#47; &lt;/summary&gt;
   * / 新手引导ID
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional int32 guideID = 16;</code>
   */
  boolean hasGuideID();
  /**
   * <pre>
   *&#47; &lt;/summary&gt;
   * / 新手引导ID
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional int32 guideID = 16;</code>
   */
  int getGuideID();

  /**
   * <pre>
   *&#47; &lt;/summary&gt;
   * / 新手引导状态
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional int32 guideState = 17;</code>
   */
  boolean hasGuideState();
  /**
   * <pre>
   *&#47; &lt;/summary&gt;
   * / 新手引导状态
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional int32 guideState = 17;</code>
   */
  int getGuideState();

  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 是否要做实名认证 fasle 不需要 true 需要
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional bool isNeedCert = 18;</code>
   */
  boolean hasIsNeedCert();
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 是否要做实名认证 fasle 不需要 true 需要
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional bool isNeedCert = 18;</code>
   */
  boolean getIsNeedCert();

  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 是否要升级客户端 不需要 true 需要
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional bool isNeedUpdate = 19;</code>
   */
  boolean hasIsNeedUpdate();
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 是否要升级客户端 不需要 true 需要
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional bool isNeedUpdate = 19;</code>
   */
  boolean getIsNeedUpdate();

  /**
   * <pre>
   *&#47; &lt;/summary&gt;
   * /俱乐部 ID
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional int64 guildID = 20;</code>
   */
  boolean hasGuildID();
  /**
   * <pre>
   *&#47; &lt;/summary&gt;
   * /俱乐部 ID
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional int64 guildID = 20;</code>
   */
  long getGuildID();
}
