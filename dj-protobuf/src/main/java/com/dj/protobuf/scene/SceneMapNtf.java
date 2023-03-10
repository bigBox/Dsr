// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Scene.proto

package com.dj.protobuf.scene;

/**
 * Protobuf type {@code Protocols.SceneMapNtf}
 */
public  final class SceneMapNtf extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:Protocols.SceneMapNtf)
    SceneMapNtfOrBuilder {
  // Use SceneMapNtf.newBuilder() to construct.
  private SceneMapNtf(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private SceneMapNtf() {
    cells_ = java.util.Collections.emptyList();
    type_ = 0;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private SceneMapNtf(
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
              cells_ = new java.util.ArrayList<com.dj.protobuf.scene.SceneCell>();
              mutable_bitField0_ |= 0x00000001;
            }
            cells_.add(
                input.readMessage(com.dj.protobuf.scene.SceneCell.PARSER, extensionRegistry));
            break;
          }
          case 16: {
            int rawValue = input.readEnum();
            com.dj.protobuf.common.SceneUpdateType value = com.dj.protobuf.common.SceneUpdateType.valueOf(rawValue);
            if (value == null) {
              unknownFields.mergeVarintField(2, rawValue);
            } else {
              bitField0_ |= 0x00000001;
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
      if (((mutable_bitField0_ & 0x00000001) == 0x00000001)) {
        cells_ = java.util.Collections.unmodifiableList(cells_);
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.dj.protobuf.scene.Scene.internal_static_Protocols_SceneMapNtf_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.dj.protobuf.scene.Scene.internal_static_Protocols_SceneMapNtf_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.dj.protobuf.scene.SceneMapNtf.class, com.dj.protobuf.scene.SceneMapNtf.Builder.class);
  }

  private int bitField0_;
  public static final int CELLS_FIELD_NUMBER = 1;
  private java.util.List<com.dj.protobuf.scene.SceneCell> cells_;
  /**
   * <code>repeated .Protocols.SceneCell cells = 1;</code>
   */
  public java.util.List<com.dj.protobuf.scene.SceneCell> getCellsList() {
    return cells_;
  }
  /**
   * <code>repeated .Protocols.SceneCell cells = 1;</code>
   */
  public java.util.List<? extends com.dj.protobuf.scene.SceneCellOrBuilder> 
      getCellsOrBuilderList() {
    return cells_;
  }
  /**
   * <code>repeated .Protocols.SceneCell cells = 1;</code>
   */
  public int getCellsCount() {
    return cells_.size();
  }
  /**
   * <code>repeated .Protocols.SceneCell cells = 1;</code>
   */
  public com.dj.protobuf.scene.SceneCell getCells(int index) {
    return cells_.get(index);
  }
  /**
   * <code>repeated .Protocols.SceneCell cells = 1;</code>
   */
  public com.dj.protobuf.scene.SceneCellOrBuilder getCellsOrBuilder(
      int index) {
    return cells_.get(index);
  }

  public static final int TYPE_FIELD_NUMBER = 2;
  private int type_;
  /**
   * <code>optional .Protocols.SceneUpdateType type = 2;</code>
   */
  public boolean hasType() {
    return ((bitField0_ & 0x00000001) == 0x00000001);
  }
  /**
   * <code>optional .Protocols.SceneUpdateType type = 2;</code>
   */
  public com.dj.protobuf.common.SceneUpdateType getType() {
    com.dj.protobuf.common.SceneUpdateType result = com.dj.protobuf.common.SceneUpdateType.valueOf(type_);
    return result == null ? com.dj.protobuf.common.SceneUpdateType.Total : result;
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
    for (int i = 0; i < cells_.size(); i++) {
      output.writeMessage(1, cells_.get(i));
    }
    if (((bitField0_ & 0x00000001) == 0x00000001)) {
      output.writeEnum(2, type_);
    }
    unknownFields.writeTo(output);
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    for (int i = 0; i < cells_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, cells_.get(i));
    }
    if (((bitField0_ & 0x00000001) == 0x00000001)) {
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
    if (!(obj instanceof com.dj.protobuf.scene.SceneMapNtf)) {
      return super.equals(obj);
    }
    com.dj.protobuf.scene.SceneMapNtf other = (com.dj.protobuf.scene.SceneMapNtf) obj;

    boolean result = true;
    result = result && getCellsList()
        .equals(other.getCellsList());
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
    if (getCellsCount() > 0) {
      hash = (37 * hash) + CELLS_FIELD_NUMBER;
      hash = (53 * hash) + getCellsList().hashCode();
    }
    if (hasType()) {
      hash = (37 * hash) + TYPE_FIELD_NUMBER;
      hash = (53 * hash) + type_;
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.dj.protobuf.scene.SceneMapNtf parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dj.protobuf.scene.SceneMapNtf parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dj.protobuf.scene.SceneMapNtf parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dj.protobuf.scene.SceneMapNtf parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dj.protobuf.scene.SceneMapNtf parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.scene.SceneMapNtf parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.dj.protobuf.scene.SceneMapNtf parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.scene.SceneMapNtf parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.dj.protobuf.scene.SceneMapNtf parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dj.protobuf.scene.SceneMapNtf parseFrom(
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
  public static Builder newBuilder(com.dj.protobuf.scene.SceneMapNtf prototype) {
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
   * Protobuf type {@code Protocols.SceneMapNtf}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:Protocols.SceneMapNtf)
      com.dj.protobuf.scene.SceneMapNtfOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.dj.protobuf.scene.Scene.internal_static_Protocols_SceneMapNtf_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.dj.protobuf.scene.Scene.internal_static_Protocols_SceneMapNtf_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.dj.protobuf.scene.SceneMapNtf.class, com.dj.protobuf.scene.SceneMapNtf.Builder.class);
    }

    // Construct using com.dj.protobuf.scene.SceneMapNtf.newBuilder()
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
        getCellsFieldBuilder();
      }
    }
    public Builder clear() {
      super.clear();
      if (cellsBuilder_ == null) {
        cells_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
      } else {
        cellsBuilder_.clear();
      }
      type_ = 0;
      bitField0_ = (bitField0_ & ~0x00000002);
      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.dj.protobuf.scene.Scene.internal_static_Protocols_SceneMapNtf_descriptor;
    }

    public com.dj.protobuf.scene.SceneMapNtf getDefaultInstanceForType() {
      return com.dj.protobuf.scene.SceneMapNtf.getDefaultInstance();
    }

    public com.dj.protobuf.scene.SceneMapNtf build() {
      com.dj.protobuf.scene.SceneMapNtf result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public com.dj.protobuf.scene.SceneMapNtf buildPartial() {
      com.dj.protobuf.scene.SceneMapNtf result = new com.dj.protobuf.scene.SceneMapNtf(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      if (cellsBuilder_ == null) {
        if (((bitField0_ & 0x00000001) == 0x00000001)) {
          cells_ = java.util.Collections.unmodifiableList(cells_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.cells_ = cells_;
      } else {
        result.cells_ = cellsBuilder_.build();
      }
      if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
        to_bitField0_ |= 0x00000001;
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
      if (other instanceof com.dj.protobuf.scene.SceneMapNtf) {
        return mergeFrom((com.dj.protobuf.scene.SceneMapNtf)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.dj.protobuf.scene.SceneMapNtf other) {
      if (other == com.dj.protobuf.scene.SceneMapNtf.getDefaultInstance()) return this;
      if (cellsBuilder_ == null) {
        if (!other.cells_.isEmpty()) {
          if (cells_.isEmpty()) {
            cells_ = other.cells_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensureCellsIsMutable();
            cells_.addAll(other.cells_);
          }
          onChanged();
        }
      } else {
        if (!other.cells_.isEmpty()) {
          if (cellsBuilder_.isEmpty()) {
            cellsBuilder_.dispose();
            cellsBuilder_ = null;
            cells_ = other.cells_;
            bitField0_ = (bitField0_ & ~0x00000001);
            cellsBuilder_ = 
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getCellsFieldBuilder() : null;
          } else {
            cellsBuilder_.addAllMessages(other.cells_);
          }
        }
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
      com.dj.protobuf.scene.SceneMapNtf parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.dj.protobuf.scene.SceneMapNtf) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private java.util.List<com.dj.protobuf.scene.SceneCell> cells_ =
      java.util.Collections.emptyList();
    private void ensureCellsIsMutable() {
      if (!((bitField0_ & 0x00000001) == 0x00000001)) {
        cells_ = new java.util.ArrayList<com.dj.protobuf.scene.SceneCell>(cells_);
        bitField0_ |= 0x00000001;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        com.dj.protobuf.scene.SceneCell, com.dj.protobuf.scene.SceneCell.Builder, com.dj.protobuf.scene.SceneCellOrBuilder> cellsBuilder_;

    /**
     * <code>repeated .Protocols.SceneCell cells = 1;</code>
     */
    public java.util.List<com.dj.protobuf.scene.SceneCell> getCellsList() {
      if (cellsBuilder_ == null) {
        return java.util.Collections.unmodifiableList(cells_);
      } else {
        return cellsBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .Protocols.SceneCell cells = 1;</code>
     */
    public int getCellsCount() {
      if (cellsBuilder_ == null) {
        return cells_.size();
      } else {
        return cellsBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .Protocols.SceneCell cells = 1;</code>
     */
    public com.dj.protobuf.scene.SceneCell getCells(int index) {
      if (cellsBuilder_ == null) {
        return cells_.get(index);
      } else {
        return cellsBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .Protocols.SceneCell cells = 1;</code>
     */
    public Builder setCells(
        int index, com.dj.protobuf.scene.SceneCell value) {
      if (cellsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureCellsIsMutable();
        cells_.set(index, value);
        onChanged();
      } else {
        cellsBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .Protocols.SceneCell cells = 1;</code>
     */
    public Builder setCells(
        int index, com.dj.protobuf.scene.SceneCell.Builder builderForValue) {
      if (cellsBuilder_ == null) {
        ensureCellsIsMutable();
        cells_.set(index, builderForValue.build());
        onChanged();
      } else {
        cellsBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .Protocols.SceneCell cells = 1;</code>
     */
    public Builder addCells(com.dj.protobuf.scene.SceneCell value) {
      if (cellsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureCellsIsMutable();
        cells_.add(value);
        onChanged();
      } else {
        cellsBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .Protocols.SceneCell cells = 1;</code>
     */
    public Builder addCells(
        int index, com.dj.protobuf.scene.SceneCell value) {
      if (cellsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureCellsIsMutable();
        cells_.add(index, value);
        onChanged();
      } else {
        cellsBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .Protocols.SceneCell cells = 1;</code>
     */
    public Builder addCells(
        com.dj.protobuf.scene.SceneCell.Builder builderForValue) {
      if (cellsBuilder_ == null) {
        ensureCellsIsMutable();
        cells_.add(builderForValue.build());
        onChanged();
      } else {
        cellsBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .Protocols.SceneCell cells = 1;</code>
     */
    public Builder addCells(
        int index, com.dj.protobuf.scene.SceneCell.Builder builderForValue) {
      if (cellsBuilder_ == null) {
        ensureCellsIsMutable();
        cells_.add(index, builderForValue.build());
        onChanged();
      } else {
        cellsBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .Protocols.SceneCell cells = 1;</code>
     */
    public Builder addAllCells(
        java.lang.Iterable<? extends com.dj.protobuf.scene.SceneCell> values) {
      if (cellsBuilder_ == null) {
        ensureCellsIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, cells_);
        onChanged();
      } else {
        cellsBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .Protocols.SceneCell cells = 1;</code>
     */
    public Builder clearCells() {
      if (cellsBuilder_ == null) {
        cells_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
      } else {
        cellsBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .Protocols.SceneCell cells = 1;</code>
     */
    public Builder removeCells(int index) {
      if (cellsBuilder_ == null) {
        ensureCellsIsMutable();
        cells_.remove(index);
        onChanged();
      } else {
        cellsBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .Protocols.SceneCell cells = 1;</code>
     */
    public com.dj.protobuf.scene.SceneCell.Builder getCellsBuilder(
        int index) {
      return getCellsFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .Protocols.SceneCell cells = 1;</code>
     */
    public com.dj.protobuf.scene.SceneCellOrBuilder getCellsOrBuilder(
        int index) {
      if (cellsBuilder_ == null) {
        return cells_.get(index);  } else {
        return cellsBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .Protocols.SceneCell cells = 1;</code>
     */
    public java.util.List<? extends com.dj.protobuf.scene.SceneCellOrBuilder> 
         getCellsOrBuilderList() {
      if (cellsBuilder_ != null) {
        return cellsBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(cells_);
      }
    }
    /**
     * <code>repeated .Protocols.SceneCell cells = 1;</code>
     */
    public com.dj.protobuf.scene.SceneCell.Builder addCellsBuilder() {
      return getCellsFieldBuilder().addBuilder(
          com.dj.protobuf.scene.SceneCell.getDefaultInstance());
    }
    /**
     * <code>repeated .Protocols.SceneCell cells = 1;</code>
     */
    public com.dj.protobuf.scene.SceneCell.Builder addCellsBuilder(
        int index) {
      return getCellsFieldBuilder().addBuilder(
          index, com.dj.protobuf.scene.SceneCell.getDefaultInstance());
    }
    /**
     * <code>repeated .Protocols.SceneCell cells = 1;</code>
     */
    public java.util.List<com.dj.protobuf.scene.SceneCell.Builder> 
         getCellsBuilderList() {
      return getCellsFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        com.dj.protobuf.scene.SceneCell, com.dj.protobuf.scene.SceneCell.Builder, com.dj.protobuf.scene.SceneCellOrBuilder> 
        getCellsFieldBuilder() {
      if (cellsBuilder_ == null) {
        cellsBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            com.dj.protobuf.scene.SceneCell, com.dj.protobuf.scene.SceneCell.Builder, com.dj.protobuf.scene.SceneCellOrBuilder>(
                cells_,
                ((bitField0_ & 0x00000001) == 0x00000001),
                getParentForChildren(),
                isClean());
        cells_ = null;
      }
      return cellsBuilder_;
    }

    private int type_ = 0;
    /**
     * <code>optional .Protocols.SceneUpdateType type = 2;</code>
     */
    public boolean hasType() {
      return ((bitField0_ & 0x00000002) == 0x00000002);
    }
    /**
     * <code>optional .Protocols.SceneUpdateType type = 2;</code>
     */
    public com.dj.protobuf.common.SceneUpdateType getType() {
      com.dj.protobuf.common.SceneUpdateType result = com.dj.protobuf.common.SceneUpdateType.valueOf(type_);
      return result == null ? com.dj.protobuf.common.SceneUpdateType.Total : result;
    }
    /**
     * <code>optional .Protocols.SceneUpdateType type = 2;</code>
     */
    public Builder setType(com.dj.protobuf.common.SceneUpdateType value) {
      if (value == null) {
        throw new NullPointerException();
      }
      bitField0_ |= 0x00000002;
      type_ = value.getNumber();
      onChanged();
      return this;
    }
    /**
     * <code>optional .Protocols.SceneUpdateType type = 2;</code>
     */
    public Builder clearType() {
      bitField0_ = (bitField0_ & ~0x00000002);
      type_ = 0;
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


    // @@protoc_insertion_point(builder_scope:Protocols.SceneMapNtf)
  }

  // @@protoc_insertion_point(class_scope:Protocols.SceneMapNtf)
  private static final com.dj.protobuf.scene.SceneMapNtf DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.dj.protobuf.scene.SceneMapNtf();
  }

  public static com.dj.protobuf.scene.SceneMapNtf getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  @java.lang.Deprecated public static final com.google.protobuf.Parser<SceneMapNtf>
      PARSER = new com.google.protobuf.AbstractParser<SceneMapNtf>() {
    public SceneMapNtf parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new SceneMapNtf(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<SceneMapNtf> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<SceneMapNtf> getParserForType() {
    return PARSER;
  }

  public com.dj.protobuf.scene.SceneMapNtf getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

