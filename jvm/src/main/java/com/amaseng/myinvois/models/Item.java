package com.amaseng.myinvois.models;

public class Item {
    private ItemClassificationCode[] itemClassificationCode;
    private String description;
    private String originCountryCode;

    public Item(ItemClassificationCode[] itemClassificationCode, String description, String originCountryCode) {
        this.itemClassificationCode = itemClassificationCode;
        this.description = description;
        this.originCountryCode = originCountryCode;
    }

    public ItemClassificationCode[] getItemClassificationCode() {
        return itemClassificationCode;
    }

    public String getDescription() {
        return description;
    }

    public String getOriginCountryCode() {
        return originCountryCode;
    }
}
