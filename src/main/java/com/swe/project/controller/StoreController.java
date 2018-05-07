package com.swe.project.controller;

import com.swe.project.actions.ActionHandler;
import com.swe.project.actions.ActionHandlerFactory;
import com.swe.project.entity.*;
import com.swe.project.service.ActionsService;
import com.swe.project.service.ProductService;
import com.swe.project.service.StoreService;
import com.swe.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "/store")
public class StoreController {

    @Autowired
    private StoreService storeService;

    @Autowired
    private UserService userService;

    @Autowired
    private ActionHandlerFactory actionHandlerFactory;

    private ActionHandler actionHandler;

    @Autowired
    private ActionsService actionsService;

    @Autowired
    private ProductService productService;

    @GetMapping(value = "/showActions")
    public ResponseEntity<?>  showActions(@RequestParam("ownerUserName") String ownerUserName, @RequestParam("storeId") Integer storeId){
        /*Store store = storeRepo.findStoreById(storeId);
        User owner = store.getOwner();

        if(! ownerUserName.equals(owner.getUsername())){
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }*/
        List<Action> actions = actionsService.showActions(storeId);
        return ResponseEntity.ok().body(actions);/*
        showActionsService.showActions(storeId);
        return  ResponseEntity.ok().build();*/
    }

    @PostMapping(value = "/undoAction")
    public ResponseEntity<?>  undoAction(@RequestParam("actionId") Integer actionId, @RequestParam("ownerUserName") String ownerUserName){
        Action action = actionsService.getActionById(actionId);
        Store store = storeService.getStoreById(action.getStore().getStoreId());
        User owner = store.getOwner();

        if(! ownerUserName.equals(owner.getUsername())){
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        actionHandler = actionHandlerFactory.getHandler(action.getAffectedObject());
        actionHandler.undoAction(action);

        return ResponseEntity.ok().build();
    }


    @PostMapping(path = "/addStore")
    public ResponseEntity<?> addStore(@RequestBody Store store, @RequestParam String ownerUsername){
        User user = userService.findByUsername(ownerUsername);

        if(user == null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

        store.setOwner(user);
        storeService.addStore(store);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/acceptStore")

    public ResponseEntity<?> acceptStore(@RequestParam("storeId") Integer id){
        Store targetStore = storeService.getStoreById(id);
        targetStore.setAccepted(true);
        storeService.addStore(targetStore);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/unAcceptStore")
    @Transactional
    public ResponseEntity<?> unAcceptStore(@RequestParam Integer id){
        storeService.deleteStoreById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping(path = "/getAcceptedStores")
    public ResponseEntity<?> getAcceptedStores(){
        Iterable<Store> stores = storeService.findByAccepted(true);
        if(stores.equals(null))
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        else
            return ResponseEntity.status(HttpStatus.OK).body(stores);
    }

    @GetMapping(path = "/getUnAcceptedStores")
    public ResponseEntity<?> getUnAcceptedStores(){
        Iterable<Store> stores = storeService.findByAccepted(false);
        if(stores.equals(null))
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        else
            return ResponseEntity.status(HttpStatus.OK).body(stores);
    }



    @PostMapping("/addProductToStore")
    ResponseEntity<?> addProductToStore(@RequestBody Product product, @RequestParam("storeId") Integer storeId){

         Store store = storeService.addProduct(product, storeId);
       if(store == null)
          return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("there is no product with this id , please contact admin!");
       else {
           Action action = new ProductActions(product);
           action.setStore(store);
           action.setType("insertProduct");
           actionHandler = actionHandlerFactory.getHandler("product");
           actionHandler.doAction(action);
       }
       return ResponseEntity.status(HttpStatus.OK).body(store);

    }


    @RequestMapping("/removeProductFromStore")
    ResponseEntity<?> removeProduct(@RequestBody Product product, @RequestBody Store store){

        storeService.remove(product, store);
        if(store == null)
            ResponseEntity.status(HttpStatus.BAD_REQUEST).body("there is no product with this id , please contact admin!");
        else {
            Action action = new ProductActions(product);
            action.setStore(store);
            action.setType("deleteProduct");

            actionHandler = actionHandlerFactory.getHandler("product");
            actionHandler.doAction(action);
        }
        return ResponseEntity.status(HttpStatus.OK).body(store);
    }

    @GetMapping(path = "/getStoreProducts")
    public ResponseEntity<?> getStoreProducts(@RequestParam("storeId") Integer storeId) {
        List<Product> products = storeService.getStoreProducts(storeId);
        if (products.equals(null))
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        else
            return ResponseEntity.status(HttpStatus.OK).body(products);
    }
    @PostMapping("/addDiscountToProduct")
    public ResponseEntity<?> addDiscount(@RequestBody Product product, @RequestParam double discount) {
        productService.ApplyDiscount(product, discount);
        return ResponseEntity.ok().build();
    }
}

//    @GetMapping(path = "/adminView")
//    public ArrayList<Object> adminView(@RequestParam Integer storeID){
//        ArrayList<Object> ret = new ArrayList<Object>();
//        ret.add(storeService.getAllProducts(storeID));
//        ret.add(new Pair<String,Integer>("Store Viewers",storeService.numberOfStoreViewers(storeID)));
//        ret.add(new Pair<String,Integer>("Store Buyers",storeService.numberOfStoreBuyers(storeID)));
//        ret.add(new Pair<String,ArrayList<Product>>("Sold out products",storeService.soldOutProducts(storeID)));
//        return ret;
//    }