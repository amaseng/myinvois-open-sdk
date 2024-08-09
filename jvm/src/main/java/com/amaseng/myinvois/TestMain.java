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
package com.amaseng.myinvois;

import com.amaseng.myinvois.models.*;

import java.io.*;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;
import java.io.IOException;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.security.PrivateKey;
import java.security.cert.CertificateFactory;

import java.text.SimpleDateFormat;



public class TestMain {

    public static void main(String[] args) throws IOException {
        try{
        Calendar calendar = Calendar.getInstance();
        // Quick and dirty workaround for UTC, subtract 8 hours.
        calendar.add(Calendar.MINUTE, -480);
        Date eightHoursEarlier = calendar.getTime(); // convert to UTC.
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");
        System.out.println(eightHoursEarlier);
        String dateString = dateFormat.format(eightHoursEarlier);
        String clientID = System.getenv("MYINVOIS_CLIENT_ID");
        if (clientID == null)
            throw new RuntimeException("Environment variable MYINVOIS_CLIENT_ID not set.");
        String clientSecret = System.getenv("MYINVOIS_CLIENT_SECRET");
        if (clientSecret == null)
            throw new RuntimeException("Environment variable MYINVOIS_CLIENT_SECRET not set.");
        String tin = System.getenv("MYINVOIS_TIN");
        if (tin == null)
            throw new RuntimeException("Environment variable MYINVOIS_TIN not set.");
        String idType = System.getenv("MYINVOIS_ID_TYPE");
        if (idType == null)
            throw new RuntimeException("Environment variable MYINVOIS_ID_TYPE not set.");
        String idValue = System.getenv("MYINVOIS_ID_VALUE");
        if (idValue == null)
            throw new RuntimeException("Environment variable MYINVOIS_ID_VALUE not set.");
        Optional<String> jksFilePath = Optional.ofNullable(System.getenv("MYINVOIS_JKS_FILE_PATH"));
        Optional<String> jksStorePassword = Optional.ofNullable(System.getenv("MYINVOIS_JKS_STORE_PASSWORD"));
        Optional<String> jksAliasName = Optional.ofNullable(System.getenv("MYINVOIS_JKS_ALIAS_NAME"));
        Optional<String> jksAliasPassword = Optional.ofNullable(System.getenv("MYINVOIS_JKS_ALIAS_PASSWORD"));
        Optional<String> certificateFilePath = Optional.ofNullable(System.getenv("MYINVOIS_CERT_FILE_PATH"));

        // Load the private key from keystore file if provided.
        Optional<PrivateKey> privateKey = jksFilePath.map(path -> {
            FileInputStream fis = null;
            try {
                fis = new FileInputStream(path);
                KeyStore keystore = KeyStore.getInstance("JKS");
                keystore.load(fis, jksStorePassword.orElse("").toCharArray());
                fis.close();

                if (!jksAliasName.isPresent())
                    throw new RuntimeException("MYINVOIS_JKS_ALIAS_NAME not provided.");

                return (PrivateKey) keystore.getKey(jksAliasName.get(), jksAliasPassword.orElse("").toCharArray());
            } catch (Exception e) {
                throw new RuntimeException(e);
            } finally {
                if (fis != null) {
                    try {
                        fis.close();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });

        // Load the certificate if provided.
        Optional<Certificate> certificate =
                certificateFilePath.map(path -> {
                    FileInputStream fis = null;
                    try {
                        fis = new FileInputStream(path);
                        CertificateFactory certFactory = CertificateFactory.getInstance("X.509");
                        return certFactory.generateCertificate(fis);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    } finally {
                        if (fis != null) {
                            try {
                                fis.close();
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    }
                });


        Invoice invoice =
            new Invoice(
                privateKey,
                certificate,
                "INV7890343390684",
                eightHoursEarlier,
                "01",
                "MYR",
                new TaxExchangeRate(new BigDecimal("3.0"), "AUD" , "MYR"),
                new Period(dateFormat.parse(dateString), dateFormat.parse(dateString), "Monthly"),
                new DocumentReference("E12345678912", Optional.empty(), Optional.empty()),
                new DocumentReference[] {
                    new DocumentReference("E12345678912", Optional.of("CustomsImportForm"), Optional.empty()),
                    new DocumentReference("ASEAN-Australia-New Zealand FTA (AANZFTA)", Optional.of("FreeTradeAgreement"), Optional.of("Sample Description")),
                    new DocumentReference("E12345678912", Optional.of("K2"), Optional.empty()),
                    new DocumentReference("CIF", Optional.empty(), Optional.empty())
                },
                new AccountingParty(
                    new Party(
                        new IndustryClassificationCode[] {
                                new IndustryClassificationCode("01111", "Growing of maize")
                        },
                        new PartyIdentification[] {
                                new PartyIdentification(tin, "TIN"),
                                new PartyIdentification(idValue, idType)
                        },
                        new Address(
                                "Kuala Lumpur",
                                "50480",
                                "14",
                                new String[] {
                                        "Lot 66",
                                        "Bangunan Merdeka",
                                        "Persiaran Jaya"
                                },
                                new Country("MYS", "ISO3166-1", "6")
                        ),
                        new PartyLegalEntity("AmaSeng Software Sdn. Bhd."),
                        new Contact("+60-123456789", "general.ams@supplier.com")
                    ),
                    new AccountID[] {
                        new AccountID("CPT-CCN-W-211111-KL-000002", "CertEX")
                    }
                ),
                new AccountingParty(
                    new Party(
                        new IndustryClassificationCode[] {}, // TODO: Skip when empty
                        new PartyIdentification[] {
                                new PartyIdentification(tin, "TIN"),
                                new PartyIdentification(idValue, "BRN")
                        },
                        new Address(
                                "Kuala Lumpur",
                                "50480",
                                "14",
                                new String[] {
                                        "Lot 66",
                                        "Bangunan Merdeka",
                                        "Persiaran Jaya"
                                },
                                new Country("MYS", "ISO3166-1", "6")
                        ),
                        new PartyLegalEntity("AMS Setia Jaya Sdn. Bhd."),
                        new Contact("+60-123456789", "name@buyer.com")
                    ),
                    new AccountID[] {}
                ),
                new Delivery(
                    new Party(
                        new IndustryClassificationCode[] {}, // TODO: Skip when empty
                        new PartyIdentification[] {
                                new PartyIdentification(tin, "TIN"),
                                new PartyIdentification(idValue, "BRN")
                        },
                        new Address(
                                "Kuala Lumpur",
                                "50480",
                                "14",
                                new String[] {
                                        "Lot 66",
                                        "Bangunan Merdeka",
                                        "Persiaran Jaya"
                                },
                                new Country("MYS", "ISO3166-1", "6")
                        ),
                        new PartyLegalEntity("Greenz Sdn. Bhd."),
                        new Contact("+60-123456789", "name@buyer.com")
                    ),
                    new Shipment(
                        "1234",
                        new FreightAllowanceCharge(
                                true,
                                "Service charge",
                                new BigDecimal("100"),
                                "MYR"
                            )
                    )
                ),
                new PaymentMeans(
                    "01",
                    new FinancialAccount("1234567890123")
                ),
                new PaymentTerms("Payment method is cash"),
                new Payment(
                    "E12345678912",
                    new MonetaryAmount(new BigDecimal("1.00"), "MYR"),
                    dateFormat.parse(dateString)
                ),
                new Charge[] {
                    new Charge(
                        false,
                        "Sample Description",
                        Optional.empty(),
                        new MonetaryAmount(new BigDecimal("100"), "MYR")
                    ),
                    new Charge(
                        true,
                        "Service charge",
                        Optional.empty(),
                         new MonetaryAmount(new BigDecimal("100"), "MYR")
                    )
                },
                new TaxTotal(
                    new MonetaryAmount(new BigDecimal("87.63"), "MYR"),
                    new TaxSubTotal[] {
                        new TaxSubTotal(
                            new MonetaryAmount(new BigDecimal("87.63"), "MYR"),
                            new MonetaryAmount(new BigDecimal("87.63"), "MYR"),
                            new TaxCategory(
                                "E",
                                new BigDecimal("6.00"),
                                new TaxScheme(
                                    "OTH",
                                    "UN/ECE 5153",
                                    "6"
                                ), 
                                Optional.empty()
                            )
                        )
                    }
                ),
                new LegalMonetaryTotal(
                    new MonetaryAmount(new BigDecimal("1436.50"), "MYR"),
                    new MonetaryAmount(new BigDecimal("1436.50"), "MYR"),
                    new MonetaryAmount(new BigDecimal("1436.50"), "MYR"),
                    new MonetaryAmount(new BigDecimal("1436.50"), "MYR"),
                    new MonetaryAmount(new BigDecimal("1436.50"), "MYR"),
                    new MonetaryAmount(new BigDecimal("0.30"), "MYR"),
                    new MonetaryAmount(new BigDecimal("1436.50"), "MYR")
                ),
                new InvoiceLine[] {
                    new InvoiceLine(
                            "1234",
                            new QuantityUnit(new BigDecimal("1"), "C62"),
                            new MonetaryAmount(new BigDecimal("1436.50"), "MYR"),
                            new Charge[] {
                                new Charge(
                                    false,
                                    "Sample Description",
                                    Optional.of(new BigDecimal("0.15")),
                                    new MonetaryAmount(new BigDecimal("100"), "MYR")
                                ),
                                new Charge(
                                    true,
                                    "Sample Description",
                                    Optional.of(new BigDecimal("0.15")),
                                    new MonetaryAmount(new BigDecimal("100"), "MYR")
                                )
                            },
                            new TaxTotal(
                                new MonetaryAmount(new BigDecimal("1460.50"), "MYR"),
                                new TaxSubTotal[] {
                                    new TaxSubTotal(
                                        new MonetaryAmount(new BigDecimal("1460.50"), "MYR"),
                                        new MonetaryAmount(new BigDecimal("0.00"), "MYR"),
                                        new TaxCategory(
                                            "E",
                                            new BigDecimal("6.00"),
                                            new TaxScheme(
                                                "OTH",
                                                "UN/ECE 5153",
                                                "6"
                                            ),
                                            Optional.of("Exempt New Means of Transport")
                                        )
                                    )
                                }
                            ),
                            new Item(
                                new ItemClassificationCode[] {
                                    new ItemClassificationCode("002", "PTC"),
                                    new ItemClassificationCode("003", "CLASS")
                                },
                                "Laptop Peripherals",
                                "MYS"
                            ),
                            new MonetaryAmount(new BigDecimal("17"), "MYR"),
                            new MonetaryAmount(new BigDecimal("100"), "MYR")
                    )
                }
            );
            
       
            // Trying to connect to MyInvois
            Api api = new Api("https://preprod-api.myinvois.hasil.gov.my", clientID, clientSecret, tin, idType, idValue);

            // Login to MyInvois
            api.init();

            // Validate TIN
            boolean tinValid = api.validateTin();
            System.out.println("##############TIN Valid: " + tinValid);

            // Submit invoice
            String submissionResponse = api.submitInvoices(new Invoice[] { invoice });
            System.out.println("##############Submission response: " + submissionResponse);

        }catch (Exception e){
            System.out.println (e.getMessage());
        }
    }

}
