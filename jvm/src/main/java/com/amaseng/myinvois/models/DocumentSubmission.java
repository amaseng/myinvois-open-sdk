package com.amaseng.myinvois.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.LinkedHashMap;

public class DocumentSubmission {
    private Document[] documents;

    public DocumentSubmission(Document[] documents) {
        this.documents = documents;
    }

    public Document[] getDocuments() {
        return documents;
    }

    public Map<Object, Object> toMap() {
        return new LinkedHashMap<Object, Object>() {{
            put("documents", Arrays.stream(documents).map(Document::toMap).toArray());
        }};
    }
}
