package com.amaseng.myinvois.models;

public class IndustryClassificationCode {
    private String id;
    private String name;

    public IndustryClassificationCode(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
