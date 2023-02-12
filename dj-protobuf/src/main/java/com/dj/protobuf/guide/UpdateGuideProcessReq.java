// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Guide.proto

package com.dj.protobuf.guide;

/**
 * Protobuf type {@code Protocols.UpdateGuideProcessReq}
 */
public  final class UpdateGuideProcessReq extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:Protocols.UpdateGuideProcessReq)
    UpdateGuideProcessReqOrBuilder {
  // Use UpdateGuideProcessReq.newBuilder() to construct.
  private UpdateGuideProcessReq(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private UpdateGuideProcessReq() {
    guideId_ = 0;
    state_ = 0;
    arg_ = 0;
    exData_ = "";
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private UpdateGuideProcessReq(
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
            bitField0_ |= 0x00000001;
            guideId_ = input.readInt32();
            break;
          }
          case 16: {
            bitField0_ |= 0x00000002;
            state_ = input.readInt32();
            break;
          }
          case 24: {
            bitField0_ |= 0x00000004;
            arg_ = input.readInt32();
            break;
          }
          case 34: {
            com.google.protobuf.ByteString bs = input.readBytes();
            bitField0_ |= 0x00000008;
            exData_ = bs;
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
    return com.dj.protobuf.guide.Guide.internal_static_Protocols_UpdateGuideProcessReq_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.dj.protobuf.guide.Guide.internal_static_Protocols_UpdateGuideProcessReq_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.dj.protobuf.guide.UpdateGuideProcessReq.class, com.dj.protobuf.guide.UpdateGuideProcessReq.Builder.class);
  }

  private int bitField0_;
  public static final int GUIDEID_FIELD_NUMBER = 1;
  private int guideId_;
  /**
   * <code>optional int32 guideId = 1;</code>
   */
  public boolean hasGuideId() {
    return ((bitField0_ & 0x00000001) == 0x00000001);
  }
  /**
   * <code>optional int32 guideId = 1;</code>
   */
  public int getGuideId() {
    return guideId_;
  }

  public static final int STATE_FIELD_NUMBER = 2;
  private int state_;
  /**
   * <code>optional int32 state = 2;</code>
   */
  public boolean hasState() {
    return ((bitField0_ & 0x00000002) == 0x00000002);
  }
  /**
   * <code>optional int32 state = 2;</code>
   */
  public int getState() {
    return state_;
  }

  public static final int ARG_FIELD_NUMBER = 3;
  private int arg_;
  /**
   * <code>optional int32 arg = 3;</code>
   */
  public boolean hasArg() {
    return ((bitField0_ & 0x00000004) == 0x00000004);
  }
  /**
   * <code>optional int32 arg = 3;</code>
   */
  public int getArg() {
    return arg_;
  }

  public static final int EXDATA_FIELD_NUMBER = 4;
  private volatile java.lang.Object exData_;
  /**
   * <code>optional string exData = 4;</code>
   */
  public boolean hasExData() {
    return ((bitField0_ & 0x00000008) == 0x00000008);
  }
  /**
   * <code>optional string exData = 4;</code>
   */
  public java.lang.String getExData() {
    java.lang.Object ref = exData_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      if (bs.isValidUtf8()) {
        exData_ = s;
      }
      return s;
    }
  }
  /**
   * <code>optional string exData = 4;</code>
   */
  public com.google.protobuf.ByteString
      getExDataBytes() {
    java.lang.Object ref = exData_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      exData_ = b;
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
      output.writeInt32(1, guideId_);
    }
    if (((bitField0_ & 0x00000002) == 0x00000002)) {
      output.writeInt32(2, state_);
    }
    if (((bitField0_ & 0x00000004) == 0x00000004)) {
      output.writeInt32(3, arg_);
    }
    if (((bitField0_ & 0x00000008) == 0x00000008)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 4, exData_);
    }
    unknownFields.writeTo(output);
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (((bitField0_ & 0x00000001) == 0x00000001)) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(1, guideId_);
    }
    if (((bitField0_ & 0x00000002) == 0x00000002)) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(2, state_);
    }
    if (((bitField0_ & 0x00000004) == 0x00000004)) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(3, arg_);
    }
    if (((bitField0_ & 0x00000008) == 0x00000008)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(4, exData_);
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
    if (!(obj instanceof com.dj.protobuf.guide.UpdateGuideProcessReq)) {
      return super.equals(obj);
    }
    com.dj.protobuf.guide.UpdateGuideProcessReq other = (com.dj.protobuf.guide.UpdateGuideProcessReq) obj;

    boolean result = true;
    result = result && (hasGuideId() == other.hasGuideId());
    if (hasGuideId()) {
      result = result && (getGuideId()
          == other.getGuideId());
    }
    result = result && (hasState() == other.hasState());
    if (hasState()) {
      result = result && (getState()
          == other.getState());
    }
    result = result && (hasArg() == other.hasArg());
    if (hasArg()) {
      result = result && (getArg()
          == other.getArg());
    }
    result = result && (hasExData() == other.hasExData());
    if (hasExData()) {
      result = result && getExData()
          .equals(other.getExData());
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
    if (hasGuideId()) {
      hash = (37 * hash) + GUIDEID_FIELD_NUMBER;
      hash = (53 * hash) + getGuideId();
    }
    if (hasState()) {
      hash = (37 * hash) + STATE_FIELD_NUMBER;
      hash = (53 * hash) + getState();
    }
    if (hasArg()) {
      hash = (37 * hash) + ARG_FIELD_NUMBER;
      hash = (53 * hash) + getArg();
    }
    if (hasExData()) {
      hash = (37 * hash) + EXDATA_FIELD_NUMBER;
      hash = (53 * hash) + getExData().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.dj.protobuf.guide.UpdateGuideProcessReq parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dj.protobuf.guide.UpdateGuideProcessReq parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dj.protobuf.guide.UpdateGuideProcessReq parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dj.protobuf.guide.UpdateGuideProcessReq parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dj.protobuf.guide.UpdateGuideProcessReq parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.guide.UpdateGuideProcessReq parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.dj.protobuf.guide.UpdateGuideProcessReq parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.guide.UpdateGuideProcessReq parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.dj.protobuf.guide.UpdateGuideProcessReq parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.guide.UpdateGuideProcessReq parseFrom(
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
  public static Builder newBuilder(com.dj.protobuf.guide.UpdateGuideProcessReq prototype) {
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
   * Protobuf type {@code Protocols.UpdateGuideProcessReq}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:Protocols.UpdateGuideProcessReq)
      com.dj.protobuf.guide.UpdateGuideProcessReqOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.dj.protobuf.guide.Guide.internal_static_Protocols_UpdateGuideProcessReq_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.dj.protobuf.guide.Guide.internal_static_Protocols_UpdateGuideProcessReq_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.dj.protobuf.guide.UpdateGuideProcessReq.class, com.dj.protobuf.guide.UpdateGuideProcessReq.Builder.class);
    }

    // Construct using com.dj.protobuf.guide.UpdateGuideProcessReq.newBuilder()
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
      }
    }
    public Builder clear() {
      super.clear();
      guideId_ = 0;
      bitField0_ = (bitField0_ & ~0x00000001);
      state_ = 0;
      bitField0_ = (bitField0_ & ~0x00000002);
      arg_ = 0;
      bitField0_ = (bitField0_ & ~0x00000004);
      exData_ = "";
      bitField0_ = (bitField0_ & ~0x00000008);
      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.dj.protobuf.guide.Guide.internal_static_Protocols_UpdateGuideProcessReq_descriptor;
    }

    public com.dj.protobuf.guide.UpdateGuideProcessReq getDefaultInstanceForType() {
      return com.dj.protobuf.guide.UpdateGuideProcessReq.getDefaultInstance();
    }

    public com.dj.protobuf.guide.UpdateGuideProcessReq build() {
      com.dj.protobuf.guide.UpdateGuideProcessReq result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public com.dj.protobuf.guide.UpdateGuideProcessReq buildPartial() {
      com.dj.protobuf.guide.UpdateGuideProcessReq result = new com.dj.protobuf.guide.UpdateGuideProcessReq(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
        to_bitField0_ |= 0x00000001;
      }
      result.guideId_ = guideId_;
      if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
        to_bitField0_ |= 0x00000002;
      }
      result.state_ = state_;
      if (((from_bitField0_ & 0x00000004) == 0x00000004)) {
        to_bitField0_ |= 0x00000004;
      }
      result.arg_ = arg_;
      if (((from_bitField0_ & 0x00000008) == 0x00000008)) {
        to_bitField0_ |= 0x00000008;
      }
      result.exData_ = exData_;
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
      if (other instanceof com.dj.protobuf.guide.UpdateGuideProcessReq) {
        return mergeFrom((com.dj.protobuf.guide.UpdateGuideProcessReq)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.dj.protobuf.guide.UpdateGuideProcessReq other) {
      if (other == com.dj.protobuf.guide.UpdateGuideProcessReq.getDefaultInstance()) return this;
      if (other.hasGuideId()) {
        setGuideId(other.getGuideId());
      }
      if (other.hasState()) {
        setState(other.getState());
      }
      if (other.hasArg()) {
        setArg(other.getArg());
      }
      if (other.hasExData()) {
        bitField0_ |= 0x00000008;
        exData_ = other.exData_;
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
      com.dj.protobuf.guide.UpdateGuideProcessReq parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.dj.protobuf.guide.UpdateGuideProcessReq) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private int guideId_ ;
    /**
     * <code>optional int32 guideId = 1;</code>
     */
    public boolean hasGuideId() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <code>optional int32 guideId = 1;</code>
     */
    public int getGuideId() {
      return guideId_;
    }
    /**
     * <code>optional int32 guideId = 1;</code>
     */
    public Builder setGuideId(int value) {
      bitField0_ |= 0x00000001;
      guideId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional int32 guideId = 1;</code>
     */
    public Builder clearGuideId() {
      bitField0_ = (bitField0_ & ~0x00000001);
      guideId_ = 0;
      onChanged();
      return this;
    }

    private int state_ ;
    /**
     * <code>optional int32 state = 2;</code>
     */
    public boolean hasState() {
      return ((bitField0_ & 0x00000002) == 0x00000002);
    }
    /**
     * <code>optional int32 state = 2;</code>
     */
    public int getState() {
      return state_;
    }
    /**
     * <code>optional int32 state = 2;</code>
     */
    public Builder setState(int value) {
      bitField0_ |= 0x00000002;
      state_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional int32 state = 2;</code>
     */
    public Builder clearState() {
      bitField0_ = (bitField0_ & ~0x00000002);
      state_ = 0;
      onChanged();
      return this;
    }

    private int arg_ ;
    /**
     * <code>optional int32 arg = 3;</code>
     */
    public boolean hasArg() {
      return ((bitField0_ & 0x00000004) == 0x00000004);
    }
    /**
     * <code>optional int32 arg = 3;</code>
     */
    public int getArg() {
      return arg_;
    }
    /**
     * <code>optional int32 arg = 3;</code>
     */
    public Builder setArg(int value) {
      bitField0_ |= 0x00000004;
      arg_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional int32 arg = 3;</code>
     */
    public Builder clearArg() {
      bitField0_ = (bitField0_ & ~0x00000004);
      arg_ = 0;
      onChanged();
      return this;
    }

    private java.lang.Object exData_ = "";
    /**
     * <code>optional string exData = 4;</code>
     */
    public boolean hasExData() {
      return ((bitField0_ & 0x00000008) == 0x00000008);
    }
    /**
     * <code>optional string exData = 4;</code>
     */
    public java.lang.String getExData() {
      java.lang.Object ref = exData_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        if (bs.isValidUtf8()) {
          exData_ = s;
        }
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>optional string exData = 4;</code>
     */
    public com.google.protobuf.ByteString
        getExDataBytes() {
      java.lang.Object ref = exData_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        exData_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>optional string exData = 4;</code>
     */
    public Builder setExData(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000008;
      exData_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional string exData = 4;</code>
     */
    public Builder clearExData() {
      bitField0_ = (bitField0_ & ~0x00000008);
      exData_ = getDefaultInstance().getExData();
      onChanged();
      return this;
    }
    /**
     * <code>optional string exData = 4;</code>
     */
    public Builder setExDataBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000008;
      exData_ = value;
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


    // @@protoc_insertion_point(builder_scope:Protocols.UpdateGuideProcessReq)
  }

  // @@protoc_insertion_point(class_scope:Protocols.UpdateGuideProcessReq)
  private static final com.dj.protobuf.guide.UpdateGuideProcessReq DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.dj.protobuf.guide.UpdateGuideProcessReq();
  }

  public static com.dj.protobuf.guide.UpdateGuideProcessReq getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  @java.lang.Deprecated public static final com.google.protobuf.Parser<UpdateGuideProcessReq>
      PARSER = new com.google.protobuf.AbstractParser<UpdateGuideProcessReq>() {
    public UpdateGuideProcessReq parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new UpdateGuideProcessReq(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<UpdateGuideProcessReq> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<UpdateGuideProcessReq> getParserForType() {
    return PARSER;
  }

  public com.dj.protobuf.guide.UpdateGuideProcessReq getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
