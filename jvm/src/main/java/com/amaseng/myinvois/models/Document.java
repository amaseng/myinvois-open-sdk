package com.amaseng.myinvois.models;

import java.util.Map;
import java.util.LinkedHashMap;

public class Document {
    private String format;
    private String document;
    private String documentHash;
    private String codeNumber;

    public Document(String format, String document, String documentHash, String codeNumber) {
        this.format = format;
        this.document = document;
        this.documentHash = documentHash;
        this.codeNumber = codeNumber;
    }

    public String getFormat() {
        return format;
    }

    public String getDocument() {
        return document;
    }

    public String getDocumentHash() {
        return documentHash;
    }

    public String getCodeNumber() {
        return codeNumber;
    }

    public Map<Object, Object> toMap() {
        return new LinkedHashMap<Object, Object>() {{
            put("Format", format);
            put("Document", document);
            put("DocumentHash", documentHash);
            put("CodeNumber", codeNumber);
        }};
    }

    public Document fromInvoice(Invoice invoice) {
        return new Document("JSON", invoice.toMap().toString(), "1234567890", "1234567890");
    }
}
