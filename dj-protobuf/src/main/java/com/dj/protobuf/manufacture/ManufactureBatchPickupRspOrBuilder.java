// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Manufacture.proto

package com.dj.protobuf.manufacture;

public interface ManufactureBatchPickupRspOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Protocols.ManufactureBatchPickupRsp)
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
   *&#47; &lt;summary&gt;
   * / 批量拾取成功的队列
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>repeated int32 successIndex = 2;</code>
   */
  java.util.List<java.lang.Integer> getSuccessIndexList();
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 批量拾取成功的队列
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>repeated int32 successIndex = 2;</code>
   */
  int getSuccessIndexCount();
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 批量拾取成功的队列
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>repeated int32 successIndex = 2;</code>
   */
  int getSuccessIndex(int index);
}
