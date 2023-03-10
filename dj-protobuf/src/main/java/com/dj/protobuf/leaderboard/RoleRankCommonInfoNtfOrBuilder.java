// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Leaderboard.proto

package com.dj.protobuf.leaderboard;

public interface RoleRankCommonInfoNtfOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Protocols.RoleRankCommonInfoNtf)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>optional .Protocols.RankType type = 1;</code>
   */
  boolean hasType();
  /**
   * <code>optional .Protocols.RankType type = 1;</code>
   */
  com.dj.protobuf.leaderboard.RankType getType();

  /**
   * <code>repeated .Protocols.RoleRankCommonInfo topN = 2;</code>
   */
  java.util.List<com.dj.protobuf.leaderboard.RoleRankCommonInfo> 
      getTopNList();
  /**
   * <code>repeated .Protocols.RoleRankCommonInfo topN = 2;</code>
   */
  com.dj.protobuf.leaderboard.RoleRankCommonInfo getTopN(int index);
  /**
   * <code>repeated .Protocols.RoleRankCommonInfo topN = 2;</code>
   */
  int getTopNCount();
  /**
   * <code>repeated .Protocols.RoleRankCommonInfo topN = 2;</code>
   */
  java.util.List<? extends com.dj.protobuf.leaderboard.RoleRankCommonInfoOrBuilder> 
      getTopNOrBuilderList();
  /**
   * <code>repeated .Protocols.RoleRankCommonInfo topN = 2;</code>
   */
  com.dj.protobuf.leaderboard.RoleRankCommonInfoOrBuilder getTopNOrBuilder(
      int index);

  /**
   * <code>optional .Protocols.RoleRankCommonInfo selfInfo = 3;</code>
   */
  boolean hasSelfInfo();
  /**
   * <code>optional .Protocols.RoleRankCommonInfo selfInfo = 3;</code>
   */
  com.dj.protobuf.leaderboard.RoleRankCommonInfo getSelfInfo();
  /**
   * <code>optional .Protocols.RoleRankCommonInfo selfInfo = 3;</code>
   */
  com.dj.protobuf.leaderboard.RoleRankCommonInfoOrBuilder getSelfInfoOrBuilder();

  /**
   * <code>optional int32 selfRank = 4;</code>
   */
  boolean hasSelfRank();
  /**
   * <code>optional int32 selfRank = 4;</code>
   */
  int getSelfRank();
}
