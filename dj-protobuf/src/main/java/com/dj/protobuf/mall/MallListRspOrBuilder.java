// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Mall.proto

package com.dj.protobuf.mall;

public interface MallListRspOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Protocols.MallListRsp)
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
   * / 
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional .Protocols.MallListReq req = 2;</code>
   */
  boolean hasReq();
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional .Protocols.MallListReq req = 2;</code>
   */
  com.dj.protobuf.mall.MallListReq getReq();
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional .Protocols.MallListReq req = 2;</code>
   */
  com.dj.protobuf.mall.MallListReqOrBuilder getReqOrBuilder();

  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 商品信息
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>map&lt;int32, .Protocols.GoodDescription&gt; GoodInfos = 3;</code>
   */
  int getGoodInfosCount();
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 商品信息
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>map&lt;int32, .Protocols.GoodDescription&gt; GoodInfos = 3;</code>
   */
  boolean containsGoodInfos(
      int key);
  /**
   * Use {@link #getGoodInfosMap()} instead.
   */
  @java.lang.Deprecated
  java.util.Map<java.lang.Integer, com.dj.protobuf.mall.GoodDescription>
  getGoodInfos();
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 商品信息
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>map&lt;int32, .Protocols.GoodDescription&gt; GoodInfos = 3;</code>
   */
  java.util.Map<java.lang.Integer, com.dj.protobuf.mall.GoodDescription>
  getGoodInfosMap();
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 商品信息
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>map&lt;int32, .Protocols.GoodDescription&gt; GoodInfos = 3;</code>
   */

  com.dj.protobuf.mall.GoodDescription getGoodInfosOrDefault(
      int key,
      com.dj.protobuf.mall.GoodDescription defaultValue);
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 商品信息
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>map&lt;int32, .Protocols.GoodDescription&gt; GoodInfos = 3;</code>
   */

  com.dj.protobuf.mall.GoodDescription getGoodInfosOrThrow(
      int key);
}
