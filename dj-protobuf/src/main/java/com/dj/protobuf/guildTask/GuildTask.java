// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: GuildTask.proto

package com.dj.protobuf.guildTask;

public final class GuildTask {
  private GuildTask() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Protocols_GuildTaskListReq_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Protocols_GuildTaskListReq_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Protocols_GuildTaskListRsp_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Protocols_GuildTaskListRsp_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Protocols_GuildTaskAcceptReq_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Protocols_GuildTaskAcceptReq_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Protocols_GuildTaskAcceptRsp_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Protocols_GuildTaskAcceptRsp_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Protocols_GuildTaskUpdateNtf_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Protocols_GuildTaskUpdateNtf_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Protocols_GuildTaskRemoveReq_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Protocols_GuildTaskRemoveReq_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Protocols_GuildTaskRemoveRsp_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Protocols_GuildTaskRemoveRsp_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Protocols_GuildTaskSpeedUpReq_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Protocols_GuildTaskSpeedUpReq_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Protocols_GuildTaskSpeedUpRsp_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Protocols_GuildTaskSpeedUpRsp_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Protocols_GuildTaskRewardReq_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Protocols_GuildTaskRewardReq_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Protocols_GuildTaskRewardRsp_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Protocols_GuildTaskRewardRsp_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\017GuildTask.proto\022\tProtocols\032\nTask.proto" +
      "\032\rErrorID.proto\"\022\n\020GuildTaskListReq\"Q\n\020G" +
      "uildTaskListRsp\022\031\n\007errorID\030\001 \001(\0162\010.Error" +
      "ID\022\"\n\005tasks\030\002 \003(\0132\023.Protocols.TaskInfo\"3" +
      "\n\022GuildTaskAcceptReq\022\016\n\006taskId\030\001 \001(\005\022\r\n\005" +
      "index\030\002 \001(\005\"~\n\022GuildTaskAcceptRsp\022\031\n\007err" +
      "orID\030\001 \001(\0162\010.ErrorID\022*\n\003req\030\002 \001(\0132\035.Prot" +
      "ocols.GuildTaskAcceptReq\022!\n\004task\030\003 \001(\0132\023" +
      ".Protocols.TaskInfo\"7\n\022GuildTaskUpdateNt" +
      "f\022!\n\004task\030\001 \001(\0132\023.Protocols.TaskInfo\"3\n\022",
      "GuildTaskRemoveReq\022\016\n\006taskId\030\001 \001(\005\022\r\n\005in" +
      "dex\030\002 \001(\005\"~\n\022GuildTaskRemoveRsp\022\031\n\007error" +
      "ID\030\001 \001(\0162\010.ErrorID\022*\n\003req\030\002 \001(\0132\035.Protoc" +
      "ols.GuildTaskRemoveReq\022!\n\004task\030\003 \001(\0132\023.P" +
      "rotocols.TaskInfo\"4\n\023GuildTaskSpeedUpReq" +
      "\022\016\n\006taskId\030\001 \001(\005\022\r\n\005index\030\002 \001(\005\"\200\001\n\023Guil" +
      "dTaskSpeedUpRsp\022\031\n\007errorID\030\001 \001(\0162\010.Error" +
      "ID\022+\n\003req\030\002 \001(\0132\036.Protocols.GuildTaskSpe" +
      "edUpReq\022!\n\004task\030\003 \001(\0132\023.Protocols.TaskIn" +
      "fo\"3\n\022GuildTaskRewardReq\022\016\n\006taskId\030\001 \001(\005",
      "\022\r\n\005index\030\002 \001(\005\"~\n\022GuildTaskRewardRsp\022\031\n" +
      "\007errorID\030\001 \001(\0162\010.ErrorID\022*\n\003req\030\002 \001(\0132\035." +
      "Protocols.GuildTaskRewardReq\022!\n\004task\030\003 \001" +
      "(\0132\023.Protocols.TaskInfoB\035\n\031com.dj.protob" +
      "uf.guildTaskP\001"
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
          com.dj.protobuf.task.Task.getDescriptor(),
          com.dj.protobuf.ErrorIDOuterClass.getDescriptor(),
        }, assigner);
    internal_static_Protocols_GuildTaskListReq_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_Protocols_GuildTaskListReq_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Protocols_GuildTaskListReq_descriptor,
        new java.lang.String[] { });
    internal_static_Protocols_GuildTaskListRsp_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_Protocols_GuildTaskListRsp_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Protocols_GuildTaskListRsp_descriptor,
        new java.lang.String[] { "ErrorID", "Tasks", });
    internal_static_Protocols_GuildTaskAcceptReq_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_Protocols_GuildTaskAcceptReq_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Protocols_GuildTaskAcceptReq_descriptor,
        new java.lang.String[] { "TaskId", "Index", });
    internal_static_Protocols_GuildTaskAcceptRsp_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_Protocols_GuildTaskAcceptRsp_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Protocols_GuildTaskAcceptRsp_descriptor,
        new java.lang.String[] { "ErrorID", "Req", "Task", });
    internal_static_Protocols_GuildTaskUpdateNtf_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_Protocols_GuildTaskUpdateNtf_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Protocols_GuildTaskUpdateNtf_descriptor,
        new java.lang.String[] { "Task", });
    internal_static_Protocols_GuildTaskRemoveReq_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_Protocols_GuildTaskRemoveReq_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Protocols_GuildTaskRemoveReq_descriptor,
        new java.lang.String[] { "TaskId", "Index", });
    internal_static_Protocols_GuildTaskRemoveRsp_descriptor =
      getDescriptor().getMessageTypes().get(6);
    internal_static_Protocols_GuildTaskRemoveRsp_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Protocols_GuildTaskRemoveRsp_descriptor,
        new java.lang.String[] { "ErrorID", "Req", "Task", });
    internal_static_Protocols_GuildTaskSpeedUpReq_descriptor =
      getDescriptor().getMessageTypes().get(7);
    internal_static_Protocols_GuildTaskSpeedUpReq_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Protocols_GuildTaskSpeedUpReq_descriptor,
        new java.lang.String[] { "TaskId", "Index", });
    internal_static_Protocols_GuildTaskSpeedUpRsp_descriptor =
      getDescriptor().getMessageTypes().get(8);
    internal_static_Protocols_GuildTaskSpeedUpRsp_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Protocols_GuildTaskSpeedUpRsp_descriptor,
        new java.lang.String[] { "ErrorID", "Req", "Task", });
    internal_static_Protocols_GuildTaskRewardReq_descriptor =
      getDescriptor().getMessageTypes().get(9);
    internal_static_Protocols_GuildTaskRewardReq_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Protocols_GuildTaskRewardReq_descriptor,
        new java.lang.String[] { "TaskId", "Index", });
    internal_static_Protocols_GuildTaskRewardRsp_descriptor =
      getDescriptor().getMessageTypes().get(10);
    internal_static_Protocols_GuildTaskRewardRsp_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Protocols_GuildTaskRewardRsp_descriptor,
        new java.lang.String[] { "ErrorID", "Req", "Task", });
    com.dj.protobuf.task.Task.getDescriptor();
    com.dj.protobuf.ErrorIDOuterClass.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
