package com.swe.project.controller;

import com.swe.project.entity.Product;
import com.swe.project.entity.Store;
import com.swe.project.entity.User;
import com.swe.project.repository.StoreRepository;
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

    @PostMapping(path = "/addStore")
    public ResponseEntity<?> addStore(@RequestBody Store store){
        storeRepo.save(store);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/acceptStore")
    public ResponseEntity<?> acceptStore(@RequestParam Integer id){
        Store targetStore = storeRepo.findStoreById(id);
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

    /*@PostMapping(path = "/addStore")
    public ResponseEntity<?> addStore(@ModelAttribute("store") Store store){
        storeRepo.save(store);
        return ResponseEntity.ok().build();;
    }*/
}
