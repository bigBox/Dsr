// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Scene.proto

package com.dj.protobuf.scene;

public interface SceneDetailInfoOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Protocols.SceneDetailInfo)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>optional .Protocols.SceneBriefInfo briefInfo = 1;</code>
   */
  boolean hasBriefInfo();
  /**
   * <code>optional .Protocols.SceneBriefInfo briefInfo = 1;</code>
   */
  com.dj.protobuf.scene.SceneBriefInfo getBriefInfo();
  /**
   * <code>optional .Protocols.SceneBriefInfo briefInfo = 1;</code>
   */
  com.dj.protobuf.scene.SceneBriefInfoOrBuilder getBriefInfoOrBuilder();

  /**
   * <code>repeated .Protocols.SceneRoleInfo attenders = 2;</code>
   */
  java.util.List<com.dj.protobuf.scene.SceneRoleInfo> 
      getAttendersList();
  /**
   * <code>repeated .Protocols.SceneRoleInfo attenders = 2;</code>
   */
  com.dj.protobuf.scene.SceneRoleInfo getAttenders(int index);
  /**
   * <code>repeated .Protocols.SceneRoleInfo attenders = 2;</code>
   */
  int getAttendersCount();
  /**
   * <code>repeated .Protocols.SceneRoleInfo attenders = 2;</code>
   */
  java.util.List<? extends com.dj.protobuf.scene.SceneRoleInfoOrBuilder> 
      getAttendersOrBuilderList();
  /**
   * <code>repeated .Protocols.SceneRoleInfo attenders = 2;</code>
   */
  com.dj.protobuf.scene.SceneRoleInfoOrBuilder getAttendersOrBuilder(
      int index);
}
