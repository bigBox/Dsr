@echo off & title protocGen - By: zcq
echo press any button to start.
@pause > nul

e:
cd /work_repository/cehua/client
@popd

D:/tool/protoc-3.0.0-win32/bin/protoc.exe --proto_path=proto2  --java_out=E:/work_repository/server/dj-define/src/main/java proto2/ErrorID.proto
echo ErrorID.proto


for /f "delims=" %%a in ('dir proto2 /b/a-d/oN *.proto') do (
	if %%a NEQ ErrorID.proto (
		if %%a NEQ ProtoID.xml (
			D:/tool/protoc-3.0.0-win32/bin/protoc.exe --proto_path=proto2  --java_out=E:/work_repository/server/dj-protobuf/src/main/java ./proto2/%%a
			echo %%a
		)
	)
)

echo press any button to end.
@pause > nul