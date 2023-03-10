// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: GuildBattle.proto

package com.dj.protobuf.guildBattle;

/**
 * <pre>
 *&#47; &lt;summary&gt;
 * / 游戏结束推送
 * / &lt;/summary&gt;
 * </pre>
 *
 * Protobuf type {@code Protocols.BattleOverNtf}
 */
public  final class BattleOverNtf extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:Protocols.BattleOverNtf)
    BattleOverNtfOrBuilder {
  // Use BattleOverNtf.newBuilder() to construct.
  private BattleOverNtf(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private BattleOverNtf() {
    score_ = 0;
    exp_ = 0;
    level_ = 0;
    matchScore_ = 0;
    winGuildID_ = 0L;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private BattleOverNtf(
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
            score_ = input.readInt32();
            break;
          }
          case 16: {
            bitField0_ |= 0x00000002;
            exp_ = input.readInt32();
            break;
          }
          case 24: {
            bitField0_ |= 0x00000004;
            level_ = input.readInt32();
            break;
          }
          case 32: {
            bitField0_ |= 0x00000008;
            matchScore_ = input.readInt32();
            break;
          }
          case 40: {
            bitField0_ |= 0x00000010;
            winGuildID_ = input.readUInt64();
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
    return com.dj.protobuf.guildBattle.GuildBattle.internal_static_Protocols_BattleOverNtf_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.dj.protobuf.guildBattle.GuildBattle.internal_static_Protocols_BattleOverNtf_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.dj.protobuf.guildBattle.BattleOverNtf.class, com.dj.protobuf.guildBattle.BattleOverNtf.Builder.class);
  }

  private int bitField0_;
  public static final int SCORE_FIELD_NUMBER = 1;
  private int score_;
  /**
   * <pre>
   * 玩家商会总分数
   * </pre>
   *
   * <code>optional int32 score = 1;</code>
   */
  public boolean hasScore() {
    return ((bitField0_ & 0x00000001) == 0x00000001);
  }
  /**
   * <pre>
   * 玩家商会总分数
   * </pre>
   *
   * <code>optional int32 score = 1;</code>
   */
  public int getScore() {
    return score_;
  }

  public static final int EXP_FIELD_NUMBER = 2;
  private int exp_;
  /**
   * <pre>
   * 玩家商会经验
   * </pre>
   *
   * <code>optional int32 exp = 2;</code>
   */
  public boolean hasExp() {
    return ((bitField0_ & 0x00000002) == 0x00000002);
  }
  /**
   * <pre>
   * 玩家商会经验
   * </pre>
   *
   * <code>optional int32 exp = 2;</code>
   */
  public int getExp() {
    return exp_;
  }

  public static final int LEVEL_FIELD_NUMBER = 3;
  private int level_;
  /**
   * <pre>
   * 玩家商会等级
   * </pre>
   *
   * <code>optional int32 level = 3;</code>
   */
  public boolean hasLevel() {
    return ((bitField0_ & 0x00000004) == 0x00000004);
  }
  /**
   * <pre>
   * 玩家商会等级
   * </pre>
   *
   * <code>optional int32 level = 3;</code>
   */
  public int getLevel() {
    return level_;
  }

  public static final int MATCHSCORE_FIELD_NUMBER = 4;
  private int matchScore_;
  /**
   * <pre>
   * 对方商会总分数
   * </pre>
   *
   * <code>optional int32 matchScore = 4;</code>
   */
  public boolean hasMatchScore() {
    return ((bitField0_ & 0x00000008) == 0x00000008);
  }
  /**
   * <pre>
   * 对方商会总分数
   * </pre>
   *
   * <code>optional int32 matchScore = 4;</code>
   */
  public int getMatchScore() {
    return matchScore_;
  }

  public static final int WINGUILDID_FIELD_NUMBER = 5;
  private long winGuildID_;
  /**
   * <pre>
   * 胜利方商会id
   * </pre>
   *
   * <code>optional uint64 winGuildID = 5;</code>
   */
  public boolean hasWinGuildID() {
    return ((bitField0_ & 0x00000010) == 0x00000010);
  }
  /**
   * <pre>
   * 胜利方商会id
   * </pre>
   *
   * <code>optional uint64 winGuildID = 5;</code>
   */
  public long getWinGuildID() {
    return winGuildID_;
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
      output.writeInt32(1, score_);
    }
    if (((bitField0_ & 0x00000002) == 0x00000002)) {
      output.writeInt32(2, exp_);
    }
    if (((bitField0_ & 0x00000004) == 0x00000004)) {
      output.writeInt32(3, level_);
    }
    if (((bitField0_ & 0x00000008) == 0x00000008)) {
      output.writeInt32(4, matchScore_);
    }
    if (((bitField0_ & 0x00000010) == 0x00000010)) {
      output.writeUInt64(5, winGuildID_);
    }
    unknownFields.writeTo(output);
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (((bitField0_ & 0x00000001) == 0x00000001)) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(1, score_);
    }
    if (((bitField0_ & 0x00000002) == 0x00000002)) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(2, exp_);
    }
    if (((bitField0_ & 0x00000004) == 0x00000004)) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(3, level_);
    }
    if (((bitField0_ & 0x00000008) == 0x00000008)) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(4, matchScore_);
    }
    if (((bitField0_ & 0x00000010) == 0x00000010)) {
      size += com.google.protobuf.CodedOutputStream
        .computeUInt64Size(5, winGuildID_);
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
    if (!(obj instanceof com.dj.protobuf.guildBattle.BattleOverNtf)) {
      return super.equals(obj);
    }
    com.dj.protobuf.guildBattle.BattleOverNtf other = (com.dj.protobuf.guildBattle.BattleOverNtf) obj;

    boolean result = true;
    result = result && (hasScore() == other.hasScore());
    if (hasScore()) {
      result = result && (getScore()
          == other.getScore());
    }
    result = result && (hasExp() == other.hasExp());
    if (hasExp()) {
      result = result && (getExp()
          == other.getExp());
    }
    result = result && (hasLevel() == other.hasLevel());
    if (hasLevel()) {
      result = result && (getLevel()
          == other.getLevel());
    }
    result = result && (hasMatchScore() == other.hasMatchScore());
    if (hasMatchScore()) {
      result = result && (getMatchScore()
          == other.getMatchScore());
    }
    result = result && (hasWinGuildID() == other.hasWinGuildID());
    if (hasWinGuildID()) {
      result = result && (getWinGuildID()
          == other.getWinGuildID());
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
    if (hasScore()) {
      hash = (37 * hash) + SCORE_FIELD_NUMBER;
      hash = (53 * hash) + getScore();
    }
    if (hasExp()) {
      hash = (37 * hash) + EXP_FIELD_NUMBER;
      hash = (53 * hash) + getExp();
    }
    if (hasLevel()) {
      hash = (37 * hash) + LEVEL_FIELD_NUMBER;
      hash = (53 * hash) + getLevel();
    }
    if (hasMatchScore()) {
      hash = (37 * hash) + MATCHSCORE_FIELD_NUMBER;
      hash = (53 * hash) + getMatchScore();
    }
    if (hasWinGuildID()) {
      hash = (37 * hash) + WINGUILDID_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
          getWinGuildID());
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.dj.protobuf.guildBattle.BattleOverNtf parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dj.protobuf.guildBattle.BattleOverNtf parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dj.protobuf.guildBattle.BattleOverNtf parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dj.protobuf.guildBattle.BattleOverNtf parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dj.protobuf.guildBattle.BattleOverNtf parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.guildBattle.BattleOverNtf parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.dj.protobuf.guildBattle.BattleOverNtf parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.guildBattle.BattleOverNtf parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.dj.protobuf.guildBattle.BattleOverNtf parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.guildBattle.BattleOverNtf parseFrom(
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
  public static Builder newBuilder(com.dj.protobuf.guildBattle.BattleOverNtf prototype) {
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
   * / 游戏结束推送
   * / &lt;/summary&gt;
   * </pre>
   *
   * Protobuf type {@code Protocols.BattleOverNtf}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:Protocols.BattleOverNtf)
      com.dj.protobuf.guildBattle.BattleOverNtfOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.dj.protobuf.guildBattle.GuildBattle.internal_static_Protocols_BattleOverNtf_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.dj.protobuf.guildBattle.GuildBattle.internal_static_Protocols_BattleOverNtf_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.dj.protobuf.guildBattle.BattleOverNtf.class, com.dj.protobuf.guildBattle.BattleOverNtf.Builder.class);
    }

    // Construct using com.dj.protobuf.guildBattle.BattleOverNtf.newBuilder()
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
      score_ = 0;
      bitField0_ = (bitField0_ & ~0x00000001);
      exp_ = 0;
      bitField0_ = (bitField0_ & ~0x00000002);
      level_ = 0;
      bitField0_ = (bitField0_ & ~0x00000004);
      matchScore_ = 0;
      bitField0_ = (bitField0_ & ~0x00000008);
      winGuildID_ = 0L;
      bitField0_ = (bitField0_ & ~0x00000010);
      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.dj.protobuf.guildBattle.GuildBattle.internal_static_Protocols_BattleOverNtf_descriptor;
    }

    public com.dj.protobuf.guildBattle.BattleOverNtf getDefaultInstanceForType() {
      return com.dj.protobuf.guildBattle.BattleOverNtf.getDefaultInstance();
    }

    public com.dj.protobuf.guildBattle.BattleOverNtf build() {
      com.dj.protobuf.guildBattle.BattleOverNtf result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public com.dj.protobuf.guildBattle.BattleOverNtf buildPartial() {
      com.dj.protobuf.guildBattle.BattleOverNtf result = new com.dj.protobuf.guildBattle.BattleOverNtf(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
        to_bitField0_ |= 0x00000001;
      }
      result.score_ = score_;
      if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
        to_bitField0_ |= 0x00000002;
      }
      result.exp_ = exp_;
      if (((from_bitField0_ & 0x00000004) == 0x00000004)) {
        to_bitField0_ |= 0x00000004;
      }
      result.level_ = level_;
      if (((from_bitField0_ & 0x00000008) == 0x00000008)) {
        to_bitField0_ |= 0x00000008;
      }
      result.matchScore_ = matchScore_;
      if (((from_bitField0_ & 0x00000010) == 0x00000010)) {
        to_bitField0_ |= 0x00000010;
      }
      result.winGuildID_ = winGuildID_;
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
      if (other instanceof com.dj.protobuf.guildBattle.BattleOverNtf) {
        return mergeFrom((com.dj.protobuf.guildBattle.BattleOverNtf)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.dj.protobuf.guildBattle.BattleOverNtf other) {
      if (other == com.dj.protobuf.guildBattle.BattleOverNtf.getDefaultInstance()) return this;
      if (other.hasScore()) {
        setScore(other.getScore());
      }
      if (other.hasExp()) {
        setExp(other.getExp());
      }
      if (other.hasLevel()) {
        setLevel(other.getLevel());
      }
      if (other.hasMatchScore()) {
        setMatchScore(other.getMatchScore());
      }
      if (other.hasWinGuildID()) {
        setWinGuildID(other.getWinGuildID());
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
      com.dj.protobuf.guildBattle.BattleOverNtf parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.dj.protobuf.guildBattle.BattleOverNtf) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private int score_ ;
    /**
     * <pre>
     * 玩家商会总分数
     * </pre>
     *
     * <code>optional int32 score = 1;</code>
     */
    public boolean hasScore() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <pre>
     * 玩家商会总分数
     * </pre>
     *
     * <code>optional int32 score = 1;</code>
     */
    public int getScore() {
      return score_;
    }
    /**
     * <pre>
     * 玩家商会总分数
     * </pre>
     *
     * <code>optional int32 score = 1;</code>
     */
    public Builder setScore(int value) {
      bitField0_ |= 0x00000001;
      score_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * 玩家商会总分数
     * </pre>
     *
     * <code>optional int32 score = 1;</code>
     */
    public Builder clearScore() {
      bitField0_ = (bitField0_ & ~0x00000001);
      score_ = 0;
      onChanged();
      return this;
    }

    private int exp_ ;
    /**
     * <pre>
     * 玩家商会经验
     * </pre>
     *
     * <code>optional int32 exp = 2;</code>
     */
    public boolean hasExp() {
      return ((bitField0_ & 0x00000002) == 0x00000002);
    }
    /**
     * <pre>
     * 玩家商会经验
     * </pre>
     *
     * <code>optional int32 exp = 2;</code>
     */
    public int getExp() {
      return exp_;
    }
    /**
     * <pre>
     * 玩家商会经验
     * </pre>
     *
     * <code>optional int32 exp = 2;</code>
     */
    public Builder setExp(int value) {
      bitField0_ |= 0x00000002;
      exp_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * 玩家商会经验
     * </pre>
     *
     * <code>optional int32 exp = 2;</code>
     */
    public Builder clearExp() {
      bitField0_ = (bitField0_ & ~0x00000002);
      exp_ = 0;
      onChanged();
      return this;
    }

    private int level_ ;
    /**
     * <pre>
     * 玩家商会等级
     * </pre>
     *
     * <code>optional int32 level = 3;</code>
     */
    public boolean hasLevel() {
      return ((bitField0_ & 0x00000004) == 0x00000004);
    }
    /**
     * <pre>
     * 玩家商会等级
     * </pre>
     *
     * <code>optional int32 level = 3;</code>
     */
    public int getLevel() {
      return level_;
    }
    /**
     * <pre>
     * 玩家商会等级
     * </pre>
     *
     * <code>optional int32 level = 3;</code>
     */
    public Builder setLevel(int value) {
      bitField0_ |= 0x00000004;
      level_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * 玩家商会等级
     * </pre>
     *
     * <code>optional int32 level = 3;</code>
     */
    public Builder clearLevel() {
      bitField0_ = (bitField0_ & ~0x00000004);
      level_ = 0;
      onChanged();
      return this;
    }

    private int matchScore_ ;
    /**
     * <pre>
     * 对方商会总分数
     * </pre>
     *
     * <code>optional int32 matchScore = 4;</code>
     */
    public boolean hasMatchScore() {
      return ((bitField0_ & 0x00000008) == 0x00000008);
    }
    /**
     * <pre>
     * 对方商会总分数
     * </pre>
     *
     * <code>optional int32 matchScore = 4;</code>
     */
    public int getMatchScore() {
      return matchScore_;
    }
    /**
     * <pre>
     * 对方商会总分数
     * </pre>
     *
     * <code>optional int32 matchScore = 4;</code>
     */
    public Builder setMatchScore(int value) {
      bitField0_ |= 0x00000008;
      matchScore_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * 对方商会总分数
     * </pre>
     *
     * <code>optional int32 matchScore = 4;</code>
     */
    public Builder clearMatchScore() {
      bitField0_ = (bitField0_ & ~0x00000008);
      matchScore_ = 0;
      onChanged();
      return this;
    }

    private long winGuildID_ ;
    /**
     * <pre>
     * 胜利方商会id
     * </pre>
     *
     * <code>optional uint64 winGuildID = 5;</code>
     */
    public boolean hasWinGuildID() {
      return ((bitField0_ & 0x00000010) == 0x00000010);
    }
    /**
     * <pre>
     * 胜利方商会id
     * </pre>
     *
     * <code>optional uint64 winGuildID = 5;</code>
     */
    public long getWinGuildID() {
      return winGuildID_;
    }
    /**
     * <pre>
     * 胜利方商会id
     * </pre>
     *
     * <code>optional uint64 winGuildID = 5;</code>
     */
    public Builder setWinGuildID(long value) {
      bitField0_ |= 0x00000010;
      winGuildID_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * 胜利方商会id
     * </pre>
     *
     * <code>optional uint64 winGuildID = 5;</code>
     */
    public Builder clearWinGuildID() {
      bitField0_ = (bitField0_ & ~0x00000010);
      winGuildID_ = 0L;
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


    // @@protoc_insertion_point(builder_scope:Protocols.BattleOverNtf)
  }

  // @@protoc_insertion_point(class_scope:Protocols.BattleOverNtf)
  private static final com.dj.protobuf.guildBattle.BattleOverNtf DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.dj.protobuf.guildBattle.BattleOverNtf();
  }

  public static com.dj.protobuf.guildBattle.BattleOverNtf getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  @java.lang.Deprecated public static final com.google.protobuf.Parser<BattleOverNtf>
      PARSER = new com.google.protobuf.AbstractParser<BattleOverNtf>() {
    public BattleOverNtf parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new BattleOverNtf(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<BattleOverNtf> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<BattleOverNtf> getParserForType() {
    return PARSER;
  }

  public com.dj.protobuf.guildBattle.BattleOverNtf getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

