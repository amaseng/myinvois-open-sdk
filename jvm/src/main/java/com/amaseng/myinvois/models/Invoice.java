/*
 * Copyright 2011-2024 AmaSeng Software Sdn. Bhd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.amaseng.myinvois.models;

import java.text.SimpleDateFormat;
import java.util.*;

public class Invoice {
    private String id;
    private Date issueDateTime;
    private String invoiceTypeCode;
    private String documentCurrencyCode;
    private Period invoicePeriod;
    private DocumentReference billingReference;
    private DocumentReference[] additionalDocumentReference;
    private AccountingParty accountingSupplierParty;
    private AccountingParty accountingCustomerParty;
    private Delivery delivery;
    private PaymentMeans paymentMeans;
    private PaymentTerms paymentTerms;
    private Payment prepaidPayment;
    private Charge[] allowanceCharge;
    private TaxTotal taxTotal;
    private LegalMonetaryTotal legalMonetaryTotal;
    private InvoiceLine[] invoiceLine;

    public Invoice(String id, Date issueDateTime, String invoiceTypeCode, String documentCurrencyCode, Period invoicePeriod,
                   DocumentReference billingReference, DocumentReference[] additionalDocumentReference, AccountingParty accountingSupplierParty,
                   AccountingParty accountingCustomerParty, Delivery delivery, PaymentMeans paymentMeans, PaymentTerms paymentTerms,
                   Payment prepaidPayment, Charge[] allowanceCharge, TaxTotal taxTotal, LegalMonetaryTotal legalMonetaryTotal, InvoiceLine[] invoiceLine) {
        this.id = id;
        this.issueDateTime = issueDateTime;
        this.invoiceTypeCode = invoiceTypeCode;
        this.documentCurrencyCode = documentCurrencyCode;
        this.invoicePeriod = invoicePeriod;
        this.billingReference = billingReference;
        this.additionalDocumentReference = additionalDocumentReference;
        this.accountingSupplierParty = accountingSupplierParty;
        this.accountingCustomerParty = accountingCustomerParty;
        this.delivery = delivery;
        this.paymentMeans = paymentMeans;
        this.paymentTerms = paymentTerms;
        this.prepaidPayment = prepaidPayment;
        this.allowanceCharge = allowanceCharge;
        this.taxTotal = taxTotal;
        this.legalMonetaryTotal = legalMonetaryTotal;
        this.invoiceLine = invoiceLine;
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

    public Period getInvoicePeriod() {
        return invoicePeriod;
    }

    public DocumentReference getBillingReference() {
        return billingReference;
    }

    public DocumentReference[] getAdditionalDocumentReference() {
        return additionalDocumentReference;
    }

    public AccountingParty getAccountingSupplierParty() {
        return accountingSupplierParty;
    }

    public AccountingParty getAccountingCustomerParty() {
        return accountingCustomerParty;
    }

    public Delivery getDelivery() {
        return delivery;
    }

    public PaymentMeans getPaymentMeans() {
        return paymentMeans;
    }

    public PaymentTerms getPaymentTerms() {
        return paymentTerms;
    }

    public Payment getPrepaidPayment() {
        return prepaidPayment;
    }

    public Charge[] getAllowanceCharge() {
        return allowanceCharge;
    }

    public TaxTotal getTaxTotal() {
        return taxTotal;
    }

    public LegalMonetaryTotal getLegalMonetaryTotal() {
        return legalMonetaryTotal;
    }

    public InvoiceLine[] getInvoiceLine() {
        return invoiceLine;
    }

    public Map<Object, Object> toMap() {
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat timeFormatter = new SimpleDateFormat("HH:mm:ss'Z'");
        return new LinkedHashMap<Object, Object>() {{
            put("_D", "urn:oasis:names:specification:ubl:schema:xsd:Invoice-2");
            put("_A", "urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2");
            put("_B", "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2");
            put("Invoice", new ArrayList<Object>() {{
                add(
                    new LinkedHashMap<Object, Object>() {{
                        put("ID", new ArrayList<Object>() {{ add(new LinkedHashMap<Object, Object>() {{ put("_", id); }}); }});
                        put("IssueDate", new ArrayList<Object>() {{ add(new LinkedHashMap<Object, Object>() {{ put("_", dateFormatter.format(issueDateTime)); }}); }});
                        put("IssueTime", new ArrayList<Object>() {{ add(new LinkedHashMap<Object, Object>() {{ put("_", timeFormatter.format(issueDateTime)); }}); }});
                        put("InvoiceTypeCode", new ArrayList<Object>() {{ add(new LinkedHashMap<Object, Object>() {{ put("_", invoiceTypeCode); put("listVersionID", "1.0"); }}); }});
                        put("DocumentCurrencyCode", new ArrayList<Object>() {{ add(new LinkedHashMap<Object, Object>() {{ put("_", documentCurrencyCode); }}); }});
                        put("InvoicePeriod", new ArrayList<Object>() {{ add(invoicePeriod.toMap()); }});
                        put("BillingReference", new ArrayList<Object>() {{ add(new LinkedHashMap<Object, Object>() {{ put("AdditionalDocumentReference", new ArrayList<Object>() {{ add(billingReference.toMap()); }}); }}); }});
                        put("AdditionalDocumentReference", Arrays.stream(additionalDocumentReference).map(DocumentReference::toMap).toArray());
                        put("AccountingSupplierParty", new ArrayList<Object>() {{ add(accountingSupplierParty.toMap()); }});
                        put("AccountingCustomerParty", new ArrayList<Object>() {{ add(accountingCustomerParty.toMap()); }});
                        put("Delivery", new ArrayList<Object>() {{ add(delivery.toMap()); }});
                        put("PaymentMeans", new ArrayList<Object>() {{ add(paymentMeans.toMap()); }});
                        put("PaymentTerms", new ArrayList<Object>() {{ add(paymentTerms.toMap()); }});
                        put("PrepaidPayment", new ArrayList<Object>() {{ add(prepaidPayment.toMap()); }});
                        if (allowanceCharge != null && allowanceCharge.length > 0)
                            put("AllowanceCharge", Arrays.stream(allowanceCharge).map(Charge::toMap).toArray());
                        put("TaxTotal", new ArrayList<Object>() {{ add(taxTotal.toMap()); }});
                        put("LegalMonetaryTotal", new ArrayList<Object>() {{ add(legalMonetaryTotal.toMap()); }});
                        put("InvoiceLine", Arrays.stream(invoiceLine).map(InvoiceLine::toMap).toArray());
                    }}
                );
            }});
        }};
    }
}
