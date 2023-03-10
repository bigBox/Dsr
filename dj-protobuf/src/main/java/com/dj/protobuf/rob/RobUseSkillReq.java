// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Rob.proto

package com.dj.protobuf.rob;

/**
 * Protobuf type {@code Protocols.RobUseSkillReq}
 */
public  final class RobUseSkillReq extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:Protocols.RobUseSkillReq)
    RobUseSkillReqOrBuilder {
  // Use RobUseSkillReq.newBuilder() to construct.
  private RobUseSkillReq(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private RobUseSkillReq() {
    skillId_ = 0;
    targetX_ = 0;
    targetY_ = 0;
    robFlag_ = false;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private RobUseSkillReq(
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
            bitField0_ |= 0x00000001;
            skillId_ = input.readInt32();
            break;
          }
          case 16: {
            bitField0_ |= 0x00000002;
            targetX_ = input.readInt32();
            break;
          }
          case 24: {
            bitField0_ |= 0x00000004;
            targetY_ = input.readInt32();
            break;
          }
          case 32: {
            bitField0_ |= 0x00000008;
            robFlag_ = input.readBool();
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
    return com.dj.protobuf.rob.Rob.internal_static_Protocols_RobUseSkillReq_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.dj.protobuf.rob.Rob.internal_static_Protocols_RobUseSkillReq_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.dj.protobuf.rob.RobUseSkillReq.class, com.dj.protobuf.rob.RobUseSkillReq.Builder.class);
  }

  private int bitField0_;
  public static final int SKILLID_FIELD_NUMBER = 1;
  private int skillId_;
  /**
   * <code>optional int32 skillId = 1;</code>
   */
  public boolean hasSkillId() {
    return ((bitField0_ & 0x00000001) == 0x00000001);
  }
  /**
   * <code>optional int32 skillId = 1;</code>
   */
  public int getSkillId() {
    return skillId_;
  }

  public static final int TARGETX_FIELD_NUMBER = 2;
  private int targetX_;
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / ????????????
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional int32 targetX = 2;</code>
   */
  public boolean hasTargetX() {
    return ((bitField0_ & 0x00000002) == 0x00000002);
  }
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / ????????????
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional int32 targetX = 2;</code>
   */
  public int getTargetX() {
    return targetX_;
  }

  public static final int TARGETY_FIELD_NUMBER = 3;
  private int targetY_;
  /**
   * <code>optional int32 targetY = 3;</code>
   */
  public boolean hasTargetY() {
    return ((bitField0_ & 0x00000004) == 0x00000004);
  }
  /**
   * <code>optional int32 targetY = 3;</code>
   */
  public int getTargetY() {
    return targetY_;
  }

  public static final int ROBFLAG_FIELD_NUMBER = 4;
  private boolean robFlag_;
  /**
   * <pre>
   * false:?????????????????????????????????,  true:????????????????????????????????????????????????
   * </pre>
   *
   * <code>optional bool robFlag = 4;</code>
   */
  public boolean hasRobFlag() {
    return ((bitField0_ & 0x00000008) == 0x00000008);
  }
  /**
   * <pre>
   * false:?????????????????????????????????,  true:????????????????????????????????????????????????
   * </pre>
   *
   * <code>optional bool robFlag = 4;</code>
   */
  public boolean getRobFlag() {
    return robFlag_;
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
      output.writeInt32(1, skillId_);
    }
    if (((bitField0_ & 0x00000002) == 0x00000002)) {
      output.writeInt32(2, targetX_);
    }
    if (((bitField0_ & 0x00000004) == 0x00000004)) {
      output.writeInt32(3, targetY_);
    }
    if (((bitField0_ & 0x00000008) == 0x00000008)) {
      output.writeBool(4, robFlag_);
    }
    unknownFields.writeTo(output);
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (((bitField0_ & 0x00000001) == 0x00000001)) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(1, skillId_);
    }
    if (((bitField0_ & 0x00000002) == 0x00000002)) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(2, targetX_);
    }
    if (((bitField0_ & 0x00000004) == 0x00000004)) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(3, targetY_);
    }
    if (((bitField0_ & 0x00000008) == 0x00000008)) {
      size += com.google.protobuf.CodedOutputStream
        .computeBoolSize(4, robFlag_);
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
    if (!(obj instanceof com.dj.protobuf.rob.RobUseSkillReq)) {
      return super.equals(obj);
    }
    com.dj.protobuf.rob.RobUseSkillReq other = (com.dj.protobuf.rob.RobUseSkillReq) obj;

    boolean result = true;
    result = result && (hasSkillId() == other.hasSkillId());
    if (hasSkillId()) {
      result = result && (getSkillId()
          == other.getSkillId());
    }
    result = result && (hasTargetX() == other.hasTargetX());
    if (hasTargetX()) {
      result = result && (getTargetX()
          == other.getTargetX());
    }
    result = result && (hasTargetY() == other.hasTargetY());
    if (hasTargetY()) {
      result = result && (getTargetY()
          == other.getTargetY());
    }
    result = result && (hasRobFlag() == other.hasRobFlag());
    if (hasRobFlag()) {
      result = result && (getRobFlag()
          == other.getRobFlag());
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
    if (hasSkillId()) {
      hash = (37 * hash) + SKILLID_FIELD_NUMBER;
      hash = (53 * hash) + getSkillId();
    }
    if (hasTargetX()) {
      hash = (37 * hash) + TARGETX_FIELD_NUMBER;
      hash = (53 * hash) + getTargetX();
    }
    if (hasTargetY()) {
      hash = (37 * hash) + TARGETY_FIELD_NUMBER;
      hash = (53 * hash) + getTargetY();
    }
    if (hasRobFlag()) {
      hash = (37 * hash) + ROBFLAG_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
          getRobFlag());
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.dj.protobuf.rob.RobUseSkillReq parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dj.protobuf.rob.RobUseSkillReq parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dj.protobuf.rob.RobUseSkillReq parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dj.protobuf.rob.RobUseSkillReq parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dj.protobuf.rob.RobUseSkillReq parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.rob.RobUseSkillReq parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.dj.protobuf.rob.RobUseSkillReq parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.rob.RobUseSkillReq parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.dj.protobuf.rob.RobUseSkillReq parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.rob.RobUseSkillReq parseFrom(
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
  public static Builder newBuilder(com.dj.protobuf.rob.RobUseSkillReq prototype) {
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
   * Protobuf type {@code Protocols.RobUseSkillReq}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:Protocols.RobUseSkillReq)
      com.dj.protobuf.rob.RobUseSkillReqOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.dj.protobuf.rob.Rob.internal_static_Protocols_RobUseSkillReq_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.dj.protobuf.rob.Rob.internal_static_Protocols_RobUseSkillReq_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.dj.protobuf.rob.RobUseSkillReq.class, com.dj.protobuf.rob.RobUseSkillReq.Builder.class);
    }

    // Construct using com.dj.protobuf.rob.RobUseSkillReq.newBuilder()
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
      }
    }
    public Builder clear() {
      super.clear();
      skillId_ = 0;
      bitField0_ = (bitField0_ & ~0x00000001);
      targetX_ = 0;
      bitField0_ = (bitField0_ & ~0x00000002);
      targetY_ = 0;
      bitField0_ = (bitField0_ & ~0x00000004);
      robFlag_ = false;
      bitField0_ = (bitField0_ & ~0x00000008);
      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.dj.protobuf.rob.Rob.internal_static_Protocols_RobUseSkillReq_descriptor;
    }

    public com.dj.protobuf.rob.RobUseSkillReq getDefaultInstanceForType() {
      return com.dj.protobuf.rob.RobUseSkillReq.getDefaultInstance();
    }

    public com.dj.protobuf.rob.RobUseSkillReq build() {
      com.dj.protobuf.rob.RobUseSkillReq result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public com.dj.protobuf.rob.RobUseSkillReq buildPartial() {
      com.dj.protobuf.rob.RobUseSkillReq result = new com.dj.protobuf.rob.RobUseSkillReq(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
        to_bitField0_ |= 0x00000001;
      }
      result.skillId_ = skillId_;
      if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
        to_bitField0_ |= 0x00000002;
      }
      result.targetX_ = targetX_;
      if (((from_bitField0_ & 0x00000004) == 0x00000004)) {
        to_bitField0_ |= 0x00000004;
      }
      result.targetY_ = targetY_;
      if (((from_bitField0_ & 0x00000008) == 0x00000008)) {
        to_bitField0_ |= 0x00000008;
      }
      result.robFlag_ = robFlag_;
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
      if (other instanceof com.dj.protobuf.rob.RobUseSkillReq) {
        return mergeFrom((com.dj.protobuf.rob.RobUseSkillReq)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.dj.protobuf.rob.RobUseSkillReq other) {
      if (other == com.dj.protobuf.rob.RobUseSkillReq.getDefaultInstance()) return this;
      if (other.hasSkillId()) {
        setSkillId(other.getSkillId());
      }
      if (other.hasTargetX()) {
        setTargetX(other.getTargetX());
      }
      if (other.hasTargetY()) {
        setTargetY(other.getTargetY());
      }
      if (other.hasRobFlag()) {
        setRobFlag(other.getRobFlag());
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
      com.dj.protobuf.rob.RobUseSkillReq parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.dj.protobuf.rob.RobUseSkillReq) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private int skillId_ ;
    /**
     * <code>optional int32 skillId = 1;</code>
     */
    public boolean hasSkillId() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <code>optional int32 skillId = 1;</code>
     */
    public int getSkillId() {
      return skillId_;
    }
    /**
     * <code>optional int32 skillId = 1;</code>
     */
    public Builder setSkillId(int value) {
      bitField0_ |= 0x00000001;
      skillId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional int32 skillId = 1;</code>
     */
    public Builder clearSkillId() {
      bitField0_ = (bitField0_ & ~0x00000001);
      skillId_ = 0;
      onChanged();
      return this;
    }

    private int targetX_ ;
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / ????????????
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional int32 targetX = 2;</code>
     */
    public boolean hasTargetX() {
      return ((bitField0_ & 0x00000002) == 0x00000002);
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / ????????????
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional int32 targetX = 2;</code>
     */
    public int getTargetX() {
      return targetX_;
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / ????????????
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional int32 targetX = 2;</code>
     */
    public Builder setTargetX(int value) {
      bitField0_ |= 0x00000002;
      targetX_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / ????????????
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional int32 targetX = 2;</code>
     */
    public Builder clearTargetX() {
      bitField0_ = (bitField0_ & ~0x00000002);
      targetX_ = 0;
      onChanged();
      return this;
    }

    private int targetY_ ;
    /**
     * <code>optional int32 targetY = 3;</code>
     */
    public boolean hasTargetY() {
      return ((bitField0_ & 0x00000004) == 0x00000004);
    }
    /**
     * <code>optional int32 targetY = 3;</code>
     */
    public int getTargetY() {
      return targetY_;
    }
    /**
     * <code>optional int32 targetY = 3;</code>
     */
    public Builder setTargetY(int value) {
      bitField0_ |= 0x00000004;
      targetY_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional int32 targetY = 3;</code>
     */
    public Builder clearTargetY() {
      bitField0_ = (bitField0_ & ~0x00000004);
      targetY_ = 0;
      onChanged();
      return this;
    }

    private boolean robFlag_ ;
    /**
     * <pre>
     * false:?????????????????????????????????,  true:????????????????????????????????????????????????
     * </pre>
     *
     * <code>optional bool robFlag = 4;</code>
     */
    public boolean hasRobFlag() {
      return ((bitField0_ & 0x00000008) == 0x00000008);
    }
    /**
     * <pre>
     * false:?????????????????????????????????,  true:????????????????????????????????????????????????
     * </pre>
     *
     * <code>optional bool robFlag = 4;</code>
     */
    public boolean getRobFlag() {
      return robFlag_;
    }
    /**
     * <pre>
     * false:?????????????????????????????????,  true:????????????????????????????????????????????????
     * </pre>
     *
     * <code>optional bool robFlag = 4;</code>
     */
    public Builder setRobFlag(boolean value) {
      bitField0_ |= 0x00000008;
      robFlag_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * false:?????????????????????????????????,  true:????????????????????????????????????????????????
     * </pre>
     *
     * <code>optional bool robFlag = 4;</code>
     */
    public Builder clearRobFlag() {
      bitField0_ = (bitField0_ & ~0x00000008);
      robFlag_ = false;
      onChanged();
      return this;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:Protocols.RobUseSkillReq)
  }

  // @@protoc_insertion_point(class_scope:Protocols.RobUseSkillReq)
  private static final com.dj.protobuf.rob.RobUseSkillReq DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.dj.protobuf.rob.RobUseSkillReq();
  }

  public static com.dj.protobuf.rob.RobUseSkillReq getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  @java.lang.Deprecated public static final com.google.protobuf.Parser<RobUseSkillReq>
      PARSER = new com.google.protobuf.AbstractParser<RobUseSkillReq>() {
    public RobUseSkillReq parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new RobUseSkillReq(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<RobUseSkillReq> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<RobUseSkillReq> getParserForType() {
    return PARSER;
  }

  public com.dj.protobuf.rob.RobUseSkillReq getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

