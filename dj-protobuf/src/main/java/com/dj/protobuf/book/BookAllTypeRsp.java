// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Book.proto

package com.dj.protobuf.book;

/**
 * Protobuf type {@code Protocols.BookAllTypeRsp}
 */
public  final class BookAllTypeRsp extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:Protocols.BookAllTypeRsp)
    BookAllTypeRspOrBuilder {
  // Use BookAllTypeRsp.newBuilder() to construct.
  private BookAllTypeRsp(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private BookAllTypeRsp() {
    errorID_ = 0;
    totalRatio_ = 0;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private BookAllTypeRsp(
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
            com.dj.protobuf.ErrorIDOuterClass.ErrorID value = com.dj.protobuf.ErrorIDOuterClass.ErrorID.valueOf(rawValue);
            if (value == null) {
              unknownFields.mergeVarintField(1, rawValue);
            } else {
              bitField0_ |= 0x00000001;
              errorID_ = rawValue;
            }
            break;
          }
          case 16: {
            bitField0_ |= 0x00000002;
            totalRatio_ = input.readInt32();
            break;
          }
          case 26: {
            if (!((mutable_bitField0_ & 0x00000004) == 0x00000004)) {
              typeMap_ = com.google.protobuf.MapField.newMapField(
                  TypeMapDefaultEntryHolder.defaultEntry);
              mutable_bitField0_ |= 0x00000004;
            }
            com.google.protobuf.MapEntry<java.lang.Integer, java.lang.Integer>
            typeMap = input.readMessage(
                TypeMapDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistry);
            typeMap_.getMutableMap().put(typeMap.getKey(), typeMap.getValue());
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
    return com.dj.protobuf.book.Book.internal_static_Protocols_BookAllTypeRsp_descriptor;
  }

  @SuppressWarnings({"rawtypes"})
  protected com.google.protobuf.MapField internalGetMapField(
      int number) {
    switch (number) {
      case 3:
        return internalGetTypeMap();
      default:
        throw new RuntimeException(
            "Invalid map field number: " + number);
    }
  }
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.dj.protobuf.book.Book.internal_static_Protocols_BookAllTypeRsp_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.dj.protobuf.book.BookAllTypeRsp.class, com.dj.protobuf.book.BookAllTypeRsp.Builder.class);
  }

  private int bitField0_;
  public static final int ERRORID_FIELD_NUMBER = 1;
  private int errorID_;
  /**
   * <code>optional .ErrorID errorID = 1;</code>
   */
  public boolean hasErrorID() {
    return ((bitField0_ & 0x00000001) == 0x00000001);
  }
  /**
   * <code>optional .ErrorID errorID = 1;</code>
   */
  public com.dj.protobuf.ErrorIDOuterClass.ErrorID getErrorID() {
    com.dj.protobuf.ErrorIDOuterClass.ErrorID result = com.dj.protobuf.ErrorIDOuterClass.ErrorID.valueOf(errorID_);
    return result == null ? com.dj.protobuf.ErrorIDOuterClass.ErrorID.OK : result;
  }

  public static final int TOTALRATIO_FIELD_NUMBER = 2;
  private int totalRatio_;
  /**
   * <pre>
   * ????????????
   * </pre>
   *
   * <code>optional int32 totalRatio = 2;</code>
   */
  public boolean hasTotalRatio() {
    return ((bitField0_ & 0x00000002) == 0x00000002);
  }
  /**
   * <pre>
   * ????????????
   * </pre>
   *
   * <code>optional int32 totalRatio = 2;</code>
   */
  public int getTotalRatio() {
    return totalRatio_;
  }

  public static final int TYPEMAP_FIELD_NUMBER = 3;
  private static final class TypeMapDefaultEntryHolder {
    static final com.google.protobuf.MapEntry<
        java.lang.Integer, java.lang.Integer> defaultEntry =
            com.google.protobuf.MapEntry
            .<java.lang.Integer, java.lang.Integer>newDefaultInstance(
                com.dj.protobuf.book.Book.internal_static_Protocols_BookAllTypeRsp_TypeMapEntry_descriptor, 
                com.google.protobuf.WireFormat.FieldType.INT32,
                0,
                com.google.protobuf.WireFormat.FieldType.INT32,
                0);
  }
  private com.google.protobuf.MapField<
      java.lang.Integer, java.lang.Integer> typeMap_;
  private com.google.protobuf.MapField<java.lang.Integer, java.lang.Integer>
  internalGetTypeMap() {
    if (typeMap_ == null) {
      return com.google.protobuf.MapField.emptyMapField(
          TypeMapDefaultEntryHolder.defaultEntry);
    }
    return typeMap_;
  }

  public int getTypeMapCount() {
    return internalGetTypeMap().getMap().size();
  }
  /**
   * <pre>
   * ?????????????????????????????????
   * </pre>
   *
   * <code>map&lt;int32, int32&gt; typeMap = 3;</code>
   */

  public boolean containsTypeMap(
      int key) {
    
    return internalGetTypeMap().getMap().containsKey(key);
  }
  /**
   * Use {@link #getTypeMapMap()} instead.
   */
  @java.lang.Deprecated
  public java.util.Map<java.lang.Integer, java.lang.Integer> getTypeMap() {
    return getTypeMapMap();
  }
  /**
   * <pre>
   * ?????????????????????????????????
   * </pre>
   *
   * <code>map&lt;int32, int32&gt; typeMap = 3;</code>
   */

  public java.util.Map<java.lang.Integer, java.lang.Integer> getTypeMapMap() {
    return internalGetTypeMap().getMap();
  }
  /**
   * <pre>
   * ?????????????????????????????????
   * </pre>
   *
   * <code>map&lt;int32, int32&gt; typeMap = 3;</code>
   */

  public int getTypeMapOrDefault(
      int key,
      int defaultValue) {
    
    java.util.Map<java.lang.Integer, java.lang.Integer> map =
        internalGetTypeMap().getMap();
    return map.containsKey(key) ? map.get(key) : defaultValue;
  }
  /**
   * <pre>
   * ?????????????????????????????????
   * </pre>
   *
   * <code>map&lt;int32, int32&gt; typeMap = 3;</code>
   */

  public int getTypeMapOrThrow(
      int key) {
    
    java.util.Map<java.lang.Integer, java.lang.Integer> map =
        internalGetTypeMap().getMap();
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
      output.writeEnum(1, errorID_);
    }
    if (((bitField0_ & 0x00000002) == 0x00000002)) {
      output.writeInt32(2, totalRatio_);
    }
    for (java.util.Map.Entry<java.lang.Integer, java.lang.Integer> entry
         : internalGetTypeMap().getMap().entrySet()) {
      com.google.protobuf.MapEntry<java.lang.Integer, java.lang.Integer>
      typeMap = TypeMapDefaultEntryHolder.defaultEntry.newBuilderForType()
          .setKey(entry.getKey())
          .setValue(entry.getValue())
          .build();
      output.writeMessage(3, typeMap);
    }
    unknownFields.writeTo(output);
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (((bitField0_ & 0x00000001) == 0x00000001)) {
      size += com.google.protobuf.CodedOutputStream
        .computeEnumSize(1, errorID_);
    }
    if (((bitField0_ & 0x00000002) == 0x00000002)) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(2, totalRatio_);
    }
    for (java.util.Map.Entry<java.lang.Integer, java.lang.Integer> entry
         : internalGetTypeMap().getMap().entrySet()) {
      com.google.protobuf.MapEntry<java.lang.Integer, java.lang.Integer>
      typeMap = TypeMapDefaultEntryHolder.defaultEntry.newBuilderForType()
          .setKey(entry.getKey())
          .setValue(entry.getValue())
          .build();
      size += com.google.protobuf.CodedOutputStream
          .computeMessageSize(3, typeMap);
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
    if (!(obj instanceof com.dj.protobuf.book.BookAllTypeRsp)) {
      return super.equals(obj);
    }
    com.dj.protobuf.book.BookAllTypeRsp other = (com.dj.protobuf.book.BookAllTypeRsp) obj;

    boolean result = true;
    result = result && (hasErrorID() == other.hasErrorID());
    if (hasErrorID()) {
      result = result && errorID_ == other.errorID_;
    }
    result = result && (hasTotalRatio() == other.hasTotalRatio());
    if (hasTotalRatio()) {
      result = result && (getTotalRatio()
          == other.getTotalRatio());
    }
    result = result && internalGetTypeMap().equals(
        other.internalGetTypeMap());
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
    if (hasErrorID()) {
      hash = (37 * hash) + ERRORID_FIELD_NUMBER;
      hash = (53 * hash) + errorID_;
    }
    if (hasTotalRatio()) {
      hash = (37 * hash) + TOTALRATIO_FIELD_NUMBER;
      hash = (53 * hash) + getTotalRatio();
    }
    if (!internalGetTypeMap().getMap().isEmpty()) {
      hash = (37 * hash) + TYPEMAP_FIELD_NUMBER;
      hash = (53 * hash) + internalGetTypeMap().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.dj.protobuf.book.BookAllTypeRsp parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dj.protobuf.book.BookAllTypeRsp parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dj.protobuf.book.BookAllTypeRsp parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dj.protobuf.book.BookAllTypeRsp parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dj.protobuf.book.BookAllTypeRsp parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.book.BookAllTypeRsp parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.dj.protobuf.book.BookAllTypeRsp parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.book.BookAllTypeRsp parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.dj.protobuf.book.BookAllTypeRsp parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.book.BookAllTypeRsp parseFrom(
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
  public static Builder newBuilder(com.dj.protobuf.book.BookAllTypeRsp prototype) {
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
   * Protobuf type {@code Protocols.BookAllTypeRsp}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:Protocols.BookAllTypeRsp)
      com.dj.protobuf.book.BookAllTypeRspOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.dj.protobuf.book.Book.internal_static_Protocols_BookAllTypeRsp_descriptor;
    }

    @SuppressWarnings({"rawtypes"})
    protected com.google.protobuf.MapField internalGetMapField(
        int number) {
      switch (number) {
        case 3:
          return internalGetTypeMap();
        default:
          throw new RuntimeException(
              "Invalid map field number: " + number);
      }
    }
    @SuppressWarnings({"rawtypes"})
    protected com.google.protobuf.MapField internalGetMutableMapField(
        int number) {
      switch (number) {
        case 3:
          return internalGetMutableTypeMap();
        default:
          throw new RuntimeException(
              "Invalid map field number: " + number);
      }
    }
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.dj.protobuf.book.Book.internal_static_Protocols_BookAllTypeRsp_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.dj.protobuf.book.BookAllTypeRsp.class, com.dj.protobuf.book.BookAllTypeRsp.Builder.class);
    }

    // Construct using com.dj.protobuf.book.BookAllTypeRsp.newBuilder()
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
      errorID_ = 0;
      bitField0_ = (bitField0_ & ~0x00000001);
      totalRatio_ = 0;
      bitField0_ = (bitField0_ & ~0x00000002);
      internalGetMutableTypeMap().clear();
      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.dj.protobuf.book.Book.internal_static_Protocols_BookAllTypeRsp_descriptor;
    }

    public com.dj.protobuf.book.BookAllTypeRsp getDefaultInstanceForType() {
      return com.dj.protobuf.book.BookAllTypeRsp.getDefaultInstance();
    }

    public com.dj.protobuf.book.BookAllTypeRsp build() {
      com.dj.protobuf.book.BookAllTypeRsp result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public com.dj.protobuf.book.BookAllTypeRsp buildPartial() {
      com.dj.protobuf.book.BookAllTypeRsp result = new com.dj.protobuf.book.BookAllTypeRsp(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
        to_bitField0_ |= 0x00000001;
      }
      result.errorID_ = errorID_;
      if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
        to_bitField0_ |= 0x00000002;
      }
      result.totalRatio_ = totalRatio_;
      result.typeMap_ = internalGetTypeMap();
      result.typeMap_.makeImmutable();
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
      if (other instanceof com.dj.protobuf.book.BookAllTypeRsp) {
        return mergeFrom((com.dj.protobuf.book.BookAllTypeRsp)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.dj.protobuf.book.BookAllTypeRsp other) {
      if (other == com.dj.protobuf.book.BookAllTypeRsp.getDefaultInstance()) return this;
      if (other.hasErrorID()) {
        setErrorID(other.getErrorID());
      }
      if (other.hasTotalRatio()) {
        setTotalRatio(other.getTotalRatio());
      }
      internalGetMutableTypeMap().mergeFrom(
          other.internalGetTypeMap());
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
      com.dj.protobuf.book.BookAllTypeRsp parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.dj.protobuf.book.BookAllTypeRsp) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private int errorID_ = 0;
    /**
     * <code>optional .ErrorID errorID = 1;</code>
     */
    public boolean hasErrorID() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <code>optional .ErrorID errorID = 1;</code>
     */
    public com.dj.protobuf.ErrorIDOuterClass.ErrorID getErrorID() {
      com.dj.protobuf.ErrorIDOuterClass.ErrorID result = com.dj.protobuf.ErrorIDOuterClass.ErrorID.valueOf(errorID_);
      return result == null ? com.dj.protobuf.ErrorIDOuterClass.ErrorID.OK : result;
    }
    /**
     * <code>optional .ErrorID errorID = 1;</code>
     */
    public Builder setErrorID(com.dj.protobuf.ErrorIDOuterClass.ErrorID value) {
      if (value == null) {
        throw new NullPointerException();
      }
      bitField0_ |= 0x00000001;
      errorID_ = value.getNumber();
      onChanged();
      return this;
    }
    /**
     * <code>optional .ErrorID errorID = 1;</code>
     */
    public Builder clearErrorID() {
      bitField0_ = (bitField0_ & ~0x00000001);
      errorID_ = 0;
      onChanged();
      return this;
    }

    private int totalRatio_ ;
    /**
     * <pre>
     * ????????????
     * </pre>
     *
     * <code>optional int32 totalRatio = 2;</code>
     */
    public boolean hasTotalRatio() {
      return ((bitField0_ & 0x00000002) == 0x00000002);
    }
    /**
     * <pre>
     * ????????????
     * </pre>
     *
     * <code>optional int32 totalRatio = 2;</code>
     */
    public int getTotalRatio() {
      return totalRatio_;
    }
    /**
     * <pre>
     * ????????????
     * </pre>
     *
     * <code>optional int32 totalRatio = 2;</code>
     */
    public Builder setTotalRatio(int value) {
      bitField0_ |= 0x00000002;
      totalRatio_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * ????????????
     * </pre>
     *
     * <code>optional int32 totalRatio = 2;</code>
     */
    public Builder clearTotalRatio() {
      bitField0_ = (bitField0_ & ~0x00000002);
      totalRatio_ = 0;
      onChanged();
      return this;
    }

    private com.google.protobuf.MapField<
        java.lang.Integer, java.lang.Integer> typeMap_;
    private com.google.protobuf.MapField<java.lang.Integer, java.lang.Integer>
    internalGetTypeMap() {
      if (typeMap_ == null) {
        return com.google.protobuf.MapField.emptyMapField(
            TypeMapDefaultEntryHolder.defaultEntry);
      }
      return typeMap_;
    }
    private com.google.protobuf.MapField<java.lang.Integer, java.lang.Integer>
    internalGetMutableTypeMap() {
      onChanged();;
      if (typeMap_ == null) {
        typeMap_ = com.google.protobuf.MapField.newMapField(
            TypeMapDefaultEntryHolder.defaultEntry);
      }
      if (!typeMap_.isMutable()) {
        typeMap_ = typeMap_.copy();
      }
      return typeMap_;
    }

    public int getTypeMapCount() {
      return internalGetTypeMap().getMap().size();
    }
    /**
     * <pre>
     * ?????????????????????????????????
     * </pre>
     *
     * <code>map&lt;int32, int32&gt; typeMap = 3;</code>
     */

    public boolean containsTypeMap(
        int key) {
      
      return internalGetTypeMap().getMap().containsKey(key);
    }
    /**
     * Use {@link #getTypeMapMap()} instead.
     */
    @java.lang.Deprecated
    public java.util.Map<java.lang.Integer, java.lang.Integer> getTypeMap() {
      return getTypeMapMap();
    }
    /**
     * <pre>
     * ?????????????????????????????????
     * </pre>
     *
     * <code>map&lt;int32, int32&gt; typeMap = 3;</code>
     */

    public java.util.Map<java.lang.Integer, java.lang.Integer> getTypeMapMap() {
      return internalGetTypeMap().getMap();
    }
    /**
     * <pre>
     * ?????????????????????????????????
     * </pre>
     *
     * <code>map&lt;int32, int32&gt; typeMap = 3;</code>
     */

    public int getTypeMapOrDefault(
        int key,
        int defaultValue) {
      
      java.util.Map<java.lang.Integer, java.lang.Integer> map =
          internalGetTypeMap().getMap();
      return map.containsKey(key) ? map.get(key) : defaultValue;
    }
    /**
     * <pre>
     * ?????????????????????????????????
     * </pre>
     *
     * <code>map&lt;int32, int32&gt; typeMap = 3;</code>
     */

    public int getTypeMapOrThrow(
        int key) {
      
      java.util.Map<java.lang.Integer, java.lang.Integer> map =
          internalGetTypeMap().getMap();
      if (!map.containsKey(key)) {
        throw new java.lang.IllegalArgumentException();
      }
      return map.get(key);
    }

    public Builder clearTypeMap() {
      getMutableTypeMap().clear();
      return this;
    }
    /**
     * <pre>
     * ?????????????????????????????????
     * </pre>
     *
     * <code>map&lt;int32, int32&gt; typeMap = 3;</code>
     */

    public Builder removeTypeMap(
        int key) {
      
      getMutableTypeMap().remove(key);
      return this;
    }
    /**
     * Use alternate mutation accessors instead.
     */
    @java.lang.Deprecated
    public java.util.Map<java.lang.Integer, java.lang.Integer>
    getMutableTypeMap() {
      return internalGetMutableTypeMap().getMutableMap();
    }
    /**
     * <pre>
     * ?????????????????????????????????
     * </pre>
     *
     * <code>map&lt;int32, int32&gt; typeMap = 3;</code>
     */
    public Builder putTypeMap(
        int key,
        int value) {
      
      
      getMutableTypeMap().put(key, value);
      return this;
    }
    /**
     * <pre>
     * ?????????????????????????????????
     * </pre>
     *
     * <code>map&lt;int32, int32&gt; typeMap = 3;</code>
     */

    public Builder putAllTypeMap(
        java.util.Map<java.lang.Integer, java.lang.Integer> values) {
      getMutableTypeMap().putAll(values);
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


    // @@protoc_insertion_point(builder_scope:Protocols.BookAllTypeRsp)
  }

  // @@protoc_insertion_point(class_scope:Protocols.BookAllTypeRsp)
  private static final com.dj.protobuf.book.BookAllTypeRsp DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.dj.protobuf.book.BookAllTypeRsp();
  }

  public static com.dj.protobuf.book.BookAllTypeRsp getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  @java.lang.Deprecated public static final com.google.protobuf.Parser<BookAllTypeRsp>
      PARSER = new com.google.protobuf.AbstractParser<BookAllTypeRsp>() {
    public BookAllTypeRsp parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new BookAllTypeRsp(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<BookAllTypeRsp> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<BookAllTypeRsp> getParserForType() {
    return PARSER;
  }

  public com.dj.protobuf.book.BookAllTypeRsp getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

