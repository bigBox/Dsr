// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Item.proto

package com.dj.protobuf.item;

public interface ItemFriendReqOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Protocols.ItemFriendReq)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>optional uint64 roleId = 1;</code>
   */
  boolean hasRoleId();
  /**
   * <code>optional uint64 roleId = 1;</code>
   */
  long getRoleId();

  /**
   * <code>repeated int32 ItemId = 2;</code>
   */
  java.util.List<java.lang.Integer> getItemIdList();
  /**
   * <code>repeated int32 ItemId = 2;</code>
   */
  int getItemIdCount();
  /**
   * <code>repeated int32 ItemId = 2;</code>
   */
  int getItemId(int index);
}
