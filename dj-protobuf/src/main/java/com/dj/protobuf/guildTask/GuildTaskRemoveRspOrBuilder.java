// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: GuildTask.proto

package com.dj.protobuf.guildTask;

public interface GuildTaskRemoveRspOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Protocols.GuildTaskRemoveRsp)
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
   * <code>optional .Protocols.GuildTaskRemoveReq req = 2;</code>
   */
  boolean hasReq();
  /**
   * <code>optional .Protocols.GuildTaskRemoveReq req = 2;</code>
   */
  com.dj.protobuf.guildTask.GuildTaskRemoveReq getReq();
  /**
   * <code>optional .Protocols.GuildTaskRemoveReq req = 2;</code>
   */
  com.dj.protobuf.guildTask.GuildTaskRemoveReqOrBuilder getReqOrBuilder();

  /**
   * <code>optional .Protocols.TaskInfo task = 3;</code>
   */
  boolean hasTask();
  /**
   * <code>optional .Protocols.TaskInfo task = 3;</code>
   */
  com.dj.protobuf.task.TaskInfo getTask();
  /**
   * <code>optional .Protocols.TaskInfo task = 3;</code>
   */
  com.dj.protobuf.task.TaskInfoOrBuilder getTaskOrBuilder();
}
