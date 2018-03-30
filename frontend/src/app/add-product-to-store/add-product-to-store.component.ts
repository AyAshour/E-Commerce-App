import { Component, OnInit } from '@angular/core';
import {ProductService} from "../services/product/product.service";

@Component({
  selector: 'app-add-product-to-store',
  templateUrl: './add-product-to-store.component.html',
  styleUrls: ['./add-product-to-store.component.css']
})
export class AddProductToStoreComponent implements OnInit {
  public products: any[];
  public chooseenProduct: any;
  public storeId = 0;
  public store: any;

  constructor(private productService: ProductService) { }

  ngOnInit() {
    this.productService.getProducts().subscribe(products => this.products = products);
  }

  addProduct(){
    this.productService.addProductToStore(this.chooseenProduct, this.storeId).subscribe(store => this.store = store);
  }

}
