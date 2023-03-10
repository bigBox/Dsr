// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Scene.proto

package com.dj.protobuf.scene;

/**
 * Protobuf type {@code Protocols.SceneMovementReq}
 */
public  final class SceneMovementReq extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:Protocols.SceneMovementReq)
    SceneMovementReqOrBuilder {
  // Use SceneMovementReq.newBuilder() to construct.
  private SceneMovementReq(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private SceneMovementReq() {
    moveType_ = 1;
    speed_ = 0F;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private SceneMovementReq(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          default: {
            if (!parseUnknownField(input, unknownFields,
                                   extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
          case 8: {
            int rawValue = input.readEnum();
            com.dj.protobuf.scene.ESceneMoveType value = com.dj.protobuf.scene.ESceneMoveType.valueOf(rawValue);
            if (value == null) {
              unknownFields.mergeVarintField(1, rawValue);
            } else {
              bitField0_ |= 0x00000001;
              moveType_ = rawValue;
            }
            break;
          }
          case 18: {
            com.dj.protobuf.scene.OtomeVector3D.Builder subBuilder = null;
            if (((bitField0_ & 0x00000002) == 0x00000002)) {
              subBuilder = pos_.toBuilder();
            }
            pos_ = input.readMessage(com.dj.protobuf.scene.OtomeVector3D.PARSER, extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(pos_);
              pos_ = subBuilder.buildPartial();
            }
            bitField0_ |= 0x00000002;
            break;
          }
          case 29: {
            bitField0_ |= 0x00000004;
            speed_ = input.readFloat();
            break;
          }
          case 34: {
            com.dj.protobuf.scene.OtomeVector3D.Builder subBuilder = null;
            if (((bitField0_ & 0x00000008) == 0x00000008)) {
              subBuilder = direction_.toBuilder();
            }
            direction_ = input.readMessage(com.dj.protobuf.scene.OtomeVector3D.PARSER, extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(direction_);
              direction_ = subBuilder.buildPartial();
            }
            bitField0_ |= 0x00000008;
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.dj.protobuf.scene.Scene.internal_static_Protocols_SceneMovementReq_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.dj.protobuf.scene.Scene.internal_static_Protocols_SceneMovementReq_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.dj.protobuf.scene.SceneMovementReq.class, com.dj.protobuf.scene.SceneMovementReq.Builder.class);
  }

  private int bitField0_;
  public static final int MOVETYPE_FIELD_NUMBER = 1;
  private int moveType_;
  /**
   * <code>optional .Protocols.ESceneMoveType moveType = 1;</code>
   */
  public boolean hasMoveType() {
    return ((bitField0_ & 0x00000001) == 0x00000001);
  }
  /**
   * <code>optional .Protocols.ESceneMoveType moveType = 1;</code>
   */
  public com.dj.protobuf.scene.ESceneMoveType getMoveType() {
    com.dj.protobuf.scene.ESceneMoveType result = com.dj.protobuf.scene.ESceneMoveType.valueOf(moveType_);
    return result == null ? com.dj.protobuf.scene.ESceneMoveType.Mov_Start : result;
  }

  public static final int POS_FIELD_NUMBER = 2;
  private com.dj.protobuf.scene.OtomeVector3D pos_;
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / ????????????
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional .Protocols.OtomeVector3D pos = 2;</code>
   */
  public boolean hasPos() {
    return ((bitField0_ & 0x00000002) == 0x00000002);
  }
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / ????????????
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional .Protocols.OtomeVector3D pos = 2;</code>
   */
  public com.dj.protobuf.scene.OtomeVector3D getPos() {
    return pos_ == null ? com.dj.protobuf.scene.OtomeVector3D.getDefaultInstance() : pos_;
  }
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / ????????????
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional .Protocols.OtomeVector3D pos = 2;</code>
   */
  public com.dj.protobuf.scene.OtomeVector3DOrBuilder getPosOrBuilder() {
    return pos_ == null ? com.dj.protobuf.scene.OtomeVector3D.getDefaultInstance() : pos_;
  }

  public static final int SPEED_FIELD_NUMBER = 3;
  private float speed_;
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / ??????
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional float speed = 3;</code>
   */
  public boolean hasSpeed() {
    return ((bitField0_ & 0x00000004) == 0x00000004);
  }
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / ??????
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional float speed = 3;</code>
   */
  public float getSpeed() {
    return speed_;
  }

  public static final int DIRECTION_FIELD_NUMBER = 4;
  private com.dj.protobuf.scene.OtomeVector3D direction_;
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / ??????
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional .Protocols.OtomeVector3D direction = 4;</code>
   */
  public boolean hasDirection() {
    return ((bitField0_ & 0x00000008) == 0x00000008);
  }
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / ??????
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional .Protocols.OtomeVector3D direction = 4;</code>
   */
  public com.dj.protobuf.scene.OtomeVector3D getDirection() {
    return direction_ == null ? com.dj.protobuf.scene.OtomeVector3D.getDefaultInstance() : direction_;
  }
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / ??????
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional .Protocols.OtomeVector3D direction = 4;</code>
   */
  public com.dj.protobuf.scene.OtomeVector3DOrBuilder getDirectionOrBuilder() {
    return direction_ == null ? com.dj.protobuf.scene.OtomeVector3D.getDefaultInstance() : direction_;
  }

  private byte memoizedIsInitialized = -1;
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (((bitField0_ & 0x00000001) == 0x00000001)) {
      output.writeEnum(1, moveType_);
    }
    if (((bitField0_ & 0x00000002) == 0x00000002)) {
      output.writeMessage(2, getPos());
    }
    if (((bitField0_ & 0x00000004) == 0x00000004)) {
      output.writeFloat(3, speed_);
    }
    if (((bitField0_ & 0x00000008) == 0x00000008)) {
      output.writeMessage(4, getDirection());
    }
    unknownFields.writeTo(output);
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (((bitField0_ & 0x00000001) == 0x00000001)) {
      size += com.google.protobuf.CodedOutputStream
        .computeEnumSize(1, moveType_);
    }
    if (((bitField0_ & 0x00000002) == 0x00000002)) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(2, getPos());
    }
    if (((bitField0_ & 0x00000004) == 0x00000004)) {
      size += com.google.protobuf.CodedOutputStream
        .computeFloatSize(3, speed_);
    }
    if (((bitField0_ & 0x00000008) == 0x00000008)) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(4, getDirection());
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  private static final long serialVersionUID = 0L;
  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof com.dj.protobuf.scene.SceneMovementReq)) {
      return super.equals(obj);
    }
    com.dj.protobuf.scene.SceneMovementReq other = (com.dj.protobuf.scene.SceneMovementReq) obj;

    boolean result = true;
    result = result && (hasMoveType() == other.hasMoveType());
    if (hasMoveType()) {
      result = result && moveType_ == other.moveType_;
    }
    result = result && (hasPos() == other.hasPos());
    if (hasPos()) {
      result = result && getPos()
          .equals(other.getPos());
    }
    result = result && (hasSpeed() == other.hasSpeed());
    if (hasSpeed()) {
      result = result && (
          java.lang.Float.floatToIntBits(getSpeed())
          == java.lang.Float.floatToIntBits(
              other.getSpeed()));
    }
    result = result && (hasDirection() == other.hasDirection());
    if (hasDirection()) {
      result = result && getDirection()
          .equals(other.getDirection());
    }
    result = result && unknownFields.equals(other.unknownFields);
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptorForType().hashCode();
    if (hasMoveType()) {
      hash = (37 * hash) + MOVETYPE_FIELD_NUMBER;
      hash = (53 * hash) + moveType_;
    }
    if (hasPos()) {
      hash = (37 * hash) + POS_FIELD_NUMBER;
      hash = (53 * hash) + getPos().hashCode();
    }
    if (hasSpeed()) {
      hash = (37 * hash) + SPEED_FIELD_NUMBER;
      hash = (53 * hash) + java.lang.Float.floatToIntBits(
          getSpeed());
    }
    if (hasDirection()) {
      hash = (37 * hash) + DIRECTION_FIELD_NUMBER;
      hash = (53 * hash) + getDirection().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.dj.protobuf.scene.SceneMovementReq parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dj.protobuf.scene.SceneMovementReq parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dj.protobuf.scene.SceneMovementReq parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dj.protobuf.scene.SceneMovementReq parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dj.protobuf.scene.SceneMovementReq parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.scene.SceneMovementReq parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.dj.protobuf.scene.SceneMovementReq parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.scene.SceneMovementReq parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.dj.protobuf.scene.SceneMovementReq parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.scene.SceneMovementReq parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(com.dj.protobuf.scene.SceneMovementReq prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code Protocols.SceneMovementReq}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:Protocols.SceneMovementReq)
      com.dj.protobuf.scene.SceneMovementReqOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.dj.protobuf.scene.Scene.internal_static_Protocols_SceneMovementReq_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.dj.protobuf.scene.Scene.internal_static_Protocols_SceneMovementReq_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.dj.protobuf.scene.SceneMovementReq.class, com.dj.protobuf.scene.SceneMovementReq.Builder.class);
    }

    // Construct using com.dj.protobuf.scene.SceneMovementReq.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
        getPosFieldBuilder();
        getDirectionFieldBuilder();
      }
    }
    public Builder clear() {
      super.clear();
      moveType_ = 1;
      bitField0_ = (bitField0_ & ~0x00000001);
      if (posBuilder_ == null) {
        pos_ = null;
      } else {
        posBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000002);
      speed_ = 0F;
      bitField0_ = (bitField0_ & ~0x00000004);
      if (directionBuilder_ == null) {
        direction_ = null;
      } else {
        directionBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000008);
      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.dj.protobuf.scene.Scene.internal_static_Protocols_SceneMovementReq_descriptor;
    }

    public com.dj.protobuf.scene.SceneMovementReq getDefaultInstanceForType() {
      return com.dj.protobuf.scene.SceneMovementReq.getDefaultInstance();
    }

    public com.dj.protobuf.scene.SceneMovementReq build() {
      com.dj.protobuf.scene.SceneMovementReq result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public com.dj.protobuf.scene.SceneMovementReq buildPartial() {
      com.dj.protobuf.scene.SceneMovementReq result = new com.dj.protobuf.scene.SceneMovementReq(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
        to_bitField0_ |= 0x00000001;
      }
      result.moveType_ = moveType_;
      if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
        to_bitField0_ |= 0x00000002;
      }
      if (posBuilder_ == null) {
        result.pos_ = pos_;
      } else {
        result.pos_ = posBuilder_.build();
      }
      if (((from_bitField0_ & 0x00000004) == 0x00000004)) {
        to_bitField0_ |= 0x00000004;
      }
      result.speed_ = speed_;
      if (((from_bitField0_ & 0x00000008) == 0x00000008)) {
        to_bitField0_ |= 0x00000008;
      }
      if (directionBuilder_ == null) {
        result.direction_ = direction_;
      } else {
        result.direction_ = directionBuilder_.build();
      }
      result.bitField0_ = to_bitField0_;
      onBuilt();
      return result;
    }

    public Builder clone() {
      return (Builder) super.clone();
    }
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return (Builder) super.setField(field, value);
    }
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.dj.protobuf.scene.SceneMovementReq) {
        return mergeFrom((com.dj.protobuf.scene.SceneMovementReq)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.dj.protobuf.scene.SceneMovementReq other) {
      if (other == com.dj.protobuf.scene.SceneMovementReq.getDefaultInstance()) return this;
      if (other.hasMoveType()) {
        setMoveType(other.getMoveType());
      }
      if (other.hasPos()) {
        mergePos(other.getPos());
      }
      if (other.hasSpeed()) {
        setSpeed(other.getSpeed());
      }
      if (other.hasDirection()) {
        mergeDirection(other.getDirection());
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    public final boolean isInitialized() {
      return true;
    }

    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      com.dj.protobuf.scene.SceneMovementReq parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.dj.protobuf.scene.SceneMovementReq) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private int moveType_ = 1;
    /**
     * <code>optional .Protocols.ESceneMoveType moveType = 1;</code>
     */
    public boolean hasMoveType() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <code>optional .Protocols.ESceneMoveType moveType = 1;</code>
     */
    public com.dj.protobuf.scene.ESceneMoveType getMoveType() {
      com.dj.protobuf.scene.ESceneMoveType result = com.dj.protobuf.scene.ESceneMoveType.valueOf(moveType_);
      return result == null ? com.dj.protobuf.scene.ESceneMoveType.Mov_Start : result;
    }
    /**
     * <code>optional .Protocols.ESceneMoveType moveType = 1;</code>
     */
    public Builder setMoveType(com.dj.protobuf.scene.ESceneMoveType value) {
      if (value == null) {
        throw new NullPointerException();
      }
      bitField0_ |= 0x00000001;
      moveType_ = value.getNumber();
      onChanged();
      return this;
    }
    /**
     * <code>optional .Protocols.ESceneMoveType moveType = 1;</code>
     */
    public Builder clearMoveType() {
      bitField0_ = (bitField0_ & ~0x00000001);
      moveType_ = 1;
      onChanged();
      return this;
    }

    private com.dj.protobuf.scene.OtomeVector3D pos_ = null;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.dj.protobuf.scene.OtomeVector3D, com.dj.protobuf.scene.OtomeVector3D.Builder, com.dj.protobuf.scene.OtomeVector3DOrBuilder> posBuilder_;
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / ????????????
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional .Protocols.OtomeVector3D pos = 2;</code>
     */
    public boolean hasPos() {
      return ((bitField0_ & 0x00000002) == 0x00000002);
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / ????????????
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional .Protocols.OtomeVector3D pos = 2;</code>
     */
    public com.dj.protobuf.scene.OtomeVector3D getPos() {
      if (posBuilder_ == null) {
        return pos_ == null ? com.dj.protobuf.scene.OtomeVector3D.getDefaultInstance() : pos_;
      } else {
        return posBuilder_.getMessage();
      }
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / ????????????
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional .Protocols.OtomeVector3D pos = 2;</code>
     */
    public Builder setPos(com.dj.protobuf.scene.OtomeVector3D value) {
      if (posBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        pos_ = value;
        onChanged();
      } else {
        posBuilder_.setMessage(value);
      }
      bitField0_ |= 0x00000002;
      return this;
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / ????????????
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional .Protocols.OtomeVector3D pos = 2;</code>
     */
    public Builder setPos(
        com.dj.protobuf.scene.OtomeVector3D.Builder builderForValue) {
      if (posBuilder_ == null) {
        pos_ = builderForValue.build();
        onChanged();
      } else {
        posBuilder_.setMessage(builderForValue.build());
      }
      bitField0_ |= 0x00000002;
      return this;
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / ????????????
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional .Protocols.OtomeVector3D pos = 2;</code>
     */
    public Builder mergePos(com.dj.protobuf.scene.OtomeVector3D value) {
      if (posBuilder_ == null) {
        if (((bitField0_ & 0x00000002) == 0x00000002) &&
            pos_ != null &&
            pos_ != com.dj.protobuf.scene.OtomeVector3D.getDefaultInstance()) {
          pos_ =
            com.dj.protobuf.scene.OtomeVector3D.newBuilder(pos_).mergeFrom(value).buildPartial();
        } else {
          pos_ = value;
        }
        onChanged();
      } else {
        posBuilder_.mergeFrom(value);
      }
      bitField0_ |= 0x00000002;
      return this;
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / ????????????
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional .Protocols.OtomeVector3D pos = 2;</code>
     */
    public Builder clearPos() {
      if (posBuilder_ == null) {
        pos_ = null;
        onChanged();
      } else {
        posBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000002);
      return this;
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / ????????????
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional .Protocols.OtomeVector3D pos = 2;</code>
     */
    public com.dj.protobuf.scene.OtomeVector3D.Builder getPosBuilder() {
      bitField0_ |= 0x00000002;
      onChanged();
      return getPosFieldBuilder().getBuilder();
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / ????????????
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional .Protocols.OtomeVector3D pos = 2;</code>
     */
    public com.dj.protobuf.scene.OtomeVector3DOrBuilder getPosOrBuilder() {
      if (posBuilder_ != null) {
        return posBuilder_.getMessageOrBuilder();
      } else {
        return pos_ == null ?
            com.dj.protobuf.scene.OtomeVector3D.getDefaultInstance() : pos_;
      }
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / ????????????
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional .Protocols.OtomeVector3D pos = 2;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.dj.protobuf.scene.OtomeVector3D, com.dj.protobuf.scene.OtomeVector3D.Builder, com.dj.protobuf.scene.OtomeVector3DOrBuilder> 
        getPosFieldBuilder() {
      if (posBuilder_ == null) {
        posBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.dj.protobuf.scene.OtomeVector3D, com.dj.protobuf.scene.OtomeVector3D.Builder, com.dj.protobuf.scene.OtomeVector3DOrBuilder>(
                getPos(),
                getParentForChildren(),
                isClean());
        pos_ = null;
      }
      return posBuilder_;
    }

    private float speed_ ;
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / ??????
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional float speed = 3;</code>
     */
    public boolean hasSpeed() {
      return ((bitField0_ & 0x00000004) == 0x00000004);
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / ??????
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional float speed = 3;</code>
     */
    public float getSpeed() {
      return speed_;
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / ??????
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional float speed = 3;</code>
     */
    public Builder setSpeed(float value) {
      bitField0_ |= 0x00000004;
      speed_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / ??????
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional float speed = 3;</code>
     */
    public Builder clearSpeed() {
      bitField0_ = (bitField0_ & ~0x00000004);
      speed_ = 0F;
      onChanged();
      return this;
    }

    private com.dj.protobuf.scene.OtomeVector3D direction_ = null;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.dj.protobuf.scene.OtomeVector3D, com.dj.protobuf.scene.OtomeVector3D.Builder, com.dj.protobuf.scene.OtomeVector3DOrBuilder> directionBuilder_;
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / ??????
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional .Protocols.OtomeVector3D direction = 4;</code>
     */
    public boolean hasDirection() {
      return ((bitField0_ & 0x00000008) == 0x00000008);
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / ??????
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional .Protocols.OtomeVector3D direction = 4;</code>
     */
    public com.dj.protobuf.scene.OtomeVector3D getDirection() {
      if (directionBuilder_ == null) {
        return direction_ == null ? com.dj.protobuf.scene.OtomeVector3D.getDefaultInstance() : direction_;
      } else {
        return directionBuilder_.getMessage();
      }
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / ??????
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional .Protocols.OtomeVector3D direction = 4;</code>
     */
    public Builder setDirection(com.dj.protobuf.scene.OtomeVector3D value) {
      if (directionBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        direction_ = value;
        onChanged();
      } else {
        directionBuilder_.setMessage(value);
      }
      bitField0_ |= 0x00000008;
      return this;
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / ??????
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional .Protocols.OtomeVector3D direction = 4;</code>
     */
    public Builder setDirection(
        com.dj.protobuf.scene.OtomeVector3D.Builder builderForValue) {
      if (directionBuilder_ == null) {
        direction_ = builderForValue.build();
        onChanged();
      } else {
        directionBuilder_.setMessage(builderForValue.build());
      }
      bitField0_ |= 0x00000008;
      return this;
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / ??????
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional .Protocols.OtomeVector3D direction = 4;</code>
     */
    public Builder mergeDirection(com.dj.protobuf.scene.OtomeVector3D value) {
      if (directionBuilder_ == null) {
        if (((bitField0_ & 0x00000008) == 0x00000008) &&
            direction_ != null &&
            direction_ != com.dj.protobuf.scene.OtomeVector3D.getDefaultInstance()) {
          direction_ =
            com.dj.protobuf.scene.OtomeVector3D.newBuilder(direction_).mergeFrom(value).buildPartial();
        } else {
          direction_ = value;
        }
        onChanged();
      } else {
        directionBuilder_.mergeFrom(value);
      }
      bitField0_ |= 0x00000008;
      return this;
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / ??????
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional .Protocols.OtomeVector3D direction = 4;</code>
     */
    public Builder clearDirection() {
      if (directionBuilder_ == null) {
        direction_ = null;
        onChanged();
      } else {
        directionBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000008);
      return this;
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / ??????
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional .Protocols.OtomeVector3D direction = 4;</code>
     */
    public com.dj.protobuf.scene.OtomeVector3D.Builder getDirectionBuilder() {
      bitField0_ |= 0x00000008;
      onChanged();
      return getDirectionFieldBuilder().getBuilder();
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / ??????
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional .Protocols.OtomeVector3D direction = 4;</code>
     */
    public com.dj.protobuf.scene.OtomeVector3DOrBuilder getDirectionOrBuilder() {
      if (directionBuilder_ != null) {
        return directionBuilder_.getMessageOrBuilder();
      } else {
        return direction_ == null ?
            com.dj.protobuf.scene.OtomeVector3D.getDefaultInstance() : direction_;
      }
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / ??????
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional .Protocols.OtomeVector3D direction = 4;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.dj.protobuf.scene.OtomeVector3D, com.dj.protobuf.scene.OtomeVector3D.Builder, com.dj.protobuf.scene.OtomeVector3DOrBuilder> 
        getDirectionFieldBuilder() {
      if (directionBuilder_ == null) {
        directionBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.dj.protobuf.scene.OtomeVector3D, com.dj.protobuf.scene.OtomeVector3D.Builder, com.dj.protobuf.scene.OtomeVector3DOrBuilder>(
                getDirection(),
                getParentForChildren(),
                isClean());
        direction_ = null;
      }
      return directionBuilder_;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:Protocols.SceneMovementReq)
  }

  // @@protoc_insertion_point(class_scope:Protocols.SceneMovementReq)
  private static final com.dj.protobuf.scene.SceneMovementReq DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.dj.protobuf.scene.SceneMovementReq();
  }

  public static com.dj.protobuf.scene.SceneMovementReq getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  @java.lang.Deprecated public static final com.google.protobuf.Parser<SceneMovementReq>
      PARSER = new com.google.protobuf.AbstractParser<SceneMovementReq>() {
    public SceneMovementReq parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new SceneMovementReq(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<SceneMovementReq> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<SceneMovementReq> getParserForType() {
    return PARSER;
  }

  public com.dj.protobuf.scene.SceneMovementReq getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

