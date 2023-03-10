// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Friend.proto

package com.dj.protobuf.friend;

/**
 * Protobuf type {@code Protocols.FriendApplyRsp}
 */
public  final class FriendApplyRsp extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:Protocols.FriendApplyRsp)
    FriendApplyRspOrBuilder {
  // Use FriendApplyRsp.newBuilder() to construct.
  private FriendApplyRsp(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private FriendApplyRsp() {
    errorID_ = 0;
    roleId_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private FriendApplyRsp(
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
          case 16: {
            if (!((mutable_bitField0_ & 0x00000002) == 0x00000002)) {
              roleId_ = new java.util.ArrayList<java.lang.Long>();
              mutable_bitField0_ |= 0x00000002;
            }
            roleId_.add(input.readUInt64());
            break;
          }
          case 18: {
            int length = input.readRawVarint32();
            int limit = input.pushLimit(length);
            if (!((mutable_bitField0_ & 0x00000002) == 0x00000002) && input.getBytesUntilLimit() > 0) {
              roleId_ = new java.util.ArrayList<java.lang.Long>();
              mutable_bitField0_ |= 0x00000002;
            }
            while (input.getBytesUntilLimit() > 0) {
              roleId_.add(input.readUInt64());
            }
            input.popLimit(limit);
            break;
          }
          case 26: {
            com.dj.protobuf.friend.FriendApplyReq.Builder subBuilder = null;
            if (((bitField0_ & 0x00000002) == 0x00000002)) {
              subBuilder = req_.toBuilder();
            }
            req_ = input.readMessage(com.dj.protobuf.friend.FriendApplyReq.PARSER, extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(req_);
              req_ = subBuilder.buildPartial();
            }
            bitField0_ |= 0x00000002;
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
        roleId_ = java.util.Collections.unmodifiableList(roleId_);
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.dj.protobuf.friend.Friend.internal_static_Protocols_FriendApplyRsp_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.dj.protobuf.friend.Friend.internal_static_Protocols_FriendApplyRsp_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.dj.protobuf.friend.FriendApplyRsp.class, com.dj.protobuf.friend.FriendApplyRsp.Builder.class);
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

  public static final int ROLEID_FIELD_NUMBER = 2;
  private java.util.List<java.lang.Long> roleId_;
  /**
   * <code>repeated uint64 roleId = 2;</code>
   */
  public java.util.List<java.lang.Long>
      getRoleIdList() {
    return roleId_;
  }
  /**
   * <code>repeated uint64 roleId = 2;</code>
   */
  public int getRoleIdCount() {
    return roleId_.size();
  }
  /**
   * <code>repeated uint64 roleId = 2;</code>
   */
  public long getRoleId(int index) {
    return roleId_.get(index);
  }

  public static final int REQ_FIELD_NUMBER = 3;
  private com.dj.protobuf.friend.FriendApplyReq req_;
  /**
   * <code>optional .Protocols.FriendApplyReq req = 3;</code>
   */
  public boolean hasReq() {
    return ((bitField0_ & 0x00000002) == 0x00000002);
  }
  /**
   * <code>optional .Protocols.FriendApplyReq req = 3;</code>
   */
  public com.dj.protobuf.friend.FriendApplyReq getReq() {
    return req_ == null ? com.dj.protobuf.friend.FriendApplyReq.getDefaultInstance() : req_;
  }
  /**
   * <code>optional .Protocols.FriendApplyReq req = 3;</code>
   */
  public com.dj.protobuf.friend.FriendApplyReqOrBuilder getReqOrBuilder() {
    return req_ == null ? com.dj.protobuf.friend.FriendApplyReq.getDefaultInstance() : req_;
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
    for (int i = 0; i < roleId_.size(); i++) {
      output.writeUInt64(2, roleId_.get(i));
    }
    if (((bitField0_ & 0x00000002) == 0x00000002)) {
      output.writeMessage(3, getReq());
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
    {
      int dataSize = 0;
      for (int i = 0; i < roleId_.size(); i++) {
        dataSize += com.google.protobuf.CodedOutputStream
          .computeUInt64SizeNoTag(roleId_.get(i));
      }
      size += dataSize;
      size += 1 * getRoleIdList().size();
    }
    if (((bitField0_ & 0x00000002) == 0x00000002)) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(3, getReq());
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
    if (!(obj instanceof com.dj.protobuf.friend.FriendApplyRsp)) {
      return super.equals(obj);
    }
    com.dj.protobuf.friend.FriendApplyRsp other = (com.dj.protobuf.friend.FriendApplyRsp) obj;

    boolean result = true;
    result = result && (hasErrorID() == other.hasErrorID());
    if (hasErrorID()) {
      result = result && errorID_ == other.errorID_;
    }
    result = result && getRoleIdList()
        .equals(other.getRoleIdList());
    result = result && (hasReq() == other.hasReq());
    if (hasReq()) {
      result = result && getReq()
          .equals(other.getReq());
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
    if (getRoleIdCount() > 0) {
      hash = (37 * hash) + ROLEID_FIELD_NUMBER;
      hash = (53 * hash) + getRoleIdList().hashCode();
    }
    if (hasReq()) {
      hash = (37 * hash) + REQ_FIELD_NUMBER;
      hash = (53 * hash) + getReq().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.dj.protobuf.friend.FriendApplyRsp parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dj.protobuf.friend.FriendApplyRsp parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dj.protobuf.friend.FriendApplyRsp parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dj.protobuf.friend.FriendApplyRsp parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dj.protobuf.friend.FriendApplyRsp parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.friend.FriendApplyRsp parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.dj.protobuf.friend.FriendApplyRsp parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.friend.FriendApplyRsp parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.dj.protobuf.friend.FriendApplyRsp parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.friend.FriendApplyRsp parseFrom(
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
  public static Builder newBuilder(com.dj.protobuf.friend.FriendApplyRsp prototype) {
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
   * Protobuf type {@code Protocols.FriendApplyRsp}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:Protocols.FriendApplyRsp)
      com.dj.protobuf.friend.FriendApplyRspOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.dj.protobuf.friend.Friend.internal_static_Protocols_FriendApplyRsp_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.dj.protobuf.friend.Friend.internal_static_Protocols_FriendApplyRsp_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.dj.protobuf.friend.FriendApplyRsp.class, com.dj.protobuf.friend.FriendApplyRsp.Builder.class);
    }

    // Construct using com.dj.protobuf.friend.FriendApplyRsp.newBuilder()
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
        getReqFieldBuilder();
      }
    }
    public Builder clear() {
      super.clear();
      errorID_ = 0;
      bitField0_ = (bitField0_ & ~0x00000001);
      roleId_ = java.util.Collections.emptyList();
      bitField0_ = (bitField0_ & ~0x00000002);
      if (reqBuilder_ == null) {
        req_ = null;
      } else {
        reqBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000004);
      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.dj.protobuf.friend.Friend.internal_static_Protocols_FriendApplyRsp_descriptor;
    }

    public com.dj.protobuf.friend.FriendApplyRsp getDefaultInstanceForType() {
      return com.dj.protobuf.friend.FriendApplyRsp.getDefaultInstance();
    }

    public com.dj.protobuf.friend.FriendApplyRsp build() {
      com.dj.protobuf.friend.FriendApplyRsp result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public com.dj.protobuf.friend.FriendApplyRsp buildPartial() {
      com.dj.protobuf.friend.FriendApplyRsp result = new com.dj.protobuf.friend.FriendApplyRsp(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
        to_bitField0_ |= 0x00000001;
      }
      result.errorID_ = errorID_;
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        roleId_ = java.util.Collections.unmodifiableList(roleId_);
        bitField0_ = (bitField0_ & ~0x00000002);
      }
      result.roleId_ = roleId_;
      if (((from_bitField0_ & 0x00000004) == 0x00000004)) {
        to_bitField0_ |= 0x00000002;
      }
      if (reqBuilder_ == null) {
        result.req_ = req_;
      } else {
        result.req_ = reqBuilder_.build();
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
      if (other instanceof com.dj.protobuf.friend.FriendApplyRsp) {
        return mergeFrom((com.dj.protobuf.friend.FriendApplyRsp)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.dj.protobuf.friend.FriendApplyRsp other) {
      if (other == com.dj.protobuf.friend.FriendApplyRsp.getDefaultInstance()) return this;
      if (other.hasErrorID()) {
        setErrorID(other.getErrorID());
      }
      if (!other.roleId_.isEmpty()) {
        if (roleId_.isEmpty()) {
          roleId_ = other.roleId_;
          bitField0_ = (bitField0_ & ~0x00000002);
        } else {
          ensureRoleIdIsMutable();
          roleId_.addAll(other.roleId_);
        }
        onChanged();
      }
      if (other.hasReq()) {
        mergeReq(other.getReq());
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
      com.dj.protobuf.friend.FriendApplyRsp parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.dj.protobuf.friend.FriendApplyRsp) e.getUnfinishedMessage();
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

    private java.util.List<java.lang.Long> roleId_ = java.util.Collections.emptyList();
    private void ensureRoleIdIsMutable() {
      if (!((bitField0_ & 0x00000002) == 0x00000002)) {
        roleId_ = new java.util.ArrayList<java.lang.Long>(roleId_);
        bitField0_ |= 0x00000002;
       }
    }
    /**
     * <code>repeated uint64 roleId = 2;</code>
     */
    public java.util.List<java.lang.Long>
        getRoleIdList() {
      return java.util.Collections.unmodifiableList(roleId_);
    }
    /**
     * <code>repeated uint64 roleId = 2;</code>
     */
    public int getRoleIdCount() {
      return roleId_.size();
    }
    /**
     * <code>repeated uint64 roleId = 2;</code>
     */
    public long getRoleId(int index) {
      return roleId_.get(index);
    }
    /**
     * <code>repeated uint64 roleId = 2;</code>
     */
    public Builder setRoleId(
        int index, long value) {
      ensureRoleIdIsMutable();
      roleId_.set(index, value);
      onChanged();
      return this;
    }
    /**
     * <code>repeated uint64 roleId = 2;</code>
     */
    public Builder addRoleId(long value) {
      ensureRoleIdIsMutable();
      roleId_.add(value);
      onChanged();
      return this;
    }
    /**
     * <code>repeated uint64 roleId = 2;</code>
     */
    public Builder addAllRoleId(
        java.lang.Iterable<? extends java.lang.Long> values) {
      ensureRoleIdIsMutable();
      com.google.protobuf.AbstractMessageLite.Builder.addAll(
          values, roleId_);
      onChanged();
      return this;
    }
    /**
     * <code>repeated uint64 roleId = 2;</code>
     */
    public Builder clearRoleId() {
      roleId_ = java.util.Collections.emptyList();
      bitField0_ = (bitField0_ & ~0x00000002);
      onChanged();
      return this;
    }

    private com.dj.protobuf.friend.FriendApplyReq req_ = null;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.dj.protobuf.friend.FriendApplyReq, com.dj.protobuf.friend.FriendApplyReq.Builder, com.dj.protobuf.friend.FriendApplyReqOrBuilder> reqBuilder_;
    /**
     * <code>optional .Protocols.FriendApplyReq req = 3;</code>
     */
    public boolean hasReq() {
      return ((bitField0_ & 0x00000004) == 0x00000004);
    }
    /**
     * <code>optional .Protocols.FriendApplyReq req = 3;</code>
     */
    public com.dj.protobuf.friend.FriendApplyReq getReq() {
      if (reqBuilder_ == null) {
        return req_ == null ? com.dj.protobuf.friend.FriendApplyReq.getDefaultInstance() : req_;
      } else {
        return reqBuilder_.getMessage();
      }
    }
    /**
     * <code>optional .Protocols.FriendApplyReq req = 3;</code>
     */
    public Builder setReq(com.dj.protobuf.friend.FriendApplyReq value) {
      if (reqBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        req_ = value;
        onChanged();
      } else {
        reqBuilder_.setMessage(value);
      }
      bitField0_ |= 0x00000004;
      return this;
    }
    /**
     * <code>optional .Protocols.FriendApplyReq req = 3;</code>
     */
    public Builder setReq(
        com.dj.protobuf.friend.FriendApplyReq.Builder builderForValue) {
      if (reqBuilder_ == null) {
        req_ = builderForValue.build();
        onChanged();
      } else {
        reqBuilder_.setMessage(builderForValue.build());
      }
      bitField0_ |= 0x00000004;
      return this;
    }
    /**
     * <code>optional .Protocols.FriendApplyReq req = 3;</code>
     */
    public Builder mergeReq(com.dj.protobuf.friend.FriendApplyReq value) {
      if (reqBuilder_ == null) {
        if (((bitField0_ & 0x00000004) == 0x00000004) &&
            req_ != null &&
            req_ != com.dj.protobuf.friend.FriendApplyReq.getDefaultInstance()) {
          req_ =
            com.dj.protobuf.friend.FriendApplyReq.newBuilder(req_).mergeFrom(value).buildPartial();
        } else {
          req_ = value;
        }
        onChanged();
      } else {
        reqBuilder_.mergeFrom(value);
      }
      bitField0_ |= 0x00000004;
      return this;
    }
    /**
     * <code>optional .Protocols.FriendApplyReq req = 3;</code>
     */
    public Builder clearReq() {
      if (reqBuilder_ == null) {
        req_ = null;
        onChanged();
      } else {
        reqBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000004);
      return this;
    }
    /**
     * <code>optional .Protocols.FriendApplyReq req = 3;</code>
     */
    public com.dj.protobuf.friend.FriendApplyReq.Builder getReqBuilder() {
      bitField0_ |= 0x00000004;
      onChanged();
      return getReqFieldBuilder().getBuilder();
    }
    /**
     * <code>optional .Protocols.FriendApplyReq req = 3;</code>
     */
    public com.dj.protobuf.friend.FriendApplyReqOrBuilder getReqOrBuilder() {
      if (reqBuilder_ != null) {
        return reqBuilder_.getMessageOrBuilder();
      } else {
        return req_ == null ?
            com.dj.protobuf.friend.FriendApplyReq.getDefaultInstance() : req_;
      }
    }
    /**
     * <code>optional .Protocols.FriendApplyReq req = 3;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.dj.protobuf.friend.FriendApplyReq, com.dj.protobuf.friend.FriendApplyReq.Builder, com.dj.protobuf.friend.FriendApplyReqOrBuilder> 
        getReqFieldBuilder() {
      if (reqBuilder_ == null) {
        reqBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.dj.protobuf.friend.FriendApplyReq, com.dj.protobuf.friend.FriendApplyReq.Builder, com.dj.protobuf.friend.FriendApplyReqOrBuilder>(
                getReq(),
                getParentForChildren(),
                isClean());
        req_ = null;
      }
      return reqBuilder_;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:Protocols.FriendApplyRsp)
  }

  // @@protoc_insertion_point(class_scope:Protocols.FriendApplyRsp)
  private static final com.dj.protobuf.friend.FriendApplyRsp DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.dj.protobuf.friend.FriendApplyRsp();
  }

  public static com.dj.protobuf.friend.FriendApplyRsp getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  @java.lang.Deprecated public static final com.google.protobuf.Parser<FriendApplyRsp>
      PARSER = new com.google.protobuf.AbstractParser<FriendApplyRsp>() {
    public FriendApplyRsp parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new FriendApplyRsp(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<FriendApplyRsp> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<FriendApplyRsp> getParserForType() {
    return PARSER;
  }

  public com.dj.protobuf.friend.FriendApplyRsp getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

