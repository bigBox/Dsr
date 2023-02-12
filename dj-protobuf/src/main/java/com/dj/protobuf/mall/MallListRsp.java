// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Mall.proto

package com.dj.protobuf.mall;

/**
 * <pre>
 *&#47; &lt;summary&gt;
 * / 商城查询响应
 * / &lt;/summary&gt;
 * </pre>
 *
 * Protobuf type {@code Protocols.MallListRsp}
 */
public  final class MallListRsp extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:Protocols.MallListRsp)
    MallListRspOrBuilder {
  // Use MallListRsp.newBuilder() to construct.
  private MallListRsp(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private MallListRsp() {
    errorID_ = 0;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private MallListRsp(
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
          case 18: {
            com.dj.protobuf.mall.MallListReq.Builder subBuilder = null;
            if (((bitField0_ & 0x00000002) == 0x00000002)) {
              subBuilder = req_.toBuilder();
            }
            req_ = input.readMessage(com.dj.protobuf.mall.MallListReq.PARSER, extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(req_);
              req_ = subBuilder.buildPartial();
            }
            bitField0_ |= 0x00000002;
            break;
          }
          case 26: {
            if (!((mutable_bitField0_ & 0x00000004) == 0x00000004)) {
              goodInfos_ = com.google.protobuf.MapField.newMapField(
                  GoodInfosDefaultEntryHolder.defaultEntry);
              mutable_bitField0_ |= 0x00000004;
            }
            com.google.protobuf.MapEntry<java.lang.Integer, com.dj.protobuf.mall.GoodDescription>
            goodInfos = input.readMessage(
                GoodInfosDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistry);
            goodInfos_.getMutableMap().put(goodInfos.getKey(), goodInfos.getValue());
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
    return com.dj.protobuf.mall.Mall.internal_static_Protocols_MallListRsp_descriptor;
  }

  @SuppressWarnings({"rawtypes"})
  protected com.google.protobuf.MapField internalGetMapField(
      int number) {
    switch (number) {
      case 3:
        return internalGetGoodInfos();
      default:
        throw new RuntimeException(
            "Invalid map field number: " + number);
    }
  }
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.dj.protobuf.mall.Mall.internal_static_Protocols_MallListRsp_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.dj.protobuf.mall.MallListRsp.class, com.dj.protobuf.mall.MallListRsp.Builder.class);
  }

  private int bitField0_;
  public static final int ERRORID_FIELD_NUMBER = 1;
  private int errorID_;
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 错误码
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional .ErrorID errorID = 1;</code>
   */
  public boolean hasErrorID() {
    return ((bitField0_ & 0x00000001) == 0x00000001);
  }
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 错误码
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional .ErrorID errorID = 1;</code>
   */
  public com.dj.protobuf.ErrorIDOuterClass.ErrorID getErrorID() {
    com.dj.protobuf.ErrorIDOuterClass.ErrorID result = com.dj.protobuf.ErrorIDOuterClass.ErrorID.valueOf(errorID_);
    return result == null ? com.dj.protobuf.ErrorIDOuterClass.ErrorID.OK : result;
  }

  public static final int REQ_FIELD_NUMBER = 2;
  private com.dj.protobuf.mall.MallListReq req_;
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional .Protocols.MallListReq req = 2;</code>
   */
  public boolean hasReq() {
    return ((bitField0_ & 0x00000002) == 0x00000002);
  }
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional .Protocols.MallListReq req = 2;</code>
   */
  public com.dj.protobuf.mall.MallListReq getReq() {
    return req_ == null ? com.dj.protobuf.mall.MallListReq.getDefaultInstance() : req_;
  }
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional .Protocols.MallListReq req = 2;</code>
   */
  public com.dj.protobuf.mall.MallListReqOrBuilder getReqOrBuilder() {
    return req_ == null ? com.dj.protobuf.mall.MallListReq.getDefaultInstance() : req_;
  }

  public static final int GOODINFOS_FIELD_NUMBER = 3;
  private static final class GoodInfosDefaultEntryHolder {
    static final com.google.protobuf.MapEntry<
        java.lang.Integer, com.dj.protobuf.mall.GoodDescription> defaultEntry =
            com.google.protobuf.MapEntry
            .<java.lang.Integer, com.dj.protobuf.mall.GoodDescription>newDefaultInstance(
                com.dj.protobuf.mall.Mall.internal_static_Protocols_MallListRsp_GoodInfosEntry_descriptor, 
                com.google.protobuf.WireFormat.FieldType.INT32,
                0,
                com.google.protobuf.WireFormat.FieldType.MESSAGE,
                com.dj.protobuf.mall.GoodDescription.getDefaultInstance());
  }
  private com.google.protobuf.MapField<
      java.lang.Integer, com.dj.protobuf.mall.GoodDescription> goodInfos_;
  private com.google.protobuf.MapField<java.lang.Integer, com.dj.protobuf.mall.GoodDescription>
  internalGetGoodInfos() {
    if (goodInfos_ == null) {
      return com.google.protobuf.MapField.emptyMapField(
          GoodInfosDefaultEntryHolder.defaultEntry);
    }
    return goodInfos_;
  }

  public int getGoodInfosCount() {
    return internalGetGoodInfos().getMap().size();
  }
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 商品信息
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>map&lt;int32, .Protocols.GoodDescription&gt; GoodInfos = 3;</code>
   */

  public boolean containsGoodInfos(
      int key) {
    
    return internalGetGoodInfos().getMap().containsKey(key);
  }
  /**
   * Use {@link #getGoodInfosMap()} instead.
   */
  @java.lang.Deprecated
  public java.util.Map<java.lang.Integer, com.dj.protobuf.mall.GoodDescription> getGoodInfos() {
    return getGoodInfosMap();
  }
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 商品信息
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>map&lt;int32, .Protocols.GoodDescription&gt; GoodInfos = 3;</code>
   */

  public java.util.Map<java.lang.Integer, com.dj.protobuf.mall.GoodDescription> getGoodInfosMap() {
    return internalGetGoodInfos().getMap();
  }
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 商品信息
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>map&lt;int32, .Protocols.GoodDescription&gt; GoodInfos = 3;</code>
   */

  public com.dj.protobuf.mall.GoodDescription getGoodInfosOrDefault(
      int key,
      com.dj.protobuf.mall.GoodDescription defaultValue) {
    
    java.util.Map<java.lang.Integer, com.dj.protobuf.mall.GoodDescription> map =
        internalGetGoodInfos().getMap();
    return map.containsKey(key) ? map.get(key) : defaultValue;
  }
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 商品信息
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>map&lt;int32, .Protocols.GoodDescription&gt; GoodInfos = 3;</code>
   */

  public com.dj.protobuf.mall.GoodDescription getGoodInfosOrThrow(
      int key) {
    
    java.util.Map<java.lang.Integer, com.dj.protobuf.mall.GoodDescription> map =
        internalGetGoodInfos().getMap();
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
      output.writeMessage(2, getReq());
    }
    for (java.util.Map.Entry<java.lang.Integer, com.dj.protobuf.mall.GoodDescription> entry
         : internalGetGoodInfos().getMap().entrySet()) {
      com.google.protobuf.MapEntry<java.lang.Integer, com.dj.protobuf.mall.GoodDescription>
      goodInfos = GoodInfosDefaultEntryHolder.defaultEntry.newBuilderForType()
          .setKey(entry.getKey())
          .setValue(entry.getValue())
          .build();
      output.writeMessage(3, goodInfos);
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
        .computeMessageSize(2, getReq());
    }
    for (java.util.Map.Entry<java.lang.Integer, com.dj.protobuf.mall.GoodDescription> entry
         : internalGetGoodInfos().getMap().entrySet()) {
      com.google.protobuf.MapEntry<java.lang.Integer, com.dj.protobuf.mall.GoodDescription>
      goodInfos = GoodInfosDefaultEntryHolder.defaultEntry.newBuilderForType()
          .setKey(entry.getKey())
          .setValue(entry.getValue())
          .build();
      size += com.google.protobuf.CodedOutputStream
          .computeMessageSize(3, goodInfos);
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
    if (!(obj instanceof com.dj.protobuf.mall.MallListRsp)) {
      return super.equals(obj);
    }
    com.dj.protobuf.mall.MallListRsp other = (com.dj.protobuf.mall.MallListRsp) obj;

    boolean result = true;
    result = result && (hasErrorID() == other.hasErrorID());
    if (hasErrorID()) {
      result = result && errorID_ == other.errorID_;
    }
    result = result && (hasReq() == other.hasReq());
    if (hasReq()) {
      result = result && getReq()
          .equals(other.getReq());
    }
    result = result && internalGetGoodInfos().equals(
        other.internalGetGoodInfos());
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
    if (hasReq()) {
      hash = (37 * hash) + REQ_FIELD_NUMBER;
      hash = (53 * hash) + getReq().hashCode();
    }
    if (!internalGetGoodInfos().getMap().isEmpty()) {
      hash = (37 * hash) + GOODINFOS_FIELD_NUMBER;
      hash = (53 * hash) + internalGetGoodInfos().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.dj.protobuf.mall.MallListRsp parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dj.protobuf.mall.MallListRsp parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dj.protobuf.mall.MallListRsp parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dj.protobuf.mall.MallListRsp parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dj.protobuf.mall.MallListRsp parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.mall.MallListRsp parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.dj.protobuf.mall.MallListRsp parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.mall.MallListRsp parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.dj.protobuf.mall.MallListRsp parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.mall.MallListRsp parseFrom(
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
  public static Builder newBuilder(com.dj.protobuf.mall.MallListRsp prototype) {
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
   * / 商城查询响应
   * / &lt;/summary&gt;
   * </pre>
   *
   * Protobuf type {@code Protocols.MallListRsp}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:Protocols.MallListRsp)
      com.dj.protobuf.mall.MallListRspOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.dj.protobuf.mall.Mall.internal_static_Protocols_MallListRsp_descriptor;
    }

    @SuppressWarnings({"rawtypes"})
    protected com.google.protobuf.MapField internalGetMapField(
        int number) {
      switch (number) {
        case 3:
          return internalGetGoodInfos();
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
          return internalGetMutableGoodInfos();
        default:
          throw new RuntimeException(
              "Invalid map field number: " + number);
      }
    }
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.dj.protobuf.mall.Mall.internal_static_Protocols_MallListRsp_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.dj.protobuf.mall.MallListRsp.class, com.dj.protobuf.mall.MallListRsp.Builder.class);
    }

    // Construct using com.dj.protobuf.mall.MallListRsp.newBuilder()
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
        getReqFieldBuilder();
      }
    }
    public Builder clear() {
      super.clear();
      errorID_ = 0;
      bitField0_ = (bitField0_ & ~0x00000001);
      if (reqBuilder_ == null) {
        req_ = null;
      } else {
        reqBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000002);
      internalGetMutableGoodInfos().clear();
      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.dj.protobuf.mall.Mall.internal_static_Protocols_MallListRsp_descriptor;
    }

    public com.dj.protobuf.mall.MallListRsp getDefaultInstanceForType() {
      return com.dj.protobuf.mall.MallListRsp.getDefaultInstance();
    }

    public com.dj.protobuf.mall.MallListRsp build() {
      com.dj.protobuf.mall.MallListRsp result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public com.dj.protobuf.mall.MallListRsp buildPartial() {
      com.dj.protobuf.mall.MallListRsp result = new com.dj.protobuf.mall.MallListRsp(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
        to_bitField0_ |= 0x00000001;
      }
      result.errorID_ = errorID_;
      if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
        to_bitField0_ |= 0x00000002;
      }
      if (reqBuilder_ == null) {
        result.req_ = req_;
      } else {
        result.req_ = reqBuilder_.build();
      }
      result.goodInfos_ = internalGetGoodInfos();
      result.goodInfos_.makeImmutable();
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
      if (other instanceof com.dj.protobuf.mall.MallListRsp) {
        return mergeFrom((com.dj.protobuf.mall.MallListRsp)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.dj.protobuf.mall.MallListRsp other) {
      if (other == com.dj.protobuf.mall.MallListRsp.getDefaultInstance()) return this;
      if (other.hasErrorID()) {
        setErrorID(other.getErrorID());
      }
      if (other.hasReq()) {
        mergeReq(other.getReq());
      }
      internalGetMutableGoodInfos().mergeFrom(
          other.internalGetGoodInfos());
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
      com.dj.protobuf.mall.MallListRsp parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.dj.protobuf.mall.MallListRsp) e.getUnfinishedMessage();
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
     * <pre>
     *&#47; &lt;summary&gt;
     * / 错误码
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional .ErrorID errorID = 1;</code>
     */
    public boolean hasErrorID() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 错误码
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional .ErrorID errorID = 1;</code>
     */
    public com.dj.protobuf.ErrorIDOuterClass.ErrorID getErrorID() {
      com.dj.protobuf.ErrorIDOuterClass.ErrorID result = com.dj.protobuf.ErrorIDOuterClass.ErrorID.valueOf(errorID_);
      return result == null ? com.dj.protobuf.ErrorIDOuterClass.ErrorID.OK : result;
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 错误码
     * / &lt;/summary&gt;
     * </pre>
     *
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
     * <pre>
     *&#47; &lt;summary&gt;
     * / 错误码
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional .ErrorID errorID = 1;</code>
     */
    public Builder clearErrorID() {
      bitField0_ = (bitField0_ & ~0x00000001);
      errorID_ = 0;
      onChanged();
      return this;
    }

    private com.dj.protobuf.mall.MallListReq req_ = null;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.dj.protobuf.mall.MallListReq, com.dj.protobuf.mall.MallListReq.Builder, com.dj.protobuf.mall.MallListReqOrBuilder> reqBuilder_;
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional .Protocols.MallListReq req = 2;</code>
     */
    public boolean hasReq() {
      return ((bitField0_ & 0x00000002) == 0x00000002);
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional .Protocols.MallListReq req = 2;</code>
     */
    public com.dj.protobuf.mall.MallListReq getReq() {
      if (reqBuilder_ == null) {
        return req_ == null ? com.dj.protobuf.mall.MallListReq.getDefaultInstance() : req_;
      } else {
        return reqBuilder_.getMessage();
      }
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional .Protocols.MallListReq req = 2;</code>
     */
    public Builder setReq(com.dj.protobuf.mall.MallListReq value) {
      if (reqBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        req_ = value;
        onChanged();
      } else {
        reqBuilder_.setMessage(value);
      }
      bitField0_ |= 0x00000002;
      return this;
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional .Protocols.MallListReq req = 2;</code>
     */
    public Builder setReq(
        com.dj.protobuf.mall.MallListReq.Builder builderForValue) {
      if (reqBuilder_ == null) {
        req_ = builderForValue.build();
        onChanged();
      } else {
        reqBuilder_.setMessage(builderForValue.build());
      }
      bitField0_ |= 0x00000002;
      return this;
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional .Protocols.MallListReq req = 2;</code>
     */
    public Builder mergeReq(com.dj.protobuf.mall.MallListReq value) {
      if (reqBuilder_ == null) {
        if (((bitField0_ & 0x00000002) == 0x00000002) &&
            req_ != null &&
            req_ != com.dj.protobuf.mall.MallListReq.getDefaultInstance()) {
          req_ =
            com.dj.protobuf.mall.MallListReq.newBuilder(req_).mergeFrom(value).buildPartial();
        } else {
          req_ = value;
        }
        onChanged();
      } else {
        reqBuilder_.mergeFrom(value);
      }
      bitField0_ |= 0x00000002;
      return this;
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional .Protocols.MallListReq req = 2;</code>
     */
    public Builder clearReq() {
      if (reqBuilder_ == null) {
        req_ = null;
        onChanged();
      } else {
        reqBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000002);
      return this;
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional .Protocols.MallListReq req = 2;</code>
     */
    public com.dj.protobuf.mall.MallListReq.Builder getReqBuilder() {
      bitField0_ |= 0x00000002;
      onChanged();
      return getReqFieldBuilder().getBuilder();
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional .Protocols.MallListReq req = 2;</code>
     */
    public com.dj.protobuf.mall.MallListReqOrBuilder getReqOrBuilder() {
      if (reqBuilder_ != null) {
        return reqBuilder_.getMessageOrBuilder();
      } else {
        return req_ == null ?
            com.dj.protobuf.mall.MallListReq.getDefaultInstance() : req_;
      }
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional .Protocols.MallListReq req = 2;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.dj.protobuf.mall.MallListReq, com.dj.protobuf.mall.MallListReq.Builder, com.dj.protobuf.mall.MallListReqOrBuilder> 
        getReqFieldBuilder() {
      if (reqBuilder_ == null) {
        reqBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.dj.protobuf.mall.MallListReq, com.dj.protobuf.mall.MallListReq.Builder, com.dj.protobuf.mall.MallListReqOrBuilder>(
                getReq(),
                getParentForChildren(),
                isClean());
        req_ = null;
      }
      return reqBuilder_;
    }

    private com.google.protobuf.MapField<
        java.lang.Integer, com.dj.protobuf.mall.GoodDescription> goodInfos_;
    private com.google.protobuf.MapField<java.lang.Integer, com.dj.protobuf.mall.GoodDescription>
    internalGetGoodInfos() {
      if (goodInfos_ == null) {
        return com.google.protobuf.MapField.emptyMapField(
            GoodInfosDefaultEntryHolder.defaultEntry);
      }
      return goodInfos_;
    }
    private com.google.protobuf.MapField<java.lang.Integer, com.dj.protobuf.mall.GoodDescription>
    internalGetMutableGoodInfos() {
      onChanged();;
      if (goodInfos_ == null) {
        goodInfos_ = com.google.protobuf.MapField.newMapField(
            GoodInfosDefaultEntryHolder.defaultEntry);
      }
      if (!goodInfos_.isMutable()) {
        goodInfos_ = goodInfos_.copy();
      }
      return goodInfos_;
    }

    public int getGoodInfosCount() {
      return internalGetGoodInfos().getMap().size();
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 商品信息
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>map&lt;int32, .Protocols.GoodDescription&gt; GoodInfos = 3;</code>
     */

    public boolean containsGoodInfos(
        int key) {
      
      return internalGetGoodInfos().getMap().containsKey(key);
    }
    /**
     * Use {@link #getGoodInfosMap()} instead.
     */
    @java.lang.Deprecated
    public java.util.Map<java.lang.Integer, com.dj.protobuf.mall.GoodDescription> getGoodInfos() {
      return getGoodInfosMap();
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 商品信息
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>map&lt;int32, .Protocols.GoodDescription&gt; GoodInfos = 3;</code>
     */

    public java.util.Map<java.lang.Integer, com.dj.protobuf.mall.GoodDescription> getGoodInfosMap() {
      return internalGetGoodInfos().getMap();
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 商品信息
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>map&lt;int32, .Protocols.GoodDescription&gt; GoodInfos = 3;</code>
     */

    public com.dj.protobuf.mall.GoodDescription getGoodInfosOrDefault(
        int key,
        com.dj.protobuf.mall.GoodDescription defaultValue) {
      
      java.util.Map<java.lang.Integer, com.dj.protobuf.mall.GoodDescription> map =
          internalGetGoodInfos().getMap();
      return map.containsKey(key) ? map.get(key) : defaultValue;
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 商品信息
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>map&lt;int32, .Protocols.GoodDescription&gt; GoodInfos = 3;</code>
     */

    public com.dj.protobuf.mall.GoodDescription getGoodInfosOrThrow(
        int key) {
      
      java.util.Map<java.lang.Integer, com.dj.protobuf.mall.GoodDescription> map =
          internalGetGoodInfos().getMap();
      if (!map.containsKey(key)) {
        throw new java.lang.IllegalArgumentException();
      }
      return map.get(key);
    }

    public Builder clearGoodInfos() {
      getMutableGoodInfos().clear();
      return this;
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 商品信息
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>map&lt;int32, .Protocols.GoodDescription&gt; GoodInfos = 3;</code>
     */

    public Builder removeGoodInfos(
        int key) {
      
      getMutableGoodInfos().remove(key);
      return this;
    }
    /**
     * Use alternate mutation accessors instead.
     */
    @java.lang.Deprecated
    public java.util.Map<java.lang.Integer, com.dj.protobuf.mall.GoodDescription>
    getMutableGoodInfos() {
      return internalGetMutableGoodInfos().getMutableMap();
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 商品信息
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>map&lt;int32, .Protocols.GoodDescription&gt; GoodInfos = 3;</code>
     */
    public Builder putGoodInfos(
        int key,
        com.dj.protobuf.mall.GoodDescription value) {
      
      if (value == null) { throw new java.lang.NullPointerException(); }
      getMutableGoodInfos().put(key, value);
      return this;
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 商品信息
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>map&lt;int32, .Protocols.GoodDescription&gt; GoodInfos = 3;</code>
     */

    public Builder putAllGoodInfos(
        java.util.Map<java.lang.Integer, com.dj.protobuf.mall.GoodDescription> values) {
      getMutableGoodInfos().putAll(values);
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


    // @@protoc_insertion_point(builder_scope:Protocols.MallListRsp)
  }

  // @@protoc_insertion_point(class_scope:Protocols.MallListRsp)
  private static final com.dj.protobuf.mall.MallListRsp DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.dj.protobuf.mall.MallListRsp();
  }

  public static com.dj.protobuf.mall.MallListRsp getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  @java.lang.Deprecated public static final com.google.protobuf.Parser<MallListRsp>
      PARSER = new com.google.protobuf.AbstractParser<MallListRsp>() {
    public MallListRsp parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new MallListRsp(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<MallListRsp> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<MallListRsp> getParserForType() {
    return PARSER;
  }

  public com.dj.protobuf.mall.MallListRsp getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

