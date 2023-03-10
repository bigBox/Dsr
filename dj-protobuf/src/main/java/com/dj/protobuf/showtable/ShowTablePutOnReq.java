// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: ShowTable.proto

package com.dj.protobuf.showtable;

/**
 * <pre>
 *&#47; &lt;summary&gt;
 * / 放入展厅
 * / &lt;/summary&gt;
 * </pre>
 *
 * Protobuf type {@code Protocols.ShowTablePutOnReq}
 */
public  final class ShowTablePutOnReq extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:Protocols.ShowTablePutOnReq)
    ShowTablePutOnReqOrBuilder {
  // Use ShowTablePutOnReq.newBuilder() to construct.
  private ShowTablePutOnReq(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private ShowTablePutOnReq() {
    itemId_ = 0;
    type_ = 0;
    page_ = 0;
    index_ = 0;
    x_ = 0;
    y_ = 0;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private ShowTablePutOnReq(
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
            itemId_ = input.readInt32();
            break;
          }
          case 16: {
            bitField0_ |= 0x00000002;
            type_ = input.readInt32();
            break;
          }
          case 24: {
            bitField0_ |= 0x00000004;
            page_ = input.readInt32();
            break;
          }
          case 32: {
            bitField0_ |= 0x00000008;
            index_ = input.readInt32();
            break;
          }
          case 40: {
            bitField0_ |= 0x00000010;
            x_ = input.readInt32();
            break;
          }
          case 48: {
            bitField0_ |= 0x00000020;
            y_ = input.readInt32();
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
    return com.dj.protobuf.showtable.ShowTable.internal_static_Protocols_ShowTablePutOnReq_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.dj.protobuf.showtable.ShowTable.internal_static_Protocols_ShowTablePutOnReq_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.dj.protobuf.showtable.ShowTablePutOnReq.class, com.dj.protobuf.showtable.ShowTablePutOnReq.Builder.class);
  }

  private int bitField0_;
  public static final int ITEMID_FIELD_NUMBER = 1;
  private int itemId_;
  /**
   * <code>optional int32 itemId = 1;</code>
   */
  public boolean hasItemId() {
    return ((bitField0_ & 0x00000001) == 0x00000001);
  }
  /**
   * <code>optional int32 itemId = 1;</code>
   */
  public int getItemId() {
    return itemId_;
  }

  public static final int TYPE_FIELD_NUMBER = 2;
  private int type_;
  /**
   * <code>optional int32 type = 2;</code>
   */
  public boolean hasType() {
    return ((bitField0_ & 0x00000002) == 0x00000002);
  }
  /**
   * <code>optional int32 type = 2;</code>
   */
  public int getType() {
    return type_;
  }

  public static final int PAGE_FIELD_NUMBER = 3;
  private int page_;
  /**
   * <code>optional int32 page = 3;</code>
   */
  public boolean hasPage() {
    return ((bitField0_ & 0x00000004) == 0x00000004);
  }
  /**
   * <code>optional int32 page = 3;</code>
   */
  public int getPage() {
    return page_;
  }

  public static final int INDEX_FIELD_NUMBER = 4;
  private int index_;
  /**
   * <code>optional int32 index = 4;</code>
   */
  public boolean hasIndex() {
    return ((bitField0_ & 0x00000008) == 0x00000008);
  }
  /**
   * <code>optional int32 index = 4;</code>
   */
  public int getIndex() {
    return index_;
  }

  public static final int X_FIELD_NUMBER = 5;
  private int x_;
  /**
   * <code>optional int32 x = 5;</code>
   */
  public boolean hasX() {
    return ((bitField0_ & 0x00000010) == 0x00000010);
  }
  /**
   * <code>optional int32 x = 5;</code>
   */
  public int getX() {
    return x_;
  }

  public static final int Y_FIELD_NUMBER = 6;
  private int y_;
  /**
   * <code>optional int32 y = 6;</code>
   */
  public boolean hasY() {
    return ((bitField0_ & 0x00000020) == 0x00000020);
  }
  /**
   * <code>optional int32 y = 6;</code>
   */
  public int getY() {
    return y_;
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
      output.writeInt32(1, itemId_);
    }
    if (((bitField0_ & 0x00000002) == 0x00000002)) {
      output.writeInt32(2, type_);
    }
    if (((bitField0_ & 0x00000004) == 0x00000004)) {
      output.writeInt32(3, page_);
    }
    if (((bitField0_ & 0x00000008) == 0x00000008)) {
      output.writeInt32(4, index_);
    }
    if (((bitField0_ & 0x00000010) == 0x00000010)) {
      output.writeInt32(5, x_);
    }
    if (((bitField0_ & 0x00000020) == 0x00000020)) {
      output.writeInt32(6, y_);
    }
    unknownFields.writeTo(output);
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (((bitField0_ & 0x00000001) == 0x00000001)) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(1, itemId_);
    }
    if (((bitField0_ & 0x00000002) == 0x00000002)) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(2, type_);
    }
    if (((bitField0_ & 0x00000004) == 0x00000004)) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(3, page_);
    }
    if (((bitField0_ & 0x00000008) == 0x00000008)) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(4, index_);
    }
    if (((bitField0_ & 0x00000010) == 0x00000010)) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(5, x_);
    }
    if (((bitField0_ & 0x00000020) == 0x00000020)) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(6, y_);
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
    if (!(obj instanceof com.dj.protobuf.showtable.ShowTablePutOnReq)) {
      return super.equals(obj);
    }
    com.dj.protobuf.showtable.ShowTablePutOnReq other = (com.dj.protobuf.showtable.ShowTablePutOnReq) obj;

    boolean result = true;
    result = result && (hasItemId() == other.hasItemId());
    if (hasItemId()) {
      result = result && (getItemId()
          == other.getItemId());
    }
    result = result && (hasType() == other.hasType());
    if (hasType()) {
      result = result && (getType()
          == other.getType());
    }
    result = result && (hasPage() == other.hasPage());
    if (hasPage()) {
      result = result && (getPage()
          == other.getPage());
    }
    result = result && (hasIndex() == other.hasIndex());
    if (hasIndex()) {
      result = result && (getIndex()
          == other.getIndex());
    }
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
    if (hasItemId()) {
      hash = (37 * hash) + ITEMID_FIELD_NUMBER;
      hash = (53 * hash) + getItemId();
    }
    if (hasType()) {
      hash = (37 * hash) + TYPE_FIELD_NUMBER;
      hash = (53 * hash) + getType();
    }
    if (hasPage()) {
      hash = (37 * hash) + PAGE_FIELD_NUMBER;
      hash = (53 * hash) + getPage();
    }
    if (hasIndex()) {
      hash = (37 * hash) + INDEX_FIELD_NUMBER;
      hash = (53 * hash) + getIndex();
    }
    if (hasX()) {
      hash = (37 * hash) + X_FIELD_NUMBER;
      hash = (53 * hash) + getX();
    }
    if (hasY()) {
      hash = (37 * hash) + Y_FIELD_NUMBER;
      hash = (53 * hash) + getY();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.dj.protobuf.showtable.ShowTablePutOnReq parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dj.protobuf.showtable.ShowTablePutOnReq parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dj.protobuf.showtable.ShowTablePutOnReq parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dj.protobuf.showtable.ShowTablePutOnReq parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dj.protobuf.showtable.ShowTablePutOnReq parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.showtable.ShowTablePutOnReq parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.dj.protobuf.showtable.ShowTablePutOnReq parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.showtable.ShowTablePutOnReq parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.dj.protobuf.showtable.ShowTablePutOnReq parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.showtable.ShowTablePutOnReq parseFrom(
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
  public static Builder newBuilder(com.dj.protobuf.showtable.ShowTablePutOnReq prototype) {
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
   * / 放入展厅
   * / &lt;/summary&gt;
   * </pre>
   *
   * Protobuf type {@code Protocols.ShowTablePutOnReq}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:Protocols.ShowTablePutOnReq)
      com.dj.protobuf.showtable.ShowTablePutOnReqOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.dj.protobuf.showtable.ShowTable.internal_static_Protocols_ShowTablePutOnReq_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.dj.protobuf.showtable.ShowTable.internal_static_Protocols_ShowTablePutOnReq_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.dj.protobuf.showtable.ShowTablePutOnReq.class, com.dj.protobuf.showtable.ShowTablePutOnReq.Builder.class);
    }

    // Construct using com.dj.protobuf.showtable.ShowTablePutOnReq.newBuilder()
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
      itemId_ = 0;
      bitField0_ = (bitField0_ & ~0x00000001);
      type_ = 0;
      bitField0_ = (bitField0_ & ~0x00000002);
      page_ = 0;
      bitField0_ = (bitField0_ & ~0x00000004);
      index_ = 0;
      bitField0_ = (bitField0_ & ~0x00000008);
      x_ = 0;
      bitField0_ = (bitField0_ & ~0x00000010);
      y_ = 0;
      bitField0_ = (bitField0_ & ~0x00000020);
      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.dj.protobuf.showtable.ShowTable.internal_static_Protocols_ShowTablePutOnReq_descriptor;
    }

    public com.dj.protobuf.showtable.ShowTablePutOnReq getDefaultInstanceForType() {
      return com.dj.protobuf.showtable.ShowTablePutOnReq.getDefaultInstance();
    }

    public com.dj.protobuf.showtable.ShowTablePutOnReq build() {
      com.dj.protobuf.showtable.ShowTablePutOnReq result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public com.dj.protobuf.showtable.ShowTablePutOnReq buildPartial() {
      com.dj.protobuf.showtable.ShowTablePutOnReq result = new com.dj.protobuf.showtable.ShowTablePutOnReq(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
        to_bitField0_ |= 0x00000001;
      }
      result.itemId_ = itemId_;
      if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
        to_bitField0_ |= 0x00000002;
      }
      result.type_ = type_;
      if (((from_bitField0_ & 0x00000004) == 0x00000004)) {
        to_bitField0_ |= 0x00000004;
      }
      result.page_ = page_;
      if (((from_bitField0_ & 0x00000008) == 0x00000008)) {
        to_bitField0_ |= 0x00000008;
      }
      result.index_ = index_;
      if (((from_bitField0_ & 0x00000010) == 0x00000010)) {
        to_bitField0_ |= 0x00000010;
      }
      result.x_ = x_;
      if (((from_bitField0_ & 0x00000020) == 0x00000020)) {
        to_bitField0_ |= 0x00000020;
      }
      result.y_ = y_;
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
      if (other instanceof com.dj.protobuf.showtable.ShowTablePutOnReq) {
        return mergeFrom((com.dj.protobuf.showtable.ShowTablePutOnReq)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.dj.protobuf.showtable.ShowTablePutOnReq other) {
      if (other == com.dj.protobuf.showtable.ShowTablePutOnReq.getDefaultInstance()) return this;
      if (other.hasItemId()) {
        setItemId(other.getItemId());
      }
      if (other.hasType()) {
        setType(other.getType());
      }
      if (other.hasPage()) {
        setPage(other.getPage());
      }
      if (other.hasIndex()) {
        setIndex(other.getIndex());
      }
      if (other.hasX()) {
        setX(other.getX());
      }
      if (other.hasY()) {
        setY(other.getY());
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
      com.dj.protobuf.showtable.ShowTablePutOnReq parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.dj.protobuf.showtable.ShowTablePutOnReq) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private int itemId_ ;
    /**
     * <code>optional int32 itemId = 1;</code>
     */
    public boolean hasItemId() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <code>optional int32 itemId = 1;</code>
     */
    public int getItemId() {
      return itemId_;
    }
    /**
     * <code>optional int32 itemId = 1;</code>
     */
    public Builder setItemId(int value) {
      bitField0_ |= 0x00000001;
      itemId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional int32 itemId = 1;</code>
     */
    public Builder clearItemId() {
      bitField0_ = (bitField0_ & ~0x00000001);
      itemId_ = 0;
      onChanged();
      return this;
    }

    private int type_ ;
    /**
     * <code>optional int32 type = 2;</code>
     */
    public boolean hasType() {
      return ((bitField0_ & 0x00000002) == 0x00000002);
    }
    /**
     * <code>optional int32 type = 2;</code>
     */
    public int getType() {
      return type_;
    }
    /**
     * <code>optional int32 type = 2;</code>
     */
    public Builder setType(int value) {
      bitField0_ |= 0x00000002;
      type_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional int32 type = 2;</code>
     */
    public Builder clearType() {
      bitField0_ = (bitField0_ & ~0x00000002);
      type_ = 0;
      onChanged();
      return this;
    }

    private int page_ ;
    /**
     * <code>optional int32 page = 3;</code>
     */
    public boolean hasPage() {
      return ((bitField0_ & 0x00000004) == 0x00000004);
    }
    /**
     * <code>optional int32 page = 3;</code>
     */
    public int getPage() {
      return page_;
    }
    /**
     * <code>optional int32 page = 3;</code>
     */
    public Builder setPage(int value) {
      bitField0_ |= 0x00000004;
      page_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional int32 page = 3;</code>
     */
    public Builder clearPage() {
      bitField0_ = (bitField0_ & ~0x00000004);
      page_ = 0;
      onChanged();
      return this;
    }

    private int index_ ;
    /**
     * <code>optional int32 index = 4;</code>
     */
    public boolean hasIndex() {
      return ((bitField0_ & 0x00000008) == 0x00000008);
    }
    /**
     * <code>optional int32 index = 4;</code>
     */
    public int getIndex() {
      return index_;
    }
    /**
     * <code>optional int32 index = 4;</code>
     */
    public Builder setIndex(int value) {
      bitField0_ |= 0x00000008;
      index_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional int32 index = 4;</code>
     */
    public Builder clearIndex() {
      bitField0_ = (bitField0_ & ~0x00000008);
      index_ = 0;
      onChanged();
      return this;
    }

    private int x_ ;
    /**
     * <code>optional int32 x = 5;</code>
     */
    public boolean hasX() {
      return ((bitField0_ & 0x00000010) == 0x00000010);
    }
    /**
     * <code>optional int32 x = 5;</code>
     */
    public int getX() {
      return x_;
    }
    /**
     * <code>optional int32 x = 5;</code>
     */
    public Builder setX(int value) {
      bitField0_ |= 0x00000010;
      x_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional int32 x = 5;</code>
     */
    public Builder clearX() {
      bitField0_ = (bitField0_ & ~0x00000010);
      x_ = 0;
      onChanged();
      return this;
    }

    private int y_ ;
    /**
     * <code>optional int32 y = 6;</code>
     */
    public boolean hasY() {
      return ((bitField0_ & 0x00000020) == 0x00000020);
    }
    /**
     * <code>optional int32 y = 6;</code>
     */
    public int getY() {
      return y_;
    }
    /**
     * <code>optional int32 y = 6;</code>
     */
    public Builder setY(int value) {
      bitField0_ |= 0x00000020;
      y_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional int32 y = 6;</code>
     */
    public Builder clearY() {
      bitField0_ = (bitField0_ & ~0x00000020);
      y_ = 0;
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


    // @@protoc_insertion_point(builder_scope:Protocols.ShowTablePutOnReq)
  }

  // @@protoc_insertion_point(class_scope:Protocols.ShowTablePutOnReq)
  private static final com.dj.protobuf.showtable.ShowTablePutOnReq DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.dj.protobuf.showtable.ShowTablePutOnReq();
  }

  public static com.dj.protobuf.showtable.ShowTablePutOnReq getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  @java.lang.Deprecated public static final com.google.protobuf.Parser<ShowTablePutOnReq>
      PARSER = new com.google.protobuf.AbstractParser<ShowTablePutOnReq>() {
    public ShowTablePutOnReq parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new ShowTablePutOnReq(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<ShowTablePutOnReq> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<ShowTablePutOnReq> getParserForType() {
    return PARSER;
  }

  public com.dj.protobuf.showtable.ShowTablePutOnReq getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

