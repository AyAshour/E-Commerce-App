import { Component, OnInit } from '@angular/core';
import { StoreService} from "../services/store/store.service";

@Component({
  selector: 'app-view-products',
  templateUrl: './view-products.component.html',
  styleUrls: ['./view-products.component.css']
})
export class ViewProductsComponent implements OnInit {
  public products = [
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

  constructor(private storeService : StoreService) { }

  ngOnInit() {
    this.storeService.getStoreProducts().subscribe(products => {
      this.products = products;
      console.log(products);
    });
  }

}
