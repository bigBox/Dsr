// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Scene.proto

package com.dj.protobuf.scene;

/**
 * Protobuf type {@code Protocols.ScenePosUpdateReq}
 */
public  final class ScenePosUpdateReq extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:Protocols.ScenePosUpdateReq)
    ScenePosUpdateReqOrBuilder {
  // Use ScenePosUpdateReq.newBuilder() to construct.
  private ScenePosUpdateReq(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private ScenePosUpdateReq() {
    id_ = 0;
    x_ = 0;
    y_ = 0;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private ScenePosUpdateReq(
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
            id_ = input.readInt32();
            break;
          }
          case 16: {
            bitField0_ |= 0x00000002;
            x_ = input.readInt32();
            break;
          }
          case 24: {
            bitField0_ |= 0x00000004;
            y_ = input.readInt32();
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
    return com.dj.protobuf.scene.Scene.internal_static_Protocols_ScenePosUpdateReq_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.dj.protobuf.scene.Scene.internal_static_Protocols_ScenePosUpdateReq_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.dj.protobuf.scene.ScenePosUpdateReq.class, com.dj.protobuf.scene.ScenePosUpdateReq.Builder.class);
  }

  private int bitField0_;
  public static final int ID_FIELD_NUMBER = 1;
  private int id_;
  /**
   * <code>optional int32 id = 1;</code>
   */
  public boolean hasId() {
    return ((bitField0_ & 0x00000001) == 0x00000001);
  }
  /**
   * <code>optional int32 id = 1;</code>
   */
  public int getId() {
    return id_;
  }

  public static final int X_FIELD_NUMBER = 2;
  private int x_;
  /**
   * <code>optional int32 x = 2;</code>
   */
  public boolean hasX() {
    return ((bitField0_ & 0x00000002) == 0x00000002);
  }
  /**
   * <code>optional int32 x = 2;</code>
   */
  public int getX() {
    return x_;
  }

  public static final int Y_FIELD_NUMBER = 3;
  private int y_;
  /**
   * <code>optional int32 y = 3;</code>
   */
  public boolean hasY() {
    return ((bitField0_ & 0x00000004) == 0x00000004);
  }
  /**
   * <code>optional int32 y = 3;</code>
   */
  public int getY() {
    return y_;
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
      output.writeInt32(1, id_);
    }
    if (((bitField0_ & 0x00000002) == 0x00000002)) {
      output.writeInt32(2, x_);
    }
    if (((bitField0_ & 0x00000004) == 0x00000004)) {
      output.writeInt32(3, y_);
    }
    unknownFields.writeTo(output);
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (((bitField0_ & 0x00000001) == 0x00000001)) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(1, id_);
    }
    if (((bitField0_ & 0x00000002) == 0x00000002)) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(2, x_);
    }
    if (((bitField0_ & 0x00000004) == 0x00000004)) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(3, y_);
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
    if (!(obj instanceof com.dj.protobuf.scene.ScenePosUpdateReq)) {
      return super.equals(obj);
    }
    com.dj.protobuf.scene.ScenePosUpdateReq other = (com.dj.protobuf.scene.ScenePosUpdateReq) obj;

    boolean result = true;
    result = result && (hasId() == other.hasId());
    if (hasId()) {
      result = result && (getId()
          == other.getId());
    }
    result = result && (hasX() == other.hasX());
    if (hasX()) {
      result = result && (getX()
          == other.getX());
    }
    result = result && (hasY() == other.hasY());
    if (hasY()) {
      result = result && (getY()
          == other.getY());
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
    if (hasId()) {
      hash = (37 * hash) + ID_FIELD_NUMBER;
      hash = (53 * hash) + getId();
    }
    if (hasX()) {
      hash = (37 * hash) + X_FIELD_NUMBER;
      hash = (53 * hash) + getX();
    }
    if (hasY()) {
      hash = (37 * hash) + Y_FIELD_NUMBER;
      hash = (53 * hash) + getY();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.dj.protobuf.scene.ScenePosUpdateReq parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dj.protobuf.scene.ScenePosUpdateReq parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dj.protobuf.scene.ScenePosUpdateReq parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dj.protobuf.scene.ScenePosUpdateReq parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dj.protobuf.scene.ScenePosUpdateReq parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.scene.ScenePosUpdateReq parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.dj.protobuf.scene.ScenePosUpdateReq parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.scene.ScenePosUpdateReq parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.dj.protobuf.scene.ScenePosUpdateReq parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.scene.ScenePosUpdateReq parseFrom(
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
  public static Builder newBuilder(com.dj.protobuf.scene.ScenePosUpdateReq prototype) {
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
   * Protobuf type {@code Protocols.ScenePosUpdateReq}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:Protocols.ScenePosUpdateReq)
      com.dj.protobuf.scene.ScenePosUpdateReqOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.dj.protobuf.scene.Scene.internal_static_Protocols_ScenePosUpdateReq_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.dj.protobuf.scene.Scene.internal_static_Protocols_ScenePosUpdateReq_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.dj.protobuf.scene.ScenePosUpdateReq.class, com.dj.protobuf.scene.ScenePosUpdateReq.Builder.class);
    }

    // Construct using com.dj.protobuf.scene.ScenePosUpdateReq.newBuilder()
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
      id_ = 0;
      bitField0_ = (bitField0_ & ~0x00000001);
      x_ = 0;
      bitField0_ = (bitField0_ & ~0x00000002);
      y_ = 0;
      bitField0_ = (bitField0_ & ~0x00000004);
      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.dj.protobuf.scene.Scene.internal_static_Protocols_ScenePosUpdateReq_descriptor;
    }

    public com.dj.protobuf.scene.ScenePosUpdateReq getDefaultInstanceForType() {
      return com.dj.protobuf.scene.ScenePosUpdateReq.getDefaultInstance();
    }

    public com.dj.protobuf.scene.ScenePosUpdateReq build() {
      com.dj.protobuf.scene.ScenePosUpdateReq result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public com.dj.protobuf.scene.ScenePosUpdateReq buildPartial() {
      com.dj.protobuf.scene.ScenePosUpdateReq result = new com.dj.protobuf.scene.ScenePosUpdateReq(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
        to_bitField0_ |= 0x00000001;
      }
      result.id_ = id_;
      if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
        to_bitField0_ |= 0x00000002;
      }
      result.x_ = x_;
      if (((from_bitField0_ & 0x00000004) == 0x00000004)) {
        to_bitField0_ |= 0x00000004;
      }
      result.y_ = y_;
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
      if (other instanceof com.dj.protobuf.scene.ScenePosUpdateReq) {
        return mergeFrom((com.dj.protobuf.scene.ScenePosUpdateReq)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.dj.protobuf.scene.ScenePosUpdateReq other) {
      if (other == com.dj.protobuf.scene.ScenePosUpdateReq.getDefaultInstance()) return this;
      if (other.hasId()) {
        setId(other.getId());
      }
      if (other.hasX()) {
        setX(other.getX());
      }
      if (other.hasY()) {
        setY(other.getY());
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
      com.dj.protobuf.scene.ScenePosUpdateReq parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.dj.protobuf.scene.ScenePosUpdateReq) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private int id_ ;
    /**
     * <code>optional int32 id = 1;</code>
     */
    public boolean hasId() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <code>optional int32 id = 1;</code>
     */
    public int getId() {
      return id_;
    }
    /**
     * <code>optional int32 id = 1;</code>
     */
    public Builder setId(int value) {
      bitField0_ |= 0x00000001;
      id_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional int32 id = 1;</code>
     */
    public Builder clearId() {
      bitField0_ = (bitField0_ & ~0x00000001);
      id_ = 0;
      onChanged();
      return this;
    }

    private int x_ ;
    /**
     * <code>optional int32 x = 2;</code>
     */
    public boolean hasX() {
      return ((bitField0_ & 0x00000002) == 0x00000002);
    }
    /**
     * <code>optional int32 x = 2;</code>
     */
    public int getX() {
      return x_;
    }
    /**
     * <code>optional int32 x = 2;</code>
     */
    public Builder setX(int value) {
      bitField0_ |= 0x00000002;
      x_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional int32 x = 2;</code>
     */
    public Builder clearX() {
      bitField0_ = (bitField0_ & ~0x00000002);
      x_ = 0;
      onChanged();
      return this;
    }

    private int y_ ;
    /**
     * <code>optional int32 y = 3;</code>
     */
    public boolean hasY() {
      return ((bitField0_ & 0x00000004) == 0x00000004);
    }
    /**
     * <code>optional int32 y = 3;</code>
     */
    public int getY() {
      return y_;
    }
    /**
     * <code>optional int32 y = 3;</code>
     */
    public Builder setY(int value) {
      bitField0_ |= 0x00000004;
      y_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional int32 y = 3;</code>
     */
    public Builder clearY() {
      bitField0_ = (bitField0_ & ~0x00000004);
      y_ = 0;
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


    // @@protoc_insertion_point(builder_scope:Protocols.ScenePosUpdateReq)
  }

  // @@protoc_insertion_point(class_scope:Protocols.ScenePosUpdateReq)
  private static final com.dj.protobuf.scene.ScenePosUpdateReq DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.dj.protobuf.scene.ScenePosUpdateReq();
  }

  public static com.dj.protobuf.scene.ScenePosUpdateReq getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  @java.lang.Deprecated public static final com.google.protobuf.Parser<ScenePosUpdateReq>
      PARSER = new com.google.protobuf.AbstractParser<ScenePosUpdateReq>() {
    public ScenePosUpdateReq parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new ScenePosUpdateReq(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<ScenePosUpdateReq> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<ScenePosUpdateReq> getParserForType() {
    return PARSER;
  }

  public com.dj.protobuf.scene.ScenePosUpdateReq getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

