package com.springbootwebscrap.mapper;

import com.springbootwebscrap.model.ArxivDocument;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ArxivDocumentMapperTest {

    @Test
    public void mapperTest() {
        List<ArxivDocument> documents = new ArrayList<>();
        ArxivDocument document = new ArxivDocument();
        document.setTitle("documentString");
        document.setAbstractContent("abstract");
        document.setPdf("pdfLink");

        documents.add(document);

        ArxivDocumentMapper mapperService = new ArxivDocumentMapper();
        mapperService.mapArxivToLuceneDocument(documents);
    }
}
