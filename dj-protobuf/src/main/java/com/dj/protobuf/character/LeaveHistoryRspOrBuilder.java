// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Character.proto

package com.dj.protobuf.character;

public interface LeaveHistoryRspOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Protocols.LeaveHistoryRsp)
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
   * <code>optional .Protocols.LeaveHistoryReq req = 2;</code>
   */
  boolean hasReq();
  /**
   * <code>optional .Protocols.LeaveHistoryReq req = 2;</code>
   */
  com.dj.protobuf.character.LeaveHistoryReq getReq();
  /**
   * <code>optional .Protocols.LeaveHistoryReq req = 2;</code>
   */
  com.dj.protobuf.character.LeaveHistoryReqOrBuilder getReqOrBuilder();

  /**
   * <pre>
   * 历史记录
   * </pre>
   *
   * <code>repeated .Protocols.LeaveHistory histories = 3;</code>
   */
  java.util.List<com.dj.protobuf.character.LeaveHistory> 
      getHistoriesList();
  /**
   * <pre>
   * 历史记录
   * </pre>
   *
   * <code>repeated .Protocols.LeaveHistory histories = 3;</code>
   */
  com.dj.protobuf.character.LeaveHistory getHistories(int index);
  /**
   * <pre>
   * 历史记录
   * </pre>
   *
   * <code>repeated .Protocols.LeaveHistory histories = 3;</code>
   */
  int getHistoriesCount();
  /**
   * <pre>
   * 历史记录
   * </pre>
   *
   * <code>repeated .Protocols.LeaveHistory histories = 3;</code>
   */
  java.util.List<? extends com.dj.protobuf.character.LeaveHistoryOrBuilder> 
      getHistoriesOrBuilderList();
  /**
   * <pre>
   * 历史记录
   * </pre>
   *
   * <code>repeated .Protocols.LeaveHistory histories = 3;</code>
   */
  com.dj.protobuf.character.LeaveHistoryOrBuilder getHistoriesOrBuilder(
      int index);
}
