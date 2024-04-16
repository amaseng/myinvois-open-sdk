package com.amaseng.myinvois.models;

public class Shipment {
    private String id;
    private FreightAllowanceCharge freightAllowanceCharge;

    public Shipment(String id, FreightAllowanceCharge freightAllowanceCharge) {
        this.id = id;
        this.freightAllowanceCharge = freightAllowanceCharge;
    }

    public String getId() {
        return id;
    }

    public FreightAllowanceCharge getFreightAllowanceCharge() {
        return freightAllowanceCharge;
    }
}
