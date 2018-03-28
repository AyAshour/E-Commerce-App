import { Component, OnInit } from '@angular/core';
import {UserService} from "../services/user/user.service";

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})
export class MainComponent implements OnInit {

  private res : object = null;
  private isEmail: boolean = false;
  public user = {
    "email" : "",
    "username" : "",
    "password" : ""
  }

  constructor(private userService: UserService){}

  register(){
    this.userService.register(this.user).subscribe(response => {
        console.log(response)
        this.res = response.json();
      });
  }

  login(){
    /*check*/
    if(this.isEmail){
      this.userService.loginByEmail(this.user).subscribe(response => {
        this.res = response;
      })
    }
    else{
      this.userService.loginByUserName(this.user).subscribe(response => {
        this.res = response;
      })
    }


  }

  ngOnInit() {
  }

}
