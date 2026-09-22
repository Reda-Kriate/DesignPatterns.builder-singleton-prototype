package org.reda.buildersingletonprototype.repository;

import org.reda.buildersingletonprototype.entity.BankAccount;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public interface BankAccountRepository {
    BankAccount save(BankAccount bankAccount);
    Optional<BankAccount> findById(Long id);
    List<BankAccount> findAll();
    List<BankAccount> searchAccounts(Predicate<BankAccount> predicate);
    BankAccount update(BankAccount bankAccount);
    void deleteById(Long id);

}
