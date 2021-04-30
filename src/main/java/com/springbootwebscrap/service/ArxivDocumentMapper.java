package com.springbootwebscrap.service;

import com.springbootwebscrap.model.ArxivDocument;
import org.apache.lucene.document.Document;

import java.util.List;

public class ArxivDocumentMapper {
    public static final String CONTENTS = "contents";
    public static final String FILE_NAME = "filename";
    public static final String FILE_PATH = "filepath";
    public static final int MAX_SEARCH = 10;

    public List<Document> mapArxivToLuceneDocument(List<ArxivDocument> arxivDocument) {

        return null;
    }
}
