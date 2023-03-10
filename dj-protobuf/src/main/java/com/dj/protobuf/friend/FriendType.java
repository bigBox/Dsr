// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Friend.proto

package com.dj.protobuf.friend;

/**
 * Protobuf enum {@code Protocols.FriendType}
 */
public enum FriendType
    implements com.google.protobuf.ProtocolMessageEnum {
  /**
   * <pre>
   * 普通好友
   * </pre>
   *
   * <code>FT_Normal = 1;</code>
   */
  FT_Normal(1),
  /**
   * <pre>
   * QQ好友
   * </pre>
   *
   * <code>ET_QQFriend = 2;</code>
   */
  ET_QQFriend(2),
  ;

  /**
   * <pre>
   * 普通好友
   * </pre>
   *
   * <code>FT_Normal = 1;</code>
   */
  public static final int FT_Normal_VALUE = 1;
  /**
   * <pre>
   * QQ好友
   * </pre>
   *
   * <code>ET_QQFriend = 2;</code>
   */
  public static final int ET_QQFriend_VALUE = 2;


  public final int getNumber() {
    return value;
  }

  /**
   * @deprecated Use {@link #forNumber(int)} instead.
   */
  @java.lang.Deprecated
  public static FriendType valueOf(int value) {
    return forNumber(value);
  }

  public static FriendType forNumber(int value) {
    switch (value) {
      case 1: return FT_Normal;
      case 2: return ET_QQFriend;
      default: return null;
    }
  }

  public static com.google.protobuf.Internal.EnumLiteMap<FriendType>
      internalGetValueMap() {
    return internalValueMap;
  }
  private static final com.google.protobuf.Internal.EnumLiteMap<
      FriendType> internalValueMap =
        new com.google.protobuf.Internal.EnumLiteMap<FriendType>() {
          public FriendType findValueByNumber(int number) {
            return FriendType.forNumber(number);
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
    return com.dj.protobuf.friend.Friend.getDescriptor()
        .getEnumTypes().get(0);
  }

  private static final FriendType[] VALUES = values();

  public static FriendType valueOf(
      com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
    if (desc.getType() != getDescriptor()) {
      throw new java.lang.IllegalArgumentException(
        "EnumValueDescriptor is not for this type.");
    }
    return VALUES[desc.getIndex()];
  }

  private final int value;

  private FriendType(int value) {
    this.value = value;
  }

  // @@protoc_insertion_point(enum_scope:Protocols.FriendType)
}

