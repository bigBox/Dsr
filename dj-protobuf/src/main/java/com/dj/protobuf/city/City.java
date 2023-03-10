// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: City.proto

package com.dj.protobuf.city;

public final class City {
  private City() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Protocols_NpcVisitReq_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Protocols_NpcVisitReq_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Protocols_NpcVisitRsp_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Protocols_NpcVisitRsp_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Protocols_NpcOnPoetryReq_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Protocols_NpcOnPoetryReq_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Protocols_NpcOnPoetryRsp_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Protocols_NpcOnPoetryRsp_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Protocols_NpcWantThingReq_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Protocols_NpcWantThingReq_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Protocols_NpcWantThingRsp_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Protocols_NpcWantThingRsp_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Protocols_NpcRaceHorsesReq_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Protocols_NpcRaceHorsesReq_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Protocols_NpcRaceHorsesRsp_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Protocols_NpcRaceHorsesRsp_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Protocols_NpcRobberyReq_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Protocols_NpcRobberyReq_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Protocols_NpcRobberyRsp_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Protocols_NpcRobberyRsp_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Protocols_NpcPraiseReq_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Protocols_NpcPraiseReq_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Protocols_NpcPraiseRsp_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Protocols_NpcPraiseRsp_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\nCity.proto\022\tProtocols\032\rErrorID.proto\"\036" +
      "\n\013NpcVisitReq\022\017\n\007sceneID\030\001 \001(\005\"\260\001\n\013NpcVi" +
      "sitRsp\022\031\n\007errorID\030\001 \001(\0162\010.ErrorID\022#\n\003req" +
      "\030\002 \001(\0132\026.Protocols.NpcVisitReq\022\017\n\007eventI" +
      "D\030\003 \001(\005\022\r\n\005npcID\030\004 \001(\005\022+\n\teventType\030\005 \001(" +
      "\0162\030.Protocols.CityEventType\022\024\n\014eventCont" +
      "ent\030\006 \001(\t\"9\n\016NpcOnPoetryReq\022\'\n\006answer\030\001 " +
      "\001(\0162\027.Protocols.AnswerOption\"\231\001\n\016NpcOnPo" +
      "etryRsp\022\031\n\007errorID\030\001 \001(\0162\010.ErrorID\022&\n\003re" +
      "q\030\002 \001(\0132\031.Protocols.NpcOnPoetryReq\022\r\n\005ri",
      "ght\030\003 \001(\005\022\022\n\nquestionID\030\004 \001(\005\022\016\n\006itemId\030" +
      "\005 \001(\005\022\021\n\titemCount\030\006 \001(\005\"D\n\017NpcWantThing" +
      "Req\022\016\n\006answer\030\001 \001(\005\022\016\n\006itemId\030\002 \001(\005\022\021\n\ti" +
      "temCount\030\003 \001(\005\"U\n\017NpcWantThingRsp\022\031\n\007err" +
      "orID\030\001 \001(\0162\010.ErrorID\022\'\n\003req\030\002 \001(\0132\032.Prot" +
      "ocols.NpcWantThingReq\"F\n\020NpcRaceHorsesRe" +
      "q\022\017\n\007houseID\030\001 \001(\005\022\016\n\006itemId\030\002 \001(\005\022\021\n\tit" +
      "emCount\030\003 \001(\005\"\215\001\n\020NpcRaceHorsesRsp\022\031\n\007er" +
      "rorID\030\001 \001(\0162\010.ErrorID\022(\n\003req\030\002 \001(\0132\033.Pro" +
      "tocols.NpcRaceHorsesReq\022\021\n\twinOrLose\030\003 \001",
      "(\005\022\016\n\006itemId\030\004 \001(\005\022\021\n\titemCount\030\005 \001(\005\"C\n" +
      "\rNpcRobberyReq\022\017\n\007isAgree\030\001 \001(\005\022\016\n\006itemI" +
      "d\030\002 \001(\005\022\021\n\titemCount\030\003 \001(\005\"\207\001\n\rNpcRobber" +
      "yRsp\022\031\n\007errorID\030\001 \001(\0162\010.ErrorID\022%\n\003req\030\002" +
      " \001(\0132\030.Protocols.NpcRobberyReq\022\021\n\tisSucc" +
      "ess\030\003 \001(\005\022\016\n\006itemId\030\004 \001(\005\022\021\n\titemCount\030\005" +
      " \001(\005\"\035\n\014NpcPraiseReq\022\r\n\005npcId\030\001 \001(\005\"\205\001\n\014" +
      "NpcPraiseRsp\022\031\n\007errorID\030\001 \001(\0162\010.ErrorID\022" +
      "$\n\003req\030\002 \001(\0132\027.Protocols.NpcPraiseReq\022\021\n" +
      "\tisSuccess\030\003 \001(\005\022\016\n\006itemId\030\004 \001(\005\022\021\n\titem",
      "Count\030\005 \001(\005*8\n\014AnswerOption\022\014\n\010Answer_A\020" +
      "\001\022\014\n\010Answer_B\020\002\022\014\n\010Answer_C\020\003*}\n\rCityEve" +
      "ntType\022\013\n\007No_Body\020d\022\r\n\tOn_Poetry\020e\022\017\n\013Ra" +
      "ce_Horses\020f\022\016\n\nWant_Money\020g\022\016\n\nWant_Thin" +
      "g\020h\022\017\n\013Robbery_NPC\020i\022\016\n\nPraise_NPC\020jB\030\n\024" +
      "com.dj.protobuf.cityP\001"
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
    internal_static_Protocols_NpcVisitReq_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_Protocols_NpcVisitReq_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Protocols_NpcVisitReq_descriptor,
        new java.lang.String[] { "SceneID", });
    internal_static_Protocols_NpcVisitRsp_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_Protocols_NpcVisitRsp_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Protocols_NpcVisitRsp_descriptor,
        new java.lang.String[] { "ErrorID", "Req", "EventID", "NpcID", "EventType", "EventContent", });
    internal_static_Protocols_NpcOnPoetryReq_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_Protocols_NpcOnPoetryReq_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Protocols_NpcOnPoetryReq_descriptor,
        new java.lang.String[] { "Answer", });
    internal_static_Protocols_NpcOnPoetryRsp_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_Protocols_NpcOnPoetryRsp_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Protocols_NpcOnPoetryRsp_descriptor,
        new java.lang.String[] { "ErrorID", "Req", "Right", "QuestionID", "ItemId", "ItemCount", });
    internal_static_Protocols_NpcWantThingReq_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_Protocols_NpcWantThingReq_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Protocols_NpcWantThingReq_descriptor,
        new java.lang.String[] { "Answer", "ItemId", "ItemCount", });
    internal_static_Protocols_NpcWantThingRsp_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_Protocols_NpcWantThingRsp_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Protocols_NpcWantThingRsp_descriptor,
        new java.lang.String[] { "ErrorID", "Req", });
    internal_static_Protocols_NpcRaceHorsesReq_descriptor =
      getDescriptor().getMessageTypes().get(6);
    internal_static_Protocols_NpcRaceHorsesReq_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Protocols_NpcRaceHorsesReq_descriptor,
        new java.lang.String[] { "HouseID", "ItemId", "ItemCount", });
    internal_static_Protocols_NpcRaceHorsesRsp_descriptor =
      getDescriptor().getMessageTypes().get(7);
    internal_static_Protocols_NpcRaceHorsesRsp_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Protocols_NpcRaceHorsesRsp_descriptor,
        new java.lang.String[] { "ErrorID", "Req", "WinOrLose", "ItemId", "ItemCount", });
    internal_static_Protocols_NpcRobberyReq_descriptor =
      getDescriptor().getMessageTypes().get(8);
    internal_static_Protocols_NpcRobberyReq_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Protocols_NpcRobberyReq_descriptor,
        new java.lang.String[] { "IsAgree", "ItemId", "ItemCount", });
    internal_static_Protocols_NpcRobberyRsp_descriptor =
      getDescriptor().getMessageTypes().get(9);
    internal_static_Protocols_NpcRobberyRsp_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Protocols_NpcRobberyRsp_descriptor,
        new java.lang.String[] { "ErrorID", "Req", "IsSuccess", "ItemId", "ItemCount", });
    internal_static_Protocols_NpcPraiseReq_descriptor =
      getDescriptor().getMessageTypes().get(10);
    internal_static_Protocols_NpcPraiseReq_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Protocols_NpcPraiseReq_descriptor,
        new java.lang.String[] { "NpcId", });
    internal_static_Protocols_NpcPraiseRsp_descriptor =
      getDescriptor().getMessageTypes().get(11);
    internal_static_Protocols_NpcPraiseRsp_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Protocols_NpcPraiseRsp_descriptor,
        new java.lang.String[] { "ErrorID", "Req", "IsSuccess", "ItemId", "ItemCount", });
    com.dj.protobuf.ErrorIDOuterClass.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
