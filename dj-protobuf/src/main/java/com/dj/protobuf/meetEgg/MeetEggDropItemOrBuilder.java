// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: MeetEgg.proto

package com.dj.protobuf.meetEgg;

public interface MeetEggDropItemOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Protocols.MeetEggDropItem)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   *掉落唯一id
   * </pre>
   *
   * <code>optional string timeID = 1;</code>
   */
  boolean hasTimeID();
  /**
   * <pre>
   *掉落唯一id
   * </pre>
   *
   * <code>optional string timeID = 1;</code>
   */
  java.lang.String getTimeID();
  /**
   * <pre>
   *掉落唯一id
   * </pre>
   *
   * <code>optional string timeID = 1;</code>
   */
  com.google.protobuf.ByteString
      getTimeIDBytes();

  /**
   * <pre>
   *掉落配置id
   * </pre>
   *
   * <code>optional int32 dropID = 2;</code>
   */
  boolean hasDropID();
  /**
   * <pre>
   *掉落配置id
   * </pre>
   *
   * <code>optional int32 dropID = 2;</code>
   */
  int getDropID();

  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 距离掉落的秒数
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional int32 leftSeconds = 3;</code>
   */
  boolean hasLeftSeconds();
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 距离掉落的秒数
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional int32 leftSeconds = 3;</code>
   */
  int getLeftSeconds();
}
