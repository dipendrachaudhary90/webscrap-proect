package com.springbootwebscrap.service;

import com.springbootwebscrap.model.ArxivDocument;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.QueryBuilder;
import org.apache.lucene.util.Version;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DocumentSearchService {

    public static final String indexDirectory = "C:\\Users\\lenovo\\Desktop\\lucene folder";
    private static final String queryString = "private static final String";
    private static final int maxHits = 100;
    File indexDir = new File(indexDirectory);
    IndexReader indexReader;


    public List<ArxivDocument> getAllSearchList(String queryStr) throws IOException {

        List<ArxivDocument> listOfSearched =new ArrayList<>();

        IndexSearcher searcher = new IndexSearcher(indexReader);
        Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_46);
        QueryBuilder builder = new QueryBuilder(analyzer);

        Query query = builder.createBooleanQuery("", queryStr);
        TopDocs topDocs =searcher.search(query, maxHits);

        ScoreDoc[] hits = topDocs.scoreDocs;
        


        return listOfSearched;
    }

    public void openIndexDirectory() throws IOException {

        Directory directory = FSDirectory.open(indexDir);
        indexReader = DirectoryReader.open(directory);



    }
}
