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

/*This class fetch the data from websites(Web scraping)*/
public class ArxivDocumentService {

    public static final String ARXIV_BASE_PATH = "https://arxiv.org";
    public static final String ARXIV_BASE_PATH_URL = "https://arxiv.org/list/cs.SI/recent";

    /*This method return list of ArxivDocument
    * used jsoup library to fetch data  of title,authors */
    public List<ArxivDocument> fetch() throws IOException {
        Document doc = Jsoup.connect(ARXIV_BASE_PATH_URL).userAgent("Google chrome").get();
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
                String pdf = previousSibling.select("a").get(2).attr("href");

                String pdfLink = ARXIV_BASE_PATH + pdf;
                obj.setPdf(pdfLink);

                String abstractLink = previousSibling.select("a").get(1).attr("href");
                String abstractContent = getAbstractContent(abstractLink);
                obj.setAbstractContent(abstractContent);

                listOfDocument.add(obj);
            }
        });
        return listOfDocument;
    }

/*This method return list of author and also split authors */
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

/*This method fetch and return abstract of contents */
    private String getAbstractContent(String Abstract) {
        Document jsoupConnect = null;
        try {
            jsoupConnect = Jsoup.connect(ARXIV_BASE_PATH + Abstract).userAgent("Google chrome").get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Elements selectContent = jsoupConnect.select("div#abs");
        String abstractContent = selectContent.select("blockquote.abstract").text().replace("Abstract:", "");

        return abstractContent;
    }
}



