package com.jcanseco.dev.bank.minibank.loansservice.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.time.LocalDate;
import java.util.Date;
@Setter
@Getter
@Table(name = "loans")
@Entity
@ToString
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "customer_id")
    private int customerId;
    @Column(name = "start_date")
    private Date startDate;
    @Column(name = "loan_type")
    private String loanType;
    @Column(name = "total_loan")
    private int totalLoan;
    @Column(name = "amount_paid")
    private int amountPaid;
    @Column(name = "outstanding_amount")
    private int outstandingAmount;
    @Column(name = "created_at")
    private LocalDate createdAt;
}
