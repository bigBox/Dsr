// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Verify.proto

package com.dj.protobuf.verify;

public final class Verify {
  private Verify() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Protocols_VerifyItem_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Protocols_VerifyItem_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Protocols_VerifyQueue_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Protocols_VerifyQueue_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Protocols_VerifyHistory_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Protocols_VerifyHistory_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Protocols_VerifiedQueueReq_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Protocols_VerifiedQueueReq_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Protocols_VerifiedQueueRsp_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Protocols_VerifiedQueueRsp_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Protocols_VerifyingQueueReq_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Protocols_VerifyingQueueReq_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Protocols_VerifyingQueueRsp_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Protocols_VerifyingQueueRsp_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Protocols_VerifyEnqueueReq_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Protocols_VerifyEnqueueReq_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Protocols_VerifyEnqueueRsp_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Protocols_VerifyEnqueueRsp_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Protocols_VerifyDequeueReq_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Protocols_VerifyDequeueReq_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Protocols_VerifyDequeueRsp_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Protocols_VerifyDequeueRsp_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Protocols_VerifyItemReq_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Protocols_VerifyItemReq_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Protocols_VerifyItemRsp_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Protocols_VerifyItemRsp_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Protocols_VerifyLeaveReq_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Protocols_VerifyLeaveReq_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Protocols_VerifyLeaveRsp_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Protocols_VerifyLeaveRsp_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Protocols_VerifyUseCardReq_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Protocols_VerifyUseCardReq_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Protocols_VerifyUseCardRsp_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Protocols_VerifyUseCardRsp_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Protocols_VerifySpeedupReq_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Protocols_VerifySpeedupReq_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Protocols_VerifySpeedupRsp_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Protocols_VerifySpeedupRsp_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\014Verify.proto\022\tProtocols\032\rErrorID.proto" +
      "\032\022CommonDefine.proto\032\016DateTime.proto\"O\n\n" +
      "VerifyItem\022\016\n\006itemId\030\001 \001(\005\022\016\n\006source\030\002 \001" +
      "(\005\022!\n\004time\030\003 \001(\0132\023.Protocols.DateTime\"\227\001" +
      "\n\013VerifyQueue\022\r\n\005index\030\001 \001(\005\022\016\n\006itemId\030\002" +
      " \001(\005\022\020\n\010verifyCD\030\003 \001(\005\022&\n\005state\030\004 \001(\0162\027." +
      "Protocols.EVerifyState\022/\n\016verifyRoleInfo" +
      "\030\005 \003(\0132\027.Protocols.BaseRoleInfo\"\213\001\n\rVeri" +
      "fyHistory\022\016\n\006itemId\030\001 \001(\005\022/\n\016verifyRoleI" +
      "nfo\030\002 \001(\0132\027.Protocols.BaseRoleInfo\022\'\n\nve",
      "rifyTime\030\003 \001(\0132\023.Protocols.DateTime\022\020\n\010v" +
      "erifyCD\030\004 \001(\005\"\022\n\020VerifiedQueueReq\"\275\001\n\020Ve" +
      "rifiedQueueRsp\022\031\n\007errorID\030\001 \001(\0162\010.ErrorI" +
      "D\022&\n\006queues\030\002 \003(\0132\026.Protocols.VerifyQueu" +
      "e\022$\n\005items\030\003 \003(\0132\025.Protocols.VerifyItem\022" +
      "\023\n\013verifyCount\030\004 \001(\005\022+\n\thistories\030\005 \003(\0132" +
      "\030.Protocols.VerifyHistory\"#\n\021VerifyingQu" +
      "eueReq\022\016\n\006roleId\030\001 \001(\004\"f\n\021VerifyingQueue" +
      "Rsp\022\031\n\007errorID\030\001 \001(\0162\010.ErrorID\022\016\n\006roleId" +
      "\030\002 \001(\004\022&\n\006queues\030\003 \003(\0132\026.Protocols.Verif",
      "yQueue\"1\n\020VerifyEnqueueReq\022\r\n\005index\030\001 \001(" +
      "\005\022\016\n\006itemId\030\002 \001(\005\"\217\001\n\020VerifyEnqueueRsp\022\031" +
      "\n\007errorID\030\001 \001(\0162\010.ErrorID\022(\n\003req\030\002 \001(\0132\033" +
      ".Protocols.VerifyEnqueueReq\022$\n\005items\030\003 \003" +
      "(\0132\025.Protocols.VerifyItem\022\020\n\010verifyCD\030\004 " +
      "\001(\005\"!\n\020VerifyDequeueReq\022\r\n\005index\030\001 \001(\r\"k" +
      "\n\020VerifyDequeueRsp\022\031\n\007errorID\030\001 \001(\0162\010.Er" +
      "rorID\022(\n\003req\030\002 \001(\0132\033.Protocols.VerifyDeq" +
      "ueueReq\022\022\n\nresultItem\030\003 \001(\005\">\n\rVerifyIte" +
      "mReq\022\016\n\006roleId\030\001 \001(\004\022\r\n\005index\030\002 \001(\r\022\016\n\006i",
      "temId\030\003 \001(\r\"c\n\rVerifyItemRsp\022\031\n\007errorID\030" +
      "\001 \001(\0162\010.ErrorID\022%\n\003req\030\002 \001(\0132\030.Protocols" +
      ".VerifyItemReq\022\020\n\010verifyCD\030\003 \001(\005\" \n\016Veri" +
      "fyLeaveReq\022\016\n\006roleId\030\001 \001(\004\";\n\016VerifyLeav" +
      "eRsp\022\031\n\007errorID\030\001 \001(\0162\010.ErrorID\022\016\n\006roleI" +
      "d\030\002 \001(\004\"D\n\020VerifyUseCardReq\022\r\n\005index\030\001 \001" +
      "(\r\022\016\n\006cardID\030\002 \001(\r\022\021\n\tcardCount\030\003 \001(\r\"k\n" +
      "\020VerifyUseCardRsp\022\031\n\007errorID\030\001 \001(\0162\010.Err" +
      "orID\022(\n\003req\030\002 \001(\0132\033.Protocols.VerifyUseC" +
      "ardReq\022\022\n\nresultItem\030\003 \001(\r\"I\n\020VerifySpee",
      "dupReq\022\r\n\005index\030\001 \001(\r\022\023\n\013speedupCard\030\002 \001" +
      "(\005\022\021\n\tcardCount\030\003 \001(\005\"}\n\020VerifySpeedupRs" +
      "p\022\031\n\007errorID\030\001 \001(\0162\010.ErrorID\022(\n\003req\030\002 \001(" +
      "\0132\033.Protocols.VerifySpeedupReq\022\020\n\010verify" +
      "CD\030\003 \001(\005\022\022\n\nresultItem\030\004 \001(\005*9\n\014EVerifyS" +
      "tate\022\014\n\010NoSelect\020\000\022\r\n\tVerifying\020\001\022\014\n\010Ver" +
      "ified\020\002B\032\n\026com.dj.protobuf.verifyP\001"
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
          com.dj.protobuf.common.CommonDefine.getDescriptor(),
          com.dj.protobuf.datetime.DateTimeOuterClass.getDescriptor(),
        }, assigner);
    internal_static_Protocols_VerifyItem_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_Protocols_VerifyItem_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Protocols_VerifyItem_descriptor,
        new java.lang.String[] { "ItemId", "Source", "Time", });
    internal_static_Protocols_VerifyQueue_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_Protocols_VerifyQueue_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Protocols_VerifyQueue_descriptor,
        new java.lang.String[] { "Index", "ItemId", "VerifyCD", "State", "VerifyRoleInfo", });
    internal_static_Protocols_VerifyHistory_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_Protocols_VerifyHistory_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Protocols_VerifyHistory_descriptor,
        new java.lang.String[] { "ItemId", "VerifyRoleInfo", "VerifyTime", "VerifyCD", });
    internal_static_Protocols_VerifiedQueueReq_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_Protocols_VerifiedQueueReq_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Protocols_VerifiedQueueReq_descriptor,
        new java.lang.String[] { });
    internal_static_Protocols_VerifiedQueueRsp_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_Protocols_VerifiedQueueRsp_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Protocols_VerifiedQueueRsp_descriptor,
        new java.lang.String[] { "ErrorID", "Queues", "Items", "VerifyCount", "Histories", });
    internal_static_Protocols_VerifyingQueueReq_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_Protocols_VerifyingQueueReq_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Protocols_VerifyingQueueReq_descriptor,
        new java.lang.String[] { "RoleId", });
    internal_static_Protocols_VerifyingQueueRsp_descriptor =
      getDescriptor().getMessageTypes().get(6);
    internal_static_Protocols_VerifyingQueueRsp_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Protocols_VerifyingQueueRsp_descriptor,
        new java.lang.String[] { "ErrorID", "RoleId", "Queues", });
    internal_static_Protocols_VerifyEnqueueReq_descriptor =
      getDescriptor().getMessageTypes().get(7);
    internal_static_Protocols_VerifyEnqueueReq_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Protocols_VerifyEnqueueReq_descriptor,
        new java.lang.String[] { "Index", "ItemId", });
    internal_static_Protocols_VerifyEnqueueRsp_descriptor =
      getDescriptor().getMessageTypes().get(8);
    internal_static_Protocols_VerifyEnqueueRsp_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Protocols_VerifyEnqueueRsp_descriptor,
        new java.lang.String[] { "ErrorID", "Req", "Items", "VerifyCD", });
    internal_static_Protocols_VerifyDequeueReq_descriptor =
      getDescriptor().getMessageTypes().get(9);
    internal_static_Protocols_VerifyDequeueReq_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Protocols_VerifyDequeueReq_descriptor,
        new java.lang.String[] { "Index", });
    internal_static_Protocols_VerifyDequeueRsp_descriptor =
      getDescriptor().getMessageTypes().get(10);
    internal_static_Protocols_VerifyDequeueRsp_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Protocols_VerifyDequeueRsp_descriptor,
        new java.lang.String[] { "ErrorID", "Req", "ResultItem", });
    internal_static_Protocols_VerifyItemReq_descriptor =
      getDescriptor().getMessageTypes().get(11);
    internal_static_Protocols_VerifyItemReq_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Protocols_VerifyItemReq_descriptor,
        new java.lang.String[] { "RoleId", "Index", "ItemId", });
    internal_static_Protocols_VerifyItemRsp_descriptor =
      getDescriptor().getMessageTypes().get(12);
    internal_static_Protocols_VerifyItemRsp_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Protocols_VerifyItemRsp_descriptor,
        new java.lang.String[] { "ErrorID", "Req", "VerifyCD", });
    internal_static_Protocols_VerifyLeaveReq_descriptor =
      getDescriptor().getMessageTypes().get(13);
    internal_static_Protocols_VerifyLeaveReq_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Protocols_VerifyLeaveReq_descriptor,
        new java.lang.String[] { "RoleId", });
    internal_static_Protocols_VerifyLeaveRsp_descriptor =
      getDescriptor().getMessageTypes().get(14);
    internal_static_Protocols_VerifyLeaveRsp_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Protocols_VerifyLeaveRsp_descriptor,
        new java.lang.String[] { "ErrorID", "RoleId", });
    internal_static_Protocols_VerifyUseCardReq_descriptor =
      getDescriptor().getMessageTypes().get(15);
    internal_static_Protocols_VerifyUseCardReq_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Protocols_VerifyUseCardReq_descriptor,
        new java.lang.String[] { "Index", "CardID", "CardCount", });
    internal_static_Protocols_VerifyUseCardRsp_descriptor =
      getDescriptor().getMessageTypes().get(16);
    internal_static_Protocols_VerifyUseCardRsp_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Protocols_VerifyUseCardRsp_descriptor,
        new java.lang.String[] { "ErrorID", "Req", "ResultItem", });
    internal_static_Protocols_VerifySpeedupReq_descriptor =
      getDescriptor().getMessageTypes().get(17);
    internal_static_Protocols_VerifySpeedupReq_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Protocols_VerifySpeedupReq_descriptor,
        new java.lang.String[] { "Index", "SpeedupCard", "CardCount", });
    internal_static_Protocols_VerifySpeedupRsp_descriptor =
      getDescriptor().getMessageTypes().get(18);
    internal_static_Protocols_VerifySpeedupRsp_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Protocols_VerifySpeedupRsp_descriptor,
        new java.lang.String[] { "ErrorID", "Req", "VerifyCD", "ResultItem", });
    com.dj.protobuf.ErrorIDOuterClass.getDescriptor();
    com.dj.protobuf.common.CommonDefine.getDescriptor();
    com.dj.protobuf.datetime.DateTimeOuterClass.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
