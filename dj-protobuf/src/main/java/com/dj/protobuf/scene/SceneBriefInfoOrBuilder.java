// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Scene.proto

package com.dj.protobuf.scene;

public interface SceneBriefInfoOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Protocols.SceneBriefInfo)
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
   * <code>optional string name = 3;</code>
   */
  boolean hasName();
  /**
   * <code>optional string name = 3;</code>
   */
  java.lang.String getName();
  /**
   * <code>optional string name = 3;</code>
   */
  com.google.protobuf.ByteString
      getNameBytes();

  /**
   * <code>optional int32 level = 4;</code>
   */
  boolean hasLevel();
  /**
   * <code>optional int32 level = 4;</code>
   */
  int getLevel();

  /**
   * <code>optional int32 themeId = 5;</code>
   */
  boolean hasThemeId();
  /**
   * <code>optional int32 themeId = 5;</code>
   */
  int getThemeId();

  /**
   * <code>optional int32 curPlayerNum = 6;</code>
   */
  boolean hasCurPlayerNum();
  /**
   * <code>optional int32 curPlayerNum = 6;</code>
   */
  int getCurPlayerNum();

  /**
   * <code>optional int32 maxPlayerNum = 7;</code>
   */
  boolean hasMaxPlayerNum();
  /**
   * <code>optional int32 maxPlayerNum = 7;</code>
   */
  int getMaxPlayerNum();

  /**
   * <code>optional bool isNeedPassword = 8;</code>
   */
  boolean hasIsNeedPassword();
  /**
   * <code>optional bool isNeedPassword = 8;</code>
   */
  boolean getIsNeedPassword();
}