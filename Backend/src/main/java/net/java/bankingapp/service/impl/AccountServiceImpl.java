package net.java.bankingapp.service.impl;

import net.java.bankingapp.dto.AccountDto;
import net.java.bankingapp.entity.Account;
import net.java.bankingapp.mapper.AccountMapper;
import net.java.bankingapp.repository.AccountRepository;
import net.java.bankingapp.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;


    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account account = AccountMapper.mapToAccount(accountDto);
        Account savedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(account);
    }

    @Override
    public AccountDto getAccountById(Long id) {
        Account account = accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account Doesnot Exist"));
        return AccountMapper.mapToAccountDto(account);
    }

    @Override
    public AccountDto deposit(Long id, double amount) {
        Account account = accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account Doesnot Exist"));
        double total = account.getBalance() + amount;
        account.setBalance(total);
        Account savedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto withdraw(Long id, double amount) {
        Account account = accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account Doesnot Exist"));
        Account savedAccount;
        if (account.getBalance() < amount) {
            throw new RuntimeException("Insufficent Balance");
        } else {
            double total = account.getBalance() - amount;
            account.setBalance(total);
            savedAccount = accountRepository.save(account);
        }
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public List<AccountDto> getAllAccount() {
        List<Account> accounts = accountRepository.findAll();

 return accounts.stream().map((account -> AccountMapper.mapToAccountDto(account))).collect(Collectors.toList());

    }

    @Override
    public void deleteAccount(Long id) {
        Account account = accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account Doesnot Exist"));

        accountRepository.deleteById(id);

    }
}

