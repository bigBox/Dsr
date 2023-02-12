// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: GuildBattle.proto

package com.dj.protobuf.guildBattle;

public interface BattleBuildListRspOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Protocols.BattleBuildListRsp)
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
   * 建筑列表
   * </pre>
   *
   * <code>repeated .Protocols.GuildBattleBuildInfo builds = 2;</code>
   */
  java.util.List<com.dj.protobuf.guildBattle.GuildBattleBuildInfo> 
      getBuildsList();
  /**
   * <pre>
   * 建筑列表
   * </pre>
   *
   * <code>repeated .Protocols.GuildBattleBuildInfo builds = 2;</code>
   */
  com.dj.protobuf.guildBattle.GuildBattleBuildInfo getBuilds(int index);
  /**
   * <pre>
   * 建筑列表
   * </pre>
   *
   * <code>repeated .Protocols.GuildBattleBuildInfo builds = 2;</code>
   */
  int getBuildsCount();
  /**
   * <pre>
   * 建筑列表
   * </pre>
   *
   * <code>repeated .Protocols.GuildBattleBuildInfo builds = 2;</code>
   */
  java.util.List<? extends com.dj.protobuf.guildBattle.GuildBattleBuildInfoOrBuilder> 
      getBuildsOrBuilderList();
  /**
   * <pre>
   * 建筑列表
   * </pre>
   *
   * <code>repeated .Protocols.GuildBattleBuildInfo builds = 2;</code>
   */
  com.dj.protobuf.guildBattle.GuildBattleBuildInfoOrBuilder getBuildsOrBuilder(
      int index);

  /**
   * <pre>
   * 房间时间（秒数）
   * </pre>
   *
   * <code>optional int32 roomTime = 3;</code>
   */
  boolean hasRoomTime();
  /**
   * <pre>
   * 房间时间（秒数）
   * </pre>
   *
   * <code>optional int32 roomTime = 3;</code>
   */
  int getRoomTime();
}
