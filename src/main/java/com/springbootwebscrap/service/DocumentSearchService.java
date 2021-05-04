package com.springbootwebscrap.service;

import com.springbootwebscrap.model.ArxivDocument;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.QueryBuilder;
import org.apache.lucene.util.Version;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class DocumentSearchService {

    public static final String indexDirectory = "C:\\Users\\lenovo\\Desktop\\lucene folder";
    private static final String queryString = "private static final String";
    private static final int maxHits = 100;
    File indexDir = new File(indexDirectory);



    public List<Document> getAllSearchList(List<ArxivDocument> ArxivDocuments) {

        return null;
    }

    public void searchIndexDirectory() throws IOException {

        Directory directory = FSDirectory.open(indexDir);

        IndexReader indexReader = DirectoryReader.open(directory);
        IndexSearcher searcher = new IndexSearcher(indexReader);

        Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_46);

    }
}
