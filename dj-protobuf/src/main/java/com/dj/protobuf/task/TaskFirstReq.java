// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Task.proto

package com.dj.protobuf.task;

/**
 * <pre>
 *&#47; &lt;summary&gt;
 * / 首次打开任务
 * / &lt;/summary&gt;
 * </pre>
 *
 * Protobuf type {@code Protocols.TaskFirstReq}
 */
public  final class TaskFirstReq extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:Protocols.TaskFirstReq)
    TaskFirstReqOrBuilder {
  // Use TaskFirstReq.newBuilder() to construct.
  private TaskFirstReq(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private TaskFirstReq() {
    taskId_ = 0;
    type_ = 1;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private TaskFirstReq(
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
            taskId_ = input.readInt32();
            break;
          }
          case 16: {
            int rawValue = input.readEnum();
            com.dj.protobuf.task.ETaskType value = com.dj.protobuf.task.ETaskType.valueOf(rawValue);
            if (value == null) {
              unknownFields.mergeVarintField(2, rawValue);
            } else {
              bitField0_ |= 0x00000002;
              type_ = rawValue;
            }
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
    return com.dj.protobuf.task.Task.internal_static_Protocols_TaskFirstReq_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.dj.protobuf.task.Task.internal_static_Protocols_TaskFirstReq_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.dj.protobuf.task.TaskFirstReq.class, com.dj.protobuf.task.TaskFirstReq.Builder.class);
  }

  private int bitField0_;
  public static final int TASKID_FIELD_NUMBER = 1;
  private int taskId_;
  /**
   * <pre>
   * 任务索引
   * </pre>
   *
   * <code>optional int32 taskId = 1;</code>
   */
  public boolean hasTaskId() {
    return ((bitField0_ & 0x00000001) == 0x00000001);
  }
  /**
   * <pre>
   * 任务索引
   * </pre>
   *
   * <code>optional int32 taskId = 1;</code>
   */
  public int getTaskId() {
    return taskId_;
  }

  public static final int TYPE_FIELD_NUMBER = 2;
  private int type_;
  /**
   * <code>optional .Protocols.ETaskType type = 2;</code>
   */
  public boolean hasType() {
    return ((bitField0_ & 0x00000002) == 0x00000002);
  }
  /**
   * <code>optional .Protocols.ETaskType type = 2;</code>
   */
  public com.dj.protobuf.task.ETaskType getType() {
    com.dj.protobuf.task.ETaskType result = com.dj.protobuf.task.ETaskType.valueOf(type_);
    return result == null ? com.dj.protobuf.task.ETaskType.GrowUp : result;
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
      output.writeInt32(1, taskId_);
    }
    if (((bitField0_ & 0x00000002) == 0x00000002)) {
      output.writeEnum(2, type_);
    }
    unknownFields.writeTo(output);
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (((bitField0_ & 0x00000001) == 0x00000001)) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(1, taskId_);
    }
    if (((bitField0_ & 0x00000002) == 0x00000002)) {
      size += com.google.protobuf.CodedOutputStream
        .computeEnumSize(2, type_);
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
    if (!(obj instanceof com.dj.protobuf.task.TaskFirstReq)) {
      return super.equals(obj);
    }
    com.dj.protobuf.task.TaskFirstReq other = (com.dj.protobuf.task.TaskFirstReq) obj;

    boolean result = true;
    result = result && (hasTaskId() == other.hasTaskId());
    if (hasTaskId()) {
      result = result && (getTaskId()
          == other.getTaskId());
    }
    result = result && (hasType() == other.hasType());
    if (hasType()) {
      result = result && type_ == other.type_;
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
    if (hasTaskId()) {
      hash = (37 * hash) + TASKID_FIELD_NUMBER;
      hash = (53 * hash) + getTaskId();
    }
    if (hasType()) {
      hash = (37 * hash) + TYPE_FIELD_NUMBER;
      hash = (53 * hash) + type_;
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.dj.protobuf.task.TaskFirstReq parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dj.protobuf.task.TaskFirstReq parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dj.protobuf.task.TaskFirstReq parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dj.protobuf.task.TaskFirstReq parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dj.protobuf.task.TaskFirstReq parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.task.TaskFirstReq parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.dj.protobuf.task.TaskFirstReq parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.task.TaskFirstReq parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.dj.protobuf.task.TaskFirstReq parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.task.TaskFirstReq parseFrom(
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
  public static Builder newBuilder(com.dj.protobuf.task.TaskFirstReq prototype) {
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
   * / 首次打开任务
   * / &lt;/summary&gt;
   * </pre>
   *
   * Protobuf type {@code Protocols.TaskFirstReq}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:Protocols.TaskFirstReq)
      com.dj.protobuf.task.TaskFirstReqOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.dj.protobuf.task.Task.internal_static_Protocols_TaskFirstReq_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.dj.protobuf.task.Task.internal_static_Protocols_TaskFirstReq_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.dj.protobuf.task.TaskFirstReq.class, com.dj.protobuf.task.TaskFirstReq.Builder.class);
    }

    // Construct using com.dj.protobuf.task.TaskFirstReq.newBuilder()
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
      taskId_ = 0;
      bitField0_ = (bitField0_ & ~0x00000001);
      type_ = 1;
      bitField0_ = (bitField0_ & ~0x00000002);
      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.dj.protobuf.task.Task.internal_static_Protocols_TaskFirstReq_descriptor;
    }

    public com.dj.protobuf.task.TaskFirstReq getDefaultInstanceForType() {
      return com.dj.protobuf.task.TaskFirstReq.getDefaultInstance();
    }

    public com.dj.protobuf.task.TaskFirstReq build() {
      com.dj.protobuf.task.TaskFirstReq result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public com.dj.protobuf.task.TaskFirstReq buildPartial() {
      com.dj.protobuf.task.TaskFirstReq result = new com.dj.protobuf.task.TaskFirstReq(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
        to_bitField0_ |= 0x00000001;
      }
      result.taskId_ = taskId_;
      if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
        to_bitField0_ |= 0x00000002;
      }
      result.type_ = type_;
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
      if (other instanceof com.dj.protobuf.task.TaskFirstReq) {
        return mergeFrom((com.dj.protobuf.task.TaskFirstReq)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.dj.protobuf.task.TaskFirstReq other) {
      if (other == com.dj.protobuf.task.TaskFirstReq.getDefaultInstance()) return this;
      if (other.hasTaskId()) {
        setTaskId(other.getTaskId());
      }
      if (other.hasType()) {
        setType(other.getType());
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
      com.dj.protobuf.task.TaskFirstReq parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.dj.protobuf.task.TaskFirstReq) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private int taskId_ ;
    /**
     * <pre>
     * 任务索引
     * </pre>
     *
     * <code>optional int32 taskId = 1;</code>
     */
    public boolean hasTaskId() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <pre>
     * 任务索引
     * </pre>
     *
     * <code>optional int32 taskId = 1;</code>
     */
    public int getTaskId() {
      return taskId_;
    }
    /**
     * <pre>
     * 任务索引
     * </pre>
     *
     * <code>optional int32 taskId = 1;</code>
     */
    public Builder setTaskId(int value) {
      bitField0_ |= 0x00000001;
      taskId_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * 任务索引
     * </pre>
     *
     * <code>optional int32 taskId = 1;</code>
     */
    public Builder clearTaskId() {
      bitField0_ = (bitField0_ & ~0x00000001);
      taskId_ = 0;
      onChanged();
      return this;
    }

    private int type_ = 1;
    /**
     * <code>optional .Protocols.ETaskType type = 2;</code>
     */
    public boolean hasType() {
      return ((bitField0_ & 0x00000002) == 0x00000002);
    }
    /**
     * <code>optional .Protocols.ETaskType type = 2;</code>
     */
    public com.dj.protobuf.task.ETaskType getType() {
      com.dj.protobuf.task.ETaskType result = com.dj.protobuf.task.ETaskType.valueOf(type_);
      return result == null ? com.dj.protobuf.task.ETaskType.GrowUp : result;
    }
    /**
     * <code>optional .Protocols.ETaskType type = 2;</code>
     */
    public Builder setType(com.dj.protobuf.task.ETaskType value) {
      if (value == null) {
        throw new NullPointerException();
      }
      bitField0_ |= 0x00000002;
      type_ = value.getNumber();
      onChanged();
      return this;
    }
    /**
     * <code>optional .Protocols.ETaskType type = 2;</code>
     */
    public Builder clearType() {
      bitField0_ = (bitField0_ & ~0x00000002);
      type_ = 1;
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


    // @@protoc_insertion_point(builder_scope:Protocols.TaskFirstReq)
  }

  // @@protoc_insertion_point(class_scope:Protocols.TaskFirstReq)
  private static final com.dj.protobuf.task.TaskFirstReq DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.dj.protobuf.task.TaskFirstReq();
  }

  public static com.dj.protobuf.task.TaskFirstReq getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  @java.lang.Deprecated public static final com.google.protobuf.Parser<TaskFirstReq>
      PARSER = new com.google.protobuf.AbstractParser<TaskFirstReq>() {
    public TaskFirstReq parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new TaskFirstReq(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<TaskFirstReq> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<TaskFirstReq> getParserForType() {
    return PARSER;
  }

  public com.dj.protobuf.task.TaskFirstReq getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

