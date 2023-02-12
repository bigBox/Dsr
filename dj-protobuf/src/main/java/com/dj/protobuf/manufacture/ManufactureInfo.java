// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Manufacture.proto

package com.dj.protobuf.manufacture;

/**
 * Protobuf type {@code Protocols.ManufactureInfo}
 */
public  final class ManufactureInfo extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:Protocols.ManufactureInfo)
    ManufactureInfoOrBuilder {
  // Use ManufactureInfo.newBuilder() to construct.
  private ManufactureInfo(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private ManufactureInfo() {
    makingQueue_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private ManufactureInfo(
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
              makingQueue_ = new java.util.ArrayList<com.dj.protobuf.manufacture.ManufactureState>();
              mutable_bitField0_ |= 0x00000001;
            }
            makingQueue_.add(
                input.readMessage(com.dj.protobuf.manufacture.ManufactureState.PARSER, extensionRegistry));
            break;
          }
          case 18: {
            com.dj.protobuf.datetime.DateTime.Builder subBuilder = null;
            if (((bitField0_ & 0x00000001) == 0x00000001)) {
              subBuilder = startTime_.toBuilder();
            }
            startTime_ = input.readMessage(com.dj.protobuf.datetime.DateTime.PARSER, extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(startTime_);
              startTime_ = subBuilder.buildPartial();
            }
            bitField0_ |= 0x00000001;
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
      if (((mutable_bitField0_ & 0x00000001) == 0x00000001)) {
        makingQueue_ = java.util.Collections.unmodifiableList(makingQueue_);
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.dj.protobuf.manufacture.Manufacture.internal_static_Protocols_ManufactureInfo_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.dj.protobuf.manufacture.Manufacture.internal_static_Protocols_ManufactureInfo_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.dj.protobuf.manufacture.ManufactureInfo.class, com.dj.protobuf.manufacture.ManufactureInfo.Builder.class);
  }

  private int bitField0_;
  public static final int MAKINGQUEUE_FIELD_NUMBER = 1;
  private java.util.List<com.dj.protobuf.manufacture.ManufactureState> makingQueue_;
  /**
   * <code>repeated .Protocols.ManufactureState makingQueue = 1;</code>
   */
  public java.util.List<com.dj.protobuf.manufacture.ManufactureState> getMakingQueueList() {
    return makingQueue_;
  }
  /**
   * <code>repeated .Protocols.ManufactureState makingQueue = 1;</code>
   */
  public java.util.List<? extends com.dj.protobuf.manufacture.ManufactureStateOrBuilder> 
      getMakingQueueOrBuilderList() {
    return makingQueue_;
  }
  /**
   * <code>repeated .Protocols.ManufactureState makingQueue = 1;</code>
   */
  public int getMakingQueueCount() {
    return makingQueue_.size();
  }
  /**
   * <code>repeated .Protocols.ManufactureState makingQueue = 1;</code>
   */
  public com.dj.protobuf.manufacture.ManufactureState getMakingQueue(int index) {
    return makingQueue_.get(index);
  }
  /**
   * <code>repeated .Protocols.ManufactureState makingQueue = 1;</code>
   */
  public com.dj.protobuf.manufacture.ManufactureStateOrBuilder getMakingQueueOrBuilder(
      int index) {
    return makingQueue_.get(index);
  }

  public static final int STARTTIME_FIELD_NUMBER = 2;
  private com.dj.protobuf.datetime.DateTime startTime_;
  /**
   * <code>optional .Protocols.DateTime startTime = 2;</code>
   */
  public boolean hasStartTime() {
    return ((bitField0_ & 0x00000001) == 0x00000001);
  }
  /**
   * <code>optional .Protocols.DateTime startTime = 2;</code>
   */
  public com.dj.protobuf.datetime.DateTime getStartTime() {
    return startTime_ == null ? com.dj.protobuf.datetime.DateTime.getDefaultInstance() : startTime_;
  }
  /**
   * <code>optional .Protocols.DateTime startTime = 2;</code>
   */
  public com.dj.protobuf.datetime.DateTimeOrBuilder getStartTimeOrBuilder() {
    return startTime_ == null ? com.dj.protobuf.datetime.DateTime.getDefaultInstance() : startTime_;
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
    for (int i = 0; i < makingQueue_.size(); i++) {
      output.writeMessage(1, makingQueue_.get(i));
    }
    if (((bitField0_ & 0x00000001) == 0x00000001)) {
      output.writeMessage(2, getStartTime());
    }
    unknownFields.writeTo(output);
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    for (int i = 0; i < makingQueue_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, makingQueue_.get(i));
    }
    if (((bitField0_ & 0x00000001) == 0x00000001)) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(2, getStartTime());
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
    if (!(obj instanceof com.dj.protobuf.manufacture.ManufactureInfo)) {
      return super.equals(obj);
    }
    com.dj.protobuf.manufacture.ManufactureInfo other = (com.dj.protobuf.manufacture.ManufactureInfo) obj;

    boolean result = true;
    result = result && getMakingQueueList()
        .equals(other.getMakingQueueList());
    result = result && (hasStartTime() == other.hasStartTime());
    if (hasStartTime()) {
      result = result && getStartTime()
          .equals(other.getStartTime());
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
    if (getMakingQueueCount() > 0) {
      hash = (37 * hash) + MAKINGQUEUE_FIELD_NUMBER;
      hash = (53 * hash) + getMakingQueueList().hashCode();
    }
    if (hasStartTime()) {
      hash = (37 * hash) + STARTTIME_FIELD_NUMBER;
      hash = (53 * hash) + getStartTime().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.dj.protobuf.manufacture.ManufactureInfo parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dj.protobuf.manufacture.ManufactureInfo parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dj.protobuf.manufacture.ManufactureInfo parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dj.protobuf.manufacture.ManufactureInfo parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dj.protobuf.manufacture.ManufactureInfo parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.manufacture.ManufactureInfo parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.dj.protobuf.manufacture.ManufactureInfo parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.manufacture.ManufactureInfo parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.dj.protobuf.manufacture.ManufactureInfo parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.manufacture.ManufactureInfo parseFrom(
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
  public static Builder newBuilder(com.dj.protobuf.manufacture.ManufactureInfo prototype) {
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
   * Protobuf type {@code Protocols.ManufactureInfo}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:Protocols.ManufactureInfo)
      com.dj.protobuf.manufacture.ManufactureInfoOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.dj.protobuf.manufacture.Manufacture.internal_static_Protocols_ManufactureInfo_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.dj.protobuf.manufacture.Manufacture.internal_static_Protocols_ManufactureInfo_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.dj.protobuf.manufacture.ManufactureInfo.class, com.dj.protobuf.manufacture.ManufactureInfo.Builder.class);
    }

    // Construct using com.dj.protobuf.manufacture.ManufactureInfo.newBuilder()
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
        getMakingQueueFieldBuilder();
        getStartTimeFieldBuilder();
      }
    }
    public Builder clear() {
      super.clear();
      if (makingQueueBuilder_ == null) {
        makingQueue_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
      } else {
        makingQueueBuilder_.clear();
      }
      if (startTimeBuilder_ == null) {
        startTime_ = null;
      } else {
        startTimeBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000002);
      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.dj.protobuf.manufacture.Manufacture.internal_static_Protocols_ManufactureInfo_descriptor;
    }

    public com.dj.protobuf.manufacture.ManufactureInfo getDefaultInstanceForType() {
      return com.dj.protobuf.manufacture.ManufactureInfo.getDefaultInstance();
    }

    public com.dj.protobuf.manufacture.ManufactureInfo build() {
      com.dj.protobuf.manufacture.ManufactureInfo result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public com.dj.protobuf.manufacture.ManufactureInfo buildPartial() {
      com.dj.protobuf.manufacture.ManufactureInfo result = new com.dj.protobuf.manufacture.ManufactureInfo(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      if (makingQueueBuilder_ == null) {
        if (((bitField0_ & 0x00000001) == 0x00000001)) {
          makingQueue_ = java.util.Collections.unmodifiableList(makingQueue_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.makingQueue_ = makingQueue_;
      } else {
        result.makingQueue_ = makingQueueBuilder_.build();
      }
      if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
        to_bitField0_ |= 0x00000001;
      }
      if (startTimeBuilder_ == null) {
        result.startTime_ = startTime_;
      } else {
        result.startTime_ = startTimeBuilder_.build();
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
      if (other instanceof com.dj.protobuf.manufacture.ManufactureInfo) {
        return mergeFrom((com.dj.protobuf.manufacture.ManufactureInfo)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.dj.protobuf.manufacture.ManufactureInfo other) {
      if (other == com.dj.protobuf.manufacture.ManufactureInfo.getDefaultInstance()) return this;
      if (makingQueueBuilder_ == null) {
        if (!other.makingQueue_.isEmpty()) {
          if (makingQueue_.isEmpty()) {
            makingQueue_ = other.makingQueue_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensureMakingQueueIsMutable();
            makingQueue_.addAll(other.makingQueue_);
          }
          onChanged();
        }
      } else {
        if (!other.makingQueue_.isEmpty()) {
          if (makingQueueBuilder_.isEmpty()) {
            makingQueueBuilder_.dispose();
            makingQueueBuilder_ = null;
            makingQueue_ = other.makingQueue_;
            bitField0_ = (bitField0_ & ~0x00000001);
            makingQueueBuilder_ = 
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getMakingQueueFieldBuilder() : null;
          } else {
            makingQueueBuilder_.addAllMessages(other.makingQueue_);
          }
        }
      }
      if (other.hasStartTime()) {
        mergeStartTime(other.getStartTime());
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
      com.dj.protobuf.manufacture.ManufactureInfo parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.dj.protobuf.manufacture.ManufactureInfo) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private java.util.List<com.dj.protobuf.manufacture.ManufactureState> makingQueue_ =
      java.util.Collections.emptyList();
    private void ensureMakingQueueIsMutable() {
      if (!((bitField0_ & 0x00000001) == 0x00000001)) {
        makingQueue_ = new java.util.ArrayList<com.dj.protobuf.manufacture.ManufactureState>(makingQueue_);
        bitField0_ |= 0x00000001;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        com.dj.protobuf.manufacture.ManufactureState, com.dj.protobuf.manufacture.ManufactureState.Builder, com.dj.protobuf.manufacture.ManufactureStateOrBuilder> makingQueueBuilder_;

    /**
     * <code>repeated .Protocols.ManufactureState makingQueue = 1;</code>
     */
    public java.util.List<com.dj.protobuf.manufacture.ManufactureState> getMakingQueueList() {
      if (makingQueueBuilder_ == null) {
        return java.util.Collections.unmodifiableList(makingQueue_);
      } else {
        return makingQueueBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .Protocols.ManufactureState makingQueue = 1;</code>
     */
    public int getMakingQueueCount() {
      if (makingQueueBuilder_ == null) {
        return makingQueue_.size();
      } else {
        return makingQueueBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .Protocols.ManufactureState makingQueue = 1;</code>
     */
    public com.dj.protobuf.manufacture.ManufactureState getMakingQueue(int index) {
      if (makingQueueBuilder_ == null) {
        return makingQueue_.get(index);
      } else {
        return makingQueueBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .Protocols.ManufactureState makingQueue = 1;</code>
     */
    public Builder setMakingQueue(
        int index, com.dj.protobuf.manufacture.ManufactureState value) {
      if (makingQueueBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureMakingQueueIsMutable();
        makingQueue_.set(index, value);
        onChanged();
      } else {
        makingQueueBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .Protocols.ManufactureState makingQueue = 1;</code>
     */
    public Builder setMakingQueue(
        int index, com.dj.protobuf.manufacture.ManufactureState.Builder builderForValue) {
      if (makingQueueBuilder_ == null) {
        ensureMakingQueueIsMutable();
        makingQueue_.set(index, builderForValue.build());
        onChanged();
      } else {
        makingQueueBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .Protocols.ManufactureState makingQueue = 1;</code>
     */
    public Builder addMakingQueue(com.dj.protobuf.manufacture.ManufactureState value) {
      if (makingQueueBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureMakingQueueIsMutable();
        makingQueue_.add(value);
        onChanged();
      } else {
        makingQueueBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .Protocols.ManufactureState makingQueue = 1;</code>
     */
    public Builder addMakingQueue(
        int index, com.dj.protobuf.manufacture.ManufactureState value) {
      if (makingQueueBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureMakingQueueIsMutable();
        makingQueue_.add(index, value);
        onChanged();
      } else {
        makingQueueBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .Protocols.ManufactureState makingQueue = 1;</code>
     */
    public Builder addMakingQueue(
        com.dj.protobuf.manufacture.ManufactureState.Builder builderForValue) {
      if (makingQueueBuilder_ == null) {
        ensureMakingQueueIsMutable();
        makingQueue_.add(builderForValue.build());
        onChanged();
      } else {
        makingQueueBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .Protocols.ManufactureState makingQueue = 1;</code>
     */
    public Builder addMakingQueue(
        int index, com.dj.protobuf.manufacture.ManufactureState.Builder builderForValue) {
      if (makingQueueBuilder_ == null) {
        ensureMakingQueueIsMutable();
        makingQueue_.add(index, builderForValue.build());
        onChanged();
      } else {
        makingQueueBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .Protocols.ManufactureState makingQueue = 1;</code>
     */
    public Builder addAllMakingQueue(
        java.lang.Iterable<? extends com.dj.protobuf.manufacture.ManufactureState> values) {
      if (makingQueueBuilder_ == null) {
        ensureMakingQueueIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, makingQueue_);
        onChanged();
      } else {
        makingQueueBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .Protocols.ManufactureState makingQueue = 1;</code>
     */
    public Builder clearMakingQueue() {
      if (makingQueueBuilder_ == null) {
        makingQueue_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
      } else {
        makingQueueBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .Protocols.ManufactureState makingQueue = 1;</code>
     */
    public Builder removeMakingQueue(int index) {
      if (makingQueueBuilder_ == null) {
        ensureMakingQueueIsMutable();
        makingQueue_.remove(index);
        onChanged();
      } else {
        makingQueueBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .Protocols.ManufactureState makingQueue = 1;</code>
     */
    public com.dj.protobuf.manufacture.ManufactureState.Builder getMakingQueueBuilder(
        int index) {
      return getMakingQueueFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .Protocols.ManufactureState makingQueue = 1;</code>
     */
    public com.dj.protobuf.manufacture.ManufactureStateOrBuilder getMakingQueueOrBuilder(
        int index) {
      if (makingQueueBuilder_ == null) {
        return makingQueue_.get(index);  } else {
        return makingQueueBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .Protocols.ManufactureState makingQueue = 1;</code>
     */
    public java.util.List<? extends com.dj.protobuf.manufacture.ManufactureStateOrBuilder> 
         getMakingQueueOrBuilderList() {
      if (makingQueueBuilder_ != null) {
        return makingQueueBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(makingQueue_);
      }
    }
    /**
     * <code>repeated .Protocols.ManufactureState makingQueue = 1;</code>
     */
    public com.dj.protobuf.manufacture.ManufactureState.Builder addMakingQueueBuilder() {
      return getMakingQueueFieldBuilder().addBuilder(
          com.dj.protobuf.manufacture.ManufactureState.getDefaultInstance());
    }
    /**
     * <code>repeated .Protocols.ManufactureState makingQueue = 1;</code>
     */
    public com.dj.protobuf.manufacture.ManufactureState.Builder addMakingQueueBuilder(
        int index) {
      return getMakingQueueFieldBuilder().addBuilder(
          index, com.dj.protobuf.manufacture.ManufactureState.getDefaultInstance());
    }
    /**
     * <code>repeated .Protocols.ManufactureState makingQueue = 1;</code>
     */
    public java.util.List<com.dj.protobuf.manufacture.ManufactureState.Builder> 
         getMakingQueueBuilderList() {
      return getMakingQueueFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        com.dj.protobuf.manufacture.ManufactureState, com.dj.protobuf.manufacture.ManufactureState.Builder, com.dj.protobuf.manufacture.ManufactureStateOrBuilder> 
        getMakingQueueFieldBuilder() {
      if (makingQueueBuilder_ == null) {
        makingQueueBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            com.dj.protobuf.manufacture.ManufactureState, com.dj.protobuf.manufacture.ManufactureState.Builder, com.dj.protobuf.manufacture.ManufactureStateOrBuilder>(
                makingQueue_,
                ((bitField0_ & 0x00000001) == 0x00000001),
                getParentForChildren(),
                isClean());
        makingQueue_ = null;
      }
      return makingQueueBuilder_;
    }

    private com.dj.protobuf.datetime.DateTime startTime_ = null;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.dj.protobuf.datetime.DateTime, com.dj.protobuf.datetime.DateTime.Builder, com.dj.protobuf.datetime.DateTimeOrBuilder> startTimeBuilder_;
    /**
     * <code>optional .Protocols.DateTime startTime = 2;</code>
     */
    public boolean hasStartTime() {
      return ((bitField0_ & 0x00000002) == 0x00000002);
    }
    /**
     * <code>optional .Protocols.DateTime startTime = 2;</code>
     */
    public com.dj.protobuf.datetime.DateTime getStartTime() {
      if (startTimeBuilder_ == null) {
        return startTime_ == null ? com.dj.protobuf.datetime.DateTime.getDefaultInstance() : startTime_;
      } else {
        return startTimeBuilder_.getMessage();
      }
    }
    /**
     * <code>optional .Protocols.DateTime startTime = 2;</code>
     */
    public Builder setStartTime(com.dj.protobuf.datetime.DateTime value) {
      if (startTimeBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        startTime_ = value;
        onChanged();
      } else {
        startTimeBuilder_.setMessage(value);
      }
      bitField0_ |= 0x00000002;
      return this;
    }
    /**
     * <code>optional .Protocols.DateTime startTime = 2;</code>
     */
    public Builder setStartTime(
        com.dj.protobuf.datetime.DateTime.Builder builderForValue) {
      if (startTimeBuilder_ == null) {
        startTime_ = builderForValue.build();
        onChanged();
      } else {
        startTimeBuilder_.setMessage(builderForValue.build());
      }
      bitField0_ |= 0x00000002;
      return this;
    }
    /**
     * <code>optional .Protocols.DateTime startTime = 2;</code>
     */
    public Builder mergeStartTime(com.dj.protobuf.datetime.DateTime value) {
      if (startTimeBuilder_ == null) {
        if (((bitField0_ & 0x00000002) == 0x00000002) &&
            startTime_ != null &&
            startTime_ != com.dj.protobuf.datetime.DateTime.getDefaultInstance()) {
          startTime_ =
            com.dj.protobuf.datetime.DateTime.newBuilder(startTime_).mergeFrom(value).buildPartial();
        } else {
          startTime_ = value;
        }
        onChanged();
      } else {
        startTimeBuilder_.mergeFrom(value);
      }
      bitField0_ |= 0x00000002;
      return this;
    }
    /**
     * <code>optional .Protocols.DateTime startTime = 2;</code>
     */
    public Builder clearStartTime() {
      if (startTimeBuilder_ == null) {
        startTime_ = null;
        onChanged();
      } else {
        startTimeBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000002);
      return this;
    }
    /**
     * <code>optional .Protocols.DateTime startTime = 2;</code>
     */
    public com.dj.protobuf.datetime.DateTime.Builder getStartTimeBuilder() {
      bitField0_ |= 0x00000002;
      onChanged();
      return getStartTimeFieldBuilder().getBuilder();
    }
    /**
     * <code>optional .Protocols.DateTime startTime = 2;</code>
     */
    public com.dj.protobuf.datetime.DateTimeOrBuilder getStartTimeOrBuilder() {
      if (startTimeBuilder_ != null) {
        return startTimeBuilder_.getMessageOrBuilder();
      } else {
        return startTime_ == null ?
            com.dj.protobuf.datetime.DateTime.getDefaultInstance() : startTime_;
      }
    }
    /**
     * <code>optional .Protocols.DateTime startTime = 2;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.dj.protobuf.datetime.DateTime, com.dj.protobuf.datetime.DateTime.Builder, com.dj.protobuf.datetime.DateTimeOrBuilder> 
        getStartTimeFieldBuilder() {
      if (startTimeBuilder_ == null) {
        startTimeBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.dj.protobuf.datetime.DateTime, com.dj.protobuf.datetime.DateTime.Builder, com.dj.protobuf.datetime.DateTimeOrBuilder>(
                getStartTime(),
                getParentForChildren(),
                isClean());
        startTime_ = null;
      }
      return startTimeBuilder_;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:Protocols.ManufactureInfo)
  }

  // @@protoc_insertion_point(class_scope:Protocols.ManufactureInfo)
  private static final com.dj.protobuf.manufacture.ManufactureInfo DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.dj.protobuf.manufacture.ManufactureInfo();
  }

  public static com.dj.protobuf.manufacture.ManufactureInfo getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  @java.lang.Deprecated public static final com.google.protobuf.Parser<ManufactureInfo>
      PARSER = new com.google.protobuf.AbstractParser<ManufactureInfo>() {
    public ManufactureInfo parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new ManufactureInfo(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<ManufactureInfo> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<ManufactureInfo> getParserForType() {
    return PARSER;
  }

  public com.dj.protobuf.manufacture.ManufactureInfo getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
