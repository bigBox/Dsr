// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Outside.proto

package com.dj.protobuf.outside;

/**
 * Protobuf type {@code Protocols.OutsideGuideReq}
 */
public  final class OutsideGuideReq extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:Protocols.OutsideGuideReq)
    OutsideGuideReqOrBuilder {
  // Use OutsideGuideReq.newBuilder() to construct.
  private OutsideGuideReq(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private OutsideGuideReq() {
    eventId_ = 0;
    count_ = 0;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private OutsideGuideReq(
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
            eventId_ = input.readInt32();
            break;
          }
          case 16: {
            bitField0_ |= 0x00000002;
            count_ = input.readInt32();
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
    return com.dj.protobuf.outside.Outside.internal_static_Protocols_OutsideGuideReq_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.dj.protobuf.outside.Outside.internal_static_Protocols_OutsideGuideReq_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.dj.protobuf.outside.OutsideGuideReq.class, com.dj.protobuf.outside.OutsideGuideReq.Builder.class);
  }

  private int bitField0_;
  public static final int EVENTID_FIELD_NUMBER = 1;
  private int eventId_;
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / ??????id
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional int32 eventId = 1;</code>
   */
  public boolean hasEventId() {
    return ((bitField0_ & 0x00000001) == 0x00000001);
  }
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / ??????id
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional int32 eventId = 1;</code>
   */
  public int getEventId() {
    return eventId_;
  }

  public static final int COUNT_FIELD_NUMBER = 2;
  private int count_;
  /**
   * <code>optional int32 count = 2;</code>
   */
  public boolean hasCount() {
    return ((bitField0_ & 0x00000002) == 0x00000002);
  }
  /**
   * <code>optional int32 count = 2;</code>
   */
  public int getCount() {
    return count_;
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
      output.writeInt32(1, eventId_);
    }
    if (((bitField0_ & 0x00000002) == 0x00000002)) {
      output.writeInt32(2, count_);
    }
    unknownFields.writeTo(output);
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (((bitField0_ & 0x00000001) == 0x00000001)) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(1, eventId_);
    }
    if (((bitField0_ & 0x00000002) == 0x00000002)) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(2, count_);
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
    if (!(obj instanceof com.dj.protobuf.outside.OutsideGuideReq)) {
      return super.equals(obj);
    }
    com.dj.protobuf.outside.OutsideGuideReq other = (com.dj.protobuf.outside.OutsideGuideReq) obj;

    boolean result = true;
    result = result && (hasEventId() == other.hasEventId());
    if (hasEventId()) {
      result = result && (getEventId()
          == other.getEventId());
    }
    result = result && (hasCount() == other.hasCount());
    if (hasCount()) {
      result = result && (getCount()
          == other.getCount());
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
    if (hasEventId()) {
      hash = (37 * hash) + EVENTID_FIELD_NUMBER;
      hash = (53 * hash) + getEventId();
    }
    if (hasCount()) {
      hash = (37 * hash) + COUNT_FIELD_NUMBER;
      hash = (53 * hash) + getCount();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.dj.protobuf.outside.OutsideGuideReq parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dj.protobuf.outside.OutsideGuideReq parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dj.protobuf.outside.OutsideGuideReq parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dj.protobuf.outside.OutsideGuideReq parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dj.protobuf.outside.OutsideGuideReq parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.outside.OutsideGuideReq parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.dj.protobuf.outside.OutsideGuideReq parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.outside.OutsideGuideReq parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.dj.protobuf.outside.OutsideGuideReq parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.outside.OutsideGuideReq parseFrom(
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
  public static Builder newBuilder(com.dj.protobuf.outside.OutsideGuideReq prototype) {
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
   * Protobuf type {@code Protocols.OutsideGuideReq}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:Protocols.OutsideGuideReq)
      com.dj.protobuf.outside.OutsideGuideReqOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.dj.protobuf.outside.Outside.internal_static_Protocols_OutsideGuideReq_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.dj.protobuf.outside.Outside.internal_static_Protocols_OutsideGuideReq_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.dj.protobuf.outside.OutsideGuideReq.class, com.dj.protobuf.outside.OutsideGuideReq.Builder.class);
    }

    // Construct using com.dj.protobuf.outside.OutsideGuideReq.newBuilder()
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
      eventId_ = 0;
      bitField0_ = (bitField0_ & ~0x00000001);
      count_ = 0;
      bitField0_ = (bitField0_ & ~0x00000002);
      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.dj.protobuf.outside.Outside.internal_static_Protocols_OutsideGuideReq_descriptor;
    }

    public com.dj.protobuf.outside.OutsideGuideReq getDefaultInstanceForType() {
      return com.dj.protobuf.outside.OutsideGuideReq.getDefaultInstance();
    }

    public com.dj.protobuf.outside.OutsideGuideReq build() {
      com.dj.protobuf.outside.OutsideGuideReq result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public com.dj.protobuf.outside.OutsideGuideReq buildPartial() {
      com.dj.protobuf.outside.OutsideGuideReq result = new com.dj.protobuf.outside.OutsideGuideReq(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
        to_bitField0_ |= 0x00000001;
      }
      result.eventId_ = eventId_;
      if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
        to_bitField0_ |= 0x00000002;
      }
      result.count_ = count_;
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
      if (other instanceof com.dj.protobuf.outside.OutsideGuideReq) {
        return mergeFrom((com.dj.protobuf.outside.OutsideGuideReq)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.dj.protobuf.outside.OutsideGuideReq other) {
      if (other == com.dj.protobuf.outside.OutsideGuideReq.getDefaultInstance()) return this;
      if (other.hasEventId()) {
        setEventId(other.getEventId());
      }
      if (other.hasCount()) {
        setCount(other.getCount());
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
      com.dj.protobuf.outside.OutsideGuideReq parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.dj.protobuf.outside.OutsideGuideReq) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private int eventId_ ;
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / ??????id
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional int32 eventId = 1;</code>
     */
    public boolean hasEventId() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / ??????id
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional int32 eventId = 1;</code>
     */
    public int getEventId() {
      return eventId_;
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / ??????id
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional int32 eventId = 1;</code>
     */
    public Builder setEventId(int value) {
      bitField0_ |= 0x00000001;
      eventId_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / ??????id
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional int32 eventId = 1;</code>
     */
    public Builder clearEventId() {
      bitField0_ = (bitField0_ & ~0x00000001);
      eventId_ = 0;
      onChanged();
      return this;
    }

    private int count_ ;
    /**
     * <code>optional int32 count = 2;</code>
     */
    public boolean hasCount() {
      return ((bitField0_ & 0x00000002) == 0x00000002);
    }
    /**
     * <code>optional int32 count = 2;</code>
     */
    public int getCount() {
      return count_;
    }
    /**
     * <code>optional int32 count = 2;</code>
     */
    public Builder setCount(int value) {
      bitField0_ |= 0x00000002;
      count_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional int32 count = 2;</code>
     */
    public Builder clearCount() {
      bitField0_ = (bitField0_ & ~0x00000002);
      count_ = 0;
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


    // @@protoc_insertion_point(builder_scope:Protocols.OutsideGuideReq)
  }

  // @@protoc_insertion_point(class_scope:Protocols.OutsideGuideReq)
  private static final com.dj.protobuf.outside.OutsideGuideReq DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.dj.protobuf.outside.OutsideGuideReq();
  }

  public static com.dj.protobuf.outside.OutsideGuideReq getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  @java.lang.Deprecated public static final com.google.protobuf.Parser<OutsideGuideReq>
      PARSER = new com.google.protobuf.AbstractParser<OutsideGuideReq>() {
    public OutsideGuideReq parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new OutsideGuideReq(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<OutsideGuideReq> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<OutsideGuideReq> getParserForType() {
    return PARSER;
  }

  public com.dj.protobuf.outside.OutsideGuideReq getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

