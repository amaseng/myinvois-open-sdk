package com.amaseng.myinvois.models;

public class AccountingParty {
    private IndustryClassificationCode industryClassificationCode;
    private PartyIdentification partyIdentification;
    private Address postalAddress;
    private PartyLegalEntity partyLegalEntity;
    private Contact contact;

    public AccountingParty(IndustryClassificationCode industryClassificationCode, PartyIdentification partyIdentification, Address postalAddress, PartyLegalEntity partyLegalEntity, Contact contact) {
        this.industryClassificationCode = industryClassificationCode;
        this.partyIdentification = partyIdentification;
        this.postalAddress = postalAddress;
        this.partyLegalEntity = partyLegalEntity;
        this.contact = contact;
    }

    public IndustryClassificationCode getIndustryClassificationCode() {
        return industryClassificationCode;
    }

    public PartyIdentification getPartyIdentification() {
        return partyIdentification;
    }

    public Address getPostalAddress() {
        return postalAddress;
    }

    public PartyLegalEntity getPartyLegalEntity() {
        return partyLegalEntity;
    }

    public Contact getContact() {
        return contact;
    }
}
