// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: City.proto

package com.dj.protobuf.city;

/**
 * Protobuf enum {@code Protocols.CityEventType}
 */
public enum CityEventType
    implements com.google.protobuf.ProtocolMessageEnum {
  /**
   * <pre>
   *没有人
   * </pre>
   *
   * <code>No_Body = 100;</code>
   */
  No_Body(100),
  /**
   * <pre>
   *对诗
   * </pre>
   *
   * <code>On_Poetry = 101;</code>
   */
  On_Poetry(101),
  /**
   * <pre>
   *赛马
   * </pre>
   *
   * <code>Race_Horses = 102;</code>
   */
  Race_Horses(102),
  /**
   * <pre>
   *要金币
   * </pre>
   *
   * <code>Want_Money = 103;</code>
   */
  Want_Money(103),
  /**
   * <pre>
   *要东西
   * </pre>
   *
   * <code>Want_Thing = 104;</code>
   */
  Want_Thing(104),
  /**
   * <pre>
   *打劫
   * </pre>
   *
   * <code>Robbery_NPC = 105;</code>
   */
  Robbery_NPC(105),
  /**
   * <pre>
   *赞美NPC
   * </pre>
   *
   * <code>Praise_NPC = 106;</code>
   */
  Praise_NPC(106),
  ;

  /**
   * <pre>
   *没有人
   * </pre>
   *
   * <code>No_Body = 100;</code>
   */
  public static final int No_Body_VALUE = 100;
  /**
   * <pre>
   *对诗
   * </pre>
   *
   * <code>On_Poetry = 101;</code>
   */
  public static final int On_Poetry_VALUE = 101;
  /**
   * <pre>
   *赛马
   * </pre>
   *
   * <code>Race_Horses = 102;</code>
   */
  public static final int Race_Horses_VALUE = 102;
  /**
   * <pre>
   *要金币
   * </pre>
   *
   * <code>Want_Money = 103;</code>
   */
  public static final int Want_Money_VALUE = 103;
  /**
   * <pre>
   *要东西
   * </pre>
   *
   * <code>Want_Thing = 104;</code>
   */
  public static final int Want_Thing_VALUE = 104;
  /**
   * <pre>
   *打劫
   * </pre>
   *
   * <code>Robbery_NPC = 105;</code>
   */
  public static final int Robbery_NPC_VALUE = 105;
  /**
   * <pre>
   *赞美NPC
   * </pre>
   *
   * <code>Praise_NPC = 106;</code>
   */
  public static final int Praise_NPC_VALUE = 106;


  public final int getNumber() {
    return value;
  }

  /**
   * @deprecated Use {@link #forNumber(int)} instead.
   */
  @java.lang.Deprecated
  public static CityEventType valueOf(int value) {
    return forNumber(value);
  }

  public static CityEventType forNumber(int value) {
    switch (value) {
      case 100: return No_Body;
      case 101: return On_Poetry;
      case 102: return Race_Horses;
      case 103: return Want_Money;
      case 104: return Want_Thing;
      case 105: return Robbery_NPC;
      case 106: return Praise_NPC;
      default: return null;
    }
  }

  public static com.google.protobuf.Internal.EnumLiteMap<CityEventType>
      internalGetValueMap() {
    return internalValueMap;
  }
  private static final com.google.protobuf.Internal.EnumLiteMap<
      CityEventType> internalValueMap =
        new com.google.protobuf.Internal.EnumLiteMap<CityEventType>() {
          public CityEventType findValueByNumber(int number) {
            return CityEventType.forNumber(number);
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
    return com.dj.protobuf.city.City.getDescriptor()
        .getEnumTypes().get(1);
  }

  private static final CityEventType[] VALUES = values();

  public static CityEventType valueOf(
      com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
    if (desc.getType() != getDescriptor()) {
      throw new java.lang.IllegalArgumentException(
        "EnumValueDescriptor is not for this type.");
    }
    return VALUES[desc.getIndex()];
  }

  private final int value;

  private CityEventType(int value) {
    this.value = value;
  }

  // @@protoc_insertion_point(enum_scope:Protocols.CityEventType)
}
