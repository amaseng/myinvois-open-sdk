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

import com.amaseng.myinvois.models.Document;
import com.amaseng.myinvois.models.DocumentSubmission;
import com.amaseng.myinvois.models.Invoice;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.util.Arrays;
import java.util.Base64;
import java.util.Map;

public class Api {
    private String baseUrl;
    private String clientId;
    private String clientSecret;
    private String tin;
    private String idType;
    private String idValue;

    private String accessToken;

    public Api(String baseUrl, String clientId, String clientSecret, String tin, String idType, String idValue) {
        this.baseUrl = baseUrl;
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.tin = tin;
        this.idType = idType;
        this.idValue = idValue;
    }

    public void init() throws IOException {

        String requestBody = "grant_type=client_credentials&client_id=" + clientId + "&client_secret=" + clientSecret + "&scope=InvoicingAPI";

        // Create URL object with the endpoint
        URL url = new URL(baseUrl + "/connect/token");

        // Open a connection
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        try {
            // Set the request method
            connection.setRequestMethod("POST");

            // Set the content type
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

            // Enable output for sending request body
            connection.setDoOutput(true);

            // Write request body to the connection
            try (DataOutputStream outputStream = new DataOutputStream(connection.getOutputStream())) {
                byte[] requestBodyBytes = requestBody.getBytes(StandardCharsets.UTF_8);
                outputStream.write(requestBodyBytes, 0, requestBodyBytes.length);
                outputStream.flush();
            }

            // Get the response code
            int responseCode = connection.getResponseCode();
            StringBuilder response = new StringBuilder();
            // Read the response
            InputStream inputStream = responseCode == 200 ? connection.getInputStream() : connection.getErrorStream();
            try (BufferedReader in = new BufferedReader(new InputStreamReader(inputStream))) {
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
            }

            if (responseCode == 200) {
                ObjectMapper objectMapper = new ObjectMapper();
                Map<String, String> map = objectMapper.readValue(response.toString(), new TypeReference<Map<String, String>>() {});
                accessToken = map.get("access_token");
            }
            else
                throw new RuntimeException("Failed to get session token. Response code: " + responseCode + ", message: " + connection.getResponseMessage() + ", content: " + response.toString());
        } finally {
            // Close the connection
            connection.disconnect();
        }
    }

    public boolean validateTin() throws IOException {
        // Create URL object with the endpoint
        URL url = new URL(baseUrl + "/api/v1.0/taxpayer/validate/" + tin + "?idType=" + idType + "&idValue=" + idValue);

        // Open a connection
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        try {
            // Set the request method
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/json");
            connection.setRequestProperty("Accept-Language", "en");
            connection.setRequestProperty("Content-type", "application/json");
            connection.setRequestProperty("Authorization", "Bearer " + accessToken);

            // Enable output for sending request body
            connection.setDoOutput(false);

            // Get the response code
            int responseCode = connection.getResponseCode();

            return responseCode == 200;
        } finally {
            // Close the connection
            connection.disconnect();
        }
    }

    private String base64(String value) {
        return Base64.getEncoder().encodeToString(value.getBytes(StandardCharsets.UTF_8));
    }

    private String sha256(String value) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hashBytes = digest.digest(value.getBytes(StandardCharsets.UTF_8));

        // Convert byte array to hexadecimal string
        StringBuilder hexString = new StringBuilder();
        for (byte hashByte : hashBytes) {
            String hex = Integer.toHexString(0xff & hashByte);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }

        return hexString.toString();
    }

    private Document convertInvoice(Invoice invoice) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writerWithDefaultPrettyPrinter()
                    .writeValueAsString(invoice.toMap());
            //System.out.println("####Invoice JSON: " + json);
            JsonNode jsonNode = mapper.readValue(json, JsonNode.class);
            String minifiedJson = jsonNode.toString();
            
            return new Document("JSON", base64(minifiedJson), sha256(minifiedJson), invoice.getId());
        } catch (JsonProcessingException | NoSuchAlgorithmException | KeyStoreException | InvalidKeyException | SignatureException | UnrecoverableKeyException e) {
            throw new RuntimeException(e);
        }
    }

    public String submitInvoices(Invoice[] invoices) throws IOException, JsonProcessingException {
        Document[] documents = Arrays.stream(invoices).map(this::convertInvoice).toArray(Document[]::new);
        DocumentSubmission submission = new DocumentSubmission(documents);
        Map<Object, Object> requestBodyMap = submission.toMap();

        ObjectMapper mapper = new ObjectMapper();
        String requestBody = mapper.writerWithDefaultPrettyPrinter()
                .writeValueAsString(requestBodyMap);

        // Create URL object with the endpoint
        URL url = new URL(baseUrl + "/api/v1.0/documentsubmissions/");

        // Open a connection
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        try {
            // Set the request method
            connection.setRequestMethod("POST");

            // Set the content type
            connection.setRequestProperty("Accept", "application/json");
            connection.setRequestProperty("Accept-Language", "en");
            connection.setRequestProperty("Content-type", "application/json");
            connection.setRequestProperty("Authorization", "Bearer " + accessToken);

            // Enable output for sending request body
            connection.setDoOutput(true);

            // Write request body to the connection
            try (DataOutputStream outputStream = new DataOutputStream(connection.getOutputStream())) {
                byte[] requestBodyBytes = requestBody.getBytes(StandardCharsets.UTF_8);
                outputStream.write(requestBodyBytes, 0, requestBodyBytes.length);
            }

            // Get the response code
            int responseCode = connection.getResponseCode();
            InputStream inputStream = responseCode == 202 ? connection.getInputStream() : connection.getErrorStream();
            // Read the response
            StringBuilder response = new StringBuilder();
            try (BufferedReader in = new BufferedReader(new InputStreamReader(inputStream))) {
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
            }

            if (responseCode == 202) {
                return response.toString();
            }
            else
                throw new RuntimeException("Failed to submit document. Response code: " + responseCode + ", message: " + connection.getResponseMessage() + ", content: " + response.toString());
        } finally {
            // Close the connection
            connection.disconnect();
        }
    }

}
