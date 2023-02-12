// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Guild.proto

package com.dj.protobuf.guild;

/**
 * <pre>
 *&#47; &lt;summary&gt;
 * / 公会申请信息
 * / &lt;/summary&gt;
 * </pre>
 *
 * Protobuf type {@code Protocols.GuildApplyInfo}
 */
public  final class GuildApplyInfo extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:Protocols.GuildApplyInfo)
    GuildApplyInfoOrBuilder {
  // Use GuildApplyInfo.newBuilder() to construct.
  private GuildApplyInfo(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private GuildApplyInfo() {
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private GuildApplyInfo(
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
            com.dj.protobuf.guild.GuildBaseInfo.Builder subBuilder = null;
            if (((bitField0_ & 0x00000001) == 0x00000001)) {
              subBuilder = guildInfo_.toBuilder();
            }
            guildInfo_ = input.readMessage(com.dj.protobuf.guild.GuildBaseInfo.PARSER, extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(guildInfo_);
              guildInfo_ = subBuilder.buildPartial();
            }
            bitField0_ |= 0x00000001;
            break;
          }
          case 18: {
            com.dj.protobuf.common.BaseRoleInfo.Builder subBuilder = null;
            if (((bitField0_ & 0x00000002) == 0x00000002)) {
              subBuilder = baseInfo_.toBuilder();
            }
            baseInfo_ = input.readMessage(com.dj.protobuf.common.BaseRoleInfo.PARSER, extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(baseInfo_);
              baseInfo_ = subBuilder.buildPartial();
            }
            bitField0_ |= 0x00000002;
            break;
          }
          case 26: {
            com.dj.protobuf.datetime.DateTime.Builder subBuilder = null;
            if (((bitField0_ & 0x00000004) == 0x00000004)) {
              subBuilder = applyTime_.toBuilder();
            }
            applyTime_ = input.readMessage(com.dj.protobuf.datetime.DateTime.PARSER, extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(applyTime_);
              applyTime_ = subBuilder.buildPartial();
            }
            bitField0_ |= 0x00000004;
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
    return com.dj.protobuf.guild.Guild.internal_static_Protocols_GuildApplyInfo_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.dj.protobuf.guild.Guild.internal_static_Protocols_GuildApplyInfo_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.dj.protobuf.guild.GuildApplyInfo.class, com.dj.protobuf.guild.GuildApplyInfo.Builder.class);
  }

  private int bitField0_;
  public static final int GUILDINFO_FIELD_NUMBER = 1;
  private com.dj.protobuf.guild.GuildBaseInfo guildInfo_;
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 申请公会基本信息
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional .Protocols.GuildBaseInfo guildInfo = 1;</code>
   */
  public boolean hasGuildInfo() {
    return ((bitField0_ & 0x00000001) == 0x00000001);
  }
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 申请公会基本信息
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional .Protocols.GuildBaseInfo guildInfo = 1;</code>
   */
  public com.dj.protobuf.guild.GuildBaseInfo getGuildInfo() {
    return guildInfo_ == null ? com.dj.protobuf.guild.GuildBaseInfo.getDefaultInstance() : guildInfo_;
  }
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 申请公会基本信息
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional .Protocols.GuildBaseInfo guildInfo = 1;</code>
   */
  public com.dj.protobuf.guild.GuildBaseInfoOrBuilder getGuildInfoOrBuilder() {
    return guildInfo_ == null ? com.dj.protobuf.guild.GuildBaseInfo.getDefaultInstance() : guildInfo_;
  }

  public static final int BASEINFO_FIELD_NUMBER = 2;
  private com.dj.protobuf.common.BaseRoleInfo baseInfo_;
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 申请者基本信息
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional .Protocols.BaseRoleInfo baseInfo = 2;</code>
   */
  public boolean hasBaseInfo() {
    return ((bitField0_ & 0x00000002) == 0x00000002);
  }
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 申请者基本信息
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional .Protocols.BaseRoleInfo baseInfo = 2;</code>
   */
  public com.dj.protobuf.common.BaseRoleInfo getBaseInfo() {
    return baseInfo_ == null ? com.dj.protobuf.common.BaseRoleInfo.getDefaultInstance() : baseInfo_;
  }
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 申请者基本信息
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional .Protocols.BaseRoleInfo baseInfo = 2;</code>
   */
  public com.dj.protobuf.common.BaseRoleInfoOrBuilder getBaseInfoOrBuilder() {
    return baseInfo_ == null ? com.dj.protobuf.common.BaseRoleInfo.getDefaultInstance() : baseInfo_;
  }

  public static final int APPLYTIME_FIELD_NUMBER = 3;
  private com.dj.protobuf.datetime.DateTime applyTime_;
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 申请时间
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional .Protocols.DateTime applyTime = 3;</code>
   */
  public boolean hasApplyTime() {
    return ((bitField0_ & 0x00000004) == 0x00000004);
  }
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 申请时间
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional .Protocols.DateTime applyTime = 3;</code>
   */
  public com.dj.protobuf.datetime.DateTime getApplyTime() {
    return applyTime_ == null ? com.dj.protobuf.datetime.DateTime.getDefaultInstance() : applyTime_;
  }
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 申请时间
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional .Protocols.DateTime applyTime = 3;</code>
   */
  public com.dj.protobuf.datetime.DateTimeOrBuilder getApplyTimeOrBuilder() {
    return applyTime_ == null ? com.dj.protobuf.datetime.DateTime.getDefaultInstance() : applyTime_;
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
      output.writeMessage(1, getGuildInfo());
    }
    if (((bitField0_ & 0x00000002) == 0x00000002)) {
      output.writeMessage(2, getBaseInfo());
    }
    if (((bitField0_ & 0x00000004) == 0x00000004)) {
      output.writeMessage(3, getApplyTime());
    }
    unknownFields.writeTo(output);
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (((bitField0_ & 0x00000001) == 0x00000001)) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, getGuildInfo());
    }
    if (((bitField0_ & 0x00000002) == 0x00000002)) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(2, getBaseInfo());
    }
    if (((bitField0_ & 0x00000004) == 0x00000004)) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(3, getApplyTime());
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
    if (!(obj instanceof com.dj.protobuf.guild.GuildApplyInfo)) {
      return super.equals(obj);
    }
    com.dj.protobuf.guild.GuildApplyInfo other = (com.dj.protobuf.guild.GuildApplyInfo) obj;

    boolean result = true;
    result = result && (hasGuildInfo() == other.hasGuildInfo());
    if (hasGuildInfo()) {
      result = result && getGuildInfo()
          .equals(other.getGuildInfo());
    }
    result = result && (hasBaseInfo() == other.hasBaseInfo());
    if (hasBaseInfo()) {
      result = result && getBaseInfo()
          .equals(other.getBaseInfo());
    }
    result = result && (hasApplyTime() == other.hasApplyTime());
    if (hasApplyTime()) {
      result = result && getApplyTime()
          .equals(other.getApplyTime());
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
    if (hasGuildInfo()) {
      hash = (37 * hash) + GUILDINFO_FIELD_NUMBER;
      hash = (53 * hash) + getGuildInfo().hashCode();
    }
    if (hasBaseInfo()) {
      hash = (37 * hash) + BASEINFO_FIELD_NUMBER;
      hash = (53 * hash) + getBaseInfo().hashCode();
    }
    if (hasApplyTime()) {
      hash = (37 * hash) + APPLYTIME_FIELD_NUMBER;
      hash = (53 * hash) + getApplyTime().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.dj.protobuf.guild.GuildApplyInfo parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dj.protobuf.guild.GuildApplyInfo parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dj.protobuf.guild.GuildApplyInfo parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dj.protobuf.guild.GuildApplyInfo parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dj.protobuf.guild.GuildApplyInfo parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.guild.GuildApplyInfo parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.dj.protobuf.guild.GuildApplyInfo parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.guild.GuildApplyInfo parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.dj.protobuf.guild.GuildApplyInfo parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.guild.GuildApplyInfo parseFrom(
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
  public static Builder newBuilder(com.dj.protobuf.guild.GuildApplyInfo prototype) {
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
   * / 公会申请信息
   * / &lt;/summary&gt;
   * </pre>
   *
   * Protobuf type {@code Protocols.GuildApplyInfo}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:Protocols.GuildApplyInfo)
      com.dj.protobuf.guild.GuildApplyInfoOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.dj.protobuf.guild.Guild.internal_static_Protocols_GuildApplyInfo_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.dj.protobuf.guild.Guild.internal_static_Protocols_GuildApplyInfo_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.dj.protobuf.guild.GuildApplyInfo.class, com.dj.protobuf.guild.GuildApplyInfo.Builder.class);
    }

    // Construct using com.dj.protobuf.guild.GuildApplyInfo.newBuilder()
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
        getGuildInfoFieldBuilder();
        getBaseInfoFieldBuilder();
        getApplyTimeFieldBuilder();
      }
    }
    public Builder clear() {
      super.clear();
      if (guildInfoBuilder_ == null) {
        guildInfo_ = null;
      } else {
        guildInfoBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000001);
      if (baseInfoBuilder_ == null) {
        baseInfo_ = null;
      } else {
        baseInfoBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000002);
      if (applyTimeBuilder_ == null) {
        applyTime_ = null;
      } else {
        applyTimeBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000004);
      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.dj.protobuf.guild.Guild.internal_static_Protocols_GuildApplyInfo_descriptor;
    }

    public com.dj.protobuf.guild.GuildApplyInfo getDefaultInstanceForType() {
      return com.dj.protobuf.guild.GuildApplyInfo.getDefaultInstance();
    }

    public com.dj.protobuf.guild.GuildApplyInfo build() {
      com.dj.protobuf.guild.GuildApplyInfo result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public com.dj.protobuf.guild.GuildApplyInfo buildPartial() {
      com.dj.protobuf.guild.GuildApplyInfo result = new com.dj.protobuf.guild.GuildApplyInfo(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
        to_bitField0_ |= 0x00000001;
      }
      if (guildInfoBuilder_ == null) {
        result.guildInfo_ = guildInfo_;
      } else {
        result.guildInfo_ = guildInfoBuilder_.build();
      }
      if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
        to_bitField0_ |= 0x00000002;
      }
      if (baseInfoBuilder_ == null) {
        result.baseInfo_ = baseInfo_;
      } else {
        result.baseInfo_ = baseInfoBuilder_.build();
      }
      if (((from_bitField0_ & 0x00000004) == 0x00000004)) {
        to_bitField0_ |= 0x00000004;
      }
      if (applyTimeBuilder_ == null) {
        result.applyTime_ = applyTime_;
      } else {
        result.applyTime_ = applyTimeBuilder_.build();
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
      if (other instanceof com.dj.protobuf.guild.GuildApplyInfo) {
        return mergeFrom((com.dj.protobuf.guild.GuildApplyInfo)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.dj.protobuf.guild.GuildApplyInfo other) {
      if (other == com.dj.protobuf.guild.GuildApplyInfo.getDefaultInstance()) return this;
      if (other.hasGuildInfo()) {
        mergeGuildInfo(other.getGuildInfo());
      }
      if (other.hasBaseInfo()) {
        mergeBaseInfo(other.getBaseInfo());
      }
      if (other.hasApplyTime()) {
        mergeApplyTime(other.getApplyTime());
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
      com.dj.protobuf.guild.GuildApplyInfo parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.dj.protobuf.guild.GuildApplyInfo) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private com.dj.protobuf.guild.GuildBaseInfo guildInfo_ = null;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.dj.protobuf.guild.GuildBaseInfo, com.dj.protobuf.guild.GuildBaseInfo.Builder, com.dj.protobuf.guild.GuildBaseInfoOrBuilder> guildInfoBuilder_;
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 申请公会基本信息
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional .Protocols.GuildBaseInfo guildInfo = 1;</code>
     */
    public boolean hasGuildInfo() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 申请公会基本信息
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional .Protocols.GuildBaseInfo guildInfo = 1;</code>
     */
    public com.dj.protobuf.guild.GuildBaseInfo getGuildInfo() {
      if (guildInfoBuilder_ == null) {
        return guildInfo_ == null ? com.dj.protobuf.guild.GuildBaseInfo.getDefaultInstance() : guildInfo_;
      } else {
        return guildInfoBuilder_.getMessage();
      }
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 申请公会基本信息
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional .Protocols.GuildBaseInfo guildInfo = 1;</code>
     */
    public Builder setGuildInfo(com.dj.protobuf.guild.GuildBaseInfo value) {
      if (guildInfoBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        guildInfo_ = value;
        onChanged();
      } else {
        guildInfoBuilder_.setMessage(value);
      }
      bitField0_ |= 0x00000001;
      return this;
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 申请公会基本信息
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional .Protocols.GuildBaseInfo guildInfo = 1;</code>
     */
    public Builder setGuildInfo(
        com.dj.protobuf.guild.GuildBaseInfo.Builder builderForValue) {
      if (guildInfoBuilder_ == null) {
        guildInfo_ = builderForValue.build();
        onChanged();
      } else {
        guildInfoBuilder_.setMessage(builderForValue.build());
      }
      bitField0_ |= 0x00000001;
      return this;
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 申请公会基本信息
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional .Protocols.GuildBaseInfo guildInfo = 1;</code>
     */
    public Builder mergeGuildInfo(com.dj.protobuf.guild.GuildBaseInfo value) {
      if (guildInfoBuilder_ == null) {
        if (((bitField0_ & 0x00000001) == 0x00000001) &&
            guildInfo_ != null &&
            guildInfo_ != com.dj.protobuf.guild.GuildBaseInfo.getDefaultInstance()) {
          guildInfo_ =
            com.dj.protobuf.guild.GuildBaseInfo.newBuilder(guildInfo_).mergeFrom(value).buildPartial();
        } else {
          guildInfo_ = value;
        }
        onChanged();
      } else {
        guildInfoBuilder_.mergeFrom(value);
      }
      bitField0_ |= 0x00000001;
      return this;
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 申请公会基本信息
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional .Protocols.GuildBaseInfo guildInfo = 1;</code>
     */
    public Builder clearGuildInfo() {
      if (guildInfoBuilder_ == null) {
        guildInfo_ = null;
        onChanged();
      } else {
        guildInfoBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000001);
      return this;
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 申请公会基本信息
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional .Protocols.GuildBaseInfo guildInfo = 1;</code>
     */
    public com.dj.protobuf.guild.GuildBaseInfo.Builder getGuildInfoBuilder() {
      bitField0_ |= 0x00000001;
      onChanged();
      return getGuildInfoFieldBuilder().getBuilder();
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 申请公会基本信息
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional .Protocols.GuildBaseInfo guildInfo = 1;</code>
     */
    public com.dj.protobuf.guild.GuildBaseInfoOrBuilder getGuildInfoOrBuilder() {
      if (guildInfoBuilder_ != null) {
        return guildInfoBuilder_.getMessageOrBuilder();
      } else {
        return guildInfo_ == null ?
            com.dj.protobuf.guild.GuildBaseInfo.getDefaultInstance() : guildInfo_;
      }
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 申请公会基本信息
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional .Protocols.GuildBaseInfo guildInfo = 1;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.dj.protobuf.guild.GuildBaseInfo, com.dj.protobuf.guild.GuildBaseInfo.Builder, com.dj.protobuf.guild.GuildBaseInfoOrBuilder> 
        getGuildInfoFieldBuilder() {
      if (guildInfoBuilder_ == null) {
        guildInfoBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.dj.protobuf.guild.GuildBaseInfo, com.dj.protobuf.guild.GuildBaseInfo.Builder, com.dj.protobuf.guild.GuildBaseInfoOrBuilder>(
                getGuildInfo(),
                getParentForChildren(),
                isClean());
        guildInfo_ = null;
      }
      return guildInfoBuilder_;
    }

    private com.dj.protobuf.common.BaseRoleInfo baseInfo_ = null;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.dj.protobuf.common.BaseRoleInfo, com.dj.protobuf.common.BaseRoleInfo.Builder, com.dj.protobuf.common.BaseRoleInfoOrBuilder> baseInfoBuilder_;
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 申请者基本信息
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional .Protocols.BaseRoleInfo baseInfo = 2;</code>
     */
    public boolean hasBaseInfo() {
      return ((bitField0_ & 0x00000002) == 0x00000002);
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 申请者基本信息
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional .Protocols.BaseRoleInfo baseInfo = 2;</code>
     */
    public com.dj.protobuf.common.BaseRoleInfo getBaseInfo() {
      if (baseInfoBuilder_ == null) {
        return baseInfo_ == null ? com.dj.protobuf.common.BaseRoleInfo.getDefaultInstance() : baseInfo_;
      } else {
        return baseInfoBuilder_.getMessage();
      }
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 申请者基本信息
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional .Protocols.BaseRoleInfo baseInfo = 2;</code>
     */
    public Builder setBaseInfo(com.dj.protobuf.common.BaseRoleInfo value) {
      if (baseInfoBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        baseInfo_ = value;
        onChanged();
      } else {
        baseInfoBuilder_.setMessage(value);
      }
      bitField0_ |= 0x00000002;
      return this;
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 申请者基本信息
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional .Protocols.BaseRoleInfo baseInfo = 2;</code>
     */
    public Builder setBaseInfo(
        com.dj.protobuf.common.BaseRoleInfo.Builder builderForValue) {
      if (baseInfoBuilder_ == null) {
        baseInfo_ = builderForValue.build();
        onChanged();
      } else {
        baseInfoBuilder_.setMessage(builderForValue.build());
      }
      bitField0_ |= 0x00000002;
      return this;
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 申请者基本信息
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional .Protocols.BaseRoleInfo baseInfo = 2;</code>
     */
    public Builder mergeBaseInfo(com.dj.protobuf.common.BaseRoleInfo value) {
      if (baseInfoBuilder_ == null) {
        if (((bitField0_ & 0x00000002) == 0x00000002) &&
            baseInfo_ != null &&
            baseInfo_ != com.dj.protobuf.common.BaseRoleInfo.getDefaultInstance()) {
          baseInfo_ =
            com.dj.protobuf.common.BaseRoleInfo.newBuilder(baseInfo_).mergeFrom(value).buildPartial();
        } else {
          baseInfo_ = value;
        }
        onChanged();
      } else {
        baseInfoBuilder_.mergeFrom(value);
      }
      bitField0_ |= 0x00000002;
      return this;
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 申请者基本信息
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional .Protocols.BaseRoleInfo baseInfo = 2;</code>
     */
    public Builder clearBaseInfo() {
      if (baseInfoBuilder_ == null) {
        baseInfo_ = null;
        onChanged();
      } else {
        baseInfoBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000002);
      return this;
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 申请者基本信息
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional .Protocols.BaseRoleInfo baseInfo = 2;</code>
     */
    public com.dj.protobuf.common.BaseRoleInfo.Builder getBaseInfoBuilder() {
      bitField0_ |= 0x00000002;
      onChanged();
      return getBaseInfoFieldBuilder().getBuilder();
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 申请者基本信息
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional .Protocols.BaseRoleInfo baseInfo = 2;</code>
     */
    public com.dj.protobuf.common.BaseRoleInfoOrBuilder getBaseInfoOrBuilder() {
      if (baseInfoBuilder_ != null) {
        return baseInfoBuilder_.getMessageOrBuilder();
      } else {
        return baseInfo_ == null ?
            com.dj.protobuf.common.BaseRoleInfo.getDefaultInstance() : baseInfo_;
      }
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 申请者基本信息
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional .Protocols.BaseRoleInfo baseInfo = 2;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.dj.protobuf.common.BaseRoleInfo, com.dj.protobuf.common.BaseRoleInfo.Builder, com.dj.protobuf.common.BaseRoleInfoOrBuilder> 
        getBaseInfoFieldBuilder() {
      if (baseInfoBuilder_ == null) {
        baseInfoBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.dj.protobuf.common.BaseRoleInfo, com.dj.protobuf.common.BaseRoleInfo.Builder, com.dj.protobuf.common.BaseRoleInfoOrBuilder>(
                getBaseInfo(),
                getParentForChildren(),
                isClean());
        baseInfo_ = null;
      }
      return baseInfoBuilder_;
    }

    private com.dj.protobuf.datetime.DateTime applyTime_ = null;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.dj.protobuf.datetime.DateTime, com.dj.protobuf.datetime.DateTime.Builder, com.dj.protobuf.datetime.DateTimeOrBuilder> applyTimeBuilder_;
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 申请时间
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional .Protocols.DateTime applyTime = 3;</code>
     */
    public boolean hasApplyTime() {
      return ((bitField0_ & 0x00000004) == 0x00000004);
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 申请时间
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional .Protocols.DateTime applyTime = 3;</code>
     */
    public com.dj.protobuf.datetime.DateTime getApplyTime() {
      if (applyTimeBuilder_ == null) {
        return applyTime_ == null ? com.dj.protobuf.datetime.DateTime.getDefaultInstance() : applyTime_;
      } else {
        return applyTimeBuilder_.getMessage();
      }
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 申请时间
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional .Protocols.DateTime applyTime = 3;</code>
     */
    public Builder setApplyTime(com.dj.protobuf.datetime.DateTime value) {
      if (applyTimeBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        applyTime_ = value;
        onChanged();
      } else {
        applyTimeBuilder_.setMessage(value);
      }
      bitField0_ |= 0x00000004;
      return this;
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 申请时间
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional .Protocols.DateTime applyTime = 3;</code>
     */
    public Builder setApplyTime(
        com.dj.protobuf.datetime.DateTime.Builder builderForValue) {
      if (applyTimeBuilder_ == null) {
        applyTime_ = builderForValue.build();
        onChanged();
      } else {
        applyTimeBuilder_.setMessage(builderForValue.build());
      }
      bitField0_ |= 0x00000004;
      return this;
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 申请时间
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional .Protocols.DateTime applyTime = 3;</code>
     */
    public Builder mergeApplyTime(com.dj.protobuf.datetime.DateTime value) {
      if (applyTimeBuilder_ == null) {
        if (((bitField0_ & 0x00000004) == 0x00000004) &&
            applyTime_ != null &&
            applyTime_ != com.dj.protobuf.datetime.DateTime.getDefaultInstance()) {
          applyTime_ =
            com.dj.protobuf.datetime.DateTime.newBuilder(applyTime_).mergeFrom(value).buildPartial();
        } else {
          applyTime_ = value;
        }
        onChanged();
      } else {
        applyTimeBuilder_.mergeFrom(value);
      }
      bitField0_ |= 0x00000004;
      return this;
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 申请时间
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional .Protocols.DateTime applyTime = 3;</code>
     */
    public Builder clearApplyTime() {
      if (applyTimeBuilder_ == null) {
        applyTime_ = null;
        onChanged();
      } else {
        applyTimeBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000004);
      return this;
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 申请时间
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional .Protocols.DateTime applyTime = 3;</code>
     */
    public com.dj.protobuf.datetime.DateTime.Builder getApplyTimeBuilder() {
      bitField0_ |= 0x00000004;
      onChanged();
      return getApplyTimeFieldBuilder().getBuilder();
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 申请时间
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional .Protocols.DateTime applyTime = 3;</code>
     */
    public com.dj.protobuf.datetime.DateTimeOrBuilder getApplyTimeOrBuilder() {
      if (applyTimeBuilder_ != null) {
        return applyTimeBuilder_.getMessageOrBuilder();
      } else {
        return applyTime_ == null ?
            com.dj.protobuf.datetime.DateTime.getDefaultInstance() : applyTime_;
      }
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 申请时间
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional .Protocols.DateTime applyTime = 3;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.dj.protobuf.datetime.DateTime, com.dj.protobuf.datetime.DateTime.Builder, com.dj.protobuf.datetime.DateTimeOrBuilder> 
        getApplyTimeFieldBuilder() {
      if (applyTimeBuilder_ == null) {
        applyTimeBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.dj.protobuf.datetime.DateTime, com.dj.protobuf.datetime.DateTime.Builder, com.dj.protobuf.datetime.DateTimeOrBuilder>(
                getApplyTime(),
                getParentForChildren(),
                isClean());
        applyTime_ = null;
      }
      return applyTimeBuilder_;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:Protocols.GuildApplyInfo)
  }

  // @@protoc_insertion_point(class_scope:Protocols.GuildApplyInfo)
  private static final com.dj.protobuf.guild.GuildApplyInfo DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.dj.protobuf.guild.GuildApplyInfo();
  }

  public static com.dj.protobuf.guild.GuildApplyInfo getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  @java.lang.Deprecated public static final com.google.protobuf.Parser<GuildApplyInfo>
      PARSER = new com.google.protobuf.AbstractParser<GuildApplyInfo>() {
    public GuildApplyInfo parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new GuildApplyInfo(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<GuildApplyInfo> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<GuildApplyInfo> getParserForType() {
    return PARSER;
  }

  public com.dj.protobuf.guild.GuildApplyInfo getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

