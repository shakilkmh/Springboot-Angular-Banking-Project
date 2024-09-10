import { Router } from '@angular/router';
import { Account } from '../account';
import { AccountserviceService } from './../accountservice.service';
import { Component, OnInit } from '@angular/core';
import { timeout } from 'rxjs';

@Component({
  selector: 'app-create-account',
  templateUrl: './create-account.component.html',
  styleUrls: ['./create-account.component.css']
})
export class CreateAccountComponent implements OnInit{

  account:Account=new Account();

  accountCreate=false;


  constructor(private Accountservice:AccountserviceService, private router:Router){}
  ngOnInit(): void {
    
  }


  onSubmit(){
    this.saveAccount();
  }

  saveAccount(){
    this.Accountservice.createAccount(this.account).subscribe(data=>{
      this.accountCreate=true;
      setTimeout(()=>{
        this.goToAccountList();
      },10000)
    
    })


  }

  goToAccountList(){
    this.router.navigate(["/accounts"])
  }

}