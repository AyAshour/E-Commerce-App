import { Component, OnInit } from '@angular/core';
import { UserService} from "../services/user/user.service";

@Component({
  selector: 'app-admin-page',
  templateUrl: './admin-page.component.html',
  styleUrls: ['./admin-page.component.css']
})
export class AdminPageComponent implements OnInit {

  constructor(private userService : UserService) { }

  public currentUser : any = null;

  ngOnInit() {
    this.setCurrentUser();
  }

  setCurrentUser(){
    this.userService.getCurrentUser().subscribe(response => {
      this.currentUser = response;
    });
  }
}
