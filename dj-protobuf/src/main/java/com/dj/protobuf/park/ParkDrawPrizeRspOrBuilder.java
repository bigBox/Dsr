// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Park.proto

package com.dj.protobuf.park;

public interface ParkDrawPrizeRspOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Protocols.ParkDrawPrizeRsp)
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
   *&#47; 获得金币数量
   * </pre>
   *
   * <code>optional int32 goldNum = 2;</code>
   */
  boolean hasGoldNum();
  /**
   * <pre>
   *&#47; 获得金币数量
   * </pre>
   *
   * <code>optional int32 goldNum = 2;</code>
   */
  int getGoldNum();
}
