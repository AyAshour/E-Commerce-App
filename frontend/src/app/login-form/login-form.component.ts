import { Component, OnInit } from '@angular/core';
import {UserService} from "../services/user/user.service";

@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.css']
})
export class LoginFormComponent implements OnInit {

  private response : object = null;
  public  username_email : String =  "";
  public  password : String =  "";

  constructor(private userService: UserService) { }

  isEmail(){
    //return this.username_email.Validators.pattern("[^ @]*@[^ @]*");
  }

  login(){
    if(this.isEmail()){
      this.userService.loginByEmail(this.username_email, this.password).subscribe(response => {
        this.response = response;
      },error => {
        console.log(error.status);
        })
    }
    else{
      this.userService.loginByUserName(this.username_email, this.password).subscribe(response => {
        this.response = response;
      },error => {
        console.log(error.status);
      })
    }
  }

  ngOnInit() {
  }

}
