// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: GuildBattle.proto

package com.dj.protobuf.guildBattle;

public interface BattleChangeMeetXReqOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Protocols.BattleChangeMeetXReq)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 玩家x坐标
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional int32 positionX = 1;</code>
   */
  boolean hasPositionX();
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 玩家x坐标
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional int32 positionX = 1;</code>
   */
  int getPositionX();

  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 方向， 2向右，1向左，0原地不动
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional int32 directionX = 2;</code>
   */
  boolean hasDirectionX();
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 方向， 2向右，1向左，0原地不动
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional int32 directionX = 2;</code>
   */
  int getDirectionX();
}
