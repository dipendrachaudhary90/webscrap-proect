package com.springbootwebscrap.service;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.StoredField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
public class LuceneIndexerService {

    private static final String indexDirectory = "";
    private static final String dirToBeIndexed = "C:\\Users\\lenovo\\Desktop\\lucene folder";
    public static void main(String[] args) throws Exception {
        File indexDir = new File(indexDirectory);
        File dataDir = new File(dirToBeIndexed);
        LuceneIndexerService indexer = new LuceneIndexerService();
        int numIndexed = indexer.index(indexDir, dataDir);
        System.out.println("Total files indexed " + numIndexed);
    }
    private int index(File indexDir, File dataDir) throws IOException {
        Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_46);
        IndexWriterConfig config = new IndexWriterConfig(Version.LUCENE_46,
                analyzer);
        IndexWriter indexWriter = new IndexWriter(FSDirectory.open(indexDir),
                config);
        File[] files = dataDir.listFiles();
        for (File f : files) {
            System.out.println("Indexing file " + f.getCanonicalPath());
            Document doc = new Document();
            doc.add(new TextField("content", new FileReader(f)));
            doc.add(new StoredField("fileName", f.getCanonicalPath()));
            indexWriter.addDocument(doc);
        }
        int numIndexed = indexWriter.maxDoc();
        indexWriter.close();
        return numIndexed;
    }
}
