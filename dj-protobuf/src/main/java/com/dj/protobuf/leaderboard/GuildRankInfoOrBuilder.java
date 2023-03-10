// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Leaderboard.proto

package com.dj.protobuf.leaderboard;

public interface GuildRankInfoOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Protocols.GuildRankInfo)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>optional .Protocols.RankBaseInfo rankBase = 1;</code>
   */
  boolean hasRankBase();
  /**
   * <code>optional .Protocols.RankBaseInfo rankBase = 1;</code>
   */
  com.dj.protobuf.leaderboard.RankBaseInfo getRankBase();
  /**
   * <code>optional .Protocols.RankBaseInfo rankBase = 1;</code>
   */
  com.dj.protobuf.leaderboard.RankBaseInfoOrBuilder getRankBaseOrBuilder();

  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 商会名
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional string name = 2;</code>
   */
  boolean hasName();
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 商会名
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional string name = 2;</code>
   */
  java.lang.String getName();
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 商会名
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional string name = 2;</code>
   */
  com.google.protobuf.ByteString
      getNameBytes();

  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 商会等级
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional int32 level = 3;</code>
   */
  boolean hasLevel();
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 商会等级
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional int32 level = 3;</code>
   */
  int getLevel();

  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 商会积分
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional int32 honor = 4;</code>
   */
  boolean hasHonor();
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 商会积分
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional int32 honor = 4;</code>
   */
  int getHonor();

  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 商会成员数
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional int32 members = 5;</code>
   */
  boolean hasMembers();
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 商会成员数
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional int32 members = 5;</code>
   */
  int getMembers();
}
