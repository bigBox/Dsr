// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Friend.proto

package com.dj.protobuf.friend;

/**
 * Protobuf type {@code Protocols.FriendApproveNtf}
 */
public  final class FriendApproveNtf extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:Protocols.FriendApproveNtf)
    FriendApproveNtfOrBuilder {
  // Use FriendApproveNtf.newBuilder() to construct.
  private FriendApproveNtf(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private FriendApproveNtf() {
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private FriendApproveNtf(
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
            com.dj.protobuf.friend.FriendInfo.Builder subBuilder = null;
            if (((bitField0_ & 0x00000001) == 0x00000001)) {
              subBuilder = roleInfo_.toBuilder();
            }
            roleInfo_ = input.readMessage(com.dj.protobuf.friend.FriendInfo.PARSER, extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(roleInfo_);
              roleInfo_ = subBuilder.buildPartial();
            }
            bitField0_ |= 0x00000001;
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
    return com.dj.protobuf.friend.Friend.internal_static_Protocols_FriendApproveNtf_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.dj.protobuf.friend.Friend.internal_static_Protocols_FriendApproveNtf_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.dj.protobuf.friend.FriendApproveNtf.class, com.dj.protobuf.friend.FriendApproveNtf.Builder.class);
  }

  private int bitField0_;
  public static final int ROLEINFO_FIELD_NUMBER = 1;
  private com.dj.protobuf.friend.FriendInfo roleInfo_;
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / ????????????????????????
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional .Protocols.FriendInfo roleInfo = 1;</code>
   */
  public boolean hasRoleInfo() {
    return ((bitField0_ & 0x00000001) == 0x00000001);
  }
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / ????????????????????????
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional .Protocols.FriendInfo roleInfo = 1;</code>
   */
  public com.dj.protobuf.friend.FriendInfo getRoleInfo() {
    return roleInfo_ == null ? com.dj.protobuf.friend.FriendInfo.getDefaultInstance() : roleInfo_;
  }
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / ????????????????????????
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional .Protocols.FriendInfo roleInfo = 1;</code>
   */
  public com.dj.protobuf.friend.FriendInfoOrBuilder getRoleInfoOrBuilder() {
    return roleInfo_ == null ? com.dj.protobuf.friend.FriendInfo.getDefaultInstance() : roleInfo_;
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
      output.writeMessage(1, getRoleInfo());
    }
    unknownFields.writeTo(output);
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (((bitField0_ & 0x00000001) == 0x00000001)) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, getRoleInfo());
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
    if (!(obj instanceof com.dj.protobuf.friend.FriendApproveNtf)) {
      return super.equals(obj);
    }
    com.dj.protobuf.friend.FriendApproveNtf other = (com.dj.protobuf.friend.FriendApproveNtf) obj;

    boolean result = true;
    result = result && (hasRoleInfo() == other.hasRoleInfo());
    if (hasRoleInfo()) {
      result = result && getRoleInfo()
          .equals(other.getRoleInfo());
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
    if (hasRoleInfo()) {
      hash = (37 * hash) + ROLEINFO_FIELD_NUMBER;
      hash = (53 * hash) + getRoleInfo().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.dj.protobuf.friend.FriendApproveNtf parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dj.protobuf.friend.FriendApproveNtf parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dj.protobuf.friend.FriendApproveNtf parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dj.protobuf.friend.FriendApproveNtf parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dj.protobuf.friend.FriendApproveNtf parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.friend.FriendApproveNtf parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.dj.protobuf.friend.FriendApproveNtf parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.friend.FriendApproveNtf parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.dj.protobuf.friend.FriendApproveNtf parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.friend.FriendApproveNtf parseFrom(
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
  public static Builder newBuilder(com.dj.protobuf.friend.FriendApproveNtf prototype) {
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
   * Protobuf type {@code Protocols.FriendApproveNtf}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:Protocols.FriendApproveNtf)
      com.dj.protobuf.friend.FriendApproveNtfOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.dj.protobuf.friend.Friend.internal_static_Protocols_FriendApproveNtf_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.dj.protobuf.friend.Friend.internal_static_Protocols_FriendApproveNtf_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.dj.protobuf.friend.FriendApproveNtf.class, com.dj.protobuf.friend.FriendApproveNtf.Builder.class);
    }

    // Construct using com.dj.protobuf.friend.FriendApproveNtf.newBuilder()
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
        getRoleInfoFieldBuilder();
      }
    }
    public Builder clear() {
      super.clear();
      if (roleInfoBuilder_ == null) {
        roleInfo_ = null;
      } else {
        roleInfoBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000001);
      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.dj.protobuf.friend.Friend.internal_static_Protocols_FriendApproveNtf_descriptor;
    }

    public com.dj.protobuf.friend.FriendApproveNtf getDefaultInstanceForType() {
      return com.dj.protobuf.friend.FriendApproveNtf.getDefaultInstance();
    }

    public com.dj.protobuf.friend.FriendApproveNtf build() {
      com.dj.protobuf.friend.FriendApproveNtf result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public com.dj.protobuf.friend.FriendApproveNtf buildPartial() {
      com.dj.protobuf.friend.FriendApproveNtf result = new com.dj.protobuf.friend.FriendApproveNtf(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
        to_bitField0_ |= 0x00000001;
      }
      if (roleInfoBuilder_ == null) {
        result.roleInfo_ = roleInfo_;
      } else {
        result.roleInfo_ = roleInfoBuilder_.build();
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
      if (other instanceof com.dj.protobuf.friend.FriendApproveNtf) {
        return mergeFrom((com.dj.protobuf.friend.FriendApproveNtf)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.dj.protobuf.friend.FriendApproveNtf other) {
      if (other == com.dj.protobuf.friend.FriendApproveNtf.getDefaultInstance()) return this;
      if (other.hasRoleInfo()) {
        mergeRoleInfo(other.getRoleInfo());
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
      com.dj.protobuf.friend.FriendApproveNtf parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.dj.protobuf.friend.FriendApproveNtf) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private com.dj.protobuf.friend.FriendInfo roleInfo_ = null;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.dj.protobuf.friend.FriendInfo, com.dj.protobuf.friend.FriendInfo.Builder, com.dj.protobuf.friend.FriendInfoOrBuilder> roleInfoBuilder_;
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / ????????????????????????
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional .Protocols.FriendInfo roleInfo = 1;</code>
     */
    public boolean hasRoleInfo() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / ????????????????????????
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional .Protocols.FriendInfo roleInfo = 1;</code>
     */
    public com.dj.protobuf.friend.FriendInfo getRoleInfo() {
      if (roleInfoBuilder_ == null) {
        return roleInfo_ == null ? com.dj.protobuf.friend.FriendInfo.getDefaultInstance() : roleInfo_;
      } else {
        return roleInfoBuilder_.getMessage();
      }
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / ????????????????????????
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional .Protocols.FriendInfo roleInfo = 1;</code>
     */
    public Builder setRoleInfo(com.dj.protobuf.friend.FriendInfo value) {
      if (roleInfoBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        roleInfo_ = value;
        onChanged();
      } else {
        roleInfoBuilder_.setMessage(value);
      }
      bitField0_ |= 0x00000001;
      return this;
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / ????????????????????????
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional .Protocols.FriendInfo roleInfo = 1;</code>
     */
    public Builder setRoleInfo(
        com.dj.protobuf.friend.FriendInfo.Builder builderForValue) {
      if (roleInfoBuilder_ == null) {
        roleInfo_ = builderForValue.build();
        onChanged();
      } else {
        roleInfoBuilder_.setMessage(builderForValue.build());
      }
      bitField0_ |= 0x00000001;
      return this;
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / ????????????????????????
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional .Protocols.FriendInfo roleInfo = 1;</code>
     */
    public Builder mergeRoleInfo(com.dj.protobuf.friend.FriendInfo value) {
      if (roleInfoBuilder_ == null) {
        if (((bitField0_ & 0x00000001) == 0x00000001) &&
            roleInfo_ != null &&
            roleInfo_ != com.dj.protobuf.friend.FriendInfo.getDefaultInstance()) {
          roleInfo_ =
            com.dj.protobuf.friend.FriendInfo.newBuilder(roleInfo_).mergeFrom(value).buildPartial();
        } else {
          roleInfo_ = value;
        }
        onChanged();
      } else {
        roleInfoBuilder_.mergeFrom(value);
      }
      bitField0_ |= 0x00000001;
      return this;
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / ????????????????????????
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional .Protocols.FriendInfo roleInfo = 1;</code>
     */
    public Builder clearRoleInfo() {
      if (roleInfoBuilder_ == null) {
        roleInfo_ = null;
        onChanged();
      } else {
        roleInfoBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000001);
      return this;
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / ????????????????????????
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional .Protocols.FriendInfo roleInfo = 1;</code>
     */
    public com.dj.protobuf.friend.FriendInfo.Builder getRoleInfoBuilder() {
      bitField0_ |= 0x00000001;
      onChanged();
      return getRoleInfoFieldBuilder().getBuilder();
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / ????????????????????????
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional .Protocols.FriendInfo roleInfo = 1;</code>
     */
    public com.dj.protobuf.friend.FriendInfoOrBuilder getRoleInfoOrBuilder() {
      if (roleInfoBuilder_ != null) {
        return roleInfoBuilder_.getMessageOrBuilder();
      } else {
        return roleInfo_ == null ?
            com.dj.protobuf.friend.FriendInfo.getDefaultInstance() : roleInfo_;
      }
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / ????????????????????????
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional .Protocols.FriendInfo roleInfo = 1;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.dj.protobuf.friend.FriendInfo, com.dj.protobuf.friend.FriendInfo.Builder, com.dj.protobuf.friend.FriendInfoOrBuilder> 
        getRoleInfoFieldBuilder() {
      if (roleInfoBuilder_ == null) {
        roleInfoBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.dj.protobuf.friend.FriendInfo, com.dj.protobuf.friend.FriendInfo.Builder, com.dj.protobuf.friend.FriendInfoOrBuilder>(
                getRoleInfo(),
                getParentForChildren(),
                isClean());
        roleInfo_ = null;
      }
      return roleInfoBuilder_;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:Protocols.FriendApproveNtf)
  }

  // @@protoc_insertion_point(class_scope:Protocols.FriendApproveNtf)
  private static final com.dj.protobuf.friend.FriendApproveNtf DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.dj.protobuf.friend.FriendApproveNtf();
  }

  public static com.dj.protobuf.friend.FriendApproveNtf getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  @java.lang.Deprecated public static final com.google.protobuf.Parser<FriendApproveNtf>
      PARSER = new com.google.protobuf.AbstractParser<FriendApproveNtf>() {
    public FriendApproveNtf parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new FriendApproveNtf(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<FriendApproveNtf> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<FriendApproveNtf> getParserForType() {
    return PARSER;
  }

  public com.dj.protobuf.friend.FriendApproveNtf getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

