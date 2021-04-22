import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CustomersComponent } from './customers.component';
import { LoginComponent } from './login/login.component';
import { ShopComponent } from './shop/shop.component';
import { CartComponent } from './cart/cart.component';
import { LocationComponent } from './location/location.component';
import { ReviewComponent } from './review/review.component';
import { ContactComponent } from './contact/contact.component';
import { HomeComponent } from './home/home.component';
import { DetailsComponent } from './details/details.component';
import { SignupComponent } from './signup/signup.component';
import { ProductByCategoryComponent } from './product-by-category/product-by-category.component';
import { PaymentComponent } from './payment/payment.component';

const routes: Routes = [{ path: '', component: CustomersComponent,
children: [
  { path: 'products', component: HomeComponent },
  { path: 'login', component: LoginComponent },
{ path: 'shop', component: ShopComponent },
{ path: 'cart', component: CartComponent },
{ path: 'location', component: LocationComponent },
{ path: 'review', component: ReviewComponent },
{ path: 'contact', component: ContactComponent },
{ path: 'details', component: DetailsComponent},
{ path: 'signup', component: SignupComponent},
{ path: 'productByCategory', component: ProductByCategoryComponent},
{ path: 'payment', component: PaymentComponent}]
}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CustomersRoutingModule { }
