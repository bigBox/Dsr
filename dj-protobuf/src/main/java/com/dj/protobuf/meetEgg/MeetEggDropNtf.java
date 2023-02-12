// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: MeetEgg.proto

package com.dj.protobuf.meetEgg;

/**
 * <pre>
 *&#47; &lt;summary&gt;
 * / 接鸡蛋的顶部掉落推送
 * / &lt;/summary&gt;
 * </pre>
 *
 * Protobuf type {@code Protocols.MeetEggDropNtf}
 */
public  final class MeetEggDropNtf extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:Protocols.MeetEggDropNtf)
    MeetEggDropNtfOrBuilder {
  // Use MeetEggDropNtf.newBuilder() to construct.
  private MeetEggDropNtf(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private MeetEggDropNtf() {
    id_ = 0;
    directionX_ = 0;
    positionX_ = 0;
    dropItems_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private MeetEggDropNtf(
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
            directionX_ = input.readInt32();
            break;
          }
          case 24: {
            bitField0_ |= 0x00000004;
            positionX_ = input.readInt32();
            break;
          }
          case 34: {
            if (!((mutable_bitField0_ & 0x00000008) == 0x00000008)) {
              dropItems_ = new java.util.ArrayList<com.dj.protobuf.meetEgg.MeetEggDropItem>();
              mutable_bitField0_ |= 0x00000008;
            }
            dropItems_.add(
                input.readMessage(com.dj.protobuf.meetEgg.MeetEggDropItem.PARSER, extensionRegistry));
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
      if (((mutable_bitField0_ & 0x00000008) == 0x00000008)) {
        dropItems_ = java.util.Collections.unmodifiableList(dropItems_);
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.dj.protobuf.meetEgg.MeetEgg.internal_static_Protocols_MeetEggDropNtf_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.dj.protobuf.meetEgg.MeetEgg.internal_static_Protocols_MeetEggDropNtf_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.dj.protobuf.meetEgg.MeetEggDropNtf.class, com.dj.protobuf.meetEgg.MeetEggDropNtf.Builder.class);
  }

  private int bitField0_;
  public static final int ID_FIELD_NUMBER = 1;
  private int id_;
  /**
   * <pre>
   *飞行物配置ID
   * </pre>
   *
   * <code>optional int32 id = 1;</code>
   */
  public boolean hasId() {
    return ((bitField0_ & 0x00000001) == 0x00000001);
  }
  /**
   * <pre>
   *飞行物配置ID
   * </pre>
   *
   * <code>optional int32 id = 1;</code>
   */
  public int getId() {
    return id_;
  }

  public static final int DIRECTIONX_FIELD_NUMBER = 2;
  private int directionX_;
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 方向， 2向右，1向左
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional int32 directionX = 2;</code>
   */
  public boolean hasDirectionX() {
    return ((bitField0_ & 0x00000002) == 0x00000002);
  }
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 方向， 2向右，1向左
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional int32 directionX = 2;</code>
   */
  public int getDirectionX() {
    return directionX_;
  }

  public static final int POSITIONX_FIELD_NUMBER = 3;
  private int positionX_;
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / x坐标
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional int32 positionX = 3;</code>
   */
  public boolean hasPositionX() {
    return ((bitField0_ & 0x00000004) == 0x00000004);
  }
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / x坐标
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional int32 positionX = 3;</code>
   */
  public int getPositionX() {
    return positionX_;
  }

  public static final int DROPITEMS_FIELD_NUMBER = 4;
  private java.util.List<com.dj.protobuf.meetEgg.MeetEggDropItem> dropItems_;
  /**
   * <code>repeated .Protocols.MeetEggDropItem dropItems = 4;</code>
   */
  public java.util.List<com.dj.protobuf.meetEgg.MeetEggDropItem> getDropItemsList() {
    return dropItems_;
  }
  /**
   * <code>repeated .Protocols.MeetEggDropItem dropItems = 4;</code>
   */
  public java.util.List<? extends com.dj.protobuf.meetEgg.MeetEggDropItemOrBuilder> 
      getDropItemsOrBuilderList() {
    return dropItems_;
  }
  /**
   * <code>repeated .Protocols.MeetEggDropItem dropItems = 4;</code>
   */
  public int getDropItemsCount() {
    return dropItems_.size();
  }
  /**
   * <code>repeated .Protocols.MeetEggDropItem dropItems = 4;</code>
   */
  public com.dj.protobuf.meetEgg.MeetEggDropItem getDropItems(int index) {
    return dropItems_.get(index);
  }
  /**
   * <code>repeated .Protocols.MeetEggDropItem dropItems = 4;</code>
   */
  public com.dj.protobuf.meetEgg.MeetEggDropItemOrBuilder getDropItemsOrBuilder(
      int index) {
    return dropItems_.get(index);
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
      output.writeInt32(2, directionX_);
    }
    if (((bitField0_ & 0x00000004) == 0x00000004)) {
      output.writeInt32(3, positionX_);
    }
    for (int i = 0; i < dropItems_.size(); i++) {
      output.writeMessage(4, dropItems_.get(i));
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
        .computeInt32Size(2, directionX_);
    }
    if (((bitField0_ & 0x00000004) == 0x00000004)) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(3, positionX_);
    }
    for (int i = 0; i < dropItems_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(4, dropItems_.get(i));
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
    if (!(obj instanceof com.dj.protobuf.meetEgg.MeetEggDropNtf)) {
      return super.equals(obj);
    }
    com.dj.protobuf.meetEgg.MeetEggDropNtf other = (com.dj.protobuf.meetEgg.MeetEggDropNtf) obj;

    boolean result = true;
    result = result && (hasId() == other.hasId());
    if (hasId()) {
      result = result && (getId()
          == other.getId());
    }
    result = result && (hasDirectionX() == other.hasDirectionX());
    if (hasDirectionX()) {
      result = result && (getDirectionX()
          == other.getDirectionX());
    }
    result = result && (hasPositionX() == other.hasPositionX());
    if (hasPositionX()) {
      result = result && (getPositionX()
          == other.getPositionX());
    }
    result = result && getDropItemsList()
        .equals(other.getDropItemsList());
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
    if (hasDirectionX()) {
      hash = (37 * hash) + DIRECTIONX_FIELD_NUMBER;
      hash = (53 * hash) + getDirectionX();
    }
    if (hasPositionX()) {
      hash = (37 * hash) + POSITIONX_FIELD_NUMBER;
      hash = (53 * hash) + getPositionX();
    }
    if (getDropItemsCount() > 0) {
      hash = (37 * hash) + DROPITEMS_FIELD_NUMBER;
      hash = (53 * hash) + getDropItemsList().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.dj.protobuf.meetEgg.MeetEggDropNtf parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dj.protobuf.meetEgg.MeetEggDropNtf parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dj.protobuf.meetEgg.MeetEggDropNtf parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dj.protobuf.meetEgg.MeetEggDropNtf parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dj.protobuf.meetEgg.MeetEggDropNtf parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.meetEgg.MeetEggDropNtf parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.dj.protobuf.meetEgg.MeetEggDropNtf parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.meetEgg.MeetEggDropNtf parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.dj.protobuf.meetEgg.MeetEggDropNtf parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.meetEgg.MeetEggDropNtf parseFrom(
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
  public static Builder newBuilder(com.dj.protobuf.meetEgg.MeetEggDropNtf prototype) {
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
   * / 接鸡蛋的顶部掉落推送
   * / &lt;/summary&gt;
   * </pre>
   *
   * Protobuf type {@code Protocols.MeetEggDropNtf}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:Protocols.MeetEggDropNtf)
      com.dj.protobuf.meetEgg.MeetEggDropNtfOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.dj.protobuf.meetEgg.MeetEgg.internal_static_Protocols_MeetEggDropNtf_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.dj.protobuf.meetEgg.MeetEgg.internal_static_Protocols_MeetEggDropNtf_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.dj.protobuf.meetEgg.MeetEggDropNtf.class, com.dj.protobuf.meetEgg.MeetEggDropNtf.Builder.class);
    }

    // Construct using com.dj.protobuf.meetEgg.MeetEggDropNtf.newBuilder()
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
        getDropItemsFieldBuilder();
      }
    }
    public Builder clear() {
      super.clear();
      id_ = 0;
      bitField0_ = (bitField0_ & ~0x00000001);
      directionX_ = 0;
      bitField0_ = (bitField0_ & ~0x00000002);
      positionX_ = 0;
      bitField0_ = (bitField0_ & ~0x00000004);
      if (dropItemsBuilder_ == null) {
        dropItems_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000008);
      } else {
        dropItemsBuilder_.clear();
      }
      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.dj.protobuf.meetEgg.MeetEgg.internal_static_Protocols_MeetEggDropNtf_descriptor;
    }

    public com.dj.protobuf.meetEgg.MeetEggDropNtf getDefaultInstanceForType() {
      return com.dj.protobuf.meetEgg.MeetEggDropNtf.getDefaultInstance();
    }

    public com.dj.protobuf.meetEgg.MeetEggDropNtf build() {
      com.dj.protobuf.meetEgg.MeetEggDropNtf result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public com.dj.protobuf.meetEgg.MeetEggDropNtf buildPartial() {
      com.dj.protobuf.meetEgg.MeetEggDropNtf result = new com.dj.protobuf.meetEgg.MeetEggDropNtf(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
        to_bitField0_ |= 0x00000001;
      }
      result.id_ = id_;
      if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
        to_bitField0_ |= 0x00000002;
      }
      result.directionX_ = directionX_;
      if (((from_bitField0_ & 0x00000004) == 0x00000004)) {
        to_bitField0_ |= 0x00000004;
      }
      result.positionX_ = positionX_;
      if (dropItemsBuilder_ == null) {
        if (((bitField0_ & 0x00000008) == 0x00000008)) {
          dropItems_ = java.util.Collections.unmodifiableList(dropItems_);
          bitField0_ = (bitField0_ & ~0x00000008);
        }
        result.dropItems_ = dropItems_;
      } else {
        result.dropItems_ = dropItemsBuilder_.build();
      }
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
      if (other instanceof com.dj.protobuf.meetEgg.MeetEggDropNtf) {
        return mergeFrom((com.dj.protobuf.meetEgg.MeetEggDropNtf)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.dj.protobuf.meetEgg.MeetEggDropNtf other) {
      if (other == com.dj.protobuf.meetEgg.MeetEggDropNtf.getDefaultInstance()) return this;
      if (other.hasId()) {
        setId(other.getId());
      }
      if (other.hasDirectionX()) {
        setDirectionX(other.getDirectionX());
      }
      if (other.hasPositionX()) {
        setPositionX(other.getPositionX());
      }
      if (dropItemsBuilder_ == null) {
        if (!other.dropItems_.isEmpty()) {
          if (dropItems_.isEmpty()) {
            dropItems_ = other.dropItems_;
            bitField0_ = (bitField0_ & ~0x00000008);
          } else {
            ensureDropItemsIsMutable();
            dropItems_.addAll(other.dropItems_);
          }
          onChanged();
        }
      } else {
        if (!other.dropItems_.isEmpty()) {
          if (dropItemsBuilder_.isEmpty()) {
            dropItemsBuilder_.dispose();
            dropItemsBuilder_ = null;
            dropItems_ = other.dropItems_;
            bitField0_ = (bitField0_ & ~0x00000008);
            dropItemsBuilder_ = 
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getDropItemsFieldBuilder() : null;
          } else {
            dropItemsBuilder_.addAllMessages(other.dropItems_);
          }
        }
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
      com.dj.protobuf.meetEgg.MeetEggDropNtf parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.dj.protobuf.meetEgg.MeetEggDropNtf) e.getUnfinishedMessage();
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
     * <pre>
     *飞行物配置ID
     * </pre>
     *
     * <code>optional int32 id = 1;</code>
     */
    public boolean hasId() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <pre>
     *飞行物配置ID
     * </pre>
     *
     * <code>optional int32 id = 1;</code>
     */
    public int getId() {
      return id_;
    }
    /**
     * <pre>
     *飞行物配置ID
     * </pre>
     *
     * <code>optional int32 id = 1;</code>
     */
    public Builder setId(int value) {
      bitField0_ |= 0x00000001;
      id_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     *飞行物配置ID
     * </pre>
     *
     * <code>optional int32 id = 1;</code>
     */
    public Builder clearId() {
      bitField0_ = (bitField0_ & ~0x00000001);
      id_ = 0;
      onChanged();
      return this;
    }

    private int directionX_ ;
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 方向， 2向右，1向左
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional int32 directionX = 2;</code>
     */
    public boolean hasDirectionX() {
      return ((bitField0_ & 0x00000002) == 0x00000002);
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 方向， 2向右，1向左
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional int32 directionX = 2;</code>
     */
    public int getDirectionX() {
      return directionX_;
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 方向， 2向右，1向左
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional int32 directionX = 2;</code>
     */
    public Builder setDirectionX(int value) {
      bitField0_ |= 0x00000002;
      directionX_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 方向， 2向右，1向左
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional int32 directionX = 2;</code>
     */
    public Builder clearDirectionX() {
      bitField0_ = (bitField0_ & ~0x00000002);
      directionX_ = 0;
      onChanged();
      return this;
    }

    private int positionX_ ;
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / x坐标
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional int32 positionX = 3;</code>
     */
    public boolean hasPositionX() {
      return ((bitField0_ & 0x00000004) == 0x00000004);
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / x坐标
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional int32 positionX = 3;</code>
     */
    public int getPositionX() {
      return positionX_;
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / x坐标
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional int32 positionX = 3;</code>
     */
    public Builder setPositionX(int value) {
      bitField0_ |= 0x00000004;
      positionX_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / x坐标
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional int32 positionX = 3;</code>
     */
    public Builder clearPositionX() {
      bitField0_ = (bitField0_ & ~0x00000004);
      positionX_ = 0;
      onChanged();
      return this;
    }

    private java.util.List<com.dj.protobuf.meetEgg.MeetEggDropItem> dropItems_ =
      java.util.Collections.emptyList();
    private void ensureDropItemsIsMutable() {
      if (!((bitField0_ & 0x00000008) == 0x00000008)) {
        dropItems_ = new java.util.ArrayList<com.dj.protobuf.meetEgg.MeetEggDropItem>(dropItems_);
        bitField0_ |= 0x00000008;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        com.dj.protobuf.meetEgg.MeetEggDropItem, com.dj.protobuf.meetEgg.MeetEggDropItem.Builder, com.dj.protobuf.meetEgg.MeetEggDropItemOrBuilder> dropItemsBuilder_;

    /**
     * <code>repeated .Protocols.MeetEggDropItem dropItems = 4;</code>
     */
    public java.util.List<com.dj.protobuf.meetEgg.MeetEggDropItem> getDropItemsList() {
      if (dropItemsBuilder_ == null) {
        return java.util.Collections.unmodifiableList(dropItems_);
      } else {
        return dropItemsBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .Protocols.MeetEggDropItem dropItems = 4;</code>
     */
    public int getDropItemsCount() {
      if (dropItemsBuilder_ == null) {
        return dropItems_.size();
      } else {
        return dropItemsBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .Protocols.MeetEggDropItem dropItems = 4;</code>
     */
    public com.dj.protobuf.meetEgg.MeetEggDropItem getDropItems(int index) {
      if (dropItemsBuilder_ == null) {
        return dropItems_.get(index);
      } else {
        return dropItemsBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .Protocols.MeetEggDropItem dropItems = 4;</code>
     */
    public Builder setDropItems(
        int index, com.dj.protobuf.meetEgg.MeetEggDropItem value) {
      if (dropItemsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureDropItemsIsMutable();
        dropItems_.set(index, value);
        onChanged();
      } else {
        dropItemsBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .Protocols.MeetEggDropItem dropItems = 4;</code>
     */
    public Builder setDropItems(
        int index, com.dj.protobuf.meetEgg.MeetEggDropItem.Builder builderForValue) {
      if (dropItemsBuilder_ == null) {
        ensureDropItemsIsMutable();
        dropItems_.set(index, builderForValue.build());
        onChanged();
      } else {
        dropItemsBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .Protocols.MeetEggDropItem dropItems = 4;</code>
     */
    public Builder addDropItems(com.dj.protobuf.meetEgg.MeetEggDropItem value) {
      if (dropItemsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureDropItemsIsMutable();
        dropItems_.add(value);
        onChanged();
      } else {
        dropItemsBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .Protocols.MeetEggDropItem dropItems = 4;</code>
     */
    public Builder addDropItems(
        int index, com.dj.protobuf.meetEgg.MeetEggDropItem value) {
      if (dropItemsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureDropItemsIsMutable();
        dropItems_.add(index, value);
        onChanged();
      } else {
        dropItemsBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .Protocols.MeetEggDropItem dropItems = 4;</code>
     */
    public Builder addDropItems(
        com.dj.protobuf.meetEgg.MeetEggDropItem.Builder builderForValue) {
      if (dropItemsBuilder_ == null) {
        ensureDropItemsIsMutable();
        dropItems_.add(builderForValue.build());
        onChanged();
      } else {
        dropItemsBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .Protocols.MeetEggDropItem dropItems = 4;</code>
     */
    public Builder addDropItems(
        int index, com.dj.protobuf.meetEgg.MeetEggDropItem.Builder builderForValue) {
      if (dropItemsBuilder_ == null) {
        ensureDropItemsIsMutable();
        dropItems_.add(index, builderForValue.build());
        onChanged();
      } else {
        dropItemsBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .Protocols.MeetEggDropItem dropItems = 4;</code>
     */
    public Builder addAllDropItems(
        java.lang.Iterable<? extends com.dj.protobuf.meetEgg.MeetEggDropItem> values) {
      if (dropItemsBuilder_ == null) {
        ensureDropItemsIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, dropItems_);
        onChanged();
      } else {
        dropItemsBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .Protocols.MeetEggDropItem dropItems = 4;</code>
     */
    public Builder clearDropItems() {
      if (dropItemsBuilder_ == null) {
        dropItems_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000008);
        onChanged();
      } else {
        dropItemsBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .Protocols.MeetEggDropItem dropItems = 4;</code>
     */
    public Builder removeDropItems(int index) {
      if (dropItemsBuilder_ == null) {
        ensureDropItemsIsMutable();
        dropItems_.remove(index);
        onChanged();
      } else {
        dropItemsBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .Protocols.MeetEggDropItem dropItems = 4;</code>
     */
    public com.dj.protobuf.meetEgg.MeetEggDropItem.Builder getDropItemsBuilder(
        int index) {
      return getDropItemsFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .Protocols.MeetEggDropItem dropItems = 4;</code>
     */
    public com.dj.protobuf.meetEgg.MeetEggDropItemOrBuilder getDropItemsOrBuilder(
        int index) {
      if (dropItemsBuilder_ == null) {
        return dropItems_.get(index);  } else {
        return dropItemsBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .Protocols.MeetEggDropItem dropItems = 4;</code>
     */
    public java.util.List<? extends com.dj.protobuf.meetEgg.MeetEggDropItemOrBuilder> 
         getDropItemsOrBuilderList() {
      if (dropItemsBuilder_ != null) {
        return dropItemsBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(dropItems_);
      }
    }
    /**
     * <code>repeated .Protocols.MeetEggDropItem dropItems = 4;</code>
     */
    public com.dj.protobuf.meetEgg.MeetEggDropItem.Builder addDropItemsBuilder() {
      return getDropItemsFieldBuilder().addBuilder(
          com.dj.protobuf.meetEgg.MeetEggDropItem.getDefaultInstance());
    }
    /**
     * <code>repeated .Protocols.MeetEggDropItem dropItems = 4;</code>
     */
    public com.dj.protobuf.meetEgg.MeetEggDropItem.Builder addDropItemsBuilder(
        int index) {
      return getDropItemsFieldBuilder().addBuilder(
          index, com.dj.protobuf.meetEgg.MeetEggDropItem.getDefaultInstance());
    }
    /**
     * <code>repeated .Protocols.MeetEggDropItem dropItems = 4;</code>
     */
    public java.util.List<com.dj.protobuf.meetEgg.MeetEggDropItem.Builder> 
         getDropItemsBuilderList() {
      return getDropItemsFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        com.dj.protobuf.meetEgg.MeetEggDropItem, com.dj.protobuf.meetEgg.MeetEggDropItem.Builder, com.dj.protobuf.meetEgg.MeetEggDropItemOrBuilder> 
        getDropItemsFieldBuilder() {
      if (dropItemsBuilder_ == null) {
        dropItemsBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            com.dj.protobuf.meetEgg.MeetEggDropItem, com.dj.protobuf.meetEgg.MeetEggDropItem.Builder, com.dj.protobuf.meetEgg.MeetEggDropItemOrBuilder>(
                dropItems_,
                ((bitField0_ & 0x00000008) == 0x00000008),
                getParentForChildren(),
                isClean());
        dropItems_ = null;
      }
      return dropItemsBuilder_;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:Protocols.MeetEggDropNtf)
  }

  // @@protoc_insertion_point(class_scope:Protocols.MeetEggDropNtf)
  private static final com.dj.protobuf.meetEgg.MeetEggDropNtf DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.dj.protobuf.meetEgg.MeetEggDropNtf();
  }

  public static com.dj.protobuf.meetEgg.MeetEggDropNtf getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  @java.lang.Deprecated public static final com.google.protobuf.Parser<MeetEggDropNtf>
      PARSER = new com.google.protobuf.AbstractParser<MeetEggDropNtf>() {
    public MeetEggDropNtf parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new MeetEggDropNtf(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<MeetEggDropNtf> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<MeetEggDropNtf> getParserForType() {
    return PARSER;
  }

  public com.dj.protobuf.meetEgg.MeetEggDropNtf getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
