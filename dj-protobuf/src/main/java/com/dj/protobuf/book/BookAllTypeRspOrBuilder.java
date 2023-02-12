// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Book.proto

package com.dj.protobuf.book;

public interface BookAllTypeRspOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Protocols.BookAllTypeRsp)
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
   * <pre>
   * 总百分比
   * </pre>
   *
   * <code>optional int32 totalRatio = 2;</code>
   */
  boolean hasTotalRatio();
  /**
   * <pre>
   * 总百分比
   * </pre>
   *
   * <code>optional int32 totalRatio = 2;</code>
   */
  int getTotalRatio();

  /**
   * <pre>
   * 每种类型图鉴拥有百分比
   * </pre>
   *
   * <code>map&lt;int32, int32&gt; typeMap = 3;</code>
   */
  int getTypeMapCount();
  /**
   * <pre>
   * 每种类型图鉴拥有百分比
   * </pre>
   *
   * <code>map&lt;int32, int32&gt; typeMap = 3;</code>
   */
  boolean containsTypeMap(
      int key);
  /**
   * Use {@link #getTypeMapMap()} instead.
   */
  @java.lang.Deprecated
  java.util.Map<java.lang.Integer, java.lang.Integer>
  getTypeMap();
  /**
   * <pre>
   * 每种类型图鉴拥有百分比
   * </pre>
   *
   * <code>map&lt;int32, int32&gt; typeMap = 3;</code>
   */
  java.util.Map<java.lang.Integer, java.lang.Integer>
  getTypeMapMap();
  /**
   * <pre>
   * 每种类型图鉴拥有百分比
   * </pre>
   *
   * <code>map&lt;int32, int32&gt; typeMap = 3;</code>
   */

  int getTypeMapOrDefault(
      int key,
      int defaultValue);
  /**
   * <pre>
   * 每种类型图鉴拥有百分比
   * </pre>
   *
   * <code>map&lt;int32, int32&gt; typeMap = 3;</code>
   */

  int getTypeMapOrThrow(
      int key);
}
