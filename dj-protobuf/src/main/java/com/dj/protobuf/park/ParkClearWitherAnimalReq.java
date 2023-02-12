// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Park.proto

package com.dj.protobuf.park;

/**
 * <pre>
 *&#47; &lt;summary&gt;
 * / 清除枯萎动物
 * / &lt;/summary&gt;
 * </pre>
 *
 * Protobuf type {@code Protocols.ParkClearWitherAnimalReq}
 */
public  final class ParkClearWitherAnimalReq extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:Protocols.ParkClearWitherAnimalReq)
    ParkClearWitherAnimalReqOrBuilder {
  // Use ParkClearWitherAnimalReq.newBuilder() to construct.
  private ParkClearWitherAnimalReq(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private ParkClearWitherAnimalReq() {
    animalTimeIDs_ = com.google.protobuf.LazyStringArrayList.EMPTY;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private ParkClearWitherAnimalReq(
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
            if (!((mutable_bitField0_ & 0x00000001) == 0x00000001)) {
              animalTimeIDs_ = new com.google.protobuf.LazyStringArrayList();
              mutable_bitField0_ |= 0x00000001;
            }
            animalTimeIDs_.add(bs);
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
      if (((mutable_bitField0_ & 0x00000001) == 0x00000001)) {
        animalTimeIDs_ = animalTimeIDs_.getUnmodifiableView();
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.dj.protobuf.park.Park.internal_static_Protocols_ParkClearWitherAnimalReq_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.dj.protobuf.park.Park.internal_static_Protocols_ParkClearWitherAnimalReq_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.dj.protobuf.park.ParkClearWitherAnimalReq.class, com.dj.protobuf.park.ParkClearWitherAnimalReq.Builder.class);
  }

  public static final int ANIMALTIMEIDS_FIELD_NUMBER = 1;
  private com.google.protobuf.LazyStringList animalTimeIDs_;
  /**
   * <code>repeated string animalTimeIDs = 1;</code>
   */
  public com.google.protobuf.ProtocolStringList
      getAnimalTimeIDsList() {
    return animalTimeIDs_;
  }
  /**
   * <code>repeated string animalTimeIDs = 1;</code>
   */
  public int getAnimalTimeIDsCount() {
    return animalTimeIDs_.size();
  }
  /**
   * <code>repeated string animalTimeIDs = 1;</code>
   */
  public java.lang.String getAnimalTimeIDs(int index) {
    return animalTimeIDs_.get(index);
  }
  /**
   * <code>repeated string animalTimeIDs = 1;</code>
   */
  public com.google.protobuf.ByteString
      getAnimalTimeIDsBytes(int index) {
    return animalTimeIDs_.getByteString(index);
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
    for (int i = 0; i < animalTimeIDs_.size(); i++) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, animalTimeIDs_.getRaw(i));
    }
    unknownFields.writeTo(output);
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    {
      int dataSize = 0;
      for (int i = 0; i < animalTimeIDs_.size(); i++) {
        dataSize += computeStringSizeNoTag(animalTimeIDs_.getRaw(i));
      }
      size += dataSize;
      size += 1 * getAnimalTimeIDsList().size();
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
    if (!(obj instanceof com.dj.protobuf.park.ParkClearWitherAnimalReq)) {
      return super.equals(obj);
    }
    com.dj.protobuf.park.ParkClearWitherAnimalReq other = (com.dj.protobuf.park.ParkClearWitherAnimalReq) obj;

    boolean result = true;
    result = result && getAnimalTimeIDsList()
        .equals(other.getAnimalTimeIDsList());
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
    if (getAnimalTimeIDsCount() > 0) {
      hash = (37 * hash) + ANIMALTIMEIDS_FIELD_NUMBER;
      hash = (53 * hash) + getAnimalTimeIDsList().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.dj.protobuf.park.ParkClearWitherAnimalReq parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dj.protobuf.park.ParkClearWitherAnimalReq parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dj.protobuf.park.ParkClearWitherAnimalReq parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dj.protobuf.park.ParkClearWitherAnimalReq parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dj.protobuf.park.ParkClearWitherAnimalReq parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.park.ParkClearWitherAnimalReq parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.dj.protobuf.park.ParkClearWitherAnimalReq parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.park.ParkClearWitherAnimalReq parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.dj.protobuf.park.ParkClearWitherAnimalReq parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.park.ParkClearWitherAnimalReq parseFrom(
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
  public static Builder newBuilder(com.dj.protobuf.park.ParkClearWitherAnimalReq prototype) {
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
   * / 清除枯萎动物
   * / &lt;/summary&gt;
   * </pre>
   *
   * Protobuf type {@code Protocols.ParkClearWitherAnimalReq}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:Protocols.ParkClearWitherAnimalReq)
      com.dj.protobuf.park.ParkClearWitherAnimalReqOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.dj.protobuf.park.Park.internal_static_Protocols_ParkClearWitherAnimalReq_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.dj.protobuf.park.Park.internal_static_Protocols_ParkClearWitherAnimalReq_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.dj.protobuf.park.ParkClearWitherAnimalReq.class, com.dj.protobuf.park.ParkClearWitherAnimalReq.Builder.class);
    }

    // Construct using com.dj.protobuf.park.ParkClearWitherAnimalReq.newBuilder()
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
      animalTimeIDs_ = com.google.protobuf.LazyStringArrayList.EMPTY;
      bitField0_ = (bitField0_ & ~0x00000001);
      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.dj.protobuf.park.Park.internal_static_Protocols_ParkClearWitherAnimalReq_descriptor;
    }

    public com.dj.protobuf.park.ParkClearWitherAnimalReq getDefaultInstanceForType() {
      return com.dj.protobuf.park.ParkClearWitherAnimalReq.getDefaultInstance();
    }

    public com.dj.protobuf.park.ParkClearWitherAnimalReq build() {
      com.dj.protobuf.park.ParkClearWitherAnimalReq result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public com.dj.protobuf.park.ParkClearWitherAnimalReq buildPartial() {
      com.dj.protobuf.park.ParkClearWitherAnimalReq result = new com.dj.protobuf.park.ParkClearWitherAnimalReq(this);
      int from_bitField0_ = bitField0_;
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        animalTimeIDs_ = animalTimeIDs_.getUnmodifiableView();
        bitField0_ = (bitField0_ & ~0x00000001);
      }
      result.animalTimeIDs_ = animalTimeIDs_;
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
      if (other instanceof com.dj.protobuf.park.ParkClearWitherAnimalReq) {
        return mergeFrom((com.dj.protobuf.park.ParkClearWitherAnimalReq)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.dj.protobuf.park.ParkClearWitherAnimalReq other) {
      if (other == com.dj.protobuf.park.ParkClearWitherAnimalReq.getDefaultInstance()) return this;
      if (!other.animalTimeIDs_.isEmpty()) {
        if (animalTimeIDs_.isEmpty()) {
          animalTimeIDs_ = other.animalTimeIDs_;
          bitField0_ = (bitField0_ & ~0x00000001);
        } else {
          ensureAnimalTimeIDsIsMutable();
          animalTimeIDs_.addAll(other.animalTimeIDs_);
        }
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
      com.dj.protobuf.park.ParkClearWitherAnimalReq parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.dj.protobuf.park.ParkClearWitherAnimalReq) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private com.google.protobuf.LazyStringList animalTimeIDs_ = com.google.protobuf.LazyStringArrayList.EMPTY;
    private void ensureAnimalTimeIDsIsMutable() {
      if (!((bitField0_ & 0x00000001) == 0x00000001)) {
        animalTimeIDs_ = new com.google.protobuf.LazyStringArrayList(animalTimeIDs_);
        bitField0_ |= 0x00000001;
       }
    }
    /**
     * <code>repeated string animalTimeIDs = 1;</code>
     */
    public com.google.protobuf.ProtocolStringList
        getAnimalTimeIDsList() {
      return animalTimeIDs_.getUnmodifiableView();
    }
    /**
     * <code>repeated string animalTimeIDs = 1;</code>
     */
    public int getAnimalTimeIDsCount() {
      return animalTimeIDs_.size();
    }
    /**
     * <code>repeated string animalTimeIDs = 1;</code>
     */
    public java.lang.String getAnimalTimeIDs(int index) {
      return animalTimeIDs_.get(index);
    }
    /**
     * <code>repeated string animalTimeIDs = 1;</code>
     */
    public com.google.protobuf.ByteString
        getAnimalTimeIDsBytes(int index) {
      return animalTimeIDs_.getByteString(index);
    }
    /**
     * <code>repeated string animalTimeIDs = 1;</code>
     */
    public Builder setAnimalTimeIDs(
        int index, java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  ensureAnimalTimeIDsIsMutable();
      animalTimeIDs_.set(index, value);
      onChanged();
      return this;
    }
    /**
     * <code>repeated string animalTimeIDs = 1;</code>
     */
    public Builder addAnimalTimeIDs(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  ensureAnimalTimeIDsIsMutable();
      animalTimeIDs_.add(value);
      onChanged();
      return this;
    }
    /**
     * <code>repeated string animalTimeIDs = 1;</code>
     */
    public Builder addAllAnimalTimeIDs(
        java.lang.Iterable<java.lang.String> values) {
      ensureAnimalTimeIDsIsMutable();
      com.google.protobuf.AbstractMessageLite.Builder.addAll(
          values, animalTimeIDs_);
      onChanged();
      return this;
    }
    /**
     * <code>repeated string animalTimeIDs = 1;</code>
     */
    public Builder clearAnimalTimeIDs() {
      animalTimeIDs_ = com.google.protobuf.LazyStringArrayList.EMPTY;
      bitField0_ = (bitField0_ & ~0x00000001);
      onChanged();
      return this;
    }
    /**
     * <code>repeated string animalTimeIDs = 1;</code>
     */
    public Builder addAnimalTimeIDsBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  ensureAnimalTimeIDsIsMutable();
      animalTimeIDs_.add(value);
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


    // @@protoc_insertion_point(builder_scope:Protocols.ParkClearWitherAnimalReq)
  }

  // @@protoc_insertion_point(class_scope:Protocols.ParkClearWitherAnimalReq)
  private static final com.dj.protobuf.park.ParkClearWitherAnimalReq DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.dj.protobuf.park.ParkClearWitherAnimalReq();
  }

  public static com.dj.protobuf.park.ParkClearWitherAnimalReq getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  @java.lang.Deprecated public static final com.google.protobuf.Parser<ParkClearWitherAnimalReq>
      PARSER = new com.google.protobuf.AbstractParser<ParkClearWitherAnimalReq>() {
    public ParkClearWitherAnimalReq parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new ParkClearWitherAnimalReq(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<ParkClearWitherAnimalReq> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<ParkClearWitherAnimalReq> getParserForType() {
    return PARSER;
  }

  public com.dj.protobuf.park.ParkClearWitherAnimalReq getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

