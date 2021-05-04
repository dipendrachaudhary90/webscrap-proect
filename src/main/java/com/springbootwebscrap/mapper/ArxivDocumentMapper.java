package com.springbootwebscrap.mapper;

import com.springbootwebscrap.model.ArxivDocument;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexableField;

import java.util.ArrayList;
import java.util.List;

/*
* This class converts ArxivDocument to lucene document
*/
public class ArxivDocumentMapper {

    public static final String TITLE = "title";
    public static final String ABSTRACT = "abstract";
    public static final String PDFLINK = "pdflink";
    public static final String CONTENT="content";
/*
* This method map the ArxivDocument to lucene document
* takes a List of ArxivDocument and return a List of Lucene Document
*  */
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
            String titleAndAbstract=arxivDocument.getTitle()+arxivDocument.getAbstractContent();
            IndexableField content = new TextField(CONTENT,titleAndAbstract,Field.Store.YES);
            document.add(content);

            listOfDocument.add(document);
        }
        return listOfDocument;
    }
}
