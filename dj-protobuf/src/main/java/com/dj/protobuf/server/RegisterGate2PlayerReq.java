// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Server.proto

package com.dj.protobuf.server;

/**
 * <pre>
 *请求注冊玩家服
 * </pre>
 *
 * Protobuf type {@code Protocols.RegisterGate2PlayerReq}
 */
public  final class RegisterGate2PlayerReq extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:Protocols.RegisterGate2PlayerReq)
    RegisterGate2PlayerReqOrBuilder {
  // Use RegisterGate2PlayerReq.newBuilder() to construct.
  private RegisterGate2PlayerReq(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private RegisterGate2PlayerReq() {
    serverId_ = 0;
    serverName_ = "";
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private RegisterGate2PlayerReq(
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
            serverId_ = input.readInt32();
            break;
          }
          case 18: {
            com.google.protobuf.ByteString bs = input.readBytes();
            bitField0_ |= 0x00000002;
            serverName_ = bs;
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
    return com.dj.protobuf.server.Server.internal_static_Protocols_RegisterGate2PlayerReq_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.dj.protobuf.server.Server.internal_static_Protocols_RegisterGate2PlayerReq_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.dj.protobuf.server.RegisterGate2PlayerReq.class, com.dj.protobuf.server.RegisterGate2PlayerReq.Builder.class);
  }

  private int bitField0_;
  public static final int SERVERID_FIELD_NUMBER = 1;
  private int serverId_;
  /**
   * <code>optional int32 serverId = 1;</code>
   */
  public boolean hasServerId() {
    return ((bitField0_ & 0x00000001) == 0x00000001);
  }
  /**
   * <code>optional int32 serverId = 1;</code>
   */
  public int getServerId() {
    return serverId_;
  }

  public static final int SERVERNAME_FIELD_NUMBER = 2;
  private volatile java.lang.Object serverName_;
  /**
   * <code>optional string serverName = 2;</code>
   */
  public boolean hasServerName() {
    return ((bitField0_ & 0x00000002) == 0x00000002);
  }
  /**
   * <code>optional string serverName = 2;</code>
   */
  public java.lang.String getServerName() {
    java.lang.Object ref = serverName_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      if (bs.isValidUtf8()) {
        serverName_ = s;
      }
      return s;
    }
  }
  /**
   * <code>optional string serverName = 2;</code>
   */
  public com.google.protobuf.ByteString
      getServerNameBytes() {
    java.lang.Object ref = serverName_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      serverName_ = b;
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
      output.writeInt32(1, serverId_);
    }
    if (((bitField0_ & 0x00000002) == 0x00000002)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, serverName_);
    }
    unknownFields.writeTo(output);
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (((bitField0_ & 0x00000001) == 0x00000001)) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(1, serverId_);
    }
    if (((bitField0_ & 0x00000002) == 0x00000002)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, serverName_);
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
    if (!(obj instanceof com.dj.protobuf.server.RegisterGate2PlayerReq)) {
      return super.equals(obj);
    }
    com.dj.protobuf.server.RegisterGate2PlayerReq other = (com.dj.protobuf.server.RegisterGate2PlayerReq) obj;

    boolean result = true;
    result = result && (hasServerId() == other.hasServerId());
    if (hasServerId()) {
      result = result && (getServerId()
          == other.getServerId());
    }
    result = result && (hasServerName() == other.hasServerName());
    if (hasServerName()) {
      result = result && getServerName()
          .equals(other.getServerName());
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
    if (hasServerId()) {
      hash = (37 * hash) + SERVERID_FIELD_NUMBER;
      hash = (53 * hash) + getServerId();
    }
    if (hasServerName()) {
      hash = (37 * hash) + SERVERNAME_FIELD_NUMBER;
      hash = (53 * hash) + getServerName().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.dj.protobuf.server.RegisterGate2PlayerReq parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dj.protobuf.server.RegisterGate2PlayerReq parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dj.protobuf.server.RegisterGate2PlayerReq parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dj.protobuf.server.RegisterGate2PlayerReq parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dj.protobuf.server.RegisterGate2PlayerReq parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.server.RegisterGate2PlayerReq parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.dj.protobuf.server.RegisterGate2PlayerReq parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.server.RegisterGate2PlayerReq parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.dj.protobuf.server.RegisterGate2PlayerReq parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.server.RegisterGate2PlayerReq parseFrom(
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
  public static Builder newBuilder(com.dj.protobuf.server.RegisterGate2PlayerReq prototype) {
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
   *请求注冊玩家服
   * </pre>
   *
   * Protobuf type {@code Protocols.RegisterGate2PlayerReq}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:Protocols.RegisterGate2PlayerReq)
      com.dj.protobuf.server.RegisterGate2PlayerReqOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.dj.protobuf.server.Server.internal_static_Protocols_RegisterGate2PlayerReq_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.dj.protobuf.server.Server.internal_static_Protocols_RegisterGate2PlayerReq_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.dj.protobuf.server.RegisterGate2PlayerReq.class, com.dj.protobuf.server.RegisterGate2PlayerReq.Builder.class);
    }

    // Construct using com.dj.protobuf.server.RegisterGate2PlayerReq.newBuilder()
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
      serverId_ = 0;
      bitField0_ = (bitField0_ & ~0x00000001);
      serverName_ = "";
      bitField0_ = (bitField0_ & ~0x00000002);
      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.dj.protobuf.server.Server.internal_static_Protocols_RegisterGate2PlayerReq_descriptor;
    }

    public com.dj.protobuf.server.RegisterGate2PlayerReq getDefaultInstanceForType() {
      return com.dj.protobuf.server.RegisterGate2PlayerReq.getDefaultInstance();
    }

    public com.dj.protobuf.server.RegisterGate2PlayerReq build() {
      com.dj.protobuf.server.RegisterGate2PlayerReq result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public com.dj.protobuf.server.RegisterGate2PlayerReq buildPartial() {
      com.dj.protobuf.server.RegisterGate2PlayerReq result = new com.dj.protobuf.server.RegisterGate2PlayerReq(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
        to_bitField0_ |= 0x00000001;
      }
      result.serverId_ = serverId_;
      if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
        to_bitField0_ |= 0x00000002;
      }
      result.serverName_ = serverName_;
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
      if (other instanceof com.dj.protobuf.server.RegisterGate2PlayerReq) {
        return mergeFrom((com.dj.protobuf.server.RegisterGate2PlayerReq)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.dj.protobuf.server.RegisterGate2PlayerReq other) {
      if (other == com.dj.protobuf.server.RegisterGate2PlayerReq.getDefaultInstance()) return this;
      if (other.hasServerId()) {
        setServerId(other.getServerId());
      }
      if (other.hasServerName()) {
        bitField0_ |= 0x00000002;
        serverName_ = other.serverName_;
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
      com.dj.protobuf.server.RegisterGate2PlayerReq parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.dj.protobuf.server.RegisterGate2PlayerReq) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private int serverId_ ;
    /**
     * <code>optional int32 serverId = 1;</code>
     */
    public boolean hasServerId() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <code>optional int32 serverId = 1;</code>
     */
    public int getServerId() {
      return serverId_;
    }
    /**
     * <code>optional int32 serverId = 1;</code>
     */
    public Builder setServerId(int value) {
      bitField0_ |= 0x00000001;
      serverId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional int32 serverId = 1;</code>
     */
    public Builder clearServerId() {
      bitField0_ = (bitField0_ & ~0x00000001);
      serverId_ = 0;
      onChanged();
      return this;
    }

    private java.lang.Object serverName_ = "";
    /**
     * <code>optional string serverName = 2;</code>
     */
    public boolean hasServerName() {
      return ((bitField0_ & 0x00000002) == 0x00000002);
    }
    /**
     * <code>optional string serverName = 2;</code>
     */
    public java.lang.String getServerName() {
      java.lang.Object ref = serverName_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        if (bs.isValidUtf8()) {
          serverName_ = s;
        }
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>optional string serverName = 2;</code>
     */
    public com.google.protobuf.ByteString
        getServerNameBytes() {
      java.lang.Object ref = serverName_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        serverName_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>optional string serverName = 2;</code>
     */
    public Builder setServerName(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000002;
      serverName_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional string serverName = 2;</code>
     */
    public Builder clearServerName() {
      bitField0_ = (bitField0_ & ~0x00000002);
      serverName_ = getDefaultInstance().getServerName();
      onChanged();
      return this;
    }
    /**
     * <code>optional string serverName = 2;</code>
     */
    public Builder setServerNameBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000002;
      serverName_ = value;
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


    // @@protoc_insertion_point(builder_scope:Protocols.RegisterGate2PlayerReq)
  }

  // @@protoc_insertion_point(class_scope:Protocols.RegisterGate2PlayerReq)
  private static final com.dj.protobuf.server.RegisterGate2PlayerReq DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.dj.protobuf.server.RegisterGate2PlayerReq();
  }

  public static com.dj.protobuf.server.RegisterGate2PlayerReq getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  @java.lang.Deprecated public static final com.google.protobuf.Parser<RegisterGate2PlayerReq>
      PARSER = new com.google.protobuf.AbstractParser<RegisterGate2PlayerReq>() {
    public RegisterGate2PlayerReq parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new RegisterGate2PlayerReq(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<RegisterGate2PlayerReq> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<RegisterGate2PlayerReq> getParserForType() {
    return PARSER;
  }

  public com.dj.protobuf.server.RegisterGate2PlayerReq getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

