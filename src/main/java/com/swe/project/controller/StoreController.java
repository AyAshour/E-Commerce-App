package com.swe.project.controller;

import com.swe.project.entity.Store;
import com.swe.project.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "/store")
public class StoreController {

    @Autowired
    private StoreRepository storeRepo;

    @PostMapping(path = "/addStore")
    public String addStore(@RequestParam String name, @RequestParam String type, @RequestParam String location){
        Store s = new Store(name, type, location);
        storeRepo.save(s);
        return "done!";
    }

    @PostMapping("/acceptStore")
    @Transactional
    public String acceptStore(@RequestParam Integer id){
        Store targetStore = storeRepo.findStoreById(id);
        targetStore.setAccepted(true);
        storeRepo.save(targetStore);
        return "done!";
    }

    @PostMapping("/unAcceptStore")
    @Transactional
    public Integer unAcceptStore(@RequestParam Integer id){
        return storeRepo.removeStoreById(id);
    }

    @GetMapping(path = "/getAcceptedStores")
    public List<Store> getAcceptedStores(){
        return storeRepo.findStoresByAccepted(true);
    }

    @GetMapping(path = "/getUnAcceptedStores")
    public List<Store> getUnAcceptedStores(){
        return storeRepo.findStoresByAccepted(false);
    }

    /*@PostMapping(path = "/addStore")
    public String addStore(@ModelAttribute("store") Store store){
        storeRepo.save(store);
        return "done!";
    }*/
}