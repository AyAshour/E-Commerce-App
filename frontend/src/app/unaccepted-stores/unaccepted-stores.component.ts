import { Component, OnInit } from '@angular/core';
import {StoreService} from "../services/store/store.service";

@Component({
  selector: 'app-unaccepted-stores',
  templateUrl: './unaccepted-stores.component.html',
  styleUrls: ['./unaccepted-stores.component.css']
})
export class UnacceptedStoresComponent implements OnInit {
   public unacceptedStores: any [];

  constructor(private storeService:StoreService) { }

  ngOnInit() {
    this.storeService.getStoresRequests().subscribe(stores => {this.unacceptedStores = stores;
    console.log(stores);
    });
  }

  acceptStore(store){
    console.log("herer");
    this.storeService.acceptStore(store.id);

  }


}
