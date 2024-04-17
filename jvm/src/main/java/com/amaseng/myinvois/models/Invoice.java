package com.amaseng.myinvois.models;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Invoice {
    private String id;
    private Date issueDateTime;
    private String invoiceTypeCode;
    private String documentCurrencyCode;
    private PartyLegalEntity partyLegalEntity;
    private Contact contact;

    public Invoice(String id, Date issueDateTime, String invoiceTypeCode, String documentCurrencyCode, PartyLegalEntity partyLegalEntity, Contact contact) {
        this.id = id;
        this.issueDateTime = issueDateTime;
        this.invoiceTypeCode = invoiceTypeCode;
        this.documentCurrencyCode = documentCurrencyCode;
        this.partyLegalEntity = partyLegalEntity;
        this.contact = contact;
    }

    public String getId() {
        return id;
    }

    public Date getIssueDateTime() {
        return issueDateTime;
    }

    public String getInvoiceTypeCode() {
        return invoiceTypeCode;
    }

    public String getDocumentCurrencyCode() {
        return documentCurrencyCode;
    }

    public PartyLegalEntity getPartyLegalEntity() {
        return partyLegalEntity;
    }

    public Contact getContact() {
        return contact;
    }

    public Map<Object, Object> toMap() {
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat timeFormatter = new SimpleDateFormat("HH:mm:ss'Z'");
        return new HashMap<Object, Object>() {{
            put("ID", new ArrayList<Object>() {{ add(new HashMap<Object, Object>() {{ put("_", id); }}); }});
            put("IssueDate", new ArrayList<Object>() {{ add(new HashMap<Object, Object>() {{ put("_", dateFormatter.format(issueDateTime)); }}); }});
            put("IssueTime", new ArrayList<Object>() {{ add(new HashMap<Object, Object>() {{ put("_", timeFormatter.format(issueDateTime)); }}); }});
            put("InvoiceTypeCode", new ArrayList<Object>() {{ add(new HashMap<Object, Object>() {{ put("_", invoiceTypeCode); put("listVersionID", "1.0"); }}); }});
            put("DocumentCurrencyCode", new ArrayList<Object>() {{ add(new HashMap<Object, Object>() {{ put("_", documentCurrencyCode); }}); }});
            put("PartyLegalEntity", new ArrayList<Object>() {{ add(partyLegalEntity.toMap()); }});
            put("Contact", new ArrayList<Object>() {{ add(contact.toMap()); }});
        }};
    }
}
