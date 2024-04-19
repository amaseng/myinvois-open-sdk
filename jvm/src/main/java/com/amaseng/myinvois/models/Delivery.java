package com.amaseng.myinvois.models;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class Delivery {
    private AccountingParty deliveryParty;
    private Shipment shipment;

    public Delivery(AccountingParty deliveryParty, Shipment shipment) {
        this.deliveryParty = deliveryParty;
        this.shipment = shipment;
    }

    public AccountingParty getDeliveryParty() {
        return deliveryParty;
    }

    public Shipment getShipment() {
        return shipment;
    }

    public Map<Object, Object> toMap() {
        return new LinkedHashMap<Object, Object>() {{
            put("DeliveryParty", new ArrayList<Object>() {{ add(deliveryParty.toMap()); }});
            put("Shipment", new ArrayList<Object>() {{ add(shipment.toMap()); }});
        }};
    }

}