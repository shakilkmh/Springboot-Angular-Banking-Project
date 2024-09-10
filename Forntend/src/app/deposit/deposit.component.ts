import { Component, OnInit } from '@angular/core';
import { Account } from '../account';
import { AccountserviceService } from '../accountservice.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-deposit',
  templateUrl: './deposit.component.html',
  styleUrls: ['./deposit.component.css']
})
export class DepositComponent implements OnInit {
  id:number=0;
  account:Account=new Account();

  constructor(private accountService:AccountserviceService,private rout:ActivatedRoute,private router:Router){

  }
  ngOnInit(): void {
    this.id=this.rout.snapshot.params['id'];
    this.accountService.getAccountById(this.id).subscribe(data=>{
      this.account=data;
    })
  }

  onSubmit(){
    this.accountService.deposit(this.id,this.account.balance).subscribe(data=>{
      this.account=data;
      this.router.navigate(['/accounts'])

    })
  }

}
