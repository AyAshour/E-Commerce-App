import { Injectable } from '@angular/core';
import {Http} from "@angular/http";


@Injectable()
export class CartService {
  private baseURL: String = "http://localhost:8080/cart/";

  constructor(private http : Http) {}

  getCart(user : object){
    return this.http.get(this.baseURL + "getCartByUser", user).map(response => response.json());
  }

  buyProducts(cart : object){
    return this.http.post(this.baseURL + "buyProducts", cart).map(response => response.json());
  }

  getTotalPrice(username : String, cartId : String){
    return this.http.get(this.baseURL + "calculatePrice?username="+username+"&cartId="+cartId).map(response => response.json());
  }

  addProductToCart(product : object, cartId : String, storeId : String){
    return this.http.post(this.baseURL + "addProduct?cartId="+cartId+"&storeId="+storeId, product).map(response => response.json());
  }

  removeProductFromCart(product : object, cartId : String){
    return this.http.post(this.baseURL + "removeProduct?cartId="+cartId, product).map(response => response.json());
  }

  assignCartToUser(user : object){
    return this.http.get(this.baseURL + "getCartByUser", user).map(response => response.json());
  }

}
