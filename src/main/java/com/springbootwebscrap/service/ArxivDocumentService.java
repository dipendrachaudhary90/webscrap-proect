package com.springbootwebscrap.service;


import com.springbootwebscrap.model.ArxivDocument;
import com.springbootwebscrap.model.Author;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public  class ArxivDocumentService {

    public  List<ArxivDocument> fetch() throws IOException {
        Document doc = Jsoup.connect("https://arxiv.org/list/cs.SI/recent").timeout(6000).get();
        Elements divs = doc.select("dl");

        List<ArxivDocument> listOfDocument = new ArrayList<>();

        for (Element div : divs.select("dd")) {

            ArxivDocument obj = new ArxivDocument();
            String title = div.select("div.list-title").text();
            obj.setTitle(title);
            listOfDocument.add(obj);

//            String author = div.select("div.list-authors").text();
//            obj.setAuthors(author);
//            Author author=new Author();
//            author.setName(div.select("div.list-authors").text());
//            listOfDocument.add(author);


        }
        return listOfDocument;
    }
}



