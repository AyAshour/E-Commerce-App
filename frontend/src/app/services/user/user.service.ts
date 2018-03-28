import { Injectable } from '@angular/core';
import {Http} from "@angular/http";

@Injectable()
export class UserService {
  private baseURL: String = "http://localhost:8080/user/";

  constructor(private http:Http) { }


  register(user: any){
    console.log("recieved user: ");
    console.log(user);
    return this.http.post(this.baseURL+"register", user);
  }

  loginByUserName(user: any){
    return this.http.get(this.baseURL+"login/byUserName").map((response => response.json()));
  }

  loginByEmail(user: any){
    return this.http.get(this.baseURL+"login/byEmail").map((response => response.json()));
  }
}
