// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Guild.proto

package com.dj.protobuf.guild;

/**
 * <pre>
 *&#47; &lt;summary&gt;
 * / 创建公会请求
 * / &lt;/summary&gt;
 * </pre>
 *
 * Protobuf type {@code Protocols.CreateGuildReq}
 */
public  final class CreateGuildReq extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:Protocols.CreateGuildReq)
    CreateGuildReqOrBuilder {
  // Use CreateGuildReq.newBuilder() to construct.
  private CreateGuildReq(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private CreateGuildReq() {
    name_ = "";
    tokenID_ = 0;
    tokenCount_ = 0;
    autoApproval_ = 0;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private CreateGuildReq(
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
            com.google.protobuf.ByteString bs = input.readBytes();
            bitField0_ |= 0x00000001;
            name_ = bs;
            break;
          }
          case 16: {
            bitField0_ |= 0x00000002;
            tokenID_ = input.readInt32();
            break;
          }
          case 24: {
            bitField0_ |= 0x00000004;
            tokenCount_ = input.readInt32();
            break;
          }
          case 32: {
            bitField0_ |= 0x00000008;
            autoApproval_ = input.readInt32();
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
    return com.dj.protobuf.guild.Guild.internal_static_Protocols_CreateGuildReq_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.dj.protobuf.guild.Guild.internal_static_Protocols_CreateGuildReq_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.dj.protobuf.guild.CreateGuildReq.class, com.dj.protobuf.guild.CreateGuildReq.Builder.class);
  }

  private int bitField0_;
  public static final int NAME_FIELD_NUMBER = 1;
  private volatile java.lang.Object name_;
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 公会名字
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional string name = 1;</code>
   */
  public boolean hasName() {
    return ((bitField0_ & 0x00000001) == 0x00000001);
  }
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 公会名字
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional string name = 1;</code>
   */
  public java.lang.String getName() {
    java.lang.Object ref = name_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      if (bs.isValidUtf8()) {
        name_ = s;
      }
      return s;
    }
  }
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 公会名字
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional string name = 1;</code>
   */
  public com.google.protobuf.ByteString
      getNameBytes() {
    java.lang.Object ref = name_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      name_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int TOKENID_FIELD_NUMBER = 2;
  private int tokenID_;
  /**
   * <pre>
   * 令牌id
   * </pre>
   *
   * <code>optional int32 tokenID = 2;</code>
   */
  public boolean hasTokenID() {
    return ((bitField0_ & 0x00000002) == 0x00000002);
  }
  /**
   * <pre>
   * 令牌id
   * </pre>
   *
   * <code>optional int32 tokenID = 2;</code>
   */
  public int getTokenID() {
    return tokenID_;
  }

  public static final int TOKENCOUNT_FIELD_NUMBER = 3;
  private int tokenCount_;
  /**
   * <pre>
   * 令牌数量
   * </pre>
   *
   * <code>optional int32 tokenCount = 3;</code>
   */
  public boolean hasTokenCount() {
    return ((bitField0_ & 0x00000004) == 0x00000004);
  }
  /**
   * <pre>
   * 令牌数量
   * </pre>
   *
   * <code>optional int32 tokenCount = 3;</code>
   */
  public int getTokenCount() {
    return tokenCount_;
  }

  public static final int AUTOAPPROVAL_FIELD_NUMBER = 4;
  private int autoApproval_;
  /**
   * <pre>
   * 是否自动批准 0-否 1-是
   * </pre>
   *
   * <code>optional int32 autoApproval = 4;</code>
   */
  public boolean hasAutoApproval() {
    return ((bitField0_ & 0x00000008) == 0x00000008);
  }
  /**
   * <pre>
   * 是否自动批准 0-否 1-是
   * </pre>
   *
   * <code>optional int32 autoApproval = 4;</code>
   */
  public int getAutoApproval() {
    return autoApproval_;
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
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, name_);
    }
    if (((bitField0_ & 0x00000002) == 0x00000002)) {
      output.writeInt32(2, tokenID_);
    }
    if (((bitField0_ & 0x00000004) == 0x00000004)) {
      output.writeInt32(3, tokenCount_);
    }
    if (((bitField0_ & 0x00000008) == 0x00000008)) {
      output.writeInt32(4, autoApproval_);
    }
    unknownFields.writeTo(output);
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (((bitField0_ & 0x00000001) == 0x00000001)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, name_);
    }
    if (((bitField0_ & 0x00000002) == 0x00000002)) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(2, tokenID_);
    }
    if (((bitField0_ & 0x00000004) == 0x00000004)) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(3, tokenCount_);
    }
    if (((bitField0_ & 0x00000008) == 0x00000008)) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(4, autoApproval_);
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
    if (!(obj instanceof com.dj.protobuf.guild.CreateGuildReq)) {
      return super.equals(obj);
    }
    com.dj.protobuf.guild.CreateGuildReq other = (com.dj.protobuf.guild.CreateGuildReq) obj;

    boolean result = true;
    result = result && (hasName() == other.hasName());
    if (hasName()) {
      result = result && getName()
          .equals(other.getName());
    }
    result = result && (hasTokenID() == other.hasTokenID());
    if (hasTokenID()) {
      result = result && (getTokenID()
          == other.getTokenID());
    }
    result = result && (hasTokenCount() == other.hasTokenCount());
    if (hasTokenCount()) {
      result = result && (getTokenCount()
          == other.getTokenCount());
    }
    result = result && (hasAutoApproval() == other.hasAutoApproval());
    if (hasAutoApproval()) {
      result = result && (getAutoApproval()
          == other.getAutoApproval());
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
    if (hasName()) {
      hash = (37 * hash) + NAME_FIELD_NUMBER;
      hash = (53 * hash) + getName().hashCode();
    }
    if (hasTokenID()) {
      hash = (37 * hash) + TOKENID_FIELD_NUMBER;
      hash = (53 * hash) + getTokenID();
    }
    if (hasTokenCount()) {
      hash = (37 * hash) + TOKENCOUNT_FIELD_NUMBER;
      hash = (53 * hash) + getTokenCount();
    }
    if (hasAutoApproval()) {
      hash = (37 * hash) + AUTOAPPROVAL_FIELD_NUMBER;
      hash = (53 * hash) + getAutoApproval();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.dj.protobuf.guild.CreateGuildReq parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dj.protobuf.guild.CreateGuildReq parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dj.protobuf.guild.CreateGuildReq parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dj.protobuf.guild.CreateGuildReq parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dj.protobuf.guild.CreateGuildReq parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.guild.CreateGuildReq parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.dj.protobuf.guild.CreateGuildReq parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.guild.CreateGuildReq parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.dj.protobuf.guild.CreateGuildReq parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.guild.CreateGuildReq parseFrom(
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
  public static Builder newBuilder(com.dj.protobuf.guild.CreateGuildReq prototype) {
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
   * / 创建公会请求
   * / &lt;/summary&gt;
   * </pre>
   *
   * Protobuf type {@code Protocols.CreateGuildReq}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:Protocols.CreateGuildReq)
      com.dj.protobuf.guild.CreateGuildReqOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.dj.protobuf.guild.Guild.internal_static_Protocols_CreateGuildReq_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.dj.protobuf.guild.Guild.internal_static_Protocols_CreateGuildReq_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.dj.protobuf.guild.CreateGuildReq.class, com.dj.protobuf.guild.CreateGuildReq.Builder.class);
    }

    // Construct using com.dj.protobuf.guild.CreateGuildReq.newBuilder()
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
      name_ = "";
      bitField0_ = (bitField0_ & ~0x00000001);
      tokenID_ = 0;
      bitField0_ = (bitField0_ & ~0x00000002);
      tokenCount_ = 0;
      bitField0_ = (bitField0_ & ~0x00000004);
      autoApproval_ = 0;
      bitField0_ = (bitField0_ & ~0x00000008);
      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.dj.protobuf.guild.Guild.internal_static_Protocols_CreateGuildReq_descriptor;
    }

    public com.dj.protobuf.guild.CreateGuildReq getDefaultInstanceForType() {
      return com.dj.protobuf.guild.CreateGuildReq.getDefaultInstance();
    }

    public com.dj.protobuf.guild.CreateGuildReq build() {
      com.dj.protobuf.guild.CreateGuildReq result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public com.dj.protobuf.guild.CreateGuildReq buildPartial() {
      com.dj.protobuf.guild.CreateGuildReq result = new com.dj.protobuf.guild.CreateGuildReq(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
        to_bitField0_ |= 0x00000001;
      }
      result.name_ = name_;
      if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
        to_bitField0_ |= 0x00000002;
      }
      result.tokenID_ = tokenID_;
      if (((from_bitField0_ & 0x00000004) == 0x00000004)) {
        to_bitField0_ |= 0x00000004;
      }
      result.tokenCount_ = tokenCount_;
      if (((from_bitField0_ & 0x00000008) == 0x00000008)) {
        to_bitField0_ |= 0x00000008;
      }
      result.autoApproval_ = autoApproval_;
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
      if (other instanceof com.dj.protobuf.guild.CreateGuildReq) {
        return mergeFrom((com.dj.protobuf.guild.CreateGuildReq)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.dj.protobuf.guild.CreateGuildReq other) {
      if (other == com.dj.protobuf.guild.CreateGuildReq.getDefaultInstance()) return this;
      if (other.hasName()) {
        bitField0_ |= 0x00000001;
        name_ = other.name_;
        onChanged();
      }
      if (other.hasTokenID()) {
        setTokenID(other.getTokenID());
      }
      if (other.hasTokenCount()) {
        setTokenCount(other.getTokenCount());
      }
      if (other.hasAutoApproval()) {
        setAutoApproval(other.getAutoApproval());
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
      com.dj.protobuf.guild.CreateGuildReq parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.dj.protobuf.guild.CreateGuildReq) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private java.lang.Object name_ = "";
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 公会名字
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional string name = 1;</code>
     */
    public boolean hasName() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 公会名字
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional string name = 1;</code>
     */
    public java.lang.String getName() {
      java.lang.Object ref = name_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        if (bs.isValidUtf8()) {
          name_ = s;
        }
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 公会名字
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional string name = 1;</code>
     */
    public com.google.protobuf.ByteString
        getNameBytes() {
      java.lang.Object ref = name_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        name_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 公会名字
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional string name = 1;</code>
     */
    public Builder setName(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000001;
      name_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 公会名字
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional string name = 1;</code>
     */
    public Builder clearName() {
      bitField0_ = (bitField0_ & ~0x00000001);
      name_ = getDefaultInstance().getName();
      onChanged();
      return this;
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 公会名字
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional string name = 1;</code>
     */
    public Builder setNameBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000001;
      name_ = value;
      onChanged();
      return this;
    }

    private int tokenID_ ;
    /**
     * <pre>
     * 令牌id
     * </pre>
     *
     * <code>optional int32 tokenID = 2;</code>
     */
    public boolean hasTokenID() {
      return ((bitField0_ & 0x00000002) == 0x00000002);
    }
    /**
     * <pre>
     * 令牌id
     * </pre>
     *
     * <code>optional int32 tokenID = 2;</code>
     */
    public int getTokenID() {
      return tokenID_;
    }
    /**
     * <pre>
     * 令牌id
     * </pre>
     *
     * <code>optional int32 tokenID = 2;</code>
     */
    public Builder setTokenID(int value) {
      bitField0_ |= 0x00000002;
      tokenID_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * 令牌id
     * </pre>
     *
     * <code>optional int32 tokenID = 2;</code>
     */
    public Builder clearTokenID() {
      bitField0_ = (bitField0_ & ~0x00000002);
      tokenID_ = 0;
      onChanged();
      return this;
    }

    private int tokenCount_ ;
    /**
     * <pre>
     * 令牌数量
     * </pre>
     *
     * <code>optional int32 tokenCount = 3;</code>
     */
    public boolean hasTokenCount() {
      return ((bitField0_ & 0x00000004) == 0x00000004);
    }
    /**
     * <pre>
     * 令牌数量
     * </pre>
     *
     * <code>optional int32 tokenCount = 3;</code>
     */
    public int getTokenCount() {
      return tokenCount_;
    }
    /**
     * <pre>
     * 令牌数量
     * </pre>
     *
     * <code>optional int32 tokenCount = 3;</code>
     */
    public Builder setTokenCount(int value) {
      bitField0_ |= 0x00000004;
      tokenCount_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * 令牌数量
     * </pre>
     *
     * <code>optional int32 tokenCount = 3;</code>
     */
    public Builder clearTokenCount() {
      bitField0_ = (bitField0_ & ~0x00000004);
      tokenCount_ = 0;
      onChanged();
      return this;
    }

    private int autoApproval_ ;
    /**
     * <pre>
     * 是否自动批准 0-否 1-是
     * </pre>
     *
     * <code>optional int32 autoApproval = 4;</code>
     */
    public boolean hasAutoApproval() {
      return ((bitField0_ & 0x00000008) == 0x00000008);
    }
    /**
     * <pre>
     * 是否自动批准 0-否 1-是
     * </pre>
     *
     * <code>optional int32 autoApproval = 4;</code>
     */
    public int getAutoApproval() {
      return autoApproval_;
    }
    /**
     * <pre>
     * 是否自动批准 0-否 1-是
     * </pre>
     *
     * <code>optional int32 autoApproval = 4;</code>
     */
    public Builder setAutoApproval(int value) {
      bitField0_ |= 0x00000008;
      autoApproval_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * 是否自动批准 0-否 1-是
     * </pre>
     *
     * <code>optional int32 autoApproval = 4;</code>
     */
    public Builder clearAutoApproval() {
      bitField0_ = (bitField0_ & ~0x00000008);
      autoApproval_ = 0;
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


    // @@protoc_insertion_point(builder_scope:Protocols.CreateGuildReq)
  }

  // @@protoc_insertion_point(class_scope:Protocols.CreateGuildReq)
  private static final com.dj.protobuf.guild.CreateGuildReq DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.dj.protobuf.guild.CreateGuildReq();
  }

  public static com.dj.protobuf.guild.CreateGuildReq getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  @java.lang.Deprecated public static final com.google.protobuf.Parser<CreateGuildReq>
      PARSER = new com.google.protobuf.AbstractParser<CreateGuildReq>() {
    public CreateGuildReq parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new CreateGuildReq(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<CreateGuildReq> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<CreateGuildReq> getParserForType() {
    return PARSER;
  }

  public com.dj.protobuf.guild.CreateGuildReq getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
