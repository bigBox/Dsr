// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Task.proto

package com.dj.protobuf.task;

public interface TaskStateListRspOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Protocols.TaskStateListRsp)
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
   * <code>repeated .Protocols.TaskStateInfo taskState = 2;</code>
   */
  java.util.List<com.dj.protobuf.task.TaskStateInfo> 
      getTaskStateList();
  /**
   * <code>repeated .Protocols.TaskStateInfo taskState = 2;</code>
   */
  com.dj.protobuf.task.TaskStateInfo getTaskState(int index);
  /**
   * <code>repeated .Protocols.TaskStateInfo taskState = 2;</code>
   */
  int getTaskStateCount();
  /**
   * <code>repeated .Protocols.TaskStateInfo taskState = 2;</code>
   */
  java.util.List<? extends com.dj.protobuf.task.TaskStateInfoOrBuilder> 
      getTaskStateOrBuilderList();
  /**
   * <code>repeated .Protocols.TaskStateInfo taskState = 2;</code>
   */
  com.dj.protobuf.task.TaskStateInfoOrBuilder getTaskStateOrBuilder(
      int index);
}
