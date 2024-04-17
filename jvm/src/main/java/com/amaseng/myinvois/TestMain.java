package com.amaseng.myinvois;

import com.amaseng.myinvois.models.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

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
                new PartyLegalEntity("AmaSeng Software Sdn. Bhd."),
                new Contact("+60-123456789", "general.ams@supplier.com")
            );

        ObjectMapper mapper = new ObjectMapper();
        String jsonResult = mapper.writerWithDefaultPrettyPrinter()
                .writeValueAsString(invoice.toMap());
        System.out.println("##############Test: ");
        System.out.println(jsonResult);
    }

}
