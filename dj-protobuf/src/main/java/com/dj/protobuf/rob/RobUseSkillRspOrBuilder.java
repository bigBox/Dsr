// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Rob.proto

package com.dj.protobuf.rob;

public interface RobUseSkillRspOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Protocols.RobUseSkillRsp)
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
   * <code>optional .Protocols.RobUseSkillReq req = 2;</code>
   */
  boolean hasReq();
  /**
   * <code>optional .Protocols.RobUseSkillReq req = 2;</code>
   */
  com.dj.protobuf.rob.RobUseSkillReq getReq();
  /**
   * <code>optional .Protocols.RobUseSkillReq req = 2;</code>
   */
  com.dj.protobuf.rob.RobUseSkillReqOrBuilder getReqOrBuilder();

  /**
   * <code>optional int32 type = 3;</code>
   */
  boolean hasType();
  /**
   * <code>optional int32 type = 3;</code>
   */
  int getType();

  /**
   * <code>optional int32 robId = 4;</code>
   */
  boolean hasRobId();
  /**
   * <code>optional int32 robId = 4;</code>
   */
  int getRobId();

  /**
   * <code>optional int32 actionValue = 5;</code>
   */
  boolean hasActionValue();
  /**
   * <code>optional int32 actionValue = 5;</code>
   */
  int getActionValue();

  /**
   * <code>optional int32 actionChange = 6;</code>
   */
  boolean hasActionChange();
  /**
   * <code>optional int32 actionChange = 6;</code>
   */
  int getActionChange();

  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 1：是大宝，0：不是大宝
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional int32 treasure = 7;</code>
   */
  boolean hasTreasure();
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 1：是大宝，0：不是大宝
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional int32 treasure = 7;</code>
   */
  int getTreasure();

  /**
   * <pre>
   * 获得奖励物品
   * </pre>
   *
   * <code>repeated int32 itemId = 8;</code>
   */
  java.util.List<java.lang.Integer> getItemIdList();
  /**
   * <pre>
   * 获得奖励物品
   * </pre>
   *
   * <code>repeated int32 itemId = 8;</code>
   */
  int getItemIdCount();
  /**
   * <pre>
   * 获得奖励物品
   * </pre>
   *
   * <code>repeated int32 itemId = 8;</code>
   */
  int getItemId(int index);

  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 1:远了, 0:没变, -1:近了
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional int32 result = 9;</code>
   */
  boolean hasResult();
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 1:远了, 0:没变, -1:近了
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional int32 result = 9;</code>
   */
  int getResult();

  /**
   * <pre>
   * 如果遇到陷阱，并且有道具效果，该值返回对应的道具ID，方便给前端做效果
   * </pre>
   *
   * <code>optional int32 trapItem = 10;</code>
   */
  boolean hasTrapItem();
  /**
   * <pre>
   * 如果遇到陷阱，并且有道具效果，该值返回对应的道具ID，方便给前端做效果
   * </pre>
   *
   * <code>optional int32 trapItem = 10;</code>
   */
  int getTrapItem();
}
