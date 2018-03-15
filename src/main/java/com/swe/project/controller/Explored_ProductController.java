package com.swe.project.controller;

import com.swe.project.entity.*;
import com.swe.project.repository.Explored_ProductRepository;
import com.swe.project.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

@RestController
public class Explored_ProductController {
    @Autowired
    private Explored_ProductRepository explored_productRepository;

    @Autowired
    private StoreRepository storeRepository;


    Iterable<Explored_Product> getExplored_Products() {
        return explored_productRepository.findAll();
    }

    ArrayList<Explored_Product> filterExplored_ProductsByStore(Store s) {
        Iterable<Explored_Product> products = getExplored_Products();
        ArrayList<Explored_Product> ret = new ArrayList<>();
        for (Explored_Product p : products) {
            Integer id = p.getProductID();
            int sID = s.getId();
            if (sID == id) {
                ret.add(p);
            }
        }
        return ret;
    }

    Integer numberOfUsersExploredHisProducts(Store s) {
        ArrayList<Explored_Product> products = filterExplored_ProductsByStore(s);
        int sum = 0;
        HashMap<Integer, Integer> mp = new HashMap<Integer, Integer>();
        for (Explored_Product p : products) {
            Integer id = p.getCustomerID();
            if (!mp.containsKey(id)) {
                mp.put(id, 1);
                sum++;
            }
        }
        return sum;
    }
}