import { Injectable } from '@angular/core';
import {Http} from "@angular/http";
import 'rxjs/add/operator/map'
import {Observable} from "rxjs/Observable";
import {observableToBeFn} from "rxjs/testing/TestScheduler";
import {Observer} from "rxjs/Observer";

@Injectable()
export class StoreService {
  private baseURL: String = "http://localhost:8080/store/";
  private currentSelected: any = null;

  constructor(private http: Http) { }

  getStoresRequests(){
    return this.http.get(this.baseURL+"getUnAcceptedStores").map((response => response.json()));
  }

  acceptStore(storeId){
    this.http.post(this.baseURL+"acceptStore?storeId="+storeId, {
      parameters: {
        "id" : storeId
      }
    });
  }
  getAcceptedStores(){
    return this.http.get(this.baseURL + "getAcceptedStores").map(response => {
      console.log("from srvc" + response);
      response.json();
    });
  }
  getStoreProducts(storeId){
    return this.http.get(this.baseURL+"getStoreProducts"+storeId).map(response => response.json());
  }

  setCurrentSelectedStore(store : any){
    this.currentSelected = store;
  }

  getCurrentSelectedStore(){
    return this.currentSelected;
  }

  addProductToStore(product: any, storeId: any){
    return this.http.post(this.baseURL+"addProductToStore?storeId="+storeId, product);
  }

}
