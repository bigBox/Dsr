// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: City.proto

package com.dj.protobuf.city;

public interface NpcRaceHorsesRspOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Protocols.NpcRaceHorsesRsp)
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
   * <code>optional .Protocols.NpcRaceHorsesReq req = 2;</code>
   */
  boolean hasReq();
  /**
   * <code>optional .Protocols.NpcRaceHorsesReq req = 2;</code>
   */
  com.dj.protobuf.city.NpcRaceHorsesReq getReq();
  /**
   * <code>optional .Protocols.NpcRaceHorsesReq req = 2;</code>
   */
  com.dj.protobuf.city.NpcRaceHorsesReqOrBuilder getReqOrBuilder();

  /**
   * <pre>
   * 输赢
   * </pre>
   *
   * <code>optional int32 winOrLose = 3;</code>
   */
  boolean hasWinOrLose();
  /**
   * <pre>
   * 输赢
   * </pre>
   *
   * <code>optional int32 winOrLose = 3;</code>
   */
  int getWinOrLose();

  /**
   * <code>optional int32 itemId = 4;</code>
   */
  boolean hasItemId();
  /**
   * <code>optional int32 itemId = 4;</code>
   */
  int getItemId();

  /**
   * <code>optional int32 itemCount = 5;</code>
   */
  boolean hasItemCount();
  /**
   * <code>optional int32 itemCount = 5;</code>
   */
  int getItemCount();
}
