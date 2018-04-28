import { Component, OnInit } from '@angular/core';
import {ProductService} from "../services/product/product.service";
import {StoreService} from "../services/store/store.service";

@Component({
  selector: 'app-add-product-to-store',
  templateUrl: './add-product-to-store.component.html',
  styleUrls: ['./add-product-to-store.component.css']
})
export class AddProductToStoreComponent implements OnInit {
  public products = [];
  public chooseenProduct: any = null;
  public choosenQty: any = null;
  public choosenPrice: any = null;
  public storeId = 0;
  public store: any;

  constructor(private productService: ProductService, private storeService : StoreService) { }

  ngOnInit() {
    this.productService.getProducts().subscribe(products => this.products = products);
  }

  addProduct(){
    console.log(this.chooseenProduct);
    this.chooseenProduct.price = this.choosenPrice;
    this.chooseenProduct.quantity = this.choosenQty;
    this.storeService.addProductToStore(this.chooseenProduct, this.storeId).subscribe(store => this.store = store);
  }

}
