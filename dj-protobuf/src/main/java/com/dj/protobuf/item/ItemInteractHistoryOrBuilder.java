// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Item.proto

package com.dj.protobuf.item;

public interface ItemInteractHistoryOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Protocols.ItemInteractHistory)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * 互动人
   * </pre>
   *
   * <code>optional .Protocols.BaseRoleInfo interactRoleInfo = 1;</code>
   */
  boolean hasInteractRoleInfo();
  /**
   * <pre>
   * 互动人
   * </pre>
   *
   * <code>optional .Protocols.BaseRoleInfo interactRoleInfo = 1;</code>
   */
  com.dj.protobuf.common.BaseRoleInfo getInteractRoleInfo();
  /**
   * <pre>
   * 互动人
   * </pre>
   *
   * <code>optional .Protocols.BaseRoleInfo interactRoleInfo = 1;</code>
   */
  com.dj.protobuf.common.BaseRoleInfoOrBuilder getInteractRoleInfoOrBuilder();

  /**
   * <pre>
   * 物品ID
   * </pre>
   *
   * <code>optional int32 itemID = 2;</code>
   */
  boolean hasItemID();
  /**
   * <pre>
   * 物品ID
   * </pre>
   *
   * <code>optional int32 itemID = 2;</code>
   */
  int getItemID();

  /**
   * <pre>
   * 物品数量
   * </pre>
   *
   * <code>optional int32 itemCount = 3;</code>
   */
  boolean hasItemCount();
  /**
   * <pre>
   * 物品数量
   * </pre>
   *
   * <code>optional int32 itemCount = 3;</code>
   */
  int getItemCount();

  /**
   * <pre>
   * 备注
   * </pre>
   *
   * <code>optional string ps = 4;</code>
   */
  boolean hasPs();
  /**
   * <pre>
   * 备注
   * </pre>
   *
   * <code>optional string ps = 4;</code>
   */
  java.lang.String getPs();
  /**
   * <pre>
   * 备注
   * </pre>
   *
   * <code>optional string ps = 4;</code>
   */
  com.google.protobuf.ByteString
      getPsBytes();

  /**
   * <pre>
   * 互动时间
   * </pre>
   *
   * <code>optional .Protocols.DateTime interactTime = 5;</code>
   */
  boolean hasInteractTime();
  /**
   * <pre>
   * 互动时间
   * </pre>
   *
   * <code>optional .Protocols.DateTime interactTime = 5;</code>
   */
  com.dj.protobuf.datetime.DateTime getInteractTime();
  /**
   * <pre>
   * 互动时间
   * </pre>
   *
   * <code>optional .Protocols.DateTime interactTime = 5;</code>
   */
  com.dj.protobuf.datetime.DateTimeOrBuilder getInteractTimeOrBuilder();
}
