import { Component, OnInit } from '@angular/core';
import {ProductService} from "../services/product/product.service";

@Component({
  selector: 'app-add-product-to-store',
  templateUrl: './add-product-to-store.component.html',
  styleUrls: ['./add-product-to-store.component.css']
})
export class AddProductToStoreComponent implements OnInit {
  public products: [
    {
      "name" : "p1",
      "price" : "1",
      "brand" : "b1",
      "category" : "c1"
    },

    {
      "name" : "p2",
      "price" : "2",
      "brand" : "b2",
      "category" : "c2"
    },

    {
      "name" : "p3",
      "price" : "3",
      "brand" : "b3",
      "category" : "c3"
    },
    {
      "name" : "p1",
      "price" : "1",
      "brand" : "b1",
      "category" : "c1"
    }
    ];
  public chooseenProduct: any = null;
  public choosenQty: any = null;
  public choosenPrice: any = null;
  public storeId = 0;
  public store: any;

  constructor(private productService: ProductService) { }

  ngOnInit() {
    //this.productService.getProducts().subscribe(products => this.products = products);
  }

  addProduct(){
    console.log(this.chooseenProduct);
    //this.chooseenProduct.price = this.choosenPrice;
    //this.chooseenProduct.quantity = this.choosenQty;
    //this.productService.addProductToStore(this.chooseenProduct, this.storeId).subscribe(store => this.store = store);
  }

}
