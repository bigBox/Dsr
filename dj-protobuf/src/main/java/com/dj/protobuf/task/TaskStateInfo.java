// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Task.proto

package com.dj.protobuf.task;

/**
 * Protobuf type {@code Protocols.TaskStateInfo}
 */
public  final class TaskStateInfo extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:Protocols.TaskStateInfo)
    TaskStateInfoOrBuilder {
  // Use TaskStateInfo.newBuilder() to construct.
  private TaskStateInfo(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private TaskStateInfo() {
    id_ = 0L;
    index_ = 0;
    taskId_ = 0;
    state_ = 0;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private TaskStateInfo(
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
            id_ = input.readInt64();
            break;
          }
          case 16: {
            bitField0_ |= 0x00000002;
            index_ = input.readInt32();
            break;
          }
          case 24: {
            bitField0_ |= 0x00000004;
            taskId_ = input.readInt32();
            break;
          }
          case 64: {
            bitField0_ |= 0x00000008;
            state_ = input.readInt32();
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
    return com.dj.protobuf.task.Task.internal_static_Protocols_TaskStateInfo_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.dj.protobuf.task.Task.internal_static_Protocols_TaskStateInfo_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.dj.protobuf.task.TaskStateInfo.class, com.dj.protobuf.task.TaskStateInfo.Builder.class);
  }

  private int bitField0_;
  public static final int ID_FIELD_NUMBER = 1;
  private long id_;
  /**
   * <pre>
   * 任务表id
   * </pre>
   *
   * <code>optional int64 id = 1;</code>
   */
  public boolean hasId() {
    return ((bitField0_ & 0x00000001) == 0x00000001);
  }
  /**
   * <pre>
   * 任务表id
   * </pre>
   *
   * <code>optional int64 id = 1;</code>
   */
  public long getId() {
    return id_;
  }

  public static final int INDEX_FIELD_NUMBER = 2;
  private int index_;
  /**
   * <pre>
   * 任务索引
   * </pre>
   *
   * <code>optional int32 index = 2;</code>
   */
  public boolean hasIndex() {
    return ((bitField0_ & 0x00000002) == 0x00000002);
  }
  /**
   * <pre>
   * 任务索引
   * </pre>
   *
   * <code>optional int32 index = 2;</code>
   */
  public int getIndex() {
    return index_;
  }

  public static final int TASKID_FIELD_NUMBER = 3;
  private int taskId_;
  /**
   * <pre>
   * 任务id
   * </pre>
   *
   * <code>optional int32 taskId = 3;</code>
   */
  public boolean hasTaskId() {
    return ((bitField0_ & 0x00000004) == 0x00000004);
  }
  /**
   * <pre>
   * 任务id
   * </pre>
   *
   * <code>optional int32 taskId = 3;</code>
   */
  public int getTaskId() {
    return taskId_;
  }

  public static final int STATE_FIELD_NUMBER = 8;
  private int state_;
  /**
   * <pre>
   *状态， 0未接受，1已接受 2 已完成 3已领取
   * </pre>
   *
   * <code>optional int32 state = 8;</code>
   */
  public boolean hasState() {
    return ((bitField0_ & 0x00000008) == 0x00000008);
  }
  /**
   * <pre>
   *状态， 0未接受，1已接受 2 已完成 3已领取
   * </pre>
   *
   * <code>optional int32 state = 8;</code>
   */
  public int getState() {
    return state_;
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
      output.writeInt64(1, id_);
    }
    if (((bitField0_ & 0x00000002) == 0x00000002)) {
      output.writeInt32(2, index_);
    }
    if (((bitField0_ & 0x00000004) == 0x00000004)) {
      output.writeInt32(3, taskId_);
    }
    if (((bitField0_ & 0x00000008) == 0x00000008)) {
      output.writeInt32(8, state_);
    }
    unknownFields.writeTo(output);
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (((bitField0_ & 0x00000001) == 0x00000001)) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(1, id_);
    }
    if (((bitField0_ & 0x00000002) == 0x00000002)) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(2, index_);
    }
    if (((bitField0_ & 0x00000004) == 0x00000004)) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(3, taskId_);
    }
    if (((bitField0_ & 0x00000008) == 0x00000008)) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(8, state_);
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
    if (!(obj instanceof com.dj.protobuf.task.TaskStateInfo)) {
      return super.equals(obj);
    }
    com.dj.protobuf.task.TaskStateInfo other = (com.dj.protobuf.task.TaskStateInfo) obj;

    boolean result = true;
    result = result && (hasId() == other.hasId());
    if (hasId()) {
      result = result && (getId()
          == other.getId());
    }
    result = result && (hasIndex() == other.hasIndex());
    if (hasIndex()) {
      result = result && (getIndex()
          == other.getIndex());
    }
    result = result && (hasTaskId() == other.hasTaskId());
    if (hasTaskId()) {
      result = result && (getTaskId()
          == other.getTaskId());
    }
    result = result && (hasState() == other.hasState());
    if (hasState()) {
      result = result && (getState()
          == other.getState());
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
    if (hasId()) {
      hash = (37 * hash) + ID_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
          getId());
    }
    if (hasIndex()) {
      hash = (37 * hash) + INDEX_FIELD_NUMBER;
      hash = (53 * hash) + getIndex();
    }
    if (hasTaskId()) {
      hash = (37 * hash) + TASKID_FIELD_NUMBER;
      hash = (53 * hash) + getTaskId();
    }
    if (hasState()) {
      hash = (37 * hash) + STATE_FIELD_NUMBER;
      hash = (53 * hash) + getState();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.dj.protobuf.task.TaskStateInfo parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dj.protobuf.task.TaskStateInfo parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dj.protobuf.task.TaskStateInfo parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dj.protobuf.task.TaskStateInfo parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dj.protobuf.task.TaskStateInfo parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.task.TaskStateInfo parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.dj.protobuf.task.TaskStateInfo parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.task.TaskStateInfo parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.dj.protobuf.task.TaskStateInfo parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.task.TaskStateInfo parseFrom(
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
  public static Builder newBuilder(com.dj.protobuf.task.TaskStateInfo prototype) {
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
   * Protobuf type {@code Protocols.TaskStateInfo}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:Protocols.TaskStateInfo)
      com.dj.protobuf.task.TaskStateInfoOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.dj.protobuf.task.Task.internal_static_Protocols_TaskStateInfo_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.dj.protobuf.task.Task.internal_static_Protocols_TaskStateInfo_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.dj.protobuf.task.TaskStateInfo.class, com.dj.protobuf.task.TaskStateInfo.Builder.class);
    }

    // Construct using com.dj.protobuf.task.TaskStateInfo.newBuilder()
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
      id_ = 0L;
      bitField0_ = (bitField0_ & ~0x00000001);
      index_ = 0;
      bitField0_ = (bitField0_ & ~0x00000002);
      taskId_ = 0;
      bitField0_ = (bitField0_ & ~0x00000004);
      state_ = 0;
      bitField0_ = (bitField0_ & ~0x00000008);
      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.dj.protobuf.task.Task.internal_static_Protocols_TaskStateInfo_descriptor;
    }

    public com.dj.protobuf.task.TaskStateInfo getDefaultInstanceForType() {
      return com.dj.protobuf.task.TaskStateInfo.getDefaultInstance();
    }

    public com.dj.protobuf.task.TaskStateInfo build() {
      com.dj.protobuf.task.TaskStateInfo result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public com.dj.protobuf.task.TaskStateInfo buildPartial() {
      com.dj.protobuf.task.TaskStateInfo result = new com.dj.protobuf.task.TaskStateInfo(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
        to_bitField0_ |= 0x00000001;
      }
      result.id_ = id_;
      if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
        to_bitField0_ |= 0x00000002;
      }
      result.index_ = index_;
      if (((from_bitField0_ & 0x00000004) == 0x00000004)) {
        to_bitField0_ |= 0x00000004;
      }
      result.taskId_ = taskId_;
      if (((from_bitField0_ & 0x00000008) == 0x00000008)) {
        to_bitField0_ |= 0x00000008;
      }
      result.state_ = state_;
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
      if (other instanceof com.dj.protobuf.task.TaskStateInfo) {
        return mergeFrom((com.dj.protobuf.task.TaskStateInfo)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.dj.protobuf.task.TaskStateInfo other) {
      if (other == com.dj.protobuf.task.TaskStateInfo.getDefaultInstance()) return this;
      if (other.hasId()) {
        setId(other.getId());
      }
      if (other.hasIndex()) {
        setIndex(other.getIndex());
      }
      if (other.hasTaskId()) {
        setTaskId(other.getTaskId());
      }
      if (other.hasState()) {
        setState(other.getState());
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
      com.dj.protobuf.task.TaskStateInfo parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.dj.protobuf.task.TaskStateInfo) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private long id_ ;
    /**
     * <pre>
     * 任务表id
     * </pre>
     *
     * <code>optional int64 id = 1;</code>
     */
    public boolean hasId() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <pre>
     * 任务表id
     * </pre>
     *
     * <code>optional int64 id = 1;</code>
     */
    public long getId() {
      return id_;
    }
    /**
     * <pre>
     * 任务表id
     * </pre>
     *
     * <code>optional int64 id = 1;</code>
     */
    public Builder setId(long value) {
      bitField0_ |= 0x00000001;
      id_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * 任务表id
     * </pre>
     *
     * <code>optional int64 id = 1;</code>
     */
    public Builder clearId() {
      bitField0_ = (bitField0_ & ~0x00000001);
      id_ = 0L;
      onChanged();
      return this;
    }

    private int index_ ;
    /**
     * <pre>
     * 任务索引
     * </pre>
     *
     * <code>optional int32 index = 2;</code>
     */
    public boolean hasIndex() {
      return ((bitField0_ & 0x00000002) == 0x00000002);
    }
    /**
     * <pre>
     * 任务索引
     * </pre>
     *
     * <code>optional int32 index = 2;</code>
     */
    public int getIndex() {
      return index_;
    }
    /**
     * <pre>
     * 任务索引
     * </pre>
     *
     * <code>optional int32 index = 2;</code>
     */
    public Builder setIndex(int value) {
      bitField0_ |= 0x00000002;
      index_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * 任务索引
     * </pre>
     *
     * <code>optional int32 index = 2;</code>
     */
    public Builder clearIndex() {
      bitField0_ = (bitField0_ & ~0x00000002);
      index_ = 0;
      onChanged();
      return this;
    }

    private int taskId_ ;
    /**
     * <pre>
     * 任务id
     * </pre>
     *
     * <code>optional int32 taskId = 3;</code>
     */
    public boolean hasTaskId() {
      return ((bitField0_ & 0x00000004) == 0x00000004);
    }
    /**
     * <pre>
     * 任务id
     * </pre>
     *
     * <code>optional int32 taskId = 3;</code>
     */
    public int getTaskId() {
      return taskId_;
    }
    /**
     * <pre>
     * 任务id
     * </pre>
     *
     * <code>optional int32 taskId = 3;</code>
     */
    public Builder setTaskId(int value) {
      bitField0_ |= 0x00000004;
      taskId_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * 任务id
     * </pre>
     *
     * <code>optional int32 taskId = 3;</code>
     */
    public Builder clearTaskId() {
      bitField0_ = (bitField0_ & ~0x00000004);
      taskId_ = 0;
      onChanged();
      return this;
    }

    private int state_ ;
    /**
     * <pre>
     *状态， 0未接受，1已接受 2 已完成 3已领取
     * </pre>
     *
     * <code>optional int32 state = 8;</code>
     */
    public boolean hasState() {
      return ((bitField0_ & 0x00000008) == 0x00000008);
    }
    /**
     * <pre>
     *状态， 0未接受，1已接受 2 已完成 3已领取
     * </pre>
     *
     * <code>optional int32 state = 8;</code>
     */
    public int getState() {
      return state_;
    }
    /**
     * <pre>
     *状态， 0未接受，1已接受 2 已完成 3已领取
     * </pre>
     *
     * <code>optional int32 state = 8;</code>
     */
    public Builder setState(int value) {
      bitField0_ |= 0x00000008;
      state_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     *状态， 0未接受，1已接受 2 已完成 3已领取
     * </pre>
     *
     * <code>optional int32 state = 8;</code>
     */
    public Builder clearState() {
      bitField0_ = (bitField0_ & ~0x00000008);
      state_ = 0;
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


    // @@protoc_insertion_point(builder_scope:Protocols.TaskStateInfo)
  }

  // @@protoc_insertion_point(class_scope:Protocols.TaskStateInfo)
  private static final com.dj.protobuf.task.TaskStateInfo DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.dj.protobuf.task.TaskStateInfo();
  }

  public static com.dj.protobuf.task.TaskStateInfo getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  @java.lang.Deprecated public static final com.google.protobuf.Parser<TaskStateInfo>
      PARSER = new com.google.protobuf.AbstractParser<TaskStateInfo>() {
    public TaskStateInfo parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new TaskStateInfo(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<TaskStateInfo> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<TaskStateInfo> getParserForType() {
    return PARSER;
  }

  public com.dj.protobuf.task.TaskStateInfo getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

