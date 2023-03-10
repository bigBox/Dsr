// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Trade.proto

package com.dj.protobuf.trade;

/**
 * Protobuf type {@code Protocols.TradeRoleRsp}
 */
public  final class TradeRoleRsp extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:Protocols.TradeRoleRsp)
    TradeRoleRspOrBuilder {
  // Use TradeRoleRsp.newBuilder() to construct.
  private TradeRoleRsp(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private TradeRoleRsp() {
    errorID_ = 0;
    info_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private TradeRoleRsp(
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
            com.dj.protobuf.trade.TradeRoleReq.Builder subBuilder = null;
            if (((bitField0_ & 0x00000002) == 0x00000002)) {
              subBuilder = req_.toBuilder();
            }
            req_ = input.readMessage(com.dj.protobuf.trade.TradeRoleReq.PARSER, extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(req_);
              req_ = subBuilder.buildPartial();
            }
            bitField0_ |= 0x00000002;
            break;
          }
          case 26: {
            if (!((mutable_bitField0_ & 0x00000004) == 0x00000004)) {
              info_ = new java.util.ArrayList<com.dj.protobuf.trade.TradeOrderInfo>();
              mutable_bitField0_ |= 0x00000004;
            }
            info_.add(
                input.readMessage(com.dj.protobuf.trade.TradeOrderInfo.PARSER, extensionRegistry));
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
      if (((mutable_bitField0_ & 0x00000004) == 0x00000004)) {
        info_ = java.util.Collections.unmodifiableList(info_);
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.dj.protobuf.trade.Trade.internal_static_Protocols_TradeRoleRsp_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.dj.protobuf.trade.Trade.internal_static_Protocols_TradeRoleRsp_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.dj.protobuf.trade.TradeRoleRsp.class, com.dj.protobuf.trade.TradeRoleRsp.Builder.class);
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
  private com.dj.protobuf.trade.TradeRoleReq req_;
  /**
   * <code>optional .Protocols.TradeRoleReq req = 2;</code>
   */
  public boolean hasReq() {
    return ((bitField0_ & 0x00000002) == 0x00000002);
  }
  /**
   * <code>optional .Protocols.TradeRoleReq req = 2;</code>
   */
  public com.dj.protobuf.trade.TradeRoleReq getReq() {
    return req_ == null ? com.dj.protobuf.trade.TradeRoleReq.getDefaultInstance() : req_;
  }
  /**
   * <code>optional .Protocols.TradeRoleReq req = 2;</code>
   */
  public com.dj.protobuf.trade.TradeRoleReqOrBuilder getReqOrBuilder() {
    return req_ == null ? com.dj.protobuf.trade.TradeRoleReq.getDefaultInstance() : req_;
  }

  public static final int INFO_FIELD_NUMBER = 3;
  private java.util.List<com.dj.protobuf.trade.TradeOrderInfo> info_;
  /**
   * <pre>
   * ????????????
   * </pre>
   *
   * <code>repeated .Protocols.TradeOrderInfo info = 3;</code>
   */
  public java.util.List<com.dj.protobuf.trade.TradeOrderInfo> getInfoList() {
    return info_;
  }
  /**
   * <pre>
   * ????????????
   * </pre>
   *
   * <code>repeated .Protocols.TradeOrderInfo info = 3;</code>
   */
  public java.util.List<? extends com.dj.protobuf.trade.TradeOrderInfoOrBuilder> 
      getInfoOrBuilderList() {
    return info_;
  }
  /**
   * <pre>
   * ????????????
   * </pre>
   *
   * <code>repeated .Protocols.TradeOrderInfo info = 3;</code>
   */
  public int getInfoCount() {
    return info_.size();
  }
  /**
   * <pre>
   * ????????????
   * </pre>
   *
   * <code>repeated .Protocols.TradeOrderInfo info = 3;</code>
   */
  public com.dj.protobuf.trade.TradeOrderInfo getInfo(int index) {
    return info_.get(index);
  }
  /**
   * <pre>
   * ????????????
   * </pre>
   *
   * <code>repeated .Protocols.TradeOrderInfo info = 3;</code>
   */
  public com.dj.protobuf.trade.TradeOrderInfoOrBuilder getInfoOrBuilder(
      int index) {
    return info_.get(index);
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
    for (int i = 0; i < info_.size(); i++) {
      output.writeMessage(3, info_.get(i));
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
    for (int i = 0; i < info_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(3, info_.get(i));
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
    if (!(obj instanceof com.dj.protobuf.trade.TradeRoleRsp)) {
      return super.equals(obj);
    }
    com.dj.protobuf.trade.TradeRoleRsp other = (com.dj.protobuf.trade.TradeRoleRsp) obj;

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
    result = result && getInfoList()
        .equals(other.getInfoList());
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
    if (getInfoCount() > 0) {
      hash = (37 * hash) + INFO_FIELD_NUMBER;
      hash = (53 * hash) + getInfoList().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.dj.protobuf.trade.TradeRoleRsp parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dj.protobuf.trade.TradeRoleRsp parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dj.protobuf.trade.TradeRoleRsp parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dj.protobuf.trade.TradeRoleRsp parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dj.protobuf.trade.TradeRoleRsp parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.trade.TradeRoleRsp parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.dj.protobuf.trade.TradeRoleRsp parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.trade.TradeRoleRsp parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.dj.protobuf.trade.TradeRoleRsp parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.trade.TradeRoleRsp parseFrom(
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
  public static Builder newBuilder(com.dj.protobuf.trade.TradeRoleRsp prototype) {
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
   * Protobuf type {@code Protocols.TradeRoleRsp}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:Protocols.TradeRoleRsp)
      com.dj.protobuf.trade.TradeRoleRspOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.dj.protobuf.trade.Trade.internal_static_Protocols_TradeRoleRsp_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.dj.protobuf.trade.Trade.internal_static_Protocols_TradeRoleRsp_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.dj.protobuf.trade.TradeRoleRsp.class, com.dj.protobuf.trade.TradeRoleRsp.Builder.class);
    }

    // Construct using com.dj.protobuf.trade.TradeRoleRsp.newBuilder()
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
        getInfoFieldBuilder();
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
      if (infoBuilder_ == null) {
        info_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000004);
      } else {
        infoBuilder_.clear();
      }
      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.dj.protobuf.trade.Trade.internal_static_Protocols_TradeRoleRsp_descriptor;
    }

    public com.dj.protobuf.trade.TradeRoleRsp getDefaultInstanceForType() {
      return com.dj.protobuf.trade.TradeRoleRsp.getDefaultInstance();
    }

    public com.dj.protobuf.trade.TradeRoleRsp build() {
      com.dj.protobuf.trade.TradeRoleRsp result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public com.dj.protobuf.trade.TradeRoleRsp buildPartial() {
      com.dj.protobuf.trade.TradeRoleRsp result = new com.dj.protobuf.trade.TradeRoleRsp(this);
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
      if (infoBuilder_ == null) {
        if (((bitField0_ & 0x00000004) == 0x00000004)) {
          info_ = java.util.Collections.unmodifiableList(info_);
          bitField0_ = (bitField0_ & ~0x00000004);
        }
        result.info_ = info_;
      } else {
        result.info_ = infoBuilder_.build();
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
      if (other instanceof com.dj.protobuf.trade.TradeRoleRsp) {
        return mergeFrom((com.dj.protobuf.trade.TradeRoleRsp)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.dj.protobuf.trade.TradeRoleRsp other) {
      if (other == com.dj.protobuf.trade.TradeRoleRsp.getDefaultInstance()) return this;
      if (other.hasErrorID()) {
        setErrorID(other.getErrorID());
      }
      if (other.hasReq()) {
        mergeReq(other.getReq());
      }
      if (infoBuilder_ == null) {
        if (!other.info_.isEmpty()) {
          if (info_.isEmpty()) {
            info_ = other.info_;
            bitField0_ = (bitField0_ & ~0x00000004);
          } else {
            ensureInfoIsMutable();
            info_.addAll(other.info_);
          }
          onChanged();
        }
      } else {
        if (!other.info_.isEmpty()) {
          if (infoBuilder_.isEmpty()) {
            infoBuilder_.dispose();
            infoBuilder_ = null;
            info_ = other.info_;
            bitField0_ = (bitField0_ & ~0x00000004);
            infoBuilder_ = 
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getInfoFieldBuilder() : null;
          } else {
            infoBuilder_.addAllMessages(other.info_);
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
      com.dj.protobuf.trade.TradeRoleRsp parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.dj.protobuf.trade.TradeRoleRsp) e.getUnfinishedMessage();
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

    private com.dj.protobuf.trade.TradeRoleReq req_ = null;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.dj.protobuf.trade.TradeRoleReq, com.dj.protobuf.trade.TradeRoleReq.Builder, com.dj.protobuf.trade.TradeRoleReqOrBuilder> reqBuilder_;
    /**
     * <code>optional .Protocols.TradeRoleReq req = 2;</code>
     */
    public boolean hasReq() {
      return ((bitField0_ & 0x00000002) == 0x00000002);
    }
    /**
     * <code>optional .Protocols.TradeRoleReq req = 2;</code>
     */
    public com.dj.protobuf.trade.TradeRoleReq getReq() {
      if (reqBuilder_ == null) {
        return req_ == null ? com.dj.protobuf.trade.TradeRoleReq.getDefaultInstance() : req_;
      } else {
        return reqBuilder_.getMessage();
      }
    }
    /**
     * <code>optional .Protocols.TradeRoleReq req = 2;</code>
     */
    public Builder setReq(com.dj.protobuf.trade.TradeRoleReq value) {
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
     * <code>optional .Protocols.TradeRoleReq req = 2;</code>
     */
    public Builder setReq(
        com.dj.protobuf.trade.TradeRoleReq.Builder builderForValue) {
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
     * <code>optional .Protocols.TradeRoleReq req = 2;</code>
     */
    public Builder mergeReq(com.dj.protobuf.trade.TradeRoleReq value) {
      if (reqBuilder_ == null) {
        if (((bitField0_ & 0x00000002) == 0x00000002) &&
            req_ != null &&
            req_ != com.dj.protobuf.trade.TradeRoleReq.getDefaultInstance()) {
          req_ =
            com.dj.protobuf.trade.TradeRoleReq.newBuilder(req_).mergeFrom(value).buildPartial();
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
     * <code>optional .Protocols.TradeRoleReq req = 2;</code>
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
     * <code>optional .Protocols.TradeRoleReq req = 2;</code>
     */
    public com.dj.protobuf.trade.TradeRoleReq.Builder getReqBuilder() {
      bitField0_ |= 0x00000002;
      onChanged();
      return getReqFieldBuilder().getBuilder();
    }
    /**
     * <code>optional .Protocols.TradeRoleReq req = 2;</code>
     */
    public com.dj.protobuf.trade.TradeRoleReqOrBuilder getReqOrBuilder() {
      if (reqBuilder_ != null) {
        return reqBuilder_.getMessageOrBuilder();
      } else {
        return req_ == null ?
            com.dj.protobuf.trade.TradeRoleReq.getDefaultInstance() : req_;
      }
    }
    /**
     * <code>optional .Protocols.TradeRoleReq req = 2;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.dj.protobuf.trade.TradeRoleReq, com.dj.protobuf.trade.TradeRoleReq.Builder, com.dj.protobuf.trade.TradeRoleReqOrBuilder> 
        getReqFieldBuilder() {
      if (reqBuilder_ == null) {
        reqBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.dj.protobuf.trade.TradeRoleReq, com.dj.protobuf.trade.TradeRoleReq.Builder, com.dj.protobuf.trade.TradeRoleReqOrBuilder>(
                getReq(),
                getParentForChildren(),
                isClean());
        req_ = null;
      }
      return reqBuilder_;
    }

    private java.util.List<com.dj.protobuf.trade.TradeOrderInfo> info_ =
      java.util.Collections.emptyList();
    private void ensureInfoIsMutable() {
      if (!((bitField0_ & 0x00000004) == 0x00000004)) {
        info_ = new java.util.ArrayList<com.dj.protobuf.trade.TradeOrderInfo>(info_);
        bitField0_ |= 0x00000004;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        com.dj.protobuf.trade.TradeOrderInfo, com.dj.protobuf.trade.TradeOrderInfo.Builder, com.dj.protobuf.trade.TradeOrderInfoOrBuilder> infoBuilder_;

    /**
     * <pre>
     * ????????????
     * </pre>
     *
     * <code>repeated .Protocols.TradeOrderInfo info = 3;</code>
     */
    public java.util.List<com.dj.protobuf.trade.TradeOrderInfo> getInfoList() {
      if (infoBuilder_ == null) {
        return java.util.Collections.unmodifiableList(info_);
      } else {
        return infoBuilder_.getMessageList();
      }
    }
    /**
     * <pre>
     * ????????????
     * </pre>
     *
     * <code>repeated .Protocols.TradeOrderInfo info = 3;</code>
     */
    public int getInfoCount() {
      if (infoBuilder_ == null) {
        return info_.size();
      } else {
        return infoBuilder_.getCount();
      }
    }
    /**
     * <pre>
     * ????????????
     * </pre>
     *
     * <code>repeated .Protocols.TradeOrderInfo info = 3;</code>
     */
    public com.dj.protobuf.trade.TradeOrderInfo getInfo(int index) {
      if (infoBuilder_ == null) {
        return info_.get(index);
      } else {
        return infoBuilder_.getMessage(index);
      }
    }
    /**
     * <pre>
     * ????????????
     * </pre>
     *
     * <code>repeated .Protocols.TradeOrderInfo info = 3;</code>
     */
    public Builder setInfo(
        int index, com.dj.protobuf.trade.TradeOrderInfo value) {
      if (infoBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureInfoIsMutable();
        info_.set(index, value);
        onChanged();
      } else {
        infoBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <pre>
     * ????????????
     * </pre>
     *
     * <code>repeated .Protocols.TradeOrderInfo info = 3;</code>
     */
    public Builder setInfo(
        int index, com.dj.protobuf.trade.TradeOrderInfo.Builder builderForValue) {
      if (infoBuilder_ == null) {
        ensureInfoIsMutable();
        info_.set(index, builderForValue.build());
        onChanged();
      } else {
        infoBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <pre>
     * ????????????
     * </pre>
     *
     * <code>repeated .Protocols.TradeOrderInfo info = 3;</code>
     */
    public Builder addInfo(com.dj.protobuf.trade.TradeOrderInfo value) {
      if (infoBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureInfoIsMutable();
        info_.add(value);
        onChanged();
      } else {
        infoBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <pre>
     * ????????????
     * </pre>
     *
     * <code>repeated .Protocols.TradeOrderInfo info = 3;</code>
     */
    public Builder addInfo(
        int index, com.dj.protobuf.trade.TradeOrderInfo value) {
      if (infoBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureInfoIsMutable();
        info_.add(index, value);
        onChanged();
      } else {
        infoBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <pre>
     * ????????????
     * </pre>
     *
     * <code>repeated .Protocols.TradeOrderInfo info = 3;</code>
     */
    public Builder addInfo(
        com.dj.protobuf.trade.TradeOrderInfo.Builder builderForValue) {
      if (infoBuilder_ == null) {
        ensureInfoIsMutable();
        info_.add(builderForValue.build());
        onChanged();
      } else {
        infoBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <pre>
     * ????????????
     * </pre>
     *
     * <code>repeated .Protocols.TradeOrderInfo info = 3;</code>
     */
    public Builder addInfo(
        int index, com.dj.protobuf.trade.TradeOrderInfo.Builder builderForValue) {
      if (infoBuilder_ == null) {
        ensureInfoIsMutable();
        info_.add(index, builderForValue.build());
        onChanged();
      } else {
        infoBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <pre>
     * ????????????
     * </pre>
     *
     * <code>repeated .Protocols.TradeOrderInfo info = 3;</code>
     */
    public Builder addAllInfo(
        java.lang.Iterable<? extends com.dj.protobuf.trade.TradeOrderInfo> values) {
      if (infoBuilder_ == null) {
        ensureInfoIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, info_);
        onChanged();
      } else {
        infoBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <pre>
     * ????????????
     * </pre>
     *
     * <code>repeated .Protocols.TradeOrderInfo info = 3;</code>
     */
    public Builder clearInfo() {
      if (infoBuilder_ == null) {
        info_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000004);
        onChanged();
      } else {
        infoBuilder_.clear();
      }
      return this;
    }
    /**
     * <pre>
     * ????????????
     * </pre>
     *
     * <code>repeated .Protocols.TradeOrderInfo info = 3;</code>
     */
    public Builder removeInfo(int index) {
      if (infoBuilder_ == null) {
        ensureInfoIsMutable();
        info_.remove(index);
        onChanged();
      } else {
        infoBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <pre>
     * ????????????
     * </pre>
     *
     * <code>repeated .Protocols.TradeOrderInfo info = 3;</code>
     */
    public com.dj.protobuf.trade.TradeOrderInfo.Builder getInfoBuilder(
        int index) {
      return getInfoFieldBuilder().getBuilder(index);
    }
    /**
     * <pre>
     * ????????????
     * </pre>
     *
     * <code>repeated .Protocols.TradeOrderInfo info = 3;</code>
     */
    public com.dj.protobuf.trade.TradeOrderInfoOrBuilder getInfoOrBuilder(
        int index) {
      if (infoBuilder_ == null) {
        return info_.get(index);  } else {
        return infoBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <pre>
     * ????????????
     * </pre>
     *
     * <code>repeated .Protocols.TradeOrderInfo info = 3;</code>
     */
    public java.util.List<? extends com.dj.protobuf.trade.TradeOrderInfoOrBuilder> 
         getInfoOrBuilderList() {
      if (infoBuilder_ != null) {
        return infoBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(info_);
      }
    }
    /**
     * <pre>
     * ????????????
     * </pre>
     *
     * <code>repeated .Protocols.TradeOrderInfo info = 3;</code>
     */
    public com.dj.protobuf.trade.TradeOrderInfo.Builder addInfoBuilder() {
      return getInfoFieldBuilder().addBuilder(
          com.dj.protobuf.trade.TradeOrderInfo.getDefaultInstance());
    }
    /**
     * <pre>
     * ????????????
     * </pre>
     *
     * <code>repeated .Protocols.TradeOrderInfo info = 3;</code>
     */
    public com.dj.protobuf.trade.TradeOrderInfo.Builder addInfoBuilder(
        int index) {
      return getInfoFieldBuilder().addBuilder(
          index, com.dj.protobuf.trade.TradeOrderInfo.getDefaultInstance());
    }
    /**
     * <pre>
     * ????????????
     * </pre>
     *
     * <code>repeated .Protocols.TradeOrderInfo info = 3;</code>
     */
    public java.util.List<com.dj.protobuf.trade.TradeOrderInfo.Builder> 
         getInfoBuilderList() {
      return getInfoFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        com.dj.protobuf.trade.TradeOrderInfo, com.dj.protobuf.trade.TradeOrderInfo.Builder, com.dj.protobuf.trade.TradeOrderInfoOrBuilder> 
        getInfoFieldBuilder() {
      if (infoBuilder_ == null) {
        infoBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            com.dj.protobuf.trade.TradeOrderInfo, com.dj.protobuf.trade.TradeOrderInfo.Builder, com.dj.protobuf.trade.TradeOrderInfoOrBuilder>(
                info_,
                ((bitField0_ & 0x00000004) == 0x00000004),
                getParentForChildren(),
                isClean());
        info_ = null;
      }
      return infoBuilder_;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:Protocols.TradeRoleRsp)
  }

  // @@protoc_insertion_point(class_scope:Protocols.TradeRoleRsp)
  private static final com.dj.protobuf.trade.TradeRoleRsp DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.dj.protobuf.trade.TradeRoleRsp();
  }

  public static com.dj.protobuf.trade.TradeRoleRsp getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  @java.lang.Deprecated public static final com.google.protobuf.Parser<TradeRoleRsp>
      PARSER = new com.google.protobuf.AbstractParser<TradeRoleRsp>() {
    public TradeRoleRsp parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new TradeRoleRsp(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<TradeRoleRsp> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<TradeRoleRsp> getParserForType() {
    return PARSER;
  }

  public com.dj.protobuf.trade.TradeRoleRsp getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

