package org.reda.buildersingletonprototype.repository;

import ch.qos.logback.core.encoder.JsonEscapeUtil;
import org.reda.buildersingletonprototype.entity.BankAccount;
import org.reda.buildersingletonprototype.enums.AccountStatus;
import org.reda.buildersingletonprototype.enums.AccountType;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class AccountRepoImpl implements BankAccountRepository{

    //Singleton Pattern ---------
    private static final AccountRepoImpl accountRepoImpl;

    static {
        accountRepoImpl = new AccountRepoImpl();
    }

    public static AccountRepoImpl getInstant(){
        return accountRepoImpl;
    }

    private AccountRepoImpl() {
    }

    // -----------------------------------

    Map<Long, BankAccount> accountMap = new HashMap<Long, BankAccount>();

    Long idCounter = 0L;
    @Override
    public BankAccount save(BankAccount bankAccount) {
        //synchronized (this){
//            Long idCounter = 0L;
            Long accountId = ++idCounter;
            bankAccount.setId(accountId);
            accountMap.put(accountId, bankAccount);
        //}
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

    public synchronized void populatedata() {
        for(int i = 0 ; i < 10 ; i++){
            BankAccount bankAccount = BankAccount.builder()
                    .balance(90000+Math.random()*10000)
                    .currency(Math.random() > 0.5 ? "MAD" : "USD")
                    .type(Math.random() > 0.5 ? AccountType.CURRENT : AccountType.SAVINGS)
                    .status(Math.random() > 0.5 ? AccountStatus.ACTIVE : AccountStatus.SUSPENDED)
                    .build();
            save(bankAccount);

            System.out.println("*******************************");
            System.out.println(Thread.currentThread().getName());
            System.out.println("Accounts count : " + idCounter);
            System.out.println("size : " + accountMap.size());
            System.out.println("*******************************");

        }
    }
}
