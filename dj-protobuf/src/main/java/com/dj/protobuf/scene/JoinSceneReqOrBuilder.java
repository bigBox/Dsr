// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Scene.proto

package com.dj.protobuf.scene;

public interface JoinSceneReqOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Protocols.JoinSceneReq)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>optional uint64 id = 1;</code>
   */
  boolean hasId();
  /**
   * <code>optional uint64 id = 1;</code>
   */
  long getId();

  /**
   * <code>optional string password = 2;</code>
   */
  boolean hasPassword();
  /**
   * <code>optional string password = 2;</code>
   */
  java.lang.String getPassword();
  /**
   * <code>optional string password = 2;</code>
   */
  com.google.protobuf.ByteString
      getPasswordBytes();

  /**
   * <code>optional .Protocols.ESceneRebornPos pos = 3;</code>
   */
  boolean hasPos();
  /**
   * <code>optional .Protocols.ESceneRebornPos pos = 3;</code>
   */
  com.dj.protobuf.scene.ESceneRebornPos getPos();
}
