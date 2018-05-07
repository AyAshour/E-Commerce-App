import { Component, OnInit } from '@angular/core';
import {UserService} from "../services/user/user.service";

@Component({
  selector: 'app-register-form',
  templateUrl: './register-form.component.html',
  styleUrls: ['./register-form.component.css']
})
export class RegisterFormComponent implements OnInit {

  private response : object = null;
  private valid : boolean = false;
  public user = {
    "type" : 2,
    "email" : "",
    "username" : "",
    "password" : ""
  }


  constructor(private userService: UserService) { }

  register(){
    this.userService.register(this.user).subscribe(response => {
        this.response = response;
        //console.log(response.status);
      },
      error => {
        console.log(error.status);
        console.log(error.ok);
        this.valid = error.ok;
      });

    if(this.valid){
      // go to page according to your type
    }
  }


  ngOnInit() {
  }

}
