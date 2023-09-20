package com.jcanseco.dev.bank.minibank.accountsservice.models;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
public class Loan {
    private int id;
    private int customerId;
    private Date startDate;
    private String loanType;
    private int totalLoan;
    private int amountPaid;
    private int outstandingAmount;
    private LocalDate createdAt;
}
