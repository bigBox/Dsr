// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Collection.proto

package com.dj.protobuf.collection;

public interface CollectionListRspOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Protocols.CollectionListRsp)
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
   * <code>map&lt;int32, .Protocols.CollectionInfo&gt; infos = 2;</code>
   */
  int getInfosCount();
  /**
   * <code>map&lt;int32, .Protocols.CollectionInfo&gt; infos = 2;</code>
   */
  boolean containsInfos(
      int key);
  /**
   * Use {@link #getInfosMap()} instead.
   */
  @java.lang.Deprecated
  java.util.Map<java.lang.Integer, com.dj.protobuf.collection.CollectionInfo>
  getInfos();
  /**
   * <code>map&lt;int32, .Protocols.CollectionInfo&gt; infos = 2;</code>
   */
  java.util.Map<java.lang.Integer, com.dj.protobuf.collection.CollectionInfo>
  getInfosMap();
  /**
   * <code>map&lt;int32, .Protocols.CollectionInfo&gt; infos = 2;</code>
   */

  com.dj.protobuf.collection.CollectionInfo getInfosOrDefault(
      int key,
      com.dj.protobuf.collection.CollectionInfo defaultValue);
  /**
   * <code>map&lt;int32, .Protocols.CollectionInfo&gt; infos = 2;</code>
   */

  com.dj.protobuf.collection.CollectionInfo getInfosOrThrow(
      int key);
}