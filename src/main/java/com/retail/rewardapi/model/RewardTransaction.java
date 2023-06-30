package com.retail.rewardapi.model;

import java.time.LocalDate;
import java.util.Date;

public class RewardTransaction {

    private Long transactionId;
    private Long customerId;
    private String customerName;
    private Long transactionAmount;
    private LocalDate createdDate;

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Long getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(Long transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return "rewardtransactions{" +
                "transactionId=" + transactionId +
                ", customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", transactionAmount=" + transactionAmount +
                ", createdDate=" + createdDate +
                '}';
    }

    public RewardTransaction(Long transactionId, Long customerId, String customerName, Long transactionAmount, LocalDate createdDate) {
        this.transactionId = transactionId;
        this.customerId = customerId;
        this.customerName = customerName;
        this.transactionAmount = transactionAmount;
        this.createdDate = createdDate;
    }
}
