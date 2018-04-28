import { Component, OnInit } from '@angular/core';
import {UserService} from "../services/user/user.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.css']
})
export class LoginFormComponent implements OnInit {

  private response : object = null;
  private valid : boolean = true;
  public  username_email : String = "";
  public  password : String = "";

  constructor(private userService: UserService, private router: Router) { }

  isEmail(){
    //return this.username_email.Validators.pattern("[^ @]*@[^ @]*");
    return false;
  }

  login(){
    console.log(this.username_email);
    console.log(this.password);
    if(this.isEmail()){
      this.userService.loginByEmail(this.username_email, this.password).subscribe(response => {
        this.response = response;
      },error => {
        this.valid = error.ok;
        console.log(this.valid);
        })
    }
    else{
      this.userService.loginByUserName(this.username_email, this.password).subscribe(response => {
        this.response = response;
        this.userService.setLoggedIn(true);
        console.log(this.userService.getLoggedIn());
      },error => {
        this.userService.setLoggedIn(false);
        /*console.log("from else: "+this.valid);
        console.log(error.status);*/
      })
    }
    this.router.navigate(['user']);
  }
  ngOnInit() {

  }

}
