// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Scene.proto

package com.dj.protobuf.scene;

/**
 * Protobuf type {@code Protocols.SceneDetailInfo}
 */
public  final class SceneDetailInfo extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:Protocols.SceneDetailInfo)
    SceneDetailInfoOrBuilder {
  // Use SceneDetailInfo.newBuilder() to construct.
  private SceneDetailInfo(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private SceneDetailInfo() {
    attenders_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private SceneDetailInfo(
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
          case 10: {
            com.dj.protobuf.scene.SceneBriefInfo.Builder subBuilder = null;
            if (((bitField0_ & 0x00000001) == 0x00000001)) {
              subBuilder = briefInfo_.toBuilder();
            }
            briefInfo_ = input.readMessage(com.dj.protobuf.scene.SceneBriefInfo.PARSER, extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(briefInfo_);
              briefInfo_ = subBuilder.buildPartial();
            }
            bitField0_ |= 0x00000001;
            break;
          }
          case 18: {
            if (!((mutable_bitField0_ & 0x00000002) == 0x00000002)) {
              attenders_ = new java.util.ArrayList<com.dj.protobuf.scene.SceneRoleInfo>();
              mutable_bitField0_ |= 0x00000002;
            }
            attenders_.add(
                input.readMessage(com.dj.protobuf.scene.SceneRoleInfo.PARSER, extensionRegistry));
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
      if (((mutable_bitField0_ & 0x00000002) == 0x00000002)) {
        attenders_ = java.util.Collections.unmodifiableList(attenders_);
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.dj.protobuf.scene.Scene.internal_static_Protocols_SceneDetailInfo_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.dj.protobuf.scene.Scene.internal_static_Protocols_SceneDetailInfo_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.dj.protobuf.scene.SceneDetailInfo.class, com.dj.protobuf.scene.SceneDetailInfo.Builder.class);
  }

  private int bitField0_;
  public static final int BRIEFINFO_FIELD_NUMBER = 1;
  private com.dj.protobuf.scene.SceneBriefInfo briefInfo_;
  /**
   * <code>optional .Protocols.SceneBriefInfo briefInfo = 1;</code>
   */
  public boolean hasBriefInfo() {
    return ((bitField0_ & 0x00000001) == 0x00000001);
  }
  /**
   * <code>optional .Protocols.SceneBriefInfo briefInfo = 1;</code>
   */
  public com.dj.protobuf.scene.SceneBriefInfo getBriefInfo() {
    return briefInfo_ == null ? com.dj.protobuf.scene.SceneBriefInfo.getDefaultInstance() : briefInfo_;
  }
  /**
   * <code>optional .Protocols.SceneBriefInfo briefInfo = 1;</code>
   */
  public com.dj.protobuf.scene.SceneBriefInfoOrBuilder getBriefInfoOrBuilder() {
    return briefInfo_ == null ? com.dj.protobuf.scene.SceneBriefInfo.getDefaultInstance() : briefInfo_;
  }

  public static final int ATTENDERS_FIELD_NUMBER = 2;
  private java.util.List<com.dj.protobuf.scene.SceneRoleInfo> attenders_;
  /**
   * <code>repeated .Protocols.SceneRoleInfo attenders = 2;</code>
   */
  public java.util.List<com.dj.protobuf.scene.SceneRoleInfo> getAttendersList() {
    return attenders_;
  }
  /**
   * <code>repeated .Protocols.SceneRoleInfo attenders = 2;</code>
   */
  public java.util.List<? extends com.dj.protobuf.scene.SceneRoleInfoOrBuilder> 
      getAttendersOrBuilderList() {
    return attenders_;
  }
  /**
   * <code>repeated .Protocols.SceneRoleInfo attenders = 2;</code>
   */
  public int getAttendersCount() {
    return attenders_.size();
  }
  /**
   * <code>repeated .Protocols.SceneRoleInfo attenders = 2;</code>
   */
  public com.dj.protobuf.scene.SceneRoleInfo getAttenders(int index) {
    return attenders_.get(index);
  }
  /**
   * <code>repeated .Protocols.SceneRoleInfo attenders = 2;</code>
   */
  public com.dj.protobuf.scene.SceneRoleInfoOrBuilder getAttendersOrBuilder(
      int index) {
    return attenders_.get(index);
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
      output.writeMessage(1, getBriefInfo());
    }
    for (int i = 0; i < attenders_.size(); i++) {
      output.writeMessage(2, attenders_.get(i));
    }
    unknownFields.writeTo(output);
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (((bitField0_ & 0x00000001) == 0x00000001)) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, getBriefInfo());
    }
    for (int i = 0; i < attenders_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(2, attenders_.get(i));
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
    if (!(obj instanceof com.dj.protobuf.scene.SceneDetailInfo)) {
      return super.equals(obj);
    }
    com.dj.protobuf.scene.SceneDetailInfo other = (com.dj.protobuf.scene.SceneDetailInfo) obj;

    boolean result = true;
    result = result && (hasBriefInfo() == other.hasBriefInfo());
    if (hasBriefInfo()) {
      result = result && getBriefInfo()
          .equals(other.getBriefInfo());
    }
    result = result && getAttendersList()
        .equals(other.getAttendersList());
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
    if (hasBriefInfo()) {
      hash = (37 * hash) + BRIEFINFO_FIELD_NUMBER;
      hash = (53 * hash) + getBriefInfo().hashCode();
    }
    if (getAttendersCount() > 0) {
      hash = (37 * hash) + ATTENDERS_FIELD_NUMBER;
      hash = (53 * hash) + getAttendersList().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.dj.protobuf.scene.SceneDetailInfo parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dj.protobuf.scene.SceneDetailInfo parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dj.protobuf.scene.SceneDetailInfo parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dj.protobuf.scene.SceneDetailInfo parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dj.protobuf.scene.SceneDetailInfo parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.scene.SceneDetailInfo parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.dj.protobuf.scene.SceneDetailInfo parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.scene.SceneDetailInfo parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.dj.protobuf.scene.SceneDetailInfo parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.scene.SceneDetailInfo parseFrom(
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
  public static Builder newBuilder(com.dj.protobuf.scene.SceneDetailInfo prototype) {
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
   * Protobuf type {@code Protocols.SceneDetailInfo}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:Protocols.SceneDetailInfo)
      com.dj.protobuf.scene.SceneDetailInfoOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.dj.protobuf.scene.Scene.internal_static_Protocols_SceneDetailInfo_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.dj.protobuf.scene.Scene.internal_static_Protocols_SceneDetailInfo_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.dj.protobuf.scene.SceneDetailInfo.class, com.dj.protobuf.scene.SceneDetailInfo.Builder.class);
    }

    // Construct using com.dj.protobuf.scene.SceneDetailInfo.newBuilder()
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
        getBriefInfoFieldBuilder();
        getAttendersFieldBuilder();
      }
    }
    public Builder clear() {
      super.clear();
      if (briefInfoBuilder_ == null) {
        briefInfo_ = null;
      } else {
        briefInfoBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000001);
      if (attendersBuilder_ == null) {
        attenders_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000002);
      } else {
        attendersBuilder_.clear();
      }
      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.dj.protobuf.scene.Scene.internal_static_Protocols_SceneDetailInfo_descriptor;
    }

    public com.dj.protobuf.scene.SceneDetailInfo getDefaultInstanceForType() {
      return com.dj.protobuf.scene.SceneDetailInfo.getDefaultInstance();
    }

    public com.dj.protobuf.scene.SceneDetailInfo build() {
      com.dj.protobuf.scene.SceneDetailInfo result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public com.dj.protobuf.scene.SceneDetailInfo buildPartial() {
      com.dj.protobuf.scene.SceneDetailInfo result = new com.dj.protobuf.scene.SceneDetailInfo(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
        to_bitField0_ |= 0x00000001;
      }
      if (briefInfoBuilder_ == null) {
        result.briefInfo_ = briefInfo_;
      } else {
        result.briefInfo_ = briefInfoBuilder_.build();
      }
      if (attendersBuilder_ == null) {
        if (((bitField0_ & 0x00000002) == 0x00000002)) {
          attenders_ = java.util.Collections.unmodifiableList(attenders_);
          bitField0_ = (bitField0_ & ~0x00000002);
        }
        result.attenders_ = attenders_;
      } else {
        result.attenders_ = attendersBuilder_.build();
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
      if (other instanceof com.dj.protobuf.scene.SceneDetailInfo) {
        return mergeFrom((com.dj.protobuf.scene.SceneDetailInfo)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.dj.protobuf.scene.SceneDetailInfo other) {
      if (other == com.dj.protobuf.scene.SceneDetailInfo.getDefaultInstance()) return this;
      if (other.hasBriefInfo()) {
        mergeBriefInfo(other.getBriefInfo());
      }
      if (attendersBuilder_ == null) {
        if (!other.attenders_.isEmpty()) {
          if (attenders_.isEmpty()) {
            attenders_ = other.attenders_;
            bitField0_ = (bitField0_ & ~0x00000002);
          } else {
            ensureAttendersIsMutable();
            attenders_.addAll(other.attenders_);
          }
          onChanged();
        }
      } else {
        if (!other.attenders_.isEmpty()) {
          if (attendersBuilder_.isEmpty()) {
            attendersBuilder_.dispose();
            attendersBuilder_ = null;
            attenders_ = other.attenders_;
            bitField0_ = (bitField0_ & ~0x00000002);
            attendersBuilder_ = 
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getAttendersFieldBuilder() : null;
          } else {
            attendersBuilder_.addAllMessages(other.attenders_);
          }
        }
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
      com.dj.protobuf.scene.SceneDetailInfo parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.dj.protobuf.scene.SceneDetailInfo) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private com.dj.protobuf.scene.SceneBriefInfo briefInfo_ = null;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.dj.protobuf.scene.SceneBriefInfo, com.dj.protobuf.scene.SceneBriefInfo.Builder, com.dj.protobuf.scene.SceneBriefInfoOrBuilder> briefInfoBuilder_;
    /**
     * <code>optional .Protocols.SceneBriefInfo briefInfo = 1;</code>
     */
    public boolean hasBriefInfo() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <code>optional .Protocols.SceneBriefInfo briefInfo = 1;</code>
     */
    public com.dj.protobuf.scene.SceneBriefInfo getBriefInfo() {
      if (briefInfoBuilder_ == null) {
        return briefInfo_ == null ? com.dj.protobuf.scene.SceneBriefInfo.getDefaultInstance() : briefInfo_;
      } else {
        return briefInfoBuilder_.getMessage();
      }
    }
    /**
     * <code>optional .Protocols.SceneBriefInfo briefInfo = 1;</code>
     */
    public Builder setBriefInfo(com.dj.protobuf.scene.SceneBriefInfo value) {
      if (briefInfoBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        briefInfo_ = value;
        onChanged();
      } else {
        briefInfoBuilder_.setMessage(value);
      }
      bitField0_ |= 0x00000001;
      return this;
    }
    /**
     * <code>optional .Protocols.SceneBriefInfo briefInfo = 1;</code>
     */
    public Builder setBriefInfo(
        com.dj.protobuf.scene.SceneBriefInfo.Builder builderForValue) {
      if (briefInfoBuilder_ == null) {
        briefInfo_ = builderForValue.build();
        onChanged();
      } else {
        briefInfoBuilder_.setMessage(builderForValue.build());
      }
      bitField0_ |= 0x00000001;
      return this;
    }
    /**
     * <code>optional .Protocols.SceneBriefInfo briefInfo = 1;</code>
     */
    public Builder mergeBriefInfo(com.dj.protobuf.scene.SceneBriefInfo value) {
      if (briefInfoBuilder_ == null) {
        if (((bitField0_ & 0x00000001) == 0x00000001) &&
            briefInfo_ != null &&
            briefInfo_ != com.dj.protobuf.scene.SceneBriefInfo.getDefaultInstance()) {
          briefInfo_ =
            com.dj.protobuf.scene.SceneBriefInfo.newBuilder(briefInfo_).mergeFrom(value).buildPartial();
        } else {
          briefInfo_ = value;
        }
        onChanged();
      } else {
        briefInfoBuilder_.mergeFrom(value);
      }
      bitField0_ |= 0x00000001;
      return this;
    }
    /**
     * <code>optional .Protocols.SceneBriefInfo briefInfo = 1;</code>
     */
    public Builder clearBriefInfo() {
      if (briefInfoBuilder_ == null) {
        briefInfo_ = null;
        onChanged();
      } else {
        briefInfoBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000001);
      return this;
    }
    /**
     * <code>optional .Protocols.SceneBriefInfo briefInfo = 1;</code>
     */
    public com.dj.protobuf.scene.SceneBriefInfo.Builder getBriefInfoBuilder() {
      bitField0_ |= 0x00000001;
      onChanged();
      return getBriefInfoFieldBuilder().getBuilder();
    }
    /**
     * <code>optional .Protocols.SceneBriefInfo briefInfo = 1;</code>
     */
    public com.dj.protobuf.scene.SceneBriefInfoOrBuilder getBriefInfoOrBuilder() {
      if (briefInfoBuilder_ != null) {
        return briefInfoBuilder_.getMessageOrBuilder();
      } else {
        return briefInfo_ == null ?
            com.dj.protobuf.scene.SceneBriefInfo.getDefaultInstance() : briefInfo_;
      }
    }
    /**
     * <code>optional .Protocols.SceneBriefInfo briefInfo = 1;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.dj.protobuf.scene.SceneBriefInfo, com.dj.protobuf.scene.SceneBriefInfo.Builder, com.dj.protobuf.scene.SceneBriefInfoOrBuilder> 
        getBriefInfoFieldBuilder() {
      if (briefInfoBuilder_ == null) {
        briefInfoBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.dj.protobuf.scene.SceneBriefInfo, com.dj.protobuf.scene.SceneBriefInfo.Builder, com.dj.protobuf.scene.SceneBriefInfoOrBuilder>(
                getBriefInfo(),
                getParentForChildren(),
                isClean());
        briefInfo_ = null;
      }
      return briefInfoBuilder_;
    }

    private java.util.List<com.dj.protobuf.scene.SceneRoleInfo> attenders_ =
      java.util.Collections.emptyList();
    private void ensureAttendersIsMutable() {
      if (!((bitField0_ & 0x00000002) == 0x00000002)) {
        attenders_ = new java.util.ArrayList<com.dj.protobuf.scene.SceneRoleInfo>(attenders_);
        bitField0_ |= 0x00000002;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        com.dj.protobuf.scene.SceneRoleInfo, com.dj.protobuf.scene.SceneRoleInfo.Builder, com.dj.protobuf.scene.SceneRoleInfoOrBuilder> attendersBuilder_;

    /**
     * <code>repeated .Protocols.SceneRoleInfo attenders = 2;</code>
     */
    public java.util.List<com.dj.protobuf.scene.SceneRoleInfo> getAttendersList() {
      if (attendersBuilder_ == null) {
        return java.util.Collections.unmodifiableList(attenders_);
      } else {
        return attendersBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .Protocols.SceneRoleInfo attenders = 2;</code>
     */
    public int getAttendersCount() {
      if (attendersBuilder_ == null) {
        return attenders_.size();
      } else {
        return attendersBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .Protocols.SceneRoleInfo attenders = 2;</code>
     */
    public com.dj.protobuf.scene.SceneRoleInfo getAttenders(int index) {
      if (attendersBuilder_ == null) {
        return attenders_.get(index);
      } else {
        return attendersBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .Protocols.SceneRoleInfo attenders = 2;</code>
     */
    public Builder setAttenders(
        int index, com.dj.protobuf.scene.SceneRoleInfo value) {
      if (attendersBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureAttendersIsMutable();
        attenders_.set(index, value);
        onChanged();
      } else {
        attendersBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .Protocols.SceneRoleInfo attenders = 2;</code>
     */
    public Builder setAttenders(
        int index, com.dj.protobuf.scene.SceneRoleInfo.Builder builderForValue) {
      if (attendersBuilder_ == null) {
        ensureAttendersIsMutable();
        attenders_.set(index, builderForValue.build());
        onChanged();
      } else {
        attendersBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .Protocols.SceneRoleInfo attenders = 2;</code>
     */
    public Builder addAttenders(com.dj.protobuf.scene.SceneRoleInfo value) {
      if (attendersBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureAttendersIsMutable();
        attenders_.add(value);
        onChanged();
      } else {
        attendersBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .Protocols.SceneRoleInfo attenders = 2;</code>
     */
    public Builder addAttenders(
        int index, com.dj.protobuf.scene.SceneRoleInfo value) {
      if (attendersBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureAttendersIsMutable();
        attenders_.add(index, value);
        onChanged();
      } else {
        attendersBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .Protocols.SceneRoleInfo attenders = 2;</code>
     */
    public Builder addAttenders(
        com.dj.protobuf.scene.SceneRoleInfo.Builder builderForValue) {
      if (attendersBuilder_ == null) {
        ensureAttendersIsMutable();
        attenders_.add(builderForValue.build());
        onChanged();
      } else {
        attendersBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .Protocols.SceneRoleInfo attenders = 2;</code>
     */
    public Builder addAttenders(
        int index, com.dj.protobuf.scene.SceneRoleInfo.Builder builderForValue) {
      if (attendersBuilder_ == null) {
        ensureAttendersIsMutable();
        attenders_.add(index, builderForValue.build());
        onChanged();
      } else {
        attendersBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .Protocols.SceneRoleInfo attenders = 2;</code>
     */
    public Builder addAllAttenders(
        java.lang.Iterable<? extends com.dj.protobuf.scene.SceneRoleInfo> values) {
      if (attendersBuilder_ == null) {
        ensureAttendersIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, attenders_);
        onChanged();
      } else {
        attendersBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .Protocols.SceneRoleInfo attenders = 2;</code>
     */
    public Builder clearAttenders() {
      if (attendersBuilder_ == null) {
        attenders_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000002);
        onChanged();
      } else {
        attendersBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .Protocols.SceneRoleInfo attenders = 2;</code>
     */
    public Builder removeAttenders(int index) {
      if (attendersBuilder_ == null) {
        ensureAttendersIsMutable();
        attenders_.remove(index);
        onChanged();
      } else {
        attendersBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .Protocols.SceneRoleInfo attenders = 2;</code>
     */
    public com.dj.protobuf.scene.SceneRoleInfo.Builder getAttendersBuilder(
        int index) {
      return getAttendersFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .Protocols.SceneRoleInfo attenders = 2;</code>
     */
    public com.dj.protobuf.scene.SceneRoleInfoOrBuilder getAttendersOrBuilder(
        int index) {
      if (attendersBuilder_ == null) {
        return attenders_.get(index);  } else {
        return attendersBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .Protocols.SceneRoleInfo attenders = 2;</code>
     */
    public java.util.List<? extends com.dj.protobuf.scene.SceneRoleInfoOrBuilder> 
         getAttendersOrBuilderList() {
      if (attendersBuilder_ != null) {
        return attendersBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(attenders_);
      }
    }
    /**
     * <code>repeated .Protocols.SceneRoleInfo attenders = 2;</code>
     */
    public com.dj.protobuf.scene.SceneRoleInfo.Builder addAttendersBuilder() {
      return getAttendersFieldBuilder().addBuilder(
          com.dj.protobuf.scene.SceneRoleInfo.getDefaultInstance());
    }
    /**
     * <code>repeated .Protocols.SceneRoleInfo attenders = 2;</code>
     */
    public com.dj.protobuf.scene.SceneRoleInfo.Builder addAttendersBuilder(
        int index) {
      return getAttendersFieldBuilder().addBuilder(
          index, com.dj.protobuf.scene.SceneRoleInfo.getDefaultInstance());
    }
    /**
     * <code>repeated .Protocols.SceneRoleInfo attenders = 2;</code>
     */
    public java.util.List<com.dj.protobuf.scene.SceneRoleInfo.Builder> 
         getAttendersBuilderList() {
      return getAttendersFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        com.dj.protobuf.scene.SceneRoleInfo, com.dj.protobuf.scene.SceneRoleInfo.Builder, com.dj.protobuf.scene.SceneRoleInfoOrBuilder> 
        getAttendersFieldBuilder() {
      if (attendersBuilder_ == null) {
        attendersBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            com.dj.protobuf.scene.SceneRoleInfo, com.dj.protobuf.scene.SceneRoleInfo.Builder, com.dj.protobuf.scene.SceneRoleInfoOrBuilder>(
                attenders_,
                ((bitField0_ & 0x00000002) == 0x00000002),
                getParentForChildren(),
                isClean());
        attenders_ = null;
      }
      return attendersBuilder_;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:Protocols.SceneDetailInfo)
  }

  // @@protoc_insertion_point(class_scope:Protocols.SceneDetailInfo)
  private static final com.dj.protobuf.scene.SceneDetailInfo DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.dj.protobuf.scene.SceneDetailInfo();
  }

  public static com.dj.protobuf.scene.SceneDetailInfo getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  @java.lang.Deprecated public static final com.google.protobuf.Parser<SceneDetailInfo>
      PARSER = new com.google.protobuf.AbstractParser<SceneDetailInfo>() {
    public SceneDetailInfo parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new SceneDetailInfo(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<SceneDetailInfo> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<SceneDetailInfo> getParserForType() {
    return PARSER;
  }

  public com.dj.protobuf.scene.SceneDetailInfo getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
