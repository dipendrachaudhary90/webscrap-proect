package com.springbootwebscrap.service;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class DocumentIndexService {

    private static final String dirToBeIndexed = "C:\\Users\\lenovo\\Desktop\\lucene folder";
    File indexDir = new File(dirToBeIndexed);
    IndexWriter indexWriter;

    public void index(List<Document> listOfDocument) throws IOException {
        for (Document document : listOfDocument) {
            indexWriter.addDocument(document);

        }
    }

    public void cleansIndexDirectory() {

    }

    public void openIndexDirectory() throws IOException {
        Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_46);
        IndexWriterConfig config = new IndexWriterConfig(Version.LUCENE_46,
                analyzer);
        indexWriter = new IndexWriter(FSDirectory.open(indexDir),
                config);

    }

    public void closeIndexDirectory() throws IOException {
        indexWriter.close();

    }
}
