// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Book.proto

package com.dj.protobuf.book;

public interface BookInfoRspOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Protocols.BookInfoRsp)
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
   * <code>optional .Protocols.BookInfoReq req = 2;</code>
   */
  boolean hasReq();
  /**
   * <code>optional .Protocols.BookInfoReq req = 2;</code>
   */
  com.dj.protobuf.book.BookInfoReq getReq();
  /**
   * <code>optional .Protocols.BookInfoReq req = 2;</code>
   */
  com.dj.protobuf.book.BookInfoReqOrBuilder getReqOrBuilder();

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

  /**
   * <pre>
   * 列表
   * </pre>
   *
   * <code>repeated .Protocols.BookInfo infos = 4;</code>
   */
  java.util.List<com.dj.protobuf.book.BookInfo> 
      getInfosList();
  /**
   * <pre>
   * 列表
   * </pre>
   *
   * <code>repeated .Protocols.BookInfo infos = 4;</code>
   */
  com.dj.protobuf.book.BookInfo getInfos(int index);
  /**
   * <pre>
   * 列表
   * </pre>
   *
   * <code>repeated .Protocols.BookInfo infos = 4;</code>
   */
  int getInfosCount();
  /**
   * <pre>
   * 列表
   * </pre>
   *
   * <code>repeated .Protocols.BookInfo infos = 4;</code>
   */
  java.util.List<? extends com.dj.protobuf.book.BookInfoOrBuilder> 
      getInfosOrBuilderList();
  /**
   * <pre>
   * 列表
   * </pre>
   *
   * <code>repeated .Protocols.BookInfo infos = 4;</code>
   */
  com.dj.protobuf.book.BookInfoOrBuilder getInfosOrBuilder(
      int index);
}
