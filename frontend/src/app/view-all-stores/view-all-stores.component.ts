import { Component, OnInit } from '@angular/core';
import { StoreService} from "../services/store/store.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-view-all-stores',
  templateUrl: './view-all-stores.component.html',
  styleUrls: ['./view-all-stores.component.css']
})
export class ViewAllStoresComponent implements OnInit {
  stores : any = [];
  choosenStore : any = null;
  constructor(private storeService : StoreService, private router: Router ) { }

  ngOnInit() {
    this.storeService.getAcceptedStores().subscribe(stores => {
      this.stores = stores;
      console.log(stores);
    });
  }

  viewStore(){
    this.storeService.setCurrentSelectedStore(this.choosenStore);
    this.router.navigate(['viewStoreProducts']);
  }

}
