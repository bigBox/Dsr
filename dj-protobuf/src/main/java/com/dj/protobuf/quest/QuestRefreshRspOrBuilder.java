// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Quest.proto

package com.dj.protobuf.quest;

public interface QuestRefreshRspOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Protocols.QuestRefreshRsp)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>optional .ErrorID error = 1;</code>
   */
  boolean hasError();
  /**
   * <code>optional .ErrorID error = 1;</code>
   */
  com.dj.protobuf.ErrorIDOuterClass.ErrorID getError();

  /**
   * <code>optional .Protocols.QuestRefreshReq req = 2;</code>
   */
  boolean hasReq();
  /**
   * <code>optional .Protocols.QuestRefreshReq req = 2;</code>
   */
  com.dj.protobuf.quest.QuestRefreshReq getReq();
  /**
   * <code>optional .Protocols.QuestRefreshReq req = 2;</code>
   */
  com.dj.protobuf.quest.QuestRefreshReqOrBuilder getReqOrBuilder();

  /**
   * <code>optional int32 newId = 3;</code>
   */
  boolean hasNewId();
  /**
   * <code>optional int32 newId = 3;</code>
   */
  int getNewId();
}