// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: City.proto

package com.dj.protobuf.city;

/**
 * Protobuf type {@code Protocols.NpcVisitRsp}
 */
public  final class NpcVisitRsp extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:Protocols.NpcVisitRsp)
    NpcVisitRspOrBuilder {
  // Use NpcVisitRsp.newBuilder() to construct.
  private NpcVisitRsp(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private NpcVisitRsp() {
    errorID_ = 0;
    eventID_ = 0;
    npcID_ = 0;
    eventType_ = 100;
    eventContent_ = "";
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private NpcVisitRsp(
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
            com.dj.protobuf.city.NpcVisitReq.Builder subBuilder = null;
            if (((bitField0_ & 0x00000002) == 0x00000002)) {
              subBuilder = req_.toBuilder();
            }
            req_ = input.readMessage(com.dj.protobuf.city.NpcVisitReq.PARSER, extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(req_);
              req_ = subBuilder.buildPartial();
            }
            bitField0_ |= 0x00000002;
            break;
          }
          case 24: {
            bitField0_ |= 0x00000004;
            eventID_ = input.readInt32();
            break;
          }
          case 32: {
            bitField0_ |= 0x00000008;
            npcID_ = input.readInt32();
            break;
          }
          case 40: {
            int rawValue = input.readEnum();
            com.dj.protobuf.city.CityEventType value = com.dj.protobuf.city.CityEventType.valueOf(rawValue);
            if (value == null) {
              unknownFields.mergeVarintField(5, rawValue);
            } else {
              bitField0_ |= 0x00000010;
              eventType_ = rawValue;
            }
            break;
          }
          case 50: {
            com.google.protobuf.ByteString bs = input.readBytes();
            bitField0_ |= 0x00000020;
            eventContent_ = bs;
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
    return com.dj.protobuf.city.City.internal_static_Protocols_NpcVisitRsp_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.dj.protobuf.city.City.internal_static_Protocols_NpcVisitRsp_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.dj.protobuf.city.NpcVisitRsp.class, com.dj.protobuf.city.NpcVisitRsp.Builder.class);
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

  public static final int REQ_FIELD_NUMBER = 2;
  private com.dj.protobuf.city.NpcVisitReq req_;
  /**
   * <code>optional .Protocols.NpcVisitReq req = 2;</code>
   */
  public boolean hasReq() {
    return ((bitField0_ & 0x00000002) == 0x00000002);
  }
  /**
   * <code>optional .Protocols.NpcVisitReq req = 2;</code>
   */
  public com.dj.protobuf.city.NpcVisitReq getReq() {
    return req_ == null ? com.dj.protobuf.city.NpcVisitReq.getDefaultInstance() : req_;
  }
  /**
   * <code>optional .Protocols.NpcVisitReq req = 2;</code>
   */
  public com.dj.protobuf.city.NpcVisitReqOrBuilder getReqOrBuilder() {
    return req_ == null ? com.dj.protobuf.city.NpcVisitReq.getDefaultInstance() : req_;
  }

  public static final int EVENTID_FIELD_NUMBER = 3;
  private int eventID_;
  /**
   * <pre>
   *??????ID
   * </pre>
   *
   * <code>optional int32 eventID = 3;</code>
   */
  public boolean hasEventID() {
    return ((bitField0_ & 0x00000004) == 0x00000004);
  }
  /**
   * <pre>
   *??????ID
   * </pre>
   *
   * <code>optional int32 eventID = 3;</code>
   */
  public int getEventID() {
    return eventID_;
  }

  public static final int NPCID_FIELD_NUMBER = 4;
  private int npcID_;
  /**
   * <pre>
   * npcID
   * </pre>
   *
   * <code>optional int32 npcID = 4;</code>
   */
  public boolean hasNpcID() {
    return ((bitField0_ & 0x00000008) == 0x00000008);
  }
  /**
   * <pre>
   * npcID
   * </pre>
   *
   * <code>optional int32 npcID = 4;</code>
   */
  public int getNpcID() {
    return npcID_;
  }

  public static final int EVENTTYPE_FIELD_NUMBER = 5;
  private int eventType_;
  /**
   * <pre>
   * ????????????
   * </pre>
   *
   * <code>optional .Protocols.CityEventType eventType = 5;</code>
   */
  public boolean hasEventType() {
    return ((bitField0_ & 0x00000010) == 0x00000010);
  }
  /**
   * <pre>
   * ????????????
   * </pre>
   *
   * <code>optional .Protocols.CityEventType eventType = 5;</code>
   */
  public com.dj.protobuf.city.CityEventType getEventType() {
    com.dj.protobuf.city.CityEventType result = com.dj.protobuf.city.CityEventType.valueOf(eventType_);
    return result == null ? com.dj.protobuf.city.CityEventType.No_Body : result;
  }

  public static final int EVENTCONTENT_FIELD_NUMBER = 6;
  private volatile java.lang.Object eventContent_;
  /**
   * <pre>
   * ????????????
   * eventType=101 ????????????eventContent ?????? questionID
   * eventType=102 ????????????eventContent ?????? ???????????? winOrLose  (1-??? 0-???) ,itemID , itemCount
   * eventType=103 ???????????????eventContent ?????? itemID(1?????????), itemCount 1000
   * eventType=104 ???????????????eventContent ?????? itemID, itemCount
   * eventType=105 ????????????eventContent ?????? itemID, itemCount
   * eventType=106 ??????NPC???eventContent ?????? ??????
   * </pre>
   *
   * <code>optional string eventContent = 6;</code>
   */
  public boolean hasEventContent() {
    return ((bitField0_ & 0x00000020) == 0x00000020);
  }
  /**
   * <pre>
   * ????????????
   * eventType=101 ????????????eventContent ?????? questionID
   * eventType=102 ????????????eventContent ?????? ???????????? winOrLose  (1-??? 0-???) ,itemID , itemCount
   * eventType=103 ???????????????eventContent ?????? itemID(1?????????), itemCount 1000
   * eventType=104 ???????????????eventContent ?????? itemID, itemCount
   * eventType=105 ????????????eventContent ?????? itemID, itemCount
   * eventType=106 ??????NPC???eventContent ?????? ??????
   * </pre>
   *
   * <code>optional string eventContent = 6;</code>
   */
  public java.lang.String getEventContent() {
    java.lang.Object ref = eventContent_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      if (bs.isValidUtf8()) {
        eventContent_ = s;
      }
      return s;
    }
  }
  /**
   * <pre>
   * ????????????
   * eventType=101 ????????????eventContent ?????? questionID
   * eventType=102 ????????????eventContent ?????? ???????????? winOrLose  (1-??? 0-???) ,itemID , itemCount
   * eventType=103 ???????????????eventContent ?????? itemID(1?????????), itemCount 1000
   * eventType=104 ???????????????eventContent ?????? itemID, itemCount
   * eventType=105 ????????????eventContent ?????? itemID, itemCount
   * eventType=106 ??????NPC???eventContent ?????? ??????
   * </pre>
   *
   * <code>optional string eventContent = 6;</code>
   */
  public com.google.protobuf.ByteString
      getEventContentBytes() {
    java.lang.Object ref = eventContent_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      eventContent_ = b;
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
      output.writeEnum(1, errorID_);
    }
    if (((bitField0_ & 0x00000002) == 0x00000002)) {
      output.writeMessage(2, getReq());
    }
    if (((bitField0_ & 0x00000004) == 0x00000004)) {
      output.writeInt32(3, eventID_);
    }
    if (((bitField0_ & 0x00000008) == 0x00000008)) {
      output.writeInt32(4, npcID_);
    }
    if (((bitField0_ & 0x00000010) == 0x00000010)) {
      output.writeEnum(5, eventType_);
    }
    if (((bitField0_ & 0x00000020) == 0x00000020)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 6, eventContent_);
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
    if (((bitField0_ & 0x00000004) == 0x00000004)) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(3, eventID_);
    }
    if (((bitField0_ & 0x00000008) == 0x00000008)) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(4, npcID_);
    }
    if (((bitField0_ & 0x00000010) == 0x00000010)) {
      size += com.google.protobuf.CodedOutputStream
        .computeEnumSize(5, eventType_);
    }
    if (((bitField0_ & 0x00000020) == 0x00000020)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(6, eventContent_);
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
    if (!(obj instanceof com.dj.protobuf.city.NpcVisitRsp)) {
      return super.equals(obj);
    }
    com.dj.protobuf.city.NpcVisitRsp other = (com.dj.protobuf.city.NpcVisitRsp) obj;

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
    result = result && (hasEventID() == other.hasEventID());
    if (hasEventID()) {
      result = result && (getEventID()
          == other.getEventID());
    }
    result = result && (hasNpcID() == other.hasNpcID());
    if (hasNpcID()) {
      result = result && (getNpcID()
          == other.getNpcID());
    }
    result = result && (hasEventType() == other.hasEventType());
    if (hasEventType()) {
      result = result && eventType_ == other.eventType_;
    }
    result = result && (hasEventContent() == other.hasEventContent());
    if (hasEventContent()) {
      result = result && getEventContent()
          .equals(other.getEventContent());
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
    if (hasErrorID()) {
      hash = (37 * hash) + ERRORID_FIELD_NUMBER;
      hash = (53 * hash) + errorID_;
    }
    if (hasReq()) {
      hash = (37 * hash) + REQ_FIELD_NUMBER;
      hash = (53 * hash) + getReq().hashCode();
    }
    if (hasEventID()) {
      hash = (37 * hash) + EVENTID_FIELD_NUMBER;
      hash = (53 * hash) + getEventID();
    }
    if (hasNpcID()) {
      hash = (37 * hash) + NPCID_FIELD_NUMBER;
      hash = (53 * hash) + getNpcID();
    }
    if (hasEventType()) {
      hash = (37 * hash) + EVENTTYPE_FIELD_NUMBER;
      hash = (53 * hash) + eventType_;
    }
    if (hasEventContent()) {
      hash = (37 * hash) + EVENTCONTENT_FIELD_NUMBER;
      hash = (53 * hash) + getEventContent().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.dj.protobuf.city.NpcVisitRsp parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dj.protobuf.city.NpcVisitRsp parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dj.protobuf.city.NpcVisitRsp parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dj.protobuf.city.NpcVisitRsp parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dj.protobuf.city.NpcVisitRsp parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.city.NpcVisitRsp parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.dj.protobuf.city.NpcVisitRsp parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.city.NpcVisitRsp parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.dj.protobuf.city.NpcVisitRsp parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.city.NpcVisitRsp parseFrom(
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
  public static Builder newBuilder(com.dj.protobuf.city.NpcVisitRsp prototype) {
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
   * Protobuf type {@code Protocols.NpcVisitRsp}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:Protocols.NpcVisitRsp)
      com.dj.protobuf.city.NpcVisitRspOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.dj.protobuf.city.City.internal_static_Protocols_NpcVisitRsp_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.dj.protobuf.city.City.internal_static_Protocols_NpcVisitRsp_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.dj.protobuf.city.NpcVisitRsp.class, com.dj.protobuf.city.NpcVisitRsp.Builder.class);
    }

    // Construct using com.dj.protobuf.city.NpcVisitRsp.newBuilder()
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
      eventID_ = 0;
      bitField0_ = (bitField0_ & ~0x00000004);
      npcID_ = 0;
      bitField0_ = (bitField0_ & ~0x00000008);
      eventType_ = 100;
      bitField0_ = (bitField0_ & ~0x00000010);
      eventContent_ = "";
      bitField0_ = (bitField0_ & ~0x00000020);
      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.dj.protobuf.city.City.internal_static_Protocols_NpcVisitRsp_descriptor;
    }

    public com.dj.protobuf.city.NpcVisitRsp getDefaultInstanceForType() {
      return com.dj.protobuf.city.NpcVisitRsp.getDefaultInstance();
    }

    public com.dj.protobuf.city.NpcVisitRsp build() {
      com.dj.protobuf.city.NpcVisitRsp result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public com.dj.protobuf.city.NpcVisitRsp buildPartial() {
      com.dj.protobuf.city.NpcVisitRsp result = new com.dj.protobuf.city.NpcVisitRsp(this);
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
      if (((from_bitField0_ & 0x00000004) == 0x00000004)) {
        to_bitField0_ |= 0x00000004;
      }
      result.eventID_ = eventID_;
      if (((from_bitField0_ & 0x00000008) == 0x00000008)) {
        to_bitField0_ |= 0x00000008;
      }
      result.npcID_ = npcID_;
      if (((from_bitField0_ & 0x00000010) == 0x00000010)) {
        to_bitField0_ |= 0x00000010;
      }
      result.eventType_ = eventType_;
      if (((from_bitField0_ & 0x00000020) == 0x00000020)) {
        to_bitField0_ |= 0x00000020;
      }
      result.eventContent_ = eventContent_;
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
      if (other instanceof com.dj.protobuf.city.NpcVisitRsp) {
        return mergeFrom((com.dj.protobuf.city.NpcVisitRsp)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.dj.protobuf.city.NpcVisitRsp other) {
      if (other == com.dj.protobuf.city.NpcVisitRsp.getDefaultInstance()) return this;
      if (other.hasErrorID()) {
        setErrorID(other.getErrorID());
      }
      if (other.hasReq()) {
        mergeReq(other.getReq());
      }
      if (other.hasEventID()) {
        setEventID(other.getEventID());
      }
      if (other.hasNpcID()) {
        setNpcID(other.getNpcID());
      }
      if (other.hasEventType()) {
        setEventType(other.getEventType());
      }
      if (other.hasEventContent()) {
        bitField0_ |= 0x00000020;
        eventContent_ = other.eventContent_;
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
      com.dj.protobuf.city.NpcVisitRsp parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.dj.protobuf.city.NpcVisitRsp) e.getUnfinishedMessage();
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

    private com.dj.protobuf.city.NpcVisitReq req_ = null;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.dj.protobuf.city.NpcVisitReq, com.dj.protobuf.city.NpcVisitReq.Builder, com.dj.protobuf.city.NpcVisitReqOrBuilder> reqBuilder_;
    /**
     * <code>optional .Protocols.NpcVisitReq req = 2;</code>
     */
    public boolean hasReq() {
      return ((bitField0_ & 0x00000002) == 0x00000002);
    }
    /**
     * <code>optional .Protocols.NpcVisitReq req = 2;</code>
     */
    public com.dj.protobuf.city.NpcVisitReq getReq() {
      if (reqBuilder_ == null) {
        return req_ == null ? com.dj.protobuf.city.NpcVisitReq.getDefaultInstance() : req_;
      } else {
        return reqBuilder_.getMessage();
      }
    }
    /**
     * <code>optional .Protocols.NpcVisitReq req = 2;</code>
     */
    public Builder setReq(com.dj.protobuf.city.NpcVisitReq value) {
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
     * <code>optional .Protocols.NpcVisitReq req = 2;</code>
     */
    public Builder setReq(
        com.dj.protobuf.city.NpcVisitReq.Builder builderForValue) {
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
     * <code>optional .Protocols.NpcVisitReq req = 2;</code>
     */
    public Builder mergeReq(com.dj.protobuf.city.NpcVisitReq value) {
      if (reqBuilder_ == null) {
        if (((bitField0_ & 0x00000002) == 0x00000002) &&
            req_ != null &&
            req_ != com.dj.protobuf.city.NpcVisitReq.getDefaultInstance()) {
          req_ =
            com.dj.protobuf.city.NpcVisitReq.newBuilder(req_).mergeFrom(value).buildPartial();
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
     * <code>optional .Protocols.NpcVisitReq req = 2;</code>
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
     * <code>optional .Protocols.NpcVisitReq req = 2;</code>
     */
    public com.dj.protobuf.city.NpcVisitReq.Builder getReqBuilder() {
      bitField0_ |= 0x00000002;
      onChanged();
      return getReqFieldBuilder().getBuilder();
    }
    /**
     * <code>optional .Protocols.NpcVisitReq req = 2;</code>
     */
    public com.dj.protobuf.city.NpcVisitReqOrBuilder getReqOrBuilder() {
      if (reqBuilder_ != null) {
        return reqBuilder_.getMessageOrBuilder();
      } else {
        return req_ == null ?
            com.dj.protobuf.city.NpcVisitReq.getDefaultInstance() : req_;
      }
    }
    /**
     * <code>optional .Protocols.NpcVisitReq req = 2;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.dj.protobuf.city.NpcVisitReq, com.dj.protobuf.city.NpcVisitReq.Builder, com.dj.protobuf.city.NpcVisitReqOrBuilder> 
        getReqFieldBuilder() {
      if (reqBuilder_ == null) {
        reqBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.dj.protobuf.city.NpcVisitReq, com.dj.protobuf.city.NpcVisitReq.Builder, com.dj.protobuf.city.NpcVisitReqOrBuilder>(
                getReq(),
                getParentForChildren(),
                isClean());
        req_ = null;
      }
      return reqBuilder_;
    }

    private int eventID_ ;
    /**
     * <pre>
     *??????ID
     * </pre>
     *
     * <code>optional int32 eventID = 3;</code>
     */
    public boolean hasEventID() {
      return ((bitField0_ & 0x00000004) == 0x00000004);
    }
    /**
     * <pre>
     *??????ID
     * </pre>
     *
     * <code>optional int32 eventID = 3;</code>
     */
    public int getEventID() {
      return eventID_;
    }
    /**
     * <pre>
     *??????ID
     * </pre>
     *
     * <code>optional int32 eventID = 3;</code>
     */
    public Builder setEventID(int value) {
      bitField0_ |= 0x00000004;
      eventID_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     *??????ID
     * </pre>
     *
     * <code>optional int32 eventID = 3;</code>
     */
    public Builder clearEventID() {
      bitField0_ = (bitField0_ & ~0x00000004);
      eventID_ = 0;
      onChanged();
      return this;
    }

    private int npcID_ ;
    /**
     * <pre>
     * npcID
     * </pre>
     *
     * <code>optional int32 npcID = 4;</code>
     */
    public boolean hasNpcID() {
      return ((bitField0_ & 0x00000008) == 0x00000008);
    }
    /**
     * <pre>
     * npcID
     * </pre>
     *
     * <code>optional int32 npcID = 4;</code>
     */
    public int getNpcID() {
      return npcID_;
    }
    /**
     * <pre>
     * npcID
     * </pre>
     *
     * <code>optional int32 npcID = 4;</code>
     */
    public Builder setNpcID(int value) {
      bitField0_ |= 0x00000008;
      npcID_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * npcID
     * </pre>
     *
     * <code>optional int32 npcID = 4;</code>
     */
    public Builder clearNpcID() {
      bitField0_ = (bitField0_ & ~0x00000008);
      npcID_ = 0;
      onChanged();
      return this;
    }

    private int eventType_ = 100;
    /**
     * <pre>
     * ????????????
     * </pre>
     *
     * <code>optional .Protocols.CityEventType eventType = 5;</code>
     */
    public boolean hasEventType() {
      return ((bitField0_ & 0x00000010) == 0x00000010);
    }
    /**
     * <pre>
     * ????????????
     * </pre>
     *
     * <code>optional .Protocols.CityEventType eventType = 5;</code>
     */
    public com.dj.protobuf.city.CityEventType getEventType() {
      com.dj.protobuf.city.CityEventType result = com.dj.protobuf.city.CityEventType.valueOf(eventType_);
      return result == null ? com.dj.protobuf.city.CityEventType.No_Body : result;
    }
    /**
     * <pre>
     * ????????????
     * </pre>
     *
     * <code>optional .Protocols.CityEventType eventType = 5;</code>
     */
    public Builder setEventType(com.dj.protobuf.city.CityEventType value) {
      if (value == null) {
        throw new NullPointerException();
      }
      bitField0_ |= 0x00000010;
      eventType_ = value.getNumber();
      onChanged();
      return this;
    }
    /**
     * <pre>
     * ????????????
     * </pre>
     *
     * <code>optional .Protocols.CityEventType eventType = 5;</code>
     */
    public Builder clearEventType() {
      bitField0_ = (bitField0_ & ~0x00000010);
      eventType_ = 100;
      onChanged();
      return this;
    }

    private java.lang.Object eventContent_ = "";
    /**
     * <pre>
     * ????????????
     * eventType=101 ????????????eventContent ?????? questionID
     * eventType=102 ????????????eventContent ?????? ???????????? winOrLose  (1-??? 0-???) ,itemID , itemCount
     * eventType=103 ???????????????eventContent ?????? itemID(1?????????), itemCount 1000
     * eventType=104 ???????????????eventContent ?????? itemID, itemCount
     * eventType=105 ????????????eventContent ?????? itemID, itemCount
     * eventType=106 ??????NPC???eventContent ?????? ??????
     * </pre>
     *
     * <code>optional string eventContent = 6;</code>
     */
    public boolean hasEventContent() {
      return ((bitField0_ & 0x00000020) == 0x00000020);
    }
    /**
     * <pre>
     * ????????????
     * eventType=101 ????????????eventContent ?????? questionID
     * eventType=102 ????????????eventContent ?????? ???????????? winOrLose  (1-??? 0-???) ,itemID , itemCount
     * eventType=103 ???????????????eventContent ?????? itemID(1?????????), itemCount 1000
     * eventType=104 ???????????????eventContent ?????? itemID, itemCount
     * eventType=105 ????????????eventContent ?????? itemID, itemCount
     * eventType=106 ??????NPC???eventContent ?????? ??????
     * </pre>
     *
     * <code>optional string eventContent = 6;</code>
     */
    public java.lang.String getEventContent() {
      java.lang.Object ref = eventContent_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        if (bs.isValidUtf8()) {
          eventContent_ = s;
        }
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <pre>
     * ????????????
     * eventType=101 ????????????eventContent ?????? questionID
     * eventType=102 ????????????eventContent ?????? ???????????? winOrLose  (1-??? 0-???) ,itemID , itemCount
     * eventType=103 ???????????????eventContent ?????? itemID(1?????????), itemCount 1000
     * eventType=104 ???????????????eventContent ?????? itemID, itemCount
     * eventType=105 ????????????eventContent ?????? itemID, itemCount
     * eventType=106 ??????NPC???eventContent ?????? ??????
     * </pre>
     *
     * <code>optional string eventContent = 6;</code>
     */
    public com.google.protobuf.ByteString
        getEventContentBytes() {
      java.lang.Object ref = eventContent_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        eventContent_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <pre>
     * ????????????
     * eventType=101 ????????????eventContent ?????? questionID
     * eventType=102 ????????????eventContent ?????? ???????????? winOrLose  (1-??? 0-???) ,itemID , itemCount
     * eventType=103 ???????????????eventContent ?????? itemID(1?????????), itemCount 1000
     * eventType=104 ???????????????eventContent ?????? itemID, itemCount
     * eventType=105 ????????????eventContent ?????? itemID, itemCount
     * eventType=106 ??????NPC???eventContent ?????? ??????
     * </pre>
     *
     * <code>optional string eventContent = 6;</code>
     */
    public Builder setEventContent(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000020;
      eventContent_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * ????????????
     * eventType=101 ????????????eventContent ?????? questionID
     * eventType=102 ????????????eventContent ?????? ???????????? winOrLose  (1-??? 0-???) ,itemID , itemCount
     * eventType=103 ???????????????eventContent ?????? itemID(1?????????), itemCount 1000
     * eventType=104 ???????????????eventContent ?????? itemID, itemCount
     * eventType=105 ????????????eventContent ?????? itemID, itemCount
     * eventType=106 ??????NPC???eventContent ?????? ??????
     * </pre>
     *
     * <code>optional string eventContent = 6;</code>
     */
    public Builder clearEventContent() {
      bitField0_ = (bitField0_ & ~0x00000020);
      eventContent_ = getDefaultInstance().getEventContent();
      onChanged();
      return this;
    }
    /**
     * <pre>
     * ????????????
     * eventType=101 ????????????eventContent ?????? questionID
     * eventType=102 ????????????eventContent ?????? ???????????? winOrLose  (1-??? 0-???) ,itemID , itemCount
     * eventType=103 ???????????????eventContent ?????? itemID(1?????????), itemCount 1000
     * eventType=104 ???????????????eventContent ?????? itemID, itemCount
     * eventType=105 ????????????eventContent ?????? itemID, itemCount
     * eventType=106 ??????NPC???eventContent ?????? ??????
     * </pre>
     *
     * <code>optional string eventContent = 6;</code>
     */
    public Builder setEventContentBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000020;
      eventContent_ = value;
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


    // @@protoc_insertion_point(builder_scope:Protocols.NpcVisitRsp)
  }

  // @@protoc_insertion_point(class_scope:Protocols.NpcVisitRsp)
  private static final com.dj.protobuf.city.NpcVisitRsp DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.dj.protobuf.city.NpcVisitRsp();
  }

  public static com.dj.protobuf.city.NpcVisitRsp getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  @java.lang.Deprecated public static final com.google.protobuf.Parser<NpcVisitRsp>
      PARSER = new com.google.protobuf.AbstractParser<NpcVisitRsp>() {
    public NpcVisitRsp parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new NpcVisitRsp(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<NpcVisitRsp> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<NpcVisitRsp> getParserForType() {
    return PARSER;
  }

  public com.dj.protobuf.city.NpcVisitRsp getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

