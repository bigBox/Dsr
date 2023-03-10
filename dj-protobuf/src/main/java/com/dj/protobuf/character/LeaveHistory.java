// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Character.proto

package com.dj.protobuf.character;

/**
 * <pre>
 * 离开历史记录
 * </pre>
 *
 * Protobuf type {@code Protocols.LeaveHistory}
 */
public  final class LeaveHistory extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:Protocols.LeaveHistory)
    LeaveHistoryOrBuilder {
  // Use LeaveHistory.newBuilder() to construct.
  private LeaveHistory(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private LeaveHistory() {
    leaveID_ = 0;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private LeaveHistory(
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
            leaveID_ = input.readInt32();
            break;
          }
          case 18: {
            com.dj.protobuf.datetime.DateTime.Builder subBuilder = null;
            if (((bitField0_ & 0x00000002) == 0x00000002)) {
              subBuilder = leaveTime_.toBuilder();
            }
            leaveTime_ = input.readMessage(com.dj.protobuf.datetime.DateTime.PARSER, extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(leaveTime_);
              leaveTime_ = subBuilder.buildPartial();
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
    return com.dj.protobuf.character.Character.internal_static_Protocols_LeaveHistory_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.dj.protobuf.character.Character.internal_static_Protocols_LeaveHistory_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.dj.protobuf.character.LeaveHistory.class, com.dj.protobuf.character.LeaveHistory.Builder.class);
  }

  private int bitField0_;
  public static final int LEAVEID_FIELD_NUMBER = 1;
  private int leaveID_;
  /**
   * <pre>
   * 互动人
   * </pre>
   *
   * <code>optional int32 leaveID = 1;</code>
   */
  public boolean hasLeaveID() {
    return ((bitField0_ & 0x00000001) == 0x00000001);
  }
  /**
   * <pre>
   * 互动人
   * </pre>
   *
   * <code>optional int32 leaveID = 1;</code>
   */
  public int getLeaveID() {
    return leaveID_;
  }

  public static final int LEAVETIME_FIELD_NUMBER = 2;
  private com.dj.protobuf.datetime.DateTime leaveTime_;
  /**
   * <pre>
   * 互动时间
   * </pre>
   *
   * <code>optional .Protocols.DateTime leaveTime = 2;</code>
   */
  public boolean hasLeaveTime() {
    return ((bitField0_ & 0x00000002) == 0x00000002);
  }
  /**
   * <pre>
   * 互动时间
   * </pre>
   *
   * <code>optional .Protocols.DateTime leaveTime = 2;</code>
   */
  public com.dj.protobuf.datetime.DateTime getLeaveTime() {
    return leaveTime_ == null ? com.dj.protobuf.datetime.DateTime.getDefaultInstance() : leaveTime_;
  }
  /**
   * <pre>
   * 互动时间
   * </pre>
   *
   * <code>optional .Protocols.DateTime leaveTime = 2;</code>
   */
  public com.dj.protobuf.datetime.DateTimeOrBuilder getLeaveTimeOrBuilder() {
    return leaveTime_ == null ? com.dj.protobuf.datetime.DateTime.getDefaultInstance() : leaveTime_;
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
      output.writeInt32(1, leaveID_);
    }
    if (((bitField0_ & 0x00000002) == 0x00000002)) {
      output.writeMessage(2, getLeaveTime());
    }
    unknownFields.writeTo(output);
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (((bitField0_ & 0x00000001) == 0x00000001)) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(1, leaveID_);
    }
    if (((bitField0_ & 0x00000002) == 0x00000002)) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(2, getLeaveTime());
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
    if (!(obj instanceof com.dj.protobuf.character.LeaveHistory)) {
      return super.equals(obj);
    }
    com.dj.protobuf.character.LeaveHistory other = (com.dj.protobuf.character.LeaveHistory) obj;

    boolean result = true;
    result = result && (hasLeaveID() == other.hasLeaveID());
    if (hasLeaveID()) {
      result = result && (getLeaveID()
          == other.getLeaveID());
    }
    result = result && (hasLeaveTime() == other.hasLeaveTime());
    if (hasLeaveTime()) {
      result = result && getLeaveTime()
          .equals(other.getLeaveTime());
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
    if (hasLeaveID()) {
      hash = (37 * hash) + LEAVEID_FIELD_NUMBER;
      hash = (53 * hash) + getLeaveID();
    }
    if (hasLeaveTime()) {
      hash = (37 * hash) + LEAVETIME_FIELD_NUMBER;
      hash = (53 * hash) + getLeaveTime().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.dj.protobuf.character.LeaveHistory parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dj.protobuf.character.LeaveHistory parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dj.protobuf.character.LeaveHistory parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dj.protobuf.character.LeaveHistory parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dj.protobuf.character.LeaveHistory parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.character.LeaveHistory parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.dj.protobuf.character.LeaveHistory parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.character.LeaveHistory parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.dj.protobuf.character.LeaveHistory parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.character.LeaveHistory parseFrom(
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
  public static Builder newBuilder(com.dj.protobuf.character.LeaveHistory prototype) {
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
   * 离开历史记录
   * </pre>
   *
   * Protobuf type {@code Protocols.LeaveHistory}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:Protocols.LeaveHistory)
      com.dj.protobuf.character.LeaveHistoryOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.dj.protobuf.character.Character.internal_static_Protocols_LeaveHistory_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.dj.protobuf.character.Character.internal_static_Protocols_LeaveHistory_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.dj.protobuf.character.LeaveHistory.class, com.dj.protobuf.character.LeaveHistory.Builder.class);
    }

    // Construct using com.dj.protobuf.character.LeaveHistory.newBuilder()
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
        getLeaveTimeFieldBuilder();
      }
    }
    public Builder clear() {
      super.clear();
      leaveID_ = 0;
      bitField0_ = (bitField0_ & ~0x00000001);
      if (leaveTimeBuilder_ == null) {
        leaveTime_ = null;
      } else {
        leaveTimeBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000002);
      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.dj.protobuf.character.Character.internal_static_Protocols_LeaveHistory_descriptor;
    }

    public com.dj.protobuf.character.LeaveHistory getDefaultInstanceForType() {
      return com.dj.protobuf.character.LeaveHistory.getDefaultInstance();
    }

    public com.dj.protobuf.character.LeaveHistory build() {
      com.dj.protobuf.character.LeaveHistory result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public com.dj.protobuf.character.LeaveHistory buildPartial() {
      com.dj.protobuf.character.LeaveHistory result = new com.dj.protobuf.character.LeaveHistory(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
        to_bitField0_ |= 0x00000001;
      }
      result.leaveID_ = leaveID_;
      if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
        to_bitField0_ |= 0x00000002;
      }
      if (leaveTimeBuilder_ == null) {
        result.leaveTime_ = leaveTime_;
      } else {
        result.leaveTime_ = leaveTimeBuilder_.build();
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
      if (other instanceof com.dj.protobuf.character.LeaveHistory) {
        return mergeFrom((com.dj.protobuf.character.LeaveHistory)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.dj.protobuf.character.LeaveHistory other) {
      if (other == com.dj.protobuf.character.LeaveHistory.getDefaultInstance()) return this;
      if (other.hasLeaveID()) {
        setLeaveID(other.getLeaveID());
      }
      if (other.hasLeaveTime()) {
        mergeLeaveTime(other.getLeaveTime());
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
      com.dj.protobuf.character.LeaveHistory parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.dj.protobuf.character.LeaveHistory) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private int leaveID_ ;
    /**
     * <pre>
     * 互动人
     * </pre>
     *
     * <code>optional int32 leaveID = 1;</code>
     */
    public boolean hasLeaveID() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <pre>
     * 互动人
     * </pre>
     *
     * <code>optional int32 leaveID = 1;</code>
     */
    public int getLeaveID() {
      return leaveID_;
    }
    /**
     * <pre>
     * 互动人
     * </pre>
     *
     * <code>optional int32 leaveID = 1;</code>
     */
    public Builder setLeaveID(int value) {
      bitField0_ |= 0x00000001;
      leaveID_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * 互动人
     * </pre>
     *
     * <code>optional int32 leaveID = 1;</code>
     */
    public Builder clearLeaveID() {
      bitField0_ = (bitField0_ & ~0x00000001);
      leaveID_ = 0;
      onChanged();
      return this;
    }

    private com.dj.protobuf.datetime.DateTime leaveTime_ = null;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.dj.protobuf.datetime.DateTime, com.dj.protobuf.datetime.DateTime.Builder, com.dj.protobuf.datetime.DateTimeOrBuilder> leaveTimeBuilder_;
    /**
     * <pre>
     * 互动时间
     * </pre>
     *
     * <code>optional .Protocols.DateTime leaveTime = 2;</code>
     */
    public boolean hasLeaveTime() {
      return ((bitField0_ & 0x00000002) == 0x00000002);
    }
    /**
     * <pre>
     * 互动时间
     * </pre>
     *
     * <code>optional .Protocols.DateTime leaveTime = 2;</code>
     */
    public com.dj.protobuf.datetime.DateTime getLeaveTime() {
      if (leaveTimeBuilder_ == null) {
        return leaveTime_ == null ? com.dj.protobuf.datetime.DateTime.getDefaultInstance() : leaveTime_;
      } else {
        return leaveTimeBuilder_.getMessage();
      }
    }
    /**
     * <pre>
     * 互动时间
     * </pre>
     *
     * <code>optional .Protocols.DateTime leaveTime = 2;</code>
     */
    public Builder setLeaveTime(com.dj.protobuf.datetime.DateTime value) {
      if (leaveTimeBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        leaveTime_ = value;
        onChanged();
      } else {
        leaveTimeBuilder_.setMessage(value);
      }
      bitField0_ |= 0x00000002;
      return this;
    }
    /**
     * <pre>
     * 互动时间
     * </pre>
     *
     * <code>optional .Protocols.DateTime leaveTime = 2;</code>
     */
    public Builder setLeaveTime(
        com.dj.protobuf.datetime.DateTime.Builder builderForValue) {
      if (leaveTimeBuilder_ == null) {
        leaveTime_ = builderForValue.build();
        onChanged();
      } else {
        leaveTimeBuilder_.setMessage(builderForValue.build());
      }
      bitField0_ |= 0x00000002;
      return this;
    }
    /**
     * <pre>
     * 互动时间
     * </pre>
     *
     * <code>optional .Protocols.DateTime leaveTime = 2;</code>
     */
    public Builder mergeLeaveTime(com.dj.protobuf.datetime.DateTime value) {
      if (leaveTimeBuilder_ == null) {
        if (((bitField0_ & 0x00000002) == 0x00000002) &&
            leaveTime_ != null &&
            leaveTime_ != com.dj.protobuf.datetime.DateTime.getDefaultInstance()) {
          leaveTime_ =
            com.dj.protobuf.datetime.DateTime.newBuilder(leaveTime_).mergeFrom(value).buildPartial();
        } else {
          leaveTime_ = value;
        }
        onChanged();
      } else {
        leaveTimeBuilder_.mergeFrom(value);
      }
      bitField0_ |= 0x00000002;
      return this;
    }
    /**
     * <pre>
     * 互动时间
     * </pre>
     *
     * <code>optional .Protocols.DateTime leaveTime = 2;</code>
     */
    public Builder clearLeaveTime() {
      if (leaveTimeBuilder_ == null) {
        leaveTime_ = null;
        onChanged();
      } else {
        leaveTimeBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000002);
      return this;
    }
    /**
     * <pre>
     * 互动时间
     * </pre>
     *
     * <code>optional .Protocols.DateTime leaveTime = 2;</code>
     */
    public com.dj.protobuf.datetime.DateTime.Builder getLeaveTimeBuilder() {
      bitField0_ |= 0x00000002;
      onChanged();
      return getLeaveTimeFieldBuilder().getBuilder();
    }
    /**
     * <pre>
     * 互动时间
     * </pre>
     *
     * <code>optional .Protocols.DateTime leaveTime = 2;</code>
     */
    public com.dj.protobuf.datetime.DateTimeOrBuilder getLeaveTimeOrBuilder() {
      if (leaveTimeBuilder_ != null) {
        return leaveTimeBuilder_.getMessageOrBuilder();
      } else {
        return leaveTime_ == null ?
            com.dj.protobuf.datetime.DateTime.getDefaultInstance() : leaveTime_;
      }
    }
    /**
     * <pre>
     * 互动时间
     * </pre>
     *
     * <code>optional .Protocols.DateTime leaveTime = 2;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.dj.protobuf.datetime.DateTime, com.dj.protobuf.datetime.DateTime.Builder, com.dj.protobuf.datetime.DateTimeOrBuilder> 
        getLeaveTimeFieldBuilder() {
      if (leaveTimeBuilder_ == null) {
        leaveTimeBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.dj.protobuf.datetime.DateTime, com.dj.protobuf.datetime.DateTime.Builder, com.dj.protobuf.datetime.DateTimeOrBuilder>(
                getLeaveTime(),
                getParentForChildren(),
                isClean());
        leaveTime_ = null;
      }
      return leaveTimeBuilder_;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:Protocols.LeaveHistory)
  }

  // @@protoc_insertion_point(class_scope:Protocols.LeaveHistory)
  private static final com.dj.protobuf.character.LeaveHistory DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.dj.protobuf.character.LeaveHistory();
  }

  public static com.dj.protobuf.character.LeaveHistory getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  @java.lang.Deprecated public static final com.google.protobuf.Parser<LeaveHistory>
      PARSER = new com.google.protobuf.AbstractParser<LeaveHistory>() {
    public LeaveHistory parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new LeaveHistory(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<LeaveHistory> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<LeaveHistory> getParserForType() {
    return PARSER;
  }

  public com.dj.protobuf.character.LeaveHistory getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

