// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: GuildBattle.proto

package com.dj.protobuf.guildBattle;

public interface BattleMeetDropReqOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Protocols.BattleMeetDropReq)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   *掉落唯一id
   * </pre>
   *
   * <code>optional string timeID = 1;</code>
   */
  boolean hasTimeID();
  /**
   * <pre>
   *掉落唯一id
   * </pre>
   *
   * <code>optional string timeID = 1;</code>
   */
  java.lang.String getTimeID();
  /**
   * <pre>
   *掉落唯一id
   * </pre>
   *
   * <code>optional string timeID = 1;</code>
   */
  com.google.protobuf.ByteString
      getTimeIDBytes();

  /**
   * <pre>
   *当前x坐标
   * </pre>
   *
   * <code>optional int32 meetX = 2;</code>
   */
  boolean hasMeetX();
  /**
   * <pre>
   *当前x坐标
   * </pre>
   *
   * <code>optional int32 meetX = 2;</code>
   */
  int getMeetX();

  /**
   * <pre>
   *当前y坐标
   * </pre>
   *
   * <code>optional int32 meetY = 3;</code>
   */
  boolean hasMeetY();
  /**
   * <pre>
   *当前y坐标
   * </pre>
   *
   * <code>optional int32 meetY = 3;</code>
   */
  int getMeetY();
}