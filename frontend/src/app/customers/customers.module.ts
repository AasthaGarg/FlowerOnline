import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CustomersRoutingModule } from './customers-routing.module';
import { CustomersComponent } from './customers.component';
import { LoginComponent } from './login/login.component';
import { ShopComponent } from './shop/shop.component';
import { CartComponent } from './cart/cart.component';
import { LocationComponent } from './location/location.component';
import { ReviewComponent } from './review/review.component';
import { ContactComponent } from './contact/contact.component';
import { HomeComponent } from './home/home.component';
import { DetailsComponent } from './details/details.component';
import { FormsModule } from '@angular/forms';
import { SignupComponent } from './signup/signup.component';
import { ProductByCategoryComponent } from './product-by-category/product-by-category.component';
import { PaymentComponent } from './payment/payment.component';


@NgModule({
  declarations: [CustomersComponent, LoginComponent, ShopComponent, CartComponent, LocationComponent, ReviewComponent, ContactComponent, HomeComponent, DetailsComponent, SignupComponent, ProductByCategoryComponent, PaymentComponent],
  imports: [
    CommonModule,
    FormsModule,
    CustomersRoutingModule
  ]
})
export class CustomersModule { }
