import { Injectable } from '@angular/core';
import {Http} from "@angular/http";

@Injectable()
export class CategoryService {
  private baseURL: String =  "http://localhost:8080/category/";

  constructor(private http: Http) { }

  getCategories(){
    return this.http.get(this.baseURL+"getAll").map((response => response.json()));
  }

}
