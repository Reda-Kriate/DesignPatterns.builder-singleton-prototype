package org.reda.buildersingletonprototype;

import org.reda.buildersingletonprototype.entity.BankAccount;
import org.reda.buildersingletonprototype.repository.AccountRepoImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class BuilderSingletonPrototypeApplication {

    public static void main(String[] args) {
        SpringApplication.run(BuilderSingletonPrototypeApplication.class, args);

        //Pattern singleton call
        AccountRepoImpl accountRepo = AccountRepoImpl.getInstant();


        accountRepo.populatedata();
        List<BankAccount> all = accountRepo.findAll();
        all.forEach(a -> System.out.println(a.toString()));

        for (int i = 0 ; i < 10 ; i++){
            new Thread(()->{
                accountRepo.populatedata();
            }).start();
        }
    }
}
