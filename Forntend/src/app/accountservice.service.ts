import { HttpClient } from '@angular/common/http';
import { Injectable, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Account } from './account';

@Injectable({
  providedIn: 'root'
})
export class AccountserviceService implements OnInit {

  constructor(private httpclient:HttpClient) { }
  private baseUrl="http://localhost:8080/api/accounts"
  ngOnInit(): void {
  
  }

  getAllAccounts():Observable<Account[]>{
    return this.httpclient.get<Account[]>(`${this.baseUrl}`);
  }

  createAccount(account:Account):Observable<Account>{
  return  this.httpclient.post<Account>(`${this.baseUrl}`,account);
  }


  getAccountById(id:number):Observable<Account>{
    return this.httpclient.get<Account>(`${this.baseUrl}/${id}`)

  }

  deposit(id:number,amount:number):Observable<Account>{
    const request={amount}

    return this.httpclient.put<Account>(`${this.baseUrl}/${id}/deposit`,request)
  }

}
