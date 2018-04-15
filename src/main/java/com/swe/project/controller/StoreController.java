package com.swe.project.controller;

import com.swe.project.entity.*;
import com.swe.project.repository.ProductRepository;
import com.swe.project.repository.StoreRepository;
import com.swe.project.repository.UserRepository;
import com.swe.project.service.ProductDiscountService;
import com.swe.project.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(path = "/store")
public class StoreController {

    @Autowired
    private StoreRepository storeRepo;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private ProductRepository productRepo;

    @Autowired
    private StoreService storeService;


//    @GetMapping(path = "/adminView")
//    public ArrayList<Object> adminView(@RequestParam Integer storeID){
//        ArrayList<Object> ret = new ArrayList<Object>();
//        ret.add(storeService.getAllProducts(storeID));
//        ret.add(new Pair<String,Integer>("Store Viewers",storeService.numberOfStoreViewers(storeID)));
//        ret.add(new Pair<String,Integer>("Store Buyers",storeService.numberOfStoreBuyers(storeID)));
//        ret.add(new Pair<String,ArrayList<Product>>("Sold out products",storeService.soldOutProducts(storeID)));
//        return ret;
//    }

    @PostMapping(path = "/addStore")
    public ResponseEntity<?> addStore(@RequestBody Store store, @RequestParam String ownerUsername){

        store.setOwner(userRepo.findByUsername(ownerUsername)); // can i send it inside Store from the front end.
        storeRepo.save(store);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/acceptStore")
    public ResponseEntity<?> acceptStore(@RequestParam Integer id){
        Store targetStore = storeRepo.findStoreById(id);
        storeRepo.delete(targetStore); // to avoid duplicated data
        targetStore.accepted=true;
        targetStore.setAccepted(true);
        storeRepo.save(targetStore);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/unAcceptStore")
    @Transactional
    public ResponseEntity<?> unAcceptStore(@RequestParam Integer id){
        storeRepo.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping(path = "/getAcceptedStores")
    public ResponseEntity<?> getAcceptedStores(){
        Iterable<Store> stores = storeRepo.findStoresByAccepted(true);
        if(stores.equals(null))
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        else
            return ResponseEntity.status(HttpStatus.OK).body(stores);
    }

    @GetMapping(path = "/getUnAcceptedStores")
    public ResponseEntity<?> getUnAcceptedStores(){
        Iterable<Store> stores = storeRepo.findStoresByAccepted(false);
        if(stores.equals(null))
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        else
            return ResponseEntity.status(HttpStatus.OK).body(stores);
    }

    @PostMapping(path = "/addStoreObject")
    public String addStore(@ModelAttribute("store") Store store){
        storeRepo.save(store);
        return "done!";
    }
    @PostMapping("/addProductToStore")
    ResponseEntity<?> addProduct(@RequestBody Product product, @RequestParam("storeId") Integer storeId){
        Store store = storeRepo.findStoreById(storeId);

        store.getProducts().add(product);
        storeRepo.save(store);

        Integer addedQuantity = product.getQuantity();
        Product existProduct = productRepo.findProductById(product.getId());
        Integer existQuantity = existProduct.getQuantity();
        existProduct.setQuantity(existQuantity + addedQuantity);
        productRepo.save(existProduct);
        Action action = new ProductActions( product);
        action.setStore(store);
        action.setType("insert");
        ActionController actionController = new ProductActionsController();
        actionController.Add(action);
        return ResponseEntity.status(HttpStatus.OK).body(store);
    }

    @RequestMapping("/removeProductFromStore")
    ResponseEntity<?> removeProduct(@RequestBody Product product, @RequestParam Integer storeId, @RequestParam User originalOwner){
        Store store = storeRepo.findStoreById(storeId);
        Product productinSystem = productRepo.findProductById(product.getId());
        if(originalOwner.equals(store.getOwner())){
            for(Product p : store.getProducts()){
                if(p.equals(product)){

                    store.getProducts().remove(p);
                    storeRepo.save(store);

                    productinSystem.setQuantity(productinSystem.getQuantity() - p.getQuantity());
                    productRepo.save(productinSystem);

                    Action action = new ProductActions(product);
                    action.setStore(store);
                    action.setType("delete");
                    ActionController actionController = new ProductActionsController();
                    actionController.remove(action);

                    return ResponseEntity.ok().build();
                }
            }
        }
        return ResponseEntity.badRequest().build();
    }
    ProductDiscountService productDiscountService;
    @PostMapping("/addDiscountToProduct")
    public ResponseEntity<?> addDiscount(@RequestBody Product product, @RequestParam double discount) {
        productDiscountService.ApplyDiscount(product, discount);
        return ResponseEntity.ok().build();
    }
}
