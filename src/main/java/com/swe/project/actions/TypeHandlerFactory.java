package com.swe.project.actions;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class TypeHandlerFactory {
    Map<String, TypeHandler> typeHandlerMap;

    public TypeHandlerFactory() {
        typeHandlerMap = new HashMap<>();
    }

    public TypeHandler getHandler(String s) {
        return typeHandlerMap.get(s);
    }

    public void registerHandler(String s, TypeHandler typeHandler) {
        this.typeHandlerMap.put(s, typeHandler);
    }
}
