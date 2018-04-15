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
        /*console.log("from component: ");
        console.log(this.response);*/
      },error => {
        //this.valid = error.ok;
        this.valid = false;
        console.log("from else: "+this.valid);
        console.log(error.status);
      })
    }

    if(this.valid){
      console.log("from the if: " + this.valid)
      this.router.navigate(['user']);
      this.valid = false;
    }
    else{
      // stay in same page
    }

  }
  ngOnInit() {

  }

}
