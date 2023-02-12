// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Guide.proto

package com.dj.protobuf.guide;

/**
 * Protobuf enum {@code Protocols.NoviceSystem}
 */
public enum NoviceSystem
    implements com.google.protobuf.ProtocolMessageEnum {
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 普通引导
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>Common = 0;</code>
   */
  Common(0),
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 建筑引导
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>Building = 1;</code>
   */
  Building(1),
  ;

  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 普通引导
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>Common = 0;</code>
   */
  public static final int Common_VALUE = 0;
  /**
   * <pre>
   *&#47; &lt;summary&gt;
   * / 建筑引导
   * / &lt;/summary&gt;
   * </pre>
   *
   * <code>Building = 1;</code>
   */
  public static final int Building_VALUE = 1;


  public final int getNumber() {
    return value;
  }

  /**
   * @deprecated Use {@link #forNumber(int)} instead.
   */
  @java.lang.Deprecated
  public static NoviceSystem valueOf(int value) {
    return forNumber(value);
  }

  public static NoviceSystem forNumber(int value) {
    switch (value) {
      case 0: return Common;
      case 1: return Building;
      default: return null;
    }
  }

  public static com.google.protobuf.Internal.EnumLiteMap<NoviceSystem>
      internalGetValueMap() {
    return internalValueMap;
  }
  private static final com.google.protobuf.Internal.EnumLiteMap<
      NoviceSystem> internalValueMap =
        new com.google.protobuf.Internal.EnumLiteMap<NoviceSystem>() {
          public NoviceSystem findValueByNumber(int number) {
            return NoviceSystem.forNumber(number);
          }
        };

  public final com.google.protobuf.Descriptors.EnumValueDescriptor
      getValueDescriptor() {
    return getDescriptor().getValues().get(ordinal());
  }
  public final com.google.protobuf.Descriptors.EnumDescriptor
      getDescriptorForType() {
    return getDescriptor();
  }
  public static final com.google.protobuf.Descriptors.EnumDescriptor
      getDescriptor() {
    return com.dj.protobuf.guide.Guide.getDescriptor()
        .getEnumTypes().get(0);
  }

  private static final NoviceSystem[] VALUES = values();

  public static NoviceSystem valueOf(
      com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
    if (desc.getType() != getDescriptor()) {
      throw new java.lang.IllegalArgumentException(
        "EnumValueDescriptor is not for this type.");
    }
    return VALUES[desc.getIndex()];
  }

  private final int value;

  private NoviceSystem(int value) {
    this.value = value;
  }

  // @@protoc_insertion_point(enum_scope:Protocols.NoviceSystem)
}

