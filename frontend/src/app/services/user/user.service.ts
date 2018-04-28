import { Injectable } from '@angular/core';
import {Http} from "@angular/http";

@Injectable()
export class UserService {
  private baseURL: String = "http://localhost:8080/user/";
 // private currentUser : any = null;
  private response : any = null;
  private loggedIn = false;

  constructor(private http:Http) { }


  register(user: any){
    /*console.log("recieved user: ");
    console.log(user);*/
    this.response =  this.http.post(this.baseURL+"register", user).map(
      response => response.json()
    );

    return this.response;
  }

  loginByUserName(username :String, password :String){
    this.response =  this.http.get(this.baseURL+"login/byUserName?username="+username+"&password="+password).map((response => response.json()));
   /* console.log("from service: ");
    console.log(this.getCurrentUser());*/
    return this.response;
  }

  loginByEmail(email :String, password :String){
    this.response = this.http.get(this.baseURL+"login/byEmail?email="+email+"&password="+password).map((response => response.json()));
    return this.response;
  }

  getCurrentUser(){
    return this.response;
    /*this.response.subscribe(response => {
      this.currentUser = response;
    });

    console.log("from servc: ");
    console.log(this.currentUser);

    return this.currentUser;*/
  }
  setLoggedIn(isLoggedIn : boolean){
    this.loggedIn = isLoggedIn;
  }
  getLoggedIn(){
    return this.loggedIn;
  }
  isAdmin(){
    return true;
  }
  isCustomer(){
    return true;
  }
  isStoreOwner(){
    return true;
  }
  isCollaborator(){
    return true;
  }
}
