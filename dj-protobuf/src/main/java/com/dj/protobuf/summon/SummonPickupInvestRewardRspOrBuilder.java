// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Summon.proto

package com.dj.protobuf.summon;

public interface SummonPickupInvestRewardRspOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Protocols.SummonPickupInvestRewardRsp)
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
   * <code>optional .Protocols.SummonPickupInvestRewardReq req = 2;</code>
   */
  boolean hasReq();
  /**
   * <code>optional .Protocols.SummonPickupInvestRewardReq req = 2;</code>
   */
  com.dj.protobuf.summon.SummonPickupInvestRewardReq getReq();
  /**
   * <code>optional .Protocols.SummonPickupInvestRewardReq req = 2;</code>
   */
  com.dj.protobuf.summon.SummonPickupInvestRewardReqOrBuilder getReqOrBuilder();

  /**
   * <pre>
   * 奖励
   * </pre>
   *
   * <code>map&lt;int32, int32&gt; reward = 3;</code>
   */
  int getRewardCount();
  /**
   * <pre>
   * 奖励
   * </pre>
   *
   * <code>map&lt;int32, int32&gt; reward = 3;</code>
   */
  boolean containsReward(
      int key);
  /**
   * Use {@link #getRewardMap()} instead.
   */
  @java.lang.Deprecated
  java.util.Map<java.lang.Integer, java.lang.Integer>
  getReward();
  /**
   * <pre>
   * 奖励
   * </pre>
   *
   * <code>map&lt;int32, int32&gt; reward = 3;</code>
   */
  java.util.Map<java.lang.Integer, java.lang.Integer>
  getRewardMap();
  /**
   * <pre>
   * 奖励
   * </pre>
   *
   * <code>map&lt;int32, int32&gt; reward = 3;</code>
   */

  int getRewardOrDefault(
      int key,
      int defaultValue);
  /**
   * <pre>
   * 奖励
   * </pre>
   *
   * <code>map&lt;int32, int32&gt; reward = 3;</code>
   */

  int getRewardOrThrow(
      int key);

  /**
   * <pre>
   * 邮件索引
   * </pre>
   *
   * <code>optional int32 index = 4;</code>
   */
  boolean hasIndex();
  /**
   * <pre>
   * 邮件索引
   * </pre>
   *
   * <code>optional int32 index = 4;</code>
   */
  int getIndex();
}
