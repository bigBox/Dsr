// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: MeetEgg.proto

package com.dj.protobuf.meetEgg;

public interface ExitMeetEggRspOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Protocols.ExitMeetEggRsp)
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
   *总积分
   * </pre>
   *
   * <code>optional int32 totalScore = 2;</code>
   */
  boolean hasTotalScore();
  /**
   * <pre>
   *总积分
   * </pre>
   *
   * <code>optional int32 totalScore = 2;</code>
   */
  int getTotalScore();
}
