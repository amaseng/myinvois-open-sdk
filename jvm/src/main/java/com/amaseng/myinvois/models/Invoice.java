package com.amaseng.myinvois.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Invoice {
    private PartyLegalEntity partyLegalEntity;
    private Contact contact;

    public Invoice(PartyLegalEntity partyLegalEntity, Contact contact) {
        this.partyLegalEntity = partyLegalEntity;
        this.contact = contact;
    }

    public PartyLegalEntity getPartyLegalEntity() {
        return partyLegalEntity;
    }

    public Contact getContact() {
        return contact;
    }

    public Map<Object, Object> toMap() {
        return new HashMap<Object, Object>() {{
            put("PartyLegalEntity", new ArrayList<Object>() {{ add(partyLegalEntity.toMap()); }});
            put("Contact", new ArrayList<Object>() {{ add(contact.toMap()); }});
        }};
    }
}
