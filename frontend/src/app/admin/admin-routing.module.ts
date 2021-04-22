import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminComponent } from './admin.component';
import { LoginComponent } from './login/login.component';
import { AddProductsComponent } from './add-products/add-products.component';
import { ViewProductsComponent } from './view-products/view-products.component';
import { ReportsComponent } from './reports/reports.component';
import { AddLocationComponent } from './add-location/add-location.component';
import { ViewLocationComponent } from './view-location/view-location.component';

const routes: Routes = [{ path: '', component: AdminComponent,
children: [
  { path: 'add', component: AddProductsComponent },
  { path: 'login', component: LoginComponent},
  { path: 'addloc', component: AddLocationComponent},
  { path: 'viewloc', component: ViewLocationComponent},
  { path: 'view', component: ViewProductsComponent },
  { path: 'reports', component: ReportsComponent}] },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdminRoutingModule { }
