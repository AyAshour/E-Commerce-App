import { Injectable } from '@angular/core';
import {Http} from "@angular/http";

@Injectable()
export class ProductService {
  private baseURL: String =  "http://localhost:8080/product/";

  constructor(private http: Http) { }

  getProducts(){
    return this.http.get(this.baseURL+"getAll").map((response => response.json()));
  }

  addProductToSystem(product: any){
    return this.http.post(this.baseURL+"addProductToSystem", product);
  }

  addProductToStore(product: any, storeId: any){
    return this.http.post(this.baseURL+"addProductToStore?"+storeId, product);
  }


}
