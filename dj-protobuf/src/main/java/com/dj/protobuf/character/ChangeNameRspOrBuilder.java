// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Character.proto

package com.dj.protobuf.character;

public interface ChangeNameRspOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Protocols.ChangeNameRsp)
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
   * <code>optional .Protocols.ChangeNameReq req = 2;</code>
   */
  boolean hasReq();
  /**
   * <code>optional .Protocols.ChangeNameReq req = 2;</code>
   */
  com.dj.protobuf.character.ChangeNameReq getReq();
  /**
   * <code>optional .Protocols.ChangeNameReq req = 2;</code>
   */
  com.dj.protobuf.character.ChangeNameReqOrBuilder getReqOrBuilder();
}
