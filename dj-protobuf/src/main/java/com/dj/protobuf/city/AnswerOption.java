// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: City.proto

package com.dj.protobuf.city;

/**
 * Protobuf enum {@code Protocols.AnswerOption}
 */
public enum AnswerOption
    implements com.google.protobuf.ProtocolMessageEnum {
  /**
   * <code>Answer_A = 1;</code>
   */
  Answer_A(1),
  /**
   * <code>Answer_B = 2;</code>
   */
  Answer_B(2),
  /**
   * <code>Answer_C = 3;</code>
   */
  Answer_C(3),
  ;

  /**
   * <code>Answer_A = 1;</code>
   */
  public static final int Answer_A_VALUE = 1;
  /**
   * <code>Answer_B = 2;</code>
   */
  public static final int Answer_B_VALUE = 2;
  /**
   * <code>Answer_C = 3;</code>
   */
  public static final int Answer_C_VALUE = 3;


  public final int getNumber() {
    return value;
  }

  /**
   * @deprecated Use {@link #forNumber(int)} instead.
   */
  @java.lang.Deprecated
  public static AnswerOption valueOf(int value) {
    return forNumber(value);
  }

  public static AnswerOption forNumber(int value) {
    switch (value) {
      case 1: return Answer_A;
      case 2: return Answer_B;
      case 3: return Answer_C;
      default: return null;
    }
  }

  public static com.google.protobuf.Internal.EnumLiteMap<AnswerOption>
      internalGetValueMap() {
    return internalValueMap;
  }
  private static final com.google.protobuf.Internal.EnumLiteMap<
      AnswerOption> internalValueMap =
        new com.google.protobuf.Internal.EnumLiteMap<AnswerOption>() {
          public AnswerOption findValueByNumber(int number) {
            return AnswerOption.forNumber(number);
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
        .getEnumTypes().get(0);
  }

  private static final AnswerOption[] VALUES = values();

  public static AnswerOption valueOf(
      com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
    if (desc.getType() != getDescriptor()) {
      throw new java.lang.IllegalArgumentException(
        "EnumValueDescriptor is not for this type.");
    }
    return VALUES[desc.getIndex()];
  }

  private final int value;

  private AnswerOption(int value) {
    this.value = value;
  }

  // @@protoc_insertion_point(enum_scope:Protocols.AnswerOption)
}

