// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Book.proto

package com.dj.protobuf.book;

/**
 * <pre>
 *&#47; &lt;summary&gt;
 * / 图鉴类型、1植物，2动物，4鱼类，5宝物，7道具，10稀有宝物
 * / &lt;/summary&gt;
 * </pre>
 *
 * Protobuf enum {@code Protocols.BookType}
 */
public enum BookType
    implements com.google.protobuf.ProtocolMessageEnum {
  /**
   * <pre>
   * 植物
   * </pre>
   *
   * <code>Book_1 = 1;</code>
   */
  Book_1(1),
  /**
   * <pre>
   * 动物
   * </pre>
   *
   * <code>Book_2 = 2;</code>
   */
  Book_2(2),
  /**
   * <pre>
   *鱼类
   * </pre>
   *
   * <code>Book_4 = 4;</code>
   */
  Book_4(4),
  /**
   * <pre>
   * 宝物
   * </pre>
   *
   * <code>Book_5 = 5;</code>
   */
  Book_5(5),
  /**
   * <pre>
   * 道具
   * </pre>
   *
   * <code>Book_7 = 7;</code>
   */
  Book_7(7),
  /**
   * <pre>
   * 稀有宝物
   * </pre>
   *
   * <code>Book_10 = 10;</code>
   */
  Book_10(10),
  ;

  /**
   * <pre>
   * 植物
   * </pre>
   *
   * <code>Book_1 = 1;</code>
   */
  public static final int Book_1_VALUE = 1;
  /**
   * <pre>
   * 动物
   * </pre>
   *
   * <code>Book_2 = 2;</code>
   */
  public static final int Book_2_VALUE = 2;
  /**
   * <pre>
   *鱼类
   * </pre>
   *
   * <code>Book_4 = 4;</code>
   */
  public static final int Book_4_VALUE = 4;
  /**
   * <pre>
   * 宝物
   * </pre>
   *
   * <code>Book_5 = 5;</code>
   */
  public static final int Book_5_VALUE = 5;
  /**
   * <pre>
   * 道具
   * </pre>
   *
   * <code>Book_7 = 7;</code>
   */
  public static final int Book_7_VALUE = 7;
  /**
   * <pre>
   * 稀有宝物
   * </pre>
   *
   * <code>Book_10 = 10;</code>
   */
  public static final int Book_10_VALUE = 10;


  public final int getNumber() {
    return value;
  }

  /**
   * @deprecated Use {@link #forNumber(int)} instead.
   */
  @java.lang.Deprecated
  public static BookType valueOf(int value) {
    return forNumber(value);
  }

  public static BookType forNumber(int value) {
    switch (value) {
      case 1: return Book_1;
      case 2: return Book_2;
      case 4: return Book_4;
      case 5: return Book_5;
      case 7: return Book_7;
      case 10: return Book_10;
      default: return null;
    }
  }

  public static com.google.protobuf.Internal.EnumLiteMap<BookType>
      internalGetValueMap() {
    return internalValueMap;
  }
  private static final com.google.protobuf.Internal.EnumLiteMap<
      BookType> internalValueMap =
        new com.google.protobuf.Internal.EnumLiteMap<BookType>() {
          public BookType findValueByNumber(int number) {
            return BookType.forNumber(number);
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
    return com.dj.protobuf.book.Book.getDescriptor()
        .getEnumTypes().get(0);
  }

  private static final BookType[] VALUES = values();

  public static BookType valueOf(
      com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
    if (desc.getType() != getDescriptor()) {
      throw new java.lang.IllegalArgumentException(
        "EnumValueDescriptor is not for this type.");
    }
    return VALUES[desc.getIndex()];
  }

  private final int value;

  private BookType(int value) {
    this.value = value;
  }

  // @@protoc_insertion_point(enum_scope:Protocols.BookType)
}
