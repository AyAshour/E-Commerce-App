package com.swe.project.actions;

import com.swe.project.entity.Action;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class OfferActionHandler implements ActionHandler {
    private static final String HANDLER_ID = "offer";

    @Override
    public void doAction(Action action) {

    }

    @Override
    public void undoAction(Action action) {

    }

    @Autowired ActionHandlerFactory actionHandlerFactory;
    @PostConstruct
    public void registerSelf() {
        actionHandlerFactory.registerHandler(OfferActionHandler.HANDLER_ID, this);
    }
}
