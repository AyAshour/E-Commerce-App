import { Component, OnInit } from '@angular/core';
import {UserService} from "../services/user/user.service";

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})
export class MainComponent implements OnInit {

  private response : object = null;
  private isEmail: boolean = false;
  public user = {
    "email" : "",
    "username" : "",
    "password" : ""
  }

  constructor(private userService: UserService){}


  ngOnInit() {
  }

}
