// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Guild.proto

package com.dj.protobuf.guild;

public interface GuildSearchRspOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Protocols.GuildSearchRsp)
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
   * <code>repeated .Protocols.GuildBaseInfo guilds = 2;</code>
   */
  java.util.List<com.dj.protobuf.guild.GuildBaseInfo> 
      getGuildsList();
  /**
   * <code>repeated .Protocols.GuildBaseInfo guilds = 2;</code>
   */
  com.dj.protobuf.guild.GuildBaseInfo getGuilds(int index);
  /**
   * <code>repeated .Protocols.GuildBaseInfo guilds = 2;</code>
   */
  int getGuildsCount();
  /**
   * <code>repeated .Protocols.GuildBaseInfo guilds = 2;</code>
   */
  java.util.List<? extends com.dj.protobuf.guild.GuildBaseInfoOrBuilder> 
      getGuildsOrBuilderList();
  /**
   * <code>repeated .Protocols.GuildBaseInfo guilds = 2;</code>
   */
  com.dj.protobuf.guild.GuildBaseInfoOrBuilder getGuildsOrBuilder(
      int index);
}