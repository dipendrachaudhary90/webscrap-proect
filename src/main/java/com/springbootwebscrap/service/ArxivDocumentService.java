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

public class ArxivDocumentService {

    public static final String ARXIV_BASE_PATH = "https://arxiv.org";


    public List<ArxivDocument> fetch() throws IOException {
        Document doc = Jsoup.connect("https://arxiv.org/list/cs.SI/recent").userAgent("Google chrome").get();
        Elements divs = doc.select("dl");
        Elements pdfs = doc.getElementsByTag("span.list-identifier");

        List<ArxivDocument> listOfDocument = new ArrayList<>();

        divs.forEach(div -> {
            for (Element element : div.select("dd")) {

                ArxivDocument obj = new ArxivDocument();

                String title = element.select("div.list-title").text();
                obj.setTitle(title + "\n");

                String combinedAuthorName = element.select("div.list-authors").text().replace("Authors:", "");
                obj.setAuthors(getAuthors(combinedAuthorName));


                Element previousSibling = element.previousElementSibling();
               String pdf =previousSibling.select("a").get(2).attr("href");

                String pdfLink = ARXIV_BASE_PATH +pdf;
                obj.setPdf(pdfLink);


                Element previousSiblingAbstract = element.previousElementSibling();
                String pdfAbstract =previousSiblingAbstract.select("a").get(1).attr("href");
//                String abstractLink = ARXIV_BASE_PATH +pdfAbstract;
                Document con = null;
                try {
                    con = (Document) Jsoup.connect("https://arxiv.org/"+pdfAbstract).userAgent("Google chrome").get();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Elements absContent  = con.select("div#abs");
                String sbdAbstract =absContent.select("blockquote.abstract").text().replace("Abstract:", "");
              obj.setAbstractPdf(sbdAbstract);

                listOfDocument.add(obj);

            }
        });
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



