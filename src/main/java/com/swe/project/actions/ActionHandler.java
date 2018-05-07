package com.swe.project.actions;

import com.swe.project.entity.Action;

public interface ActionHandler {
    public void doAction(Action action);
    public void undoAction(Action action);
}
