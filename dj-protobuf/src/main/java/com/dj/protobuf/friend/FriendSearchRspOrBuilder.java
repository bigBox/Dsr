// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Friend.proto

package com.dj.protobuf.friend;

public interface FriendSearchRspOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Protocols.FriendSearchRsp)
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
   * <code>repeated .Protocols.BaseRoleInfo roleInfos = 2;</code>
   */
  java.util.List<com.dj.protobuf.common.BaseRoleInfo> 
      getRoleInfosList();
  /**
   * <code>repeated .Protocols.BaseRoleInfo roleInfos = 2;</code>
   */
  com.dj.protobuf.common.BaseRoleInfo getRoleInfos(int index);
  /**
   * <code>repeated .Protocols.BaseRoleInfo roleInfos = 2;</code>
   */
  int getRoleInfosCount();
  /**
   * <code>repeated .Protocols.BaseRoleInfo roleInfos = 2;</code>
   */
  java.util.List<? extends com.dj.protobuf.common.BaseRoleInfoOrBuilder> 
      getRoleInfosOrBuilderList();
  /**
   * <code>repeated .Protocols.BaseRoleInfo roleInfos = 2;</code>
   */
  com.dj.protobuf.common.BaseRoleInfoOrBuilder getRoleInfosOrBuilder(
      int index);
}
