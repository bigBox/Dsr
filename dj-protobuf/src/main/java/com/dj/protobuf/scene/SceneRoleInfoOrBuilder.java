// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Scene.proto

package com.dj.protobuf.scene;

public interface SceneRoleInfoOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Protocols.SceneRoleInfo)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 玩家基本信息
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional .Protocols.BaseRoleInfo roleBaseInfo = 1;</code>
   */
  boolean hasRoleBaseInfo();
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 玩家基本信息
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional .Protocols.BaseRoleInfo roleBaseInfo = 1;</code>
   */
  com.dj.protobuf.common.BaseRoleInfo getRoleBaseInfo();
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 玩家基本信息
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional .Protocols.BaseRoleInfo roleBaseInfo = 1;</code>
   */
  com.dj.protobuf.common.BaseRoleInfoOrBuilder getRoleBaseInfoOrBuilder();

  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 场景内打扮
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>repeated int32 SceneClothes = 2;</code>
   */
  java.util.List<java.lang.Integer> getSceneClothesList();
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 场景内打扮
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>repeated int32 SceneClothes = 2;</code>
   */
  int getSceneClothesCount();
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 场景内打扮
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>repeated int32 SceneClothes = 2;</code>
   */
  int getSceneClothes(int index);

  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 场景内职位
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional .Protocols.ESceneRolePost post = 3;</code>
   */
  boolean hasPost();
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 场景内职位
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional .Protocols.ESceneRolePost post = 3;</code>
   */
  com.dj.protobuf.scene.ESceneRolePost getPost();

  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 进入场景的时间
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional .Protocols.DateTime attendTime = 4;</code>
   */
  boolean hasAttendTime();
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 进入场景的时间
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional .Protocols.DateTime attendTime = 4;</code>
   */
  com.dj.protobuf.datetime.DateTime getAttendTime();
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 进入场景的时间
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional .Protocols.DateTime attendTime = 4;</code>
   */
  com.dj.protobuf.datetime.DateTimeOrBuilder getAttendTimeOrBuilder();

  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 所在场景坐标
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional .Protocols.OtomeVector3D position = 5;</code>
   */
  boolean hasPosition();
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 所在场景坐标
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional .Protocols.OtomeVector3D position = 5;</code>
   */
  com.dj.protobuf.scene.OtomeVector3D getPosition();
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 所在场景坐标
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional .Protocols.OtomeVector3D position = 5;</code>
   */
  com.dj.protobuf.scene.OtomeVector3DOrBuilder getPositionOrBuilder();

  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 方向
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional .Protocols.OtomeVector3D direction = 6;</code>
   */
  boolean hasDirection();
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 方向
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional .Protocols.OtomeVector3D direction = 6;</code>
   */
  com.dj.protobuf.scene.OtomeVector3D getDirection();
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 方向
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional .Protocols.OtomeVector3D direction = 6;</code>
   */
  com.dj.protobuf.scene.OtomeVector3DOrBuilder getDirectionOrBuilder();

  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 当前所处技能状态
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional .Protocols.SceneRoleSkillStatus skillStatus = 7;</code>
   */
  boolean hasSkillStatus();
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 当前所处技能状态
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional .Protocols.SceneRoleSkillStatus skillStatus = 7;</code>
   */
  com.dj.protobuf.scene.SceneRoleSkillStatus getSkillStatus();
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 当前所处技能状态
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional .Protocols.SceneRoleSkillStatus skillStatus = 7;</code>
   */
  com.dj.protobuf.scene.SceneRoleSkillStatusOrBuilder getSkillStatusOrBuilder();

  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 双倍奖励到期时间
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional .Protocols.DateTime doubleExpire = 8;</code>
   */
  boolean hasDoubleExpire();
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 双倍奖励到期时间
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional .Protocols.DateTime doubleExpire = 8;</code>
   */
  com.dj.protobuf.datetime.DateTime getDoubleExpire();
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 双倍奖励到期时间
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional .Protocols.DateTime doubleExpire = 8;</code>
   */
  com.dj.protobuf.datetime.DateTimeOrBuilder getDoubleExpireOrBuilder();
}
