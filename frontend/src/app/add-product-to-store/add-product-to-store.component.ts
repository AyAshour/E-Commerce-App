import { Component, OnInit } from '@angular/core';
import {ProductService} from "../services/product/product.service";

@Component({
  selector: 'app-add-product-to-store',
  templateUrl: './add-product-to-store.component.html',
  styleUrls: ['./add-product-to-store.component.css']
})
export class AddProductToStoreComponent implements OnInit {
  public products: any[];

  constructor(private productService: ProductService) { }

  ngOnInit() {
    this.productService.getProducts().subscribe(products => this.products = products);
  }

}
