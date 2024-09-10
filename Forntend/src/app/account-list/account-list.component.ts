import { Component, OnInit } from '@angular/core';
import { AccountserviceService } from '../accountservice.service';
import { Account } from '../account';
import { Router } from '@angular/router';

@Component({
  selector: 'app-account-list',
  templateUrl: './account-list.component.html',
  styleUrls: ['./account-list.component.css']
})
export class AccountListComponent implements OnInit{

  accounts:Account[]=[];

  constructor(private accountservice:AccountserviceService,private router:Router){}
  ngOnInit(): void {
    this.getAccounts();
  }

  getAccounts(){
    this.accountservice.getAllAccounts().subscribe(data=>{
      this.accounts=data;
    })
  }

  deposit(id:number){
    this.router.navigate(['/deposit',id])
  }


}
