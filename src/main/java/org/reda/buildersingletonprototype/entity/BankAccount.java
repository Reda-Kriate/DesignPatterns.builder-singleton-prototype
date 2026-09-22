package org.reda.buildersingletonprototype.entity;

import org.reda.buildersingletonprototype.enums.AccountStatus;
import org.reda.buildersingletonprototype.enums.AccountType;

public class BankAccount {
    private Long id;
    private double balance;
    private String currency;
    private AccountType type;
    private AccountStatus status;

    public BankAccount(Long id, double balance, String currency, AccountType type, AccountStatus status) {
        this.id = id;
        this.balance = balance;
        this.currency = currency;
        this.type = type;
        this.status = status;
    }

    public BankAccount() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }

    public AccountType getType() {
        return type;
    }

    public void setType(AccountType type) {
        this.type = type;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "id=" + id +
                ", balance=" + balance +
                ", currency='" + currency + '\'' +
                ", type=" + type +
                ", status=" + status +
                '}';
    }

}
