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

/*
* This class indexes the lucene document. and  define the location to be indexed
* IndexeWriter will use the StrandardAnalyzer to analyze the text, and will
* store the index in the FSDirectory pointing to the mentioned index path.
* */
public class DocumentIndexService {

    private static final String dirToBeIndexed = "C:\\Users\\lenovo\\Desktop\\lucene folder";
    File indexDir = new File(dirToBeIndexed);
    IndexWriter indexWriter;

    /*This method takes list of lucene document and indexed the document */
    public void index(List<Document> listOfDocument) throws IOException {
        for (Document document : listOfDocument) {
            indexWriter.addDocument(document);
        }
    }
/*
* This method cleans the indexing directory
*/
    public void cleansIndexDirectory() {
    }

    /*This method open the indexing directory
    * IndexeWriter will use the StrandardAnalyzer to analyze the text   */
    public void openIndexDirectory() throws IOException {
        Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_46);
        IndexWriterConfig config = new IndexWriterConfig(Version.LUCENE_46,
                analyzer);
        indexWriter = new IndexWriter(FSDirectory.open(indexDir),
                config);
    }

/*This method close the indexing directory (indexWriter  close because we don’t need it anymore) */
    public void closeIndexDirectory() throws IOException {
        indexWriter.close();
    }
}
