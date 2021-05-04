package com.springbootwebscrap.service;

import com.springbootwebscrap.model.ArxivDocument;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class DocumentSearchServiceTest {

    @Test
    public void searchLists() throws IOException {
        ArxivDocumentService service = new ArxivDocumentService();
        List<ArxivDocument> arxivDocuments = service.fetch();
        System.out.println(arxivDocuments);
    }
}
