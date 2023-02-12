package com.dj.servercore.action.base;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import com.dj.protobuf.CommonException;
import com.dj.protobuf.ErrorIDOuterClass.ErrorID;
import com.dj.domain.util.StringUtil;
import com.dj.domain.util.Utility;
import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageV3;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class BaseAction {

    private Map<Integer, Method> cmdMethods = new HashMap<>();

    @SuppressWarnings("rawtypes")
    public void initCmdMethods(Class cls) {
        for (Method method : cls.getDeclaredMethods()) {
            IActionCmd cmd = method.getAnnotation(IActionCmd.class);
            if (cmd != null) {
                cmdMethods.put(cmd.cmd(), method);
            }
        }
    }

    public Method getMethod(int cmd) {
        return cmdMethods.get(cmd);
    }

    public ErrorID handleService(Runnable runnable) {
        ErrorID errorID = ErrorID.OK;
        try {
            runnable.run();
        } catch (CommonException e) {
            errorID = e.getErrorID();
            log.error("code:{},message:{}", errorID, e.getMessage());
            logError(e, errorID, e.getMessage());
        } catch (Exception e) {
            errorID = ErrorID.SYSTEM_ERROR;
            logError(e, errorID, "");
        }
        return errorID;
    }

    protected GeneratedMessageV3 doReqHandler(long roleID, String reqClz, ByteString reqByte) {
        try {
            GeneratedMessageV3 req = (GeneratedMessageV3) Class.forName(reqClz).getMethod("parseFrom", ByteString.class).invoke(null, reqByte);
            log.debug("roleID 【{}】, req:{}, content:{}", roleID, req.getClass().getSimpleName(), StringUtil.msg2Json(req));
            String clsName = req.getClass().getSimpleName();
            Method method = this.getClass().getMethod(StringUtil.firstChar2lowerCase(clsName), long.class, req.getClass());
            GeneratedMessageV3 rspContent = (GeneratedMessageV3) method.invoke(this, roleID, req);
            return rspContent;
        } catch (Exception e) {
        	log.error(Utility.getTraceString(e));
        }
        return null;
    }

    protected GeneratedMessageV3 doReqHandler(long roleID, String reqClz, ByteString reqByte, String ps) {
        try {
            GeneratedMessageV3 req = (GeneratedMessageV3) Class.forName(reqClz).getMethod("parseFrom", ByteString.class).invoke(null, reqByte);
            log.debug("roleID 【{}】, req:{}, content:{}", roleID, req.getClass().getSimpleName(), StringUtil.msg2Json(req));
            String clsName = req.getClass().getSimpleName();
            Method method = this.getClass().getMethod(StringUtil.firstChar2lowerCase(clsName), long.class, req.getClass(), String.class);
            GeneratedMessageV3 rspContent = (GeneratedMessageV3) method.invoke(this, roleID, req, ps);
            return rspContent;
        } catch (Exception e) {
         	log.error(Utility.getTraceString(e));
        }
        return null;
    }

    protected void logError(Exception e, ErrorID errorID, String message) {
        String error = Utility.getTraceString(e);
        log.error(error);
        //WechatUtil.writeActionException(AbsServer.getServerConfig().getTag(), AbsServer.getServerConfig().getName(), AbsServer.getServerConfig().getId(), errorID, message, error);
    }
}
