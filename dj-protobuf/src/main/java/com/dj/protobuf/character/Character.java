// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Character.proto

package com.dj.protobuf.character;

public final class Character {
  private Character() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Protocols_ChangeNameReq_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Protocols_ChangeNameReq_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Protocols_ChangeNameRsp_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Protocols_ChangeNameRsp_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Protocols_ChangeSignatureReq_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Protocols_ChangeSignatureReq_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Protocols_ChangeSignatureRsp_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Protocols_ChangeSignatureRsp_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Protocols_ChangeClientDataReq_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Protocols_ChangeClientDataReq_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Protocols_ChangeClientDataRsp_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Protocols_ChangeClientDataRsp_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Protocols_UsePowerBarAddStaminaReq_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Protocols_UsePowerBarAddStaminaReq_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Protocols_UsePowerBarAddStaminaRsp_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Protocols_UsePowerBarAddStaminaRsp_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Protocols_CheckWordReq_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Protocols_CheckWordReq_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Protocols_CheckWordRsp_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Protocols_CheckWordRsp_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Protocols_LeaveHistory_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Protocols_LeaveHistory_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Protocols_LeaveHistoryReq_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Protocols_LeaveHistoryReq_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Protocols_LeaveHistoryRsp_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Protocols_LeaveHistoryRsp_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\017Character.proto\022\tProtocols\032\rErrorID.pr" +
      "oto\032\016DateTime.proto\"7\n\rChangeNameReq\022\014\n\004" +
      "name\030\001 \001(\t\022\030\n\020Isint32roduction\030\002 \001(\010\"Q\n\r" +
      "ChangeNameRsp\022\031\n\007errorID\030\001 \001(\0162\010.ErrorID" +
      "\022%\n\003req\030\002 \001(\0132\030.Protocols.ChangeNameReq\"" +
      "\'\n\022ChangeSignatureReq\022\021\n\tsignature\030\001 \001(\t" +
      "\"[\n\022ChangeSignatureRsp\022\031\n\007errorID\030\001 \001(\0162" +
      "\010.ErrorID\022*\n\003req\030\002 \001(\0132\035.Protocols.Chang" +
      "eSignatureReq\"1\n\023ChangeClientDataReq\022\013\n\003" +
      "key\030\001 \001(\t\022\r\n\005value\030\002 \001(\005\"]\n\023ChangeClient",
      "DataRsp\022\031\n\007errorID\030\001 \001(\0162\010.ErrorID\022+\n\003re" +
      "q\030\002 \001(\0132\036.Protocols.ChangeClientDataReq\"" +
      ")\n\030UsePowerBarAddStaminaReq\022\r\n\005count\030\001 \001" +
      "(\005\"5\n\030UsePowerBarAddStaminaRsp\022\031\n\007errorI" +
      "D\030\001 \001(\0162\010.ErrorID\"\034\n\014CheckWordReq\022\014\n\004wor" +
      "d\030\001 \001(\t\"7\n\014CheckWordRsp\022\031\n\007errorID\030\001 \001(\016" +
      "2\010.ErrorID\022\014\n\004word\030\002 \001(\t\"G\n\014LeaveHistory" +
      "\022\017\n\007leaveID\030\001 \001(\005\022&\n\tleaveTime\030\002 \001(\0132\023.P" +
      "rotocols.DateTime\"\037\n\017LeaveHistoryReq\022\014\n\004" +
      "type\030\001 \001(\005\"\201\001\n\017LeaveHistoryRsp\022\031\n\007errorI",
      "D\030\001 \001(\0162\010.ErrorID\022\'\n\003req\030\002 \001(\0132\032.Protoco" +
      "ls.LeaveHistoryReq\022*\n\thistories\030\003 \003(\0132\027." +
      "Protocols.LeaveHistoryB\035\n\031com.dj.protobu" +
      "f.characterP\001"
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
          com.dj.protobuf.datetime.DateTimeOuterClass.getDescriptor(),
        }, assigner);
    internal_static_Protocols_ChangeNameReq_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_Protocols_ChangeNameReq_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Protocols_ChangeNameReq_descriptor,
        new java.lang.String[] { "Name", "Isint32Roduction", });
    internal_static_Protocols_ChangeNameRsp_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_Protocols_ChangeNameRsp_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Protocols_ChangeNameRsp_descriptor,
        new java.lang.String[] { "ErrorID", "Req", });
    internal_static_Protocols_ChangeSignatureReq_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_Protocols_ChangeSignatureReq_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Protocols_ChangeSignatureReq_descriptor,
        new java.lang.String[] { "Signature", });
    internal_static_Protocols_ChangeSignatureRsp_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_Protocols_ChangeSignatureRsp_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Protocols_ChangeSignatureRsp_descriptor,
        new java.lang.String[] { "ErrorID", "Req", });
    internal_static_Protocols_ChangeClientDataReq_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_Protocols_ChangeClientDataReq_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Protocols_ChangeClientDataReq_descriptor,
        new java.lang.String[] { "Key", "Value", });
    internal_static_Protocols_ChangeClientDataRsp_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_Protocols_ChangeClientDataRsp_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Protocols_ChangeClientDataRsp_descriptor,
        new java.lang.String[] { "ErrorID", "Req", });
    internal_static_Protocols_UsePowerBarAddStaminaReq_descriptor =
      getDescriptor().getMessageTypes().get(6);
    internal_static_Protocols_UsePowerBarAddStaminaReq_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Protocols_UsePowerBarAddStaminaReq_descriptor,
        new java.lang.String[] { "Count", });
    internal_static_Protocols_UsePowerBarAddStaminaRsp_descriptor =
      getDescriptor().getMessageTypes().get(7);
    internal_static_Protocols_UsePowerBarAddStaminaRsp_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Protocols_UsePowerBarAddStaminaRsp_descriptor,
        new java.lang.String[] { "ErrorID", });
    internal_static_Protocols_CheckWordReq_descriptor =
      getDescriptor().getMessageTypes().get(8);
    internal_static_Protocols_CheckWordReq_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Protocols_CheckWordReq_descriptor,
        new java.lang.String[] { "Word", });
    internal_static_Protocols_CheckWordRsp_descriptor =
      getDescriptor().getMessageTypes().get(9);
    internal_static_Protocols_CheckWordRsp_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Protocols_CheckWordRsp_descriptor,
        new java.lang.String[] { "ErrorID", "Word", });
    internal_static_Protocols_LeaveHistory_descriptor =
      getDescriptor().getMessageTypes().get(10);
    internal_static_Protocols_LeaveHistory_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Protocols_LeaveHistory_descriptor,
        new java.lang.String[] { "LeaveID", "LeaveTime", });
    internal_static_Protocols_LeaveHistoryReq_descriptor =
      getDescriptor().getMessageTypes().get(11);
    internal_static_Protocols_LeaveHistoryReq_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Protocols_LeaveHistoryReq_descriptor,
        new java.lang.String[] { "Type", });
    internal_static_Protocols_LeaveHistoryRsp_descriptor =
      getDescriptor().getMessageTypes().get(12);
    internal_static_Protocols_LeaveHistoryRsp_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Protocols_LeaveHistoryRsp_descriptor,
        new java.lang.String[] { "ErrorID", "Req", "Histories", });
    com.dj.protobuf.ErrorIDOuterClass.getDescriptor();
    com.dj.protobuf.datetime.DateTimeOuterClass.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
