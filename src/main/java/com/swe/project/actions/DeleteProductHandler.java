package com.swe.project.actions;

import com.swe.project.entity.Action;
import com.swe.project.entity.ProductActions;
import com.swe.project.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DeleteProductHandler implements TypeHandler {
    private static final String HANDLER_ID = "deleteProduct";
    @Autowired
    ProductService productService;
    @Override
    public void doAction(Action action) {

        ProductActions productActions = (ProductActions) action;
        productService.remove(productActions.getProduct(), productActions.getStore());
    }

    @Override
    public  void undoAction(Action action){

    }

    @Autowired
    TypeHandlerFactory typeHandlerFactory;
    @PostConstruct
    public void registerSelf(){
        typeHandlerFactory.registerHandler(DeleteProductHandler.HANDLER_ID, this);
    }
}
