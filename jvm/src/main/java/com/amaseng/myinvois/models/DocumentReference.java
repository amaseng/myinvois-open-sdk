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
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

public class DocumentReference {
    private String id;
    private Optional<String> documentType;;
    private Optional<String> documentDescription;

    public DocumentReference(String id, Optional<String> documentType, Optional<String> documentDescription) {
        this.id = id;
        this.documentType = documentType;
        this.documentDescription = documentDescription;
    }

    public String getId() {
        return id;
    }

    public Optional<String> getDocumentType() {
        return documentType;
    }

    public Optional<String> getDocumentDescription() {
        return documentDescription;
    }

    public Map<Object, Object> toMap() {
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
        return new LinkedHashMap<Object, Object>() {{
            put("ID", new ArrayList<Object>() {{
                add(new LinkedHashMap<Object, Object>() {{
                    put("_", id);
                }});
            }});
            documentType.ifPresent(s -> put("DocumentType", new ArrayList<Object>() {{
                add(new LinkedHashMap<Object, Object>() {{
                    put("_", s);
                }});
            }}));
            documentDescription.ifPresent(s -> put("DocumentDescription", new ArrayList<Object>() {{
                add(new LinkedHashMap<Object, Object>() {{
                    put("_", s);
                }});
            }}));
        }};
    }
}
