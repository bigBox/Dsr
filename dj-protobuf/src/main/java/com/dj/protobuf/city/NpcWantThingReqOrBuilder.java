// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: City.proto

package com.dj.protobuf.city;

public interface NpcWantThingReqOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Protocols.NpcWantThingReq)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * 拜访npc返回eventContent中yes或no的值1或0
   * </pre>
   *
   * <code>optional int32 answer = 1;</code>
   */
  boolean hasAnswer();
  /**
   * <pre>
   * 拜访npc返回eventContent中yes或no的值1或0
   * </pre>
   *
   * <code>optional int32 answer = 1;</code>
   */
  int getAnswer();

  /**
   * <code>optional int32 itemId = 2;</code>
   */
  boolean hasItemId();
  /**
   * <code>optional int32 itemId = 2;</code>
   */
  int getItemId();

  /**
   * <code>optional int32 itemCount = 3;</code>
   */
  boolean hasItemCount();
  /**
   * <code>optional int32 itemCount = 3;</code>
   */
  int getItemCount();
}
