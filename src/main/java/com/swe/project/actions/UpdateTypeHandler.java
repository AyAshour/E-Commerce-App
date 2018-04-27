package com.swe.project.actions;

import com.swe.project.entity.Action;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

public class UpdateTypeHandler implements TypeHandler {
    private static final String HANDLER_ID = "update";

    @Override
    public void doAction(Action action) {

    }

    @Override
    public void undoAction(Action action) {

    }

    @Autowired TypeHandlerFactory typeHandlerFactory;
    @PostConstruct
    public void registerSelf(){
        typeHandlerFactory.registerHandler(UpdateTypeHandler.HANDLER_ID, this);
    }
}
