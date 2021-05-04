package com.springbootwebscrap.service;

import com.springbootwebscrap.model.ArxivDocument;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class DocumentSearchServiceTest {

    @Test
    public void searchLists() throws IOException {
        DocumentSearchService searches = new DocumentSearchService();
        searches.openIndexDirectory();
        List<ArxivDocument> arxivDocuments = searches.getAllSearchList("Recovering ");
        System.out.println(arxivDocuments);
    }
}
