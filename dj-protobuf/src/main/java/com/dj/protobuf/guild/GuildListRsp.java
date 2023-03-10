// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Guild.proto

package com.dj.protobuf.guild;

/**
 * <pre>
 *&#47; &lt;summary&gt;
 * / 查询公会信息响应
 * / &lt;/summary&gt;
 * </pre>
 *
 * Protobuf type {@code Protocols.GuildListRsp}
 */
public  final class GuildListRsp extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:Protocols.GuildListRsp)
    GuildListRspOrBuilder {
  // Use GuildListRsp.newBuilder() to construct.
  private GuildListRsp(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private GuildListRsp() {
    errorID_ = 0;
    members_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private GuildListRsp(
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
            com.dj.protobuf.guild.GuildBaseInfo.Builder subBuilder = null;
            if (((bitField0_ & 0x00000002) == 0x00000002)) {
              subBuilder = guilBaseInfo_.toBuilder();
            }
            guilBaseInfo_ = input.readMessage(com.dj.protobuf.guild.GuildBaseInfo.PARSER, extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(guilBaseInfo_);
              guilBaseInfo_ = subBuilder.buildPartial();
            }
            bitField0_ |= 0x00000002;
            break;
          }
          case 26: {
            if (!((mutable_bitField0_ & 0x00000004) == 0x00000004)) {
              members_ = new java.util.ArrayList<com.dj.protobuf.guild.GuildMemberInfo>();
              mutable_bitField0_ |= 0x00000004;
            }
            members_.add(
                input.readMessage(com.dj.protobuf.guild.GuildMemberInfo.PARSER, extensionRegistry));
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
      if (((mutable_bitField0_ & 0x00000004) == 0x00000004)) {
        members_ = java.util.Collections.unmodifiableList(members_);
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.dj.protobuf.guild.Guild.internal_static_Protocols_GuildListRsp_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.dj.protobuf.guild.Guild.internal_static_Protocols_GuildListRsp_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.dj.protobuf.guild.GuildListRsp.class, com.dj.protobuf.guild.GuildListRsp.Builder.class);
  }

  private int bitField0_;
  public static final int ERRORID_FIELD_NUMBER = 1;
  private int errorID_;
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 错误码，ErrorID.Guild_NotExist 表示没有公会
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
   * / 错误码，ErrorID.Guild_NotExist 表示没有公会
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional .ErrorID errorID = 1;</code>
   */
  public com.dj.protobuf.ErrorIDOuterClass.ErrorID getErrorID() {
    com.dj.protobuf.ErrorIDOuterClass.ErrorID result = com.dj.protobuf.ErrorIDOuterClass.ErrorID.valueOf(errorID_);
    return result == null ? com.dj.protobuf.ErrorIDOuterClass.ErrorID.OK : result;
  }

  public static final int GUILBASEINFO_FIELD_NUMBER = 2;
  private com.dj.protobuf.guild.GuildBaseInfo guilBaseInfo_;
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 公会基本信息
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional .Protocols.GuildBaseInfo guilBaseInfo = 2;</code>
   */
  public boolean hasGuilBaseInfo() {
    return ((bitField0_ & 0x00000002) == 0x00000002);
  }
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 公会基本信息
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional .Protocols.GuildBaseInfo guilBaseInfo = 2;</code>
   */
  public com.dj.protobuf.guild.GuildBaseInfo getGuilBaseInfo() {
    return guilBaseInfo_ == null ? com.dj.protobuf.guild.GuildBaseInfo.getDefaultInstance() : guilBaseInfo_;
  }
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 公会基本信息
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>optional .Protocols.GuildBaseInfo guilBaseInfo = 2;</code>
   */
  public com.dj.protobuf.guild.GuildBaseInfoOrBuilder getGuilBaseInfoOrBuilder() {
    return guilBaseInfo_ == null ? com.dj.protobuf.guild.GuildBaseInfo.getDefaultInstance() : guilBaseInfo_;
  }

  public static final int MEMBERS_FIELD_NUMBER = 3;
  private java.util.List<com.dj.protobuf.guild.GuildMemberInfo> members_;
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 公会成员信息，bool表示是否在线
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>repeated .Protocols.GuildMemberInfo members = 3;</code>
   */
  public java.util.List<com.dj.protobuf.guild.GuildMemberInfo> getMembersList() {
    return members_;
  }
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 公会成员信息，bool表示是否在线
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>repeated .Protocols.GuildMemberInfo members = 3;</code>
   */
  public java.util.List<? extends com.dj.protobuf.guild.GuildMemberInfoOrBuilder> 
      getMembersOrBuilderList() {
    return members_;
  }
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 公会成员信息，bool表示是否在线
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>repeated .Protocols.GuildMemberInfo members = 3;</code>
   */
  public int getMembersCount() {
    return members_.size();
  }
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 公会成员信息，bool表示是否在线
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>repeated .Protocols.GuildMemberInfo members = 3;</code>
   */
  public com.dj.protobuf.guild.GuildMemberInfo getMembers(int index) {
    return members_.get(index);
  }
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 公会成员信息，bool表示是否在线
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>repeated .Protocols.GuildMemberInfo members = 3;</code>
   */
  public com.dj.protobuf.guild.GuildMemberInfoOrBuilder getMembersOrBuilder(
      int index) {
    return members_.get(index);
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
      output.writeMessage(2, getGuilBaseInfo());
    }
    for (int i = 0; i < members_.size(); i++) {
      output.writeMessage(3, members_.get(i));
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
        .computeMessageSize(2, getGuilBaseInfo());
    }
    for (int i = 0; i < members_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(3, members_.get(i));
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
    if (!(obj instanceof com.dj.protobuf.guild.GuildListRsp)) {
      return super.equals(obj);
    }
    com.dj.protobuf.guild.GuildListRsp other = (com.dj.protobuf.guild.GuildListRsp) obj;

    boolean result = true;
    result = result && (hasErrorID() == other.hasErrorID());
    if (hasErrorID()) {
      result = result && errorID_ == other.errorID_;
    }
    result = result && (hasGuilBaseInfo() == other.hasGuilBaseInfo());
    if (hasGuilBaseInfo()) {
      result = result && getGuilBaseInfo()
          .equals(other.getGuilBaseInfo());
    }
    result = result && getMembersList()
        .equals(other.getMembersList());
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
    if (hasGuilBaseInfo()) {
      hash = (37 * hash) + GUILBASEINFO_FIELD_NUMBER;
      hash = (53 * hash) + getGuilBaseInfo().hashCode();
    }
    if (getMembersCount() > 0) {
      hash = (37 * hash) + MEMBERS_FIELD_NUMBER;
      hash = (53 * hash) + getMembersList().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.dj.protobuf.guild.GuildListRsp parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dj.protobuf.guild.GuildListRsp parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dj.protobuf.guild.GuildListRsp parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dj.protobuf.guild.GuildListRsp parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dj.protobuf.guild.GuildListRsp parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.guild.GuildListRsp parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.dj.protobuf.guild.GuildListRsp parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.guild.GuildListRsp parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.dj.protobuf.guild.GuildListRsp parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.guild.GuildListRsp parseFrom(
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
  public static Builder newBuilder(com.dj.protobuf.guild.GuildListRsp prototype) {
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
   * / 查询公会信息响应
   * / &lt;/summary&gt;
   * </pre>
   *
   * Protobuf type {@code Protocols.GuildListRsp}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:Protocols.GuildListRsp)
      com.dj.protobuf.guild.GuildListRspOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.dj.protobuf.guild.Guild.internal_static_Protocols_GuildListRsp_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.dj.protobuf.guild.Guild.internal_static_Protocols_GuildListRsp_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.dj.protobuf.guild.GuildListRsp.class, com.dj.protobuf.guild.GuildListRsp.Builder.class);
    }

    // Construct using com.dj.protobuf.guild.GuildListRsp.newBuilder()
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
        getGuilBaseInfoFieldBuilder();
        getMembersFieldBuilder();
      }
    }
    public Builder clear() {
      super.clear();
      errorID_ = 0;
      bitField0_ = (bitField0_ & ~0x00000001);
      if (guilBaseInfoBuilder_ == null) {
        guilBaseInfo_ = null;
      } else {
        guilBaseInfoBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000002);
      if (membersBuilder_ == null) {
        members_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000004);
      } else {
        membersBuilder_.clear();
      }
      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.dj.protobuf.guild.Guild.internal_static_Protocols_GuildListRsp_descriptor;
    }

    public com.dj.protobuf.guild.GuildListRsp getDefaultInstanceForType() {
      return com.dj.protobuf.guild.GuildListRsp.getDefaultInstance();
    }

    public com.dj.protobuf.guild.GuildListRsp build() {
      com.dj.protobuf.guild.GuildListRsp result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public com.dj.protobuf.guild.GuildListRsp buildPartial() {
      com.dj.protobuf.guild.GuildListRsp result = new com.dj.protobuf.guild.GuildListRsp(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
        to_bitField0_ |= 0x00000001;
      }
      result.errorID_ = errorID_;
      if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
        to_bitField0_ |= 0x00000002;
      }
      if (guilBaseInfoBuilder_ == null) {
        result.guilBaseInfo_ = guilBaseInfo_;
      } else {
        result.guilBaseInfo_ = guilBaseInfoBuilder_.build();
      }
      if (membersBuilder_ == null) {
        if (((bitField0_ & 0x00000004) == 0x00000004)) {
          members_ = java.util.Collections.unmodifiableList(members_);
          bitField0_ = (bitField0_ & ~0x00000004);
        }
        result.members_ = members_;
      } else {
        result.members_ = membersBuilder_.build();
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
      if (other instanceof com.dj.protobuf.guild.GuildListRsp) {
        return mergeFrom((com.dj.protobuf.guild.GuildListRsp)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.dj.protobuf.guild.GuildListRsp other) {
      if (other == com.dj.protobuf.guild.GuildListRsp.getDefaultInstance()) return this;
      if (other.hasErrorID()) {
        setErrorID(other.getErrorID());
      }
      if (other.hasGuilBaseInfo()) {
        mergeGuilBaseInfo(other.getGuilBaseInfo());
      }
      if (membersBuilder_ == null) {
        if (!other.members_.isEmpty()) {
          if (members_.isEmpty()) {
            members_ = other.members_;
            bitField0_ = (bitField0_ & ~0x00000004);
          } else {
            ensureMembersIsMutable();
            members_.addAll(other.members_);
          }
          onChanged();
        }
      } else {
        if (!other.members_.isEmpty()) {
          if (membersBuilder_.isEmpty()) {
            membersBuilder_.dispose();
            membersBuilder_ = null;
            members_ = other.members_;
            bitField0_ = (bitField0_ & ~0x00000004);
            membersBuilder_ = 
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getMembersFieldBuilder() : null;
          } else {
            membersBuilder_.addAllMessages(other.members_);
          }
        }
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
      com.dj.protobuf.guild.GuildListRsp parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.dj.protobuf.guild.GuildListRsp) e.getUnfinishedMessage();
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
     * / 错误码，ErrorID.Guild_NotExist 表示没有公会
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
     * / 错误码，ErrorID.Guild_NotExist 表示没有公会
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
     * / 错误码，ErrorID.Guild_NotExist 表示没有公会
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
     * / 错误码，ErrorID.Guild_NotExist 表示没有公会
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

    private com.dj.protobuf.guild.GuildBaseInfo guilBaseInfo_ = null;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.dj.protobuf.guild.GuildBaseInfo, com.dj.protobuf.guild.GuildBaseInfo.Builder, com.dj.protobuf.guild.GuildBaseInfoOrBuilder> guilBaseInfoBuilder_;
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 公会基本信息
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional .Protocols.GuildBaseInfo guilBaseInfo = 2;</code>
     */
    public boolean hasGuilBaseInfo() {
      return ((bitField0_ & 0x00000002) == 0x00000002);
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 公会基本信息
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional .Protocols.GuildBaseInfo guilBaseInfo = 2;</code>
     */
    public com.dj.protobuf.guild.GuildBaseInfo getGuilBaseInfo() {
      if (guilBaseInfoBuilder_ == null) {
        return guilBaseInfo_ == null ? com.dj.protobuf.guild.GuildBaseInfo.getDefaultInstance() : guilBaseInfo_;
      } else {
        return guilBaseInfoBuilder_.getMessage();
      }
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 公会基本信息
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional .Protocols.GuildBaseInfo guilBaseInfo = 2;</code>
     */
    public Builder setGuilBaseInfo(com.dj.protobuf.guild.GuildBaseInfo value) {
      if (guilBaseInfoBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        guilBaseInfo_ = value;
        onChanged();
      } else {
        guilBaseInfoBuilder_.setMessage(value);
      }
      bitField0_ |= 0x00000002;
      return this;
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 公会基本信息
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional .Protocols.GuildBaseInfo guilBaseInfo = 2;</code>
     */
    public Builder setGuilBaseInfo(
        com.dj.protobuf.guild.GuildBaseInfo.Builder builderForValue) {
      if (guilBaseInfoBuilder_ == null) {
        guilBaseInfo_ = builderForValue.build();
        onChanged();
      } else {
        guilBaseInfoBuilder_.setMessage(builderForValue.build());
      }
      bitField0_ |= 0x00000002;
      return this;
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 公会基本信息
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional .Protocols.GuildBaseInfo guilBaseInfo = 2;</code>
     */
    public Builder mergeGuilBaseInfo(com.dj.protobuf.guild.GuildBaseInfo value) {
      if (guilBaseInfoBuilder_ == null) {
        if (((bitField0_ & 0x00000002) == 0x00000002) &&
            guilBaseInfo_ != null &&
            guilBaseInfo_ != com.dj.protobuf.guild.GuildBaseInfo.getDefaultInstance()) {
          guilBaseInfo_ =
            com.dj.protobuf.guild.GuildBaseInfo.newBuilder(guilBaseInfo_).mergeFrom(value).buildPartial();
        } else {
          guilBaseInfo_ = value;
        }
        onChanged();
      } else {
        guilBaseInfoBuilder_.mergeFrom(value);
      }
      bitField0_ |= 0x00000002;
      return this;
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 公会基本信息
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional .Protocols.GuildBaseInfo guilBaseInfo = 2;</code>
     */
    public Builder clearGuilBaseInfo() {
      if (guilBaseInfoBuilder_ == null) {
        guilBaseInfo_ = null;
        onChanged();
      } else {
        guilBaseInfoBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000002);
      return this;
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 公会基本信息
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional .Protocols.GuildBaseInfo guilBaseInfo = 2;</code>
     */
    public com.dj.protobuf.guild.GuildBaseInfo.Builder getGuilBaseInfoBuilder() {
      bitField0_ |= 0x00000002;
      onChanged();
      return getGuilBaseInfoFieldBuilder().getBuilder();
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 公会基本信息
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional .Protocols.GuildBaseInfo guilBaseInfo = 2;</code>
     */
    public com.dj.protobuf.guild.GuildBaseInfoOrBuilder getGuilBaseInfoOrBuilder() {
      if (guilBaseInfoBuilder_ != null) {
        return guilBaseInfoBuilder_.getMessageOrBuilder();
      } else {
        return guilBaseInfo_ == null ?
            com.dj.protobuf.guild.GuildBaseInfo.getDefaultInstance() : guilBaseInfo_;
      }
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 公会基本信息
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>optional .Protocols.GuildBaseInfo guilBaseInfo = 2;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.dj.protobuf.guild.GuildBaseInfo, com.dj.protobuf.guild.GuildBaseInfo.Builder, com.dj.protobuf.guild.GuildBaseInfoOrBuilder> 
        getGuilBaseInfoFieldBuilder() {
      if (guilBaseInfoBuilder_ == null) {
        guilBaseInfoBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.dj.protobuf.guild.GuildBaseInfo, com.dj.protobuf.guild.GuildBaseInfo.Builder, com.dj.protobuf.guild.GuildBaseInfoOrBuilder>(
                getGuilBaseInfo(),
                getParentForChildren(),
                isClean());
        guilBaseInfo_ = null;
      }
      return guilBaseInfoBuilder_;
    }

    private java.util.List<com.dj.protobuf.guild.GuildMemberInfo> members_ =
      java.util.Collections.emptyList();
    private void ensureMembersIsMutable() {
      if (!((bitField0_ & 0x00000004) == 0x00000004)) {
        members_ = new java.util.ArrayList<com.dj.protobuf.guild.GuildMemberInfo>(members_);
        bitField0_ |= 0x00000004;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        com.dj.protobuf.guild.GuildMemberInfo, com.dj.protobuf.guild.GuildMemberInfo.Builder, com.dj.protobuf.guild.GuildMemberInfoOrBuilder> membersBuilder_;

    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 公会成员信息，bool表示是否在线
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>repeated .Protocols.GuildMemberInfo members = 3;</code>
     */
    public java.util.List<com.dj.protobuf.guild.GuildMemberInfo> getMembersList() {
      if (membersBuilder_ == null) {
        return java.util.Collections.unmodifiableList(members_);
      } else {
        return membersBuilder_.getMessageList();
      }
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 公会成员信息，bool表示是否在线
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>repeated .Protocols.GuildMemberInfo members = 3;</code>
     */
    public int getMembersCount() {
      if (membersBuilder_ == null) {
        return members_.size();
      } else {
        return membersBuilder_.getCount();
      }
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 公会成员信息，bool表示是否在线
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>repeated .Protocols.GuildMemberInfo members = 3;</code>
     */
    public com.dj.protobuf.guild.GuildMemberInfo getMembers(int index) {
      if (membersBuilder_ == null) {
        return members_.get(index);
      } else {
        return membersBuilder_.getMessage(index);
      }
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 公会成员信息，bool表示是否在线
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>repeated .Protocols.GuildMemberInfo members = 3;</code>
     */
    public Builder setMembers(
        int index, com.dj.protobuf.guild.GuildMemberInfo value) {
      if (membersBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureMembersIsMutable();
        members_.set(index, value);
        onChanged();
      } else {
        membersBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 公会成员信息，bool表示是否在线
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>repeated .Protocols.GuildMemberInfo members = 3;</code>
     */
    public Builder setMembers(
        int index, com.dj.protobuf.guild.GuildMemberInfo.Builder builderForValue) {
      if (membersBuilder_ == null) {
        ensureMembersIsMutable();
        members_.set(index, builderForValue.build());
        onChanged();
      } else {
        membersBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 公会成员信息，bool表示是否在线
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>repeated .Protocols.GuildMemberInfo members = 3;</code>
     */
    public Builder addMembers(com.dj.protobuf.guild.GuildMemberInfo value) {
      if (membersBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureMembersIsMutable();
        members_.add(value);
        onChanged();
      } else {
        membersBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 公会成员信息，bool表示是否在线
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>repeated .Protocols.GuildMemberInfo members = 3;</code>
     */
    public Builder addMembers(
        int index, com.dj.protobuf.guild.GuildMemberInfo value) {
      if (membersBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureMembersIsMutable();
        members_.add(index, value);
        onChanged();
      } else {
        membersBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 公会成员信息，bool表示是否在线
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>repeated .Protocols.GuildMemberInfo members = 3;</code>
     */
    public Builder addMembers(
        com.dj.protobuf.guild.GuildMemberInfo.Builder builderForValue) {
      if (membersBuilder_ == null) {
        ensureMembersIsMutable();
        members_.add(builderForValue.build());
        onChanged();
      } else {
        membersBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 公会成员信息，bool表示是否在线
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>repeated .Protocols.GuildMemberInfo members = 3;</code>
     */
    public Builder addMembers(
        int index, com.dj.protobuf.guild.GuildMemberInfo.Builder builderForValue) {
      if (membersBuilder_ == null) {
        ensureMembersIsMutable();
        members_.add(index, builderForValue.build());
        onChanged();
      } else {
        membersBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 公会成员信息，bool表示是否在线
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>repeated .Protocols.GuildMemberInfo members = 3;</code>
     */
    public Builder addAllMembers(
        java.lang.Iterable<? extends com.dj.protobuf.guild.GuildMemberInfo> values) {
      if (membersBuilder_ == null) {
        ensureMembersIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, members_);
        onChanged();
      } else {
        membersBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 公会成员信息，bool表示是否在线
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>repeated .Protocols.GuildMemberInfo members = 3;</code>
     */
    public Builder clearMembers() {
      if (membersBuilder_ == null) {
        members_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000004);
        onChanged();
      } else {
        membersBuilder_.clear();
      }
      return this;
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 公会成员信息，bool表示是否在线
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>repeated .Protocols.GuildMemberInfo members = 3;</code>
     */
    public Builder removeMembers(int index) {
      if (membersBuilder_ == null) {
        ensureMembersIsMutable();
        members_.remove(index);
        onChanged();
      } else {
        membersBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 公会成员信息，bool表示是否在线
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>repeated .Protocols.GuildMemberInfo members = 3;</code>
     */
    public com.dj.protobuf.guild.GuildMemberInfo.Builder getMembersBuilder(
        int index) {
      return getMembersFieldBuilder().getBuilder(index);
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 公会成员信息，bool表示是否在线
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>repeated .Protocols.GuildMemberInfo members = 3;</code>
     */
    public com.dj.protobuf.guild.GuildMemberInfoOrBuilder getMembersOrBuilder(
        int index) {
      if (membersBuilder_ == null) {
        return members_.get(index);  } else {
        return membersBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 公会成员信息，bool表示是否在线
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>repeated .Protocols.GuildMemberInfo members = 3;</code>
     */
    public java.util.List<? extends com.dj.protobuf.guild.GuildMemberInfoOrBuilder> 
         getMembersOrBuilderList() {
      if (membersBuilder_ != null) {
        return membersBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(members_);
      }
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 公会成员信息，bool表示是否在线
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>repeated .Protocols.GuildMemberInfo members = 3;</code>
     */
    public com.dj.protobuf.guild.GuildMemberInfo.Builder addMembersBuilder() {
      return getMembersFieldBuilder().addBuilder(
          com.dj.protobuf.guild.GuildMemberInfo.getDefaultInstance());
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 公会成员信息，bool表示是否在线
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>repeated .Protocols.GuildMemberInfo members = 3;</code>
     */
    public com.dj.protobuf.guild.GuildMemberInfo.Builder addMembersBuilder(
        int index) {
      return getMembersFieldBuilder().addBuilder(
          index, com.dj.protobuf.guild.GuildMemberInfo.getDefaultInstance());
    }
    /**
     * <pre>
     *&#47; &lt;summary&gt;
     * / 公会成员信息，bool表示是否在线
     * / &lt;/summary&gt;
     * </pre>
     *
     * <code>repeated .Protocols.GuildMemberInfo members = 3;</code>
     */
    public java.util.List<com.dj.protobuf.guild.GuildMemberInfo.Builder> 
         getMembersBuilderList() {
      return getMembersFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        com.dj.protobuf.guild.GuildMemberInfo, com.dj.protobuf.guild.GuildMemberInfo.Builder, com.dj.protobuf.guild.GuildMemberInfoOrBuilder> 
        getMembersFieldBuilder() {
      if (membersBuilder_ == null) {
        membersBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            com.dj.protobuf.guild.GuildMemberInfo, com.dj.protobuf.guild.GuildMemberInfo.Builder, com.dj.protobuf.guild.GuildMemberInfoOrBuilder>(
                members_,
                ((bitField0_ & 0x00000004) == 0x00000004),
                getParentForChildren(),
                isClean());
        members_ = null;
      }
      return membersBuilder_;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:Protocols.GuildListRsp)
  }

  // @@protoc_insertion_point(class_scope:Protocols.GuildListRsp)
  private static final com.dj.protobuf.guild.GuildListRsp DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.dj.protobuf.guild.GuildListRsp();
  }

  public static com.dj.protobuf.guild.GuildListRsp getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  @java.lang.Deprecated public static final com.google.protobuf.Parser<GuildListRsp>
      PARSER = new com.google.protobuf.AbstractParser<GuildListRsp>() {
    public GuildListRsp parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new GuildListRsp(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<GuildListRsp> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<GuildListRsp> getParserForType() {
    return PARSER;
  }

  public com.dj.protobuf.guild.GuildListRsp getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

