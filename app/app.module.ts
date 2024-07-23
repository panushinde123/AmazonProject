import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { BuyerComponent } from './buyer/buyer.component';
import { SellerComponent } from './seller/seller.component';
import { AdminComponent } from './admin/admin.component';
import { FormsModule } from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import { CategoryMngtComponent } from './admin/category-mngt/category-mngt.component';
import { ProductComponent } from './seller/product/product.component';
import { ShowProductComponent } from './buyer/show-product/show-product.component';
import { CartComponent } from './buyer/cart/cart.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    BuyerComponent,
    SellerComponent,
    AdminComponent,
    CategoryMngtComponent,
    ProductComponent,
    ShowProductComponent,
    CartComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
