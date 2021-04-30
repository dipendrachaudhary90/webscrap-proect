package com.springbootwebscrap.service;

import com.springbootwebscrap.mapper.ArxivDocumentMapper;
import com.springbootwebscrap.model.ArxivDocument;
import org.apache.lucene.document.Document;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class DocumentIndexServiceTest {

    @Test
    public void indexText() throws IOException {
        ArxivDocumentMapper mapperService = new ArxivDocumentMapper();
        List<ArxivDocument> documents = getArxivDocuments();
        List<Document> listOfDocument = mapperService.mapArxivToLuceneDocument(documents);
        DocumentIndexService indexService = new DocumentIndexService();
        indexService.cleansIndexDirectory();
        indexService.openIndexDirectory();
        indexService.index(listOfDocument);
        indexService.closeIndexDirectory();

    }

    private List<ArxivDocument> getArxivDocuments() throws IOException {
        ArxivDocumentService service = new ArxivDocumentService();
        List<ArxivDocument> arxivDocuments = service.fetch();
        return arxivDocuments;
    }
}
