package com.amaseng.myinvois.models;

public class PartyIdentification {
    private String id;
    private String schemaID;

    public PartyIdentification(String id, String schemaID) {
        this.id = id;
        this.schemaID = schemaID;
    }

    public String getId() {
        return id;
    }

    public String getSchemaID() {
        return schemaID;
    }
}
