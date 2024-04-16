package com.amaseng.myinvois;

import com.amaseng.myinvois.models.PartyLegalEntity;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TestMain {

    public static void main(String[] args) throws JsonProcessingException {
        PartyLegalEntity test = new PartyLegalEntity("AmaSeng Software Sdn. Bhd.");

        ObjectMapper mapper = new ObjectMapper();
        String jsonResult = mapper.writerWithDefaultPrettyPrinter()
                .writeValueAsString(test.toMap());
        System.out.println("##############Test: ");
        System.out.println(jsonResult);
    }

}
