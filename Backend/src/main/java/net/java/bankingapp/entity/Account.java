package net.java.bankingapp.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "accounts")
public class Account {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
@Column(name = "account_holder_name")
    private  String accountHolderName;
    private double balance;
}
