// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Scene.proto

package com.dj.protobuf.scene;

/**
 * Protobuf type {@code Protocols.LeaveSceneNtf}
 */
public  final class LeaveSceneNtf extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:Protocols.LeaveSceneNtf)
    LeaveSceneNtfOrBuilder {
  // Use LeaveSceneNtf.newBuilder() to construct.
  private LeaveSceneNtf(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private LeaveSceneNtf() {
    roleId_ = 0L;
    sceneId_ = 0L;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private LeaveSceneNtf(
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
            roleId_ = input.readUInt64();
            break;
          }
          case 16: {
            bitField0_ |= 0x00000002;
            sceneId_ = input.readUInt64();
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
    return com.dj.protobuf.scene.Scene.internal_static_Protocols_LeaveSceneNtf_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.dj.protobuf.scene.Scene.internal_static_Protocols_LeaveSceneNtf_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.dj.protobuf.scene.LeaveSceneNtf.class, com.dj.protobuf.scene.LeaveSceneNtf.Builder.class);
  }

  private int bitField0_;
  public static final int ROLEID_FIELD_NUMBER = 1;
  private long roleId_;
  /**
   * <code>optional uint64 roleId = 1;</code>
   */
  public boolean hasRoleId() {
    return ((bitField0_ & 0x00000001) == 0x00000001);
  }
  /**
   * <code>optional uint64 roleId = 1;</code>
   */
  public long getRoleId() {
    return roleId_;
  }

  public static final int SCENEID_FIELD_NUMBER = 2;
  private long sceneId_;
  /**
   * <code>optional uint64 sceneId = 2;</code>
   */
  public boolean hasSceneId() {
    return ((bitField0_ & 0x00000002) == 0x00000002);
  }
  /**
   * <code>optional uint64 sceneId = 2;</code>
   */
  public long getSceneId() {
    return sceneId_;
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
      output.writeUInt64(1, roleId_);
    }
    if (((bitField0_ & 0x00000002) == 0x00000002)) {
      output.writeUInt64(2, sceneId_);
    }
    unknownFields.writeTo(output);
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (((bitField0_ & 0x00000001) == 0x00000001)) {
      size += com.google.protobuf.CodedOutputStream
        .computeUInt64Size(1, roleId_);
    }
    if (((bitField0_ & 0x00000002) == 0x00000002)) {
      size += com.google.protobuf.CodedOutputStream
        .computeUInt64Size(2, sceneId_);
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
    if (!(obj instanceof com.dj.protobuf.scene.LeaveSceneNtf)) {
      return super.equals(obj);
    }
    com.dj.protobuf.scene.LeaveSceneNtf other = (com.dj.protobuf.scene.LeaveSceneNtf) obj;

    boolean result = true;
    result = result && (hasRoleId() == other.hasRoleId());
    if (hasRoleId()) {
      result = result && (getRoleId()
          == other.getRoleId());
    }
    result = result && (hasSceneId() == other.hasSceneId());
    if (hasSceneId()) {
      result = result && (getSceneId()
          == other.getSceneId());
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
    if (hasRoleId()) {
      hash = (37 * hash) + ROLEID_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
          getRoleId());
    }
    if (hasSceneId()) {
      hash = (37 * hash) + SCENEID_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
          getSceneId());
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.dj.protobuf.scene.LeaveSceneNtf parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dj.protobuf.scene.LeaveSceneNtf parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dj.protobuf.scene.LeaveSceneNtf parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dj.protobuf.scene.LeaveSceneNtf parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dj.protobuf.scene.LeaveSceneNtf parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.scene.LeaveSceneNtf parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.dj.protobuf.scene.LeaveSceneNtf parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.scene.LeaveSceneNtf parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.dj.protobuf.scene.LeaveSceneNtf parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.scene.LeaveSceneNtf parseFrom(
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
  public static Builder newBuilder(com.dj.protobuf.scene.LeaveSceneNtf prototype) {
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
   * Protobuf type {@code Protocols.LeaveSceneNtf}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:Protocols.LeaveSceneNtf)
      com.dj.protobuf.scene.LeaveSceneNtfOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.dj.protobuf.scene.Scene.internal_static_Protocols_LeaveSceneNtf_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.dj.protobuf.scene.Scene.internal_static_Protocols_LeaveSceneNtf_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.dj.protobuf.scene.LeaveSceneNtf.class, com.dj.protobuf.scene.LeaveSceneNtf.Builder.class);
    }

    // Construct using com.dj.protobuf.scene.LeaveSceneNtf.newBuilder()
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
      roleId_ = 0L;
      bitField0_ = (bitField0_ & ~0x00000001);
      sceneId_ = 0L;
      bitField0_ = (bitField0_ & ~0x00000002);
      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.dj.protobuf.scene.Scene.internal_static_Protocols_LeaveSceneNtf_descriptor;
    }

    public com.dj.protobuf.scene.LeaveSceneNtf getDefaultInstanceForType() {
      return com.dj.protobuf.scene.LeaveSceneNtf.getDefaultInstance();
    }

    public com.dj.protobuf.scene.LeaveSceneNtf build() {
      com.dj.protobuf.scene.LeaveSceneNtf result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public com.dj.protobuf.scene.LeaveSceneNtf buildPartial() {
      com.dj.protobuf.scene.LeaveSceneNtf result = new com.dj.protobuf.scene.LeaveSceneNtf(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
        to_bitField0_ |= 0x00000001;
      }
      result.roleId_ = roleId_;
      if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
        to_bitField0_ |= 0x00000002;
      }
      result.sceneId_ = sceneId_;
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
      if (other instanceof com.dj.protobuf.scene.LeaveSceneNtf) {
        return mergeFrom((com.dj.protobuf.scene.LeaveSceneNtf)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.dj.protobuf.scene.LeaveSceneNtf other) {
      if (other == com.dj.protobuf.scene.LeaveSceneNtf.getDefaultInstance()) return this;
      if (other.hasRoleId()) {
        setRoleId(other.getRoleId());
      }
      if (other.hasSceneId()) {
        setSceneId(other.getSceneId());
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
      com.dj.protobuf.scene.LeaveSceneNtf parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.dj.protobuf.scene.LeaveSceneNtf) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private long roleId_ ;
    /**
     * <code>optional uint64 roleId = 1;</code>
     */
    public boolean hasRoleId() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <code>optional uint64 roleId = 1;</code>
     */
    public long getRoleId() {
      return roleId_;
    }
    /**
     * <code>optional uint64 roleId = 1;</code>
     */
    public Builder setRoleId(long value) {
      bitField0_ |= 0x00000001;
      roleId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional uint64 roleId = 1;</code>
     */
    public Builder clearRoleId() {
      bitField0_ = (bitField0_ & ~0x00000001);
      roleId_ = 0L;
      onChanged();
      return this;
    }

    private long sceneId_ ;
    /**
     * <code>optional uint64 sceneId = 2;</code>
     */
    public boolean hasSceneId() {
      return ((bitField0_ & 0x00000002) == 0x00000002);
    }
    /**
     * <code>optional uint64 sceneId = 2;</code>
     */
    public long getSceneId() {
      return sceneId_;
    }
    /**
     * <code>optional uint64 sceneId = 2;</code>
     */
    public Builder setSceneId(long value) {
      bitField0_ |= 0x00000002;
      sceneId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional uint64 sceneId = 2;</code>
     */
    public Builder clearSceneId() {
      bitField0_ = (bitField0_ & ~0x00000002);
      sceneId_ = 0L;
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


    // @@protoc_insertion_point(builder_scope:Protocols.LeaveSceneNtf)
  }

  // @@protoc_insertion_point(class_scope:Protocols.LeaveSceneNtf)
  private static final com.dj.protobuf.scene.LeaveSceneNtf DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.dj.protobuf.scene.LeaveSceneNtf();
  }

  public static com.dj.protobuf.scene.LeaveSceneNtf getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  @java.lang.Deprecated public static final com.google.protobuf.Parser<LeaveSceneNtf>
      PARSER = new com.google.protobuf.AbstractParser<LeaveSceneNtf>() {
    public LeaveSceneNtf parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new LeaveSceneNtf(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<LeaveSceneNtf> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<LeaveSceneNtf> getParserForType() {
    return PARSER;
  }

  public com.dj.protobuf.scene.LeaveSceneNtf getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
