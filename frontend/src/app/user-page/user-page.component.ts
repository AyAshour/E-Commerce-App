import { Component, OnInit } from '@angular/core';
import { UserService} from "../services/user/user.service";

@Component({
  selector: 'app-user-page',
  templateUrl: './user-page.component.html',
  styleUrls: ['./user-page.component.css']
})
export class UserPageComponent implements OnInit {
  public admin : boolean = false;
  public customer : boolean = false;
  public storeOwner : boolean = false
  public collaborator : boolean = false;
  public currentUser : any = null;


  constructor(private userService : UserService) { }

  ngOnInit() {
    this.setCurrentUser();

    this.admin = this.userService.isAdmin();
    this.customer = this.userService.isCustomer();
    this.storeOwner = this.userService.isStoreOwner();
    this.collaborator = this.userService.isCollaborator();
  }

  setCurrentUser(){
    this.userService.getCurrentUser().subscribe(response => {
      this.currentUser = response;
    });
  }

}
