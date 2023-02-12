// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Server.proto

package com.dj.protobuf.server;

/**
 * <pre>
 *更新全局服配置
 * </pre>
 *
 * Protobuf type {@code Protocols.UpdateConfig4GlobalReq}
 */
public  final class UpdateConfig4GlobalReq extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:Protocols.UpdateConfig4GlobalReq)
    UpdateConfig4GlobalReqOrBuilder {
  // Use UpdateConfig4GlobalReq.newBuilder() to construct.
  private UpdateConfig4GlobalReq(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private UpdateConfig4GlobalReq() {
    jsonConfigName_ = "";
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private UpdateConfig4GlobalReq(
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
            jsonConfigName_ = bs;
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
    return com.dj.protobuf.server.Server.internal_static_Protocols_UpdateConfig4GlobalReq_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.dj.protobuf.server.Server.internal_static_Protocols_UpdateConfig4GlobalReq_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.dj.protobuf.server.UpdateConfig4GlobalReq.class, com.dj.protobuf.server.UpdateConfig4GlobalReq.Builder.class);
  }

  private int bitField0_;
  public static final int JSONCONFIGNAME_FIELD_NUMBER = 1;
  private volatile java.lang.Object jsonConfigName_;
  /**
   * <code>optional string jsonConfigName = 1;</code>
   */
  public boolean hasJsonConfigName() {
    return ((bitField0_ & 0x00000001) == 0x00000001);
  }
  /**
   * <code>optional string jsonConfigName = 1;</code>
   */
  public java.lang.String getJsonConfigName() {
    java.lang.Object ref = jsonConfigName_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      if (bs.isValidUtf8()) {
        jsonConfigName_ = s;
      }
      return s;
    }
  }
  /**
   * <code>optional string jsonConfigName = 1;</code>
   */
  public com.google.protobuf.ByteString
      getJsonConfigNameBytes() {
    java.lang.Object ref = jsonConfigName_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      jsonConfigName_ = b;
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
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, jsonConfigName_);
    }
    unknownFields.writeTo(output);
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (((bitField0_ & 0x00000001) == 0x00000001)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, jsonConfigName_);
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
    if (!(obj instanceof com.dj.protobuf.server.UpdateConfig4GlobalReq)) {
      return super.equals(obj);
    }
    com.dj.protobuf.server.UpdateConfig4GlobalReq other = (com.dj.protobuf.server.UpdateConfig4GlobalReq) obj;

    boolean result = true;
    result = result && (hasJsonConfigName() == other.hasJsonConfigName());
    if (hasJsonConfigName()) {
      result = result && getJsonConfigName()
          .equals(other.getJsonConfigName());
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
    if (hasJsonConfigName()) {
      hash = (37 * hash) + JSONCONFIGNAME_FIELD_NUMBER;
      hash = (53 * hash) + getJsonConfigName().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.dj.protobuf.server.UpdateConfig4GlobalReq parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dj.protobuf.server.UpdateConfig4GlobalReq parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dj.protobuf.server.UpdateConfig4GlobalReq parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dj.protobuf.server.UpdateConfig4GlobalReq parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dj.protobuf.server.UpdateConfig4GlobalReq parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.server.UpdateConfig4GlobalReq parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.dj.protobuf.server.UpdateConfig4GlobalReq parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.server.UpdateConfig4GlobalReq parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.dj.protobuf.server.UpdateConfig4GlobalReq parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.server.UpdateConfig4GlobalReq parseFrom(
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
  public static Builder newBuilder(com.dj.protobuf.server.UpdateConfig4GlobalReq prototype) {
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
   *更新全局服配置
   * </pre>
   *
   * Protobuf type {@code Protocols.UpdateConfig4GlobalReq}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:Protocols.UpdateConfig4GlobalReq)
      com.dj.protobuf.server.UpdateConfig4GlobalReqOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.dj.protobuf.server.Server.internal_static_Protocols_UpdateConfig4GlobalReq_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.dj.protobuf.server.Server.internal_static_Protocols_UpdateConfig4GlobalReq_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.dj.protobuf.server.UpdateConfig4GlobalReq.class, com.dj.protobuf.server.UpdateConfig4GlobalReq.Builder.class);
    }

    // Construct using com.dj.protobuf.server.UpdateConfig4GlobalReq.newBuilder()
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
      jsonConfigName_ = "";
      bitField0_ = (bitField0_ & ~0x00000001);
      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.dj.protobuf.server.Server.internal_static_Protocols_UpdateConfig4GlobalReq_descriptor;
    }

    public com.dj.protobuf.server.UpdateConfig4GlobalReq getDefaultInstanceForType() {
      return com.dj.protobuf.server.UpdateConfig4GlobalReq.getDefaultInstance();
    }

    public com.dj.protobuf.server.UpdateConfig4GlobalReq build() {
      com.dj.protobuf.server.UpdateConfig4GlobalReq result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public com.dj.protobuf.server.UpdateConfig4GlobalReq buildPartial() {
      com.dj.protobuf.server.UpdateConfig4GlobalReq result = new com.dj.protobuf.server.UpdateConfig4GlobalReq(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
        to_bitField0_ |= 0x00000001;
      }
      result.jsonConfigName_ = jsonConfigName_;
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
      if (other instanceof com.dj.protobuf.server.UpdateConfig4GlobalReq) {
        return mergeFrom((com.dj.protobuf.server.UpdateConfig4GlobalReq)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.dj.protobuf.server.UpdateConfig4GlobalReq other) {
      if (other == com.dj.protobuf.server.UpdateConfig4GlobalReq.getDefaultInstance()) return this;
      if (other.hasJsonConfigName()) {
        bitField0_ |= 0x00000001;
        jsonConfigName_ = other.jsonConfigName_;
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
      com.dj.protobuf.server.UpdateConfig4GlobalReq parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.dj.protobuf.server.UpdateConfig4GlobalReq) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private java.lang.Object jsonConfigName_ = "";
    /**
     * <code>optional string jsonConfigName = 1;</code>
     */
    public boolean hasJsonConfigName() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <code>optional string jsonConfigName = 1;</code>
     */
    public java.lang.String getJsonConfigName() {
      java.lang.Object ref = jsonConfigName_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        if (bs.isValidUtf8()) {
          jsonConfigName_ = s;
        }
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>optional string jsonConfigName = 1;</code>
     */
    public com.google.protobuf.ByteString
        getJsonConfigNameBytes() {
      java.lang.Object ref = jsonConfigName_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        jsonConfigName_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>optional string jsonConfigName = 1;</code>
     */
    public Builder setJsonConfigName(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000001;
      jsonConfigName_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional string jsonConfigName = 1;</code>
     */
    public Builder clearJsonConfigName() {
      bitField0_ = (bitField0_ & ~0x00000001);
      jsonConfigName_ = getDefaultInstance().getJsonConfigName();
      onChanged();
      return this;
    }
    /**
     * <code>optional string jsonConfigName = 1;</code>
     */
    public Builder setJsonConfigNameBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000001;
      jsonConfigName_ = value;
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


    // @@protoc_insertion_point(builder_scope:Protocols.UpdateConfig4GlobalReq)
  }

  // @@protoc_insertion_point(class_scope:Protocols.UpdateConfig4GlobalReq)
  private static final com.dj.protobuf.server.UpdateConfig4GlobalReq DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.dj.protobuf.server.UpdateConfig4GlobalReq();
  }

  public static com.dj.protobuf.server.UpdateConfig4GlobalReq getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  @java.lang.Deprecated public static final com.google.protobuf.Parser<UpdateConfig4GlobalReq>
      PARSER = new com.google.protobuf.AbstractParser<UpdateConfig4GlobalReq>() {
    public UpdateConfig4GlobalReq parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new UpdateConfig4GlobalReq(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<UpdateConfig4GlobalReq> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<UpdateConfig4GlobalReq> getParserForType() {
    return PARSER;
  }

  public com.dj.protobuf.server.UpdateConfig4GlobalReq getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
