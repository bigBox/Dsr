// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Character.proto

package com.dj.protobuf.character;

public interface LeaveHistoryOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Protocols.LeaveHistory)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * 互动人
   * </pre>
   *
   * <code>optional int32 leaveID = 1;</code>
   */
  boolean hasLeaveID();
  /**
   * <pre>
   * 互动人
   * </pre>
   *
   * <code>optional int32 leaveID = 1;</code>
   */
  int getLeaveID();

  /**
   * <pre>
   * 互动时间
   * </pre>
   *
   * <code>optional .Protocols.DateTime leaveTime = 2;</code>
   */
  boolean hasLeaveTime();
  /**
   * <pre>
   * 互动时间
   * </pre>
   *
   * <code>optional .Protocols.DateTime leaveTime = 2;</code>
   */
  com.dj.protobuf.datetime.DateTime getLeaveTime();
  /**
   * <pre>
   * 互动时间
   * </pre>
   *
   * <code>optional .Protocols.DateTime leaveTime = 2;</code>
   */
  com.dj.protobuf.datetime.DateTimeOrBuilder getLeaveTimeOrBuilder();
}
