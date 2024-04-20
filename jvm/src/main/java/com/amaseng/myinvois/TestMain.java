package com.amaseng.myinvois;

import com.amaseng.myinvois.models.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Optional;

public class TestMain {

    public static void main(String[] args) throws JsonProcessingException {
        Invoice invoice =
            new Invoice(
                "INV12345",
                new Date(),
                "01",
                "MYR",
                new Period(new Date(), new Date(), "Monthly"),
                new DocumentReference("E12345678912", Optional.empty(), Optional.empty()),
                new DocumentReference[] {
                    new DocumentReference("E12345678912", Optional.of("CustomsImportForm"), Optional.empty()),
                    new DocumentReference("ASEAN-Australia-New Zealand FTA (AANZFTA)", Optional.of("FreeTradeAgreement"), Optional.of("Sample Description")),
                    new DocumentReference("E12345678912", Optional.of("K2"), Optional.empty()),
                    new DocumentReference("CIF", Optional.empty(), Optional.empty())
                },
                new AccountingParty(
                    new IndustryClassificationCode[] {
                        new IndustryClassificationCode("01111", "Growing of maize")
                    },
                    new PartyIdentification[] {
                        new PartyIdentification("C2584563222", "TIN"),
                        new PartyIdentification("202001234567", "BRN")
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
                    new Contact("+60-123456789", "general.ams@supplier.com"),
                    new AccountID[] {
                        new AccountID("CPT-CCN-W-211111-KL-000002", "CertEX")
                    }
                ),
                new AccountingParty(
                        new IndustryClassificationCode[] {}, // TODO: Skip when empty
                        new PartyIdentification[] {
                                new PartyIdentification("C2584563200", "TIN"),
                                new PartyIdentification("201901234567", "BRN")
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
                        new Contact("+60-123456789", "name@buyer.com"),
                        new AccountID[] {}
                ),
                new Delivery(
                    new AccountingParty(
                        new IndustryClassificationCode[] {}, // TODO: Skip when empty
                        new PartyIdentification[] {
                                new PartyIdentification("C2584563200", "TIN"),
                                new PartyIdentification("201901234567", "BRN")
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
                        new Contact("+60-123456789", "name@buyer.com"),
                        new AccountID[] {}
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
                    new Date()
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
                                new TaxScheme(
                                    "OTH",
                                    "UN/ECE 5153",
                                    "6"
                                )
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
                )
            );

        ObjectMapper mapper = new ObjectMapper();
        String jsonResult = mapper.writerWithDefaultPrettyPrinter()
                .writeValueAsString(invoice.toMap());
        System.out.println("##############Test: ");
        System.out.println(jsonResult);
    }

}
