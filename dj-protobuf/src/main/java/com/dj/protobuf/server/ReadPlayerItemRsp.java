// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Server.proto

package com.dj.protobuf.server;

/**
 * <pre>
 *响应获取玩家道具
 * </pre>
 *
 * Protobuf type {@code Protocols.ReadPlayerItemRsp}
 */
public  final class ReadPlayerItemRsp extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:Protocols.ReadPlayerItemRsp)
    ReadPlayerItemRspOrBuilder {
  // Use ReadPlayerItemRsp.newBuilder() to construct.
  private ReadPlayerItemRsp(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private ReadPlayerItemRsp() {
    data_ = "";
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private ReadPlayerItemRsp(
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
            com.dj.protobuf.server.ReadPlayerItemReq.Builder subBuilder = null;
            if (((bitField0_ & 0x00000001) == 0x00000001)) {
              subBuilder = req_.toBuilder();
            }
            req_ = input.readMessage(com.dj.protobuf.server.ReadPlayerItemReq.PARSER, extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(req_);
              req_ = subBuilder.buildPartial();
            }
            bitField0_ |= 0x00000001;
            break;
          }
          case 18: {
            com.google.protobuf.ByteString bs = input.readBytes();
            bitField0_ |= 0x00000002;
            data_ = bs;
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
    return com.dj.protobuf.server.Server.internal_static_Protocols_ReadPlayerItemRsp_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.dj.protobuf.server.Server.internal_static_Protocols_ReadPlayerItemRsp_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.dj.protobuf.server.ReadPlayerItemRsp.class, com.dj.protobuf.server.ReadPlayerItemRsp.Builder.class);
  }

  private int bitField0_;
  public static final int REQ_FIELD_NUMBER = 1;
  private com.dj.protobuf.server.ReadPlayerItemReq req_;
  /**
   * <code>optional .Protocols.ReadPlayerItemReq req = 1;</code>
   */
  public boolean hasReq() {
    return ((bitField0_ & 0x00000001) == 0x00000001);
  }
  /**
   * <code>optional .Protocols.ReadPlayerItemReq req = 1;</code>
   */
  public com.dj.protobuf.server.ReadPlayerItemReq getReq() {
    return req_ == null ? com.dj.protobuf.server.ReadPlayerItemReq.getDefaultInstance() : req_;
  }
  /**
   * <code>optional .Protocols.ReadPlayerItemReq req = 1;</code>
   */
  public com.dj.protobuf.server.ReadPlayerItemReqOrBuilder getReqOrBuilder() {
    return req_ == null ? com.dj.protobuf.server.ReadPlayerItemReq.getDefaultInstance() : req_;
  }

  public static final int DATA_FIELD_NUMBER = 2;
  private volatile java.lang.Object data_;
  /**
   * <code>optional string data = 2;</code>
   */
  public boolean hasData() {
    return ((bitField0_ & 0x00000002) == 0x00000002);
  }
  /**
   * <code>optional string data = 2;</code>
   */
  public java.lang.String getData() {
    java.lang.Object ref = data_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      if (bs.isValidUtf8()) {
        data_ = s;
      }
      return s;
    }
  }
  /**
   * <code>optional string data = 2;</code>
   */
  public com.google.protobuf.ByteString
      getDataBytes() {
    java.lang.Object ref = data_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      data_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
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
      output.writeMessage(1, getReq());
    }
    if (((bitField0_ & 0x00000002) == 0x00000002)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, data_);
    }
    unknownFields.writeTo(output);
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (((bitField0_ & 0x00000001) == 0x00000001)) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, getReq());
    }
    if (((bitField0_ & 0x00000002) == 0x00000002)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, data_);
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
    if (!(obj instanceof com.dj.protobuf.server.ReadPlayerItemRsp)) {
      return super.equals(obj);
    }
    com.dj.protobuf.server.ReadPlayerItemRsp other = (com.dj.protobuf.server.ReadPlayerItemRsp) obj;

    boolean result = true;
    result = result && (hasReq() == other.hasReq());
    if (hasReq()) {
      result = result && getReq()
          .equals(other.getReq());
    }
    result = result && (hasData() == other.hasData());
    if (hasData()) {
      result = result && getData()
          .equals(other.getData());
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
    if (hasReq()) {
      hash = (37 * hash) + REQ_FIELD_NUMBER;
      hash = (53 * hash) + getReq().hashCode();
    }
    if (hasData()) {
      hash = (37 * hash) + DATA_FIELD_NUMBER;
      hash = (53 * hash) + getData().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.dj.protobuf.server.ReadPlayerItemRsp parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dj.protobuf.server.ReadPlayerItemRsp parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dj.protobuf.server.ReadPlayerItemRsp parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dj.protobuf.server.ReadPlayerItemRsp parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dj.protobuf.server.ReadPlayerItemRsp parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.server.ReadPlayerItemRsp parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.dj.protobuf.server.ReadPlayerItemRsp parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.server.ReadPlayerItemRsp parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.dj.protobuf.server.ReadPlayerItemRsp parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.server.ReadPlayerItemRsp parseFrom(
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
  public static Builder newBuilder(com.dj.protobuf.server.ReadPlayerItemRsp prototype) {
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
   *响应获取玩家道具
   * </pre>
   *
   * Protobuf type {@code Protocols.ReadPlayerItemRsp}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:Protocols.ReadPlayerItemRsp)
      com.dj.protobuf.server.ReadPlayerItemRspOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.dj.protobuf.server.Server.internal_static_Protocols_ReadPlayerItemRsp_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.dj.protobuf.server.Server.internal_static_Protocols_ReadPlayerItemRsp_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.dj.protobuf.server.ReadPlayerItemRsp.class, com.dj.protobuf.server.ReadPlayerItemRsp.Builder.class);
    }

    // Construct using com.dj.protobuf.server.ReadPlayerItemRsp.newBuilder()
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
      if (reqBuilder_ == null) {
        req_ = null;
      } else {
        reqBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000001);
      data_ = "";
      bitField0_ = (bitField0_ & ~0x00000002);
      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.dj.protobuf.server.Server.internal_static_Protocols_ReadPlayerItemRsp_descriptor;
    }

    public com.dj.protobuf.server.ReadPlayerItemRsp getDefaultInstanceForType() {
      return com.dj.protobuf.server.ReadPlayerItemRsp.getDefaultInstance();
    }

    public com.dj.protobuf.server.ReadPlayerItemRsp build() {
      com.dj.protobuf.server.ReadPlayerItemRsp result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public com.dj.protobuf.server.ReadPlayerItemRsp buildPartial() {
      com.dj.protobuf.server.ReadPlayerItemRsp result = new com.dj.protobuf.server.ReadPlayerItemRsp(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
        to_bitField0_ |= 0x00000001;
      }
      if (reqBuilder_ == null) {
        result.req_ = req_;
      } else {
        result.req_ = reqBuilder_.build();
      }
      if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
        to_bitField0_ |= 0x00000002;
      }
      result.data_ = data_;
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
      if (other instanceof com.dj.protobuf.server.ReadPlayerItemRsp) {
        return mergeFrom((com.dj.protobuf.server.ReadPlayerItemRsp)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.dj.protobuf.server.ReadPlayerItemRsp other) {
      if (other == com.dj.protobuf.server.ReadPlayerItemRsp.getDefaultInstance()) return this;
      if (other.hasReq()) {
        mergeReq(other.getReq());
      }
      if (other.hasData()) {
        bitField0_ |= 0x00000002;
        data_ = other.data_;
        onChanged();
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
      com.dj.protobuf.server.ReadPlayerItemRsp parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.dj.protobuf.server.ReadPlayerItemRsp) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private com.dj.protobuf.server.ReadPlayerItemReq req_ = null;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.dj.protobuf.server.ReadPlayerItemReq, com.dj.protobuf.server.ReadPlayerItemReq.Builder, com.dj.protobuf.server.ReadPlayerItemReqOrBuilder> reqBuilder_;
    /**
     * <code>optional .Protocols.ReadPlayerItemReq req = 1;</code>
     */
    public boolean hasReq() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <code>optional .Protocols.ReadPlayerItemReq req = 1;</code>
     */
    public com.dj.protobuf.server.ReadPlayerItemReq getReq() {
      if (reqBuilder_ == null) {
        return req_ == null ? com.dj.protobuf.server.ReadPlayerItemReq.getDefaultInstance() : req_;
      } else {
        return reqBuilder_.getMessage();
      }
    }
    /**
     * <code>optional .Protocols.ReadPlayerItemReq req = 1;</code>
     */
    public Builder setReq(com.dj.protobuf.server.ReadPlayerItemReq value) {
      if (reqBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        req_ = value;
        onChanged();
      } else {
        reqBuilder_.setMessage(value);
      }
      bitField0_ |= 0x00000001;
      return this;
    }
    /**
     * <code>optional .Protocols.ReadPlayerItemReq req = 1;</code>
     */
    public Builder setReq(
        com.dj.protobuf.server.ReadPlayerItemReq.Builder builderForValue) {
      if (reqBuilder_ == null) {
        req_ = builderForValue.build();
        onChanged();
      } else {
        reqBuilder_.setMessage(builderForValue.build());
      }
      bitField0_ |= 0x00000001;
      return this;
    }
    /**
     * <code>optional .Protocols.ReadPlayerItemReq req = 1;</code>
     */
    public Builder mergeReq(com.dj.protobuf.server.ReadPlayerItemReq value) {
      if (reqBuilder_ == null) {
        if (((bitField0_ & 0x00000001) == 0x00000001) &&
            req_ != null &&
            req_ != com.dj.protobuf.server.ReadPlayerItemReq.getDefaultInstance()) {
          req_ =
            com.dj.protobuf.server.ReadPlayerItemReq.newBuilder(req_).mergeFrom(value).buildPartial();
        } else {
          req_ = value;
        }
        onChanged();
      } else {
        reqBuilder_.mergeFrom(value);
      }
      bitField0_ |= 0x00000001;
      return this;
    }
    /**
     * <code>optional .Protocols.ReadPlayerItemReq req = 1;</code>
     */
    public Builder clearReq() {
      if (reqBuilder_ == null) {
        req_ = null;
        onChanged();
      } else {
        reqBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000001);
      return this;
    }
    /**
     * <code>optional .Protocols.ReadPlayerItemReq req = 1;</code>
     */
    public com.dj.protobuf.server.ReadPlayerItemReq.Builder getReqBuilder() {
      bitField0_ |= 0x00000001;
      onChanged();
      return getReqFieldBuilder().getBuilder();
    }
    /**
     * <code>optional .Protocols.ReadPlayerItemReq req = 1;</code>
     */
    public com.dj.protobuf.server.ReadPlayerItemReqOrBuilder getReqOrBuilder() {
      if (reqBuilder_ != null) {
        return reqBuilder_.getMessageOrBuilder();
      } else {
        return req_ == null ?
            com.dj.protobuf.server.ReadPlayerItemReq.getDefaultInstance() : req_;
      }
    }
    /**
     * <code>optional .Protocols.ReadPlayerItemReq req = 1;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.dj.protobuf.server.ReadPlayerItemReq, com.dj.protobuf.server.ReadPlayerItemReq.Builder, com.dj.protobuf.server.ReadPlayerItemReqOrBuilder> 
        getReqFieldBuilder() {
      if (reqBuilder_ == null) {
        reqBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.dj.protobuf.server.ReadPlayerItemReq, com.dj.protobuf.server.ReadPlayerItemReq.Builder, com.dj.protobuf.server.ReadPlayerItemReqOrBuilder>(
                getReq(),
                getParentForChildren(),
                isClean());
        req_ = null;
      }
      return reqBuilder_;
    }

    private java.lang.Object data_ = "";
    /**
     * <code>optional string data = 2;</code>
     */
    public boolean hasData() {
      return ((bitField0_ & 0x00000002) == 0x00000002);
    }
    /**
     * <code>optional string data = 2;</code>
     */
    public java.lang.String getData() {
      java.lang.Object ref = data_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        if (bs.isValidUtf8()) {
          data_ = s;
        }
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>optional string data = 2;</code>
     */
    public com.google.protobuf.ByteString
        getDataBytes() {
      java.lang.Object ref = data_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        data_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>optional string data = 2;</code>
     */
    public Builder setData(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000002;
      data_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional string data = 2;</code>
     */
    public Builder clearData() {
      bitField0_ = (bitField0_ & ~0x00000002);
      data_ = getDefaultInstance().getData();
      onChanged();
      return this;
    }
    /**
     * <code>optional string data = 2;</code>
     */
    public Builder setDataBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000002;
      data_ = value;
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


    // @@protoc_insertion_point(builder_scope:Protocols.ReadPlayerItemRsp)
  }

  // @@protoc_insertion_point(class_scope:Protocols.ReadPlayerItemRsp)
  private static final com.dj.protobuf.server.ReadPlayerItemRsp DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.dj.protobuf.server.ReadPlayerItemRsp();
  }

  public static com.dj.protobuf.server.ReadPlayerItemRsp getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  @java.lang.Deprecated public static final com.google.protobuf.Parser<ReadPlayerItemRsp>
      PARSER = new com.google.protobuf.AbstractParser<ReadPlayerItemRsp>() {
    public ReadPlayerItemRsp parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new ReadPlayerItemRsp(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<ReadPlayerItemRsp> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<ReadPlayerItemRsp> getParserForType() {
    return PARSER;
  }

  public com.dj.protobuf.server.ReadPlayerItemRsp getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

