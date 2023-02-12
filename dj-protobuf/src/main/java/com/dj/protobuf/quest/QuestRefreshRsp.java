// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Quest.proto

package com.dj.protobuf.quest;

/**
 * Protobuf type {@code Protocols.QuestRefreshRsp}
 */
public  final class QuestRefreshRsp extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:Protocols.QuestRefreshRsp)
    QuestRefreshRspOrBuilder {
  // Use QuestRefreshRsp.newBuilder() to construct.
  private QuestRefreshRsp(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private QuestRefreshRsp() {
    error_ = 0;
    newId_ = 0;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private QuestRefreshRsp(
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
              error_ = rawValue;
            }
            break;
          }
          case 18: {
            com.dj.protobuf.quest.QuestRefreshReq.Builder subBuilder = null;
            if (((bitField0_ & 0x00000002) == 0x00000002)) {
              subBuilder = req_.toBuilder();
            }
            req_ = input.readMessage(com.dj.protobuf.quest.QuestRefreshReq.PARSER, extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(req_);
              req_ = subBuilder.buildPartial();
            }
            bitField0_ |= 0x00000002;
            break;
          }
          case 24: {
            bitField0_ |= 0x00000004;
            newId_ = input.readInt32();
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
    return com.dj.protobuf.quest.Quest.internal_static_Protocols_QuestRefreshRsp_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.dj.protobuf.quest.Quest.internal_static_Protocols_QuestRefreshRsp_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.dj.protobuf.quest.QuestRefreshRsp.class, com.dj.protobuf.quest.QuestRefreshRsp.Builder.class);
  }

  private int bitField0_;
  public static final int ERROR_FIELD_NUMBER = 1;
  private int error_;
  /**
   * <code>optional .ErrorID error = 1;</code>
   */
  public boolean hasError() {
    return ((bitField0_ & 0x00000001) == 0x00000001);
  }
  /**
   * <code>optional .ErrorID error = 1;</code>
   */
  public com.dj.protobuf.ErrorIDOuterClass.ErrorID getError() {
    com.dj.protobuf.ErrorIDOuterClass.ErrorID result = com.dj.protobuf.ErrorIDOuterClass.ErrorID.valueOf(error_);
    return result == null ? com.dj.protobuf.ErrorIDOuterClass.ErrorID.OK : result;
  }

  public static final int REQ_FIELD_NUMBER = 2;
  private com.dj.protobuf.quest.QuestRefreshReq req_;
  /**
   * <code>optional .Protocols.QuestRefreshReq req = 2;</code>
   */
  public boolean hasReq() {
    return ((bitField0_ & 0x00000002) == 0x00000002);
  }
  /**
   * <code>optional .Protocols.QuestRefreshReq req = 2;</code>
   */
  public com.dj.protobuf.quest.QuestRefreshReq getReq() {
    return req_ == null ? com.dj.protobuf.quest.QuestRefreshReq.getDefaultInstance() : req_;
  }
  /**
   * <code>optional .Protocols.QuestRefreshReq req = 2;</code>
   */
  public com.dj.protobuf.quest.QuestRefreshReqOrBuilder getReqOrBuilder() {
    return req_ == null ? com.dj.protobuf.quest.QuestRefreshReq.getDefaultInstance() : req_;
  }

  public static final int NEWID_FIELD_NUMBER = 3;
  private int newId_;
  /**
   * <code>optional int32 newId = 3;</code>
   */
  public boolean hasNewId() {
    return ((bitField0_ & 0x00000004) == 0x00000004);
  }
  /**
   * <code>optional int32 newId = 3;</code>
   */
  public int getNewId() {
    return newId_;
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
      output.writeEnum(1, error_);
    }
    if (((bitField0_ & 0x00000002) == 0x00000002)) {
      output.writeMessage(2, getReq());
    }
    if (((bitField0_ & 0x00000004) == 0x00000004)) {
      output.writeInt32(3, newId_);
    }
    unknownFields.writeTo(output);
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (((bitField0_ & 0x00000001) == 0x00000001)) {
      size += com.google.protobuf.CodedOutputStream
        .computeEnumSize(1, error_);
    }
    if (((bitField0_ & 0x00000002) == 0x00000002)) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(2, getReq());
    }
    if (((bitField0_ & 0x00000004) == 0x00000004)) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(3, newId_);
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
    if (!(obj instanceof com.dj.protobuf.quest.QuestRefreshRsp)) {
      return super.equals(obj);
    }
    com.dj.protobuf.quest.QuestRefreshRsp other = (com.dj.protobuf.quest.QuestRefreshRsp) obj;

    boolean result = true;
    result = result && (hasError() == other.hasError());
    if (hasError()) {
      result = result && error_ == other.error_;
    }
    result = result && (hasReq() == other.hasReq());
    if (hasReq()) {
      result = result && getReq()
          .equals(other.getReq());
    }
    result = result && (hasNewId() == other.hasNewId());
    if (hasNewId()) {
      result = result && (getNewId()
          == other.getNewId());
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
    if (hasError()) {
      hash = (37 * hash) + ERROR_FIELD_NUMBER;
      hash = (53 * hash) + error_;
    }
    if (hasReq()) {
      hash = (37 * hash) + REQ_FIELD_NUMBER;
      hash = (53 * hash) + getReq().hashCode();
    }
    if (hasNewId()) {
      hash = (37 * hash) + NEWID_FIELD_NUMBER;
      hash = (53 * hash) + getNewId();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.dj.protobuf.quest.QuestRefreshRsp parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dj.protobuf.quest.QuestRefreshRsp parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dj.protobuf.quest.QuestRefreshRsp parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dj.protobuf.quest.QuestRefreshRsp parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dj.protobuf.quest.QuestRefreshRsp parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.quest.QuestRefreshRsp parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.dj.protobuf.quest.QuestRefreshRsp parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.quest.QuestRefreshRsp parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.dj.protobuf.quest.QuestRefreshRsp parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.quest.QuestRefreshRsp parseFrom(
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
  public static Builder newBuilder(com.dj.protobuf.quest.QuestRefreshRsp prototype) {
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
   * Protobuf type {@code Protocols.QuestRefreshRsp}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:Protocols.QuestRefreshRsp)
      com.dj.protobuf.quest.QuestRefreshRspOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.dj.protobuf.quest.Quest.internal_static_Protocols_QuestRefreshRsp_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.dj.protobuf.quest.Quest.internal_static_Protocols_QuestRefreshRsp_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.dj.protobuf.quest.QuestRefreshRsp.class, com.dj.protobuf.quest.QuestRefreshRsp.Builder.class);
    }

    // Construct using com.dj.protobuf.quest.QuestRefreshRsp.newBuilder()
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
      error_ = 0;
      bitField0_ = (bitField0_ & ~0x00000001);
      if (reqBuilder_ == null) {
        req_ = null;
      } else {
        reqBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000002);
      newId_ = 0;
      bitField0_ = (bitField0_ & ~0x00000004);
      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.dj.protobuf.quest.Quest.internal_static_Protocols_QuestRefreshRsp_descriptor;
    }

    public com.dj.protobuf.quest.QuestRefreshRsp getDefaultInstanceForType() {
      return com.dj.protobuf.quest.QuestRefreshRsp.getDefaultInstance();
    }

    public com.dj.protobuf.quest.QuestRefreshRsp build() {
      com.dj.protobuf.quest.QuestRefreshRsp result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public com.dj.protobuf.quest.QuestRefreshRsp buildPartial() {
      com.dj.protobuf.quest.QuestRefreshRsp result = new com.dj.protobuf.quest.QuestRefreshRsp(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
        to_bitField0_ |= 0x00000001;
      }
      result.error_ = error_;
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
      result.newId_ = newId_;
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
      if (other instanceof com.dj.protobuf.quest.QuestRefreshRsp) {
        return mergeFrom((com.dj.protobuf.quest.QuestRefreshRsp)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.dj.protobuf.quest.QuestRefreshRsp other) {
      if (other == com.dj.protobuf.quest.QuestRefreshRsp.getDefaultInstance()) return this;
      if (other.hasError()) {
        setError(other.getError());
      }
      if (other.hasReq()) {
        mergeReq(other.getReq());
      }
      if (other.hasNewId()) {
        setNewId(other.getNewId());
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
      com.dj.protobuf.quest.QuestRefreshRsp parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.dj.protobuf.quest.QuestRefreshRsp) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private int error_ = 0;
    /**
     * <code>optional .ErrorID error = 1;</code>
     */
    public boolean hasError() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <code>optional .ErrorID error = 1;</code>
     */
    public com.dj.protobuf.ErrorIDOuterClass.ErrorID getError() {
      com.dj.protobuf.ErrorIDOuterClass.ErrorID result = com.dj.protobuf.ErrorIDOuterClass.ErrorID.valueOf(error_);
      return result == null ? com.dj.protobuf.ErrorIDOuterClass.ErrorID.OK : result;
    }
    /**
     * <code>optional .ErrorID error = 1;</code>
     */
    public Builder setError(com.dj.protobuf.ErrorIDOuterClass.ErrorID value) {
      if (value == null) {
        throw new NullPointerException();
      }
      bitField0_ |= 0x00000001;
      error_ = value.getNumber();
      onChanged();
      return this;
    }
    /**
     * <code>optional .ErrorID error = 1;</code>
     */
    public Builder clearError() {
      bitField0_ = (bitField0_ & ~0x00000001);
      error_ = 0;
      onChanged();
      return this;
    }

    private com.dj.protobuf.quest.QuestRefreshReq req_ = null;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.dj.protobuf.quest.QuestRefreshReq, com.dj.protobuf.quest.QuestRefreshReq.Builder, com.dj.protobuf.quest.QuestRefreshReqOrBuilder> reqBuilder_;
    /**
     * <code>optional .Protocols.QuestRefreshReq req = 2;</code>
     */
    public boolean hasReq() {
      return ((bitField0_ & 0x00000002) == 0x00000002);
    }
    /**
     * <code>optional .Protocols.QuestRefreshReq req = 2;</code>
     */
    public com.dj.protobuf.quest.QuestRefreshReq getReq() {
      if (reqBuilder_ == null) {
        return req_ == null ? com.dj.protobuf.quest.QuestRefreshReq.getDefaultInstance() : req_;
      } else {
        return reqBuilder_.getMessage();
      }
    }
    /**
     * <code>optional .Protocols.QuestRefreshReq req = 2;</code>
     */
    public Builder setReq(com.dj.protobuf.quest.QuestRefreshReq value) {
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
     * <code>optional .Protocols.QuestRefreshReq req = 2;</code>
     */
    public Builder setReq(
        com.dj.protobuf.quest.QuestRefreshReq.Builder builderForValue) {
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
     * <code>optional .Protocols.QuestRefreshReq req = 2;</code>
     */
    public Builder mergeReq(com.dj.protobuf.quest.QuestRefreshReq value) {
      if (reqBuilder_ == null) {
        if (((bitField0_ & 0x00000002) == 0x00000002) &&
            req_ != null &&
            req_ != com.dj.protobuf.quest.QuestRefreshReq.getDefaultInstance()) {
          req_ =
            com.dj.protobuf.quest.QuestRefreshReq.newBuilder(req_).mergeFrom(value).buildPartial();
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
     * <code>optional .Protocols.QuestRefreshReq req = 2;</code>
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
     * <code>optional .Protocols.QuestRefreshReq req = 2;</code>
     */
    public com.dj.protobuf.quest.QuestRefreshReq.Builder getReqBuilder() {
      bitField0_ |= 0x00000002;
      onChanged();
      return getReqFieldBuilder().getBuilder();
    }
    /**
     * <code>optional .Protocols.QuestRefreshReq req = 2;</code>
     */
    public com.dj.protobuf.quest.QuestRefreshReqOrBuilder getReqOrBuilder() {
      if (reqBuilder_ != null) {
        return reqBuilder_.getMessageOrBuilder();
      } else {
        return req_ == null ?
            com.dj.protobuf.quest.QuestRefreshReq.getDefaultInstance() : req_;
      }
    }
    /**
     * <code>optional .Protocols.QuestRefreshReq req = 2;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.dj.protobuf.quest.QuestRefreshReq, com.dj.protobuf.quest.QuestRefreshReq.Builder, com.dj.protobuf.quest.QuestRefreshReqOrBuilder> 
        getReqFieldBuilder() {
      if (reqBuilder_ == null) {
        reqBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.dj.protobuf.quest.QuestRefreshReq, com.dj.protobuf.quest.QuestRefreshReq.Builder, com.dj.protobuf.quest.QuestRefreshReqOrBuilder>(
                getReq(),
                getParentForChildren(),
                isClean());
        req_ = null;
      }
      return reqBuilder_;
    }

    private int newId_ ;
    /**
     * <code>optional int32 newId = 3;</code>
     */
    public boolean hasNewId() {
      return ((bitField0_ & 0x00000004) == 0x00000004);
    }
    /**
     * <code>optional int32 newId = 3;</code>
     */
    public int getNewId() {
      return newId_;
    }
    /**
     * <code>optional int32 newId = 3;</code>
     */
    public Builder setNewId(int value) {
      bitField0_ |= 0x00000004;
      newId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional int32 newId = 3;</code>
     */
    public Builder clearNewId() {
      bitField0_ = (bitField0_ & ~0x00000004);
      newId_ = 0;
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


    // @@protoc_insertion_point(builder_scope:Protocols.QuestRefreshRsp)
  }

  // @@protoc_insertion_point(class_scope:Protocols.QuestRefreshRsp)
  private static final com.dj.protobuf.quest.QuestRefreshRsp DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.dj.protobuf.quest.QuestRefreshRsp();
  }

  public static com.dj.protobuf.quest.QuestRefreshRsp getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  @java.lang.Deprecated public static final com.google.protobuf.Parser<QuestRefreshRsp>
      PARSER = new com.google.protobuf.AbstractParser<QuestRefreshRsp>() {
    public QuestRefreshRsp parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new QuestRefreshRsp(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<QuestRefreshRsp> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<QuestRefreshRsp> getParserForType() {
    return PARSER;
  }

  public com.dj.protobuf.quest.QuestRefreshRsp getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

