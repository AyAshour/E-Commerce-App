import { Injectable } from '@angular/core';
import {Http} from "@angular/http";
import 'rxjs/add/operator/map'
import {Observable} from "rxjs/Observable";
import {observableToBeFn} from "rxjs/testing/TestScheduler";
import {Observer} from "rxjs/Observer";

@Injectable()
export class StoreService {
  private baseURL: String = "http://localhost:8080/store/";
  private currentSelected: object = null;

  constructor(private http: Http) { }

  getStoresRequests(){
    return this.http.get(this.baseURL+"getUnAcceptedStores").map((response => response.json()));
  }

  acceptStore(id){
    console.log("id: "+this.baseURL+"acceptStore?id="+id);
    this.http.post(this.baseURL+"acceptStore?id="+id, {
      parameters: {
        id: id
      }
    });
  }
  getStoreProducts(){
    return this.http.get(this.baseURL+"/getStoreProducts").map(response => response.json());
  }

  setCurrentSelectedStore(){

  }

  getCurrentSelectedStore(){

  }

}
