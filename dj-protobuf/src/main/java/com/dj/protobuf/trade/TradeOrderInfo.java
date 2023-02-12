// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Trade.proto

package com.dj.protobuf.trade;

/**
 * <pre>
 * 挂单信息
 * </pre>
 *
 * Protobuf type {@code Protocols.TradeOrderInfo}
 */
public  final class TradeOrderInfo extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:Protocols.TradeOrderInfo)
    TradeOrderInfoOrBuilder {
  // Use TradeOrderInfo.newBuilder() to construct.
  private TradeOrderInfo(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private TradeOrderInfo() {
    type_ = 0;
    orderID_ = 0L;
    orderNum_ = 0L;
    tradeNum_ = 0L;
    itemID_ = 0;
    itemNum_ = 0L;
    price_ = 0L;
    amount_ = 0L;
    roleID_ = 0L;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private TradeOrderInfo(
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
            com.dj.protobuf.trade.TradeType value = com.dj.protobuf.trade.TradeType.valueOf(rawValue);
            if (value == null) {
              unknownFields.mergeVarintField(1, rawValue);
            } else {
              bitField0_ |= 0x00000001;
              type_ = rawValue;
            }
            break;
          }
          case 16: {
            bitField0_ |= 0x00000002;
            orderID_ = input.readUInt64();
            break;
          }
          case 24: {
            bitField0_ |= 0x00000004;
            orderNum_ = input.readUInt64();
            break;
          }
          case 32: {
            bitField0_ |= 0x00000008;
            tradeNum_ = input.readUInt64();
            break;
          }
          case 40: {
            bitField0_ |= 0x00000010;
            itemID_ = input.readUInt32();
            break;
          }
          case 48: {
            bitField0_ |= 0x00000020;
            itemNum_ = input.readUInt64();
            break;
          }
          case 56: {
            bitField0_ |= 0x00000040;
            price_ = input.readUInt64();
            break;
          }
          case 64: {
            bitField0_ |= 0x00000080;
            amount_ = input.readUInt64();
            break;
          }
          case 72: {
            bitField0_ |= 0x00000100;
            roleID_ = input.readUInt64();
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
    return com.dj.protobuf.trade.Trade.internal_static_Protocols_TradeOrderInfo_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.dj.protobuf.trade.Trade.internal_static_Protocols_TradeOrderInfo_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.dj.protobuf.trade.TradeOrderInfo.class, com.dj.protobuf.trade.TradeOrderInfo.Builder.class);
  }

  private int bitField0_;
  public static final int TYPE_FIELD_NUMBER = 1;
  private int type_;
  /**
   * <pre>
   * 交易类型
   * </pre>
   *
   * <code>optional .Protocols.TradeType type = 1;</code>
   */
  public boolean hasType() {
    return ((bitField0_ & 0x00000001) == 0x00000001);
  }
  /**
   * <pre>
   * 交易类型
   * </pre>
   *
   * <code>optional .Protocols.TradeType type = 1;</code>
   */
  public com.dj.protobuf.trade.TradeType getType() {
    com.dj.protobuf.trade.TradeType result = com.dj.protobuf.trade.TradeType.valueOf(type_);
    return result == null ? com.dj.protobuf.trade.TradeType.All : result;
  }

  public static final int ORDERID_FIELD_NUMBER = 2;
  private long orderID_;
  /**
   * <pre>
   * 挂单ID
   * </pre>
   *
   * <code>optional uint64 orderID = 2;</code>
   */
  public boolean hasOrderID() {
    return ((bitField0_ & 0x00000002) == 0x00000002);
  }
  /**
   * <pre>
   * 挂单ID
   * </pre>
   *
   * <code>optional uint64 orderID = 2;</code>
   */
  public long getOrderID() {
    return orderID_;
  }

  public static final int ORDERNUM_FIELD_NUMBER = 3;
  private long orderNum_;
  /**
   * <pre>
   * 挂单数量
   * </pre>
   *
   * <code>optional uint64 orderNum = 3;</code>
   */
  public boolean hasOrderNum() {
    return ((bitField0_ & 0x00000004) == 0x00000004);
  }
  /**
   * <pre>
   * 挂单数量
   * </pre>
   *
   * <code>optional uint64 orderNum = 3;</code>
   */
  public long getOrderNum() {
    return orderNum_;
  }

  public static final int TRADENUM_FIELD_NUMBER = 4;
  private long tradeNum_;
  /**
   * <pre>
   * 已经完成的交易物品数量
   * </pre>
   *
   * <code>optional uint64 tradeNum = 4;</code>
   */
  public boolean hasTradeNum() {
    return ((bitField0_ & 0x00000008) == 0x00000008);
  }
  /**
   * <pre>
   * 已经完成的交易物品数量
   * </pre>
   *
   * <code>optional uint64 tradeNum = 4;</code>
   */
  public long getTradeNum() {
    return tradeNum_;
  }

  public static final int ITEMID_FIELD_NUMBER = 5;
  private int itemID_;
  /**
   * <pre>
   * 物品ID
   * </pre>
   *
   * <code>optional uint32 itemID = 5;</code>
   */
  public boolean hasItemID() {
    return ((bitField0_ & 0x00000010) == 0x00000010);
  }
  /**
   * <pre>
   * 物品ID
   * </pre>
   *
   * <code>optional uint32 itemID = 5;</code>
   */
  public int getItemID() {
    return itemID_;
  }

  public static final int ITEMNUM_FIELD_NUMBER = 6;
  private long itemNum_;
  /**
   * <pre>
   * 物品数量
   * </pre>
   *
   * <code>optional uint64 itemNum = 6;</code>
   */
  public boolean hasItemNum() {
    return ((bitField0_ & 0x00000020) == 0x00000020);
  }
  /**
   * <pre>
   * 物品数量
   * </pre>
   *
   * <code>optional uint64 itemNum = 6;</code>
   */
  public long getItemNum() {
    return itemNum_;
  }

  public static final int PRICE_FIELD_NUMBER = 7;
  private long price_;
  /**
   * <pre>
   * 单品价格
   * </pre>
   *
   * <code>optional uint64 price = 7;</code>
   */
  public boolean hasPrice() {
    return ((bitField0_ & 0x00000040) == 0x00000040);
  }
  /**
   * <pre>
   * 单品价格
   * </pre>
   *
   * <code>optional uint64 price = 7;</code>
   */
  public long getPrice() {
    return price_;
  }

  public static final int AMOUNT_FIELD_NUMBER = 8;
  private long amount_;
  /**
   * <pre>
   * 挂单总价格
   * </pre>
   *
   * <code>optional uint64 amount = 8;</code>
   */
  public boolean hasAmount() {
    return ((bitField0_ & 0x00000080) == 0x00000080);
  }
  /**
   * <pre>
   * 挂单总价格
   * </pre>
   *
   * <code>optional uint64 amount = 8;</code>
   */
  public long getAmount() {
    return amount_;
  }

  public static final int ROLEID_FIELD_NUMBER = 9;
  private long roleID_;
  /**
   * <pre>
   * 挂单发起者
   * </pre>
   *
   * <code>optional uint64 roleID = 9;</code>
   */
  public boolean hasRoleID() {
    return ((bitField0_ & 0x00000100) == 0x00000100);
  }
  /**
   * <pre>
   * 挂单发起者
   * </pre>
   *
   * <code>optional uint64 roleID = 9;</code>
   */
  public long getRoleID() {
    return roleID_;
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
      output.writeEnum(1, type_);
    }
    if (((bitField0_ & 0x00000002) == 0x00000002)) {
      output.writeUInt64(2, orderID_);
    }
    if (((bitField0_ & 0x00000004) == 0x00000004)) {
      output.writeUInt64(3, orderNum_);
    }
    if (((bitField0_ & 0x00000008) == 0x00000008)) {
      output.writeUInt64(4, tradeNum_);
    }
    if (((bitField0_ & 0x00000010) == 0x00000010)) {
      output.writeUInt32(5, itemID_);
    }
    if (((bitField0_ & 0x00000020) == 0x00000020)) {
      output.writeUInt64(6, itemNum_);
    }
    if (((bitField0_ & 0x00000040) == 0x00000040)) {
      output.writeUInt64(7, price_);
    }
    if (((bitField0_ & 0x00000080) == 0x00000080)) {
      output.writeUInt64(8, amount_);
    }
    if (((bitField0_ & 0x00000100) == 0x00000100)) {
      output.writeUInt64(9, roleID_);
    }
    unknownFields.writeTo(output);
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (((bitField0_ & 0x00000001) == 0x00000001)) {
      size += com.google.protobuf.CodedOutputStream
        .computeEnumSize(1, type_);
    }
    if (((bitField0_ & 0x00000002) == 0x00000002)) {
      size += com.google.protobuf.CodedOutputStream
        .computeUInt64Size(2, orderID_);
    }
    if (((bitField0_ & 0x00000004) == 0x00000004)) {
      size += com.google.protobuf.CodedOutputStream
        .computeUInt64Size(3, orderNum_);
    }
    if (((bitField0_ & 0x00000008) == 0x00000008)) {
      size += com.google.protobuf.CodedOutputStream
        .computeUInt64Size(4, tradeNum_);
    }
    if (((bitField0_ & 0x00000010) == 0x00000010)) {
      size += com.google.protobuf.CodedOutputStream
        .computeUInt32Size(5, itemID_);
    }
    if (((bitField0_ & 0x00000020) == 0x00000020)) {
      size += com.google.protobuf.CodedOutputStream
        .computeUInt64Size(6, itemNum_);
    }
    if (((bitField0_ & 0x00000040) == 0x00000040)) {
      size += com.google.protobuf.CodedOutputStream
        .computeUInt64Size(7, price_);
    }
    if (((bitField0_ & 0x00000080) == 0x00000080)) {
      size += com.google.protobuf.CodedOutputStream
        .computeUInt64Size(8, amount_);
    }
    if (((bitField0_ & 0x00000100) == 0x00000100)) {
      size += com.google.protobuf.CodedOutputStream
        .computeUInt64Size(9, roleID_);
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
    if (!(obj instanceof com.dj.protobuf.trade.TradeOrderInfo)) {
      return super.equals(obj);
    }
    com.dj.protobuf.trade.TradeOrderInfo other = (com.dj.protobuf.trade.TradeOrderInfo) obj;

    boolean result = true;
    result = result && (hasType() == other.hasType());
    if (hasType()) {
      result = result && type_ == other.type_;
    }
    result = result && (hasOrderID() == other.hasOrderID());
    if (hasOrderID()) {
      result = result && (getOrderID()
          == other.getOrderID());
    }
    result = result && (hasOrderNum() == other.hasOrderNum());
    if (hasOrderNum()) {
      result = result && (getOrderNum()
          == other.getOrderNum());
    }
    result = result && (hasTradeNum() == other.hasTradeNum());
    if (hasTradeNum()) {
      result = result && (getTradeNum()
          == other.getTradeNum());
    }
    result = result && (hasItemID() == other.hasItemID());
    if (hasItemID()) {
      result = result && (getItemID()
          == other.getItemID());
    }
    result = result && (hasItemNum() == other.hasItemNum());
    if (hasItemNum()) {
      result = result && (getItemNum()
          == other.getItemNum());
    }
    result = result && (hasPrice() == other.hasPrice());
    if (hasPrice()) {
      result = result && (getPrice()
          == other.getPrice());
    }
    result = result && (hasAmount() == other.hasAmount());
    if (hasAmount()) {
      result = result && (getAmount()
          == other.getAmount());
    }
    result = result && (hasRoleID() == other.hasRoleID());
    if (hasRoleID()) {
      result = result && (getRoleID()
          == other.getRoleID());
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
    if (hasType()) {
      hash = (37 * hash) + TYPE_FIELD_NUMBER;
      hash = (53 * hash) + type_;
    }
    if (hasOrderID()) {
      hash = (37 * hash) + ORDERID_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
          getOrderID());
    }
    if (hasOrderNum()) {
      hash = (37 * hash) + ORDERNUM_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
          getOrderNum());
    }
    if (hasTradeNum()) {
      hash = (37 * hash) + TRADENUM_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
          getTradeNum());
    }
    if (hasItemID()) {
      hash = (37 * hash) + ITEMID_FIELD_NUMBER;
      hash = (53 * hash) + getItemID();
    }
    if (hasItemNum()) {
      hash = (37 * hash) + ITEMNUM_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
          getItemNum());
    }
    if (hasPrice()) {
      hash = (37 * hash) + PRICE_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
          getPrice());
    }
    if (hasAmount()) {
      hash = (37 * hash) + AMOUNT_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
          getAmount());
    }
    if (hasRoleID()) {
      hash = (37 * hash) + ROLEID_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
          getRoleID());
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.dj.protobuf.trade.TradeOrderInfo parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dj.protobuf.trade.TradeOrderInfo parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dj.protobuf.trade.TradeOrderInfo parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dj.protobuf.trade.TradeOrderInfo parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dj.protobuf.trade.TradeOrderInfo parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.trade.TradeOrderInfo parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.dj.protobuf.trade.TradeOrderInfo parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.trade.TradeOrderInfo parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.dj.protobuf.trade.TradeOrderInfo parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.trade.TradeOrderInfo parseFrom(
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
  public static Builder newBuilder(com.dj.protobuf.trade.TradeOrderInfo prototype) {
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
   * 挂单信息
   * </pre>
   *
   * Protobuf type {@code Protocols.TradeOrderInfo}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:Protocols.TradeOrderInfo)
      com.dj.protobuf.trade.TradeOrderInfoOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.dj.protobuf.trade.Trade.internal_static_Protocols_TradeOrderInfo_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.dj.protobuf.trade.Trade.internal_static_Protocols_TradeOrderInfo_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.dj.protobuf.trade.TradeOrderInfo.class, com.dj.protobuf.trade.TradeOrderInfo.Builder.class);
    }

    // Construct using com.dj.protobuf.trade.TradeOrderInfo.newBuilder()
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
      type_ = 0;
      bitField0_ = (bitField0_ & ~0x00000001);
      orderID_ = 0L;
      bitField0_ = (bitField0_ & ~0x00000002);
      orderNum_ = 0L;
      bitField0_ = (bitField0_ & ~0x00000004);
      tradeNum_ = 0L;
      bitField0_ = (bitField0_ & ~0x00000008);
      itemID_ = 0;
      bitField0_ = (bitField0_ & ~0x00000010);
      itemNum_ = 0L;
      bitField0_ = (bitField0_ & ~0x00000020);
      price_ = 0L;
      bitField0_ = (bitField0_ & ~0x00000040);
      amount_ = 0L;
      bitField0_ = (bitField0_ & ~0x00000080);
      roleID_ = 0L;
      bitField0_ = (bitField0_ & ~0x00000100);
      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.dj.protobuf.trade.Trade.internal_static_Protocols_TradeOrderInfo_descriptor;
    }

    public com.dj.protobuf.trade.TradeOrderInfo getDefaultInstanceForType() {
      return com.dj.protobuf.trade.TradeOrderInfo.getDefaultInstance();
    }

    public com.dj.protobuf.trade.TradeOrderInfo build() {
      com.dj.protobuf.trade.TradeOrderInfo result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public com.dj.protobuf.trade.TradeOrderInfo buildPartial() {
      com.dj.protobuf.trade.TradeOrderInfo result = new com.dj.protobuf.trade.TradeOrderInfo(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
        to_bitField0_ |= 0x00000001;
      }
      result.type_ = type_;
      if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
        to_bitField0_ |= 0x00000002;
      }
      result.orderID_ = orderID_;
      if (((from_bitField0_ & 0x00000004) == 0x00000004)) {
        to_bitField0_ |= 0x00000004;
      }
      result.orderNum_ = orderNum_;
      if (((from_bitField0_ & 0x00000008) == 0x00000008)) {
        to_bitField0_ |= 0x00000008;
      }
      result.tradeNum_ = tradeNum_;
      if (((from_bitField0_ & 0x00000010) == 0x00000010)) {
        to_bitField0_ |= 0x00000010;
      }
      result.itemID_ = itemID_;
      if (((from_bitField0_ & 0x00000020) == 0x00000020)) {
        to_bitField0_ |= 0x00000020;
      }
      result.itemNum_ = itemNum_;
      if (((from_bitField0_ & 0x00000040) == 0x00000040)) {
        to_bitField0_ |= 0x00000040;
      }
      result.price_ = price_;
      if (((from_bitField0_ & 0x00000080) == 0x00000080)) {
        to_bitField0_ |= 0x00000080;
      }
      result.amount_ = amount_;
      if (((from_bitField0_ & 0x00000100) == 0x00000100)) {
        to_bitField0_ |= 0x00000100;
      }
      result.roleID_ = roleID_;
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
      if (other instanceof com.dj.protobuf.trade.TradeOrderInfo) {
        return mergeFrom((com.dj.protobuf.trade.TradeOrderInfo)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.dj.protobuf.trade.TradeOrderInfo other) {
      if (other == com.dj.protobuf.trade.TradeOrderInfo.getDefaultInstance()) return this;
      if (other.hasType()) {
        setType(other.getType());
      }
      if (other.hasOrderID()) {
        setOrderID(other.getOrderID());
      }
      if (other.hasOrderNum()) {
        setOrderNum(other.getOrderNum());
      }
      if (other.hasTradeNum()) {
        setTradeNum(other.getTradeNum());
      }
      if (other.hasItemID()) {
        setItemID(other.getItemID());
      }
      if (other.hasItemNum()) {
        setItemNum(other.getItemNum());
      }
      if (other.hasPrice()) {
        setPrice(other.getPrice());
      }
      if (other.hasAmount()) {
        setAmount(other.getAmount());
      }
      if (other.hasRoleID()) {
        setRoleID(other.getRoleID());
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
      com.dj.protobuf.trade.TradeOrderInfo parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.dj.protobuf.trade.TradeOrderInfo) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private int type_ = 0;
    /**
     * <pre>
     * 交易类型
     * </pre>
     *
     * <code>optional .Protocols.TradeType type = 1;</code>
     */
    public boolean hasType() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <pre>
     * 交易类型
     * </pre>
     *
     * <code>optional .Protocols.TradeType type = 1;</code>
     */
    public com.dj.protobuf.trade.TradeType getType() {
      com.dj.protobuf.trade.TradeType result = com.dj.protobuf.trade.TradeType.valueOf(type_);
      return result == null ? com.dj.protobuf.trade.TradeType.All : result;
    }
    /**
     * <pre>
     * 交易类型
     * </pre>
     *
     * <code>optional .Protocols.TradeType type = 1;</code>
     */
    public Builder setType(com.dj.protobuf.trade.TradeType value) {
      if (value == null) {
        throw new NullPointerException();
      }
      bitField0_ |= 0x00000001;
      type_ = value.getNumber();
      onChanged();
      return this;
    }
    /**
     * <pre>
     * 交易类型
     * </pre>
     *
     * <code>optional .Protocols.TradeType type = 1;</code>
     */
    public Builder clearType() {
      bitField0_ = (bitField0_ & ~0x00000001);
      type_ = 0;
      onChanged();
      return this;
    }

    private long orderID_ ;
    /**
     * <pre>
     * 挂单ID
     * </pre>
     *
     * <code>optional uint64 orderID = 2;</code>
     */
    public boolean hasOrderID() {
      return ((bitField0_ & 0x00000002) == 0x00000002);
    }
    /**
     * <pre>
     * 挂单ID
     * </pre>
     *
     * <code>optional uint64 orderID = 2;</code>
     */
    public long getOrderID() {
      return orderID_;
    }
    /**
     * <pre>
     * 挂单ID
     * </pre>
     *
     * <code>optional uint64 orderID = 2;</code>
     */
    public Builder setOrderID(long value) {
      bitField0_ |= 0x00000002;
      orderID_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * 挂单ID
     * </pre>
     *
     * <code>optional uint64 orderID = 2;</code>
     */
    public Builder clearOrderID() {
      bitField0_ = (bitField0_ & ~0x00000002);
      orderID_ = 0L;
      onChanged();
      return this;
    }

    private long orderNum_ ;
    /**
     * <pre>
     * 挂单数量
     * </pre>
     *
     * <code>optional uint64 orderNum = 3;</code>
     */
    public boolean hasOrderNum() {
      return ((bitField0_ & 0x00000004) == 0x00000004);
    }
    /**
     * <pre>
     * 挂单数量
     * </pre>
     *
     * <code>optional uint64 orderNum = 3;</code>
     */
    public long getOrderNum() {
      return orderNum_;
    }
    /**
     * <pre>
     * 挂单数量
     * </pre>
     *
     * <code>optional uint64 orderNum = 3;</code>
     */
    public Builder setOrderNum(long value) {
      bitField0_ |= 0x00000004;
      orderNum_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * 挂单数量
     * </pre>
     *
     * <code>optional uint64 orderNum = 3;</code>
     */
    public Builder clearOrderNum() {
      bitField0_ = (bitField0_ & ~0x00000004);
      orderNum_ = 0L;
      onChanged();
      return this;
    }

    private long tradeNum_ ;
    /**
     * <pre>
     * 已经完成的交易物品数量
     * </pre>
     *
     * <code>optional uint64 tradeNum = 4;</code>
     */
    public boolean hasTradeNum() {
      return ((bitField0_ & 0x00000008) == 0x00000008);
    }
    /**
     * <pre>
     * 已经完成的交易物品数量
     * </pre>
     *
     * <code>optional uint64 tradeNum = 4;</code>
     */
    public long getTradeNum() {
      return tradeNum_;
    }
    /**
     * <pre>
     * 已经完成的交易物品数量
     * </pre>
     *
     * <code>optional uint64 tradeNum = 4;</code>
     */
    public Builder setTradeNum(long value) {
      bitField0_ |= 0x00000008;
      tradeNum_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * 已经完成的交易物品数量
     * </pre>
     *
     * <code>optional uint64 tradeNum = 4;</code>
     */
    public Builder clearTradeNum() {
      bitField0_ = (bitField0_ & ~0x00000008);
      tradeNum_ = 0L;
      onChanged();
      return this;
    }

    private int itemID_ ;
    /**
     * <pre>
     * 物品ID
     * </pre>
     *
     * <code>optional uint32 itemID = 5;</code>
     */
    public boolean hasItemID() {
      return ((bitField0_ & 0x00000010) == 0x00000010);
    }
    /**
     * <pre>
     * 物品ID
     * </pre>
     *
     * <code>optional uint32 itemID = 5;</code>
     */
    public int getItemID() {
      return itemID_;
    }
    /**
     * <pre>
     * 物品ID
     * </pre>
     *
     * <code>optional uint32 itemID = 5;</code>
     */
    public Builder setItemID(int value) {
      bitField0_ |= 0x00000010;
      itemID_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * 物品ID
     * </pre>
     *
     * <code>optional uint32 itemID = 5;</code>
     */
    public Builder clearItemID() {
      bitField0_ = (bitField0_ & ~0x00000010);
      itemID_ = 0;
      onChanged();
      return this;
    }

    private long itemNum_ ;
    /**
     * <pre>
     * 物品数量
     * </pre>
     *
     * <code>optional uint64 itemNum = 6;</code>
     */
    public boolean hasItemNum() {
      return ((bitField0_ & 0x00000020) == 0x00000020);
    }
    /**
     * <pre>
     * 物品数量
     * </pre>
     *
     * <code>optional uint64 itemNum = 6;</code>
     */
    public long getItemNum() {
      return itemNum_;
    }
    /**
     * <pre>
     * 物品数量
     * </pre>
     *
     * <code>optional uint64 itemNum = 6;</code>
     */
    public Builder setItemNum(long value) {
      bitField0_ |= 0x00000020;
      itemNum_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * 物品数量
     * </pre>
     *
     * <code>optional uint64 itemNum = 6;</code>
     */
    public Builder clearItemNum() {
      bitField0_ = (bitField0_ & ~0x00000020);
      itemNum_ = 0L;
      onChanged();
      return this;
    }

    private long price_ ;
    /**
     * <pre>
     * 单品价格
     * </pre>
     *
     * <code>optional uint64 price = 7;</code>
     */
    public boolean hasPrice() {
      return ((bitField0_ & 0x00000040) == 0x00000040);
    }
    /**
     * <pre>
     * 单品价格
     * </pre>
     *
     * <code>optional uint64 price = 7;</code>
     */
    public long getPrice() {
      return price_;
    }
    /**
     * <pre>
     * 单品价格
     * </pre>
     *
     * <code>optional uint64 price = 7;</code>
     */
    public Builder setPrice(long value) {
      bitField0_ |= 0x00000040;
      price_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * 单品价格
     * </pre>
     *
     * <code>optional uint64 price = 7;</code>
     */
    public Builder clearPrice() {
      bitField0_ = (bitField0_ & ~0x00000040);
      price_ = 0L;
      onChanged();
      return this;
    }

    private long amount_ ;
    /**
     * <pre>
     * 挂单总价格
     * </pre>
     *
     * <code>optional uint64 amount = 8;</code>
     */
    public boolean hasAmount() {
      return ((bitField0_ & 0x00000080) == 0x00000080);
    }
    /**
     * <pre>
     * 挂单总价格
     * </pre>
     *
     * <code>optional uint64 amount = 8;</code>
     */
    public long getAmount() {
      return amount_;
    }
    /**
     * <pre>
     * 挂单总价格
     * </pre>
     *
     * <code>optional uint64 amount = 8;</code>
     */
    public Builder setAmount(long value) {
      bitField0_ |= 0x00000080;
      amount_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * 挂单总价格
     * </pre>
     *
     * <code>optional uint64 amount = 8;</code>
     */
    public Builder clearAmount() {
      bitField0_ = (bitField0_ & ~0x00000080);
      amount_ = 0L;
      onChanged();
      return this;
    }

    private long roleID_ ;
    /**
     * <pre>
     * 挂单发起者
     * </pre>
     *
     * <code>optional uint64 roleID = 9;</code>
     */
    public boolean hasRoleID() {
      return ((bitField0_ & 0x00000100) == 0x00000100);
    }
    /**
     * <pre>
     * 挂单发起者
     * </pre>
     *
     * <code>optional uint64 roleID = 9;</code>
     */
    public long getRoleID() {
      return roleID_;
    }
    /**
     * <pre>
     * 挂单发起者
     * </pre>
     *
     * <code>optional uint64 roleID = 9;</code>
     */
    public Builder setRoleID(long value) {
      bitField0_ |= 0x00000100;
      roleID_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * 挂单发起者
     * </pre>
     *
     * <code>optional uint64 roleID = 9;</code>
     */
    public Builder clearRoleID() {
      bitField0_ = (bitField0_ & ~0x00000100);
      roleID_ = 0L;
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


    // @@protoc_insertion_point(builder_scope:Protocols.TradeOrderInfo)
  }

  // @@protoc_insertion_point(class_scope:Protocols.TradeOrderInfo)
  private static final com.dj.protobuf.trade.TradeOrderInfo DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.dj.protobuf.trade.TradeOrderInfo();
  }

  public static com.dj.protobuf.trade.TradeOrderInfo getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  @java.lang.Deprecated public static final com.google.protobuf.Parser<TradeOrderInfo>
      PARSER = new com.google.protobuf.AbstractParser<TradeOrderInfo>() {
    public TradeOrderInfo parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new TradeOrderInfo(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<TradeOrderInfo> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<TradeOrderInfo> getParserForType() {
    return PARSER;
  }

  public com.dj.protobuf.trade.TradeOrderInfo getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

