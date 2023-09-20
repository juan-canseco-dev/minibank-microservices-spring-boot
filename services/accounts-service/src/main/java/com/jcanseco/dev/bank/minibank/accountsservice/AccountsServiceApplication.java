package com.jcanseco.dev.bank.minibank.accountsservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.jcanseco.dev.bank.minibank")
@EnableFeignClients
@SpringBootApplication
public class AccountsServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(AccountsServiceApplication.class, args);
    }
}
