// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Character.proto

package com.dj.protobuf.character;

/**
 * Protobuf type {@code Protocols.LeaveHistoryRsp}
 */
public  final class LeaveHistoryRsp extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:Protocols.LeaveHistoryRsp)
    LeaveHistoryRspOrBuilder {
  // Use LeaveHistoryRsp.newBuilder() to construct.
  private LeaveHistoryRsp(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private LeaveHistoryRsp() {
    errorID_ = 0;
    histories_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private LeaveHistoryRsp(
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
            com.dj.protobuf.character.LeaveHistoryReq.Builder subBuilder = null;
            if (((bitField0_ & 0x00000002) == 0x00000002)) {
              subBuilder = req_.toBuilder();
            }
            req_ = input.readMessage(com.dj.protobuf.character.LeaveHistoryReq.PARSER, extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(req_);
              req_ = subBuilder.buildPartial();
            }
            bitField0_ |= 0x00000002;
            break;
          }
          case 26: {
            if (!((mutable_bitField0_ & 0x00000004) == 0x00000004)) {
              histories_ = new java.util.ArrayList<com.dj.protobuf.character.LeaveHistory>();
              mutable_bitField0_ |= 0x00000004;
            }
            histories_.add(
                input.readMessage(com.dj.protobuf.character.LeaveHistory.PARSER, extensionRegistry));
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
        histories_ = java.util.Collections.unmodifiableList(histories_);
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.dj.protobuf.character.Character.internal_static_Protocols_LeaveHistoryRsp_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.dj.protobuf.character.Character.internal_static_Protocols_LeaveHistoryRsp_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.dj.protobuf.character.LeaveHistoryRsp.class, com.dj.protobuf.character.LeaveHistoryRsp.Builder.class);
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
  private com.dj.protobuf.character.LeaveHistoryReq req_;
  /**
   * <code>optional .Protocols.LeaveHistoryReq req = 2;</code>
   */
  public boolean hasReq() {
    return ((bitField0_ & 0x00000002) == 0x00000002);
  }
  /**
   * <code>optional .Protocols.LeaveHistoryReq req = 2;</code>
   */
  public com.dj.protobuf.character.LeaveHistoryReq getReq() {
    return req_ == null ? com.dj.protobuf.character.LeaveHistoryReq.getDefaultInstance() : req_;
  }
  /**
   * <code>optional .Protocols.LeaveHistoryReq req = 2;</code>
   */
  public com.dj.protobuf.character.LeaveHistoryReqOrBuilder getReqOrBuilder() {
    return req_ == null ? com.dj.protobuf.character.LeaveHistoryReq.getDefaultInstance() : req_;
  }

  public static final int HISTORIES_FIELD_NUMBER = 3;
  private java.util.List<com.dj.protobuf.character.LeaveHistory> histories_;
  /**
   * <pre>
   * ????????????
   * </pre>
   *
   * <code>repeated .Protocols.LeaveHistory histories = 3;</code>
   */
  public java.util.List<com.dj.protobuf.character.LeaveHistory> getHistoriesList() {
    return histories_;
  }
  /**
   * <pre>
   * ????????????
   * </pre>
   *
   * <code>repeated .Protocols.LeaveHistory histories = 3;</code>
   */
  public java.util.List<? extends com.dj.protobuf.character.LeaveHistoryOrBuilder> 
      getHistoriesOrBuilderList() {
    return histories_;
  }
  /**
   * <pre>
   * ????????????
   * </pre>
   *
   * <code>repeated .Protocols.LeaveHistory histories = 3;</code>
   */
  public int getHistoriesCount() {
    return histories_.size();
  }
  /**
   * <pre>
   * ????????????
   * </pre>
   *
   * <code>repeated .Protocols.LeaveHistory histories = 3;</code>
   */
  public com.dj.protobuf.character.LeaveHistory getHistories(int index) {
    return histories_.get(index);
  }
  /**
   * <pre>
   * ????????????
   * </pre>
   *
   * <code>repeated .Protocols.LeaveHistory histories = 3;</code>
   */
  public com.dj.protobuf.character.LeaveHistoryOrBuilder getHistoriesOrBuilder(
      int index) {
    return histories_.get(index);
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
    for (int i = 0; i < histories_.size(); i++) {
      output.writeMessage(3, histories_.get(i));
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
    for (int i = 0; i < histories_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(3, histories_.get(i));
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
    if (!(obj instanceof com.dj.protobuf.character.LeaveHistoryRsp)) {
      return super.equals(obj);
    }
    com.dj.protobuf.character.LeaveHistoryRsp other = (com.dj.protobuf.character.LeaveHistoryRsp) obj;

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
    result = result && getHistoriesList()
        .equals(other.getHistoriesList());
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
    if (getHistoriesCount() > 0) {
      hash = (37 * hash) + HISTORIES_FIELD_NUMBER;
      hash = (53 * hash) + getHistoriesList().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.dj.protobuf.character.LeaveHistoryRsp parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dj.protobuf.character.LeaveHistoryRsp parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dj.protobuf.character.LeaveHistoryRsp parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dj.protobuf.character.LeaveHistoryRsp parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dj.protobuf.character.LeaveHistoryRsp parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.character.LeaveHistoryRsp parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.dj.protobuf.character.LeaveHistoryRsp parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.character.LeaveHistoryRsp parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.dj.protobuf.character.LeaveHistoryRsp parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.character.LeaveHistoryRsp parseFrom(
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
  public static Builder newBuilder(com.dj.protobuf.character.LeaveHistoryRsp prototype) {
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
   * Protobuf type {@code Protocols.LeaveHistoryRsp}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:Protocols.LeaveHistoryRsp)
      com.dj.protobuf.character.LeaveHistoryRspOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.dj.protobuf.character.Character.internal_static_Protocols_LeaveHistoryRsp_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.dj.protobuf.character.Character.internal_static_Protocols_LeaveHistoryRsp_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.dj.protobuf.character.LeaveHistoryRsp.class, com.dj.protobuf.character.LeaveHistoryRsp.Builder.class);
    }

    // Construct using com.dj.protobuf.character.LeaveHistoryRsp.newBuilder()
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
        getHistoriesFieldBuilder();
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
      if (historiesBuilder_ == null) {
        histories_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000004);
      } else {
        historiesBuilder_.clear();
      }
      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.dj.protobuf.character.Character.internal_static_Protocols_LeaveHistoryRsp_descriptor;
    }

    public com.dj.protobuf.character.LeaveHistoryRsp getDefaultInstanceForType() {
      return com.dj.protobuf.character.LeaveHistoryRsp.getDefaultInstance();
    }

    public com.dj.protobuf.character.LeaveHistoryRsp build() {
      com.dj.protobuf.character.LeaveHistoryRsp result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public com.dj.protobuf.character.LeaveHistoryRsp buildPartial() {
      com.dj.protobuf.character.LeaveHistoryRsp result = new com.dj.protobuf.character.LeaveHistoryRsp(this);
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
      if (historiesBuilder_ == null) {
        if (((bitField0_ & 0x00000004) == 0x00000004)) {
          histories_ = java.util.Collections.unmodifiableList(histories_);
          bitField0_ = (bitField0_ & ~0x00000004);
        }
        result.histories_ = histories_;
      } else {
        result.histories_ = historiesBuilder_.build();
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
      if (other instanceof com.dj.protobuf.character.LeaveHistoryRsp) {
        return mergeFrom((com.dj.protobuf.character.LeaveHistoryRsp)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.dj.protobuf.character.LeaveHistoryRsp other) {
      if (other == com.dj.protobuf.character.LeaveHistoryRsp.getDefaultInstance()) return this;
      if (other.hasErrorID()) {
        setErrorID(other.getErrorID());
      }
      if (other.hasReq()) {
        mergeReq(other.getReq());
      }
      if (historiesBuilder_ == null) {
        if (!other.histories_.isEmpty()) {
          if (histories_.isEmpty()) {
            histories_ = other.histories_;
            bitField0_ = (bitField0_ & ~0x00000004);
          } else {
            ensureHistoriesIsMutable();
            histories_.addAll(other.histories_);
          }
          onChanged();
        }
      } else {
        if (!other.histories_.isEmpty()) {
          if (historiesBuilder_.isEmpty()) {
            historiesBuilder_.dispose();
            historiesBuilder_ = null;
            histories_ = other.histories_;
            bitField0_ = (bitField0_ & ~0x00000004);
            historiesBuilder_ = 
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getHistoriesFieldBuilder() : null;
          } else {
            historiesBuilder_.addAllMessages(other.histories_);
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
      com.dj.protobuf.character.LeaveHistoryRsp parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.dj.protobuf.character.LeaveHistoryRsp) e.getUnfinishedMessage();
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

    private com.dj.protobuf.character.LeaveHistoryReq req_ = null;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.dj.protobuf.character.LeaveHistoryReq, com.dj.protobuf.character.LeaveHistoryReq.Builder, com.dj.protobuf.character.LeaveHistoryReqOrBuilder> reqBuilder_;
    /**
     * <code>optional .Protocols.LeaveHistoryReq req = 2;</code>
     */
    public boolean hasReq() {
      return ((bitField0_ & 0x00000002) == 0x00000002);
    }
    /**
     * <code>optional .Protocols.LeaveHistoryReq req = 2;</code>
     */
    public com.dj.protobuf.character.LeaveHistoryReq getReq() {
      if (reqBuilder_ == null) {
        return req_ == null ? com.dj.protobuf.character.LeaveHistoryReq.getDefaultInstance() : req_;
      } else {
        return reqBuilder_.getMessage();
      }
    }
    /**
     * <code>optional .Protocols.LeaveHistoryReq req = 2;</code>
     */
    public Builder setReq(com.dj.protobuf.character.LeaveHistoryReq value) {
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
     * <code>optional .Protocols.LeaveHistoryReq req = 2;</code>
     */
    public Builder setReq(
        com.dj.protobuf.character.LeaveHistoryReq.Builder builderForValue) {
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
     * <code>optional .Protocols.LeaveHistoryReq req = 2;</code>
     */
    public Builder mergeReq(com.dj.protobuf.character.LeaveHistoryReq value) {
      if (reqBuilder_ == null) {
        if (((bitField0_ & 0x00000002) == 0x00000002) &&
            req_ != null &&
            req_ != com.dj.protobuf.character.LeaveHistoryReq.getDefaultInstance()) {
          req_ =
            com.dj.protobuf.character.LeaveHistoryReq.newBuilder(req_).mergeFrom(value).buildPartial();
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
     * <code>optional .Protocols.LeaveHistoryReq req = 2;</code>
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
     * <code>optional .Protocols.LeaveHistoryReq req = 2;</code>
     */
    public com.dj.protobuf.character.LeaveHistoryReq.Builder getReqBuilder() {
      bitField0_ |= 0x00000002;
      onChanged();
      return getReqFieldBuilder().getBuilder();
    }
    /**
     * <code>optional .Protocols.LeaveHistoryReq req = 2;</code>
     */
    public com.dj.protobuf.character.LeaveHistoryReqOrBuilder getReqOrBuilder() {
      if (reqBuilder_ != null) {
        return reqBuilder_.getMessageOrBuilder();
      } else {
        return req_ == null ?
            com.dj.protobuf.character.LeaveHistoryReq.getDefaultInstance() : req_;
      }
    }
    /**
     * <code>optional .Protocols.LeaveHistoryReq req = 2;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.dj.protobuf.character.LeaveHistoryReq, com.dj.protobuf.character.LeaveHistoryReq.Builder, com.dj.protobuf.character.LeaveHistoryReqOrBuilder> 
        getReqFieldBuilder() {
      if (reqBuilder_ == null) {
        reqBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.dj.protobuf.character.LeaveHistoryReq, com.dj.protobuf.character.LeaveHistoryReq.Builder, com.dj.protobuf.character.LeaveHistoryReqOrBuilder>(
                getReq(),
                getParentForChildren(),
                isClean());
        req_ = null;
      }
      return reqBuilder_;
    }

    private java.util.List<com.dj.protobuf.character.LeaveHistory> histories_ =
      java.util.Collections.emptyList();
    private void ensureHistoriesIsMutable() {
      if (!((bitField0_ & 0x00000004) == 0x00000004)) {
        histories_ = new java.util.ArrayList<com.dj.protobuf.character.LeaveHistory>(histories_);
        bitField0_ |= 0x00000004;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        com.dj.protobuf.character.LeaveHistory, com.dj.protobuf.character.LeaveHistory.Builder, com.dj.protobuf.character.LeaveHistoryOrBuilder> historiesBuilder_;

    /**
     * <pre>
     * ????????????
     * </pre>
     *
     * <code>repeated .Protocols.LeaveHistory histories = 3;</code>
     */
    public java.util.List<com.dj.protobuf.character.LeaveHistory> getHistoriesList() {
      if (historiesBuilder_ == null) {
        return java.util.Collections.unmodifiableList(histories_);
      } else {
        return historiesBuilder_.getMessageList();
      }
    }
    /**
     * <pre>
     * ????????????
     * </pre>
     *
     * <code>repeated .Protocols.LeaveHistory histories = 3;</code>
     */
    public int getHistoriesCount() {
      if (historiesBuilder_ == null) {
        return histories_.size();
      } else {
        return historiesBuilder_.getCount();
      }
    }
    /**
     * <pre>
     * ????????????
     * </pre>
     *
     * <code>repeated .Protocols.LeaveHistory histories = 3;</code>
     */
    public com.dj.protobuf.character.LeaveHistory getHistories(int index) {
      if (historiesBuilder_ == null) {
        return histories_.get(index);
      } else {
        return historiesBuilder_.getMessage(index);
      }
    }
    /**
     * <pre>
     * ????????????
     * </pre>
     *
     * <code>repeated .Protocols.LeaveHistory histories = 3;</code>
     */
    public Builder setHistories(
        int index, com.dj.protobuf.character.LeaveHistory value) {
      if (historiesBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureHistoriesIsMutable();
        histories_.set(index, value);
        onChanged();
      } else {
        historiesBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <pre>
     * ????????????
     * </pre>
     *
     * <code>repeated .Protocols.LeaveHistory histories = 3;</code>
     */
    public Builder setHistories(
        int index, com.dj.protobuf.character.LeaveHistory.Builder builderForValue) {
      if (historiesBuilder_ == null) {
        ensureHistoriesIsMutable();
        histories_.set(index, builderForValue.build());
        onChanged();
      } else {
        historiesBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <pre>
     * ????????????
     * </pre>
     *
     * <code>repeated .Protocols.LeaveHistory histories = 3;</code>
     */
    public Builder addHistories(com.dj.protobuf.character.LeaveHistory value) {
      if (historiesBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureHistoriesIsMutable();
        histories_.add(value);
        onChanged();
      } else {
        historiesBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <pre>
     * ????????????
     * </pre>
     *
     * <code>repeated .Protocols.LeaveHistory histories = 3;</code>
     */
    public Builder addHistories(
        int index, com.dj.protobuf.character.LeaveHistory value) {
      if (historiesBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureHistoriesIsMutable();
        histories_.add(index, value);
        onChanged();
      } else {
        historiesBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <pre>
     * ????????????
     * </pre>
     *
     * <code>repeated .Protocols.LeaveHistory histories = 3;</code>
     */
    public Builder addHistories(
        com.dj.protobuf.character.LeaveHistory.Builder builderForValue) {
      if (historiesBuilder_ == null) {
        ensureHistoriesIsMutable();
        histories_.add(builderForValue.build());
        onChanged();
      } else {
        historiesBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <pre>
     * ????????????
     * </pre>
     *
     * <code>repeated .Protocols.LeaveHistory histories = 3;</code>
     */
    public Builder addHistories(
        int index, com.dj.protobuf.character.LeaveHistory.Builder builderForValue) {
      if (historiesBuilder_ == null) {
        ensureHistoriesIsMutable();
        histories_.add(index, builderForValue.build());
        onChanged();
      } else {
        historiesBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <pre>
     * ????????????
     * </pre>
     *
     * <code>repeated .Protocols.LeaveHistory histories = 3;</code>
     */
    public Builder addAllHistories(
        java.lang.Iterable<? extends com.dj.protobuf.character.LeaveHistory> values) {
      if (historiesBuilder_ == null) {
        ensureHistoriesIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, histories_);
        onChanged();
      } else {
        historiesBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <pre>
     * ????????????
     * </pre>
     *
     * <code>repeated .Protocols.LeaveHistory histories = 3;</code>
     */
    public Builder clearHistories() {
      if (historiesBuilder_ == null) {
        histories_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000004);
        onChanged();
      } else {
        historiesBuilder_.clear();
      }
      return this;
    }
    /**
     * <pre>
     * ????????????
     * </pre>
     *
     * <code>repeated .Protocols.LeaveHistory histories = 3;</code>
     */
    public Builder removeHistories(int index) {
      if (historiesBuilder_ == null) {
        ensureHistoriesIsMutable();
        histories_.remove(index);
        onChanged();
      } else {
        historiesBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <pre>
     * ????????????
     * </pre>
     *
     * <code>repeated .Protocols.LeaveHistory histories = 3;</code>
     */
    public com.dj.protobuf.character.LeaveHistory.Builder getHistoriesBuilder(
        int index) {
      return getHistoriesFieldBuilder().getBuilder(index);
    }
    /**
     * <pre>
     * ????????????
     * </pre>
     *
     * <code>repeated .Protocols.LeaveHistory histories = 3;</code>
     */
    public com.dj.protobuf.character.LeaveHistoryOrBuilder getHistoriesOrBuilder(
        int index) {
      if (historiesBuilder_ == null) {
        return histories_.get(index);  } else {
        return historiesBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <pre>
     * ????????????
     * </pre>
     *
     * <code>repeated .Protocols.LeaveHistory histories = 3;</code>
     */
    public java.util.List<? extends com.dj.protobuf.character.LeaveHistoryOrBuilder> 
         getHistoriesOrBuilderList() {
      if (historiesBuilder_ != null) {
        return historiesBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(histories_);
      }
    }
    /**
     * <pre>
     * ????????????
     * </pre>
     *
     * <code>repeated .Protocols.LeaveHistory histories = 3;</code>
     */
    public com.dj.protobuf.character.LeaveHistory.Builder addHistoriesBuilder() {
      return getHistoriesFieldBuilder().addBuilder(
          com.dj.protobuf.character.LeaveHistory.getDefaultInstance());
    }
    /**
     * <pre>
     * ????????????
     * </pre>
     *
     * <code>repeated .Protocols.LeaveHistory histories = 3;</code>
     */
    public com.dj.protobuf.character.LeaveHistory.Builder addHistoriesBuilder(
        int index) {
      return getHistoriesFieldBuilder().addBuilder(
          index, com.dj.protobuf.character.LeaveHistory.getDefaultInstance());
    }
    /**
     * <pre>
     * ????????????
     * </pre>
     *
     * <code>repeated .Protocols.LeaveHistory histories = 3;</code>
     */
    public java.util.List<com.dj.protobuf.character.LeaveHistory.Builder> 
         getHistoriesBuilderList() {
      return getHistoriesFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        com.dj.protobuf.character.LeaveHistory, com.dj.protobuf.character.LeaveHistory.Builder, com.dj.protobuf.character.LeaveHistoryOrBuilder> 
        getHistoriesFieldBuilder() {
      if (historiesBuilder_ == null) {
        historiesBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            com.dj.protobuf.character.LeaveHistory, com.dj.protobuf.character.LeaveHistory.Builder, com.dj.protobuf.character.LeaveHistoryOrBuilder>(
                histories_,
                ((bitField0_ & 0x00000004) == 0x00000004),
                getParentForChildren(),
                isClean());
        histories_ = null;
      }
      return historiesBuilder_;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:Protocols.LeaveHistoryRsp)
  }

  // @@protoc_insertion_point(class_scope:Protocols.LeaveHistoryRsp)
  private static final com.dj.protobuf.character.LeaveHistoryRsp DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.dj.protobuf.character.LeaveHistoryRsp();
  }

  public static com.dj.protobuf.character.LeaveHistoryRsp getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  @java.lang.Deprecated public static final com.google.protobuf.Parser<LeaveHistoryRsp>
      PARSER = new com.google.protobuf.AbstractParser<LeaveHistoryRsp>() {
    public LeaveHistoryRsp parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new LeaveHistoryRsp(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<LeaveHistoryRsp> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<LeaveHistoryRsp> getParserForType() {
    return PARSER;
  }

  public com.dj.protobuf.character.LeaveHistoryRsp getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

