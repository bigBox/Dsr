// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Item.proto

package com.dj.protobuf.item;

/**
 * <pre>
 * 好友互动物品历史记录
 * </pre>
 *
 * Protobuf type {@code Protocols.ItemInteractHistory}
 */
public  final class ItemInteractHistory extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:Protocols.ItemInteractHistory)
    ItemInteractHistoryOrBuilder {
  // Use ItemInteractHistory.newBuilder() to construct.
  private ItemInteractHistory(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private ItemInteractHistory() {
    itemID_ = 0;
    itemCount_ = 0;
    ps_ = "";
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private ItemInteractHistory(
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
            com.dj.protobuf.common.BaseRoleInfo.Builder subBuilder = null;
            if (((bitField0_ & 0x00000001) == 0x00000001)) {
              subBuilder = interactRoleInfo_.toBuilder();
            }
            interactRoleInfo_ = input.readMessage(com.dj.protobuf.common.BaseRoleInfo.PARSER, extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(interactRoleInfo_);
              interactRoleInfo_ = subBuilder.buildPartial();
            }
            bitField0_ |= 0x00000001;
            break;
          }
          case 16: {
            bitField0_ |= 0x00000002;
            itemID_ = input.readInt32();
            break;
          }
          case 24: {
            bitField0_ |= 0x00000004;
            itemCount_ = input.readInt32();
            break;
          }
          case 34: {
            com.google.protobuf.ByteString bs = input.readBytes();
            bitField0_ |= 0x00000008;
            ps_ = bs;
            break;
          }
          case 42: {
            com.dj.protobuf.datetime.DateTime.Builder subBuilder = null;
            if (((bitField0_ & 0x00000010) == 0x00000010)) {
              subBuilder = interactTime_.toBuilder();
            }
            interactTime_ = input.readMessage(com.dj.protobuf.datetime.DateTime.PARSER, extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(interactTime_);
              interactTime_ = subBuilder.buildPartial();
            }
            bitField0_ |= 0x00000010;
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
    return com.dj.protobuf.item.Item.internal_static_Protocols_ItemInteractHistory_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.dj.protobuf.item.Item.internal_static_Protocols_ItemInteractHistory_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.dj.protobuf.item.ItemInteractHistory.class, com.dj.protobuf.item.ItemInteractHistory.Builder.class);
  }

  private int bitField0_;
  public static final int INTERACTROLEINFO_FIELD_NUMBER = 1;
  private com.dj.protobuf.common.BaseRoleInfo interactRoleInfo_;
  /**
   * <pre>
   * 互动人
   * </pre>
   *
   * <code>optional .Protocols.BaseRoleInfo interactRoleInfo = 1;</code>
   */
  public boolean hasInteractRoleInfo() {
    return ((bitField0_ & 0x00000001) == 0x00000001);
  }
  /**
   * <pre>
   * 互动人
   * </pre>
   *
   * <code>optional .Protocols.BaseRoleInfo interactRoleInfo = 1;</code>
   */
  public com.dj.protobuf.common.BaseRoleInfo getInteractRoleInfo() {
    return interactRoleInfo_ == null ? com.dj.protobuf.common.BaseRoleInfo.getDefaultInstance() : interactRoleInfo_;
  }
  /**
   * <pre>
   * 互动人
   * </pre>
   *
   * <code>optional .Protocols.BaseRoleInfo interactRoleInfo = 1;</code>
   */
  public com.dj.protobuf.common.BaseRoleInfoOrBuilder getInteractRoleInfoOrBuilder() {
    return interactRoleInfo_ == null ? com.dj.protobuf.common.BaseRoleInfo.getDefaultInstance() : interactRoleInfo_;
  }

  public static final int ITEMID_FIELD_NUMBER = 2;
  private int itemID_;
  /**
   * <pre>
   * 物品ID
   * </pre>
   *
   * <code>optional int32 itemID = 2;</code>
   */
  public boolean hasItemID() {
    return ((bitField0_ & 0x00000002) == 0x00000002);
  }
  /**
   * <pre>
   * 物品ID
   * </pre>
   *
   * <code>optional int32 itemID = 2;</code>
   */
  public int getItemID() {
    return itemID_;
  }

  public static final int ITEMCOUNT_FIELD_NUMBER = 3;
  private int itemCount_;
  /**
   * <pre>
   * 物品数量
   * </pre>
   *
   * <code>optional int32 itemCount = 3;</code>
   */
  public boolean hasItemCount() {
    return ((bitField0_ & 0x00000004) == 0x00000004);
  }
  /**
   * <pre>
   * 物品数量
   * </pre>
   *
   * <code>optional int32 itemCount = 3;</code>
   */
  public int getItemCount() {
    return itemCount_;
  }

  public static final int PS_FIELD_NUMBER = 4;
  private volatile java.lang.Object ps_;
  /**
   * <pre>
   * 备注
   * </pre>
   *
   * <code>optional string ps = 4;</code>
   */
  public boolean hasPs() {
    return ((bitField0_ & 0x00000008) == 0x00000008);
  }
  /**
   * <pre>
   * 备注
   * </pre>
   *
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
   * <pre>
   * 备注
   * </pre>
   *
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

  public static final int INTERACTTIME_FIELD_NUMBER = 5;
  private com.dj.protobuf.datetime.DateTime interactTime_;
  /**
   * <pre>
   * 互动时间
   * </pre>
   *
   * <code>optional .Protocols.DateTime interactTime = 5;</code>
   */
  public boolean hasInteractTime() {
    return ((bitField0_ & 0x00000010) == 0x00000010);
  }
  /**
   * <pre>
   * 互动时间
   * </pre>
   *
   * <code>optional .Protocols.DateTime interactTime = 5;</code>
   */
  public com.dj.protobuf.datetime.DateTime getInteractTime() {
    return interactTime_ == null ? com.dj.protobuf.datetime.DateTime.getDefaultInstance() : interactTime_;
  }
  /**
   * <pre>
   * 互动时间
   * </pre>
   *
   * <code>optional .Protocols.DateTime interactTime = 5;</code>
   */
  public com.dj.protobuf.datetime.DateTimeOrBuilder getInteractTimeOrBuilder() {
    return interactTime_ == null ? com.dj.protobuf.datetime.DateTime.getDefaultInstance() : interactTime_;
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
      output.writeMessage(1, getInteractRoleInfo());
    }
    if (((bitField0_ & 0x00000002) == 0x00000002)) {
      output.writeInt32(2, itemID_);
    }
    if (((bitField0_ & 0x00000004) == 0x00000004)) {
      output.writeInt32(3, itemCount_);
    }
    if (((bitField0_ & 0x00000008) == 0x00000008)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 4, ps_);
    }
    if (((bitField0_ & 0x00000010) == 0x00000010)) {
      output.writeMessage(5, getInteractTime());
    }
    unknownFields.writeTo(output);
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (((bitField0_ & 0x00000001) == 0x00000001)) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, getInteractRoleInfo());
    }
    if (((bitField0_ & 0x00000002) == 0x00000002)) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(2, itemID_);
    }
    if (((bitField0_ & 0x00000004) == 0x00000004)) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(3, itemCount_);
    }
    if (((bitField0_ & 0x00000008) == 0x00000008)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(4, ps_);
    }
    if (((bitField0_ & 0x00000010) == 0x00000010)) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(5, getInteractTime());
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
    if (!(obj instanceof com.dj.protobuf.item.ItemInteractHistory)) {
      return super.equals(obj);
    }
    com.dj.protobuf.item.ItemInteractHistory other = (com.dj.protobuf.item.ItemInteractHistory) obj;

    boolean result = true;
    result = result && (hasInteractRoleInfo() == other.hasInteractRoleInfo());
    if (hasInteractRoleInfo()) {
      result = result && getInteractRoleInfo()
          .equals(other.getInteractRoleInfo());
    }
    result = result && (hasItemID() == other.hasItemID());
    if (hasItemID()) {
      result = result && (getItemID()
          == other.getItemID());
    }
    result = result && (hasItemCount() == other.hasItemCount());
    if (hasItemCount()) {
      result = result && (getItemCount()
          == other.getItemCount());
    }
    result = result && (hasPs() == other.hasPs());
    if (hasPs()) {
      result = result && getPs()
          .equals(other.getPs());
    }
    result = result && (hasInteractTime() == other.hasInteractTime());
    if (hasInteractTime()) {
      result = result && getInteractTime()
          .equals(other.getInteractTime());
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
    if (hasInteractRoleInfo()) {
      hash = (37 * hash) + INTERACTROLEINFO_FIELD_NUMBER;
      hash = (53 * hash) + getInteractRoleInfo().hashCode();
    }
    if (hasItemID()) {
      hash = (37 * hash) + ITEMID_FIELD_NUMBER;
      hash = (53 * hash) + getItemID();
    }
    if (hasItemCount()) {
      hash = (37 * hash) + ITEMCOUNT_FIELD_NUMBER;
      hash = (53 * hash) + getItemCount();
    }
    if (hasPs()) {
      hash = (37 * hash) + PS_FIELD_NUMBER;
      hash = (53 * hash) + getPs().hashCode();
    }
    if (hasInteractTime()) {
      hash = (37 * hash) + INTERACTTIME_FIELD_NUMBER;
      hash = (53 * hash) + getInteractTime().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.dj.protobuf.item.ItemInteractHistory parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dj.protobuf.item.ItemInteractHistory parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dj.protobuf.item.ItemInteractHistory parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dj.protobuf.item.ItemInteractHistory parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dj.protobuf.item.ItemInteractHistory parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.item.ItemInteractHistory parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.dj.protobuf.item.ItemInteractHistory parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.item.ItemInteractHistory parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.dj.protobuf.item.ItemInteractHistory parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.item.ItemInteractHistory parseFrom(
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
  public static Builder newBuilder(com.dj.protobuf.item.ItemInteractHistory prototype) {
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
   * 好友互动物品历史记录
   * </pre>
   *
   * Protobuf type {@code Protocols.ItemInteractHistory}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:Protocols.ItemInteractHistory)
      com.dj.protobuf.item.ItemInteractHistoryOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.dj.protobuf.item.Item.internal_static_Protocols_ItemInteractHistory_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.dj.protobuf.item.Item.internal_static_Protocols_ItemInteractHistory_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.dj.protobuf.item.ItemInteractHistory.class, com.dj.protobuf.item.ItemInteractHistory.Builder.class);
    }

    // Construct using com.dj.protobuf.item.ItemInteractHistory.newBuilder()
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
        getInteractRoleInfoFieldBuilder();
        getInteractTimeFieldBuilder();
      }
    }
    public Builder clear() {
      super.clear();
      if (interactRoleInfoBuilder_ == null) {
        interactRoleInfo_ = null;
      } else {
        interactRoleInfoBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000001);
      itemID_ = 0;
      bitField0_ = (bitField0_ & ~0x00000002);
      itemCount_ = 0;
      bitField0_ = (bitField0_ & ~0x00000004);
      ps_ = "";
      bitField0_ = (bitField0_ & ~0x00000008);
      if (interactTimeBuilder_ == null) {
        interactTime_ = null;
      } else {
        interactTimeBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000010);
      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.dj.protobuf.item.Item.internal_static_Protocols_ItemInteractHistory_descriptor;
    }

    public com.dj.protobuf.item.ItemInteractHistory getDefaultInstanceForType() {
      return com.dj.protobuf.item.ItemInteractHistory.getDefaultInstance();
    }

    public com.dj.protobuf.item.ItemInteractHistory build() {
      com.dj.protobuf.item.ItemInteractHistory result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public com.dj.protobuf.item.ItemInteractHistory buildPartial() {
      com.dj.protobuf.item.ItemInteractHistory result = new com.dj.protobuf.item.ItemInteractHistory(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
        to_bitField0_ |= 0x00000001;
      }
      if (interactRoleInfoBuilder_ == null) {
        result.interactRoleInfo_ = interactRoleInfo_;
      } else {
        result.interactRoleInfo_ = interactRoleInfoBuilder_.build();
      }
      if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
        to_bitField0_ |= 0x00000002;
      }
      result.itemID_ = itemID_;
      if (((from_bitField0_ & 0x00000004) == 0x00000004)) {
        to_bitField0_ |= 0x00000004;
      }
      result.itemCount_ = itemCount_;
      if (((from_bitField0_ & 0x00000008) == 0x00000008)) {
        to_bitField0_ |= 0x00000008;
      }
      result.ps_ = ps_;
      if (((from_bitField0_ & 0x00000010) == 0x00000010)) {
        to_bitField0_ |= 0x00000010;
      }
      if (interactTimeBuilder_ == null) {
        result.interactTime_ = interactTime_;
      } else {
        result.interactTime_ = interactTimeBuilder_.build();
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
      if (other instanceof com.dj.protobuf.item.ItemInteractHistory) {
        return mergeFrom((com.dj.protobuf.item.ItemInteractHistory)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.dj.protobuf.item.ItemInteractHistory other) {
      if (other == com.dj.protobuf.item.ItemInteractHistory.getDefaultInstance()) return this;
      if (other.hasInteractRoleInfo()) {
        mergeInteractRoleInfo(other.getInteractRoleInfo());
      }
      if (other.hasItemID()) {
        setItemID(other.getItemID());
      }
      if (other.hasItemCount()) {
        setItemCount(other.getItemCount());
      }
      if (other.hasPs()) {
        bitField0_ |= 0x00000008;
        ps_ = other.ps_;
        onChanged();
      }
      if (other.hasInteractTime()) {
        mergeInteractTime(other.getInteractTime());
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
      com.dj.protobuf.item.ItemInteractHistory parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.dj.protobuf.item.ItemInteractHistory) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private com.dj.protobuf.common.BaseRoleInfo interactRoleInfo_ = null;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.dj.protobuf.common.BaseRoleInfo, com.dj.protobuf.common.BaseRoleInfo.Builder, com.dj.protobuf.common.BaseRoleInfoOrBuilder> interactRoleInfoBuilder_;
    /**
     * <pre>
     * 互动人
     * </pre>
     *
     * <code>optional .Protocols.BaseRoleInfo interactRoleInfo = 1;</code>
     */
    public boolean hasInteractRoleInfo() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <pre>
     * 互动人
     * </pre>
     *
     * <code>optional .Protocols.BaseRoleInfo interactRoleInfo = 1;</code>
     */
    public com.dj.protobuf.common.BaseRoleInfo getInteractRoleInfo() {
      if (interactRoleInfoBuilder_ == null) {
        return interactRoleInfo_ == null ? com.dj.protobuf.common.BaseRoleInfo.getDefaultInstance() : interactRoleInfo_;
      } else {
        return interactRoleInfoBuilder_.getMessage();
      }
    }
    /**
     * <pre>
     * 互动人
     * </pre>
     *
     * <code>optional .Protocols.BaseRoleInfo interactRoleInfo = 1;</code>
     */
    public Builder setInteractRoleInfo(com.dj.protobuf.common.BaseRoleInfo value) {
      if (interactRoleInfoBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        interactRoleInfo_ = value;
        onChanged();
      } else {
        interactRoleInfoBuilder_.setMessage(value);
      }
      bitField0_ |= 0x00000001;
      return this;
    }
    /**
     * <pre>
     * 互动人
     * </pre>
     *
     * <code>optional .Protocols.BaseRoleInfo interactRoleInfo = 1;</code>
     */
    public Builder setInteractRoleInfo(
        com.dj.protobuf.common.BaseRoleInfo.Builder builderForValue) {
      if (interactRoleInfoBuilder_ == null) {
        interactRoleInfo_ = builderForValue.build();
        onChanged();
      } else {
        interactRoleInfoBuilder_.setMessage(builderForValue.build());
      }
      bitField0_ |= 0x00000001;
      return this;
    }
    /**
     * <pre>
     * 互动人
     * </pre>
     *
     * <code>optional .Protocols.BaseRoleInfo interactRoleInfo = 1;</code>
     */
    public Builder mergeInteractRoleInfo(com.dj.protobuf.common.BaseRoleInfo value) {
      if (interactRoleInfoBuilder_ == null) {
        if (((bitField0_ & 0x00000001) == 0x00000001) &&
            interactRoleInfo_ != null &&
            interactRoleInfo_ != com.dj.protobuf.common.BaseRoleInfo.getDefaultInstance()) {
          interactRoleInfo_ =
            com.dj.protobuf.common.BaseRoleInfo.newBuilder(interactRoleInfo_).mergeFrom(value).buildPartial();
        } else {
          interactRoleInfo_ = value;
        }
        onChanged();
      } else {
        interactRoleInfoBuilder_.mergeFrom(value);
      }
      bitField0_ |= 0x00000001;
      return this;
    }
    /**
     * <pre>
     * 互动人
     * </pre>
     *
     * <code>optional .Protocols.BaseRoleInfo interactRoleInfo = 1;</code>
     */
    public Builder clearInteractRoleInfo() {
      if (interactRoleInfoBuilder_ == null) {
        interactRoleInfo_ = null;
        onChanged();
      } else {
        interactRoleInfoBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000001);
      return this;
    }
    /**
     * <pre>
     * 互动人
     * </pre>
     *
     * <code>optional .Protocols.BaseRoleInfo interactRoleInfo = 1;</code>
     */
    public com.dj.protobuf.common.BaseRoleInfo.Builder getInteractRoleInfoBuilder() {
      bitField0_ |= 0x00000001;
      onChanged();
      return getInteractRoleInfoFieldBuilder().getBuilder();
    }
    /**
     * <pre>
     * 互动人
     * </pre>
     *
     * <code>optional .Protocols.BaseRoleInfo interactRoleInfo = 1;</code>
     */
    public com.dj.protobuf.common.BaseRoleInfoOrBuilder getInteractRoleInfoOrBuilder() {
      if (interactRoleInfoBuilder_ != null) {
        return interactRoleInfoBuilder_.getMessageOrBuilder();
      } else {
        return interactRoleInfo_ == null ?
            com.dj.protobuf.common.BaseRoleInfo.getDefaultInstance() : interactRoleInfo_;
      }
    }
    /**
     * <pre>
     * 互动人
     * </pre>
     *
     * <code>optional .Protocols.BaseRoleInfo interactRoleInfo = 1;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.dj.protobuf.common.BaseRoleInfo, com.dj.protobuf.common.BaseRoleInfo.Builder, com.dj.protobuf.common.BaseRoleInfoOrBuilder> 
        getInteractRoleInfoFieldBuilder() {
      if (interactRoleInfoBuilder_ == null) {
        interactRoleInfoBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.dj.protobuf.common.BaseRoleInfo, com.dj.protobuf.common.BaseRoleInfo.Builder, com.dj.protobuf.common.BaseRoleInfoOrBuilder>(
                getInteractRoleInfo(),
                getParentForChildren(),
                isClean());
        interactRoleInfo_ = null;
      }
      return interactRoleInfoBuilder_;
    }

    private int itemID_ ;
    /**
     * <pre>
     * 物品ID
     * </pre>
     *
     * <code>optional int32 itemID = 2;</code>
     */
    public boolean hasItemID() {
      return ((bitField0_ & 0x00000002) == 0x00000002);
    }
    /**
     * <pre>
     * 物品ID
     * </pre>
     *
     * <code>optional int32 itemID = 2;</code>
     */
    public int getItemID() {
      return itemID_;
    }
    /**
     * <pre>
     * 物品ID
     * </pre>
     *
     * <code>optional int32 itemID = 2;</code>
     */
    public Builder setItemID(int value) {
      bitField0_ |= 0x00000002;
      itemID_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * 物品ID
     * </pre>
     *
     * <code>optional int32 itemID = 2;</code>
     */
    public Builder clearItemID() {
      bitField0_ = (bitField0_ & ~0x00000002);
      itemID_ = 0;
      onChanged();
      return this;
    }

    private int itemCount_ ;
    /**
     * <pre>
     * 物品数量
     * </pre>
     *
     * <code>optional int32 itemCount = 3;</code>
     */
    public boolean hasItemCount() {
      return ((bitField0_ & 0x00000004) == 0x00000004);
    }
    /**
     * <pre>
     * 物品数量
     * </pre>
     *
     * <code>optional int32 itemCount = 3;</code>
     */
    public int getItemCount() {
      return itemCount_;
    }
    /**
     * <pre>
     * 物品数量
     * </pre>
     *
     * <code>optional int32 itemCount = 3;</code>
     */
    public Builder setItemCount(int value) {
      bitField0_ |= 0x00000004;
      itemCount_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * 物品数量
     * </pre>
     *
     * <code>optional int32 itemCount = 3;</code>
     */
    public Builder clearItemCount() {
      bitField0_ = (bitField0_ & ~0x00000004);
      itemCount_ = 0;
      onChanged();
      return this;
    }

    private java.lang.Object ps_ = "";
    /**
     * <pre>
     * 备注
     * </pre>
     *
     * <code>optional string ps = 4;</code>
     */
    public boolean hasPs() {
      return ((bitField0_ & 0x00000008) == 0x00000008);
    }
    /**
     * <pre>
     * 备注
     * </pre>
     *
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
     * <pre>
     * 备注
     * </pre>
     *
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
     * <pre>
     * 备注
     * </pre>
     *
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
     * <pre>
     * 备注
     * </pre>
     *
     * <code>optional string ps = 4;</code>
     */
    public Builder clearPs() {
      bitField0_ = (bitField0_ & ~0x00000008);
      ps_ = getDefaultInstance().getPs();
      onChanged();
      return this;
    }
    /**
     * <pre>
     * 备注
     * </pre>
     *
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

    private com.dj.protobuf.datetime.DateTime interactTime_ = null;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.dj.protobuf.datetime.DateTime, com.dj.protobuf.datetime.DateTime.Builder, com.dj.protobuf.datetime.DateTimeOrBuilder> interactTimeBuilder_;
    /**
     * <pre>
     * 互动时间
     * </pre>
     *
     * <code>optional .Protocols.DateTime interactTime = 5;</code>
     */
    public boolean hasInteractTime() {
      return ((bitField0_ & 0x00000010) == 0x00000010);
    }
    /**
     * <pre>
     * 互动时间
     * </pre>
     *
     * <code>optional .Protocols.DateTime interactTime = 5;</code>
     */
    public com.dj.protobuf.datetime.DateTime getInteractTime() {
      if (interactTimeBuilder_ == null) {
        return interactTime_ == null ? com.dj.protobuf.datetime.DateTime.getDefaultInstance() : interactTime_;
      } else {
        return interactTimeBuilder_.getMessage();
      }
    }
    /**
     * <pre>
     * 互动时间
     * </pre>
     *
     * <code>optional .Protocols.DateTime interactTime = 5;</code>
     */
    public Builder setInteractTime(com.dj.protobuf.datetime.DateTime value) {
      if (interactTimeBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        interactTime_ = value;
        onChanged();
      } else {
        interactTimeBuilder_.setMessage(value);
      }
      bitField0_ |= 0x00000010;
      return this;
    }
    /**
     * <pre>
     * 互动时间
     * </pre>
     *
     * <code>optional .Protocols.DateTime interactTime = 5;</code>
     */
    public Builder setInteractTime(
        com.dj.protobuf.datetime.DateTime.Builder builderForValue) {
      if (interactTimeBuilder_ == null) {
        interactTime_ = builderForValue.build();
        onChanged();
      } else {
        interactTimeBuilder_.setMessage(builderForValue.build());
      }
      bitField0_ |= 0x00000010;
      return this;
    }
    /**
     * <pre>
     * 互动时间
     * </pre>
     *
     * <code>optional .Protocols.DateTime interactTime = 5;</code>
     */
    public Builder mergeInteractTime(com.dj.protobuf.datetime.DateTime value) {
      if (interactTimeBuilder_ == null) {
        if (((bitField0_ & 0x00000010) == 0x00000010) &&
            interactTime_ != null &&
            interactTime_ != com.dj.protobuf.datetime.DateTime.getDefaultInstance()) {
          interactTime_ =
            com.dj.protobuf.datetime.DateTime.newBuilder(interactTime_).mergeFrom(value).buildPartial();
        } else {
          interactTime_ = value;
        }
        onChanged();
      } else {
        interactTimeBuilder_.mergeFrom(value);
      }
      bitField0_ |= 0x00000010;
      return this;
    }
    /**
     * <pre>
     * 互动时间
     * </pre>
     *
     * <code>optional .Protocols.DateTime interactTime = 5;</code>
     */
    public Builder clearInteractTime() {
      if (interactTimeBuilder_ == null) {
        interactTime_ = null;
        onChanged();
      } else {
        interactTimeBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000010);
      return this;
    }
    /**
     * <pre>
     * 互动时间
     * </pre>
     *
     * <code>optional .Protocols.DateTime interactTime = 5;</code>
     */
    public com.dj.protobuf.datetime.DateTime.Builder getInteractTimeBuilder() {
      bitField0_ |= 0x00000010;
      onChanged();
      return getInteractTimeFieldBuilder().getBuilder();
    }
    /**
     * <pre>
     * 互动时间
     * </pre>
     *
     * <code>optional .Protocols.DateTime interactTime = 5;</code>
     */
    public com.dj.protobuf.datetime.DateTimeOrBuilder getInteractTimeOrBuilder() {
      if (interactTimeBuilder_ != null) {
        return interactTimeBuilder_.getMessageOrBuilder();
      } else {
        return interactTime_ == null ?
            com.dj.protobuf.datetime.DateTime.getDefaultInstance() : interactTime_;
      }
    }
    /**
     * <pre>
     * 互动时间
     * </pre>
     *
     * <code>optional .Protocols.DateTime interactTime = 5;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.dj.protobuf.datetime.DateTime, com.dj.protobuf.datetime.DateTime.Builder, com.dj.protobuf.datetime.DateTimeOrBuilder> 
        getInteractTimeFieldBuilder() {
      if (interactTimeBuilder_ == null) {
        interactTimeBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.dj.protobuf.datetime.DateTime, com.dj.protobuf.datetime.DateTime.Builder, com.dj.protobuf.datetime.DateTimeOrBuilder>(
                getInteractTime(),
                getParentForChildren(),
                isClean());
        interactTime_ = null;
      }
      return interactTimeBuilder_;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:Protocols.ItemInteractHistory)
  }

  // @@protoc_insertion_point(class_scope:Protocols.ItemInteractHistory)
  private static final com.dj.protobuf.item.ItemInteractHistory DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.dj.protobuf.item.ItemInteractHistory();
  }

  public static com.dj.protobuf.item.ItemInteractHistory getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  @java.lang.Deprecated public static final com.google.protobuf.Parser<ItemInteractHistory>
      PARSER = new com.google.protobuf.AbstractParser<ItemInteractHistory>() {
    public ItemInteractHistory parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new ItemInteractHistory(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<ItemInteractHistory> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<ItemInteractHistory> getParserForType() {
    return PARSER;
  }

  public com.dj.protobuf.item.ItemInteractHistory getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

