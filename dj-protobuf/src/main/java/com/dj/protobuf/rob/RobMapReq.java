// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Rob.proto

package com.dj.protobuf.rob;

/**
 * Protobuf type {@code Protocols.RobMapReq}
 */
public  final class RobMapReq extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:Protocols.RobMapReq)
    RobMapReqOrBuilder {
  // Use RobMapReq.newBuilder() to construct.
  private RobMapReq(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private RobMapReq() {
    mapId_ = 0;
    enterCondition_ = 0;
    floor_ = 0;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private RobMapReq(
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
            mapId_ = input.readInt32();
            break;
          }
          case 16: {
            bitField0_ |= 0x00000002;
            enterCondition_ = input.readInt32();
            break;
          }
          case 24: {
            bitField0_ |= 0x00000004;
            floor_ = input.readInt32();
            break;
          }
          case 34: {
            if (!((mutable_bitField0_ & 0x00000008) == 0x00000008)) {
              trapItem_ = com.google.protobuf.MapField.newMapField(
                  TrapItemDefaultEntryHolder.defaultEntry);
              mutable_bitField0_ |= 0x00000008;
            }
            com.google.protobuf.MapEntry<java.lang.Integer, java.lang.Integer>
            trapItem = input.readMessage(
                TrapItemDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistry);
            trapItem_.getMutableMap().put(trapItem.getKey(), trapItem.getValue());
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
    return com.dj.protobuf.rob.Rob.internal_static_Protocols_RobMapReq_descriptor;
  }

  @SuppressWarnings({"rawtypes"})
  protected com.google.protobuf.MapField internalGetMapField(
      int number) {
    switch (number) {
      case 4:
        return internalGetTrapItem();
      default:
        throw new RuntimeException(
            "Invalid map field number: " + number);
    }
  }
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.dj.protobuf.rob.Rob.internal_static_Protocols_RobMapReq_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.dj.protobuf.rob.RobMapReq.class, com.dj.protobuf.rob.RobMapReq.Builder.class);
  }

  private int bitField0_;
  public static final int MAPID_FIELD_NUMBER = 1;
  private int mapId_;
  /**
   * <code>optional int32 mapId = 1;</code>
   */
  public boolean hasMapId() {
    return ((bitField0_ & 0x00000001) == 0x00000001);
  }
  /**
   * <code>optional int32 mapId = 1;</code>
   */
  public int getMapId() {
    return mapId_;
  }

  public static final int ENTERCONDITION_FIELD_NUMBER = 2;
  private int enterCondition_;
  /**
   * <code>optional int32 enterCondition = 2;</code>
   */
  public boolean hasEnterCondition() {
    return ((bitField0_ & 0x00000002) == 0x00000002);
  }
  /**
   * <code>optional int32 enterCondition = 2;</code>
   */
  public int getEnterCondition() {
    return enterCondition_;
  }

  public static final int FLOOR_FIELD_NUMBER = 3;
  private int floor_;
  /**
   * <code>optional int32 floor = 3;</code>
   */
  public boolean hasFloor() {
    return ((bitField0_ & 0x00000004) == 0x00000004);
  }
  /**
   * <code>optional int32 floor = 3;</code>
   */
  public int getFloor() {
    return floor_;
  }

  public static final int TRAPITEM_FIELD_NUMBER = 4;
  private static final class TrapItemDefaultEntryHolder {
    static final com.google.protobuf.MapEntry<
        java.lang.Integer, java.lang.Integer> defaultEntry =
            com.google.protobuf.MapEntry
            .<java.lang.Integer, java.lang.Integer>newDefaultInstance(
                com.dj.protobuf.rob.Rob.internal_static_Protocols_RobMapReq_TrapItemEntry_descriptor, 
                com.google.protobuf.WireFormat.FieldType.INT32,
                0,
                com.google.protobuf.WireFormat.FieldType.INT32,
                0);
  }
  private com.google.protobuf.MapField<
      java.lang.Integer, java.lang.Integer> trapItem_;
  private com.google.protobuf.MapField<java.lang.Integer, java.lang.Integer>
  internalGetTrapItem() {
    if (trapItem_ == null) {
      return com.google.protobuf.MapField.emptyMapField(
          TrapItemDefaultEntryHolder.defaultEntry);
    }
    return trapItem_;
  }

  public int getTrapItemCount() {
    return internalGetTrapItem().getMap().size();
  }
  /**
   * <pre>
   * ???????????????????????????????????????
   * </pre>
   *
   * <code>map&lt;int32, int32&gt; trapItem = 4;</code>
   */

  public boolean containsTrapItem(
      int key) {
    
    return internalGetTrapItem().getMap().containsKey(key);
  }
  /**
   * Use {@link #getTrapItemMap()} instead.
   */
  @java.lang.Deprecated
  public java.util.Map<java.lang.Integer, java.lang.Integer> getTrapItem() {
    return getTrapItemMap();
  }
  /**
   * <pre>
   * ???????????????????????????????????????
   * </pre>
   *
   * <code>map&lt;int32, int32&gt; trapItem = 4;</code>
   */

  public java.util.Map<java.lang.Integer, java.lang.Integer> getTrapItemMap() {
    return internalGetTrapItem().getMap();
  }
  /**
   * <pre>
   * ???????????????????????????????????????
   * </pre>
   *
   * <code>map&lt;int32, int32&gt; trapItem = 4;</code>
   */

  public int getTrapItemOrDefault(
      int key,
      int defaultValue) {
    
    java.util.Map<java.lang.Integer, java.lang.Integer> map =
        internalGetTrapItem().getMap();
    return map.containsKey(key) ? map.get(key) : defaultValue;
  }
  /**
   * <pre>
   * ???????????????????????????????????????
   * </pre>
   *
   * <code>map&lt;int32, int32&gt; trapItem = 4;</code>
   */

  public int getTrapItemOrThrow(
      int key) {
    
    java.util.Map<java.lang.Integer, java.lang.Integer> map =
        internalGetTrapItem().getMap();
    if (!map.containsKey(key)) {
      throw new java.lang.IllegalArgumentException();
    }
    return map.get(key);
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
      output.writeInt32(1, mapId_);
    }
    if (((bitField0_ & 0x00000002) == 0x00000002)) {
      output.writeInt32(2, enterCondition_);
    }
    if (((bitField0_ & 0x00000004) == 0x00000004)) {
      output.writeInt32(3, floor_);
    }
    for (java.util.Map.Entry<java.lang.Integer, java.lang.Integer> entry
         : internalGetTrapItem().getMap().entrySet()) {
      com.google.protobuf.MapEntry<java.lang.Integer, java.lang.Integer>
      trapItem = TrapItemDefaultEntryHolder.defaultEntry.newBuilderForType()
          .setKey(entry.getKey())
          .setValue(entry.getValue())
          .build();
      output.writeMessage(4, trapItem);
    }
    unknownFields.writeTo(output);
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (((bitField0_ & 0x00000001) == 0x00000001)) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(1, mapId_);
    }
    if (((bitField0_ & 0x00000002) == 0x00000002)) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(2, enterCondition_);
    }
    if (((bitField0_ & 0x00000004) == 0x00000004)) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(3, floor_);
    }
    for (java.util.Map.Entry<java.lang.Integer, java.lang.Integer> entry
         : internalGetTrapItem().getMap().entrySet()) {
      com.google.protobuf.MapEntry<java.lang.Integer, java.lang.Integer>
      trapItem = TrapItemDefaultEntryHolder.defaultEntry.newBuilderForType()
          .setKey(entry.getKey())
          .setValue(entry.getValue())
          .build();
      size += com.google.protobuf.CodedOutputStream
          .computeMessageSize(4, trapItem);
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
    if (!(obj instanceof com.dj.protobuf.rob.RobMapReq)) {
      return super.equals(obj);
    }
    com.dj.protobuf.rob.RobMapReq other = (com.dj.protobuf.rob.RobMapReq) obj;

    boolean result = true;
    result = result && (hasMapId() == other.hasMapId());
    if (hasMapId()) {
      result = result && (getMapId()
          == other.getMapId());
    }
    result = result && (hasEnterCondition() == other.hasEnterCondition());
    if (hasEnterCondition()) {
      result = result && (getEnterCondition()
          == other.getEnterCondition());
    }
    result = result && (hasFloor() == other.hasFloor());
    if (hasFloor()) {
      result = result && (getFloor()
          == other.getFloor());
    }
    result = result && internalGetTrapItem().equals(
        other.internalGetTrapItem());
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
    if (hasMapId()) {
      hash = (37 * hash) + MAPID_FIELD_NUMBER;
      hash = (53 * hash) + getMapId();
    }
    if (hasEnterCondition()) {
      hash = (37 * hash) + ENTERCONDITION_FIELD_NUMBER;
      hash = (53 * hash) + getEnterCondition();
    }
    if (hasFloor()) {
      hash = (37 * hash) + FLOOR_FIELD_NUMBER;
      hash = (53 * hash) + getFloor();
    }
    if (!internalGetTrapItem().getMap().isEmpty()) {
      hash = (37 * hash) + TRAPITEM_FIELD_NUMBER;
      hash = (53 * hash) + internalGetTrapItem().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.dj.protobuf.rob.RobMapReq parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dj.protobuf.rob.RobMapReq parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dj.protobuf.rob.RobMapReq parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dj.protobuf.rob.RobMapReq parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dj.protobuf.rob.RobMapReq parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.rob.RobMapReq parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.dj.protobuf.rob.RobMapReq parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.rob.RobMapReq parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.dj.protobuf.rob.RobMapReq parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.rob.RobMapReq parseFrom(
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
  public static Builder newBuilder(com.dj.protobuf.rob.RobMapReq prototype) {
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
   * Protobuf type {@code Protocols.RobMapReq}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:Protocols.RobMapReq)
      com.dj.protobuf.rob.RobMapReqOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.dj.protobuf.rob.Rob.internal_static_Protocols_RobMapReq_descriptor;
    }

    @SuppressWarnings({"rawtypes"})
    protected com.google.protobuf.MapField internalGetMapField(
        int number) {
      switch (number) {
        case 4:
          return internalGetTrapItem();
        default:
          throw new RuntimeException(
              "Invalid map field number: " + number);
      }
    }
    @SuppressWarnings({"rawtypes"})
    protected com.google.protobuf.MapField internalGetMutableMapField(
        int number) {
      switch (number) {
        case 4:
          return internalGetMutableTrapItem();
        default:
          throw new RuntimeException(
              "Invalid map field number: " + number);
      }
    }
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.dj.protobuf.rob.Rob.internal_static_Protocols_RobMapReq_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.dj.protobuf.rob.RobMapReq.class, com.dj.protobuf.rob.RobMapReq.Builder.class);
    }

    // Construct using com.dj.protobuf.rob.RobMapReq.newBuilder()
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
      mapId_ = 0;
      bitField0_ = (bitField0_ & ~0x00000001);
      enterCondition_ = 0;
      bitField0_ = (bitField0_ & ~0x00000002);
      floor_ = 0;
      bitField0_ = (bitField0_ & ~0x00000004);
      internalGetMutableTrapItem().clear();
      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.dj.protobuf.rob.Rob.internal_static_Protocols_RobMapReq_descriptor;
    }

    public com.dj.protobuf.rob.RobMapReq getDefaultInstanceForType() {
      return com.dj.protobuf.rob.RobMapReq.getDefaultInstance();
    }

    public com.dj.protobuf.rob.RobMapReq build() {
      com.dj.protobuf.rob.RobMapReq result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public com.dj.protobuf.rob.RobMapReq buildPartial() {
      com.dj.protobuf.rob.RobMapReq result = new com.dj.protobuf.rob.RobMapReq(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
        to_bitField0_ |= 0x00000001;
      }
      result.mapId_ = mapId_;
      if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
        to_bitField0_ |= 0x00000002;
      }
      result.enterCondition_ = enterCondition_;
      if (((from_bitField0_ & 0x00000004) == 0x00000004)) {
        to_bitField0_ |= 0x00000004;
      }
      result.floor_ = floor_;
      result.trapItem_ = internalGetTrapItem();
      result.trapItem_.makeImmutable();
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
      if (other instanceof com.dj.protobuf.rob.RobMapReq) {
        return mergeFrom((com.dj.protobuf.rob.RobMapReq)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.dj.protobuf.rob.RobMapReq other) {
      if (other == com.dj.protobuf.rob.RobMapReq.getDefaultInstance()) return this;
      if (other.hasMapId()) {
        setMapId(other.getMapId());
      }
      if (other.hasEnterCondition()) {
        setEnterCondition(other.getEnterCondition());
      }
      if (other.hasFloor()) {
        setFloor(other.getFloor());
      }
      internalGetMutableTrapItem().mergeFrom(
          other.internalGetTrapItem());
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
      com.dj.protobuf.rob.RobMapReq parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.dj.protobuf.rob.RobMapReq) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private int mapId_ ;
    /**
     * <code>optional int32 mapId = 1;</code>
     */
    public boolean hasMapId() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <code>optional int32 mapId = 1;</code>
     */
    public int getMapId() {
      return mapId_;
    }
    /**
     * <code>optional int32 mapId = 1;</code>
     */
    public Builder setMapId(int value) {
      bitField0_ |= 0x00000001;
      mapId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional int32 mapId = 1;</code>
     */
    public Builder clearMapId() {
      bitField0_ = (bitField0_ & ~0x00000001);
      mapId_ = 0;
      onChanged();
      return this;
    }

    private int enterCondition_ ;
    /**
     * <code>optional int32 enterCondition = 2;</code>
     */
    public boolean hasEnterCondition() {
      return ((bitField0_ & 0x00000002) == 0x00000002);
    }
    /**
     * <code>optional int32 enterCondition = 2;</code>
     */
    public int getEnterCondition() {
      return enterCondition_;
    }
    /**
     * <code>optional int32 enterCondition = 2;</code>
     */
    public Builder setEnterCondition(int value) {
      bitField0_ |= 0x00000002;
      enterCondition_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional int32 enterCondition = 2;</code>
     */
    public Builder clearEnterCondition() {
      bitField0_ = (bitField0_ & ~0x00000002);
      enterCondition_ = 0;
      onChanged();
      return this;
    }

    private int floor_ ;
    /**
     * <code>optional int32 floor = 3;</code>
     */
    public boolean hasFloor() {
      return ((bitField0_ & 0x00000004) == 0x00000004);
    }
    /**
     * <code>optional int32 floor = 3;</code>
     */
    public int getFloor() {
      return floor_;
    }
    /**
     * <code>optional int32 floor = 3;</code>
     */
    public Builder setFloor(int value) {
      bitField0_ |= 0x00000004;
      floor_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional int32 floor = 3;</code>
     */
    public Builder clearFloor() {
      bitField0_ = (bitField0_ & ~0x00000004);
      floor_ = 0;
      onChanged();
      return this;
    }

    private com.google.protobuf.MapField<
        java.lang.Integer, java.lang.Integer> trapItem_;
    private com.google.protobuf.MapField<java.lang.Integer, java.lang.Integer>
    internalGetTrapItem() {
      if (trapItem_ == null) {
        return com.google.protobuf.MapField.emptyMapField(
            TrapItemDefaultEntryHolder.defaultEntry);
      }
      return trapItem_;
    }
    private com.google.protobuf.MapField<java.lang.Integer, java.lang.Integer>
    internalGetMutableTrapItem() {
      onChanged();;
      if (trapItem_ == null) {
        trapItem_ = com.google.protobuf.MapField.newMapField(
            TrapItemDefaultEntryHolder.defaultEntry);
      }
      if (!trapItem_.isMutable()) {
        trapItem_ = trapItem_.copy();
      }
      return trapItem_;
    }

    public int getTrapItemCount() {
      return internalGetTrapItem().getMap().size();
    }
    /**
     * <pre>
     * ???????????????????????????????????????
     * </pre>
     *
     * <code>map&lt;int32, int32&gt; trapItem = 4;</code>
     */

    public boolean containsTrapItem(
        int key) {
      
      return internalGetTrapItem().getMap().containsKey(key);
    }
    /**
     * Use {@link #getTrapItemMap()} instead.
     */
    @java.lang.Deprecated
    public java.util.Map<java.lang.Integer, java.lang.Integer> getTrapItem() {
      return getTrapItemMap();
    }
    /**
     * <pre>
     * ???????????????????????????????????????
     * </pre>
     *
     * <code>map&lt;int32, int32&gt; trapItem = 4;</code>
     */

    public java.util.Map<java.lang.Integer, java.lang.Integer> getTrapItemMap() {
      return internalGetTrapItem().getMap();
    }
    /**
     * <pre>
     * ???????????????????????????????????????
     * </pre>
     *
     * <code>map&lt;int32, int32&gt; trapItem = 4;</code>
     */

    public int getTrapItemOrDefault(
        int key,
        int defaultValue) {
      
      java.util.Map<java.lang.Integer, java.lang.Integer> map =
          internalGetTrapItem().getMap();
      return map.containsKey(key) ? map.get(key) : defaultValue;
    }
    /**
     * <pre>
     * ???????????????????????????????????????
     * </pre>
     *
     * <code>map&lt;int32, int32&gt; trapItem = 4;</code>
     */

    public int getTrapItemOrThrow(
        int key) {
      
      java.util.Map<java.lang.Integer, java.lang.Integer> map =
          internalGetTrapItem().getMap();
      if (!map.containsKey(key)) {
        throw new java.lang.IllegalArgumentException();
      }
      return map.get(key);
    }

    public Builder clearTrapItem() {
      getMutableTrapItem().clear();
      return this;
    }
    /**
     * <pre>
     * ???????????????????????????????????????
     * </pre>
     *
     * <code>map&lt;int32, int32&gt; trapItem = 4;</code>
     */

    public Builder removeTrapItem(
        int key) {
      
      getMutableTrapItem().remove(key);
      return this;
    }
    /**
     * Use alternate mutation accessors instead.
     */
    @java.lang.Deprecated
    public java.util.Map<java.lang.Integer, java.lang.Integer>
    getMutableTrapItem() {
      return internalGetMutableTrapItem().getMutableMap();
    }
    /**
     * <pre>
     * ???????????????????????????????????????
     * </pre>
     *
     * <code>map&lt;int32, int32&gt; trapItem = 4;</code>
     */
    public Builder putTrapItem(
        int key,
        int value) {
      
      
      getMutableTrapItem().put(key, value);
      return this;
    }
    /**
     * <pre>
     * ???????????????????????????????????????
     * </pre>
     *
     * <code>map&lt;int32, int32&gt; trapItem = 4;</code>
     */

    public Builder putAllTrapItem(
        java.util.Map<java.lang.Integer, java.lang.Integer> values) {
      getMutableTrapItem().putAll(values);
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


    // @@protoc_insertion_point(builder_scope:Protocols.RobMapReq)
  }

  // @@protoc_insertion_point(class_scope:Protocols.RobMapReq)
  private static final com.dj.protobuf.rob.RobMapReq DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.dj.protobuf.rob.RobMapReq();
  }

  public static com.dj.protobuf.rob.RobMapReq getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  @java.lang.Deprecated public static final com.google.protobuf.Parser<RobMapReq>
      PARSER = new com.google.protobuf.AbstractParser<RobMapReq>() {
    public RobMapReq parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new RobMapReq(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<RobMapReq> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<RobMapReq> getParserForType() {
    return PARSER;
  }

  public com.dj.protobuf.rob.RobMapReq getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

