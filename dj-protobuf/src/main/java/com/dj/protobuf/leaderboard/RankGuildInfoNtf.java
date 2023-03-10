// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Leaderboard.proto

package com.dj.protobuf.leaderboard;

/**
 * Protobuf type {@code Protocols.RankGuildInfoNtf}
 */
public  final class RankGuildInfoNtf extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:Protocols.RankGuildInfoNtf)
    RankGuildInfoNtfOrBuilder {
  // Use RankGuildInfoNtf.newBuilder() to construct.
  private RankGuildInfoNtf(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private RankGuildInfoNtf() {
    topN_ = java.util.Collections.emptyList();
    selfRank_ = 0;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private RankGuildInfoNtf(
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
            if (!((mutable_bitField0_ & 0x00000001) == 0x00000001)) {
              topN_ = new java.util.ArrayList<com.dj.protobuf.leaderboard.GuildRankInfo>();
              mutable_bitField0_ |= 0x00000001;
            }
            topN_.add(
                input.readMessage(com.dj.protobuf.leaderboard.GuildRankInfo.PARSER, extensionRegistry));
            break;
          }
          case 18: {
            com.dj.protobuf.leaderboard.GuildRankInfo.Builder subBuilder = null;
            if (((bitField0_ & 0x00000001) == 0x00000001)) {
              subBuilder = selfInfo_.toBuilder();
            }
            selfInfo_ = input.readMessage(com.dj.protobuf.leaderboard.GuildRankInfo.PARSER, extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(selfInfo_);
              selfInfo_ = subBuilder.buildPartial();
            }
            bitField0_ |= 0x00000001;
            break;
          }
          case 24: {
            bitField0_ |= 0x00000002;
            selfRank_ = input.readInt32();
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
      if (((mutable_bitField0_ & 0x00000001) == 0x00000001)) {
        topN_ = java.util.Collections.unmodifiableList(topN_);
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.dj.protobuf.leaderboard.Leaderboard.internal_static_Protocols_RankGuildInfoNtf_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.dj.protobuf.leaderboard.Leaderboard.internal_static_Protocols_RankGuildInfoNtf_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.dj.protobuf.leaderboard.RankGuildInfoNtf.class, com.dj.protobuf.leaderboard.RankGuildInfoNtf.Builder.class);
  }

  private int bitField0_;
  public static final int TOPN_FIELD_NUMBER = 1;
  private java.util.List<com.dj.protobuf.leaderboard.GuildRankInfo> topN_;
  /**
   * <code>repeated .Protocols.GuildRankInfo topN = 1;</code>
   */
  public java.util.List<com.dj.protobuf.leaderboard.GuildRankInfo> getTopNList() {
    return topN_;
  }
  /**
   * <code>repeated .Protocols.GuildRankInfo topN = 1;</code>
   */
  public java.util.List<? extends com.dj.protobuf.leaderboard.GuildRankInfoOrBuilder> 
      getTopNOrBuilderList() {
    return topN_;
  }
  /**
   * <code>repeated .Protocols.GuildRankInfo topN = 1;</code>
   */
  public int getTopNCount() {
    return topN_.size();
  }
  /**
   * <code>repeated .Protocols.GuildRankInfo topN = 1;</code>
   */
  public com.dj.protobuf.leaderboard.GuildRankInfo getTopN(int index) {
    return topN_.get(index);
  }
  /**
   * <code>repeated .Protocols.GuildRankInfo topN = 1;</code>
   */
  public com.dj.protobuf.leaderboard.GuildRankInfoOrBuilder getTopNOrBuilder(
      int index) {
    return topN_.get(index);
  }

  public static final int SELFINFO_FIELD_NUMBER = 2;
  private com.dj.protobuf.leaderboard.GuildRankInfo selfInfo_;
  /**
   * <code>optional .Protocols.GuildRankInfo selfInfo = 2;</code>
   */
  public boolean hasSelfInfo() {
    return ((bitField0_ & 0x00000001) == 0x00000001);
  }
  /**
   * <code>optional .Protocols.GuildRankInfo selfInfo = 2;</code>
   */
  public com.dj.protobuf.leaderboard.GuildRankInfo getSelfInfo() {
    return selfInfo_ == null ? com.dj.protobuf.leaderboard.GuildRankInfo.getDefaultInstance() : selfInfo_;
  }
  /**
   * <code>optional .Protocols.GuildRankInfo selfInfo = 2;</code>
   */
  public com.dj.protobuf.leaderboard.GuildRankInfoOrBuilder getSelfInfoOrBuilder() {
    return selfInfo_ == null ? com.dj.protobuf.leaderboard.GuildRankInfo.getDefaultInstance() : selfInfo_;
  }

  public static final int SELFRANK_FIELD_NUMBER = 3;
  private int selfRank_;
  /**
   * <code>optional int32 selfRank = 3;</code>
   */
  public boolean hasSelfRank() {
    return ((bitField0_ & 0x00000002) == 0x00000002);
  }
  /**
   * <code>optional int32 selfRank = 3;</code>
   */
  public int getSelfRank() {
    return selfRank_;
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
    for (int i = 0; i < topN_.size(); i++) {
      output.writeMessage(1, topN_.get(i));
    }
    if (((bitField0_ & 0x00000001) == 0x00000001)) {
      output.writeMessage(2, getSelfInfo());
    }
    if (((bitField0_ & 0x00000002) == 0x00000002)) {
      output.writeInt32(3, selfRank_);
    }
    unknownFields.writeTo(output);
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    for (int i = 0; i < topN_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, topN_.get(i));
    }
    if (((bitField0_ & 0x00000001) == 0x00000001)) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(2, getSelfInfo());
    }
    if (((bitField0_ & 0x00000002) == 0x00000002)) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(3, selfRank_);
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
    if (!(obj instanceof com.dj.protobuf.leaderboard.RankGuildInfoNtf)) {
      return super.equals(obj);
    }
    com.dj.protobuf.leaderboard.RankGuildInfoNtf other = (com.dj.protobuf.leaderboard.RankGuildInfoNtf) obj;

    boolean result = true;
    result = result && getTopNList()
        .equals(other.getTopNList());
    result = result && (hasSelfInfo() == other.hasSelfInfo());
    if (hasSelfInfo()) {
      result = result && getSelfInfo()
          .equals(other.getSelfInfo());
    }
    result = result && (hasSelfRank() == other.hasSelfRank());
    if (hasSelfRank()) {
      result = result && (getSelfRank()
          == other.getSelfRank());
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
    if (getTopNCount() > 0) {
      hash = (37 * hash) + TOPN_FIELD_NUMBER;
      hash = (53 * hash) + getTopNList().hashCode();
    }
    if (hasSelfInfo()) {
      hash = (37 * hash) + SELFINFO_FIELD_NUMBER;
      hash = (53 * hash) + getSelfInfo().hashCode();
    }
    if (hasSelfRank()) {
      hash = (37 * hash) + SELFRANK_FIELD_NUMBER;
      hash = (53 * hash) + getSelfRank();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.dj.protobuf.leaderboard.RankGuildInfoNtf parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dj.protobuf.leaderboard.RankGuildInfoNtf parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dj.protobuf.leaderboard.RankGuildInfoNtf parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dj.protobuf.leaderboard.RankGuildInfoNtf parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dj.protobuf.leaderboard.RankGuildInfoNtf parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.leaderboard.RankGuildInfoNtf parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.dj.protobuf.leaderboard.RankGuildInfoNtf parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.leaderboard.RankGuildInfoNtf parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.dj.protobuf.leaderboard.RankGuildInfoNtf parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.leaderboard.RankGuildInfoNtf parseFrom(
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
  public static Builder newBuilder(com.dj.protobuf.leaderboard.RankGuildInfoNtf prototype) {
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
   * Protobuf type {@code Protocols.RankGuildInfoNtf}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:Protocols.RankGuildInfoNtf)
      com.dj.protobuf.leaderboard.RankGuildInfoNtfOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.dj.protobuf.leaderboard.Leaderboard.internal_static_Protocols_RankGuildInfoNtf_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.dj.protobuf.leaderboard.Leaderboard.internal_static_Protocols_RankGuildInfoNtf_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.dj.protobuf.leaderboard.RankGuildInfoNtf.class, com.dj.protobuf.leaderboard.RankGuildInfoNtf.Builder.class);
    }

    // Construct using com.dj.protobuf.leaderboard.RankGuildInfoNtf.newBuilder()
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
        getTopNFieldBuilder();
        getSelfInfoFieldBuilder();
      }
    }
    public Builder clear() {
      super.clear();
      if (topNBuilder_ == null) {
        topN_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
      } else {
        topNBuilder_.clear();
      }
      if (selfInfoBuilder_ == null) {
        selfInfo_ = null;
      } else {
        selfInfoBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000002);
      selfRank_ = 0;
      bitField0_ = (bitField0_ & ~0x00000004);
      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.dj.protobuf.leaderboard.Leaderboard.internal_static_Protocols_RankGuildInfoNtf_descriptor;
    }

    public com.dj.protobuf.leaderboard.RankGuildInfoNtf getDefaultInstanceForType() {
      return com.dj.protobuf.leaderboard.RankGuildInfoNtf.getDefaultInstance();
    }

    public com.dj.protobuf.leaderboard.RankGuildInfoNtf build() {
      com.dj.protobuf.leaderboard.RankGuildInfoNtf result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public com.dj.protobuf.leaderboard.RankGuildInfoNtf buildPartial() {
      com.dj.protobuf.leaderboard.RankGuildInfoNtf result = new com.dj.protobuf.leaderboard.RankGuildInfoNtf(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      if (topNBuilder_ == null) {
        if (((bitField0_ & 0x00000001) == 0x00000001)) {
          topN_ = java.util.Collections.unmodifiableList(topN_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.topN_ = topN_;
      } else {
        result.topN_ = topNBuilder_.build();
      }
      if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
        to_bitField0_ |= 0x00000001;
      }
      if (selfInfoBuilder_ == null) {
        result.selfInfo_ = selfInfo_;
      } else {
        result.selfInfo_ = selfInfoBuilder_.build();
      }
      if (((from_bitField0_ & 0x00000004) == 0x00000004)) {
        to_bitField0_ |= 0x00000002;
      }
      result.selfRank_ = selfRank_;
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
      if (other instanceof com.dj.protobuf.leaderboard.RankGuildInfoNtf) {
        return mergeFrom((com.dj.protobuf.leaderboard.RankGuildInfoNtf)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.dj.protobuf.leaderboard.RankGuildInfoNtf other) {
      if (other == com.dj.protobuf.leaderboard.RankGuildInfoNtf.getDefaultInstance()) return this;
      if (topNBuilder_ == null) {
        if (!other.topN_.isEmpty()) {
          if (topN_.isEmpty()) {
            topN_ = other.topN_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensureTopNIsMutable();
            topN_.addAll(other.topN_);
          }
          onChanged();
        }
      } else {
        if (!other.topN_.isEmpty()) {
          if (topNBuilder_.isEmpty()) {
            topNBuilder_.dispose();
            topNBuilder_ = null;
            topN_ = other.topN_;
            bitField0_ = (bitField0_ & ~0x00000001);
            topNBuilder_ = 
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getTopNFieldBuilder() : null;
          } else {
            topNBuilder_.addAllMessages(other.topN_);
          }
        }
      }
      if (other.hasSelfInfo()) {
        mergeSelfInfo(other.getSelfInfo());
      }
      if (other.hasSelfRank()) {
        setSelfRank(other.getSelfRank());
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
      com.dj.protobuf.leaderboard.RankGuildInfoNtf parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.dj.protobuf.leaderboard.RankGuildInfoNtf) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private java.util.List<com.dj.protobuf.leaderboard.GuildRankInfo> topN_ =
      java.util.Collections.emptyList();
    private void ensureTopNIsMutable() {
      if (!((bitField0_ & 0x00000001) == 0x00000001)) {
        topN_ = new java.util.ArrayList<com.dj.protobuf.leaderboard.GuildRankInfo>(topN_);
        bitField0_ |= 0x00000001;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        com.dj.protobuf.leaderboard.GuildRankInfo, com.dj.protobuf.leaderboard.GuildRankInfo.Builder, com.dj.protobuf.leaderboard.GuildRankInfoOrBuilder> topNBuilder_;

    /**
     * <code>repeated .Protocols.GuildRankInfo topN = 1;</code>
     */
    public java.util.List<com.dj.protobuf.leaderboard.GuildRankInfo> getTopNList() {
      if (topNBuilder_ == null) {
        return java.util.Collections.unmodifiableList(topN_);
      } else {
        return topNBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .Protocols.GuildRankInfo topN = 1;</code>
     */
    public int getTopNCount() {
      if (topNBuilder_ == null) {
        return topN_.size();
      } else {
        return topNBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .Protocols.GuildRankInfo topN = 1;</code>
     */
    public com.dj.protobuf.leaderboard.GuildRankInfo getTopN(int index) {
      if (topNBuilder_ == null) {
        return topN_.get(index);
      } else {
        return topNBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .Protocols.GuildRankInfo topN = 1;</code>
     */
    public Builder setTopN(
        int index, com.dj.protobuf.leaderboard.GuildRankInfo value) {
      if (topNBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureTopNIsMutable();
        topN_.set(index, value);
        onChanged();
      } else {
        topNBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .Protocols.GuildRankInfo topN = 1;</code>
     */
    public Builder setTopN(
        int index, com.dj.protobuf.leaderboard.GuildRankInfo.Builder builderForValue) {
      if (topNBuilder_ == null) {
        ensureTopNIsMutable();
        topN_.set(index, builderForValue.build());
        onChanged();
      } else {
        topNBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .Protocols.GuildRankInfo topN = 1;</code>
     */
    public Builder addTopN(com.dj.protobuf.leaderboard.GuildRankInfo value) {
      if (topNBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureTopNIsMutable();
        topN_.add(value);
        onChanged();
      } else {
        topNBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .Protocols.GuildRankInfo topN = 1;</code>
     */
    public Builder addTopN(
        int index, com.dj.protobuf.leaderboard.GuildRankInfo value) {
      if (topNBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureTopNIsMutable();
        topN_.add(index, value);
        onChanged();
      } else {
        topNBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .Protocols.GuildRankInfo topN = 1;</code>
     */
    public Builder addTopN(
        com.dj.protobuf.leaderboard.GuildRankInfo.Builder builderForValue) {
      if (topNBuilder_ == null) {
        ensureTopNIsMutable();
        topN_.add(builderForValue.build());
        onChanged();
      } else {
        topNBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .Protocols.GuildRankInfo topN = 1;</code>
     */
    public Builder addTopN(
        int index, com.dj.protobuf.leaderboard.GuildRankInfo.Builder builderForValue) {
      if (topNBuilder_ == null) {
        ensureTopNIsMutable();
        topN_.add(index, builderForValue.build());
        onChanged();
      } else {
        topNBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .Protocols.GuildRankInfo topN = 1;</code>
     */
    public Builder addAllTopN(
        java.lang.Iterable<? extends com.dj.protobuf.leaderboard.GuildRankInfo> values) {
      if (topNBuilder_ == null) {
        ensureTopNIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, topN_);
        onChanged();
      } else {
        topNBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .Protocols.GuildRankInfo topN = 1;</code>
     */
    public Builder clearTopN() {
      if (topNBuilder_ == null) {
        topN_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
      } else {
        topNBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .Protocols.GuildRankInfo topN = 1;</code>
     */
    public Builder removeTopN(int index) {
      if (topNBuilder_ == null) {
        ensureTopNIsMutable();
        topN_.remove(index);
        onChanged();
      } else {
        topNBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .Protocols.GuildRankInfo topN = 1;</code>
     */
    public com.dj.protobuf.leaderboard.GuildRankInfo.Builder getTopNBuilder(
        int index) {
      return getTopNFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .Protocols.GuildRankInfo topN = 1;</code>
     */
    public com.dj.protobuf.leaderboard.GuildRankInfoOrBuilder getTopNOrBuilder(
        int index) {
      if (topNBuilder_ == null) {
        return topN_.get(index);  } else {
        return topNBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .Protocols.GuildRankInfo topN = 1;</code>
     */
    public java.util.List<? extends com.dj.protobuf.leaderboard.GuildRankInfoOrBuilder> 
         getTopNOrBuilderList() {
      if (topNBuilder_ != null) {
        return topNBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(topN_);
      }
    }
    /**
     * <code>repeated .Protocols.GuildRankInfo topN = 1;</code>
     */
    public com.dj.protobuf.leaderboard.GuildRankInfo.Builder addTopNBuilder() {
      return getTopNFieldBuilder().addBuilder(
          com.dj.protobuf.leaderboard.GuildRankInfo.getDefaultInstance());
    }
    /**
     * <code>repeated .Protocols.GuildRankInfo topN = 1;</code>
     */
    public com.dj.protobuf.leaderboard.GuildRankInfo.Builder addTopNBuilder(
        int index) {
      return getTopNFieldBuilder().addBuilder(
          index, com.dj.protobuf.leaderboard.GuildRankInfo.getDefaultInstance());
    }
    /**
     * <code>repeated .Protocols.GuildRankInfo topN = 1;</code>
     */
    public java.util.List<com.dj.protobuf.leaderboard.GuildRankInfo.Builder> 
         getTopNBuilderList() {
      return getTopNFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        com.dj.protobuf.leaderboard.GuildRankInfo, com.dj.protobuf.leaderboard.GuildRankInfo.Builder, com.dj.protobuf.leaderboard.GuildRankInfoOrBuilder> 
        getTopNFieldBuilder() {
      if (topNBuilder_ == null) {
        topNBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            com.dj.protobuf.leaderboard.GuildRankInfo, com.dj.protobuf.leaderboard.GuildRankInfo.Builder, com.dj.protobuf.leaderboard.GuildRankInfoOrBuilder>(
                topN_,
                ((bitField0_ & 0x00000001) == 0x00000001),
                getParentForChildren(),
                isClean());
        topN_ = null;
      }
      return topNBuilder_;
    }

    private com.dj.protobuf.leaderboard.GuildRankInfo selfInfo_ = null;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.dj.protobuf.leaderboard.GuildRankInfo, com.dj.protobuf.leaderboard.GuildRankInfo.Builder, com.dj.protobuf.leaderboard.GuildRankInfoOrBuilder> selfInfoBuilder_;
    /**
     * <code>optional .Protocols.GuildRankInfo selfInfo = 2;</code>
     */
    public boolean hasSelfInfo() {
      return ((bitField0_ & 0x00000002) == 0x00000002);
    }
    /**
     * <code>optional .Protocols.GuildRankInfo selfInfo = 2;</code>
     */
    public com.dj.protobuf.leaderboard.GuildRankInfo getSelfInfo() {
      if (selfInfoBuilder_ == null) {
        return selfInfo_ == null ? com.dj.protobuf.leaderboard.GuildRankInfo.getDefaultInstance() : selfInfo_;
      } else {
        return selfInfoBuilder_.getMessage();
      }
    }
    /**
     * <code>optional .Protocols.GuildRankInfo selfInfo = 2;</code>
     */
    public Builder setSelfInfo(com.dj.protobuf.leaderboard.GuildRankInfo value) {
      if (selfInfoBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        selfInfo_ = value;
        onChanged();
      } else {
        selfInfoBuilder_.setMessage(value);
      }
      bitField0_ |= 0x00000002;
      return this;
    }
    /**
     * <code>optional .Protocols.GuildRankInfo selfInfo = 2;</code>
     */
    public Builder setSelfInfo(
        com.dj.protobuf.leaderboard.GuildRankInfo.Builder builderForValue) {
      if (selfInfoBuilder_ == null) {
        selfInfo_ = builderForValue.build();
        onChanged();
      } else {
        selfInfoBuilder_.setMessage(builderForValue.build());
      }
      bitField0_ |= 0x00000002;
      return this;
    }
    /**
     * <code>optional .Protocols.GuildRankInfo selfInfo = 2;</code>
     */
    public Builder mergeSelfInfo(com.dj.protobuf.leaderboard.GuildRankInfo value) {
      if (selfInfoBuilder_ == null) {
        if (((bitField0_ & 0x00000002) == 0x00000002) &&
            selfInfo_ != null &&
            selfInfo_ != com.dj.protobuf.leaderboard.GuildRankInfo.getDefaultInstance()) {
          selfInfo_ =
            com.dj.protobuf.leaderboard.GuildRankInfo.newBuilder(selfInfo_).mergeFrom(value).buildPartial();
        } else {
          selfInfo_ = value;
        }
        onChanged();
      } else {
        selfInfoBuilder_.mergeFrom(value);
      }
      bitField0_ |= 0x00000002;
      return this;
    }
    /**
     * <code>optional .Protocols.GuildRankInfo selfInfo = 2;</code>
     */
    public Builder clearSelfInfo() {
      if (selfInfoBuilder_ == null) {
        selfInfo_ = null;
        onChanged();
      } else {
        selfInfoBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000002);
      return this;
    }
    /**
     * <code>optional .Protocols.GuildRankInfo selfInfo = 2;</code>
     */
    public com.dj.protobuf.leaderboard.GuildRankInfo.Builder getSelfInfoBuilder() {
      bitField0_ |= 0x00000002;
      onChanged();
      return getSelfInfoFieldBuilder().getBuilder();
    }
    /**
     * <code>optional .Protocols.GuildRankInfo selfInfo = 2;</code>
     */
    public com.dj.protobuf.leaderboard.GuildRankInfoOrBuilder getSelfInfoOrBuilder() {
      if (selfInfoBuilder_ != null) {
        return selfInfoBuilder_.getMessageOrBuilder();
      } else {
        return selfInfo_ == null ?
            com.dj.protobuf.leaderboard.GuildRankInfo.getDefaultInstance() : selfInfo_;
      }
    }
    /**
     * <code>optional .Protocols.GuildRankInfo selfInfo = 2;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.dj.protobuf.leaderboard.GuildRankInfo, com.dj.protobuf.leaderboard.GuildRankInfo.Builder, com.dj.protobuf.leaderboard.GuildRankInfoOrBuilder> 
        getSelfInfoFieldBuilder() {
      if (selfInfoBuilder_ == null) {
        selfInfoBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.dj.protobuf.leaderboard.GuildRankInfo, com.dj.protobuf.leaderboard.GuildRankInfo.Builder, com.dj.protobuf.leaderboard.GuildRankInfoOrBuilder>(
                getSelfInfo(),
                getParentForChildren(),
                isClean());
        selfInfo_ = null;
      }
      return selfInfoBuilder_;
    }

    private int selfRank_ ;
    /**
     * <code>optional int32 selfRank = 3;</code>
     */
    public boolean hasSelfRank() {
      return ((bitField0_ & 0x00000004) == 0x00000004);
    }
    /**
     * <code>optional int32 selfRank = 3;</code>
     */
    public int getSelfRank() {
      return selfRank_;
    }
    /**
     * <code>optional int32 selfRank = 3;</code>
     */
    public Builder setSelfRank(int value) {
      bitField0_ |= 0x00000004;
      selfRank_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional int32 selfRank = 3;</code>
     */
    public Builder clearSelfRank() {
      bitField0_ = (bitField0_ & ~0x00000004);
      selfRank_ = 0;
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


    // @@protoc_insertion_point(builder_scope:Protocols.RankGuildInfoNtf)
  }

  // @@protoc_insertion_point(class_scope:Protocols.RankGuildInfoNtf)
  private static final com.dj.protobuf.leaderboard.RankGuildInfoNtf DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.dj.protobuf.leaderboard.RankGuildInfoNtf();
  }

  public static com.dj.protobuf.leaderboard.RankGuildInfoNtf getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  @java.lang.Deprecated public static final com.google.protobuf.Parser<RankGuildInfoNtf>
      PARSER = new com.google.protobuf.AbstractParser<RankGuildInfoNtf>() {
    public RankGuildInfoNtf parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new RankGuildInfoNtf(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<RankGuildInfoNtf> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<RankGuildInfoNtf> getParserForType() {
    return PARSER;
  }

  public com.dj.protobuf.leaderboard.RankGuildInfoNtf getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

