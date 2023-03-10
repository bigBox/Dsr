// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Login.proto

package com.dj.protobuf.login;

/**
 * Protobuf type {@code Protocols.CreateAccountReq}
 */
public  final class CreateAccountReq extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:Protocols.CreateAccountReq)
    CreateAccountReqOrBuilder {
  // Use CreateAccountReq.newBuilder() to construct.
  private CreateAccountReq(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private CreateAccountReq() {
    account_ = "";
    password_ = "";
    nickname_ = "";
    addr_ = "";
    smsCode_ = "";
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private CreateAccountReq(
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
            account_ = bs;
            break;
          }
          case 18: {
            com.google.protobuf.ByteString bs = input.readBytes();
            bitField0_ |= 0x00000002;
            password_ = bs;
            break;
          }
          case 26: {
            com.google.protobuf.ByteString bs = input.readBytes();
            bitField0_ |= 0x00000004;
            nickname_ = bs;
            break;
          }
          case 34: {
            com.google.protobuf.ByteString bs = input.readBytes();
            bitField0_ |= 0x00000008;
            addr_ = bs;
            break;
          }
          case 42: {
            com.google.protobuf.ByteString bs = input.readBytes();
            bitField0_ |= 0x00000010;
            smsCode_ = bs;
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
    return com.dj.protobuf.login.Login.internal_static_Protocols_CreateAccountReq_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.dj.protobuf.login.Login.internal_static_Protocols_CreateAccountReq_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.dj.protobuf.login.CreateAccountReq.class, com.dj.protobuf.login.CreateAccountReq.Builder.class);
  }

  private int bitField0_;
  public static final int ACCOUNT_FIELD_NUMBER = 1;
  private volatile java.lang.Object account_;
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / ??????????????????/?????????
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional string account = 1;</code>
   */
  public boolean hasAccount() {
    return ((bitField0_ & 0x00000001) == 0x00000001);
  }
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / ??????????????????/?????????
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional string account = 1;</code>
   */
  public java.lang.String getAccount() {
    java.lang.Object ref = account_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      if (bs.isValidUtf8()) {
        account_ = s;
      }
      return s;
    }
  }
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / ??????????????????/?????????
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional string account = 1;</code>
   */
  public com.google.protobuf.ByteString
      getAccountBytes() {
    java.lang.Object ref = account_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      account_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int PASSWORD_FIELD_NUMBER = 2;
  private volatile java.lang.Object password_;
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / ??????????????????
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional string password = 2;</code>
   */
  public boolean hasPassword() {
    return ((bitField0_ & 0x00000002) == 0x00000002);
  }
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / ??????????????????
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional string password = 2;</code>
   */
  public java.lang.String getPassword() {
    java.lang.Object ref = password_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      if (bs.isValidUtf8()) {
        password_ = s;
      }
      return s;
    }
  }
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / ??????????????????
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional string password = 2;</code>
   */
  public com.google.protobuf.ByteString
      getPasswordBytes() {
    java.lang.Object ref = password_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      password_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int NICKNAME_FIELD_NUMBER = 3;
  private volatile java.lang.Object nickname_;
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / ??????
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional string nickname = 3;</code>
   */
  public boolean hasNickname() {
    return ((bitField0_ & 0x00000004) == 0x00000004);
  }
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / ??????
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional string nickname = 3;</code>
   */
  public java.lang.String getNickname() {
    java.lang.Object ref = nickname_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      if (bs.isValidUtf8()) {
        nickname_ = s;
      }
      return s;
    }
  }
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / ??????
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional string nickname = 3;</code>
   */
  public com.google.protobuf.ByteString
      getNicknameBytes() {
    java.lang.Object ref = nickname_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      nickname_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int ADDR_FIELD_NUMBER = 4;
  private volatile java.lang.Object addr_;
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / ??????IP????????????????????????
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional string addr = 4;</code>
   */
  public boolean hasAddr() {
    return ((bitField0_ & 0x00000008) == 0x00000008);
  }
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / ??????IP????????????????????????
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional string addr = 4;</code>
   */
  public java.lang.String getAddr() {
    java.lang.Object ref = addr_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      if (bs.isValidUtf8()) {
        addr_ = s;
      }
      return s;
    }
  }
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / ??????IP????????????????????????
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional string addr = 4;</code>
   */
  public com.google.protobuf.ByteString
      getAddrBytes() {
    java.lang.Object ref = addr_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      addr_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int SMSCODE_FIELD_NUMBER = 5;
  private volatile java.lang.Object smsCode_;
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / ???????????????
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional string smsCode = 5;</code>
   */
  public boolean hasSmsCode() {
    return ((bitField0_ & 0x00000010) == 0x00000010);
  }
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / ???????????????
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional string smsCode = 5;</code>
   */
  public java.lang.String getSmsCode() {
    java.lang.Object ref = smsCode_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      if (bs.isValidUtf8()) {
        smsCode_ = s;
      }
      return s;
    }
  }
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / ???????????????
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional string smsCode = 5;</code>
   */
  public com.google.protobuf.ByteString
      getSmsCodeBytes() {
    java.lang.Object ref = smsCode_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      smsCode_ = b;
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
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, account_);
    }
    if (((bitField0_ & 0x00000002) == 0x00000002)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, password_);
    }
    if (((bitField0_ & 0x00000004) == 0x00000004)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 3, nickname_);
    }
    if (((bitField0_ & 0x00000008) == 0x00000008)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 4, addr_);
    }
    if (((bitField0_ & 0x00000010) == 0x00000010)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 5, smsCode_);
    }
    unknownFields.writeTo(output);
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (((bitField0_ & 0x00000001) == 0x00000001)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, account_);
    }
    if (((bitField0_ & 0x00000002) == 0x00000002)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, password_);
    }
    if (((bitField0_ & 0x00000004) == 0x00000004)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, nickname_);
    }
    if (((bitField0_ & 0x00000008) == 0x00000008)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(4, addr_);
    }
    if (((bitField0_ & 0x00000010) == 0x00000010)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(5, smsCode_);
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
    if (!(obj instanceof com.dj.protobuf.login.CreateAccountReq)) {
      return super.equals(obj);
    }
    com.dj.protobuf.login.CreateAccountReq other = (com.dj.protobuf.login.CreateAccountReq) obj;

    boolean result = true;
    result = result && (hasAccount() == other.hasAccount());
    if (hasAccount()) {
      result = result && getAccount()
          .equals(other.getAccount());
    }
    result = result && (hasPassword() == other.hasPassword());
    if (hasPassword()) {
      result = result && getPassword()
          .equals(other.getPassword());
    }
    result = result && (hasNickname() == other.hasNickname());
    if (hasNickname()) {
      result = result && getNickname()
          .equals(other.getNickname());
    }
    result = result && (hasAddr() == other.hasAddr());
    if (hasAddr()) {
      result = result && getAddr()
          .equals(other.getAddr());
    }
    result = result && (hasSmsCode() == other.hasSmsCode());
    if (hasSmsCode()) {
      result = result && getSmsCode()
          .equals(other.getSmsCode());
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
    if (hasAccount()) {
      hash = (37 * hash) + ACCOUNT_FIELD_NUMBER;
      hash = (53 * hash) + getAccount().hashCode();
    }
    if (hasPassword()) {
      hash = (37 * hash) + PASSWORD_FIELD_NUMBER;
      hash = (53 * hash) + getPassword().hashCode();
    }
    if (hasNickname()) {
      hash = (37 * hash) + NICKNAME_FIELD_NUMBER;
      hash = (53 * hash) + getNickname().hashCode();
    }
    if (hasAddr()) {
      hash = (37 * hash) + ADDR_FIELD_NUMBER;
      hash = (53 * hash) + getAddr().hashCode();
    }
    if (hasSmsCode()) {
      hash = (37 * hash) + SMSCODE_FIELD_NUMBER;
      hash = (53 * hash) + getSmsCode().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.dj.protobuf.login.CreateAccountReq parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dj.protobuf.login.CreateAccountReq parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dj.protobuf.login.CreateAccountReq parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dj.protobuf.login.CreateAccountReq parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dj.protobuf.login.CreateAccountReq parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.login.CreateAccountReq parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.dj.protobuf.login.CreateAccountReq parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.login.CreateAccountReq parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.dj.protobuf.login.CreateAccountReq parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.login.CreateAccountReq parseFrom(
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
  public static Builder newBuilder(com.dj.protobuf.login.CreateAccountReq prototype) {
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
   * Protobuf type {@code Protocols.CreateAccountReq}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:Protocols.CreateAccountReq)
      com.dj.protobuf.login.CreateAccountReqOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.dj.protobuf.login.Login.internal_static_Protocols_CreateAccountReq_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.dj.protobuf.login.Login.internal_static_Protocols_CreateAccountReq_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.dj.protobuf.login.CreateAccountReq.class, com.dj.protobuf.login.CreateAccountReq.Builder.class);
    }

    // Construct using com.dj.protobuf.login.CreateAccountReq.newBuilder()
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
      account_ = "";
      bitField0_ = (bitField0_ & ~0x00000001);
      password_ = "";
      bitField0_ = (bitField0_ & ~0x00000002);
      nickname_ = "";
      bitField0_ = (bitField0_ & ~0x00000004);
      addr_ = "";
      bitField0_ = (bitField0_ & ~0x00000008);
      smsCode_ = "";
      bitField0_ = (bitField0_ & ~0x00000010);
      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.dj.protobuf.login.Login.internal_static_Protocols_CreateAccountReq_descriptor;
    }

    public com.dj.protobuf.login.CreateAccountReq getDefaultInstanceForType() {
      return com.dj.protobuf.login.CreateAccountReq.getDefaultInstance();
    }

    public com.dj.protobuf.login.CreateAccountReq build() {
      com.dj.protobuf.login.CreateAccountReq result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public com.dj.protobuf.login.CreateAccountReq buildPartial() {
      com.dj.protobuf.login.CreateAccountReq result = new com.dj.protobuf.login.CreateAccountReq(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
        to_bitField0_ |= 0x00000001;
      }
      result.account_ = account_;
      if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
        to_bitField0_ |= 0x00000002;
      }
      result.password_ = password_;
      if (((from_bitField0_ & 0x00000004) == 0x00000004)) {
        to_bitField0_ |= 0x00000004;
      }
      result.nickname_ = nickname_;
      if (((from_bitField0_ & 0x00000008) == 0x00000008)) {
        to_bitField0_ |= 0x00000008;
      }
      result.addr_ = addr_;
      if (((from_bitField0_ & 0x00000010) == 0x00000010)) {
        to_bitField0_ |= 0x00000010;
      }
      result.smsCode_ = smsCode_;
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
      if (other instanceof com.dj.protobuf.login.CreateAccountReq) {
        return mergeFrom((com.dj.protobuf.login.CreateAccountReq)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.dj.protobuf.login.CreateAccountReq other) {
      if (other == com.dj.protobuf.login.CreateAccountReq.getDefaultInstance()) return this;
      if (other.hasAccount()) {
        bitField0_ |= 0x00000001;
        account_ = other.account_;
        onChanged();
      }
      if (other.hasPassword()) {
        bitField0_ |= 0x00000002;
        password_ = other.password_;
        onChanged();
      }
      if (other.hasNickname()) {
        bitField0_ |= 0x00000004;
        nickname_ = other.nickname_;
        onChanged();
      }
      if (other.hasAddr()) {
        bitField0_ |= 0x00000008;
        addr_ = other.addr_;
        onChanged();
      }
      if (other.hasSmsCode()) {
        bitField0_ |= 0x00000010;
        smsCode_ = other.smsCode_;
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
      com.dj.protobuf.login.CreateAccountReq parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.dj.protobuf.login.CreateAccountReq) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private java.lang.Object account_ = "";
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / ??????????????????/?????????
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional string account = 1;</code>
     */
    public boolean hasAccount() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / ??????????????????/?????????
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional string account = 1;</code>
     */
    public java.lang.String getAccount() {
      java.lang.Object ref = account_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        if (bs.isValidUtf8()) {
          account_ = s;
        }
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / ??????????????????/?????????
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional string account = 1;</code>
     */
    public com.google.protobuf.ByteString
        getAccountBytes() {
      java.lang.Object ref = account_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        account_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / ??????????????????/?????????
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional string account = 1;</code>
     */
    public Builder setAccount(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000001;
      account_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / ??????????????????/?????????
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional string account = 1;</code>
     */
    public Builder clearAccount() {
      bitField0_ = (bitField0_ & ~0x00000001);
      account_ = getDefaultInstance().getAccount();
      onChanged();
      return this;
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / ??????????????????/?????????
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional string account = 1;</code>
     */
    public Builder setAccountBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000001;
      account_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object password_ = "";
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / ??????????????????
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional string password = 2;</code>
     */
    public boolean hasPassword() {
      return ((bitField0_ & 0x00000002) == 0x00000002);
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / ??????????????????
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional string password = 2;</code>
     */
    public java.lang.String getPassword() {
      java.lang.Object ref = password_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        if (bs.isValidUtf8()) {
          password_ = s;
        }
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / ??????????????????
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional string password = 2;</code>
     */
    public com.google.protobuf.ByteString
        getPasswordBytes() {
      java.lang.Object ref = password_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        password_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / ??????????????????
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional string password = 2;</code>
     */
    public Builder setPassword(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000002;
      password_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / ??????????????????
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional string password = 2;</code>
     */
    public Builder clearPassword() {
      bitField0_ = (bitField0_ & ~0x00000002);
      password_ = getDefaultInstance().getPassword();
      onChanged();
      return this;
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / ??????????????????
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional string password = 2;</code>
     */
    public Builder setPasswordBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000002;
      password_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object nickname_ = "";
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / ??????
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional string nickname = 3;</code>
     */
    public boolean hasNickname() {
      return ((bitField0_ & 0x00000004) == 0x00000004);
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / ??????
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional string nickname = 3;</code>
     */
    public java.lang.String getNickname() {
      java.lang.Object ref = nickname_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        if (bs.isValidUtf8()) {
          nickname_ = s;
        }
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / ??????
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional string nickname = 3;</code>
     */
    public com.google.protobuf.ByteString
        getNicknameBytes() {
      java.lang.Object ref = nickname_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        nickname_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / ??????
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional string nickname = 3;</code>
     */
    public Builder setNickname(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000004;
      nickname_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / ??????
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional string nickname = 3;</code>
     */
    public Builder clearNickname() {
      bitField0_ = (bitField0_ & ~0x00000004);
      nickname_ = getDefaultInstance().getNickname();
      onChanged();
      return this;
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / ??????
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional string nickname = 3;</code>
     */
    public Builder setNicknameBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000004;
      nickname_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object addr_ = "";
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / ??????IP????????????????????????
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional string addr = 4;</code>
     */
    public boolean hasAddr() {
      return ((bitField0_ & 0x00000008) == 0x00000008);
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / ??????IP????????????????????????
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional string addr = 4;</code>
     */
    public java.lang.String getAddr() {
      java.lang.Object ref = addr_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        if (bs.isValidUtf8()) {
          addr_ = s;
        }
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / ??????IP????????????????????????
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional string addr = 4;</code>
     */
    public com.google.protobuf.ByteString
        getAddrBytes() {
      java.lang.Object ref = addr_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        addr_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / ??????IP????????????????????????
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional string addr = 4;</code>
     */
    public Builder setAddr(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000008;
      addr_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / ??????IP????????????????????????
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional string addr = 4;</code>
     */
    public Builder clearAddr() {
      bitField0_ = (bitField0_ & ~0x00000008);
      addr_ = getDefaultInstance().getAddr();
      onChanged();
      return this;
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / ??????IP????????????????????????
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional string addr = 4;</code>
     */
    public Builder setAddrBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000008;
      addr_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object smsCode_ = "";
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / ???????????????
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional string smsCode = 5;</code>
     */
    public boolean hasSmsCode() {
      return ((bitField0_ & 0x00000010) == 0x00000010);
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / ???????????????
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional string smsCode = 5;</code>
     */
    public java.lang.String getSmsCode() {
      java.lang.Object ref = smsCode_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        if (bs.isValidUtf8()) {
          smsCode_ = s;
        }
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / ???????????????
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional string smsCode = 5;</code>
     */
    public com.google.protobuf.ByteString
        getSmsCodeBytes() {
      java.lang.Object ref = smsCode_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        smsCode_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / ???????????????
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional string smsCode = 5;</code>
     */
    public Builder setSmsCode(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000010;
      smsCode_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / ???????????????
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional string smsCode = 5;</code>
     */
    public Builder clearSmsCode() {
      bitField0_ = (bitField0_ & ~0x00000010);
      smsCode_ = getDefaultInstance().getSmsCode();
      onChanged();
      return this;
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / ???????????????
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional string smsCode = 5;</code>
     */
    public Builder setSmsCodeBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000010;
      smsCode_ = value;
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


    // @@protoc_insertion_point(builder_scope:Protocols.CreateAccountReq)
  }

  // @@protoc_insertion_point(class_scope:Protocols.CreateAccountReq)
  private static final com.dj.protobuf.login.CreateAccountReq DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.dj.protobuf.login.CreateAccountReq();
  }

  public static com.dj.protobuf.login.CreateAccountReq getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  @java.lang.Deprecated public static final com.google.protobuf.Parser<CreateAccountReq>
      PARSER = new com.google.protobuf.AbstractParser<CreateAccountReq>() {
    public CreateAccountReq parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new CreateAccountReq(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<CreateAccountReq> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<CreateAccountReq> getParserForType() {
    return PARSER;
  }

  public com.dj.protobuf.login.CreateAccountReq getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

