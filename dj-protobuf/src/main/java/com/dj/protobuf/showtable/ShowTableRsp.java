// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: ShowTable.proto

package com.dj.protobuf.showtable;

/**
 * Protobuf type {@code Protocols.ShowTableRsp}
 */
public  final class ShowTableRsp extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:Protocols.ShowTableRsp)
    ShowTableRspOrBuilder {
  // Use ShowTableRsp.newBuilder() to construct.
  private ShowTableRsp(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private ShowTableRsp() {
    errorID_ = 0;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private ShowTableRsp(
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
            com.dj.protobuf.showtable.ShowTableReq.Builder subBuilder = null;
            if (((bitField0_ & 0x00000002) == 0x00000002)) {
              subBuilder = req_.toBuilder();
            }
            req_ = input.readMessage(com.dj.protobuf.showtable.ShowTableReq.PARSER, extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(req_);
              req_ = subBuilder.buildPartial();
            }
            bitField0_ |= 0x00000002;
            break;
          }
          case 26: {
            com.dj.protobuf.showtable.ShowTableGrids.Builder subBuilder = null;
            if (((bitField0_ & 0x00000004) == 0x00000004)) {
              subBuilder = grids_.toBuilder();
            }
            grids_ = input.readMessage(com.dj.protobuf.showtable.ShowTableGrids.PARSER, extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(grids_);
              grids_ = subBuilder.buildPartial();
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
    return com.dj.protobuf.showtable.ShowTable.internal_static_Protocols_ShowTableRsp_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.dj.protobuf.showtable.ShowTable.internal_static_Protocols_ShowTableRsp_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.dj.protobuf.showtable.ShowTableRsp.class, com.dj.protobuf.showtable.ShowTableRsp.Builder.class);
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
  private com.dj.protobuf.showtable.ShowTableReq req_;
  /**
   * <code>optional .Protocols.ShowTableReq req = 2;</code>
   */
  public boolean hasReq() {
    return ((bitField0_ & 0x00000002) == 0x00000002);
  }
  /**
   * <code>optional .Protocols.ShowTableReq req = 2;</code>
   */
  public com.dj.protobuf.showtable.ShowTableReq getReq() {
    return req_ == null ? com.dj.protobuf.showtable.ShowTableReq.getDefaultInstance() : req_;
  }
  /**
   * <code>optional .Protocols.ShowTableReq req = 2;</code>
   */
  public com.dj.protobuf.showtable.ShowTableReqOrBuilder getReqOrBuilder() {
    return req_ == null ? com.dj.protobuf.showtable.ShowTableReq.getDefaultInstance() : req_;
  }

  public static final int GRIDS_FIELD_NUMBER = 3;
  private com.dj.protobuf.showtable.ShowTableGrids grids_;
  /**
   * <code>optional .Protocols.ShowTableGrids grids = 3;</code>
   */
  public boolean hasGrids() {
    return ((bitField0_ & 0x00000004) == 0x00000004);
  }
  /**
   * <code>optional .Protocols.ShowTableGrids grids = 3;</code>
   */
  public com.dj.protobuf.showtable.ShowTableGrids getGrids() {
    return grids_ == null ? com.dj.protobuf.showtable.ShowTableGrids.getDefaultInstance() : grids_;
  }
  /**
   * <code>optional .Protocols.ShowTableGrids grids = 3;</code>
   */
  public com.dj.protobuf.showtable.ShowTableGridsOrBuilder getGridsOrBuilder() {
    return grids_ == null ? com.dj.protobuf.showtable.ShowTableGrids.getDefaultInstance() : grids_;
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
      output.writeMessage(3, getGrids());
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
        .computeMessageSize(3, getGrids());
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
    if (!(obj instanceof com.dj.protobuf.showtable.ShowTableRsp)) {
      return super.equals(obj);
    }
    com.dj.protobuf.showtable.ShowTableRsp other = (com.dj.protobuf.showtable.ShowTableRsp) obj;

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
    result = result && (hasGrids() == other.hasGrids());
    if (hasGrids()) {
      result = result && getGrids()
          .equals(other.getGrids());
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
    if (hasGrids()) {
      hash = (37 * hash) + GRIDS_FIELD_NUMBER;
      hash = (53 * hash) + getGrids().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.dj.protobuf.showtable.ShowTableRsp parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dj.protobuf.showtable.ShowTableRsp parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dj.protobuf.showtable.ShowTableRsp parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dj.protobuf.showtable.ShowTableRsp parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dj.protobuf.showtable.ShowTableRsp parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.showtable.ShowTableRsp parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.dj.protobuf.showtable.ShowTableRsp parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.showtable.ShowTableRsp parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.dj.protobuf.showtable.ShowTableRsp parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.showtable.ShowTableRsp parseFrom(
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
  public static Builder newBuilder(com.dj.protobuf.showtable.ShowTableRsp prototype) {
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
   * Protobuf type {@code Protocols.ShowTableRsp}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:Protocols.ShowTableRsp)
      com.dj.protobuf.showtable.ShowTableRspOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.dj.protobuf.showtable.ShowTable.internal_static_Protocols_ShowTableRsp_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.dj.protobuf.showtable.ShowTable.internal_static_Protocols_ShowTableRsp_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.dj.protobuf.showtable.ShowTableRsp.class, com.dj.protobuf.showtable.ShowTableRsp.Builder.class);
    }

    // Construct using com.dj.protobuf.showtable.ShowTableRsp.newBuilder()
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
        getGridsFieldBuilder();
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
      if (gridsBuilder_ == null) {
        grids_ = null;
      } else {
        gridsBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000004);
      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.dj.protobuf.showtable.ShowTable.internal_static_Protocols_ShowTableRsp_descriptor;
    }

    public com.dj.protobuf.showtable.ShowTableRsp getDefaultInstanceForType() {
      return com.dj.protobuf.showtable.ShowTableRsp.getDefaultInstance();
    }

    public com.dj.protobuf.showtable.ShowTableRsp build() {
      com.dj.protobuf.showtable.ShowTableRsp result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public com.dj.protobuf.showtable.ShowTableRsp buildPartial() {
      com.dj.protobuf.showtable.ShowTableRsp result = new com.dj.protobuf.showtable.ShowTableRsp(this);
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
      if (gridsBuilder_ == null) {
        result.grids_ = grids_;
      } else {
        result.grids_ = gridsBuilder_.build();
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
      if (other instanceof com.dj.protobuf.showtable.ShowTableRsp) {
        return mergeFrom((com.dj.protobuf.showtable.ShowTableRsp)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.dj.protobuf.showtable.ShowTableRsp other) {
      if (other == com.dj.protobuf.showtable.ShowTableRsp.getDefaultInstance()) return this;
      if (other.hasErrorID()) {
        setErrorID(other.getErrorID());
      }
      if (other.hasReq()) {
        mergeReq(other.getReq());
      }
      if (other.hasGrids()) {
        mergeGrids(other.getGrids());
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
      com.dj.protobuf.showtable.ShowTableRsp parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.dj.protobuf.showtable.ShowTableRsp) e.getUnfinishedMessage();
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

    private com.dj.protobuf.showtable.ShowTableReq req_ = null;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.dj.protobuf.showtable.ShowTableReq, com.dj.protobuf.showtable.ShowTableReq.Builder, com.dj.protobuf.showtable.ShowTableReqOrBuilder> reqBuilder_;
    /**
     * <code>optional .Protocols.ShowTableReq req = 2;</code>
     */
    public boolean hasReq() {
      return ((bitField0_ & 0x00000002) == 0x00000002);
    }
    /**
     * <code>optional .Protocols.ShowTableReq req = 2;</code>
     */
    public com.dj.protobuf.showtable.ShowTableReq getReq() {
      if (reqBuilder_ == null) {
        return req_ == null ? com.dj.protobuf.showtable.ShowTableReq.getDefaultInstance() : req_;
      } else {
        return reqBuilder_.getMessage();
      }
    }
    /**
     * <code>optional .Protocols.ShowTableReq req = 2;</code>
     */
    public Builder setReq(com.dj.protobuf.showtable.ShowTableReq value) {
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
     * <code>optional .Protocols.ShowTableReq req = 2;</code>
     */
    public Builder setReq(
        com.dj.protobuf.showtable.ShowTableReq.Builder builderForValue) {
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
     * <code>optional .Protocols.ShowTableReq req = 2;</code>
     */
    public Builder mergeReq(com.dj.protobuf.showtable.ShowTableReq value) {
      if (reqBuilder_ == null) {
        if (((bitField0_ & 0x00000002) == 0x00000002) &&
            req_ != null &&
            req_ != com.dj.protobuf.showtable.ShowTableReq.getDefaultInstance()) {
          req_ =
            com.dj.protobuf.showtable.ShowTableReq.newBuilder(req_).mergeFrom(value).buildPartial();
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
     * <code>optional .Protocols.ShowTableReq req = 2;</code>
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
     * <code>optional .Protocols.ShowTableReq req = 2;</code>
     */
    public com.dj.protobuf.showtable.ShowTableReq.Builder getReqBuilder() {
      bitField0_ |= 0x00000002;
      onChanged();
      return getReqFieldBuilder().getBuilder();
    }
    /**
     * <code>optional .Protocols.ShowTableReq req = 2;</code>
     */
    public com.dj.protobuf.showtable.ShowTableReqOrBuilder getReqOrBuilder() {
      if (reqBuilder_ != null) {
        return reqBuilder_.getMessageOrBuilder();
      } else {
        return req_ == null ?
            com.dj.protobuf.showtable.ShowTableReq.getDefaultInstance() : req_;
      }
    }
    /**
     * <code>optional .Protocols.ShowTableReq req = 2;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.dj.protobuf.showtable.ShowTableReq, com.dj.protobuf.showtable.ShowTableReq.Builder, com.dj.protobuf.showtable.ShowTableReqOrBuilder> 
        getReqFieldBuilder() {
      if (reqBuilder_ == null) {
        reqBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.dj.protobuf.showtable.ShowTableReq, com.dj.protobuf.showtable.ShowTableReq.Builder, com.dj.protobuf.showtable.ShowTableReqOrBuilder>(
                getReq(),
                getParentForChildren(),
                isClean());
        req_ = null;
      }
      return reqBuilder_;
    }

    private com.dj.protobuf.showtable.ShowTableGrids grids_ = null;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.dj.protobuf.showtable.ShowTableGrids, com.dj.protobuf.showtable.ShowTableGrids.Builder, com.dj.protobuf.showtable.ShowTableGridsOrBuilder> gridsBuilder_;
    /**
     * <code>optional .Protocols.ShowTableGrids grids = 3;</code>
     */
    public boolean hasGrids() {
      return ((bitField0_ & 0x00000004) == 0x00000004);
    }
    /**
     * <code>optional .Protocols.ShowTableGrids grids = 3;</code>
     */
    public com.dj.protobuf.showtable.ShowTableGrids getGrids() {
      if (gridsBuilder_ == null) {
        return grids_ == null ? com.dj.protobuf.showtable.ShowTableGrids.getDefaultInstance() : grids_;
      } else {
        return gridsBuilder_.getMessage();
      }
    }
    /**
     * <code>optional .Protocols.ShowTableGrids grids = 3;</code>
     */
    public Builder setGrids(com.dj.protobuf.showtable.ShowTableGrids value) {
      if (gridsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        grids_ = value;
        onChanged();
      } else {
        gridsBuilder_.setMessage(value);
      }
      bitField0_ |= 0x00000004;
      return this;
    }
    /**
     * <code>optional .Protocols.ShowTableGrids grids = 3;</code>
     */
    public Builder setGrids(
        com.dj.protobuf.showtable.ShowTableGrids.Builder builderForValue) {
      if (gridsBuilder_ == null) {
        grids_ = builderForValue.build();
        onChanged();
      } else {
        gridsBuilder_.setMessage(builderForValue.build());
      }
      bitField0_ |= 0x00000004;
      return this;
    }
    /**
     * <code>optional .Protocols.ShowTableGrids grids = 3;</code>
     */
    public Builder mergeGrids(com.dj.protobuf.showtable.ShowTableGrids value) {
      if (gridsBuilder_ == null) {
        if (((bitField0_ & 0x00000004) == 0x00000004) &&
            grids_ != null &&
            grids_ != com.dj.protobuf.showtable.ShowTableGrids.getDefaultInstance()) {
          grids_ =
            com.dj.protobuf.showtable.ShowTableGrids.newBuilder(grids_).mergeFrom(value).buildPartial();
        } else {
          grids_ = value;
        }
        onChanged();
      } else {
        gridsBuilder_.mergeFrom(value);
      }
      bitField0_ |= 0x00000004;
      return this;
    }
    /**
     * <code>optional .Protocols.ShowTableGrids grids = 3;</code>
     */
    public Builder clearGrids() {
      if (gridsBuilder_ == null) {
        grids_ = null;
        onChanged();
      } else {
        gridsBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000004);
      return this;
    }
    /**
     * <code>optional .Protocols.ShowTableGrids grids = 3;</code>
     */
    public com.dj.protobuf.showtable.ShowTableGrids.Builder getGridsBuilder() {
      bitField0_ |= 0x00000004;
      onChanged();
      return getGridsFieldBuilder().getBuilder();
    }
    /**
     * <code>optional .Protocols.ShowTableGrids grids = 3;</code>
     */
    public com.dj.protobuf.showtable.ShowTableGridsOrBuilder getGridsOrBuilder() {
      if (gridsBuilder_ != null) {
        return gridsBuilder_.getMessageOrBuilder();
      } else {
        return grids_ == null ?
            com.dj.protobuf.showtable.ShowTableGrids.getDefaultInstance() : grids_;
      }
    }
    /**
     * <code>optional .Protocols.ShowTableGrids grids = 3;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.dj.protobuf.showtable.ShowTableGrids, com.dj.protobuf.showtable.ShowTableGrids.Builder, com.dj.protobuf.showtable.ShowTableGridsOrBuilder> 
        getGridsFieldBuilder() {
      if (gridsBuilder_ == null) {
        gridsBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.dj.protobuf.showtable.ShowTableGrids, com.dj.protobuf.showtable.ShowTableGrids.Builder, com.dj.protobuf.showtable.ShowTableGridsOrBuilder>(
                getGrids(),
                getParentForChildren(),
                isClean());
        grids_ = null;
      }
      return gridsBuilder_;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:Protocols.ShowTableRsp)
  }

  // @@protoc_insertion_point(class_scope:Protocols.ShowTableRsp)
  private static final com.dj.protobuf.showtable.ShowTableRsp DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.dj.protobuf.showtable.ShowTableRsp();
  }

  public static com.dj.protobuf.showtable.ShowTableRsp getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  @java.lang.Deprecated public static final com.google.protobuf.Parser<ShowTableRsp>
      PARSER = new com.google.protobuf.AbstractParser<ShowTableRsp>() {
    public ShowTableRsp parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new ShowTableRsp(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<ShowTableRsp> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<ShowTableRsp> getParserForType() {
    return PARSER;
  }

  public com.dj.protobuf.showtable.ShowTableRsp getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

