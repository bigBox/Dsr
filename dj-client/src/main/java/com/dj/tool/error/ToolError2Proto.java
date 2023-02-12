package com.dj.tool.error;

import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;

import com.dj.domain.util.FileUtil;

public class ToolError2Proto {

    public static void main(String[] args) throws Exception {

        String fileConent = "syntax = \"proto2\";\r\n" +
                "option java_package=\"com.dj.define\";\r\n" +
                "\r\n" +
                "enum ErrorID\r\n" +
                "{\r\n" +
                "@ErrorIDContent@" +
                "    \r\n" +
                "}";

        String fieldContent = "\n\t/// <summary>\r\n" +
                "\t/// @Desc@\r\n" +
                "\t/// </summary>\r\n" +
                "\t@Field@ = @Value@;";

        StringBuilder errorIDContent = new StringBuilder();
        for (Field e : ErrorCode.class.getDeclaredFields()) {
            String text = "";
            ErrorDesc c = e.getAnnotation(ErrorDesc.class);
            if (c != null) {
                byte[] b1 = c.text().getBytes(StandardCharsets.UTF_8);
                text = new String(b1, StandardCharsets.UTF_8);
                int code = e.getInt(null);
                String fieldTmp = fieldContent.replace("@Desc@", text);
                fieldTmp = fieldTmp.replace("@Field@", e.getName());
                fieldTmp = fieldTmp.replace("@Value@", code + "");
                errorIDContent.append(fieldTmp);
            }
        }
        fileConent = fileConent.replace("@ErrorIDContent@", errorIDContent.toString());
        System.out.println(fileConent);

        FileUtil.writeFile("D:\\work-xdq\\mycore\\proto2", "ErrorID.proto", fileConent);
    }
}
