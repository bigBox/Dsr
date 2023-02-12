// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Guild.proto

package com.dj.protobuf.guild;

public interface GuildApproveRspOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Protocols.GuildApproveRsp)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 批准响应
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional .ErrorID errorID = 1;</code>
   */
  boolean hasErrorID();
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 批准响应
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional .ErrorID errorID = 1;</code>
   */
  com.dj.protobuf.ErrorIDOuterClass.ErrorID getErrorID();

  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 请求消息原路返回
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional .Protocols.GuildApproveReq req = 2;</code>
   */
  boolean hasReq();
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 请求消息原路返回
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional .Protocols.GuildApproveReq req = 2;</code>
   */
  com.dj.protobuf.guild.GuildApproveReq getReq();
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 请求消息原路返回
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional .Protocols.GuildApproveReq req = 2;</code>
   */
  com.dj.protobuf.guild.GuildApproveReqOrBuilder getReqOrBuilder();

  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 刷新后的普通成员列表
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional .Protocols.GuildMemberInfo memberInfo = 3;</code>
   */
  boolean hasMemberInfo();
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 刷新后的普通成员列表
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional .Protocols.GuildMemberInfo memberInfo = 3;</code>
   */
  com.dj.protobuf.guild.GuildMemberInfo getMemberInfo();
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 刷新后的普通成员列表
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional .Protocols.GuildMemberInfo memberInfo = 3;</code>
   */
  com.dj.protobuf.guild.GuildMemberInfoOrBuilder getMemberInfoOrBuilder();

  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 是否在线
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional bool online = 4;</code>
   */
  boolean hasOnline();
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 是否在线
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional bool online = 4;</code>
   */
  boolean getOnline();
}
