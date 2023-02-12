// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Park.proto

package com.dj.protobuf.park;

/**
 * <pre>
 *&#47; &lt;summary&gt;
 * / 地图格子
 * / &lt;/summary&gt;
 * </pre>
 *
 * Protobuf type {@code Protocols.ParkCell}
 */
public  final class ParkCell extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:Protocols.ParkCell)
    ParkCellOrBuilder {
  // Use ParkCell.newBuilder() to construct.
  private ParkCell(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private ParkCell() {
    x_ = 0;
    y_ = 0;
    plantID_ = 0;
    leftSeconds_ = 0;
    green_ = 0;
    harvestNum_ = 0;
    status_ = -1;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private ParkCell(
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
            x_ = input.readInt32();
            break;
          }
          case 16: {
            bitField0_ |= 0x00000002;
            y_ = input.readInt32();
            break;
          }
          case 24: {
            bitField0_ |= 0x00000004;
            plantID_ = input.readInt32();
            break;
          }
          case 32: {
            bitField0_ |= 0x00000008;
            leftSeconds_ = input.readInt32();
            break;
          }
          case 42: {
            com.dj.protobuf.datetime.DateTime.Builder subBuilder = null;
            if (((bitField0_ & 0x00000010) == 0x00000010)) {
              subBuilder = placeTime_.toBuilder();
            }
            placeTime_ = input.readMessage(com.dj.protobuf.datetime.DateTime.PARSER, extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(placeTime_);
              placeTime_ = subBuilder.buildPartial();
            }
            bitField0_ |= 0x00000010;
            break;
          }
          case 48: {
            bitField0_ |= 0x00000020;
            green_ = input.readInt32();
            break;
          }
          case 56: {
            bitField0_ |= 0x00000040;
            harvestNum_ = input.readInt32();
            break;
          }
          case 64: {
            int rawValue = input.readEnum();
            com.dj.protobuf.park.ParkStatus value = com.dj.protobuf.park.ParkStatus.valueOf(rawValue);
            if (value == null) {
              unknownFields.mergeVarintField(8, rawValue);
            } else {
              bitField0_ |= 0x00000080;
              status_ = rawValue;
            }
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
    return com.dj.protobuf.park.Park.internal_static_Protocols_ParkCell_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.dj.protobuf.park.Park.internal_static_Protocols_ParkCell_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.dj.protobuf.park.ParkCell.class, com.dj.protobuf.park.ParkCell.Builder.class);
  }

  private int bitField0_;
  public static final int X_FIELD_NUMBER = 1;
  private int x_;
  /**
   * <code>optional int32 x = 1;</code>
   */
  public boolean hasX() {
    return ((bitField0_ & 0x00000001) == 0x00000001);
  }
  /**
   * <code>optional int32 x = 1;</code>
   */
  public int getX() {
    return x_;
  }

  public static final int Y_FIELD_NUMBER = 2;
  private int y_;
  /**
   * <code>optional int32 y = 2;</code>
   */
  public boolean hasY() {
    return ((bitField0_ & 0x00000002) == 0x00000002);
  }
  /**
   * <code>optional int32 y = 2;</code>
   */
  public int getY() {
    return y_;
  }

  public static final int PLANTID_FIELD_NUMBER = 3;
  private int plantID_;
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 植物ID
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional int32 plantID = 3;</code>
   */
  public boolean hasPlantID() {
    return ((bitField0_ & 0x00000004) == 0x00000004);
  }
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 植物ID
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional int32 plantID = 3;</code>
   */
  public int getPlantID() {
    return plantID_;
  }

  public static final int LEFTSECONDS_FIELD_NUMBER = 4;
  private int leftSeconds_;
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 距离成熟的秒数
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional int32 leftSeconds = 4;</code>
   */
  public boolean hasLeftSeconds() {
    return ((bitField0_ & 0x00000008) == 0x00000008);
  }
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 距离成熟的秒数
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional int32 leftSeconds = 4;</code>
   */
  public int getLeftSeconds() {
    return leftSeconds_;
  }

  public static final int PLACETIME_FIELD_NUMBER = 5;
  private com.dj.protobuf.datetime.DateTime placeTime_;
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 放置时间
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional .Protocols.DateTime placeTime = 5;</code>
   */
  public boolean hasPlaceTime() {
    return ((bitField0_ & 0x00000010) == 0x00000010);
  }
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 放置时间
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional .Protocols.DateTime placeTime = 5;</code>
   */
  public com.dj.protobuf.datetime.DateTime getPlaceTime() {
    return placeTime_ == null ? com.dj.protobuf.datetime.DateTime.getDefaultInstance() : placeTime_;
  }
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 放置时间
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional .Protocols.DateTime placeTime = 5;</code>
   */
  public com.dj.protobuf.datetime.DateTimeOrBuilder getPlaceTimeOrBuilder() {
    return placeTime_ == null ? com.dj.protobuf.datetime.DateTime.getDefaultInstance() : placeTime_;
  }

  public static final int GREEN_FIELD_NUMBER = 6;
  private int green_;
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 绿化值
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional int32 green = 6;</code>
   */
  public boolean hasGreen() {
    return ((bitField0_ & 0x00000020) == 0x00000020);
  }
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 绿化值
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional int32 green = 6;</code>
   */
  public int getGreen() {
    return green_;
  }

  public static final int HARVESTNUM_FIELD_NUMBER = 7;
  private int harvestNum_;
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 收获次数
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional int32 harvestNum = 7;</code>
   */
  public boolean hasHarvestNum() {
    return ((bitField0_ & 0x00000040) == 0x00000040);
  }
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 收获次数
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional int32 harvestNum = 7;</code>
   */
  public int getHarvestNum() {
    return harvestNum_;
  }

  public static final int STATUS_FIELD_NUMBER = 8;
  private int status_;
  /**
   * <pre>
   *状态
   * </pre>
   *
   * <code>optional .Protocols.ParkStatus status = 8;</code>
   */
  public boolean hasStatus() {
    return ((bitField0_ & 0x00000080) == 0x00000080);
  }
  /**
   * <pre>
   *状态
   * </pre>
   *
   * <code>optional .Protocols.ParkStatus status = 8;</code>
   */
  public com.dj.protobuf.park.ParkStatus getStatus() {
    com.dj.protobuf.park.ParkStatus result = com.dj.protobuf.park.ParkStatus.valueOf(status_);
    return result == null ? com.dj.protobuf.park.ParkStatus.Hunger : result;
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
      output.writeInt32(1, x_);
    }
    if (((bitField0_ & 0x00000002) == 0x00000002)) {
      output.writeInt32(2, y_);
    }
    if (((bitField0_ & 0x00000004) == 0x00000004)) {
      output.writeInt32(3, plantID_);
    }
    if (((bitField0_ & 0x00000008) == 0x00000008)) {
      output.writeInt32(4, leftSeconds_);
    }
    if (((bitField0_ & 0x00000010) == 0x00000010)) {
      output.writeMessage(5, getPlaceTime());
    }
    if (((bitField0_ & 0x00000020) == 0x00000020)) {
      output.writeInt32(6, green_);
    }
    if (((bitField0_ & 0x00000040) == 0x00000040)) {
      output.writeInt32(7, harvestNum_);
    }
    if (((bitField0_ & 0x00000080) == 0x00000080)) {
      output.writeEnum(8, status_);
    }
    unknownFields.writeTo(output);
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (((bitField0_ & 0x00000001) == 0x00000001)) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(1, x_);
    }
    if (((bitField0_ & 0x00000002) == 0x00000002)) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(2, y_);
    }
    if (((bitField0_ & 0x00000004) == 0x00000004)) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(3, plantID_);
    }
    if (((bitField0_ & 0x00000008) == 0x00000008)) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(4, leftSeconds_);
    }
    if (((bitField0_ & 0x00000010) == 0x00000010)) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(5, getPlaceTime());
    }
    if (((bitField0_ & 0x00000020) == 0x00000020)) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(6, green_);
    }
    if (((bitField0_ & 0x00000040) == 0x00000040)) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(7, harvestNum_);
    }
    if (((bitField0_ & 0x00000080) == 0x00000080)) {
      size += com.google.protobuf.CodedOutputStream
        .computeEnumSize(8, status_);
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
    if (!(obj instanceof com.dj.protobuf.park.ParkCell)) {
      return super.equals(obj);
    }
    com.dj.protobuf.park.ParkCell other = (com.dj.protobuf.park.ParkCell) obj;

    boolean result = true;
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
    result = result && (hasPlantID() == other.hasPlantID());
    if (hasPlantID()) {
      result = result && (getPlantID()
          == other.getPlantID());
    }
    result = result && (hasLeftSeconds() == other.hasLeftSeconds());
    if (hasLeftSeconds()) {
      result = result && (getLeftSeconds()
          == other.getLeftSeconds());
    }
    result = result && (hasPlaceTime() == other.hasPlaceTime());
    if (hasPlaceTime()) {
      result = result && getPlaceTime()
          .equals(other.getPlaceTime());
    }
    result = result && (hasGreen() == other.hasGreen());
    if (hasGreen()) {
      result = result && (getGreen()
          == other.getGreen());
    }
    result = result && (hasHarvestNum() == other.hasHarvestNum());
    if (hasHarvestNum()) {
      result = result && (getHarvestNum()
          == other.getHarvestNum());
    }
    result = result && (hasStatus() == other.hasStatus());
    if (hasStatus()) {
      result = result && status_ == other.status_;
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
    if (hasX()) {
      hash = (37 * hash) + X_FIELD_NUMBER;
      hash = (53 * hash) + getX();
    }
    if (hasY()) {
      hash = (37 * hash) + Y_FIELD_NUMBER;
      hash = (53 * hash) + getY();
    }
    if (hasPlantID()) {
      hash = (37 * hash) + PLANTID_FIELD_NUMBER;
      hash = (53 * hash) + getPlantID();
    }
    if (hasLeftSeconds()) {
      hash = (37 * hash) + LEFTSECONDS_FIELD_NUMBER;
      hash = (53 * hash) + getLeftSeconds();
    }
    if (hasPlaceTime()) {
      hash = (37 * hash) + PLACETIME_FIELD_NUMBER;
      hash = (53 * hash) + getPlaceTime().hashCode();
    }
    if (hasGreen()) {
      hash = (37 * hash) + GREEN_FIELD_NUMBER;
      hash = (53 * hash) + getGreen();
    }
    if (hasHarvestNum()) {
      hash = (37 * hash) + HARVESTNUM_FIELD_NUMBER;
      hash = (53 * hash) + getHarvestNum();
    }
    if (hasStatus()) {
      hash = (37 * hash) + STATUS_FIELD_NUMBER;
      hash = (53 * hash) + status_;
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.dj.protobuf.park.ParkCell parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dj.protobuf.park.ParkCell parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dj.protobuf.park.ParkCell parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dj.protobuf.park.ParkCell parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dj.protobuf.park.ParkCell parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.park.ParkCell parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.dj.protobuf.park.ParkCell parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.park.ParkCell parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.dj.protobuf.park.ParkCell parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.park.ParkCell parseFrom(
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
  public static Builder newBuilder(com.dj.protobuf.park.ParkCell prototype) {
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
   * / 地图格子
   * / &lt;/summary&gt;
   * </pre>
   *
   * Protobuf type {@code Protocols.ParkCell}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:Protocols.ParkCell)
      com.dj.protobuf.park.ParkCellOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.dj.protobuf.park.Park.internal_static_Protocols_ParkCell_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.dj.protobuf.park.Park.internal_static_Protocols_ParkCell_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.dj.protobuf.park.ParkCell.class, com.dj.protobuf.park.ParkCell.Builder.class);
    }

    // Construct using com.dj.protobuf.park.ParkCell.newBuilder()
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
        getPlaceTimeFieldBuilder();
      }
    }
    public Builder clear() {
      super.clear();
      x_ = 0;
      bitField0_ = (bitField0_ & ~0x00000001);
      y_ = 0;
      bitField0_ = (bitField0_ & ~0x00000002);
      plantID_ = 0;
      bitField0_ = (bitField0_ & ~0x00000004);
      leftSeconds_ = 0;
      bitField0_ = (bitField0_ & ~0x00000008);
      if (placeTimeBuilder_ == null) {
        placeTime_ = null;
      } else {
        placeTimeBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000010);
      green_ = 0;
      bitField0_ = (bitField0_ & ~0x00000020);
      harvestNum_ = 0;
      bitField0_ = (bitField0_ & ~0x00000040);
      status_ = -1;
      bitField0_ = (bitField0_ & ~0x00000080);
      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.dj.protobuf.park.Park.internal_static_Protocols_ParkCell_descriptor;
    }

    public com.dj.protobuf.park.ParkCell getDefaultInstanceForType() {
      return com.dj.protobuf.park.ParkCell.getDefaultInstance();
    }

    public com.dj.protobuf.park.ParkCell build() {
      com.dj.protobuf.park.ParkCell result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public com.dj.protobuf.park.ParkCell buildPartial() {
      com.dj.protobuf.park.ParkCell result = new com.dj.protobuf.park.ParkCell(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
        to_bitField0_ |= 0x00000001;
      }
      result.x_ = x_;
      if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
        to_bitField0_ |= 0x00000002;
      }
      result.y_ = y_;
      if (((from_bitField0_ & 0x00000004) == 0x00000004)) {
        to_bitField0_ |= 0x00000004;
      }
      result.plantID_ = plantID_;
      if (((from_bitField0_ & 0x00000008) == 0x00000008)) {
        to_bitField0_ |= 0x00000008;
      }
      result.leftSeconds_ = leftSeconds_;
      if (((from_bitField0_ & 0x00000010) == 0x00000010)) {
        to_bitField0_ |= 0x00000010;
      }
      if (placeTimeBuilder_ == null) {
        result.placeTime_ = placeTime_;
      } else {
        result.placeTime_ = placeTimeBuilder_.build();
      }
      if (((from_bitField0_ & 0x00000020) == 0x00000020)) {
        to_bitField0_ |= 0x00000020;
      }
      result.green_ = green_;
      if (((from_bitField0_ & 0x00000040) == 0x00000040)) {
        to_bitField0_ |= 0x00000040;
      }
      result.harvestNum_ = harvestNum_;
      if (((from_bitField0_ & 0x00000080) == 0x00000080)) {
        to_bitField0_ |= 0x00000080;
      }
      result.status_ = status_;
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
      if (other instanceof com.dj.protobuf.park.ParkCell) {
        return mergeFrom((com.dj.protobuf.park.ParkCell)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.dj.protobuf.park.ParkCell other) {
      if (other == com.dj.protobuf.park.ParkCell.getDefaultInstance()) return this;
      if (other.hasX()) {
        setX(other.getX());
      }
      if (other.hasY()) {
        setY(other.getY());
      }
      if (other.hasPlantID()) {
        setPlantID(other.getPlantID());
      }
      if (other.hasLeftSeconds()) {
        setLeftSeconds(other.getLeftSeconds());
      }
      if (other.hasPlaceTime()) {
        mergePlaceTime(other.getPlaceTime());
      }
      if (other.hasGreen()) {
        setGreen(other.getGreen());
      }
      if (other.hasHarvestNum()) {
        setHarvestNum(other.getHarvestNum());
      }
      if (other.hasStatus()) {
        setStatus(other.getStatus());
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
      com.dj.protobuf.park.ParkCell parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.dj.protobuf.park.ParkCell) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private int x_ ;
    /**
     * <code>optional int32 x = 1;</code>
     */
    public boolean hasX() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <code>optional int32 x = 1;</code>
     */
    public int getX() {
      return x_;
    }
    /**
     * <code>optional int32 x = 1;</code>
     */
    public Builder setX(int value) {
      bitField0_ |= 0x00000001;
      x_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional int32 x = 1;</code>
     */
    public Builder clearX() {
      bitField0_ = (bitField0_ & ~0x00000001);
      x_ = 0;
      onChanged();
      return this;
    }

    private int y_ ;
    /**
     * <code>optional int32 y = 2;</code>
     */
    public boolean hasY() {
      return ((bitField0_ & 0x00000002) == 0x00000002);
    }
    /**
     * <code>optional int32 y = 2;</code>
     */
    public int getY() {
      return y_;
    }
    /**
     * <code>optional int32 y = 2;</code>
     */
    public Builder setY(int value) {
      bitField0_ |= 0x00000002;
      y_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional int32 y = 2;</code>
     */
    public Builder clearY() {
      bitField0_ = (bitField0_ & ~0x00000002);
      y_ = 0;
      onChanged();
      return this;
    }

    private int plantID_ ;
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 植物ID
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional int32 plantID = 3;</code>
     */
    public boolean hasPlantID() {
      return ((bitField0_ & 0x00000004) == 0x00000004);
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 植物ID
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional int32 plantID = 3;</code>
     */
    public int getPlantID() {
      return plantID_;
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 植物ID
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional int32 plantID = 3;</code>
     */
    public Builder setPlantID(int value) {
      bitField0_ |= 0x00000004;
      plantID_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 植物ID
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional int32 plantID = 3;</code>
     */
    public Builder clearPlantID() {
      bitField0_ = (bitField0_ & ~0x00000004);
      plantID_ = 0;
      onChanged();
      return this;
    }

    private int leftSeconds_ ;
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 距离成熟的秒数
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional int32 leftSeconds = 4;</code>
     */
    public boolean hasLeftSeconds() {
      return ((bitField0_ & 0x00000008) == 0x00000008);
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 距离成熟的秒数
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional int32 leftSeconds = 4;</code>
     */
    public int getLeftSeconds() {
      return leftSeconds_;
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 距离成熟的秒数
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional int32 leftSeconds = 4;</code>
     */
    public Builder setLeftSeconds(int value) {
      bitField0_ |= 0x00000008;
      leftSeconds_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 距离成熟的秒数
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional int32 leftSeconds = 4;</code>
     */
    public Builder clearLeftSeconds() {
      bitField0_ = (bitField0_ & ~0x00000008);
      leftSeconds_ = 0;
      onChanged();
      return this;
    }

    private com.dj.protobuf.datetime.DateTime placeTime_ = null;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.dj.protobuf.datetime.DateTime, com.dj.protobuf.datetime.DateTime.Builder, com.dj.protobuf.datetime.DateTimeOrBuilder> placeTimeBuilder_;
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 放置时间
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional .Protocols.DateTime placeTime = 5;</code>
     */
    public boolean hasPlaceTime() {
      return ((bitField0_ & 0x00000010) == 0x00000010);
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 放置时间
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional .Protocols.DateTime placeTime = 5;</code>
     */
    public com.dj.protobuf.datetime.DateTime getPlaceTime() {
      if (placeTimeBuilder_ == null) {
        return placeTime_ == null ? com.dj.protobuf.datetime.DateTime.getDefaultInstance() : placeTime_;
      } else {
        return placeTimeBuilder_.getMessage();
      }
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 放置时间
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional .Protocols.DateTime placeTime = 5;</code>
     */
    public Builder setPlaceTime(com.dj.protobuf.datetime.DateTime value) {
      if (placeTimeBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        placeTime_ = value;
        onChanged();
      } else {
        placeTimeBuilder_.setMessage(value);
      }
      bitField0_ |= 0x00000010;
      return this;
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 放置时间
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional .Protocols.DateTime placeTime = 5;</code>
     */
    public Builder setPlaceTime(
        com.dj.protobuf.datetime.DateTime.Builder builderForValue) {
      if (placeTimeBuilder_ == null) {
        placeTime_ = builderForValue.build();
        onChanged();
      } else {
        placeTimeBuilder_.setMessage(builderForValue.build());
      }
      bitField0_ |= 0x00000010;
      return this;
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 放置时间
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional .Protocols.DateTime placeTime = 5;</code>
     */
    public Builder mergePlaceTime(com.dj.protobuf.datetime.DateTime value) {
      if (placeTimeBuilder_ == null) {
        if (((bitField0_ & 0x00000010) == 0x00000010) &&
            placeTime_ != null &&
            placeTime_ != com.dj.protobuf.datetime.DateTime.getDefaultInstance()) {
          placeTime_ =
            com.dj.protobuf.datetime.DateTime.newBuilder(placeTime_).mergeFrom(value).buildPartial();
        } else {
          placeTime_ = value;
        }
        onChanged();
      } else {
        placeTimeBuilder_.mergeFrom(value);
      }
      bitField0_ |= 0x00000010;
      return this;
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 放置时间
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional .Protocols.DateTime placeTime = 5;</code>
     */
    public Builder clearPlaceTime() {
      if (placeTimeBuilder_ == null) {
        placeTime_ = null;
        onChanged();
      } else {
        placeTimeBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000010);
      return this;
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 放置时间
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional .Protocols.DateTime placeTime = 5;</code>
     */
    public com.dj.protobuf.datetime.DateTime.Builder getPlaceTimeBuilder() {
      bitField0_ |= 0x00000010;
      onChanged();
      return getPlaceTimeFieldBuilder().getBuilder();
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 放置时间
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional .Protocols.DateTime placeTime = 5;</code>
     */
    public com.dj.protobuf.datetime.DateTimeOrBuilder getPlaceTimeOrBuilder() {
      if (placeTimeBuilder_ != null) {
        return placeTimeBuilder_.getMessageOrBuilder();
      } else {
        return placeTime_ == null ?
            com.dj.protobuf.datetime.DateTime.getDefaultInstance() : placeTime_;
      }
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 放置时间
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional .Protocols.DateTime placeTime = 5;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.dj.protobuf.datetime.DateTime, com.dj.protobuf.datetime.DateTime.Builder, com.dj.protobuf.datetime.DateTimeOrBuilder> 
        getPlaceTimeFieldBuilder() {
      if (placeTimeBuilder_ == null) {
        placeTimeBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.dj.protobuf.datetime.DateTime, com.dj.protobuf.datetime.DateTime.Builder, com.dj.protobuf.datetime.DateTimeOrBuilder>(
                getPlaceTime(),
                getParentForChildren(),
                isClean());
        placeTime_ = null;
      }
      return placeTimeBuilder_;
    }

    private int green_ ;
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 绿化值
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional int32 green = 6;</code>
     */
    public boolean hasGreen() {
      return ((bitField0_ & 0x00000020) == 0x00000020);
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 绿化值
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional int32 green = 6;</code>
     */
    public int getGreen() {
      return green_;
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 绿化值
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional int32 green = 6;</code>
     */
    public Builder setGreen(int value) {
      bitField0_ |= 0x00000020;
      green_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 绿化值
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional int32 green = 6;</code>
     */
    public Builder clearGreen() {
      bitField0_ = (bitField0_ & ~0x00000020);
      green_ = 0;
      onChanged();
      return this;
    }

    private int harvestNum_ ;
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 收获次数
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional int32 harvestNum = 7;</code>
     */
    public boolean hasHarvestNum() {
      return ((bitField0_ & 0x00000040) == 0x00000040);
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 收获次数
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional int32 harvestNum = 7;</code>
     */
    public int getHarvestNum() {
      return harvestNum_;
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 收获次数
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional int32 harvestNum = 7;</code>
     */
    public Builder setHarvestNum(int value) {
      bitField0_ |= 0x00000040;
      harvestNum_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 收获次数
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional int32 harvestNum = 7;</code>
     */
    public Builder clearHarvestNum() {
      bitField0_ = (bitField0_ & ~0x00000040);
      harvestNum_ = 0;
      onChanged();
      return this;
    }

    private int status_ = -1;
    /**
     * <pre>
     *状态
     * </pre>
     *
     * <code>optional .Protocols.ParkStatus status = 8;</code>
     */
    public boolean hasStatus() {
      return ((bitField0_ & 0x00000080) == 0x00000080);
    }
    /**
     * <pre>
     *状态
     * </pre>
     *
     * <code>optional .Protocols.ParkStatus status = 8;</code>
     */
    public com.dj.protobuf.park.ParkStatus getStatus() {
      com.dj.protobuf.park.ParkStatus result = com.dj.protobuf.park.ParkStatus.valueOf(status_);
      return result == null ? com.dj.protobuf.park.ParkStatus.Hunger : result;
    }
    /**
     * <pre>
     *状态
     * </pre>
     *
     * <code>optional .Protocols.ParkStatus status = 8;</code>
     */
    public Builder setStatus(com.dj.protobuf.park.ParkStatus value) {
      if (value == null) {
        throw new NullPointerException();
      }
      bitField0_ |= 0x00000080;
      status_ = value.getNumber();
      onChanged();
      return this;
    }
    /**
     * <pre>
     *状态
     * </pre>
     *
     * <code>optional .Protocols.ParkStatus status = 8;</code>
     */
    public Builder clearStatus() {
      bitField0_ = (bitField0_ & ~0x00000080);
      status_ = -1;
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


    // @@protoc_insertion_point(builder_scope:Protocols.ParkCell)
  }

  // @@protoc_insertion_point(class_scope:Protocols.ParkCell)
  private static final com.dj.protobuf.park.ParkCell DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.dj.protobuf.park.ParkCell();
  }

  public static com.dj.protobuf.park.ParkCell getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  @java.lang.Deprecated public static final com.google.protobuf.Parser<ParkCell>
      PARSER = new com.google.protobuf.AbstractParser<ParkCell>() {
    public ParkCell parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new ParkCell(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<ParkCell> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<ParkCell> getParserForType() {
    return PARSER;
  }

  public com.dj.protobuf.park.ParkCell getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

