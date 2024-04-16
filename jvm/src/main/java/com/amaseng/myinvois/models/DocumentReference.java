package com.amaseng.myinvois.models;

public class DocumentReference {
    private String id;
    private String documentType;;
    private String documentDescription;

    public DocumentReference(String id, String documentType, String documentDescription) {
        this.id = id;
        this.documentType = documentType;
        this.documentDescription = documentDescription;
    }

    public String getId() {
        return id;
    }

    public String getDocumentType() {
        return documentType;
    }

    public String getDocumentDescription() {
        return documentDescription;
    }
}
