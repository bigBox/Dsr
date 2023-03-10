// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Login.proto

package com.dj.protobuf.login;

/**
 * Protobuf type {@code Protocols.RoleLoginNtf}
 */
public  final class RoleLoginNtf extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:Protocols.RoleLoginNtf)
    RoleLoginNtfOrBuilder {
  // Use RoleLoginNtf.newBuilder() to construct.
  private RoleLoginNtf(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private RoleLoginNtf() {
    errorID_ = 0;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private RoleLoginNtf(
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
            if (!((mutable_bitField0_ & 0x00000002) == 0x00000002)) {
              infos_ = com.google.protobuf.MapField.newMapField(
                  InfosDefaultEntryHolder.defaultEntry);
              mutable_bitField0_ |= 0x00000002;
            }
            com.google.protobuf.MapEntry<java.lang.Integer, com.dj.protobuf.login.PlayerLoginInfo>
            infos = input.readMessage(
                InfosDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistry);
            infos_.getMutableMap().put(infos.getKey(), infos.getValue());
            break;
          }
          case 26: {
            if (!((mutable_bitField0_ & 0x00000004) == 0x00000004)) {
              clientData_ = com.google.protobuf.MapField.newMapField(
                  ClientDataDefaultEntryHolder.defaultEntry);
              mutable_bitField0_ |= 0x00000004;
            }
            com.google.protobuf.MapEntry<java.lang.String, java.lang.Integer>
            clientData = input.readMessage(
                ClientDataDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistry);
            clientData_.getMutableMap().put(clientData.getKey(), clientData.getValue());
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
    return com.dj.protobuf.login.Login.internal_static_Protocols_RoleLoginNtf_descriptor;
  }

  @SuppressWarnings({"rawtypes"})
  protected com.google.protobuf.MapField internalGetMapField(
      int number) {
    switch (number) {
      case 2:
        return internalGetInfos();
      case 3:
        return internalGetClientData();
      default:
        throw new RuntimeException(
            "Invalid map field number: " + number);
    }
  }
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.dj.protobuf.login.Login.internal_static_Protocols_RoleLoginNtf_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.dj.protobuf.login.RoleLoginNtf.class, com.dj.protobuf.login.RoleLoginNtf.Builder.class);
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

  public static final int INFOS_FIELD_NUMBER = 2;
  private static final class InfosDefaultEntryHolder {
    static final com.google.protobuf.MapEntry<
        java.lang.Integer, com.dj.protobuf.login.PlayerLoginInfo> defaultEntry =
            com.google.protobuf.MapEntry
            .<java.lang.Integer, com.dj.protobuf.login.PlayerLoginInfo>newDefaultInstance(
                com.dj.protobuf.login.Login.internal_static_Protocols_RoleLoginNtf_InfosEntry_descriptor, 
                com.google.protobuf.WireFormat.FieldType.INT32,
                0,
                com.google.protobuf.WireFormat.FieldType.MESSAGE,
                com.dj.protobuf.login.PlayerLoginInfo.getDefaultInstance());
  }
  private com.google.protobuf.MapField<
      java.lang.Integer, com.dj.protobuf.login.PlayerLoginInfo> infos_;
  private com.google.protobuf.MapField<java.lang.Integer, com.dj.protobuf.login.PlayerLoginInfo>
  internalGetInfos() {
    if (infos_ == null) {
      return com.google.protobuf.MapField.emptyMapField(
          InfosDefaultEntryHolder.defaultEntry);
    }
    return infos_;
  }

  public int getInfosCount() {
    return internalGetInfos().getMap().size();
  }
  /**
   * <code>map&lt;int32, .Protocols.PlayerLoginInfo&gt; infos = 2;</code>
   */

  public boolean containsInfos(
      int key) {
    
    return internalGetInfos().getMap().containsKey(key);
  }
  /**
   * Use {@link #getInfosMap()} instead.
   */
  @java.lang.Deprecated
  public java.util.Map<java.lang.Integer, com.dj.protobuf.login.PlayerLoginInfo> getInfos() {
    return getInfosMap();
  }
  /**
   * <code>map&lt;int32, .Protocols.PlayerLoginInfo&gt; infos = 2;</code>
   */

  public java.util.Map<java.lang.Integer, com.dj.protobuf.login.PlayerLoginInfo> getInfosMap() {
    return internalGetInfos().getMap();
  }
  /**
   * <code>map&lt;int32, .Protocols.PlayerLoginInfo&gt; infos = 2;</code>
   */

  public com.dj.protobuf.login.PlayerLoginInfo getInfosOrDefault(
      int key,
      com.dj.protobuf.login.PlayerLoginInfo defaultValue) {
    
    java.util.Map<java.lang.Integer, com.dj.protobuf.login.PlayerLoginInfo> map =
        internalGetInfos().getMap();
    return map.containsKey(key) ? map.get(key) : defaultValue;
  }
  /**
   * <code>map&lt;int32, .Protocols.PlayerLoginInfo&gt; infos = 2;</code>
   */

  public com.dj.protobuf.login.PlayerLoginInfo getInfosOrThrow(
      int key) {
    
    java.util.Map<java.lang.Integer, com.dj.protobuf.login.PlayerLoginInfo> map =
        internalGetInfos().getMap();
    if (!map.containsKey(key)) {
      throw new java.lang.IllegalArgumentException();
    }
    return map.get(key);
  }

  public static final int CLIENTDATA_FIELD_NUMBER = 3;
  private static final class ClientDataDefaultEntryHolder {
    static final com.google.protobuf.MapEntry<
        java.lang.String, java.lang.Integer> defaultEntry =
            com.google.protobuf.MapEntry
            .<java.lang.String, java.lang.Integer>newDefaultInstance(
                com.dj.protobuf.login.Login.internal_static_Protocols_RoleLoginNtf_ClientDataEntry_descriptor, 
                com.google.protobuf.WireFormat.FieldType.STRING,
                "",
                com.google.protobuf.WireFormat.FieldType.INT32,
                0);
  }
  private com.google.protobuf.MapField<
      java.lang.String, java.lang.Integer> clientData_;
  private com.google.protobuf.MapField<java.lang.String, java.lang.Integer>
  internalGetClientData() {
    if (clientData_ == null) {
      return com.google.protobuf.MapField.emptyMapField(
          ClientDataDefaultEntryHolder.defaultEntry);
    }
    return clientData_;
  }

  public int getClientDataCount() {
    return internalGetClientData().getMap().size();
  }
  /**
   * <code>map&lt;string, int32&gt; clientData = 3;</code>
   */

  public boolean containsClientData(
      java.lang.String key) {
    if (key == null) { throw new java.lang.NullPointerException(); }
    return internalGetClientData().getMap().containsKey(key);
  }
  /**
   * Use {@link #getClientDataMap()} instead.
   */
  @java.lang.Deprecated
  public java.util.Map<java.lang.String, java.lang.Integer> getClientData() {
    return getClientDataMap();
  }
  /**
   * <code>map&lt;string, int32&gt; clientData = 3;</code>
   */

  public java.util.Map<java.lang.String, java.lang.Integer> getClientDataMap() {
    return internalGetClientData().getMap();
  }
  /**
   * <code>map&lt;string, int32&gt; clientData = 3;</code>
   */

  public int getClientDataOrDefault(
      java.lang.String key,
      int defaultValue) {
    if (key == null) { throw new java.lang.NullPointerException(); }
    java.util.Map<java.lang.String, java.lang.Integer> map =
        internalGetClientData().getMap();
    return map.containsKey(key) ? map.get(key) : defaultValue;
  }
  /**
   * <code>map&lt;string, int32&gt; clientData = 3;</code>
   */

  public int getClientDataOrThrow(
      java.lang.String key) {
    if (key == null) { throw new java.lang.NullPointerException(); }
    java.util.Map<java.lang.String, java.lang.Integer> map =
        internalGetClientData().getMap();
    if (!map.containsKey(key)) {
      throw new java.lang.IllegalArgumentException();
    }
    return map.get(key);
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
    for (java.util.Map.Entry<java.lang.Integer, com.dj.protobuf.login.PlayerLoginInfo> entry
         : internalGetInfos().getMap().entrySet()) {
      com.google.protobuf.MapEntry<java.lang.Integer, com.dj.protobuf.login.PlayerLoginInfo>
      infos = InfosDefaultEntryHolder.defaultEntry.newBuilderForType()
          .setKey(entry.getKey())
          .setValue(entry.getValue())
          .build();
      output.writeMessage(2, infos);
    }
    for (java.util.Map.Entry<java.lang.String, java.lang.Integer> entry
         : internalGetClientData().getMap().entrySet()) {
      com.google.protobuf.MapEntry<java.lang.String, java.lang.Integer>
      clientData = ClientDataDefaultEntryHolder.defaultEntry.newBuilderForType()
          .setKey(entry.getKey())
          .setValue(entry.getValue())
          .build();
      output.writeMessage(3, clientData);
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
    for (java.util.Map.Entry<java.lang.Integer, com.dj.protobuf.login.PlayerLoginInfo> entry
         : internalGetInfos().getMap().entrySet()) {
      com.google.protobuf.MapEntry<java.lang.Integer, com.dj.protobuf.login.PlayerLoginInfo>
      infos = InfosDefaultEntryHolder.defaultEntry.newBuilderForType()
          .setKey(entry.getKey())
          .setValue(entry.getValue())
          .build();
      size += com.google.protobuf.CodedOutputStream
          .computeMessageSize(2, infos);
    }
    for (java.util.Map.Entry<java.lang.String, java.lang.Integer> entry
         : internalGetClientData().getMap().entrySet()) {
      com.google.protobuf.MapEntry<java.lang.String, java.lang.Integer>
      clientData = ClientDataDefaultEntryHolder.defaultEntry.newBuilderForType()
          .setKey(entry.getKey())
          .setValue(entry.getValue())
          .build();
      size += com.google.protobuf.CodedOutputStream
          .computeMessageSize(3, clientData);
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
    if (!(obj instanceof com.dj.protobuf.login.RoleLoginNtf)) {
      return super.equals(obj);
    }
    com.dj.protobuf.login.RoleLoginNtf other = (com.dj.protobuf.login.RoleLoginNtf) obj;

    boolean result = true;
    result = result && (hasErrorID() == other.hasErrorID());
    if (hasErrorID()) {
      result = result && errorID_ == other.errorID_;
    }
    result = result && internalGetInfos().equals(
        other.internalGetInfos());
    result = result && internalGetClientData().equals(
        other.internalGetClientData());
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
    if (!internalGetInfos().getMap().isEmpty()) {
      hash = (37 * hash) + INFOS_FIELD_NUMBER;
      hash = (53 * hash) + internalGetInfos().hashCode();
    }
    if (!internalGetClientData().getMap().isEmpty()) {
      hash = (37 * hash) + CLIENTDATA_FIELD_NUMBER;
      hash = (53 * hash) + internalGetClientData().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.dj.protobuf.login.RoleLoginNtf parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dj.protobuf.login.RoleLoginNtf parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dj.protobuf.login.RoleLoginNtf parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dj.protobuf.login.RoleLoginNtf parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dj.protobuf.login.RoleLoginNtf parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.login.RoleLoginNtf parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.dj.protobuf.login.RoleLoginNtf parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.login.RoleLoginNtf parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.dj.protobuf.login.RoleLoginNtf parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.login.RoleLoginNtf parseFrom(
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
  public static Builder newBuilder(com.dj.protobuf.login.RoleLoginNtf prototype) {
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
   * Protobuf type {@code Protocols.RoleLoginNtf}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:Protocols.RoleLoginNtf)
      com.dj.protobuf.login.RoleLoginNtfOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.dj.protobuf.login.Login.internal_static_Protocols_RoleLoginNtf_descriptor;
    }

    @SuppressWarnings({"rawtypes"})
    protected com.google.protobuf.MapField internalGetMapField(
        int number) {
      switch (number) {
        case 2:
          return internalGetInfos();
        case 3:
          return internalGetClientData();
        default:
          throw new RuntimeException(
              "Invalid map field number: " + number);
      }
    }
    @SuppressWarnings({"rawtypes"})
    protected com.google.protobuf.MapField internalGetMutableMapField(
        int number) {
      switch (number) {
        case 2:
          return internalGetMutableInfos();
        case 3:
          return internalGetMutableClientData();
        default:
          throw new RuntimeException(
              "Invalid map field number: " + number);
      }
    }
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.dj.protobuf.login.Login.internal_static_Protocols_RoleLoginNtf_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.dj.protobuf.login.RoleLoginNtf.class, com.dj.protobuf.login.RoleLoginNtf.Builder.class);
    }

    // Construct using com.dj.protobuf.login.RoleLoginNtf.newBuilder()
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
      errorID_ = 0;
      bitField0_ = (bitField0_ & ~0x00000001);
      internalGetMutableInfos().clear();
      internalGetMutableClientData().clear();
      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.dj.protobuf.login.Login.internal_static_Protocols_RoleLoginNtf_descriptor;
    }

    public com.dj.protobuf.login.RoleLoginNtf getDefaultInstanceForType() {
      return com.dj.protobuf.login.RoleLoginNtf.getDefaultInstance();
    }

    public com.dj.protobuf.login.RoleLoginNtf build() {
      com.dj.protobuf.login.RoleLoginNtf result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public com.dj.protobuf.login.RoleLoginNtf buildPartial() {
      com.dj.protobuf.login.RoleLoginNtf result = new com.dj.protobuf.login.RoleLoginNtf(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
        to_bitField0_ |= 0x00000001;
      }
      result.errorID_ = errorID_;
      result.infos_ = internalGetInfos();
      result.infos_.makeImmutable();
      result.clientData_ = internalGetClientData();
      result.clientData_.makeImmutable();
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
      if (other instanceof com.dj.protobuf.login.RoleLoginNtf) {
        return mergeFrom((com.dj.protobuf.login.RoleLoginNtf)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.dj.protobuf.login.RoleLoginNtf other) {
      if (other == com.dj.protobuf.login.RoleLoginNtf.getDefaultInstance()) return this;
      if (other.hasErrorID()) {
        setErrorID(other.getErrorID());
      }
      internalGetMutableInfos().mergeFrom(
          other.internalGetInfos());
      internalGetMutableClientData().mergeFrom(
          other.internalGetClientData());
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
      com.dj.protobuf.login.RoleLoginNtf parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.dj.protobuf.login.RoleLoginNtf) e.getUnfinishedMessage();
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

    private com.google.protobuf.MapField<
        java.lang.Integer, com.dj.protobuf.login.PlayerLoginInfo> infos_;
    private com.google.protobuf.MapField<java.lang.Integer, com.dj.protobuf.login.PlayerLoginInfo>
    internalGetInfos() {
      if (infos_ == null) {
        return com.google.protobuf.MapField.emptyMapField(
            InfosDefaultEntryHolder.defaultEntry);
      }
      return infos_;
    }
    private com.google.protobuf.MapField<java.lang.Integer, com.dj.protobuf.login.PlayerLoginInfo>
    internalGetMutableInfos() {
      onChanged();;
      if (infos_ == null) {
        infos_ = com.google.protobuf.MapField.newMapField(
            InfosDefaultEntryHolder.defaultEntry);
      }
      if (!infos_.isMutable()) {
        infos_ = infos_.copy();
      }
      return infos_;
    }

    public int getInfosCount() {
      return internalGetInfos().getMap().size();
    }
    /**
     * <code>map&lt;int32, .Protocols.PlayerLoginInfo&gt; infos = 2;</code>
     */

    public boolean containsInfos(
        int key) {
      
      return internalGetInfos().getMap().containsKey(key);
    }
    /**
     * Use {@link #getInfosMap()} instead.
     */
    @java.lang.Deprecated
    public java.util.Map<java.lang.Integer, com.dj.protobuf.login.PlayerLoginInfo> getInfos() {
      return getInfosMap();
    }
    /**
     * <code>map&lt;int32, .Protocols.PlayerLoginInfo&gt; infos = 2;</code>
     */

    public java.util.Map<java.lang.Integer, com.dj.protobuf.login.PlayerLoginInfo> getInfosMap() {
      return internalGetInfos().getMap();
    }
    /**
     * <code>map&lt;int32, .Protocols.PlayerLoginInfo&gt; infos = 2;</code>
     */

    public com.dj.protobuf.login.PlayerLoginInfo getInfosOrDefault(
        int key,
        com.dj.protobuf.login.PlayerLoginInfo defaultValue) {
      
      java.util.Map<java.lang.Integer, com.dj.protobuf.login.PlayerLoginInfo> map =
          internalGetInfos().getMap();
      return map.containsKey(key) ? map.get(key) : defaultValue;
    }
    /**
     * <code>map&lt;int32, .Protocols.PlayerLoginInfo&gt; infos = 2;</code>
     */

    public com.dj.protobuf.login.PlayerLoginInfo getInfosOrThrow(
        int key) {
      
      java.util.Map<java.lang.Integer, com.dj.protobuf.login.PlayerLoginInfo> map =
          internalGetInfos().getMap();
      if (!map.containsKey(key)) {
        throw new java.lang.IllegalArgumentException();
      }
      return map.get(key);
    }

    public Builder clearInfos() {
      getMutableInfos().clear();
      return this;
    }
    /**
     * <code>map&lt;int32, .Protocols.PlayerLoginInfo&gt; infos = 2;</code>
     */

    public Builder removeInfos(
        int key) {
      
      getMutableInfos().remove(key);
      return this;
    }
    /**
     * Use alternate mutation accessors instead.
     */
    @java.lang.Deprecated
    public java.util.Map<java.lang.Integer, com.dj.protobuf.login.PlayerLoginInfo>
    getMutableInfos() {
      return internalGetMutableInfos().getMutableMap();
    }
    /**
     * <code>map&lt;int32, .Protocols.PlayerLoginInfo&gt; infos = 2;</code>
     */
    public Builder putInfos(
        int key,
        com.dj.protobuf.login.PlayerLoginInfo value) {
      
      if (value == null) { throw new java.lang.NullPointerException(); }
      getMutableInfos().put(key, value);
      return this;
    }
    /**
     * <code>map&lt;int32, .Protocols.PlayerLoginInfo&gt; infos = 2;</code>
     */

    public Builder putAllInfos(
        java.util.Map<java.lang.Integer, com.dj.protobuf.login.PlayerLoginInfo> values) {
      getMutableInfos().putAll(values);
      return this;
    }

    private com.google.protobuf.MapField<
        java.lang.String, java.lang.Integer> clientData_;
    private com.google.protobuf.MapField<java.lang.String, java.lang.Integer>
    internalGetClientData() {
      if (clientData_ == null) {
        return com.google.protobuf.MapField.emptyMapField(
            ClientDataDefaultEntryHolder.defaultEntry);
      }
      return clientData_;
    }
    private com.google.protobuf.MapField<java.lang.String, java.lang.Integer>
    internalGetMutableClientData() {
      onChanged();;
      if (clientData_ == null) {
        clientData_ = com.google.protobuf.MapField.newMapField(
            ClientDataDefaultEntryHolder.defaultEntry);
      }
      if (!clientData_.isMutable()) {
        clientData_ = clientData_.copy();
      }
      return clientData_;
    }

    public int getClientDataCount() {
      return internalGetClientData().getMap().size();
    }
    /**
     * <code>map&lt;string, int32&gt; clientData = 3;</code>
     */

    public boolean containsClientData(
        java.lang.String key) {
      if (key == null) { throw new java.lang.NullPointerException(); }
      return internalGetClientData().getMap().containsKey(key);
    }
    /**
     * Use {@link #getClientDataMap()} instead.
     */
    @java.lang.Deprecated
    public java.util.Map<java.lang.String, java.lang.Integer> getClientData() {
      return getClientDataMap();
    }
    /**
     * <code>map&lt;string, int32&gt; clientData = 3;</code>
     */

    public java.util.Map<java.lang.String, java.lang.Integer> getClientDataMap() {
      return internalGetClientData().getMap();
    }
    /**
     * <code>map&lt;string, int32&gt; clientData = 3;</code>
     */

    public int getClientDataOrDefault(
        java.lang.String key,
        int defaultValue) {
      if (key == null) { throw new java.lang.NullPointerException(); }
      java.util.Map<java.lang.String, java.lang.Integer> map =
          internalGetClientData().getMap();
      return map.containsKey(key) ? map.get(key) : defaultValue;
    }
    /**
     * <code>map&lt;string, int32&gt; clientData = 3;</code>
     */

    public int getClientDataOrThrow(
        java.lang.String key) {
      if (key == null) { throw new java.lang.NullPointerException(); }
      java.util.Map<java.lang.String, java.lang.Integer> map =
          internalGetClientData().getMap();
      if (!map.containsKey(key)) {
        throw new java.lang.IllegalArgumentException();
      }
      return map.get(key);
    }

    public Builder clearClientData() {
      getMutableClientData().clear();
      return this;
    }
    /**
     * <code>map&lt;string, int32&gt; clientData = 3;</code>
     */

    public Builder removeClientData(
        java.lang.String key) {
      if (key == null) { throw new java.lang.NullPointerException(); }
      getMutableClientData().remove(key);
      return this;
    }
    /**
     * Use alternate mutation accessors instead.
     */
    @java.lang.Deprecated
    public java.util.Map<java.lang.String, java.lang.Integer>
    getMutableClientData() {
      return internalGetMutableClientData().getMutableMap();
    }
    /**
     * <code>map&lt;string, int32&gt; clientData = 3;</code>
     */
    public Builder putClientData(
        java.lang.String key,
        int value) {
      if (key == null) { throw new java.lang.NullPointerException(); }
      
      getMutableClientData().put(key, value);
      return this;
    }
    /**
     * <code>map&lt;string, int32&gt; clientData = 3;</code>
     */

    public Builder putAllClientData(
        java.util.Map<java.lang.String, java.lang.Integer> values) {
      getMutableClientData().putAll(values);
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


    // @@protoc_insertion_point(builder_scope:Protocols.RoleLoginNtf)
  }

  // @@protoc_insertion_point(class_scope:Protocols.RoleLoginNtf)
  private static final com.dj.protobuf.login.RoleLoginNtf DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.dj.protobuf.login.RoleLoginNtf();
  }

  public static com.dj.protobuf.login.RoleLoginNtf getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  @java.lang.Deprecated public static final com.google.protobuf.Parser<RoleLoginNtf>
      PARSER = new com.google.protobuf.AbstractParser<RoleLoginNtf>() {
    public RoleLoginNtf parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new RoleLoginNtf(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<RoleLoginNtf> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<RoleLoginNtf> getParserForType() {
    return PARSER;
  }

  public com.dj.protobuf.login.RoleLoginNtf getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

