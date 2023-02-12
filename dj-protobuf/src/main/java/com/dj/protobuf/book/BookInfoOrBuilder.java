// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Book.proto

package com.dj.protobuf.book;

public interface BookInfoOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Protocols.BookInfo)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 类型
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional .Protocols.BookType type = 1;</code>
   */
  boolean hasType();
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 类型
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional .Protocols.BookType type = 1;</code>
   */
  com.dj.protobuf.book.BookType getType();

  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 图鉴id
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional int32 bookId = 2;</code>
   */
  boolean hasBookId();
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 图鉴id
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional int32 bookId = 2;</code>
   */
  int getBookId();

  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 物品id
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional int32 itemId = 3;</code>
   */
  boolean hasItemId();
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 物品id
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional int32 itemId = 3;</code>
   */
  int getItemId();

  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 图鉴状态
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional .Protocols.BookState state = 4;</code>
   */
  boolean hasState();
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 图鉴状态
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional .Protocols.BookState state = 4;</code>
   */
  com.dj.protobuf.book.BookState getState();

  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 奖励标识，可领奖次数
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional int32 reward = 5;</code>
   */
  boolean hasReward();
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 奖励标识，可领奖次数
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional int32 reward = 5;</code>
   */
  int getReward();

  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 是否稀有
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional int32 isRare = 6;</code>
   */
  boolean hasIsRare();
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 是否稀有
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional int32 isRare = 6;</code>
   */
  int getIsRare();

  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 套装ID
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional int32 antiqueId = 7;</code>
   */
  boolean hasAntiqueId();
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 套装ID
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional int32 antiqueId = 7;</code>
   */
  int getAntiqueId();
}