package com.swe.project.actions;

import com.swe.project.entity.Action;
import com.swe.project.entity.ProductActions;
import com.swe.project.service.ProductActionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class ProductActionHandler implements ActionHandler {
    private static final String HANDLER_ID = "product";

    @Autowired
    private ProductActionsService productActionsService;

    TypeHandler typeHandler;

    @Autowired
    TypeHandlerFactory typeHandlerFactory;

    @Override
    public void doAction(Action action) {
        productActionsService.addAction((ProductActions) action);


    }

    @Override
    public void undoAction(Action action) {

        typeHandler = typeHandlerFactory.getHandler(action.getType());
        typeHandler.undoAction(action);

        productActionsService.removeAction((ProductActions) action);

    }

    @Autowired ActionHandlerFactory actionHandlerFactory;
    @PostConstruct
    public void registerSelf() {
        actionHandlerFactory.registerHandler(ProductActionHandler.HANDLER_ID, this);
    }
}
