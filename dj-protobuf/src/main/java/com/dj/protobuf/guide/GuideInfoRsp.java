// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Guide.proto

package com.dj.protobuf.guide;

/**
 * Protobuf type {@code Protocols.GuideInfoRsp}
 */
public  final class GuideInfoRsp extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:Protocols.GuideInfoRsp)
    GuideInfoRspOrBuilder {
  // Use GuideInfoRsp.newBuilder() to construct.
  private GuideInfoRsp(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private GuideInfoRsp() {
    errorID_ = 0;
    guideInfos_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private GuideInfoRsp(
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
            if (!((mutable_bitField0_ & 0x00000002) == 0x00000002)) {
              guideInfos_ = new java.util.ArrayList<com.dj.protobuf.guide.GuideInfo>();
              mutable_bitField0_ |= 0x00000002;
            }
            guideInfos_.add(
                input.readMessage(com.dj.protobuf.guide.GuideInfo.PARSER, extensionRegistry));
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
        guideInfos_ = java.util.Collections.unmodifiableList(guideInfos_);
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.dj.protobuf.guide.Guide.internal_static_Protocols_GuideInfoRsp_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.dj.protobuf.guide.Guide.internal_static_Protocols_GuideInfoRsp_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.dj.protobuf.guide.GuideInfoRsp.class, com.dj.protobuf.guide.GuideInfoRsp.Builder.class);
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

  public static final int GUIDEINFOS_FIELD_NUMBER = 2;
  private java.util.List<com.dj.protobuf.guide.GuideInfo> guideInfos_;
  /**
   * <code>repeated .Protocols.GuideInfo guideInfos = 2;</code>
   */
  public java.util.List<com.dj.protobuf.guide.GuideInfo> getGuideInfosList() {
    return guideInfos_;
  }
  /**
   * <code>repeated .Protocols.GuideInfo guideInfos = 2;</code>
   */
  public java.util.List<? extends com.dj.protobuf.guide.GuideInfoOrBuilder> 
      getGuideInfosOrBuilderList() {
    return guideInfos_;
  }
  /**
   * <code>repeated .Protocols.GuideInfo guideInfos = 2;</code>
   */
  public int getGuideInfosCount() {
    return guideInfos_.size();
  }
  /**
   * <code>repeated .Protocols.GuideInfo guideInfos = 2;</code>
   */
  public com.dj.protobuf.guide.GuideInfo getGuideInfos(int index) {
    return guideInfos_.get(index);
  }
  /**
   * <code>repeated .Protocols.GuideInfo guideInfos = 2;</code>
   */
  public com.dj.protobuf.guide.GuideInfoOrBuilder getGuideInfosOrBuilder(
      int index) {
    return guideInfos_.get(index);
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
    for (int i = 0; i < guideInfos_.size(); i++) {
      output.writeMessage(2, guideInfos_.get(i));
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
    for (int i = 0; i < guideInfos_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(2, guideInfos_.get(i));
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
    if (!(obj instanceof com.dj.protobuf.guide.GuideInfoRsp)) {
      return super.equals(obj);
    }
    com.dj.protobuf.guide.GuideInfoRsp other = (com.dj.protobuf.guide.GuideInfoRsp) obj;

    boolean result = true;
    result = result && (hasErrorID() == other.hasErrorID());
    if (hasErrorID()) {
      result = result && errorID_ == other.errorID_;
    }
    result = result && getGuideInfosList()
        .equals(other.getGuideInfosList());
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
    if (getGuideInfosCount() > 0) {
      hash = (37 * hash) + GUIDEINFOS_FIELD_NUMBER;
      hash = (53 * hash) + getGuideInfosList().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.dj.protobuf.guide.GuideInfoRsp parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dj.protobuf.guide.GuideInfoRsp parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dj.protobuf.guide.GuideInfoRsp parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dj.protobuf.guide.GuideInfoRsp parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dj.protobuf.guide.GuideInfoRsp parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.guide.GuideInfoRsp parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.dj.protobuf.guide.GuideInfoRsp parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.guide.GuideInfoRsp parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.dj.protobuf.guide.GuideInfoRsp parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.guide.GuideInfoRsp parseFrom(
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
  public static Builder newBuilder(com.dj.protobuf.guide.GuideInfoRsp prototype) {
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
   * Protobuf type {@code Protocols.GuideInfoRsp}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:Protocols.GuideInfoRsp)
      com.dj.protobuf.guide.GuideInfoRspOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.dj.protobuf.guide.Guide.internal_static_Protocols_GuideInfoRsp_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.dj.protobuf.guide.Guide.internal_static_Protocols_GuideInfoRsp_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.dj.protobuf.guide.GuideInfoRsp.class, com.dj.protobuf.guide.GuideInfoRsp.Builder.class);
    }

    // Construct using com.dj.protobuf.guide.GuideInfoRsp.newBuilder()
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
        getGuideInfosFieldBuilder();
      }
    }
    public Builder clear() {
      super.clear();
      errorID_ = 0;
      bitField0_ = (bitField0_ & ~0x00000001);
      if (guideInfosBuilder_ == null) {
        guideInfos_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000002);
      } else {
        guideInfosBuilder_.clear();
      }
      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.dj.protobuf.guide.Guide.internal_static_Protocols_GuideInfoRsp_descriptor;
    }

    public com.dj.protobuf.guide.GuideInfoRsp getDefaultInstanceForType() {
      return com.dj.protobuf.guide.GuideInfoRsp.getDefaultInstance();
    }

    public com.dj.protobuf.guide.GuideInfoRsp build() {
      com.dj.protobuf.guide.GuideInfoRsp result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public com.dj.protobuf.guide.GuideInfoRsp buildPartial() {
      com.dj.protobuf.guide.GuideInfoRsp result = new com.dj.protobuf.guide.GuideInfoRsp(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
        to_bitField0_ |= 0x00000001;
      }
      result.errorID_ = errorID_;
      if (guideInfosBuilder_ == null) {
        if (((bitField0_ & 0x00000002) == 0x00000002)) {
          guideInfos_ = java.util.Collections.unmodifiableList(guideInfos_);
          bitField0_ = (bitField0_ & ~0x00000002);
        }
        result.guideInfos_ = guideInfos_;
      } else {
        result.guideInfos_ = guideInfosBuilder_.build();
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
      if (other instanceof com.dj.protobuf.guide.GuideInfoRsp) {
        return mergeFrom((com.dj.protobuf.guide.GuideInfoRsp)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.dj.protobuf.guide.GuideInfoRsp other) {
      if (other == com.dj.protobuf.guide.GuideInfoRsp.getDefaultInstance()) return this;
      if (other.hasErrorID()) {
        setErrorID(other.getErrorID());
      }
      if (guideInfosBuilder_ == null) {
        if (!other.guideInfos_.isEmpty()) {
          if (guideInfos_.isEmpty()) {
            guideInfos_ = other.guideInfos_;
            bitField0_ = (bitField0_ & ~0x00000002);
          } else {
            ensureGuideInfosIsMutable();
            guideInfos_.addAll(other.guideInfos_);
          }
          onChanged();
        }
      } else {
        if (!other.guideInfos_.isEmpty()) {
          if (guideInfosBuilder_.isEmpty()) {
            guideInfosBuilder_.dispose();
            guideInfosBuilder_ = null;
            guideInfos_ = other.guideInfos_;
            bitField0_ = (bitField0_ & ~0x00000002);
            guideInfosBuilder_ = 
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getGuideInfosFieldBuilder() : null;
          } else {
            guideInfosBuilder_.addAllMessages(other.guideInfos_);
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
      com.dj.protobuf.guide.GuideInfoRsp parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.dj.protobuf.guide.GuideInfoRsp) e.getUnfinishedMessage();
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

    private java.util.List<com.dj.protobuf.guide.GuideInfo> guideInfos_ =
      java.util.Collections.emptyList();
    private void ensureGuideInfosIsMutable() {
      if (!((bitField0_ & 0x00000002) == 0x00000002)) {
        guideInfos_ = new java.util.ArrayList<com.dj.protobuf.guide.GuideInfo>(guideInfos_);
        bitField0_ |= 0x00000002;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        com.dj.protobuf.guide.GuideInfo, com.dj.protobuf.guide.GuideInfo.Builder, com.dj.protobuf.guide.GuideInfoOrBuilder> guideInfosBuilder_;

    /**
     * <code>repeated .Protocols.GuideInfo guideInfos = 2;</code>
     */
    public java.util.List<com.dj.protobuf.guide.GuideInfo> getGuideInfosList() {
      if (guideInfosBuilder_ == null) {
        return java.util.Collections.unmodifiableList(guideInfos_);
      } else {
        return guideInfosBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .Protocols.GuideInfo guideInfos = 2;</code>
     */
    public int getGuideInfosCount() {
      if (guideInfosBuilder_ == null) {
        return guideInfos_.size();
      } else {
        return guideInfosBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .Protocols.GuideInfo guideInfos = 2;</code>
     */
    public com.dj.protobuf.guide.GuideInfo getGuideInfos(int index) {
      if (guideInfosBuilder_ == null) {
        return guideInfos_.get(index);
      } else {
        return guideInfosBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .Protocols.GuideInfo guideInfos = 2;</code>
     */
    public Builder setGuideInfos(
        int index, com.dj.protobuf.guide.GuideInfo value) {
      if (guideInfosBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureGuideInfosIsMutable();
        guideInfos_.set(index, value);
        onChanged();
      } else {
        guideInfosBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .Protocols.GuideInfo guideInfos = 2;</code>
     */
    public Builder setGuideInfos(
        int index, com.dj.protobuf.guide.GuideInfo.Builder builderForValue) {
      if (guideInfosBuilder_ == null) {
        ensureGuideInfosIsMutable();
        guideInfos_.set(index, builderForValue.build());
        onChanged();
      } else {
        guideInfosBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .Protocols.GuideInfo guideInfos = 2;</code>
     */
    public Builder addGuideInfos(com.dj.protobuf.guide.GuideInfo value) {
      if (guideInfosBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureGuideInfosIsMutable();
        guideInfos_.add(value);
        onChanged();
      } else {
        guideInfosBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .Protocols.GuideInfo guideInfos = 2;</code>
     */
    public Builder addGuideInfos(
        int index, com.dj.protobuf.guide.GuideInfo value) {
      if (guideInfosBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureGuideInfosIsMutable();
        guideInfos_.add(index, value);
        onChanged();
      } else {
        guideInfosBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .Protocols.GuideInfo guideInfos = 2;</code>
     */
    public Builder addGuideInfos(
        com.dj.protobuf.guide.GuideInfo.Builder builderForValue) {
      if (guideInfosBuilder_ == null) {
        ensureGuideInfosIsMutable();
        guideInfos_.add(builderForValue.build());
        onChanged();
      } else {
        guideInfosBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .Protocols.GuideInfo guideInfos = 2;</code>
     */
    public Builder addGuideInfos(
        int index, com.dj.protobuf.guide.GuideInfo.Builder builderForValue) {
      if (guideInfosBuilder_ == null) {
        ensureGuideInfosIsMutable();
        guideInfos_.add(index, builderForValue.build());
        onChanged();
      } else {
        guideInfosBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .Protocols.GuideInfo guideInfos = 2;</code>
     */
    public Builder addAllGuideInfos(
        java.lang.Iterable<? extends com.dj.protobuf.guide.GuideInfo> values) {
      if (guideInfosBuilder_ == null) {
        ensureGuideInfosIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, guideInfos_);
        onChanged();
      } else {
        guideInfosBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .Protocols.GuideInfo guideInfos = 2;</code>
     */
    public Builder clearGuideInfos() {
      if (guideInfosBuilder_ == null) {
        guideInfos_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000002);
        onChanged();
      } else {
        guideInfosBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .Protocols.GuideInfo guideInfos = 2;</code>
     */
    public Builder removeGuideInfos(int index) {
      if (guideInfosBuilder_ == null) {
        ensureGuideInfosIsMutable();
        guideInfos_.remove(index);
        onChanged();
      } else {
        guideInfosBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .Protocols.GuideInfo guideInfos = 2;</code>
     */
    public com.dj.protobuf.guide.GuideInfo.Builder getGuideInfosBuilder(
        int index) {
      return getGuideInfosFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .Protocols.GuideInfo guideInfos = 2;</code>
     */
    public com.dj.protobuf.guide.GuideInfoOrBuilder getGuideInfosOrBuilder(
        int index) {
      if (guideInfosBuilder_ == null) {
        return guideInfos_.get(index);  } else {
        return guideInfosBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .Protocols.GuideInfo guideInfos = 2;</code>
     */
    public java.util.List<? extends com.dj.protobuf.guide.GuideInfoOrBuilder> 
         getGuideInfosOrBuilderList() {
      if (guideInfosBuilder_ != null) {
        return guideInfosBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(guideInfos_);
      }
    }
    /**
     * <code>repeated .Protocols.GuideInfo guideInfos = 2;</code>
     */
    public com.dj.protobuf.guide.GuideInfo.Builder addGuideInfosBuilder() {
      return getGuideInfosFieldBuilder().addBuilder(
          com.dj.protobuf.guide.GuideInfo.getDefaultInstance());
    }
    /**
     * <code>repeated .Protocols.GuideInfo guideInfos = 2;</code>
     */
    public com.dj.protobuf.guide.GuideInfo.Builder addGuideInfosBuilder(
        int index) {
      return getGuideInfosFieldBuilder().addBuilder(
          index, com.dj.protobuf.guide.GuideInfo.getDefaultInstance());
    }
    /**
     * <code>repeated .Protocols.GuideInfo guideInfos = 2;</code>
     */
    public java.util.List<com.dj.protobuf.guide.GuideInfo.Builder> 
         getGuideInfosBuilderList() {
      return getGuideInfosFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        com.dj.protobuf.guide.GuideInfo, com.dj.protobuf.guide.GuideInfo.Builder, com.dj.protobuf.guide.GuideInfoOrBuilder> 
        getGuideInfosFieldBuilder() {
      if (guideInfosBuilder_ == null) {
        guideInfosBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            com.dj.protobuf.guide.GuideInfo, com.dj.protobuf.guide.GuideInfo.Builder, com.dj.protobuf.guide.GuideInfoOrBuilder>(
                guideInfos_,
                ((bitField0_ & 0x00000002) == 0x00000002),
                getParentForChildren(),
                isClean());
        guideInfos_ = null;
      }
      return guideInfosBuilder_;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:Protocols.GuideInfoRsp)
  }

  // @@protoc_insertion_point(class_scope:Protocols.GuideInfoRsp)
  private static final com.dj.protobuf.guide.GuideInfoRsp DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.dj.protobuf.guide.GuideInfoRsp();
  }

  public static com.dj.protobuf.guide.GuideInfoRsp getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  @java.lang.Deprecated public static final com.google.protobuf.Parser<GuideInfoRsp>
      PARSER = new com.google.protobuf.AbstractParser<GuideInfoRsp>() {
    public GuideInfoRsp parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new GuideInfoRsp(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<GuideInfoRsp> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<GuideInfoRsp> getParserForType() {
    return PARSER;
  }

  public com.dj.protobuf.guide.GuideInfoRsp getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

