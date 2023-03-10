// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Verify.proto

package com.dj.protobuf.verify;

/**
 * <pre>
 *&#47; &lt;summary&gt;
 * / 使用鉴定卡鉴定
 * / &lt;/summary&gt;
 * </pre>
 *
 * Protobuf type {@code Protocols.VerifyUseCardReq}
 */
public  final class VerifyUseCardReq extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:Protocols.VerifyUseCardReq)
    VerifyUseCardReqOrBuilder {
  // Use VerifyUseCardReq.newBuilder() to construct.
  private VerifyUseCardReq(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private VerifyUseCardReq() {
    index_ = 0;
    cardID_ = 0;
    cardCount_ = 0;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private VerifyUseCardReq(
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
            index_ = input.readUInt32();
            break;
          }
          case 16: {
            bitField0_ |= 0x00000002;
            cardID_ = input.readUInt32();
            break;
          }
          case 24: {
            bitField0_ |= 0x00000004;
            cardCount_ = input.readUInt32();
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
    return com.dj.protobuf.verify.Verify.internal_static_Protocols_VerifyUseCardReq_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.dj.protobuf.verify.Verify.internal_static_Protocols_VerifyUseCardReq_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.dj.protobuf.verify.VerifyUseCardReq.class, com.dj.protobuf.verify.VerifyUseCardReq.Builder.class);
  }

  private int bitField0_;
  public static final int INDEX_FIELD_NUMBER = 1;
  private int index_;
  /**
   * <code>optional uint32 index = 1;</code>
   */
  public boolean hasIndex() {
    return ((bitField0_ & 0x00000001) == 0x00000001);
  }
  /**
   * <code>optional uint32 index = 1;</code>
   */
  public int getIndex() {
    return index_;
  }

  public static final int CARDID_FIELD_NUMBER = 2;
  private int cardID_;
  /**
   * <pre>
   * 鉴定卡id
   * </pre>
   *
   * <code>optional uint32 cardID = 2;</code>
   */
  public boolean hasCardID() {
    return ((bitField0_ & 0x00000002) == 0x00000002);
  }
  /**
   * <pre>
   * 鉴定卡id
   * </pre>
   *
   * <code>optional uint32 cardID = 2;</code>
   */
  public int getCardID() {
    return cardID_;
  }

  public static final int CARDCOUNT_FIELD_NUMBER = 3;
  private int cardCount_;
  /**
   * <pre>
   * 鉴定卡数量
   * </pre>
   *
   * <code>optional uint32 cardCount = 3;</code>
   */
  public boolean hasCardCount() {
    return ((bitField0_ & 0x00000004) == 0x00000004);
  }
  /**
   * <pre>
   * 鉴定卡数量
   * </pre>
   *
   * <code>optional uint32 cardCount = 3;</code>
   */
  public int getCardCount() {
    return cardCount_;
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
      output.writeUInt32(1, index_);
    }
    if (((bitField0_ & 0x00000002) == 0x00000002)) {
      output.writeUInt32(2, cardID_);
    }
    if (((bitField0_ & 0x00000004) == 0x00000004)) {
      output.writeUInt32(3, cardCount_);
    }
    unknownFields.writeTo(output);
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (((bitField0_ & 0x00000001) == 0x00000001)) {
      size += com.google.protobuf.CodedOutputStream
        .computeUInt32Size(1, index_);
    }
    if (((bitField0_ & 0x00000002) == 0x00000002)) {
      size += com.google.protobuf.CodedOutputStream
        .computeUInt32Size(2, cardID_);
    }
    if (((bitField0_ & 0x00000004) == 0x00000004)) {
      size += com.google.protobuf.CodedOutputStream
        .computeUInt32Size(3, cardCount_);
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
    if (!(obj instanceof com.dj.protobuf.verify.VerifyUseCardReq)) {
      return super.equals(obj);
    }
    com.dj.protobuf.verify.VerifyUseCardReq other = (com.dj.protobuf.verify.VerifyUseCardReq) obj;

    boolean result = true;
    result = result && (hasIndex() == other.hasIndex());
    if (hasIndex()) {
      result = result && (getIndex()
          == other.getIndex());
    }
    result = result && (hasCardID() == other.hasCardID());
    if (hasCardID()) {
      result = result && (getCardID()
          == other.getCardID());
    }
    result = result && (hasCardCount() == other.hasCardCount());
    if (hasCardCount()) {
      result = result && (getCardCount()
          == other.getCardCount());
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
    if (hasIndex()) {
      hash = (37 * hash) + INDEX_FIELD_NUMBER;
      hash = (53 * hash) + getIndex();
    }
    if (hasCardID()) {
      hash = (37 * hash) + CARDID_FIELD_NUMBER;
      hash = (53 * hash) + getCardID();
    }
    if (hasCardCount()) {
      hash = (37 * hash) + CARDCOUNT_FIELD_NUMBER;
      hash = (53 * hash) + getCardCount();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.dj.protobuf.verify.VerifyUseCardReq parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dj.protobuf.verify.VerifyUseCardReq parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dj.protobuf.verify.VerifyUseCardReq parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dj.protobuf.verify.VerifyUseCardReq parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dj.protobuf.verify.VerifyUseCardReq parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.verify.VerifyUseCardReq parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.dj.protobuf.verify.VerifyUseCardReq parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.verify.VerifyUseCardReq parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.dj.protobuf.verify.VerifyUseCardReq parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.verify.VerifyUseCardReq parseFrom(
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
  public static Builder newBuilder(com.dj.protobuf.verify.VerifyUseCardReq prototype) {
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
   * / 使用鉴定卡鉴定
   * / &lt;/summary&gt;
   * </pre>
   *
   * Protobuf type {@code Protocols.VerifyUseCardReq}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:Protocols.VerifyUseCardReq)
      com.dj.protobuf.verify.VerifyUseCardReqOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.dj.protobuf.verify.Verify.internal_static_Protocols_VerifyUseCardReq_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.dj.protobuf.verify.Verify.internal_static_Protocols_VerifyUseCardReq_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.dj.protobuf.verify.VerifyUseCardReq.class, com.dj.protobuf.verify.VerifyUseCardReq.Builder.class);
    }

    // Construct using com.dj.protobuf.verify.VerifyUseCardReq.newBuilder()
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
      index_ = 0;
      bitField0_ = (bitField0_ & ~0x00000001);
      cardID_ = 0;
      bitField0_ = (bitField0_ & ~0x00000002);
      cardCount_ = 0;
      bitField0_ = (bitField0_ & ~0x00000004);
      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.dj.protobuf.verify.Verify.internal_static_Protocols_VerifyUseCardReq_descriptor;
    }

    public com.dj.protobuf.verify.VerifyUseCardReq getDefaultInstanceForType() {
      return com.dj.protobuf.verify.VerifyUseCardReq.getDefaultInstance();
    }

    public com.dj.protobuf.verify.VerifyUseCardReq build() {
      com.dj.protobuf.verify.VerifyUseCardReq result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public com.dj.protobuf.verify.VerifyUseCardReq buildPartial() {
      com.dj.protobuf.verify.VerifyUseCardReq result = new com.dj.protobuf.verify.VerifyUseCardReq(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
        to_bitField0_ |= 0x00000001;
      }
      result.index_ = index_;
      if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
        to_bitField0_ |= 0x00000002;
      }
      result.cardID_ = cardID_;
      if (((from_bitField0_ & 0x00000004) == 0x00000004)) {
        to_bitField0_ |= 0x00000004;
      }
      result.cardCount_ = cardCount_;
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
      if (other instanceof com.dj.protobuf.verify.VerifyUseCardReq) {
        return mergeFrom((com.dj.protobuf.verify.VerifyUseCardReq)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.dj.protobuf.verify.VerifyUseCardReq other) {
      if (other == com.dj.protobuf.verify.VerifyUseCardReq.getDefaultInstance()) return this;
      if (other.hasIndex()) {
        setIndex(other.getIndex());
      }
      if (other.hasCardID()) {
        setCardID(other.getCardID());
      }
      if (other.hasCardCount()) {
        setCardCount(other.getCardCount());
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
      com.dj.protobuf.verify.VerifyUseCardReq parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.dj.protobuf.verify.VerifyUseCardReq) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private int index_ ;
    /**
     * <code>optional uint32 index = 1;</code>
     */
    public boolean hasIndex() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <code>optional uint32 index = 1;</code>
     */
    public int getIndex() {
      return index_;
    }
    /**
     * <code>optional uint32 index = 1;</code>
     */
    public Builder setIndex(int value) {
      bitField0_ |= 0x00000001;
      index_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional uint32 index = 1;</code>
     */
    public Builder clearIndex() {
      bitField0_ = (bitField0_ & ~0x00000001);
      index_ = 0;
      onChanged();
      return this;
    }

    private int cardID_ ;
    /**
     * <pre>
     * 鉴定卡id
     * </pre>
     *
     * <code>optional uint32 cardID = 2;</code>
     */
    public boolean hasCardID() {
      return ((bitField0_ & 0x00000002) == 0x00000002);
    }
    /**
     * <pre>
     * 鉴定卡id
     * </pre>
     *
     * <code>optional uint32 cardID = 2;</code>
     */
    public int getCardID() {
      return cardID_;
    }
    /**
     * <pre>
     * 鉴定卡id
     * </pre>
     *
     * <code>optional uint32 cardID = 2;</code>
     */
    public Builder setCardID(int value) {
      bitField0_ |= 0x00000002;
      cardID_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * 鉴定卡id
     * </pre>
     *
     * <code>optional uint32 cardID = 2;</code>
     */
    public Builder clearCardID() {
      bitField0_ = (bitField0_ & ~0x00000002);
      cardID_ = 0;
      onChanged();
      return this;
    }

    private int cardCount_ ;
    /**
     * <pre>
     * 鉴定卡数量
     * </pre>
     *
     * <code>optional uint32 cardCount = 3;</code>
     */
    public boolean hasCardCount() {
      return ((bitField0_ & 0x00000004) == 0x00000004);
    }
    /**
     * <pre>
     * 鉴定卡数量
     * </pre>
     *
     * <code>optional uint32 cardCount = 3;</code>
     */
    public int getCardCount() {
      return cardCount_;
    }
    /**
     * <pre>
     * 鉴定卡数量
     * </pre>
     *
     * <code>optional uint32 cardCount = 3;</code>
     */
    public Builder setCardCount(int value) {
      bitField0_ |= 0x00000004;
      cardCount_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * 鉴定卡数量
     * </pre>
     *
     * <code>optional uint32 cardCount = 3;</code>
     */
    public Builder clearCardCount() {
      bitField0_ = (bitField0_ & ~0x00000004);
      cardCount_ = 0;
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


    // @@protoc_insertion_point(builder_scope:Protocols.VerifyUseCardReq)
  }

  // @@protoc_insertion_point(class_scope:Protocols.VerifyUseCardReq)
  private static final com.dj.protobuf.verify.VerifyUseCardReq DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.dj.protobuf.verify.VerifyUseCardReq();
  }

  public static com.dj.protobuf.verify.VerifyUseCardReq getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  @java.lang.Deprecated public static final com.google.protobuf.Parser<VerifyUseCardReq>
      PARSER = new com.google.protobuf.AbstractParser<VerifyUseCardReq>() {
    public VerifyUseCardReq parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new VerifyUseCardReq(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<VerifyUseCardReq> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<VerifyUseCardReq> getParserForType() {
    return PARSER;
  }

  public com.dj.protobuf.verify.VerifyUseCardReq getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

