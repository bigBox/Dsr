// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Mall.proto

package com.dj.protobuf.mall;

public interface MallBuyRspOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Protocols.MallBuyRsp)
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
   * <code>optional .Protocols.MallBuyReq req = 2;</code>
   */
  boolean hasReq();
  /**
   * <code>optional .Protocols.MallBuyReq req = 2;</code>
   */
  com.dj.protobuf.mall.MallBuyReq getReq();
  /**
   * <code>optional .Protocols.MallBuyReq req = 2;</code>
   */
  com.dj.protobuf.mall.MallBuyReqOrBuilder getReqOrBuilder();
}
