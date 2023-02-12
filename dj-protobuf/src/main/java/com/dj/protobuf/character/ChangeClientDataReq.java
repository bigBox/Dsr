// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Character.proto

package com.dj.protobuf.character;

/**
 * <pre>
 *&#47; &lt;summary&gt;
 * / 修改客戶端数据
 * / &lt;/summary&gt;
 * </pre>
 *
 * Protobuf type {@code Protocols.ChangeClientDataReq}
 */
public  final class ChangeClientDataReq extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:Protocols.ChangeClientDataReq)
    ChangeClientDataReqOrBuilder {
  // Use ChangeClientDataReq.newBuilder() to construct.
  private ChangeClientDataReq(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private ChangeClientDataReq() {
    key_ = "";
    value_ = 0;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private ChangeClientDataReq(
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
            key_ = bs;
            break;
          }
          case 16: {
            bitField0_ |= 0x00000002;
            value_ = input.readInt32();
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
    return com.dj.protobuf.character.Character.internal_static_Protocols_ChangeClientDataReq_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.dj.protobuf.character.Character.internal_static_Protocols_ChangeClientDataReq_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.dj.protobuf.character.ChangeClientDataReq.class, com.dj.protobuf.character.ChangeClientDataReq.Builder.class);
  }

  private int bitField0_;
  public static final int KEY_FIELD_NUMBER = 1;
  private volatile java.lang.Object key_;
  /**
   * <code>optional string key = 1;</code>
   */
  public boolean hasKey() {
    return ((bitField0_ & 0x00000001) == 0x00000001);
  }
  /**
   * <code>optional string key = 1;</code>
   */
  public java.lang.String getKey() {
    java.lang.Object ref = key_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      if (bs.isValidUtf8()) {
        key_ = s;
      }
      return s;
    }
  }
  /**
   * <code>optional string key = 1;</code>
   */
  public com.google.protobuf.ByteString
      getKeyBytes() {
    java.lang.Object ref = key_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      key_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int VALUE_FIELD_NUMBER = 2;
  private int value_;
  /**
   * <code>optional int32 value = 2;</code>
   */
  public boolean hasValue() {
    return ((bitField0_ & 0x00000002) == 0x00000002);
  }
  /**
   * <code>optional int32 value = 2;</code>
   */
  public int getValue() {
    return value_;
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
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, key_);
    }
    if (((bitField0_ & 0x00000002) == 0x00000002)) {
      output.writeInt32(2, value_);
    }
    unknownFields.writeTo(output);
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (((bitField0_ & 0x00000001) == 0x00000001)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, key_);
    }
    if (((bitField0_ & 0x00000002) == 0x00000002)) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(2, value_);
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
    if (!(obj instanceof com.dj.protobuf.character.ChangeClientDataReq)) {
      return super.equals(obj);
    }
    com.dj.protobuf.character.ChangeClientDataReq other = (com.dj.protobuf.character.ChangeClientDataReq) obj;

    boolean result = true;
    result = result && (hasKey() == other.hasKey());
    if (hasKey()) {
      result = result && getKey()
          .equals(other.getKey());
    }
    result = result && (hasValue() == other.hasValue());
    if (hasValue()) {
      result = result && (getValue()
          == other.getValue());
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
    if (hasKey()) {
      hash = (37 * hash) + KEY_FIELD_NUMBER;
      hash = (53 * hash) + getKey().hashCode();
    }
    if (hasValue()) {
      hash = (37 * hash) + VALUE_FIELD_NUMBER;
      hash = (53 * hash) + getValue();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.dj.protobuf.character.ChangeClientDataReq parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dj.protobuf.character.ChangeClientDataReq parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dj.protobuf.character.ChangeClientDataReq parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dj.protobuf.character.ChangeClientDataReq parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dj.protobuf.character.ChangeClientDataReq parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.character.ChangeClientDataReq parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.dj.protobuf.character.ChangeClientDataReq parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.character.ChangeClientDataReq parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.dj.protobuf.character.ChangeClientDataReq parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.character.ChangeClientDataReq parseFrom(
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
  public static Builder newBuilder(com.dj.protobuf.character.ChangeClientDataReq prototype) {
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
   * / 修改客戶端数据
   * / &lt;/summary&gt;
   * </pre>
   *
   * Protobuf type {@code Protocols.ChangeClientDataReq}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:Protocols.ChangeClientDataReq)
      com.dj.protobuf.character.ChangeClientDataReqOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.dj.protobuf.character.Character.internal_static_Protocols_ChangeClientDataReq_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.dj.protobuf.character.Character.internal_static_Protocols_ChangeClientDataReq_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.dj.protobuf.character.ChangeClientDataReq.class, com.dj.protobuf.character.ChangeClientDataReq.Builder.class);
    }

    // Construct using com.dj.protobuf.character.ChangeClientDataReq.newBuilder()
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
      key_ = "";
      bitField0_ = (bitField0_ & ~0x00000001);
      value_ = 0;
      bitField0_ = (bitField0_ & ~0x00000002);
      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.dj.protobuf.character.Character.internal_static_Protocols_ChangeClientDataReq_descriptor;
    }

    public com.dj.protobuf.character.ChangeClientDataReq getDefaultInstanceForType() {
      return com.dj.protobuf.character.ChangeClientDataReq.getDefaultInstance();
    }

    public com.dj.protobuf.character.ChangeClientDataReq build() {
      com.dj.protobuf.character.ChangeClientDataReq result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public com.dj.protobuf.character.ChangeClientDataReq buildPartial() {
      com.dj.protobuf.character.ChangeClientDataReq result = new com.dj.protobuf.character.ChangeClientDataReq(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
        to_bitField0_ |= 0x00000001;
      }
      result.key_ = key_;
      if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
        to_bitField0_ |= 0x00000002;
      }
      result.value_ = value_;
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
      if (other instanceof com.dj.protobuf.character.ChangeClientDataReq) {
        return mergeFrom((com.dj.protobuf.character.ChangeClientDataReq)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.dj.protobuf.character.ChangeClientDataReq other) {
      if (other == com.dj.protobuf.character.ChangeClientDataReq.getDefaultInstance()) return this;
      if (other.hasKey()) {
        bitField0_ |= 0x00000001;
        key_ = other.key_;
        onChanged();
      }
      if (other.hasValue()) {
        setValue(other.getValue());
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
      com.dj.protobuf.character.ChangeClientDataReq parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.dj.protobuf.character.ChangeClientDataReq) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private java.lang.Object key_ = "";
    /**
     * <code>optional string key = 1;</code>
     */
    public boolean hasKey() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <code>optional string key = 1;</code>
     */
    public java.lang.String getKey() {
      java.lang.Object ref = key_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        if (bs.isValidUtf8()) {
          key_ = s;
        }
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>optional string key = 1;</code>
     */
    public com.google.protobuf.ByteString
        getKeyBytes() {
      java.lang.Object ref = key_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        key_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>optional string key = 1;</code>
     */
    public Builder setKey(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000001;
      key_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional string key = 1;</code>
     */
    public Builder clearKey() {
      bitField0_ = (bitField0_ & ~0x00000001);
      key_ = getDefaultInstance().getKey();
      onChanged();
      return this;
    }
    /**
     * <code>optional string key = 1;</code>
     */
    public Builder setKeyBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000001;
      key_ = value;
      onChanged();
      return this;
    }

    private int value_ ;
    /**
     * <code>optional int32 value = 2;</code>
     */
    public boolean hasValue() {
      return ((bitField0_ & 0x00000002) == 0x00000002);
    }
    /**
     * <code>optional int32 value = 2;</code>
     */
    public int getValue() {
      return value_;
    }
    /**
     * <code>optional int32 value = 2;</code>
     */
    public Builder setValue(int value) {
      bitField0_ |= 0x00000002;
      value_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional int32 value = 2;</code>
     */
    public Builder clearValue() {
      bitField0_ = (bitField0_ & ~0x00000002);
      value_ = 0;
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


    // @@protoc_insertion_point(builder_scope:Protocols.ChangeClientDataReq)
  }

  // @@protoc_insertion_point(class_scope:Protocols.ChangeClientDataReq)
  private static final com.dj.protobuf.character.ChangeClientDataReq DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.dj.protobuf.character.ChangeClientDataReq();
  }

  public static com.dj.protobuf.character.ChangeClientDataReq getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  @java.lang.Deprecated public static final com.google.protobuf.Parser<ChangeClientDataReq>
      PARSER = new com.google.protobuf.AbstractParser<ChangeClientDataReq>() {
    public ChangeClientDataReq parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new ChangeClientDataReq(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<ChangeClientDataReq> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<ChangeClientDataReq> getParserForType() {
    return PARSER;
  }

  public com.dj.protobuf.character.ChangeClientDataReq getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

