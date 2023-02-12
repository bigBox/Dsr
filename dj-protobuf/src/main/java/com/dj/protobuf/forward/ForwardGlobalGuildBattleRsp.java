// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Forward.proto

package com.dj.protobuf.forward;

/**
 * <pre>
 * 响应全局商会战斗转发
 * </pre>
 *
 * Protobuf type {@code Protocols.ForwardGlobalGuildBattleRsp}
 */
public  final class ForwardGlobalGuildBattleRsp extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:Protocols.ForwardGlobalGuildBattleRsp)
    ForwardGlobalGuildBattleRspOrBuilder {
  // Use ForwardGlobalGuildBattleRsp.newBuilder() to construct.
  private ForwardGlobalGuildBattleRsp(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private ForwardGlobalGuildBattleRsp() {
    roleID_ = 0L;
    rspClz_ = "";
    rsp_ = com.google.protobuf.ByteString.EMPTY;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private ForwardGlobalGuildBattleRsp(
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
            roleID_ = input.readUInt64();
            break;
          }
          case 18: {
            com.google.protobuf.ByteString bs = input.readBytes();
            bitField0_ |= 0x00000002;
            rspClz_ = bs;
            break;
          }
          case 26: {
            bitField0_ |= 0x00000004;
            rsp_ = input.readBytes();
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
    return com.dj.protobuf.forward.Forward.internal_static_Protocols_ForwardGlobalGuildBattleRsp_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.dj.protobuf.forward.Forward.internal_static_Protocols_ForwardGlobalGuildBattleRsp_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.dj.protobuf.forward.ForwardGlobalGuildBattleRsp.class, com.dj.protobuf.forward.ForwardGlobalGuildBattleRsp.Builder.class);
  }

  private int bitField0_;
  public static final int ROLEID_FIELD_NUMBER = 1;
  private long roleID_;
  /**
   * <code>optional uint64 roleID = 1;</code>
   */
  public boolean hasRoleID() {
    return ((bitField0_ & 0x00000001) == 0x00000001);
  }
  /**
   * <code>optional uint64 roleID = 1;</code>
   */
  public long getRoleID() {
    return roleID_;
  }

  public static final int RSPCLZ_FIELD_NUMBER = 2;
  private volatile java.lang.Object rspClz_;
  /**
   * <code>optional string rspClz = 2;</code>
   */
  public boolean hasRspClz() {
    return ((bitField0_ & 0x00000002) == 0x00000002);
  }
  /**
   * <code>optional string rspClz = 2;</code>
   */
  public java.lang.String getRspClz() {
    java.lang.Object ref = rspClz_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      if (bs.isValidUtf8()) {
        rspClz_ = s;
      }
      return s;
    }
  }
  /**
   * <code>optional string rspClz = 2;</code>
   */
  public com.google.protobuf.ByteString
      getRspClzBytes() {
    java.lang.Object ref = rspClz_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      rspClz_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int RSP_FIELD_NUMBER = 3;
  private com.google.protobuf.ByteString rsp_;
  /**
   * <code>optional bytes rsp = 3;</code>
   */
  public boolean hasRsp() {
    return ((bitField0_ & 0x00000004) == 0x00000004);
  }
  /**
   * <code>optional bytes rsp = 3;</code>
   */
  public com.google.protobuf.ByteString getRsp() {
    return rsp_;
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
      output.writeUInt64(1, roleID_);
    }
    if (((bitField0_ & 0x00000002) == 0x00000002)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, rspClz_);
    }
    if (((bitField0_ & 0x00000004) == 0x00000004)) {
      output.writeBytes(3, rsp_);
    }
    unknownFields.writeTo(output);
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (((bitField0_ & 0x00000001) == 0x00000001)) {
      size += com.google.protobuf.CodedOutputStream
        .computeUInt64Size(1, roleID_);
    }
    if (((bitField0_ & 0x00000002) == 0x00000002)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, rspClz_);
    }
    if (((bitField0_ & 0x00000004) == 0x00000004)) {
      size += com.google.protobuf.CodedOutputStream
        .computeBytesSize(3, rsp_);
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
    if (!(obj instanceof com.dj.protobuf.forward.ForwardGlobalGuildBattleRsp)) {
      return super.equals(obj);
    }
    com.dj.protobuf.forward.ForwardGlobalGuildBattleRsp other = (com.dj.protobuf.forward.ForwardGlobalGuildBattleRsp) obj;

    boolean result = true;
    result = result && (hasRoleID() == other.hasRoleID());
    if (hasRoleID()) {
      result = result && (getRoleID()
          == other.getRoleID());
    }
    result = result && (hasRspClz() == other.hasRspClz());
    if (hasRspClz()) {
      result = result && getRspClz()
          .equals(other.getRspClz());
    }
    result = result && (hasRsp() == other.hasRsp());
    if (hasRsp()) {
      result = result && getRsp()
          .equals(other.getRsp());
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
    if (hasRoleID()) {
      hash = (37 * hash) + ROLEID_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
          getRoleID());
    }
    if (hasRspClz()) {
      hash = (37 * hash) + RSPCLZ_FIELD_NUMBER;
      hash = (53 * hash) + getRspClz().hashCode();
    }
    if (hasRsp()) {
      hash = (37 * hash) + RSP_FIELD_NUMBER;
      hash = (53 * hash) + getRsp().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.dj.protobuf.forward.ForwardGlobalGuildBattleRsp parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dj.protobuf.forward.ForwardGlobalGuildBattleRsp parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dj.protobuf.forward.ForwardGlobalGuildBattleRsp parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dj.protobuf.forward.ForwardGlobalGuildBattleRsp parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dj.protobuf.forward.ForwardGlobalGuildBattleRsp parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.forward.ForwardGlobalGuildBattleRsp parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.dj.protobuf.forward.ForwardGlobalGuildBattleRsp parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.forward.ForwardGlobalGuildBattleRsp parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.dj.protobuf.forward.ForwardGlobalGuildBattleRsp parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.forward.ForwardGlobalGuildBattleRsp parseFrom(
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
  public static Builder newBuilder(com.dj.protobuf.forward.ForwardGlobalGuildBattleRsp prototype) {
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
   * 响应全局商会战斗转发
   * </pre>
   *
   * Protobuf type {@code Protocols.ForwardGlobalGuildBattleRsp}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:Protocols.ForwardGlobalGuildBattleRsp)
      com.dj.protobuf.forward.ForwardGlobalGuildBattleRspOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.dj.protobuf.forward.Forward.internal_static_Protocols_ForwardGlobalGuildBattleRsp_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.dj.protobuf.forward.Forward.internal_static_Protocols_ForwardGlobalGuildBattleRsp_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.dj.protobuf.forward.ForwardGlobalGuildBattleRsp.class, com.dj.protobuf.forward.ForwardGlobalGuildBattleRsp.Builder.class);
    }

    // Construct using com.dj.protobuf.forward.ForwardGlobalGuildBattleRsp.newBuilder()
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
      roleID_ = 0L;
      bitField0_ = (bitField0_ & ~0x00000001);
      rspClz_ = "";
      bitField0_ = (bitField0_ & ~0x00000002);
      rsp_ = com.google.protobuf.ByteString.EMPTY;
      bitField0_ = (bitField0_ & ~0x00000004);
      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.dj.protobuf.forward.Forward.internal_static_Protocols_ForwardGlobalGuildBattleRsp_descriptor;
    }

    public com.dj.protobuf.forward.ForwardGlobalGuildBattleRsp getDefaultInstanceForType() {
      return com.dj.protobuf.forward.ForwardGlobalGuildBattleRsp.getDefaultInstance();
    }

    public com.dj.protobuf.forward.ForwardGlobalGuildBattleRsp build() {
      com.dj.protobuf.forward.ForwardGlobalGuildBattleRsp result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public com.dj.protobuf.forward.ForwardGlobalGuildBattleRsp buildPartial() {
      com.dj.protobuf.forward.ForwardGlobalGuildBattleRsp result = new com.dj.protobuf.forward.ForwardGlobalGuildBattleRsp(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
        to_bitField0_ |= 0x00000001;
      }
      result.roleID_ = roleID_;
      if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
        to_bitField0_ |= 0x00000002;
      }
      result.rspClz_ = rspClz_;
      if (((from_bitField0_ & 0x00000004) == 0x00000004)) {
        to_bitField0_ |= 0x00000004;
      }
      result.rsp_ = rsp_;
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
      if (other instanceof com.dj.protobuf.forward.ForwardGlobalGuildBattleRsp) {
        return mergeFrom((com.dj.protobuf.forward.ForwardGlobalGuildBattleRsp)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.dj.protobuf.forward.ForwardGlobalGuildBattleRsp other) {
      if (other == com.dj.protobuf.forward.ForwardGlobalGuildBattleRsp.getDefaultInstance()) return this;
      if (other.hasRoleID()) {
        setRoleID(other.getRoleID());
      }
      if (other.hasRspClz()) {
        bitField0_ |= 0x00000002;
        rspClz_ = other.rspClz_;
        onChanged();
      }
      if (other.hasRsp()) {
        setRsp(other.getRsp());
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
      com.dj.protobuf.forward.ForwardGlobalGuildBattleRsp parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.dj.protobuf.forward.ForwardGlobalGuildBattleRsp) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private long roleID_ ;
    /**
     * <code>optional uint64 roleID = 1;</code>
     */
    public boolean hasRoleID() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <code>optional uint64 roleID = 1;</code>
     */
    public long getRoleID() {
      return roleID_;
    }
    /**
     * <code>optional uint64 roleID = 1;</code>
     */
    public Builder setRoleID(long value) {
      bitField0_ |= 0x00000001;
      roleID_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional uint64 roleID = 1;</code>
     */
    public Builder clearRoleID() {
      bitField0_ = (bitField0_ & ~0x00000001);
      roleID_ = 0L;
      onChanged();
      return this;
    }

    private java.lang.Object rspClz_ = "";
    /**
     * <code>optional string rspClz = 2;</code>
     */
    public boolean hasRspClz() {
      return ((bitField0_ & 0x00000002) == 0x00000002);
    }
    /**
     * <code>optional string rspClz = 2;</code>
     */
    public java.lang.String getRspClz() {
      java.lang.Object ref = rspClz_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        if (bs.isValidUtf8()) {
          rspClz_ = s;
        }
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>optional string rspClz = 2;</code>
     */
    public com.google.protobuf.ByteString
        getRspClzBytes() {
      java.lang.Object ref = rspClz_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        rspClz_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>optional string rspClz = 2;</code>
     */
    public Builder setRspClz(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000002;
      rspClz_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional string rspClz = 2;</code>
     */
    public Builder clearRspClz() {
      bitField0_ = (bitField0_ & ~0x00000002);
      rspClz_ = getDefaultInstance().getRspClz();
      onChanged();
      return this;
    }
    /**
     * <code>optional string rspClz = 2;</code>
     */
    public Builder setRspClzBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000002;
      rspClz_ = value;
      onChanged();
      return this;
    }

    private com.google.protobuf.ByteString rsp_ = com.google.protobuf.ByteString.EMPTY;
    /**
     * <code>optional bytes rsp = 3;</code>
     */
    public boolean hasRsp() {
      return ((bitField0_ & 0x00000004) == 0x00000004);
    }
    /**
     * <code>optional bytes rsp = 3;</code>
     */
    public com.google.protobuf.ByteString getRsp() {
      return rsp_;
    }
    /**
     * <code>optional bytes rsp = 3;</code>
     */
    public Builder setRsp(com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000004;
      rsp_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional bytes rsp = 3;</code>
     */
    public Builder clearRsp() {
      bitField0_ = (bitField0_ & ~0x00000004);
      rsp_ = getDefaultInstance().getRsp();
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


    // @@protoc_insertion_point(builder_scope:Protocols.ForwardGlobalGuildBattleRsp)
  }

  // @@protoc_insertion_point(class_scope:Protocols.ForwardGlobalGuildBattleRsp)
  private static final com.dj.protobuf.forward.ForwardGlobalGuildBattleRsp DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.dj.protobuf.forward.ForwardGlobalGuildBattleRsp();
  }

  public static com.dj.protobuf.forward.ForwardGlobalGuildBattleRsp getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  @java.lang.Deprecated public static final com.google.protobuf.Parser<ForwardGlobalGuildBattleRsp>
      PARSER = new com.google.protobuf.AbstractParser<ForwardGlobalGuildBattleRsp>() {
    public ForwardGlobalGuildBattleRsp parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new ForwardGlobalGuildBattleRsp(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<ForwardGlobalGuildBattleRsp> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<ForwardGlobalGuildBattleRsp> getParserForType() {
    return PARSER;
  }

  public com.dj.protobuf.forward.ForwardGlobalGuildBattleRsp getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

