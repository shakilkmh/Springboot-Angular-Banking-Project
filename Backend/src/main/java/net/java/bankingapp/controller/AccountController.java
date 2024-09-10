package net.java.bankingapp.controller;

import net.java.bankingapp.dto.AccountDto;
import net.java.bankingapp.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@CrossOrigin(origins = "http://localhost:4200")
@RestController

@RequestMapping("/api/accounts")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @PostMapping
    public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto){
        return new ResponseEntity<>(accountService.createAccount(accountDto), HttpStatus.CREATED);
    }


    @GetMapping("/{id}")
    public ResponseEntity<AccountDto > getAccountById(@PathVariable Long id){
        AccountDto accountDto=accountService.getAccountById(id);
        return  ResponseEntity.ok(accountDto);

    }

    @PutMapping("/{id}/deposit")
    public ResponseEntity<AccountDto>deposit(@PathVariable Long id, @RequestBody Map<String,Double> request){
        double amount=request.get("amount");
     AccountDto accountDto=  accountService.deposit(id,amount);
     return ResponseEntity.ok(accountDto);
    }


    @PutMapping("/{id}/withdraw")
    public ResponseEntity<AccountDto>withdraw(@PathVariable Long id, @RequestBody Map<String,Double> request){
        double amount=request.get("amount");
        AccountDto accountDto=  accountService.withdraw(id,amount);
        return ResponseEntity.ok(accountDto);
    }


    @GetMapping
    public ResponseEntity<List<AccountDto>> getALLAccounts(){
        List<AccountDto> allAccount = accountService.getAllAccount();
        return ResponseEntity.ok(allAccount);

    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable Long id){
        accountService.deleteAccount(id);
        return ResponseEntity.ok("Account is deleted  successfuly");
    }
}

