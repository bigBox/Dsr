// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Scene.proto

package com.dj.protobuf.scene;

public interface SceneUseSkillNtfOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Protocols.SceneUseSkillNtf)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>optional int32 skillId = 1;</code>
   */
  boolean hasSkillId();
  /**
   * <code>optional int32 skillId = 1;</code>
   */
  int getSkillId();

  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 技能目标方roleId
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional uint64 targetRoleId = 2;</code>
   */
  boolean hasTargetRoleId();
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 技能目标方roleId
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional uint64 targetRoleId = 2;</code>
   */
  long getTargetRoleId();

  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 技能发起方roleid
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional uint64 srcRoleId = 3;</code>
   */
  boolean hasSrcRoleId();
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 技能发起方roleid
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional uint64 srcRoleId = 3;</code>
   */
  long getSrcRoleId();

  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 技能目标方位置信息
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional .Protocols.OtomeVector3D targetRolePos = 4;</code>
   */
  boolean hasTargetRolePos();
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 技能目标方位置信息
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional .Protocols.OtomeVector3D targetRolePos = 4;</code>
   */
  com.dj.protobuf.scene.OtomeVector3D getTargetRolePos();
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 技能目标方位置信息
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional .Protocols.OtomeVector3D targetRolePos = 4;</code>
   */
  com.dj.protobuf.scene.OtomeVector3DOrBuilder getTargetRolePosOrBuilder();

  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 使用技能类型
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional .Protocols.ESceneUseSkillType type = 5;</code>
   */
  boolean hasType();
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 使用技能类型
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional .Protocols.ESceneUseSkillType type = 5;</code>
   */
  com.dj.protobuf.scene.ESceneUseSkillType getType();

  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 技能发起方的位置信息
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional .Protocols.OtomeVector3D scrRolePos = 6;</code>
   */
  boolean hasScrRolePos();
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 技能发起方的位置信息
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional .Protocols.OtomeVector3D scrRolePos = 6;</code>
   */
  com.dj.protobuf.scene.OtomeVector3D getScrRolePos();
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 技能发起方的位置信息
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional .Protocols.OtomeVector3D scrRolePos = 6;</code>
   */
  com.dj.protobuf.scene.OtomeVector3DOrBuilder getScrRolePosOrBuilder();

  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 技能发起方的方向信息
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional .Protocols.OtomeVector3D srcRoleDirection = 7;</code>
   */
  boolean hasSrcRoleDirection();
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 技能发起方的方向信息
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional .Protocols.OtomeVector3D srcRoleDirection = 7;</code>
   */
  com.dj.protobuf.scene.OtomeVector3D getSrcRoleDirection();
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 技能发起方的方向信息
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional .Protocols.OtomeVector3D srcRoleDirection = 7;</code>
   */
  com.dj.protobuf.scene.OtomeVector3DOrBuilder getSrcRoleDirectionOrBuilder();

  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 技能目标方的方向信息
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional .Protocols.OtomeVector3D targetRoleDirection = 8;</code>
   */
  boolean hasTargetRoleDirection();
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 技能目标方的方向信息
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional .Protocols.OtomeVector3D targetRoleDirection = 8;</code>
   */
  com.dj.protobuf.scene.OtomeVector3D getTargetRoleDirection();
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 技能目标方的方向信息
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional .Protocols.OtomeVector3D targetRoleDirection = 8;</code>
   */
  com.dj.protobuf.scene.OtomeVector3DOrBuilder getTargetRoleDirectionOrBuilder();

  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 使用技能数量
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional int32 skillCount = 9;</code>
   */
  boolean hasSkillCount();
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 使用技能数量
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional int32 skillCount = 9;</code>
   */
  int getSkillCount();

  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 目标位置
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional .Protocols.OtomeVector3D targetPos = 10;</code>
   */
  boolean hasTargetPos();
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 目标位置
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional .Protocols.OtomeVector3D targetPos = 10;</code>
   */
  com.dj.protobuf.scene.OtomeVector3D getTargetPos();
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 目标位置
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional .Protocols.OtomeVector3D targetPos = 10;</code>
   */
  com.dj.protobuf.scene.OtomeVector3DOrBuilder getTargetPosOrBuilder();
}
