// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: OutSideMap.proto

package com.dj.protobuf.outSideMap;

public final class OutSideMap {
  private OutSideMap() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Protocols_BuildInfo_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Protocols_BuildInfo_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Protocols_BuildListReq_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Protocols_BuildListReq_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Protocols_BuildListRsp_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Protocols_BuildListRsp_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\020OutSideMap.proto\022\tProtocols\032\rErrorID.p" +
      "roto\"0\n\tBuildInfo\022\017\n\007buildID\030\001 \001(\005\022\022\n\nho" +
      "ldRoleID\030\002 \001(\005\"\016\n\014BuildListReq\"O\n\014BuildL" +
      "istRsp\022\031\n\007errorID\030\001 \001(\0162\010.ErrorID\022$\n\006bui" +
      "lds\030\002 \003(\0132\024.Protocols.BuildInfoB\036\n\032com.d" +
      "j.protobuf.outSideMapP\001"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.dj.protobuf.ErrorIDOuterClass.getDescriptor(),
        }, assigner);
    internal_static_Protocols_BuildInfo_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_Protocols_BuildInfo_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Protocols_BuildInfo_descriptor,
        new java.lang.String[] { "BuildID", "HoldRoleID", });
    internal_static_Protocols_BuildListReq_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_Protocols_BuildListReq_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Protocols_BuildListReq_descriptor,
        new java.lang.String[] { });
    internal_static_Protocols_BuildListRsp_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_Protocols_BuildListRsp_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Protocols_BuildListRsp_descriptor,
        new java.lang.String[] { "ErrorID", "Builds", });
    com.dj.protobuf.ErrorIDOuterClass.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
