package com.amaseng.myinvois.models;

public class InvoiceLine {
    private String id;
    private QuantityUnit invoicedQuantity;
    private MonetaryAmount lineExtensionAmount;
    private Charge[] allowanceCharge;
    private TaxTotal taxTotal;
    private Item item;
    private MonetaryAmount price;
    private MonetaryAmount itemPriceExtension;

    public InvoiceLine(String id, QuantityUnit invoicedQuantity, MonetaryAmount lineExtensionAmount, Charge[] allowanceCharge, TaxTotal taxTotal, Item item, MonetaryAmount price, MonetaryAmount itemPriceExtension) {
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
}
