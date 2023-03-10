// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Scene.proto

package com.dj.protobuf.scene;

public interface SceneRoleSkillStatusOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Protocols.SceneRoleSkillStatus)
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
   * <code>optional uint64 srcRoleId = 2;</code>
   */
  boolean hasSrcRoleId();
  /**
   * <code>optional uint64 srcRoleId = 2;</code>
   */
  long getSrcRoleId();

  /**
   * <code>optional uint64 targetRoleId = 3;</code>
   */
  boolean hasTargetRoleId();
  /**
   * <code>optional uint64 targetRoleId = 3;</code>
   */
  long getTargetRoleId();

  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 技能状态， start为使用技能状态，cancel为空闲状态
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional .Protocols.ESceneUseSkillType type = 4;</code>
   */
  boolean hasType();
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 技能状态， start为使用技能状态，cancel为空闲状态
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional .Protocols.ESceneUseSkillType type = 4;</code>
   */
  com.dj.protobuf.scene.ESceneUseSkillType getType();

  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 技能发起方方向信息
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional .Protocols.OtomeVector3D srcRoleDirection = 5;</code>
   */
  boolean hasSrcRoleDirection();
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 技能发起方方向信息
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional .Protocols.OtomeVector3D srcRoleDirection = 5;</code>
   */
  com.dj.protobuf.scene.OtomeVector3D getSrcRoleDirection();
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 技能发起方方向信息
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional .Protocols.OtomeVector3D srcRoleDirection = 5;</code>
   */
  com.dj.protobuf.scene.OtomeVector3DOrBuilder getSrcRoleDirectionOrBuilder();

  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 技能目标方方向信息
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional .Protocols.OtomeVector3D targetRoleDirection = 6;</code>
   */
  boolean hasTargetRoleDirection();
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 技能目标方方向信息
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional .Protocols.OtomeVector3D targetRoleDirection = 6;</code>
   */
  com.dj.protobuf.scene.OtomeVector3D getTargetRoleDirection();
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 技能目标方方向信息
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional .Protocols.OtomeVector3D targetRoleDirection = 6;</code>
   */
  com.dj.protobuf.scene.OtomeVector3DOrBuilder getTargetRoleDirectionOrBuilder();
}
