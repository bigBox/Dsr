// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: GuildBattle.proto

package com.dj.protobuf.guildBattle;

/**
 * Protobuf type {@code Protocols.BattleMeetEggDropItem}
 */
public  final class BattleMeetEggDropItem extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:Protocols.BattleMeetEggDropItem)
    BattleMeetEggDropItemOrBuilder {
  // Use BattleMeetEggDropItem.newBuilder() to construct.
  private BattleMeetEggDropItem(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private BattleMeetEggDropItem() {
    timeID_ = "";
    dropID_ = 0;
    leftSeconds_ = 0;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private BattleMeetEggDropItem(
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
            timeID_ = bs;
            break;
          }
          case 16: {
            bitField0_ |= 0x00000002;
            dropID_ = input.readInt32();
            break;
          }
          case 24: {
            bitField0_ |= 0x00000004;
            leftSeconds_ = input.readInt32();
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
    return com.dj.protobuf.guildBattle.GuildBattle.internal_static_Protocols_BattleMeetEggDropItem_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.dj.protobuf.guildBattle.GuildBattle.internal_static_Protocols_BattleMeetEggDropItem_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.dj.protobuf.guildBattle.BattleMeetEggDropItem.class, com.dj.protobuf.guildBattle.BattleMeetEggDropItem.Builder.class);
  }

  private int bitField0_;
  public static final int TIMEID_FIELD_NUMBER = 1;
  private volatile java.lang.Object timeID_;
  /**
   * <pre>
   *掉落唯一id
   * </pre>
   *
   * <code>optional string timeID = 1;</code>
   */
  public boolean hasTimeID() {
    return ((bitField0_ & 0x00000001) == 0x00000001);
  }
  /**
   * <pre>
   *掉落唯一id
   * </pre>
   *
   * <code>optional string timeID = 1;</code>
   */
  public java.lang.String getTimeID() {
    java.lang.Object ref = timeID_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      if (bs.isValidUtf8()) {
        timeID_ = s;
      }
      return s;
    }
  }
  /**
   * <pre>
   *掉落唯一id
   * </pre>
   *
   * <code>optional string timeID = 1;</code>
   */
  public com.google.protobuf.ByteString
      getTimeIDBytes() {
    java.lang.Object ref = timeID_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      timeID_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int DROPID_FIELD_NUMBER = 2;
  private int dropID_;
  /**
   * <pre>
   *掉落配置id
   * </pre>
   *
   * <code>optional int32 dropID = 2;</code>
   */
  public boolean hasDropID() {
    return ((bitField0_ & 0x00000002) == 0x00000002);
  }
  /**
   * <pre>
   *掉落配置id
   * </pre>
   *
   * <code>optional int32 dropID = 2;</code>
   */
  public int getDropID() {
    return dropID_;
  }

  public static final int LEFTSECONDS_FIELD_NUMBER = 3;
  private int leftSeconds_;
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 距离掉落的秒数
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional int32 leftSeconds = 3;</code>
   */
  public boolean hasLeftSeconds() {
    return ((bitField0_ & 0x00000004) == 0x00000004);
  }
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 距离掉落的秒数
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional int32 leftSeconds = 3;</code>
   */
  public int getLeftSeconds() {
    return leftSeconds_;
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
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, timeID_);
    }
    if (((bitField0_ & 0x00000002) == 0x00000002)) {
      output.writeInt32(2, dropID_);
    }
    if (((bitField0_ & 0x00000004) == 0x00000004)) {
      output.writeInt32(3, leftSeconds_);
    }
    unknownFields.writeTo(output);
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (((bitField0_ & 0x00000001) == 0x00000001)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, timeID_);
    }
    if (((bitField0_ & 0x00000002) == 0x00000002)) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(2, dropID_);
    }
    if (((bitField0_ & 0x00000004) == 0x00000004)) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(3, leftSeconds_);
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
    if (!(obj instanceof com.dj.protobuf.guildBattle.BattleMeetEggDropItem)) {
      return super.equals(obj);
    }
    com.dj.protobuf.guildBattle.BattleMeetEggDropItem other = (com.dj.protobuf.guildBattle.BattleMeetEggDropItem) obj;

    boolean result = true;
    result = result && (hasTimeID() == other.hasTimeID());
    if (hasTimeID()) {
      result = result && getTimeID()
          .equals(other.getTimeID());
    }
    result = result && (hasDropID() == other.hasDropID());
    if (hasDropID()) {
      result = result && (getDropID()
          == other.getDropID());
    }
    result = result && (hasLeftSeconds() == other.hasLeftSeconds());
    if (hasLeftSeconds()) {
      result = result && (getLeftSeconds()
          == other.getLeftSeconds());
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
    if (hasTimeID()) {
      hash = (37 * hash) + TIMEID_FIELD_NUMBER;
      hash = (53 * hash) + getTimeID().hashCode();
    }
    if (hasDropID()) {
      hash = (37 * hash) + DROPID_FIELD_NUMBER;
      hash = (53 * hash) + getDropID();
    }
    if (hasLeftSeconds()) {
      hash = (37 * hash) + LEFTSECONDS_FIELD_NUMBER;
      hash = (53 * hash) + getLeftSeconds();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.dj.protobuf.guildBattle.BattleMeetEggDropItem parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dj.protobuf.guildBattle.BattleMeetEggDropItem parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dj.protobuf.guildBattle.BattleMeetEggDropItem parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dj.protobuf.guildBattle.BattleMeetEggDropItem parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dj.protobuf.guildBattle.BattleMeetEggDropItem parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.guildBattle.BattleMeetEggDropItem parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.dj.protobuf.guildBattle.BattleMeetEggDropItem parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.guildBattle.BattleMeetEggDropItem parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.dj.protobuf.guildBattle.BattleMeetEggDropItem parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.guildBattle.BattleMeetEggDropItem parseFrom(
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
  public static Builder newBuilder(com.dj.protobuf.guildBattle.BattleMeetEggDropItem prototype) {
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
   * Protobuf type {@code Protocols.BattleMeetEggDropItem}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:Protocols.BattleMeetEggDropItem)
      com.dj.protobuf.guildBattle.BattleMeetEggDropItemOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.dj.protobuf.guildBattle.GuildBattle.internal_static_Protocols_BattleMeetEggDropItem_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.dj.protobuf.guildBattle.GuildBattle.internal_static_Protocols_BattleMeetEggDropItem_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.dj.protobuf.guildBattle.BattleMeetEggDropItem.class, com.dj.protobuf.guildBattle.BattleMeetEggDropItem.Builder.class);
    }

    // Construct using com.dj.protobuf.guildBattle.BattleMeetEggDropItem.newBuilder()
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
      timeID_ = "";
      bitField0_ = (bitField0_ & ~0x00000001);
      dropID_ = 0;
      bitField0_ = (bitField0_ & ~0x00000002);
      leftSeconds_ = 0;
      bitField0_ = (bitField0_ & ~0x00000004);
      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.dj.protobuf.guildBattle.GuildBattle.internal_static_Protocols_BattleMeetEggDropItem_descriptor;
    }

    public com.dj.protobuf.guildBattle.BattleMeetEggDropItem getDefaultInstanceForType() {
      return com.dj.protobuf.guildBattle.BattleMeetEggDropItem.getDefaultInstance();
    }

    public com.dj.protobuf.guildBattle.BattleMeetEggDropItem build() {
      com.dj.protobuf.guildBattle.BattleMeetEggDropItem result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public com.dj.protobuf.guildBattle.BattleMeetEggDropItem buildPartial() {
      com.dj.protobuf.guildBattle.BattleMeetEggDropItem result = new com.dj.protobuf.guildBattle.BattleMeetEggDropItem(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
        to_bitField0_ |= 0x00000001;
      }
      result.timeID_ = timeID_;
      if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
        to_bitField0_ |= 0x00000002;
      }
      result.dropID_ = dropID_;
      if (((from_bitField0_ & 0x00000004) == 0x00000004)) {
        to_bitField0_ |= 0x00000004;
      }
      result.leftSeconds_ = leftSeconds_;
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
      if (other instanceof com.dj.protobuf.guildBattle.BattleMeetEggDropItem) {
        return mergeFrom((com.dj.protobuf.guildBattle.BattleMeetEggDropItem)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.dj.protobuf.guildBattle.BattleMeetEggDropItem other) {
      if (other == com.dj.protobuf.guildBattle.BattleMeetEggDropItem.getDefaultInstance()) return this;
      if (other.hasTimeID()) {
        bitField0_ |= 0x00000001;
        timeID_ = other.timeID_;
        onChanged();
      }
      if (other.hasDropID()) {
        setDropID(other.getDropID());
      }
      if (other.hasLeftSeconds()) {
        setLeftSeconds(other.getLeftSeconds());
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
      com.dj.protobuf.guildBattle.BattleMeetEggDropItem parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.dj.protobuf.guildBattle.BattleMeetEggDropItem) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private java.lang.Object timeID_ = "";
    /**
     * <pre>
     *掉落唯一id
     * </pre>
     *
     * <code>optional string timeID = 1;</code>
     */
    public boolean hasTimeID() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <pre>
     *掉落唯一id
     * </pre>
     *
     * <code>optional string timeID = 1;</code>
     */
    public java.lang.String getTimeID() {
      java.lang.Object ref = timeID_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        if (bs.isValidUtf8()) {
          timeID_ = s;
        }
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <pre>
     *掉落唯一id
     * </pre>
     *
     * <code>optional string timeID = 1;</code>
     */
    public com.google.protobuf.ByteString
        getTimeIDBytes() {
      java.lang.Object ref = timeID_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        timeID_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <pre>
     *掉落唯一id
     * </pre>
     *
     * <code>optional string timeID = 1;</code>
     */
    public Builder setTimeID(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000001;
      timeID_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     *掉落唯一id
     * </pre>
     *
     * <code>optional string timeID = 1;</code>
     */
    public Builder clearTimeID() {
      bitField0_ = (bitField0_ & ~0x00000001);
      timeID_ = getDefaultInstance().getTimeID();
      onChanged();
      return this;
    }
    /**
     * <pre>
     *掉落唯一id
     * </pre>
     *
     * <code>optional string timeID = 1;</code>
     */
    public Builder setTimeIDBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000001;
      timeID_ = value;
      onChanged();
      return this;
    }

    private int dropID_ ;
    /**
     * <pre>
     *掉落配置id
     * </pre>
     *
     * <code>optional int32 dropID = 2;</code>
     */
    public boolean hasDropID() {
      return ((bitField0_ & 0x00000002) == 0x00000002);
    }
    /**
     * <pre>
     *掉落配置id
     * </pre>
     *
     * <code>optional int32 dropID = 2;</code>
     */
    public int getDropID() {
      return dropID_;
    }
    /**
     * <pre>
     *掉落配置id
     * </pre>
     *
     * <code>optional int32 dropID = 2;</code>
     */
    public Builder setDropID(int value) {
      bitField0_ |= 0x00000002;
      dropID_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     *掉落配置id
     * </pre>
     *
     * <code>optional int32 dropID = 2;</code>
     */
    public Builder clearDropID() {
      bitField0_ = (bitField0_ & ~0x00000002);
      dropID_ = 0;
      onChanged();
      return this;
    }

    private int leftSeconds_ ;
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 距离掉落的秒数
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional int32 leftSeconds = 3;</code>
     */
    public boolean hasLeftSeconds() {
      return ((bitField0_ & 0x00000004) == 0x00000004);
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 距离掉落的秒数
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional int32 leftSeconds = 3;</code>
     */
    public int getLeftSeconds() {
      return leftSeconds_;
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 距离掉落的秒数
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional int32 leftSeconds = 3;</code>
     */
    public Builder setLeftSeconds(int value) {
      bitField0_ |= 0x00000004;
      leftSeconds_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 距离掉落的秒数
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional int32 leftSeconds = 3;</code>
     */
    public Builder clearLeftSeconds() {
      bitField0_ = (bitField0_ & ~0x00000004);
      leftSeconds_ = 0;
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


    // @@protoc_insertion_point(builder_scope:Protocols.BattleMeetEggDropItem)
  }

  // @@protoc_insertion_point(class_scope:Protocols.BattleMeetEggDropItem)
  private static final com.dj.protobuf.guildBattle.BattleMeetEggDropItem DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.dj.protobuf.guildBattle.BattleMeetEggDropItem();
  }

  public static com.dj.protobuf.guildBattle.BattleMeetEggDropItem getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  @java.lang.Deprecated public static final com.google.protobuf.Parser<BattleMeetEggDropItem>
      PARSER = new com.google.protobuf.AbstractParser<BattleMeetEggDropItem>() {
    public BattleMeetEggDropItem parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new BattleMeetEggDropItem(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<BattleMeetEggDropItem> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<BattleMeetEggDropItem> getParserForType() {
    return PARSER;
  }

  public com.dj.protobuf.guildBattle.BattleMeetEggDropItem getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
