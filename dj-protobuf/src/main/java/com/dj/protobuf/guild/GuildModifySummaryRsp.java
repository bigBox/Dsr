// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Guild.proto

package com.dj.protobuf.guild;

/**
 * <pre>
 *&#47; &lt;summary&gt;
 * / 修改公会说明响应
 * / &lt;/summary&gt;
 * </pre>
 *
 * Protobuf type {@code Protocols.GuildModifySummaryRsp}
 */
public  final class GuildModifySummaryRsp extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:Protocols.GuildModifySummaryRsp)
    GuildModifySummaryRspOrBuilder {
  // Use GuildModifySummaryRsp.newBuilder() to construct.
  private GuildModifySummaryRsp(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private GuildModifySummaryRsp() {
    errorID_ = 0;
    summary_ = "";
    type_ = 1;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private GuildModifySummaryRsp(
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
            com.google.protobuf.ByteString bs = input.readBytes();
            bitField0_ |= 0x00000002;
            summary_ = bs;
            break;
          }
          case 24: {
            int rawValue = input.readEnum();
            com.dj.protobuf.guild.SummaryType value = com.dj.protobuf.guild.SummaryType.valueOf(rawValue);
            if (value == null) {
              unknownFields.mergeVarintField(3, rawValue);
            } else {
              bitField0_ |= 0x00000004;
              type_ = rawValue;
            }
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
    return com.dj.protobuf.guild.Guild.internal_static_Protocols_GuildModifySummaryRsp_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.dj.protobuf.guild.Guild.internal_static_Protocols_GuildModifySummaryRsp_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.dj.protobuf.guild.GuildModifySummaryRsp.class, com.dj.protobuf.guild.GuildModifySummaryRsp.Builder.class);
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

  public static final int SUMMARY_FIELD_NUMBER = 2;
  private volatile java.lang.Object summary_;
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 替换掉屏蔽字后的说明
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional string summary = 2;</code>
   */
  public boolean hasSummary() {
    return ((bitField0_ & 0x00000002) == 0x00000002);
  }
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 替换掉屏蔽字后的说明
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional string summary = 2;</code>
   */
  public java.lang.String getSummary() {
    java.lang.Object ref = summary_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      if (bs.isValidUtf8()) {
        summary_ = s;
      }
      return s;
    }
  }
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 替换掉屏蔽字后的说明
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional string summary = 2;</code>
   */
  public com.google.protobuf.ByteString
      getSummaryBytes() {
    java.lang.Object ref = summary_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      summary_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int TYPE_FIELD_NUMBER = 3;
  private int type_;
  /**
   * <code>optional .Protocols.SummaryType type = 3;</code>
   */
  public boolean hasType() {
    return ((bitField0_ & 0x00000004) == 0x00000004);
  }
  /**
   * <code>optional .Protocols.SummaryType type = 3;</code>
   */
  public com.dj.protobuf.guild.SummaryType getType() {
    com.dj.protobuf.guild.SummaryType result = com.dj.protobuf.guild.SummaryType.valueOf(type_);
    return result == null ? com.dj.protobuf.guild.SummaryType.External : result;
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
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, summary_);
    }
    if (((bitField0_ & 0x00000004) == 0x00000004)) {
      output.writeEnum(3, type_);
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
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, summary_);
    }
    if (((bitField0_ & 0x00000004) == 0x00000004)) {
      size += com.google.protobuf.CodedOutputStream
        .computeEnumSize(3, type_);
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
    if (!(obj instanceof com.dj.protobuf.guild.GuildModifySummaryRsp)) {
      return super.equals(obj);
    }
    com.dj.protobuf.guild.GuildModifySummaryRsp other = (com.dj.protobuf.guild.GuildModifySummaryRsp) obj;

    boolean result = true;
    result = result && (hasErrorID() == other.hasErrorID());
    if (hasErrorID()) {
      result = result && errorID_ == other.errorID_;
    }
    result = result && (hasSummary() == other.hasSummary());
    if (hasSummary()) {
      result = result && getSummary()
          .equals(other.getSummary());
    }
    result = result && (hasType() == other.hasType());
    if (hasType()) {
      result = result && type_ == other.type_;
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
    if (hasSummary()) {
      hash = (37 * hash) + SUMMARY_FIELD_NUMBER;
      hash = (53 * hash) + getSummary().hashCode();
    }
    if (hasType()) {
      hash = (37 * hash) + TYPE_FIELD_NUMBER;
      hash = (53 * hash) + type_;
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.dj.protobuf.guild.GuildModifySummaryRsp parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dj.protobuf.guild.GuildModifySummaryRsp parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dj.protobuf.guild.GuildModifySummaryRsp parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dj.protobuf.guild.GuildModifySummaryRsp parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dj.protobuf.guild.GuildModifySummaryRsp parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.guild.GuildModifySummaryRsp parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.dj.protobuf.guild.GuildModifySummaryRsp parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.guild.GuildModifySummaryRsp parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.dj.protobuf.guild.GuildModifySummaryRsp parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.guild.GuildModifySummaryRsp parseFrom(
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
  public static Builder newBuilder(com.dj.protobuf.guild.GuildModifySummaryRsp prototype) {
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
   *&#47; &lt;summary&gt;
   * / 修改公会说明响应
   * / &lt;/summary&gt;
   * </pre>
   *
   * Protobuf type {@code Protocols.GuildModifySummaryRsp}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:Protocols.GuildModifySummaryRsp)
      com.dj.protobuf.guild.GuildModifySummaryRspOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.dj.protobuf.guild.Guild.internal_static_Protocols_GuildModifySummaryRsp_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.dj.protobuf.guild.Guild.internal_static_Protocols_GuildModifySummaryRsp_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.dj.protobuf.guild.GuildModifySummaryRsp.class, com.dj.protobuf.guild.GuildModifySummaryRsp.Builder.class);
    }

    // Construct using com.dj.protobuf.guild.GuildModifySummaryRsp.newBuilder()
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
      summary_ = "";
      bitField0_ = (bitField0_ & ~0x00000002);
      type_ = 1;
      bitField0_ = (bitField0_ & ~0x00000004);
      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.dj.protobuf.guild.Guild.internal_static_Protocols_GuildModifySummaryRsp_descriptor;
    }

    public com.dj.protobuf.guild.GuildModifySummaryRsp getDefaultInstanceForType() {
      return com.dj.protobuf.guild.GuildModifySummaryRsp.getDefaultInstance();
    }

    public com.dj.protobuf.guild.GuildModifySummaryRsp build() {
      com.dj.protobuf.guild.GuildModifySummaryRsp result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public com.dj.protobuf.guild.GuildModifySummaryRsp buildPartial() {
      com.dj.protobuf.guild.GuildModifySummaryRsp result = new com.dj.protobuf.guild.GuildModifySummaryRsp(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
        to_bitField0_ |= 0x00000001;
      }
      result.errorID_ = errorID_;
      if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
        to_bitField0_ |= 0x00000002;
      }
      result.summary_ = summary_;
      if (((from_bitField0_ & 0x00000004) == 0x00000004)) {
        to_bitField0_ |= 0x00000004;
      }
      result.type_ = type_;
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
      if (other instanceof com.dj.protobuf.guild.GuildModifySummaryRsp) {
        return mergeFrom((com.dj.protobuf.guild.GuildModifySummaryRsp)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.dj.protobuf.guild.GuildModifySummaryRsp other) {
      if (other == com.dj.protobuf.guild.GuildModifySummaryRsp.getDefaultInstance()) return this;
      if (other.hasErrorID()) {
        setErrorID(other.getErrorID());
      }
      if (other.hasSummary()) {
        bitField0_ |= 0x00000002;
        summary_ = other.summary_;
        onChanged();
      }
      if (other.hasType()) {
        setType(other.getType());
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
      com.dj.protobuf.guild.GuildModifySummaryRsp parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.dj.protobuf.guild.GuildModifySummaryRsp) e.getUnfinishedMessage();
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

    private java.lang.Object summary_ = "";
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 替换掉屏蔽字后的说明
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional string summary = 2;</code>
     */
    public boolean hasSummary() {
      return ((bitField0_ & 0x00000002) == 0x00000002);
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 替换掉屏蔽字后的说明
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional string summary = 2;</code>
     */
    public java.lang.String getSummary() {
      java.lang.Object ref = summary_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        if (bs.isValidUtf8()) {
          summary_ = s;
        }
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 替换掉屏蔽字后的说明
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional string summary = 2;</code>
     */
    public com.google.protobuf.ByteString
        getSummaryBytes() {
      java.lang.Object ref = summary_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        summary_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 替换掉屏蔽字后的说明
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional string summary = 2;</code>
     */
    public Builder setSummary(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000002;
      summary_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 替换掉屏蔽字后的说明
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional string summary = 2;</code>
     */
    public Builder clearSummary() {
      bitField0_ = (bitField0_ & ~0x00000002);
      summary_ = getDefaultInstance().getSummary();
      onChanged();
      return this;
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 替换掉屏蔽字后的说明
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional string summary = 2;</code>
     */
    public Builder setSummaryBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000002;
      summary_ = value;
      onChanged();
      return this;
    }

    private int type_ = 1;
    /**
     * <code>optional .Protocols.SummaryType type = 3;</code>
     */
    public boolean hasType() {
      return ((bitField0_ & 0x00000004) == 0x00000004);
    }
    /**
     * <code>optional .Protocols.SummaryType type = 3;</code>
     */
    public com.dj.protobuf.guild.SummaryType getType() {
      com.dj.protobuf.guild.SummaryType result = com.dj.protobuf.guild.SummaryType.valueOf(type_);
      return result == null ? com.dj.protobuf.guild.SummaryType.External : result;
    }
    /**
     * <code>optional .Protocols.SummaryType type = 3;</code>
     */
    public Builder setType(com.dj.protobuf.guild.SummaryType value) {
      if (value == null) {
        throw new NullPointerException();
      }
      bitField0_ |= 0x00000004;
      type_ = value.getNumber();
      onChanged();
      return this;
    }
    /**
     * <code>optional .Protocols.SummaryType type = 3;</code>
     */
    public Builder clearType() {
      bitField0_ = (bitField0_ & ~0x00000004);
      type_ = 1;
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


    // @@protoc_insertion_point(builder_scope:Protocols.GuildModifySummaryRsp)
  }

  // @@protoc_insertion_point(class_scope:Protocols.GuildModifySummaryRsp)
  private static final com.dj.protobuf.guild.GuildModifySummaryRsp DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.dj.protobuf.guild.GuildModifySummaryRsp();
  }

  public static com.dj.protobuf.guild.GuildModifySummaryRsp getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  @java.lang.Deprecated public static final com.google.protobuf.Parser<GuildModifySummaryRsp>
      PARSER = new com.google.protobuf.AbstractParser<GuildModifySummaryRsp>() {
    public GuildModifySummaryRsp parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new GuildModifySummaryRsp(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<GuildModifySummaryRsp> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<GuildModifySummaryRsp> getParserForType() {
    return PARSER;
  }

  public com.dj.protobuf.guild.GuildModifySummaryRsp getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

