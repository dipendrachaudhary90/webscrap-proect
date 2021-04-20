package com.springbootwebscrap;

import com.springbootwebscrap.model.ArxivDocument;
import com.springbootwebscrap.service.ArxivDocumentService;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

public class ArxivDocumentTest {

    @Test
    public void fetchFromArxiv() throws IOException {
        ArxivDocumentService service = new ArxivDocumentService();
        List<ArxivDocument> arxivDocuments = service.fetch();
        System.out.println(arxivDocuments);
    }
}
