package com.jcanseco.dev.bank.minibank.loansservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.jcanseco.dev.bank.minibank")
@SpringBootApplication
public class LoansServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(LoansServiceApplication.class, args);
    }

}
