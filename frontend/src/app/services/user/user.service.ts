import { Injectable } from '@angular/core';
import {Http} from "@angular/http";

@Injectable()
export class UserService {
  private baseURL: String = "http://localhost:8080/user/";

  constructor(private http:Http) { }


  register(user: any){
    console.log("recieved user: ");
    console.log(user);
    return this.http.post(this.baseURL+"register", user).map(
      response => response.json()
    );
  }

  loginByUserName(username :String, password :String){
    return this.http.get(this.baseURL+"login/byUserName?username="+username+"&password="+password).map((response => response.json()));
  }

  loginByEmail(email :String, password :String){
    return this.http.get(this.baseURL+"login/byEmail?email="+email+"&password="+password).map((response => response.json()));
  }
}
