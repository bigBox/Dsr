// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Rob.proto

package com.dj.protobuf.rob;

/**
 * Protobuf type {@code Protocols.RobCell}
 */
public  final class RobCell extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:Protocols.RobCell)
    RobCellOrBuilder {
  // Use RobCell.newBuilder() to construct.
  private RobCell(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private RobCell() {
    x_ = 0;
    y_ = 0;
    type_ = -2;
    stage_ = 0;
    isShow_ = false;
    cellTypeLandforms_ = "";
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private RobCell(
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
            int rawValue = input.readEnum();
            com.dj.protobuf.rob.ERobCellType value = com.dj.protobuf.rob.ERobCellType.valueOf(rawValue);
            if (value == null) {
              unknownFields.mergeVarintField(3, rawValue);
            } else {
              bitField0_ |= 0x00000004;
              type_ = rawValue;
            }
            break;
          }
          case 32: {
            bitField0_ |= 0x00000008;
            stage_ = input.readInt32();
            break;
          }
          case 40: {
            bitField0_ |= 0x00000010;
            isShow_ = input.readBool();
            break;
          }
          case 50: {
            com.google.protobuf.ByteString bs = input.readBytes();
            bitField0_ |= 0x00000020;
            cellTypeLandforms_ = bs;
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
    return com.dj.protobuf.rob.Rob.internal_static_Protocols_RobCell_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.dj.protobuf.rob.Rob.internal_static_Protocols_RobCell_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.dj.protobuf.rob.RobCell.class, com.dj.protobuf.rob.RobCell.Builder.class);
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

  public static final int TYPE_FIELD_NUMBER = 3;
  private int type_;
  /**
   * <code>optional .Protocols.ERobCellType type = 3;</code>
   */
  public boolean hasType() {
    return ((bitField0_ & 0x00000004) == 0x00000004);
  }
  /**
   * <code>optional .Protocols.ERobCellType type = 3;</code>
   */
  public com.dj.protobuf.rob.ERobCellType getType() {
    com.dj.protobuf.rob.ERobCellType result = com.dj.protobuf.rob.ERobCellType.valueOf(type_);
    return result == null ? com.dj.protobuf.rob.ERobCellType.DigUp : result;
  }

  public static final int STAGE_FIELD_NUMBER = 4;
  private int stage_;
  /**
   * <code>optional int32 stage = 4;</code>
   */
  public boolean hasStage() {
    return ((bitField0_ & 0x00000008) == 0x00000008);
  }
  /**
   * <code>optional int32 stage = 4;</code>
   */
  public int getStage() {
    return stage_;
  }

  public static final int ISSHOW_FIELD_NUMBER = 5;
  private boolean isShow_;
  /**
   * <code>optional bool isShow = 5;</code>
   */
  public boolean hasIsShow() {
    return ((bitField0_ & 0x00000010) == 0x00000010);
  }
  /**
   * <code>optional bool isShow = 5;</code>
   */
  public boolean getIsShow() {
    return isShow_;
  }

  public static final int CELLTYPELANDFORMS_FIELD_NUMBER = 6;
  private volatile java.lang.Object cellTypeLandforms_;
  /**
   * <pre>
   * ??????type???????????????
   * </pre>
   *
   * <code>optional string cellTypeLandforms = 6;</code>
   */
  public boolean hasCellTypeLandforms() {
    return ((bitField0_ & 0x00000020) == 0x00000020);
  }
  /**
   * <pre>
   * ??????type???????????????
   * </pre>
   *
   * <code>optional string cellTypeLandforms = 6;</code>
   */
  public java.lang.String getCellTypeLandforms() {
    java.lang.Object ref = cellTypeLandforms_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      if (bs.isValidUtf8()) {
        cellTypeLandforms_ = s;
      }
      return s;
    }
  }
  /**
   * <pre>
   * ??????type???????????????
   * </pre>
   *
   * <code>optional string cellTypeLandforms = 6;</code>
   */
  public com.google.protobuf.ByteString
      getCellTypeLandformsBytes() {
    java.lang.Object ref = cellTypeLandforms_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      cellTypeLandforms_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
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
      output.writeEnum(3, type_);
    }
    if (((bitField0_ & 0x00000008) == 0x00000008)) {
      output.writeInt32(4, stage_);
    }
    if (((bitField0_ & 0x00000010) == 0x00000010)) {
      output.writeBool(5, isShow_);
    }
    if (((bitField0_ & 0x00000020) == 0x00000020)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 6, cellTypeLandforms_);
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
        .computeEnumSize(3, type_);
    }
    if (((bitField0_ & 0x00000008) == 0x00000008)) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(4, stage_);
    }
    if (((bitField0_ & 0x00000010) == 0x00000010)) {
      size += com.google.protobuf.CodedOutputStream
        .computeBoolSize(5, isShow_);
    }
    if (((bitField0_ & 0x00000020) == 0x00000020)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(6, cellTypeLandforms_);
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
    if (!(obj instanceof com.dj.protobuf.rob.RobCell)) {
      return super.equals(obj);
    }
    com.dj.protobuf.rob.RobCell other = (com.dj.protobuf.rob.RobCell) obj;

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
    result = result && (hasType() == other.hasType());
    if (hasType()) {
      result = result && type_ == other.type_;
    }
    result = result && (hasStage() == other.hasStage());
    if (hasStage()) {
      result = result && (getStage()
          == other.getStage());
    }
    result = result && (hasIsShow() == other.hasIsShow());
    if (hasIsShow()) {
      result = result && (getIsShow()
          == other.getIsShow());
    }
    result = result && (hasCellTypeLandforms() == other.hasCellTypeLandforms());
    if (hasCellTypeLandforms()) {
      result = result && getCellTypeLandforms()
          .equals(other.getCellTypeLandforms());
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
    if (hasType()) {
      hash = (37 * hash) + TYPE_FIELD_NUMBER;
      hash = (53 * hash) + type_;
    }
    if (hasStage()) {
      hash = (37 * hash) + STAGE_FIELD_NUMBER;
      hash = (53 * hash) + getStage();
    }
    if (hasIsShow()) {
      hash = (37 * hash) + ISSHOW_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
          getIsShow());
    }
    if (hasCellTypeLandforms()) {
      hash = (37 * hash) + CELLTYPELANDFORMS_FIELD_NUMBER;
      hash = (53 * hash) + getCellTypeLandforms().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.dj.protobuf.rob.RobCell parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dj.protobuf.rob.RobCell parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dj.protobuf.rob.RobCell parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dj.protobuf.rob.RobCell parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dj.protobuf.rob.RobCell parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.rob.RobCell parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.dj.protobuf.rob.RobCell parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.rob.RobCell parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.dj.protobuf.rob.RobCell parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.rob.RobCell parseFrom(
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
  public static Builder newBuilder(com.dj.protobuf.rob.RobCell prototype) {
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
   * Protobuf type {@code Protocols.RobCell}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:Protocols.RobCell)
      com.dj.protobuf.rob.RobCellOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.dj.protobuf.rob.Rob.internal_static_Protocols_RobCell_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.dj.protobuf.rob.Rob.internal_static_Protocols_RobCell_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.dj.protobuf.rob.RobCell.class, com.dj.protobuf.rob.RobCell.Builder.class);
    }

    // Construct using com.dj.protobuf.rob.RobCell.newBuilder()
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
      x_ = 0;
      bitField0_ = (bitField0_ & ~0x00000001);
      y_ = 0;
      bitField0_ = (bitField0_ & ~0x00000002);
      type_ = -2;
      bitField0_ = (bitField0_ & ~0x00000004);
      stage_ = 0;
      bitField0_ = (bitField0_ & ~0x00000008);
      isShow_ = false;
      bitField0_ = (bitField0_ & ~0x00000010);
      cellTypeLandforms_ = "";
      bitField0_ = (bitField0_ & ~0x00000020);
      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.dj.protobuf.rob.Rob.internal_static_Protocols_RobCell_descriptor;
    }

    public com.dj.protobuf.rob.RobCell getDefaultInstanceForType() {
      return com.dj.protobuf.rob.RobCell.getDefaultInstance();
    }

    public com.dj.protobuf.rob.RobCell build() {
      com.dj.protobuf.rob.RobCell result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public com.dj.protobuf.rob.RobCell buildPartial() {
      com.dj.protobuf.rob.RobCell result = new com.dj.protobuf.rob.RobCell(this);
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
      result.type_ = type_;
      if (((from_bitField0_ & 0x00000008) == 0x00000008)) {
        to_bitField0_ |= 0x00000008;
      }
      result.stage_ = stage_;
      if (((from_bitField0_ & 0x00000010) == 0x00000010)) {
        to_bitField0_ |= 0x00000010;
      }
      result.isShow_ = isShow_;
      if (((from_bitField0_ & 0x00000020) == 0x00000020)) {
        to_bitField0_ |= 0x00000020;
      }
      result.cellTypeLandforms_ = cellTypeLandforms_;
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
      if (other instanceof com.dj.protobuf.rob.RobCell) {
        return mergeFrom((com.dj.protobuf.rob.RobCell)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.dj.protobuf.rob.RobCell other) {
      if (other == com.dj.protobuf.rob.RobCell.getDefaultInstance()) return this;
      if (other.hasX()) {
        setX(other.getX());
      }
      if (other.hasY()) {
        setY(other.getY());
      }
      if (other.hasType()) {
        setType(other.getType());
      }
      if (other.hasStage()) {
        setStage(other.getStage());
      }
      if (other.hasIsShow()) {
        setIsShow(other.getIsShow());
      }
      if (other.hasCellTypeLandforms()) {
        bitField0_ |= 0x00000020;
        cellTypeLandforms_ = other.cellTypeLandforms_;
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
      com.dj.protobuf.rob.RobCell parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.dj.protobuf.rob.RobCell) e.getUnfinishedMessage();
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

    private int type_ = -2;
    /**
     * <code>optional .Protocols.ERobCellType type = 3;</code>
     */
    public boolean hasType() {
      return ((bitField0_ & 0x00000004) == 0x00000004);
    }
    /**
     * <code>optional .Protocols.ERobCellType type = 3;</code>
     */
    public com.dj.protobuf.rob.ERobCellType getType() {
      com.dj.protobuf.rob.ERobCellType result = com.dj.protobuf.rob.ERobCellType.valueOf(type_);
      return result == null ? com.dj.protobuf.rob.ERobCellType.DigUp : result;
    }
    /**
     * <code>optional .Protocols.ERobCellType type = 3;</code>
     */
    public Builder setType(com.dj.protobuf.rob.ERobCellType value) {
      if (value == null) {
        throw new NullPointerException();
      }
      bitField0_ |= 0x00000004;
      type_ = value.getNumber();
      onChanged();
      return this;
    }
    /**
     * <code>optional .Protocols.ERobCellType type = 3;</code>
     */
    public Builder clearType() {
      bitField0_ = (bitField0_ & ~0x00000004);
      type_ = -2;
      onChanged();
      return this;
    }

    private int stage_ ;
    /**
     * <code>optional int32 stage = 4;</code>
     */
    public boolean hasStage() {
      return ((bitField0_ & 0x00000008) == 0x00000008);
    }
    /**
     * <code>optional int32 stage = 4;</code>
     */
    public int getStage() {
      return stage_;
    }
    /**
     * <code>optional int32 stage = 4;</code>
     */
    public Builder setStage(int value) {
      bitField0_ |= 0x00000008;
      stage_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional int32 stage = 4;</code>
     */
    public Builder clearStage() {
      bitField0_ = (bitField0_ & ~0x00000008);
      stage_ = 0;
      onChanged();
      return this;
    }

    private boolean isShow_ ;
    /**
     * <code>optional bool isShow = 5;</code>
     */
    public boolean hasIsShow() {
      return ((bitField0_ & 0x00000010) == 0x00000010);
    }
    /**
     * <code>optional bool isShow = 5;</code>
     */
    public boolean getIsShow() {
      return isShow_;
    }
    /**
     * <code>optional bool isShow = 5;</code>
     */
    public Builder setIsShow(boolean value) {
      bitField0_ |= 0x00000010;
      isShow_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional bool isShow = 5;</code>
     */
    public Builder clearIsShow() {
      bitField0_ = (bitField0_ & ~0x00000010);
      isShow_ = false;
      onChanged();
      return this;
    }

    private java.lang.Object cellTypeLandforms_ = "";
    /**
     * <pre>
     * ??????type???????????????
     * </pre>
     *
     * <code>optional string cellTypeLandforms = 6;</code>
     */
    public boolean hasCellTypeLandforms() {
      return ((bitField0_ & 0x00000020) == 0x00000020);
    }
    /**
     * <pre>
     * ??????type???????????????
     * </pre>
     *
     * <code>optional string cellTypeLandforms = 6;</code>
     */
    public java.lang.String getCellTypeLandforms() {
      java.lang.Object ref = cellTypeLandforms_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        if (bs.isValidUtf8()) {
          cellTypeLandforms_ = s;
        }
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <pre>
     * ??????type???????????????
     * </pre>
     *
     * <code>optional string cellTypeLandforms = 6;</code>
     */
    public com.google.protobuf.ByteString
        getCellTypeLandformsBytes() {
      java.lang.Object ref = cellTypeLandforms_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        cellTypeLandforms_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <pre>
     * ??????type???????????????
     * </pre>
     *
     * <code>optional string cellTypeLandforms = 6;</code>
     */
    public Builder setCellTypeLandforms(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000020;
      cellTypeLandforms_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * ??????type???????????????
     * </pre>
     *
     * <code>optional string cellTypeLandforms = 6;</code>
     */
    public Builder clearCellTypeLandforms() {
      bitField0_ = (bitField0_ & ~0x00000020);
      cellTypeLandforms_ = getDefaultInstance().getCellTypeLandforms();
      onChanged();
      return this;
    }
    /**
     * <pre>
     * ??????type???????????????
     * </pre>
     *
     * <code>optional string cellTypeLandforms = 6;</code>
     */
    public Builder setCellTypeLandformsBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000020;
      cellTypeLandforms_ = value;
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


    // @@protoc_insertion_point(builder_scope:Protocols.RobCell)
  }

  // @@protoc_insertion_point(class_scope:Protocols.RobCell)
  private static final com.dj.protobuf.rob.RobCell DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.dj.protobuf.rob.RobCell();
  }

  public static com.dj.protobuf.rob.RobCell getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  @java.lang.Deprecated public static final com.google.protobuf.Parser<RobCell>
      PARSER = new com.google.protobuf.AbstractParser<RobCell>() {
    public RobCell parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new RobCell(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<RobCell> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<RobCell> getParserForType() {
    return PARSER;
  }

  public com.dj.protobuf.rob.RobCell getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

