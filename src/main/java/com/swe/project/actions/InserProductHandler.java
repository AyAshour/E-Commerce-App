package com.swe.project.actions;

import com.swe.project.entity.Action;
import com.swe.project.entity.ProductActions;
import com.swe.project.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class InserProductHandler implements TypeHandler{
    private static final String HANDLER_ID = "insertProduct";
    @Autowired
    ProductService productService;
    @Override
    public void doAction(Action action) {

        ProductActions productActions = (ProductActions)action;
        productService.addProduct(productActions.getProduct(), productActions.getStore().getStoreId());
    }

    @Override
    public  void undoAction(Action action){
        ProductActions productActions = (ProductActions)action;
        productService.remove(productActions.getProduct(), productActions.getStore());

    }

    @Autowired
    TypeHandlerFactory typeHandlerFactory;
    @PostConstruct
    public void registerSelf(){
        typeHandlerFactory.registerHandler(InserProductHandler.HANDLER_ID, this);
    }
}
