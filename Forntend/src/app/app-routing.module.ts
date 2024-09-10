import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AccountListComponent } from './account-list/account-list.component';
import { CreateAccountComponent } from './create-account/create-account.component';
import { DepositComponent } from './deposit/deposit.component';

const routes: Routes = [
  {
    path:'accounts',component:AccountListComponent
  },

  {
    path:'create-account',component:CreateAccountComponent
  },
  {
    path:'deposit/:id',component:DepositComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
