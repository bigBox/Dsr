// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Outside.proto

package com.dj.protobuf.outside;

public interface OutsideRspOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Protocols.OutsideRsp)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 错误码
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional .ErrorID errorID = 1;</code>
   */
  boolean hasErrorID();
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 错误码
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional .ErrorID errorID = 1;</code>
   */
  com.dj.protobuf.ErrorIDOuterClass.ErrorID getErrorID();

  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 奖励物品
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>repeated .Protocols.OutSideProductInfo products = 2;</code>
   */
  java.util.List<com.dj.protobuf.outside.OutSideProductInfo> 
      getProductsList();
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 奖励物品
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>repeated .Protocols.OutSideProductInfo products = 2;</code>
   */
  com.dj.protobuf.outside.OutSideProductInfo getProducts(int index);
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 奖励物品
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>repeated .Protocols.OutSideProductInfo products = 2;</code>
   */
  int getProductsCount();
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 奖励物品
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>repeated .Protocols.OutSideProductInfo products = 2;</code>
   */
  java.util.List<? extends com.dj.protobuf.outside.OutSideProductInfoOrBuilder> 
      getProductsOrBuilderList();
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 奖励物品
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>repeated .Protocols.OutSideProductInfo products = 2;</code>
   */
  com.dj.protobuf.outside.OutSideProductInfoOrBuilder getProductsOrBuilder(
      int index);

  /**
   * <code>optional .Protocols.OutsideReq req = 3;</code>
   */
  boolean hasReq();
  /**
   * <code>optional .Protocols.OutsideReq req = 3;</code>
   */
  com.dj.protobuf.outside.OutsideReq getReq();
  /**
   * <code>optional .Protocols.OutsideReq req = 3;</code>
   */
  com.dj.protobuf.outside.OutsideReqOrBuilder getReqOrBuilder();
}
