// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Outside.proto

package com.dj.protobuf.outside;

public interface OutSideProductInfoOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Protocols.OutSideProductInfo)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>repeated .Protocols.OutSideProduct products = 1;</code>
   */
  java.util.List<com.dj.protobuf.outside.OutSideProduct> 
      getProductsList();
  /**
   * <code>repeated .Protocols.OutSideProduct products = 1;</code>
   */
  com.dj.protobuf.outside.OutSideProduct getProducts(int index);
  /**
   * <code>repeated .Protocols.OutSideProduct products = 1;</code>
   */
  int getProductsCount();
  /**
   * <code>repeated .Protocols.OutSideProduct products = 1;</code>
   */
  java.util.List<? extends com.dj.protobuf.outside.OutSideProductOrBuilder> 
      getProductsOrBuilderList();
  /**
   * <code>repeated .Protocols.OutSideProduct products = 1;</code>
   */
  com.dj.protobuf.outside.OutSideProductOrBuilder getProductsOrBuilder(
      int index);

  /**
   * <code>optional int32 productType = 2;</code>
   */
  boolean hasProductType();
  /**
   * <code>optional int32 productType = 2;</code>
   */
  int getProductType();
}
