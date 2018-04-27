package com.swe.project.actions;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ActionHandlerFactory {
    Map<String, ActionHandler> actionHandlerMap;

    public ActionHandlerFactory() {
        actionHandlerMap = new HashMap<>();
    }

    public ActionHandler getHandler(String s) {
        return actionHandlerMap.get(s);
    }

    public void registerHandler(String s, ActionHandler actionHandler) {
        this.actionHandlerMap.put(s, actionHandler);
    }
}
