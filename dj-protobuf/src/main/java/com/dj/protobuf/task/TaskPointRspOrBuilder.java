// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Task.proto

package com.dj.protobuf.task;

public interface TaskPointRspOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Protocols.TaskPointRsp)
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
   * <code>optional .Protocols.TaskPointReq req = 2;</code>
   */
  boolean hasReq();
  /**
   * <code>optional .Protocols.TaskPointReq req = 2;</code>
   */
  com.dj.protobuf.task.TaskPointReq getReq();
  /**
   * <code>optional .Protocols.TaskPointReq req = 2;</code>
   */
  com.dj.protobuf.task.TaskPointReqOrBuilder getReqOrBuilder();
}
