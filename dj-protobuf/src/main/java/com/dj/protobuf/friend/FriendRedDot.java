// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Friend.proto

package com.dj.protobuf.friend;

/**
 * <pre>
 *好友红点数据
 * </pre>
 *
 * Protobuf type {@code Protocols.FriendRedDot}
 */
public  final class FriendRedDot extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:Protocols.FriendRedDot)
    FriendRedDotOrBuilder {
  // Use FriendRedDot.newBuilder() to construct.
  private FriendRedDot(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private FriendRedDot() {
    verifyingCount_ = 0;
    feedCount_ = 0;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private FriendRedDot(
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
            verifyingCount_ = input.readInt32();
            break;
          }
          case 16: {
            bitField0_ |= 0x00000002;
            feedCount_ = input.readInt32();
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
    return com.dj.protobuf.friend.Friend.internal_static_Protocols_FriendRedDot_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.dj.protobuf.friend.Friend.internal_static_Protocols_FriendRedDot_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.dj.protobuf.friend.FriendRedDot.class, com.dj.protobuf.friend.FriendRedDot.Builder.class);
  }

  private int bitField0_;
  public static final int VERIFYINGCOUNT_FIELD_NUMBER = 1;
  private int verifyingCount_;
  /**
   * <pre>
   *待鉴定数量
   * </pre>
   *
   * <code>optional int32 verifyingCount = 1;</code>
   */
  public boolean hasVerifyingCount() {
    return ((bitField0_ & 0x00000001) == 0x00000001);
  }
  /**
   * <pre>
   *待鉴定数量
   * </pre>
   *
   * <code>optional int32 verifyingCount = 1;</code>
   */
  public int getVerifyingCount() {
    return verifyingCount_;
  }

  public static final int FEEDCOUNT_FIELD_NUMBER = 2;
  private int feedCount_;
  /**
   * <pre>
   *生态园待喂动物数量
   * </pre>
   *
   * <code>optional int32 feedCount = 2;</code>
   */
  public boolean hasFeedCount() {
    return ((bitField0_ & 0x00000002) == 0x00000002);
  }
  /**
   * <pre>
   *生态园待喂动物数量
   * </pre>
   *
   * <code>optional int32 feedCount = 2;</code>
   */
  public int getFeedCount() {
    return feedCount_;
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
      output.writeInt32(1, verifyingCount_);
    }
    if (((bitField0_ & 0x00000002) == 0x00000002)) {
      output.writeInt32(2, feedCount_);
    }
    unknownFields.writeTo(output);
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (((bitField0_ & 0x00000001) == 0x00000001)) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(1, verifyingCount_);
    }
    if (((bitField0_ & 0x00000002) == 0x00000002)) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(2, feedCount_);
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
    if (!(obj instanceof com.dj.protobuf.friend.FriendRedDot)) {
      return super.equals(obj);
    }
    com.dj.protobuf.friend.FriendRedDot other = (com.dj.protobuf.friend.FriendRedDot) obj;

    boolean result = true;
    result = result && (hasVerifyingCount() == other.hasVerifyingCount());
    if (hasVerifyingCount()) {
      result = result && (getVerifyingCount()
          == other.getVerifyingCount());
    }
    result = result && (hasFeedCount() == other.hasFeedCount());
    if (hasFeedCount()) {
      result = result && (getFeedCount()
          == other.getFeedCount());
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
    if (hasVerifyingCount()) {
      hash = (37 * hash) + VERIFYINGCOUNT_FIELD_NUMBER;
      hash = (53 * hash) + getVerifyingCount();
    }
    if (hasFeedCount()) {
      hash = (37 * hash) + FEEDCOUNT_FIELD_NUMBER;
      hash = (53 * hash) + getFeedCount();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.dj.protobuf.friend.FriendRedDot parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dj.protobuf.friend.FriendRedDot parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dj.protobuf.friend.FriendRedDot parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dj.protobuf.friend.FriendRedDot parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dj.protobuf.friend.FriendRedDot parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.friend.FriendRedDot parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.dj.protobuf.friend.FriendRedDot parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.friend.FriendRedDot parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.dj.protobuf.friend.FriendRedDot parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.friend.FriendRedDot parseFrom(
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
  public static Builder newBuilder(com.dj.protobuf.friend.FriendRedDot prototype) {
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
   *好友红点数据
   * </pre>
   *
   * Protobuf type {@code Protocols.FriendRedDot}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:Protocols.FriendRedDot)
      com.dj.protobuf.friend.FriendRedDotOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.dj.protobuf.friend.Friend.internal_static_Protocols_FriendRedDot_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.dj.protobuf.friend.Friend.internal_static_Protocols_FriendRedDot_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.dj.protobuf.friend.FriendRedDot.class, com.dj.protobuf.friend.FriendRedDot.Builder.class);
    }

    // Construct using com.dj.protobuf.friend.FriendRedDot.newBuilder()
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
      verifyingCount_ = 0;
      bitField0_ = (bitField0_ & ~0x00000001);
      feedCount_ = 0;
      bitField0_ = (bitField0_ & ~0x00000002);
      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.dj.protobuf.friend.Friend.internal_static_Protocols_FriendRedDot_descriptor;
    }

    public com.dj.protobuf.friend.FriendRedDot getDefaultInstanceForType() {
      return com.dj.protobuf.friend.FriendRedDot.getDefaultInstance();
    }

    public com.dj.protobuf.friend.FriendRedDot build() {
      com.dj.protobuf.friend.FriendRedDot result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public com.dj.protobuf.friend.FriendRedDot buildPartial() {
      com.dj.protobuf.friend.FriendRedDot result = new com.dj.protobuf.friend.FriendRedDot(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
        to_bitField0_ |= 0x00000001;
      }
      result.verifyingCount_ = verifyingCount_;
      if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
        to_bitField0_ |= 0x00000002;
      }
      result.feedCount_ = feedCount_;
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
      if (other instanceof com.dj.protobuf.friend.FriendRedDot) {
        return mergeFrom((com.dj.protobuf.friend.FriendRedDot)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.dj.protobuf.friend.FriendRedDot other) {
      if (other == com.dj.protobuf.friend.FriendRedDot.getDefaultInstance()) return this;
      if (other.hasVerifyingCount()) {
        setVerifyingCount(other.getVerifyingCount());
      }
      if (other.hasFeedCount()) {
        setFeedCount(other.getFeedCount());
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
      com.dj.protobuf.friend.FriendRedDot parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.dj.protobuf.friend.FriendRedDot) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private int verifyingCount_ ;
    /**
     * <pre>
     *待鉴定数量
     * </pre>
     *
     * <code>optional int32 verifyingCount = 1;</code>
     */
    public boolean hasVerifyingCount() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <pre>
     *待鉴定数量
     * </pre>
     *
     * <code>optional int32 verifyingCount = 1;</code>
     */
    public int getVerifyingCount() {
      return verifyingCount_;
    }
    /**
     * <pre>
     *待鉴定数量
     * </pre>
     *
     * <code>optional int32 verifyingCount = 1;</code>
     */
    public Builder setVerifyingCount(int value) {
      bitField0_ |= 0x00000001;
      verifyingCount_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     *待鉴定数量
     * </pre>
     *
     * <code>optional int32 verifyingCount = 1;</code>
     */
    public Builder clearVerifyingCount() {
      bitField0_ = (bitField0_ & ~0x00000001);
      verifyingCount_ = 0;
      onChanged();
      return this;
    }

    private int feedCount_ ;
    /**
     * <pre>
     *生态园待喂动物数量
     * </pre>
     *
     * <code>optional int32 feedCount = 2;</code>
     */
    public boolean hasFeedCount() {
      return ((bitField0_ & 0x00000002) == 0x00000002);
    }
    /**
     * <pre>
     *生态园待喂动物数量
     * </pre>
     *
     * <code>optional int32 feedCount = 2;</code>
     */
    public int getFeedCount() {
      return feedCount_;
    }
    /**
     * <pre>
     *生态园待喂动物数量
     * </pre>
     *
     * <code>optional int32 feedCount = 2;</code>
     */
    public Builder setFeedCount(int value) {
      bitField0_ |= 0x00000002;
      feedCount_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     *生态园待喂动物数量
     * </pre>
     *
     * <code>optional int32 feedCount = 2;</code>
     */
    public Builder clearFeedCount() {
      bitField0_ = (bitField0_ & ~0x00000002);
      feedCount_ = 0;
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


    // @@protoc_insertion_point(builder_scope:Protocols.FriendRedDot)
  }

  // @@protoc_insertion_point(class_scope:Protocols.FriendRedDot)
  private static final com.dj.protobuf.friend.FriendRedDot DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.dj.protobuf.friend.FriendRedDot();
  }

  public static com.dj.protobuf.friend.FriendRedDot getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  @java.lang.Deprecated public static final com.google.protobuf.Parser<FriendRedDot>
      PARSER = new com.google.protobuf.AbstractParser<FriendRedDot>() {
    public FriendRedDot parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new FriendRedDot(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<FriendRedDot> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<FriendRedDot> getParserForType() {
    return PARSER;
  }

  public com.dj.protobuf.friend.FriendRedDot getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
