// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: GuildBattle.proto

package com.dj.protobuf.guildBattle;

public interface CaptureBattleBuildNtfOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Protocols.CaptureBattleBuildNtf)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * 建筑id
   * </pre>
   *
   * <code>optional int32 buildID = 1;</code>
   */
  boolean hasBuildID();
  /**
   * <pre>
   * 建筑id
   * </pre>
   *
   * <code>optional int32 buildID = 1;</code>
   */
  int getBuildID();

  /**
   * <pre>
   * 攻占人信息
   * </pre>
   *
   * <code>optional .Protocols.BaseRoleInfo captureRoleInfo = 2;</code>
   */
  boolean hasCaptureRoleInfo();
  /**
   * <pre>
   * 攻占人信息
   * </pre>
   *
   * <code>optional .Protocols.BaseRoleInfo captureRoleInfo = 2;</code>
   */
  com.dj.protobuf.common.BaseRoleInfo getCaptureRoleInfo();
  /**
   * <pre>
   * 攻占人信息
   * </pre>
   *
   * <code>optional .Protocols.BaseRoleInfo captureRoleInfo = 2;</code>
   */
  com.dj.protobuf.common.BaseRoleInfoOrBuilder getCaptureRoleInfoOrBuilder();
}