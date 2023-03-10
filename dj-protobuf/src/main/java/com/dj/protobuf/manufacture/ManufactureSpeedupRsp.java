// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Manufacture.proto

package com.dj.protobuf.manufacture;

/**
 * Protobuf type {@code Protocols.ManufactureSpeedupRsp}
 */
public  final class ManufactureSpeedupRsp extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:Protocols.ManufactureSpeedupRsp)
    ManufactureSpeedupRspOrBuilder {
  // Use ManufactureSpeedupRsp.newBuilder() to construct.
  private ManufactureSpeedupRsp(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private ManufactureSpeedupRsp() {
    errorID_ = 0;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private ManufactureSpeedupRsp(
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
            com.dj.protobuf.manufacture.ManufactureInfo.Builder subBuilder = null;
            if (((bitField0_ & 0x00000002) == 0x00000002)) {
              subBuilder = info_.toBuilder();
            }
            info_ = input.readMessage(com.dj.protobuf.manufacture.ManufactureInfo.PARSER, extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(info_);
              info_ = subBuilder.buildPartial();
            }
            bitField0_ |= 0x00000002;
            break;
          }
          case 26: {
            com.dj.protobuf.manufacture.ManufactureSpeedupReq.Builder subBuilder = null;
            if (((bitField0_ & 0x00000004) == 0x00000004)) {
              subBuilder = req_.toBuilder();
            }
            req_ = input.readMessage(com.dj.protobuf.manufacture.ManufactureSpeedupReq.PARSER, extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(req_);
              req_ = subBuilder.buildPartial();
            }
            bitField0_ |= 0x00000004;
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
    return com.dj.protobuf.manufacture.Manufacture.internal_static_Protocols_ManufactureSpeedupRsp_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.dj.protobuf.manufacture.Manufacture.internal_static_Protocols_ManufactureSpeedupRsp_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.dj.protobuf.manufacture.ManufactureSpeedupRsp.class, com.dj.protobuf.manufacture.ManufactureSpeedupRsp.Builder.class);
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

  public static final int INFO_FIELD_NUMBER = 2;
  private com.dj.protobuf.manufacture.ManufactureInfo info_;
  /**
   * <code>optional .Protocols.ManufactureInfo info = 2;</code>
   */
  public boolean hasInfo() {
    return ((bitField0_ & 0x00000002) == 0x00000002);
  }
  /**
   * <code>optional .Protocols.ManufactureInfo info = 2;</code>
   */
  public com.dj.protobuf.manufacture.ManufactureInfo getInfo() {
    return info_ == null ? com.dj.protobuf.manufacture.ManufactureInfo.getDefaultInstance() : info_;
  }
  /**
   * <code>optional .Protocols.ManufactureInfo info = 2;</code>
   */
  public com.dj.protobuf.manufacture.ManufactureInfoOrBuilder getInfoOrBuilder() {
    return info_ == null ? com.dj.protobuf.manufacture.ManufactureInfo.getDefaultInstance() : info_;
  }

  public static final int REQ_FIELD_NUMBER = 3;
  private com.dj.protobuf.manufacture.ManufactureSpeedupReq req_;
  /**
   * <code>optional .Protocols.ManufactureSpeedupReq req = 3;</code>
   */
  public boolean hasReq() {
    return ((bitField0_ & 0x00000004) == 0x00000004);
  }
  /**
   * <code>optional .Protocols.ManufactureSpeedupReq req = 3;</code>
   */
  public com.dj.protobuf.manufacture.ManufactureSpeedupReq getReq() {
    return req_ == null ? com.dj.protobuf.manufacture.ManufactureSpeedupReq.getDefaultInstance() : req_;
  }
  /**
   * <code>optional .Protocols.ManufactureSpeedupReq req = 3;</code>
   */
  public com.dj.protobuf.manufacture.ManufactureSpeedupReqOrBuilder getReqOrBuilder() {
    return req_ == null ? com.dj.protobuf.manufacture.ManufactureSpeedupReq.getDefaultInstance() : req_;
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
      output.writeMessage(2, getInfo());
    }
    if (((bitField0_ & 0x00000004) == 0x00000004)) {
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
    if (((bitField0_ & 0x00000002) == 0x00000002)) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(2, getInfo());
    }
    if (((bitField0_ & 0x00000004) == 0x00000004)) {
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
    if (!(obj instanceof com.dj.protobuf.manufacture.ManufactureSpeedupRsp)) {
      return super.equals(obj);
    }
    com.dj.protobuf.manufacture.ManufactureSpeedupRsp other = (com.dj.protobuf.manufacture.ManufactureSpeedupRsp) obj;

    boolean result = true;
    result = result && (hasErrorID() == other.hasErrorID());
    if (hasErrorID()) {
      result = result && errorID_ == other.errorID_;
    }
    result = result && (hasInfo() == other.hasInfo());
    if (hasInfo()) {
      result = result && getInfo()
          .equals(other.getInfo());
    }
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
    if (hasInfo()) {
      hash = (37 * hash) + INFO_FIELD_NUMBER;
      hash = (53 * hash) + getInfo().hashCode();
    }
    if (hasReq()) {
      hash = (37 * hash) + REQ_FIELD_NUMBER;
      hash = (53 * hash) + getReq().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.dj.protobuf.manufacture.ManufactureSpeedupRsp parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dj.protobuf.manufacture.ManufactureSpeedupRsp parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dj.protobuf.manufacture.ManufactureSpeedupRsp parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dj.protobuf.manufacture.ManufactureSpeedupRsp parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dj.protobuf.manufacture.ManufactureSpeedupRsp parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.manufacture.ManufactureSpeedupRsp parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.dj.protobuf.manufacture.ManufactureSpeedupRsp parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.manufacture.ManufactureSpeedupRsp parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.dj.protobuf.manufacture.ManufactureSpeedupRsp parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.manufacture.ManufactureSpeedupRsp parseFrom(
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
  public static Builder newBuilder(com.dj.protobuf.manufacture.ManufactureSpeedupRsp prototype) {
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
   * Protobuf type {@code Protocols.ManufactureSpeedupRsp}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:Protocols.ManufactureSpeedupRsp)
      com.dj.protobuf.manufacture.ManufactureSpeedupRspOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.dj.protobuf.manufacture.Manufacture.internal_static_Protocols_ManufactureSpeedupRsp_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.dj.protobuf.manufacture.Manufacture.internal_static_Protocols_ManufactureSpeedupRsp_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.dj.protobuf.manufacture.ManufactureSpeedupRsp.class, com.dj.protobuf.manufacture.ManufactureSpeedupRsp.Builder.class);
    }

    // Construct using com.dj.protobuf.manufacture.ManufactureSpeedupRsp.newBuilder()
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
        getInfoFieldBuilder();
        getReqFieldBuilder();
      }
    }
    public Builder clear() {
      super.clear();
      errorID_ = 0;
      bitField0_ = (bitField0_ & ~0x00000001);
      if (infoBuilder_ == null) {
        info_ = null;
      } else {
        infoBuilder_.clear();
      }
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
      return com.dj.protobuf.manufacture.Manufacture.internal_static_Protocols_ManufactureSpeedupRsp_descriptor;
    }

    public com.dj.protobuf.manufacture.ManufactureSpeedupRsp getDefaultInstanceForType() {
      return com.dj.protobuf.manufacture.ManufactureSpeedupRsp.getDefaultInstance();
    }

    public com.dj.protobuf.manufacture.ManufactureSpeedupRsp build() {
      com.dj.protobuf.manufacture.ManufactureSpeedupRsp result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public com.dj.protobuf.manufacture.ManufactureSpeedupRsp buildPartial() {
      com.dj.protobuf.manufacture.ManufactureSpeedupRsp result = new com.dj.protobuf.manufacture.ManufactureSpeedupRsp(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
        to_bitField0_ |= 0x00000001;
      }
      result.errorID_ = errorID_;
      if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
        to_bitField0_ |= 0x00000002;
      }
      if (infoBuilder_ == null) {
        result.info_ = info_;
      } else {
        result.info_ = infoBuilder_.build();
      }
      if (((from_bitField0_ & 0x00000004) == 0x00000004)) {
        to_bitField0_ |= 0x00000004;
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
      if (other instanceof com.dj.protobuf.manufacture.ManufactureSpeedupRsp) {
        return mergeFrom((com.dj.protobuf.manufacture.ManufactureSpeedupRsp)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.dj.protobuf.manufacture.ManufactureSpeedupRsp other) {
      if (other == com.dj.protobuf.manufacture.ManufactureSpeedupRsp.getDefaultInstance()) return this;
      if (other.hasErrorID()) {
        setErrorID(other.getErrorID());
      }
      if (other.hasInfo()) {
        mergeInfo(other.getInfo());
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
      com.dj.protobuf.manufacture.ManufactureSpeedupRsp parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.dj.protobuf.manufacture.ManufactureSpeedupRsp) e.getUnfinishedMessage();
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

    private com.dj.protobuf.manufacture.ManufactureInfo info_ = null;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.dj.protobuf.manufacture.ManufactureInfo, com.dj.protobuf.manufacture.ManufactureInfo.Builder, com.dj.protobuf.manufacture.ManufactureInfoOrBuilder> infoBuilder_;
    /**
     * <code>optional .Protocols.ManufactureInfo info = 2;</code>
     */
    public boolean hasInfo() {
      return ((bitField0_ & 0x00000002) == 0x00000002);
    }
    /**
     * <code>optional .Protocols.ManufactureInfo info = 2;</code>
     */
    public com.dj.protobuf.manufacture.ManufactureInfo getInfo() {
      if (infoBuilder_ == null) {
        return info_ == null ? com.dj.protobuf.manufacture.ManufactureInfo.getDefaultInstance() : info_;
      } else {
        return infoBuilder_.getMessage();
      }
    }
    /**
     * <code>optional .Protocols.ManufactureInfo info = 2;</code>
     */
    public Builder setInfo(com.dj.protobuf.manufacture.ManufactureInfo value) {
      if (infoBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        info_ = value;
        onChanged();
      } else {
        infoBuilder_.setMessage(value);
      }
      bitField0_ |= 0x00000002;
      return this;
    }
    /**
     * <code>optional .Protocols.ManufactureInfo info = 2;</code>
     */
    public Builder setInfo(
        com.dj.protobuf.manufacture.ManufactureInfo.Builder builderForValue) {
      if (infoBuilder_ == null) {
        info_ = builderForValue.build();
        onChanged();
      } else {
        infoBuilder_.setMessage(builderForValue.build());
      }
      bitField0_ |= 0x00000002;
      return this;
    }
    /**
     * <code>optional .Protocols.ManufactureInfo info = 2;</code>
     */
    public Builder mergeInfo(com.dj.protobuf.manufacture.ManufactureInfo value) {
      if (infoBuilder_ == null) {
        if (((bitField0_ & 0x00000002) == 0x00000002) &&
            info_ != null &&
            info_ != com.dj.protobuf.manufacture.ManufactureInfo.getDefaultInstance()) {
          info_ =
            com.dj.protobuf.manufacture.ManufactureInfo.newBuilder(info_).mergeFrom(value).buildPartial();
        } else {
          info_ = value;
        }
        onChanged();
      } else {
        infoBuilder_.mergeFrom(value);
      }
      bitField0_ |= 0x00000002;
      return this;
    }
    /**
     * <code>optional .Protocols.ManufactureInfo info = 2;</code>
     */
    public Builder clearInfo() {
      if (infoBuilder_ == null) {
        info_ = null;
        onChanged();
      } else {
        infoBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000002);
      return this;
    }
    /**
     * <code>optional .Protocols.ManufactureInfo info = 2;</code>
     */
    public com.dj.protobuf.manufacture.ManufactureInfo.Builder getInfoBuilder() {
      bitField0_ |= 0x00000002;
      onChanged();
      return getInfoFieldBuilder().getBuilder();
    }
    /**
     * <code>optional .Protocols.ManufactureInfo info = 2;</code>
     */
    public com.dj.protobuf.manufacture.ManufactureInfoOrBuilder getInfoOrBuilder() {
      if (infoBuilder_ != null) {
        return infoBuilder_.getMessageOrBuilder();
      } else {
        return info_ == null ?
            com.dj.protobuf.manufacture.ManufactureInfo.getDefaultInstance() : info_;
      }
    }
    /**
     * <code>optional .Protocols.ManufactureInfo info = 2;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.dj.protobuf.manufacture.ManufactureInfo, com.dj.protobuf.manufacture.ManufactureInfo.Builder, com.dj.protobuf.manufacture.ManufactureInfoOrBuilder> 
        getInfoFieldBuilder() {
      if (infoBuilder_ == null) {
        infoBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.dj.protobuf.manufacture.ManufactureInfo, com.dj.protobuf.manufacture.ManufactureInfo.Builder, com.dj.protobuf.manufacture.ManufactureInfoOrBuilder>(
                getInfo(),
                getParentForChildren(),
                isClean());
        info_ = null;
      }
      return infoBuilder_;
    }

    private com.dj.protobuf.manufacture.ManufactureSpeedupReq req_ = null;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.dj.protobuf.manufacture.ManufactureSpeedupReq, com.dj.protobuf.manufacture.ManufactureSpeedupReq.Builder, com.dj.protobuf.manufacture.ManufactureSpeedupReqOrBuilder> reqBuilder_;
    /**
     * <code>optional .Protocols.ManufactureSpeedupReq req = 3;</code>
     */
    public boolean hasReq() {
      return ((bitField0_ & 0x00000004) == 0x00000004);
    }
    /**
     * <code>optional .Protocols.ManufactureSpeedupReq req = 3;</code>
     */
    public com.dj.protobuf.manufacture.ManufactureSpeedupReq getReq() {
      if (reqBuilder_ == null) {
        return req_ == null ? com.dj.protobuf.manufacture.ManufactureSpeedupReq.getDefaultInstance() : req_;
      } else {
        return reqBuilder_.getMessage();
      }
    }
    /**
     * <code>optional .Protocols.ManufactureSpeedupReq req = 3;</code>
     */
    public Builder setReq(com.dj.protobuf.manufacture.ManufactureSpeedupReq value) {
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
     * <code>optional .Protocols.ManufactureSpeedupReq req = 3;</code>
     */
    public Builder setReq(
        com.dj.protobuf.manufacture.ManufactureSpeedupReq.Builder builderForValue) {
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
     * <code>optional .Protocols.ManufactureSpeedupReq req = 3;</code>
     */
    public Builder mergeReq(com.dj.protobuf.manufacture.ManufactureSpeedupReq value) {
      if (reqBuilder_ == null) {
        if (((bitField0_ & 0x00000004) == 0x00000004) &&
            req_ != null &&
            req_ != com.dj.protobuf.manufacture.ManufactureSpeedupReq.getDefaultInstance()) {
          req_ =
            com.dj.protobuf.manufacture.ManufactureSpeedupReq.newBuilder(req_).mergeFrom(value).buildPartial();
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
     * <code>optional .Protocols.ManufactureSpeedupReq req = 3;</code>
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
     * <code>optional .Protocols.ManufactureSpeedupReq req = 3;</code>
     */
    public com.dj.protobuf.manufacture.ManufactureSpeedupReq.Builder getReqBuilder() {
      bitField0_ |= 0x00000004;
      onChanged();
      return getReqFieldBuilder().getBuilder();
    }
    /**
     * <code>optional .Protocols.ManufactureSpeedupReq req = 3;</code>
     */
    public com.dj.protobuf.manufacture.ManufactureSpeedupReqOrBuilder getReqOrBuilder() {
      if (reqBuilder_ != null) {
        return reqBuilder_.getMessageOrBuilder();
      } else {
        return req_ == null ?
            com.dj.protobuf.manufacture.ManufactureSpeedupReq.getDefaultInstance() : req_;
      }
    }
    /**
     * <code>optional .Protocols.ManufactureSpeedupReq req = 3;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.dj.protobuf.manufacture.ManufactureSpeedupReq, com.dj.protobuf.manufacture.ManufactureSpeedupReq.Builder, com.dj.protobuf.manufacture.ManufactureSpeedupReqOrBuilder> 
        getReqFieldBuilder() {
      if (reqBuilder_ == null) {
        reqBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.dj.protobuf.manufacture.ManufactureSpeedupReq, com.dj.protobuf.manufacture.ManufactureSpeedupReq.Builder, com.dj.protobuf.manufacture.ManufactureSpeedupReqOrBuilder>(
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


    // @@protoc_insertion_point(builder_scope:Protocols.ManufactureSpeedupRsp)
  }

  // @@protoc_insertion_point(class_scope:Protocols.ManufactureSpeedupRsp)
  private static final com.dj.protobuf.manufacture.ManufactureSpeedupRsp DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.dj.protobuf.manufacture.ManufactureSpeedupRsp();
  }

  public static com.dj.protobuf.manufacture.ManufactureSpeedupRsp getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  @java.lang.Deprecated public static final com.google.protobuf.Parser<ManufactureSpeedupRsp>
      PARSER = new com.google.protobuf.AbstractParser<ManufactureSpeedupRsp>() {
    public ManufactureSpeedupRsp parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new ManufactureSpeedupRsp(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<ManufactureSpeedupRsp> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<ManufactureSpeedupRsp> getParserForType() {
    return PARSER;
  }

  public com.dj.protobuf.manufacture.ManufactureSpeedupRsp getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

