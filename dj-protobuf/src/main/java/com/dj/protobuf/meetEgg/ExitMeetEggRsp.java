// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: MeetEgg.proto

package com.dj.protobuf.meetEgg;

/**
 * Protobuf type {@code Protocols.ExitMeetEggRsp}
 */
public  final class ExitMeetEggRsp extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:Protocols.ExitMeetEggRsp)
    ExitMeetEggRspOrBuilder {
  // Use ExitMeetEggRsp.newBuilder() to construct.
  private ExitMeetEggRsp(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private ExitMeetEggRsp() {
    errorID_ = 0;
    totalScore_ = 0;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private ExitMeetEggRsp(
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
            bitField0_ |= 0x00000002;
            totalScore_ = input.readInt32();
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
    return com.dj.protobuf.meetEgg.MeetEgg.internal_static_Protocols_ExitMeetEggRsp_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.dj.protobuf.meetEgg.MeetEgg.internal_static_Protocols_ExitMeetEggRsp_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.dj.protobuf.meetEgg.ExitMeetEggRsp.class, com.dj.protobuf.meetEgg.ExitMeetEggRsp.Builder.class);
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

  public static final int TOTALSCORE_FIELD_NUMBER = 2;
  private int totalScore_;
  /**
   * <pre>
   *?????????
   * </pre>
   *
   * <code>optional int32 totalScore = 2;</code>
   */
  public boolean hasTotalScore() {
    return ((bitField0_ & 0x00000002) == 0x00000002);
  }
  /**
   * <pre>
   *?????????
   * </pre>
   *
   * <code>optional int32 totalScore = 2;</code>
   */
  public int getTotalScore() {
    return totalScore_;
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
      output.writeInt32(2, totalScore_);
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
        .computeInt32Size(2, totalScore_);
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
    if (!(obj instanceof com.dj.protobuf.meetEgg.ExitMeetEggRsp)) {
      return super.equals(obj);
    }
    com.dj.protobuf.meetEgg.ExitMeetEggRsp other = (com.dj.protobuf.meetEgg.ExitMeetEggRsp) obj;

    boolean result = true;
    result = result && (hasErrorID() == other.hasErrorID());
    if (hasErrorID()) {
      result = result && errorID_ == other.errorID_;
    }
    result = result && (hasTotalScore() == other.hasTotalScore());
    if (hasTotalScore()) {
      result = result && (getTotalScore()
          == other.getTotalScore());
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
    if (hasTotalScore()) {
      hash = (37 * hash) + TOTALSCORE_FIELD_NUMBER;
      hash = (53 * hash) + getTotalScore();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.dj.protobuf.meetEgg.ExitMeetEggRsp parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dj.protobuf.meetEgg.ExitMeetEggRsp parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dj.protobuf.meetEgg.ExitMeetEggRsp parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dj.protobuf.meetEgg.ExitMeetEggRsp parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dj.protobuf.meetEgg.ExitMeetEggRsp parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.meetEgg.ExitMeetEggRsp parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.dj.protobuf.meetEgg.ExitMeetEggRsp parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.meetEgg.ExitMeetEggRsp parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.dj.protobuf.meetEgg.ExitMeetEggRsp parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.meetEgg.ExitMeetEggRsp parseFrom(
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
  public static Builder newBuilder(com.dj.protobuf.meetEgg.ExitMeetEggRsp prototype) {
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
   * Protobuf type {@code Protocols.ExitMeetEggRsp}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:Protocols.ExitMeetEggRsp)
      com.dj.protobuf.meetEgg.ExitMeetEggRspOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.dj.protobuf.meetEgg.MeetEgg.internal_static_Protocols_ExitMeetEggRsp_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.dj.protobuf.meetEgg.MeetEgg.internal_static_Protocols_ExitMeetEggRsp_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.dj.protobuf.meetEgg.ExitMeetEggRsp.class, com.dj.protobuf.meetEgg.ExitMeetEggRsp.Builder.class);
    }

    // Construct using com.dj.protobuf.meetEgg.ExitMeetEggRsp.newBuilder()
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
      errorID_ = 0;
      bitField0_ = (bitField0_ & ~0x00000001);
      totalScore_ = 0;
      bitField0_ = (bitField0_ & ~0x00000002);
      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.dj.protobuf.meetEgg.MeetEgg.internal_static_Protocols_ExitMeetEggRsp_descriptor;
    }

    public com.dj.protobuf.meetEgg.ExitMeetEggRsp getDefaultInstanceForType() {
      return com.dj.protobuf.meetEgg.ExitMeetEggRsp.getDefaultInstance();
    }

    public com.dj.protobuf.meetEgg.ExitMeetEggRsp build() {
      com.dj.protobuf.meetEgg.ExitMeetEggRsp result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public com.dj.protobuf.meetEgg.ExitMeetEggRsp buildPartial() {
      com.dj.protobuf.meetEgg.ExitMeetEggRsp result = new com.dj.protobuf.meetEgg.ExitMeetEggRsp(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
        to_bitField0_ |= 0x00000001;
      }
      result.errorID_ = errorID_;
      if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
        to_bitField0_ |= 0x00000002;
      }
      result.totalScore_ = totalScore_;
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
      if (other instanceof com.dj.protobuf.meetEgg.ExitMeetEggRsp) {
        return mergeFrom((com.dj.protobuf.meetEgg.ExitMeetEggRsp)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.dj.protobuf.meetEgg.ExitMeetEggRsp other) {
      if (other == com.dj.protobuf.meetEgg.ExitMeetEggRsp.getDefaultInstance()) return this;
      if (other.hasErrorID()) {
        setErrorID(other.getErrorID());
      }
      if (other.hasTotalScore()) {
        setTotalScore(other.getTotalScore());
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
      com.dj.protobuf.meetEgg.ExitMeetEggRsp parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.dj.protobuf.meetEgg.ExitMeetEggRsp) e.getUnfinishedMessage();
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

    private int totalScore_ ;
    /**
     * <pre>
     *?????????
     * </pre>
     *
     * <code>optional int32 totalScore = 2;</code>
     */
    public boolean hasTotalScore() {
      return ((bitField0_ & 0x00000002) == 0x00000002);
    }
    /**
     * <pre>
     *?????????
     * </pre>
     *
     * <code>optional int32 totalScore = 2;</code>
     */
    public int getTotalScore() {
      return totalScore_;
    }
    /**
     * <pre>
     *?????????
     * </pre>
     *
     * <code>optional int32 totalScore = 2;</code>
     */
    public Builder setTotalScore(int value) {
      bitField0_ |= 0x00000002;
      totalScore_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     *?????????
     * </pre>
     *
     * <code>optional int32 totalScore = 2;</code>
     */
    public Builder clearTotalScore() {
      bitField0_ = (bitField0_ & ~0x00000002);
      totalScore_ = 0;
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


    // @@protoc_insertion_point(builder_scope:Protocols.ExitMeetEggRsp)
  }

  // @@protoc_insertion_point(class_scope:Protocols.ExitMeetEggRsp)
  private static final com.dj.protobuf.meetEgg.ExitMeetEggRsp DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.dj.protobuf.meetEgg.ExitMeetEggRsp();
  }

  public static com.dj.protobuf.meetEgg.ExitMeetEggRsp getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  @java.lang.Deprecated public static final com.google.protobuf.Parser<ExitMeetEggRsp>
      PARSER = new com.google.protobuf.AbstractParser<ExitMeetEggRsp>() {
    public ExitMeetEggRsp parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new ExitMeetEggRsp(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<ExitMeetEggRsp> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<ExitMeetEggRsp> getParserForType() {
    return PARSER;
  }

  public com.dj.protobuf.meetEgg.ExitMeetEggRsp getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

