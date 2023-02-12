// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Manufacture.proto

package com.dj.protobuf.manufacture;

public final class Manufacture {
  private Manufacture() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Protocols_ManufactureState_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Protocols_ManufactureState_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Protocols_ManufactureActionReq_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Protocols_ManufactureActionReq_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Protocols_ManufactureActionRsp_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Protocols_ManufactureActionRsp_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Protocols_ManufactureInfoReq_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Protocols_ManufactureInfoReq_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Protocols_ManufactureInfoRsp_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Protocols_ManufactureInfoRsp_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Protocols_ManufactureInfo_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Protocols_ManufactureInfo_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Protocols_ManufactureSpeedupReq_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Protocols_ManufactureSpeedupReq_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Protocols_ManufactureSpeedupRsp_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Protocols_ManufactureSpeedupRsp_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Protocols_ManufactureBatchPickupReq_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Protocols_ManufactureBatchPickupReq_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Protocols_ManufactureBatchPickupRsp_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Protocols_ManufactureBatchPickupRsp_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\021Manufacture.proto\022\tProtocols\032\rErrorID." +
      "proto\032\016DateTime.proto\"x\n\020ManufactureStat" +
      "e\022\020\n\010recipeId\030\001 \001(\005\022+\n\005state\030\002 \001(\0162\034.Pro" +
      "tocols.EManufactureState\022\022\n\nmakingTime\030\003" +
      " \001(\005\022\021\n\tcountDown\030\004 \001(\005\"q\n\024ManufactureAc" +
      "tionReq\0225\n\nactionType\030\001 \001(\0162!.Protocols." +
      "EManufactureActionType\022\020\n\010recipeId\030\002 \001(\005" +
      "\022\020\n\010enqueued\030\003 \001(\005\"\220\001\n\024ManufactureAction" +
      "Rsp\022\031\n\007errorID\030\001 \001(\0162\010.ErrorID\022,\n\003req\030\002 " +
      "\001(\0132\037.Protocols.ManufactureActionReq\022\025\n\r",
      "produceItemId\030\003 \001(\005\022\030\n\020produceItemCount\030" +
      "\004 \001(\005\"\024\n\022ManufactureInfoReq\"[\n\022Manufactu" +
      "reInfoRsp\022*\n\005items\030\001 \003(\0132\033.Protocols.Man" +
      "ufactureState\022\031\n\007errorID\030\002 \001(\0162\010.ErrorID" +
      "\"k\n\017ManufactureInfo\0220\n\013makingQueue\030\001 \003(\013" +
      "2\033.Protocols.ManufactureState\022&\n\tstartTi" +
      "me\030\002 \001(\0132\023.Protocols.DateTime\"O\n\025Manufac" +
      "tureSpeedupReq\022\022\n\nbuildingId\030\001 \001(\005\022\023\n\013sp" +
      "eedupCard\030\002 \001(\005\022\r\n\005index\030\003 \001(\005\"\213\001\n\025Manuf" +
      "actureSpeedupRsp\022\031\n\007errorID\030\001 \001(\0162\010.Erro",
      "rID\022(\n\004info\030\002 \001(\0132\032.Protocols.Manufactur" +
      "eInfo\022-\n\003req\030\003 \001(\0132 .Protocols.Manufactu" +
      "reSpeedupReq\"/\n\031ManufactureBatchPickupRe" +
      "q\022\022\n\nbuildingId\030\001 \001(\005\"L\n\031ManufactureBatc" +
      "hPickupRsp\022\031\n\007errorID\030\001 \001(\0162\010.ErrorID\022\024\n" +
      "\014successIndex\030\002 \003(\005*\"\n\026EManufactureActio" +
      "nType\022\010\n\004Make\020\001*9\n\021EManufactureState\022\n\n\006" +
      "Queued\020\001\022\n\n\006Making\020\002\022\014\n\010Finished\020\003B\037\n\033co" +
      "m.dj.protobuf.manufactureP\001"
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
    internal_static_Protocols_ManufactureState_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_Protocols_ManufactureState_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Protocols_ManufactureState_descriptor,
        new java.lang.String[] { "RecipeId", "State", "MakingTime", "CountDown", });
    internal_static_Protocols_ManufactureActionReq_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_Protocols_ManufactureActionReq_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Protocols_ManufactureActionReq_descriptor,
        new java.lang.String[] { "ActionType", "RecipeId", "Enqueued", });
    internal_static_Protocols_ManufactureActionRsp_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_Protocols_ManufactureActionRsp_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Protocols_ManufactureActionRsp_descriptor,
        new java.lang.String[] { "ErrorID", "Req", "ProduceItemId", "ProduceItemCount", });
    internal_static_Protocols_ManufactureInfoReq_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_Protocols_ManufactureInfoReq_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Protocols_ManufactureInfoReq_descriptor,
        new java.lang.String[] { });
    internal_static_Protocols_ManufactureInfoRsp_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_Protocols_ManufactureInfoRsp_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Protocols_ManufactureInfoRsp_descriptor,
        new java.lang.String[] { "Items", "ErrorID", });
    internal_static_Protocols_ManufactureInfo_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_Protocols_ManufactureInfo_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Protocols_ManufactureInfo_descriptor,
        new java.lang.String[] { "MakingQueue", "StartTime", });
    internal_static_Protocols_ManufactureSpeedupReq_descriptor =
      getDescriptor().getMessageTypes().get(6);
    internal_static_Protocols_ManufactureSpeedupReq_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Protocols_ManufactureSpeedupReq_descriptor,
        new java.lang.String[] { "BuildingId", "SpeedupCard", "Index", });
    internal_static_Protocols_ManufactureSpeedupRsp_descriptor =
      getDescriptor().getMessageTypes().get(7);
    internal_static_Protocols_ManufactureSpeedupRsp_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Protocols_ManufactureSpeedupRsp_descriptor,
        new java.lang.String[] { "ErrorID", "Info", "Req", });
    internal_static_Protocols_ManufactureBatchPickupReq_descriptor =
      getDescriptor().getMessageTypes().get(8);
    internal_static_Protocols_ManufactureBatchPickupReq_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Protocols_ManufactureBatchPickupReq_descriptor,
        new java.lang.String[] { "BuildingId", });
    internal_static_Protocols_ManufactureBatchPickupRsp_descriptor =
      getDescriptor().getMessageTypes().get(9);
    internal_static_Protocols_ManufactureBatchPickupRsp_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Protocols_ManufactureBatchPickupRsp_descriptor,
        new java.lang.String[] { "ErrorID", "SuccessIndex", });
    com.dj.protobuf.ErrorIDOuterClass.getDescriptor();
    com.dj.protobuf.datetime.DateTimeOuterClass.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
