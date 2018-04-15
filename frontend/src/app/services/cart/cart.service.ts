import { Injectable } from '@angular/core';
import {Http} from "@angular/http";


@Injectable()
export class CartService {
  private baseURL: String = "http://localhost:8080/cart/";
  private response : any = null;

  constructor(private http : Http) {}

  getCart(user : object){
    this.response = this.http.get(this.baseURL + "getCartByUser", user).map(response => response.json());
    return this.response;
  }

  // add product to cart
}
