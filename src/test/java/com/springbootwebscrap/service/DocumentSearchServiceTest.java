package com.springbootwebscrap.service;

import com.springbootwebscrap.model.ArxivDocument;
import org.apache.lucene.search.highlight.InvalidTokenOffsetsException;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class DocumentSearchServiceTest {

    @Test
    public void searchLists() throws IOException, InvalidTokenOffsetsException {
        DocumentSearchService searches = new DocumentSearchService();
        List<ArxivDocument> arxivDocuments = searches.getAllSearchList("Learning");
        System.out.println(arxivDocuments);
    }
}
