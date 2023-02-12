// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Login.proto

package com.dj.protobuf.login;

/**
 * Protobuf type {@code Protocols.RealNameAuthRsp}
 */
public  final class RealNameAuthRsp extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:Protocols.RealNameAuthRsp)
    RealNameAuthRspOrBuilder {
  // Use RealNameAuthRsp.newBuilder() to construct.
  private RealNameAuthRsp(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private RealNameAuthRsp() {
    errorID_ = 0;
    roleID_ = 0L;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private RealNameAuthRsp(
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
            com.dj.protobuf.login.RealNameAuthReq.Builder subBuilder = null;
            if (((bitField0_ & 0x00000002) == 0x00000002)) {
              subBuilder = req_.toBuilder();
            }
            req_ = input.readMessage(com.dj.protobuf.login.RealNameAuthReq.PARSER, extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(req_);
              req_ = subBuilder.buildPartial();
            }
            bitField0_ |= 0x00000002;
            break;
          }
          case 24: {
            bitField0_ |= 0x00000004;
            roleID_ = input.readUInt64();
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
    return com.dj.protobuf.login.Login.internal_static_Protocols_RealNameAuthRsp_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.dj.protobuf.login.Login.internal_static_Protocols_RealNameAuthRsp_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.dj.protobuf.login.RealNameAuthRsp.class, com.dj.protobuf.login.RealNameAuthRsp.Builder.class);
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

  public static final int REQ_FIELD_NUMBER = 2;
  private com.dj.protobuf.login.RealNameAuthReq req_;
  /**
   * <code>optional .Protocols.RealNameAuthReq req = 2;</code>
   */
  public boolean hasReq() {
    return ((bitField0_ & 0x00000002) == 0x00000002);
  }
  /**
   * <code>optional .Protocols.RealNameAuthReq req = 2;</code>
   */
  public com.dj.protobuf.login.RealNameAuthReq getReq() {
    return req_ == null ? com.dj.protobuf.login.RealNameAuthReq.getDefaultInstance() : req_;
  }
  /**
   * <code>optional .Protocols.RealNameAuthReq req = 2;</code>
   */
  public com.dj.protobuf.login.RealNameAuthReqOrBuilder getReqOrBuilder() {
    return req_ == null ? com.dj.protobuf.login.RealNameAuthReq.getDefaultInstance() : req_;
  }

  public static final int ROLEID_FIELD_NUMBER = 3;
  private long roleID_;
  /**
   * <code>optional uint64 roleID = 3;</code>
   */
  public boolean hasRoleID() {
    return ((bitField0_ & 0x00000004) == 0x00000004);
  }
  /**
   * <code>optional uint64 roleID = 3;</code>
   */
  public long getRoleID() {
    return roleID_;
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
    if (((bitField0_ & 0x00000002) == 0x00000002)) {
      output.writeMessage(2, getReq());
    }
    if (((bitField0_ & 0x00000004) == 0x00000004)) {
      output.writeUInt64(3, roleID_);
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
    if (((bitField0_ & 0x00000002) == 0x00000002)) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(2, getReq());
    }
    if (((bitField0_ & 0x00000004) == 0x00000004)) {
      size += com.google.protobuf.CodedOutputStream
        .computeUInt64Size(3, roleID_);
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
    if (!(obj instanceof com.dj.protobuf.login.RealNameAuthRsp)) {
      return super.equals(obj);
    }
    com.dj.protobuf.login.RealNameAuthRsp other = (com.dj.protobuf.login.RealNameAuthRsp) obj;

    boolean result = true;
    result = result && (hasErrorID() == other.hasErrorID());
    if (hasErrorID()) {
      result = result && errorID_ == other.errorID_;
    }
    result = result && (hasReq() == other.hasReq());
    if (hasReq()) {
      result = result && getReq()
          .equals(other.getReq());
    }
    result = result && (hasRoleID() == other.hasRoleID());
    if (hasRoleID()) {
      result = result && (getRoleID()
          == other.getRoleID());
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
    if (hasReq()) {
      hash = (37 * hash) + REQ_FIELD_NUMBER;
      hash = (53 * hash) + getReq().hashCode();
    }
    if (hasRoleID()) {
      hash = (37 * hash) + ROLEID_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
          getRoleID());
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.dj.protobuf.login.RealNameAuthRsp parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dj.protobuf.login.RealNameAuthRsp parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dj.protobuf.login.RealNameAuthRsp parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dj.protobuf.login.RealNameAuthRsp parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dj.protobuf.login.RealNameAuthRsp parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.login.RealNameAuthRsp parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.dj.protobuf.login.RealNameAuthRsp parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.login.RealNameAuthRsp parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.dj.protobuf.login.RealNameAuthRsp parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.login.RealNameAuthRsp parseFrom(
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
  public static Builder newBuilder(com.dj.protobuf.login.RealNameAuthRsp prototype) {
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
   * Protobuf type {@code Protocols.RealNameAuthRsp}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:Protocols.RealNameAuthRsp)
      com.dj.protobuf.login.RealNameAuthRspOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.dj.protobuf.login.Login.internal_static_Protocols_RealNameAuthRsp_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.dj.protobuf.login.Login.internal_static_Protocols_RealNameAuthRsp_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.dj.protobuf.login.RealNameAuthRsp.class, com.dj.protobuf.login.RealNameAuthRsp.Builder.class);
    }

    // Construct using com.dj.protobuf.login.RealNameAuthRsp.newBuilder()
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
      if (reqBuilder_ == null) {
        req_ = null;
      } else {
        reqBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000002);
      roleID_ = 0L;
      bitField0_ = (bitField0_ & ~0x00000004);
      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.dj.protobuf.login.Login.internal_static_Protocols_RealNameAuthRsp_descriptor;
    }

    public com.dj.protobuf.login.RealNameAuthRsp getDefaultInstanceForType() {
      return com.dj.protobuf.login.RealNameAuthRsp.getDefaultInstance();
    }

    public com.dj.protobuf.login.RealNameAuthRsp build() {
      com.dj.protobuf.login.RealNameAuthRsp result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public com.dj.protobuf.login.RealNameAuthRsp buildPartial() {
      com.dj.protobuf.login.RealNameAuthRsp result = new com.dj.protobuf.login.RealNameAuthRsp(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
        to_bitField0_ |= 0x00000001;
      }
      result.errorID_ = errorID_;
      if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
        to_bitField0_ |= 0x00000002;
      }
      if (reqBuilder_ == null) {
        result.req_ = req_;
      } else {
        result.req_ = reqBuilder_.build();
      }
      if (((from_bitField0_ & 0x00000004) == 0x00000004)) {
        to_bitField0_ |= 0x00000004;
      }
      result.roleID_ = roleID_;
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
      if (other instanceof com.dj.protobuf.login.RealNameAuthRsp) {
        return mergeFrom((com.dj.protobuf.login.RealNameAuthRsp)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.dj.protobuf.login.RealNameAuthRsp other) {
      if (other == com.dj.protobuf.login.RealNameAuthRsp.getDefaultInstance()) return this;
      if (other.hasErrorID()) {
        setErrorID(other.getErrorID());
      }
      if (other.hasReq()) {
        mergeReq(other.getReq());
      }
      if (other.hasRoleID()) {
        setRoleID(other.getRoleID());
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
      com.dj.protobuf.login.RealNameAuthRsp parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.dj.protobuf.login.RealNameAuthRsp) e.getUnfinishedMessage();
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

    private com.dj.protobuf.login.RealNameAuthReq req_ = null;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.dj.protobuf.login.RealNameAuthReq, com.dj.protobuf.login.RealNameAuthReq.Builder, com.dj.protobuf.login.RealNameAuthReqOrBuilder> reqBuilder_;
    /**
     * <code>optional .Protocols.RealNameAuthReq req = 2;</code>
     */
    public boolean hasReq() {
      return ((bitField0_ & 0x00000002) == 0x00000002);
    }
    /**
     * <code>optional .Protocols.RealNameAuthReq req = 2;</code>
     */
    public com.dj.protobuf.login.RealNameAuthReq getReq() {
      if (reqBuilder_ == null) {
        return req_ == null ? com.dj.protobuf.login.RealNameAuthReq.getDefaultInstance() : req_;
      } else {
        return reqBuilder_.getMessage();
      }
    }
    /**
     * <code>optional .Protocols.RealNameAuthReq req = 2;</code>
     */
    public Builder setReq(com.dj.protobuf.login.RealNameAuthReq value) {
      if (reqBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        req_ = value;
        onChanged();
      } else {
        reqBuilder_.setMessage(value);
      }
      bitField0_ |= 0x00000002;
      return this;
    }
    /**
     * <code>optional .Protocols.RealNameAuthReq req = 2;</code>
     */
    public Builder setReq(
        com.dj.protobuf.login.RealNameAuthReq.Builder builderForValue) {
      if (reqBuilder_ == null) {
        req_ = builderForValue.build();
        onChanged();
      } else {
        reqBuilder_.setMessage(builderForValue.build());
      }
      bitField0_ |= 0x00000002;
      return this;
    }
    /**
     * <code>optional .Protocols.RealNameAuthReq req = 2;</code>
     */
    public Builder mergeReq(com.dj.protobuf.login.RealNameAuthReq value) {
      if (reqBuilder_ == null) {
        if (((bitField0_ & 0x00000002) == 0x00000002) &&
            req_ != null &&
            req_ != com.dj.protobuf.login.RealNameAuthReq.getDefaultInstance()) {
          req_ =
            com.dj.protobuf.login.RealNameAuthReq.newBuilder(req_).mergeFrom(value).buildPartial();
        } else {
          req_ = value;
        }
        onChanged();
      } else {
        reqBuilder_.mergeFrom(value);
      }
      bitField0_ |= 0x00000002;
      return this;
    }
    /**
     * <code>optional .Protocols.RealNameAuthReq req = 2;</code>
     */
    public Builder clearReq() {
      if (reqBuilder_ == null) {
        req_ = null;
        onChanged();
      } else {
        reqBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000002);
      return this;
    }
    /**
     * <code>optional .Protocols.RealNameAuthReq req = 2;</code>
     */
    public com.dj.protobuf.login.RealNameAuthReq.Builder getReqBuilder() {
      bitField0_ |= 0x00000002;
      onChanged();
      return getReqFieldBuilder().getBuilder();
    }
    /**
     * <code>optional .Protocols.RealNameAuthReq req = 2;</code>
     */
    public com.dj.protobuf.login.RealNameAuthReqOrBuilder getReqOrBuilder() {
      if (reqBuilder_ != null) {
        return reqBuilder_.getMessageOrBuilder();
      } else {
        return req_ == null ?
            com.dj.protobuf.login.RealNameAuthReq.getDefaultInstance() : req_;
      }
    }
    /**
     * <code>optional .Protocols.RealNameAuthReq req = 2;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.dj.protobuf.login.RealNameAuthReq, com.dj.protobuf.login.RealNameAuthReq.Builder, com.dj.protobuf.login.RealNameAuthReqOrBuilder> 
        getReqFieldBuilder() {
      if (reqBuilder_ == null) {
        reqBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.dj.protobuf.login.RealNameAuthReq, com.dj.protobuf.login.RealNameAuthReq.Builder, com.dj.protobuf.login.RealNameAuthReqOrBuilder>(
                getReq(),
                getParentForChildren(),
                isClean());
        req_ = null;
      }
      return reqBuilder_;
    }

    private long roleID_ ;
    /**
     * <code>optional uint64 roleID = 3;</code>
     */
    public boolean hasRoleID() {
      return ((bitField0_ & 0x00000004) == 0x00000004);
    }
    /**
     * <code>optional uint64 roleID = 3;</code>
     */
    public long getRoleID() {
      return roleID_;
    }
    /**
     * <code>optional uint64 roleID = 3;</code>
     */
    public Builder setRoleID(long value) {
      bitField0_ |= 0x00000004;
      roleID_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional uint64 roleID = 3;</code>
     */
    public Builder clearRoleID() {
      bitField0_ = (bitField0_ & ~0x00000004);
      roleID_ = 0L;
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


    // @@protoc_insertion_point(builder_scope:Protocols.RealNameAuthRsp)
  }

  // @@protoc_insertion_point(class_scope:Protocols.RealNameAuthRsp)
  private static final com.dj.protobuf.login.RealNameAuthRsp DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.dj.protobuf.login.RealNameAuthRsp();
  }

  public static com.dj.protobuf.login.RealNameAuthRsp getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  @java.lang.Deprecated public static final com.google.protobuf.Parser<RealNameAuthRsp>
      PARSER = new com.google.protobuf.AbstractParser<RealNameAuthRsp>() {
    public RealNameAuthRsp parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new RealNameAuthRsp(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<RealNameAuthRsp> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<RealNameAuthRsp> getParserForType() {
    return PARSER;
  }

  public com.dj.protobuf.login.RealNameAuthRsp getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

