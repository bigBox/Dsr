// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: OutSideMap.proto

package com.dj.protobuf.outSideMap;

public interface BuildListRspOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Protocols.BuildListRsp)
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
   * <code>repeated .Protocols.BuildInfo builds = 2;</code>
   */
  java.util.List<com.dj.protobuf.outSideMap.BuildInfo> 
      getBuildsList();
  /**
   * <code>repeated .Protocols.BuildInfo builds = 2;</code>
   */
  com.dj.protobuf.outSideMap.BuildInfo getBuilds(int index);
  /**
   * <code>repeated .Protocols.BuildInfo builds = 2;</code>
   */
  int getBuildsCount();
  /**
   * <code>repeated .Protocols.BuildInfo builds = 2;</code>
   */
  java.util.List<? extends com.dj.protobuf.outSideMap.BuildInfoOrBuilder> 
      getBuildsOrBuilderList();
  /**
   * <code>repeated .Protocols.BuildInfo builds = 2;</code>
   */
  com.dj.protobuf.outSideMap.BuildInfoOrBuilder getBuildsOrBuilder(
      int index);
}
