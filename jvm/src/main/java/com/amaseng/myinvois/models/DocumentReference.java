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
