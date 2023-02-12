// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: City.proto

package com.dj.protobuf.city;

/**
 * <pre>
 *赛马
 * </pre>
 *
 * Protobuf type {@code Protocols.NpcRaceHorsesReq}
 */
public  final class NpcRaceHorsesReq extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:Protocols.NpcRaceHorsesReq)
    NpcRaceHorsesReqOrBuilder {
  // Use NpcRaceHorsesReq.newBuilder() to construct.
  private NpcRaceHorsesReq(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private NpcRaceHorsesReq() {
    houseID_ = 0;
    itemId_ = 0;
    itemCount_ = 0;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private NpcRaceHorsesReq(
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
            houseID_ = input.readInt32();
            break;
          }
          case 16: {
            bitField0_ |= 0x00000002;
            itemId_ = input.readInt32();
            break;
          }
          case 24: {
            bitField0_ |= 0x00000004;
            itemCount_ = input.readInt32();
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
    return com.dj.protobuf.city.City.internal_static_Protocols_NpcRaceHorsesReq_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.dj.protobuf.city.City.internal_static_Protocols_NpcRaceHorsesReq_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.dj.protobuf.city.NpcRaceHorsesReq.class, com.dj.protobuf.city.NpcRaceHorsesReq.Builder.class);
  }

  private int bitField0_;
  public static final int HOUSEID_FIELD_NUMBER = 1;
  private int houseID_;
  /**
   * <code>optional int32 houseID = 1;</code>
   */
  public boolean hasHouseID() {
    return ((bitField0_ & 0x00000001) == 0x00000001);
  }
  /**
   * <code>optional int32 houseID = 1;</code>
   */
  public int getHouseID() {
    return houseID_;
  }

  public static final int ITEMID_FIELD_NUMBER = 2;
  private int itemId_;
  /**
   * <code>optional int32 itemId = 2;</code>
   */
  public boolean hasItemId() {
    return ((bitField0_ & 0x00000002) == 0x00000002);
  }
  /**
   * <code>optional int32 itemId = 2;</code>
   */
  public int getItemId() {
    return itemId_;
  }

  public static final int ITEMCOUNT_FIELD_NUMBER = 3;
  private int itemCount_;
  /**
   * <code>optional int32 itemCount = 3;</code>
   */
  public boolean hasItemCount() {
    return ((bitField0_ & 0x00000004) == 0x00000004);
  }
  /**
   * <code>optional int32 itemCount = 3;</code>
   */
  public int getItemCount() {
    return itemCount_;
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
      output.writeInt32(1, houseID_);
    }
    if (((bitField0_ & 0x00000002) == 0x00000002)) {
      output.writeInt32(2, itemId_);
    }
    if (((bitField0_ & 0x00000004) == 0x00000004)) {
      output.writeInt32(3, itemCount_);
    }
    unknownFields.writeTo(output);
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (((bitField0_ & 0x00000001) == 0x00000001)) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(1, houseID_);
    }
    if (((bitField0_ & 0x00000002) == 0x00000002)) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(2, itemId_);
    }
    if (((bitField0_ & 0x00000004) == 0x00000004)) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(3, itemCount_);
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
    if (!(obj instanceof com.dj.protobuf.city.NpcRaceHorsesReq)) {
      return super.equals(obj);
    }
    com.dj.protobuf.city.NpcRaceHorsesReq other = (com.dj.protobuf.city.NpcRaceHorsesReq) obj;

    boolean result = true;
    result = result && (hasHouseID() == other.hasHouseID());
    if (hasHouseID()) {
      result = result && (getHouseID()
          == other.getHouseID());
    }
    result = result && (hasItemId() == other.hasItemId());
    if (hasItemId()) {
      result = result && (getItemId()
          == other.getItemId());
    }
    result = result && (hasItemCount() == other.hasItemCount());
    if (hasItemCount()) {
      result = result && (getItemCount()
          == other.getItemCount());
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
    if (hasHouseID()) {
      hash = (37 * hash) + HOUSEID_FIELD_NUMBER;
      hash = (53 * hash) + getHouseID();
    }
    if (hasItemId()) {
      hash = (37 * hash) + ITEMID_FIELD_NUMBER;
      hash = (53 * hash) + getItemId();
    }
    if (hasItemCount()) {
      hash = (37 * hash) + ITEMCOUNT_FIELD_NUMBER;
      hash = (53 * hash) + getItemCount();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.dj.protobuf.city.NpcRaceHorsesReq parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dj.protobuf.city.NpcRaceHorsesReq parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dj.protobuf.city.NpcRaceHorsesReq parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dj.protobuf.city.NpcRaceHorsesReq parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dj.protobuf.city.NpcRaceHorsesReq parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.city.NpcRaceHorsesReq parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.dj.protobuf.city.NpcRaceHorsesReq parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.city.NpcRaceHorsesReq parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.dj.protobuf.city.NpcRaceHorsesReq parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.city.NpcRaceHorsesReq parseFrom(
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
  public static Builder newBuilder(com.dj.protobuf.city.NpcRaceHorsesReq prototype) {
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
   *赛马
   * </pre>
   *
   * Protobuf type {@code Protocols.NpcRaceHorsesReq}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:Protocols.NpcRaceHorsesReq)
      com.dj.protobuf.city.NpcRaceHorsesReqOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.dj.protobuf.city.City.internal_static_Protocols_NpcRaceHorsesReq_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.dj.protobuf.city.City.internal_static_Protocols_NpcRaceHorsesReq_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.dj.protobuf.city.NpcRaceHorsesReq.class, com.dj.protobuf.city.NpcRaceHorsesReq.Builder.class);
    }

    // Construct using com.dj.protobuf.city.NpcRaceHorsesReq.newBuilder()
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
      houseID_ = 0;
      bitField0_ = (bitField0_ & ~0x00000001);
      itemId_ = 0;
      bitField0_ = (bitField0_ & ~0x00000002);
      itemCount_ = 0;
      bitField0_ = (bitField0_ & ~0x00000004);
      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.dj.protobuf.city.City.internal_static_Protocols_NpcRaceHorsesReq_descriptor;
    }

    public com.dj.protobuf.city.NpcRaceHorsesReq getDefaultInstanceForType() {
      return com.dj.protobuf.city.NpcRaceHorsesReq.getDefaultInstance();
    }

    public com.dj.protobuf.city.NpcRaceHorsesReq build() {
      com.dj.protobuf.city.NpcRaceHorsesReq result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public com.dj.protobuf.city.NpcRaceHorsesReq buildPartial() {
      com.dj.protobuf.city.NpcRaceHorsesReq result = new com.dj.protobuf.city.NpcRaceHorsesReq(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
        to_bitField0_ |= 0x00000001;
      }
      result.houseID_ = houseID_;
      if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
        to_bitField0_ |= 0x00000002;
      }
      result.itemId_ = itemId_;
      if (((from_bitField0_ & 0x00000004) == 0x00000004)) {
        to_bitField0_ |= 0x00000004;
      }
      result.itemCount_ = itemCount_;
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
      if (other instanceof com.dj.protobuf.city.NpcRaceHorsesReq) {
        return mergeFrom((com.dj.protobuf.city.NpcRaceHorsesReq)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.dj.protobuf.city.NpcRaceHorsesReq other) {
      if (other == com.dj.protobuf.city.NpcRaceHorsesReq.getDefaultInstance()) return this;
      if (other.hasHouseID()) {
        setHouseID(other.getHouseID());
      }
      if (other.hasItemId()) {
        setItemId(other.getItemId());
      }
      if (other.hasItemCount()) {
        setItemCount(other.getItemCount());
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
      com.dj.protobuf.city.NpcRaceHorsesReq parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.dj.protobuf.city.NpcRaceHorsesReq) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private int houseID_ ;
    /**
     * <code>optional int32 houseID = 1;</code>
     */
    public boolean hasHouseID() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <code>optional int32 houseID = 1;</code>
     */
    public int getHouseID() {
      return houseID_;
    }
    /**
     * <code>optional int32 houseID = 1;</code>
     */
    public Builder setHouseID(int value) {
      bitField0_ |= 0x00000001;
      houseID_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional int32 houseID = 1;</code>
     */
    public Builder clearHouseID() {
      bitField0_ = (bitField0_ & ~0x00000001);
      houseID_ = 0;
      onChanged();
      return this;
    }

    private int itemId_ ;
    /**
     * <code>optional int32 itemId = 2;</code>
     */
    public boolean hasItemId() {
      return ((bitField0_ & 0x00000002) == 0x00000002);
    }
    /**
     * <code>optional int32 itemId = 2;</code>
     */
    public int getItemId() {
      return itemId_;
    }
    /**
     * <code>optional int32 itemId = 2;</code>
     */
    public Builder setItemId(int value) {
      bitField0_ |= 0x00000002;
      itemId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional int32 itemId = 2;</code>
     */
    public Builder clearItemId() {
      bitField0_ = (bitField0_ & ~0x00000002);
      itemId_ = 0;
      onChanged();
      return this;
    }

    private int itemCount_ ;
    /**
     * <code>optional int32 itemCount = 3;</code>
     */
    public boolean hasItemCount() {
      return ((bitField0_ & 0x00000004) == 0x00000004);
    }
    /**
     * <code>optional int32 itemCount = 3;</code>
     */
    public int getItemCount() {
      return itemCount_;
    }
    /**
     * <code>optional int32 itemCount = 3;</code>
     */
    public Builder setItemCount(int value) {
      bitField0_ |= 0x00000004;
      itemCount_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional int32 itemCount = 3;</code>
     */
    public Builder clearItemCount() {
      bitField0_ = (bitField0_ & ~0x00000004);
      itemCount_ = 0;
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


    // @@protoc_insertion_point(builder_scope:Protocols.NpcRaceHorsesReq)
  }

  // @@protoc_insertion_point(class_scope:Protocols.NpcRaceHorsesReq)
  private static final com.dj.protobuf.city.NpcRaceHorsesReq DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.dj.protobuf.city.NpcRaceHorsesReq();
  }

  public static com.dj.protobuf.city.NpcRaceHorsesReq getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  @java.lang.Deprecated public static final com.google.protobuf.Parser<NpcRaceHorsesReq>
      PARSER = new com.google.protobuf.AbstractParser<NpcRaceHorsesReq>() {
    public NpcRaceHorsesReq parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new NpcRaceHorsesReq(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<NpcRaceHorsesReq> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<NpcRaceHorsesReq> getParserForType() {
    return PARSER;
  }

  public com.dj.protobuf.city.NpcRaceHorsesReq getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
