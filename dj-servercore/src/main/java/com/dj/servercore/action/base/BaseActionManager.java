package com.dj.servercore.action.base;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dj.protobuf.Module;
import com.dj.servercore.spring.SpringContext;
import com.dj.servercore.task.msg.MyMsg;
import com.dj.domain.util.ClassUtil;
import com.dj.domain.util.StringUtil;
import com.dj.domain.util.Utility;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class BaseActionManager {
    protected Map<Module, BaseAction> actionModule = new HashMap<>();

    @SuppressWarnings({"rawtypes", "unchecked", "deprecation"})
    public void initAction(Class cls) {
        try {
            List<String> list = ClassUtil.getAllClassesNameByPackageName(cls.getPackage().getName(), true);
            for (String str : list) {
                Class clazz = Class.forName(str);
                IActionModule annotation = (IActionModule) clazz.getAnnotation(IActionModule.class);
                if (annotation != null) {
                    BaseAction actionModel = (BaseAction) clazz.newInstance();
                    Field[] fields = clazz.getDeclaredFields();
                    for (Field field : fields) {
                        IFieldHandler handler = field.getAnnotation(IFieldHandler.class);
                        if (handler != null) {
                            Method method = clazz.getMethod("set" + StringUtil.firstChar2upperCase(field.getName()), field.getType());
                            method.invoke(actionModel, SpringContext.getBean(field.getType()));
                        }
                    }
                    actionModel.initCmdMethods(clazz);
                    actionModule.put(annotation.module(), actionModel);
                }
            }
        } catch (Exception e) {
            log.error(Utility.getTraceString(e));
        }
    }

    public long doAction(MyMsg msg) throws Exception {
        if (msg.getContent() == null) {
            return 0;
        }
        BaseAction action = actionModule.get(msg.getModule());
        if (action == null) {
            log.error("error module {} cls {}", msg.getModule(), msg.getContent().getClass().getSimpleName());
        }
        Method method = action.getMethod(msg.getCmd());
        if (method == null) {
            log.error("error method {} cls {}", msg.getCmd(), msg.getContent().getClass().getSimpleName());
        }
        if (method.getReturnType() == Long.class) {
            return (long) method.invoke(action, msg);
        } else {
            method.invoke(action, msg);
            return 0;
        }
    }
    
    public BaseAction getAction(Module module) {
    	BaseAction action = actionModule.get(module);
    	return action;
    }
}
