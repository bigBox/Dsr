// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Forward.proto

package com.dj.protobuf.forward;

/**
 * <pre>
 * 向多人游戏转发
 * </pre>
 *
 * Protobuf type {@code Protocols.ForwardGameMultiReq}
 */
public  final class ForwardGameMultiReq extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:Protocols.ForwardGameMultiReq)
    ForwardGameMultiReqOrBuilder {
  // Use ForwardGameMultiReq.newBuilder() to construct.
  private ForwardGameMultiReq(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private ForwardGameMultiReq() {
    roleID_ = 0L;
    reqClz_ = "";
    req_ = com.google.protobuf.ByteString.EMPTY;
    ps_ = "";
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private ForwardGameMultiReq(
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
            reqClz_ = bs;
            break;
          }
          case 26: {
            bitField0_ |= 0x00000004;
            req_ = input.readBytes();
            break;
          }
          case 34: {
            com.google.protobuf.ByteString bs = input.readBytes();
            bitField0_ |= 0x00000008;
            ps_ = bs;
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
    return com.dj.protobuf.forward.Forward.internal_static_Protocols_ForwardGameMultiReq_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.dj.protobuf.forward.Forward.internal_static_Protocols_ForwardGameMultiReq_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.dj.protobuf.forward.ForwardGameMultiReq.class, com.dj.protobuf.forward.ForwardGameMultiReq.Builder.class);
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

  public static final int REQCLZ_FIELD_NUMBER = 2;
  private volatile java.lang.Object reqClz_;
  /**
   * <code>optional string reqClz = 2;</code>
   */
  public boolean hasReqClz() {
    return ((bitField0_ & 0x00000002) == 0x00000002);
  }
  /**
   * <code>optional string reqClz = 2;</code>
   */
  public java.lang.String getReqClz() {
    java.lang.Object ref = reqClz_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      if (bs.isValidUtf8()) {
        reqClz_ = s;
      }
      return s;
    }
  }
  /**
   * <code>optional string reqClz = 2;</code>
   */
  public com.google.protobuf.ByteString
      getReqClzBytes() {
    java.lang.Object ref = reqClz_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      reqClz_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int REQ_FIELD_NUMBER = 3;
  private com.google.protobuf.ByteString req_;
  /**
   * <code>optional bytes req = 3;</code>
   */
  public boolean hasReq() {
    return ((bitField0_ & 0x00000004) == 0x00000004);
  }
  /**
   * <code>optional bytes req = 3;</code>
   */
  public com.google.protobuf.ByteString getReq() {
    return req_;
  }

  public static final int PS_FIELD_NUMBER = 4;
  private volatile java.lang.Object ps_;
  /**
   * <code>optional string ps = 4;</code>
   */
  public boolean hasPs() {
    return ((bitField0_ & 0x00000008) == 0x00000008);
  }
  /**
   * <code>optional string ps = 4;</code>
   */
  public java.lang.String getPs() {
    java.lang.Object ref = ps_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      if (bs.isValidUtf8()) {
        ps_ = s;
      }
      return s;
    }
  }
  /**
   * <code>optional string ps = 4;</code>
   */
  public com.google.protobuf.ByteString
      getPsBytes() {
    java.lang.Object ref = ps_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      ps_ = b;
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
      output.writeUInt64(1, roleID_);
    }
    if (((bitField0_ & 0x00000002) == 0x00000002)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, reqClz_);
    }
    if (((bitField0_ & 0x00000004) == 0x00000004)) {
      output.writeBytes(3, req_);
    }
    if (((bitField0_ & 0x00000008) == 0x00000008)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 4, ps_);
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
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, reqClz_);
    }
    if (((bitField0_ & 0x00000004) == 0x00000004)) {
      size += com.google.protobuf.CodedOutputStream
        .computeBytesSize(3, req_);
    }
    if (((bitField0_ & 0x00000008) == 0x00000008)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(4, ps_);
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
    if (!(obj instanceof com.dj.protobuf.forward.ForwardGameMultiReq)) {
      return super.equals(obj);
    }
    com.dj.protobuf.forward.ForwardGameMultiReq other = (com.dj.protobuf.forward.ForwardGameMultiReq) obj;

    boolean result = true;
    result = result && (hasRoleID() == other.hasRoleID());
    if (hasRoleID()) {
      result = result && (getRoleID()
          == other.getRoleID());
    }
    result = result && (hasReqClz() == other.hasReqClz());
    if (hasReqClz()) {
      result = result && getReqClz()
          .equals(other.getReqClz());
    }
    result = result && (hasReq() == other.hasReq());
    if (hasReq()) {
      result = result && getReq()
          .equals(other.getReq());
    }
    result = result && (hasPs() == other.hasPs());
    if (hasPs()) {
      result = result && getPs()
          .equals(other.getPs());
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
    if (hasReqClz()) {
      hash = (37 * hash) + REQCLZ_FIELD_NUMBER;
      hash = (53 * hash) + getReqClz().hashCode();
    }
    if (hasReq()) {
      hash = (37 * hash) + REQ_FIELD_NUMBER;
      hash = (53 * hash) + getReq().hashCode();
    }
    if (hasPs()) {
      hash = (37 * hash) + PS_FIELD_NUMBER;
      hash = (53 * hash) + getPs().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.dj.protobuf.forward.ForwardGameMultiReq parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dj.protobuf.forward.ForwardGameMultiReq parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dj.protobuf.forward.ForwardGameMultiReq parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dj.protobuf.forward.ForwardGameMultiReq parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dj.protobuf.forward.ForwardGameMultiReq parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.forward.ForwardGameMultiReq parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.dj.protobuf.forward.ForwardGameMultiReq parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.forward.ForwardGameMultiReq parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.dj.protobuf.forward.ForwardGameMultiReq parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.forward.ForwardGameMultiReq parseFrom(
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
  public static Builder newBuilder(com.dj.protobuf.forward.ForwardGameMultiReq prototype) {
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
   * 向多人游戏转发
   * </pre>
   *
   * Protobuf type {@code Protocols.ForwardGameMultiReq}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:Protocols.ForwardGameMultiReq)
      com.dj.protobuf.forward.ForwardGameMultiReqOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.dj.protobuf.forward.Forward.internal_static_Protocols_ForwardGameMultiReq_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.dj.protobuf.forward.Forward.internal_static_Protocols_ForwardGameMultiReq_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.dj.protobuf.forward.ForwardGameMultiReq.class, com.dj.protobuf.forward.ForwardGameMultiReq.Builder.class);
    }

    // Construct using com.dj.protobuf.forward.ForwardGameMultiReq.newBuilder()
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
      reqClz_ = "";
      bitField0_ = (bitField0_ & ~0x00000002);
      req_ = com.google.protobuf.ByteString.EMPTY;
      bitField0_ = (bitField0_ & ~0x00000004);
      ps_ = "";
      bitField0_ = (bitField0_ & ~0x00000008);
      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.dj.protobuf.forward.Forward.internal_static_Protocols_ForwardGameMultiReq_descriptor;
    }

    public com.dj.protobuf.forward.ForwardGameMultiReq getDefaultInstanceForType() {
      return com.dj.protobuf.forward.ForwardGameMultiReq.getDefaultInstance();
    }

    public com.dj.protobuf.forward.ForwardGameMultiReq build() {
      com.dj.protobuf.forward.ForwardGameMultiReq result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public com.dj.protobuf.forward.ForwardGameMultiReq buildPartial() {
      com.dj.protobuf.forward.ForwardGameMultiReq result = new com.dj.protobuf.forward.ForwardGameMultiReq(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
        to_bitField0_ |= 0x00000001;
      }
      result.roleID_ = roleID_;
      if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
        to_bitField0_ |= 0x00000002;
      }
      result.reqClz_ = reqClz_;
      if (((from_bitField0_ & 0x00000004) == 0x00000004)) {
        to_bitField0_ |= 0x00000004;
      }
      result.req_ = req_;
      if (((from_bitField0_ & 0x00000008) == 0x00000008)) {
        to_bitField0_ |= 0x00000008;
      }
      result.ps_ = ps_;
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
      if (other instanceof com.dj.protobuf.forward.ForwardGameMultiReq) {
        return mergeFrom((com.dj.protobuf.forward.ForwardGameMultiReq)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.dj.protobuf.forward.ForwardGameMultiReq other) {
      if (other == com.dj.protobuf.forward.ForwardGameMultiReq.getDefaultInstance()) return this;
      if (other.hasRoleID()) {
        setRoleID(other.getRoleID());
      }
      if (other.hasReqClz()) {
        bitField0_ |= 0x00000002;
        reqClz_ = other.reqClz_;
        onChanged();
      }
      if (other.hasReq()) {
        setReq(other.getReq());
      }
      if (other.hasPs()) {
        bitField0_ |= 0x00000008;
        ps_ = other.ps_;
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
      com.dj.protobuf.forward.ForwardGameMultiReq parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.dj.protobuf.forward.ForwardGameMultiReq) e.getUnfinishedMessage();
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

    private java.lang.Object reqClz_ = "";
    /**
     * <code>optional string reqClz = 2;</code>
     */
    public boolean hasReqClz() {
      return ((bitField0_ & 0x00000002) == 0x00000002);
    }
    /**
     * <code>optional string reqClz = 2;</code>
     */
    public java.lang.String getReqClz() {
      java.lang.Object ref = reqClz_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        if (bs.isValidUtf8()) {
          reqClz_ = s;
        }
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>optional string reqClz = 2;</code>
     */
    public com.google.protobuf.ByteString
        getReqClzBytes() {
      java.lang.Object ref = reqClz_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        reqClz_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>optional string reqClz = 2;</code>
     */
    public Builder setReqClz(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000002;
      reqClz_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional string reqClz = 2;</code>
     */
    public Builder clearReqClz() {
      bitField0_ = (bitField0_ & ~0x00000002);
      reqClz_ = getDefaultInstance().getReqClz();
      onChanged();
      return this;
    }
    /**
     * <code>optional string reqClz = 2;</code>
     */
    public Builder setReqClzBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000002;
      reqClz_ = value;
      onChanged();
      return this;
    }

    private com.google.protobuf.ByteString req_ = com.google.protobuf.ByteString.EMPTY;
    /**
     * <code>optional bytes req = 3;</code>
     */
    public boolean hasReq() {
      return ((bitField0_ & 0x00000004) == 0x00000004);
    }
    /**
     * <code>optional bytes req = 3;</code>
     */
    public com.google.protobuf.ByteString getReq() {
      return req_;
    }
    /**
     * <code>optional bytes req = 3;</code>
     */
    public Builder setReq(com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000004;
      req_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional bytes req = 3;</code>
     */
    public Builder clearReq() {
      bitField0_ = (bitField0_ & ~0x00000004);
      req_ = getDefaultInstance().getReq();
      onChanged();
      return this;
    }

    private java.lang.Object ps_ = "";
    /**
     * <code>optional string ps = 4;</code>
     */
    public boolean hasPs() {
      return ((bitField0_ & 0x00000008) == 0x00000008);
    }
    /**
     * <code>optional string ps = 4;</code>
     */
    public java.lang.String getPs() {
      java.lang.Object ref = ps_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        if (bs.isValidUtf8()) {
          ps_ = s;
        }
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>optional string ps = 4;</code>
     */
    public com.google.protobuf.ByteString
        getPsBytes() {
      java.lang.Object ref = ps_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        ps_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>optional string ps = 4;</code>
     */
    public Builder setPs(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000008;
      ps_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional string ps = 4;</code>
     */
    public Builder clearPs() {
      bitField0_ = (bitField0_ & ~0x00000008);
      ps_ = getDefaultInstance().getPs();
      onChanged();
      return this;
    }
    /**
     * <code>optional string ps = 4;</code>
     */
    public Builder setPsBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000008;
      ps_ = value;
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


    // @@protoc_insertion_point(builder_scope:Protocols.ForwardGameMultiReq)
  }

  // @@protoc_insertion_point(class_scope:Protocols.ForwardGameMultiReq)
  private static final com.dj.protobuf.forward.ForwardGameMultiReq DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.dj.protobuf.forward.ForwardGameMultiReq();
  }

  public static com.dj.protobuf.forward.ForwardGameMultiReq getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  @java.lang.Deprecated public static final com.google.protobuf.Parser<ForwardGameMultiReq>
      PARSER = new com.google.protobuf.AbstractParser<ForwardGameMultiReq>() {
    public ForwardGameMultiReq parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new ForwardGameMultiReq(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<ForwardGameMultiReq> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<ForwardGameMultiReq> getParserForType() {
    return PARSER;
  }

  public com.dj.protobuf.forward.ForwardGameMultiReq getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

