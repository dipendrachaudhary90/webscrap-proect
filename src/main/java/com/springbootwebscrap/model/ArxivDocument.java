package com.springbootwebscrap.model;

import java.util.List;
import java.util.Set;

public class ArxivDocument {

    private String title;

    //to stored orderly
    private List<Author> authors;


    public ArxivDocument() {

    }

    @Override
    public String toString() {
        return "ArxivDocument{" +
                "title='" + title + '\'' +
                ", authors=" + authors +
                '}'+"\n";
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }
}
