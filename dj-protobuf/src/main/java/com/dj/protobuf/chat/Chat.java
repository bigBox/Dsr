// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Chat.proto

package com.dj.protobuf.chat;

public final class Chat {
  private Chat() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Protocols_ChatSendReq_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Protocols_ChatSendReq_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Protocols_ChatSendRsp_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Protocols_ChatSendRsp_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Protocols_ChatSendNtf_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Protocols_ChatSendNtf_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\nChat.proto\022\tProtocols\032\016DateTime.proto\032" +
      "\rErrorID.proto\032\022CommonDefine.proto\"X\n\013Ch" +
      "atSendReq\022\016\n\006roleID\030\001 \001(\004\022(\n\007channel\030\002 \001" +
      "(\0162\027.Protocols.EChatChannel\022\017\n\007content\030\003" +
      " \001(\t\"M\n\013ChatSendRsp\022\031\n\007errorID\030\001 \001(\0162\010.E" +
      "rrorID\022#\n\003req\030\002 \001(\0132\026.Protocols.ChatSend" +
      "Req\"\232\001\n\013ChatSendNtf\022)\n\010roleInfo\030\001 \001(\0132\027." +
      "Protocols.BaseRoleInfo\022%\n\010sendTime\030\002 \001(\013" +
      "2\023.Protocols.DateTime\022(\n\007channel\030\003 \001(\0162\027" +
      ".Protocols.EChatChannel\022\017\n\007content\030\004 \001(\t",
      "*/\n\014EChatChannel\022\t\n\005Guild\020\001\022\010\n\004Mine\020\002\022\n\n" +
      "\006Verify\020\003B\030\n\024com.dj.protobuf.chatP\001"
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
          com.dj.protobuf.datetime.DateTimeOuterClass.getDescriptor(),
          com.dj.protobuf.ErrorIDOuterClass.getDescriptor(),
          com.dj.protobuf.common.CommonDefine.getDescriptor(),
        }, assigner);
    internal_static_Protocols_ChatSendReq_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_Protocols_ChatSendReq_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Protocols_ChatSendReq_descriptor,
        new java.lang.String[] { "RoleID", "Channel", "Content", });
    internal_static_Protocols_ChatSendRsp_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_Protocols_ChatSendRsp_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Protocols_ChatSendRsp_descriptor,
        new java.lang.String[] { "ErrorID", "Req", });
    internal_static_Protocols_ChatSendNtf_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_Protocols_ChatSendNtf_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Protocols_ChatSendNtf_descriptor,
        new java.lang.String[] { "RoleInfo", "SendTime", "Channel", "Content", });
    com.dj.protobuf.datetime.DateTimeOuterClass.getDescriptor();
    com.dj.protobuf.ErrorIDOuterClass.getDescriptor();
    com.dj.protobuf.common.CommonDefine.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
