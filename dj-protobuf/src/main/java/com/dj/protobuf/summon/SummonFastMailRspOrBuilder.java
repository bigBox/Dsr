// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Summon.proto

package com.dj.protobuf.summon;

public interface SummonFastMailRspOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Protocols.SummonFastMailRsp)
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
   * <code>repeated .Protocols.SummonMailInfo mailList = 2;</code>
   */
  java.util.List<com.dj.protobuf.summon.SummonMailInfo> 
      getMailListList();
  /**
   * <code>repeated .Protocols.SummonMailInfo mailList = 2;</code>
   */
  com.dj.protobuf.summon.SummonMailInfo getMailList(int index);
  /**
   * <code>repeated .Protocols.SummonMailInfo mailList = 2;</code>
   */
  int getMailListCount();
  /**
   * <code>repeated .Protocols.SummonMailInfo mailList = 2;</code>
   */
  java.util.List<? extends com.dj.protobuf.summon.SummonMailInfoOrBuilder> 
      getMailListOrBuilderList();
  /**
   * <code>repeated .Protocols.SummonMailInfo mailList = 2;</code>
   */
  com.dj.protobuf.summon.SummonMailInfoOrBuilder getMailListOrBuilder(
      int index);
}