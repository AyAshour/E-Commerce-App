import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule} from '@angular/forms';
import { AppComponent } from './app.component';
import { UnacceptedStoresComponent } from './unaccepted-stores/unaccepted-stores.component';
import {StoreService} from "./services/store/store.service";
import {UserService} from "./services/user/user.service";
import {ProductService} from "./services/product/product.service";
import {BrandService} from "./services/brand/brand.service";
import {CategoryService} from "./services/category/category.service";
import {CartService} from "./services/cart/cart.service";
import {HttpModule} from "@angular/http";
import { AddProductToStoreComponent } from './add-product-to-store/add-product-to-store.component';
import { AddProductToSystemComponent } from './add-product-to-system/add-product-to-system.component';
import { RegisterFormComponent } from './register-form/register-form.component';
import {RouterModule, Routes} from "@angular/router";
import { LoginFormComponent } from './login-form/login-form.component';
import { AdminPageComponent } from './admin-page/admin-page.component';
import { CustomerPageComponent } from './customer-page/customer-page.component';
import { StoreOwnerPageComponent } from './store-owner-page/store-owner-page.component';
import { HomePageComponent } from './home-page/home-page.component';
import { ViewProductsComponent } from './view-products/view-products.component';
import { ViewCartComponent } from './view-cart/view-cart.component';
import { UserPageComponent } from './user-page/user-page.component';
import { AuthenticationGuard} from "./guards/authentication/authentication.guard";
import { CollboratorComponent } from './collborator-page/collborator.component';
import { ViewAllStoresComponent} from "./view-all-stores/view-all-stores.component";
import { ViewMyStoresComponent } from './view-my-stores/view-my-stores.component';

const appRoutes: Routes = [
  {path: '', component: HomePageComponent },
  {path: 'user', canActivate: [AuthenticationGuard] , component: UserPageComponent},
  {path: 'admin', component: AdminPageComponent },
  {path: 'customer', component: CustomerPageComponent},

];


@NgModule({
  declarations: [
    AppComponent,
    UnacceptedStoresComponent,
    AddProductToStoreComponent,
    AddProductToSystemComponent,
    RegisterFormComponent,
    LoginFormComponent,
    AdminPageComponent,
    CustomerPageComponent,
    StoreOwnerPageComponent,
    HomePageComponent,
    ViewProductsComponent,
    ViewCartComponent,
    UserPageComponent,
    CollboratorComponent,
    ViewAllStoresComponent,
    ViewMyStoresComponent
  ],
  imports: [
    BrowserModule,
    HttpModule,
    FormsModule,
    RouterModule.forRoot(
      appRoutes,
      { enableTracing: true } // <-- debugging purposes only
    )
  ],
  providers: [StoreService, UserService, ProductService, BrandService, CategoryService, CartService, AuthenticationGuard],
  bootstrap: [AppComponent]
})
export class AppModule { }
