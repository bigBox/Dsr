// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Manufacture.proto

package com.dj.protobuf.manufacture;

/**
 * <pre>
 *&#47; &lt;summary&gt;
 * / 制作操作请求
 * / &lt;/summary&gt;
 * </pre>
 *
 * Protobuf type {@code Protocols.ManufactureActionReq}
 */
public  final class ManufactureActionReq extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:Protocols.ManufactureActionReq)
    ManufactureActionReqOrBuilder {
  // Use ManufactureActionReq.newBuilder() to construct.
  private ManufactureActionReq(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private ManufactureActionReq() {
    actionType_ = 1;
    recipeId_ = 0;
    enqueued_ = 0;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private ManufactureActionReq(
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
            int rawValue = input.readEnum();
            com.dj.protobuf.manufacture.EManufactureActionType value = com.dj.protobuf.manufacture.EManufactureActionType.valueOf(rawValue);
            if (value == null) {
              unknownFields.mergeVarintField(1, rawValue);
            } else {
              bitField0_ |= 0x00000001;
              actionType_ = rawValue;
            }
            break;
          }
          case 16: {
            bitField0_ |= 0x00000002;
            recipeId_ = input.readInt32();
            break;
          }
          case 24: {
            bitField0_ |= 0x00000004;
            enqueued_ = input.readInt32();
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
    return com.dj.protobuf.manufacture.Manufacture.internal_static_Protocols_ManufactureActionReq_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.dj.protobuf.manufacture.Manufacture.internal_static_Protocols_ManufactureActionReq_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.dj.protobuf.manufacture.ManufactureActionReq.class, com.dj.protobuf.manufacture.ManufactureActionReq.Builder.class);
  }

  private int bitField0_;
  public static final int ACTIONTYPE_FIELD_NUMBER = 1;
  private int actionType_;
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 制作操作
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional .Protocols.EManufactureActionType actionType = 1;</code>
   */
  public boolean hasActionType() {
    return ((bitField0_ & 0x00000001) == 0x00000001);
  }
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 制作操作
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional .Protocols.EManufactureActionType actionType = 1;</code>
   */
  public com.dj.protobuf.manufacture.EManufactureActionType getActionType() {
    com.dj.protobuf.manufacture.EManufactureActionType result = com.dj.protobuf.manufacture.EManufactureActionType.valueOf(actionType_);
    return result == null ? com.dj.protobuf.manufacture.EManufactureActionType.Make : result;
  }

  public static final int RECIPEID_FIELD_NUMBER = 2;
  private int recipeId_;
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 操作配方ID
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional int32 recipeId = 2;</code>
   */
  public boolean hasRecipeId() {
    return ((bitField0_ & 0x00000002) == 0x00000002);
  }
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 操作配方ID
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional int32 recipeId = 2;</code>
   */
  public int getRecipeId() {
    return recipeId_;
  }

  public static final int ENQUEUED_FIELD_NUMBER = 3;
  private int enqueued_;
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 1:制作; 0:领取
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional int32 enqueued = 3;</code>
   */
  public boolean hasEnqueued() {
    return ((bitField0_ & 0x00000004) == 0x00000004);
  }
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 1:制作; 0:领取
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional int32 enqueued = 3;</code>
   */
  public int getEnqueued() {
    return enqueued_;
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
      output.writeEnum(1, actionType_);
    }
    if (((bitField0_ & 0x00000002) == 0x00000002)) {
      output.writeInt32(2, recipeId_);
    }
    if (((bitField0_ & 0x00000004) == 0x00000004)) {
      output.writeInt32(3, enqueued_);
    }
    unknownFields.writeTo(output);
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (((bitField0_ & 0x00000001) == 0x00000001)) {
      size += com.google.protobuf.CodedOutputStream
        .computeEnumSize(1, actionType_);
    }
    if (((bitField0_ & 0x00000002) == 0x00000002)) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(2, recipeId_);
    }
    if (((bitField0_ & 0x00000004) == 0x00000004)) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(3, enqueued_);
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
    if (!(obj instanceof com.dj.protobuf.manufacture.ManufactureActionReq)) {
      return super.equals(obj);
    }
    com.dj.protobuf.manufacture.ManufactureActionReq other = (com.dj.protobuf.manufacture.ManufactureActionReq) obj;

    boolean result = true;
    result = result && (hasActionType() == other.hasActionType());
    if (hasActionType()) {
      result = result && actionType_ == other.actionType_;
    }
    result = result && (hasRecipeId() == other.hasRecipeId());
    if (hasRecipeId()) {
      result = result && (getRecipeId()
          == other.getRecipeId());
    }
    result = result && (hasEnqueued() == other.hasEnqueued());
    if (hasEnqueued()) {
      result = result && (getEnqueued()
          == other.getEnqueued());
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
    if (hasActionType()) {
      hash = (37 * hash) + ACTIONTYPE_FIELD_NUMBER;
      hash = (53 * hash) + actionType_;
    }
    if (hasRecipeId()) {
      hash = (37 * hash) + RECIPEID_FIELD_NUMBER;
      hash = (53 * hash) + getRecipeId();
    }
    if (hasEnqueued()) {
      hash = (37 * hash) + ENQUEUED_FIELD_NUMBER;
      hash = (53 * hash) + getEnqueued();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.dj.protobuf.manufacture.ManufactureActionReq parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dj.protobuf.manufacture.ManufactureActionReq parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dj.protobuf.manufacture.ManufactureActionReq parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dj.protobuf.manufacture.ManufactureActionReq parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dj.protobuf.manufacture.ManufactureActionReq parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.manufacture.ManufactureActionReq parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.dj.protobuf.manufacture.ManufactureActionReq parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.manufacture.ManufactureActionReq parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.dj.protobuf.manufacture.ManufactureActionReq parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.manufacture.ManufactureActionReq parseFrom(
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
  public static Builder newBuilder(com.dj.protobuf.manufacture.ManufactureActionReq prototype) {
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
   * / 制作操作请求
   * / &lt;/summary&gt;
   * </pre>
   *
   * Protobuf type {@code Protocols.ManufactureActionReq}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:Protocols.ManufactureActionReq)
      com.dj.protobuf.manufacture.ManufactureActionReqOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.dj.protobuf.manufacture.Manufacture.internal_static_Protocols_ManufactureActionReq_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.dj.protobuf.manufacture.Manufacture.internal_static_Protocols_ManufactureActionReq_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.dj.protobuf.manufacture.ManufactureActionReq.class, com.dj.protobuf.manufacture.ManufactureActionReq.Builder.class);
    }

    // Construct using com.dj.protobuf.manufacture.ManufactureActionReq.newBuilder()
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
      actionType_ = 1;
      bitField0_ = (bitField0_ & ~0x00000001);
      recipeId_ = 0;
      bitField0_ = (bitField0_ & ~0x00000002);
      enqueued_ = 0;
      bitField0_ = (bitField0_ & ~0x00000004);
      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.dj.protobuf.manufacture.Manufacture.internal_static_Protocols_ManufactureActionReq_descriptor;
    }

    public com.dj.protobuf.manufacture.ManufactureActionReq getDefaultInstanceForType() {
      return com.dj.protobuf.manufacture.ManufactureActionReq.getDefaultInstance();
    }

    public com.dj.protobuf.manufacture.ManufactureActionReq build() {
      com.dj.protobuf.manufacture.ManufactureActionReq result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public com.dj.protobuf.manufacture.ManufactureActionReq buildPartial() {
      com.dj.protobuf.manufacture.ManufactureActionReq result = new com.dj.protobuf.manufacture.ManufactureActionReq(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
        to_bitField0_ |= 0x00000001;
      }
      result.actionType_ = actionType_;
      if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
        to_bitField0_ |= 0x00000002;
      }
      result.recipeId_ = recipeId_;
      if (((from_bitField0_ & 0x00000004) == 0x00000004)) {
        to_bitField0_ |= 0x00000004;
      }
      result.enqueued_ = enqueued_;
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
      if (other instanceof com.dj.protobuf.manufacture.ManufactureActionReq) {
        return mergeFrom((com.dj.protobuf.manufacture.ManufactureActionReq)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.dj.protobuf.manufacture.ManufactureActionReq other) {
      if (other == com.dj.protobuf.manufacture.ManufactureActionReq.getDefaultInstance()) return this;
      if (other.hasActionType()) {
        setActionType(other.getActionType());
      }
      if (other.hasRecipeId()) {
        setRecipeId(other.getRecipeId());
      }
      if (other.hasEnqueued()) {
        setEnqueued(other.getEnqueued());
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
      com.dj.protobuf.manufacture.ManufactureActionReq parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.dj.protobuf.manufacture.ManufactureActionReq) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private int actionType_ = 1;
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 制作操作
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional .Protocols.EManufactureActionType actionType = 1;</code>
     */
    public boolean hasActionType() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 制作操作
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional .Protocols.EManufactureActionType actionType = 1;</code>
     */
    public com.dj.protobuf.manufacture.EManufactureActionType getActionType() {
      com.dj.protobuf.manufacture.EManufactureActionType result = com.dj.protobuf.manufacture.EManufactureActionType.valueOf(actionType_);
      return result == null ? com.dj.protobuf.manufacture.EManufactureActionType.Make : result;
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 制作操作
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional .Protocols.EManufactureActionType actionType = 1;</code>
     */
    public Builder setActionType(com.dj.protobuf.manufacture.EManufactureActionType value) {
      if (value == null) {
        throw new NullPointerException();
      }
      bitField0_ |= 0x00000001;
      actionType_ = value.getNumber();
      onChanged();
      return this;
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 制作操作
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional .Protocols.EManufactureActionType actionType = 1;</code>
     */
    public Builder clearActionType() {
      bitField0_ = (bitField0_ & ~0x00000001);
      actionType_ = 1;
      onChanged();
      return this;
    }

    private int recipeId_ ;
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 操作配方ID
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional int32 recipeId = 2;</code>
     */
    public boolean hasRecipeId() {
      return ((bitField0_ & 0x00000002) == 0x00000002);
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 操作配方ID
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional int32 recipeId = 2;</code>
     */
    public int getRecipeId() {
      return recipeId_;
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 操作配方ID
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional int32 recipeId = 2;</code>
     */
    public Builder setRecipeId(int value) {
      bitField0_ |= 0x00000002;
      recipeId_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 操作配方ID
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional int32 recipeId = 2;</code>
     */
    public Builder clearRecipeId() {
      bitField0_ = (bitField0_ & ~0x00000002);
      recipeId_ = 0;
      onChanged();
      return this;
    }

    private int enqueued_ ;
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 1:制作; 0:领取
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional int32 enqueued = 3;</code>
     */
    public boolean hasEnqueued() {
      return ((bitField0_ & 0x00000004) == 0x00000004);
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 1:制作; 0:领取
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional int32 enqueued = 3;</code>
     */
    public int getEnqueued() {
      return enqueued_;
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 1:制作; 0:领取
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional int32 enqueued = 3;</code>
     */
    public Builder setEnqueued(int value) {
      bitField0_ |= 0x00000004;
      enqueued_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 1:制作; 0:领取
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional int32 enqueued = 3;</code>
     */
    public Builder clearEnqueued() {
      bitField0_ = (bitField0_ & ~0x00000004);
      enqueued_ = 0;
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


    // @@protoc_insertion_point(builder_scope:Protocols.ManufactureActionReq)
  }

  // @@protoc_insertion_point(class_scope:Protocols.ManufactureActionReq)
  private static final com.dj.protobuf.manufacture.ManufactureActionReq DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.dj.protobuf.manufacture.ManufactureActionReq();
  }

  public static com.dj.protobuf.manufacture.ManufactureActionReq getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  @java.lang.Deprecated public static final com.google.protobuf.Parser<ManufactureActionReq>
      PARSER = new com.google.protobuf.AbstractParser<ManufactureActionReq>() {
    public ManufactureActionReq parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new ManufactureActionReq(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<ManufactureActionReq> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<ManufactureActionReq> getParserForType() {
    return PARSER;
  }

  public com.dj.protobuf.manufacture.ManufactureActionReq getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

