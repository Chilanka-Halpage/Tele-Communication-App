import { PkgActivationListComponent } from './component/pkg-activation-list/pkg-activation-list.component';
import { PkgActivationComponent } from './component/pkg-activation/pkg-activation.component';
import { PaymentComponent } from './component/payment/payment.component';
import { CustomerComponent } from './component/customer/customer.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CustomerListComponent } from './component/customer-list/customer-list.component';
import { PaymentListComponent } from './component/payment-list/payment-list.component';

const routes: Routes = [
  { path: 'customers/new', component: CustomerComponent },
  { path: 'customers/view', component: CustomerListComponent },
  { path: 'customers/edit/:accNo', component: CustomerComponent },
  { path: 'customers/:accNo/payments/new', component: PaymentComponent },
  { path: 'customers/:accNo/payments/view', component: PaymentListComponent },
  { path: 'customers/:accNo/pkgs/new', component: PkgActivationComponent },
  { path: 'customers/:accNo/pkgs/view', component: PkgActivationListComponent },
  { path: '', redirectTo: 'customers/view', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
