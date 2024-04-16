package com.amaseng.myinvois.models;

public class PaymentMeans {
    private String paymentMeansCode;
    private FinancialAccount payeeFinancialAccount;

    public PaymentMeans(String paymentMeansCode, FinancialAccount payeeFinancialAccount) {
        this.paymentMeansCode = paymentMeansCode;
        this.payeeFinancialAccount = payeeFinancialAccount;
    }

    public String getPaymentMeansCode() {
        return paymentMeansCode;
    }

    public FinancialAccount getPayeeFinancialAccount() {
        return payeeFinancialAccount;
    }
}
