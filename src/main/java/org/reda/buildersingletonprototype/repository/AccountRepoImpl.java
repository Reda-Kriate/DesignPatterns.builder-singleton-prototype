package org.reda.buildersingletonprototype.repository;

import org.reda.buildersingletonprototype.entity.BankAccount;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class AccountRepoImpl implements BankAccountRepository{
    Map<Long, BankAccount> accountMap = new HashMap<Long, BankAccount>();
    Long idCounter = 0L;
    @Override
    public BankAccount save(BankAccount bankAccount) {
        Long accountId = ++idCounter;
        bankAccount.setId(accountId);
        accountMap.put(accountId, bankAccount);
        return bankAccount;
    }

    @Override
    public Optional<BankAccount> findById(Long id) {
        BankAccount bankAccount = accountMap.get(id);
        if(bankAccount == null){
            return Optional.empty();
        }else{
            return Optional.of(bankAccount);
        }
    }

    @Override
    public List<BankAccount> findAll() {
        return accountMap.values().stream().toList();
    }

    @Override
    public List<BankAccount> searchAccounts(Predicate<BankAccount> predicate) {
        return accountMap.values().stream().filter(predicate).collect(Collectors.toList());
    }

    @Override
    public BankAccount update(BankAccount bankAccount) {
        return accountMap.put(bankAccount.getId(), bankAccount);
    }

    @Override
    public void deleteById(Long id) {
        accountMap.remove(id);
    }
}
