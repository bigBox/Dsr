// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Guide.proto

package com.dj.protobuf.guide;

public interface GetGuideRewardRspOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Protocols.GetGuideRewardRsp)
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
   * <code>optional .Protocols.GetGuideRewardReq req = 2;</code>
   */
  boolean hasReq();
  /**
   * <code>optional .Protocols.GetGuideRewardReq req = 2;</code>
   */
  com.dj.protobuf.guide.GetGuideRewardReq getReq();
  /**
   * <code>optional .Protocols.GetGuideRewardReq req = 2;</code>
   */
  com.dj.protobuf.guide.GetGuideRewardReqOrBuilder getReqOrBuilder();
}