package com.springbootwebscrap.service;

import com.springbootwebscrap.mapper.ArxivDocumentMapper;
import com.springbootwebscrap.model.ArxivDocument;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.highlight.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.QueryBuilder;
import org.apache.lucene.util.Version;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class DocumentSearchService {

    public static final String indexDirectory = "C:\\Users\\lenovo\\Desktop\\lucene folder";
    private static final int maxHits = 100;
    File indexDir = new File(indexDirectory);
    IndexReader indexReader;

    public DocumentSearchService() throws IOException {
        openIndexDirectory();
    }

/* This method takes String query and return list of ArxivDocument
* obtain the ScoreDocs that satisfied the query from the TopDocs returned from the search method */
    public List<ArxivDocument> getAllSearchList(String queryStr) throws IOException, InvalidTokenOffsetsException {
        List<ArxivDocument> listOfSearched = new ArrayList<>();

        IndexSearcher searcher = new IndexSearcher(indexReader);
        Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_46);
        QueryBuilder builder = new QueryBuilder(analyzer);
        Query query = builder.createBooleanQuery(ArxivDocumentMapper.CONTENT, queryStr);

        //Uses HTML &lt;B&gt;&lt;/B&gt; tag to highlight the searched terms
        Formatter formatter = new SimpleHTMLFormatter();
        //It scores text fragments by the number of unique query terms found
        //Basically the matching score in layman terms
        QueryScorer scorer = new QueryScorer(query);
        Highlighter highLight=new Highlighter(formatter,scorer);
        TopDocs topDocs = searcher.search(query, maxHits);

        ScoreDoc[] hits = topDocs.scoreDocs;
        for (int i = 0; i < hits.length; i++) {
            int docId = hits[i].doc;
            Document d = searcher.doc(docId);
            TokenStream stream = TokenSources.getAnyTokenStream(indexReader, docId, ArxivDocumentMapper.TITLE, d, analyzer);
            String title = d.getField(ArxivDocumentMapper.TITLE).stringValue();
            //Get highlighted text fragments
            String[] frags = highLight.getBestFragments(stream, title, 100);
            if(frags.length >0){
                title=frags[0];
            }
            TokenStream streams = TokenSources.getAnyTokenStream(indexReader, docId, ArxivDocumentMapper.ABSTRACT, d, analyzer);
            String abstractContent = d.getField(ArxivDocumentMapper.ABSTRACT).stringValue();
            String[] fragsAbsContent = highLight.getBestFragments(streams, abstractContent, 100);
            if(fragsAbsContent.length >0){
                abstractContent=fragsAbsContent[0];
            }
            String pdfLink = d.getField(ArxivDocumentMapper.PDFLINK).stringValue();
            ArxivDocument arxivDocument = new ArxivDocument();
            arxivDocument.setTitle(title);

            arxivDocument.setAbstractContent(abstractContent);
            arxivDocument.setPdf(pdfLink);
            listOfSearched.add(arxivDocument);
        }
        return listOfSearched;
    }

/*This method open the indexing directory*/
    private void openIndexDirectory() throws IOException {
        Directory directory = FSDirectory.open(indexDir);
        indexReader = DirectoryReader.open(directory);
    }
}
