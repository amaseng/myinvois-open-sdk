package com.amaseng.myinvois.models;

public class ItemClassificationCode {
    private String id;
    private String listID;

    public ItemClassificationCode(String id, String listID) {
        this.id = id;
        this.listID = listID;
    }

    public String getId() {
        return id;
    }

    public String getListID() {
        return listID;
    }
}
