// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Manufacture.proto

package com.dj.protobuf.manufacture;

public interface ManufactureStateOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Protocols.ManufactureState)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 操作配方ID
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional int32 recipeId = 1;</code>
   */
  boolean hasRecipeId();
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 操作配方ID
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional int32 recipeId = 1;</code>
   */
  int getRecipeId();

  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 状态
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional .Protocols.EManufactureState state = 2;</code>
   */
  boolean hasState();
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 状态
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional .Protocols.EManufactureState state = 2;</code>
   */
  com.dj.protobuf.manufacture.EManufactureState getState();

  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 制作用时
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional int32 makingTime = 3;</code>
   */
  boolean hasMakingTime();
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 制作用时
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional int32 makingTime = 3;</code>
   */
  int getMakingTime();

  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 倒计时;秒数
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional int32 countDown = 4;</code>
   */
  boolean hasCountDown();
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 倒计时;秒数
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional int32 countDown = 4;</code>
   */
  int getCountDown();
}
