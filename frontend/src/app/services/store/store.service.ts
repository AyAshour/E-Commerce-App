import { Injectable } from '@angular/core';
import {Http} from "@angular/http";
import 'rxjs/add/operator/map'
import {Observable} from "rxjs/Observable";
import {observableToBeFn} from "rxjs/testing/TestScheduler";
import {Observer} from "rxjs/Observer";

@Injectable()
export class StoreService {
  private baseURL: String = "http://localhost:8080/store/";

  constructor(private http: Http) { }

  getStoresRequests(){
    return this.http.get(this.baseURL+"getUnAcceptedStores").map((response => response.json()));
  }

  acceptStore(id){
    this.http.post(this.baseURL+"acceptStore/{"+id+"}", id);
  }
}
