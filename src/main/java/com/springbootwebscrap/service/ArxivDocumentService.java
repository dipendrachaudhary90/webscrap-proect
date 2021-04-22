package com.springbootwebscrap.service;


import com.springbootwebscrap.model.ArxivDocument;
import com.springbootwebscrap.model.Author;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ArxivDocumentService {

    public List<ArxivDocument> fetch() throws IOException {
        Document doc = Jsoup.connect("https://arxiv.org/list/cs.SI/recent").userAgent("Google chrome").get();
        Elements divs = doc.select("dl");
        Element firstListElement = divs.select("a[href]").first();


        List<ArxivDocument> listOfDocument = new ArrayList<>();

        for (Element div : divs.select("dd")) {

            ArxivDocument obj = new ArxivDocument();
            String title = div.select("div.list-title").text();
            obj.setTitle(title);

            String combinedAuthorName = div.select("div.list-authors").text();
            obj.setAuthors(getAuthors(combinedAuthorName));
            listOfDocument.add(obj);

        }
            return listOfDocument;
    }

    private List<Author> getAuthors(String authorNames) {
        String[] splitAuthorNames = authorNames.split(",");
        List<Author> authors = new ArrayList<>();
        for (int i = 0; i < splitAuthorNames.length; i++) {
            Author author = new Author();
            author.setName(splitAuthorNames[i]);
            authors.add(author);
        }
        return authors;

    }
}



