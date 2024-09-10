package net.java.bankingapp.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
@AllArgsConstructor

@Data
@Getter
public class AccountDto {
   private Long id;
private String accountHolderName;
    private double balance;
}
