// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: MeetEgg.proto

package com.dj.protobuf.meetEgg;

public interface StartMeetEggRspOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Protocols.StartMeetEggRsp)
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
   * <pre>
   *初始掉落id
   * </pre>
   *
   * <code>repeated .Protocols.MeetEggDropItem dropItems = 2;</code>
   */
  java.util.List<com.dj.protobuf.meetEgg.MeetEggDropItem> 
      getDropItemsList();
  /**
   * <pre>
   *初始掉落id
   * </pre>
   *
   * <code>repeated .Protocols.MeetEggDropItem dropItems = 2;</code>
   */
  com.dj.protobuf.meetEgg.MeetEggDropItem getDropItems(int index);
  /**
   * <pre>
   *初始掉落id
   * </pre>
   *
   * <code>repeated .Protocols.MeetEggDropItem dropItems = 2;</code>
   */
  int getDropItemsCount();
  /**
   * <pre>
   *初始掉落id
   * </pre>
   *
   * <code>repeated .Protocols.MeetEggDropItem dropItems = 2;</code>
   */
  java.util.List<? extends com.dj.protobuf.meetEgg.MeetEggDropItemOrBuilder> 
      getDropItemsOrBuilderList();
  /**
   * <pre>
   *初始掉落id
   * </pre>
   *
   * <code>repeated .Protocols.MeetEggDropItem dropItems = 2;</code>
   */
  com.dj.protobuf.meetEgg.MeetEggDropItemOrBuilder getDropItemsOrBuilder(
      int index);
}