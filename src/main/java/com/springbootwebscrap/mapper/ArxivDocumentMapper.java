package com.springbootwebscrap.mapper;

import com.springbootwebscrap.model.ArxivDocument;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexableField;

import java.util.ArrayList;
import java.util.List;

public class ArxivDocumentMapper {
    public static final String CONTENTS = "contents";
    public static final String FILE_NAME = "filename";
    public static final String FILE_PATH = "filepath";
    public static final int MAX_SEARCH = 10;
    public static final String TITLE = "title";
    public static final String ABSTRACT = "abstract";
    public static final String PDFLINK = "pdflink";

    public List<Document> mapArxivToLuceneDocument(List<ArxivDocument> arxivDocuments) {
        List<Document> listOfDocument = new ArrayList<>();

        for (ArxivDocument arxivDocument : arxivDocuments) {
            Document document = new Document();
            IndexableField title = new TextField(TITLE, arxivDocument.getTitle(), Field.Store.YES);
            document.add(title);

            IndexableField abstractField = new TextField(ABSTRACT, arxivDocument.getAbstractContent(), Field.Store.YES);
            document.add(abstractField);
            listOfDocument.add(document);

            IndexableField abstractLink = new TextField(PDFLINK, arxivDocument.getPdf(), Field.Store.YES);
            document.add(abstractLink);
            listOfDocument.add(document);


        }

        return listOfDocument;
    }
}
