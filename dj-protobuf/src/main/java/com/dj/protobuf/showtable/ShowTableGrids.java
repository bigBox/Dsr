// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: ShowTable.proto

package com.dj.protobuf.showtable;

/**
 * Protobuf type {@code Protocols.ShowTableGrids}
 */
public  final class ShowTableGrids extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:Protocols.ShowTableGrids)
    ShowTableGridsOrBuilder {
  // Use ShowTableGrids.newBuilder() to construct.
  private ShowTableGrids(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private ShowTableGrids() {
    money_ = 0;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private ShowTableGrids(
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
            if (!((mutable_bitField0_ & 0x00000001) == 0x00000001)) {
              grids_ = com.google.protobuf.MapField.newMapField(
                  GridsDefaultEntryHolder.defaultEntry);
              mutable_bitField0_ |= 0x00000001;
            }
            com.google.protobuf.MapEntry<java.lang.Integer, com.dj.protobuf.showtable.ShowTableItem>
            grids = input.readMessage(
                GridsDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistry);
            grids_.getMutableMap().put(grids.getKey(), grids.getValue());
            break;
          }
          case 16: {
            bitField0_ |= 0x00000001;
            money_ = input.readInt32();
            break;
          }
          case 26: {
            com.dj.protobuf.datetime.DateTime.Builder subBuilder = null;
            if (((bitField0_ & 0x00000002) == 0x00000002)) {
              subBuilder = resetTime_.toBuilder();
            }
            resetTime_ = input.readMessage(com.dj.protobuf.datetime.DateTime.PARSER, extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(resetTime_);
              resetTime_ = subBuilder.buildPartial();
            }
            bitField0_ |= 0x00000002;
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
    return com.dj.protobuf.showtable.ShowTable.internal_static_Protocols_ShowTableGrids_descriptor;
  }

  @SuppressWarnings({"rawtypes"})
  protected com.google.protobuf.MapField internalGetMapField(
      int number) {
    switch (number) {
      case 1:
        return internalGetGrids();
      default:
        throw new RuntimeException(
            "Invalid map field number: " + number);
    }
  }
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.dj.protobuf.showtable.ShowTable.internal_static_Protocols_ShowTableGrids_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.dj.protobuf.showtable.ShowTableGrids.class, com.dj.protobuf.showtable.ShowTableGrids.Builder.class);
  }

  private int bitField0_;
  public static final int GRIDS_FIELD_NUMBER = 1;
  private static final class GridsDefaultEntryHolder {
    static final com.google.protobuf.MapEntry<
        java.lang.Integer, com.dj.protobuf.showtable.ShowTableItem> defaultEntry =
            com.google.protobuf.MapEntry
            .<java.lang.Integer, com.dj.protobuf.showtable.ShowTableItem>newDefaultInstance(
                com.dj.protobuf.showtable.ShowTable.internal_static_Protocols_ShowTableGrids_GridsEntry_descriptor, 
                com.google.protobuf.WireFormat.FieldType.INT32,
                0,
                com.google.protobuf.WireFormat.FieldType.MESSAGE,
                com.dj.protobuf.showtable.ShowTableItem.getDefaultInstance());
  }
  private com.google.protobuf.MapField<
      java.lang.Integer, com.dj.protobuf.showtable.ShowTableItem> grids_;
  private com.google.protobuf.MapField<java.lang.Integer, com.dj.protobuf.showtable.ShowTableItem>
  internalGetGrids() {
    if (grids_ == null) {
      return com.google.protobuf.MapField.emptyMapField(
          GridsDefaultEntryHolder.defaultEntry);
    }
    return grids_;
  }

  public int getGridsCount() {
    return internalGetGrids().getMap().size();
  }
  /**
   * <code>map&lt;int32, .Protocols.ShowTableItem&gt; grids = 1;</code>
   */

  public boolean containsGrids(
      int key) {
    
    return internalGetGrids().getMap().containsKey(key);
  }
  /**
   * Use {@link #getGridsMap()} instead.
   */
  @java.lang.Deprecated
  public java.util.Map<java.lang.Integer, com.dj.protobuf.showtable.ShowTableItem> getGrids() {
    return getGridsMap();
  }
  /**
   * <code>map&lt;int32, .Protocols.ShowTableItem&gt; grids = 1;</code>
   */

  public java.util.Map<java.lang.Integer, com.dj.protobuf.showtable.ShowTableItem> getGridsMap() {
    return internalGetGrids().getMap();
  }
  /**
   * <code>map&lt;int32, .Protocols.ShowTableItem&gt; grids = 1;</code>
   */

  public com.dj.protobuf.showtable.ShowTableItem getGridsOrDefault(
      int key,
      com.dj.protobuf.showtable.ShowTableItem defaultValue) {
    
    java.util.Map<java.lang.Integer, com.dj.protobuf.showtable.ShowTableItem> map =
        internalGetGrids().getMap();
    return map.containsKey(key) ? map.get(key) : defaultValue;
  }
  /**
   * <code>map&lt;int32, .Protocols.ShowTableItem&gt; grids = 1;</code>
   */

  public com.dj.protobuf.showtable.ShowTableItem getGridsOrThrow(
      int key) {
    
    java.util.Map<java.lang.Integer, com.dj.protobuf.showtable.ShowTableItem> map =
        internalGetGrids().getMap();
    if (!map.containsKey(key)) {
      throw new java.lang.IllegalArgumentException();
    }
    return map.get(key);
  }

  public static final int MONEY_FIELD_NUMBER = 2;
  private int money_;
  /**
   * <code>optional int32 money = 2;</code>
   */
  public boolean hasMoney() {
    return ((bitField0_ & 0x00000001) == 0x00000001);
  }
  /**
   * <code>optional int32 money = 2;</code>
   */
  public int getMoney() {
    return money_;
  }

  public static final int RESETTIME_FIELD_NUMBER = 3;
  private com.dj.protobuf.datetime.DateTime resetTime_;
  /**
   * <code>optional .Protocols.DateTime resetTime = 3;</code>
   */
  public boolean hasResetTime() {
    return ((bitField0_ & 0x00000002) == 0x00000002);
  }
  /**
   * <code>optional .Protocols.DateTime resetTime = 3;</code>
   */
  public com.dj.protobuf.datetime.DateTime getResetTime() {
    return resetTime_ == null ? com.dj.protobuf.datetime.DateTime.getDefaultInstance() : resetTime_;
  }
  /**
   * <code>optional .Protocols.DateTime resetTime = 3;</code>
   */
  public com.dj.protobuf.datetime.DateTimeOrBuilder getResetTimeOrBuilder() {
    return resetTime_ == null ? com.dj.protobuf.datetime.DateTime.getDefaultInstance() : resetTime_;
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
    for (java.util.Map.Entry<java.lang.Integer, com.dj.protobuf.showtable.ShowTableItem> entry
         : internalGetGrids().getMap().entrySet()) {
      com.google.protobuf.MapEntry<java.lang.Integer, com.dj.protobuf.showtable.ShowTableItem>
      grids = GridsDefaultEntryHolder.defaultEntry.newBuilderForType()
          .setKey(entry.getKey())
          .setValue(entry.getValue())
          .build();
      output.writeMessage(1, grids);
    }
    if (((bitField0_ & 0x00000001) == 0x00000001)) {
      output.writeInt32(2, money_);
    }
    if (((bitField0_ & 0x00000002) == 0x00000002)) {
      output.writeMessage(3, getResetTime());
    }
    unknownFields.writeTo(output);
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    for (java.util.Map.Entry<java.lang.Integer, com.dj.protobuf.showtable.ShowTableItem> entry
         : internalGetGrids().getMap().entrySet()) {
      com.google.protobuf.MapEntry<java.lang.Integer, com.dj.protobuf.showtable.ShowTableItem>
      grids = GridsDefaultEntryHolder.defaultEntry.newBuilderForType()
          .setKey(entry.getKey())
          .setValue(entry.getValue())
          .build();
      size += com.google.protobuf.CodedOutputStream
          .computeMessageSize(1, grids);
    }
    if (((bitField0_ & 0x00000001) == 0x00000001)) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(2, money_);
    }
    if (((bitField0_ & 0x00000002) == 0x00000002)) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(3, getResetTime());
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
    if (!(obj instanceof com.dj.protobuf.showtable.ShowTableGrids)) {
      return super.equals(obj);
    }
    com.dj.protobuf.showtable.ShowTableGrids other = (com.dj.protobuf.showtable.ShowTableGrids) obj;

    boolean result = true;
    result = result && internalGetGrids().equals(
        other.internalGetGrids());
    result = result && (hasMoney() == other.hasMoney());
    if (hasMoney()) {
      result = result && (getMoney()
          == other.getMoney());
    }
    result = result && (hasResetTime() == other.hasResetTime());
    if (hasResetTime()) {
      result = result && getResetTime()
          .equals(other.getResetTime());
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
    if (!internalGetGrids().getMap().isEmpty()) {
      hash = (37 * hash) + GRIDS_FIELD_NUMBER;
      hash = (53 * hash) + internalGetGrids().hashCode();
    }
    if (hasMoney()) {
      hash = (37 * hash) + MONEY_FIELD_NUMBER;
      hash = (53 * hash) + getMoney();
    }
    if (hasResetTime()) {
      hash = (37 * hash) + RESETTIME_FIELD_NUMBER;
      hash = (53 * hash) + getResetTime().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.dj.protobuf.showtable.ShowTableGrids parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dj.protobuf.showtable.ShowTableGrids parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dj.protobuf.showtable.ShowTableGrids parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dj.protobuf.showtable.ShowTableGrids parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dj.protobuf.showtable.ShowTableGrids parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.showtable.ShowTableGrids parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.dj.protobuf.showtable.ShowTableGrids parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.showtable.ShowTableGrids parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.dj.protobuf.showtable.ShowTableGrids parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.showtable.ShowTableGrids parseFrom(
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
  public static Builder newBuilder(com.dj.protobuf.showtable.ShowTableGrids prototype) {
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
   * Protobuf type {@code Protocols.ShowTableGrids}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:Protocols.ShowTableGrids)
      com.dj.protobuf.showtable.ShowTableGridsOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.dj.protobuf.showtable.ShowTable.internal_static_Protocols_ShowTableGrids_descriptor;
    }

    @SuppressWarnings({"rawtypes"})
    protected com.google.protobuf.MapField internalGetMapField(
        int number) {
      switch (number) {
        case 1:
          return internalGetGrids();
        default:
          throw new RuntimeException(
              "Invalid map field number: " + number);
      }
    }
    @SuppressWarnings({"rawtypes"})
    protected com.google.protobuf.MapField internalGetMutableMapField(
        int number) {
      switch (number) {
        case 1:
          return internalGetMutableGrids();
        default:
          throw new RuntimeException(
              "Invalid map field number: " + number);
      }
    }
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.dj.protobuf.showtable.ShowTable.internal_static_Protocols_ShowTableGrids_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.dj.protobuf.showtable.ShowTableGrids.class, com.dj.protobuf.showtable.ShowTableGrids.Builder.class);
    }

    // Construct using com.dj.protobuf.showtable.ShowTableGrids.newBuilder()
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
        getResetTimeFieldBuilder();
      }
    }
    public Builder clear() {
      super.clear();
      internalGetMutableGrids().clear();
      money_ = 0;
      bitField0_ = (bitField0_ & ~0x00000002);
      if (resetTimeBuilder_ == null) {
        resetTime_ = null;
      } else {
        resetTimeBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000004);
      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.dj.protobuf.showtable.ShowTable.internal_static_Protocols_ShowTableGrids_descriptor;
    }

    public com.dj.protobuf.showtable.ShowTableGrids getDefaultInstanceForType() {
      return com.dj.protobuf.showtable.ShowTableGrids.getDefaultInstance();
    }

    public com.dj.protobuf.showtable.ShowTableGrids build() {
      com.dj.protobuf.showtable.ShowTableGrids result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public com.dj.protobuf.showtable.ShowTableGrids buildPartial() {
      com.dj.protobuf.showtable.ShowTableGrids result = new com.dj.protobuf.showtable.ShowTableGrids(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      result.grids_ = internalGetGrids();
      result.grids_.makeImmutable();
      if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
        to_bitField0_ |= 0x00000001;
      }
      result.money_ = money_;
      if (((from_bitField0_ & 0x00000004) == 0x00000004)) {
        to_bitField0_ |= 0x00000002;
      }
      if (resetTimeBuilder_ == null) {
        result.resetTime_ = resetTime_;
      } else {
        result.resetTime_ = resetTimeBuilder_.build();
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
      if (other instanceof com.dj.protobuf.showtable.ShowTableGrids) {
        return mergeFrom((com.dj.protobuf.showtable.ShowTableGrids)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.dj.protobuf.showtable.ShowTableGrids other) {
      if (other == com.dj.protobuf.showtable.ShowTableGrids.getDefaultInstance()) return this;
      internalGetMutableGrids().mergeFrom(
          other.internalGetGrids());
      if (other.hasMoney()) {
        setMoney(other.getMoney());
      }
      if (other.hasResetTime()) {
        mergeResetTime(other.getResetTime());
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
      com.dj.protobuf.showtable.ShowTableGrids parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.dj.protobuf.showtable.ShowTableGrids) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private com.google.protobuf.MapField<
        java.lang.Integer, com.dj.protobuf.showtable.ShowTableItem> grids_;
    private com.google.protobuf.MapField<java.lang.Integer, com.dj.protobuf.showtable.ShowTableItem>
    internalGetGrids() {
      if (grids_ == null) {
        return com.google.protobuf.MapField.emptyMapField(
            GridsDefaultEntryHolder.defaultEntry);
      }
      return grids_;
    }
    private com.google.protobuf.MapField<java.lang.Integer, com.dj.protobuf.showtable.ShowTableItem>
    internalGetMutableGrids() {
      onChanged();;
      if (grids_ == null) {
        grids_ = com.google.protobuf.MapField.newMapField(
            GridsDefaultEntryHolder.defaultEntry);
      }
      if (!grids_.isMutable()) {
        grids_ = grids_.copy();
      }
      return grids_;
    }

    public int getGridsCount() {
      return internalGetGrids().getMap().size();
    }
    /**
     * <code>map&lt;int32, .Protocols.ShowTableItem&gt; grids = 1;</code>
     */

    public boolean containsGrids(
        int key) {
      
      return internalGetGrids().getMap().containsKey(key);
    }
    /**
     * Use {@link #getGridsMap()} instead.
     */
    @java.lang.Deprecated
    public java.util.Map<java.lang.Integer, com.dj.protobuf.showtable.ShowTableItem> getGrids() {
      return getGridsMap();
    }
    /**
     * <code>map&lt;int32, .Protocols.ShowTableItem&gt; grids = 1;</code>
     */

    public java.util.Map<java.lang.Integer, com.dj.protobuf.showtable.ShowTableItem> getGridsMap() {
      return internalGetGrids().getMap();
    }
    /**
     * <code>map&lt;int32, .Protocols.ShowTableItem&gt; grids = 1;</code>
     */

    public com.dj.protobuf.showtable.ShowTableItem getGridsOrDefault(
        int key,
        com.dj.protobuf.showtable.ShowTableItem defaultValue) {
      
      java.util.Map<java.lang.Integer, com.dj.protobuf.showtable.ShowTableItem> map =
          internalGetGrids().getMap();
      return map.containsKey(key) ? map.get(key) : defaultValue;
    }
    /**
     * <code>map&lt;int32, .Protocols.ShowTableItem&gt; grids = 1;</code>
     */

    public com.dj.protobuf.showtable.ShowTableItem getGridsOrThrow(
        int key) {
      
      java.util.Map<java.lang.Integer, com.dj.protobuf.showtable.ShowTableItem> map =
          internalGetGrids().getMap();
      if (!map.containsKey(key)) {
        throw new java.lang.IllegalArgumentException();
      }
      return map.get(key);
    }

    public Builder clearGrids() {
      getMutableGrids().clear();
      return this;
    }
    /**
     * <code>map&lt;int32, .Protocols.ShowTableItem&gt; grids = 1;</code>
     */

    public Builder removeGrids(
        int key) {
      
      getMutableGrids().remove(key);
      return this;
    }
    /**
     * Use alternate mutation accessors instead.
     */
    @java.lang.Deprecated
    public java.util.Map<java.lang.Integer, com.dj.protobuf.showtable.ShowTableItem>
    getMutableGrids() {
      return internalGetMutableGrids().getMutableMap();
    }
    /**
     * <code>map&lt;int32, .Protocols.ShowTableItem&gt; grids = 1;</code>
     */
    public Builder putGrids(
        int key,
        com.dj.protobuf.showtable.ShowTableItem value) {
      
      if (value == null) { throw new java.lang.NullPointerException(); }
      getMutableGrids().put(key, value);
      return this;
    }
    /**
     * <code>map&lt;int32, .Protocols.ShowTableItem&gt; grids = 1;</code>
     */

    public Builder putAllGrids(
        java.util.Map<java.lang.Integer, com.dj.protobuf.showtable.ShowTableItem> values) {
      getMutableGrids().putAll(values);
      return this;
    }

    private int money_ ;
    /**
     * <code>optional int32 money = 2;</code>
     */
    public boolean hasMoney() {
      return ((bitField0_ & 0x00000002) == 0x00000002);
    }
    /**
     * <code>optional int32 money = 2;</code>
     */
    public int getMoney() {
      return money_;
    }
    /**
     * <code>optional int32 money = 2;</code>
     */
    public Builder setMoney(int value) {
      bitField0_ |= 0x00000002;
      money_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional int32 money = 2;</code>
     */
    public Builder clearMoney() {
      bitField0_ = (bitField0_ & ~0x00000002);
      money_ = 0;
      onChanged();
      return this;
    }

    private com.dj.protobuf.datetime.DateTime resetTime_ = null;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.dj.protobuf.datetime.DateTime, com.dj.protobuf.datetime.DateTime.Builder, com.dj.protobuf.datetime.DateTimeOrBuilder> resetTimeBuilder_;
    /**
     * <code>optional .Protocols.DateTime resetTime = 3;</code>
     */
    public boolean hasResetTime() {
      return ((bitField0_ & 0x00000004) == 0x00000004);
    }
    /**
     * <code>optional .Protocols.DateTime resetTime = 3;</code>
     */
    public com.dj.protobuf.datetime.DateTime getResetTime() {
      if (resetTimeBuilder_ == null) {
        return resetTime_ == null ? com.dj.protobuf.datetime.DateTime.getDefaultInstance() : resetTime_;
      } else {
        return resetTimeBuilder_.getMessage();
      }
    }
    /**
     * <code>optional .Protocols.DateTime resetTime = 3;</code>
     */
    public Builder setResetTime(com.dj.protobuf.datetime.DateTime value) {
      if (resetTimeBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        resetTime_ = value;
        onChanged();
      } else {
        resetTimeBuilder_.setMessage(value);
      }
      bitField0_ |= 0x00000004;
      return this;
    }
    /**
     * <code>optional .Protocols.DateTime resetTime = 3;</code>
     */
    public Builder setResetTime(
        com.dj.protobuf.datetime.DateTime.Builder builderForValue) {
      if (resetTimeBuilder_ == null) {
        resetTime_ = builderForValue.build();
        onChanged();
      } else {
        resetTimeBuilder_.setMessage(builderForValue.build());
      }
      bitField0_ |= 0x00000004;
      return this;
    }
    /**
     * <code>optional .Protocols.DateTime resetTime = 3;</code>
     */
    public Builder mergeResetTime(com.dj.protobuf.datetime.DateTime value) {
      if (resetTimeBuilder_ == null) {
        if (((bitField0_ & 0x00000004) == 0x00000004) &&
            resetTime_ != null &&
            resetTime_ != com.dj.protobuf.datetime.DateTime.getDefaultInstance()) {
          resetTime_ =
            com.dj.protobuf.datetime.DateTime.newBuilder(resetTime_).mergeFrom(value).buildPartial();
        } else {
          resetTime_ = value;
        }
        onChanged();
      } else {
        resetTimeBuilder_.mergeFrom(value);
      }
      bitField0_ |= 0x00000004;
      return this;
    }
    /**
     * <code>optional .Protocols.DateTime resetTime = 3;</code>
     */
    public Builder clearResetTime() {
      if (resetTimeBuilder_ == null) {
        resetTime_ = null;
        onChanged();
      } else {
        resetTimeBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000004);
      return this;
    }
    /**
     * <code>optional .Protocols.DateTime resetTime = 3;</code>
     */
    public com.dj.protobuf.datetime.DateTime.Builder getResetTimeBuilder() {
      bitField0_ |= 0x00000004;
      onChanged();
      return getResetTimeFieldBuilder().getBuilder();
    }
    /**
     * <code>optional .Protocols.DateTime resetTime = 3;</code>
     */
    public com.dj.protobuf.datetime.DateTimeOrBuilder getResetTimeOrBuilder() {
      if (resetTimeBuilder_ != null) {
        return resetTimeBuilder_.getMessageOrBuilder();
      } else {
        return resetTime_ == null ?
            com.dj.protobuf.datetime.DateTime.getDefaultInstance() : resetTime_;
      }
    }
    /**
     * <code>optional .Protocols.DateTime resetTime = 3;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.dj.protobuf.datetime.DateTime, com.dj.protobuf.datetime.DateTime.Builder, com.dj.protobuf.datetime.DateTimeOrBuilder> 
        getResetTimeFieldBuilder() {
      if (resetTimeBuilder_ == null) {
        resetTimeBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.dj.protobuf.datetime.DateTime, com.dj.protobuf.datetime.DateTime.Builder, com.dj.protobuf.datetime.DateTimeOrBuilder>(
                getResetTime(),
                getParentForChildren(),
                isClean());
        resetTime_ = null;
      }
      return resetTimeBuilder_;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:Protocols.ShowTableGrids)
  }

  // @@protoc_insertion_point(class_scope:Protocols.ShowTableGrids)
  private static final com.dj.protobuf.showtable.ShowTableGrids DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.dj.protobuf.showtable.ShowTableGrids();
  }

  public static com.dj.protobuf.showtable.ShowTableGrids getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  @java.lang.Deprecated public static final com.google.protobuf.Parser<ShowTableGrids>
      PARSER = new com.google.protobuf.AbstractParser<ShowTableGrids>() {
    public ShowTableGrids parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new ShowTableGrids(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<ShowTableGrids> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<ShowTableGrids> getParserForType() {
    return PARSER;
  }

  public com.dj.protobuf.showtable.ShowTableGrids getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

