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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.security.cert.Certificate;
import java.text.SimpleDateFormat;
import java.util.*;
import java.security.*;
import java.security.MessageDigest;
import java.nio.charset.StandardCharsets;
import java.security.cert.X509Certificate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.ZoneOffset;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.Base64;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Invoice {
    private InvoiceSignature invoiceSignature;
    private SignedSignatureProperties signedSignatureProperties;
    private UBLExtensions ublExtensions;
    private Optional<PrivateKey> privateKey;
    private Optional<Certificate> certificate;
    private String id;
    private Date issueDateTime;
    private String invoiceTypeCode;
    private String documentCurrencyCode;
    private TaxExchangeRate taxExchangeRate;
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
    
    public Invoice(Optional<PrivateKey> privateKey, Optional<Certificate> certificate, String id, Date issueDateTime, String invoiceTypeCode, String documentCurrencyCode, TaxExchangeRate taxExchangeRate, Period invoicePeriod,
                   DocumentReference billingReference, DocumentReference[] additionalDocumentReference, AccountingParty accountingSupplierParty,
                   AccountingParty accountingCustomerParty, Delivery delivery, PaymentMeans paymentMeans, PaymentTerms paymentTerms,
                   Payment prepaidPayment, Charge[] allowanceCharge, TaxTotal taxTotal, LegalMonetaryTotal legalMonetaryTotal, InvoiceLine[] invoiceLine) {
        this.privateKey = privateKey;
        this.certificate = certificate;
        this.id = id;
        this.issueDateTime = issueDateTime;
        this.invoiceTypeCode = invoiceTypeCode;
        this.documentCurrencyCode = documentCurrencyCode;
        this.taxExchangeRate = taxExchangeRate;
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

    public UBLExtensions getUBLExtensions() {
        return ublExtensions;
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

    public TaxExchangeRate getTaxExchangeRate() {
        return taxExchangeRate;
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

    public static String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder(2 * hash.length);
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }

    private String extractField(String dn, String field) {
        String pattern = field + "=([^,]*)";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(dn);
        if (m.find()) {
            return m.group(1);
        }
        return null;
    }

    public Map<Object, Object> toMap() throws JsonProcessingException, NoSuchAlgorithmException, KeyStoreException, InvalidKeyException, SignatureException, UnrecoverableKeyException{
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat timeFormatter = new SimpleDateFormat("HH:mm:ss'Z'");
        ArrayList<Object> invoiceJson = new ArrayList<>();
        try {

            String apiVersion = (privateKey.isPresent() && certificate.isPresent()) ? "1.1" : "1.0";
            
            invoiceJson.add(new LinkedHashMap<Object, Object>() {{
                        put("ID", new ArrayList<Object>() {{ add(new LinkedHashMap<Object, Object>() {{ put("_", id); }}); }});
                        put("IssueDate", new ArrayList<Object>() {{ add(new LinkedHashMap<Object, Object>() {{ put("_", dateFormatter.format(issueDateTime)); }}); }});
                        put("IssueTime", new ArrayList<Object>() {{ add(new LinkedHashMap<Object, Object>() {{ put("_", timeFormatter.format(issueDateTime)); }}); }});
                        put("InvoiceTypeCode", new ArrayList<Object>() {{ add(new LinkedHashMap<Object, Object>() {{ put("_", invoiceTypeCode); put("listVersionID", apiVersion); }}); }});
                        put("DocumentCurrencyCode", new ArrayList<Object>() {{ add(new LinkedHashMap<Object, Object>() {{ put("_", documentCurrencyCode); }}); }});
                        put("TaxExchangeRate", new ArrayList<Object>() {{ add(taxExchangeRate.toMap()); }});
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
            

            if (apiVersion.equals("1.1")) {

                //Step 1 minify invoice, without UBLExtensions

                ObjectMapper mapper = new ObjectMapper();
                LinkedHashMap<Object, Object> documentJson = 
                    new LinkedHashMap<Object, Object>() {{
                        put("_D", "urn:oasis:names:specification:ubl:schema:xsd:Invoice-2");
                        put("_A", "urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2");
                        put("_B", "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2");
                        put("Invoice", invoiceJson);
                    }};
                String prettyJsonResult = mapper.writerWithDefaultPrettyPrinter()
                        .writeValueAsString(documentJson);

                JsonNode jsonNode = mapper.readValue(prettyJsonResult, JsonNode.class);
                String document = jsonNode.toString(); // minified.

                //Step 2 Calculate the document digest , //DigestValue
                MessageDigest digest = MessageDigest.getInstance("SHA-256");
                byte[] documentBytes = document.getBytes(StandardCharsets.UTF_8);
                byte[] hash = digest.digest(documentBytes);
                // Convert hash to Base64
                String docdigest = Base64.getEncoder().encodeToString(hash);

                // Step 3 Sign the document digest using the certificate  //Signature value
                Signature signature = Signature.getInstance("SHA256withRSA");
                signature.initSign(privateKey.get());
                signature.update(documentBytes);
                byte[] sign = signature.sign();
                String base64Signature = java.util.Base64.getEncoder().encodeToString(sign);

                //step 4 Calculate the certificate digest  // Cert digestValue

                // Compute the SHA-256 hash of the certificate
                Certificate cert = certificate.get();
                String certBase64 = Base64.getEncoder().encodeToString(cert.getEncoded());
                byte[] certDigestHash = digest.digest(cert.getEncoded());
                String certDigestBase64 = Base64.getEncoder().encodeToString(certDigestHash);

                //Step 5: Populate the signed properties section

                //Date format
                ZonedDateTime utcDateTime = ZonedDateTime.now(ZoneOffset.UTC);
                // Print the current date and time in UTC
                // Format the date and time
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");
                String formattedDateTime = utcDateTime.format(formatter);
                // create a string to assign the issuerName and serialNumber

                X509Certificate x509Cert = (X509Certificate) cert;
                String subjectName = ((X509Certificate) cert).getSubjectX500Principal().getName();
                String issuerDn = x509Cert.getIssuerX500Principal().getName();
                String issuerCn = extractField(issuerDn, "CN");
                String issuerO = extractField(issuerDn, "O");
                String issuerC = extractField(issuerDn, "C");
                String issuerName = "CN=" + issuerCn + ", O=" + issuerO + ", C=" + issuerC;

                String serialNumber = x509Cert.getSerialNumber().toString();

                String target = "signature";
                SignedProperties signedProperties = new SignedProperties(
                                        "id-xades-signed-props",
                                        new SignedSignatureProperties(
                                            formattedDateTime,
                                            new SigningCertificate(
                                                new InvoiceCert(
                                                    new CertDigest(new DigestMethod("",
                                                                                    "http://www.w3.org/2001/04/xmlenc#sha256"
                                                                                    ),
                                                                    certDigestBase64
                                                    ),
                                                    new IssuerSerial(issuerName, serialNumber)
                                                )
                                            )
                                        )
                                    );
                
                
                

                ArrayList<Object> signatureJson = new ArrayList<>();
                signatureJson.add(new LinkedHashMap<Object, Object>() {{
                       put("Target", target);
                       put("SignedProperties", new ArrayList<Object>() {{ add(signedProperties.toMap()); }});
                }});

                //Step 6: Calculate the signed properties section digest  //propsdigest

                String signatureJsonResult = mapper.writerWithDefaultPrettyPrinter()
                        .writeValueAsString(signatureJson.get(0));
                JsonNode signatureJsonNode = mapper.readValue(signatureJsonResult, JsonNode.class);
                String minifiedSignature = signatureJsonNode.toString(); // minified.
                // Compute SHA-256 hash
                byte[] signatureHash = digest.digest(minifiedSignature.getBytes(StandardCharsets.UTF_8));
                // Convert hash to Base64
                String propsdigest = Base64.getEncoder().encodeToString(signatureHash);
                
                //Step 7: Create the signed JSON document

                UBLExtensions ublExtensions=
                    new UBLExtensions(
                        "urn:oasis:names:specification:ubl:dsig:enveloped:xades",
                        new SignatureInformation(
                            "urn:oasis:names:specification:ubl:signature:1",
                            "urn:oasis:names:specification:ubl:signature:Invoice",
                            new UBLSignature(
                                "signature",
                                new QualifyingProperties(
                                    target,
                                    signedProperties
                                ),
                                new KeyInfo(
                                    new X509Data(
                                        certBase64,
                                        subjectName,
                                        new X509IssuerSerial(issuerName,serialNumber)
                                    )
                                ),    
                                base64Signature, 
                                new SignedInfo(
                                    new SignatureMethod(
                                        "",
                                        "http://www.w3.org/2001/04/xmldsig-more#rsa-sha256"
                                    ),  
                                    new Reference[] {
                                        new Reference(Optional.of("id-doc-signed-data"),
                                                        Optional.empty(),
                                                        "",
                                                        new DigestMethod("", 
                                                                        "http://www.w3.org/2001/04/xmlenc#sha256"
                                                                        ),
                                                        docdigest
                                                    ),
                                        new Reference(Optional.of("#id-xades-signed-props"),
                                                        Optional.of("http://uri.etsi.org/01903/v1.3.2#SignedProperties"),
                                                        "#id-xades-signed-props",
                                                        new DigestMethod("", 
                                                                        "http://www.w3.org/2001/04/xmlenc#sha256"
                                                                        ),                                                     
                                                        propsdigest
                                                    )
                                    }                                                              
                                )              
                            )
                        )
                    );
                InvoiceSignature invoiceSignature =
                    new InvoiceSignature(
                        "urn:oasis:names:specification:ubl:signature:Invoice",
                        "urn:oasis:names:specification:ubl:dsig:enveloped:xades"
                    );
                    
                if (ublExtensions != null) {
                    invoiceJson.forEach(item -> {
                        if (item instanceof LinkedHashMap) {
                            ((LinkedHashMap<Object, Object>) item).put("Signature", new ArrayList<Object>() {{
                                // Add your UBLExtensions content here
                                add(invoiceSignature.toMap()); 
                            }});
                            ((LinkedHashMap<Object, Object>) item).put("UBLExtensions", new ArrayList<Object>() {{
                                // Add your UBLExtensions content here
                                add(new LinkedHashMap<Object, Object>() {{
                                    put("UBLExtension", new ArrayList<Object>() {{ add(ublExtensions.toMap()); }});
                                }});
                            }});
                        }
                    });
                }
                else{
                    System.out.println("UBLExtensions in empty.");
                }
            
            };
            ObjectMapper mapper = new ObjectMapper();
            String jsonResult = mapper.writerWithDefaultPrettyPrinter()
                    .writeValueAsString(invoiceJson);
                

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return new LinkedHashMap<Object, Object>() {{
            put("_D", "urn:oasis:names:specification:ubl:schema:xsd:Invoice-2");
            put("_A", "urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2");
            put("_B", "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2");
            put("Invoice", invoiceJson);
        }};
    }
}
