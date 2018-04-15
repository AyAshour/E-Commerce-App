package com.swe.project.service;



import com.swe.project.entity.Product;
import com.swe.project.entity.Store;
import com.swe.project.entity.User;
import com.swe.project.repository.ProductRepository;
import com.swe.project.repository.StoreRepository;
import com.swe.project.repository.UserRepository;
import com.swe.project.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.TreeSet;

@Service
public class StoreService {
     private UserRepository userRepository;
     private StoreRepository storeRepository;
     private ProductRepository productRepository;

     public void addStore(Store store, String ownerUsername){
         store.setOwner(userRepository.findByUsername(ownerUsername));
         storeRepository.save(store);
     }

//    @Autowired
//    StoreProductsRepository storeProductsDP;
//    @Autowired
//    BuyProductRepository buyProductDP;
//    @Autowired
//    Explored_ProductRepository exploredDP;
//    @Autowired
//    ProductRepository productDP;
//
//    public static StoreService singleTone = new StoreService();

//    public ArrayList<Integer> getAllProductsID(Integer storeID){
//       Iterable<StoreProducts> all = storeProductsDP.findAllByStoreID(storeID);
//       ArrayList<Integer> ret = new ArrayList<Integer>();
//       for(StoreProducts sp : all){
//           ret.add(sp.product_id);
//       }
//       return ret;
//   }

    public Iterable<Product> getAllProducts(Integer storeID){
      return null;//productRepository.findAllByStore(new Store(storeID));
   }
   public Integer numberOfStoreViewers(Integer storeID) {
       Iterable<Product> storeProducts = getAllProducts(storeID);
       TreeSet<String> users = new TreeSet<String>();
       for(Product p :storeProducts){

       }
       return users.size();
   }

//   public ArrayList<Product> getAllProducts(Integer storeID){
//       Iterable<StoreProducts> all = storeProductsDP.findAllByStoreID(storeID);
//       ArrayList<Product> ret = new ArrayList<Product>();
//       for(StoreProducts sp : all) ret.add(productDP.findProductById(sp.product_id));
//       return ret;
//   }
//   public Integer numberOfStoreViewers(Integer storeID) {
//       ArrayList<Integer> products_ids = getAllProductsID(storeID);
//       TreeSet<String> users = new TreeSet<String>();
//       for(Integer id :products_ids){
//           Iterable<Explored_Product> ex = exploredDP.findAllByProductID(id);
//           for(Explored_Product exi : ex){
//               users.add(exi.getUsername());
//           }
//       }
//       return users.size();
//   }

//   public Integer numberOfStoreBuyers(Integer storeID) {
//       ArrayList<Integer> products_ids = getAllProductsID(storeID);
//       TreeSet<String> users = new TreeSet<String>();
//       for(Integer id :products_ids){
//           Iterable<BuyProduct> bp = buyProductDP.findAllByProductID(id);
//           for(BuyProduct bpi:bp){
//               users.add(bpi.username);
//           }
//       }
//       return  users.size();
//   }
//    public ArrayList<Product> soldOutProducts(Integer storeID){
//       ArrayList<Product> ret = new ArrayList<Product>();
//       ArrayList<Integer> products_ids = getAllProductsID(storeID);
//       for(Integer id :products_ids){
//           Product p = productDP.findProductById(id);
//           if(p!=null){
//               ret.add(p);
//           }
//       }
//       return ret;
//    }

}
    