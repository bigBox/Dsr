// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Buffer.proto

package com.dj.protobuf.buffer;

public interface MonthCardNtfOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Protocols.MonthCardNtf)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>optional int32 leftSeconds = 1;</code>
   */
  boolean hasLeftSeconds();
  /**
   * <code>optional int32 leftSeconds = 1;</code>
   */
  int getLeftSeconds();

  /**
   * <pre>
   * 登陆奖励
   * </pre>
   *
   * <code>optional bool isDrawedToday = 2;</code>
   */
  boolean hasIsDrawedToday();
  /**
   * <pre>
   * 登陆奖励
   * </pre>
   *
   * <code>optional bool isDrawedToday = 2;</code>
   */
  boolean getIsDrawedToday();

  /**
   * <pre>
   * 月卡额外奖励
   * </pre>
   *
   * <code>optional bool isMonthCardDrawedToday = 3;</code>
   */
  boolean hasIsMonthCardDrawedToday();
  /**
   * <pre>
   * 月卡额外奖励
   * </pre>
   *
   * <code>optional bool isMonthCardDrawedToday = 3;</code>
   */
  boolean getIsMonthCardDrawedToday();
}
