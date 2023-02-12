// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Summon.proto

package com.dj.protobuf.summon;

public interface SummonInfoRspOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Protocols.SummonInfoRsp)
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
   * 精灵列表
   * </pre>
   *
   * <code>repeated .Protocols.SummonInfo summons = 2;</code>
   */
  java.util.List<com.dj.protobuf.summon.SummonInfo> 
      getSummonsList();
  /**
   * <pre>
   * 精灵列表
   * </pre>
   *
   * <code>repeated .Protocols.SummonInfo summons = 2;</code>
   */
  com.dj.protobuf.summon.SummonInfo getSummons(int index);
  /**
   * <pre>
   * 精灵列表
   * </pre>
   *
   * <code>repeated .Protocols.SummonInfo summons = 2;</code>
   */
  int getSummonsCount();
  /**
   * <pre>
   * 精灵列表
   * </pre>
   *
   * <code>repeated .Protocols.SummonInfo summons = 2;</code>
   */
  java.util.List<? extends com.dj.protobuf.summon.SummonInfoOrBuilder> 
      getSummonsOrBuilderList();
  /**
   * <pre>
   * 精灵列表
   * </pre>
   *
   * <code>repeated .Protocols.SummonInfo summons = 2;</code>
   */
  com.dj.protobuf.summon.SummonInfoOrBuilder getSummonsOrBuilder(
      int index);

  /**
   * <pre>
   *当前被派出的精灵ID
   * </pre>
   *
   * <code>optional int32 curSummonID = 3;</code>
   */
  boolean hasCurSummonID();
  /**
   * <pre>
   *当前被派出的精灵ID
   * </pre>
   *
   * <code>optional int32 curSummonID = 3;</code>
   */
  int getCurSummonID();

  /**
   * <pre>
   *当前被派出的精灵的属性 1金 2木 3水 4火 5土
   * </pre>
   *
   * <code>optional int32 curElement = 4;</code>
   */
  boolean hasCurElement();
  /**
   * <pre>
   *当前被派出的精灵的属性 1金 2木 3水 4火 5土
   * </pre>
   *
   * <code>optional int32 curElement = 4;</code>
   */
  int getCurElement();

  /**
   * <pre>
   *当前默认的精灵ID
   * </pre>
   *
   * <code>optional int32 defSummonID = 5;</code>
   */
  boolean hasDefSummonID();
  /**
   * <pre>
   *当前默认的精灵ID
   * </pre>
   *
   * <code>optional int32 defSummonID = 5;</code>
   */
  int getDefSummonID();

  /**
   * <pre>
   *当前精灵的召唤等级
   * </pre>
   *
   * <code>optional int32 curLevel = 6;</code>
   */
  boolean hasCurLevel();
  /**
   * <pre>
   *当前精灵的召唤等级
   * </pre>
   *
   * <code>optional int32 curLevel = 6;</code>
   */
  int getCurLevel();
}
