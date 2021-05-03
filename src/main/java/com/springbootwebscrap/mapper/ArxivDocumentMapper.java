package com.springbootwebscrap.mapper;

import com.springbootwebscrap.model.ArxivDocument;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexableField;

import java.util.ArrayList;
import java.util.List;

public class ArxivDocumentMapper {

    public static final String TITLE = "title";
    public static final String ABSTRACT = "abstract";
    public static final String PDFLINK = "pdflink";
    public static final String CONTENT="TITLE +ABSTRACT";

    public List<Document> mapArxivToLuceneDocument(List<ArxivDocument> arxivDocuments) {
        List<Document> listOfDocument = new ArrayList<>();

        for (ArxivDocument arxivDocument : arxivDocuments) {
            Document document = new Document();
            IndexableField title = new TextField(TITLE, arxivDocument.getTitle(), Field.Store.YES);
            document.add(title);

            IndexableField abstractField = new TextField(ABSTRACT, arxivDocument.getAbstractContent(), Field.Store.YES);
            document.add(abstractField);

            IndexableField abstractLink = new TextField(PDFLINK, arxivDocument.getPdf(), Field.Store.YES);
            document.add(abstractLink);

            IndexableField content= new TextField(CONTENT,arxivDocument.getContent(),Field.Store.YES);
            document.add(content);

            listOfDocument.add(document);

        }

        return listOfDocument;
    }
}
