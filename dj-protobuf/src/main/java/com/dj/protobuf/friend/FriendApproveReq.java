// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Friend.proto

package com.dj.protobuf.friend;

/**
 * Protobuf type {@code Protocols.FriendApproveReq}
 */
public  final class FriendApproveReq extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:Protocols.FriendApproveReq)
    FriendApproveReqOrBuilder {
  // Use FriendApproveReq.newBuilder() to construct.
  private FriendApproveReq(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private FriendApproveReq() {
    targetRoleId_ = java.util.Collections.emptyList();
    agree_ = false;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private FriendApproveReq(
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
            if (!((mutable_bitField0_ & 0x00000001) == 0x00000001)) {
              targetRoleId_ = new java.util.ArrayList<java.lang.Long>();
              mutable_bitField0_ |= 0x00000001;
            }
            targetRoleId_.add(input.readUInt64());
            break;
          }
          case 10: {
            int length = input.readRawVarint32();
            int limit = input.pushLimit(length);
            if (!((mutable_bitField0_ & 0x00000001) == 0x00000001) && input.getBytesUntilLimit() > 0) {
              targetRoleId_ = new java.util.ArrayList<java.lang.Long>();
              mutable_bitField0_ |= 0x00000001;
            }
            while (input.getBytesUntilLimit() > 0) {
              targetRoleId_.add(input.readUInt64());
            }
            input.popLimit(limit);
            break;
          }
          case 16: {
            bitField0_ |= 0x00000001;
            agree_ = input.readBool();
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
        targetRoleId_ = java.util.Collections.unmodifiableList(targetRoleId_);
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.dj.protobuf.friend.Friend.internal_static_Protocols_FriendApproveReq_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.dj.protobuf.friend.Friend.internal_static_Protocols_FriendApproveReq_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.dj.protobuf.friend.FriendApproveReq.class, com.dj.protobuf.friend.FriendApproveReq.Builder.class);
  }

  private int bitField0_;
  public static final int TARGETROLEID_FIELD_NUMBER = 1;
  private java.util.List<java.lang.Long> targetRoleId_;
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 发起加好友的玩家
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>repeated uint64 targetRoleId = 1;</code>
   */
  public java.util.List<java.lang.Long>
      getTargetRoleIdList() {
    return targetRoleId_;
  }
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 发起加好友的玩家
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>repeated uint64 targetRoleId = 1;</code>
   */
  public int getTargetRoleIdCount() {
    return targetRoleId_.size();
  }
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 发起加好友的玩家
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>repeated uint64 targetRoleId = 1;</code>
   */
  public long getTargetRoleId(int index) {
    return targetRoleId_.get(index);
  }

  public static final int AGREE_FIELD_NUMBER = 2;
  private boolean agree_;
  /**
   * <code>optional bool agree = 2;</code>
   */
  public boolean hasAgree() {
    return ((bitField0_ & 0x00000001) == 0x00000001);
  }
  /**
   * <code>optional bool agree = 2;</code>
   */
  public boolean getAgree() {
    return agree_;
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
    for (int i = 0; i < targetRoleId_.size(); i++) {
      output.writeUInt64(1, targetRoleId_.get(i));
    }
    if (((bitField0_ & 0x00000001) == 0x00000001)) {
      output.writeBool(2, agree_);
    }
    unknownFields.writeTo(output);
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    {
      int dataSize = 0;
      for (int i = 0; i < targetRoleId_.size(); i++) {
        dataSize += com.google.protobuf.CodedOutputStream
          .computeUInt64SizeNoTag(targetRoleId_.get(i));
      }
      size += dataSize;
      size += 1 * getTargetRoleIdList().size();
    }
    if (((bitField0_ & 0x00000001) == 0x00000001)) {
      size += com.google.protobuf.CodedOutputStream
        .computeBoolSize(2, agree_);
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
    if (!(obj instanceof com.dj.protobuf.friend.FriendApproveReq)) {
      return super.equals(obj);
    }
    com.dj.protobuf.friend.FriendApproveReq other = (com.dj.protobuf.friend.FriendApproveReq) obj;

    boolean result = true;
    result = result && getTargetRoleIdList()
        .equals(other.getTargetRoleIdList());
    result = result && (hasAgree() == other.hasAgree());
    if (hasAgree()) {
      result = result && (getAgree()
          == other.getAgree());
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
    if (getTargetRoleIdCount() > 0) {
      hash = (37 * hash) + TARGETROLEID_FIELD_NUMBER;
      hash = (53 * hash) + getTargetRoleIdList().hashCode();
    }
    if (hasAgree()) {
      hash = (37 * hash) + AGREE_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
          getAgree());
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.dj.protobuf.friend.FriendApproveReq parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dj.protobuf.friend.FriendApproveReq parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dj.protobuf.friend.FriendApproveReq parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dj.protobuf.friend.FriendApproveReq parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dj.protobuf.friend.FriendApproveReq parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.friend.FriendApproveReq parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.dj.protobuf.friend.FriendApproveReq parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.friend.FriendApproveReq parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.dj.protobuf.friend.FriendApproveReq parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.friend.FriendApproveReq parseFrom(
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
  public static Builder newBuilder(com.dj.protobuf.friend.FriendApproveReq prototype) {
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
   * Protobuf type {@code Protocols.FriendApproveReq}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:Protocols.FriendApproveReq)
      com.dj.protobuf.friend.FriendApproveReqOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.dj.protobuf.friend.Friend.internal_static_Protocols_FriendApproveReq_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.dj.protobuf.friend.Friend.internal_static_Protocols_FriendApproveReq_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.dj.protobuf.friend.FriendApproveReq.class, com.dj.protobuf.friend.FriendApproveReq.Builder.class);
    }

    // Construct using com.dj.protobuf.friend.FriendApproveReq.newBuilder()
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
      targetRoleId_ = java.util.Collections.emptyList();
      bitField0_ = (bitField0_ & ~0x00000001);
      agree_ = false;
      bitField0_ = (bitField0_ & ~0x00000002);
      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.dj.protobuf.friend.Friend.internal_static_Protocols_FriendApproveReq_descriptor;
    }

    public com.dj.protobuf.friend.FriendApproveReq getDefaultInstanceForType() {
      return com.dj.protobuf.friend.FriendApproveReq.getDefaultInstance();
    }

    public com.dj.protobuf.friend.FriendApproveReq build() {
      com.dj.protobuf.friend.FriendApproveReq result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public com.dj.protobuf.friend.FriendApproveReq buildPartial() {
      com.dj.protobuf.friend.FriendApproveReq result = new com.dj.protobuf.friend.FriendApproveReq(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        targetRoleId_ = java.util.Collections.unmodifiableList(targetRoleId_);
        bitField0_ = (bitField0_ & ~0x00000001);
      }
      result.targetRoleId_ = targetRoleId_;
      if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
        to_bitField0_ |= 0x00000001;
      }
      result.agree_ = agree_;
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
      if (other instanceof com.dj.protobuf.friend.FriendApproveReq) {
        return mergeFrom((com.dj.protobuf.friend.FriendApproveReq)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.dj.protobuf.friend.FriendApproveReq other) {
      if (other == com.dj.protobuf.friend.FriendApproveReq.getDefaultInstance()) return this;
      if (!other.targetRoleId_.isEmpty()) {
        if (targetRoleId_.isEmpty()) {
          targetRoleId_ = other.targetRoleId_;
          bitField0_ = (bitField0_ & ~0x00000001);
        } else {
          ensureTargetRoleIdIsMutable();
          targetRoleId_.addAll(other.targetRoleId_);
        }
        onChanged();
      }
      if (other.hasAgree()) {
        setAgree(other.getAgree());
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
      com.dj.protobuf.friend.FriendApproveReq parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.dj.protobuf.friend.FriendApproveReq) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private java.util.List<java.lang.Long> targetRoleId_ = java.util.Collections.emptyList();
    private void ensureTargetRoleIdIsMutable() {
      if (!((bitField0_ & 0x00000001) == 0x00000001)) {
        targetRoleId_ = new java.util.ArrayList<java.lang.Long>(targetRoleId_);
        bitField0_ |= 0x00000001;
       }
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 发起加好友的玩家
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>repeated uint64 targetRoleId = 1;</code>
     */
    public java.util.List<java.lang.Long>
        getTargetRoleIdList() {
      return java.util.Collections.unmodifiableList(targetRoleId_);
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 发起加好友的玩家
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>repeated uint64 targetRoleId = 1;</code>
     */
    public int getTargetRoleIdCount() {
      return targetRoleId_.size();
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 发起加好友的玩家
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>repeated uint64 targetRoleId = 1;</code>
     */
    public long getTargetRoleId(int index) {
      return targetRoleId_.get(index);
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 发起加好友的玩家
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>repeated uint64 targetRoleId = 1;</code>
     */
    public Builder setTargetRoleId(
        int index, long value) {
      ensureTargetRoleIdIsMutable();
      targetRoleId_.set(index, value);
      onChanged();
      return this;
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 发起加好友的玩家
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>repeated uint64 targetRoleId = 1;</code>
     */
    public Builder addTargetRoleId(long value) {
      ensureTargetRoleIdIsMutable();
      targetRoleId_.add(value);
      onChanged();
      return this;
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 发起加好友的玩家
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>repeated uint64 targetRoleId = 1;</code>
     */
    public Builder addAllTargetRoleId(
        java.lang.Iterable<? extends java.lang.Long> values) {
      ensureTargetRoleIdIsMutable();
      com.google.protobuf.AbstractMessageLite.Builder.addAll(
          values, targetRoleId_);
      onChanged();
      return this;
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 发起加好友的玩家
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>repeated uint64 targetRoleId = 1;</code>
     */
    public Builder clearTargetRoleId() {
      targetRoleId_ = java.util.Collections.emptyList();
      bitField0_ = (bitField0_ & ~0x00000001);
      onChanged();
      return this;
    }

    private boolean agree_ ;
    /**
     * <code>optional bool agree = 2;</code>
     */
    public boolean hasAgree() {
      return ((bitField0_ & 0x00000002) == 0x00000002);
    }
    /**
     * <code>optional bool agree = 2;</code>
     */
    public boolean getAgree() {
      return agree_;
    }
    /**
     * <code>optional bool agree = 2;</code>
     */
    public Builder setAgree(boolean value) {
      bitField0_ |= 0x00000002;
      agree_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional bool agree = 2;</code>
     */
    public Builder clearAgree() {
      bitField0_ = (bitField0_ & ~0x00000002);
      agree_ = false;
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


    // @@protoc_insertion_point(builder_scope:Protocols.FriendApproveReq)
  }

  // @@protoc_insertion_point(class_scope:Protocols.FriendApproveReq)
  private static final com.dj.protobuf.friend.FriendApproveReq DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.dj.protobuf.friend.FriendApproveReq();
  }

  public static com.dj.protobuf.friend.FriendApproveReq getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  @java.lang.Deprecated public static final com.google.protobuf.Parser<FriendApproveReq>
      PARSER = new com.google.protobuf.AbstractParser<FriendApproveReq>() {
    public FriendApproveReq parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new FriendApproveReq(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<FriendApproveReq> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<FriendApproveReq> getParserForType() {
    return PARSER;
  }

  public com.dj.protobuf.friend.FriendApproveReq getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

