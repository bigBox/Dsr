// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Character.proto

package com.dj.protobuf.character;

public interface ChangeClientDataRspOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Protocols.ChangeClientDataRsp)
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
   * <code>optional .Protocols.ChangeClientDataReq req = 2;</code>
   */
  boolean hasReq();
  /**
   * <code>optional .Protocols.ChangeClientDataReq req = 2;</code>
   */
  com.dj.protobuf.character.ChangeClientDataReq getReq();
  /**
   * <code>optional .Protocols.ChangeClientDataReq req = 2;</code>
   */
  com.dj.protobuf.character.ChangeClientDataReqOrBuilder getReqOrBuilder();
}
