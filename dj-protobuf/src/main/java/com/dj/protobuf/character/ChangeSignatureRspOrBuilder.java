// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Character.proto

package com.dj.protobuf.character;

public interface ChangeSignatureRspOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Protocols.ChangeSignatureRsp)
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
   * <code>optional .Protocols.ChangeSignatureReq req = 2;</code>
   */
  boolean hasReq();
  /**
   * <code>optional .Protocols.ChangeSignatureReq req = 2;</code>
   */
  com.dj.protobuf.character.ChangeSignatureReq getReq();
  /**
   * <code>optional .Protocols.ChangeSignatureReq req = 2;</code>
   */
  com.dj.protobuf.character.ChangeSignatureReqOrBuilder getReqOrBuilder();
}
