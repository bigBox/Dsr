// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Guild.proto

package com.dj.protobuf.guild;

public interface GuildAdjustPostRspOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Protocols.GuildAdjustPostRsp)
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
   * / 调整后的成员信息
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional .Protocols.GuildMemberInfo memberInfo = 2;</code>
   */
  boolean hasMemberInfo();
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 调整后的成员信息
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional .Protocols.GuildMemberInfo memberInfo = 2;</code>
   */
  com.dj.protobuf.guild.GuildMemberInfo getMemberInfo();
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 调整后的成员信息
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional .Protocols.GuildMemberInfo memberInfo = 2;</code>
   */
  com.dj.protobuf.guild.GuildMemberInfoOrBuilder getMemberInfoOrBuilder();
}