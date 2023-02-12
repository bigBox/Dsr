// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Login.proto

package com.dj.protobuf.login;

/**
 * Protobuf type {@code Protocols.CreateSmsCodeReq}
 */
public  final class CreateSmsCodeReq extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:Protocols.CreateSmsCodeReq)
    CreateSmsCodeReqOrBuilder {
  // Use CreateSmsCodeReq.newBuilder() to construct.
  private CreateSmsCodeReq(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private CreateSmsCodeReq() {
    phoneNum_ = "";
    type_ = 0;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private CreateSmsCodeReq(
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
            phoneNum_ = bs;
            break;
          }
          case 16: {
            bitField0_ |= 0x00000002;
            type_ = input.readUInt32();
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
    return com.dj.protobuf.login.Login.internal_static_Protocols_CreateSmsCodeReq_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.dj.protobuf.login.Login.internal_static_Protocols_CreateSmsCodeReq_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.dj.protobuf.login.CreateSmsCodeReq.class, com.dj.protobuf.login.CreateSmsCodeReq.Builder.class);
  }

  private int bitField0_;
  public static final int PHONENUM_FIELD_NUMBER = 1;
  private volatile java.lang.Object phoneNum_;
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 手机号
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional string phoneNum = 1;</code>
   */
  public boolean hasPhoneNum() {
    return ((bitField0_ & 0x00000001) == 0x00000001);
  }
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 手机号
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional string phoneNum = 1;</code>
   */
  public java.lang.String getPhoneNum() {
    java.lang.Object ref = phoneNum_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      if (bs.isValidUtf8()) {
        phoneNum_ = s;
      }
      return s;
    }
  }
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 手机号
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional string phoneNum = 1;</code>
   */
  public com.google.protobuf.ByteString
      getPhoneNumBytes() {
    java.lang.Object ref = phoneNum_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      phoneNum_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int TYPE_FIELD_NUMBER = 2;
  private int type_;
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 发送类型 0 手机号注册 1 重置密码
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional uint32 type = 2;</code>
   */
  public boolean hasType() {
    return ((bitField0_ & 0x00000002) == 0x00000002);
  }
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 发送类型 0 手机号注册 1 重置密码
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional uint32 type = 2;</code>
   */
  public int getType() {
    return type_;
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
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, phoneNum_);
    }
    if (((bitField0_ & 0x00000002) == 0x00000002)) {
      output.writeUInt32(2, type_);
    }
    unknownFields.writeTo(output);
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (((bitField0_ & 0x00000001) == 0x00000001)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, phoneNum_);
    }
    if (((bitField0_ & 0x00000002) == 0x00000002)) {
      size += com.google.protobuf.CodedOutputStream
        .computeUInt32Size(2, type_);
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
    if (!(obj instanceof com.dj.protobuf.login.CreateSmsCodeReq)) {
      return super.equals(obj);
    }
    com.dj.protobuf.login.CreateSmsCodeReq other = (com.dj.protobuf.login.CreateSmsCodeReq) obj;

    boolean result = true;
    result = result && (hasPhoneNum() == other.hasPhoneNum());
    if (hasPhoneNum()) {
      result = result && getPhoneNum()
          .equals(other.getPhoneNum());
    }
    result = result && (hasType() == other.hasType());
    if (hasType()) {
      result = result && (getType()
          == other.getType());
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
    if (hasPhoneNum()) {
      hash = (37 * hash) + PHONENUM_FIELD_NUMBER;
      hash = (53 * hash) + getPhoneNum().hashCode();
    }
    if (hasType()) {
      hash = (37 * hash) + TYPE_FIELD_NUMBER;
      hash = (53 * hash) + getType();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.dj.protobuf.login.CreateSmsCodeReq parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dj.protobuf.login.CreateSmsCodeReq parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dj.protobuf.login.CreateSmsCodeReq parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dj.protobuf.login.CreateSmsCodeReq parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dj.protobuf.login.CreateSmsCodeReq parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.login.CreateSmsCodeReq parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.dj.protobuf.login.CreateSmsCodeReq parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.login.CreateSmsCodeReq parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.dj.protobuf.login.CreateSmsCodeReq parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.login.CreateSmsCodeReq parseFrom(
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
  public static Builder newBuilder(com.dj.protobuf.login.CreateSmsCodeReq prototype) {
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
   * Protobuf type {@code Protocols.CreateSmsCodeReq}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:Protocols.CreateSmsCodeReq)
      com.dj.protobuf.login.CreateSmsCodeReqOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.dj.protobuf.login.Login.internal_static_Protocols_CreateSmsCodeReq_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.dj.protobuf.login.Login.internal_static_Protocols_CreateSmsCodeReq_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.dj.protobuf.login.CreateSmsCodeReq.class, com.dj.protobuf.login.CreateSmsCodeReq.Builder.class);
    }

    // Construct using com.dj.protobuf.login.CreateSmsCodeReq.newBuilder()
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
      phoneNum_ = "";
      bitField0_ = (bitField0_ & ~0x00000001);
      type_ = 0;
      bitField0_ = (bitField0_ & ~0x00000002);
      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.dj.protobuf.login.Login.internal_static_Protocols_CreateSmsCodeReq_descriptor;
    }

    public com.dj.protobuf.login.CreateSmsCodeReq getDefaultInstanceForType() {
      return com.dj.protobuf.login.CreateSmsCodeReq.getDefaultInstance();
    }

    public com.dj.protobuf.login.CreateSmsCodeReq build() {
      com.dj.protobuf.login.CreateSmsCodeReq result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public com.dj.protobuf.login.CreateSmsCodeReq buildPartial() {
      com.dj.protobuf.login.CreateSmsCodeReq result = new com.dj.protobuf.login.CreateSmsCodeReq(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
        to_bitField0_ |= 0x00000001;
      }
      result.phoneNum_ = phoneNum_;
      if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
        to_bitField0_ |= 0x00000002;
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
      if (other instanceof com.dj.protobuf.login.CreateSmsCodeReq) {
        return mergeFrom((com.dj.protobuf.login.CreateSmsCodeReq)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.dj.protobuf.login.CreateSmsCodeReq other) {
      if (other == com.dj.protobuf.login.CreateSmsCodeReq.getDefaultInstance()) return this;
      if (other.hasPhoneNum()) {
        bitField0_ |= 0x00000001;
        phoneNum_ = other.phoneNum_;
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
      com.dj.protobuf.login.CreateSmsCodeReq parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.dj.protobuf.login.CreateSmsCodeReq) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private java.lang.Object phoneNum_ = "";
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 手机号
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional string phoneNum = 1;</code>
     */
    public boolean hasPhoneNum() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 手机号
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional string phoneNum = 1;</code>
     */
    public java.lang.String getPhoneNum() {
      java.lang.Object ref = phoneNum_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        if (bs.isValidUtf8()) {
          phoneNum_ = s;
        }
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 手机号
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional string phoneNum = 1;</code>
     */
    public com.google.protobuf.ByteString
        getPhoneNumBytes() {
      java.lang.Object ref = phoneNum_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        phoneNum_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 手机号
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional string phoneNum = 1;</code>
     */
    public Builder setPhoneNum(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000001;
      phoneNum_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 手机号
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional string phoneNum = 1;</code>
     */
    public Builder clearPhoneNum() {
      bitField0_ = (bitField0_ & ~0x00000001);
      phoneNum_ = getDefaultInstance().getPhoneNum();
      onChanged();
      return this;
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 手机号
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional string phoneNum = 1;</code>
     */
    public Builder setPhoneNumBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000001;
      phoneNum_ = value;
      onChanged();
      return this;
    }

    private int type_ ;
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 发送类型 0 手机号注册 1 重置密码
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional uint32 type = 2;</code>
     */
    public boolean hasType() {
      return ((bitField0_ & 0x00000002) == 0x00000002);
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 发送类型 0 手机号注册 1 重置密码
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional uint32 type = 2;</code>
     */
    public int getType() {
      return type_;
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 发送类型 0 手机号注册 1 重置密码
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional uint32 type = 2;</code>
     */
    public Builder setType(int value) {
      bitField0_ |= 0x00000002;
      type_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 发送类型 0 手机号注册 1 重置密码
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional uint32 type = 2;</code>
     */
    public Builder clearType() {
      bitField0_ = (bitField0_ & ~0x00000002);
      type_ = 0;
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


    // @@protoc_insertion_point(builder_scope:Protocols.CreateSmsCodeReq)
  }

  // @@protoc_insertion_point(class_scope:Protocols.CreateSmsCodeReq)
  private static final com.dj.protobuf.login.CreateSmsCodeReq DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.dj.protobuf.login.CreateSmsCodeReq();
  }

  public static com.dj.protobuf.login.CreateSmsCodeReq getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  @java.lang.Deprecated public static final com.google.protobuf.Parser<CreateSmsCodeReq>
      PARSER = new com.google.protobuf.AbstractParser<CreateSmsCodeReq>() {
    public CreateSmsCodeReq parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new CreateSmsCodeReq(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<CreateSmsCodeReq> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<CreateSmsCodeReq> getParserForType() {
    return PARSER;
  }

  public com.dj.protobuf.login.CreateSmsCodeReq getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
