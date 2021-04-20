package com.springbootwebscrap.service;


import com.springbootwebscrap.model.Documents;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DocumentService {

    public  static List<String> fetch() throws IOException {
        Document doc = Jsoup.connect("https://arxiv.org/list/cs.SI/recent").timeout(6000).get();
        Elements divs = doc.select("dl");

        Documents obj=new Documents();

        List<String> listOfDocument= new ArrayList<>();

        for (Element div : divs.select("dd")) {

            String title=div.select("div.list-title").text();
            obj.setTitle(title);
//            System.out.println(title);
//
//            obj.setAuthors(div.select("div.list-authors").text());
//            listOfDocument.add(obj.getAuthors());
            listOfDocument.add(obj.getTitle());
        }
        return listOfDocument;
    }
}


