package com.amaseng.myinvois.models;

import java.util.Date;

public class Period {
    private Date startDate;
    private Date endDate;
    private String description;

    public Period(Date startDate, Date endDate, String description) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public String getDescription() {
        return description;
    }
}
