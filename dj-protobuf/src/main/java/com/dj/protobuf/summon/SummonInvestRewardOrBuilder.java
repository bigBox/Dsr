// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Summon.proto

package com.dj.protobuf.summon;

public interface SummonInvestRewardOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Protocols.SummonInvestReward)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * 邮件索引
   * </pre>
   *
   * <code>optional int32 mailIndex = 1;</code>
   */
  boolean hasMailIndex();
  /**
   * <pre>
   * 邮件索引
   * </pre>
   *
   * <code>optional int32 mailIndex = 1;</code>
   */
  int getMailIndex();

  /**
   * <pre>
   * 自己可领奖励时间倒计时（秒）
   * </pre>
   *
   * <code>optional int32 rewardTime = 2;</code>
   */
  boolean hasRewardTime();
  /**
   * <pre>
   * 自己可领奖励时间倒计时（秒）
   * </pre>
   *
   * <code>optional int32 rewardTime = 2;</code>
   */
  int getRewardTime();

  /**
   * <pre>
   * 邮件位于户外地图上x坐标
   * </pre>
   *
   * <code>optional int32 positionX = 3;</code>
   */
  boolean hasPositionX();
  /**
   * <pre>
   * 邮件位于户外地图上x坐标
   * </pre>
   *
   * <code>optional int32 positionX = 3;</code>
   */
  int getPositionX();

  /**
   * <pre>
   * 邮件位于户外地图上y坐标
   * </pre>
   *
   * <code>optional int32 positionY = 4;</code>
   */
  boolean hasPositionY();
  /**
   * <pre>
   * 邮件位于户外地图上y坐标
   * </pre>
   *
   * <code>optional int32 positionY = 4;</code>
   */
  int getPositionY();

  /**
   * <pre>
   * 请求者是否捡漏过, true已捡漏过，不能再捡了
   * </pre>
   *
   * <code>optional bool rewadFlag = 5;</code>
   */
  boolean hasRewadFlag();
  /**
   * <pre>
   * 请求者是否捡漏过, true已捡漏过，不能再捡了
   * </pre>
   *
   * <code>optional bool rewadFlag = 5;</code>
   */
  boolean getRewadFlag();
}
