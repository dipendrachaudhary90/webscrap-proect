package com.springbootwebscrap.service;

import com.springbootwebscrap.model.ArxivDocument;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

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



        return listOfSearched;
    }

    public void openIndexDirectory() throws IOException {

        Directory directory = FSDirectory.open(indexDir);
        indexReader = DirectoryReader.open(directory);



    }
}
