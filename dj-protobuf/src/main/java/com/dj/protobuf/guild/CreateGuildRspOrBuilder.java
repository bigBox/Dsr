// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Guild.proto

package com.dj.protobuf.guild;

public interface CreateGuildRspOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Protocols.CreateGuildRsp)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 错误码
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional .ErrorID errorID = 1;</code>
   */
  boolean hasErrorID();
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 错误码
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional .ErrorID errorID = 1;</code>
   */
  com.dj.protobuf.ErrorIDOuterClass.ErrorID getErrorID();

  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 公会基本信息
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional .Protocols.GuildBaseInfo guildBaseInfo = 2;</code>
   */
  boolean hasGuildBaseInfo();
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 公会基本信息
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional .Protocols.GuildBaseInfo guildBaseInfo = 2;</code>
   */
  com.dj.protobuf.guild.GuildBaseInfo getGuildBaseInfo();
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 公会基本信息
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional .Protocols.GuildBaseInfo guildBaseInfo = 2;</code>
   */
  com.dj.protobuf.guild.GuildBaseInfoOrBuilder getGuildBaseInfoOrBuilder();
}
