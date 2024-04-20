package com.amaseng.myinvois.models;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

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

    public Map<Object, Object> toMap() {
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat timeFormatter = new SimpleDateFormat("HH:mm:ss'Z'");
        Map<Object, Object> map = new LinkedHashMap<>();
        map.put("ID", new ArrayList<Object>() {{ add(new LinkedHashMap<Object, Object>() {{ put("_", id); }}); }});
        map.put("PaidAmount", new ArrayList<Object>() {{ add(paidAmount.toMap()); }});
        map.put("PaidDate", new ArrayList<Object>() {{ add(new LinkedHashMap<Object, Object>() {{ put("_", dateFormatter.format(paidDateTime)); }}); }});
        map.put("PaidTime", new ArrayList<Object>() {{ add(new LinkedHashMap<Object, Object>() {{ put("_", timeFormatter.format(paidDateTime)); }}); }});
        return map;
    }
}
