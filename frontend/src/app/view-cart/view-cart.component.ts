import { Component, OnInit } from '@angular/core';
import { UserService} from "../services/user/user.service";
import { CartService} from "../services/cart/cart.service";


@Component({
  selector: 'app-view-cart',
  templateUrl: './view-cart.component.html',
  styleUrls: ['./view-cart.component.css']
})
export class ViewCartComponent implements OnInit {

  private cart : object = null;
  private currentUser : object = null;

  constructor(private userService : UserService, private cartService : CartService) {}

  ngOnInit() {
    this.setCurrentUser();
    this.setCart(this.currentUser);
  }

  setCurrentUser(){
    this.userService.getCurrentUser().subscribe(response => {
      this.currentUser = response;
    });
    // if this is not working, return this.currentUser and call a function inside the other .
  }

  setCart(user : object){
    this.cartService.getCart(user).subscribe(response => {
      this.cart = response;
    })
  }

}
