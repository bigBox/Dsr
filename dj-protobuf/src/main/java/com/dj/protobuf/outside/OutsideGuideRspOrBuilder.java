// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Outside.proto

package com.dj.protobuf.outside;

public interface OutsideGuideRspOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Protocols.OutsideGuideRsp)
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
   * <code>optional .Protocols.OutsideGuideReq req = 3;</code>
   */
  boolean hasReq();
  /**
   * <code>optional .Protocols.OutsideGuideReq req = 3;</code>
   */
  com.dj.protobuf.outside.OutsideGuideReq getReq();
  /**
   * <code>optional .Protocols.OutsideGuideReq req = 3;</code>
   */
  com.dj.protobuf.outside.OutsideGuideReqOrBuilder getReqOrBuilder();
}
