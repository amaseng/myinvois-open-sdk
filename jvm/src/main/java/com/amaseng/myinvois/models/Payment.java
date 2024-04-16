package com.amaseng.myinvois.models;

import java.util.Date;

public class Payment {
    private String id;
    private MonetaryAmount paidAmount;
    private Date paidDateTime;

    public Payment(String id, MonetaryAmount paidAmount, Date paidDateTime) {
        this.id = id;
        this.paidAmount = paidAmount;
        this.paidDateTime = paidDateTime;
    }

    public String getId() {
        return id;
    }

    public MonetaryAmount getPaidAmount() {
        return paidAmount;
    }

    public Date getPaidDateTime() {
        return paidDateTime;
    }
}
