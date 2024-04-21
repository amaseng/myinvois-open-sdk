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

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.Map;

public class Api {
    private String baseUrl;
    private String clientId;
    private String clientSecret;

    public Api(String baseUrl, String clientId, String clientSecret) {
        this.baseUrl = baseUrl;
        this.clientId = clientId;
        this.clientSecret = clientSecret;
    }

    public String getSessionToken() throws IOException {

        Map<Object, Object> requestBodyMap = new LinkedHashMap<>();
        requestBodyMap.put("grant_type", "client_credentials");
        requestBodyMap.put("clientId", clientId);
        requestBodyMap.put("clientSecret", clientSecret);

        ObjectMapper mapper = new ObjectMapper();
        String requestBody = mapper.writerWithDefaultPrettyPrinter()
                .writeValueAsString(requestBodyMap);

        // Create URL object with the endpoint
        URL url = new URL(baseUrl + "/connect/token");

        // Open a connection
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        try {
            // Set the request method
            connection.setRequestMethod("POST");

            // Set the content type
            connection.setRequestProperty("Content-Type", "application/json");

            // Enable output for sending request body
            connection.setDoOutput(true);

            // Write request body to the connection
            try (DataOutputStream outputStream = new DataOutputStream(connection.getOutputStream())) {
                byte[] requestBodyBytes = requestBody.getBytes(StandardCharsets.UTF_8);
                outputStream.write(requestBodyBytes, 0, requestBodyBytes.length);
            }

            // Get the response code
            int responseCode = connection.getResponseCode();

            if (responseCode == 200) {
                // Read the response
                StringBuilder response = new StringBuilder();
                try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                    String inputLine;
                    while ((inputLine = in.readLine()) != null) {
                        response.append(inputLine);
                    }
                }

                ObjectMapper objectMapper = new ObjectMapper();
                Map<String, String> map = objectMapper.readValue(response.toString(), new TypeReference<Map<String, String>>() {});

                return map.get("access_token");
            }
            else
                throw new RuntimeException("Failed to get session token. Response code: " + responseCode);
        } finally {
            // Close the connection
            connection.disconnect();
        }
    }

}
