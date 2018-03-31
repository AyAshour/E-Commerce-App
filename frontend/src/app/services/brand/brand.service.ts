import { Injectable } from '@angular/core';
import {Http} from "@angular/http";

@Injectable()
export class BrandService {
  private baseURL: String =  "http://localhost:8080/brand/";

  constructor(private http: Http) { }

  getBrands(){
    return this.http.get(this.baseURL+"getAll").map((response => response.json()));
  }
}
