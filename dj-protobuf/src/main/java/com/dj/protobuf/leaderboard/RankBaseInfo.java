// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Leaderboard.proto

package com.dj.protobuf.leaderboard;

/**
 * <pre>
 *&#47; &lt;summary&gt;
 * / 排行榜通用基础数据
 * / &lt;/summary&gt;
 * </pre>
 *
 * Protobuf type {@code Protocols.RankBaseInfo}
 */
public  final class RankBaseInfo extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:Protocols.RankBaseInfo)
    RankBaseInfoOrBuilder {
  // Use RankBaseInfo.newBuilder() to construct.
  private RankBaseInfo(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private RankBaseInfo() {
    id_ = 0L;
    score_ = 0;
    seasonId_ = 0;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private RankBaseInfo(
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
            id_ = input.readUInt64();
            break;
          }
          case 16: {
            bitField0_ |= 0x00000002;
            score_ = input.readInt32();
            break;
          }
          case 26: {
            com.dj.protobuf.datetime.DateTime.Builder subBuilder = null;
            if (((bitField0_ & 0x00000004) == 0x00000004)) {
              subBuilder = updateTime_.toBuilder();
            }
            updateTime_ = input.readMessage(com.dj.protobuf.datetime.DateTime.PARSER, extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(updateTime_);
              updateTime_ = subBuilder.buildPartial();
            }
            bitField0_ |= 0x00000004;
            break;
          }
          case 32: {
            bitField0_ |= 0x00000008;
            seasonId_ = input.readInt32();
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
    return com.dj.protobuf.leaderboard.Leaderboard.internal_static_Protocols_RankBaseInfo_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.dj.protobuf.leaderboard.Leaderboard.internal_static_Protocols_RankBaseInfo_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.dj.protobuf.leaderboard.RankBaseInfo.class, com.dj.protobuf.leaderboard.RankBaseInfo.Builder.class);
  }

  private int bitField0_;
  public static final int ID_FIELD_NUMBER = 1;
  private long id_;
  /**
   * <code>optional uint64 id = 1;</code>
   */
  public boolean hasId() {
    return ((bitField0_ & 0x00000001) == 0x00000001);
  }
  /**
   * <code>optional uint64 id = 1;</code>
   */
  public long getId() {
    return id_;
  }

  public static final int SCORE_FIELD_NUMBER = 2;
  private int score_;
  /**
   * <code>optional int32 score = 2;</code>
   */
  public boolean hasScore() {
    return ((bitField0_ & 0x00000002) == 0x00000002);
  }
  /**
   * <code>optional int32 score = 2;</code>
   */
  public int getScore() {
    return score_;
  }

  public static final int UPDATETIME_FIELD_NUMBER = 3;
  private com.dj.protobuf.datetime.DateTime updateTime_;
  /**
   * <code>optional .Protocols.DateTime updateTime = 3;</code>
   */
  public boolean hasUpdateTime() {
    return ((bitField0_ & 0x00000004) == 0x00000004);
  }
  /**
   * <code>optional .Protocols.DateTime updateTime = 3;</code>
   */
  public com.dj.protobuf.datetime.DateTime getUpdateTime() {
    return updateTime_ == null ? com.dj.protobuf.datetime.DateTime.getDefaultInstance() : updateTime_;
  }
  /**
   * <code>optional .Protocols.DateTime updateTime = 3;</code>
   */
  public com.dj.protobuf.datetime.DateTimeOrBuilder getUpdateTimeOrBuilder() {
    return updateTime_ == null ? com.dj.protobuf.datetime.DateTime.getDefaultInstance() : updateTime_;
  }

  public static final int SEASONID_FIELD_NUMBER = 4;
  private int seasonId_;
  /**
   * <code>optional int32 seasonId = 4;</code>
   */
  public boolean hasSeasonId() {
    return ((bitField0_ & 0x00000008) == 0x00000008);
  }
  /**
   * <code>optional int32 seasonId = 4;</code>
   */
  public int getSeasonId() {
    return seasonId_;
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
      output.writeUInt64(1, id_);
    }
    if (((bitField0_ & 0x00000002) == 0x00000002)) {
      output.writeInt32(2, score_);
    }
    if (((bitField0_ & 0x00000004) == 0x00000004)) {
      output.writeMessage(3, getUpdateTime());
    }
    if (((bitField0_ & 0x00000008) == 0x00000008)) {
      output.writeInt32(4, seasonId_);
    }
    unknownFields.writeTo(output);
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (((bitField0_ & 0x00000001) == 0x00000001)) {
      size += com.google.protobuf.CodedOutputStream
        .computeUInt64Size(1, id_);
    }
    if (((bitField0_ & 0x00000002) == 0x00000002)) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(2, score_);
    }
    if (((bitField0_ & 0x00000004) == 0x00000004)) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(3, getUpdateTime());
    }
    if (((bitField0_ & 0x00000008) == 0x00000008)) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(4, seasonId_);
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
    if (!(obj instanceof com.dj.protobuf.leaderboard.RankBaseInfo)) {
      return super.equals(obj);
    }
    com.dj.protobuf.leaderboard.RankBaseInfo other = (com.dj.protobuf.leaderboard.RankBaseInfo) obj;

    boolean result = true;
    result = result && (hasId() == other.hasId());
    if (hasId()) {
      result = result && (getId()
          == other.getId());
    }
    result = result && (hasScore() == other.hasScore());
    if (hasScore()) {
      result = result && (getScore()
          == other.getScore());
    }
    result = result && (hasUpdateTime() == other.hasUpdateTime());
    if (hasUpdateTime()) {
      result = result && getUpdateTime()
          .equals(other.getUpdateTime());
    }
    result = result && (hasSeasonId() == other.hasSeasonId());
    if (hasSeasonId()) {
      result = result && (getSeasonId()
          == other.getSeasonId());
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
    if (hasId()) {
      hash = (37 * hash) + ID_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
          getId());
    }
    if (hasScore()) {
      hash = (37 * hash) + SCORE_FIELD_NUMBER;
      hash = (53 * hash) + getScore();
    }
    if (hasUpdateTime()) {
      hash = (37 * hash) + UPDATETIME_FIELD_NUMBER;
      hash = (53 * hash) + getUpdateTime().hashCode();
    }
    if (hasSeasonId()) {
      hash = (37 * hash) + SEASONID_FIELD_NUMBER;
      hash = (53 * hash) + getSeasonId();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.dj.protobuf.leaderboard.RankBaseInfo parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dj.protobuf.leaderboard.RankBaseInfo parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dj.protobuf.leaderboard.RankBaseInfo parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dj.protobuf.leaderboard.RankBaseInfo parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dj.protobuf.leaderboard.RankBaseInfo parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.leaderboard.RankBaseInfo parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.dj.protobuf.leaderboard.RankBaseInfo parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.leaderboard.RankBaseInfo parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.dj.protobuf.leaderboard.RankBaseInfo parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.leaderboard.RankBaseInfo parseFrom(
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
  public static Builder newBuilder(com.dj.protobuf.leaderboard.RankBaseInfo prototype) {
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
   * <pre>
   *&#47; &lt;summary&gt;
   * / 排行榜通用基础数据
   * / &lt;/summary&gt;
   * </pre>
   *
   * Protobuf type {@code Protocols.RankBaseInfo}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:Protocols.RankBaseInfo)
      com.dj.protobuf.leaderboard.RankBaseInfoOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.dj.protobuf.leaderboard.Leaderboard.internal_static_Protocols_RankBaseInfo_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.dj.protobuf.leaderboard.Leaderboard.internal_static_Protocols_RankBaseInfo_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.dj.protobuf.leaderboard.RankBaseInfo.class, com.dj.protobuf.leaderboard.RankBaseInfo.Builder.class);
    }

    // Construct using com.dj.protobuf.leaderboard.RankBaseInfo.newBuilder()
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
        getUpdateTimeFieldBuilder();
      }
    }
    public Builder clear() {
      super.clear();
      id_ = 0L;
      bitField0_ = (bitField0_ & ~0x00000001);
      score_ = 0;
      bitField0_ = (bitField0_ & ~0x00000002);
      if (updateTimeBuilder_ == null) {
        updateTime_ = null;
      } else {
        updateTimeBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000004);
      seasonId_ = 0;
      bitField0_ = (bitField0_ & ~0x00000008);
      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.dj.protobuf.leaderboard.Leaderboard.internal_static_Protocols_RankBaseInfo_descriptor;
    }

    public com.dj.protobuf.leaderboard.RankBaseInfo getDefaultInstanceForType() {
      return com.dj.protobuf.leaderboard.RankBaseInfo.getDefaultInstance();
    }

    public com.dj.protobuf.leaderboard.RankBaseInfo build() {
      com.dj.protobuf.leaderboard.RankBaseInfo result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public com.dj.protobuf.leaderboard.RankBaseInfo buildPartial() {
      com.dj.protobuf.leaderboard.RankBaseInfo result = new com.dj.protobuf.leaderboard.RankBaseInfo(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
        to_bitField0_ |= 0x00000001;
      }
      result.id_ = id_;
      if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
        to_bitField0_ |= 0x00000002;
      }
      result.score_ = score_;
      if (((from_bitField0_ & 0x00000004) == 0x00000004)) {
        to_bitField0_ |= 0x00000004;
      }
      if (updateTimeBuilder_ == null) {
        result.updateTime_ = updateTime_;
      } else {
        result.updateTime_ = updateTimeBuilder_.build();
      }
      if (((from_bitField0_ & 0x00000008) == 0x00000008)) {
        to_bitField0_ |= 0x00000008;
      }
      result.seasonId_ = seasonId_;
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
      if (other instanceof com.dj.protobuf.leaderboard.RankBaseInfo) {
        return mergeFrom((com.dj.protobuf.leaderboard.RankBaseInfo)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.dj.protobuf.leaderboard.RankBaseInfo other) {
      if (other == com.dj.protobuf.leaderboard.RankBaseInfo.getDefaultInstance()) return this;
      if (other.hasId()) {
        setId(other.getId());
      }
      if (other.hasScore()) {
        setScore(other.getScore());
      }
      if (other.hasUpdateTime()) {
        mergeUpdateTime(other.getUpdateTime());
      }
      if (other.hasSeasonId()) {
        setSeasonId(other.getSeasonId());
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
      com.dj.protobuf.leaderboard.RankBaseInfo parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.dj.protobuf.leaderboard.RankBaseInfo) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private long id_ ;
    /**
     * <code>optional uint64 id = 1;</code>
     */
    public boolean hasId() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <code>optional uint64 id = 1;</code>
     */
    public long getId() {
      return id_;
    }
    /**
     * <code>optional uint64 id = 1;</code>
     */
    public Builder setId(long value) {
      bitField0_ |= 0x00000001;
      id_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional uint64 id = 1;</code>
     */
    public Builder clearId() {
      bitField0_ = (bitField0_ & ~0x00000001);
      id_ = 0L;
      onChanged();
      return this;
    }

    private int score_ ;
    /**
     * <code>optional int32 score = 2;</code>
     */
    public boolean hasScore() {
      return ((bitField0_ & 0x00000002) == 0x00000002);
    }
    /**
     * <code>optional int32 score = 2;</code>
     */
    public int getScore() {
      return score_;
    }
    /**
     * <code>optional int32 score = 2;</code>
     */
    public Builder setScore(int value) {
      bitField0_ |= 0x00000002;
      score_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional int32 score = 2;</code>
     */
    public Builder clearScore() {
      bitField0_ = (bitField0_ & ~0x00000002);
      score_ = 0;
      onChanged();
      return this;
    }

    private com.dj.protobuf.datetime.DateTime updateTime_ = null;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.dj.protobuf.datetime.DateTime, com.dj.protobuf.datetime.DateTime.Builder, com.dj.protobuf.datetime.DateTimeOrBuilder> updateTimeBuilder_;
    /**
     * <code>optional .Protocols.DateTime updateTime = 3;</code>
     */
    public boolean hasUpdateTime() {
      return ((bitField0_ & 0x00000004) == 0x00000004);
    }
    /**
     * <code>optional .Protocols.DateTime updateTime = 3;</code>
     */
    public com.dj.protobuf.datetime.DateTime getUpdateTime() {
      if (updateTimeBuilder_ == null) {
        return updateTime_ == null ? com.dj.protobuf.datetime.DateTime.getDefaultInstance() : updateTime_;
      } else {
        return updateTimeBuilder_.getMessage();
      }
    }
    /**
     * <code>optional .Protocols.DateTime updateTime = 3;</code>
     */
    public Builder setUpdateTime(com.dj.protobuf.datetime.DateTime value) {
      if (updateTimeBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        updateTime_ = value;
        onChanged();
      } else {
        updateTimeBuilder_.setMessage(value);
      }
      bitField0_ |= 0x00000004;
      return this;
    }
    /**
     * <code>optional .Protocols.DateTime updateTime = 3;</code>
     */
    public Builder setUpdateTime(
        com.dj.protobuf.datetime.DateTime.Builder builderForValue) {
      if (updateTimeBuilder_ == null) {
        updateTime_ = builderForValue.build();
        onChanged();
      } else {
        updateTimeBuilder_.setMessage(builderForValue.build());
      }
      bitField0_ |= 0x00000004;
      return this;
    }
    /**
     * <code>optional .Protocols.DateTime updateTime = 3;</code>
     */
    public Builder mergeUpdateTime(com.dj.protobuf.datetime.DateTime value) {
      if (updateTimeBuilder_ == null) {
        if (((bitField0_ & 0x00000004) == 0x00000004) &&
            updateTime_ != null &&
            updateTime_ != com.dj.protobuf.datetime.DateTime.getDefaultInstance()) {
          updateTime_ =
            com.dj.protobuf.datetime.DateTime.newBuilder(updateTime_).mergeFrom(value).buildPartial();
        } else {
          updateTime_ = value;
        }
        onChanged();
      } else {
        updateTimeBuilder_.mergeFrom(value);
      }
      bitField0_ |= 0x00000004;
      return this;
    }
    /**
     * <code>optional .Protocols.DateTime updateTime = 3;</code>
     */
    public Builder clearUpdateTime() {
      if (updateTimeBuilder_ == null) {
        updateTime_ = null;
        onChanged();
      } else {
        updateTimeBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000004);
      return this;
    }
    /**
     * <code>optional .Protocols.DateTime updateTime = 3;</code>
     */
    public com.dj.protobuf.datetime.DateTime.Builder getUpdateTimeBuilder() {
      bitField0_ |= 0x00000004;
      onChanged();
      return getUpdateTimeFieldBuilder().getBuilder();
    }
    /**
     * <code>optional .Protocols.DateTime updateTime = 3;</code>
     */
    public com.dj.protobuf.datetime.DateTimeOrBuilder getUpdateTimeOrBuilder() {
      if (updateTimeBuilder_ != null) {
        return updateTimeBuilder_.getMessageOrBuilder();
      } else {
        return updateTime_ == null ?
            com.dj.protobuf.datetime.DateTime.getDefaultInstance() : updateTime_;
      }
    }
    /**
     * <code>optional .Protocols.DateTime updateTime = 3;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.dj.protobuf.datetime.DateTime, com.dj.protobuf.datetime.DateTime.Builder, com.dj.protobuf.datetime.DateTimeOrBuilder> 
        getUpdateTimeFieldBuilder() {
      if (updateTimeBuilder_ == null) {
        updateTimeBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.dj.protobuf.datetime.DateTime, com.dj.protobuf.datetime.DateTime.Builder, com.dj.protobuf.datetime.DateTimeOrBuilder>(
                getUpdateTime(),
                getParentForChildren(),
                isClean());
        updateTime_ = null;
      }
      return updateTimeBuilder_;
    }

    private int seasonId_ ;
    /**
     * <code>optional int32 seasonId = 4;</code>
     */
    public boolean hasSeasonId() {
      return ((bitField0_ & 0x00000008) == 0x00000008);
    }
    /**
     * <code>optional int32 seasonId = 4;</code>
     */
    public int getSeasonId() {
      return seasonId_;
    }
    /**
     * <code>optional int32 seasonId = 4;</code>
     */
    public Builder setSeasonId(int value) {
      bitField0_ |= 0x00000008;
      seasonId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional int32 seasonId = 4;</code>
     */
    public Builder clearSeasonId() {
      bitField0_ = (bitField0_ & ~0x00000008);
      seasonId_ = 0;
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


    // @@protoc_insertion_point(builder_scope:Protocols.RankBaseInfo)
  }

  // @@protoc_insertion_point(class_scope:Protocols.RankBaseInfo)
  private static final com.dj.protobuf.leaderboard.RankBaseInfo DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.dj.protobuf.leaderboard.RankBaseInfo();
  }

  public static com.dj.protobuf.leaderboard.RankBaseInfo getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  @java.lang.Deprecated public static final com.google.protobuf.Parser<RankBaseInfo>
      PARSER = new com.google.protobuf.AbstractParser<RankBaseInfo>() {
    public RankBaseInfo parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new RankBaseInfo(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<RankBaseInfo> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<RankBaseInfo> getParserForType() {
    return PARSER;
  }

  public com.dj.protobuf.leaderboard.RankBaseInfo getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

