// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Friend.proto

package com.dj.protobuf.friend;

public interface FriendApplyRspOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Protocols.FriendApplyRsp)
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
   * <code>repeated uint64 roleId = 2;</code>
   */
  java.util.List<java.lang.Long> getRoleIdList();
  /**
   * <code>repeated uint64 roleId = 2;</code>
   */
  int getRoleIdCount();
  /**
   * <code>repeated uint64 roleId = 2;</code>
   */
  long getRoleId(int index);

  /**
   * <code>optional .Protocols.FriendApplyReq req = 3;</code>
   */
  boolean hasReq();
  /**
   * <code>optional .Protocols.FriendApplyReq req = 3;</code>
   */
  com.dj.protobuf.friend.FriendApplyReq getReq();
  /**
   * <code>optional .Protocols.FriendApplyReq req = 3;</code>
   */
  com.dj.protobuf.friend.FriendApplyReqOrBuilder getReqOrBuilder();
}
