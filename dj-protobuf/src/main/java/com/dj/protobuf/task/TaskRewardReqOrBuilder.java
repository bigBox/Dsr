// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Task.proto

package com.dj.protobuf.task;

public interface TaskRewardReqOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Protocols.TaskRewardReq)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * 任务索引
   * </pre>
   *
   * <code>optional int32 taskId = 1;</code>
   */
  boolean hasTaskId();
  /**
   * <pre>
   * 任务索引
   * </pre>
   *
   * <code>optional int32 taskId = 1;</code>
   */
  int getTaskId();

  /**
   * <code>optional .Protocols.ETaskType type = 2;</code>
   */
  boolean hasType();
  /**
   * <code>optional .Protocols.ETaskType type = 2;</code>
   */
  com.dj.protobuf.task.ETaskType getType();
}
