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

import java.util.Map;
import java.util.LinkedHashMap;

public class Document {
    private String format;
    private String document;
    private String documentHash;
    private String codeNumber;

    public Document(String format, String document, String documentHash, String codeNumber) {
        this.format = format;
        this.document = document;
        this.documentHash = documentHash;
        this.codeNumber = codeNumber;
    }

    public String getFormat() {
        return format;
    }

    public String getDocument() {
        return document;
    }

    public String getDocumentHash() {
        return documentHash;
    }

    public String getCodeNumber() {
        return codeNumber;
    }

    public Map<Object, Object> toMap() {
        return new LinkedHashMap<Object, Object>() {{
            put("format", format);
            put("document", document);
            put("documentHash", documentHash);
            put("codeNumber", codeNumber);
        }};
    }
}
