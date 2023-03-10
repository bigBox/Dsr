// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Guild.proto

package com.dj.protobuf.guild;

/**
 * Protobuf enum {@code Protocols.EGuildQuitReson}
 */
public enum EGuildQuitReson
    implements com.google.protobuf.ProtocolMessageEnum {
  /**
   * <pre>
   * 主动退出
   * </pre>
   *
   * <code>GuildQuitActive = 1;</code>
   */
  GuildQuitActive(1),
  /**
   * <pre>
   * 被踢出
   * </pre>
   *
   * <code>GuildQuitKicked = 2;</code>
   */
  GuildQuitKicked(2),
  ;

  /**
   * <pre>
   * 主动退出
   * </pre>
   *
   * <code>GuildQuitActive = 1;</code>
   */
  public static final int GuildQuitActive_VALUE = 1;
  /**
   * <pre>
   * 被踢出
   * </pre>
   *
   * <code>GuildQuitKicked = 2;</code>
   */
  public static final int GuildQuitKicked_VALUE = 2;


  public final int getNumber() {
    return value;
  }

  /**
   * @deprecated Use {@link #forNumber(int)} instead.
   */
  @java.lang.Deprecated
  public static EGuildQuitReson valueOf(int value) {
    return forNumber(value);
  }

  public static EGuildQuitReson forNumber(int value) {
    switch (value) {
      case 1: return GuildQuitActive;
      case 2: return GuildQuitKicked;
      default: return null;
    }
  }

  public static com.google.protobuf.Internal.EnumLiteMap<EGuildQuitReson>
      internalGetValueMap() {
    return internalValueMap;
  }
  private static final com.google.protobuf.Internal.EnumLiteMap<
      EGuildQuitReson> internalValueMap =
        new com.google.protobuf.Internal.EnumLiteMap<EGuildQuitReson>() {
          public EGuildQuitReson findValueByNumber(int number) {
            return EGuildQuitReson.forNumber(number);
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
    return com.dj.protobuf.guild.Guild.getDescriptor()
        .getEnumTypes().get(1);
  }

  private static final EGuildQuitReson[] VALUES = values();

  public static EGuildQuitReson valueOf(
      com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
    if (desc.getType() != getDescriptor()) {
      throw new java.lang.IllegalArgumentException(
        "EnumValueDescriptor is not for this type.");
    }
    return VALUES[desc.getIndex()];
  }

  private final int value;

  private EGuildQuitReson(int value) {
    this.value = value;
  }

  // @@protoc_insertion_point(enum_scope:Protocols.EGuildQuitReson)
}

