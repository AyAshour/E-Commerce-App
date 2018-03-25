package com.swe.project.controller;

import com.swe.project.entity.Store;
import com.swe.project.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "/store")
public class StoreController {

    @Autowired
    private StoreRepository storeRepo;

    @PostMapping(path = "/addStore")
    public String addStore(@RequestParam String name, @RequestParam String type, @RequestParam String location, @RequestParam String owner){
        Store s = new Store(name, type, location, owner);
        storeRepo.save(s);
        return "done";
    }

    @PostMapping("/acceptStore")
    public String acceptStore(@RequestParam Integer id){
        Store targetStore = storeRepo.findStoreById(id);
        storeRepo.delete(targetStore); // to avoid duplicated data
        targetStore.setAccepted(true);
        storeRepo.save(targetStore);
        return "done!";
    }

    @PostMapping("/unAcceptStore")
    @Transactional
    public void unAcceptStore(@RequestParam Integer id){
        storeRepo.deleteById(id);
    }

    @GetMapping(path = "/getAcceptedStores")
    public Iterable<Store> getAcceptedStores(){
        return storeRepo.findStoresByAccepted(true);
    }

    @GetMapping(path = "/getUnAcceptedStores")
    public Iterable<Store> getUnAcceptedStores(){
        return storeRepo.findStoresByAccepted(false);
    }

    /*@PostMapping(path = "/addStore")
    public String addStore(@ModelAttribute("store") Store store){
        storeRepo.save(store);
        return "done!";
    }*/
}
