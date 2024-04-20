package com.amaseng.myinvois.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class InvoiceLine {
    private String id;
    private QuantityUnit invoicedQuantity;
    private MonetaryAmount lineExtensionAmount;
    private Charge[] allowanceCharge;
    private TaxTotal taxTotal;
    private Item item;
    private MonetaryAmount price;
    private MonetaryAmount itemPriceExtension;

    public InvoiceLine(String id, QuantityUnit invoicedQuantity, MonetaryAmount lineExtensionAmount, Charge[] allowanceCharge,
                       TaxTotal taxTotal, Item item, MonetaryAmount price, MonetaryAmount itemPriceExtension) {
        this.id = id;
        this.invoicedQuantity = invoicedQuantity;
        this.lineExtensionAmount = lineExtensionAmount;
        this.allowanceCharge = allowanceCharge;
        this.taxTotal = taxTotal;
        this.item = item;
        this.price = price;
        this.itemPriceExtension = itemPriceExtension;
    }

    public String getId() {
        return id;
    }

    public QuantityUnit getInvoicedQuantity() {
        return invoicedQuantity;
    }

    public MonetaryAmount getLineExtensionAmount() {
        return lineExtensionAmount;
    }

    public Charge[] getAllowanceCharge() {
        return allowanceCharge;
    }

    public TaxTotal getTaxTotal() {
        return taxTotal;
    }

    public Item getItem() {
        return item;
    }

    public MonetaryAmount getPrice() {
        return price;
    }

    public MonetaryAmount getItemPriceExtension() {
        return itemPriceExtension;
    }

    public Map<Object, Object> toMap() {
        Map<Object, Object> map = new LinkedHashMap<>();
        map.put("ID", new ArrayList<Object>() {{ add(new LinkedHashMap<Object, Object>() {{ put("_", id); }}); }});
        map.put("InvoicedQuantity", new ArrayList<Object>() {{ add(invoicedQuantity.toMap()); }});
        map.put("LineExtensionAmount", new ArrayList<Object>() {{ add(lineExtensionAmount.toMap()); }});
        if (allowanceCharge != null && allowanceCharge.length > 0)
            map.put("AllowanceCharge", Arrays.stream(allowanceCharge).map(Charge::toMap).toArray());
        map.put("TaxTotal", new ArrayList<Object>() {{ add(taxTotal.toMap()); }});
        map.put("Item", new ArrayList<Object>() {{ add(item.toMap()); }});
        map.put("Price", new ArrayList<Object>() {{
            add(new LinkedHashMap<Object, Object>() {{
                put("PriceAmount", new ArrayList<Object>() {{ add(price.toMap()); }});
            }});
        }});
        map.put("ItemPriceExtension", new ArrayList<Object>() {{
            add(new LinkedHashMap<Object, Object>() {{
                put("Amount", new ArrayList<Object>() {{ add(itemPriceExtension.toMap()); }});
            }});
        }});
        return map;
    }
}
