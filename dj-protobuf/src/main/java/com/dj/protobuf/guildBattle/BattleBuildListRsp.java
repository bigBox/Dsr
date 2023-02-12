// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: GuildBattle.proto

package com.dj.protobuf.guildBattle;

/**
 * Protobuf type {@code Protocols.BattleBuildListRsp}
 */
public  final class BattleBuildListRsp extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:Protocols.BattleBuildListRsp)
    BattleBuildListRspOrBuilder {
  // Use BattleBuildListRsp.newBuilder() to construct.
  private BattleBuildListRsp(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private BattleBuildListRsp() {
    errorID_ = 0;
    builds_ = java.util.Collections.emptyList();
    roomTime_ = 0;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private BattleBuildListRsp(
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
            com.dj.protobuf.ErrorIDOuterClass.ErrorID value = com.dj.protobuf.ErrorIDOuterClass.ErrorID.valueOf(rawValue);
            if (value == null) {
              unknownFields.mergeVarintField(1, rawValue);
            } else {
              bitField0_ |= 0x00000001;
              errorID_ = rawValue;
            }
            break;
          }
          case 18: {
            if (!((mutable_bitField0_ & 0x00000002) == 0x00000002)) {
              builds_ = new java.util.ArrayList<com.dj.protobuf.guildBattle.GuildBattleBuildInfo>();
              mutable_bitField0_ |= 0x00000002;
            }
            builds_.add(
                input.readMessage(com.dj.protobuf.guildBattle.GuildBattleBuildInfo.PARSER, extensionRegistry));
            break;
          }
          case 24: {
            bitField0_ |= 0x00000002;
            roomTime_ = input.readInt32();
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
        builds_ = java.util.Collections.unmodifiableList(builds_);
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.dj.protobuf.guildBattle.GuildBattle.internal_static_Protocols_BattleBuildListRsp_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.dj.protobuf.guildBattle.GuildBattle.internal_static_Protocols_BattleBuildListRsp_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.dj.protobuf.guildBattle.BattleBuildListRsp.class, com.dj.protobuf.guildBattle.BattleBuildListRsp.Builder.class);
  }

  private int bitField0_;
  public static final int ERRORID_FIELD_NUMBER = 1;
  private int errorID_;
  /**
   * <code>optional .ErrorID errorID = 1;</code>
   */
  public boolean hasErrorID() {
    return ((bitField0_ & 0x00000001) == 0x00000001);
  }
  /**
   * <code>optional .ErrorID errorID = 1;</code>
   */
  public com.dj.protobuf.ErrorIDOuterClass.ErrorID getErrorID() {
    com.dj.protobuf.ErrorIDOuterClass.ErrorID result = com.dj.protobuf.ErrorIDOuterClass.ErrorID.valueOf(errorID_);
    return result == null ? com.dj.protobuf.ErrorIDOuterClass.ErrorID.OK : result;
  }

  public static final int BUILDS_FIELD_NUMBER = 2;
  private java.util.List<com.dj.protobuf.guildBattle.GuildBattleBuildInfo> builds_;
  /**
   * <pre>
   * 建筑列表
   * </pre>
   *
   * <code>repeated .Protocols.GuildBattleBuildInfo builds = 2;</code>
   */
  public java.util.List<com.dj.protobuf.guildBattle.GuildBattleBuildInfo> getBuildsList() {
    return builds_;
  }
  /**
   * <pre>
   * 建筑列表
   * </pre>
   *
   * <code>repeated .Protocols.GuildBattleBuildInfo builds = 2;</code>
   */
  public java.util.List<? extends com.dj.protobuf.guildBattle.GuildBattleBuildInfoOrBuilder> 
      getBuildsOrBuilderList() {
    return builds_;
  }
  /**
   * <pre>
   * 建筑列表
   * </pre>
   *
   * <code>repeated .Protocols.GuildBattleBuildInfo builds = 2;</code>
   */
  public int getBuildsCount() {
    return builds_.size();
  }
  /**
   * <pre>
   * 建筑列表
   * </pre>
   *
   * <code>repeated .Protocols.GuildBattleBuildInfo builds = 2;</code>
   */
  public com.dj.protobuf.guildBattle.GuildBattleBuildInfo getBuilds(int index) {
    return builds_.get(index);
  }
  /**
   * <pre>
   * 建筑列表
   * </pre>
   *
   * <code>repeated .Protocols.GuildBattleBuildInfo builds = 2;</code>
   */
  public com.dj.protobuf.guildBattle.GuildBattleBuildInfoOrBuilder getBuildsOrBuilder(
      int index) {
    return builds_.get(index);
  }

  public static final int ROOMTIME_FIELD_NUMBER = 3;
  private int roomTime_;
  /**
   * <pre>
   * 房间时间（秒数）
   * </pre>
   *
   * <code>optional int32 roomTime = 3;</code>
   */
  public boolean hasRoomTime() {
    return ((bitField0_ & 0x00000002) == 0x00000002);
  }
  /**
   * <pre>
   * 房间时间（秒数）
   * </pre>
   *
   * <code>optional int32 roomTime = 3;</code>
   */
  public int getRoomTime() {
    return roomTime_;
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
      output.writeEnum(1, errorID_);
    }
    for (int i = 0; i < builds_.size(); i++) {
      output.writeMessage(2, builds_.get(i));
    }
    if (((bitField0_ & 0x00000002) == 0x00000002)) {
      output.writeInt32(3, roomTime_);
    }
    unknownFields.writeTo(output);
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (((bitField0_ & 0x00000001) == 0x00000001)) {
      size += com.google.protobuf.CodedOutputStream
        .computeEnumSize(1, errorID_);
    }
    for (int i = 0; i < builds_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(2, builds_.get(i));
    }
    if (((bitField0_ & 0x00000002) == 0x00000002)) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(3, roomTime_);
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
    if (!(obj instanceof com.dj.protobuf.guildBattle.BattleBuildListRsp)) {
      return super.equals(obj);
    }
    com.dj.protobuf.guildBattle.BattleBuildListRsp other = (com.dj.protobuf.guildBattle.BattleBuildListRsp) obj;

    boolean result = true;
    result = result && (hasErrorID() == other.hasErrorID());
    if (hasErrorID()) {
      result = result && errorID_ == other.errorID_;
    }
    result = result && getBuildsList()
        .equals(other.getBuildsList());
    result = result && (hasRoomTime() == other.hasRoomTime());
    if (hasRoomTime()) {
      result = result && (getRoomTime()
          == other.getRoomTime());
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
    if (hasErrorID()) {
      hash = (37 * hash) + ERRORID_FIELD_NUMBER;
      hash = (53 * hash) + errorID_;
    }
    if (getBuildsCount() > 0) {
      hash = (37 * hash) + BUILDS_FIELD_NUMBER;
      hash = (53 * hash) + getBuildsList().hashCode();
    }
    if (hasRoomTime()) {
      hash = (37 * hash) + ROOMTIME_FIELD_NUMBER;
      hash = (53 * hash) + getRoomTime();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.dj.protobuf.guildBattle.BattleBuildListRsp parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dj.protobuf.guildBattle.BattleBuildListRsp parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dj.protobuf.guildBattle.BattleBuildListRsp parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dj.protobuf.guildBattle.BattleBuildListRsp parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dj.protobuf.guildBattle.BattleBuildListRsp parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.guildBattle.BattleBuildListRsp parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.dj.protobuf.guildBattle.BattleBuildListRsp parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.guildBattle.BattleBuildListRsp parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.dj.protobuf.guildBattle.BattleBuildListRsp parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.guildBattle.BattleBuildListRsp parseFrom(
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
  public static Builder newBuilder(com.dj.protobuf.guildBattle.BattleBuildListRsp prototype) {
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
   * Protobuf type {@code Protocols.BattleBuildListRsp}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:Protocols.BattleBuildListRsp)
      com.dj.protobuf.guildBattle.BattleBuildListRspOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.dj.protobuf.guildBattle.GuildBattle.internal_static_Protocols_BattleBuildListRsp_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.dj.protobuf.guildBattle.GuildBattle.internal_static_Protocols_BattleBuildListRsp_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.dj.protobuf.guildBattle.BattleBuildListRsp.class, com.dj.protobuf.guildBattle.BattleBuildListRsp.Builder.class);
    }

    // Construct using com.dj.protobuf.guildBattle.BattleBuildListRsp.newBuilder()
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
        getBuildsFieldBuilder();
      }
    }
    public Builder clear() {
      super.clear();
      errorID_ = 0;
      bitField0_ = (bitField0_ & ~0x00000001);
      if (buildsBuilder_ == null) {
        builds_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000002);
      } else {
        buildsBuilder_.clear();
      }
      roomTime_ = 0;
      bitField0_ = (bitField0_ & ~0x00000004);
      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.dj.protobuf.guildBattle.GuildBattle.internal_static_Protocols_BattleBuildListRsp_descriptor;
    }

    public com.dj.protobuf.guildBattle.BattleBuildListRsp getDefaultInstanceForType() {
      return com.dj.protobuf.guildBattle.BattleBuildListRsp.getDefaultInstance();
    }

    public com.dj.protobuf.guildBattle.BattleBuildListRsp build() {
      com.dj.protobuf.guildBattle.BattleBuildListRsp result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public com.dj.protobuf.guildBattle.BattleBuildListRsp buildPartial() {
      com.dj.protobuf.guildBattle.BattleBuildListRsp result = new com.dj.protobuf.guildBattle.BattleBuildListRsp(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
        to_bitField0_ |= 0x00000001;
      }
      result.errorID_ = errorID_;
      if (buildsBuilder_ == null) {
        if (((bitField0_ & 0x00000002) == 0x00000002)) {
          builds_ = java.util.Collections.unmodifiableList(builds_);
          bitField0_ = (bitField0_ & ~0x00000002);
        }
        result.builds_ = builds_;
      } else {
        result.builds_ = buildsBuilder_.build();
      }
      if (((from_bitField0_ & 0x00000004) == 0x00000004)) {
        to_bitField0_ |= 0x00000002;
      }
      result.roomTime_ = roomTime_;
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
      if (other instanceof com.dj.protobuf.guildBattle.BattleBuildListRsp) {
        return mergeFrom((com.dj.protobuf.guildBattle.BattleBuildListRsp)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.dj.protobuf.guildBattle.BattleBuildListRsp other) {
      if (other == com.dj.protobuf.guildBattle.BattleBuildListRsp.getDefaultInstance()) return this;
      if (other.hasErrorID()) {
        setErrorID(other.getErrorID());
      }
      if (buildsBuilder_ == null) {
        if (!other.builds_.isEmpty()) {
          if (builds_.isEmpty()) {
            builds_ = other.builds_;
            bitField0_ = (bitField0_ & ~0x00000002);
          } else {
            ensureBuildsIsMutable();
            builds_.addAll(other.builds_);
          }
          onChanged();
        }
      } else {
        if (!other.builds_.isEmpty()) {
          if (buildsBuilder_.isEmpty()) {
            buildsBuilder_.dispose();
            buildsBuilder_ = null;
            builds_ = other.builds_;
            bitField0_ = (bitField0_ & ~0x00000002);
            buildsBuilder_ = 
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getBuildsFieldBuilder() : null;
          } else {
            buildsBuilder_.addAllMessages(other.builds_);
          }
        }
      }
      if (other.hasRoomTime()) {
        setRoomTime(other.getRoomTime());
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
      com.dj.protobuf.guildBattle.BattleBuildListRsp parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.dj.protobuf.guildBattle.BattleBuildListRsp) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private int errorID_ = 0;
    /**
     * <code>optional .ErrorID errorID = 1;</code>
     */
    public boolean hasErrorID() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <code>optional .ErrorID errorID = 1;</code>
     */
    public com.dj.protobuf.ErrorIDOuterClass.ErrorID getErrorID() {
      com.dj.protobuf.ErrorIDOuterClass.ErrorID result = com.dj.protobuf.ErrorIDOuterClass.ErrorID.valueOf(errorID_);
      return result == null ? com.dj.protobuf.ErrorIDOuterClass.ErrorID.OK : result;
    }
    /**
     * <code>optional .ErrorID errorID = 1;</code>
     */
    public Builder setErrorID(com.dj.protobuf.ErrorIDOuterClass.ErrorID value) {
      if (value == null) {
        throw new NullPointerException();
      }
      bitField0_ |= 0x00000001;
      errorID_ = value.getNumber();
      onChanged();
      return this;
    }
    /**
     * <code>optional .ErrorID errorID = 1;</code>
     */
    public Builder clearErrorID() {
      bitField0_ = (bitField0_ & ~0x00000001);
      errorID_ = 0;
      onChanged();
      return this;
    }

    private java.util.List<com.dj.protobuf.guildBattle.GuildBattleBuildInfo> builds_ =
      java.util.Collections.emptyList();
    private void ensureBuildsIsMutable() {
      if (!((bitField0_ & 0x00000002) == 0x00000002)) {
        builds_ = new java.util.ArrayList<com.dj.protobuf.guildBattle.GuildBattleBuildInfo>(builds_);
        bitField0_ |= 0x00000002;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        com.dj.protobuf.guildBattle.GuildBattleBuildInfo, com.dj.protobuf.guildBattle.GuildBattleBuildInfo.Builder, com.dj.protobuf.guildBattle.GuildBattleBuildInfoOrBuilder> buildsBuilder_;

    /**
     * <pre>
     * 建筑列表
     * </pre>
     *
     * <code>repeated .Protocols.GuildBattleBuildInfo builds = 2;</code>
     */
    public java.util.List<com.dj.protobuf.guildBattle.GuildBattleBuildInfo> getBuildsList() {
      if (buildsBuilder_ == null) {
        return java.util.Collections.unmodifiableList(builds_);
      } else {
        return buildsBuilder_.getMessageList();
      }
    }
    /**
     * <pre>
     * 建筑列表
     * </pre>
     *
     * <code>repeated .Protocols.GuildBattleBuildInfo builds = 2;</code>
     */
    public int getBuildsCount() {
      if (buildsBuilder_ == null) {
        return builds_.size();
      } else {
        return buildsBuilder_.getCount();
      }
    }
    /**
     * <pre>
     * 建筑列表
     * </pre>
     *
     * <code>repeated .Protocols.GuildBattleBuildInfo builds = 2;</code>
     */
    public com.dj.protobuf.guildBattle.GuildBattleBuildInfo getBuilds(int index) {
      if (buildsBuilder_ == null) {
        return builds_.get(index);
      } else {
        return buildsBuilder_.getMessage(index);
      }
    }
    /**
     * <pre>
     * 建筑列表
     * </pre>
     *
     * <code>repeated .Protocols.GuildBattleBuildInfo builds = 2;</code>
     */
    public Builder setBuilds(
        int index, com.dj.protobuf.guildBattle.GuildBattleBuildInfo value) {
      if (buildsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureBuildsIsMutable();
        builds_.set(index, value);
        onChanged();
      } else {
        buildsBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <pre>
     * 建筑列表
     * </pre>
     *
     * <code>repeated .Protocols.GuildBattleBuildInfo builds = 2;</code>
     */
    public Builder setBuilds(
        int index, com.dj.protobuf.guildBattle.GuildBattleBuildInfo.Builder builderForValue) {
      if (buildsBuilder_ == null) {
        ensureBuildsIsMutable();
        builds_.set(index, builderForValue.build());
        onChanged();
      } else {
        buildsBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <pre>
     * 建筑列表
     * </pre>
     *
     * <code>repeated .Protocols.GuildBattleBuildInfo builds = 2;</code>
     */
    public Builder addBuilds(com.dj.protobuf.guildBattle.GuildBattleBuildInfo value) {
      if (buildsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureBuildsIsMutable();
        builds_.add(value);
        onChanged();
      } else {
        buildsBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <pre>
     * 建筑列表
     * </pre>
     *
     * <code>repeated .Protocols.GuildBattleBuildInfo builds = 2;</code>
     */
    public Builder addBuilds(
        int index, com.dj.protobuf.guildBattle.GuildBattleBuildInfo value) {
      if (buildsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureBuildsIsMutable();
        builds_.add(index, value);
        onChanged();
      } else {
        buildsBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <pre>
     * 建筑列表
     * </pre>
     *
     * <code>repeated .Protocols.GuildBattleBuildInfo builds = 2;</code>
     */
    public Builder addBuilds(
        com.dj.protobuf.guildBattle.GuildBattleBuildInfo.Builder builderForValue) {
      if (buildsBuilder_ == null) {
        ensureBuildsIsMutable();
        builds_.add(builderForValue.build());
        onChanged();
      } else {
        buildsBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <pre>
     * 建筑列表
     * </pre>
     *
     * <code>repeated .Protocols.GuildBattleBuildInfo builds = 2;</code>
     */
    public Builder addBuilds(
        int index, com.dj.protobuf.guildBattle.GuildBattleBuildInfo.Builder builderForValue) {
      if (buildsBuilder_ == null) {
        ensureBuildsIsMutable();
        builds_.add(index, builderForValue.build());
        onChanged();
      } else {
        buildsBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <pre>
     * 建筑列表
     * </pre>
     *
     * <code>repeated .Protocols.GuildBattleBuildInfo builds = 2;</code>
     */
    public Builder addAllBuilds(
        java.lang.Iterable<? extends com.dj.protobuf.guildBattle.GuildBattleBuildInfo> values) {
      if (buildsBuilder_ == null) {
        ensureBuildsIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, builds_);
        onChanged();
      } else {
        buildsBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <pre>
     * 建筑列表
     * </pre>
     *
     * <code>repeated .Protocols.GuildBattleBuildInfo builds = 2;</code>
     */
    public Builder clearBuilds() {
      if (buildsBuilder_ == null) {
        builds_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000002);
        onChanged();
      } else {
        buildsBuilder_.clear();
      }
      return this;
    }
    /**
     * <pre>
     * 建筑列表
     * </pre>
     *
     * <code>repeated .Protocols.GuildBattleBuildInfo builds = 2;</code>
     */
    public Builder removeBuilds(int index) {
      if (buildsBuilder_ == null) {
        ensureBuildsIsMutable();
        builds_.remove(index);
        onChanged();
      } else {
        buildsBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <pre>
     * 建筑列表
     * </pre>
     *
     * <code>repeated .Protocols.GuildBattleBuildInfo builds = 2;</code>
     */
    public com.dj.protobuf.guildBattle.GuildBattleBuildInfo.Builder getBuildsBuilder(
        int index) {
      return getBuildsFieldBuilder().getBuilder(index);
    }
    /**
     * <pre>
     * 建筑列表
     * </pre>
     *
     * <code>repeated .Protocols.GuildBattleBuildInfo builds = 2;</code>
     */
    public com.dj.protobuf.guildBattle.GuildBattleBuildInfoOrBuilder getBuildsOrBuilder(
        int index) {
      if (buildsBuilder_ == null) {
        return builds_.get(index);  } else {
        return buildsBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <pre>
     * 建筑列表
     * </pre>
     *
     * <code>repeated .Protocols.GuildBattleBuildInfo builds = 2;</code>
     */
    public java.util.List<? extends com.dj.protobuf.guildBattle.GuildBattleBuildInfoOrBuilder> 
         getBuildsOrBuilderList() {
      if (buildsBuilder_ != null) {
        return buildsBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(builds_);
      }
    }
    /**
     * <pre>
     * 建筑列表
     * </pre>
     *
     * <code>repeated .Protocols.GuildBattleBuildInfo builds = 2;</code>
     */
    public com.dj.protobuf.guildBattle.GuildBattleBuildInfo.Builder addBuildsBuilder() {
      return getBuildsFieldBuilder().addBuilder(
          com.dj.protobuf.guildBattle.GuildBattleBuildInfo.getDefaultInstance());
    }
    /**
     * <pre>
     * 建筑列表
     * </pre>
     *
     * <code>repeated .Protocols.GuildBattleBuildInfo builds = 2;</code>
     */
    public com.dj.protobuf.guildBattle.GuildBattleBuildInfo.Builder addBuildsBuilder(
        int index) {
      return getBuildsFieldBuilder().addBuilder(
          index, com.dj.protobuf.guildBattle.GuildBattleBuildInfo.getDefaultInstance());
    }
    /**
     * <pre>
     * 建筑列表
     * </pre>
     *
     * <code>repeated .Protocols.GuildBattleBuildInfo builds = 2;</code>
     */
    public java.util.List<com.dj.protobuf.guildBattle.GuildBattleBuildInfo.Builder> 
         getBuildsBuilderList() {
      return getBuildsFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        com.dj.protobuf.guildBattle.GuildBattleBuildInfo, com.dj.protobuf.guildBattle.GuildBattleBuildInfo.Builder, com.dj.protobuf.guildBattle.GuildBattleBuildInfoOrBuilder> 
        getBuildsFieldBuilder() {
      if (buildsBuilder_ == null) {
        buildsBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            com.dj.protobuf.guildBattle.GuildBattleBuildInfo, com.dj.protobuf.guildBattle.GuildBattleBuildInfo.Builder, com.dj.protobuf.guildBattle.GuildBattleBuildInfoOrBuilder>(
                builds_,
                ((bitField0_ & 0x00000002) == 0x00000002),
                getParentForChildren(),
                isClean());
        builds_ = null;
      }
      return buildsBuilder_;
    }

    private int roomTime_ ;
    /**
     * <pre>
     * 房间时间（秒数）
     * </pre>
     *
     * <code>optional int32 roomTime = 3;</code>
     */
    public boolean hasRoomTime() {
      return ((bitField0_ & 0x00000004) == 0x00000004);
    }
    /**
     * <pre>
     * 房间时间（秒数）
     * </pre>
     *
     * <code>optional int32 roomTime = 3;</code>
     */
    public int getRoomTime() {
      return roomTime_;
    }
    /**
     * <pre>
     * 房间时间（秒数）
     * </pre>
     *
     * <code>optional int32 roomTime = 3;</code>
     */
    public Builder setRoomTime(int value) {
      bitField0_ |= 0x00000004;
      roomTime_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * 房间时间（秒数）
     * </pre>
     *
     * <code>optional int32 roomTime = 3;</code>
     */
    public Builder clearRoomTime() {
      bitField0_ = (bitField0_ & ~0x00000004);
      roomTime_ = 0;
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


    // @@protoc_insertion_point(builder_scope:Protocols.BattleBuildListRsp)
  }

  // @@protoc_insertion_point(class_scope:Protocols.BattleBuildListRsp)
  private static final com.dj.protobuf.guildBattle.BattleBuildListRsp DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.dj.protobuf.guildBattle.BattleBuildListRsp();
  }

  public static com.dj.protobuf.guildBattle.BattleBuildListRsp getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  @java.lang.Deprecated public static final com.google.protobuf.Parser<BattleBuildListRsp>
      PARSER = new com.google.protobuf.AbstractParser<BattleBuildListRsp>() {
    public BattleBuildListRsp parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new BattleBuildListRsp(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<BattleBuildListRsp> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<BattleBuildListRsp> getParserForType() {
    return PARSER;
  }

  public com.dj.protobuf.guildBattle.BattleBuildListRsp getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

