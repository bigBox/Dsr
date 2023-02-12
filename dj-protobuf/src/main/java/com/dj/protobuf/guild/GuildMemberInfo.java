// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Guild.proto

package com.dj.protobuf.guild;

/**
 * Protobuf type {@code Protocols.GuildMemberInfo}
 */
public  final class GuildMemberInfo extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:Protocols.GuildMemberInfo)
    GuildMemberInfoOrBuilder {
  // Use GuildMemberInfo.newBuilder() to construct.
  private GuildMemberInfo(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private GuildMemberInfo() {
    guildPost_ = 1;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private GuildMemberInfo(
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
            com.dj.protobuf.common.BaseRoleInfo.Builder subBuilder = null;
            if (((bitField0_ & 0x00000001) == 0x00000001)) {
              subBuilder = baseInfo_.toBuilder();
            }
            baseInfo_ = input.readMessage(com.dj.protobuf.common.BaseRoleInfo.PARSER, extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(baseInfo_);
              baseInfo_ = subBuilder.buildPartial();
            }
            bitField0_ |= 0x00000001;
            break;
          }
          case 16: {
            int rawValue = input.readEnum();
            com.dj.protobuf.guild.EGuildPost value = com.dj.protobuf.guild.EGuildPost.valueOf(rawValue);
            if (value == null) {
              unknownFields.mergeVarintField(2, rawValue);
            } else {
              bitField0_ |= 0x00000002;
              guildPost_ = rawValue;
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
    return com.dj.protobuf.guild.Guild.internal_static_Protocols_GuildMemberInfo_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.dj.protobuf.guild.Guild.internal_static_Protocols_GuildMemberInfo_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.dj.protobuf.guild.GuildMemberInfo.class, com.dj.protobuf.guild.GuildMemberInfo.Builder.class);
  }

  private int bitField0_;
  public static final int BASEINFO_FIELD_NUMBER = 1;
  private com.dj.protobuf.common.BaseRoleInfo baseInfo_;
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 角色基本信息
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional .Protocols.BaseRoleInfo baseInfo = 1;</code>
   */
  public boolean hasBaseInfo() {
    return ((bitField0_ & 0x00000001) == 0x00000001);
  }
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 角色基本信息
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional .Protocols.BaseRoleInfo baseInfo = 1;</code>
   */
  public com.dj.protobuf.common.BaseRoleInfo getBaseInfo() {
    return baseInfo_ == null ? com.dj.protobuf.common.BaseRoleInfo.getDefaultInstance() : baseInfo_;
  }
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 角色基本信息
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional .Protocols.BaseRoleInfo baseInfo = 1;</code>
   */
  public com.dj.protobuf.common.BaseRoleInfoOrBuilder getBaseInfoOrBuilder() {
    return baseInfo_ == null ? com.dj.protobuf.common.BaseRoleInfo.getDefaultInstance() : baseInfo_;
  }

  public static final int GUILDPOST_FIELD_NUMBER = 2;
  private int guildPost_;
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 角色在公会中的职位
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional .Protocols.EGuildPost guildPost = 2;</code>
   */
  public boolean hasGuildPost() {
    return ((bitField0_ & 0x00000002) == 0x00000002);
  }
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 角色在公会中的职位
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional .Protocols.EGuildPost guildPost = 2;</code>
   */
  public com.dj.protobuf.guild.EGuildPost getGuildPost() {
    com.dj.protobuf.guild.EGuildPost result = com.dj.protobuf.guild.EGuildPost.valueOf(guildPost_);
    return result == null ? com.dj.protobuf.guild.EGuildPost.GuildPostChairMan : result;
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
      output.writeMessage(1, getBaseInfo());
    }
    if (((bitField0_ & 0x00000002) == 0x00000002)) {
      output.writeEnum(2, guildPost_);
    }
    unknownFields.writeTo(output);
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (((bitField0_ & 0x00000001) == 0x00000001)) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, getBaseInfo());
    }
    if (((bitField0_ & 0x00000002) == 0x00000002)) {
      size += com.google.protobuf.CodedOutputStream
        .computeEnumSize(2, guildPost_);
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
    if (!(obj instanceof com.dj.protobuf.guild.GuildMemberInfo)) {
      return super.equals(obj);
    }
    com.dj.protobuf.guild.GuildMemberInfo other = (com.dj.protobuf.guild.GuildMemberInfo) obj;

    boolean result = true;
    result = result && (hasBaseInfo() == other.hasBaseInfo());
    if (hasBaseInfo()) {
      result = result && getBaseInfo()
          .equals(other.getBaseInfo());
    }
    result = result && (hasGuildPost() == other.hasGuildPost());
    if (hasGuildPost()) {
      result = result && guildPost_ == other.guildPost_;
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
    if (hasBaseInfo()) {
      hash = (37 * hash) + BASEINFO_FIELD_NUMBER;
      hash = (53 * hash) + getBaseInfo().hashCode();
    }
    if (hasGuildPost()) {
      hash = (37 * hash) + GUILDPOST_FIELD_NUMBER;
      hash = (53 * hash) + guildPost_;
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.dj.protobuf.guild.GuildMemberInfo parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dj.protobuf.guild.GuildMemberInfo parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dj.protobuf.guild.GuildMemberInfo parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dj.protobuf.guild.GuildMemberInfo parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dj.protobuf.guild.GuildMemberInfo parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.guild.GuildMemberInfo parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.dj.protobuf.guild.GuildMemberInfo parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.guild.GuildMemberInfo parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.dj.protobuf.guild.GuildMemberInfo parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.guild.GuildMemberInfo parseFrom(
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
  public static Builder newBuilder(com.dj.protobuf.guild.GuildMemberInfo prototype) {
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
   * Protobuf type {@code Protocols.GuildMemberInfo}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:Protocols.GuildMemberInfo)
      com.dj.protobuf.guild.GuildMemberInfoOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.dj.protobuf.guild.Guild.internal_static_Protocols_GuildMemberInfo_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.dj.protobuf.guild.Guild.internal_static_Protocols_GuildMemberInfo_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.dj.protobuf.guild.GuildMemberInfo.class, com.dj.protobuf.guild.GuildMemberInfo.Builder.class);
    }

    // Construct using com.dj.protobuf.guild.GuildMemberInfo.newBuilder()
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
        getBaseInfoFieldBuilder();
      }
    }
    public Builder clear() {
      super.clear();
      if (baseInfoBuilder_ == null) {
        baseInfo_ = null;
      } else {
        baseInfoBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000001);
      guildPost_ = 1;
      bitField0_ = (bitField0_ & ~0x00000002);
      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.dj.protobuf.guild.Guild.internal_static_Protocols_GuildMemberInfo_descriptor;
    }

    public com.dj.protobuf.guild.GuildMemberInfo getDefaultInstanceForType() {
      return com.dj.protobuf.guild.GuildMemberInfo.getDefaultInstance();
    }

    public com.dj.protobuf.guild.GuildMemberInfo build() {
      com.dj.protobuf.guild.GuildMemberInfo result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public com.dj.protobuf.guild.GuildMemberInfo buildPartial() {
      com.dj.protobuf.guild.GuildMemberInfo result = new com.dj.protobuf.guild.GuildMemberInfo(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
        to_bitField0_ |= 0x00000001;
      }
      if (baseInfoBuilder_ == null) {
        result.baseInfo_ = baseInfo_;
      } else {
        result.baseInfo_ = baseInfoBuilder_.build();
      }
      if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
        to_bitField0_ |= 0x00000002;
      }
      result.guildPost_ = guildPost_;
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
      if (other instanceof com.dj.protobuf.guild.GuildMemberInfo) {
        return mergeFrom((com.dj.protobuf.guild.GuildMemberInfo)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.dj.protobuf.guild.GuildMemberInfo other) {
      if (other == com.dj.protobuf.guild.GuildMemberInfo.getDefaultInstance()) return this;
      if (other.hasBaseInfo()) {
        mergeBaseInfo(other.getBaseInfo());
      }
      if (other.hasGuildPost()) {
        setGuildPost(other.getGuildPost());
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
      com.dj.protobuf.guild.GuildMemberInfo parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.dj.protobuf.guild.GuildMemberInfo) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private com.dj.protobuf.common.BaseRoleInfo baseInfo_ = null;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.dj.protobuf.common.BaseRoleInfo, com.dj.protobuf.common.BaseRoleInfo.Builder, com.dj.protobuf.common.BaseRoleInfoOrBuilder> baseInfoBuilder_;
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 角色基本信息
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional .Protocols.BaseRoleInfo baseInfo = 1;</code>
     */
    public boolean hasBaseInfo() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 角色基本信息
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional .Protocols.BaseRoleInfo baseInfo = 1;</code>
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
     * / 角色基本信息
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional .Protocols.BaseRoleInfo baseInfo = 1;</code>
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
      bitField0_ |= 0x00000001;
      return this;
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 角色基本信息
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional .Protocols.BaseRoleInfo baseInfo = 1;</code>
     */
    public Builder setBaseInfo(
        com.dj.protobuf.common.BaseRoleInfo.Builder builderForValue) {
      if (baseInfoBuilder_ == null) {
        baseInfo_ = builderForValue.build();
        onChanged();
      } else {
        baseInfoBuilder_.setMessage(builderForValue.build());
      }
      bitField0_ |= 0x00000001;
      return this;
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 角色基本信息
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional .Protocols.BaseRoleInfo baseInfo = 1;</code>
     */
    public Builder mergeBaseInfo(com.dj.protobuf.common.BaseRoleInfo value) {
      if (baseInfoBuilder_ == null) {
        if (((bitField0_ & 0x00000001) == 0x00000001) &&
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
      bitField0_ |= 0x00000001;
      return this;
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 角色基本信息
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional .Protocols.BaseRoleInfo baseInfo = 1;</code>
     */
    public Builder clearBaseInfo() {
      if (baseInfoBuilder_ == null) {
        baseInfo_ = null;
        onChanged();
      } else {
        baseInfoBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000001);
      return this;
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 角色基本信息
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional .Protocols.BaseRoleInfo baseInfo = 1;</code>
     */
    public com.dj.protobuf.common.BaseRoleInfo.Builder getBaseInfoBuilder() {
      bitField0_ |= 0x00000001;
      onChanged();
      return getBaseInfoFieldBuilder().getBuilder();
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 角色基本信息
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional .Protocols.BaseRoleInfo baseInfo = 1;</code>
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
     * / 角色基本信息
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional .Protocols.BaseRoleInfo baseInfo = 1;</code>
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

    private int guildPost_ = 1;
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 角色在公会中的职位
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional .Protocols.EGuildPost guildPost = 2;</code>
     */
    public boolean hasGuildPost() {
      return ((bitField0_ & 0x00000002) == 0x00000002);
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 角色在公会中的职位
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional .Protocols.EGuildPost guildPost = 2;</code>
     */
    public com.dj.protobuf.guild.EGuildPost getGuildPost() {
      com.dj.protobuf.guild.EGuildPost result = com.dj.protobuf.guild.EGuildPost.valueOf(guildPost_);
      return result == null ? com.dj.protobuf.guild.EGuildPost.GuildPostChairMan : result;
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 角色在公会中的职位
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional .Protocols.EGuildPost guildPost = 2;</code>
     */
    public Builder setGuildPost(com.dj.protobuf.guild.EGuildPost value) {
      if (value == null) {
        throw new NullPointerException();
      }
      bitField0_ |= 0x00000002;
      guildPost_ = value.getNumber();
      onChanged();
      return this;
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 角色在公会中的职位
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional .Protocols.EGuildPost guildPost = 2;</code>
     */
    public Builder clearGuildPost() {
      bitField0_ = (bitField0_ & ~0x00000002);
      guildPost_ = 1;
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


    // @@protoc_insertion_point(builder_scope:Protocols.GuildMemberInfo)
  }

  // @@protoc_insertion_point(class_scope:Protocols.GuildMemberInfo)
  private static final com.dj.protobuf.guild.GuildMemberInfo DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.dj.protobuf.guild.GuildMemberInfo();
  }

  public static com.dj.protobuf.guild.GuildMemberInfo getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  @java.lang.Deprecated public static final com.google.protobuf.Parser<GuildMemberInfo>
      PARSER = new com.google.protobuf.AbstractParser<GuildMemberInfo>() {
    public GuildMemberInfo parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new GuildMemberInfo(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<GuildMemberInfo> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<GuildMemberInfo> getParserForType() {
    return PARSER;
  }

  public com.dj.protobuf.guild.GuildMemberInfo getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

