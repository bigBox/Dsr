// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: CommonDefine.proto

package com.dj.protobuf.common;

public interface RoleInfoOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Protocols.RoleInfo)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>optional uint64 roleId = 1;</code>
   */
  boolean hasRoleId();
  /**
   * <code>optional uint64 roleId = 1;</code>
   */
  long getRoleId();

  /**
   * <code>optional string roleName = 2;</code>
   */
  boolean hasRoleName();
  /**
   * <code>optional string roleName = 2;</code>
   */
  java.lang.String getRoleName();
  /**
   * <code>optional string roleName = 2;</code>
   */
  com.google.protobuf.ByteString
      getRoleNameBytes();

  /**
   * <pre>
   * 等级
   * </pre>
   *
   * <code>optional int32 level = 3;</code>
   */
  boolean hasLevel();
  /**
   * <pre>
   * 等级
   * </pre>
   *
   * <code>optional int32 level = 3;</code>
   */
  int getLevel();

  /**
   * <pre>
   * 金币
   * </pre>
   *
   * <code>optional int32 gold = 4;</code>
   */
  boolean hasGold();
  /**
   * <pre>
   * 金币
   * </pre>
   *
   * <code>optional int32 gold = 4;</code>
   */
  int getGold();

  /**
   * <pre>
   * 钻石
   * </pre>
   *
   * <code>optional int32 diamond = 5;</code>
   */
  boolean hasDiamond();
  /**
   * <pre>
   * 钻石
   * </pre>
   *
   * <code>optional int32 diamond = 5;</code>
   */
  int getDiamond();

  /**
   * <pre>
   * 生态值
   * </pre>
   *
   * <code>optional int32 ecology = 6;</code>
   */
  boolean hasEcology();
  /**
   * <pre>
   * 生态值
   * </pre>
   *
   * <code>optional int32 ecology = 6;</code>
   */
  int getEcology();

  /**
   * <pre>
   * 玩家所在公会ID，0表示没有公会
   * </pre>
   *
   * <code>optional uint64 guildId = 7;</code>
   */
  boolean hasGuildId();
  /**
   * <pre>
   * 玩家所在公会ID，0表示没有公会
   * </pre>
   *
   * <code>optional uint64 guildId = 7;</code>
   */
  long getGuildId();

  /**
   * <pre>
   * 个人签名
   * </pre>
   *
   * <code>optional string signature = 8;</code>
   */
  boolean hasSignature();
  /**
   * <pre>
   * 个人签名
   * </pre>
   *
   * <code>optional string signature = 8;</code>
   */
  java.lang.String getSignature();
  /**
   * <pre>
   * 个人签名
   * </pre>
   *
   * <code>optional string signature = 8;</code>
   */
  com.google.protobuf.ByteString
      getSignatureBytes();

  /**
   * <pre>
   * 经验
   * </pre>
   *
   * <code>optional int32 experience = 9;</code>
   */
  boolean hasExperience();
  /**
   * <pre>
   * 经验
   * </pre>
   *
   * <code>optional int32 experience = 9;</code>
   */
  int getExperience();
}
