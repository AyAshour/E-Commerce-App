package com.swe.project.controller;

import com.swe.project.entity.Store;
import com.swe.project.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


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

   /*@GetMapping(path = "/getStore")
    public ResponseEntity<Store> getStore(@RequestParam String name, @RequestParam String type, @RequestParam String location){
        Store s = new Store(name, type, location);
        return ResponseEntity.status(200).body(s);
    }*/
}
